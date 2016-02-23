/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public class SharedLinkSettings {
    // struct SharedLinkSettings

    private final RequestedVisibility requestedVisibility;
    private final String linkPassword;
    private final Date expires;

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
        this.expires = expires;
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
            this.expires = expires;
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedLinkSettings fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedLinkSettings> _JSON_WRITER = new JsonWriter<SharedLinkSettings>() {
        public final void write(SharedLinkSettings x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharedLinkSettings._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharedLinkSettings x, JsonGenerator g) throws IOException {
            if (x.requestedVisibility != null) {
                g.writeFieldName("requested_visibility");
                RequestedVisibility._JSON_WRITER.write(x.requestedVisibility, g);
            }
            if (x.linkPassword != null) {
                g.writeFieldName("link_password");
                g.writeString(x.linkPassword);
            }
            if (x.expires != null) {
                g.writeFieldName("expires");
                writeDateIso(x.expires, g);
            }
        }
    };

    public static final JsonReader<SharedLinkSettings> _JSON_READER = new JsonReader<SharedLinkSettings>() {
        public final SharedLinkSettings read(JsonParser parser) throws IOException, JsonReadException {
            SharedLinkSettings result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharedLinkSettings readFields(JsonParser parser) throws IOException, JsonReadException {
            RequestedVisibility requestedVisibility = null;
            String linkPassword = null;
            Date expires = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("requested_visibility".equals(fieldName)) {
                    requestedVisibility = RequestedVisibility._JSON_READER
                        .readField(parser, "requested_visibility", requestedVisibility);
                }
                else if ("link_password".equals(fieldName)) {
                    linkPassword = JsonReader.StringReader
                        .readField(parser, "link_password", linkPassword);
                }
                else if ("expires".equals(fieldName)) {
                    expires = JsonDateReader.DropboxV2
                        .readField(parser, "expires", expires);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            return new SharedLinkSettings(requestedVisibility, linkPassword, expires);
        }
    };
}
