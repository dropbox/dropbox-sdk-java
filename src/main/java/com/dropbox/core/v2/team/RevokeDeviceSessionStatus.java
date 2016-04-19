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

@JsonSerialize(using=RevokeDeviceSessionStatus.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionStatus.Deserializer.class)
public class RevokeDeviceSessionStatus {
    // struct RevokeDeviceSessionStatus

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final boolean success;
    protected final RevokeDeviceSessionError errorType;

    /**
     *
     * @param success  Result of the revoking request.
     * @param errorType  The error cause in case of a failure.
     */
    public RevokeDeviceSessionStatus(boolean success, RevokeDeviceSessionError errorType) {
        this.success = success;
        this.errorType = errorType;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param success  Result of the revoking request.
     */
    public RevokeDeviceSessionStatus(boolean success) {
        this(success, null);
    }

    /**
     * Result of the revoking request
     *
     * @return value for this field.
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * The error cause in case of a failure
     *
     * @return value for this field, or {@code null} if not present.
     */
    public RevokeDeviceSessionError getErrorType() {
        return errorType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            success,
            errorType
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
            RevokeDeviceSessionStatus other = (RevokeDeviceSessionStatus) obj;
            return (this.success == other.success)
                && ((this.errorType == other.errorType) || (this.errorType != null && this.errorType.equals(other.errorType)))
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

    static final class Serializer extends StructJsonSerializer<RevokeDeviceSessionStatus> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionStatus.class);
        }

        public Serializer(boolean unwrapping) {
            super(RevokeDeviceSessionStatus.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RevokeDeviceSessionStatus> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RevokeDeviceSessionStatus value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("success", value.success);
            if (value.errorType != null) {
                g.writeObjectField("error_type", value.errorType);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RevokeDeviceSessionStatus> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionStatus.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RevokeDeviceSessionStatus.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RevokeDeviceSessionStatus> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RevokeDeviceSessionStatus deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean success = null;
            RevokeDeviceSessionError errorType = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("success".equals(_field)) {
                    success = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("error_type".equals(_field)) {
                    errorType = _p.readValueAs(RevokeDeviceSessionError.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (success == null) {
                throw new JsonParseException(_p, "Required field \"success\" is missing.");
            }

            return new RevokeDeviceSessionStatus(success, errorType);
        }
    }
}
