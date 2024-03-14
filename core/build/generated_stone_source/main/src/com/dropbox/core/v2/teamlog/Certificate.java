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
 * Certificate details.
 */
public class Certificate {
    // struct team_log.Certificate (team_log_generated.stone)

    protected final String subject;
    protected final String issuer;
    protected final String issueDate;
    protected final String expirationDate;
    protected final String serialNumber;
    protected final String sha1Fingerprint;
    protected final String commonName;

    /**
     * Certificate details.
     *
     * @param subject  Certificate subject. Must not be {@code null}.
     * @param issuer  Certificate issuer. Must not be {@code null}.
     * @param issueDate  Certificate issue date. Must not be {@code null}.
     * @param expirationDate  Certificate expiration date. Must not be {@code
     *     null}.
     * @param serialNumber  Certificate serial number. Must not be {@code null}.
     * @param sha1Fingerprint  Certificate sha1 fingerprint. Must not be {@code
     *     null}.
     * @param commonName  Certificate common name.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Certificate(@Nonnull String subject, @Nonnull String issuer, @Nonnull String issueDate, @Nonnull String expirationDate, @Nonnull String serialNumber, @Nonnull String sha1Fingerprint, @Nullable String commonName) {
        if (subject == null) {
            throw new IllegalArgumentException("Required value for 'subject' is null");
        }
        this.subject = subject;
        if (issuer == null) {
            throw new IllegalArgumentException("Required value for 'issuer' is null");
        }
        this.issuer = issuer;
        if (issueDate == null) {
            throw new IllegalArgumentException("Required value for 'issueDate' is null");
        }
        this.issueDate = issueDate;
        if (expirationDate == null) {
            throw new IllegalArgumentException("Required value for 'expirationDate' is null");
        }
        this.expirationDate = expirationDate;
        if (serialNumber == null) {
            throw new IllegalArgumentException("Required value for 'serialNumber' is null");
        }
        this.serialNumber = serialNumber;
        if (sha1Fingerprint == null) {
            throw new IllegalArgumentException("Required value for 'sha1Fingerprint' is null");
        }
        this.sha1Fingerprint = sha1Fingerprint;
        this.commonName = commonName;
    }

    /**
     * Certificate details.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param subject  Certificate subject. Must not be {@code null}.
     * @param issuer  Certificate issuer. Must not be {@code null}.
     * @param issueDate  Certificate issue date. Must not be {@code null}.
     * @param expirationDate  Certificate expiration date. Must not be {@code
     *     null}.
     * @param serialNumber  Certificate serial number. Must not be {@code null}.
     * @param sha1Fingerprint  Certificate sha1 fingerprint. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Certificate(@Nonnull String subject, @Nonnull String issuer, @Nonnull String issueDate, @Nonnull String expirationDate, @Nonnull String serialNumber, @Nonnull String sha1Fingerprint) {
        this(subject, issuer, issueDate, expirationDate, serialNumber, sha1Fingerprint, null);
    }

    /**
     * Certificate subject.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSubject() {
        return subject;
    }

    /**
     * Certificate issuer.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getIssuer() {
        return issuer;
    }

    /**
     * Certificate issue date.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * Certificate expiration date.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Certificate serial number.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Certificate sha1 fingerprint.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSha1Fingerprint() {
        return sha1Fingerprint;
    }

    /**
     * Certificate common name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCommonName() {
        return commonName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            subject,
            issuer,
            issueDate,
            expirationDate,
            serialNumber,
            sha1Fingerprint,
            commonName
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
            Certificate other = (Certificate) obj;
            return ((this.subject == other.subject) || (this.subject.equals(other.subject)))
                && ((this.issuer == other.issuer) || (this.issuer.equals(other.issuer)))
                && ((this.issueDate == other.issueDate) || (this.issueDate.equals(other.issueDate)))
                && ((this.expirationDate == other.expirationDate) || (this.expirationDate.equals(other.expirationDate)))
                && ((this.serialNumber == other.serialNumber) || (this.serialNumber.equals(other.serialNumber)))
                && ((this.sha1Fingerprint == other.sha1Fingerprint) || (this.sha1Fingerprint.equals(other.sha1Fingerprint)))
                && ((this.commonName == other.commonName) || (this.commonName != null && this.commonName.equals(other.commonName)))
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
    static class Serializer extends StructSerializer<Certificate> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Certificate value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("subject");
            StoneSerializers.string().serialize(value.subject, g);
            g.writeFieldName("issuer");
            StoneSerializers.string().serialize(value.issuer, g);
            g.writeFieldName("issue_date");
            StoneSerializers.string().serialize(value.issueDate, g);
            g.writeFieldName("expiration_date");
            StoneSerializers.string().serialize(value.expirationDate, g);
            g.writeFieldName("serial_number");
            StoneSerializers.string().serialize(value.serialNumber, g);
            g.writeFieldName("sha1_fingerprint");
            StoneSerializers.string().serialize(value.sha1Fingerprint, g);
            if (value.commonName != null) {
                g.writeFieldName("common_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.commonName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Certificate deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Certificate value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_subject = null;
                String f_issuer = null;
                String f_issueDate = null;
                String f_expirationDate = null;
                String f_serialNumber = null;
                String f_sha1Fingerprint = null;
                String f_commonName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("subject".equals(field)) {
                        f_subject = StoneSerializers.string().deserialize(p);
                    }
                    else if ("issuer".equals(field)) {
                        f_issuer = StoneSerializers.string().deserialize(p);
                    }
                    else if ("issue_date".equals(field)) {
                        f_issueDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("expiration_date".equals(field)) {
                        f_expirationDate = StoneSerializers.string().deserialize(p);
                    }
                    else if ("serial_number".equals(field)) {
                        f_serialNumber = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sha1_fingerprint".equals(field)) {
                        f_sha1Fingerprint = StoneSerializers.string().deserialize(p);
                    }
                    else if ("common_name".equals(field)) {
                        f_commonName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_subject == null) {
                    throw new JsonParseException(p, "Required field \"subject\" missing.");
                }
                if (f_issuer == null) {
                    throw new JsonParseException(p, "Required field \"issuer\" missing.");
                }
                if (f_issueDate == null) {
                    throw new JsonParseException(p, "Required field \"issue_date\" missing.");
                }
                if (f_expirationDate == null) {
                    throw new JsonParseException(p, "Required field \"expiration_date\" missing.");
                }
                if (f_serialNumber == null) {
                    throw new JsonParseException(p, "Required field \"serial_number\" missing.");
                }
                if (f_sha1Fingerprint == null) {
                    throw new JsonParseException(p, "Required field \"sha1_fingerprint\" missing.");
                }
                value = new Certificate(f_subject, f_issuer, f_issueDate, f_expirationDate, f_serialNumber, f_sha1Fingerprint, f_commonName);
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
