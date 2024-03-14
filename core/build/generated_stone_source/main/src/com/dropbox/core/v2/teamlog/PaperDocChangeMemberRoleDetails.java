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
 * Changed member permissions for Paper doc.
 */
public class PaperDocChangeMemberRoleDetails {
    // struct team_log.PaperDocChangeMemberRoleDetails (team_log_generated.stone)

    protected final String eventUuid;
    protected final PaperAccessType accessType;

    /**
     * Changed member permissions for Paper doc.
     *
     * @param eventUuid  Event unique identifier. Must not be {@code null}.
     * @param accessType  Paper doc access type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocChangeMemberRoleDetails(@Nonnull String eventUuid, @Nonnull PaperAccessType accessType) {
        if (eventUuid == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = eventUuid;
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
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
     * Paper doc access type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PaperAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            eventUuid,
            accessType
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
            PaperDocChangeMemberRoleDetails other = (PaperDocChangeMemberRoleDetails) obj;
            return ((this.eventUuid == other.eventUuid) || (this.eventUuid.equals(other.eventUuid)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
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
    static class Serializer extends StructSerializer<PaperDocChangeMemberRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocChangeMemberRoleDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(value.eventUuid, g);
            g.writeFieldName("access_type");
            PaperAccessType.Serializer.INSTANCE.serialize(value.accessType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocChangeMemberRoleDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocChangeMemberRoleDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_eventUuid = null;
                PaperAccessType f_accessType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("event_uuid".equals(field)) {
                        f_eventUuid = StoneSerializers.string().deserialize(p);
                    }
                    else if ("access_type".equals(field)) {
                        f_accessType = PaperAccessType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_eventUuid == null) {
                    throw new JsonParseException(p, "Required field \"event_uuid\" missing.");
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                value = new PaperDocChangeMemberRoleDetails(f_eventUuid, f_accessType);
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
