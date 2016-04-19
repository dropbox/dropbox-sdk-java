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

/**
 * Full description of a group.
 */
@JsonSerialize(using=GroupFullInfo.Serializer.class)
@JsonDeserialize(using=GroupFullInfo.Deserializer.class)
public class GroupFullInfo extends GroupSummary {
    // struct GroupFullInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<GroupMemberInfo> members;
    protected final long created;

    /**
     * Full description of a group.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param members  List of group members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long memberCount, List<GroupMemberInfo> members, long created, String groupExternalId) {
        super(groupName, groupId, memberCount, groupExternalId);
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (GroupMemberInfo x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        this.created = created;
    }

    /**
     * Full description of a group.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param memberCount  The number of members in the group.
     * @param members  List of group members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long memberCount, List<GroupMemberInfo> members, long created) {
        this(groupName, groupId, memberCount, members, created, null);
    }

    /**
     * List of group members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<GroupMemberInfo> getMembers() {
        return members;
    }

    /**
     * The group creation time as a UTC timestamp in milliseconds since the Unix
     * epoch.
     *
     * @return value for this field.
     */
    public long getCreated() {
        return created;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            members,
            created
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
            GroupFullInfo other = (GroupFullInfo) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && (this.memberCount == other.memberCount)
                && ((this.members == other.members) || (this.members.equals(other.members)))
                && (this.created == other.created)
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
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

    static final class Serializer extends StructJsonSerializer<GroupFullInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupFullInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupFullInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupFullInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupFullInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group_name", value.groupName);
            g.writeObjectField("group_id", value.groupId);
            g.writeObjectField("member_count", value.memberCount);
            g.writeObjectField("members", value.members);
            g.writeObjectField("created", value.created);
            if (value.groupExternalId != null) {
                g.writeObjectField("group_external_id", value.groupExternalId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupFullInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupFullInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupFullInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupFullInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupFullInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String groupName = null;
            String groupId = null;
            Long memberCount = null;
            List<GroupMemberInfo> members = null;
            Long created = null;
            String groupExternalId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group_name".equals(_field)) {
                    groupName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("group_id".equals(_field)) {
                    groupId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_count".equals(_field)) {
                    memberCount = _p.getLongValue();
                    assertUnsigned(_p, memberCount);
                    if (memberCount > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + memberCount);
                    }
                    _p.nextToken();
                }
                else if ("members".equals(_field)) {
                    expectArrayStart(_p);
                    members = new java.util.ArrayList<GroupMemberInfo>();
                    while (!isArrayEnd(_p)) {
                        GroupMemberInfo _x = null;
                        _x = _p.readValueAs(GroupMemberInfo.class);
                        _p.nextToken();
                        members.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("created".equals(_field)) {
                    created = _p.getLongValue();
                    assertUnsigned(_p, created);
                    _p.nextToken();
                }
                else if ("group_external_id".equals(_field)) {
                    groupExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (groupName == null) {
                throw new JsonParseException(_p, "Required field \"group_name\" is missing.");
            }
            if (groupId == null) {
                throw new JsonParseException(_p, "Required field \"group_id\" is missing.");
            }
            if (memberCount == null) {
                throw new JsonParseException(_p, "Required field \"member_count\" is missing.");
            }
            if (members == null) {
                throw new JsonParseException(_p, "Required field \"members\" is missing.");
            }
            if (created == null) {
                throw new JsonParseException(_p, "Required field \"created\" is missing.");
            }

            return new GroupFullInfo(groupName, groupId, memberCount, members, created, groupExternalId);
        }
    }
}
