/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * Result for {@link DbxUserSharingRequests#listFolders()}. Unmounted shared
 * folders can be identified by the absence of {@link
 * SharedFolderMetadata#getPathLower}.
 */
@JsonSerialize(using=ListFoldersResult.Serializer.class)
@JsonDeserialize(using=ListFoldersResult.Deserializer.class)
public class ListFoldersResult {
    // struct ListFoldersResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<SharedFolderMetadata> entries;
    protected final String cursor;

    /**
     * Result for {@link DbxUserSharingRequests#listFolders()}. Unmounted shared
     * folders can be identified by the absence of {@link
     * SharedFolderMetadata#getPathLower}.
     *
     * @param entries  List of all shared folders the authenticated user has
     *     access to. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param cursor  Present if there are additional shared folders that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listFoldersContinue(String)} to list
     *     additional folders.
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
     * Result for {@link DbxUserSharingRequests#listFolders()}. Unmounted shared
     * folders can be identified by the absence of {@link
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
     * DbxUserSharingRequests#listFoldersContinue(String)} to list additional
     * folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListFoldersResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFoldersResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFoldersResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFoldersResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFoldersResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("entries", value.entries);
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFoldersResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFoldersResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFoldersResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFoldersResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFoldersResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<SharedFolderMetadata> entries = null;
            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("entries".equals(_field)) {
                    expectArrayStart(_p);
                    entries = new java.util.ArrayList<SharedFolderMetadata>();
                    while (!isArrayEnd(_p)) {
                        SharedFolderMetadata _x = null;
                        _x = _p.readValueAs(SharedFolderMetadata.class);
                        _p.nextToken();
                        entries.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (entries == null) {
                throw new JsonParseException(_p, "Required field \"entries\" is missing.");
            }

            return new ListFoldersResult(entries, cursor);
        }
    }
}
