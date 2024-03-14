/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Changed link expiration of shared file/folder.
 */
public class SharedContentChangeLinkExpiryDetails {
    // struct team_log.SharedContentChangeLinkExpiryDetails (team_log_generated.stone)

    protected final Date newValue;
    protected final Date previousValue;

    /**
     * Changed link expiration of shared file/folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New shared content link expiration date. Might be
     *     missing due to historical data gap.
     * @param previousValue  Previous shared content link expiration date. Might
     *     be missing due to historical data gap.
     */
    public SharedContentChangeLinkExpiryDetails(Date newValue, Date previousValue) {
        this.newValue = LangUtil.truncateMillis(newValue);
        this.previousValue = LangUtil.truncateMillis(previousValue);
    }

    /**
     * Changed link expiration of shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedContentChangeLinkExpiryDetails() {
        this(null, null);
    }

    /**
     * New shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getNewValue() {
        return newValue;
    }

    /**
     * Previous shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getPreviousValue() {
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
     * Builder for {@link SharedContentChangeLinkExpiryDetails}.
     */
    public static class Builder {

        protected Date newValue;
        protected Date previousValue;

        protected Builder() {
            this.newValue = null;
            this.previousValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New shared content link expiration date. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewValue(Date newValue) {
            this.newValue = LangUtil.truncateMillis(newValue);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous shared content link expiration date.
         *     Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(Date previousValue) {
            this.previousValue = LangUtil.truncateMillis(previousValue);
            return this;
        }

        /**
         * Builds an instance of {@link SharedContentChangeLinkExpiryDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link SharedContentChangeLinkExpiryDetails}
         */
        public SharedContentChangeLinkExpiryDetails build() {
            return new SharedContentChangeLinkExpiryDetails(newValue, previousValue);
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
            SharedContentChangeLinkExpiryDetails other = (SharedContentChangeLinkExpiryDetails) obj;
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
    static class Serializer extends StructSerializer<SharedContentChangeLinkExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentChangeLinkExpiryDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.newValue, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentChangeLinkExpiryDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentChangeLinkExpiryDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_newValue = null;
                Date f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedContentChangeLinkExpiryDetails(f_newValue, f_previousValue);
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
