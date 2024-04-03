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

import javax.annotation.Nonnull;

/**
 * Changed permissions for published doc.
 */
public class PaperPublishedLinkChangePermissionDetails {
    // struct team_log.PaperPublishedLinkChangePermissionDetails (team_log_generated.stone)

    @Nonnull
    protected final String eventUuid;
    @Nonnull
    protected final String newPermissionLevel;
    @Nonnull
    protected final String previousPermissionLevel;

    /**
     * Changed permissions for published doc.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param newPermissionLevel  New permission level. Must not be {@code
     *     null}.
     * @param previousPermissionLevel  Previous permission level. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperPublishedLinkChangePermissionDetails(@Nonnull String eventUuid, @Nonnull String newPermissionLevel, @Nonnull String previousPermissionLevel) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (newPermissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'newPermissionLevel' is null");
        }
        this.newPermissionLevel = newPermissionLevel;
        if (previousPermissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'previousPermissionLevel' is null");
        }
        this.previousPermissionLevel = previousPermissionLevel;
    }

    /**
     * Event unique identifier.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getEventUuid() {
        return eventUuid;
    }

    /**
     * New permission level.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNewPermissionLevel() {
        return newPermissionLevel;
    }

    /**
     * Previous permission level.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPreviousPermissionLevel() {
        return previousPermissionLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.eventUuid,
            this.newPermissionLevel,
            this.previousPermissionLevel
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
            PaperPublishedLinkChangePermissionDetails other = (PaperPublishedLinkChangePermissionDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.newPermissionLevel == other.newPermissionLevel) || (this.newPermissionLevel.equals(other.newPermissionLevel)))
                && ((this.previousPermissionLevel == other.previousPermissionLevel) || (this.previousPermissionLevel.equals(other.previousPermissionLevel)))
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
    static class Serializer extends StructSerializer<PaperPublishedLinkChangePermissionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperPublishedLinkChangePermissionDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("new_permission_level");
            StoneSerializers.string().serialize(value.newPermissionLevel, g);
            g.writeFieldName("previous_permission_level");
            StoneSerializers.string().serialize(value.previousPermissionLevel, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperPublishedLinkChangePermissionDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperPublishedLinkChangePermissionDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_newPermissionLevel = null;
                String f_previousPermissionLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_permission_level".equals(field)) {
                        f_newPermissionLevel = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_permission_level".equals(field)) {
                        f_previousPermissionLevel = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_newPermissionLevel == null) {
                    throw new JsonParseException(p, "Required field \"new_permission_level\" missing.");
                }
                if (f_previousPermissionLevel == null) {
                    throw new JsonParseException(p, "Required field \"previous_permission_level\" missing.");
                }
                value = new PaperPublishedLinkChangePermissionDetails(f_eventUuid, f_newPermissionLevel, f_previousPermissionLevel);
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
