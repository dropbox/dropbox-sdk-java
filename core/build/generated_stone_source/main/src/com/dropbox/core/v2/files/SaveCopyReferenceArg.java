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

class SaveCopyReferenceArg {
    // struct files.SaveCopyReferenceArg (files.stone)

    protected final String copyReference;
    protected final String path;

    /**
     *
     * @param copyReference  A copy reference returned by {@link
     *     DbxUserFilesRequests#copyReferenceGet(String)}. Must not be {@code
     *     null}.
     * @param path  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SaveCopyReferenceArg(@javax.annotation.Nonnull String copyReference, @javax.annotation.Nonnull String path) {
        if (copyReference == null) {
            throw new IllegalArgumentException("Required value for 'copyReference' is null");
        }
        this.copyReference = copyReference;
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
    }

    /**
     * A copy reference returned by {@link
     * DbxUserFilesRequests#copyReferenceGet(String)}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getCopyReference() {
        return copyReference;
    }

    /**
     * Path in the user's Dropbox that is the destination.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            copyReference,
            path
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
            SaveCopyReferenceArg other = (SaveCopyReferenceArg) obj;
            return ((this.copyReference == other.copyReference) || (this.copyReference.equals(other.copyReference)))
                && ((this.path == other.path) || (this.path.equals(other.path)))
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
    static class Serializer extends StructSerializer<SaveCopyReferenceArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SaveCopyReferenceArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("copy_reference");
            StoneSerializers.string().serialize(value.copyReference, g);
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SaveCopyReferenceArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SaveCopyReferenceArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_copyReference = null;
                String f_path = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("copy_reference".equals(field)) {
                        f_copyReference = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_copyReference == null) {
                    throw new JsonParseException(p, "Required field \"copy_reference\" missing.");
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new SaveCopyReferenceArg(f_copyReference, f_path);
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
