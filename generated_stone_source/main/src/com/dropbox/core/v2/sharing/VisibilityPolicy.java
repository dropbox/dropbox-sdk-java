/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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

public class VisibilityPolicy {
    // struct sharing.VisibilityPolicy (shared_links.stone)

    protected final RequestedVisibility policy;
    protected final AlphaResolvedVisibility resolvedPolicy;
    protected final boolean allowed;
    protected final VisibilityPolicyDisallowedReason disallowedReason;

    /**
     *
     * @param policy  This is the value to submit when saving the visibility
     *     setting. Must not be {@code null}.
     * @param resolvedPolicy  This is what the effective policy would be, if you
     *     selected this option. The resolved policy is obtained after
     *     considering external effects such as shared folder settings and team
     *     policy. This value is guaranteed to be provided. Must not be {@code
     *     null}.
     * @param allowed  Whether the user is permitted to set the visibility to
     *     this policy.
     * @param disallowedReason  If {@link VisibilityPolicy#getAllowed} is {@code
     *     false}, this will provide the reason that the user is not permitted
     *     to set the visibility to this policy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public VisibilityPolicy(RequestedVisibility policy, AlphaResolvedVisibility resolvedPolicy, boolean allowed, VisibilityPolicyDisallowedReason disallowedReason) {
        if (policy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = policy;
        if (resolvedPolicy == null) {
            throw new IllegalArgumentException("Required value for 'resolvedPolicy' is null");
        }
        this.resolvedPolicy = resolvedPolicy;
        this.allowed = allowed;
        this.disallowedReason = disallowedReason;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param policy  This is the value to submit when saving the visibility
     *     setting. Must not be {@code null}.
     * @param resolvedPolicy  This is what the effective policy would be, if you
     *     selected this option. The resolved policy is obtained after
     *     considering external effects such as shared folder settings and team
     *     policy. This value is guaranteed to be provided. Must not be {@code
     *     null}.
     * @param allowed  Whether the user is permitted to set the visibility to
     *     this policy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public VisibilityPolicy(RequestedVisibility policy, AlphaResolvedVisibility resolvedPolicy, boolean allowed) {
        this(policy, resolvedPolicy, allowed, null);
    }

    /**
     * This is the value to submit when saving the visibility setting.
     *
     * @return value for this field, never {@code null}.
     */
    public RequestedVisibility getPolicy() {
        return policy;
    }

    /**
     * This is what the effective policy would be, if you selected this option.
     * The resolved policy is obtained after considering external effects such
     * as shared folder settings and team policy. This value is guaranteed to be
     * provided.
     *
     * @return value for this field, never {@code null}.
     */
    public AlphaResolvedVisibility getResolvedPolicy() {
        return resolvedPolicy;
    }

    /**
     * Whether the user is permitted to set the visibility to this policy.
     *
     * @return value for this field.
     */
    public boolean getAllowed() {
        return allowed;
    }

    /**
     * If {@link VisibilityPolicy#getAllowed} is {@code false}, this will
     * provide the reason that the user is not permitted to set the visibility
     * to this policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public VisibilityPolicyDisallowedReason getDisallowedReason() {
        return disallowedReason;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            policy,
            resolvedPolicy,
            allowed,
            disallowedReason
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
            VisibilityPolicy other = (VisibilityPolicy) obj;
            return ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.resolvedPolicy == other.resolvedPolicy) || (this.resolvedPolicy.equals(other.resolvedPolicy)))
                && (this.allowed == other.allowed)
                && ((this.disallowedReason == other.disallowedReason) || (this.disallowedReason != null && this.disallowedReason.equals(other.disallowedReason)))
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
    static class Serializer extends StructSerializer<VisibilityPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(VisibilityPolicy value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("policy");
            RequestedVisibility.Serializer.INSTANCE.serialize(value.policy, g);
            g.writeFieldName("resolved_policy");
            AlphaResolvedVisibility.Serializer.INSTANCE.serialize(value.resolvedPolicy, g);
            g.writeFieldName("allowed");
            StoneSerializers.boolean_().serialize(value.allowed, g);
            if (value.disallowedReason != null) {
                g.writeFieldName("disallowed_reason");
                StoneSerializers.nullable(VisibilityPolicyDisallowedReason.Serializer.INSTANCE).serialize(value.disallowedReason, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public VisibilityPolicy deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            VisibilityPolicy value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                RequestedVisibility f_policy = null;
                AlphaResolvedVisibility f_resolvedPolicy = null;
                Boolean f_allowed = null;
                VisibilityPolicyDisallowedReason f_disallowedReason = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("policy".equals(field)) {
                        f_policy = RequestedVisibility.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("resolved_policy".equals(field)) {
                        f_resolvedPolicy = AlphaResolvedVisibility.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("allowed".equals(field)) {
                        f_allowed = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("disallowed_reason".equals(field)) {
                        f_disallowedReason = StoneSerializers.nullable(VisibilityPolicyDisallowedReason.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_policy == null) {
                    throw new JsonParseException(p, "Required field \"policy\" missing.");
                }
                if (f_resolvedPolicy == null) {
                    throw new JsonParseException(p, "Required field \"resolved_policy\" missing.");
                }
                if (f_allowed == null) {
                    throw new JsonParseException(p, "Required field \"allowed\" missing.");
                }
                value = new VisibilityPolicy(f_policy, f_resolvedPolicy, f_allowed, f_disallowedReason);
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
