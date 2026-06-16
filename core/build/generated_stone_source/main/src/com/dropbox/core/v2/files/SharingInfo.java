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

/**
 * Sharing info for a file or folder.
 */
public class SharingInfo {
    // struct files.SharingInfo (files.stone)

    protected final boolean readOnly;

    /**
     * Sharing info for a file or folder.
     *
     * @param readOnly  True if the file or folder is inside a read-only shared
     *     folder.
     */
    public SharingInfo(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * True if the file or folder is inside a read-only shared folder.
     *
     * @return value for this field.
     */
    public boolean getReadOnly() {
        return readOnly;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.readOnly
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
            SharingInfo other = (SharingInfo) obj;
            return this.readOnly == other.readOnly;
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
    private static class Serializer extends StructSerializer<SharingInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("read_only");
            StoneSerializers.boolean_().serialize(value.readOnly, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_readOnly = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("read_only".equals(field)) {
                        f_readOnly = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_readOnly == null) {
                    throw new JsonParseException(p, "Required field \"read_only\" missing.");
                }
                value = new SharingInfo(f_readOnly);
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
