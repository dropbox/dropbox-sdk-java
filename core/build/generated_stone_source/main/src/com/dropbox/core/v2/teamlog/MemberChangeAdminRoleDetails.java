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
 * Changed team member admin role.
 */
public class MemberChangeAdminRoleDetails {
    // struct team_log.MemberChangeAdminRoleDetails (team_log_generated.stone)

    @Nullable
    protected final AdminRole newValue;
    @Nullable
    protected final AdminRole previousValue;

    /**
     * Changed team member admin role.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newValue  New admin role. This field is relevant when the admin
     *     role is changed or whenthe user role changes from no admin rights to
     *     with admin rights.
     * @param previousValue  Previous admin role. This field is relevant when
     *     the admin role is changed or when the admin role is removed.
     */
    public MemberChangeAdminRoleDetails(@Nullable AdminRole newValue, @Nullable AdminRole previousValue) {
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Changed team member admin role.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public MemberChangeAdminRoleDetails() {
        this(null, null);
    }

    /**
     * New admin role. This field is relevant when the admin role is changed or
     * whenthe user role changes from no admin rights to with admin rights.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AdminRole getNewValue() {
        return newValue;
    }

    /**
     * Previous admin role. This field is relevant when the admin role is
     * changed or when the admin role is removed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AdminRole getPreviousValue() {
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
     * Builder for {@link MemberChangeAdminRoleDetails}.
     */
    public static class Builder {

        protected AdminRole newValue;
        protected AdminRole previousValue;

        protected Builder() {
            this.newValue = null;
            this.previousValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New admin role. This field is relevant when the
         *     admin role is changed or whenthe user role changes from no admin
         *     rights to with admin rights.
         *
         * @return this builder
         */
        public Builder withNewValue(AdminRole newValue) {
            this.newValue = newValue;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous admin role. This field is relevant
         *     when the admin role is changed or when the admin role is removed.
         *
         * @return this builder
         */
        public Builder withPreviousValue(AdminRole previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Builds an instance of {@link MemberChangeAdminRoleDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link MemberChangeAdminRoleDetails}
         */
        public MemberChangeAdminRoleDetails build() {
            return new MemberChangeAdminRoleDetails(newValue, previousValue);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.newValue,
            this.previousValue
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
            MemberChangeAdminRoleDetails other = (MemberChangeAdminRoleDetails) obj;
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
    static class Serializer extends StructSerializer<MemberChangeAdminRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberChangeAdminRoleDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).serialize(value.newValue, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberChangeAdminRoleDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberChangeAdminRoleDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AdminRole f_newValue = null;
                AdminRole f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(AdminRole.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new MemberChangeAdminRoleDetails(f_newValue, f_previousValue);
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
