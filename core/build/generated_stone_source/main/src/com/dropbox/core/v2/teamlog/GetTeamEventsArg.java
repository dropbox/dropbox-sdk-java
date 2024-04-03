/* DO NOT EDIT */
/* This file was generated from team_log.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.TimeRange;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class GetTeamEventsArg {
    // struct team_log.GetTeamEventsArg (team_log.stone)

    protected final long limit;
    @Nullable
    protected final String accountId;
    @Nullable
    protected final TimeRange time;
    @Nullable
    protected final EventCategory category;
    @Nullable
    protected final EventTypeArg eventType;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param limit  The maximal number of results to return per call. Note that
     *     some calls may not return {@link GetTeamEventsArg#getLimit} number of
     *     events, and may even return no events, even with `has_more` set to
     *     true. In this case, callers should fetch again using {@link
     *     DbxTeamTeamLogRequests#getEventsContinue(String)}. Must be greater
     *     than or equal to 1 and be less than or equal to 1000.
     * @param accountId  Filter the events by account ID. Return only events
     *     with this account_id as either Actor, Context, or Participants. Must
     *     have length of at least 40 and have length of at most 40.
     * @param time  Filter by time range.
     * @param category  Filter the returned events to a single category. Note
     *     that category shouldn't be provided together with event_type.
     * @param eventType  Filter the returned events to a single event type. Note
     *     that event_type shouldn't be provided together with category.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTeamEventsArg(long limit, @Nullable String accountId, @Nullable TimeRange time, @Nullable EventCategory category, @Nullable EventTypeArg eventType) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
        if (accountId != null) {
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = accountId;
        this.time = time;
        this.category = category;
        this.eventType = eventType;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public GetTeamEventsArg() {
        this(1000L, null, null, null, null);
    }

    /**
     * The maximal number of results to return per call. Note that some calls
     * may not return {@link GetTeamEventsArg#getLimit} number of events, and
     * may even return no events, even with `has_more` set to true. In this
     * case, callers should fetch again using {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)}.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * Filter the events by account ID. Return only events with this account_id
     * as either Actor, Context, or Participants.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getAccountId() {
        return accountId;
    }

    /**
     * Filter by time range.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public TimeRange getTime() {
        return time;
    }

    /**
     * Filter the returned events to a single category. Note that category
     * shouldn't be provided together with event_type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public EventCategory getCategory() {
        return category;
    }

    /**
     * Filter the returned events to a single event type. Note that event_type
     * shouldn't be provided together with category.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public EventTypeArg getEventType() {
        return eventType;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link GetTeamEventsArg}.
     */
    public static class Builder {

        protected long limit;
        protected String accountId;
        protected TimeRange time;
        protected EventCategory category;
        protected EventTypeArg eventType;

        protected Builder() {
            this.limit = 1000L;
            this.accountId = null;
            this.time = null;
            this.category = null;
            this.eventType = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 1000L}.
         * </p>
         *
         * @param limit  The maximal number of results to return per call. Note
         *     that some calls may not return {@link GetTeamEventsArg#getLimit}
         *     number of events, and may even return no events, even with
         *     `has_more` set to true. In this case, callers should fetch again
         *     using {@link DbxTeamTeamLogRequests#getEventsContinue(String)}.
         *     Must be greater than or equal to 1 and be less than or equal to
         *     1000. Defaults to {@code 1000L} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Long limit) {
            if (limit < 1L) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (limit > 1000L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 1000L;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param accountId  Filter the events by account ID. Return only events
         *     with this account_id as either Actor, Context, or Participants.
         *     Must have length of at least 40 and have length of at most 40.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccountId(String accountId) {
            if (accountId != null) {
                if (accountId.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (accountId.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = accountId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param time  Filter by time range.
         *
         * @return this builder
         */
        public Builder withTime(TimeRange time) {
            this.time = time;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param category  Filter the returned events to a single category.
         *     Note that category shouldn't be provided together with
         *     event_type.
         *
         * @return this builder
         */
        public Builder withCategory(EventCategory category) {
            this.category = category;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param eventType  Filter the returned events to a single event type.
         *     Note that event_type shouldn't be provided together with
         *     category.
         *
         * @return this builder
         */
        public Builder withEventType(EventTypeArg eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * Builds an instance of {@link GetTeamEventsArg} configured with this
         * builder's values
         *
         * @return new instance of {@link GetTeamEventsArg}
         */
        public GetTeamEventsArg build() {
            return new GetTeamEventsArg(limit, accountId, time, category, eventType);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.limit,
            this.accountId,
            this.time,
            this.category,
            this.eventType
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
            GetTeamEventsArg other = (GetTeamEventsArg) obj;
            return (this.limit == other.limit)
                && ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                && ((this.time == other.time) || (this.time != null && this.time.equals(other.time)))
                && ((this.category == other.category) || (this.category != null && this.category.equals(other.category)))
                && ((this.eventType == other.eventType) || (this.eventType != null && this.eventType.equals(other.eventType)))
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
    static class Serializer extends StructSerializer<GetTeamEventsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTeamEventsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (value.accountId != null) {
                g.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.accountId, g);
            }
            if (value.time != null) {
                g.writeFieldName("time");
                StoneSerializers.nullableStruct(TimeRange.Serializer.INSTANCE).serialize(value.time, g);
            }
            if (value.category != null) {
                g.writeFieldName("category");
                StoneSerializers.nullable(EventCategory.Serializer.INSTANCE).serialize(value.category, g);
            }
            if (value.eventType != null) {
                g.writeFieldName("event_type");
                StoneSerializers.nullable(EventTypeArg.Serializer.INSTANCE).serialize(value.eventType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTeamEventsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTeamEventsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_limit = 1000L;
                String f_accountId = null;
                TimeRange f_time = null;
                EventCategory f_category = null;
                EventTypeArg f_eventType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("time".equals(field)) {
                        f_time = StoneSerializers.nullableStruct(TimeRange.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("category".equals(field)) {
                        f_category = StoneSerializers.nullable(EventCategory.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("event_type".equals(field)) {
                        f_eventType = StoneSerializers.nullable(EventTypeArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new GetTeamEventsArg(f_limit, f_accountId, f_time, f_category, f_eventType);
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
