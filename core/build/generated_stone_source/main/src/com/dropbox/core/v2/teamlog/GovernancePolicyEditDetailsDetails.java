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
 * Edited policy.
 */
public class GovernancePolicyEditDetailsDetails {
    // struct team_log.GovernancePolicyEditDetailsDetails (team_log_generated.stone)

    protected final String governancePolicyId;
    protected final String name;
    protected final PolicyType policyType;
    protected final String attribute;
    protected final String previousValue;
    protected final String newValue;

    /**
     * Edited policy.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param attribute  Attribute. Must not be {@code null}.
     * @param previousValue  From. Must not be {@code null}.
     * @param newValue  To. Must not be {@code null}.
     * @param policyType  Policy type.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyEditDetailsDetails(String governancePolicyId, String name, String attribute, String previousValue, String newValue, PolicyType policyType) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
        if (attribute == null) {
            throw new IllegalArgumentException("Required value for 'attribute' is null");
        }
        this.attribute = attribute;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * Edited policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param attribute  Attribute. Must not be {@code null}.
     * @param previousValue  From. Must not be {@code null}.
     * @param newValue  To. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyEditDetailsDetails(String governancePolicyId, String name, String attribute, String previousValue, String newValue) {
        this(governancePolicyId, name, attribute, previousValue, newValue, null);
    }

    /**
     * Policy ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getGovernancePolicyId() {
        return governancePolicyId;
    }

    /**
     * Policy name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Attribute.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * From.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPreviousValue() {
        return previousValue;
    }

    /**
     * To.
     *
     * @return value for this field, never {@code null}.
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * Policy type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public PolicyType getPolicyType() {
        return policyType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            governancePolicyId,
            name,
            policyType,
            attribute,
            previousValue,
            newValue
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
            GovernancePolicyEditDetailsDetails other = (GovernancePolicyEditDetailsDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.attribute == other.attribute) || (this.attribute.equals(other.attribute)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.policyType == other.policyType) || (this.policyType != null && this.policyType.equals(other.policyType)))
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
    static class Serializer extends StructSerializer<GovernancePolicyEditDetailsDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyEditDetailsDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(value.governancePolicyId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("attribute");
            StoneSerializers.string().serialize(value.attribute, g);
            g.writeFieldName("previous_value");
            StoneSerializers.string().serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            StoneSerializers.string().serialize(value.newValue, g);
            if (value.policyType != null) {
                g.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(value.policyType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GovernancePolicyEditDetailsDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyEditDetailsDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
                String f_attribute = null;
                String f_previousValue = null;
                String f_newValue = null;
                PolicyType f_policyType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("governance_policy_id".equals(field)) {
                        f_governancePolicyId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("attribute".equals(field)) {
                        f_attribute = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.string().deserialize(p);
                    }
                    else if ("policy_type".equals(field)) {
                        f_policyType = StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_governancePolicyId == null) {
                    throw new JsonParseException(p, "Required field \"governance_policy_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_attribute == null) {
                    throw new JsonParseException(p, "Required field \"attribute\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new GovernancePolicyEditDetailsDetails(f_governancePolicyId, f_name, f_attribute, f_previousValue, f_newValue, f_policyType);
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
