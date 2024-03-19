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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Device's session logged information.
 */
public class DeviceSessionLogInfo {
    // struct team_log.DeviceSessionLogInfo (team_log_generated.stone)

    @Nullable
    protected final String ipAddress;
    @Nullable
    protected final Date created;
    @Nullable
    protected final Date updated;

    /**
     * Device's session logged information.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param ipAddress  The IP address of the last activity from this session.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     */
    public DeviceSessionLogInfo(@Nullable String ipAddress, @Nullable Date created, @Nullable Date updated) {
        this.ipAddress = ipAddress;
        this.created = LangUtil.truncateMillis(created);
        this.updated = LangUtil.truncateMillis(updated);
    }

    /**
     * Device's session logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DeviceSessionLogInfo() {
        this(null, null, null);
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
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link DeviceSessionLogInfo}.
     */
    public static class Builder {

        protected String ipAddress;
        protected Date created;
        protected Date updated;

        protected Builder() {
            this.ipAddress = null;
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
         * @param created  The time this session was created.
         *
         * @return this builder
         */
        public Builder withCreated(Date created) {
            this.created = LangUtil.truncateMillis(created);
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
            this.updated = LangUtil.truncateMillis(updated);
            return this;
        }

        /**
         * Builds an instance of {@link DeviceSessionLogInfo} configured with
         * this builder's values
         *
         * @return new instance of {@link DeviceSessionLogInfo}
         */
        public DeviceSessionLogInfo build() {
            return new DeviceSessionLogInfo(ipAddress, created, updated);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            ipAddress,
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DeviceSessionLogInfo other = (DeviceSessionLogInfo) obj;
            return ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
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
    static class Serializer extends StructSerializer<DeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof DesktopDeviceSessionLogInfo) {
                DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize((DesktopDeviceSessionLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof MobileDeviceSessionLogInfo) {
                MobileDeviceSessionLogInfo.Serializer.INSTANCE.serialize((MobileDeviceSessionLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof WebDeviceSessionLogInfo) {
                WebDeviceSessionLogInfo.Serializer.INSTANCE.serialize((WebDeviceSessionLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof LegacyDeviceSessionLogInfo) {
                LegacyDeviceSessionLogInfo.Serializer.INSTANCE.serialize((LegacyDeviceSessionLogInfo) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
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
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_ipAddress = null;
                Date f_created = null;
                Date f_updated = null;
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
                    else {
                        skipValue(p);
                    }
                }
                value = new DeviceSessionLogInfo(f_ipAddress, f_created, f_updated);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("desktop_device_session".equals(tag)) {
                value = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("mobile_device_session".equals(tag)) {
                value = MobileDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("web_device_session".equals(tag)) {
                value = WebDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("legacy_device_session".equals(tag)) {
                value = LegacyDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
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
