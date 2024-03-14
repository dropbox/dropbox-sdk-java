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
 * More details about the organization.
 */
public class OrganizationDetails {
    // struct team_log.OrganizationDetails (team_log_generated.stone)

    protected final String organization;

    /**
     * More details about the organization.
     *
     * @param organization  The name of the organization. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public OrganizationDetails(@javax.annotation.Nonnull String organization) {
        if (organization == null) {
            throw new IllegalArgumentException("Required value for 'organization' is null");
        }
        this.organization = organization;
    }

    /**
     * The name of the organization.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getOrganization() {
        return organization;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            organization
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
            OrganizationDetails other = (OrganizationDetails) obj;
            return (this.organization == other.organization) || (this.organization.equals(other.organization));
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
    static class Serializer extends StructSerializer<OrganizationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(OrganizationDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("organization");
            StoneSerializers.string().serialize(value.organization, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public OrganizationDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            OrganizationDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_organization = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("organization".equals(field)) {
                        f_organization = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_organization == null) {
                    throw new JsonParseException(p, "Required field \"organization\" missing.");
                }
                value = new OrganizationDetails(f_organization);
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
