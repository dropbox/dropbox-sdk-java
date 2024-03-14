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
 * Linked device.
 */
public class DeviceLinkSuccessDetails {
    // struct team_log.DeviceLinkSuccessDetails (team_log_generated.stone)

    protected final DeviceSessionLogInfo deviceSessionInfo;

    /**
     * Linked device.
     *
     * @param deviceSessionInfo  Device's session logged information.
     */
    public DeviceLinkSuccessDetails(DeviceSessionLogInfo deviceSessionInfo) {
        this.deviceSessionInfo = deviceSessionInfo;
    }

    /**
     * Linked device.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DeviceLinkSuccessDetails() {
        this(null);
    }

    /**
     * Device's session logged information.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
            DeviceLinkSuccessDetails other = (DeviceLinkSuccessDetails) obj;
            return (this.deviceSessionInfo == other.deviceSessionInfo) || (this.deviceSessionInfo != null && this.deviceSessionInfo.equals(other.deviceSessionInfo));
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
    static class Serializer extends StructSerializer<DeviceLinkSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceLinkSuccessDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.deviceSessionInfo != null) {
                g.writeFieldName("device_session_info");
                StoneSerializers.nullableStruct(DeviceSessionLogInfo.Serializer.INSTANCE).serialize(value.deviceSessionInfo, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceLinkSuccessDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceLinkSuccessDetails value;
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
                        f_deviceSessionInfo = StoneSerializers.nullableStruct(DeviceSessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new DeviceLinkSuccessDetails(f_deviceSessionInfo);
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
