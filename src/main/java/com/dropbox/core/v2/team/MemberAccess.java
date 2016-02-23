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
 * Specify access type a member should have when joined to a group.
 */
public class MemberAccess {
    // struct MemberAccess

    private final UserSelectorArg user;
    private final GroupAccessType accessType;

    /**
     * Specify access type a member should have when joined to a group.
     *
     * @param user  Identity of a user. Must not be {@code null}.
     * @param accessType  Access type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAccess(UserSelectorArg user, GroupAccessType accessType) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * Identity of a user.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * Access type.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
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
            MemberAccess other = (MemberAccess) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
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

    public static MemberAccess fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberAccess> _JSON_WRITER = new JsonWriter<MemberAccess>() {
        public final void write(MemberAccess x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberAccess._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MemberAccess x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
            g.writeFieldName("access_type");
            GroupAccessType._JSON_WRITER.write(x.accessType, g);
        }
    };

    public static final JsonReader<MemberAccess> _JSON_READER = new JsonReader<MemberAccess>() {
        public final MemberAccess read(JsonParser parser) throws IOException, JsonReadException {
            MemberAccess result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MemberAccess readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            GroupAccessType accessType = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("access_type".equals(fieldName)) {
                    accessType = GroupAccessType._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            return new MemberAccess(user, accessType);
        }
    };
}
