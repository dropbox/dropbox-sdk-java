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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Arguments for {@link DbxUserSharingRequests#unshareFile(String)}.
 */
class UnshareFileArg {
    // struct sharing.UnshareFileArg (sharing_files.stone)

    @Nonnull
    protected final String file;

    /**
     * Arguments for {@link DbxUserSharingRequests#unshareFile(String)}.
     *
     * @param file  The file to unshare. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UnshareFileArg(@Nonnull String file) {
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
    }

    /**
     * The file to unshare.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFile() {
        return file;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            file
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
            UnshareFileArg other = (UnshareFileArg) obj;
            return (this.file == other.file) || (this.file.equals(other.file));
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
    static class Serializer extends StructSerializer<UnshareFileArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UnshareFileArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("file");
            StoneSerializers.string().serialize(value.file, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UnshareFileArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UnshareFileArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_file = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("file".equals(field)) {
                        f_file = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_file == null) {
                    throw new JsonParseException(p, "Required field \"file\" missing.");
                }
                value = new UnshareFileArg(f_file);
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
