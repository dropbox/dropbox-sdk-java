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

/**
 * Information about linked Dropbox mobile client sessions
 */
@JsonSerialize(using=MobileClientSession.Serializer.class)
@JsonDeserialize(using=MobileClientSession.Deserializer.class)
public class MobileClientSession extends DeviceSession {
    // struct MobileClientSession

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String deviceName;
    protected final MobileClientPlatform clientType;
    protected final String clientVersion;
    protected final String osVersion;
    protected final String lastCarrier;

    /**
     * Information about linked Dropbox mobile client sessions
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param country  The country from which the last activity from this
     *     session was made.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     * @param clientVersion  The dropbox client version.
     * @param osVersion  The hosting OS version.
     * @param lastCarrier  last carrier used by the device.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MobileClientSession(String sessionId, String deviceName, MobileClientPlatform clientType, String ipAddress, String country, Date created, Date updated, String clientVersion, String osVersion, String lastCarrier) {
        super(sessionId, ipAddress, country, created, updated);
        if (deviceName == null) {
            throw new IllegalArgumentException("Required value for 'deviceName' is null");
        }
        this.deviceName = deviceName;
        if (clientType == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = clientType;
        this.clientVersion = clientVersion;
        this.osVersion = osVersion;
        this.lastCarrier = lastCarrier;
    }

    /**
     * Information about linked Dropbox mobile client sessions
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MobileClientSession(String sessionId, String deviceName, MobileClientPlatform clientType) {
        this(sessionId, deviceName, clientType, null, null, null, null, null, null, null);
    }

    /**
     * The device name
     *
     * @return value for this field, never {@code null}.
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * The mobile application type
     *
     * @return value for this field, never {@code null}.
     */
    public MobileClientPlatform getClientType() {
        return clientType;
    }

    /**
     * The dropbox client version
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * The hosting OS version
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * last carrier used by the device
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLastCarrier() {
        return lastCarrier;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sessionId, String deviceName, MobileClientPlatform clientType) {
        return new Builder(sessionId, deviceName, clientType);
    }

    /**
     * Builder for {@link MobileClientSession}.
     */
    public static class Builder extends DeviceSession.Builder {
        protected final String deviceName;
        protected final MobileClientPlatform clientType;

        protected String clientVersion;
        protected String osVersion;
        protected String lastCarrier;

        protected Builder(String sessionId, String deviceName, MobileClientPlatform clientType) {
            super(sessionId);
            if (deviceName == null) {
                throw new IllegalArgumentException("Required value for 'deviceName' is null");
            }
            this.deviceName = deviceName;
            if (clientType == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = clientType;
            this.clientVersion = null;
            this.osVersion = null;
            this.lastCarrier = null;
        }

        /**
         * Set value for optional field.
         *
         * @param clientVersion  The dropbox client version.
         *
         * @return this builder
         */
        public Builder withClientVersion(String clientVersion) {
            this.clientVersion = clientVersion;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param osVersion  The hosting OS version.
         *
         * @return this builder
         */
        public Builder withOsVersion(String osVersion) {
            this.osVersion = osVersion;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param lastCarrier  last carrier used by the device.
         *
         * @return this builder
         */
        public Builder withLastCarrier(String lastCarrier) {
            this.lastCarrier = lastCarrier;
            return this;
        }

        /**
         * Builds an instance of {@link MobileClientSession} configured with
         * this builder's values
         *
         * @return new instance of {@link MobileClientSession}
         */
        public MobileClientSession build() {
            return new MobileClientSession(sessionId, deviceName, clientType, ipAddress, country, created, updated, clientVersion, osVersion, lastCarrier);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            deviceName,
            clientType,
            clientVersion,
            osVersion,
            lastCarrier
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            MobileClientSession other = (MobileClientSession) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.deviceName == other.deviceName) || (this.deviceName.equals(other.deviceName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion != null && this.clientVersion.equals(other.clientVersion)))
                && ((this.osVersion == other.osVersion) || (this.osVersion != null && this.osVersion.equals(other.osVersion)))
                && ((this.lastCarrier == other.lastCarrier) || (this.lastCarrier != null && this.lastCarrier.equals(other.lastCarrier)))
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

    static final class Serializer extends StructJsonSerializer<MobileClientSession> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MobileClientSession.class);
        }

        public Serializer(boolean unwrapping) {
            super(MobileClientSession.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MobileClientSession> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MobileClientSession value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("device_name", value.deviceName);
            g.writeObjectField("client_type", value.clientType);
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
            if (value.clientVersion != null) {
                g.writeObjectField("client_version", value.clientVersion);
            }
            if (value.osVersion != null) {
                g.writeObjectField("os_version", value.osVersion);
            }
            if (value.lastCarrier != null) {
                g.writeObjectField("last_carrier", value.lastCarrier);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MobileClientSession> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MobileClientSession.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MobileClientSession.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MobileClientSession> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MobileClientSession deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String deviceName = null;
            MobileClientPlatform clientType = null;
            String ipAddress = null;
            String country = null;
            Date created = null;
            Date updated = null;
            String clientVersion = null;
            String osVersion = null;
            String lastCarrier = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("device_name".equals(_field)) {
                    deviceName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("client_type".equals(_field)) {
                    clientType = _p.readValueAs(MobileClientPlatform.class);
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
                else if ("client_version".equals(_field)) {
                    clientVersion = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("os_version".equals(_field)) {
                    osVersion = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("last_carrier".equals(_field)) {
                    lastCarrier = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }
            if (deviceName == null) {
                throw new JsonParseException(_p, "Required field \"device_name\" is missing.");
            }
            if (clientType == null) {
                throw new JsonParseException(_p, "Required field \"client_type\" is missing.");
            }

            return new MobileClientSession(sessionId, deviceName, clientType, ipAddress, country, created, updated, clientVersion, osVersion, lastCarrier);
        }
    }
}
