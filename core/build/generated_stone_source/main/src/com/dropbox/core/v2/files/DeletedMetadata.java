/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Indicates that there used to be a file or folder at this path, but it no
 * longer exists.
 */
public class DeletedMetadata extends Metadata {
    // struct files.DeletedMetadata (files.stone)


    /**
     * Indicates that there used to be a file or folder at this path, but it no
     * longer exists.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. This field will be null if the file or
     *     folder is not mounted.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1, and at least the last path component will have the
     *     correct casing. Changes to only the casing of paths won't be returned
     *     by {@link DbxAppFilesRequests#listFolderContinue(String)}. This field
     *     will be null if the file or folder is not mounted.
     * @param parentSharedFolderId  Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param previewUrl  The preview URL of the file.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeletedMetadata(@Nonnull String name, @Nullable String pathLower, @Nullable String pathDisplay, @Nullable String parentSharedFolderId, @Nullable String previewUrl) {
        super(name, pathLower, pathDisplay, parentSharedFolderId, previewUrl);
    }

    /**
     * Indicates that there used to be a file or folder at this path, but it no
     * longer exists.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeletedMetadata(@Nonnull String name) {
        this(name, null, null, null, null);
    }

    /**
     * The last component of the path (including extension). This never contains
     * a slash.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The lowercased full path in the user's Dropbox. This always starts with a
     * slash. This field will be null if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1, and at least
     * the last path component will have the correct casing. Changes to only the
     * casing of paths won't be returned by {@link
     * DbxAppFilesRequests#listFolderContinue(String)}. This field will be null
     * if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * Please use {@link FileSharingInfo#getParentSharedFolderId} or {@link
     * FolderSharingInfo#getParentSharedFolderId} instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The preview URL of the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name) {
        return new Builder(name);
    }

    /**
     * Builder for {@link DeletedMetadata}.
     */
    public static class Builder extends Metadata.Builder {

        protected Builder(String name) {
            super(name);
        }

        /**
         * Set value for optional field.
         *
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will be null if the
         *     file or folder is not mounted.
         *
         * @return this builder
         */
        public Builder withPathLower(String pathLower) {
            super.withPathLower(pathLower);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param pathDisplay  The cased path to be used for display purposes
         *     only. In rare instances the casing will not correctly match the
         *     user's filesystem, but this behavior will match the path provided
         *     in the Core API v1, and at least the last path component will
         *     have the correct casing. Changes to only the casing of paths
         *     won't be returned by {@link
         *     DbxAppFilesRequests#listFolderContinue(String)}. This field will
         *     be null if the file or folder is not mounted.
         *
         * @return this builder
         */
        public Builder withPathDisplay(String pathDisplay) {
            super.withPathDisplay(pathDisplay);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Please use {@link
         *     FileSharingInfo#getParentSharedFolderId} or {@link
         *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
         *     pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withParentSharedFolderId(String parentSharedFolderId) {
            super.withParentSharedFolderId(parentSharedFolderId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previewUrl  The preview URL of the file.
         *
         * @return this builder
         */
        public Builder withPreviewUrl(String previewUrl) {
            super.withPreviewUrl(previewUrl);
            return this;
        }

        /**
         * Builds an instance of {@link DeletedMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link DeletedMetadata}
         */
        public DeletedMetadata build() {
            return new DeletedMetadata(name, pathLower, pathDisplay, parentSharedFolderId, previewUrl);
        }
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DeletedMetadata other = (DeletedMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl != null && this.previewUrl.equals(other.previewUrl)))
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
    static class Serializer extends StructSerializer<DeletedMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeletedMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("deleted", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.pathDisplay != null) {
                g.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathDisplay, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.previewUrl != null) {
                g.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previewUrl, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeletedMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeletedMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("deleted".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_pathLower = null;
                String f_pathDisplay = null;
                String f_parentSharedFolderId = null;
                String f_previewUrl = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("preview_url".equals(field)) {
                        f_previewUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new DeletedMetadata(f_name, f_pathLower, f_pathDisplay, f_parentSharedFolderId, f_previewUrl);
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
