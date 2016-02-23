/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Result for {@link DbxSharing#listFolders()}. Unmounted shared folders can be
 * identified by the absence of {@link SharedFolderMetadata#getPathLower}.
 */
public class ListFoldersResult {
    // struct ListFoldersResult

    private final List<SharedFolderMetadata> entries;
    private final String cursor;

    /**
     * Result for {@link DbxSharing#listFolders()}. Unmounted shared folders can
     * be identified by the absence of {@link
     * SharedFolderMetadata#getPathLower}.
     *
     * @param entries  List of all shared folders the authenticated user has
     *     access to. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param cursor  Present if there are additional shared folders that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxSharing#listFoldersContinue(String)} to list additional folders.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult(List<SharedFolderMetadata> entries, String cursor) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (SharedFolderMetadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
        this.cursor = cursor;
    }

    /**
     * Result for {@link DbxSharing#listFolders()}. Unmounted shared folders can
     * be identified by the absence of {@link
     * SharedFolderMetadata#getPathLower}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param entries  List of all shared folders the authenticated user has
     *     access to. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult(List<SharedFolderMetadata> entries) {
        this(entries, null);
    }

    /**
     * List of all shared folders the authenticated user has access to.
     *
     * @return value for this field, never {@code null}.
     */
    public List<SharedFolderMetadata> getEntries() {
        return entries;
    }

    /**
     * Present if there are additional shared folders that have not been
     * returned yet. Pass the cursor into {@link
     * DbxSharing#listFoldersContinue(String)} to list additional folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListFoldersResult other = (ListFoldersResult) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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

    public static ListFoldersResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFoldersResult> _JSON_WRITER = new JsonWriter<ListFoldersResult>() {
        public final void write(ListFoldersResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListFoldersResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListFoldersResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("entries");
            g.writeStartArray();
            for (SharedFolderMetadata item: x.entries) {
                if (item != null) {
                    SharedFolderMetadata._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListFoldersResult> _JSON_READER = new JsonReader<ListFoldersResult>() {
        public final ListFoldersResult read(JsonParser parser) throws IOException, JsonReadException {
            ListFoldersResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListFoldersResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<SharedFolderMetadata> entries = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("entries".equals(fieldName)) {
                    entries = JsonArrayReader.mk(SharedFolderMetadata._JSON_READER)
                        .readField(parser, "entries", entries);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (entries == null) {
                throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
            }
            return new ListFoldersResult(entries, cursor);
        }
    };
}
