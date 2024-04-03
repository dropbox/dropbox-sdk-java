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
 * Enabled/disabled/changed two-step verification setting.
 */
public class TfaChangeStatusDetails {
    // struct team_log.TfaChangeStatusDetails (team_log_generated.stone)

    @Nonnull
    protected final TfaConfiguration newValue;
    @Nullable
    protected final TfaConfiguration previousValue;
    @Nullable
    protected final Boolean usedRescueCode;

    /**
     * Enabled/disabled/changed two-step verification setting.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  The new two factor authentication configuration. Must
     *     not be {@code null}.
     * @param previousValue  The previous two factor authentication
     *     configuration. Might be missing due to historical data gap.
     * @param usedRescueCode  Used two factor authentication rescue code. This
     *     flag is relevant when the two factor authentication configuration is
     *     disabled.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TfaChangeStatusDetails(@Nonnull TfaConfiguration newValue, @Nullable TfaConfiguration previousValue, @Nullable Boolean usedRescueCode) {
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.previousValue = previousValue;
        this.usedRescueCode = usedRescueCode;
    }

    /**
     * Enabled/disabled/changed two-step verification setting.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  The new two factor authentication configuration. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TfaChangeStatusDetails(@Nonnull TfaConfiguration newValue) {
        this(newValue, null, null);
    }

    /**
     * The new two factor authentication configuration.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public TfaConfiguration getNewValue() {
        return newValue;
    }

    /**
     * The previous two factor authentication configuration. Might be missing
     * due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public TfaConfiguration getPreviousValue() {
        return previousValue;
    }

    /**
     * Used two factor authentication rescue code. This flag is relevant when
     * the two factor authentication configuration is disabled.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getUsedRescueCode() {
        return usedRescueCode;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param newValue  The new two factor authentication configuration. Must
     *     not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(TfaConfiguration newValue) {
        return new Builder(newValue);
    }

    /**
     * Builder for {@link TfaChangeStatusDetails}.
     */
    public static class Builder {
        protected final TfaConfiguration newValue;

        protected TfaConfiguration previousValue;
        protected Boolean usedRescueCode;

        protected Builder(TfaConfiguration newValue) {
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            this.previousValue = null;
            this.usedRescueCode = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  The previous two factor authentication
         *     configuration. Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(TfaConfiguration previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param usedRescueCode  Used two factor authentication rescue code.
         *     This flag is relevant when the two factor authentication
         *     configuration is disabled.
         *
         * @return this builder
         */
        public Builder withUsedRescueCode(Boolean usedRescueCode) {
            this.usedRescueCode = usedRescueCode;
            return this;
        }

        /**
         * Builds an instance of {@link TfaChangeStatusDetails} configured with
         * this builder's values
         *
         * @return new instance of {@link TfaChangeStatusDetails}
         */
        public TfaChangeStatusDetails build() {
            return new TfaChangeStatusDetails(newValue, previousValue, usedRescueCode);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.newValue,
            this.previousValue,
            this.usedRescueCode
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
            TfaChangeStatusDetails other = (TfaChangeStatusDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
                && ((this.usedRescueCode == other.usedRescueCode) || (this.usedRescueCode != null && this.usedRescueCode.equals(other.usedRescueCode)))
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
    static class Serializer extends StructSerializer<TfaChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TfaChangeStatusDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            TfaConfiguration.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(TfaConfiguration.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (value.usedRescueCode != null) {
                g.writeFieldName("used_rescue_code");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.usedRescueCode, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TfaChangeStatusDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TfaChangeStatusDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TfaConfiguration f_newValue = null;
                TfaConfiguration f_previousValue = null;
                Boolean f_usedRescueCode = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = TfaConfiguration.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(TfaConfiguration.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("used_rescue_code".equals(field)) {
                        f_usedRescueCode = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new TfaChangeStatusDetails(f_newValue, f_previousValue, f_usedRescueCode);
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
