/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Metadata for a path-based shared link.
 */
public class PathLinkMetadata extends LinkMetadata {
    // struct PathLinkMetadata

    private final String path;

    /**
     * Metadata for a path-based shared link.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     * @param path  Path in user's Dropbox. Must not be {@code null}.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathLinkMetadata(String url, Visibility visibility, String path, Date expires) {
        super(url, visibility, expires);
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = path;
    }

    /**
     * Metadata for a path-based shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     * @param path  Path in user's Dropbox. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathLinkMetadata(String url, Visibility visibility, String path) {
        this(url, visibility, path, null);
    }

    /**
     * Path in user's Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            PathLinkMetadata other = (PathLinkMetadata) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.getUrl() == other.getUrl()) || (this.getUrl().equals(other.getUrl())))
                && ((this.getVisibility() == other.getVisibility()) || (this.getVisibility().equals(other.getVisibility())))
                && ((this.getExpires() == other.getExpires()) || (this.getExpires() != null && this.getExpires().equals(other.getExpires())))
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

    public static PathLinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PathLinkMetadata> _JSON_WRITER = new JsonWriter<PathLinkMetadata>() {
        public final void write(PathLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "path");
            LinkMetadata._JSON_WRITER.writeFields(x, g);
            PathLinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(PathLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
        }
    };

    public static final JsonReader<PathLinkMetadata> _JSON_READER = new JsonReader<PathLinkMetadata>() {
        public final PathLinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            PathLinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final PathLinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "path".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final PathLinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            Visibility visibility = null;
            String path = null;
            Date expires = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("url".equals(fieldName)) {
                    url = JsonReader.StringReader
                        .readField(parser, "url", url);
                }
                else if ("visibility".equals(fieldName)) {
                    visibility = Visibility._JSON_READER
                        .readField(parser, "visibility", visibility);
                }
                else if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("expires".equals(fieldName)) {
                    expires = JsonDateReader.DropboxV2
                        .readField(parser, "expires", expires);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (url == null) {
                throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
            }
            if (visibility == null) {
                throw new JsonReadException("Required field \"visibility\" is missing.", parser.getTokenLocation());
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new PathLinkMetadata(url, visibility, path, expires);
        }
    };
}
