package com.dropbox.core.v2;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;

import com.dropbox.core.ITUtil;
import com.dropbox.core.v2.users.FullAccount;

/**
 * Integration test for a user {@link DbxClientV2} authenticated via the scoped user refresh token
 * (mirrors the scoped-user credentials shared across the Dropbox SDKs). Requires the
 * {@code SCOPED_USER_*} environment variables; otherwise the tests are skipped.
 */
public class ScopedUserClientV2IT {
    @Test
    public void testScopedUserRefreshAccountInfo() throws Exception {
        DbxClientV2 client = ITUtil.newScopedUserClientV2();

        FullAccount account = client.users().getCurrentAccount();
        assertThat(account).isNotNull();
        assertThat(account.getAccountId()).isNotNull();
        assertThat(account.getName()).isNotNull();
    }
}
