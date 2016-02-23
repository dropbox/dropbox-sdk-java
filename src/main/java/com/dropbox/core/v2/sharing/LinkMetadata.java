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
 * Metadata for a shared link. This can be either a {@link PathLinkMetadata} or
 * {@link CollectionLinkMetadata}.
 */
public class LinkMetadata {
    // struct LinkMetadata

    private final String url;
    private final Visibility visibility;
    private final Date expires;

    /**
     * Metadata for a shared link. This can be either a {@link PathLinkMetadata}
     * or {@link CollectionLinkMetadata}.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkMetadata(String url, Visibility visibility, Date expires) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (visibility == null) {
            throw new IllegalArgumentException("Required value for 'visibility' is null");
        }
        this.visibility = visibility;
        this.expires = expires;
    }

    /**
     * Metadata for a shared link. This can be either a {@link PathLinkMetadata}
     * or {@link CollectionLinkMetadata}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkMetadata(String url, Visibility visibility) {
        this(url, visibility, null);
    }

    /**
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Who can access the link.
     *
     * @return value for this field, never {@code null}.
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * Expiration time, if set. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getExpires() {
        return expires;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            url,
            visibility,
            expires
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
            LinkMetadata other = (LinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.visibility == other.visibility) || (this.visibility.equals(other.visibility)))
                && ((this.expires == other.expires) || (this.expires != null && this.expires.equals(other.expires)))
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

    public static LinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<LinkMetadata> _JSON_WRITER = new JsonWriter<LinkMetadata>() {
        public final void write(LinkMetadata x, JsonGenerator g) throws IOException {
            if (x instanceof PathLinkMetadata) {
                PathLinkMetadata._JSON_WRITER.write((PathLinkMetadata) x, g);
                return;
            }
            if (x instanceof CollectionLinkMetadata) {
                CollectionLinkMetadata._JSON_WRITER.write((CollectionLinkMetadata) x, g);
                return;
            }

            g.writeStartObject();
            LinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(LinkMetadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("url");
            g.writeString(x.url);
            g.writeFieldName("visibility");
            Visibility._JSON_WRITER.write(x.visibility, g);
            if (x.expires != null) {
                g.writeFieldName("expires");
                writeDateIso(x.expires, g);
            }
        }
    };

    public static final JsonReader<LinkMetadata> _JSON_READER = new JsonReader<LinkMetadata>() {
        public final LinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            LinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final LinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null && tags.length > 0) {
                if ("path".equals(tags[0])) {
                    return PathLinkMetadata._JSON_READER.readFromTags(tags, parser);
                }
                if ("collection".equals(tags[0])) {
                    return CollectionLinkMetadata._JSON_READER.readFromTags(tags, parser);
                }
                // If no match, fall back to base class
            }
            return readFields(parser);
        }

        public final LinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            Visibility visibility = null;
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
            return new LinkMetadata(url, visibility, expires);
        }
    };
}
