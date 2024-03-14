/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Information about linked Dropbox mobile client sessions.
 */
public class MobileClientSession extends DeviceSession {
    // struct team.MobileClientSession (team_devices.stone)

    protected final String deviceName;
    protected final MobileClientPlatform clientType;
    protected final String clientVersion;
    protected final String osVersion;
    protected final String lastCarrier;

    /**
     * Information about linked Dropbox mobile client sessions.
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
    public MobileClientSession(@Nonnull String sessionId, @Nonnull String deviceName, @Nonnull MobileClientPlatform clientType, @Nullable String ipAddress, @Nullable String country, @Nullable Date created, @Nullable Date updated, @Nullable String clientVersion, @Nullable String osVersion, @Nullable String lastCarrier) {
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
     * Information about linked Dropbox mobile client sessions.
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
     * The session id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The device name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * The mobile application type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MobileClientPlatform getClientType() {
        return clientType;
    }

    /**
     * The IP address of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The country from which the last activity from this session was made.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCountry() {
        return country;
    }

    /**
     * The time this session was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getUpdated() {
        return updated;
    }

    /**
     * The dropbox client version.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * The hosting OS version.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * last carrier used by the device.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
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
         * Set value for optional field.
         *
         * @param ipAddress  The IP address of the last activity from this
         *     session.
         *
         * @return this builder
         */
        public Builder withIpAddress(String ipAddress) {
            super.withIpAddress(ipAddress);
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
            super.withCountry(country);
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
            super.withCreated(created);
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
            super.withUpdated(updated);
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<MobileClientSession> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MobileClientSession value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            g.writeFieldName("device_name");
            StoneSerializers.string().serialize(value.deviceName, g);
            g.writeFieldName("client_type");
            MobileClientPlatform.Serializer.INSTANCE.serialize(value.clientType, g);
            if (value.ipAddress != null) {
                g.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.ipAddress, g);
            }
            if (value.country != null) {
                g.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.country, g);
            }
            if (value.created != null) {
                g.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.created, g);
            }
            if (value.updated != null) {
                g.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.updated, g);
            }
            if (value.clientVersion != null) {
                g.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.clientVersion, g);
            }
            if (value.osVersion != null) {
                g.writeFieldName("os_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.osVersion, g);
            }
            if (value.lastCarrier != null) {
                g.writeFieldName("last_carrier");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.lastCarrier, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MobileClientSession deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MobileClientSession value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                String f_deviceName = null;
                MobileClientPlatform f_clientType = null;
                String f_ipAddress = null;
                String f_country = null;
                Date f_created = null;
                Date f_updated = null;
                String f_clientVersion = null;
                String f_osVersion = null;
                String f_lastCarrier = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("device_name".equals(field)) {
                        f_deviceName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("client_type".equals(field)) {
                        f_clientType = MobileClientPlatform.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("country".equals(field)) {
                        f_country = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("updated".equals(field)) {
                        f_updated = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("client_version".equals(field)) {
                        f_clientVersion = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("os_version".equals(field)) {
                        f_osVersion = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("last_carrier".equals(field)) {
                        f_lastCarrier = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                if (f_deviceName == null) {
                    throw new JsonParseException(p, "Required field \"device_name\" missing.");
                }
                if (f_clientType == null) {
                    throw new JsonParseException(p, "Required field \"client_type\" missing.");
                }
                value = new MobileClientSession(f_sessionId, f_deviceName, f_clientType, f_ipAddress, f_country, f_created, f_updated, f_clientVersion, f_osVersion, f_lastCarrier);
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
