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
 * Sent domain invites to existing domain accounts.
 */
public class DomainInvitesEmailExistingUsersDetails {
    // struct team_log.DomainInvitesEmailExistingUsersDetails (team_log_generated.stone)

    protected final String domainName;
    protected final long numRecipients;

    /**
     * Sent domain invites to existing domain accounts.
     *
     * @param domainName  Domain names. Must not be {@code null}.
     * @param numRecipients  Number of recipients.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DomainInvitesEmailExistingUsersDetails(@javax.annotation.Nonnull String domainName, long numRecipients) {
        if (domainName == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = domainName;
        this.numRecipients = numRecipients;
    }

    /**
     * Domain names.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getDomainName() {
        return domainName;
    }

    /**
     * Number of recipients.
     *
     * @return value for this field.
     */
    public long getNumRecipients() {
        return numRecipients;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            domainName,
            numRecipients
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
            DomainInvitesEmailExistingUsersDetails other = (DomainInvitesEmailExistingUsersDetails) obj;
            return ((this.domainName == other.domainName) || (this.domainName.equals(other.domainName)))
                && (this.numRecipients == other.numRecipients)
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
    static class Serializer extends StructSerializer<DomainInvitesEmailExistingUsersDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DomainInvitesEmailExistingUsersDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("domain_name");
            StoneSerializers.string().serialize(value.domainName, g);
            g.writeFieldName("num_recipients");
            StoneSerializers.uInt64().serialize(value.numRecipients, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DomainInvitesEmailExistingUsersDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DomainInvitesEmailExistingUsersDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_domainName = null;
                Long f_numRecipients = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("domain_name".equals(field)) {
                        f_domainName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("num_recipients".equals(field)) {
                        f_numRecipients = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_domainName == null) {
                    throw new JsonParseException(p, "Required field \"domain_name\" missing.");
                }
                if (f_numRecipients == null) {
                    throw new JsonParseException(p, "Required field \"num_recipients\" missing.");
                }
                value = new DomainInvitesEmailExistingUsersDetails(f_domainName, f_numRecipients);
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
