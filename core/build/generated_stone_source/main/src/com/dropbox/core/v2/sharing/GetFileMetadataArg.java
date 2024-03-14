/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Arguments of {@link DbxUserSharingRequests#getFileMetadata(String,List)}.
 */
class GetFileMetadataArg {
    // struct sharing.GetFileMetadataArg (sharing_files.stone)

    protected final String file;
    protected final List<FileAction> actions;

    /**
     * Arguments of {@link DbxUserSharingRequests#getFileMetadata(String,List)}.
     *
     * @param file  The file to query. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     * @param actions  A list of `FileAction`s corresponding to
     *     `FilePermission`s that should appear in the  response's {@link
     *     SharedFileMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the file. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetFileMetadataArg(@Nonnull String file, @Nullable List<FileAction> actions) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
        if (actions != null) {
            for (FileAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        this.actions = actions;
    }

    /**
     * Arguments of {@link DbxUserSharingRequests#getFileMetadata(String,List)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param file  The file to query. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetFileMetadataArg(@Nonnull String file) {
        this(file, null);
    }

    /**
     * The file to query.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFile() {
        return file;
    }

    /**
     * A list of `FileAction`s corresponding to `FilePermission`s that should
     * appear in the  response's {@link SharedFileMetadata#getPermissions} field
     * describing the actions the  authenticated user can perform on the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<FileAction> getActions() {
        return actions;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            file,
            actions
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
            GetFileMetadataArg other = (GetFileMetadataArg) obj;
            return ((this.file == other.file) || (this.file.equals(other.file)))
                && ((this.actions == other.actions) || (this.actions != null && this.actions.equals(other.actions)))
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
    static class Serializer extends StructSerializer<GetFileMetadataArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetFileMetadataArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetFileMetadataArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetFileMetadataArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                List<FileAction> f_actions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                value = new GetFileMetadataArg(f_file, f_actions);
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
