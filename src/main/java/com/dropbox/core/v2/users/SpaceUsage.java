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
 * Information about a user's space usage and quota.
 */
@JsonSerialize(using=SpaceUsage.Serializer.class)
@JsonDeserialize(using=SpaceUsage.Deserializer.class)
public class SpaceUsage {
    // struct SpaceUsage

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long used;
    protected final SpaceAllocation allocation;

    /**
     * Information about a user's space usage and quota.
     *
     * @param used  The user's total space usage (bytes).
     * @param allocation  The user's space allocation. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SpaceUsage(long used, SpaceAllocation allocation) {
        this.used = used;
        if (allocation == null) {
            throw new IllegalArgumentException("Required value for 'allocation' is null");
        }
        this.allocation = allocation;
    }

    /**
     * The user's total space usage (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The user's space allocation.
     *
     * @return value for this field, never {@code null}.
     */
    public SpaceAllocation getAllocation() {
        return allocation;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            used,
            allocation
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
            SpaceUsage other = (SpaceUsage) obj;
            return (this.used == other.used)
                && ((this.allocation == other.allocation) || (this.allocation.equals(other.allocation)))
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

    static final class Serializer extends StructJsonSerializer<SpaceUsage> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SpaceUsage.class);
        }

        public Serializer(boolean unwrapping) {
            super(SpaceUsage.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SpaceUsage> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SpaceUsage value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("used", value.used);
            g.writeObjectField("allocation", value.allocation);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SpaceUsage> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SpaceUsage.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SpaceUsage.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SpaceUsage> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SpaceUsage deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long used = null;
            SpaceAllocation allocation = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("used".equals(_field)) {
                    used = _p.getLongValue();
                    assertUnsigned(_p, used);
                    _p.nextToken();
                }
                else if ("allocation".equals(_field)) {
                    allocation = _p.readValueAs(SpaceAllocation.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (used == null) {
                throw new JsonParseException(_p, "Required field \"used\" is missing.");
            }
            if (allocation == null) {
                throw new JsonParseException(_p, "Required field \"allocation\" is missing.");
            }

            return new SpaceUsage(used, allocation);
        }
    }
}
