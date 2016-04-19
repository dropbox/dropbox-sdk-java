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

@JsonSerialize(using=CreateSharedLinkArg.Serializer.class)
@JsonDeserialize(using=CreateSharedLinkArg.Deserializer.class)
class CreateSharedLinkArg {
    // struct CreateSharedLinkArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final boolean shortUrl;
    protected final PendingUploadMode pendingUpload;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to share. Must not be {@code null}.
     * @param shortUrl  Whether to return a shortened URL.
     * @param pendingUpload  If it's okay to share a path that does not yet
     *     exist, set this to either {@link PendingUploadMode#FILE} or {@link
     *     PendingUploadMode#FOLDER} to indicate whether to assume it's a file
     *     or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkArg(String path, boolean shortUrl, PendingUploadMode pendingUpload) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = path;
        this.shortUrl = shortUrl;
        this.pendingUpload = pendingUpload;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkArg(String path) {
        this(path, false, null);
    }

    /**
     * The path to share.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Whether to return a shortened URL.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getShortUrl() {
        return shortUrl;
    }

    /**
     * If it's okay to share a path that does not yet exist, set this to either
     * {@link PendingUploadMode#FILE} or {@link PendingUploadMode#FOLDER} to
     * indicate whether to assume it's a file or folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public PendingUploadMode getPendingUpload() {
        return pendingUpload;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link CreateSharedLinkArg}.
     */
    public static class Builder {
        protected final String path;

        protected boolean shortUrl;
        protected PendingUploadMode pendingUpload;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            this.path = path;
            this.shortUrl = false;
            this.pendingUpload = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param shortUrl  Whether to return a shortened URL. Defaults to
         *     {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withShortUrl(Boolean shortUrl) {
            if (shortUrl != null) {
                this.shortUrl = shortUrl;
            }
            else {
                this.shortUrl = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param pendingUpload  If it's okay to share a path that does not yet
         *     exist, set this to either {@link PendingUploadMode#FILE} or
         *     {@link PendingUploadMode#FOLDER} to indicate whether to assume
         *     it's a file or folder.
         *
         * @return this builder
         */
        public Builder withPendingUpload(PendingUploadMode pendingUpload) {
            this.pendingUpload = pendingUpload;
            return this;
        }

        /**
         * Builds an instance of {@link CreateSharedLinkArg} configured with
         * this builder's values
         *
         * @return new instance of {@link CreateSharedLinkArg}
         */
        public CreateSharedLinkArg build() {
            return new CreateSharedLinkArg(path, shortUrl, pendingUpload);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            shortUrl,
            pendingUpload
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
            CreateSharedLinkArg other = (CreateSharedLinkArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.shortUrl == other.shortUrl)
                && ((this.pendingUpload == other.pendingUpload) || (this.pendingUpload != null && this.pendingUpload.equals(other.pendingUpload)))
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

    static final class Serializer extends StructJsonSerializer<CreateSharedLinkArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(CreateSharedLinkArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(CreateSharedLinkArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<CreateSharedLinkArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(CreateSharedLinkArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("short_url", value.shortUrl);
            if (value.pendingUpload != null) {
                g.writeObjectField("pending_upload", value.pendingUpload);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<CreateSharedLinkArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(CreateSharedLinkArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(CreateSharedLinkArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<CreateSharedLinkArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public CreateSharedLinkArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            boolean shortUrl = false;
            PendingUploadMode pendingUpload = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("short_url".equals(_field)) {
                    shortUrl = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("pending_upload".equals(_field)) {
                    pendingUpload = _p.readValueAs(PendingUploadMode.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new CreateSharedLinkArg(path, shortUrl, pendingUpload);
        }
    }
}
