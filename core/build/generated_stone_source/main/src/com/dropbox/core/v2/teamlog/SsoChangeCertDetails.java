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
 * Changed X.509 certificate for SSO.
 */
public class SsoChangeCertDetails {
    // struct team_log.SsoChangeCertDetails (team_log_generated.stone)

    @Nullable
    protected final Certificate previousCertificateDetails;
    @Nonnull
    protected final Certificate newCertificateDetails;

    /**
     * Changed X.509 certificate for SSO.
     *
     * @param newCertificateDetails  New SSO certificate details. Must not be
     *     {@code null}.
     * @param previousCertificateDetails  Previous SSO certificate details.
     *     Might be missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SsoChangeCertDetails(@Nonnull Certificate newCertificateDetails, @Nullable Certificate previousCertificateDetails) {
        this.previousCertificateDetails = previousCertificateDetails;
        if (newCertificateDetails == null) {
            throw new IllegalArgumentException("Required value for 'newCertificateDetails' is null");
        }
        this.newCertificateDetails = newCertificateDetails;
    }

    /**
     * Changed X.509 certificate for SSO.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newCertificateDetails  New SSO certificate details. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SsoChangeCertDetails(@Nonnull Certificate newCertificateDetails) {
        this(newCertificateDetails, null);
    }

    /**
     * New SSO certificate details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Certificate getNewCertificateDetails() {
        return newCertificateDetails;
    }

    /**
     * Previous SSO certificate details. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Certificate getPreviousCertificateDetails() {
        return previousCertificateDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.previousCertificateDetails,
            this.newCertificateDetails
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
            SsoChangeCertDetails other = (SsoChangeCertDetails) obj;
            return ((this.newCertificateDetails == other.newCertificateDetails) || (this.newCertificateDetails.equals(other.newCertificateDetails)))
                && ((this.previousCertificateDetails == other.previousCertificateDetails) || (this.previousCertificateDetails != null && this.previousCertificateDetails.equals(other.previousCertificateDetails)))
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
    static class Serializer extends StructSerializer<SsoChangeCertDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoChangeCertDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_certificate_details");
            Certificate.Serializer.INSTANCE.serialize(value.newCertificateDetails, g);
            if (value.previousCertificateDetails != null) {
                g.writeFieldName("previous_certificate_details");
                StoneSerializers.nullableStruct(Certificate.Serializer.INSTANCE).serialize(value.previousCertificateDetails, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SsoChangeCertDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SsoChangeCertDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Certificate f_newCertificateDetails = null;
                Certificate f_previousCertificateDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_certificate_details".equals(field)) {
                        f_newCertificateDetails = Certificate.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_certificate_details".equals(field)) {
                        f_previousCertificateDetails = StoneSerializers.nullableStruct(Certificate.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newCertificateDetails == null) {
                    throw new JsonParseException(p, "Required field \"new_certificate_details\" missing.");
                }
                value = new SsoChangeCertDetails(f_newCertificateDetails, f_previousCertificateDetails);
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
