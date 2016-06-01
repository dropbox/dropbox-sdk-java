/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class UploadSessionCursor {
    // struct UploadSessionCursor

    protected final String sessionId;
    protected final long offset;

    /**
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxUserFilesRequests#uploadSessionStart()}). Must not be {@code
     *     null}.
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
     * DbxUserFilesRequests#uploadSessionStart()}).
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
    static final class Serializer extends StructSerializer<UploadSessionCursor> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionCursor value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            g.writeFieldName("offset");
            StoneSerializers.uInt64().serialize(value.offset, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionCursor deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionCursor value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                Long f_offset = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("offset".equals(field)) {
                        f_offset = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                if (f_offset == null) {
                    throw new JsonParseException(p, "Required field \"offset\" missing.");
                }
                value = new UploadSessionCursor(f_sessionId, f_offset);
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
