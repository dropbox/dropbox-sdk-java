/* DO NOT EDIT */
/* This file was generated from team_log.stone */

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
 * File request details
 */
public class FileRequestDetails {
    // struct team_log.FileRequestDetails (team_log.stone)

    protected final long assetIndex;
    @Nullable
    protected final FileRequestDeadline deadline;
    @Nullable
    protected final Boolean hasPassword;

    /**
     * File request details
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param assetIndex  Asset position in the Assets list.
     * @param deadline  File request deadline.
     * @param hasPassword  Flag represents if this file request has password.
     */
    public FileRequestDetails(long assetIndex, @Nullable FileRequestDeadline deadline, @Nullable Boolean hasPassword) {
        this.assetIndex = assetIndex;
        this.deadline = deadline;
        this.hasPassword = hasPassword;
    }

    /**
     * File request details
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param assetIndex  Asset position in the Assets list.
     */
    public FileRequestDetails(long assetIndex) {
        this(assetIndex, null, null);
    }

    /**
     * Asset position in the Assets list.
     *
     * @return value for this field.
     */
    public long getAssetIndex() {
        return assetIndex;
    }

    /**
     * File request deadline.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileRequestDeadline getDeadline() {
        return deadline;
    }

    /**
     * Flag represents if this file request has password.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getHasPassword() {
        return hasPassword;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param assetIndex  Asset position in the Assets list.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder(long assetIndex) {
        return new Builder(assetIndex);
    }

    /**
     * Builder for {@link FileRequestDetails}.
     */
    public static class Builder {
        protected final long assetIndex;

        protected FileRequestDeadline deadline;
        protected Boolean hasPassword;

        protected Builder(long assetIndex) {
            this.assetIndex = assetIndex;
            this.deadline = null;
            this.hasPassword = null;
        }

        /**
         * Set value for optional field.
         *
         * @param deadline  File request deadline.
         *
         * @return this builder
         */
        public Builder withDeadline(FileRequestDeadline deadline) {
            this.deadline = deadline;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasPassword  Flag represents if this file request has
         *     password.
         *
         * @return this builder
         */
        public Builder withHasPassword(Boolean hasPassword) {
            this.hasPassword = hasPassword;
            return this;
        }

        /**
         * Builds an instance of {@link FileRequestDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link FileRequestDetails}
         */
        public FileRequestDetails build() {
            return new FileRequestDetails(assetIndex, deadline, hasPassword);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.assetIndex,
            this.deadline,
            this.hasPassword
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
            FileRequestDetails other = (FileRequestDetails) obj;
            return (this.assetIndex == other.assetIndex)
                && ((this.deadline == other.deadline) || (this.deadline != null && this.deadline.equals(other.deadline)))
                && ((this.hasPassword == other.hasPassword) || (this.hasPassword != null && this.hasPassword.equals(other.hasPassword)))
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
    static class Serializer extends StructSerializer<FileRequestDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequestDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("asset_index");
            StoneSerializers.uInt64().serialize(value.assetIndex, g);
            if (value.deadline != null) {
                g.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(value.deadline, g);
            }
            if (value.hasPassword != null) {
                g.writeFieldName("has_password");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasPassword, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileRequestDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequestDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_assetIndex = null;
                FileRequestDeadline f_deadline = null;
                Boolean f_hasPassword = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("asset_index".equals(field)) {
                        f_assetIndex = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("deadline".equals(field)) {
                        f_deadline = StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("has_password".equals(field)) {
                        f_hasPassword = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_assetIndex == null) {
                    throw new JsonParseException(p, "Required field \"asset_index\" missing.");
                }
                value = new FileRequestDetails(f_assetIndex, f_deadline, f_hasPassword);
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
