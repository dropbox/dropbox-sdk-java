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

@JsonSerialize(using=TeamSpaceAllocation.Serializer.class)
@JsonDeserialize(using=TeamSpaceAllocation.Deserializer.class)
public class TeamSpaceAllocation {
    // struct TeamSpaceAllocation

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long used;
    protected final long allocated;

    /**
     *
     * @param used  The total space currently used by the user's team (bytes).
     * @param allocated  The total space allocated to the user's team (bytes).
     */
    public TeamSpaceAllocation(long used, long allocated) {
        this.used = used;
        this.allocated = allocated;
    }

    /**
     * The total space currently used by the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The total space allocated to the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            used,
            allocated
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
            TeamSpaceAllocation other = (TeamSpaceAllocation) obj;
            return (this.used == other.used)
                && (this.allocated == other.allocated)
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

    static final class Serializer extends StructJsonSerializer<TeamSpaceAllocation> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamSpaceAllocation.class);
        }

        public Serializer(boolean unwrapping) {
            super(TeamSpaceAllocation.class, unwrapping);
        }

        @Override
        protected JsonSerializer<TeamSpaceAllocation> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(TeamSpaceAllocation value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("used", value.used);
            g.writeObjectField("allocated", value.allocated);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<TeamSpaceAllocation> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamSpaceAllocation.class);
        }

        public Deserializer(boolean unwrapping) {
            super(TeamSpaceAllocation.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<TeamSpaceAllocation> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public TeamSpaceAllocation deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long used = null;
            Long allocated = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("used".equals(_field)) {
                    used = _p.getLongValue();
                    assertUnsigned(_p, used);
                    _p.nextToken();
                }
                else if ("allocated".equals(_field)) {
                    allocated = _p.getLongValue();
                    assertUnsigned(_p, allocated);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (used == null) {
                throw new JsonParseException(_p, "Required field \"used\" is missing.");
            }
            if (allocated == null) {
                throw new JsonParseException(_p, "Required field \"allocated\" is missing.");
            }

            return new TeamSpaceAllocation(used, allocated);
        }
    }
}
