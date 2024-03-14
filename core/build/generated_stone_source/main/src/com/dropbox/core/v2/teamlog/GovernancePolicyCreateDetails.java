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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Activated a new policy.
 */
public class GovernancePolicyCreateDetails {
    // struct team_log.GovernancePolicyCreateDetails (team_log_generated.stone)

    protected final String governancePolicyId;
    protected final String name;
    protected final PolicyType policyType;
    protected final DurationLogInfo duration;
    protected final List<String> folders;

    /**
     * Activated a new policy.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param duration  Duration in days. Must not be {@code null}.
     * @param policyType  Policy type.
     * @param folders  Folders. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyCreateDetails(@Nonnull String governancePolicyId, @Nonnull String name, @Nonnull DurationLogInfo duration, @Nullable PolicyType policyType, @Nullable List<String> folders) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
        if (duration == null) {
            throw new IllegalArgumentException("Required value for 'duration' is null");
        }
        this.duration = duration;
        if (folders != null) {
            for (String x : folders) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'folders' is null");
                }
            }
        }
        this.folders = folders;
    }

    /**
     * Activated a new policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param duration  Duration in days. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyCreateDetails(String governancePolicyId, String name, DurationLogInfo duration) {
        this(governancePolicyId, name, duration, null, null);
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
     * Duration in days.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public DurationLogInfo getDuration() {
        return duration;
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
     * Folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getFolders() {
        return folders;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param duration  Duration in days. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String governancePolicyId, String name, DurationLogInfo duration) {
        return new Builder(governancePolicyId, name, duration);
    }

    /**
     * Builder for {@link GovernancePolicyCreateDetails}.
     */
    public static class Builder {
        protected final String governancePolicyId;
        protected final String name;
        protected final DurationLogInfo duration;

        protected PolicyType policyType;
        protected List<String> folders;

        protected Builder(String governancePolicyId, String name, DurationLogInfo duration) {
            if (governancePolicyId == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = governancePolicyId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (duration == null) {
                throw new IllegalArgumentException("Required value for 'duration' is null");
            }
            this.duration = duration;
            this.policyType = null;
            this.folders = null;
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
         * Builds an instance of {@link GovernancePolicyCreateDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link GovernancePolicyCreateDetails}
         */
        public GovernancePolicyCreateDetails build() {
            return new GovernancePolicyCreateDetails(governancePolicyId, name, duration, policyType, folders);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            governancePolicyId,
            name,
            policyType,
            duration,
            folders
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
            GovernancePolicyCreateDetails other = (GovernancePolicyCreateDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.duration == other.duration) || (this.duration.equals(other.duration)))
                && ((this.policyType == other.policyType) || (this.policyType != null && this.policyType.equals(other.policyType)))
                && ((this.folders == other.folders) || (this.folders != null && this.folders.equals(other.folders)))
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
    static class Serializer extends StructSerializer<GovernancePolicyCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyCreateDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(value.governancePolicyId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("duration");
            DurationLogInfo.Serializer.INSTANCE.serialize(value.duration, g);
            if (value.policyType != null) {
                g.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(value.policyType, g);
            }
            if (value.folders != null) {
                g.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.folders, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GovernancePolicyCreateDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyCreateDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
                DurationLogInfo f_duration = null;
                PolicyType f_policyType = null;
                List<String> f_folders = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("governance_policy_id".equals(field)) {
                        f_governancePolicyId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("duration".equals(field)) {
                        f_duration = DurationLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("policy_type".equals(field)) {
                        f_policyType = StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("folders".equals(field)) {
                        f_folders = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
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
                if (f_duration == null) {
                    throw new JsonParseException(p, "Required field \"duration\" missing.");
                }
                value = new GovernancePolicyCreateDetails(f_governancePolicyId, f_name, f_duration, f_policyType, f_folders);
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
