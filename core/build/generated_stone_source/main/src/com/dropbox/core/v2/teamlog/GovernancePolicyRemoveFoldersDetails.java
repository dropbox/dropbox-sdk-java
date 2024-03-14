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
import java.util.List;

/**
 * Removed folders from policy.
 */
public class GovernancePolicyRemoveFoldersDetails {
    // struct team_log.GovernancePolicyRemoveFoldersDetails (team_log_generated.stone)

    protected final String governancePolicyId;
    protected final String name;
    protected final PolicyType policyType;
    protected final List<String> folders;
    protected final String reason;

    /**
     * Removed folders from policy.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param policyType  Policy type.
     * @param folders  Folders. Must not contain a {@code null} item.
     * @param reason  Reason.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyRemoveFoldersDetails(@javax.annotation.Nonnull String governancePolicyId, @javax.annotation.Nonnull String name, @javax.annotation.Nullable PolicyType policyType, @javax.annotation.Nullable List<String> folders, @javax.annotation.Nullable String reason) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
        if (folders != null) {
            for (String x : folders) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'folders' is null");
                }
            }
        }
        this.folders = folders;
        this.reason = reason;
    }

    /**
     * Removed folders from policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyRemoveFoldersDetails(String governancePolicyId, String name) {
        this(governancePolicyId, name, null, null, null);
    }

    /**
     * Policy ID.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getGovernancePolicyId() {
        return governancePolicyId;
    }

    /**
     * Policy name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * Policy type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public PolicyType getPolicyType() {
        return policyType;
    }

    /**
     * Folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<String> getFolders() {
        return folders;
    }

    /**
     * Reason.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getReason() {
        return reason;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String governancePolicyId, String name) {
        return new Builder(governancePolicyId, name);
    }

    /**
     * Builder for {@link GovernancePolicyRemoveFoldersDetails}.
     */
    public static class Builder {
        protected final String governancePolicyId;
        protected final String name;

        protected PolicyType policyType;
        protected List<String> folders;
        protected String reason;

        protected Builder(String governancePolicyId, String name) {
            if (governancePolicyId == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = governancePolicyId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            this.policyType = null;
            this.folders = null;
            this.reason = null;
        }

        /**
         * Set value for optional field.
         *
         * @param policyType  Policy type.
         *
         * @return this builder
         */
        public Builder withPolicyType(PolicyType policyType) {
            this.policyType = policyType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param folders  Folders. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFolders(List<String> folders) {
            if (folders != null) {
                for (String x : folders) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'folders' is null");
                    }
                }
            }
            this.folders = folders;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param reason  Reason.
         *
         * @return this builder
         */
        public Builder withReason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds an instance of {@link GovernancePolicyRemoveFoldersDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link GovernancePolicyRemoveFoldersDetails}
         */
        public GovernancePolicyRemoveFoldersDetails build() {
            return new GovernancePolicyRemoveFoldersDetails(governancePolicyId, name, policyType, folders, reason);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            governancePolicyId,
            name,
            policyType,
            folders,
            reason
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
            GovernancePolicyRemoveFoldersDetails other = (GovernancePolicyRemoveFoldersDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.policyType == other.policyType) || (this.policyType != null && this.policyType.equals(other.policyType)))
                && ((this.folders == other.folders) || (this.folders != null && this.folders.equals(other.folders)))
                && ((this.reason == other.reason) || (this.reason != null && this.reason.equals(other.reason)))
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
    static class Serializer extends StructSerializer<GovernancePolicyRemoveFoldersDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyRemoveFoldersDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (value.folders != null) {
                g.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.folders, g);
            }
            if (value.reason != null) {
                g.writeFieldName("reason");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.reason, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GovernancePolicyRemoveFoldersDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyRemoveFoldersDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
                PolicyType f_policyType = null;
                List<String> f_folders = null;
                String f_reason = null;
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
                    else if ("folders".equals(field)) {
                        f_folders = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else if ("reason".equals(field)) {
                        f_reason = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new GovernancePolicyRemoveFoldersDetails(f_governancePolicyId, f_name, f_policyType, f_folders, f_reason);
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
