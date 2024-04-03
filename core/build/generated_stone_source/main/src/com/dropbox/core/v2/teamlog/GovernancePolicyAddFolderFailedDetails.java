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
 * Couldn't add a folder to a policy.
 */
public class GovernancePolicyAddFolderFailedDetails {
    // struct team_log.GovernancePolicyAddFolderFailedDetails (team_log_generated.stone)

    @Nonnull
    protected final String governancePolicyId;
    @Nonnull
    protected final String name;
    @Nullable
    protected final PolicyType policyType;
    @Nonnull
    protected final String folder;
    @Nullable
    protected final String reason;

    /**
     * Couldn't add a folder to a policy.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param folder  Folder. Must not be {@code null}.
     * @param policyType  Policy type.
     * @param reason  Reason.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyAddFolderFailedDetails(@Nonnull String governancePolicyId, @Nonnull String name, @Nonnull String folder, @Nullable PolicyType policyType, @Nullable String reason) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
        if (folder == null) {
            throw new IllegalArgumentException("Required value for 'folder' is null");
        }
        this.folder = folder;
        this.reason = reason;
    }

    /**
     * Couldn't add a folder to a policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param folder  Folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyAddFolderFailedDetails(@Nonnull String governancePolicyId, @Nonnull String name, @Nonnull String folder) {
        this(governancePolicyId, name, folder, null, null);
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
     * Folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFolder() {
        return folder;
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

    /**
     * Reason.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getReason() {
        return reason;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param folder  Folder. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String governancePolicyId, String name, String folder) {
        return new Builder(governancePolicyId, name, folder);
    }

    /**
     * Builder for {@link GovernancePolicyAddFolderFailedDetails}.
     */
    public static class Builder {
        protected final String governancePolicyId;
        protected final String name;
        protected final String folder;

        protected PolicyType policyType;
        protected String reason;

        protected Builder(String governancePolicyId, String name, String folder) {
            if (governancePolicyId == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = governancePolicyId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (folder == null) {
                throw new IllegalArgumentException("Required value for 'folder' is null");
            }
            this.folder = folder;
            this.policyType = null;
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
         * @param reason  Reason.
         *
         * @return this builder
         */
        public Builder withReason(String reason) {
            this.reason = reason;
            return this;
        }

        /**
         * Builds an instance of {@link GovernancePolicyAddFolderFailedDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link
         *     GovernancePolicyAddFolderFailedDetails}
         */
        public GovernancePolicyAddFolderFailedDetails build() {
            return new GovernancePolicyAddFolderFailedDetails(governancePolicyId, name, folder, policyType, reason);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.governancePolicyId,
            this.name,
            this.policyType,
            this.folder,
            this.reason
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
            GovernancePolicyAddFolderFailedDetails other = (GovernancePolicyAddFolderFailedDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.folder == other.folder) || (this.folder.equals(other.folder)))
                && ((this.policyType == other.policyType) || (this.policyType != null && this.policyType.equals(other.policyType)))
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
    static class Serializer extends StructSerializer<GovernancePolicyAddFolderFailedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyAddFolderFailedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(value.governancePolicyId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("folder");
            StoneSerializers.string().serialize(value.folder, g);
            if (value.policyType != null) {
                g.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(value.policyType, g);
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
        public GovernancePolicyAddFolderFailedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyAddFolderFailedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
                String f_folder = null;
                PolicyType f_policyType = null;
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
                    else if ("folder".equals(field)) {
                        f_folder = StoneSerializers.string().deserialize(p);
                    }
                    else if ("policy_type".equals(field)) {
                        f_policyType = StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(p);
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
                if (f_folder == null) {
                    throw new JsonParseException(p, "Required field \"folder\" missing.");
                }
                value = new GovernancePolicyAddFolderFailedDetails(f_governancePolicyId, f_name, f_folder, f_policyType, f_reason);
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
