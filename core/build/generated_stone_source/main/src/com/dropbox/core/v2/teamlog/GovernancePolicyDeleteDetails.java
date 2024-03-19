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
 * Deleted a policy.
 */
public class GovernancePolicyDeleteDetails {
    // struct team_log.GovernancePolicyDeleteDetails (team_log_generated.stone)

    @Nonnull
    protected final String governancePolicyId;
    @Nonnull
    protected final String name;
    @Nullable
    protected final PolicyType policyType;

    /**
     * Deleted a policy.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param policyType  Policy type.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyDeleteDetails(@Nonnull String governancePolicyId, @Nonnull String name, @Nullable PolicyType policyType) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
    }

    /**
     * Deleted a policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyDeleteDetails(@Nonnull String governancePolicyId, @Nonnull String name) {
        this(governancePolicyId, name, null);
    }

    /**
     * Policy ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getGovernancePolicyId() {
        return governancePolicyId;
    }

    /**
     * Policy name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Policy type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public PolicyType getPolicyType() {
        return policyType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            governancePolicyId,
            name,
            policyType
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
            GovernancePolicyDeleteDetails other = (GovernancePolicyDeleteDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
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
    static class Serializer extends StructSerializer<GovernancePolicyDeleteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyDeleteDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(value.governancePolicyId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.policyType != null) {
                g.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(value.policyType, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GovernancePolicyDeleteDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyDeleteDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
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
                value = new GovernancePolicyDeleteDetails(f_governancePolicyId, f_name, f_policyType);
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
