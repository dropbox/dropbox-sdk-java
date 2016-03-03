/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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
 * Profile of group member, and role in group.
 */
@JsonSerialize(using=GroupMemberInfo.Serializer.class)
@JsonDeserialize(using=GroupMemberInfo.Deserializer.class)
public class GroupMemberInfo {
    // struct GroupMemberInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final MemberProfile profile;
    protected final GroupAccessType accessType;

    /**
     * Profile of group member, and role in group.
     *
     * @param profile  Profile of group member. Must not be {@code null}.
     * @param accessType  The role that the user has in the group. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMemberInfo(MemberProfile profile, GroupAccessType accessType) {
        if (profile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = profile;
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * Profile of group member.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberProfile getProfile() {
        return profile;
    }

    /**
     * The role that the user has in the group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            profile,
            accessType
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
            GroupMemberInfo other = (GroupMemberInfo) obj;
            return ((this.profile == other.profile) || (this.profile.equals(other.profile)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
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

    static final class Serializer extends StructJsonSerializer<GroupMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMemberInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupMemberInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupMemberInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("profile", value.profile);
            g.writeObjectField("access_type", value.accessType);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupMemberInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMemberInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupMemberInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupMemberInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupMemberInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            MemberProfile profile = null;
            GroupAccessType accessType = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("profile".equals(_field)) {
                    profile = _p.readValueAs(MemberProfile.class);
                    _p.nextToken();
                }
                else if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(GroupAccessType.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (profile == null) {
                throw new JsonParseException(_p, "Required field \"profile\" is missing.");
            }
            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }

            return new GroupMemberInfo(profile, accessType);
        }
    }
}
