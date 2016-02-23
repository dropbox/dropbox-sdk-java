/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class CreateSharedLinkArg {
    // struct CreateSharedLinkArg

    private final String path;
    private final boolean shortUrl;
    private final PendingUploadMode pendingUpload;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static CreateSharedLinkArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<CreateSharedLinkArg> _JSON_WRITER = new JsonWriter<CreateSharedLinkArg>() {
        public final void write(CreateSharedLinkArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            CreateSharedLinkArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(CreateSharedLinkArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("short_url");
            g.writeBoolean(x.shortUrl);
            if (x.pendingUpload != null) {
                g.writeFieldName("pending_upload");
                PendingUploadMode._JSON_WRITER.write(x.pendingUpload, g);
            }
        }
    };

    public static final JsonReader<CreateSharedLinkArg> _JSON_READER = new JsonReader<CreateSharedLinkArg>() {
        public final CreateSharedLinkArg read(JsonParser parser) throws IOException, JsonReadException {
            CreateSharedLinkArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final CreateSharedLinkArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            Boolean shortUrl = null;
            PendingUploadMode pendingUpload = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("short_url".equals(fieldName)) {
                    shortUrl = JsonReader.BooleanReader
                        .readField(parser, "short_url", shortUrl);
                }
                else if ("pending_upload".equals(fieldName)) {
                    pendingUpload = PendingUploadMode._JSON_READER
                        .readField(parser, "pending_upload", pendingUpload);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new CreateSharedLinkArg(path, shortUrl, pendingUpload);
        }
    };
}
