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

public class SharedLink {
    // struct files.SharedLink (files.stone)

    protected final String url;
    protected final String password;

    /**
     *
     * @param url  Shared link url. Must not be {@code null}.
     * @param password  Password for the shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLink(String url, String password) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        this.password = password;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  Shared link url. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLink(String url) {
        this(url, null);
    }

    /**
     * Shared link url.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * Password for the shared link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            url,
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
            SharedLink other = (SharedLink) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
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
    static class Serializer extends StructSerializer<SharedLink> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLink value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            if (value.password != null) {
                g.writeFieldName("password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.password, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLink deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLink value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                String f_password = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
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
                value = new SharedLink(f_url, f_password);
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
