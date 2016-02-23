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

public class RevokeDeviceSessionBatchArg {
    // struct RevokeDeviceSessionBatchArg

    private final List<RevokeDeviceSessionArg> revokeDevices;

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
            RevokeDeviceSessionBatchArg other = (RevokeDeviceSessionBatchArg) obj;
            return (this.revokeDevices == other.revokeDevices) || (this.revokeDevices.equals(other.revokeDevices));
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

    public static RevokeDeviceSessionBatchArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDeviceSessionBatchArg> _JSON_WRITER = new JsonWriter<RevokeDeviceSessionBatchArg>() {
        public final void write(RevokeDeviceSessionBatchArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeDeviceSessionBatchArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeDeviceSessionBatchArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("revoke_devices");
            g.writeStartArray();
            for (RevokeDeviceSessionArg item: x.revokeDevices) {
                if (item != null) {
                    RevokeDeviceSessionArg._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<RevokeDeviceSessionBatchArg> _JSON_READER = new JsonReader<RevokeDeviceSessionBatchArg>() {
        public final RevokeDeviceSessionBatchArg read(JsonParser parser) throws IOException, JsonReadException {
            RevokeDeviceSessionBatchArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeDeviceSessionBatchArg readFields(JsonParser parser) throws IOException, JsonReadException {
            List<RevokeDeviceSessionArg> revokeDevices = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("revoke_devices".equals(fieldName)) {
                    revokeDevices = JsonArrayReader.mk(RevokeDeviceSessionArg._JSON_READER)
                        .readField(parser, "revoke_devices", revokeDevices);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (revokeDevices == null) {
                throw new JsonReadException("Required field \"revoke_devices\" is missing.", parser.getTokenLocation());
            }
            return new RevokeDeviceSessionBatchArg(revokeDevices);
        }
    };
}
