/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

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

public class RevokeLinkedAppBatchResult {
    // struct RevokeLinkedAppBatchResult

    private final List<RevokeLinkedAppStatus> revokeLinkedAppStatus;

    /**
     *
     * @param revokeLinkedAppStatus  Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedAppBatchResult(List<RevokeLinkedAppStatus> revokeLinkedAppStatus) {
        if (revokeLinkedAppStatus == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedAppStatus' is null");
        }
        for (RevokeLinkedAppStatus x : revokeLinkedAppStatus) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedAppStatus' is null");
            }
        }
        this.revokeLinkedAppStatus = revokeLinkedAppStatus;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeLinkedAppStatus> getRevokeLinkedAppStatus() {
        return revokeLinkedAppStatus;
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
            RevokeLinkedAppBatchResult other = (RevokeLinkedAppBatchResult) obj;
            return (this.revokeLinkedAppStatus == other.revokeLinkedAppStatus) || (this.revokeLinkedAppStatus.equals(other.revokeLinkedAppStatus));
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

    public static RevokeLinkedAppBatchResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedAppBatchResult> _JSON_WRITER = new JsonWriter<RevokeLinkedAppBatchResult>() {
        public final void write(RevokeLinkedAppBatchResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeLinkedAppBatchResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeLinkedAppBatchResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("revoke_linked_app_status");
            g.writeStartArray();
            for (RevokeLinkedAppStatus item: x.revokeLinkedAppStatus) {
                if (item != null) {
                    RevokeLinkedAppStatus._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<RevokeLinkedAppBatchResult> _JSON_READER = new JsonReader<RevokeLinkedAppBatchResult>() {
        public final RevokeLinkedAppBatchResult read(JsonParser parser) throws IOException, JsonReadException {
            RevokeLinkedAppBatchResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeLinkedAppBatchResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<RevokeLinkedAppStatus> revokeLinkedAppStatus = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("revoke_linked_app_status".equals(fieldName)) {
                    revokeLinkedAppStatus = JsonArrayReader.mk(RevokeLinkedAppStatus._JSON_READER)
                        .readField(parser, "revoke_linked_app_status", revokeLinkedAppStatus);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (revokeLinkedAppStatus == null) {
                throw new JsonReadException("Required field \"revoke_linked_app_status\" is missing.", parser.getTokenLocation());
            }
            return new RevokeLinkedAppBatchResult(revokeLinkedAppStatus);
        }
    };
}
