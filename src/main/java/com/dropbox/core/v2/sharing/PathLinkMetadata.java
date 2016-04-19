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
 * Metadata for a path-based shared link.
 */
@JsonSerialize(using=PathLinkMetadata.Serializer.class)
@JsonDeserialize(using=PathLinkMetadata.Deserializer.class)
public class PathLinkMetadata extends LinkMetadata {
    // struct PathLinkMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;

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
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.visibility == other.visibility) || (this.visibility.equals(other.visibility)))
                && ((this.path == other.path) || (this.path.equals(other.path)))
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

    static final class Serializer extends StructJsonSerializer<PathLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PathLinkMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(PathLinkMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(PathLinkMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeStringField(".tag", "path");
            g.writeObjectField("url", value.url);
            g.writeObjectField("visibility", value.visibility);
            g.writeObjectField("path", value.path);
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<PathLinkMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PathLinkMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(PathLinkMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<PathLinkMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public PathLinkMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p, "path");

            String url = null;
            Visibility visibility = null;
            String path = null;
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
                else if ("path".equals(_field)) {
                    path = getStringValue(_p);
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
            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new PathLinkMetadata(url, visibility, path, expires);
        }
    }
}
