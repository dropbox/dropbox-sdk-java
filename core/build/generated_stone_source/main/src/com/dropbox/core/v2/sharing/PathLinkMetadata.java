/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Metadata for a path-based shared link.
 */
public class PathLinkMetadata extends LinkMetadata {
    // struct sharing.PathLinkMetadata (shared_links.stone)

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
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * Who can access the link.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * Path in user's Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Expiration time, if set. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getExpires() {
        return expires;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<PathLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("path", g);
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("visibility");
            Visibility.Serializer.INSTANCE.serialize(value.visibility, g);
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (value.expires != null) {
                g.writeFieldName("expires");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expires, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PathLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PathLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("path".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_url = null;
                Visibility f_visibility = null;
                String f_path = null;
                Date f_expires = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("visibility".equals(field)) {
                        f_visibility = Visibility.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("expires".equals(field)) {
                        f_expires = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_visibility == null) {
                    throw new JsonParseException(p, "Required field \"visibility\" missing.");
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new PathLinkMetadata(f_url, f_visibility, f_path, f_expires);
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
