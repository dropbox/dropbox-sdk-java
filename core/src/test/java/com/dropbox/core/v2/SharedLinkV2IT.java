package com.dropbox.core.v2;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;

import com.dropbox.core.ITUtil;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;

/**
 * Integration test that resolves the shared link supplied via {@code DROPBOX_SHARED_LINK} using
 * the sharing API (mirrors the shared-link credential shared across the Dropbox SDKs). Requires
 * the {@code SCOPED_USER_*} and {@code DROPBOX_SHARED_LINK} environment variables; otherwise the
 * tests are skipped.
 */
public class SharedLinkV2IT {
    @Test
    public void testGetSharedLinkMetadata() throws Exception {
        String sharedLink = ITUtil.valueFromEnvOrSkip(ITUtil.DROPBOX_SHARED_LINK);
        DbxClientV2 client = ITUtil.newScopedUserClientV2();

        SharedLinkMetadata metadata = client.sharing().getSharedLinkMetadata(sharedLink);
        assertThat(metadata).isNotNull();
        assertThat(metadata.getUrl()).isNotNull();
        assertThat(metadata.getName()).isNotNull();
    }
}
