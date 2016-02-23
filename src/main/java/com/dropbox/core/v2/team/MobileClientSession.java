/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Information about linked Dropbox mobile client sessions
 */
public class MobileClientSession extends DeviceSession {
    // struct MobileClientSession

    private final String deviceName;
    private final MobileClientPlatform clientType;
    private final String clientVersion;
    private final String osVersion;
    private final String lastCarrier;

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
            return ((this.deviceName == other.deviceName) || (this.deviceName.equals(other.deviceName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion != null && this.clientVersion.equals(other.clientVersion)))
                && ((this.osVersion == other.osVersion) || (this.osVersion != null && this.osVersion.equals(other.osVersion)))
                && ((this.lastCarrier == other.lastCarrier) || (this.lastCarrier != null && this.lastCarrier.equals(other.lastCarrier)))
                && ((this.getSessionId() == other.getSessionId()) || (this.getSessionId().equals(other.getSessionId())))
                && ((this.getIpAddress() == other.getIpAddress()) || (this.getIpAddress() != null && this.getIpAddress().equals(other.getIpAddress())))
                && ((this.getCountry() == other.getCountry()) || (this.getCountry() != null && this.getCountry().equals(other.getCountry())))
                && ((this.getCreated() == other.getCreated()) || (this.getCreated() != null && this.getCreated().equals(other.getCreated())))
                && ((this.getUpdated() == other.getUpdated()) || (this.getUpdated() != null && this.getUpdated().equals(other.getUpdated())))
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

    public static MobileClientSession fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MobileClientSession> _JSON_WRITER = new JsonWriter<MobileClientSession>() {
        public final void write(MobileClientSession x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSession._JSON_WRITER.writeFields(x, g);
            MobileClientSession._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MobileClientSession x, JsonGenerator g) throws IOException {
            g.writeFieldName("device_name");
            g.writeString(x.deviceName);
            g.writeFieldName("client_type");
            MobileClientPlatform._JSON_WRITER.write(x.clientType, g);
            if (x.clientVersion != null) {
                g.writeFieldName("client_version");
                g.writeString(x.clientVersion);
            }
            if (x.osVersion != null) {
                g.writeFieldName("os_version");
                g.writeString(x.osVersion);
            }
            if (x.lastCarrier != null) {
                g.writeFieldName("last_carrier");
                g.writeString(x.lastCarrier);
            }
        }
    };

    public static final JsonReader<MobileClientSession> _JSON_READER = new JsonReader<MobileClientSession>() {
        public final MobileClientSession read(JsonParser parser) throws IOException, JsonReadException {
            MobileClientSession result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MobileClientSession readFields(JsonParser parser) throws IOException, JsonReadException {
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
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else if ("device_name".equals(fieldName)) {
                    deviceName = JsonReader.StringReader
                        .readField(parser, "device_name", deviceName);
                }
                else if ("client_type".equals(fieldName)) {
                    clientType = MobileClientPlatform._JSON_READER
                        .readField(parser, "client_type", clientType);
                }
                else if ("ip_address".equals(fieldName)) {
                    ipAddress = JsonReader.StringReader
                        .readField(parser, "ip_address", ipAddress);
                }
                else if ("country".equals(fieldName)) {
                    country = JsonReader.StringReader
                        .readField(parser, "country", country);
                }
                else if ("created".equals(fieldName)) {
                    created = JsonDateReader.DropboxV2
                        .readField(parser, "created", created);
                }
                else if ("updated".equals(fieldName)) {
                    updated = JsonDateReader.DropboxV2
                        .readField(parser, "updated", updated);
                }
                else if ("client_version".equals(fieldName)) {
                    clientVersion = JsonReader.StringReader
                        .readField(parser, "client_version", clientVersion);
                }
                else if ("os_version".equals(fieldName)) {
                    osVersion = JsonReader.StringReader
                        .readField(parser, "os_version", osVersion);
                }
                else if ("last_carrier".equals(fieldName)) {
                    lastCarrier = JsonReader.StringReader
                        .readField(parser, "last_carrier", lastCarrier);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sessionId == null) {
                throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
            }
            if (deviceName == null) {
                throw new JsonReadException("Required field \"device_name\" is missing.", parser.getTokenLocation());
            }
            if (clientType == null) {
                throw new JsonReadException("Required field \"client_type\" is missing.", parser.getTokenLocation());
            }
            return new MobileClientSession(sessionId, deviceName, clientType, ipAddress, country, created, updated, clientVersion, osVersion, lastCarrier);
        }
    };
}
