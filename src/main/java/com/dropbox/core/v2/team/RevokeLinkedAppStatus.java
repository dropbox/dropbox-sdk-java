/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class RevokeLinkedAppStatus {
    // struct RevokeLinkedAppStatus

    protected final boolean success;
    protected final RevokeLinkedAppError errorType;

    /**
     *
     * @param success  Result of the revoking request.
     * @param errorType  The error cause in case of a failure.
     */
    public RevokeLinkedAppStatus(boolean success, RevokeLinkedAppError errorType) {
        this.success = success;
        this.errorType = errorType;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param success  Result of the revoking request.
     */
    public RevokeLinkedAppStatus(boolean success) {
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
    public RevokeLinkedAppError getErrorType() {
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
            RevokeLinkedAppStatus other = (RevokeLinkedAppStatus) obj;
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
    static final class Serializer extends StructSerializer<RevokeLinkedAppStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeLinkedAppStatus value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("success");
            StoneSerializers.boolean_().serialize(value.success, g);
            if (value.errorType != null) {
                g.writeFieldName("error_type");
                StoneSerializers.nullable(RevokeLinkedAppError.Serializer.INSTANCE).serialize(value.errorType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeLinkedAppStatus deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeLinkedAppStatus value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_success = null;
                RevokeLinkedAppError f_errorType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("success".equals(field)) {
                        f_success = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("error_type".equals(field)) {
                        f_errorType = StoneSerializers.nullable(RevokeLinkedAppError.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_success == null) {
                    throw new JsonParseException(p, "Required field \"success\" missing.");
                }
                value = new RevokeLinkedAppStatus(f_success, f_errorType);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
