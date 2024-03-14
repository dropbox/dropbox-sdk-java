/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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
 * Sharing policy of Paper doc.
 */
public class SharingPolicy {
    // struct paper.SharingPolicy (paper.stone)

    protected final SharingPublicPolicyType publicSharingPolicy;
    protected final SharingTeamPolicyType teamSharingPolicy;

    /**
     * Sharing policy of Paper doc.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param publicSharingPolicy  This value applies to the non-team members.
     * @param teamSharingPolicy  This value applies to the team members only.
     *     The value is null for all personal accounts.
     */
    public SharingPolicy(@javax.annotation.Nullable SharingPublicPolicyType publicSharingPolicy, @javax.annotation.Nullable SharingTeamPolicyType teamSharingPolicy) {
        this.publicSharingPolicy = publicSharingPolicy;
        this.teamSharingPolicy = teamSharingPolicy;
    }

    /**
     * Sharing policy of Paper doc.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharingPolicy() {
        this(null, null);
    }

    /**
     * This value applies to the non-team members.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SharingPublicPolicyType getPublicSharingPolicy() {
        return publicSharingPolicy;
    }

    /**
     * This value applies to the team members only. The value is null for all
     * personal accounts.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SharingTeamPolicyType getTeamSharingPolicy() {
        return teamSharingPolicy;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link SharingPolicy}.
     */
    public static class Builder {

        protected SharingPublicPolicyType publicSharingPolicy;
        protected SharingTeamPolicyType teamSharingPolicy;

        protected Builder() {
            this.publicSharingPolicy = null;
            this.teamSharingPolicy = null;
        }

        /**
         * Set value for optional field.
         *
         * @param publicSharingPolicy  This value applies to the non-team
         *     members.
         *
         * @return this builder
         */
        public Builder withPublicSharingPolicy(SharingPublicPolicyType publicSharingPolicy) {
            this.publicSharingPolicy = publicSharingPolicy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param teamSharingPolicy  This value applies to the team members
         *     only. The value is null for all personal accounts.
         *
         * @return this builder
         */
        public Builder withTeamSharingPolicy(SharingTeamPolicyType teamSharingPolicy) {
            this.teamSharingPolicy = teamSharingPolicy;
            return this;
        }

        /**
         * Builds an instance of {@link SharingPolicy} configured with this
         * builder's values
         *
         * @return new instance of {@link SharingPolicy}
         */
        public SharingPolicy build() {
            return new SharingPolicy(publicSharingPolicy, teamSharingPolicy);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            publicSharingPolicy,
            teamSharingPolicy
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
            SharingPolicy other = (SharingPolicy) obj;
            return ((this.publicSharingPolicy == other.publicSharingPolicy) || (this.publicSharingPolicy != null && this.publicSharingPolicy.equals(other.publicSharingPolicy)))
                && ((this.teamSharingPolicy == other.teamSharingPolicy) || (this.teamSharingPolicy != null && this.teamSharingPolicy.equals(other.teamSharingPolicy)))
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
    static class Serializer extends StructSerializer<SharingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingPolicy value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.publicSharingPolicy != null) {
                g.writeFieldName("public_sharing_policy");
                StoneSerializers.nullable(SharingPublicPolicyType.Serializer.INSTANCE).serialize(value.publicSharingPolicy, g);
            }
            if (value.teamSharingPolicy != null) {
                g.writeFieldName("team_sharing_policy");
                StoneSerializers.nullable(SharingTeamPolicyType.Serializer.INSTANCE).serialize(value.teamSharingPolicy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingPolicy deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingPolicy value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharingPublicPolicyType f_publicSharingPolicy = null;
                SharingTeamPolicyType f_teamSharingPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("public_sharing_policy".equals(field)) {
                        f_publicSharingPolicy = StoneSerializers.nullable(SharingPublicPolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("team_sharing_policy".equals(field)) {
                        f_teamSharingPolicy = StoneSerializers.nullable(SharingTeamPolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharingPolicy(f_publicSharingPolicy, f_teamSharingPolicy);
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
