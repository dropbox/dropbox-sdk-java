/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class RevokeDeviceSessionBatchResult {
    // struct RevokeDeviceSessionBatchResult

    private final List<RevokeDeviceSessionStatus> revokeDevicesStatus;

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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeDeviceSessionBatchResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDeviceSessionBatchResult> _JSON_WRITER = new JsonWriter<RevokeDeviceSessionBatchResult>() {
        public final void write(RevokeDeviceSessionBatchResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeDeviceSessionBatchResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeDeviceSessionBatchResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("revoke_devices_status");
            g.writeStartArray();
            for (RevokeDeviceSessionStatus item: x.revokeDevicesStatus) {
                if (item != null) {
                    RevokeDeviceSessionStatus._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<RevokeDeviceSessionBatchResult> _JSON_READER = new JsonReader<RevokeDeviceSessionBatchResult>() {
        public final RevokeDeviceSessionBatchResult read(JsonParser parser) throws IOException, JsonReadException {
            RevokeDeviceSessionBatchResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeDeviceSessionBatchResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<RevokeDeviceSessionStatus> revokeDevicesStatus = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("revoke_devices_status".equals(fieldName)) {
                    revokeDevicesStatus = JsonArrayReader.mk(RevokeDeviceSessionStatus._JSON_READER)
                        .readField(parser, "revoke_devices_status", revokeDevicesStatus);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (revokeDevicesStatus == null) {
                throw new JsonReadException("Required field \"revoke_devices_status\" is missing.", parser.getTokenLocation());
            }
            return new RevokeDeviceSessionBatchResult(revokeDevicesStatus);
        }
    };
}
