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

/**
 * Profile of group member, and role in group.
 */
public class GroupMemberInfo {
    // struct team.GroupMemberInfo (team_groups.stone)

    protected final MemberProfile profile;
    protected final GroupAccessType accessType;

    /**
     * Profile of group member, and role in group.
     *
     * @param profile  Profile of group member. Must not be {@code null}.
     * @param accessType  The role that the user has in the group. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMemberInfo(MemberProfile profile, GroupAccessType accessType) {
        if (profile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = profile;
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * Profile of group member.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberProfile getProfile() {
        return profile;
    }

    /**
     * The role that the user has in the group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            profile,
            accessType
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
            GroupMemberInfo other = (GroupMemberInfo) obj;
            return ((this.profile == other.profile) || (this.profile.equals(other.profile)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
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
    static class Serializer extends StructSerializer<GroupMemberInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMemberInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("profile");
            MemberProfile.Serializer.INSTANCE.serialize(value.profile, g);
            g.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(value.accessType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupMemberInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupMemberInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MemberProfile f_profile = null;
                GroupAccessType f_accessType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("profile".equals(field)) {
                        f_profile = MemberProfile.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("access_type".equals(field)) {
                        f_accessType = GroupAccessType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_profile == null) {
                    throw new JsonParseException(p, "Required field \"profile\" missing.");
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                value = new GroupMemberInfo(f_profile, f_accessType);
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
