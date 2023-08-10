/* DO NOT EDIT */
/* This file was generated from openid_openid_types.stone */

package com.dropbox.core.v2.openid;

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

public class UserInfoError {
    // struct openid.UserInfoError (openid_openid_types.stone)

    protected final ErrUnion err;
    protected final String errorMessage;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param errorMessage  Brief explanation of the error. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserInfoError(ErrUnion err, String errorMessage) {
        this.err = err;
        if (errorMessage == null) {
            throw new IllegalArgumentException("Required value for 'errorMessage' is null");
        }
        this.errorMessage = errorMessage;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public UserInfoError() {
        this(null, "");
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    public ErrUnion getErr() {
        return err;
    }

    /**
     * Brief explanation of the error.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "".
     */
    public String getErrorMessage() {
        return errorMessage;
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
     * Builder for {@link UserInfoError}.
     */
    public static class Builder {

        protected ErrUnion err;
        protected String errorMessage;

        protected Builder() {
            this.err = null;
            this.errorMessage = "";
        }

        /**
         * Set value for optional field.
         *
         * @return this builder
         */
        public Builder withErr(ErrUnion err) {
            this.err = err;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code ""}.
         * </p>
         *
         * @param errorMessage  Brief explanation of the error. Must not be
         *     {@code null}. Defaults to {@code ""} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withErrorMessage(String errorMessage) {
            if (errorMessage != null) {
                this.errorMessage = errorMessage;
            }
            else {
                this.errorMessage = "";
            }
            return this;
        }

        /**
         * Builds an instance of {@link UserInfoError} configured with this
         * builder's values
         *
         * @return new instance of {@link UserInfoError}
         */
        public UserInfoError build() {
            return new UserInfoError(err, errorMessage);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            err,
            errorMessage
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
            UserInfoError other = (UserInfoError) obj;
            return ((this.err == other.err) || (this.err != null && this.err.equals(other.err)))
                && ((this.errorMessage == other.errorMessage) || (this.errorMessage.equals(other.errorMessage)))
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
    static class Serializer extends StructSerializer<UserInfoError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserInfoError value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.err != null) {
                g.writeFieldName("err");
                StoneSerializers.nullable(ErrUnion.Serializer.INSTANCE).serialize(value.err, g);
            }
            g.writeFieldName("error_message");
            StoneSerializers.string().serialize(value.errorMessage, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserInfoError deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserInfoError value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                ErrUnion f_err = null;
                String f_errorMessage = "";
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("err".equals(field)) {
                        f_err = StoneSerializers.nullable(ErrUnion.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("error_message".equals(field)) {
                        f_errorMessage = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new UserInfoError(f_err, f_errorMessage);
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
