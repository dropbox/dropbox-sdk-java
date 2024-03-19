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
 * Set/removed limit on number of mobile devices member can link to team Dropbox
 * account.
 */
public class DeviceApprovalsChangeMobilePolicyDetails {
    // struct team_log.DeviceApprovalsChangeMobilePolicyDetails (team_log_generated.stone)

    @Nullable
    protected final DeviceApprovalsPolicy newValue;
    @Nullable
    protected final DeviceApprovalsPolicy previousValue;

    /**
     * Set/removed limit on number of mobile devices member can link to team
     * Dropbox account.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New mobile device approvals policy. Might be missing due
     *     to historical data gap.
     * @param previousValue  Previous mobile device approvals policy. Might be
     *     missing due to historical data gap.
     */
    public DeviceApprovalsChangeMobilePolicyDetails(@Nullable DeviceApprovalsPolicy newValue, @Nullable DeviceApprovalsPolicy previousValue) {
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Set/removed limit on number of mobile devices member can link to team
     * Dropbox account.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DeviceApprovalsChangeMobilePolicyDetails() {
        this(null, null);
    }

    /**
     * New mobile device approvals policy. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public DeviceApprovalsPolicy getNewValue() {
        return newValue;
    }

    /**
     * Previous mobile device approvals policy. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public DeviceApprovalsPolicy getPreviousValue() {
        return previousValue;
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
     * Builder for {@link DeviceApprovalsChangeMobilePolicyDetails}.
     */
    public static class Builder {

        protected DeviceApprovalsPolicy newValue;
        protected DeviceApprovalsPolicy previousValue;

        protected Builder() {
            this.newValue = null;
            this.previousValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New mobile device approvals policy. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewValue(DeviceApprovalsPolicy newValue) {
            this.newValue = newValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous mobile device approvals policy. Might
         *     be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(DeviceApprovalsPolicy previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Builds an instance of {@link
         * DeviceApprovalsChangeMobilePolicyDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link
         *     DeviceApprovalsChangeMobilePolicyDetails}
         */
        public DeviceApprovalsChangeMobilePolicyDetails build() {
            return new DeviceApprovalsChangeMobilePolicyDetails(newValue, previousValue);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newValue,
            previousValue
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
            DeviceApprovalsChangeMobilePolicyDetails other = (DeviceApprovalsChangeMobilePolicyDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue != null && this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<DeviceApprovalsChangeMobilePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceApprovalsChangeMobilePolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).serialize(value.newValue, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceApprovalsChangeMobilePolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceApprovalsChangeMobilePolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                DeviceApprovalsPolicy f_newValue = null;
                DeviceApprovalsPolicy f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(DeviceApprovalsPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new DeviceApprovalsChangeMobilePolicyDetails(f_newValue, f_previousValue);
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
