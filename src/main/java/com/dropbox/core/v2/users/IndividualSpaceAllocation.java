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

@JsonSerialize(using=IndividualSpaceAllocation.Serializer.class)
@JsonDeserialize(using=IndividualSpaceAllocation.Deserializer.class)
public class IndividualSpaceAllocation {
    // struct IndividualSpaceAllocation

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long allocated;

    /**
     *
     * @param allocated  The total space allocated to the user's account
     *     (bytes).
     */
    public IndividualSpaceAllocation(long allocated) {
        this.allocated = allocated;
    }

    /**
     * The total space allocated to the user's account (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
            IndividualSpaceAllocation other = (IndividualSpaceAllocation) obj;
            return this.allocated == other.allocated;
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

    static final class Serializer extends StructJsonSerializer<IndividualSpaceAllocation> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(IndividualSpaceAllocation.class);
        }

        public Serializer(boolean unwrapping) {
            super(IndividualSpaceAllocation.class, unwrapping);
        }

        @Override
        protected JsonSerializer<IndividualSpaceAllocation> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(IndividualSpaceAllocation value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("allocated", value.allocated);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<IndividualSpaceAllocation> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(IndividualSpaceAllocation.class);
        }

        public Deserializer(boolean unwrapping) {
            super(IndividualSpaceAllocation.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<IndividualSpaceAllocation> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public IndividualSpaceAllocation deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long allocated = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("allocated".equals(_field)) {
                    allocated = _p.getLongValue();
                    assertUnsigned(_p, allocated);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (allocated == null) {
                throw new JsonParseException(_p, "Required field \"allocated\" is missing.");
            }

            return new IndividualSpaceAllocation(allocated);
        }
    }
}
