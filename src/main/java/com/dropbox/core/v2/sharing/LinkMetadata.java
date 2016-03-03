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
 * Metadata for a shared link. This can be either a {@link PathLinkMetadata} or
 * {@link CollectionLinkMetadata}.
 */
@JsonSerialize(using=LinkMetadata.Serializer.class)
@JsonDeserialize(using=LinkMetadata.Deserializer.class)
public class LinkMetadata {
    // struct LinkMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String url;
    protected final Visibility visibility;
    protected final Date expires;

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

    static final class Serializer extends StructJsonSerializer<LinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(LinkMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(LinkMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(LinkMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("url", value.url);
            g.writeObjectField("visibility", value.visibility);
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<LinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(LinkMetadata.class, PathLinkMetadata.class, CollectionLinkMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(LinkMetadata.class, unwrapping, PathLinkMetadata.class, CollectionLinkMetadata.class);
        }

        @Override
        protected JsonDeserializer<LinkMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public LinkMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p);
            if ("path".equals(_subtype_tag)) {
                return readCollapsedStructValue(PathLinkMetadata.class, _p, _ctx);
            }
            if ("collection".equals(_subtype_tag)) {
                return readCollapsedStructValue(CollectionLinkMetadata.class, _p, _ctx);
            }

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

            return new LinkMetadata(url, visibility, expires);
        }
    }
}
