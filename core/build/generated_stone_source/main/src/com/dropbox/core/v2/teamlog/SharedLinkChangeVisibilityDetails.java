/* DO NOT EDIT */
/* This file was generated from team_log.stone */

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
 * Changed visibility of shared link.
 */
public class SharedLinkChangeVisibilityDetails {
    // struct team_log.SharedLinkChangeVisibilityDetails (team_log.stone)

    @Nonnull
    protected final SharedLinkVisibility newValue;
    @Nullable
    protected final SharedLinkVisibility previousValue;
    @Nullable
    protected final Boolean isConsolidationAction;

    /**
     * Changed visibility of shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New shared link visibility. Must not be {@code null}.
     * @param previousValue  Previous shared link visibility. Might be missing
     *     due to historical data gap.
     * @param isConsolidationAction  Indicates whether this was a consolidation
     *     action by system.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkChangeVisibilityDetails(@Nonnull SharedLinkVisibility newValue, @Nullable SharedLinkVisibility previousValue, @Nullable Boolean isConsolidationAction) {
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.previousValue = previousValue;
        this.isConsolidationAction = isConsolidationAction;
    }

    /**
     * Changed visibility of shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  New shared link visibility. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkChangeVisibilityDetails(@Nonnull SharedLinkVisibility newValue) {
        this(newValue, null, null);
    }

    /**
     * New shared link visibility.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedLinkVisibility getNewValue() {
        return newValue;
    }

    /**
     * Previous shared link visibility. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedLinkVisibility getPreviousValue() {
        return previousValue;
    }

    /**
     * Indicates whether this was a consolidation action by system.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsConsolidationAction() {
        return isConsolidationAction;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param newValue  New shared link visibility. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(SharedLinkVisibility newValue) {
        return new Builder(newValue);
    }

    /**
     * Builder for {@link SharedLinkChangeVisibilityDetails}.
     */
    public static class Builder {
        protected final SharedLinkVisibility newValue;

        protected SharedLinkVisibility previousValue;
        protected Boolean isConsolidationAction;

        protected Builder(SharedLinkVisibility newValue) {
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            this.previousValue = null;
            this.isConsolidationAction = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous shared link visibility. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(SharedLinkVisibility previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isConsolidationAction  Indicates whether this was a
         *     consolidation action by system.
         *
         * @return this builder
         */
        public Builder withIsConsolidationAction(Boolean isConsolidationAction) {
            this.isConsolidationAction = isConsolidationAction;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkChangeVisibilityDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link SharedLinkChangeVisibilityDetails}
         */
        public SharedLinkChangeVisibilityDetails build() {
            return new SharedLinkChangeVisibilityDetails(newValue, previousValue, isConsolidationAction);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.newValue,
            this.previousValue,
            this.isConsolidationAction
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
            SharedLinkChangeVisibilityDetails other = (SharedLinkChangeVisibilityDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
                && ((this.isConsolidationAction == other.isConsolidationAction) || (this.isConsolidationAction != null && this.isConsolidationAction.equals(other.isConsolidationAction)))
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
    static class Serializer extends StructSerializer<SharedLinkChangeVisibilityDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkChangeVisibilityDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            SharedLinkVisibility.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(SharedLinkVisibility.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (value.isConsolidationAction != null) {
                g.writeFieldName("is_consolidation_action");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isConsolidationAction, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkChangeVisibilityDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkChangeVisibilityDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharedLinkVisibility f_newValue = null;
                SharedLinkVisibility f_previousValue = null;
                Boolean f_isConsolidationAction = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = SharedLinkVisibility.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(SharedLinkVisibility.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("is_consolidation_action".equals(field)) {
                        f_isConsolidationAction = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new SharedLinkChangeVisibilityDetails(f_newValue, f_previousValue, f_isConsolidationAction);
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
