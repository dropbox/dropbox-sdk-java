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
import java.util.List;

/**
 * Information on linked applications of a team member.
 */
@JsonSerialize(using=MemberLinkedApps.Serializer.class)
@JsonDeserialize(using=MemberLinkedApps.Deserializer.class)
public class MemberLinkedApps {
    // struct MemberLinkedApps

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String teamMemberId;
    protected final List<ApiApp> linkedApiApps;

    /**
     * Information on linked applications of a team member.
     *
     * @param teamMemberId  The member unique Id. Must not be {@code null}.
     * @param linkedApiApps  List of third party applications linked by this
     *     team member. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberLinkedApps(String teamMemberId, List<ApiApp> linkedApiApps) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (linkedApiApps == null) {
            throw new IllegalArgumentException("Required value for 'linkedApiApps' is null");
        }
        for (ApiApp x : linkedApiApps) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedApiApps' is null");
            }
        }
        this.linkedApiApps = linkedApiApps;
    }

    /**
     * The member unique Id
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * List of third party applications linked by this team member
     *
     * @return value for this field, never {@code null}.
     */
    public List<ApiApp> getLinkedApiApps() {
        return linkedApiApps;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            linkedApiApps
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
            MemberLinkedApps other = (MemberLinkedApps) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.linkedApiApps == other.linkedApiApps) || (this.linkedApiApps.equals(other.linkedApiApps)))
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

    static final class Serializer extends StructJsonSerializer<MemberLinkedApps> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberLinkedApps.class);
        }

        public Serializer(boolean unwrapping) {
            super(MemberLinkedApps.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MemberLinkedApps> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MemberLinkedApps value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("linked_api_apps", value.linkedApiApps);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MemberLinkedApps> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberLinkedApps.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MemberLinkedApps.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MemberLinkedApps> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MemberLinkedApps deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            List<ApiApp> linkedApiApps = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("linked_api_apps".equals(_field)) {
                    expectArrayStart(_p);
                    linkedApiApps = new java.util.ArrayList<ApiApp>();
                    while (!isArrayEnd(_p)) {
                        ApiApp _x = null;
                        _x = _p.readValueAs(ApiApp.class);
                        _p.nextToken();
                        linkedApiApps.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }
            if (linkedApiApps == null) {
                throw new JsonParseException(_p, "Required field \"linked_api_apps\" is missing.");
            }

            return new MemberLinkedApps(teamMemberId, linkedApiApps);
        }
    }
}
