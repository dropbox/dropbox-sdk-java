/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.teampolicies.TeamSharingPolicies;

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
 * Detailed information about a team.
 */
@JsonSerialize(using=FullTeam.Serializer.class)
@JsonDeserialize(using=FullTeam.Deserializer.class)
public class FullTeam extends Team {
    // struct FullTeam

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final TeamSharingPolicies sharingPolicies;

    /**
     * Detailed information about a team.
     *
     * @param id  The team's unique ID. Must not be {@code null}.
     * @param name  The name of the team. Must not be {@code null}.
     * @param sharingPolicies  Team policies governing sharing. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FullTeam(String id, String name, TeamSharingPolicies sharingPolicies) {
        super(id, name);
        if (sharingPolicies == null) {
            throw new IllegalArgumentException("Required value for 'sharingPolicies' is null");
        }
        this.sharingPolicies = sharingPolicies;
    }

    /**
     * Team policies governing sharing.
     *
     * @return value for this field, never {@code null}.
     */
    public TeamSharingPolicies getSharingPolicies() {
        return sharingPolicies;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharingPolicies
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FullTeam other = (FullTeam) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.sharingPolicies == other.sharingPolicies) || (this.sharingPolicies.equals(other.sharingPolicies)))
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

    static final class Serializer extends StructJsonSerializer<FullTeam> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FullTeam.class);
        }

        public Serializer(boolean unwrapping) {
            super(FullTeam.class, unwrapping);
        }

        @Override
        protected JsonSerializer<FullTeam> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(FullTeam value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("id", value.id);
            g.writeObjectField("name", value.name);
            g.writeObjectField("sharing_policies", value.sharingPolicies);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FullTeam> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FullTeam.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FullTeam.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FullTeam> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FullTeam deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String id = null;
            String name = null;
            TeamSharingPolicies sharingPolicies = null;

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
                else if ("sharing_policies".equals(_field)) {
                    sharingPolicies = _p.readValueAs(TeamSharingPolicies.class);
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
            if (sharingPolicies == null) {
                throw new JsonParseException(_p, "Required field \"sharing_policies\" is missing.");
            }

            return new FullTeam(id, name, sharingPolicies);
        }
    }
}
