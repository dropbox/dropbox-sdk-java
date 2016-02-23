/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.List;

/**
 * Routes in namespace "users".
 */
public final class DbxUsers {
    // namespace users

    private final DbxRawClientV2 client;

    public DbxUsers(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route users/get_account
    //

    /**
     * Get information about a user's account.
     *
     *
     * @return Basic information about any account.
     */
     BasicAccount getAccount(GetAccountArg getAccountArg) throws GetAccountErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_account",
                                   getAccountArg,
                                   false,
                                   GetAccountArg._JSON_WRITER,
                                   BasicAccount._JSON_READER,
                                   GetAccountError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountErrorException(ew.getRequestId(), ew.getUserMessage(), (GetAccountError) ew.getErrorValue());
        }
    }

    /**
     * Get information about a user's account.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetAccountArg} for more details. </p>
     *
     * @param accountId  A user's account identifier. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     *
     * @return Basic information about any account.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount getAccount(String accountId) throws GetAccountErrorException, DbxException {
        GetAccountArg arg = new GetAccountArg(accountId);
        return getAccount(arg);
    }

    //
    // route users/get_current_account
    //

    /**
     * Get information about the current user's account.
     *
     * @return Detailed information about the current user's account.
     */
    public FullAccount getCurrentAccount() throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_current_account",
                                   null,
                                   false,
                                   null,
                                   FullAccount._JSON_READER,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"get_current_account\": ew.errValue");
        }
    }

    //
    // route users/get_space_usage
    //

    /**
     * Get the space usage information for the current user's account.
     *
     * @return Information about a user's space usage and quota.
     */
    public SpaceUsage getSpaceUsage() throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_space_usage",
                                   null,
                                   false,
                                   null,
                                   SpaceUsage._JSON_READER,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"get_space_usage\": ew.errValue");
        }
    }

    //
    // route users/get_account_batch
    //

    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     *
     */
     List<BasicAccount> getAccountBatch(GetAccountBatchArg getAccountBatchArg) throws GetAccountBatchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/users/get_account_batch",
                                   getAccountBatchArg,
                                   false,
                                   GetAccountBatchArg._JSON_WRITER,
                                   JsonArrayReader.mk(BasicAccount._JSON_READER),
                                   GetAccountBatchError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetAccountBatchErrorException(ew.getRequestId(), ew.getUserMessage(), (GetAccountBatchError) ew.getErrorValue());
        }
    }

    /**
     * Get information about multiple user accounts.  At most 300 accounts may
     * be queried per request.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetAccountBatchArg} for more details. </p>
     *
     * @param accountIds  List of user account identifiers.  Should not contain
     *     any duplicate account IDs. Must contain at least 1 items, not contain
     *     a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<BasicAccount> getAccountBatch(List<String> accountIds) throws GetAccountBatchErrorException, DbxException {
        GetAccountBatchArg arg = new GetAccountBatchArg(accountIds);
        return getAccountBatch(arg);
    }
}
