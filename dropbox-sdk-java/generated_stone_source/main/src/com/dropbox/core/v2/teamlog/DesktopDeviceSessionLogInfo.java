/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.team.DesktopPlatform;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Information about linked Dropbox desktop client sessions
 */
public class DesktopDeviceSessionLogInfo extends DeviceSessionLogInfo {
    // struct team_log.DesktopDeviceSessionLogInfo (team_log_generated.stone)

    protected final DesktopSessionLogInfo sessionInfo;
    protected final String hostName;
    protected final DesktopPlatform clientType;
    protected final String clientVersion;
    protected final String platform;
    protected final boolean isDeleteOnUnlinkSupported;

    /**
     * Information about linked Dropbox desktop client sessions
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether itu2019s possible to delete all
     *     of the account files upon unlinking.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     * @param sessionInfo  Desktop session unique id.
     * @param clientVersion  The Dropbox client version.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DesktopDeviceSessionLogInfo(String hostName, DesktopPlatform clientType, String platform, boolean isDeleteOnUnlinkSupported, String ipAddress, Date created, Date updated, DesktopSessionLogInfo sessionInfo, String clientVersion) {
        super(ipAddress, created, updated);
        this.sessionInfo = sessionInfo;
        if (hostName == null) {
            throw new IllegalArgumentException("Required value for 'hostName' is null");
        }
        this.hostName = hostName;
        if (clientType == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = clientType;
        this.clientVersion = clientVersion;
        if (platform == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = platform;
        this.isDeleteOnUnlinkSupported = isDeleteOnUnlinkSupported;
    }

    /**
     * Information about linked Dropbox desktop client sessions
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether itu2019s possible to delete all
     *     of the account files upon unlinking.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DesktopDeviceSessionLogInfo(String hostName, DesktopPlatform clientType, String platform, boolean isDeleteOnUnlinkSupported) {
        this(hostName, clientType, platform, isDeleteOnUnlinkSupported, null, null, null, null, null);
    }

    /**
     * Name of the hosting desktop.
     *
     * @return value for this field, never {@code null}.
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * The Dropbox desktop client type.
     *
     * @return value for this field, never {@code null}.
     */
    public DesktopPlatform getClientType() {
        return clientType;
    }

    /**
     * Information on the hosting platform.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Whether itu2019s possible to delete all of the account files upon
     * unlinking.
     *
     * @return value for this field.
     */
    public boolean getIsDeleteOnUnlinkSupported() {
        return isDeleteOnUnlinkSupported;
    }

    /**
     * The IP address of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The time this session was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Desktop session unique id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public DesktopSessionLogInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * The Dropbox client version.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether itu2019s possible to delete all
     *     of the account files upon unlinking.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String hostName, DesktopPlatform clientType, String platform, boolean isDeleteOnUnlinkSupported) {
        return new Builder(hostName, clientType, platform, isDeleteOnUnlinkSupported);
    }

    /**
     * Builder for {@link DesktopDeviceSessionLogInfo}.
     */
    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final String hostName;
        protected final DesktopPlatform clientType;
        protected final String platform;
        protected final boolean isDeleteOnUnlinkSupported;

        protected DesktopSessionLogInfo sessionInfo;
        protected String clientVersion;

        protected Builder(String hostName, DesktopPlatform clientType, String platform, boolean isDeleteOnUnlinkSupported) {
            if (hostName == null) {
                throw new IllegalArgumentException("Required value for 'hostName' is null");
            }
            this.hostName = hostName;
            if (clientType == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = clientType;
            if (platform == null) {
                throw new IllegalArgumentException("Required value for 'platform' is null");
            }
            this.platform = platform;
            this.isDeleteOnUnlinkSupported = isDeleteOnUnlinkSupported;
            this.sessionInfo = null;
            this.clientVersion = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sessionInfo  Desktop session unique id.
         *
         * @return this builder
         */
        public Builder withSessionInfo(DesktopSessionLogInfo sessionInfo) {
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
         * Builds an instance of {@link DesktopDeviceSessionLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link DesktopDeviceSessionLogInfo}
         */
        public DesktopDeviceSessionLogInfo build() {
            return new DesktopDeviceSessionLogInfo(hostName, clientType, platform, isDeleteOnUnlinkSupported, ipAddress, created, updated, sessionInfo, clientVersion);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
            hostName,
            clientType,
            clientVersion,
            platform,
            isDeleteOnUnlinkSupported
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
            DesktopDeviceSessionLogInfo other = (DesktopDeviceSessionLogInfo) obj;
            return ((this.hostName == other.hostName) || (this.hostName.equals(other.hostName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.platform == other.platform) || (this.platform.equals(other.platform)))
                && (this.isDeleteOnUnlinkSupported == other.isDeleteOnUnlinkSupported)
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
                && ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion != null && this.clientVersion.equals(other.clientVersion)))
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
    static class Serializer extends StructSerializer<DesktopDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DesktopDeviceSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("desktop_device_session", g);
            g.writeFieldName("host_name");
            StoneSerializers.string().serialize(value.hostName, g);
            g.writeFieldName("client_type");
            DesktopPlatform.Serializer.INSTANCE.serialize(value.clientType, g);
            g.writeFieldName("platform");
            StoneSerializers.string().serialize(value.platform, g);
            g.writeFieldName("is_delete_on_unlink_supported");
            StoneSerializers.boolean_().serialize(value.isDeleteOnUnlinkSupported, g);
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
                StoneSerializers.nullableStruct(DesktopSessionLogInfo.Serializer.INSTANCE).serialize(value.sessionInfo, g);
            }
            if (value.clientVersion != null) {
                g.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.clientVersion, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DesktopDeviceSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DesktopDeviceSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("desktop_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_hostName = null;
                DesktopPlatform f_clientType = null;
                String f_platform = null;
                Boolean f_isDeleteOnUnlinkSupported = null;
                String f_ipAddress = null;
                Date f_created = null;
                Date f_updated = null;
                DesktopSessionLogInfo f_sessionInfo = null;
                String f_clientVersion = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("host_name".equals(field)) {
                        f_hostName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("client_type".equals(field)) {
                        f_clientType = DesktopPlatform.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("platform".equals(field)) {
                        f_platform = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_delete_on_unlink_supported".equals(field)) {
                        f_isDeleteOnUnlinkSupported = StoneSerializers.boolean_().deserialize(p);
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
                        f_sessionInfo = StoneSerializers.nullableStruct(DesktopSessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("client_version".equals(field)) {
                        f_clientVersion = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_hostName == null) {
                    throw new JsonParseException(p, "Required field \"host_name\" missing.");
                }
                if (f_clientType == null) {
                    throw new JsonParseException(p, "Required field \"client_type\" missing.");
                }
                if (f_platform == null) {
                    throw new JsonParseException(p, "Required field \"platform\" missing.");
                }
                if (f_isDeleteOnUnlinkSupported == null) {
                    throw new JsonParseException(p, "Required field \"is_delete_on_unlink_supported\" missing.");
                }
                value = new DesktopDeviceSessionLogInfo(f_hostName, f_clientType, f_platform, f_isDeleteOnUnlinkSupported, f_ipAddress, f_created, f_updated, f_sessionInfo, f_clientVersion);
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
