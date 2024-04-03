/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;

/**
 * Paper folder's logged information.
 */
public class PaperFolderLogInfo {
    // struct team_log.PaperFolderLogInfo (team_log_generated.stone)

    @Nonnull
    protected final String folderId;
    @Nonnull
    protected final String folderName;

    /**
     * Paper folder's logged information.
     *
     * @param folderId  Papers folder Id. Must not be {@code null}.
     * @param folderName  Paper folder name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperFolderLogInfo(@Nonnull String folderId, @Nonnull String folderName) {
        if (folderId == null) {
            throw new IllegalArgumentException("Required value for 'folderId' is null");
        }
        this.folderId = folderId;
        if (folderName == null) {
            throw new IllegalArgumentException("Required value for 'folderName' is null");
        }
        this.folderName = folderName;
    }

    /**
     * Papers folder Id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFolderId() {
        return folderId;
    }

    /**
     * Paper folder name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFolderName() {
        return folderName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.folderId,
            this.folderName
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
            PaperFolderLogInfo other = (PaperFolderLogInfo) obj;
            return ((this.folderId == other.folderId) || (this.folderId.equals(other.folderId)))
                && ((this.folderName == other.folderName) || (this.folderName.equals(other.folderName)))
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
    static class Serializer extends StructSerializer<PaperFolderLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperFolderLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("folder_id");
            StoneSerializers.string().serialize(value.folderId, g);
            g.writeFieldName("folder_name");
            StoneSerializers.string().serialize(value.folderName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperFolderLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperFolderLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_folderId = null;
                String f_folderName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("folder_id".equals(field)) {
                        f_folderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("folder_name".equals(field)) {
                        f_folderName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_folderId == null) {
                    throw new JsonParseException(p, "Required field \"folder_id\" missing.");
                }
                if (f_folderName == null) {
                    throw new JsonParseException(p, "Required field \"folder_name\" missing.");
                }
                value = new PaperFolderLogInfo(f_folderId, f_folderName);
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
