/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

class CreateSharedLinkArg {
    // struct sharing.CreateSharedLinkArg (shared_links.stone)

    protected final String path;
    protected final boolean shortUrl;
    protected final PendingUploadMode pendingUpload;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to share. Must not be {@code null}.
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
     * None
     *
     * <p> The default values for unset fields will be used. </p>
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
         * @param shortUrl  Defaults to {@code false} when set to {@code null}.
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<CreateSharedLinkArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateSharedLinkArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("short_url");
            StoneSerializers.boolean_().serialize(value.shortUrl, g);
            if (value.pendingUpload != null) {
                g.writeFieldName("pending_upload");
                StoneSerializers.nullable(PendingUploadMode.Serializer.INSTANCE).serialize(value.pendingUpload, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CreateSharedLinkArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CreateSharedLinkArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                Boolean f_shortUrl = false;
                PendingUploadMode f_pendingUpload = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("short_url".equals(field)) {
                        f_shortUrl = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("pending_upload".equals(field)) {
                        f_pendingUpload = StoneSerializers.nullable(PendingUploadMode.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new CreateSharedLinkArg(f_path, f_shortUrl, f_pendingUpload);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
