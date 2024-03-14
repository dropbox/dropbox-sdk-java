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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Sharing info for a file which is contained by a shared folder.
 */
public class FileSharingInfo extends SharingInfo {
    // struct files.FileSharingInfo (files.stone)

    protected final String parentSharedFolderId;
    protected final String modifiedBy;

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param modifiedBy  The last user who modified the file. This field will
     *     be null if the user's account has been deleted. Must have length of
     *     at least 40 and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, @Nonnull String parentSharedFolderId, @Nullable String modifiedBy) {
        super(readOnly);
        if (parentSharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'parentSharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (modifiedBy != null) {
            if (modifiedBy.length() < 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is shorter than 40");
            }
            if (modifiedBy.length() > 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is longer than 40");
            }
        }
        this.modifiedBy = modifiedBy;
    }

    /**
     * Sharing info for a file which is contained by a shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     * @param parentSharedFolderId  ID of shared folder that holds this file.
     *     Must match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileSharingInfo(boolean readOnly, String parentSharedFolderId) {
        this(readOnly, parentSharedFolderId, null);
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
     * ID of shared folder that holds this file.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The last user who modified the file. This field will be null if the
     * user's account has been deleted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            parentSharedFolderId,
            modifiedBy
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
            FileSharingInfo other = (FileSharingInfo) obj;
            return (this.readOnly == other.readOnly)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.modifiedBy == other.modifiedBy) || (this.modifiedBy != null && this.modifiedBy.equals(other.modifiedBy)))
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
    static class Serializer extends StructSerializer<FileSharingInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileSharingInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("read_only");
            StoneSerializers.boolean_().serialize(value.readOnly, g);
            g.writeFieldName("parent_shared_folder_id");
            StoneSerializers.string().serialize(value.parentSharedFolderId, g);
            if (value.modifiedBy != null) {
                g.writeFieldName("modified_by");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.modifiedBy, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileSharingInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileSharingInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_readOnly = null;
                String f_parentSharedFolderId = null;
                String f_modifiedBy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("read_only".equals(field)) {
                        f_readOnly = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("modified_by".equals(field)) {
                        f_modifiedBy = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_readOnly == null) {
                    throw new JsonParseException(p, "Required field \"read_only\" missing.");
                }
                if (f_parentSharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"parent_shared_folder_id\" missing.");
                }
                value = new FileSharingInfo(f_readOnly, f_parentSharedFolderId, f_modifiedBy);
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
