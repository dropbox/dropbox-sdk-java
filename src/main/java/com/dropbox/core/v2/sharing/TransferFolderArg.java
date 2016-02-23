/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class TransferFolderArg {
    // struct TransferFolderArg

    private final String sharedFolderId;
    private final String toDropboxId;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param toDropboxId  A account or team member ID to transfer ownership to.
     *     Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TransferFolderArg(String sharedFolderId, String toDropboxId) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (toDropboxId == null) {
            throw new IllegalArgumentException("Required value for 'toDropboxId' is null");
        }
        if (toDropboxId.length() < 1) {
            throw new IllegalArgumentException("String 'toDropboxId' is shorter than 1");
        }
        this.toDropboxId = toDropboxId;
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * A account or team member ID to transfer ownership to.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToDropboxId() {
        return toDropboxId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            toDropboxId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TransferFolderArg other = (TransferFolderArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.toDropboxId == other.toDropboxId) || (this.toDropboxId.equals(other.toDropboxId)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static TransferFolderArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TransferFolderArg> _JSON_WRITER = new JsonWriter<TransferFolderArg>() {
        public final void write(TransferFolderArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TransferFolderArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TransferFolderArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("to_dropbox_id");
            g.writeString(x.toDropboxId);
        }
    };

    public static final JsonReader<TransferFolderArg> _JSON_READER = new JsonReader<TransferFolderArg>() {
        public final TransferFolderArg read(JsonParser parser) throws IOException, JsonReadException {
            TransferFolderArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TransferFolderArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            String toDropboxId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("to_dropbox_id".equals(fieldName)) {
                    toDropboxId = JsonReader.StringReader
                        .readField(parser, "to_dropbox_id", toDropboxId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            if (toDropboxId == null) {
                throw new JsonReadException("Required field \"to_dropbox_id\" is missing.", parser.getTokenLocation());
            }
            return new TransferFolderArg(sharedFolderId, toDropboxId);
        }
    };
}
