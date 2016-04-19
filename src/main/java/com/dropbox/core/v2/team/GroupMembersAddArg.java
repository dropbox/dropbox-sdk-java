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

@JsonSerialize(using=GroupMembersAddArg.Serializer.class)
@JsonDeserialize(using=GroupMembersAddArg.Deserializer.class)
class GroupMembersAddArg {
    // struct GroupMembersAddArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupSelector group;
    protected final List<MemberAccess> members;

    /**
     *
     * @param group  Group to which users will be added. Must not be {@code
     *     null}.
     * @param members  List of users to be added to the group. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersAddArg(GroupSelector group, List<MemberAccess> members) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (MemberAccess x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
    }

    /**
     * Group to which users will be added.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * List of users to be added to the group.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberAccess> getMembers() {
        return members;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            members
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
            GroupMembersAddArg other = (GroupMembersAddArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.members == other.members) || (this.members.equals(other.members)))
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

    static final class Serializer extends StructJsonSerializer<GroupMembersAddArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupMembersAddArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupMembersAddArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupMembersAddArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupMembersAddArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group", value.group);
            g.writeObjectField("members", value.members);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupMembersAddArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupMembersAddArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupMembersAddArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupMembersAddArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupMembersAddArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            GroupSelector group = null;
            List<MemberAccess> members = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group".equals(_field)) {
                    group = _p.readValueAs(GroupSelector.class);
                    _p.nextToken();
                }
                else if ("members".equals(_field)) {
                    expectArrayStart(_p);
                    members = new java.util.ArrayList<MemberAccess>();
                    while (!isArrayEnd(_p)) {
                        MemberAccess _x = null;
                        _x = _p.readValueAs(MemberAccess.class);
                        _p.nextToken();
                        members.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (group == null) {
                throw new JsonParseException(_p, "Required field \"group\" is missing.");
            }
            if (members == null) {
                throw new JsonParseException(_p, "Required field \"members\" is missing.");
            }

            return new GroupMembersAddArg(group, members);
        }
    }
}
