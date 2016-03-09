/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

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

@JsonSerialize(using=DeviceSession.Serializer.class)
@JsonDeserialize(using=DeviceSession.Deserializer.class)
public class DeviceSession {
    // struct DeviceSession

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String sessionId;
    protected final String ipAddress;
    protected final String country;
    protected final Date created;
    protected final Date updated;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param country  The country from which the last activity from this
     *     session was made.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSession(String sessionId, String ipAddress, String country, Date created, Date updated) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        this.ipAddress = ipAddress;
        this.country = country;
        this.created = com.dropbox.core.util.LangUtil.truncateMillis(created);
        this.updated = com.dropbox.core.util.LangUtil.truncateMillis(updated);
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSession(String sessionId) {
        this(sessionId, null, null, null, null);
    }

    /**
     * The session id
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The IP address of the last activity from this session
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The country from which the last activity from this session was made
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCountry() {
        return country;
    }

    /**
     * The time this session was created
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sessionId) {
        return new Builder(sessionId);
    }

    /**
     * Builder for {@link DeviceSession}.
     */
    public static class Builder {
        protected final String sessionId;

        protected String ipAddress;
        protected String country;
        protected Date created;
        protected Date updated;

        protected Builder(String sessionId) {
            if (sessionId == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
            }
            this.sessionId = sessionId;
            this.ipAddress = null;
            this.country = null;
            this.created = null;
            this.updated = null;
        }

        /**
         * Set value for optional field.
         *
         * @param ipAddress  The IP address of the last activity from this
         *     session.
         *
         * @return this builder
         */
        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param country  The country from which the last activity from this
         *     session was made.
         *
         * @return this builder
         */
        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param created  The time this session was created.
         *
         * @return this builder
         */
        public Builder withCreated(Date created) {
            this.created = com.dropbox.core.util.LangUtil.truncateMillis(created);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param updated  The time of the last activity from this session.
         *
         * @return this builder
         */
        public Builder withUpdated(Date updated) {
            this.updated = com.dropbox.core.util.LangUtil.truncateMillis(updated);
            return this;
        }

        /**
         * Builds an instance of {@link DeviceSession} configured with this
         * builder's values
         *
         * @return new instance of {@link DeviceSession}
         */
        public DeviceSession build() {
            return new DeviceSession(sessionId, ipAddress, country, created, updated);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sessionId,
            ipAddress,
            country,
            created,
            updated
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
            DeviceSession other = (DeviceSession) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
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

    static final class Serializer extends StructJsonSerializer<DeviceSession> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DeviceSession.class);
        }

        public Serializer(boolean unwrapping) {
            super(DeviceSession.class, unwrapping);
        }

        @Override
        protected JsonSerializer<DeviceSession> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(DeviceSession value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            if (value.ipAddress != null) {
                g.writeObjectField("ip_address", value.ipAddress);
            }
            if (value.country != null) {
                g.writeObjectField("country", value.country);
            }
            if (value.created != null) {
                g.writeObjectField("created", value.created);
            }
            if (value.updated != null) {
                g.writeObjectField("updated", value.updated);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<DeviceSession> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DeviceSession.class);
        }

        public Deserializer(boolean unwrapping) {
            super(DeviceSession.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<DeviceSession> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public DeviceSession deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String ipAddress = null;
            String country = null;
            Date created = null;
            Date updated = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("ip_address".equals(_field)) {
                    ipAddress = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("country".equals(_field)) {
                    country = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("created".equals(_field)) {
                    created = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("updated".equals(_field)) {
                    updated = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }

            return new DeviceSession(sessionId, ipAddress, country, created, updated);
        }
    }
}
