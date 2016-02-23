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

public class MembersAddArg {
    // struct MembersAddArg

    private final List<MemberAddArg> newMembers;
    private final boolean forceAsync;

    /**
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddArg(List<MemberAddArg> newMembers, boolean forceAsync) {
        if (newMembers == null) {
            throw new IllegalArgumentException("Required value for 'newMembers' is null");
        }
        for (MemberAddArg x : newMembers) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'newMembers' is null");
            }
        }
        this.newMembers = newMembers;
        this.forceAsync = forceAsync;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddArg(List<MemberAddArg> newMembers) {
        this(newMembers, false);
    }

    /**
     * Details of new members to be added to the team.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberAddArg> getNewMembers() {
        return newMembers;
    }

    /**
     * Whether to force the add to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
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
            MembersAddArg other = (MembersAddArg) obj;
            return ((this.newMembers == other.newMembers) || (this.newMembers.equals(other.newMembers)))
                && (this.forceAsync == other.forceAsync)
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

    public static MembersAddArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersAddArg> _JSON_WRITER = new JsonWriter<MembersAddArg>() {
        public final void write(MembersAddArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MembersAddArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MembersAddArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("new_members");
            g.writeStartArray();
            for (MemberAddArg item: x.newMembers) {
                if (item != null) {
                    MemberAddArg._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("force_async");
            g.writeBoolean(x.forceAsync);
        }
    };

    public static final JsonReader<MembersAddArg> _JSON_READER = new JsonReader<MembersAddArg>() {
        public final MembersAddArg read(JsonParser parser) throws IOException, JsonReadException {
            MembersAddArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MembersAddArg readFields(JsonParser parser) throws IOException, JsonReadException {
            List<MemberAddArg> newMembers = null;
            Boolean forceAsync = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("new_members".equals(fieldName)) {
                    newMembers = JsonArrayReader.mk(MemberAddArg._JSON_READER)
                        .readField(parser, "new_members", newMembers);
                }
                else if ("force_async".equals(fieldName)) {
                    forceAsync = JsonReader.BooleanReader
                        .readField(parser, "force_async", forceAsync);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (newMembers == null) {
                throw new JsonReadException("Required field \"new_members\" is missing.", parser.getTokenLocation());
            }
            return new MembersAddArg(newMembers, forceAsync);
        }
    };
}
