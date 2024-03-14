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
 * Changed sign-out URL for SSO.
 */
public class SsoChangeLogoutUrlDetails {
    // struct team_log.SsoChangeLogoutUrlDetails (team_log_generated.stone)

    protected final String previousValue;
    protected final String newValue;

    /**
     * Changed sign-out URL for SSO.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param previousValue  Previous single sign-on logout URL. Might be
     *     missing due to historical data gap.
     * @param newValue  New single sign-on logout URL.
     */
    public SsoChangeLogoutUrlDetails(@javax.annotation.Nullable String previousValue, @javax.annotation.Nullable String newValue) {
        this.previousValue = previousValue;
        this.newValue = newValue;
    }

    /**
     * Changed sign-out URL for SSO.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SsoChangeLogoutUrlDetails() {
        this(null, null);
    }

    /**
     * Previous single sign-on logout URL. Might be missing due to historical
     * data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPreviousValue() {
        return previousValue;
    }

    /**
     * New single sign-on logout URL.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getNewValue() {
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
     * Builder for {@link SsoChangeLogoutUrlDetails}.
     */
    public static class Builder {

        protected String previousValue;
        protected String newValue;

        protected Builder() {
            this.previousValue = null;
            this.newValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous single sign-on logout URL. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(String previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New single sign-on logout URL.
         *
         * @return this builder
         */
        public Builder withNewValue(String newValue) {
            this.newValue = newValue;
            return this;
        }

        /**
         * Builds an instance of {@link SsoChangeLogoutUrlDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link SsoChangeLogoutUrlDetails}
         */
        public SsoChangeLogoutUrlDetails build() {
            return new SsoChangeLogoutUrlDetails(previousValue, newValue);
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
            SsoChangeLogoutUrlDetails other = (SsoChangeLogoutUrlDetails) obj;
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
    static class Serializer extends StructSerializer<SsoChangeLogoutUrlDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoChangeLogoutUrlDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousValue, g);
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SsoChangeLogoutUrlDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SsoChangeLogoutUrlDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_previousValue = null;
                String f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SsoChangeLogoutUrlDetails(f_previousValue, f_newValue);
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
