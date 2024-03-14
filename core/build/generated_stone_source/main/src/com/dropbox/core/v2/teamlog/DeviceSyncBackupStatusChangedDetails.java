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
 * Enabled/disabled backup for computer.
 */
public class DeviceSyncBackupStatusChangedDetails {
    // struct team_log.DeviceSyncBackupStatusChangedDetails (team_log_generated.stone)

    protected final DesktopDeviceSessionLogInfo desktopDeviceSessionInfo;
    protected final BackupStatus previousValue;
    protected final BackupStatus newValue;

    /**
     * Enabled/disabled backup for computer.
     *
     * @param desktopDeviceSessionInfo  Device's session logged information.
     *     Must not be {@code null}.
     * @param previousValue  Previous status of computer backup on the device.
     *     Must not be {@code null}.
     * @param newValue  Next status of computer backup on the device. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSyncBackupStatusChangedDetails(DesktopDeviceSessionLogInfo desktopDeviceSessionInfo, BackupStatus previousValue, BackupStatus newValue) {
        if (desktopDeviceSessionInfo == null) {
            throw new IllegalArgumentException("Required value for 'desktopDeviceSessionInfo' is null");
        }
        this.desktopDeviceSessionInfo = desktopDeviceSessionInfo;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * Device's session logged information.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionInfo() {
        return desktopDeviceSessionInfo;
    }

    /**
     * Previous status of computer backup on the device.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public BackupStatus getPreviousValue() {
        return previousValue;
    }

    /**
     * Next status of computer backup on the device.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public BackupStatus getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            desktopDeviceSessionInfo,
            previousValue,
            newValue
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
            DeviceSyncBackupStatusChangedDetails other = (DeviceSyncBackupStatusChangedDetails) obj;
            return ((this.desktopDeviceSessionInfo == other.desktopDeviceSessionInfo) || (this.desktopDeviceSessionInfo.equals(other.desktopDeviceSessionInfo)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
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
    static class Serializer extends StructSerializer<DeviceSyncBackupStatusChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceSyncBackupStatusChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("desktop_device_session_info");
            DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.desktopDeviceSessionInfo, g);
            g.writeFieldName("previous_value");
            BackupStatus.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            BackupStatus.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceSyncBackupStatusChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceSyncBackupStatusChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                DesktopDeviceSessionLogInfo f_desktopDeviceSessionInfo = null;
                BackupStatus f_previousValue = null;
                BackupStatus f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("desktop_device_session_info".equals(field)) {
                        f_desktopDeviceSessionInfo = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = BackupStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = BackupStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_desktopDeviceSessionInfo == null) {
                    throw new JsonParseException(p, "Required field \"desktop_device_session_info\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new DeviceSyncBackupStatusChangedDetails(f_desktopDeviceSessionInfo, f_previousValue, f_newValue);
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
