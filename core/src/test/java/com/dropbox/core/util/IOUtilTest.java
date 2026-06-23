package com.dropbox.core.util;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class IOUtilTest {
    @Test
    public void slurpHonorsByteLimit() throws Exception {
        byte[] result = IOUtil.slurp(
            new ByteArrayInputStream("abcdef".getBytes(StandardCharsets.UTF_8)),
            3,
            new byte[2]
        );

        assertEquals(new String(result, StandardCharsets.UTF_8), "abc");
    }

    @Test
    public void slurpReturnsShortStreamWithoutPadding() throws Exception {
        byte[] result = IOUtil.slurp(
            new ByteArrayInputStream("ab".getBytes(StandardCharsets.UTF_8)),
            3,
            new byte[2]
        );

        assertEquals(new String(result, StandardCharsets.UTF_8), "ab");
    }
}
