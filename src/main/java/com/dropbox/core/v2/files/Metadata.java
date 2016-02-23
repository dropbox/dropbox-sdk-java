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
 * Metadata for a file or folder.
 */
public class Metadata {
    // struct Metadata

    private final String name;
    private final String pathLower;
    private final String parentSharedFolderId;

    /**
     * Metadata for a file or folder.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param parentSharedFolderId  Deprecated. Please use
     *     :field:'FileSharingInfo.parent_shared_folder_id' or
     *     :field:'FolderSharingInfo.parent_shared_folder_id' instead. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata(String name, String pathLower, String parentSharedFolderId) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (pathLower == null) {
            throw new IllegalArgumentException("Required value for 'pathLower' is null");
        }
        this.pathLower = pathLower;
        if (parentSharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
    }

    /**
     * Metadata for a file or folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata(String name, String pathLower) {
        this(name, pathLower, null);
    }

    /**
     * The last component of the path (including extension). This never contains
     * a slash.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * The lowercased full path in the user's Dropbox. This always starts with a
     * slash.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPathLower() {
        return pathLower;
    }

    /**
     * Deprecated. Please use :field:'FileSharingInfo.parent_shared_folder_id'
     * or :field:'FolderSharingInfo.parent_shared_folder_id' instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            name,
            pathLower,
            parentSharedFolderId
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
            Metadata other = (Metadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.pathLower == other.pathLower) || (this.pathLower.equals(other.pathLower)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
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

    public static Metadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Metadata> _JSON_WRITER = new JsonWriter<Metadata>() {
        public final void write(Metadata x, JsonGenerator g) throws IOException {
            if (x instanceof FileMetadata) {
                FileMetadata._JSON_WRITER.write((FileMetadata) x, g);
                return;
            }
            if (x instanceof FolderMetadata) {
                FolderMetadata._JSON_WRITER.write((FolderMetadata) x, g);
                return;
            }
            if (x instanceof DeletedMetadata) {
                DeletedMetadata._JSON_WRITER.write((DeletedMetadata) x, g);
                return;
            }

            g.writeStartObject();
            Metadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(Metadata x, JsonGenerator g) throws IOException {
            g.writeFieldName("name");
            g.writeString(x.name);
            g.writeFieldName("path_lower");
            g.writeString(x.pathLower);
            if (x.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                g.writeString(x.parentSharedFolderId);
            }
        }
    };

    public static final JsonReader<Metadata> _JSON_READER = new JsonReader<Metadata>() {
        public final Metadata read(JsonParser parser) throws IOException, JsonReadException {
            Metadata result;
            JsonReader.expectObjectStart(parser);
            String [] tags = readTags(parser);
            result = readFromTags(tags, parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final Metadata readFromTags(String [] tags, JsonParser parser) throws IOException, JsonReadException {
            if (tags != null && tags.length > 0) {
                if ("file".equals(tags[0])) {
                    return FileMetadata._JSON_READER.readFromTags(tags, parser);
                }
                if ("folder".equals(tags[0])) {
                    return FolderMetadata._JSON_READER.readFromTags(tags, parser);
                }
                if ("deleted".equals(tags[0])) {
                    return DeletedMetadata._JSON_READER.readFromTags(tags, parser);
                }
                // If no match, fall back to base class
            }
            return readFields(parser);
        }

        public final Metadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String pathLower = null;
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
            return new Metadata(name, pathLower, parentSharedFolderId);
        }
    };
}
