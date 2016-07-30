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

public class RelocationArg {
    // struct RelocationArg

    protected final String fromPath;
    protected final String toPath;

    /**
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationArg(String fromPath, String toPath) {
        if (fromPath == null) {
            throw new IllegalArgumentException("Required value for 'fromPath' is null");
        }
        if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", fromPath)) {
            throw new IllegalArgumentException("String 'fromPath' does not match pattern");
        }
        this.fromPath = fromPath;
        if (toPath == null) {
            throw new IllegalArgumentException("Required value for 'toPath' is null");
        }
        if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", toPath)) {
            throw new IllegalArgumentException("String 'toPath' does not match pattern");
        }
        this.toPath = toPath;
    }

    /**
     * Path in the user's Dropbox to be copied or moved.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFromPath() {
        return fromPath;
    }

    /**
     * Path in the user's Dropbox that is the destination.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToPath() {
        return toPath;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            fromPath,
            toPath
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
            RelocationArg other = (RelocationArg) obj;
            return ((this.fromPath == other.fromPath) || (this.fromPath.equals(other.fromPath)))
                && ((this.toPath == other.toPath) || (this.toPath.equals(other.toPath)))
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
    static final class Serializer extends StructSerializer<RelocationArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("from_path");
            StoneSerializers.string().serialize(value.fromPath, g);
            g.writeFieldName("to_path");
            StoneSerializers.string().serialize(value.toPath, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocationArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocationArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_fromPath = null;
                String f_toPath = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("from_path".equals(field)) {
                        f_fromPath = StoneSerializers.string().deserialize(p);
                    }
                    else if ("to_path".equals(field)) {
                        f_toPath = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fromPath == null) {
                    throw new JsonParseException(p, "Required field \"from_path\" missing.");
                }
                if (f_toPath == null) {
                    throw new JsonParseException(p, "Required field \"to_path\" missing.");
                }
                value = new RelocationArg(f_fromPath, f_toPath);
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
