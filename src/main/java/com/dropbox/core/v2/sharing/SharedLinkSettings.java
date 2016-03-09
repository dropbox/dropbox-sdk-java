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
import java.util.Date;

@JsonSerialize(using=SharedLinkSettings.Serializer.class)
@JsonDeserialize(using=SharedLinkSettings.Deserializer.class)
public class SharedLinkSettings {
    // struct SharedLinkSettings

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<SharedLinkSettings> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkSettings.class);
        }

        public Serializer(boolean unwrapping) {
            super(SharedLinkSettings.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SharedLinkSettings> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SharedLinkSettings value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.requestedVisibility != null) {
                g.writeObjectField("requested_visibility", value.requestedVisibility);
            }
            if (value.linkPassword != null) {
                g.writeObjectField("link_password", value.linkPassword);
            }
            if (value.expires != null) {
                g.writeObjectField("expires", value.expires);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SharedLinkSettings> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkSettings.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SharedLinkSettings.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SharedLinkSettings> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SharedLinkSettings deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            RequestedVisibility requestedVisibility = null;
            String linkPassword = null;
            Date expires = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("requested_visibility".equals(_field)) {
                    requestedVisibility = _p.readValueAs(RequestedVisibility.class);
                    _p.nextToken();
                }
                else if ("link_password".equals(_field)) {
                    linkPassword = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("expires".equals(_field)) {
                    expires = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new SharedLinkSettings(requestedVisibility, linkPassword, expires);
        }
    }
}
