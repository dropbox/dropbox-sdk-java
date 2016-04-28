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
import java.util.List;

@JsonSerialize(using=GroupMembersRemoveArg.Serializer.class)
@JsonDeserialize(using=GroupMembersRemoveArg.Deserializer.class)
class GroupMembersRemoveArg extends IncludeMembersArg {
    // struct GroupMembersRemoveArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupSelector group;
    protected final List<UserSelectorArg> users;

    /**
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersRemoveArg(GroupSelector group, List<UserSelectorArg> users, boolean returnMembers) {
        super(returnMembers);
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (UserSelectorArg x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersRemoveArg(GroupSelector group, List<UserSelectorArg> users) {
        this(group, users, true);
    }

    /**
     * Group from which users will be removed.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * List of users to be removed from the group.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSelectorArg> getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            users
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
            GroupMembersRemoveArg other = (GroupMembersRemoveArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.users == other.users) || (this.users.equals(other.users)))
                && (this.returnMembers == other.returnMembers)
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

    static final class Serializer extends StructJsonSerializer<GroupMembersRemoveArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersRemoveArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupMembersRemoveArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupMembersRemoveArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupMembersRemoveArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group", value.group);
            g.writeObjectField("users", value.users);
            g.writeObjectField("return_members", value.returnMembers);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupMembersRemoveArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersRemoveArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupMembersRemoveArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupMembersRemoveArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupMembersRemoveArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            GroupSelector group = null;
            List<UserSelectorArg> users = null;
            boolean returnMembers = true;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group".equals(_field)) {
                    group = _p.readValueAs(GroupSelector.class);
                    _p.nextToken();
                }
                else if ("users".equals(_field)) {
                    expectArrayStart(_p);
                    users = new java.util.ArrayList<UserSelectorArg>();
                    while (!isArrayEnd(_p)) {
                        UserSelectorArg _x = null;
                        _x = _p.readValueAs(UserSelectorArg.class);
                        _p.nextToken();
                        users.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("return_members".equals(_field)) {
                    returnMembers = _p.getValueAsBoolean();
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

            return new GroupMembersRemoveArg(group, users, returnMembers);
        }
    }
}
