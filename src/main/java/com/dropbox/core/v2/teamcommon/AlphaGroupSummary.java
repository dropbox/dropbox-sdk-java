/* DO NOT EDIT */
/* This file was generated from team_common.stone */

package com.dropbox.core.v2.teamcommon;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Information about a group.
 */
public class AlphaGroupSummary extends GroupSummary {
    // struct AlphaGroupSummary

    protected final GroupManagementType groupManagementType;

    /**
     * Information about a group.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupManagementType  Who is allowed to manage the group. Must not
     *     be {@code null}.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     * @param memberCount  The number of members in the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupSummary(String groupName, String groupId, GroupManagementType groupManagementType, String groupExternalId, Long memberCount) {
        super(groupName, groupId, groupExternalId, memberCount);
        if (groupManagementType == null) {
            throw new IllegalArgumentException("Required value for 'groupManagementType' is null");
        }
        this.groupManagementType = groupManagementType;
    }

    /**
     * Information about a group.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupManagementType  Who is allowed to manage the group. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupSummary(String groupName, String groupId, GroupManagementType groupManagementType) {
        this(groupName, groupId, groupManagementType, null, null);
    }

    /**
     * Who is allowed to manage the group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupManagementType getGroupManagementType() {
        return groupManagementType;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupManagementType  Who is allowed to manage the group. Must not
     *     be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName, String groupId, GroupManagementType groupManagementType) {
        return new Builder(groupName, groupId, groupManagementType);
    }

    /**
     * Builder for {@link AlphaGroupSummary}.
     */
    public static class Builder extends GroupSummary.Builder {
        protected final GroupManagementType groupManagementType;

        protected Builder(String groupName, String groupId, GroupManagementType groupManagementType) {
            super(groupName, groupId);
            if (groupManagementType == null) {
                throw new IllegalArgumentException("Required value for 'groupManagementType' is null");
            }
            this.groupManagementType = groupManagementType;
        }

        /**
         * Set value for optional field.
         *
         * @param groupExternalId  External ID of group. This is an arbitrary ID
         *     that an admin can attach to a group.
         *
         * @return this builder
         */
        public Builder withGroupExternalId(String groupExternalId) {
            super.withGroupExternalId(groupExternalId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberCount  The number of members in the group.
         *
         * @return this builder
         */
        public Builder withMemberCount(Long memberCount) {
            super.withMemberCount(memberCount);
            return this;
        }

        /**
         * Builds an instance of {@link AlphaGroupSummary} configured with this
         * builder's values
         *
         * @return new instance of {@link AlphaGroupSummary}
         */
        public AlphaGroupSummary build() {
            return new AlphaGroupSummary(groupName, groupId, groupManagementType, groupExternalId, memberCount);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupManagementType
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
            AlphaGroupSummary other = (AlphaGroupSummary) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && ((this.groupManagementType == other.groupManagementType) || (this.groupManagementType.equals(other.groupManagementType)))
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
    public static final class Serializer extends StructSerializer<AlphaGroupSummary> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGroupSummary value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            g.writeFieldName("group_id");
            StoneSerializers.string().serialize(value.groupId, g);
            g.writeFieldName("group_management_type");
            GroupManagementType.Serializer.INSTANCE.serialize(value.groupManagementType, g);
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
        public AlphaGroupSummary deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AlphaGroupSummary value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                String f_groupId = null;
                GroupManagementType f_groupManagementType = null;
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
                    else if ("group_management_type".equals(field)) {
                        f_groupManagementType = GroupManagementType.Serializer.INSTANCE.deserialize(p);
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
                if (f_groupManagementType == null) {
                    throw new JsonParseException(p, "Required field \"group_management_type\" missing.");
                }
                value = new AlphaGroupSummary(f_groupName, f_groupId, f_groupManagementType, f_groupExternalId, f_memberCount);
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
