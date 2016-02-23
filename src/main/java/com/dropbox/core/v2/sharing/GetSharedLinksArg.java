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

public class GetSharedLinksArg {
    // struct GetSharedLinksArg

    private final String path;

    /**
     *
     * @param path  See {@link DbxSharing#getSharedLinks()} description.
     */
    public GetSharedLinksArg(String path) {
        this.path = path;
    }

    /**
     * The default values for unset fields will be used.
     */
    public GetSharedLinksArg() {
        this(null);
    }

    /**
     * See {@link DbxSharing#getSharedLinks()} description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path
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
            GetSharedLinksArg other = (GetSharedLinksArg) obj;
            return (this.path == other.path) || (this.path != null && this.path.equals(other.path));
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

    public static GetSharedLinksArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetSharedLinksArg> _JSON_WRITER = new JsonWriter<GetSharedLinksArg>() {
        public final void write(GetSharedLinksArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GetSharedLinksArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetSharedLinksArg x, JsonGenerator g) throws IOException {
            if (x.path != null) {
                g.writeFieldName("path");
                g.writeString(x.path);
            }
        }
    };

    public static final JsonReader<GetSharedLinksArg> _JSON_READER = new JsonReader<GetSharedLinksArg>() {
        public final GetSharedLinksArg read(JsonParser parser) throws IOException, JsonReadException {
            GetSharedLinksArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetSharedLinksArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new GetSharedLinksArg(path);
        }
    };
}
