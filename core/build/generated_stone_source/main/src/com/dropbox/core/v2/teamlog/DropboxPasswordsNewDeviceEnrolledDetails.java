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
 * Enrolled new Dropbox Passwords device.
 */
public class DropboxPasswordsNewDeviceEnrolledDetails {
    // struct team_log.DropboxPasswordsNewDeviceEnrolledDetails (team_log_generated.stone)

    protected final boolean isFirstDevice;
    protected final String platform;

    /**
     * Enrolled new Dropbox Passwords device.
     *
     * @param isFirstDevice  Whether it's a first device enrolled.
     * @param platform  The platform the device is enrolled. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DropboxPasswordsNewDeviceEnrolledDetails(boolean isFirstDevice, @javax.annotation.Nonnull String platform) {
        this.isFirstDevice = isFirstDevice;
        if (platform == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = platform;
    }

    /**
     * Whether it's a first device enrolled.
     *
     * @return value for this field.
     */
    public boolean getIsFirstDevice() {
        return isFirstDevice;
    }

    /**
     * The platform the device is enrolled.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPlatform() {
        return platform;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isFirstDevice,
            platform
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
            DropboxPasswordsNewDeviceEnrolledDetails other = (DropboxPasswordsNewDeviceEnrolledDetails) obj;
            return (this.isFirstDevice == other.isFirstDevice)
                && ((this.platform == other.platform) || (this.platform.equals(other.platform)))
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
    static class Serializer extends StructSerializer<DropboxPasswordsNewDeviceEnrolledDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DropboxPasswordsNewDeviceEnrolledDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_first_device");
            StoneSerializers.boolean_().serialize(value.isFirstDevice, g);
            g.writeFieldName("platform");
            StoneSerializers.string().serialize(value.platform, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DropboxPasswordsNewDeviceEnrolledDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DropboxPasswordsNewDeviceEnrolledDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isFirstDevice = null;
                String f_platform = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_first_device".equals(field)) {
                        f_isFirstDevice = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("platform".equals(field)) {
                        f_platform = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isFirstDevice == null) {
                    throw new JsonParseException(p, "Required field \"is_first_device\" missing.");
                }
                if (f_platform == null) {
                    throw new JsonParseException(p, "Required field \"platform\" missing.");
                }
                value = new DropboxPasswordsNewDeviceEnrolledDetails(f_isFirstDevice, f_platform);
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
