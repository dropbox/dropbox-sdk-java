/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

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

public class LegalHoldsListPoliciesResult {
    // struct team.LegalHoldsListPoliciesResult (team_legal_holds.stone)

    protected final List<LegalHoldPolicy> policies;

    /**
     *
     * @param policies  Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListPoliciesResult(@javax.annotation.Nonnull List<LegalHoldPolicy> policies) {
        if (policies == null) {
            throw new IllegalArgumentException("Required value for 'policies' is null");
        }
        for (LegalHoldPolicy x : policies) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'policies' is null");
            }
        }
        this.policies = policies;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<LegalHoldPolicy> getPolicies() {
        return policies;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            policies
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
            LegalHoldsListPoliciesResult other = (LegalHoldsListPoliciesResult) obj;
            return (this.policies == other.policies) || (this.policies.equals(other.policies));
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
    static class Serializer extends StructSerializer<LegalHoldsListPoliciesResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsListPoliciesResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("policies");
            StoneSerializers.list(LegalHoldPolicy.Serializer.INSTANCE).serialize(value.policies, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsListPoliciesResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsListPoliciesResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<LegalHoldPolicy> f_policies = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("policies".equals(field)) {
                        f_policies = StoneSerializers.list(LegalHoldPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_policies == null) {
                    throw new JsonParseException(p, "Required field \"policies\" missing.");
                }
                value = new LegalHoldsListPoliciesResult(f_policies);
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
