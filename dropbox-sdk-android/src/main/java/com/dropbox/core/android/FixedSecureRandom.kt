package com.dropbox.core.android

import android.os.Build
import android.os.Process
import android.util.Log
import com.dropbox.core.android.FixedSecureRandom
import com.dropbox.core.android.FixedSecureRandom.LinuxPrngSecureRandomSpi
import java.io.*
import java.security.Provider
import java.security.SecureRandom
import java.security.SecureRandomSpi

/*
 * This software is provided 'as-is', without any express or implied
 * warranty.  In no event will Google be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, as long as the origin is not misrepresented.
 */ /**
 * Older versions of Android have a SecureRandom that isn't actually secure.  This
 * class implements a workaround.  Call the static [.get] method to get a
 * secure SecureRandom instance.
 *
 *
 *
 * This workaround code was recommended by Google in a
 * [euphemistically-titled blog post](http://android-developers.blogspot.com.es/2013/08/some-securerandom-thoughts.html).
 * Our code is slightly different because we're a library so we don't want to change
 * global JVM settings.
 *
 */
public object FixedSecureRandom : SecureRandom() {
    private const val serialVersionUID = 0L
    public fun get(): SecureRandom {
        return if (Build.VERSION.SDK_INT > VERSION_CODE_JELLY_BEAN_MR2) {
            // This version of Android doesn't have the issue.
            SecureRandom()
        } else {
            FixedSecureRandom
        }
    }

    private const val VERSION_CODE_JELLY_BEAN_MR2 = 18
    private val BUILD_FINGERPRINT_AND_DEVICE_SERIAL = buildFingerprintAndDeviceSerial

    /**
     * Generates a device- and invocation-specific seed to be mixed into the
     * Linux PRNG.
     */
    private fun generateSeed(): ByteArray {
        return try {
            val seedBuffer = ByteArrayOutputStream()
            val seedBufferOut = DataOutputStream(seedBuffer)
            seedBufferOut.writeLong(System.currentTimeMillis())
            seedBufferOut.writeLong(System.nanoTime())
            seedBufferOut.writeInt(Process.myPid())
            seedBufferOut.writeInt(Process.myUid())
            seedBufferOut.write(BUILD_FINGERPRINT_AND_DEVICE_SERIAL)
            seedBufferOut.close()
            seedBuffer.toByteArray()
        } catch (e: IOException) {
            throw SecurityException("Failed to generate seed", e)
        }
    }// We're using the Reflection API because Build.SERIAL is only available
    // since API Level 9 (Gingerbread, Android 2.3).
    /**
     * Gets the hardware serial number of this device.
     *
     * @return serial number or `null` if not available.
     */
    private val deviceSerialNumber: String?
        private get() =// We're using the Reflection API because Build.SERIAL is only available
            // since API Level 9 (Gingerbread, Android 2.3).
            try {
                Build::class.java.getField("SERIAL")[null] as String
            } catch (ignored: Exception) {
                null
            }
    private val buildFingerprintAndDeviceSerial: ByteArray
        private get() {
            val result = StringBuilder()
            val fingerprint = Build.FINGERPRINT
            if (fingerprint != null) {
                result.append(fingerprint)
            }
            val serial = deviceSerialNumber
            if (serial != null) {
                result.append(serial)
            }
            return try {
                result.toString().toByteArray(charset("UTF-8"))
            } catch (e: UnsupportedEncodingException) {
                throw RuntimeException("UTF-8 encoding not supported")
            }
        }

    /**
     * `Provider` of `SecureRandom` engines which pass through
     * all requests to the Linux PRNG.
     */
    private class LinuxPrngSecureRandomProvider : Provider(
        "LinuxPRNG",
        1.0, "A Linux-specific random number provider that uses"
                + " /dev/urandom"
    ) {
        init {
            // Although /dev/urandom is not a SHA-1 PRNG, some apps
            // explicitly request a SHA1PRNG SecureRandom and we thus need to
            // prevent them from getting the default implementation whose output
            // may have low entropy.
            put("SecureRandom.SHA1PRNG", LinuxPrngSecureRandomSpi::class.java.name)
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software")
        }

        companion object {
            private const val serialVersionUID = 0L
        }
    }

    /**
     * [SecureRandomSpi] which passes all requests to the Linux PRNG
     * (`/dev/urandom`).
     */
    public class LinuxPrngSecureRandomSpi : SecureRandomSpi() {
        /**
         * Whether this engine instance has been seeded. This is needed because
         * each instance needs to seed itself if the client does not explicitly
         * seed it.
         */
        private var mSeeded = false
        override fun engineSetSeed(bytes: ByteArray) {
            try {
                var out: OutputStream?
                synchronized(sLock) { out = urandomOutputStream }
                out!!.write(bytes)
                out!!.flush()
            } catch (e: IOException) {
                // On a small fraction of devices /dev/urandom is not writable.
                // Log and ignore.
                Log.w(
                    LinuxPrngSecureRandomSpi::class.java.simpleName,
                    "Failed to mix seed into " + URANDOM_FILE
                )
            } finally {
                mSeeded = true
            }
        }

        override fun engineNextBytes(bytes: ByteArray) {
            if (!mSeeded) {
                // Mix in the device- and invocation-specific seed.
                engineSetSeed(generateSeed())
            }
            try {
                var `in`: DataInputStream?
                synchronized(sLock) { `in` = urandomInputStream }
                synchronized(`in`!!) { `in`!!.readFully(bytes) }
            } catch (e: IOException) {
                throw SecurityException(
                    "Failed to read from " + URANDOM_FILE, e
                )
            }
        }

        override fun engineGenerateSeed(size: Int): ByteArray {
            val seed = ByteArray(size)
            engineNextBytes(seed)
            return seed
        }

        // NOTE: Consider inserting a BufferedInputStream between
        // DataInputStream and FileInputStream if you need higher
        // PRNG output performance and can live with future PRNG
        // output being pulled into this process prematurely.
        private val urandomInputStream: DataInputStream?
            private get() {
                synchronized(sLock) {
                    if (sUrandomIn == null) {
                        // NOTE: Consider inserting a BufferedInputStream between
                        // DataInputStream and FileInputStream if you need higher
                        // PRNG output performance and can live with future PRNG
                        // output being pulled into this process prematurely.
                        try {
                            sUrandomIn = DataInputStream(
                                FileInputStream(URANDOM_FILE)
                            )
                        } catch (e: IOException) {
                            throw SecurityException(
                                "Failed to open "
                                        + URANDOM_FILE + " for reading", e
                            )
                        }
                    }
                    return sUrandomIn
                }
            }

        @get:Throws(IOException::class)
        private val urandomOutputStream: OutputStream?
            private get() {
                synchronized(sLock) {
                    if (sUrandomOut == null) {
                        sUrandomOut = FileOutputStream(URANDOM_FILE)
                    }
                    return sUrandomOut
                }
            }

        public companion object {
            private const val serialVersionUID = 0L

            /*
         * IMPLEMENTATION NOTE: Requests to generate bytes and to mix in a seed
         * are passed through to the Linux PRNG (/dev/urandom). Instances of
         * this class seed themselves by mixing in the current time, PID, UID,
         * build fingerprint, and hardware serial number (where available) into
         * Linux PRNG.
         *
         * Concurrency: Read requests to the underlying Linux PRNG are
         * serialized (on sLock) to ensure that multiple threads do not get
         * duplicated PRNG output.
         */
            private val URANDOM_FILE = File("/dev/urandom")
            private val sLock = Any()

            /**
             * Input stream for reading from Linux PRNG or `null` if not yet
             * opened.
             *
             * @GuardedBy("sLock")
             */
            private var sUrandomIn: DataInputStream? = null

            /**
             * Output stream for writing to Linux PRNG or `null` if not yet
             * opened.
             *
             * @GuardedBy("sLock")
             */
            private var sUrandomOut: OutputStream? = null
        }
    }
}