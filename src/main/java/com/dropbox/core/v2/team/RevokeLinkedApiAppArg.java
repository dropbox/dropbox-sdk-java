/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

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

@JsonSerialize(using=RevokeLinkedApiAppArg.Serializer.class)
@JsonDeserialize(using=RevokeLinkedApiAppArg.Deserializer.class)
public class RevokeLinkedApiAppArg {
    // struct RevokeLinkedApiAppArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String appId;
    protected final String teamMemberId;
    protected final boolean keepAppFolder;

    /**
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param keepAppFolder  Whether to keep the application dedicated folder
     *     (in case the application uses  one).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppArg(String appId, String teamMemberId, boolean keepAppFolder) {
        if (appId == null) {
            throw new IllegalArgumentException("Required value for 'appId' is null");
        }
        this.appId = appId;
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.keepAppFolder = keepAppFolder;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppArg(String appId, String teamMemberId) {
        this(appId, teamMemberId, true);
    }

    /**
     * The application's unique id
     *
     * @return value for this field, never {@code null}.
     */
    public String getAppId() {
        return appId;
    }

    /**
     * The unique id of the member owning the device
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Whether to keep the application dedicated folder (in case the application
     * uses  one)
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getKeepAppFolder() {
        return keepAppFolder;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            appId,
            teamMemberId,
            keepAppFolder
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
            RevokeLinkedApiAppArg other = (RevokeLinkedApiAppArg) obj;
            return ((this.appId == other.appId) || (this.appId.equals(other.appId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && (this.keepAppFolder == other.keepAppFolder)
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

    static final class Serializer extends StructJsonSerializer<RevokeLinkedApiAppArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeLinkedApiAppArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeLinkedApiAppArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeLinkedApiAppArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeLinkedApiAppArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("app_id", value.appId);
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("keep_app_folder", value.keepAppFolder);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeLinkedApiAppArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeLinkedApiAppArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeLinkedApiAppArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeLinkedApiAppArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeLinkedApiAppArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String appId = null;
            String teamMemberId = null;
            Boolean keepAppFolder = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("app_id".equals(_field)) {
                    appId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("keep_app_folder".equals(_field)) {
                    keepAppFolder = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (appId == null) {
                throw new JsonParseException(_p, "Required field \"app_id\" is missing.");
            }
            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }

            return new RevokeLinkedApiAppArg(appId, teamMemberId, keepAppFolder);
        }
    }
}
