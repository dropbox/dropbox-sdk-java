/* DO NOT EDIT */
/* This file was generated from team.stone */

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Properties of a namespace.
 */
public class NamespaceMetadata {
    // struct team.NamespaceMetadata (team.stone)

    @Nonnull
    protected final String name;
    @Nonnull
    protected final String namespaceId;
    @Nonnull
    protected final NamespaceType namespaceType;
    @Nullable
    protected final String teamMemberId;
    protected final long quotaLimit;

    /**
     * Properties of a namespace.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param name  The name of this namespace. Must not be {@code null}.
     * @param namespaceId  The ID of this namespace. Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param namespaceType  The type of this namespace. Must not be {@code
     *     null}.
     * @param teamMemberId  If this is a team member or app folder, the ID of
     *     the owning team member. Otherwise, this field is not present.
     * @param quotaLimit  The quota limit in bytes for this namespace tree. Only
     *     applicable to team folders.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NamespaceMetadata(@Nonnull String name, @Nonnull String namespaceId, @Nonnull NamespaceType namespaceType, @Nullable String teamMemberId, long quotaLimit) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (namespaceId == null) {
            throw new IllegalArgumentException("Required value for 'namespaceId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", namespaceId)) {
            throw new IllegalArgumentException("String 'namespaceId' does not match pattern");
        }
        this.namespaceId = namespaceId;
        if (namespaceType == null) {
            throw new IllegalArgumentException("Required value for 'namespaceType' is null");
        }
        this.namespaceType = namespaceType;
        this.teamMemberId = teamMemberId;
        this.quotaLimit = quotaLimit;
    }

    /**
     * Properties of a namespace.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The name of this namespace. Must not be {@code null}.
     * @param namespaceId  The ID of this namespace. Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param namespaceType  The type of this namespace. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NamespaceMetadata(@Nonnull String name, @Nonnull String namespaceId, @Nonnull NamespaceType namespaceType) {
        this(name, namespaceId, namespaceType, null, 0L);
    }

    /**
     * The name of this namespace.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The ID of this namespace.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNamespaceId() {
        return namespaceId;
    }

    /**
     * The type of this namespace.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public NamespaceType getNamespaceType() {
        return namespaceType;
    }

    /**
     * If this is a team member or app folder, the ID of the owning team member.
     * Otherwise, this field is not present.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * The quota limit in bytes for this namespace tree. Only applicable to team
     * folders.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     0L.
     */
    public long getQuotaLimit() {
        return quotaLimit;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The name of this namespace. Must not be {@code null}.
     * @param namespaceId  The ID of this namespace. Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param namespaceType  The type of this namespace. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String namespaceId, NamespaceType namespaceType) {
        return new Builder(name, namespaceId, namespaceType);
    }

    /**
     * Builder for {@link NamespaceMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String namespaceId;
        protected final NamespaceType namespaceType;

        protected String teamMemberId;
        protected long quotaLimit;

        protected Builder(String name, String namespaceId, NamespaceType namespaceType) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (namespaceId == null) {
                throw new IllegalArgumentException("Required value for 'namespaceId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", namespaceId)) {
                throw new IllegalArgumentException("String 'namespaceId' does not match pattern");
            }
            this.namespaceId = namespaceId;
            if (namespaceType == null) {
                throw new IllegalArgumentException("Required value for 'namespaceType' is null");
            }
            this.namespaceType = namespaceType;
            this.teamMemberId = null;
            this.quotaLimit = 0L;
        }

        /**
         * Set value for optional field.
         *
         * @param teamMemberId  If this is a team member or app folder, the ID
         *     of the owning team member. Otherwise, this field is not present.
         *
         * @return this builder
         */
        public Builder withTeamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 0L}.
         * </p>
         *
         * @param quotaLimit  The quota limit in bytes for this namespace tree.
         *     Only applicable to team folders. Defaults to {@code 0L} when set
         *     to {@code null}.
         *
         * @return this builder
         */
        public Builder withQuotaLimit(Long quotaLimit) {
            if (quotaLimit != null) {
                this.quotaLimit = quotaLimit;
            }
            else {
                this.quotaLimit = 0L;
            }
            return this;
        }

        /**
         * Builds an instance of {@link NamespaceMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link NamespaceMetadata}
         */
        public NamespaceMetadata build() {
            return new NamespaceMetadata(name, namespaceId, namespaceType, teamMemberId, quotaLimit);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.namespaceId,
            this.namespaceType,
            this.teamMemberId,
            this.quotaLimit
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
            NamespaceMetadata other = (NamespaceMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.namespaceId == other.namespaceId) || (this.namespaceId.equals(other.namespaceId)))
                && ((this.namespaceType == other.namespaceType) || (this.namespaceType.equals(other.namespaceType)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId != null && this.teamMemberId.equals(other.teamMemberId)))
                && (this.quotaLimit == other.quotaLimit)
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
    static class Serializer extends StructSerializer<NamespaceMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NamespaceMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("namespace_id");
            StoneSerializers.string().serialize(value.namespaceId, g);
            g.writeFieldName("namespace_type");
            NamespaceType.Serializer.INSTANCE.serialize(value.namespaceType, g);
            if (value.teamMemberId != null) {
                g.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamMemberId, g);
            }
            g.writeFieldName("quota_limit");
            StoneSerializers.int64().serialize(value.quotaLimit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public NamespaceMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            NamespaceMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_namespaceId = null;
                NamespaceType f_namespaceType = null;
                String f_teamMemberId = null;
                Long f_quotaLimit = 0L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("namespace_id".equals(field)) {
                        f_namespaceId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("namespace_type".equals(field)) {
                        f_namespaceType = NamespaceType.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("quota_limit".equals(field)) {
                        f_quotaLimit = StoneSerializers.int64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_namespaceId == null) {
                    throw new JsonParseException(p, "Required field \"namespace_id\" missing.");
                }
                if (f_namespaceType == null) {
                    throw new JsonParseException(p, "Required field \"namespace_type\" missing.");
                }
                value = new NamespaceMetadata(f_name, f_namespaceId, f_namespaceType, f_teamMemberId, f_quotaLimit);
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
