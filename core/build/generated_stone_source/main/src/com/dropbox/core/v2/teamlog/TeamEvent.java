/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An audit log event.
 */
public class TeamEvent {
    // struct team_log.TeamEvent (team_log_generated.stone)

    @Nonnull
    protected final Date timestamp;
    @Nonnull
    protected final EventCategory eventCategory;
    @Nullable
    protected final ActorLogInfo actor;
    @Nullable
    protected final OriginLogInfo origin;
    @Nullable
    protected final Boolean involveNonTeamMember;
    @Nullable
    protected final ContextLogInfo context;
    @Nullable
    protected final List<ParticipantLogInfo> participants;
    @Nullable
    protected final List<AssetLogInfo> assets;
    @Nonnull
    protected final EventType eventType;
    @Nonnull
    protected final EventDetails details;

    /**
     * An audit log event.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param timestamp  The Dropbox timestamp representing when the action was
     *     taken. Must not be {@code null}.
     * @param eventCategory  The category that this type of action belongs to.
     *     Must not be {@code null}.
     * @param eventType  The particular type of action taken. Must not be {@code
     *     null}.
     * @param details  The variable event schema applicable to this type of
     *     action, instantiated with respect to this particular action. Must not
     *     be {@code null}.
     * @param actor  The entity who actually performed the action. Might be
     *     missing due to historical data gap.
     * @param origin  The origin from which the actor performed the action
     *     including information about host, ip address, location, session, etc.
     *     If the action was performed programmatically via the API the origin
     *     represents the API client.
     * @param involveNonTeamMember  True if the action involved a non team
     *     member either as the actor or as one of the affected users. Might be
     *     missing due to historical data gap.
     * @param context  The user or team on whose behalf the actor performed the
     *     action. Might be missing due to historical data gap.
     * @param participants  Zero or more users and/or groups that are affected
     *     by the action. Note that this list doesn't include any actors or
     *     users in context. Must not contain a {@code null} item.
     * @param assets  Zero or more content assets involved in the action.
     *     Currently these include Dropbox files and folders but in the future
     *     we might add other asset types such as Paper documents, folders,
     *     projects, etc. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamEvent(@Nonnull Date timestamp, @Nonnull EventCategory eventCategory, @Nonnull EventType eventType, @Nonnull EventDetails details, @Nullable ActorLogInfo actor, @Nullable OriginLogInfo origin, @Nullable Boolean involveNonTeamMember, @Nullable ContextLogInfo context, @Nullable List<ParticipantLogInfo> participants, @Nullable List<AssetLogInfo> assets) {
        if (timestamp == null) {
            throw new IllegalArgumentException("Required value for 'timestamp' is null");
        }
        this.timestamp = LangUtil.truncateMillis(timestamp);
        if (eventCategory == null) {
            throw new IllegalArgumentException("Required value for 'eventCategory' is null");
        }
        this.eventCategory = eventCategory;
        this.actor = actor;
        this.origin = origin;
        this.involveNonTeamMember = involveNonTeamMember;
        this.context = context;
        if (participants != null) {
            for (ParticipantLogInfo x : participants) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'participants' is null");
                }
            }
        }
        this.participants = participants;
        if (assets != null) {
            for (AssetLogInfo x : assets) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'assets' is null");
                }
            }
        }
        this.assets = assets;
        if (eventType == null) {
            throw new IllegalArgumentException("Required value for 'eventType' is null");
        }
        this.eventType = eventType;
        if (details == null) {
            throw new IllegalArgumentException("Required value for 'details' is null");
        }
        this.details = details;
    }

    /**
     * An audit log event.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param timestamp  The Dropbox timestamp representing when the action was
     *     taken. Must not be {@code null}.
     * @param eventCategory  The category that this type of action belongs to.
     *     Must not be {@code null}.
     * @param eventType  The particular type of action taken. Must not be {@code
     *     null}.
     * @param details  The variable event schema applicable to this type of
     *     action, instantiated with respect to this particular action. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamEvent(@Nonnull Date timestamp, @Nonnull EventCategory eventCategory, @Nonnull EventType eventType, @Nonnull EventDetails details) {
        this(timestamp, eventCategory, eventType, details, null, null, null, null, null, null);
    }

    /**
     * The Dropbox timestamp representing when the action was taken.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * The category that this type of action belongs to.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public EventCategory getEventCategory() {
        return eventCategory;
    }

    /**
     * The particular type of action taken.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public EventType getEventType() {
        return eventType;
    }

    /**
     * The variable event schema applicable to this type of action, instantiated
     * with respect to this particular action.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public EventDetails getDetails() {
        return details;
    }

    /**
     * The entity who actually performed the action. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public ActorLogInfo getActor() {
        return actor;
    }

    /**
     * The origin from which the actor performed the action including
     * information about host, ip address, location, session, etc. If the action
     * was performed programmatically via the API the origin represents the API
     * client.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public OriginLogInfo getOrigin() {
        return origin;
    }

    /**
     * True if the action involved a non team member either as the actor or as
     * one of the affected users. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getInvolveNonTeamMember() {
        return involveNonTeamMember;
    }

    /**
     * The user or team on whose behalf the actor performed the action. Might be
     * missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public ContextLogInfo getContext() {
        return context;
    }

    /**
     * Zero or more users and/or groups that are affected by the action. Note
     * that this list doesn't include any actors or users in context.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<ParticipantLogInfo> getParticipants() {
        return participants;
    }

    /**
     * Zero or more content assets involved in the action. Currently these
     * include Dropbox files and folders but in the future we might add other
     * asset types such as Paper documents, folders, projects, etc.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<AssetLogInfo> getAssets() {
        return assets;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param timestamp  The Dropbox timestamp representing when the action was
     *     taken. Must not be {@code null}.
     * @param eventCategory  The category that this type of action belongs to.
     *     Must not be {@code null}.
     * @param eventType  The particular type of action taken. Must not be {@code
     *     null}.
     * @param details  The variable event schema applicable to this type of
     *     action, instantiated with respect to this particular action. Must not
     *     be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(Date timestamp, EventCategory eventCategory, EventType eventType, EventDetails details) {
        return new Builder(timestamp, eventCategory, eventType, details);
    }

    /**
     * Builder for {@link TeamEvent}.
     */
    public static class Builder {
        protected final Date timestamp;
        protected final EventCategory eventCategory;
        protected final EventType eventType;
        protected final EventDetails details;

        protected ActorLogInfo actor;
        protected OriginLogInfo origin;
        protected Boolean involveNonTeamMember;
        protected ContextLogInfo context;
        protected List<ParticipantLogInfo> participants;
        protected List<AssetLogInfo> assets;

        protected Builder(Date timestamp, EventCategory eventCategory, EventType eventType, EventDetails details) {
            if (timestamp == null) {
                throw new IllegalArgumentException("Required value for 'timestamp' is null");
            }
            this.timestamp = LangUtil.truncateMillis(timestamp);
            if (eventCategory == null) {
                throw new IllegalArgumentException("Required value for 'eventCategory' is null");
            }
            this.eventCategory = eventCategory;
            if (eventType == null) {
                throw new IllegalArgumentException("Required value for 'eventType' is null");
            }
            this.eventType = eventType;
            if (details == null) {
                throw new IllegalArgumentException("Required value for 'details' is null");
            }
            this.details = details;
            this.actor = null;
            this.origin = null;
            this.involveNonTeamMember = null;
            this.context = null;
            this.participants = null;
            this.assets = null;
        }

        /**
         * Set value for optional field.
         *
         * @param actor  The entity who actually performed the action. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withActor(ActorLogInfo actor) {
            this.actor = actor;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param origin  The origin from which the actor performed the action
         *     including information about host, ip address, location, session,
         *     etc. If the action was performed programmatically via the API the
         *     origin represents the API client.
         *
         * @return this builder
         */
        public Builder withOrigin(OriginLogInfo origin) {
            this.origin = origin;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param involveNonTeamMember  True if the action involved a non team
         *     member either as the actor or as one of the affected users. Might
         *     be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withInvolveNonTeamMember(Boolean involveNonTeamMember) {
            this.involveNonTeamMember = involveNonTeamMember;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param context  The user or team on whose behalf the actor performed
         *     the action. Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withContext(ContextLogInfo context) {
            this.context = context;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param participants  Zero or more users and/or groups that are
         *     affected by the action. Note that this list doesn't include any
         *     actors or users in context. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withParticipants(List<ParticipantLogInfo> participants) {
            if (participants != null) {
                for (ParticipantLogInfo x : participants) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'participants' is null");
                    }
                }
            }
            this.participants = participants;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param assets  Zero or more content assets involved in the action.
         *     Currently these include Dropbox files and folders but in the
         *     future we might add other asset types such as Paper documents,
         *     folders, projects, etc. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAssets(List<AssetLogInfo> assets) {
            if (assets != null) {
                for (AssetLogInfo x : assets) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'assets' is null");
                    }
                }
            }
            this.assets = assets;
            return this;
        }

        /**
         * Builds an instance of {@link TeamEvent} configured with this
         * builder's values
         *
         * @return new instance of {@link TeamEvent}
         */
        public TeamEvent build() {
            return new TeamEvent(timestamp, eventCategory, eventType, details, actor, origin, involveNonTeamMember, context, participants, assets);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            timestamp,
            eventCategory,
            actor,
            origin,
            involveNonTeamMember,
            context,
            participants,
            assets,
            eventType,
            details
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
            TeamEvent other = (TeamEvent) obj;
            return ((this.timestamp == other.timestamp) || (this.timestamp.equals(other.timestamp)))
                && ((this.eventCategory == other.eventCategory) || (this.eventCategory.equals(other.eventCategory)))
                && ((this.eventType == other.eventType) || (this.eventType.equals(other.eventType)))
                && ((this.details == other.details) || (this.details.equals(other.details)))
                && ((this.actor == other.actor) || (this.actor != null && this.actor.equals(other.actor)))
                && ((this.origin == other.origin) || (this.origin != null && this.origin.equals(other.origin)))
                && ((this.involveNonTeamMember == other.involveNonTeamMember) || (this.involveNonTeamMember != null && this.involveNonTeamMember.equals(other.involveNonTeamMember)))
                && ((this.context == other.context) || (this.context != null && this.context.equals(other.context)))
                && ((this.participants == other.participants) || (this.participants != null && this.participants.equals(other.participants)))
                && ((this.assets == other.assets) || (this.assets != null && this.assets.equals(other.assets)))
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
    static class Serializer extends StructSerializer<TeamEvent> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamEvent value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("timestamp");
            StoneSerializers.timestamp().serialize(value.timestamp, g);
            g.writeFieldName("event_category");
            EventCategory.Serializer.INSTANCE.serialize(value.eventCategory, g);
            g.writeFieldName("event_type");
            EventType.Serializer.INSTANCE.serialize(value.eventType, g);
            g.writeFieldName("details");
            EventDetails.Serializer.INSTANCE.serialize(value.details, g);
            if (value.actor != null) {
                g.writeFieldName("actor");
                StoneSerializers.nullable(ActorLogInfo.Serializer.INSTANCE).serialize(value.actor, g);
            }
            if (value.origin != null) {
                g.writeFieldName("origin");
                StoneSerializers.nullableStruct(OriginLogInfo.Serializer.INSTANCE).serialize(value.origin, g);
            }
            if (value.involveNonTeamMember != null) {
                g.writeFieldName("involve_non_team_member");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.involveNonTeamMember, g);
            }
            if (value.context != null) {
                g.writeFieldName("context");
                StoneSerializers.nullable(ContextLogInfo.Serializer.INSTANCE).serialize(value.context, g);
            }
            if (value.participants != null) {
                g.writeFieldName("participants");
                StoneSerializers.nullable(StoneSerializers.list(ParticipantLogInfo.Serializer.INSTANCE)).serialize(value.participants, g);
            }
            if (value.assets != null) {
                g.writeFieldName("assets");
                StoneSerializers.nullable(StoneSerializers.list(AssetLogInfo.Serializer.INSTANCE)).serialize(value.assets, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamEvent deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamEvent value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_timestamp = null;
                EventCategory f_eventCategory = null;
                EventType f_eventType = null;
                EventDetails f_details = null;
                ActorLogInfo f_actor = null;
                OriginLogInfo f_origin = null;
                Boolean f_involveNonTeamMember = null;
                ContextLogInfo f_context = null;
                List<ParticipantLogInfo> f_participants = null;
                List<AssetLogInfo> f_assets = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("timestamp".equals(field)) {
                        f_timestamp = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("event_category".equals(field)) {
                        f_eventCategory = EventCategory.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("event_type".equals(field)) {
                        f_eventType = EventType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("details".equals(field)) {
                        f_details = EventDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("actor".equals(field)) {
                        f_actor = StoneSerializers.nullable(ActorLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("origin".equals(field)) {
                        f_origin = StoneSerializers.nullableStruct(OriginLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("involve_non_team_member".equals(field)) {
                        f_involveNonTeamMember = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("context".equals(field)) {
                        f_context = StoneSerializers.nullable(ContextLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("participants".equals(field)) {
                        f_participants = StoneSerializers.nullable(StoneSerializers.list(ParticipantLogInfo.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("assets".equals(field)) {
                        f_assets = StoneSerializers.nullable(StoneSerializers.list(AssetLogInfo.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_timestamp == null) {
                    throw new JsonParseException(p, "Required field \"timestamp\" missing.");
                }
                if (f_eventCategory == null) {
                    throw new JsonParseException(p, "Required field \"event_category\" missing.");
                }
                if (f_eventType == null) {
                    throw new JsonParseException(p, "Required field \"event_type\" missing.");
                }
                if (f_details == null) {
                    throw new JsonParseException(p, "Required field \"details\" missing.");
                }
                value = new TeamEvent(f_timestamp, f_eventCategory, f_eventType, f_details, f_actor, f_origin, f_involveNonTeamMember, f_context, f_participants, f_assets);
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
