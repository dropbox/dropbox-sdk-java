/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Information about a team.
 */
public class Team {
    // struct Team

    private final String id;
    private final String name;

    /**
     * Information about a team.
     *
     * @param id  The team's unique ID. Must not be {@code null}.
     * @param name  The name of the team. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Team(String id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        this.id = id;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
    }

    /**
     * The team's unique ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * The name of the team.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            id,
            name
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
            Team other = (Team) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
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

    public static Team fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Team> _JSON_WRITER = new JsonWriter<Team>() {
        public final void write(Team x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Team._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(Team x, JsonGenerator g) throws IOException {
            g.writeFieldName("id");
            g.writeString(x.id);
            g.writeFieldName("name");
            g.writeString(x.name);
        }
    };

    public static final JsonReader<Team> _JSON_READER = new JsonReader<Team>() {
        public final Team read(JsonParser parser) throws IOException, JsonReadException {
            Team result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final Team readFields(JsonParser parser) throws IOException, JsonReadException {
            String id = null;
            String name = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("id".equals(fieldName)) {
                    id = JsonReader.StringReader
                        .readField(parser, "id", id);
                }
                else if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (id == null) {
                throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            return new Team(id, name);
        }
    };
}
