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
 * Updated group join policy.
 */
public class GroupJoinPolicyUpdatedDetails {
    // struct team_log.GroupJoinPolicyUpdatedDetails (team_log_generated.stone)

    @Nullable
    protected final Boolean isCompanyManaged;
    @Nullable
    protected final GroupJoinPolicy joinPolicy;

    /**
     * Updated group join policy.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param isCompanyManaged  Is company managed group.
     * @param joinPolicy  Group join policy.
     */
    public GroupJoinPolicyUpdatedDetails(@Nullable Boolean isCompanyManaged, @Nullable GroupJoinPolicy joinPolicy) {
        this.isCompanyManaged = isCompanyManaged;
        this.joinPolicy = joinPolicy;
    }

    /**
     * Updated group join policy.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public GroupJoinPolicyUpdatedDetails() {
        this(null, null);
    }

    /**
     * Is company managed group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsCompanyManaged() {
        return isCompanyManaged;
    }

    /**
     * Group join policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public GroupJoinPolicy getJoinPolicy() {
        return joinPolicy;
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
     * Builder for {@link GroupJoinPolicyUpdatedDetails}.
     */
    public static class Builder {

        protected Boolean isCompanyManaged;
        protected GroupJoinPolicy joinPolicy;

        protected Builder() {
            this.isCompanyManaged = null;
            this.joinPolicy = null;
        }

        /**
         * Set value for optional field.
         *
         * @param isCompanyManaged  Is company managed group.
         *
         * @return this builder
         */
        public Builder withIsCompanyManaged(Boolean isCompanyManaged) {
            this.isCompanyManaged = isCompanyManaged;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param joinPolicy  Group join policy.
         *
         * @return this builder
         */
        public Builder withJoinPolicy(GroupJoinPolicy joinPolicy) {
            this.joinPolicy = joinPolicy;
            return this;
        }

        /**
         * Builds an instance of {@link GroupJoinPolicyUpdatedDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link GroupJoinPolicyUpdatedDetails}
         */
        public GroupJoinPolicyUpdatedDetails build() {
            return new GroupJoinPolicyUpdatedDetails(isCompanyManaged, joinPolicy);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.isCompanyManaged,
            this.joinPolicy
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
            GroupJoinPolicyUpdatedDetails other = (GroupJoinPolicyUpdatedDetails) obj;
            return ((this.isCompanyManaged == other.isCompanyManaged) || (this.isCompanyManaged != null && this.isCompanyManaged.equals(other.isCompanyManaged)))
                && ((this.joinPolicy == other.joinPolicy) || (this.joinPolicy != null && this.joinPolicy.equals(other.joinPolicy)))
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
    static class Serializer extends StructSerializer<GroupJoinPolicyUpdatedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupJoinPolicyUpdatedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.isCompanyManaged != null) {
                g.writeFieldName("is_company_managed");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isCompanyManaged, g);
            }
            if (value.joinPolicy != null) {
                g.writeFieldName("join_policy");
                StoneSerializers.nullable(GroupJoinPolicy.Serializer.INSTANCE).serialize(value.joinPolicy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupJoinPolicyUpdatedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupJoinPolicyUpdatedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isCompanyManaged = null;
                GroupJoinPolicy f_joinPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_company_managed".equals(field)) {
                        f_isCompanyManaged = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("join_policy".equals(field)) {
                        f_joinPolicy = StoneSerializers.nullable(GroupJoinPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new GroupJoinPolicyUpdatedDetails(f_isCompanyManaged, f_joinPolicy);
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
