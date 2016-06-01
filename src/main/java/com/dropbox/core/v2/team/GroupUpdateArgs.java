/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class GroupUpdateArgs extends IncludeMembersArg {
    // struct GroupUpdateArgs

    protected final GroupSelector group;
    protected final String newGroupName;
    protected final String newGroupExternalId;

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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupUpdateArgs(GroupSelector group, boolean returnMembers, String newGroupName, String newGroupExternalId) {
        super(returnMembers);
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        this.newGroupName = newGroupName;
        this.newGroupExternalId = newGroupExternalId;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupUpdateArgs(GroupSelector group) {
        this(group, true, null, null);
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
     * Optional argument. Set group name to this if provided.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewGroupName() {
        return newGroupName;
    }

    /**
     * Optional argument. New group external ID. If the argument is None, the
     * group's external_id won't be updated. If the argument is empty string,
     * the group's external id will be cleared.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewGroupExternalId() {
        return newGroupExternalId;
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
     * Builder for {@link GroupUpdateArgs}.
     */
    public static class Builder {
        protected final GroupSelector group;

        protected boolean returnMembers;
        protected String newGroupName;
        protected String newGroupExternalId;

        protected Builder(GroupSelector group) {
            if (group == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = group;
            this.returnMembers = true;
            this.newGroupName = null;
            this.newGroupExternalId = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param returnMembers  Whether to return the list of members in the
         *     group.  Note that the default value will cause all the group
         *     members  to be returned in the response. This may take a long
         *     time for large groups. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withReturnMembers(Boolean returnMembers) {
            if (returnMembers != null) {
                this.returnMembers = returnMembers;
            }
            else {
                this.returnMembers = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGroupName  Optional argument. Set group name to this if
         *     provided.
         *
         * @return this builder
         */
        public Builder withNewGroupName(String newGroupName) {
            this.newGroupName = newGroupName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGroupExternalId  Optional argument. New group external ID.
         *     If the argument is None, the group's external_id won't be
         *     updated. If the argument is empty string, the group's external id
         *     will be cleared.
         *
         * @return this builder
         */
        public Builder withNewGroupExternalId(String newGroupExternalId) {
            this.newGroupExternalId = newGroupExternalId;
            return this;
        }

        /**
         * Builds an instance of {@link GroupUpdateArgs} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupUpdateArgs}
         */
        public GroupUpdateArgs build() {
            return new GroupUpdateArgs(group, returnMembers, newGroupName, newGroupExternalId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            newGroupName,
            newGroupExternalId
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
            GroupUpdateArgs other = (GroupUpdateArgs) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && (this.returnMembers == other.returnMembers)
                && ((this.newGroupName == other.newGroupName) || (this.newGroupName != null && this.newGroupName.equals(other.newGroupName)))
                && ((this.newGroupExternalId == other.newGroupExternalId) || (this.newGroupExternalId != null && this.newGroupExternalId.equals(other.newGroupExternalId)))
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
    static final class Serializer extends StructSerializer<GroupUpdateArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupUpdateArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupUpdateArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupUpdateArgs value;
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
                    else {
                        skipValue(p);
                    }
                }
                if (f_group == null) {
                    throw new JsonParseException(p, "Required field \"group\" missing.");
                }
                value = new GroupUpdateArgs(f_group, f_returnMembers, f_newGroupName, f_newGroupExternalId);
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
