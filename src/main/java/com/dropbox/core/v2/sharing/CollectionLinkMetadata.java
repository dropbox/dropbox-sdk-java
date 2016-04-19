/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

/**
 * Metadata for a collection-based shared link.
 */
@JsonSerialize(using=CollectionLinkMetadata.Serializer.class)
@JsonDeserialize(using=CollectionLinkMetadata.Deserializer.class)
public class CollectionLinkMetadata extends LinkMetadata {
    // struct CollectionLinkMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();


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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<CollectionLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(CollectionLinkMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(CollectionLinkMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(CollectionLinkMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeStringField(".tag", "collection");
            g.writeObjectField("url", value.url);
            g.writeObjectField("visibility", value.visibility);
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<CollectionLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(CollectionLinkMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(CollectionLinkMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<CollectionLinkMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public CollectionLinkMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p, "collection");

            String url = null;
            Visibility visibility = null;
            Date expires = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("url".equals(_field)) {
                    url = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("visibility".equals(_field)) {
                    visibility = _p.readValueAs(Visibility.class);
                    _p.nextToken();
                }
                else if ("expires".equals(_field)) {
                    expires = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (url == null) {
                throw new JsonParseException(_p, "Required field \"url\" is missing.");
            }
            if (visibility == null) {
                throw new JsonParseException(_p, "Required field \"visibility\" is missing.");
            }

            return new CollectionLinkMetadata(url, visibility, expires);
        }
    }
}
