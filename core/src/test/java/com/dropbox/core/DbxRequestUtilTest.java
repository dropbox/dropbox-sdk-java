package com.dropbox.core;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;

public class DbxRequestUtilTest {

    @Test
    public void testEncodeUrlParam() {
        assertThat(DbxRequestUtil.encodeUrlParam("hello world/+"))
            .isEqualTo("hello+world%2F%2B");
    }
}
