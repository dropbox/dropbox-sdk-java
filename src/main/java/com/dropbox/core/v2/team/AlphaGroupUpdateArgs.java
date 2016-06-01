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

public class AlphaGroupUpdateArgs extends GroupUpdateArgs {
    // struct AlphaGroupUpdateArgs

    protected final GroupManagementType newGroupManagementType;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     * @param newGroupName  Optional argument. Set group name to this if
     *     provided.
     * @param newGroupExternalId  Optional argument. New group external ID. If
     *     the argument is None, the group's external_id won't be updated. If
     *     the argument is empty string, the group's external id will be
     *     cleared.
     * @param newGroupManagementType  Set new group management type, if
     *     provided.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupUpdateArgs(GroupSelector group, boolean returnMembers, String newGroupName, String newGroupExternalId, GroupManagementType newGroupManagementType) {
        super(group, returnMembers, newGroupName, newGroupExternalId);
        this.newGroupManagementType = newGroupManagementType;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaGroupUpdateArgs(GroupSelector group) {
        this(group, true, null, null, null);
    }

    /**
     * Set new group management type, if provided.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public GroupManagementType getNewGroupManagementType() {
        return newGroupManagementType;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(GroupSelector group) {
        return new Builder(group);
    }

    /**
     * Builder for {@link AlphaGroupUpdateArgs}.
     */
    public static class Builder extends GroupUpdateArgs.Builder {

        protected GroupManagementType newGroupManagementType;

        protected Builder(GroupSelector group) {
            super(group);
            this.newGroupManagementType = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newGroupManagementType  Set new group management type, if
         *     provided.
         *
         * @return this builder
         */
        public Builder withNewGroupManagementType(GroupManagementType newGroupManagementType) {
            this.newGroupManagementType = newGroupManagementType;
            return this;
        }

        /**
         * Builds an instance of {@link AlphaGroupUpdateArgs} configured with
         * this builder's values
         *
         * @return new instance of {@link AlphaGroupUpdateArgs}
         */
        public AlphaGroupUpdateArgs build() {
            return new AlphaGroupUpdateArgs(group, returnMembers, newGroupName, newGroupExternalId, newGroupManagementType);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            newGroupManagementType
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
            AlphaGroupUpdateArgs other = (AlphaGroupUpdateArgs) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && (this.returnMembers == other.returnMembers)
                && ((this.newGroupName == other.newGroupName) || (this.newGroupName != null && this.newGroupName.equals(other.newGroupName)))
                && ((this.newGroupExternalId == other.newGroupExternalId) || (this.newGroupExternalId != null && this.newGroupExternalId.equals(other.newGroupExternalId)))
                && ((this.newGroupManagementType == other.newGroupManagementType) || (this.newGroupManagementType != null && this.newGroupManagementType.equals(other.newGroupManagementType)))
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
    static final class Serializer extends StructSerializer<AlphaGroupUpdateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGroupUpdateArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(value.group, g);
            g.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(value.returnMembers, g);
            if (value.newGroupName != null) {
                g.writeFieldName("new_group_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newGroupName, g);
            }
            if (value.newGroupExternalId != null) {
                g.writeFieldName("new_group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newGroupExternalId, g);
            }
            if (value.newGroupManagementType != null) {
                g.writeFieldName("new_group_management_type");
                StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).serialize(value.newGroupManagementType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AlphaGroupUpdateArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AlphaGroupUpdateArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupSelector f_group = null;
                Boolean f_returnMembers = true;
                String f_newGroupName = null;
                String f_newGroupExternalId = null;
                GroupManagementType f_newGroupManagementType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group".equals(field)) {
                        f_group = GroupSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("return_members".equals(field)) {
                        f_returnMembers = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("new_group_name".equals(field)) {
                        f_newGroupName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_group_external_id".equals(field)) {
                        f_newGroupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_group_management_type".equals(field)) {
                        f_newGroupManagementType = StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_group == null) {
                    throw new JsonParseException(p, "Required field \"group\" missing.");
                }
                value = new AlphaGroupUpdateArgs(f_group, f_returnMembers, f_newGroupName, f_newGroupExternalId, f_newGroupManagementType);
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
