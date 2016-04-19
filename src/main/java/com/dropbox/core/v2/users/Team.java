/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Information about a team.
 */
@JsonSerialize(using=Team.Serializer.class)
@JsonDeserialize(using=Team.Deserializer.class)
public class Team {
    // struct Team

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<Team> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Team.class);
        }

        public Serializer(boolean unwrapping) {
            super(Team.class, unwrapping);
        }

        @Override
        protected JsonSerializer<Team> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(Team value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("id", value.id);
            g.writeObjectField("name", value.name);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<Team> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Team.class);
        }

        public Deserializer(boolean unwrapping) {
            super(Team.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<Team> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public Team deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String id = null;
            String name = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("id".equals(_field)) {
                    id = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (id == null) {
                throw new JsonParseException(_p, "Required field \"id\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }

            return new Team(id, name);
        }
    }
}
