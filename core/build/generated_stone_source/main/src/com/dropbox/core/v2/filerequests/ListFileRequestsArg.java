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
 * Arguments for {@link DbxUserFileRequestsRequests#listV2(long)}.
 */
class ListFileRequestsArg {
    // struct file_requests.ListFileRequestsArg (file_requests.stone)

    protected final long limit;

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#listV2(long)}.
     *
     * @param limit  The maximum number of file requests that should be returned
     *     per request.
     */
    public ListFileRequestsArg(long limit) {
        this.limit = limit;
    }

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#listV2(long)}.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListFileRequestsArg() {
        this(1000L);
    }

    /**
     * The maximum number of file requests that should be returned per request.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.limit
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
            ListFileRequestsArg other = (ListFileRequestsArg) obj;
            return this.limit == other.limit;
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
    static class Serializer extends StructSerializer<ListFileRequestsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileRequestsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("limit");
            StoneSerializers.uInt64().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileRequestsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileRequestsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_limit = 1000L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListFileRequestsArg(f_limit);
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
