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
 * Argument for selecting a group and a list of users.
 */
@JsonSerialize(using=GroupMembersSelector.Serializer.class)
@JsonDeserialize(using=GroupMembersSelector.Deserializer.class)
public class GroupMembersSelector {
    // struct GroupMembersSelector

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupSelector group;
    protected final UsersSelectorArg users;

    /**
     * Argument for selecting a group and a list of users.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param users  A list of users that are members of {@link
     *     GroupMembersSelector#getGroup}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSelector(GroupSelector group, UsersSelectorArg users) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        this.users = users;
    }

    /**
     * Specify a group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * A list of users that are members of {@link
     * GroupMembersSelector#getGroup}.
     *
     * @return value for this field, never {@code null}.
     */
    public UsersSelectorArg getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            users
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
            GroupMembersSelector other = (GroupMembersSelector) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
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

    static final class Serializer extends StructJsonSerializer<GroupMembersSelector> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersSelector.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupMembersSelector.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupMembersSelector> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupMembersSelector value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group", value.group);
            g.writeObjectField("users", value.users);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupMembersSelector> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersSelector.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupMembersSelector.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupMembersSelector> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupMembersSelector deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            GroupSelector group = null;
            UsersSelectorArg users = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group".equals(_field)) {
                    group = _p.readValueAs(GroupSelector.class);
                    _p.nextToken();
                }
                else if ("users".equals(_field)) {
                    users = _p.readValueAs(UsersSelectorArg.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (group == null) {
                throw new JsonParseException(_p, "Required field \"group\" is missing.");
            }
            if (users == null) {
                throw new JsonParseException(_p, "Required field \"users\" is missing.");
            }

            return new GroupMembersSelector(group, users);
        }
    }
}
