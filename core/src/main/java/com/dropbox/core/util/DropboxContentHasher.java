package com.dropbox.core.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Utility for calculating Dropbox content hashes.
 *
 * <p>The Dropbox content hash is calculated by splitting the input into
 * 4 MiB blocks, calculating the SHA-256 hash of each block, concatenating
 * those block hashes, and calculating the SHA-256 hash of the resulting
 * sequence.</p>
 */
public final class DropboxContentHasher {
    public static final int BLOCK_SIZE = 4 * 1024 * 1024;

    private static final String SHA_256 = "SHA-256";
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    private DropboxContentHasher() {
    }

    /**
     * Calculates the Dropbox content hash for an input stream.
     *
     * <p>This method does not close the supplied stream.</p>
     *
     * @param input stream to read
     * @return raw 32-byte Dropbox content hash
     * @throws IOException if the stream cannot be read
     */
    public static byte[] hash(InputStream input) throws IOException {
        Objects.requireNonNull(input, "input");

        MessageDigest overallDigest = newSha256Digest();
        MessageDigest blockDigest = newSha256Digest();
        byte[] buffer = new byte[BLOCK_SIZE];

        while (true) {
            int blockLength = readBlock(input, buffer);
            if (blockLength == 0) {
                break;
            }

            blockDigest.reset();
            blockDigest.update(buffer, 0, blockLength);
            overallDigest.update(blockDigest.digest());
        }

        return overallDigest.digest();
    }

    /**
     * Calculates the lowercase hexadecimal Dropbox content hash for an input stream.
     *
     * <p>This method does not close the supplied stream.</p>
     *
     * @param input stream to read
     * @return lowercase hexadecimal Dropbox content hash
     * @throws IOException if the stream cannot be read
     */
    public static String hashHex(InputStream input) throws IOException {
        return toHex(hash(input));
    }

    /**
     * Calculates the Dropbox content hash for a byte array.
     *
     * @param input bytes to hash
     * @return raw 32-byte Dropbox content hash
     */
    public static byte[] hash(byte[] input) {
        Objects.requireNonNull(input, "input");

        try {
            return hash(new ByteArrayInputStream(input));
        } catch (IOException ex) {
            // ByteArrayInputStream does not throw IOException while reading.
            throw new AssertionError("Unexpected ByteArrayInputStream failure", ex);
        }
    }

    /**
     * Calculates the lowercase hexadecimal Dropbox content hash for a byte array.
     *
     * @param input bytes to hash
     * @return lowercase hexadecimal Dropbox content hash
     */
    public static String hashHex(byte[] input) {
        return toHex(hash(input));
    }

    private static int readBlock(InputStream input, byte[] buffer) throws IOException {
        int offset = 0;

        while (offset < buffer.length) {
            int bytesRead = input.read(buffer, offset, buffer.length - offset);

            if (bytesRead < 0) {
                break;
            }

            if (bytesRead == 0) {
                int value = input.read();
                if (value < 0) {
                    break;
                }

                buffer[offset++] = (byte) value;
            } else {
                offset += bytesRead;
            }
        }

        return offset;
    }

    private static MessageDigest newSha256Digest() {
        try {
            return MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("SHA-256 is not available", ex);
        }
    }

    private static String toHex(byte[] bytes) {
        char[] result = new char[bytes.length * 2];

        for (int i = 0; i < bytes.length; i++) {
            int value = bytes[i] & 0xff;
            result[i * 2] = HEX_DIGITS[value >>> 4];
            result[i * 2 + 1] = HEX_DIGITS[value & 0x0f];
        }

        return new String(result);
    }
}
