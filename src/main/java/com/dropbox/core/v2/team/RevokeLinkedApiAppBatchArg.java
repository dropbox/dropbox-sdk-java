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

public class RevokeLinkedApiAppBatchArg {
    // struct RevokeLinkedApiAppBatchArg

    private final List<RevokeLinkedApiAppArg> revokeLinkedApp;

    /**
     *
     * @param revokeLinkedApp  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppBatchArg(List<RevokeLinkedApiAppArg> revokeLinkedApp) {
        if (revokeLinkedApp == null) {
            throw new IllegalArgumentException("Required value for 'revokeLinkedApp' is null");
        }
        for (RevokeLinkedApiAppArg x : revokeLinkedApp) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeLinkedApp' is null");
            }
        }
        this.revokeLinkedApp = revokeLinkedApp;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeLinkedApiAppArg> getRevokeLinkedApp() {
        return revokeLinkedApp;
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
            RevokeLinkedApiAppBatchArg other = (RevokeLinkedApiAppBatchArg) obj;
            return (this.revokeLinkedApp == other.revokeLinkedApp) || (this.revokeLinkedApp.equals(other.revokeLinkedApp));
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

    public static RevokeLinkedApiAppBatchArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedApiAppBatchArg> _JSON_WRITER = new JsonWriter<RevokeLinkedApiAppBatchArg>() {
        public final void write(RevokeLinkedApiAppBatchArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeLinkedApiAppBatchArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeLinkedApiAppBatchArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("revoke_linked_app");
            g.writeStartArray();
            for (RevokeLinkedApiAppArg item: x.revokeLinkedApp) {
                if (item != null) {
                    RevokeLinkedApiAppArg._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<RevokeLinkedApiAppBatchArg> _JSON_READER = new JsonReader<RevokeLinkedApiAppBatchArg>() {
        public final RevokeLinkedApiAppBatchArg read(JsonParser parser) throws IOException, JsonReadException {
            RevokeLinkedApiAppBatchArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeLinkedApiAppBatchArg readFields(JsonParser parser) throws IOException, JsonReadException {
            List<RevokeLinkedApiAppArg> revokeLinkedApp = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("revoke_linked_app".equals(fieldName)) {
                    revokeLinkedApp = JsonArrayReader.mk(RevokeLinkedApiAppArg._JSON_READER)
                        .readField(parser, "revoke_linked_app", revokeLinkedApp);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (revokeLinkedApp == null) {
                throw new JsonReadException("Required field \"revoke_linked_app\" is missing.", parser.getTokenLocation());
            }
            return new RevokeLinkedApiAppBatchArg(revokeLinkedApp);
        }
    };
}
