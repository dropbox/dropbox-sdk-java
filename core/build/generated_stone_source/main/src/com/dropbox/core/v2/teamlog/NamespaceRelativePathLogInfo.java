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
 * Namespace relative path details.
 */
public class NamespaceRelativePathLogInfo {
    // struct team_log.NamespaceRelativePathLogInfo (team_log_generated.stone)

    protected final String nsId;
    protected final String relativePath;
    protected final Boolean isSharedNamespace;

    /**
     * Namespace relative path details.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param nsId  Namespace ID.
     * @param relativePath  A path relative to the specified namespace ID.
     * @param isSharedNamespace  True if the namespace is shared.
     */
    public NamespaceRelativePathLogInfo(@Nullable String nsId, @Nullable String relativePath, @Nullable Boolean isSharedNamespace) {
        this.nsId = nsId;
        this.relativePath = relativePath;
        this.isSharedNamespace = isSharedNamespace;
    }

    /**
     * Namespace relative path details.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public NamespaceRelativePathLogInfo() {
        this(null, null, null);
    }

    /**
     * Namespace ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getNsId() {
        return nsId;
    }

    /**
     * A path relative to the specified namespace ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getRelativePath() {
        return relativePath;
    }

    /**
     * True if the namespace is shared.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsSharedNamespace() {
        return isSharedNamespace;
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
     * Builder for {@link NamespaceRelativePathLogInfo}.
     */
    public static class Builder {

        protected String nsId;
        protected String relativePath;
        protected Boolean isSharedNamespace;

        protected Builder() {
            this.nsId = null;
            this.relativePath = null;
            this.isSharedNamespace = null;
        }

        /**
         * Set value for optional field.
         *
         * @param nsId  Namespace ID.
         *
         * @return this builder
         */
        public Builder withNsId(String nsId) {
            this.nsId = nsId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param relativePath  A path relative to the specified namespace ID.
         *
         * @return this builder
         */
        public Builder withRelativePath(String relativePath) {
            this.relativePath = relativePath;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isSharedNamespace  True if the namespace is shared.
         *
         * @return this builder
         */
        public Builder withIsSharedNamespace(Boolean isSharedNamespace) {
            this.isSharedNamespace = isSharedNamespace;
            return this;
        }

        /**
         * Builds an instance of {@link NamespaceRelativePathLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link NamespaceRelativePathLogInfo}
         */
        public NamespaceRelativePathLogInfo build() {
            return new NamespaceRelativePathLogInfo(nsId, relativePath, isSharedNamespace);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            nsId,
            relativePath,
            isSharedNamespace
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
            NamespaceRelativePathLogInfo other = (NamespaceRelativePathLogInfo) obj;
            return ((this.nsId == other.nsId) || (this.nsId != null && this.nsId.equals(other.nsId)))
                && ((this.relativePath == other.relativePath) || (this.relativePath != null && this.relativePath.equals(other.relativePath)))
                && ((this.isSharedNamespace == other.isSharedNamespace) || (this.isSharedNamespace != null && this.isSharedNamespace.equals(other.isSharedNamespace)))
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
    static class Serializer extends StructSerializer<NamespaceRelativePathLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NamespaceRelativePathLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.nsId != null) {
                g.writeFieldName("ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.nsId, g);
            }
            if (value.relativePath != null) {
                g.writeFieldName("relative_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.relativePath, g);
            }
            if (value.isSharedNamespace != null) {
                g.writeFieldName("is_shared_namespace");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isSharedNamespace, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public NamespaceRelativePathLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            NamespaceRelativePathLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_nsId = null;
                String f_relativePath = null;
                Boolean f_isSharedNamespace = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("ns_id".equals(field)) {
                        f_nsId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("relative_path".equals(field)) {
                        f_relativePath = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_shared_namespace".equals(field)) {
                        f_isSharedNamespace = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new NamespaceRelativePathLogInfo(f_nsId, f_relativePath, f_isSharedNamespace);
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
