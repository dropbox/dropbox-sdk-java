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
 * Changed team default member space limit.
 */
public class MemberSpaceLimitsChangePolicyDetails {
    // struct team_log.MemberSpaceLimitsChangePolicyDetails (team_log_generated.stone)

    protected final Long previousValue;
    protected final Long newValue;

    /**
     * Changed team default member space limit.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param previousValue  Previous team default limit value in bytes. Might
     *     be missing due to historical data gap.
     * @param newValue  New team default limit value in bytes. Might be missing
     *     due to historical data gap.
     */
    public MemberSpaceLimitsChangePolicyDetails(@Nullable Long previousValue, @Nullable Long newValue) {
        this.previousValue = previousValue;
        this.newValue = newValue;
    }

    /**
     * Changed team default member space limit.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public MemberSpaceLimitsChangePolicyDetails() {
        this(null, null);
    }

    /**
     * Previous team default limit value in bytes. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getPreviousValue() {
        return previousValue;
    }

    /**
     * New team default limit value in bytes. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Long getNewValue() {
        return newValue;
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
     * Builder for {@link MemberSpaceLimitsChangePolicyDetails}.
     */
    public static class Builder {

        protected Long previousValue;
        protected Long newValue;

        protected Builder() {
            this.previousValue = null;
            this.newValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous team default limit value in bytes.
         *     Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(Long previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New team default limit value in bytes. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewValue(Long newValue) {
            this.newValue = newValue;
            return this;
        }

        /**
         * Builds an instance of {@link MemberSpaceLimitsChangePolicyDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link MemberSpaceLimitsChangePolicyDetails}
         */
        public MemberSpaceLimitsChangePolicyDetails build() {
            return new MemberSpaceLimitsChangePolicyDetails(previousValue, newValue);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
            MemberSpaceLimitsChangePolicyDetails other = (MemberSpaceLimitsChangePolicyDetails) obj;
            return ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue != null && this.newValue.equals(other.newValue)))
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
    static class Serializer extends StructSerializer<MemberSpaceLimitsChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSpaceLimitsChangePolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.previousValue, g);
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(value.newValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberSpaceLimitsChangePolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberSpaceLimitsChangePolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_previousValue = null;
                Long f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new MemberSpaceLimitsChangePolicyDetails(f_previousValue, f_newValue);
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
