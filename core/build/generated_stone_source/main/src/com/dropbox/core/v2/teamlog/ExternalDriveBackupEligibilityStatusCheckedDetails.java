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

/**
 * Checked external drive backup eligibility status.
 */
public class ExternalDriveBackupEligibilityStatusCheckedDetails {
    // struct team_log.ExternalDriveBackupEligibilityStatusCheckedDetails (team_log_generated.stone)

    @Nonnull
    protected final DesktopDeviceSessionLogInfo desktopDeviceSessionInfo;
    @Nonnull
    protected final ExternalDriveBackupEligibilityStatus status;
    protected final long numberOfExternalDriveBackup;

    /**
     * Checked external drive backup eligibility status.
     *
     * @param desktopDeviceSessionInfo  Device's session logged information.
     *     Must not be {@code null}.
     * @param status  Current eligibility status of external drive backup. Must
     *     not be {@code null}.
     * @param numberOfExternalDriveBackup  Total number of valid external drive
     *     backup for all the team members.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExternalDriveBackupEligibilityStatusCheckedDetails(@Nonnull DesktopDeviceSessionLogInfo desktopDeviceSessionInfo, @Nonnull ExternalDriveBackupEligibilityStatus status, long numberOfExternalDriveBackup) {
        if (desktopDeviceSessionInfo == null) {
            throw new IllegalArgumentException("Required value for 'desktopDeviceSessionInfo' is null");
        }
        this.desktopDeviceSessionInfo = desktopDeviceSessionInfo;
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        this.numberOfExternalDriveBackup = numberOfExternalDriveBackup;
    }

    /**
     * Device's session logged information.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionInfo() {
        return desktopDeviceSessionInfo;
    }

    /**
     * Current eligibility status of external drive backup.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public ExternalDriveBackupEligibilityStatus getStatus() {
        return status;
    }

    /**
     * Total number of valid external drive backup for all the team members.
     *
     * @return value for this field.
     */
    public long getNumberOfExternalDriveBackup() {
        return numberOfExternalDriveBackup;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.desktopDeviceSessionInfo,
            this.status,
            this.numberOfExternalDriveBackup
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
            ExternalDriveBackupEligibilityStatusCheckedDetails other = (ExternalDriveBackupEligibilityStatusCheckedDetails) obj;
            return ((this.desktopDeviceSessionInfo == other.desktopDeviceSessionInfo) || (this.desktopDeviceSessionInfo.equals(other.desktopDeviceSessionInfo)))
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && (this.numberOfExternalDriveBackup == other.numberOfExternalDriveBackup)
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
    static class Serializer extends StructSerializer<ExternalDriveBackupEligibilityStatusCheckedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExternalDriveBackupEligibilityStatusCheckedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("desktop_device_session_info");
            DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.desktopDeviceSessionInfo, g);
            g.writeFieldName("status");
            ExternalDriveBackupEligibilityStatus.Serializer.INSTANCE.serialize(value.status, g);
            g.writeFieldName("number_of_external_drive_backup");
            StoneSerializers.uInt64().serialize(value.numberOfExternalDriveBackup, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExternalDriveBackupEligibilityStatusCheckedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExternalDriveBackupEligibilityStatusCheckedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                DesktopDeviceSessionLogInfo f_desktopDeviceSessionInfo = null;
                ExternalDriveBackupEligibilityStatus f_status = null;
                Long f_numberOfExternalDriveBackup = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("desktop_device_session_info".equals(field)) {
                        f_desktopDeviceSessionInfo = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("status".equals(field)) {
                        f_status = ExternalDriveBackupEligibilityStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("number_of_external_drive_backup".equals(field)) {
                        f_numberOfExternalDriveBackup = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_desktopDeviceSessionInfo == null) {
                    throw new JsonParseException(p, "Required field \"desktop_device_session_info\" missing.");
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                if (f_numberOfExternalDriveBackup == null) {
                    throw new JsonParseException(p, "Required field \"number_of_external_drive_backup\" missing.");
                }
                value = new ExternalDriveBackupEligibilityStatusCheckedDetails(f_desktopDeviceSessionInfo, f_status, f_numberOfExternalDriveBackup);
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
