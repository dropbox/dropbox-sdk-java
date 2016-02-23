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

public class UnshareFolderArg {
    // struct UnshareFolderArg

    private final String sharedFolderId;
    private final boolean leaveACopy;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param leaveACopy  If true, members of this shared folder will get a copy
     *     of this folder after it's unshared. Otherwise, it will be removed
     *     from their Dropbox. The current user, who is an owner, will always
     *     retain their copy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UnshareFolderArg(String sharedFolderId, boolean leaveACopy) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        this.leaveACopy = leaveACopy;
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
     * If true, members of this shared folder will get a copy of this folder
     * after it's unshared. Otherwise, it will be removed from their Dropbox.
     * The current user, who is an owner, will always retain their copy.
     *
     * @return value for this field.
     */
    public boolean getLeaveACopy() {
        return leaveACopy;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            leaveACopy
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
            UnshareFolderArg other = (UnshareFolderArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && (this.leaveACopy == other.leaveACopy)
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

    public static UnshareFolderArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UnshareFolderArg> _JSON_WRITER = new JsonWriter<UnshareFolderArg>() {
        public final void write(UnshareFolderArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UnshareFolderArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UnshareFolderArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("leave_a_copy");
            g.writeBoolean(x.leaveACopy);
        }
    };

    public static final JsonReader<UnshareFolderArg> _JSON_READER = new JsonReader<UnshareFolderArg>() {
        public final UnshareFolderArg read(JsonParser parser) throws IOException, JsonReadException {
            UnshareFolderArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UnshareFolderArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            Boolean leaveACopy = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("leave_a_copy".equals(fieldName)) {
                    leaveACopy = JsonReader.BooleanReader
                        .readField(parser, "leave_a_copy", leaveACopy);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            if (leaveACopy == null) {
                throw new JsonReadException("Required field \"leave_a_copy\" is missing.", parser.getTokenLocation());
            }
            return new UnshareFolderArg(sharedFolderId, leaveACopy);
        }
    };
}
