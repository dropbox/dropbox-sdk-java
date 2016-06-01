/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.GroupManagementType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class AlphaGroupCreateArg extends GroupCreateArg {
    // struct AlphaGroupCreateArg

    protected final GroupManagementType groupManagementType;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param groupExternalId  The creator of a team can associate an arbitrary
     *     external ID to the group.
     * @param groupManagementType  Whether the team can be managed by selected
     *     users, or only by team admins.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupCreateArg(String groupName, String groupExternalId, GroupManagementType groupManagementType) {
        super(groupName, groupExternalId);
        if (groupManagementType == null) {
            throw new IllegalArgumentException("Required value for 'groupManagementType' is null");
        }
        this.groupManagementType = groupManagementType;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupCreateArg(String groupName) {
        this(groupName, null, GroupManagementType.COMPANY_MANAGED);
    }

    /**
     * Whether the team can be managed by selected users, or only by team admins
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     GroupManagementType.COMPANY_MANAGED.
     */
    public GroupManagementType getGroupManagementType() {
        return groupManagementType;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName) {
        return new Builder(groupName);
    }

    /**
     * Builder for {@link AlphaGroupCreateArg}.
     */
    public static class Builder {
        protected final String groupName;

        protected String groupExternalId;
        protected GroupManagementType groupManagementType;

        protected Builder(String groupName) {
            if (groupName == null) {
                throw new IllegalArgumentException("Required value for 'groupName' is null");
            }
            this.groupName = groupName;
            this.groupExternalId = null;
            this.groupManagementType = GroupManagementType.COMPANY_MANAGED;
        }

        /**
         * Set value for optional field.
         *
         * @param groupExternalId  The creator of a team can associate an
         *     arbitrary external ID to the group.
         *
         * @return this builder
         */
        public Builder withGroupExternalId(String groupExternalId) {
            this.groupExternalId = groupExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * GroupManagementType.COMPANY_MANAGED}. </p>
         *
         * @param groupManagementType  Whether the team can be managed by
         *     selected users, or only by team admins. Defaults to {@code
         *     GroupManagementType.COMPANY_MANAGED} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withGroupManagementType(GroupManagementType groupManagementType) {
            if (groupManagementType != null) {
                this.groupManagementType = groupManagementType;
            }
            else {
                this.groupManagementType = GroupManagementType.COMPANY_MANAGED;
            }
            return this;
        }

        /**
         * Builds an instance of {@link AlphaGroupCreateArg} configured with
         * this builder's values
         *
         * @return new instance of {@link AlphaGroupCreateArg}
         */
        public AlphaGroupCreateArg build() {
            return new AlphaGroupCreateArg(groupName, groupExternalId, groupManagementType);
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
            AlphaGroupCreateArg other = (AlphaGroupCreateArg) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && ((this.groupManagementType == other.groupManagementType) || (this.groupManagementType.equals(other.groupManagementType)))
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
    static final class Serializer extends StructSerializer<AlphaGroupCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGroupCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            if (value.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupExternalId, g);
            }
            g.writeFieldName("group_management_type");
            GroupManagementType.Serializer.INSTANCE.serialize(value.groupManagementType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AlphaGroupCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AlphaGroupCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                String f_groupExternalId = null;
                GroupManagementType f_groupManagementType = GroupManagementType.COMPANY_MANAGED;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_name".equals(field)) {
                        f_groupName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_external_id".equals(field)) {
                        f_groupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("group_management_type".equals(field)) {
                        f_groupManagementType = GroupManagementType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_groupName == null) {
                    throw new JsonParseException(p, "Required field \"group_name\" missing.");
                }
                value = new AlphaGroupCreateArg(f_groupName, f_groupExternalId, f_groupManagementType);
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
