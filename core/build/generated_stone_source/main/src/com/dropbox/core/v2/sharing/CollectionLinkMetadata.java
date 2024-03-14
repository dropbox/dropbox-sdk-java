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
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Metadata for a collection-based shared link.
 */
public class CollectionLinkMetadata extends LinkMetadata {
    // struct sharing.CollectionLinkMetadata (shared_links.stone)


    /**
     * Metadata for a collection-based shared link.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     * @param expires  Expiration time, if set. By default the link won't
     *     expire.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CollectionLinkMetadata(@Nonnull String url, @Nonnull Visibility visibility, @Nullable Date expires) {
        super(url, visibility, expires);
    }

    /**
     * Metadata for a collection-based shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param visibility  Who can access the link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CollectionLinkMetadata(String url, Visibility visibility) {
        this(url, visibility, null);
    }

    /**
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * Who can access the link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * Expiration time, if set. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getExpires() {
        return expires;
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
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
            CollectionLinkMetadata other = (CollectionLinkMetadata) obj;
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
    static class Serializer extends StructSerializer<CollectionLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CollectionLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("collection", g);
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("visibility");
            Visibility.Serializer.INSTANCE.serialize(value.visibility, g);
            if (value.expires != null) {
                g.writeFieldName("expires");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expires, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CollectionLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CollectionLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("collection".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_url = null;
                Visibility f_visibility = null;
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
                value = new CollectionLinkMetadata(f_url, f_visibility, f_expires);
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
