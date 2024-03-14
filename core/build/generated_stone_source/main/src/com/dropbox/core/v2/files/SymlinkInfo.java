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

public class SymlinkInfo {
    // struct files.SymlinkInfo (files.stone)

    protected final String target;

    /**
     *
     * @param target  The target this symlink points to. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SymlinkInfo(String target) {
        if (target == null) {
            throw new IllegalArgumentException("Required value for 'target' is null");
        }
        this.target = target;
    }

    /**
     * The target this symlink points to.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTarget() {
        return target;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            target
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
            SymlinkInfo other = (SymlinkInfo) obj;
            return (this.target == other.target) || (this.target.equals(other.target));
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
    static class Serializer extends StructSerializer<SymlinkInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SymlinkInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("target");
            StoneSerializers.string().serialize(value.target, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SymlinkInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SymlinkInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_target = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("target".equals(field)) {
                        f_target = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_target == null) {
                    throw new JsonParseException(p, "Required field \"target\" missing.");
                }
                value = new SymlinkInfo(f_target);
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
