/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public class SharedLinkFileInfo {
    // struct files.SharedLinkFileInfo (files.stone)

    protected final String url;
    protected final String path;
    protected final String password;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param url  The shared link corresponding to either a file or shared link
     *     to a folder. If it is for a folder shared link, we use the path param
     *     to determine for which file in the folder the view is for. Must not
     *     be {@code null}.
     * @param path  The path corresponding to a file in a shared link to a
     *     folder. Required for shared links to folders.
     * @param password  Password for the shared link. Required for
     *     password-protected shared links to files  unless it can be read from
     *     a cookie.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkFileInfo(@javax.annotation.Nonnull String url, @javax.annotation.Nullable String path, @javax.annotation.Nullable String password) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        this.path = path;
        this.password = password;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  The shared link corresponding to either a file or shared link
     *     to a folder. If it is for a folder shared link, we use the path param
     *     to determine for which file in the folder the view is for. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkFileInfo(String url) {
        this(url, null, null);
    }

    /**
     * The shared link corresponding to either a file or shared link to a
     * folder. If it is for a folder shared link, we use the path param to
     * determine for which file in the folder the view is for.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * The path corresponding to a file in a shared link to a folder. Required
     * for shared links to folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPath() {
        return path;
    }

    /**
     * Password for the shared link. Required for password-protected shared
     * links to files  unless it can be read from a cookie.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPassword() {
        return password;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  The shared link corresponding to either a file or shared link
     *     to a folder. If it is for a folder shared link, we use the path param
     *     to determine for which file in the folder the view is for. Must not
     *     be {@code null}.
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
     * Builder for {@link SharedLinkFileInfo}.
     */
    public static class Builder {
        protected final String url;

        protected String path;
        protected String password;

        protected Builder(String url) {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
            this.path = null;
            this.password = null;
        }

        /**
         * Set value for optional field.
         *
         * @param path  The path corresponding to a file in a shared link to a
         *     folder. Required for shared links to folders.
         *
         * @return this builder
         */
        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param password  Password for the shared link. Required for
         *     password-protected shared links to files  unless it can be read
         *     from a cookie.
         *
         * @return this builder
         */
        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkFileInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedLinkFileInfo}
         */
        public SharedLinkFileInfo build() {
            return new SharedLinkFileInfo(url, path, password);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            url,
            path,
            password
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
            SharedLinkFileInfo other = (SharedLinkFileInfo) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
                && ((this.password == other.password) || (this.password != null && this.password.equals(other.password)))
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
    static class Serializer extends StructSerializer<SharedLinkFileInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkFileInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            if (value.password != null) {
                g.writeFieldName("password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.password, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkFileInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkFileInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                String f_path = null;
                String f_password = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("password".equals(field)) {
                        f_password = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                value = new SharedLinkFileInfo(f_url, f_path, f_password);
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
