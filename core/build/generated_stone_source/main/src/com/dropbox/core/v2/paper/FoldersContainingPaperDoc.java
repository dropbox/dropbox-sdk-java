/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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
 * Metadata about Paper folders containing the specififed Paper doc.
 */
public class FoldersContainingPaperDoc {
    // struct paper.FoldersContainingPaperDoc (paper.stone)

    protected final FolderSharingPolicyType folderSharingPolicyType;
    protected final List<Folder> folders;

    /**
     * Metadata about Paper folders containing the specififed Paper doc.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param folderSharingPolicyType  The sharing policy of the folder
     *     containing the Paper doc.
     * @param folders  The folder path. If present the first folder is the root
     *     folder. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FoldersContainingPaperDoc(@Nullable FolderSharingPolicyType folderSharingPolicyType, @Nullable List<Folder> folders) {
        this.folderSharingPolicyType = folderSharingPolicyType;
        if (folders != null) {
            for (Folder x : folders) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'folders' is null");
                }
            }
        }
        this.folders = folders;
    }

    /**
     * Metadata about Paper folders containing the specififed Paper doc.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FoldersContainingPaperDoc() {
        this(null, null);
    }

    /**
     * The sharing policy of the folder containing the Paper doc.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FolderSharingPolicyType getFolderSharingPolicyType() {
        return folderSharingPolicyType;
    }

    /**
     * The folder path. If present the first folder is the root folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<Folder> getFolders() {
        return folders;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link FoldersContainingPaperDoc}.
     */
    public static class Builder {

        protected FolderSharingPolicyType folderSharingPolicyType;
        protected List<Folder> folders;

        protected Builder() {
            this.folderSharingPolicyType = null;
            this.folders = null;
        }

        /**
         * Set value for optional field.
         *
         * @param folderSharingPolicyType  The sharing policy of the folder
         *     containing the Paper doc.
         *
         * @return this builder
         */
        public Builder withFolderSharingPolicyType(FolderSharingPolicyType folderSharingPolicyType) {
            this.folderSharingPolicyType = folderSharingPolicyType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param folders  The folder path. If present the first folder is the
         *     root folder. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFolders(List<Folder> folders) {
            if (folders != null) {
                for (Folder x : folders) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'folders' is null");
                    }
                }
            }
            this.folders = folders;
            return this;
        }

        /**
         * Builds an instance of {@link FoldersContainingPaperDoc} configured
         * with this builder's values
         *
         * @return new instance of {@link FoldersContainingPaperDoc}
         */
        public FoldersContainingPaperDoc build() {
            return new FoldersContainingPaperDoc(folderSharingPolicyType, folders);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            folderSharingPolicyType,
            folders
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
            FoldersContainingPaperDoc other = (FoldersContainingPaperDoc) obj;
            return ((this.folderSharingPolicyType == other.folderSharingPolicyType) || (this.folderSharingPolicyType != null && this.folderSharingPolicyType.equals(other.folderSharingPolicyType)))
                && ((this.folders == other.folders) || (this.folders != null && this.folders.equals(other.folders)))
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
    static class Serializer extends StructSerializer<FoldersContainingPaperDoc> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FoldersContainingPaperDoc value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.folderSharingPolicyType != null) {
                g.writeFieldName("folder_sharing_policy_type");
                StoneSerializers.nullable(FolderSharingPolicyType.Serializer.INSTANCE).serialize(value.folderSharingPolicyType, g);
            }
            if (value.folders != null) {
                g.writeFieldName("folders");
                StoneSerializers.nullable(StoneSerializers.list(Folder.Serializer.INSTANCE)).serialize(value.folders, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FoldersContainingPaperDoc deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FoldersContainingPaperDoc value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FolderSharingPolicyType f_folderSharingPolicyType = null;
                List<Folder> f_folders = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("folder_sharing_policy_type".equals(field)) {
                        f_folderSharingPolicyType = StoneSerializers.nullable(FolderSharingPolicyType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("folders".equals(field)) {
                        f_folders = StoneSerializers.nullable(StoneSerializers.list(Folder.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FoldersContainingPaperDoc(f_folderSharingPolicyType, f_folders);
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
