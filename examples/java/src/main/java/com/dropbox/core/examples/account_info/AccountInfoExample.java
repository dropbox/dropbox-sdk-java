package com.dropbox.core.examples.account_info;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.examples.CredentialsUtil;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;


public final class AccountInfoExample {

    public static void main(String[] args) {
        DbxCredential credential = CredentialsUtil.getDbxCredential();
        new AccountInfoExample().runExample(credential);
    }

    public void runExample(DbxCredential credential) {
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-account-info");
        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, credential);

        try {
            FullAccount dbxAccountInfo = dbxClient.users().getCurrentAccount();
            System.out.println(dbxAccountInfo.toStringMultiline());
        } catch (DbxException ex) {
            throw new RuntimeException("Error making API call: " + ex.getMessage());
        }
    }
}
