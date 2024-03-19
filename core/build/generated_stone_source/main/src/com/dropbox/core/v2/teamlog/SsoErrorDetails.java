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

/**
 * Failed to sign in via SSO.
 */
public class SsoErrorDetails {
    // struct team_log.SsoErrorDetails (team_log_generated.stone)

    @Nonnull
    protected final FailureDetailsLogInfo errorDetails;

    /**
     * Failed to sign in via SSO.
     *
     * @param errorDetails  Error details. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SsoErrorDetails(@Nonnull FailureDetailsLogInfo errorDetails) {
        if (errorDetails == null) {
            throw new IllegalArgumentException("Required value for 'errorDetails' is null");
        }
        this.errorDetails = errorDetails;
    }

    /**
     * Error details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FailureDetailsLogInfo getErrorDetails() {
        return errorDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            errorDetails
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
            SsoErrorDetails other = (SsoErrorDetails) obj;
            return (this.errorDetails == other.errorDetails) || (this.errorDetails.equals(other.errorDetails));
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
    static class Serializer extends StructSerializer<SsoErrorDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoErrorDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("error_details");
            FailureDetailsLogInfo.Serializer.INSTANCE.serialize(value.errorDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SsoErrorDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SsoErrorDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FailureDetailsLogInfo f_errorDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("error_details".equals(field)) {
                        f_errorDetails = FailureDetailsLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_errorDetails == null) {
                    throw new JsonParseException(p, "Required field \"error_details\" missing.");
                }
                value = new SsoErrorDetails(f_errorDetails);
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
