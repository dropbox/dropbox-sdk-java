/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

class RevokeDeviceSessionBatchArg {
    // struct RevokeDeviceSessionBatchArg

    protected final List<RevokeDeviceSessionArg> revokeDevices;

    /**
     *
     * @param revokeDevices  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchArg(List<RevokeDeviceSessionArg> revokeDevices) {
        if (revokeDevices == null) {
            throw new IllegalArgumentException("Required value for 'revokeDevices' is null");
        }
        for (RevokeDeviceSessionArg x : revokeDevices) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'revokeDevices' is null");
            }
        }
        this.revokeDevices = revokeDevices;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<RevokeDeviceSessionArg> getRevokeDevices() {
        return revokeDevices;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            revokeDevices
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            RevokeDeviceSessionBatchArg other = (RevokeDeviceSessionBatchArg) obj;
            return (this.revokeDevices == other.revokeDevices) || (this.revokeDevices.equals(other.revokeDevices));
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
    static final class Serializer extends StructSerializer<RevokeDeviceSessionBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeDeviceSessionBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("revoke_devices");
            StoneSerializers.list(RevokeDeviceSessionArg.Serializer.INSTANCE).serialize(value.revokeDevices, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeDeviceSessionBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeDeviceSessionBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RevokeDeviceSessionArg> f_revokeDevices = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("revoke_devices".equals(field)) {
                        f_revokeDevices = StoneSerializers.list(RevokeDeviceSessionArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_revokeDevices == null) {
                    throw new JsonParseException(p, "Required field \"revoke_devices\" missing.");
                }
                value = new RevokeDeviceSessionBatchArg(f_revokeDevices);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
