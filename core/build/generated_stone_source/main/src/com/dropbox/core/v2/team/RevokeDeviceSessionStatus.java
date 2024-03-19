/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RevokeDeviceSessionStatus {
    // struct team.RevokeDeviceSessionStatus (team_devices.stone)

    protected final boolean success;
    @Nullable
    protected final RevokeDeviceSessionError errorType;

    /**
     *
     * @param success  Result of the revoking request.
     * @param errorType  The error cause in case of a failure.
     */
    public RevokeDeviceSessionStatus(boolean success, @Nullable RevokeDeviceSessionError errorType) {
        this.success = success;
        this.errorType = errorType;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param success  Result of the revoking request.
     */
    public RevokeDeviceSessionStatus(boolean success) {
        this(success, null);
    }

    /**
     * Result of the revoking request.
     *
     * @return value for this field.
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * The error cause in case of a failure.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public RevokeDeviceSessionError getErrorType() {
        return errorType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<RevokeDeviceSessionStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeDeviceSessionStatus value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("success");
            StoneSerializers.boolean_().serialize(value.success, g);
            if (value.errorType != null) {
                g.writeFieldName("error_type");
                StoneSerializers.nullable(RevokeDeviceSessionError.Serializer.INSTANCE).serialize(value.errorType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeDeviceSessionStatus deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeDeviceSessionStatus value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_success = null;
                RevokeDeviceSessionError f_errorType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("success".equals(field)) {
                        f_success = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("error_type".equals(field)) {
                        f_errorType = StoneSerializers.nullable(RevokeDeviceSessionError.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_success == null) {
                    throw new JsonParseException(p, "Required field \"success\" missing.");
                }
                value = new RevokeDeviceSessionStatus(f_success, f_errorType);
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
