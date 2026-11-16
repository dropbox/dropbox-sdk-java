package com.dropbox.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
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
public final class DropboxContentHasher extends MessageDigest implements Cloneable {
    public static final int BLOCK_SIZE = 4 * 1024 * 1024;

    private static final String SHA_256 = "SHA-256";
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    private MessageDigest overallDigest = newSha256Digest();
    private MessageDigest blockDigest = newSha256Digest();
    private int blockPosition;

    /**
     * Creates an incremental content hasher. Instances are not thread safe.
     *
     * <p>Use {@link #update(byte[])} to add data and {@link #digest()} to finish and reset.
     * This hasher also supports {@link java.security.DigestInputStream} and
     * {@link java.security.DigestOutputStream}.</p>
     */
    public DropboxContentHasher() {
        super("Dropbox-Content-Hash");
    }

    @Override
    protected int engineGetDigestLength() {
        return 32;
    }

    @Override
    protected void engineUpdate(byte input) {
        blockDigest.update(input);
        blockPosition++;
        finishBlockIfFull();
    }

    @Override
    protected void engineUpdate(byte[] input, int offset, int length) {
        while (length > 0) {
            int count = Math.min(length, BLOCK_SIZE - blockPosition);
            blockDigest.update(input, offset, count);
            blockPosition += count;
            offset += count;
            length -= count;
            finishBlockIfFull();
        }
    }

    private void finishBlockIfFull() {
        if (blockPosition == BLOCK_SIZE) {
            overallDigest.update(blockDigest.digest());
            blockPosition = 0;
        }
    }

    @Override
    protected byte[] engineDigest() {
        if (blockPosition > 0) {
            overallDigest.update(blockDigest.digest());
        }
        byte[] result = overallDigest.digest();
        engineReset();
        return result;
    }

    @Override
    protected int engineDigest(byte[] output, int offset, int length) throws DigestException {
        // Validate before finalizing so a rejected output buffer does not consume the state.
        if (length < 32 || offset < 0 || offset > output.length - 32) {
            throw new DigestException("A 32-byte output buffer is required");
        }
        byte[] result = engineDigest();
        System.arraycopy(result, 0, output, offset, result.length);
        return result.length;
    }

    @Override
    protected void engineReset() {
        overallDigest.reset();
        blockDigest.reset();
        blockPosition = 0;
    }

    /**
     * Returns an independent copy of this hasher, including any partial block.
     *
     * @return a copy of this hasher
     * @throws CloneNotSupportedException if the SHA-256 provider does not support cloning
     */
    @Override
    public DropboxContentHasher clone() throws CloneNotSupportedException {
        DropboxContentHasher copy = (DropboxContentHasher) super.clone();
        copy.overallDigest = (MessageDigest) overallDigest.clone();
        copy.blockDigest = (MessageDigest) blockDigest.clone();
        return copy;
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

        DropboxContentHasher hasher = new DropboxContentHasher();
        byte[] buffer = new byte[IOUtil.DEFAULT_COPY_BUFFER_SIZE];
        while (true) {
            int count = input.read(buffer);
            if (count < 0) {
                break;
            }
            if (count == 0) {
                int value = input.read();
                if (value < 0) {
                    break;
                }
                hasher.update((byte) value);
            } else {
                hasher.update(buffer, 0, count);
            }
        }
        return hasher.digest();
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

        return new DropboxContentHasher().digest(input);
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
