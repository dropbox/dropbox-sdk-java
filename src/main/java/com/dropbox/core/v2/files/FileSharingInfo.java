/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Sharing info for a file which is contained by a shared folder.
 */
public class FileSharingInfo extends SharingInfo {
    // struct FileSharingInfo

    private final String parentSharedFolderId;
    private final String modifiedBy;

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param modifiedBy  The last user who modified the file. This field will
     *     be null if the user's account has been deleted. Must have length of
     *     at least 40 and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, String parentSharedFolderId, String modifiedBy) {
        super(readOnly);
        if (parentSharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'parentSharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (modifiedBy != null) {
            if (modifiedBy.length() < 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is shorter than 40");
            }
            if (modifiedBy.length() > 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is longer than 40");
            }
        }
        this.modifiedBy = modifiedBy;
    }

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, String parentSharedFolderId) {
        this(readOnly, parentSharedFolderId, null);
    }

    /**
     * ID of shared folder that holds this file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The last user who modified the file. This field will be null if the
     * user's account has been deleted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            modifiedBy
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FileSharingInfo other = (FileSharingInfo) obj;
            return ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.modifiedBy == other.modifiedBy) || (this.modifiedBy != null && this.modifiedBy.equals(other.modifiedBy)))
                && (this.getReadOnly() == other.getReadOnly())
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

    public static FileSharingInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<FileSharingInfo> _JSON_WRITER = new JsonWriter<FileSharingInfo>() {
        public final void write(FileSharingInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharingInfo._JSON_WRITER.writeFields(x, g);
            FileSharingInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(FileSharingInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("parent_shared_folder_id");
            g.writeString(x.parentSharedFolderId);
            if (x.modifiedBy != null) {
                g.writeFieldName("modified_by");
                g.writeString(x.modifiedBy);
            }
        }
    };

    public static final JsonReader<FileSharingInfo> _JSON_READER = new JsonReader<FileSharingInfo>() {
        public final FileSharingInfo read(JsonParser parser) throws IOException, JsonReadException {
            FileSharingInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final FileSharingInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            Boolean readOnly = null;
            String parentSharedFolderId = null;
            String modifiedBy = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("read_only".equals(fieldName)) {
                    readOnly = JsonReader.BooleanReader
                        .readField(parser, "read_only", readOnly);
                }
                else if ("parent_shared_folder_id".equals(fieldName)) {
                    parentSharedFolderId = JsonReader.StringReader
                        .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                }
                else if ("modified_by".equals(fieldName)) {
                    modifiedBy = JsonReader.StringReader
                        .readField(parser, "modified_by", modifiedBy);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (readOnly == null) {
                throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
            }
            if (parentSharedFolderId == null) {
                throw new JsonReadException("Required field \"parent_shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            return new FileSharingInfo(readOnly, parentSharedFolderId, modifiedBy);
        }
    };
}
