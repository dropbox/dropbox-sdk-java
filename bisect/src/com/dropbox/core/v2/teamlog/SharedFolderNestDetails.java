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
 * Changed parent of shared folder.
 */
public class SharedFolderNestDetails {
    // struct team_log.SharedFolderNestDetails (team_log_generated.stone)

    protected final String previousParentNsId;
    protected final String newParentNsId;
    protected final String previousNsPath;
    protected final String newNsPath;

    /**
     * Changed parent of shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param previousParentNsId  Previous parent namespace ID. Might be missing
     *     due to historical data gap.
     * @param newParentNsId  New parent namespace ID. Might be missing due to
     *     historical data gap.
     * @param previousNsPath  Previous namespace path. Might be missing due to
     *     historical data gap.
     * @param newNsPath  New namespace path. Might be missing due to historical
     *     data gap.
     */
    public SharedFolderNestDetails(String previousParentNsId, String newParentNsId, String previousNsPath, String newNsPath) {
        this.previousParentNsId = previousParentNsId;
        this.newParentNsId = newParentNsId;
        this.previousNsPath = previousNsPath;
        this.newNsPath = newNsPath;
    }

    /**
     * Changed parent of shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedFolderNestDetails() {
        this(null, null, null, null);
    }

    /**
     * Previous parent namespace ID. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPreviousParentNsId() {
        return previousParentNsId;
    }

    /**
     * New parent namespace ID. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewParentNsId() {
        return newParentNsId;
    }

    /**
     * Previous namespace path. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPreviousNsPath() {
        return previousNsPath;
    }

    /**
     * New namespace path. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewNsPath() {
        return newNsPath;
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
     * Builder for {@link SharedFolderNestDetails}.
     */
    public static class Builder {

        protected String previousParentNsId;
        protected String newParentNsId;
        protected String previousNsPath;
        protected String newNsPath;

        protected Builder() {
            this.previousParentNsId = null;
            this.newParentNsId = null;
            this.previousNsPath = null;
            this.newNsPath = null;
        }

        /**
         * Set value for optional field.
         *
         * @param previousParentNsId  Previous parent namespace ID. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousParentNsId(String previousParentNsId) {
            this.previousParentNsId = previousParentNsId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newParentNsId  New parent namespace ID. Might be missing due
         *     to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewParentNsId(String newParentNsId) {
            this.newParentNsId = newParentNsId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousNsPath  Previous namespace path. Might be missing due
         *     to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousNsPath(String previousNsPath) {
            this.previousNsPath = previousNsPath;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newNsPath  New namespace path. Might be missing due to
         *     historical data gap.
         *
         * @return this builder
         */
        public Builder withNewNsPath(String newNsPath) {
            this.newNsPath = newNsPath;
            return this;
        }

        /**
         * Builds an instance of {@link SharedFolderNestDetails} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedFolderNestDetails}
         */
        public SharedFolderNestDetails build() {
            return new SharedFolderNestDetails(previousParentNsId, newParentNsId, previousNsPath, newNsPath);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousParentNsId,
            newParentNsId,
            previousNsPath,
            newNsPath
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
            SharedFolderNestDetails other = (SharedFolderNestDetails) obj;
            return ((this.previousParentNsId == other.previousParentNsId) || (this.previousParentNsId != null && this.previousParentNsId.equals(other.previousParentNsId)))
                && ((this.newParentNsId == other.newParentNsId) || (this.newParentNsId != null && this.newParentNsId.equals(other.newParentNsId)))
                && ((this.previousNsPath == other.previousNsPath) || (this.previousNsPath != null && this.previousNsPath.equals(other.previousNsPath)))
                && ((this.newNsPath == other.newNsPath) || (this.newNsPath != null && this.newNsPath.equals(other.newNsPath)))
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
    static class Serializer extends StructSerializer<SharedFolderNestDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderNestDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.previousParentNsId != null) {
                g.writeFieldName("previous_parent_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousParentNsId, g);
            }
            if (value.newParentNsId != null) {
                g.writeFieldName("new_parent_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newParentNsId, g);
            }
            if (value.previousNsPath != null) {
                g.writeFieldName("previous_ns_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previousNsPath, g);
            }
            if (value.newNsPath != null) {
                g.writeFieldName("new_ns_path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.newNsPath, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderNestDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderNestDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_previousParentNsId = null;
                String f_newParentNsId = null;
                String f_previousNsPath = null;
                String f_newNsPath = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_parent_ns_id".equals(field)) {
                        f_previousParentNsId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_parent_ns_id".equals(field)) {
                        f_newParentNsId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("previous_ns_path".equals(field)) {
                        f_previousNsPath = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_ns_path".equals(field)) {
                        f_newNsPath = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedFolderNestDetails(f_previousParentNsId, f_newParentNsId, f_previousNsPath, f_newNsPath);
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
