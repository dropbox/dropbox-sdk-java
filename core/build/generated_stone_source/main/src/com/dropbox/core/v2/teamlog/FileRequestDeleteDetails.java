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
 * Delete file request.
 */
public class FileRequestDeleteDetails {
    // struct team_log.FileRequestDeleteDetails (team_log_generated.stone)

    protected final String fileRequestId;
    protected final FileRequestDetails previousDetails;

    /**
     * Delete file request.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param fileRequestId  File request id. Might be missing due to historical
     *     data gap. Must have length of at least 1 and match pattern "{@code
     *     [-_0-9a-zA-Z]+}".
     * @param previousDetails  Previous file request details. Might be missing
     *     due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestDeleteDetails(@javax.annotation.Nullable String fileRequestId, @javax.annotation.Nullable FileRequestDetails previousDetails) {
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
    }

    /**
     * Delete file request.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FileRequestDeleteDetails() {
        this(null, null);
    }

    /**
     * File request id. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getFileRequestId() {
        return fileRequestId;
    }

    /**
     * Previous file request details. Might be missing due to historical data
     * gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public FileRequestDetails getPreviousDetails() {
        return previousDetails;
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
     * Builder for {@link FileRequestDeleteDetails}.
     */
    public static class Builder {

        protected String fileRequestId;
        protected FileRequestDetails previousDetails;

        protected Builder() {
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
         * Builds an instance of {@link FileRequestDeleteDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link FileRequestDeleteDetails}
         */
        public FileRequestDeleteDetails build() {
            return new FileRequestDeleteDetails(fileRequestId, previousDetails);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            fileRequestId,
            previousDetails
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
            FileRequestDeleteDetails other = (FileRequestDeleteDetails) obj;
            return ((this.fileRequestId == other.fileRequestId) || (this.fileRequestId != null && this.fileRequestId.equals(other.fileRequestId)))
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
    static class Serializer extends StructSerializer<FileRequestDeleteDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequestDeleteDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
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
        public FileRequestDeleteDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequestDeleteDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_fileRequestId = null;
                FileRequestDetails f_previousDetails = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file_request_id".equals(field)) {
                        f_fileRequestId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("previous_details".equals(field)) {
                        f_previousDetails = StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FileRequestDeleteDetails(f_fileRequestId, f_previousDetails);
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
