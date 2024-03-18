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
 * Failed to delete all files from unlinked device.
 */
public class DeviceDeleteOnUnlinkFailDetails {
    // struct team_log.DeviceDeleteOnUnlinkFailDetails (team_log_generated.stone)

    @Nullable
    protected final SessionLogInfo sessionInfo;
    @Nullable
    protected final String displayName;
    protected final long numFailures;

    /**
     * Failed to delete all files from unlinked device.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param numFailures  The number of times that remote file deletion failed.
     * @param sessionInfo  Session unique id.
     * @param displayName  The device name. Might be missing due to historical
     *     data gap.
     */
    public DeviceDeleteOnUnlinkFailDetails(long numFailures, @Nullable SessionLogInfo sessionInfo, @Nullable String displayName) {
        this.sessionInfo = sessionInfo;
        this.displayName = displayName;
        this.numFailures = numFailures;
    }

    /**
     * Failed to delete all files from unlinked device.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param numFailures  The number of times that remote file deletion failed.
     */
    public DeviceDeleteOnUnlinkFailDetails(long numFailures) {
        this(numFailures, null, null);
    }

    /**
     * The number of times that remote file deletion failed.
     *
     * @return value for this field.
     */
    public long getNumFailures() {
        return numFailures;
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
     * @param numFailures  The number of times that remote file deletion failed.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder(long numFailures) {
        return new Builder(numFailures);
    }

    /**
     * Builder for {@link DeviceDeleteOnUnlinkFailDetails}.
     */
    public static class Builder {
        protected final long numFailures;

        protected SessionLogInfo sessionInfo;
        protected String displayName;

        protected Builder(long numFailures) {
            this.numFailures = numFailures;
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
         * Builds an instance of {@link DeviceDeleteOnUnlinkFailDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link DeviceDeleteOnUnlinkFailDetails}
         */
        public DeviceDeleteOnUnlinkFailDetails build() {
            return new DeviceDeleteOnUnlinkFailDetails(numFailures, sessionInfo, displayName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
            displayName,
            numFailures
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
            DeviceDeleteOnUnlinkFailDetails other = (DeviceDeleteOnUnlinkFailDetails) obj;
            return (this.numFailures == other.numFailures)
                && ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
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
    static class Serializer extends StructSerializer<DeviceDeleteOnUnlinkFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceDeleteOnUnlinkFailDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("num_failures");
            StoneSerializers.int64().serialize(value.numFailures, g);
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
        public DeviceDeleteOnUnlinkFailDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceDeleteOnUnlinkFailDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_numFailures = null;
                SessionLogInfo f_sessionInfo = null;
                String f_displayName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("num_failures".equals(field)) {
                        f_numFailures = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("session_info".equals(field)) {
                        f_sessionInfo = StoneSerializers.nullableStruct(SessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_numFailures == null) {
                    throw new JsonParseException(p, "Required field \"num_failures\" missing.");
                }
                value = new DeviceDeleteOnUnlinkFailDetails(f_numFailures, f_sessionInfo, f_displayName);
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
