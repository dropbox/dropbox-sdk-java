/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Exactly one of team_member_id, email, or external_id must be provided to
 * identify the user account.
 */
public class MembersSetPermissionsArg {
    // struct MembersSetPermissionsArg

    private final UserSelectorArg user;
    private final AdminTier newRole;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRole  The new role of the member. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsArg(UserSelectorArg user, AdminTier newRole) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (newRole == null) {
            throw new IllegalArgumentException("Required value for 'newRole' is null");
        }
        this.newRole = newRole;
    }

    /**
     * Identity of user whose role will be set.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * The new role of the member.
     *
     * @return value for this field, never {@code null}.
     */
    public AdminTier getNewRole() {
        return newRole;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
            newRole
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
            MembersSetPermissionsArg other = (MembersSetPermissionsArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.newRole == other.newRole) || (this.newRole.equals(other.newRole)))
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

    public static MembersSetPermissionsArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSetPermissionsArg> _JSON_WRITER = new JsonWriter<MembersSetPermissionsArg>() {
        public final void write(MembersSetPermissionsArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersSetPermissionsArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersSetPermissionsArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
            g.writeFieldName("new_role");
            AdminTier._JSON_WRITER.write(x.newRole, g);
        }
    };

    public static final JsonReader<MembersSetPermissionsArg> _JSON_READER = new JsonReader<MembersSetPermissionsArg>() {
        public final MembersSetPermissionsArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersSetPermissionsArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersSetPermissionsArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            AdminTier newRole = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("new_role".equals(fieldName)) {
                    newRole = AdminTier._JSON_READER
                        .readField(parser, "new_role", newRole);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            if (newRole == null) {
                throw new JsonReadException("Required field \"new_role\" is missing.", parser.getTokenLocation());
            }
            return new MembersSetPermissionsArg(user, newRole);
        }
    };
}
