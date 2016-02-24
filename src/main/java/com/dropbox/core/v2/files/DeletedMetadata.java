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
 * Indicates that there used to be a file or folder at this path, but it no
 * longer exists.
 */
public class DeletedMetadata extends Metadata {
    // struct DeletedMetadata


    /**
     * Indicates that there used to be a file or folder at this path, but it no
     * longer exists.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxFiles#listFolderContinue(String)}. Must not be {@code
     *     null}.
     * @param parentSharedFolderId  Deprecated. Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeletedMetadata(String name, String pathLower, String pathDisplay, String parentSharedFolderId) {
        super(name, pathLower, pathDisplay, parentSharedFolderId);
    }

    /**
     * Indicates that there used to be a file or folder at this path, but it no
     * longer exists.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxFiles#listFolderContinue(String)}. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeletedMetadata(String name, String pathLower, String pathDisplay) {
        this(name, pathLower, pathDisplay, null);
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DeletedMetadata other = (DeletedMetadata) obj;
            return ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                && ((this.getPathLower() == other.getPathLower()) || (this.getPathLower().equals(other.getPathLower())))
                && ((this.getPathDisplay() == other.getPathDisplay()) || (this.getPathDisplay().equals(other.getPathDisplay())))
                && ((this.getParentSharedFolderId() == other.getParentSharedFolderId()) || (this.getParentSharedFolderId() != null && this.getParentSharedFolderId().equals(other.getParentSharedFolderId())))
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

    public static DeletedMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DeletedMetadata> _JSON_WRITER = new JsonWriter<DeletedMetadata>() {
        public final void write(DeletedMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            g.writeStringField(".tag", "deleted");
            Metadata._JSON_WRITER.writeFields(x, g);
            DeletedMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DeletedMetadata x, JsonGenerator g) throws IOException {
        }
    };

    public static final JsonReader<DeletedMetadata> _JSON_READER = new JsonReader<DeletedMetadata>() {
        public final DeletedMetadata read(JsonParser parser) throws IOException, JsonReadException {
            DeletedMetadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DeletedMetadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null) {
                assert tags.length >= 1;
                assert "deleted".equals(tags[0]);
            }
            return readFields(parser);
        }

        public final DeletedMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String pathLower = null;
            String pathDisplay = null;
            String parentSharedFolderId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("path_lower".equals(fieldName)) {
                    pathLower = JsonReader.StringReader
                        .readField(parser, "path_lower", pathLower);
                }
                else if ("path_display".equals(fieldName)) {
                    pathDisplay = JsonReader.StringReader
                        .readField(parser, "path_display", pathDisplay);
                }
                else if ("parent_shared_folder_id".equals(fieldName)) {
                    parentSharedFolderId = JsonReader.StringReader
                        .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (pathLower == null) {
                throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
            }
            if (pathDisplay == null) {
                throw new JsonReadException("Required field \"path_display\" is missing.", parser.getTokenLocation());
            }
            return new DeletedMetadata(name, pathLower, pathDisplay, parentSharedFolderId);
        }
    };
}
