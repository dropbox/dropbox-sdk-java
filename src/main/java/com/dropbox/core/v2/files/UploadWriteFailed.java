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

public class UploadWriteFailed {
    // struct UploadWriteFailed

    private final WriteError reason;
    private final String uploadSessionId;

    /**
     *
     * @param reason  The reason why the file couldn't be saved. Must not be
     *     {@code null}.
     * @param uploadSessionId  The upload session ID; this may be used to retry
     *     the commit. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadWriteFailed(WriteError reason, String uploadSessionId) {
        if (reason == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = reason;
        if (uploadSessionId == null) {
            throw new IllegalArgumentException("Required value for 'uploadSessionId' is null");
        }
        this.uploadSessionId = uploadSessionId;
    }

    /**
     * The reason why the file couldn't be saved.
     *
     * @return value for this field, never {@code null}.
     */
    public WriteError getReason() {
        return reason;
    }

    /**
     * The upload session ID; this may be used to retry the commit.
     *
     * @return value for this field, never {@code null}.
     */
    public String getUploadSessionId() {
        return uploadSessionId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            reason,
            uploadSessionId
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
            UploadWriteFailed other = (UploadWriteFailed) obj;
            return ((this.reason == other.reason) || (this.reason.equals(other.reason)))
                && ((this.uploadSessionId == other.uploadSessionId) || (this.uploadSessionId.equals(other.uploadSessionId)))
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

    public static UploadWriteFailed fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadWriteFailed> _JSON_WRITER = new JsonWriter<UploadWriteFailed>() {
        public final void write(UploadWriteFailed x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UploadWriteFailed._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UploadWriteFailed x, JsonGenerator g) throws IOException {
            g.writeFieldName("reason");
            WriteError._JSON_WRITER.write(x.reason, g);
            g.writeFieldName("upload_session_id");
            g.writeString(x.uploadSessionId);
        }
    };

    public static final JsonReader<UploadWriteFailed> _JSON_READER = new JsonReader<UploadWriteFailed>() {
        public final UploadWriteFailed read(JsonParser parser) throws IOException, JsonReadException {
            UploadWriteFailed result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UploadWriteFailed readFields(JsonParser parser) throws IOException, JsonReadException {
            WriteError reason = null;
            String uploadSessionId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("reason".equals(fieldName)) {
                    reason = WriteError._JSON_READER
                        .readField(parser, "reason", reason);
                }
                else if ("upload_session_id".equals(fieldName)) {
                    uploadSessionId = JsonReader.StringReader
                        .readField(parser, "upload_session_id", uploadSessionId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (reason == null) {
                throw new JsonReadException("Required field \"reason\" is missing.", parser.getTokenLocation());
            }
            if (uploadSessionId == null) {
                throw new JsonReadException("Required field \"upload_session_id\" is missing.", parser.getTokenLocation());
            }
            return new UploadWriteFailed(reason, uploadSessionId);
        }
    };
}
