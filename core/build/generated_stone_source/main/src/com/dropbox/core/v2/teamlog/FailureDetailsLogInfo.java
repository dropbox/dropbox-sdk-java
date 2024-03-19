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
 * Provides details about a failure
 */
public class FailureDetailsLogInfo {
    // struct team_log.FailureDetailsLogInfo (team_log_generated.stone)

    @Nullable
    protected final String userFriendlyMessage;
    @Nullable
    protected final String technicalErrorMessage;

    /**
     * Provides details about a failure
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param userFriendlyMessage  A user friendly explanation of the error.
     * @param technicalErrorMessage  A technical explanation of the error. This
     *     is relevant for some errors.
     */
    public FailureDetailsLogInfo(@Nullable String userFriendlyMessage, @Nullable String technicalErrorMessage) {
        this.userFriendlyMessage = userFriendlyMessage;
        this.technicalErrorMessage = technicalErrorMessage;
    }

    /**
     * Provides details about a failure
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FailureDetailsLogInfo() {
        this(null, null);
    }

    /**
     * A user friendly explanation of the error.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getUserFriendlyMessage() {
        return userFriendlyMessage;
    }

    /**
     * A technical explanation of the error. This is relevant for some errors.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTechnicalErrorMessage() {
        return technicalErrorMessage;
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
     * Builder for {@link FailureDetailsLogInfo}.
     */
    public static class Builder {

        protected String userFriendlyMessage;
        protected String technicalErrorMessage;

        protected Builder() {
            this.userFriendlyMessage = null;
            this.technicalErrorMessage = null;
        }

        /**
         * Set value for optional field.
         *
         * @param userFriendlyMessage  A user friendly explanation of the error.
         *
         * @return this builder
         */
        public Builder withUserFriendlyMessage(String userFriendlyMessage) {
            this.userFriendlyMessage = userFriendlyMessage;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param technicalErrorMessage  A technical explanation of the error.
         *     This is relevant for some errors.
         *
         * @return this builder
         */
        public Builder withTechnicalErrorMessage(String technicalErrorMessage) {
            this.technicalErrorMessage = technicalErrorMessage;
            return this;
        }

        /**
         * Builds an instance of {@link FailureDetailsLogInfo} configured with
         * this builder's values
         *
         * @return new instance of {@link FailureDetailsLogInfo}
         */
        public FailureDetailsLogInfo build() {
            return new FailureDetailsLogInfo(userFriendlyMessage, technicalErrorMessage);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            userFriendlyMessage,
            technicalErrorMessage
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
            FailureDetailsLogInfo other = (FailureDetailsLogInfo) obj;
            return ((this.userFriendlyMessage == other.userFriendlyMessage) || (this.userFriendlyMessage != null && this.userFriendlyMessage.equals(other.userFriendlyMessage)))
                && ((this.technicalErrorMessage == other.technicalErrorMessage) || (this.technicalErrorMessage != null && this.technicalErrorMessage.equals(other.technicalErrorMessage)))
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
    static class Serializer extends StructSerializer<FailureDetailsLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FailureDetailsLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.userFriendlyMessage != null) {
                g.writeFieldName("user_friendly_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.userFriendlyMessage, g);
            }
            if (value.technicalErrorMessage != null) {
                g.writeFieldName("technical_error_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.technicalErrorMessage, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FailureDetailsLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FailureDetailsLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_userFriendlyMessage = null;
                String f_technicalErrorMessage = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user_friendly_message".equals(field)) {
                        f_userFriendlyMessage = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("technical_error_message".equals(field)) {
                        f_technicalErrorMessage = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FailureDetailsLogInfo(f_userFriendlyMessage, f_technicalErrorMessage);
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
