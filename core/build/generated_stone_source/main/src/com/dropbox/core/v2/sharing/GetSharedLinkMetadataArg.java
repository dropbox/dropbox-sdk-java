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

class GetSharedLinkMetadataArg {
    // struct sharing.GetSharedLinkMetadataArg (shared_links.stone)

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
     *     "{@code /(.|[\\r\\n])*}".
     * @param linkPassword  If the shared link has a password, this parameter
     *     can be used.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkMetadataArg(@javax.annotation.Nonnull String url, @javax.annotation.Nullable String path, @javax.annotation.Nullable String linkPassword) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (path != null) {
            if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
        }
        this.path = path;
        this.linkPassword = linkPassword;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
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
    @javax.annotation.Nonnull
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
    @javax.annotation.Nullable
    public String getPath() {
        return path;
    }

    /**
     * If the shared link has a password, this parameter can be used.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
         *     pattern "{@code /(.|[\\r\\n])*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPath(String path) {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<GetSharedLinkMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetSharedLinkMetadataArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            if (value.linkPassword != null) {
                g.writeFieldName("link_password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.linkPassword, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetSharedLinkMetadataArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetSharedLinkMetadataArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                String f_path = null;
                String f_linkPassword = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("link_password".equals(field)) {
                        f_linkPassword = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                value = new GetSharedLinkMetadataArg(f_url, f_path, f_linkPassword);
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
