package com.dropbox.core.util;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.io.ByteArrayOutputStream;
import org.testng.annotations.DataProvider;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class DropboxContentHasherTest {

    @Test
    public void testEmpty() {
        assertEquals(
                DropboxContentHasher.hashHex(new byte[0]),
                "e3b0c44298fc1c149afbf4c8996fb924"
                        + "27ae41e4649b934ca495991b7852b855");
    }

    @Test
    public void testByteArrayAndStreamMatch() throws Exception {
        byte[] data = randomBytes(12345);

        assertEquals(
                DropboxContentHasher.hashHex(data),
                DropboxContentHasher.hashHex(new ByteArrayInputStream(data))
        );
    }

    @Test
    public void testExactlyOneBlock() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE);

        assertEquals(
                DropboxContentHasher.hashHex(data),
                DropboxContentHasher.hashHex(new ByteArrayInputStream(data))
        );
    }

    @Test
    public void testBlockPlusOneByte() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE + 1);

        assertEquals(
                DropboxContentHasher.hashHex(data),
                DropboxContentHasher.hashHex(new ByteArrayInputStream(data))
        );
    }

    @Test
    public void testMultipleBlocks() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE * 3 + 123);

        assertEquals(
                DropboxContentHasher.hashHex(data),
                DropboxContentHasher.hashHex(new ByteArrayInputStream(data))
        );
    }

    @Test
    public void testPartialReads() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE + 123);

        InputStream partial = new FilterInputStream(
                new ByteArrayInputStream(data)
        ) {
            @Override
            public int read(byte[] b, int off, int len) throws IOException {
                return super.read(b, off, Math.min(len, 37));
            }
        };

        assertEquals(
                DropboxContentHasher.hashHex(data),
                DropboxContentHasher.hashHex(partial)
        );
    }

    @Test
    public void testDoesNotCloseStream() throws Exception {
        CloseTrackingInputStream in =
                new CloseTrackingInputStream(
                        new ByteArrayInputStream(randomBytes(1024)));

        DropboxContentHasher.hashHex(in);

        assertFalse(in.closed);
    }

    @DataProvider(name = "vectors")
    public Object[][] vectors() {
        int b = DropboxContentHasher.BLOCK_SIZE;
        return new Object[][] {
            {0, "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"},
            {1, "1406e05881e299367766d313e26c05564ec91bf721d31726bd6e46e60689539a"},
            {b - 1, "e1d05b9adf4293b7fec11b099ce74116fc06dfa733a9833be9166ab4c769da43"},
            {b, "b9654428408015906b44a00935b70af33830aa344b780b0eabd535a133150d04"},
            {b + 1, "4a6cc0a344febaa07772e7c974834b2fb1d24594d4ba15f27c97a54699709f44"},
            {b * 3 + 123, "b4c5d97fec5b78c2c45907bc6fed003057fc99977501eeac971e84f836af442c"},
        };
    }

    @Test(dataProvider = "vectors")
    public void testIndependentVectors(int size, String expected) throws Exception {
        // Values generated independently with Python hashlib, using byte[i] = i % 251.
        byte[] data = new byte[size];
        for (int i = 0; i < size; i++) data[i] = (byte) (i % 251);
        assertEquals(DropboxContentHasher.hashHex(data), expected);
        assertEquals(DropboxContentHasher.hashHex(new ByteArrayInputStream(data)), expected);
        MessageDigest hasher = new DropboxContentHasher();
        for (int offset = 0; offset < size; offset += 7919) {
            hasher.update(data, offset, Math.min(7919, size - offset));
        }
        assertEquals(java.util.HexFormat.of().formatHex(hasher.digest()), expected);
    }

    @Test
    public void testByteBuffersPreserveLimitAndConsumeRemainingBytes() {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE + 129);
        for (ByteBuffer buffer : new ByteBuffer[]{ByteBuffer.wrap(data),
                ByteBuffer.allocateDirect(data.length).put(data).flip(),
                ByteBuffer.wrap(data).asReadOnlyBuffer()}) {
            buffer.position(7);
            buffer.limit(data.length - 11);
            int limit = buffer.limit();
            byte[] expected = java.util.Arrays.copyOfRange(data, 7, limit);
            DropboxContentHasher hasher = new DropboxContentHasher();
            hasher.update(buffer);
            assertEquals(buffer.limit(), limit);
            assertEquals(buffer.position(), limit);
            assertEquals(hasher.digest(), DropboxContentHasher.hash(expected));
        }
    }

    @Test
    public void testCloneResetAndRepeatedDigest() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE + 123);
        DropboxContentHasher hasher = new DropboxContentHasher();
        hasher.update(data, 0, data.length - 1);
        DropboxContentHasher clone = hasher.clone();
        hasher.update(data[data.length - 1]);
        assertEquals(hasher.digest(), DropboxContentHasher.hash(data));
        clone.update((byte) (data[data.length - 1] ^ 1));
        data[data.length - 1] ^= 1;
        assertEquals(clone.digest(), DropboxContentHasher.hash(data));
        assertEquals(hasher.digest(), DropboxContentHasher.hash(new byte[0]));
        hasher.update(data);
        hasher.reset();
        assertEquals(hasher.digest(data), DropboxContentHasher.hash(data));
        assertEquals(hasher.getDigestLength(), 32);
    }

    @Test
    public void testDigestOutputBufferFailurePreservesState() throws Exception {
        DropboxContentHasher hasher = new DropboxContentHasher();
        byte[] data = randomBytes(100);
        hasher.update(data);
        org.testng.Assert.expectThrows(DigestException.class, () -> hasher.digest(new byte[31], 0, 31));
        byte[] output = new byte[40];
        assertEquals(hasher.digest(output, 4, 32), 32);
        assertEquals(java.util.Arrays.copyOfRange(output, 4, 36), DropboxContentHasher.hash(data));
        assertEquals(hasher.digest(), DropboxContentHasher.hash(new byte[0]));
    }

    @Test
    public void testDigestStreamWrappers() throws Exception {
        byte[] data = randomBytes(DropboxContentHasher.BLOCK_SIZE + 1);
        DropboxContentHasher readHasher = new DropboxContentHasher();
        try (InputStream input = new DigestInputStream(new ByteArrayInputStream(data), readHasher)) {
            IOUtil.copyStreamToStream(input, IOUtil.BlackHoleOutputStream);
        }
        assertEquals(readHasher.digest(), DropboxContentHasher.hash(data));
        DropboxContentHasher writeHasher = new DropboxContentHasher();
        ByteArrayOutputStream body = new ByteArrayOutputStream();
        try (DigestOutputStream output = new DigestOutputStream(body, writeHasher)) {
            output.write(data);
        }
        assertEquals(writeHasher.digest(), DropboxContentHasher.hash(data));
        assertEquals(body.toByteArray(), data);
    }

    @Test
    public void testZeroByteReadsMakeProgress() throws Exception {
        byte[] data = randomBytes(123);
        InputStream input = new ByteArrayInputStream(data) {
            @Override public synchronized int read(byte[] b, int off, int len) { return 0; }
        };
        assertEquals(DropboxContentHasher.hash(input), DropboxContentHasher.hash(data));
    }

    @Test
    public void testInvalidUpdateRangePreservesState() {
        DropboxContentHasher hasher = new DropboxContentHasher();
        byte[] data = randomBytes(100);
        hasher.update(data);
        org.testng.Assert.expectThrows(IndexOutOfBoundsException.class, () -> hasher.update(data, 0, -1));
        org.testng.Assert.expectThrows(IndexOutOfBoundsException.class, () -> hasher.update(data, -1, 0));
        assertEquals(hasher.digest(), DropboxContentHasher.hash(data));
    }

    @Test
    public void testExactBlockBoundaryCloneAndReset() throws Exception {
        byte[] block = randomBytes(DropboxContentHasher.BLOCK_SIZE);
        DropboxContentHasher hasher = new DropboxContentHasher();
        for (byte value : block) hasher.update(value);
        DropboxContentHasher clone = hasher.clone();
        assertEquals(hasher.digest(), DropboxContentHasher.hash(block));
        assertEquals(hasher.digest(), DropboxContentHasher.hash(new byte[0]));
        clone.update(block);
        MessageDigest reference = MessageDigest.getInstance("SHA-256");
        reference.update(MessageDigest.getInstance("SHA-256").digest(block));
        reference.update(MessageDigest.getInstance("SHA-256").digest(block));
        assertEquals(clone.digest(), reference.digest());
        clone.update(block);
        clone.reset();
        assertEquals(clone.digest(), DropboxContentHasher.hash(new byte[0]));
    }

    private static byte[] randomBytes(int size) {
        byte[] data = new byte[size];
        new Random(12345).nextBytes(data);
        return data;
    }

    private static final class CloseTrackingInputStream
            extends FilterInputStream {

        boolean closed;

        CloseTrackingInputStream(InputStream in) {
            super(in);
        }

        @Override
        public void close() throws IOException {
            closed = true;
            super.close();
        }
    }
}
