/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.GroupSummary;
import com.dropbox.core.v2.teamcommon.GroupType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * The information about a group. Groups is a way to manage a list of users  who
 * need same access permission to the shared folder.
 */
public class GroupInfo extends GroupSummary {
    // struct GroupInfo

    protected final GroupType groupType;
    protected final boolean isOwner;
    protected final boolean sameTeam;

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param isOwner  If the current user is an owner of the group.
     * @param sameTeam  If the group is owned by the current user's team.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     * @param memberCount  The number of members in the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, GroupType groupType, boolean isOwner, boolean sameTeam, String groupExternalId, Long memberCount) {
        super(groupName, groupId, groupExternalId, memberCount);
        if (groupType == null) {
            throw new IllegalArgumentException("Required value for 'groupType' is null");
        }
        this.groupType = groupType;
        this.isOwner = isOwner;
        this.sameTeam = sameTeam;
    }

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param isOwner  If the current user is an owner of the group.
     * @param sameTeam  If the group is owned by the current user's team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, GroupType groupType, boolean isOwner, boolean sameTeam) {
        this(groupName, groupId, groupType, isOwner, sameTeam, null, null);
    }

    /**
     * The type of group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupType getGroupType() {
        return groupType;
    }

    /**
     * If the current user is an owner of the group.
     *
     * @return value for this field.
     */
    public boolean getIsOwner() {
        return isOwner;
    }

    /**
     * If the group is owned by the current user's team.
     *
     * @return value for this field.
     */
    public boolean getSameTeam() {
        return sameTeam;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param isOwner  If the current user is an owner of the group.
     * @param sameTeam  If the group is owned by the current user's team.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName, String groupId, GroupType groupType, boolean isOwner, boolean sameTeam) {
        return new Builder(groupName, groupId, groupType, isOwner, sameTeam);
    }

    /**
     * Builder for {@link GroupInfo}.
     */
    public static class Builder extends GroupSummary.Builder {
        protected final GroupType groupType;
        protected final boolean isOwner;
        protected final boolean sameTeam;

        protected Builder(String groupName, String groupId, GroupType groupType, boolean isOwner, boolean sameTeam) {
            super(groupName, groupId);
            if (groupType == null) {
                throw new IllegalArgumentException("Required value for 'groupType' is null");
            }
            this.groupType = groupType;
            this.isOwner = isOwner;
            this.sameTeam = sameTeam;
        }

        /**
         * Builds an instance of {@link GroupInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupInfo}
         */
        public GroupInfo build() {
            return new GroupInfo(groupName, groupId, groupType, isOwner, sameTeam, groupExternalId, memberCount);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupType,
            isOwner,
            sameTeam
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
            GroupInfo other = (GroupInfo) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && ((this.groupType == other.groupType) || (this.groupType.equals(other.groupType)))
                && (this.isOwner == other.isOwner)
                && (this.sameTeam == other.sameTeam)
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && ((this.memberCount == other.memberCount) || (this.memberCount != null && this.memberCount.equals(other.memberCount)))
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
    static final class Serializer extends StructSerializer<GroupInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            g.writeFieldName("group_id");
            StoneSerializers.string().serialize(value.groupId, g);
            g.writeFieldName("group_type");
            GroupType.Serializer.INSTANCE.serialize(value.groupType, g);
            g.writeFieldName("is_owner");
            StoneSerializers.boolean_().serialize(value.isOwner, g);
            g.writeFieldName("same_team");
            StoneSerializers.boolean_().serialize(value.sameTeam, g);
            if (value.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupExternalId, g);
            }
            if (value.memberCount != null) {
                g.writeFieldName("member_count");
                StoneSerializers.nullable(StoneSerializers.uInt32()).serialize(value.memberCount, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                String f_groupId = null;
                GroupType f_groupType = null;
                Boolean f_isOwner = null;
                Boolean f_sameTeam = null;
                String f_groupExternalId = null;
                Long f_memberCount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_name".equals(field)) {
                        f_groupName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_id".equals(field)) {
                        f_groupId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_type".equals(field)) {
                        f_groupType = GroupType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_owner".equals(field)) {
                        f_isOwner = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("same_team".equals(field)) {
                        f_sameTeam = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("group_external_id".equals(field)) {
                        f_groupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_count".equals(field)) {
                        f_memberCount = StoneSerializers.nullable(StoneSerializers.uInt32()).deserialize(p);
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
                if (f_groupType == null) {
                    throw new JsonParseException(p, "Required field \"group_type\" missing.");
                }
                if (f_isOwner == null) {
                    throw new JsonParseException(p, "Required field \"is_owner\" missing.");
                }
                if (f_sameTeam == null) {
                    throw new JsonParseException(p, "Required field \"same_team\" missing.");
                }
                value = new GroupInfo(f_groupName, f_groupId, f_groupType, f_isOwner, f_sameTeam, f_groupExternalId, f_memberCount);
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
