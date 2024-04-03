/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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
import java.util.List;

import javax.annotation.Nonnull;

public class RevokeDeviceSessionBatchResult {
    // struct team.RevokeDeviceSessionBatchResult (team_devices.stone)

    @Nonnull
    protected final List<RevokeDeviceSessionStatus> revokeDevicesStatus;

    /**
     *
     * @param revokeDevicesStatus  Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchResult(@Nonnull List<RevokeDeviceSessionStatus> revokeDevicesStatus) {
        if (revokeDevicesStatus == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevicesStatus' is null");
        }
        for (RevokeDeviceSessionStatus x : revokeDevicesStatus) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevicesStatus' is null");
            }
        }
        this.revokeDevicesStatus = revokeDevicesStatus;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<RevokeDeviceSessionStatus> getRevokeDevicesStatus() {
        return revokeDevicesStatus;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.revokeDevicesStatus
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
            RevokeDeviceSessionBatchResult other = (RevokeDeviceSessionBatchResult) obj;
            return (this.revokeDevicesStatus == other.revokeDevicesStatus) || (this.revokeDevicesStatus.equals(other.revokeDevicesStatus));
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
    static class Serializer extends StructSerializer<RevokeDeviceSessionBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeDeviceSessionBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("revoke_devices_status");
            StoneSerializers.list(RevokeDeviceSessionStatus.Serializer.INSTANCE).serialize(value.revokeDevicesStatus, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeDeviceSessionBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeDeviceSessionBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RevokeDeviceSessionStatus> f_revokeDevicesStatus = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("revoke_devices_status".equals(field)) {
                        f_revokeDevicesStatus = StoneSerializers.list(RevokeDeviceSessionStatus.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_revokeDevicesStatus == null) {
                    throw new JsonParseException(p, "Required field \"revoke_devices_status\" missing.");
                }
                value = new RevokeDeviceSessionBatchResult(f_revokeDevicesStatus);
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
