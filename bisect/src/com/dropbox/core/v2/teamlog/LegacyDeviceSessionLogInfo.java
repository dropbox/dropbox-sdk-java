/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Information on sessions, in legacy format
 */
public class LegacyDeviceSessionLogInfo extends DeviceSessionLogInfo {
    // struct team_log.LegacyDeviceSessionLogInfo (team_log_generated.stone)

    protected final SessionLogInfo sessionInfo;
    protected final String displayName;
    protected final Boolean isEmmManaged;
    protected final String platform;
    protected final String macAddress;
    protected final String osVersion;
    protected final String deviceType;
    protected final String clientVersion;
    protected final String legacyUniqId;

    /**
     * Information on sessions, in legacy format
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param ipAddress  The IP address of the last activity from this session.
     *     Might be missing due to historical data gap.
     * @param created  The time this session was created. Might be missing due
     *     to historical data gap.
     * @param updated  The time of the last activity from this session. Might be
     *     missing due to historical data gap.
     * @param sessionInfo  Session unique id. Might be missing due to historical
     *     data gap.
     * @param displayName  The device name. Might be missing due to historical
     *     data gap.
     * @param isEmmManaged  Is device managed by emm. Might be missing due to
     *     historical data gap.
     * @param platform  Information on the hosting platform. Might be missing
     *     due to historical data gap.
     * @param macAddress  The mac address of the last activity from this
     *     session. Might be missing due to historical data gap.
     * @param osVersion  The hosting OS version. Might be missing due to
     *     historical data gap.
     * @param deviceType  Information on the hosting device type. Might be
     *     missing due to historical data gap.
     * @param clientVersion  The Dropbox client version. Might be missing due to
     *     historical data gap.
     * @param legacyUniqId  Alternative unique device session id, instead of
     *     session id field. Might be missing due to historical data gap.
     */
    public LegacyDeviceSessionLogInfo(String ipAddress, Date created, Date updated, SessionLogInfo sessionInfo, String displayName, Boolean isEmmManaged, String platform, String macAddress, String osVersion, String deviceType, String clientVersion, String legacyUniqId) {
        super(ipAddress, created, updated);
        this.sessionInfo = sessionInfo;
        this.displayName = displayName;
        this.isEmmManaged = isEmmManaged;
        this.platform = platform;
        this.macAddress = macAddress;
        this.osVersion = osVersion;
        this.deviceType = deviceType;
        this.clientVersion = clientVersion;
        this.legacyUniqId = legacyUniqId;
    }

    /**
     * Information on sessions, in legacy format
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public LegacyDeviceSessionLogInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * The IP address of the last activity from this session. Might be missing
     * due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The time this session was created. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * Session unique id. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public SessionLogInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * The device name. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Is device managed by emm. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getIsEmmManaged() {
        return isEmmManaged;
    }

    /**
     * Information on the hosting platform. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * The mac address of the last activity from this session. Might be missing
     * due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * The hosting OS version. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * Information on the hosting device type. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * The Dropbox client version. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Alternative unique device session id, instead of session id field. Might
     * be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLegacyUniqId() {
        return legacyUniqId;
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
     * Builder for {@link LegacyDeviceSessionLogInfo}.
     */
    public static class Builder extends DeviceSessionLogInfo.Builder {

        protected SessionLogInfo sessionInfo;
        protected String displayName;
        protected Boolean isEmmManaged;
        protected String platform;
        protected String macAddress;
        protected String osVersion;
        protected String deviceType;
        protected String clientVersion;
        protected String legacyUniqId;

        protected Builder() {
            this.sessionInfo = null;
            this.displayName = null;
            this.isEmmManaged = null;
            this.platform = null;
            this.macAddress = null;
            this.osVersion = null;
            this.deviceType = null;
            this.clientVersion = null;
            this.legacyUniqId = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sessionInfo  Session unique id. Might be missing due to
         *     historical data gap.
         *
         * @return this builder
         */
        public Builder withSessionInfo(SessionLogInfo sessionInfo) {
            this.sessionInfo = sessionInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param displayName  The device name. Might be missing due to
         *     historical data gap.
         *
         * @return this builder
         */
        public Builder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isEmmManaged  Is device managed by emm. Might be missing due
         *     to historical data gap.
         *
         * @return this builder
         */
        public Builder withIsEmmManaged(Boolean isEmmManaged) {
            this.isEmmManaged = isEmmManaged;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param platform  Information on the hosting platform. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPlatform(String platform) {
            this.platform = platform;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param macAddress  The mac address of the last activity from this
         *     session. Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withMacAddress(String macAddress) {
            this.macAddress = macAddress;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param osVersion  The hosting OS version. Might be missing due to
         *     historical data gap.
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
         * @param deviceType  Information on the hosting device type. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withDeviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param clientVersion  The Dropbox client version. Might be missing
         *     due to historical data gap.
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
         * @param legacyUniqId  Alternative unique device session id, instead of
         *     session id field. Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withLegacyUniqId(String legacyUniqId) {
            this.legacyUniqId = legacyUniqId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param ipAddress  The IP address of the last activity from this
         *     session. Might be missing due to historical data gap.
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
         * @param created  The time this session was created. Might be missing
         *     due to historical data gap.
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
         *     Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withUpdated(Date updated) {
            super.withUpdated(updated);
            return this;
        }

        /**
         * Builds an instance of {@link LegacyDeviceSessionLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link LegacyDeviceSessionLogInfo}
         */
        public LegacyDeviceSessionLogInfo build() {
            return new LegacyDeviceSessionLogInfo(ipAddress, created, updated, sessionInfo, displayName, isEmmManaged, platform, macAddress, osVersion, deviceType, clientVersion, legacyUniqId);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
            displayName,
            isEmmManaged,
            platform,
            macAddress,
            osVersion,
            deviceType,
            clientVersion,
            legacyUniqId
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
            LegacyDeviceSessionLogInfo other = (LegacyDeviceSessionLogInfo) obj;
            return ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
                && ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
                && ((this.isEmmManaged == other.isEmmManaged) || (this.isEmmManaged != null && this.isEmmManaged.equals(other.isEmmManaged)))
                && ((this.platform == other.platform) || (this.platform != null && this.platform.equals(other.platform)))
                && ((this.macAddress == other.macAddress) || (this.macAddress != null && this.macAddress.equals(other.macAddress)))
                && ((this.osVersion == other.osVersion) || (this.osVersion != null && this.osVersion.equals(other.osVersion)))
                && ((this.deviceType == other.deviceType) || (this.deviceType != null && this.deviceType.equals(other.deviceType)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion != null && this.clientVersion.equals(other.clientVersion)))
                && ((this.legacyUniqId == other.legacyUniqId) || (this.legacyUniqId != null && this.legacyUniqId.equals(other.legacyUniqId)))
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
    static class Serializer extends StructSerializer<LegacyDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegacyDeviceSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("legacy_device_session", g);
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
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(value.sessionInfo, g);
            }
            if (value.displayName != null) {
                g.writeFieldName("display_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.displayName, g);
            }
            if (value.isEmmManaged != null) {
                g.writeFieldName("is_emm_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isEmmManaged, g);
            }
            if (value.platform != null) {
                g.writeFieldName("platform");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.platform, g);
            }
            if (value.macAddress != null) {
                g.writeFieldName("mac_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.macAddress, g);
            }
            if (value.osVersion != null) {
                g.writeFieldName("os_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.osVersion, g);
            }
            if (value.deviceType != null) {
                g.writeFieldName("device_type");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.deviceType, g);
            }
            if (value.clientVersion != null) {
                g.writeFieldName("client_version");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.clientVersion, g);
            }
            if (value.legacyUniqId != null) {
                g.writeFieldName("legacy_uniq_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.legacyUniqId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegacyDeviceSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegacyDeviceSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("legacy_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_ipAddress = null;
                Date f_created = null;
                Date f_updated = null;
                SessionLogInfo f_sessionInfo = null;
                String f_displayName = null;
                Boolean f_isEmmManaged = null;
                String f_platform = null;
                String f_macAddress = null;
                String f_osVersion = null;
                String f_deviceType = null;
                String f_clientVersion = null;
                String f_legacyUniqId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("updated".equals(field)) {
                        f_updated = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("session_info".equals(field)) {
                        f_sessionInfo = StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_emm_managed".equals(field)) {
                        f_isEmmManaged = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("platform".equals(field)) {
                        f_platform = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("mac_address".equals(field)) {
                        f_macAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("os_version".equals(field)) {
                        f_osVersion = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("device_type".equals(field)) {
                        f_deviceType = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("client_version".equals(field)) {
                        f_clientVersion = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("legacy_uniq_id".equals(field)) {
                        f_legacyUniqId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new LegacyDeviceSessionLogInfo(f_ipAddress, f_created, f_updated, f_sessionInfo, f_displayName, f_isEmmManaged, f_platform, f_macAddress, f_osVersion, f_deviceType, f_clientVersion, f_legacyUniqId);
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
