/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class RestoreArg {
    // struct RestoreArg

    protected final String path;
    protected final String rev;

    /**
     *
     * @param path  The path to the file you want to restore. Must match pattern
     *     "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param rev  The revision to restore for the file. Must have length of at
     *     least 9, match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RestoreArg(String path, String rev) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (rev == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (rev.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = rev;
    }

    /**
     * The path to the file you want to restore.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The revision to restore for the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getRev() {
        return rev;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            rev
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
            RestoreArg other = (RestoreArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
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
    static final class Serializer extends StructSerializer<RestoreArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RestoreArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("rev");
            StoneSerializers.string().serialize(value.rev, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RestoreArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RestoreArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                String f_rev = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("rev".equals(field)) {
                        f_rev = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_rev == null) {
                    throw new JsonParseException(p, "Required field \"rev\" missing.");
                }
                value = new RestoreArg(f_path, f_rev);
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
