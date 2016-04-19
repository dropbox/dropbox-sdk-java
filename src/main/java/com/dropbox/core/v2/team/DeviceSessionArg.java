/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=DeviceSessionArg.Serializer.class)
@JsonDeserialize(using=DeviceSessionArg.Deserializer.class)
public class DeviceSessionArg {
    // struct DeviceSessionArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sessionId;
    protected final String teamMemberId;

    /**
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSessionArg(String sessionId, String teamMemberId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
    }

    /**
     * The session id
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The unique id of the member owning the device
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId,
            teamMemberId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DeviceSessionArg other = (DeviceSessionArg) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<DeviceSessionArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DeviceSessionArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(DeviceSessionArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<DeviceSessionArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(DeviceSessionArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("team_member_id", value.teamMemberId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<DeviceSessionArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DeviceSessionArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(DeviceSessionArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<DeviceSessionArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public DeviceSessionArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String teamMemberId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }
            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }

            return new DeviceSessionArg(sessionId, teamMemberId);
        }
    }
}
