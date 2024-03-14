/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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

/**
 * Result for {@link DbxUserFileRequestsRequests#count}.
 */
public class CountFileRequestsResult {
    // struct file_requests.CountFileRequestsResult (file_requests.stone)

    protected final long fileRequestCount;

    /**
     * Result for {@link DbxUserFileRequestsRequests#count}.
     *
     * @param fileRequestCount  The number file requests owner by this user.
     */
    public CountFileRequestsResult(long fileRequestCount) {
        this.fileRequestCount = fileRequestCount;
    }

    /**
     * The number file requests owner by this user.
     *
     * @return value for this field.
     */
    public long getFileRequestCount() {
        return fileRequestCount;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileRequestCount
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
            CountFileRequestsResult other = (CountFileRequestsResult) obj;
            return this.fileRequestCount == other.fileRequestCount;
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
    static class Serializer extends StructSerializer<CountFileRequestsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CountFileRequestsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file_request_count");
            StoneSerializers.uInt64().serialize(value.fileRequestCount, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CountFileRequestsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CountFileRequestsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_fileRequestCount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_request_count".equals(field)) {
                        f_fileRequestCount = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fileRequestCount == null) {
                    throw new JsonParseException(p, "Required field \"file_request_count\" missing.");
                }
                value = new CountFileRequestsResult(f_fileRequestCount);
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
