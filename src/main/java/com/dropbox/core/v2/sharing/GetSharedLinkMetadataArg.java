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

public class GetSharedLinkMetadataArg {
    // struct GetSharedLinkMetadataArg

    private final String url;
    private final String path;
    private final String linkPassword;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GetSharedLinkMetadataArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetSharedLinkMetadataArg> _JSON_WRITER = new JsonWriter<GetSharedLinkMetadataArg>() {
        public final void write(GetSharedLinkMetadataArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GetSharedLinkMetadataArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetSharedLinkMetadataArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("url");
            g.writeString(x.url);
            if (x.path != null) {
                g.writeFieldName("path");
                g.writeString(x.path);
            }
            if (x.linkPassword != null) {
                g.writeFieldName("link_password");
                g.writeString(x.linkPassword);
            }
        }
    };

    public static final JsonReader<GetSharedLinkMetadataArg> _JSON_READER = new JsonReader<GetSharedLinkMetadataArg>() {
        public final GetSharedLinkMetadataArg read(JsonParser parser) throws IOException, JsonReadException {
            GetSharedLinkMetadataArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetSharedLinkMetadataArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            String path = null;
            String linkPassword = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("url".equals(fieldName)) {
                    url = JsonReader.StringReader
                        .readField(parser, "url", url);
                }
                else if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("link_password".equals(fieldName)) {
                    linkPassword = JsonReader.StringReader
                        .readField(parser, "link_password", linkPassword);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (url == null) {
                throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
            }
            return new GetSharedLinkMetadataArg(url, path, linkPassword);
        }
    };
}
