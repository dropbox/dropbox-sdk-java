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

class UploadSessionStartArg {
    // struct UploadSessionStartArg

    protected final boolean close;

    /**
     *
     * @param close  If true, current session will be closed. You cannot do
     *     {@link DbxUserFilesRequests#uploadSessionAppend(String,long)} any
     *     more to current session.
     */
    public UploadSessionStartArg(boolean close) {
        this.close = close;
    }

    /**
     * The default values for unset fields will be used.
     */
    public UploadSessionStartArg() {
        this(false);
    }

    /**
     * If true, current session will be closed. You cannot do {@link
     * DbxUserFilesRequests#uploadSessionAppend(String,long)} any more to
     * current session
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getClose() {
        return close;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            close
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
            UploadSessionStartArg other = (UploadSessionStartArg) obj;
            return this.close == other.close;
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
    static final class Serializer extends StructSerializer<UploadSessionStartArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("close");
            StoneSerializers.boolean_().serialize(value.close, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionStartArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionStartArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_close = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("close".equals(field)) {
                        f_close = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new UploadSessionStartArg(f_close);
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
