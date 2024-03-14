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
import java.util.List;

public class UploadSessionStartBatchResult {
    // struct files.UploadSessionStartBatchResult (files.stone)

    protected final List<String> sessionIds;

    /**
     *
     * @param sessionIds  A List of unique identifiers for the upload session.
     *     Pass each session_id to {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} and
     *     {@link
     *     DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartBatchResult(List<String> sessionIds) {
        if (sessionIds == null) {
            throw new IllegalArgumentException("Required value for 'sessionIds' is null");
        }
        for (String x : sessionIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'sessionIds' is null");
            }
        }
        this.sessionIds = sessionIds;
    }

    /**
     * A List of unique identifiers for the upload session. Pass each session_id
     * to {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} and
     * {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getSessionIds() {
        return sessionIds;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionIds
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
            UploadSessionStartBatchResult other = (UploadSessionStartBatchResult) obj;
            return (this.sessionIds == other.sessionIds) || (this.sessionIds.equals(other.sessionIds));
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
    static class Serializer extends StructSerializer<UploadSessionStartBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.sessionIds, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionStartBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionStartBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_sessionIds = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_ids".equals(field)) {
                        f_sessionIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionIds == null) {
                    throw new JsonParseException(p, "Required field \"session_ids\" missing.");
                }
                value = new UploadSessionStartBatchResult(f_sessionIds);
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
