/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class UploadSessionCursor {
    // struct UploadSessionCursor

    private final String sessionId;
    private final long offset;

    /**
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxFiles#uploadSessionStart()}). Must not be {@code null}.
     * @param offset  The amount of data that has been uploaded so far. We use
     *     this to make sure upload data isn't lost or duplicated in the event
     *     of a network error.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionCursor(String sessionId, long offset) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        this.offset = offset;
    }

    /**
     * The upload session ID (returned by {@link
     * DbxFiles#uploadSessionStart()}).
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The amount of data that has been uploaded so far. We use this to make
     * sure upload data isn't lost or duplicated in the event of a network
     * error.
     *
     * @return value for this field.
     */
    public long getOffset() {
        return offset;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId,
            offset
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
            UploadSessionCursor other = (UploadSessionCursor) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && (this.offset == other.offset)
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

    public static UploadSessionCursor fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionCursor> _JSON_WRITER = new JsonWriter<UploadSessionCursor>() {
        public final void write(UploadSessionCursor x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UploadSessionCursor._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UploadSessionCursor x, JsonGenerator g) throws IOException {
            g.writeFieldName("session_id");
            g.writeString(x.sessionId);
            g.writeFieldName("offset");
            g.writeNumber(x.offset);
        }
    };

    public static final JsonReader<UploadSessionCursor> _JSON_READER = new JsonReader<UploadSessionCursor>() {
        public final UploadSessionCursor read(JsonParser parser) throws IOException, JsonReadException {
            UploadSessionCursor result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UploadSessionCursor readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
            Long offset = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else if ("offset".equals(fieldName)) {
                    offset = JsonReader.UInt64Reader
                        .readField(parser, "offset", offset);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sessionId == null) {
                throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
            }
            if (offset == null) {
                throw new JsonReadException("Required field \"offset\" is missing.", parser.getTokenLocation());
            }
            return new UploadSessionCursor(sessionId, offset);
        }
    };
}
