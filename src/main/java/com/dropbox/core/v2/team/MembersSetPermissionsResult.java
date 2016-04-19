/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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

@JsonSerialize(using=MembersSetPermissionsResult.Serializer.class)
@JsonDeserialize(using=MembersSetPermissionsResult.Deserializer.class)
public class MembersSetPermissionsResult {
    // struct MembersSetPermissionsResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String teamMemberId;
    protected final AdminTier role;

    /**
     *
     * @param teamMemberId  The member ID of the user to which the change was
     *     applied. Must not be {@code null}.
     * @param role  The role after the change. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsResult(String teamMemberId, AdminTier role) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * The member ID of the user to which the change was applied.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * The role after the change.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            role
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
            MembersSetPermissionsResult other = (MembersSetPermissionsResult) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.role == other.role) || (this.role.equals(other.role)))
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

    static final class Serializer extends StructJsonSerializer<MembersSetPermissionsResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersSetPermissionsResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersSetPermissionsResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersSetPermissionsResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersSetPermissionsResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("role", value.role);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersSetPermissionsResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersSetPermissionsResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersSetPermissionsResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersSetPermissionsResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersSetPermissionsResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            AdminTier role = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("role".equals(_field)) {
                    role = _p.readValueAs(AdminTier.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }
            if (role == null) {
                throw new JsonParseException(_p, "Required field \"role\" is missing.");
            }

            return new MembersSetPermissionsResult(teamMemberId, role);
        }
    }
}
