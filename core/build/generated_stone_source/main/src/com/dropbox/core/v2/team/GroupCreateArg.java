/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teamcommon.GroupManagementType;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

class GroupCreateArg {
    // struct team.GroupCreateArg (team_groups.stone)

    protected final String groupName;
    protected final boolean addCreatorAsOwner;
    protected final String groupExternalId;
    protected final GroupManagementType groupManagementType;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param addCreatorAsOwner  Automatically add the creator of the group.
     * @param groupExternalId  The creator of a team can associate an arbitrary
     *     external ID to the group.
     * @param groupManagementType  Whether the team can be managed by selected
     *     users, or only by team admins.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(@javax.annotation.Nonnull String groupName, boolean addCreatorAsOwner, @javax.annotation.Nullable String groupExternalId, @javax.annotation.Nullable GroupManagementType groupManagementType) {
        if (groupName == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = groupName;
        this.addCreatorAsOwner = addCreatorAsOwner;
        this.groupExternalId = groupExternalId;
        this.groupManagementType = groupManagementType;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(String groupName) {
        this(groupName, false, null, null);
    }

    /**
     * Group name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getGroupName() {
        return groupName;
    }

    /**
     * Automatically add the creator of the group.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAddCreatorAsOwner() {
        return addCreatorAsOwner;
    }

    /**
     * The creator of a team can associate an arbitrary external ID to the
     * group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getGroupExternalId() {
        return groupExternalId;
    }

    /**
     * Whether the team can be managed by selected users, or only by team
     * admins.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
     * Builder for {@link GroupCreateArg}.
     */
    public static class Builder {
        protected final String groupName;

        protected boolean addCreatorAsOwner;
        protected String groupExternalId;
        protected GroupManagementType groupManagementType;

        protected Builder(String groupName) {
            if (groupName == null) {
                throw new IllegalArgumentException("Required value for 'groupName' is null");
            }
            this.groupName = groupName;
            this.addCreatorAsOwner = false;
            this.groupExternalId = null;
            this.groupManagementType = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param addCreatorAsOwner  Automatically add the creator of the group.
         *     Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withAddCreatorAsOwner(Boolean addCreatorAsOwner) {
            if (addCreatorAsOwner != null) {
                this.addCreatorAsOwner = addCreatorAsOwner;
            }
            else {
                this.addCreatorAsOwner = false;
            }
            return this;
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
         * @param groupManagementType  Whether the team can be managed by
         *     selected users, or only by team admins.
         *
         * @return this builder
         */
        public Builder withGroupManagementType(GroupManagementType groupManagementType) {
            this.groupManagementType = groupManagementType;
            return this;
        }

        /**
         * Builds an instance of {@link GroupCreateArg} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupCreateArg}
         */
        public GroupCreateArg build() {
            return new GroupCreateArg(groupName, addCreatorAsOwner, groupExternalId, groupManagementType);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            groupName,
            addCreatorAsOwner,
            groupExternalId,
            groupManagementType
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupCreateArg other = (GroupCreateArg) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && (this.addCreatorAsOwner == other.addCreatorAsOwner)
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && ((this.groupManagementType == other.groupManagementType) || (this.groupManagementType != null && this.groupManagementType.equals(other.groupManagementType)))
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
    static class Serializer extends StructSerializer<GroupCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            g.writeFieldName("add_creator_as_owner");
            StoneSerializers.boolean_().serialize(value.addCreatorAsOwner, g);
            if (value.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupExternalId, g);
            }
            if (value.groupManagementType != null) {
                g.writeFieldName("group_management_type");
                StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).serialize(value.groupManagementType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                Boolean f_addCreatorAsOwner = false;
                String f_groupExternalId = null;
                GroupManagementType f_groupManagementType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_name".equals(field)) {
                        f_groupName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("add_creator_as_owner".equals(field)) {
                        f_addCreatorAsOwner = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("group_external_id".equals(field)) {
                        f_groupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("group_management_type".equals(field)) {
                        f_groupManagementType = StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_groupName == null) {
                    throw new JsonParseException(p, "Required field \"group_name\" missing.");
                }
                value = new GroupCreateArg(f_groupName, f_addCreatorAsOwner, f_groupExternalId, f_groupManagementType);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
