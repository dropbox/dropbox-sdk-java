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
 * Changed member status (invited, joined, suspended, etc.).
 */
public class MemberChangeStatusDetails {
    // struct team_log.MemberChangeStatusDetails (team_log_generated.stone)

    protected final MemberStatus previousValue;
    protected final MemberStatus newValue;
    protected final ActionDetails action;

    /**
     * Changed member status (invited, joined, suspended, etc.).
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New member status. Must not be {@code null}.
     * @param previousValue  Previous member status. Might be missing due to
     *     historical data gap.
     * @param action  Additional information indicating the action taken that
     *     caused status change.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberChangeStatusDetails(MemberStatus newValue, MemberStatus previousValue, ActionDetails action) {
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.action = action;
    }

    /**
     * Changed member status (invited, joined, suspended, etc.).
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  New member status. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberChangeStatusDetails(MemberStatus newValue) {
        this(newValue, null, null);
    }

    /**
     * New member status.
     *
     * @return value for this field, never {@code null}.
     */
    public MemberStatus getNewValue() {
        return newValue;
    }

    /**
     * Previous member status. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public MemberStatus getPreviousValue() {
        return previousValue;
    }

    /**
     * Additional information indicating the action taken that caused status
     * change.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public ActionDetails getAction() {
        return action;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param newValue  New member status. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(MemberStatus newValue) {
        return new Builder(newValue);
    }

    /**
     * Builder for {@link MemberChangeStatusDetails}.
     */
    public static class Builder {
        protected final MemberStatus newValue;

        protected MemberStatus previousValue;
        protected ActionDetails action;

        protected Builder(MemberStatus newValue) {
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            this.previousValue = null;
            this.action = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous member status. Might be missing due to
         *     historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(MemberStatus previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param action  Additional information indicating the action taken
         *     that caused status change.
         *
         * @return this builder
         */
        public Builder withAction(ActionDetails action) {
            this.action = action;
            return this;
        }

        /**
         * Builds an instance of {@link MemberChangeStatusDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link MemberChangeStatusDetails}
         */
        public MemberChangeStatusDetails build() {
            return new MemberChangeStatusDetails(newValue, previousValue, action);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousValue,
            newValue,
            action
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
            MemberChangeStatusDetails other = (MemberChangeStatusDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
                && ((this.action == other.action) || (this.action != null && this.action.equals(other.action)))
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
    static class Serializer extends StructSerializer<MemberChangeStatusDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberChangeStatusDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            MemberStatus.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(MemberStatus.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (value.action != null) {
                g.writeFieldName("action");
                StoneSerializers.nullable(ActionDetails.Serializer.INSTANCE).serialize(value.action, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberChangeStatusDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberChangeStatusDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MemberStatus f_newValue = null;
                MemberStatus f_previousValue = null;
                ActionDetails f_action = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = MemberStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(MemberStatus.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("action".equals(field)) {
                        f_action = StoneSerializers.nullable(ActionDetails.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new MemberChangeStatusDetails(f_newValue, f_previousValue, f_action);
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
