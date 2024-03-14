/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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
 * Result for {@link DbxUserSharingRequests#listFolders} or {@link
 * DbxUserSharingRequests#listMountableFolders}, depending on which endpoint was
 * requested. Unmounted shared folders can be identified by the absence of
 * {@link SharedFolderMetadata#getPathLower}.
 */
public class ListFoldersResult {
    // struct sharing.ListFoldersResult (sharing_folders.stone)

    protected final List<SharedFolderMetadata> entries;
    protected final String cursor;

    /**
     * Result for {@link DbxUserSharingRequests#listFolders} or {@link
     * DbxUserSharingRequests#listMountableFolders}, depending on which endpoint
     * was requested. Unmounted shared folders can be identified by the absence
     * of {@link SharedFolderMetadata#getPathLower}.
     *
     * @param entries  List of all shared folders the authenticated user has
     *     access to. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param cursor  Present if there are additional shared folders that have
     *     not been returned yet. Pass the cursor into the corresponding
     *     continue endpoint (either {@link
     *     DbxUserSharingRequests#listFoldersContinue(String)} or {@link
     *     DbxUserSharingRequests#listMountableFoldersContinue(String)}) to list
     *     additional folders.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult(@Nonnull List<SharedFolderMetadata> entries, @Nullable String cursor) {
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
     * Result for {@link DbxUserSharingRequests#listFolders} or {@link
     * DbxUserSharingRequests#listMountableFolders}, depending on which endpoint
     * was requested. Unmounted shared folders can be identified by the absence
     * of {@link SharedFolderMetadata#getPathLower}.
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
    public ListFoldersResult(@Nonnull List<SharedFolderMetadata> entries) {
        this(entries, null);
    }

    /**
     * List of all shared folders the authenticated user has access to.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<SharedFolderMetadata> getEntries() {
        return entries;
    }

    /**
     * Present if there are additional shared folders that have not been
     * returned yet. Pass the cursor into the corresponding continue endpoint
     * (either {@link DbxUserSharingRequests#listFoldersContinue(String)} or
     * {@link DbxUserSharingRequests#listMountableFoldersContinue(String)}) to
     * list additional folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            entries,
            cursor
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
    static class Serializer extends StructSerializer<ListFoldersResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFoldersResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(SharedFolderMetadata.Serializer.INSTANCE).serialize(value.entries, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFoldersResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFoldersResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<SharedFolderMetadata> f_entries = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(SharedFolderMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new ListFoldersResult(f_entries, f_cursor);
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
