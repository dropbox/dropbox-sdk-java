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

@JsonSerialize(using=GroupMembersSetAccessTypeArg.Serializer.class)
@JsonDeserialize(using=GroupMembersSetAccessTypeArg.Deserializer.class)
class GroupMembersSetAccessTypeArg extends GroupMemberSelector {
    // struct GroupMembersSetAccessTypeArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupAccessType accessType;

    /**
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of {@link
     *     GroupMemberSelector#getGroup}. Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSetAccessTypeArg(GroupSelector group, UserSelectorArg user, GroupAccessType accessType) {
        super(group, user);
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * New group access type the user will have.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accessType
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
            GroupMembersSetAccessTypeArg other = (GroupMembersSetAccessTypeArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.user == other.user) || (this.user.equals(other.user)))
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

    static final class Serializer extends StructJsonSerializer<GroupMembersSetAccessTypeArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersSetAccessTypeArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupMembersSetAccessTypeArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupMembersSetAccessTypeArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupMembersSetAccessTypeArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group", value.group);
            g.writeObjectField("user", value.user);
            g.writeObjectField("access_type", value.accessType);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupMembersSetAccessTypeArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersSetAccessTypeArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupMembersSetAccessTypeArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupMembersSetAccessTypeArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupMembersSetAccessTypeArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            GroupSelector group = null;
            UserSelectorArg user = null;
            GroupAccessType accessType = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group".equals(_field)) {
                    group = _p.readValueAs(GroupSelector.class);
                    _p.nextToken();
                }
                else if ("user".equals(_field)) {
                    user = _p.readValueAs(UserSelectorArg.class);
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

            if (group == null) {
                throw new JsonParseException(_p, "Required field \"group\" is missing.");
            }
            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }
            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }

            return new GroupMembersSetAccessTypeArg(group, user, accessType);
        }
    }
}
