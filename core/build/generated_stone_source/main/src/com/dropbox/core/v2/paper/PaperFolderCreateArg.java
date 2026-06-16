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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class PaperFolderCreateArg {
    // struct paper.PaperFolderCreateArg (paper.stone)

    @Nonnull
    protected final String name;
    @Nullable
    protected final String parentFolderId;
    @Nullable
    protected final Boolean isTeamFolder;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The name of the new Paper folder. Must not be {@code null}.
     * @param parentFolderId  The encrypted Paper folder Id where the new Paper
     *     folder should be created. The API user has to have write access to
     *     this folder or error is thrown. If not supplied, the new folder will
     *     be created at top level.
     * @param isTeamFolder  Whether the folder to be created should be a team
     *     folder. This value will be ignored if parent_folder_id is supplied,
     *     as the new folder will inherit the type (private or team folder) from
     *     its parent. We will by default create a top-level private folder if
     *     both parent_folder_id and is_team_folder are not supplied.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperFolderCreateArg(@Nonnull String name, @Nullable String parentFolderId, @Nullable Boolean isTeamFolder) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        this.parentFolderId = parentFolderId;
        this.isTeamFolder = isTeamFolder;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The name of the new Paper folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperFolderCreateArg(@Nonnull String name) {
        this(name, null, null);
    }

    /**
     * The name of the new Paper folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * The encrypted Paper folder Id where the new Paper folder should be
     * created. The API user has to have write access to this folder or error is
     * thrown. If not supplied, the new folder will be created at top level.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentFolderId() {
        return parentFolderId;
    }

    /**
     * Whether the folder to be created should be a team folder. This value will
     * be ignored if parent_folder_id is supplied, as the new folder will
     * inherit the type (private or team folder) from its parent. We will by
     * default create a top-level private folder if both parent_folder_id and
     * is_team_folder are not supplied.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Boolean getIsTeamFolder() {
        return isTeamFolder;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The name of the new Paper folder. Must not be {@code null}.
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
     * Builder for {@link PaperFolderCreateArg}.
     */
    public static class Builder {
        protected final String name;

        protected String parentFolderId;
        protected Boolean isTeamFolder;

        protected Builder(String name) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            this.parentFolderId = null;
            this.isTeamFolder = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentFolderId  The encrypted Paper folder Id where the new
         *     Paper folder should be created. The API user has to have write
         *     access to this folder or error is thrown. If not supplied, the
         *     new folder will be created at top level.
         *
         * @return this builder
         */
        public Builder withParentFolderId(String parentFolderId) {
            this.parentFolderId = parentFolderId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isTeamFolder  Whether the folder to be created should be a
         *     team folder. This value will be ignored if parent_folder_id is
         *     supplied, as the new folder will inherit the type (private or
         *     team folder) from its parent. We will by default create a
         *     top-level private folder if both parent_folder_id and
         *     is_team_folder are not supplied.
         *
         * @return this builder
         */
        public Builder withIsTeamFolder(Boolean isTeamFolder) {
            this.isTeamFolder = isTeamFolder;
            return this;
        }

        /**
         * Builds an instance of {@link PaperFolderCreateArg} configured with
         * this builder's values
         *
         * @return new instance of {@link PaperFolderCreateArg}
         */
        public PaperFolderCreateArg build() {
            return new PaperFolderCreateArg(name, parentFolderId, isTeamFolder);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.name,
            this.parentFolderId,
            this.isTeamFolder
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
            PaperFolderCreateArg other = (PaperFolderCreateArg) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.parentFolderId == other.parentFolderId) || (this.parentFolderId != null && this.parentFolderId.equals(other.parentFolderId)))
                && ((this.isTeamFolder == other.isTeamFolder) || (this.isTeamFolder != null && this.isTeamFolder.equals(other.isTeamFolder)))
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
    static class Serializer extends StructSerializer<PaperFolderCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperFolderCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (value.parentFolderId != null) {
                g.writeFieldName("parent_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentFolderId, g);
            }
            if (value.isTeamFolder != null) {
                g.writeFieldName("is_team_folder");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isTeamFolder, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperFolderCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperFolderCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_parentFolderId = null;
                Boolean f_isTeamFolder = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("parent_folder_id".equals(field)) {
                        f_parentFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_team_folder".equals(field)) {
                        f_isTeamFolder = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new PaperFolderCreateArg(f_name, f_parentFolderId, f_isTeamFolder);
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
