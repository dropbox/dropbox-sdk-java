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
import javax.annotation.Nullable;

/**
 * Transferred ownership of Paper doc.
 */
public class PaperDocOwnershipChangedDetails {
    // struct team_log.PaperDocOwnershipChangedDetails (team_log_generated.stone)

    @Nonnull
    protected final String eventUuid;
    @Nullable
    protected final String oldOwnerUserId;
    @Nonnull
    protected final String newOwnerUserId;

    /**
     * Transferred ownership of Paper doc.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param newOwnerUserId  New owner. Must have length of at least 40, have
     *     length of at most 40, and not be {@code null}.
     * @param oldOwnerUserId  Previous owner. Must have length of at least 40
     *     and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocOwnershipChangedDetails(@Nonnull String eventUuid, @Nonnull String newOwnerUserId, @Nullable String oldOwnerUserId) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (oldOwnerUserId != null) {
            if (oldOwnerUserId.length() < 40) {
                throw new IllegalArgumentException("String 'oldOwnerUserId' is shorter than 40");
            }
            if (oldOwnerUserId.length() > 40) {
                throw new IllegalArgumentException("String 'oldOwnerUserId' is longer than 40");
            }
        }
        this.oldOwnerUserId = oldOwnerUserId;
        if (newOwnerUserId == null) {
            throw new IllegalArgumentException("Required value for 'newOwnerUserId' is null");
        }
        if (newOwnerUserId.length() < 40) {
            throw new IllegalArgumentException("String 'newOwnerUserId' is shorter than 40");
        }
        if (newOwnerUserId.length() > 40) {
            throw new IllegalArgumentException("String 'newOwnerUserId' is longer than 40");
        }
        this.newOwnerUserId = newOwnerUserId;
    }

    /**
     * Transferred ownership of Paper doc.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param newOwnerUserId  New owner. Must have length of at least 40, have
     *     length of at most 40, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocOwnershipChangedDetails(@Nonnull String eventUuid, @Nonnull String newOwnerUserId) {
        this(eventUuid, newOwnerUserId, null);
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
     * New owner.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNewOwnerUserId() {
        return newOwnerUserId;
    }

    /**
     * Previous owner.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getOldOwnerUserId() {
        return oldOwnerUserId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.eventUuid,
            this.oldOwnerUserId,
            this.newOwnerUserId
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
            PaperDocOwnershipChangedDetails other = (PaperDocOwnershipChangedDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.newOwnerUserId == other.newOwnerUserId) || (this.newOwnerUserId.equals(other.newOwnerUserId)))
                && ((this.oldOwnerUserId == other.oldOwnerUserId) || (this.oldOwnerUserId != null && this.oldOwnerUserId.equals(other.oldOwnerUserId)))
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
    static class Serializer extends StructSerializer<PaperDocOwnershipChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocOwnershipChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("new_owner_user_id");
            StoneSerializers.string().serialize(value.newOwnerUserId, g);
            if (value.oldOwnerUserId != null) {
                g.writeFieldName("old_owner_user_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.oldOwnerUserId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocOwnershipChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocOwnershipChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                String f_newOwnerUserId = null;
                String f_oldOwnerUserId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_owner_user_id".equals(field)) {
                        f_newOwnerUserId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("old_owner_user_id".equals(field)) {
                        f_oldOwnerUserId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_newOwnerUserId == null) {
                    throw new JsonParseException(p, "Required field \"new_owner_user_id\" missing.");
                }
                value = new PaperDocOwnershipChangedDetails(f_eventUuid, f_newOwnerUserId, f_oldOwnerUserId);
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
