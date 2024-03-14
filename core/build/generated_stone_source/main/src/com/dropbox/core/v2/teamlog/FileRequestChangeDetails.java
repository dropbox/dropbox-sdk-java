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
 * Changed file request.
 */
public class FileRequestChangeDetails {
    // struct team_log.FileRequestChangeDetails (team_log_generated.stone)

    protected final String fileRequestId;
    protected final FileRequestDetails previousDetails;
    protected final FileRequestDetails newDetails;

    /**
     * Changed file request.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param newDetails  New file request details. Must not be {@code null}.
     * @param fileRequestId  File request id. Might be missing due to historical
     *     data gap. Must have length of at least 1 and match pattern "{@code
     *     [-_0-9a-zA-Z]+}".
     * @param previousDetails  Previous file request details. Might be missing
     *     due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestChangeDetails(@Nonnull FileRequestDetails newDetails, @Nullable String fileRequestId, @Nullable FileRequestDetails previousDetails) {
        if (fileRequestId != null) {
            if (fileRequestId.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z]+", fileRequestId)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = fileRequestId;
        this.previousDetails = previousDetails;
        if (newDetails == null) {
            throw new IllegalArgumentException("Required value for 'newDetails' is null");
        }
        this.newDetails = newDetails;
    }

    /**
     * Changed file request.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newDetails  New file request details. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestChangeDetails(@Nonnull FileRequestDetails newDetails) {
        this(newDetails, null, null);
    }

    /**
     * New file request details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FileRequestDetails getNewDetails() {
        return newDetails;
    }

    /**
     * File request id. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getFileRequestId() {
        return fileRequestId;
    }

    /**
     * Previous file request details. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileRequestDetails getPreviousDetails() {
        return previousDetails;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param newDetails  New file request details. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(FileRequestDetails newDetails) {
        return new Builder(newDetails);
    }

    /**
     * Builder for {@link FileRequestChangeDetails}.
     */
    public static class Builder {
        protected final FileRequestDetails newDetails;

        protected String fileRequestId;
        protected FileRequestDetails previousDetails;

        protected Builder(FileRequestDetails newDetails) {
            if (newDetails == null) {
                throw new IllegalArgumentException("Required value for 'newDetails' is null");
            }
            this.newDetails = newDetails;
            this.fileRequestId = null;
            this.previousDetails = null;
        }

        /**
         * Set value for optional field.
         *
         * @param fileRequestId  File request id. Might be missing due to
         *     historical data gap. Must have length of at least 1 and match
         *     pattern "{@code [-_0-9a-zA-Z]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFileRequestId(String fileRequestId) {
            if (fileRequestId != null) {
                if (fileRequestId.length() < 1) {
                    throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
                }
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z]+", fileRequestId)) {
                    throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
                }
            }
            this.fileRequestId = fileRequestId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousDetails  Previous file request details. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousDetails(FileRequestDetails previousDetails) {
            this.previousDetails = previousDetails;
            return this;
        }

        /**
         * Builds an instance of {@link FileRequestChangeDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link FileRequestChangeDetails}
         */
        public FileRequestChangeDetails build() {
            return new FileRequestChangeDetails(newDetails, fileRequestId, previousDetails);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileRequestId,
            previousDetails,
            newDetails
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
            FileRequestChangeDetails other = (FileRequestChangeDetails) obj;
            return ((this.newDetails == other.newDetails) || (this.newDetails.equals(other.newDetails)))
                && ((this.fileRequestId == other.fileRequestId) || (this.fileRequestId != null && this.fileRequestId.equals(other.fileRequestId)))
                && ((this.previousDetails == other.previousDetails) || (this.previousDetails != null && this.previousDetails.equals(other.previousDetails)))
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
    static class Serializer extends StructSerializer<FileRequestChangeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequestChangeDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_details");
            FileRequestDetails.Serializer.INSTANCE.serialize(value.newDetails, g);
            if (value.fileRequestId != null) {
                g.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fileRequestId, g);
            }
            if (value.previousDetails != null) {
                g.writeFieldName("previous_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(value.previousDetails, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileRequestChangeDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequestChangeDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FileRequestDetails f_newDetails = null;
                String f_fileRequestId = null;
                FileRequestDetails f_previousDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_details".equals(field)) {
                        f_newDetails = FileRequestDetails.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("file_request_id".equals(field)) {
                        f_fileRequestId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("previous_details".equals(field)) {
                        f_previousDetails = StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newDetails == null) {
                    throw new JsonParseException(p, "Required field \"new_details\" missing.");
                }
                value = new FileRequestChangeDetails(f_newDetails, f_fileRequestId, f_previousDetails);
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
