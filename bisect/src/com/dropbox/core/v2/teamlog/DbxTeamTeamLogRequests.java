/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone, team_log.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "team_log".
 */
public class DbxTeamTeamLogRequests {
    // namespace team_log (team_log_generated.stone, team_log.stone)

    private final DbxRawClientV2 client;

    public DbxTeamTeamLogRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/team_log/get_events
    //

    /**
     * Retrieves team events. Events have a lifespan of two years. Events older
     * than two years will not be returned. Many attributes note 'may be missing
     * due to historical data gap'. Note that the file_operations category and
     * &amp; analogous paper events are not available on all Dropbox Business <a
     * href="/business/plans-comparison">plans</a>. Use <a
     * href="/developers/documentation/http/teams#team-features-get_values">features/get_values</a>
     * to check for this feature. Permission : Team Auditing.
     *
     */
    GetTeamEventsResult getEvents(GetTeamEventsArg arg) throws GetTeamEventsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team_log/get_events",
                                        arg,
                                        false,
                                        GetTeamEventsArg.Serializer.INSTANCE,
                                        GetTeamEventsResult.Serializer.INSTANCE,
                                        GetTeamEventsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetTeamEventsErrorException("2/team_log/get_events", ex.getRequestId(), ex.getUserMessage(), (GetTeamEventsError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves team events.
     *
     * <p> Events have a lifespan of two years. Events older than two years will
     * not be returned. </p>
     *
     * <p> Many attributes note 'may be missing due to historical data gap'.
     * </p>
     *
     * <p> Note that the file_operations category and &amp; analogous paper
     * events are not available on all Dropbox Business <a
     * href="/business/plans-comparison">plans</a>. Use <a
     * href="/developers/documentation/http/teams#team-features-get_values">features/get_values</a>
     * to check for this feature. </p>
     *
     * <p> Permission : Team Auditing. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link GetEventsBuilder} for more details. </p>
     */
    public GetTeamEventsResult getEvents() throws GetTeamEventsErrorException, DbxException {
        GetTeamEventsArg _arg = new GetTeamEventsArg();
        return getEvents(_arg);
    }

    /**
     * Retrieves team events. Events have a lifespan of two years. Events older
     * than two years will not be returned. Many attributes note 'may be missing
     * due to historical data gap'. Note that the file_operations category and
     * &amp; analogous paper events are not available on all Dropbox Business <a
     * href="/business/plans-comparison">plans</a>. Use <a
     * href="/developers/documentation/http/teams#team-features-get_values">features/get_values</a>
     * to check for this feature. Permission : Team Auditing.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public GetEventsBuilder getEventsBuilder() {
        GetTeamEventsArg.Builder argBuilder_ = GetTeamEventsArg.newBuilder();
        return new GetEventsBuilder(this, argBuilder_);
    }

    //
    // route 2/team_log/get_events/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamLogRequests#getEvents}, use this to paginate through all
     * events. Permission : Team Auditing.
     *
     */
    GetTeamEventsResult getEventsContinue(GetTeamEventsContinueArg arg) throws GetTeamEventsContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team_log/get_events/continue",
                                        arg,
                                        false,
                                        GetTeamEventsContinueArg.Serializer.INSTANCE,
                                        GetTeamEventsResult.Serializer.INSTANCE,
                                        GetTeamEventsContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetTeamEventsContinueErrorException("2/team_log/get_events/continue", ex.getRequestId(), ex.getUserMessage(), (GetTeamEventsContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamLogRequests#getEvents}, use this to paginate through all
     * events.
     *
     * <p> Permission : Team Auditing. </p>
     *
     * @param cursor  Indicates from what point to get the next set of events.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTeamEventsResult getEventsContinue(String cursor) throws GetTeamEventsContinueErrorException, DbxException {
        GetTeamEventsContinueArg _arg = new GetTeamEventsContinueArg(cursor);
        return getEventsContinue(_arg);
    }
}
