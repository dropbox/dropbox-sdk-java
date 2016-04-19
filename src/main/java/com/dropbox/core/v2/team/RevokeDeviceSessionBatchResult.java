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

@JsonSerialize(using=RevokeDeviceSessionBatchResult.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionBatchResult.Deserializer.class)
public class RevokeDeviceSessionBatchResult {
    // struct RevokeDeviceSessionBatchResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<RevokeDeviceSessionStatus> revokeDevicesStatus;

    /**
     *
     * @param revokeDevicesStatus  Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchResult(List<RevokeDeviceSessionStatus> revokeDevicesStatus) {
        if (revokeDevicesStatus == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevicesStatus' is null");
        }
        for (RevokeDeviceSessionStatus x : revokeDevicesStatus) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevicesStatus' is null");
            }
        }
        this.revokeDevicesStatus = revokeDevicesStatus;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeDeviceSessionStatus> getRevokeDevicesStatus() {
        return revokeDevicesStatus;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            revokeDevicesStatus
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
            RevokeDeviceSessionBatchResult other = (RevokeDeviceSessionBatchResult) obj;
            return (this.revokeDevicesStatus == other.revokeDevicesStatus) || (this.revokeDevicesStatus.equals(other.revokeDevicesStatus));
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

    static final class Serializer extends StructJsonSerializer<RevokeDeviceSessionBatchResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionBatchResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeDeviceSessionBatchResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeDeviceSessionBatchResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeDeviceSessionBatchResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("revoke_devices_status", value.revokeDevicesStatus);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeDeviceSessionBatchResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionBatchResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeDeviceSessionBatchResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeDeviceSessionBatchResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeDeviceSessionBatchResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<RevokeDeviceSessionStatus> revokeDevicesStatus = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("revoke_devices_status".equals(_field)) {
                    expectArrayStart(_p);
                    revokeDevicesStatus = new java.util.ArrayList<RevokeDeviceSessionStatus>();
                    while (!isArrayEnd(_p)) {
                        RevokeDeviceSessionStatus _x = null;
                        _x = _p.readValueAs(RevokeDeviceSessionStatus.class);
                        _p.nextToken();
                        revokeDevicesStatus.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (revokeDevicesStatus == null) {
                throw new JsonParseException(_p, "Required field \"revoke_devices_status\" is missing.");
            }

            return new RevokeDeviceSessionBatchResult(revokeDevicesStatus);
        }
    }
}
