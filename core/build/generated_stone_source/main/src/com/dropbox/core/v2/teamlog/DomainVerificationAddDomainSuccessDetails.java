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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Verified team domain.
 */
public class DomainVerificationAddDomainSuccessDetails {
    // struct team_log.DomainVerificationAddDomainSuccessDetails (team_log_generated.stone)

    protected final List<String> domainNames;
    protected final String verificationMethod;

    /**
     * Verified team domain.
     *
     * @param domainNames  Domain names. Must not contain a {@code null} item
     *     and not be {@code null}.
     * @param verificationMethod  Domain name verification method. Might be
     *     missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainVerificationAddDomainSuccessDetails(@Nonnull List<String> domainNames, @Nullable String verificationMethod) {
        if (domainNames == null) {
            throw new IllegalArgumentException("Required value for 'domainNames' is null");
        }
        for (String x : domainNames) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'domainNames' is null");
            }
        }
        this.domainNames = domainNames;
        this.verificationMethod = verificationMethod;
    }

    /**
     * Verified team domain.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param domainNames  Domain names. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainVerificationAddDomainSuccessDetails(List<String> domainNames) {
        this(domainNames, null);
    }

    /**
     * Domain names.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getDomainNames() {
        return domainNames;
    }

    /**
     * Domain name verification method. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getVerificationMethod() {
        return verificationMethod;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domainNames,
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
            DomainVerificationAddDomainSuccessDetails other = (DomainVerificationAddDomainSuccessDetails) obj;
            return ((this.domainNames == other.domainNames) || (this.domainNames.equals(other.domainNames)))
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
    static class Serializer extends StructSerializer<DomainVerificationAddDomainSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DomainVerificationAddDomainSuccessDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domain_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.domainNames, g);
            if (value.verificationMethod != null) {
                g.writeFieldName("verification_method");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.verificationMethod, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DomainVerificationAddDomainSuccessDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DomainVerificationAddDomainSuccessDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_domainNames = null;
                String f_verificationMethod = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domain_names".equals(field)) {
                        f_domainNames = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("verification_method".equals(field)) {
                        f_verificationMethod = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domainNames == null) {
                    throw new JsonParseException(p, "Required field \"domain_names\" missing.");
                }
                value = new DomainVerificationAddDomainSuccessDetails(f_domainNames, f_verificationMethod);
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
