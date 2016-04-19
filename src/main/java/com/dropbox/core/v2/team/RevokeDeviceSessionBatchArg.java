/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

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
import java.util.List;

@JsonSerialize(using=RevokeDeviceSessionBatchArg.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionBatchArg.Deserializer.class)
class RevokeDeviceSessionBatchArg {
    // struct RevokeDeviceSessionBatchArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<RevokeDeviceSessionArg> revokeDevices;

    /**
     *
     * @param revokeDevices  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchArg(List<RevokeDeviceSessionArg> revokeDevices) {
        if (revokeDevices == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevices' is null");
        }
        for (RevokeDeviceSessionArg x : revokeDevices) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevices' is null");
            }
        }
        this.revokeDevices = revokeDevices;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeDeviceSessionArg> getRevokeDevices() {
        return revokeDevices;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            revokeDevices
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
            RevokeDeviceSessionBatchArg other = (RevokeDeviceSessionBatchArg) obj;
            return (this.revokeDevices == other.revokeDevices) || (this.revokeDevices.equals(other.revokeDevices));
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

    static final class Serializer extends StructJsonSerializer<RevokeDeviceSessionBatchArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionBatchArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeDeviceSessionBatchArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeDeviceSessionBatchArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeDeviceSessionBatchArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("revoke_devices", value.revokeDevices);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeDeviceSessionBatchArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionBatchArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeDeviceSessionBatchArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeDeviceSessionBatchArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeDeviceSessionBatchArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<RevokeDeviceSessionArg> revokeDevices = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("revoke_devices".equals(_field)) {
                    expectArrayStart(_p);
                    revokeDevices = new java.util.ArrayList<RevokeDeviceSessionArg>();
                    while (!isArrayEnd(_p)) {
                        RevokeDeviceSessionArg _x = null;
                        _x = _p.readValueAs(RevokeDeviceSessionArg.class);
                        _p.nextToken();
                        revokeDevices.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (revokeDevices == null) {
                throw new JsonParseException(_p, "Required field \"revoke_devices\" is missing.");
            }

            return new RevokeDeviceSessionBatchArg(revokeDevices);
        }
    }
}
