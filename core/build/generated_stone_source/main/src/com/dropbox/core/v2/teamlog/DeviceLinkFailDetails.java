/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Failed to link device.
 */
public class DeviceLinkFailDetails {
    // struct team_log.DeviceLinkFailDetails (team_log_generated.stone)

    protected final String ipAddress;
    protected final DeviceType deviceType;

    /**
     * Failed to link device.
     *
     * @param deviceType  A description of the device used while user approval
     *     blocked. Must not be {@code null}.
     * @param ipAddress  IP address. Might be missing due to historical data
     *     gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceLinkFailDetails(@Nonnull DeviceType deviceType, @Nullable String ipAddress) {
        this.ipAddress = ipAddress;
        if (deviceType == null) {
            throw new IllegalArgumentException("Required value for 'deviceType' is null");
        }
        this.deviceType = deviceType;
    }

    /**
     * Failed to link device.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param deviceType  A description of the device used while user approval
     *     blocked. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceLinkFailDetails(DeviceType deviceType) {
        this(deviceType, null);
    }

    /**
     * A description of the device used while user approval blocked.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public DeviceType getDeviceType() {
        return deviceType;
    }

    /**
     * IP address. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            ipAddress,
            deviceType
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
            DeviceLinkFailDetails other = (DeviceLinkFailDetails) obj;
            return ((this.deviceType == other.deviceType) || (this.deviceType.equals(other.deviceType)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
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
    static class Serializer extends StructSerializer<DeviceLinkFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceLinkFailDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("device_type");
            DeviceType.Serializer.INSTANCE.serialize(value.deviceType, g);
            if (value.ipAddress != null) {
                g.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.ipAddress, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceLinkFailDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceLinkFailDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                DeviceType f_deviceType = null;
                String f_ipAddress = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("device_type".equals(field)) {
                        f_deviceType = DeviceType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_deviceType == null) {
                    throw new JsonParseException(p, "Required field \"device_type\" missing.");
                }
                value = new DeviceLinkFailDetails(f_deviceType, f_ipAddress);
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
