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
 * Downloaded content from a policy.
 */
public class GovernancePolicyZipPartDownloadedDetails {
    // struct team_log.GovernancePolicyZipPartDownloadedDetails (team_log_generated.stone)

    protected final String governancePolicyId;
    protected final String name;
    protected final PolicyType policyType;
    protected final String exportName;
    protected final String part;

    /**
     * Downloaded content from a policy.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     * @param policyType  Policy type.
     * @param part  Part.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyZipPartDownloadedDetails(String governancePolicyId, String name, String exportName, PolicyType policyType, String part) {
        if (governancePolicyId == null) {
            throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
        }
        this.governancePolicyId = governancePolicyId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.policyType = policyType;
        if (exportName == null) {
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = exportName;
        this.part = part;
    }

    /**
     * Downloaded content from a policy.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GovernancePolicyZipPartDownloadedDetails(String governancePolicyId, String name, String exportName) {
        this(governancePolicyId, name, exportName, null, null);
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
     * Export name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getExportName() {
        return exportName;
    }

    /**
     * Policy type.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public PolicyType getPolicyType() {
        return policyType;
    }

    /**
     * Part.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPart() {
        return part;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param governancePolicyId  Policy ID. Must not be {@code null}.
     * @param name  Policy name. Must not be {@code null}.
     * @param exportName  Export name. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String governancePolicyId, String name, String exportName) {
        return new Builder(governancePolicyId, name, exportName);
    }

    /**
     * Builder for {@link GovernancePolicyZipPartDownloadedDetails}.
     */
    public static class Builder {
        protected final String governancePolicyId;
        protected final String name;
        protected final String exportName;

        protected PolicyType policyType;
        protected String part;

        protected Builder(String governancePolicyId, String name, String exportName) {
            if (governancePolicyId == null) {
                throw new IllegalArgumentException("Required value for 'governancePolicyId' is null");
            }
            this.governancePolicyId = governancePolicyId;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (exportName == null) {
                throw new IllegalArgumentException("Required value for 'exportName' is null");
            }
            this.exportName = exportName;
            this.policyType = null;
            this.part = null;
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
         * @param part  Part.
         *
         * @return this builder
         */
        public Builder withPart(String part) {
            this.part = part;
            return this;
        }

        /**
         * Builds an instance of {@link
         * GovernancePolicyZipPartDownloadedDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link
         *     GovernancePolicyZipPartDownloadedDetails}
         */
        public GovernancePolicyZipPartDownloadedDetails build() {
            return new GovernancePolicyZipPartDownloadedDetails(governancePolicyId, name, exportName, policyType, part);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            governancePolicyId,
            name,
            policyType,
            exportName,
            part
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
            GovernancePolicyZipPartDownloadedDetails other = (GovernancePolicyZipPartDownloadedDetails) obj;
            return ((this.governancePolicyId == other.governancePolicyId) || (this.governancePolicyId.equals(other.governancePolicyId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.exportName == other.exportName) || (this.exportName.equals(other.exportName)))
                && ((this.policyType == other.policyType) || (this.policyType != null && this.policyType.equals(other.policyType)))
                && ((this.part == other.part) || (this.part != null && this.part.equals(other.part)))
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
    static class Serializer extends StructSerializer<GovernancePolicyZipPartDownloadedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GovernancePolicyZipPartDownloadedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("governance_policy_id");
            StoneSerializers.string().serialize(value.governancePolicyId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("export_name");
            StoneSerializers.string().serialize(value.exportName, g);
            if (value.policyType != null) {
                g.writeFieldName("policy_type");
                StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).serialize(value.policyType, g);
            }
            if (value.part != null) {
                g.writeFieldName("part");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.part, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GovernancePolicyZipPartDownloadedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GovernancePolicyZipPartDownloadedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_governancePolicyId = null;
                String f_name = null;
                String f_exportName = null;
                PolicyType f_policyType = null;
                String f_part = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("governance_policy_id".equals(field)) {
                        f_governancePolicyId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_name".equals(field)) {
                        f_exportName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("policy_type".equals(field)) {
                        f_policyType = StoneSerializers.nullable(PolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("part".equals(field)) {
                        f_part = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                if (f_exportName == null) {
                    throw new JsonParseException(p, "Required field \"export_name\" missing.");
                }
                value = new GovernancePolicyZipPartDownloadedDetails(f_governancePolicyId, f_name, f_exportName, f_policyType, f_part);
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
