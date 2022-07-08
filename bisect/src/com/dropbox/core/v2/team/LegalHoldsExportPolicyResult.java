/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.files.FolderMetadata;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public class LegalHoldsExportPolicyResult {
    // struct team.LegalHoldsExportPolicyResult (team_legal_holds.stone)

    protected final String asyncJobId;
    protected final FolderMetadata exportFolderMetadata;

    /**
     *
     * @param asyncJobId  Pass the given ID into {@link
     *     DbxTeamTeamRequests#legalHoldsExportPolicyJobStatusCheck(String)} to
     *     obtain the status of the export policy job status. Must have length
     *     of at least 1 and not be {@code null}.
     * @param exportFolderMetadata  Metadata for the newly created folder that
     *     will eventually, once the export policy job completes, include the
     *     hold's export. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsExportPolicyResult(String asyncJobId, FolderMetadata exportFolderMetadata) {
        if (asyncJobId == null) {
            throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
        }
        if (asyncJobId.length() < 1) {
            throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
        }
        this.asyncJobId = asyncJobId;
        if (exportFolderMetadata == null) {
            throw new IllegalArgumentException("Required value for 'exportFolderMetadata' is null");
        }
        this.exportFolderMetadata = exportFolderMetadata;
    }

    /**
     * Pass the given ID into {@link
     * DbxTeamTeamRequests#legalHoldsExportPolicyJobStatusCheck(String)} to
     * obtain the status of the export policy job status.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAsyncJobId() {
        return asyncJobId;
    }

    /**
     * Metadata for the newly created folder that will eventually, once the
     * export policy job completes, include the hold's export.
     *
     * @return value for this field, never {@code null}.
     */
    public FolderMetadata getExportFolderMetadata() {
        return exportFolderMetadata;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            asyncJobId,
            exportFolderMetadata
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
            LegalHoldsExportPolicyResult other = (LegalHoldsExportPolicyResult) obj;
            return ((this.asyncJobId == other.asyncJobId) || (this.asyncJobId.equals(other.asyncJobId)))
                && ((this.exportFolderMetadata == other.exportFolderMetadata) || (this.exportFolderMetadata.equals(other.exportFolderMetadata)))
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
    static class Serializer extends StructSerializer<LegalHoldsExportPolicyResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsExportPolicyResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("async_job_id");
            StoneSerializers.string().serialize(value.asyncJobId, g);
            g.writeFieldName("export_folder_metadata");
            FolderMetadata.Serializer.INSTANCE.serialize(value.exportFolderMetadata, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsExportPolicyResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsExportPolicyResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_asyncJobId = null;
                FolderMetadata f_exportFolderMetadata = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("async_job_id".equals(field)) {
                        f_asyncJobId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("export_folder_metadata".equals(field)) {
                        f_exportFolderMetadata = FolderMetadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_asyncJobId == null) {
                    throw new JsonParseException(p, "Required field \"async_job_id\" missing.");
                }
                if (f_exportFolderMetadata == null) {
                    throw new JsonParseException(p, "Required field \"export_folder_metadata\" missing.");
                }
                value = new LegalHoldsExportPolicyResult(f_asyncJobId, f_exportFolderMetadata);
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
