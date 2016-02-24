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

public class GetMetadataArg {
    // struct GetMetadataArg

    private final String path;
    private final boolean includeMediaInfo;

    /**
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path, boolean includeMediaInfo) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.includeMediaInfo = includeMediaInfo;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataArg(String path) {
        this(path, false);
    }

    /**
     * The path of a file or folder on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * If true, {@link FileMetadata#getMediaInfo} is set for photo and video.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeMediaInfo() {
        return includeMediaInfo;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            includeMediaInfo
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
            GetMetadataArg other = (GetMetadataArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.includeMediaInfo == other.includeMediaInfo)
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

    public static GetMetadataArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetMetadataArg> _JSON_WRITER = new JsonWriter<GetMetadataArg>() {
        public final void write(GetMetadataArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GetMetadataArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetMetadataArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("include_media_info");
            g.writeBoolean(x.includeMediaInfo);
        }
    };

    public static final JsonReader<GetMetadataArg> _JSON_READER = new JsonReader<GetMetadataArg>() {
        public final GetMetadataArg read(JsonParser parser) throws IOException, JsonReadException {
            GetMetadataArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetMetadataArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            Boolean includeMediaInfo = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("include_media_info".equals(fieldName)) {
                    includeMediaInfo = JsonReader.BooleanReader
                        .readField(parser, "include_media_info", includeMediaInfo);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new GetMetadataArg(path, includeMediaInfo);
        }
    };
}
