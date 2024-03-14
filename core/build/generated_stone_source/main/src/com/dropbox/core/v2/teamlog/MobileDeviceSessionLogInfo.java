/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.team.MobileClientPlatform;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Information about linked Dropbox mobile client sessions
 */
public class MobileDeviceSessionLogInfo extends DeviceSessionLogInfo {
    // struct team_log.MobileDeviceSessionLogInfo (team_log_generated.stone)

    protected final MobileSessionLogInfo sessionInfo;
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
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     * @param sessionInfo  Mobile session unique id.
     * @param clientVersion  The Dropbox client version.
     * @param osVersion  The hosting OS version.
     * @param lastCarrier  last carrier used by the device.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MobileDeviceSessionLogInfo(@javax.annotation.Nonnull String deviceName, @javax.annotation.Nonnull MobileClientPlatform clientType, @javax.annotation.Nullable String ipAddress, @javax.annotation.Nullable Date created, @javax.annotation.Nullable Date updated, @javax.annotation.Nullable MobileSessionLogInfo sessionInfo, @javax.annotation.Nullable String clientVersion, @javax.annotation.Nullable String osVersion, @javax.annotation.Nullable String lastCarrier) {
        super(ipAddress, created, updated);
        this.sessionInfo = sessionInfo;
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
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MobileDeviceSessionLogInfo(String deviceName, MobileClientPlatform clientType) {
        this(deviceName, clientType, null, null, null, null, null, null, null);
    }

    /**
     * The device name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * The mobile application type.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public MobileClientPlatform getClientType() {
        return clientType;
    }

    /**
     * The IP address of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The time this session was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getUpdated() {
        return updated;
    }

    /**
     * Mobile session unique id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public MobileSessionLogInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * The Dropbox client version.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * The hosting OS version.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * last carrier used by the device.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getLastCarrier() {
        return lastCarrier;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param deviceName  The device name. Must not be {@code null}.
     * @param clientType  The mobile application type. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String deviceName, MobileClientPlatform clientType) {
        return new Builder(deviceName, clientType);
    }

    /**
     * Builder for {@link MobileDeviceSessionLogInfo}.
     */
    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final String deviceName;
        protected final MobileClientPlatform clientType;

        protected MobileSessionLogInfo sessionInfo;
        protected String clientVersion;
        protected String osVersion;
        protected String lastCarrier;

        protected Builder(String deviceName, MobileClientPlatform clientType) {
            if (deviceName == null) {
                throw new IllegalArgumentException("Required value for 'deviceName' is null");
            }
            this.deviceName = deviceName;
            if (clientType == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = clientType;
            this.sessionInfo = null;
            this.clientVersion = null;
            this.osVersion = null;
            this.lastCarrier = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sessionInfo  Mobile session unique id.
         *
         * @return this builder
         */
        public Builder withSessionInfo(MobileSessionLogInfo sessionInfo) {
            this.sessionInfo = sessionInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param clientVersion  The Dropbox client version.
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
         * Builds an instance of {@link MobileDeviceSessionLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link MobileDeviceSessionLogInfo}
         */
        public MobileDeviceSessionLogInfo build() {
            return new MobileDeviceSessionLogInfo(deviceName, clientType, ipAddress, created, updated, sessionInfo, clientVersion, osVersion, lastCarrier);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
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
            MobileDeviceSessionLogInfo other = (MobileDeviceSessionLogInfo) obj;
            return ((this.deviceName == other.deviceName) || (this.deviceName.equals(other.deviceName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
                && ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
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
    static class Serializer extends StructSerializer<MobileDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MobileDeviceSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("mobile_device_session", g);
            g.writeFieldName("device_name");
            StoneSerializers.string().serialize(value.deviceName, g);
            g.writeFieldName("client_type");
            MobileClientPlatform.Serializer.INSTANCE.serialize(value.clientType, g);
            if (value.ipAddress != null) {
                g.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.ipAddress, g);
            }
            if (value.created != null) {
                g.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.created, g);
            }
            if (value.updated != null) {
                g.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.updated, g);
            }
            if (value.sessionInfo != null) {
                g.writeFieldName("session_info");
                StoneSerializers.nullableStruct(MobileSessionLogInfo.Serializer.INSTANCE).serialize(value.sessionInfo, g);
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
        public MobileDeviceSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MobileDeviceSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("mobile_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_deviceName = null;
                MobileClientPlatform f_clientType = null;
                String f_ipAddress = null;
                Date f_created = null;
                Date f_updated = null;
                MobileSessionLogInfo f_sessionInfo = null;
                String f_clientVersion = null;
                String f_osVersion = null;
                String f_lastCarrier = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("device_name".equals(field)) {
                        f_deviceName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("client_type".equals(field)) {
                        f_clientType = MobileClientPlatform.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("updated".equals(field)) {
                        f_updated = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("session_info".equals(field)) {
                        f_sessionInfo = StoneSerializers.nullableStruct(MobileSessionLogInfo.Serializer.INSTANCE).deserialize(p);
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
                if (f_deviceName == null) {
                    throw new JsonParseException(p, "Required field \"device_name\" missing.");
                }
                if (f_clientType == null) {
                    throw new JsonParseException(p, "Required field \"client_type\" missing.");
                }
                value = new MobileDeviceSessionLogInfo(f_deviceName, f_clientType, f_ipAddress, f_created, f_updated, f_sessionInfo, f_clientVersion, f_osVersion, f_lastCarrier);
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
