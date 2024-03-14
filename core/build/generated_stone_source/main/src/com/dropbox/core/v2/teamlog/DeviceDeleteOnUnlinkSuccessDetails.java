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
 * Deleted all files from unlinked device.
 */
public class DeviceDeleteOnUnlinkSuccessDetails {
    // struct team_log.DeviceDeleteOnUnlinkSuccessDetails (team_log_generated.stone)

    protected final SessionLogInfo sessionInfo;
    protected final String displayName;

    /**
     * Deleted all files from unlinked device.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sessionInfo  Session unique id.
     * @param displayName  The device name. Might be missing due to historical
     *     data gap.
     */
    public DeviceDeleteOnUnlinkSuccessDetails(@Nullable SessionLogInfo sessionInfo, @Nullable String displayName) {
        this.sessionInfo = sessionInfo;
        this.displayName = displayName;
    }

    /**
     * Deleted all files from unlinked device.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DeviceDeleteOnUnlinkSuccessDetails() {
        this(null, null);
    }

    /**
     * Session unique id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SessionLogInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * The device name. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
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
     * Builder for {@link DeviceDeleteOnUnlinkSuccessDetails}.
     */
    public static class Builder {

        protected SessionLogInfo sessionInfo;
        protected String displayName;

        protected Builder() {
            this.sessionInfo = null;
            this.displayName = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sessionInfo  Session unique id.
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
         * Builds an instance of {@link DeviceDeleteOnUnlinkSuccessDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link DeviceDeleteOnUnlinkSuccessDetails}
         */
        public DeviceDeleteOnUnlinkSuccessDetails build() {
            return new DeviceDeleteOnUnlinkSuccessDetails(sessionInfo, displayName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
            displayName
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
            DeviceDeleteOnUnlinkSuccessDetails other = (DeviceDeleteOnUnlinkSuccessDetails) obj;
            return ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
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
    static class Serializer extends StructSerializer<DeviceDeleteOnUnlinkSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceDeleteOnUnlinkSuccessDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sessionInfo != null) {
                g.writeFieldName("session_info");
                StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).serialize(value.sessionInfo, g);
            }
            if (value.displayName != null) {
                g.writeFieldName("display_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.displayName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceDeleteOnUnlinkSuccessDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceDeleteOnUnlinkSuccessDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SessionLogInfo f_sessionInfo = null;
                String f_displayName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_info".equals(field)) {
                        f_sessionInfo = StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new DeviceDeleteOnUnlinkSuccessDetails(f_sessionInfo, f_displayName);
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
