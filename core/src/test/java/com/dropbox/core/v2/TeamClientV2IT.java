package com.dropbox.core.v2;

import static com.google.common.truth.Truth.assertThat;

import org.testng.annotations.Test;

import com.dropbox.core.ITUtil;
import com.dropbox.core.v2.team.TeamGetInfoResult;

/**
 * Integration test for {@link DbxTeamClientV2} authenticated via the scoped team refresh token
 * (mirrors the {@code dbx_team_from_env} fixture in dropbox-sdk-python). Requires the
 * {@code SCOPED_TEAM_*} environment variables; otherwise the tests are skipped.
 */
public class TeamClientV2IT {
    @Test
    public void testScopedTeamGetInfo() throws Exception {
        DbxTeamClientV2 client = ITUtil.newScopedTeamClientV2();

        TeamGetInfoResult info = client.team().getInfo();
        assertThat(info).isNotNull();
        assertThat(info.getTeamId()).isNotNull();
        assertThat(info.getName()).isNotNull();
    }
}
