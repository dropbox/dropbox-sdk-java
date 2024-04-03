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
 * Received files for file request.
 */
public class FileRequestReceiveFileDetails {
    // struct team_log.FileRequestReceiveFileDetails (team_log_generated.stone)

    @Nullable
    protected final String fileRequestId;
    @Nullable
    protected final FileRequestDetails fileRequestDetails;
    @Nonnull
    protected final List<String> submittedFileNames;
    @Nullable
    protected final String submitterName;
    @Nullable
    protected final String submitterEmail;

    /**
     * Received files for file request.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param submittedFileNames  Submitted file names. Must not contain a
     *     {@code null} item and not be {@code null}.
     * @param fileRequestId  File request id. Might be missing due to historical
     *     data gap. Must have length of at least 1 and match pattern "{@code
     *     [-_0-9a-zA-Z]+}".
     * @param fileRequestDetails  File request details. Might be missing due to
     *     historical data gap.
     * @param submitterName  The name as provided by the submitter.
     * @param submitterEmail  The email as provided by the submitter. Must have
     *     length of at most 255.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestReceiveFileDetails(@Nonnull List<String> submittedFileNames, @Nullable String fileRequestId, @Nullable FileRequestDetails fileRequestDetails, @Nullable String submitterName, @Nullable String submitterEmail) {
        if (fileRequestId != null) {
            if (fileRequestId.length() < 1) {
                throw new IllegalArgumentException("String 'fileRequestId' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z]+", fileRequestId)) {
                throw new IllegalArgumentException("String 'fileRequestId' does not match pattern");
            }
        }
        this.fileRequestId = fileRequestId;
        this.fileRequestDetails = fileRequestDetails;
        if (submittedFileNames == null) {
            throw new IllegalArgumentException("Required value for 'submittedFileNames' is null");
        }
        for (String x : submittedFileNames) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'submittedFileNames' is null");
            }
        }
        this.submittedFileNames = submittedFileNames;
        this.submitterName = submitterName;
        if (submitterEmail != null) {
            if (submitterEmail.length() > 255) {
                throw new IllegalArgumentException("String 'submitterEmail' is longer than 255");
            }
        }
        this.submitterEmail = submitterEmail;
    }

    /**
     * Received files for file request.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param submittedFileNames  Submitted file names. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequestReceiveFileDetails(@Nonnull List<String> submittedFileNames) {
        this(submittedFileNames, null, null, null, null);
    }

    /**
     * Submitted file names.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getSubmittedFileNames() {
        return submittedFileNames;
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
     * File request details. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileRequestDetails getFileRequestDetails() {
        return fileRequestDetails;
    }

    /**
     * The name as provided by the submitter.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSubmitterName() {
        return submitterName;
    }

    /**
     * The email as provided by the submitter.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSubmitterEmail() {
        return submitterEmail;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param submittedFileNames  Submitted file names. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<String> submittedFileNames) {
        return new Builder(submittedFileNames);
    }

    /**
     * Builder for {@link FileRequestReceiveFileDetails}.
     */
    public static class Builder {
        protected final List<String> submittedFileNames;

        protected String fileRequestId;
        protected FileRequestDetails fileRequestDetails;
        protected String submitterName;
        protected String submitterEmail;

        protected Builder(List<String> submittedFileNames) {
            if (submittedFileNames == null) {
                throw new IllegalArgumentException("Required value for 'submittedFileNames' is null");
            }
            for (String x : submittedFileNames) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'submittedFileNames' is null");
                }
            }
            this.submittedFileNames = submittedFileNames;
            this.fileRequestId = null;
            this.fileRequestDetails = null;
            this.submitterName = null;
            this.submitterEmail = null;
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
         * @param fileRequestDetails  File request details. Might be missing due
         *     to historical data gap.
         *
         * @return this builder
         */
        public Builder withFileRequestDetails(FileRequestDetails fileRequestDetails) {
            this.fileRequestDetails = fileRequestDetails;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param submitterName  The name as provided by the submitter.
         *
         * @return this builder
         */
        public Builder withSubmitterName(String submitterName) {
            this.submitterName = submitterName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param submitterEmail  The email as provided by the submitter. Must
         *     have length of at most 255.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSubmitterEmail(String submitterEmail) {
            if (submitterEmail != null) {
                if (submitterEmail.length() > 255) {
                    throw new IllegalArgumentException("String 'submitterEmail' is longer than 255");
                }
            }
            this.submitterEmail = submitterEmail;
            return this;
        }

        /**
         * Builds an instance of {@link FileRequestReceiveFileDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link FileRequestReceiveFileDetails}
         */
        public FileRequestReceiveFileDetails build() {
            return new FileRequestReceiveFileDetails(submittedFileNames, fileRequestId, fileRequestDetails, submitterName, submitterEmail);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.fileRequestId,
            this.fileRequestDetails,
            this.submittedFileNames,
            this.submitterName,
            this.submitterEmail
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
            FileRequestReceiveFileDetails other = (FileRequestReceiveFileDetails) obj;
            return ((this.submittedFileNames == other.submittedFileNames) || (this.submittedFileNames.equals(other.submittedFileNames)))
                && ((this.fileRequestId == other.fileRequestId) || (this.fileRequestId != null && this.fileRequestId.equals(other.fileRequestId)))
                && ((this.fileRequestDetails == other.fileRequestDetails) || (this.fileRequestDetails != null && this.fileRequestDetails.equals(other.fileRequestDetails)))
                && ((this.submitterName == other.submitterName) || (this.submitterName != null && this.submitterName.equals(other.submitterName)))
                && ((this.submitterEmail == other.submitterEmail) || (this.submitterEmail != null && this.submitterEmail.equals(other.submitterEmail)))
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
    static class Serializer extends StructSerializer<FileRequestReceiveFileDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequestReceiveFileDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("submitted_file_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.submittedFileNames, g);
            if (value.fileRequestId != null) {
                g.writeFieldName("file_request_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.fileRequestId, g);
            }
            if (value.fileRequestDetails != null) {
                g.writeFieldName("file_request_details");
                StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).serialize(value.fileRequestDetails, g);
            }
            if (value.submitterName != null) {
                g.writeFieldName("submitter_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.submitterName, g);
            }
            if (value.submitterEmail != null) {
                g.writeFieldName("submitter_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.submitterEmail, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileRequestReceiveFileDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequestReceiveFileDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_submittedFileNames = null;
                String f_fileRequestId = null;
                FileRequestDetails f_fileRequestDetails = null;
                String f_submitterName = null;
                String f_submitterEmail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("submitted_file_names".equals(field)) {
                        f_submittedFileNames = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_request_id".equals(field)) {
                        f_fileRequestId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("file_request_details".equals(field)) {
                        f_fileRequestDetails = StoneSerializers.nullableStruct(FileRequestDetails.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("submitter_name".equals(field)) {
                        f_submitterName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("submitter_email".equals(field)) {
                        f_submitterEmail = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_submittedFileNames == null) {
                    throw new JsonParseException(p, "Required field \"submitted_file_names\" missing.");
                }
                value = new FileRequestReceiveFileDetails(f_submittedFileNames, f_fileRequestId, f_fileRequestDetails, f_submitterName, f_submitterEmail);
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
