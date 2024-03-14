/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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
 * Information about a team.
 */
public class Team {
    // struct users.Team (users.stone)

    protected final String id;
    protected final String name;

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
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    /**
     * The name of the team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    public static class Serializer extends StructSerializer<Team> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Team value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Team deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Team value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_name = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new Team(f_id, f_name);
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
