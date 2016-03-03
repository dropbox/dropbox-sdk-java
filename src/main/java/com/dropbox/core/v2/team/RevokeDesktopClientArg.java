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

@JsonSerialize(using=RevokeDesktopClientArg.Serializer.class)
@JsonDeserialize(using=RevokeDesktopClientArg.Deserializer.class)
public class RevokeDesktopClientArg extends DeviceSessionArg {
    // struct RevokeDesktopClientArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final boolean deleteOnUnlink;

    /**
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param deleteOnUnlink  Whether to delete all files of the account (this
     *     is possible only if supported by the desktop client and  will be made
     *     the next time the client access the account).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId, boolean deleteOnUnlink) {
        super(sessionId, teamMemberId);
        this.deleteOnUnlink = deleteOnUnlink;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId) {
        this(sessionId, teamMemberId, false);
    }

    /**
     * Whether to delete all files of the account (this is possible only if
     * supported by the desktop client and  will be made the next time the
     * client access the account)
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getDeleteOnUnlink() {
        return deleteOnUnlink;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            deleteOnUnlink
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            RevokeDesktopClientArg other = (RevokeDesktopClientArg) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && (this.deleteOnUnlink == other.deleteOnUnlink)
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

    static final class Serializer extends StructJsonSerializer<RevokeDesktopClientArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDesktopClientArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeDesktopClientArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeDesktopClientArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeDesktopClientArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("delete_on_unlink", value.deleteOnUnlink);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeDesktopClientArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDesktopClientArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeDesktopClientArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeDesktopClientArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeDesktopClientArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String teamMemberId = null;
            Boolean deleteOnUnlink = null;

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
                else if ("delete_on_unlink".equals(_field)) {
                    deleteOnUnlink = _p.getValueAsBoolean();
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

            return new RevokeDesktopClientArg(sessionId, teamMemberId, deleteOnUnlink);
        }
    }
}
