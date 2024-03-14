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
 * Changed how long team members can be idle while signed in to Dropbox.com.
 */
public class WebSessionsChangeIdleLengthPolicyDetails {
    // struct team_log.WebSessionsChangeIdleLengthPolicyDetails (team_log_generated.stone)

    protected final WebSessionsIdleLengthPolicy newValue;
    protected final WebSessionsIdleLengthPolicy previousValue;

    /**
     * Changed how long team members can be idle while signed in to Dropbox.com.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New idle length policy. Might be missing due to
     *     historical data gap.
     * @param previousValue  Previous idle length policy. Might be missing due
     *     to historical data gap.
     */
    public WebSessionsChangeIdleLengthPolicyDetails(@Nullable WebSessionsIdleLengthPolicy newValue, @Nullable WebSessionsIdleLengthPolicy previousValue) {
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Changed how long team members can be idle while signed in to Dropbox.com.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public WebSessionsChangeIdleLengthPolicyDetails() {
        this(null, null);
    }

    /**
     * New idle length policy. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public WebSessionsIdleLengthPolicy getNewValue() {
        return newValue;
    }

    /**
     * Previous idle length policy. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public WebSessionsIdleLengthPolicy getPreviousValue() {
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
     * Builder for {@link WebSessionsChangeIdleLengthPolicyDetails}.
     */
    public static class Builder {

        protected WebSessionsIdleLengthPolicy newValue;
        protected WebSessionsIdleLengthPolicy previousValue;

        protected Builder() {
            this.newValue = null;
            this.previousValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New idle length policy. Might be missing due to
         *     historical data gap.
         *
         * @return this builder
         */
        public Builder withNewValue(WebSessionsIdleLengthPolicy newValue) {
            this.newValue = newValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous idle length policy. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(WebSessionsIdleLengthPolicy previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Builds an instance of {@link
         * WebSessionsChangeIdleLengthPolicyDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link
         *     WebSessionsChangeIdleLengthPolicyDetails}
         */
        public WebSessionsChangeIdleLengthPolicyDetails build() {
            return new WebSessionsChangeIdleLengthPolicyDetails(newValue, previousValue);
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
            WebSessionsChangeIdleLengthPolicyDetails other = (WebSessionsChangeIdleLengthPolicyDetails) obj;
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
    static class Serializer extends StructSerializer<WebSessionsChangeIdleLengthPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WebSessionsChangeIdleLengthPolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).serialize(value.newValue, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public WebSessionsChangeIdleLengthPolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            WebSessionsChangeIdleLengthPolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                WebSessionsIdleLengthPolicy f_newValue = null;
                WebSessionsIdleLengthPolicy f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new WebSessionsChangeIdleLengthPolicyDetails(f_newValue, f_previousValue);
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
