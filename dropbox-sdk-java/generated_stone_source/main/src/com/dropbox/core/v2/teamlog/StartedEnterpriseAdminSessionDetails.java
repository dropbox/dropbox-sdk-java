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
 * Started enterprise admin session.
 */
public class StartedEnterpriseAdminSessionDetails {
    // struct team_log.StartedEnterpriseAdminSessionDetails (team_log_generated.stone)

    protected final FedExtraDetails federationExtraDetails;

    /**
     * Started enterprise admin session.
     *
     * @param federationExtraDetails  More information about the organization or
     *     team. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public StartedEnterpriseAdminSessionDetails(FedExtraDetails federationExtraDetails) {
        if (federationExtraDetails == null) {
            throw new IllegalArgumentException("Required value for 'federationExtraDetails' is null");
        }
        this.federationExtraDetails = federationExtraDetails;
    }

    /**
     * More information about the organization or team.
     *
     * @return value for this field, never {@code null}.
     */
    public FedExtraDetails getFederationExtraDetails() {
        return federationExtraDetails;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            federationExtraDetails
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
            StartedEnterpriseAdminSessionDetails other = (StartedEnterpriseAdminSessionDetails) obj;
            return (this.federationExtraDetails == other.federationExtraDetails) || (this.federationExtraDetails.equals(other.federationExtraDetails));
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
    static class Serializer extends StructSerializer<StartedEnterpriseAdminSessionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(StartedEnterpriseAdminSessionDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("federation_extra_details");
            FedExtraDetails.Serializer.INSTANCE.serialize(value.federationExtraDetails, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public StartedEnterpriseAdminSessionDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            StartedEnterpriseAdminSessionDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FedExtraDetails f_federationExtraDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("federation_extra_details".equals(field)) {
                        f_federationExtraDetails = FedExtraDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_federationExtraDetails == null) {
                    throw new JsonParseException(p, "Required field \"federation_extra_details\" missing.");
                }
                value = new StartedEnterpriseAdminSessionDetails(f_federationExtraDetails);
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
