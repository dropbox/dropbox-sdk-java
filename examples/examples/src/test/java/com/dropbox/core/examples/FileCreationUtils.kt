package com.dropbox.core.examples

import java.io.File
import java.io.FileOutputStream
import java.security.SecureRandom

object FileCreationUtils {
    fun bytesToMb(bytes: Long): Long {
        val kb = bytes / 1000
        return kb / 1000
    }

    fun bytesToKb(bytes: Long): Long {
        return bytes / 1000
    }

    fun kbToBytes(kb: Long): Long {
        return kb * 1000
    }

    fun mbToBytes(mb: Long): Long {
        val kb = mb * 1000
        return kb * 1000
    }

    fun createTempFileOfSize(tempFile: File, sizeInBytes: Int): File {
        // to fill with random bytes.
        FileOutputStream(tempFile).use { out ->
            val bytes = ByteArray(sizeInBytes)
            SecureRandom().nextBytes(bytes)
            out.write(bytes)
        }

        val fileSizeInBytes: Long = tempFile.length()

        println("Random Data Written To File: ${tempFile.absolutePath}")
        println("File Created of Size ${bytesToKb(fileSizeInBytes)} KB")
        println("File Created of Size ${bytesToMb(fileSizeInBytes)} MB")

        return tempFile
    }
}