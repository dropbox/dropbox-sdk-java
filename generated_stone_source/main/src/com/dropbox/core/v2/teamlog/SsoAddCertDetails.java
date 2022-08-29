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
 * Added X.509 certificate for SSO.
 */
public class SsoAddCertDetails {
    // struct team_log.SsoAddCertDetails (team_log_generated.stone)

    protected final Certificate certificateDetails;

    /**
     * Added X.509 certificate for SSO.
     *
     * @param certificateDetails  SSO certificate details. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SsoAddCertDetails(Certificate certificateDetails) {
        if (certificateDetails == null) {
            throw new IllegalArgumentException("Required value for 'certificateDetails' is null");
        }
        this.certificateDetails = certificateDetails;
    }

    /**
     * SSO certificate details.
     *
     * @return value for this field, never {@code null}.
     */
    public Certificate getCertificateDetails() {
        return certificateDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            certificateDetails
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
            SsoAddCertDetails other = (SsoAddCertDetails) obj;
            return (this.certificateDetails == other.certificateDetails) || (this.certificateDetails.equals(other.certificateDetails));
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
    static class Serializer extends StructSerializer<SsoAddCertDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoAddCertDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("certificate_details");
            Certificate.Serializer.INSTANCE.serialize(value.certificateDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SsoAddCertDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SsoAddCertDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Certificate f_certificateDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("certificate_details".equals(field)) {
                        f_certificateDetails = Certificate.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_certificateDetails == null) {
                    throw new JsonParseException(p, "Required field \"certificate_details\" missing.");
                }
                value = new SsoAddCertDetails(f_certificateDetails);
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
