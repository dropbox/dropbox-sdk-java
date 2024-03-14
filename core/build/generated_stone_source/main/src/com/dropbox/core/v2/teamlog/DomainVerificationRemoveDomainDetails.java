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

/**
 * Removed domain from list of verified team domains.
 */
public class DomainVerificationRemoveDomainDetails {
    // struct team_log.DomainVerificationRemoveDomainDetails (team_log_generated.stone)

    protected final List<String> domainNames;

    /**
     * Removed domain from list of verified team domains.
     *
     * @param domainNames  Domain names. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainVerificationRemoveDomainDetails(@javax.annotation.Nonnull List<String> domainNames) {
        if (domainNames == null) {
            throw new IllegalArgumentException("Required value for 'domainNames' is null");
        }
        for (String x : domainNames) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'domainNames' is null");
            }
        }
        this.domainNames = domainNames;
    }

    /**
     * Domain names.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getDomainNames() {
        return domainNames;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domainNames
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
            DomainVerificationRemoveDomainDetails other = (DomainVerificationRemoveDomainDetails) obj;
            return (this.domainNames == other.domainNames) || (this.domainNames.equals(other.domainNames));
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
    static class Serializer extends StructSerializer<DomainVerificationRemoveDomainDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DomainVerificationRemoveDomainDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domain_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.domainNames, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DomainVerificationRemoveDomainDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DomainVerificationRemoveDomainDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_domainNames = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domain_names".equals(field)) {
                        f_domainNames = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domainNames == null) {
                    throw new JsonParseException(p, "Required field \"domain_names\" missing.");
                }
                value = new DomainVerificationRemoveDomainDetails(f_domainNames);
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
