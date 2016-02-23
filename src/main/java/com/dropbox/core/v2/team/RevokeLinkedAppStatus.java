/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class RevokeLinkedAppStatus {
    // struct RevokeLinkedAppStatus

    private final boolean success;
    private final RevokeLinkedAppError errorType;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeLinkedAppStatus fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedAppStatus> _JSON_WRITER = new JsonWriter<RevokeLinkedAppStatus>() {
        public final void write(RevokeLinkedAppStatus x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeLinkedAppStatus._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeLinkedAppStatus x, JsonGenerator g) throws IOException {
            g.writeFieldName("success");
            g.writeBoolean(x.success);
            if (x.errorType != null) {
                g.writeFieldName("error_type");
                RevokeLinkedAppError._JSON_WRITER.write(x.errorType, g);
            }
        }
    };

    public static final JsonReader<RevokeLinkedAppStatus> _JSON_READER = new JsonReader<RevokeLinkedAppStatus>() {
        public final RevokeLinkedAppStatus read(JsonParser parser) throws IOException, JsonReadException {
            RevokeLinkedAppStatus result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeLinkedAppStatus readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean success = null;
            RevokeLinkedAppError errorType = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("success".equals(fieldName)) {
                    success = JsonReader.BooleanReader
                        .readField(parser, "success", success);
                }
                else if ("error_type".equals(fieldName)) {
                    errorType = RevokeLinkedAppError._JSON_READER
                        .readField(parser, "error_type", errorType);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (success == null) {
                throw new JsonReadException("Required field \"success\" is missing.", parser.getTokenLocation());
            }
            return new RevokeLinkedAppStatus(success, errorType);
        }
    };
}
