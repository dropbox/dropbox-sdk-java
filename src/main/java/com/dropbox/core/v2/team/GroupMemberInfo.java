/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Profile of group member, and role in group.
 */
public class GroupMemberInfo {
    // struct GroupMemberInfo

    private final MemberProfile profile;
    private final GroupAccessType accessType;

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
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupMemberInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupMemberInfo> _JSON_WRITER = new JsonWriter<GroupMemberInfo>() {
        public final void write(GroupMemberInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupMemberInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupMemberInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("profile");
            MemberProfile._JSON_WRITER.write(x.profile, g);
            g.writeFieldName("access_type");
            GroupAccessType._JSON_WRITER.write(x.accessType, g);
        }
    };

    public static final JsonReader<GroupMemberInfo> _JSON_READER = new JsonReader<GroupMemberInfo>() {
        public final GroupMemberInfo read(JsonParser parser) throws IOException, JsonReadException {
            GroupMemberInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupMemberInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            MemberProfile profile = null;
            GroupAccessType accessType = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("profile".equals(fieldName)) {
                    profile = MemberProfile._JSON_READER
                        .readField(parser, "profile", profile);
                }
                else if ("access_type".equals(fieldName)) {
                    accessType = GroupAccessType._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (profile == null) {
                throw new JsonReadException("Required field \"profile\" is missing.", parser.getTokenLocation());
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            return new GroupMemberInfo(profile, accessType);
        }
    };
}
