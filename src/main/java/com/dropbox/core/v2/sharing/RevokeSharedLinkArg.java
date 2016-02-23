/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class RevokeSharedLinkArg {
    // struct RevokeSharedLinkArg

    private final String url;

    /**
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeSharedLinkArg(String url) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
    }

    /**
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    public String getUrl() {
        return url;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            url
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
            RevokeSharedLinkArg other = (RevokeSharedLinkArg) obj;
            return (this.url == other.url) || (this.url.equals(other.url));
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

    public static RevokeSharedLinkArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeSharedLinkArg> _JSON_WRITER = new JsonWriter<RevokeSharedLinkArg>() {
        public final void write(RevokeSharedLinkArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeSharedLinkArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeSharedLinkArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("url");
            g.writeString(x.url);
        }
    };

    public static final JsonReader<RevokeSharedLinkArg> _JSON_READER = new JsonReader<RevokeSharedLinkArg>() {
        public final RevokeSharedLinkArg read(JsonParser parser) throws IOException, JsonReadException {
            RevokeSharedLinkArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeSharedLinkArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("url".equals(fieldName)) {
                    url = JsonReader.StringReader
                        .readField(parser, "url", url);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (url == null) {
                throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
            }
            return new RevokeSharedLinkArg(url);
        }
    };
}
