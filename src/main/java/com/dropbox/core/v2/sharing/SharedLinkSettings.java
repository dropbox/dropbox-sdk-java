/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public class SharedLinkSettings {
    // struct SharedLinkSettings

    protected final RequestedVisibility requestedVisibility;
    protected final String linkPassword;
    protected final Date expires;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param requestedVisibility  The requested access for this shared link.
     * @param linkPassword  If {@link SharedLinkSettings#getRequestedVisibility}
     *     is {@link RequestedVisibility#PASSWORD} this is needed to specify the
     *     password to access the link.
     * @param expires  Expiration time of the shared link. By default the link
     *     won't expire.
     */
    public SharedLinkSettings(RequestedVisibility requestedVisibility, String linkPassword, Date expires) {
        this.requestedVisibility = requestedVisibility;
        this.linkPassword = linkPassword;
        this.expires = com.dropbox.core.util.LangUtil.truncateMillis(expires);
    }

    /**
     * The default values for unset fields will be used.
     */
    public SharedLinkSettings() {
        this(null, null, null);
    }

    /**
     * The requested access for this shared link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public RequestedVisibility getRequestedVisibility() {
        return requestedVisibility;
    }

    /**
     * If {@link SharedLinkSettings#getRequestedVisibility} is {@link
     * RequestedVisibility#PASSWORD} this is needed to specify the password to
     * access the link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLinkPassword() {
        return linkPassword;
    }

    /**
     * Expiration time of the shared link. By default the link won't expire.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getExpires() {
        return expires;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link SharedLinkSettings}.
     */
    public static class Builder {

        protected RequestedVisibility requestedVisibility;
        protected String linkPassword;
        protected Date expires;

        protected Builder() {
            this.requestedVisibility = null;
            this.linkPassword = null;
            this.expires = null;
        }

        /**
         * Set value for optional field.
         *
         * @param requestedVisibility  The requested access for this shared
         *     link.
         *
         * @return this builder
         */
        public Builder withRequestedVisibility(RequestedVisibility requestedVisibility) {
            this.requestedVisibility = requestedVisibility;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkPassword  If {@link
         *     SharedLinkSettings#getRequestedVisibility} is {@link
         *     RequestedVisibility#PASSWORD} this is needed to specify the
         *     password to access the link.
         *
         * @return this builder
         */
        public Builder withLinkPassword(String linkPassword) {
            this.linkPassword = linkPassword;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expires  Expiration time of the shared link. By default the
         *     link won't expire.
         *
         * @return this builder
         */
        public Builder withExpires(Date expires) {
            this.expires = com.dropbox.core.util.LangUtil.truncateMillis(expires);
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkSettings} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedLinkSettings}
         */
        public SharedLinkSettings build() {
            return new SharedLinkSettings(requestedVisibility, linkPassword, expires);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            requestedVisibility,
            linkPassword,
            expires
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
            SharedLinkSettings other = (SharedLinkSettings) obj;
            return ((this.requestedVisibility == other.requestedVisibility) || (this.requestedVisibility != null && this.requestedVisibility.equals(other.requestedVisibility)))
                && ((this.linkPassword == other.linkPassword) || (this.linkPassword != null && this.linkPassword.equals(other.linkPassword)))
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
    static final class Serializer extends StructSerializer<SharedLinkSettings> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettings value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.requestedVisibility != null) {
                g.writeFieldName("requested_visibility");
                StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).serialize(value.requestedVisibility, g);
            }
            if (value.linkPassword != null) {
                g.writeFieldName("link_password");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.linkPassword, g);
            }
            if (value.expires != null) {
                g.writeFieldName("expires");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expires, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkSettings deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkSettings value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                RequestedVisibility f_requestedVisibility = null;
                String f_linkPassword = null;
                Date f_expires = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("requested_visibility".equals(field)) {
                        f_requestedVisibility = StoneSerializers.nullable(RequestedVisibility.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("link_password".equals(field)) {
                        f_linkPassword = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("expires".equals(field)) {
                        f_expires = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkSettings(f_requestedVisibility, f_linkPassword, f_expires);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
