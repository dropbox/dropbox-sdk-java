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

public class DeleteArg {
    // struct files.DeleteArg (files.stone)

    @Nonnull
    protected final String path;
    @Nullable
    protected final String parentRev;

    /**
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     * @param parentRev  Perform delete if given "rev" matches the existing
     *     file's latest "rev". This field does not support deleting a folder.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteArg(@Nonnull String path, @Nullable String parentRev) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (parentRev != null) {
            if (parentRev.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", parentRev)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        this.parentRev = parentRev;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteArg(@Nonnull String path) {
        this(path, null);
    }

    /**
     * Path in the user's Dropbox to delete.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Perform delete if given "rev" matches the existing file's latest "rev".
     * This field does not support deleting a folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentRev() {
        return parentRev;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            parentRev
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
            DeleteArg other = (DeleteArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.parentRev == other.parentRev) || (this.parentRev != null && this.parentRev.equals(other.parentRev)))
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
    static class Serializer extends StructSerializer<DeleteArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (value.parentRev != null) {
                g.writeFieldName("parent_rev");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentRev, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                String f_parentRev = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("parent_rev".equals(field)) {
                        f_parentRev = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new DeleteArg(f_path, f_parentRev);
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
