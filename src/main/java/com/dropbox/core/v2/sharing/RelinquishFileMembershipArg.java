/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class RelinquishFileMembershipArg {
    // struct RelinquishFileMembershipArg

    protected final String file;

    /**
     *
     * @param file  The path or id for the file. Must have length of at least 1,
     *     match pattern "{@code ((/|id:).*|nspath:[^:]*:[^:]*)}", and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelinquishFileMembershipArg(String file) {
        if (file == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (file.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*|nspath:[^:]*:[^:]*)", file)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = file;
    }

    /**
     * The path or id for the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFile() {
        return file;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            file
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
            RelinquishFileMembershipArg other = (RelinquishFileMembershipArg) obj;
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
    static final class Serializer extends StructSerializer<RelinquishFileMembershipArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelinquishFileMembershipArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
        public RelinquishFileMembershipArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelinquishFileMembershipArg value;
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
                value = new RelinquishFileMembershipArg(f_file);
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
