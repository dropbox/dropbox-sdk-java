/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

class GroupMembersSetAccessTypeArg extends GroupMemberSelector {
    // struct team.GroupMembersSetAccessTypeArg (team_groups.stone)

    @Nonnull
    protected final GroupAccessType accessType;
    protected final boolean returnMembers;

    /**
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of the {@code group}
     *     argument to {@link
     *     DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}.
     *     Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSetAccessTypeArg(@Nonnull GroupSelector group, @Nonnull UserSelectorArg user, @Nonnull GroupAccessType accessType, boolean returnMembers) {
        super(group, user);
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
        this.returnMembers = returnMembers;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of the {@code group}
     *     argument to {@link
     *     DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}.
     *     Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersSetAccessTypeArg(@Nonnull GroupSelector group, @Nonnull UserSelectorArg user, @Nonnull GroupAccessType accessType) {
        this(group, user, accessType, true);
    }

    /**
     * Specify a group.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * Identity of a user that is a member of the {@code group} argument to
     * {@link
     * DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * New group access type the user will have.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public GroupAccessType getAccessType() {
        return accessType;
    }

    /**
     * Whether to return the list of members in the group.  Note that the
     * default value will cause all the group members  to be returned in the
     * response. This may take a long time for large groups.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getReturnMembers() {
        return returnMembers;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accessType,
            returnMembers
        });
        hash = (31 * super.hashCode()) + hash;
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
            GroupMembersSetAccessTypeArg other = (GroupMembersSetAccessTypeArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.returnMembers == other.returnMembers)
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
    static class Serializer extends StructSerializer<GroupMembersSetAccessTypeArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersSetAccessTypeArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(value.group, g);
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(value.returnMembers, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupMembersSetAccessTypeArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupMembersSetAccessTypeArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupSelector f_group = null;
                UserSelectorArg f_user = null;
                GroupAccessType f_accessType = null;
                Boolean f_returnMembers = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group".equals(field)) {
                        f_group = GroupSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("access_type".equals(field)) {
                        f_accessType = GroupAccessType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("return_members".equals(field)) {
                        f_returnMembers = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_group == null) {
                    throw new JsonParseException(p, "Required field \"group\" missing.");
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                value = new GroupMembersSetAccessTypeArg(f_group, f_user, f_accessType, f_returnMembers);
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
