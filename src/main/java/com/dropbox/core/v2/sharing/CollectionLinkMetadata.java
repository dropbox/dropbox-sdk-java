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
 * Metadata for a collection-based shared link.
 */
public class CollectionLinkMetadata extends LinkMetadata {
    // struct CollectionLinkMetadata


    /**
     * Metadata for a collection-based shared link.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CollectionLinkMetadata(String url, Visibility visibility, Date expires) {
        super(url, visibility, expires);
    }

    /**
     * Metadata for a collection-based shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CollectionLinkMetadata(String url, Visibility visibility) {
        this(url, visibility, null);
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            CollectionLinkMetadata other = (CollectionLinkMetadata) obj;
            return ((this.getUrl() == other.getUrl()) || (this.getUrl().equals(other.getUrl())))
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

    public static CollectionLinkMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<CollectionLinkMetadata> _JSON_WRITER = new JsonWriter<CollectionLinkMetadata>() {
        public final void write(CollectionLinkMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "collection");
            LinkMetadata._JSON_WRITER.writeFields(x, g);
            CollectionLinkMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(CollectionLinkMetadata x, JsonGenerator g) throws IOException {
        }
    };

    public static final JsonReader<CollectionLinkMetadata> _JSON_READER = new JsonReader<CollectionLinkMetadata>() {
        public final CollectionLinkMetadata read(JsonParser parser) throws IOException, JsonReadException {
            CollectionLinkMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final CollectionLinkMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "collection".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final CollectionLinkMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
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
            return new CollectionLinkMetadata(url, visibility, expires);
        }
    };
}
