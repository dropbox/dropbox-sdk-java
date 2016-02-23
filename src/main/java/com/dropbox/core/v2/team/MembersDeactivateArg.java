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
public class MembersDeactivateArg {
    // struct MembersDeactivateArg

    private final UserSelectorArg user;
    private final boolean wipeData;

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user, boolean wipeData) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        this.wipeData = wipeData;
    }

    /**
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersDeactivateArg(UserSelectorArg user) {
        this(user, true);
    }

    /**
     * Identity of user to remove/suspend.
     *
     * @return value for this field, never {@code null}.
     */
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * If provided, controls if the user's data will be deleted on their linked
     * devices.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getWipeData() {
        return wipeData;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user,
            wipeData
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
            MembersDeactivateArg other = (MembersDeactivateArg) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && (this.wipeData == other.wipeData)
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

    public static MembersDeactivateArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersDeactivateArg> _JSON_WRITER = new JsonWriter<MembersDeactivateArg>() {
        public final void write(MembersDeactivateArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersDeactivateArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersDeactivateArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("user");
            UserSelectorArg._JSON_WRITER.write(x.user, g);
            g.writeFieldName("wipe_data");
            g.writeBoolean(x.wipeData);
        }
    };

    public static final JsonReader<MembersDeactivateArg> _JSON_READER = new JsonReader<MembersDeactivateArg>() {
        public final MembersDeactivateArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersDeactivateArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersDeactivateArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UserSelectorArg user = null;
            Boolean wipeData = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("user".equals(fieldName)) {
                    user = UserSelectorArg._JSON_READER
                        .readField(parser, "user", user);
                }
                else if ("wipe_data".equals(fieldName)) {
                    wipeData = JsonReader.BooleanReader
                        .readField(parser, "wipe_data", wipeData);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (user == null) {
                throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
            }
            return new MembersDeactivateArg(user, wipeData);
        }
    };
}
