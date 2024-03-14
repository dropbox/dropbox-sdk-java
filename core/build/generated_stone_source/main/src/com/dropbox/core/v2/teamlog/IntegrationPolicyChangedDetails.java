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
 * Changed integration policy for team.
 */
public class IntegrationPolicyChangedDetails {
    // struct team_log.IntegrationPolicyChangedDetails (team_log_generated.stone)

    protected final String integrationName;
    protected final IntegrationPolicy newValue;
    protected final IntegrationPolicy previousValue;

    /**
     * Changed integration policy for team.
     *
     * @param integrationName  Name of the third-party integration. Must not be
     *     {@code null}.
     * @param newValue  New integration policy. Must not be {@code null}.
     * @param previousValue  Previous integration policy. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public IntegrationPolicyChangedDetails(String integrationName, IntegrationPolicy newValue, IntegrationPolicy previousValue) {
        if (integrationName == null) {
            throw new IllegalArgumentException("Required value for 'integrationName' is null");
        }
        this.integrationName = integrationName;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
    }

    /**
     * Name of the third-party integration.
     *
     * @return value for this field, never {@code null}.
     */
    public String getIntegrationName() {
        return integrationName;
    }

    /**
     * New integration policy.
     *
     * @return value for this field, never {@code null}.
     */
    public IntegrationPolicy getNewValue() {
        return newValue;
    }

    /**
     * Previous integration policy.
     *
     * @return value for this field, never {@code null}.
     */
    public IntegrationPolicy getPreviousValue() {
        return previousValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            integrationName,
            newValue,
            previousValue
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
            IntegrationPolicyChangedDetails other = (IntegrationPolicyChangedDetails) obj;
            return ((this.integrationName == other.integrationName) || (this.integrationName.equals(other.integrationName)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<IntegrationPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(IntegrationPolicyChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("integration_name");
            StoneSerializers.string().serialize(value.integrationName, g);
            g.writeFieldName("new_value");
            IntegrationPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            g.writeFieldName("previous_value");
            IntegrationPolicy.Serializer.INSTANCE.serialize(value.previousValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public IntegrationPolicyChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            IntegrationPolicyChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_integrationName = null;
                IntegrationPolicy f_newValue = null;
                IntegrationPolicy f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("integration_name".equals(field)) {
                        f_integrationName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = IntegrationPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = IntegrationPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_integrationName == null) {
                    throw new JsonParseException(p, "Required field \"integration_name\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                value = new IntegrationPolicyChangedDetails(f_integrationName, f_newValue, f_previousValue);
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
