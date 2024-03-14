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
 * Account-captured user changed account email to personal email.
 */
public class AccountCaptureRelinquishAccountDetails {
    // struct team_log.AccountCaptureRelinquishAccountDetails (team_log_generated.stone)

    protected final String domainName;

    /**
     * Account-captured user changed account email to personal email.
     *
     * @param domainName  Domain name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AccountCaptureRelinquishAccountDetails(@Nonnull String domainName) {
        if (domainName == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = domainName;
    }

    /**
     * Domain name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDomainName() {
        return domainName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domainName
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
            AccountCaptureRelinquishAccountDetails other = (AccountCaptureRelinquishAccountDetails) obj;
            return (this.domainName == other.domainName) || (this.domainName.equals(other.domainName));
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
    static class Serializer extends StructSerializer<AccountCaptureRelinquishAccountDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccountCaptureRelinquishAccountDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domain_name");
            StoneSerializers.string().serialize(value.domainName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AccountCaptureRelinquishAccountDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AccountCaptureRelinquishAccountDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_domainName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domain_name".equals(field)) {
                        f_domainName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domainName == null) {
                    throw new JsonParseException(p, "Required field \"domain_name\" missing.");
                }
                value = new AccountCaptureRelinquishAccountDetails(f_domainName);
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
