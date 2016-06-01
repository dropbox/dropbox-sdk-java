/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.GroupSummary;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Full description of a group.
 */
public class GroupFullInfo extends GroupSummary {
    // struct GroupFullInfo

    protected final List<GroupMemberInfo> members;
    protected final long created;

    /**
     * Full description of a group.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     * @param memberCount  The number of members in the group.
     * @param members  List of group members. Must not contain a {@code null}
     *     item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long created, String groupExternalId, Long memberCount, List<GroupMemberInfo> members) {
        super(groupName, groupId, groupExternalId, memberCount);
        if (members != null) {
            for (GroupMemberInfo x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
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
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo(String groupName, String groupId, long created) {
        this(groupName, groupId, created, null, null, null);
    }

    /**
     * List of group members.
     *
     * @return value for this field, or {@code null} if not present.
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

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param created  The group creation time as a UTC timestamp in
     *     milliseconds since the Unix epoch.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName, String groupId, long created) {
        return new Builder(groupName, groupId, created);
    }

    /**
     * Builder for {@link GroupFullInfo}.
     */
    public static class Builder extends GroupSummary.Builder {
        protected final long created;

        protected List<GroupMemberInfo> members;

        protected Builder(String groupName, String groupId, long created) {
            super(groupName, groupId);
            this.created = created;
            this.members = null;
        }

        /**
         * Set value for optional field.
         *
         * @param members  List of group members. Must not contain a {@code
         *     null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMembers(List<GroupMemberInfo> members) {
            if (members != null) {
                for (GroupMemberInfo x : members) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'members' is null");
                    }
                }
            }
            this.members = members;
            return this;
        }

        /**
         * Builds an instance of {@link GroupFullInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupFullInfo}
         */
        public GroupFullInfo build() {
            return new GroupFullInfo(groupName, groupId, created, groupExternalId, memberCount, members);
        }
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
                && (this.created == other.created)
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && ((this.memberCount == other.memberCount) || (this.memberCount != null && this.memberCount.equals(other.memberCount)))
                && ((this.members == other.members) || (this.members != null && this.members.equals(other.members)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static final class Serializer extends StructSerializer<GroupFullInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupFullInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            g.writeFieldName("group_id");
            StoneSerializers.string().serialize(value.groupId, g);
            g.writeFieldName("created");
            StoneSerializers.uInt64().serialize(value.created, g);
            if (value.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupExternalId, g);
            }
            if (value.memberCount != null) {
                g.writeFieldName("member_count");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(value.memberCount, g);
            }
            if (value.members != null) {
                g.writeFieldName("members");
                StoneSerializers.nullable(StoneSerializers.list(GroupMemberInfo.Serializer.INSTANCE)).serialize(value.members, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupFullInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupFullInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                String f_groupId = null;
                Long f_created = null;
                String f_groupExternalId = null;
                Long f_memberCount = null;
                List<GroupMemberInfo> f_members = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_name".equals(field)) {
                        f_groupName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_id".equals(field)) {
                        f_groupId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("group_external_id".equals(field)) {
                        f_groupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_count".equals(field)) {
                        f_memberCount = StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(p);
                    }
                    else if ("members".equals(field)) {
                        f_members = StoneSerializers.nullable(StoneSerializers.list(GroupMemberInfo.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_groupName == null) {
                    throw new JsonParseException(p, "Required field \"group_name\" missing.");
                }
                if (f_groupId == null) {
                    throw new JsonParseException(p, "Required field \"group_id\" missing.");
                }
                if (f_created == null) {
                    throw new JsonParseException(p, "Required field \"created\" missing.");
                }
                value = new GroupFullInfo(f_groupName, f_groupId, f_created, f_groupExternalId, f_memberCount, f_members);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
