/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

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

/**
 * Metadata for a file or folder.
 */
@JsonSerialize(using=Metadata.Serializer.class)
@JsonDeserialize(using=Metadata.Deserializer.class)
public class Metadata {
    // struct Metadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String name;
    protected final String pathLower;
    protected final String pathDisplay;
    protected final String parentSharedFolderId;

    /**
     * Metadata for a file or folder.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxUserFilesRequests#listFolderContinue(String)}. Must not be
     *     {@code null}.
     * @param parentSharedFolderId  Deprecated. Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata(String name, String pathLower, String pathDisplay, String parentSharedFolderId) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (pathLower == null) {
            throw new IllegalArgumentException("Required value for 'pathLower' is null");
        }
        this.pathLower = pathLower;
        if (pathDisplay == null) {
            throw new IllegalArgumentException("Required value for 'pathDisplay' is null");
        }
        this.pathDisplay = pathDisplay;
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
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxUserFilesRequests#listFolderContinue(String)}. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata(String name, String pathLower, String pathDisplay) {
        this(name, pathLower, pathDisplay, null);
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
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1. Changes to the
     * casing of paths won't be returned by {@link
     * DbxUserFilesRequests#listFolderContinue(String)}
     *
     * @return value for this field, never {@code null}.
     */
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * Deprecated. Please use {@link FileSharingInfo#getParentSharedFolderId} or
     * {@link FolderSharingInfo#getParentSharedFolderId} instead.
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
            pathDisplay,
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
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay.equals(other.pathDisplay)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
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

    static final class Serializer extends StructJsonSerializer<Metadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Metadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(Metadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(Metadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("name", value.name);
            g.writeObjectField("path_lower", value.pathLower);
            g.writeObjectField("path_display", value.pathDisplay);
            if (value.parentSharedFolderId != null) {
                g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<Metadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Metadata.class, FileMetadata.class, FolderMetadata.class, DeletedMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(Metadata.class, unwrapping, FileMetadata.class, FolderMetadata.class, DeletedMetadata.class);
        }

        @Override
        protected JsonDeserializer<Metadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public Metadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p);
            if ("file".equals(_subtype_tag)) {
                return readCollapsedStructValue(FileMetadata.class, _p, _ctx);
            }
            if ("folder".equals(_subtype_tag)) {
                return readCollapsedStructValue(FolderMetadata.class, _p, _ctx);
            }
            if ("deleted".equals(_subtype_tag)) {
                return readCollapsedStructValue(DeletedMetadata.class, _p, _ctx);
            }

            String name = null;
            String pathLower = null;
            String pathDisplay = null;
            String parentSharedFolderId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path_display".equals(_field)) {
                    pathDisplay = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("parent_shared_folder_id".equals(_field)) {
                    parentSharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (pathLower == null) {
                throw new JsonParseException(_p, "Required field \"path_lower\" is missing.");
            }
            if (pathDisplay == null) {
                throw new JsonParseException(_p, "Required field \"path_display\" is missing.");
            }

            return new Metadata(name, pathLower, pathDisplay, parentSharedFolderId);
        }
    }
}
