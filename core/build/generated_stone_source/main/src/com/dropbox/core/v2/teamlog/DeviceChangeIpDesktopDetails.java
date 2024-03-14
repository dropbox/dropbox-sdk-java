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

/**
 * Changed IP address associated with active desktop session.
 */
public class DeviceChangeIpDesktopDetails {
    // struct team_log.DeviceChangeIpDesktopDetails (team_log_generated.stone)

    protected final DeviceSessionLogInfo deviceSessionInfo;

    /**
     * Changed IP address associated with active desktop session.
     *
     * @param deviceSessionInfo  Device's session logged information. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceChangeIpDesktopDetails(DeviceSessionLogInfo deviceSessionInfo) {
        if (deviceSessionInfo == null) {
            throw new IllegalArgumentException("Required value for 'deviceSessionInfo' is null");
        }
        this.deviceSessionInfo = deviceSessionInfo;
    }

    /**
     * Device's session logged information.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public DeviceSessionLogInfo getDeviceSessionInfo() {
        return deviceSessionInfo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            deviceSessionInfo
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
            DeviceChangeIpDesktopDetails other = (DeviceChangeIpDesktopDetails) obj;
            return (this.deviceSessionInfo == other.deviceSessionInfo) || (this.deviceSessionInfo.equals(other.deviceSessionInfo));
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
    static class Serializer extends StructSerializer<DeviceChangeIpDesktopDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceChangeIpDesktopDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("device_session_info");
            DeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.deviceSessionInfo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceChangeIpDesktopDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceChangeIpDesktopDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                DeviceSessionLogInfo f_deviceSessionInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("device_session_info".equals(field)) {
                        f_deviceSessionInfo = DeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_deviceSessionInfo == null) {
                    throw new JsonParseException(p, "Required field \"device_session_info\" missing.");
                }
                value = new DeviceChangeIpDesktopDetails(f_deviceSessionInfo);
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
