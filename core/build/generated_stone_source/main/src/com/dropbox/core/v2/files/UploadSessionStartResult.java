/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;

public class UploadSessionStartResult {
    // struct files.UploadSessionStartResult (files.stone)

    protected final String sessionId;

    /**
     *
     * @param sessionId  A unique identifier for the upload session. Pass this
     *     to {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} and
     *     {@link
     *     DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartResult(@Nonnull String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
    }

    /**
     * A unique identifier for the upload session. Pass this to {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} and
     * {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<UploadSessionStartResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionStartResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionStartResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                value = new UploadSessionStartResult(f_sessionId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
