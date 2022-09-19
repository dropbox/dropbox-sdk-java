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
import java.util.Arrays;

/**
 * Sharing info for a folder which is contained in a shared folder or is a
 * shared folder mount point.
 */
public class FolderSharingInfo extends SharingInfo {
    // struct files.FolderSharingInfo (files.stone)

    protected final String parentSharedFolderId;
    protected final String sharedFolderId;
    protected final boolean traverseOnly;
    protected final boolean noAccess;

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
     * @param traverseOnly  Specifies that the folder can only be traversed and
     *     the user can only see a limited subset of the contents of this folder
     *     because they don't have read access to this folder. They do, however,
     *     have access to some sub folder.
     * @param noAccess  Specifies that the folder cannot be accessed by the
     *     user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderSharingInfo(boolean readOnly, String parentSharedFolderId, String sharedFolderId, boolean traverseOnly, boolean noAccess) {
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
        this.traverseOnly = traverseOnly;
        this.noAccess = noAccess;
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
        this(readOnly, null, null, false, false);
    }

    /**
     * True if the file or folder is inside a read-only shared folder.
     *
     * @return value for this field.
     */
    public boolean getReadOnly() {
        return readOnly;
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
     * Specifies that the folder can only be traversed and the user can only see
     * a limited subset of the contents of this folder because they don't have
     * read access to this folder. They do, however, have access to some sub
     * folder.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getTraverseOnly() {
        return traverseOnly;
    }

    /**
     * Specifies that the folder cannot be accessed by the user.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getNoAccess() {
        return noAccess;
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
        protected boolean traverseOnly;
        protected boolean noAccess;

        protected Builder(boolean readOnly) {
            this.readOnly = readOnly;
            this.parentSharedFolderId = null;
            this.sharedFolderId = null;
            this.traverseOnly = false;
            this.noAccess = false;
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
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param traverseOnly  Specifies that the folder can only be traversed
         *     and the user can only see a limited subset of the contents of
         *     this folder because they don't have read access to this folder.
         *     They do, however, have access to some sub folder. Defaults to
         *     {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withTraverseOnly(Boolean traverseOnly) {
            if (traverseOnly != null) {
                this.traverseOnly = traverseOnly;
            }
            else {
                this.traverseOnly = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param noAccess  Specifies that the folder cannot be accessed by the
         *     user. Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withNoAccess(Boolean noAccess) {
            if (noAccess != null) {
                this.noAccess = noAccess;
            }
            else {
                this.noAccess = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link FolderSharingInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderSharingInfo}
         */
        public FolderSharingInfo build() {
            return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId, traverseOnly, noAccess);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            sharedFolderId,
            traverseOnly,
            noAccess
        });
        hash = (31 * super.hashCode()) + hash;
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
            FolderSharingInfo other = (FolderSharingInfo) obj;
            return (this.readOnly == other.readOnly)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
                && (this.traverseOnly == other.traverseOnly)
                && (this.noAccess == other.noAccess)
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
    static class Serializer extends StructSerializer<FolderSharingInfo> {
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
            g.writeFieldName("traverse_only");
            StoneSerializers.boolean_().serialize(value.traverseOnly, g);
            g.writeFieldName("no_access");
            StoneSerializers.boolean_().serialize(value.noAccess, g);
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
                Boolean f_traverseOnly = false;
                Boolean f_noAccess = false;
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
                    else if ("traverse_only".equals(field)) {
                        f_traverseOnly = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("no_access".equals(field)) {
                        f_noAccess = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_readOnly == null) {
                    throw new JsonParseException(p, "Required field \"read_only\" missing.");
                }
                value = new FolderSharingInfo(f_readOnly, f_parentSharedFolderId, f_sharedFolderId, f_traverseOnly, f_noAccess);
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
