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

public class UploadSessionStartResult {
    // struct UploadSessionStartResult

    private final String sessionId;

    /**
     *
     * @param sessionId  A unique identifier for the upload session. Pass this
     *     to {@link DbxFiles#uploadSessionAppend(String,long)} and {@link
     *     DbxFiles#uploadSessionFinish(UploadSessionCursor,CommitInfo)}. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartResult(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
    }

    /**
     * A unique identifier for the upload session. Pass this to {@link
     * DbxFiles#uploadSessionAppend(String,long)} and {@link
     * DbxFiles#uploadSessionFinish(UploadSessionCursor,CommitInfo)}.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId
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
            UploadSessionStartResult other = (UploadSessionStartResult) obj;
            return (this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId));
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

    public static UploadSessionStartResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionStartResult> _JSON_WRITER = new JsonWriter<UploadSessionStartResult>() {
        public final void write(UploadSessionStartResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UploadSessionStartResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UploadSessionStartResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("session_id");
            g.writeString(x.sessionId);
        }
    };

    public static final JsonReader<UploadSessionStartResult> _JSON_READER = new JsonReader<UploadSessionStartResult>() {
        public final UploadSessionStartResult read(JsonParser parser) throws IOException, JsonReadException {
            UploadSessionStartResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UploadSessionStartResult readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sessionId == null) {
                throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
            }
            return new UploadSessionStartResult(sessionId);
        }
    };
}
