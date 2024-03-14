/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

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

/**
 * Followed/unfollowed Paper folder.
 */
public class PaperFolderChangeSubscriptionDetails {
    // struct team_log.PaperFolderChangeSubscriptionDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final String newSubscriptionLevel;
    protected final String previousSubscriptionLevel;

    /**
     * Followed/unfollowed Paper folder.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param newSubscriptionLevel  New folder subscription level. Must not be
     *     {@code null}.
     * @param previousSubscriptionLevel  Previous folder subscription level.
     *     Might be missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperFolderChangeSubscriptionDetails(String eventUuid, String newSubscriptionLevel, String previousSubscriptionLevel) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (newSubscriptionLevel == null) {
            throw new IllegalArgumentException("Required value for 'newSubscriptionLevel' is null");
        }
        this.newSubscriptionLevel = newSubscriptionLevel;
        this.previousSubscriptionLevel = previousSubscriptionLevel;
    }

    /**
     * Followed/unfollowed Paper folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param newSubscriptionLevel  New folder subscription level. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperFolderChangeSubscriptionDetails(String eventUuid, String newSubscriptionLevel) {
        this(eventUuid, newSubscriptionLevel, null);
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getEventUuid() {
        return eventUuid;
    }

    /**
     * New folder subscription level.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getNewSubscriptionLevel() {
        return newSubscriptionLevel;
    }

    /**
     * Previous folder subscription level. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPreviousSubscriptionLevel() {
        return previousSubscriptionLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            newSubscriptionLevel,
            previousSubscriptionLevel
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
            PaperFolderChangeSubscriptionDetails other = (PaperFolderChangeSubscriptionDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.newSubscriptionLevel == other.newSubscriptionLevel) || (this.newSubscriptionLevel.equals(other.newSubscriptionLevel)))
                && ((this.previousSubscriptionLevel == other.previousSubscriptionLevel) || (this.previousSubscriptionLevel != null && this.previousSubscriptionLevel.equals(other.previousSubscriptionLevel)))
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
    static class Serializer extends StructSerializer<PaperFolderChangeSubscriptionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperFolderChangeSubscriptionDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("new_subscription_level");
            StoneSerializers.string().serialize(value.newSubscriptionLevel, g);
            if (value.previousSubscriptionLevel != null) {
                g.writeFieldName("previous_subscription_level");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousSubscriptionLevel, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperFolderChangeSubscriptionDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperFolderChangeSubscriptionDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_newSubscriptionLevel = null;
                String f_previousSubscriptionLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_subscription_level".equals(field)) {
                        f_newSubscriptionLevel = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_subscription_level".equals(field)) {
                        f_previousSubscriptionLevel = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_newSubscriptionLevel == null) {
                    throw new JsonParseException(p, "Required field \"new_subscription_level\" missing.");
                }
                value = new PaperFolderChangeSubscriptionDetails(f_eventUuid, f_newSubscriptionLevel, f_previousSubscriptionLevel);
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
