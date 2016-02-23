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
public class MembersUnsuspendArg {
    // struct MembersUnsuspendArg

    private final UserSelectorArg user;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user to unsuspend. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersUnsuspendArg(UserSelectorArg user) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
    }

    /**
     * Identity of user to unsuspend.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user
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
            MembersUnsuspendArg other = (MembersUnsuspendArg) obj;
            return (this.user == other.user) || (this.user.equals(other.user));
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

    public static MembersUnsuspendArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersUnsuspendArg> _JSON_WRITER = new JsonWriter<MembersUnsuspendArg>() {
        public final void write(MembersUnsuspendArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersUnsuspendArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersUnsuspendArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
        }
    };

    public static final JsonReader<MembersUnsuspendArg> _JSON_READER = new JsonReader<MembersUnsuspendArg>() {
        public final MembersUnsuspendArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersUnsuspendArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersUnsuspendArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new MembersUnsuspendArg(user);
        }
    };
}
