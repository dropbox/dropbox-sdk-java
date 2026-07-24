package com.dropbox.core.util;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
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
