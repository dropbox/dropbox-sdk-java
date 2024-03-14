/* DO NOT EDIT */
/* This file was generated from team_log.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

public class GetTeamEventsResult {
    // struct team_log.GetTeamEventsResult (team_log.stone)

    protected final List<TeamEvent> events;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param events  List of events. Note that events are not guaranteed to be
     *     sorted by their timestamp value. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamLogRequests#getEventsContinue(String)} to obtain
     *     additional events. The value of {@link GetTeamEventsResult#getCursor}
     *     may change for each response from {@link
     *     DbxTeamTeamLogRequests#getEventsContinue(String)}, regardless of the
     *     value of {@link GetTeamEventsResult#getHasMore}; older cursor strings
     *     may expire. Thus, callers should ensure that they update their cursor
     *     based on the latest value of {@link GetTeamEventsResult#getCursor}
     *     after each call, and poll regularly if they wish to poll for new
     *     events. Callers should handle reset exceptions for expired cursors.
     *     Must not be {@code null}.
     * @param hasMore  Is true if there may be additional events that have not
     *     been returned yet. An additional call to {@link
     *     DbxTeamTeamLogRequests#getEventsContinue(String)} can retrieve them.
     *     Note that {@link GetTeamEventsResult#getHasMore} may be {@code true},
     *     even if {@link GetTeamEventsResult#getEvents} is empty.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTeamEventsResult(@Nonnull List<TeamEvent> events, @Nonnull String cursor, boolean hasMore) {
        if (events == null) {
            throw new IllegalArgumentException("Required value for 'events' is null");
        }
        for (TeamEvent x : events) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'events' is null");
            }
        }
        this.events = events;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of events. Note that events are not guaranteed to be sorted by their
     * timestamp value.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<TeamEvent> getEvents() {
        return events;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)} to obtain additional
     * events. The value of {@link GetTeamEventsResult#getCursor} may change for
     * each response from {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)}, regardless of the
     * value of {@link GetTeamEventsResult#getHasMore}; older cursor strings may
     * expire. Thus, callers should ensure that they update their cursor based
     * on the latest value of {@link GetTeamEventsResult#getCursor} after each
     * call, and poll regularly if they wish to poll for new events. Callers
     * should handle reset exceptions for expired cursors.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there may be additional events that have not been returned
     * yet. An additional call to {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)} can retrieve them. Note
     * that {@link GetTeamEventsResult#getHasMore} may be {@code true}, even if
     * {@link GetTeamEventsResult#getEvents} is empty.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            events,
            cursor,
            hasMore
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetTeamEventsResult other = (GetTeamEventsResult) obj;
            return ((this.events == other.events) || (this.events.equals(other.events)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<GetTeamEventsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTeamEventsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("events");
            StoneSerializers.list(TeamEvent.Serializer.INSTANCE).serialize(value.events, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTeamEventsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTeamEventsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<TeamEvent> f_events = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("events".equals(field)) {
                        f_events = StoneSerializers.list(TeamEvent.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_events == null) {
                    throw new JsonParseException(p, "Required field \"events\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new GetTeamEventsResult(f_events, f_cursor, f_hasMore);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
