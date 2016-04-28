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

@JsonSerialize(using=GetSharedLinkMetadataArg.Serializer.class)
@JsonDeserialize(using=GetSharedLinkMetadataArg.Deserializer.class)
public class GetSharedLinkMetadataArg {
    // struct GetSharedLinkMetadataArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String url;
    protected final String path;
    protected final String linkPassword;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param path  If the shared link is to a folder, this parameter can be
     *     used to retrieve the metadata for a specific file or sub-folder in
     *     this folder. A relative path should be used. Must match pattern
     *     "{@code /.*}".
     * @param linkPassword  If the shared link has a password, this parameter
     *     can be used.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkMetadataArg(String url, String path, String linkPassword) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (path != null) {
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
        }
        this.path = path;
        this.linkPassword = linkPassword;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkMetadataArg(String url) {
        this(url, null, null);
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
     * If the shared link is to a folder, this parameter can be used to retrieve
     * the metadata for a specific file or sub-folder in this folder. A relative
     * path should be used.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPath() {
        return path;
    }

    /**
     * If the shared link has a password, this parameter can be used.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLinkPassword() {
        return linkPassword;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String url) {
        return new Builder(url);
    }

    /**
     * Builder for {@link GetSharedLinkMetadataArg}.
     */
    public static class Builder {
        protected final String url;

        protected String path;
        protected String linkPassword;

        protected Builder(String url) {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
            this.path = null;
            this.linkPassword = null;
        }

        /**
         * Set value for optional field.
         *
         * @param path  If the shared link is to a folder, this parameter can be
         *     used to retrieve the metadata for a specific file or sub-folder
         *     in this folder. A relative path should be used. Must match
         *     pattern "{@code /.*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPath(String path) {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("/.*", path)) {
                    throw new IllegalArgumentException("String 'path' does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkPassword  If the shared link has a password, this
         *     parameter can be used.
         *
         * @return this builder
         */
        public Builder withLinkPassword(String linkPassword) {
            this.linkPassword = linkPassword;
            return this;
        }

        /**
         * Builds an instance of {@link GetSharedLinkMetadataArg} configured
         * with this builder's values
         *
         * @return new instance of {@link GetSharedLinkMetadataArg}
         */
        public GetSharedLinkMetadataArg build() {
            return new GetSharedLinkMetadataArg(url, path, linkPassword);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            url,
            path,
            linkPassword
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
            GetSharedLinkMetadataArg other = (GetSharedLinkMetadataArg) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
                && ((this.linkPassword == other.linkPassword) || (this.linkPassword != null && this.linkPassword.equals(other.linkPassword)))
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

    static final class Serializer extends StructJsonSerializer<GetSharedLinkMetadataArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetSharedLinkMetadataArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetSharedLinkMetadataArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetSharedLinkMetadataArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetSharedLinkMetadataArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("url", value.url);
            if (value.path != null) {
                g.writeObjectField("path", value.path);
            }
            if (value.linkPassword != null) {
                g.writeObjectField("link_password", value.linkPassword);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetSharedLinkMetadataArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetSharedLinkMetadataArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetSharedLinkMetadataArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetSharedLinkMetadataArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetSharedLinkMetadataArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String url = null;
            String path = null;
            String linkPassword = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("url".equals(_field)) {
                    url = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("link_password".equals(_field)) {
                    linkPassword = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (url == null) {
                throw new JsonParseException(_p, "Required field \"url\" is missing.");
            }

            return new GetSharedLinkMetadataArg(url, path, linkPassword);
        }
    }
}
