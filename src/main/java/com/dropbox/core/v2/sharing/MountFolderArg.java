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

public class MountFolderArg {
    // struct MountFolderArg

    private final String sharedFolderId;

    /**
     *
     * @param sharedFolderId  The ID of the shared folder to mount. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MountFolderArg(String sharedFolderId) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * The ID of the shared folder to mount.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId
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
            MountFolderArg other = (MountFolderArg) obj;
            return (this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId));
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

    public static MountFolderArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MountFolderArg> _JSON_WRITER = new JsonWriter<MountFolderArg>() {
        public final void write(MountFolderArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MountFolderArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MountFolderArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
        }
    };

    public static final JsonReader<MountFolderArg> _JSON_READER = new JsonReader<MountFolderArg>() {
        public final MountFolderArg read(JsonParser parser) throws IOException, JsonReadException {
            MountFolderArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MountFolderArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String sharedFolderId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            return new MountFolderArg(sharedFolderId);
        }
    };
}
