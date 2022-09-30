package com.dropbox.core.examples.account_info;

import static org.junit.Assume.assumeTrue;

import com.dropbox.core.examples.CredentialsUtil;

import org.junit.Before;
import org.junit.Test;

public class AccountInfoExampleTest {

    @Before
    public void setup() {
        // Only run if this is running in CI
        Boolean isRunningInCI = System.getenv("ci").equals("true");
        assumeTrue(isRunningInCI);
    }

    @Test
    public void accountInfo() {
        new AccountInfoExample().runExample(CredentialsUtil.getDbxCredential());
    }
}
