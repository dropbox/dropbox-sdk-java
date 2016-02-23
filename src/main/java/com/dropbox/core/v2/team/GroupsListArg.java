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

public class GroupsListArg {
    // struct GroupsListArg

    private final long limit;

    /**
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListArg(long limit) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     */
    public GroupsListArg() {
        this(1000L);
    }

    /**
     * Number of results to return per call.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            limit
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
            GroupsListArg other = (GroupsListArg) obj;
            return this.limit == other.limit;
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

    public static GroupsListArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupsListArg> _JSON_WRITER = new JsonWriter<GroupsListArg>() {
        public final void write(GroupsListArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupsListArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupsListArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("limit");
            g.writeNumber(x.limit);
        }
    };

    public static final JsonReader<GroupsListArg> _JSON_READER = new JsonReader<GroupsListArg>() {
        public final GroupsListArg read(JsonParser parser) throws IOException, JsonReadException {
            GroupsListArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupsListArg readFields(JsonParser parser) throws IOException, JsonReadException {
            Long limit = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("limit".equals(fieldName)) {
                    limit = JsonReader.UInt32Reader
                        .readField(parser, "limit", limit);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new GroupsListArg(limit);
        }
    };
}
