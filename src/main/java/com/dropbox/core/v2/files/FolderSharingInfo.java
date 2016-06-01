/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Sharing info for a folder which is contained in a shared folder or is a
 * shared folder mount point.
 */
public class FolderSharingInfo extends SharingInfo {
    // struct FolderSharingInfo

    protected final String parentSharedFolderId;
    protected final String sharedFolderId;

    /**
     * Sharing info for a folder which is contained in a shared folder or is a
     * shared folder mount point.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  Set if the folder is contained by a shared
     *     folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param sharedFolderId  If this folder is a shared folder mount point, the
     *     ID of the shared folder mounted at this location. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderSharingInfo(boolean readOnly, String parentSharedFolderId, String sharedFolderId) {
        super(readOnly);
        if (parentSharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (sharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * Sharing info for a folder which is contained in a shared folder or is a
     * shared folder mount point.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     */
    public FolderSharingInfo(boolean readOnly) {
        this(readOnly, null, null);
    }

    /**
     * Set if the folder is contained by a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * If this folder is a shared folder mount point, the ID of the shared
     * folder mounted at this location.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder(boolean readOnly) {
        return new Builder(readOnly);
    }

    /**
     * Builder for {@link FolderSharingInfo}.
     */
    public static class Builder {
        protected final boolean readOnly;

        protected String parentSharedFolderId;
        protected String sharedFolderId;

        protected Builder(boolean readOnly) {
            this.readOnly = readOnly;
            this.parentSharedFolderId = null;
            this.sharedFolderId = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Set if the folder is contained by a
         *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withParentSharedFolderId(String parentSharedFolderId) {
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.parentSharedFolderId = parentSharedFolderId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedFolderId  If this folder is a shared folder mount point,
         *     the ID of the shared folder mounted at this location. Must match
         *     pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSharedFolderId(String sharedFolderId) {
            if (sharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                    throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
                }
            }
            this.sharedFolderId = sharedFolderId;
            return this;
        }

        /**
         * Builds an instance of {@link FolderSharingInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderSharingInfo}
         */
        public FolderSharingInfo build() {
            return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            sharedFolderId
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
            FolderSharingInfo other = (FolderSharingInfo) obj;
            return (this.readOnly == other.readOnly)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
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
    static final class Serializer extends StructSerializer<FolderSharingInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderSharingInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("read_only");
            StoneSerializers.boolean_().serialize(value.readOnly, g);
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.sharedFolderId != null) {
                g.writeFieldName("shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedFolderId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderSharingInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderSharingInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_readOnly = null;
                String f_parentSharedFolderId = null;
                String f_sharedFolderId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("read_only".equals(field)) {
                        f_readOnly = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_readOnly == null) {
                    throw new JsonParseException(p, "Required field \"read_only\" missing.");
                }
                value = new FolderSharingInfo(f_readOnly, f_parentSharedFolderId, f_sharedFolderId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
