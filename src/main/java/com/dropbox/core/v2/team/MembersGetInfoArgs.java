/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class MembersGetInfoArgs {
    // struct MembersGetInfoArgs

    private final List<UserSelectorArg> members;

    /**
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersGetInfoArgs(List<UserSelectorArg> members) {
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (UserSelectorArg x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
    }

    /**
     * List of team members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<UserSelectorArg> getMembers() {
        return members;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MembersGetInfoArgs other = (MembersGetInfoArgs) obj;
            return (this.members == other.members) || (this.members.equals(other.members));
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

    public static MembersGetInfoArgs fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersGetInfoArgs> _JSON_WRITER = new JsonWriter<MembersGetInfoArgs>() {
        public final void write(MembersGetInfoArgs x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersGetInfoArgs._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersGetInfoArgs x, JsonGenerator g) throws IOException {
            g.writeFieldName("members");
            g.writeStartArray();
            for (UserSelectorArg item: x.members) {
                if (item != null) {
                    UserSelectorArg._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<MembersGetInfoArgs> _JSON_READER = new JsonReader<MembersGetInfoArgs>() {
        public final MembersGetInfoArgs read(JsonParser parser) throws IOException, JsonReadException {
            MembersGetInfoArgs result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersGetInfoArgs readFields(JsonParser parser) throws IOException, JsonReadException {
            List<UserSelectorArg> members = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("members".equals(fieldName)) {
                    members = JsonArrayReader.mk(UserSelectorArg._JSON_READER)
                        .readField(parser, "members", members);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (members == null) {
                throw new JsonReadException("Required field \"members\" is missing.", parser.getTokenLocation());
            }
            return new MembersGetInfoArgs(members);
        }
    };
}
