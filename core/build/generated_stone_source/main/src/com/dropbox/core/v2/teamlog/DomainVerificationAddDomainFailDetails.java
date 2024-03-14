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
 * Failed to verify team domain.
 */
public class DomainVerificationAddDomainFailDetails {
    // struct team_log.DomainVerificationAddDomainFailDetails (team_log_generated.stone)

    protected final String domainName;
    protected final String verificationMethod;

    /**
     * Failed to verify team domain.
     *
     * @param domainName  Domain name. Must not be {@code null}.
     * @param verificationMethod  Domain name verification method. Might be
     *     missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainVerificationAddDomainFailDetails(String domainName, String verificationMethod) {
        if (domainName == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = domainName;
        this.verificationMethod = verificationMethod;
    }

    /**
     * Failed to verify team domain.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param domainName  Domain name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainVerificationAddDomainFailDetails(String domainName) {
        this(domainName, null);
    }

    /**
     * Domain name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getDomainName() {
        return domainName;
    }

    /**
     * Domain name verification method. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getVerificationMethod() {
        return verificationMethod;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domainName,
            verificationMethod
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
            DomainVerificationAddDomainFailDetails other = (DomainVerificationAddDomainFailDetails) obj;
            return ((this.domainName == other.domainName) || (this.domainName.equals(other.domainName)))
                && ((this.verificationMethod == other.verificationMethod) || (this.verificationMethod != null && this.verificationMethod.equals(other.verificationMethod)))
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
    static class Serializer extends StructSerializer<DomainVerificationAddDomainFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DomainVerificationAddDomainFailDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domain_name");
            StoneSerializers.string().serialize(value.domainName, g);
            if (value.verificationMethod != null) {
                g.writeFieldName("verification_method");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.verificationMethod, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DomainVerificationAddDomainFailDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DomainVerificationAddDomainFailDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_domainName = null;
                String f_verificationMethod = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domain_name".equals(field)) {
                        f_domainName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("verification_method".equals(field)) {
                        f_verificationMethod = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domainName == null) {
                    throw new JsonParseException(p, "Required field \"domain_name\" missing.");
                }
                value = new DomainVerificationAddDomainFailDetails(f_domainName, f_verificationMethod);
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
