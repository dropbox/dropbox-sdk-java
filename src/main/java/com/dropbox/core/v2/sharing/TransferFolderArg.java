/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class TransferFolderArg {
    // struct TransferFolderArg

    protected final String sharedFolderId;
    protected final String toDropboxId;

    /**
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param toDropboxId  A account or team member ID to transfer ownership to.
     *     Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TransferFolderArg(String sharedFolderId, String toDropboxId) {
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (toDropboxId == null) {
            throw new IllegalArgumentException("Required value for 'toDropboxId' is null");
        }
        if (toDropboxId.length() < 1) {
            throw new IllegalArgumentException("String 'toDropboxId' is shorter than 1");
        }
        this.toDropboxId = toDropboxId;
    }

    /**
     * The ID for the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * A account or team member ID to transfer ownership to.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToDropboxId() {
        return toDropboxId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharedFolderId,
            toDropboxId
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
            TransferFolderArg other = (TransferFolderArg) obj;
            return ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.toDropboxId == other.toDropboxId) || (this.toDropboxId.equals(other.toDropboxId)))
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
    static final class Serializer extends StructSerializer<TransferFolderArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TransferFolderArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("to_dropbox_id");
            StoneSerializers.string().serialize(value.toDropboxId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TransferFolderArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TransferFolderArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sharedFolderId = null;
                String f_toDropboxId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("to_dropbox_id".equals(field)) {
                        f_toDropboxId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_toDropboxId == null) {
                    throw new JsonParseException(p, "Required field \"to_dropbox_id\" missing.");
                }
                value = new TransferFolderArg(f_sharedFolderId, f_toDropboxId);
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
