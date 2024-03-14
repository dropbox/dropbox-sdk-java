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

/**
 * Arguments of {@link DbxUserSharingRequests#getFileMetadataBatch(List,List)}.
 */
class GetFileMetadataBatchArg {
    // struct sharing.GetFileMetadataBatchArg (sharing_files.stone)

    protected final List<String> files;
    protected final List<FileAction> actions;

    /**
     * Arguments of {@link
     * DbxUserSharingRequests#getFileMetadataBatch(List,List)}.
     *
     * @param files  The files to query. Must contain at most 100 items, not
     *     contain a {@code null} item, and not be {@code null}.
     * @param actions  A list of `FileAction`s corresponding to
     *     `FilePermission`s that should appear in the  response's {@link
     *     SharedFileMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the file. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetFileMetadataBatchArg(List<String> files, List<FileAction> actions) {
        if (files == null) {
            throw new IllegalArgumentException("Required value for 'files' is null");
        }
        if (files.size() > 100) {
            throw new IllegalArgumentException("List 'files' has more than 100 items");
        }
        for (String x : files) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'files' is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'files' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", x)) {
                throw new IllegalArgumentException("Stringan item in list 'files' does not match pattern");
            }
        }
        this.files = files;
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
     * Arguments of {@link
     * DbxUserSharingRequests#getFileMetadataBatch(List,List)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param files  The files to query. Must contain at most 100 items, not
     *     contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetFileMetadataBatchArg(List<String> files) {
        this(files, null);
    }

    /**
     * The files to query.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getFiles() {
        return files;
    }

    /**
     * A list of `FileAction`s corresponding to `FilePermission`s that should
     * appear in the  response's {@link SharedFileMetadata#getPermissions} field
     * describing the actions the  authenticated user can perform on the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<FileAction> getActions() {
        return actions;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            files,
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
            GetFileMetadataBatchArg other = (GetFileMetadataBatchArg) obj;
            return ((this.files == other.files) || (this.files.equals(other.files)))
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
    static class Serializer extends StructSerializer<GetFileMetadataBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetFileMetadataBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("files");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.files, g);
            if (value.actions != null) {
                g.writeFieldName("actions");
                StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).serialize(value.actions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetFileMetadataBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetFileMetadataBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_files = null;
                List<FileAction> f_actions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("files".equals(field)) {
                        f_files = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("actions".equals(field)) {
                        f_actions = StoneSerializers.nullable(StoneSerializers.list(FileAction.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_files == null) {
                    throw new JsonParseException(p, "Required field \"files\" missing.");
                }
                value = new GetFileMetadataBatchArg(f_files, f_actions);
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
