/* DO NOT EDIT */
/* This file was generated from team.babel */

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

/**
 * Policies governing sharing within and outside of the team.
 */
@JsonSerialize(using=TeamSharingPolicies.Serializer.class)
@JsonDeserialize(using=TeamSharingPolicies.Deserializer.class)
public class TeamSharingPolicies {
    // struct TeamSharingPolicies

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final SharedFolderMemberPolicy sharedFolderMemberPolicy;
    protected final SharedFolderJoinPolicy sharedFolderJoinPolicy;
    protected final SharedLinkCreatePolicy sharedLinkCreatePolicy;

    /**
     * Policies governing sharing within and outside of the team.
     *
     * @param sharedFolderMemberPolicy  Who can join folders shared by team
     *     members. Must not be {@code null}.
     * @param sharedFolderJoinPolicy  Which shared folders team members can
     *     join. Must not be {@code null}.
     * @param sharedLinkCreatePolicy  What is the visibility of newly created
     *     shared links. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamSharingPolicies(SharedFolderMemberPolicy sharedFolderMemberPolicy, SharedFolderJoinPolicy sharedFolderJoinPolicy, SharedLinkCreatePolicy sharedLinkCreatePolicy) {
        if (sharedFolderMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderMemberPolicy' is null");
        }
        this.sharedFolderMemberPolicy = sharedFolderMemberPolicy;
        if (sharedFolderJoinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderJoinPolicy' is null");
        }
        this.sharedFolderJoinPolicy = sharedFolderJoinPolicy;
        if (sharedLinkCreatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkCreatePolicy' is null");
        }
        this.sharedLinkCreatePolicy = sharedLinkCreatePolicy;
    }

    /**
     * Who can join folders shared by team members.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedFolderMemberPolicy getSharedFolderMemberPolicy() {
        return sharedFolderMemberPolicy;
    }

    /**
     * Which shared folders team members can join.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedFolderJoinPolicy getSharedFolderJoinPolicy() {
        return sharedFolderJoinPolicy;
    }

    /**
     * What is the visibility of newly created shared links.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedLinkCreatePolicy getSharedLinkCreatePolicy() {
        return sharedLinkCreatePolicy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderMemberPolicy,
            sharedFolderJoinPolicy,
            sharedLinkCreatePolicy
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
            TeamSharingPolicies other = (TeamSharingPolicies) obj;
            return ((this.sharedFolderMemberPolicy == other.sharedFolderMemberPolicy) || (this.sharedFolderMemberPolicy.equals(other.sharedFolderMemberPolicy)))
                && ((this.sharedFolderJoinPolicy == other.sharedFolderJoinPolicy) || (this.sharedFolderJoinPolicy.equals(other.sharedFolderJoinPolicy)))
                && ((this.sharedLinkCreatePolicy == other.sharedLinkCreatePolicy) || (this.sharedLinkCreatePolicy.equals(other.sharedLinkCreatePolicy)))
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

    static final class Serializer extends StructJsonSerializer<TeamSharingPolicies> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamSharingPolicies.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamSharingPolicies.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamSharingPolicies> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamSharingPolicies value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("shared_folder_member_policy", value.sharedFolderMemberPolicy);
            g.writeObjectField("shared_folder_join_policy", value.sharedFolderJoinPolicy);
            g.writeObjectField("shared_link_create_policy", value.sharedLinkCreatePolicy);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamSharingPolicies> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamSharingPolicies.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamSharingPolicies.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamSharingPolicies> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamSharingPolicies deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            SharedFolderMemberPolicy sharedFolderMemberPolicy = null;
            SharedFolderJoinPolicy sharedFolderJoinPolicy = null;
            SharedLinkCreatePolicy sharedLinkCreatePolicy = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("shared_folder_member_policy".equals(_field)) {
                    sharedFolderMemberPolicy = _p.readValueAs(SharedFolderMemberPolicy.class);
                    _p.nextToken();
                }
                else if ("shared_folder_join_policy".equals(_field)) {
                    sharedFolderJoinPolicy = _p.readValueAs(SharedFolderJoinPolicy.class);
                    _p.nextToken();
                }
                else if ("shared_link_create_policy".equals(_field)) {
                    sharedLinkCreatePolicy = _p.readValueAs(SharedLinkCreatePolicy.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sharedFolderMemberPolicy == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_member_policy\" is missing.");
            }
            if (sharedFolderJoinPolicy == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_join_policy\" is missing.");
            }
            if (sharedLinkCreatePolicy == null) {
                throw new JsonParseException(_p, "Required field \"shared_link_create_policy\" is missing.");
            }

            return new TeamSharingPolicies(sharedFolderMemberPolicy, sharedFolderJoinPolicy, sharedLinkCreatePolicy);
        }
    }
}
