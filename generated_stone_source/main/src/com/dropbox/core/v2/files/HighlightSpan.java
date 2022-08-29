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

public class HighlightSpan {
    // struct files.HighlightSpan (files.stone)

    protected final String highlightStr;
    protected final boolean isHighlighted;

    /**
     *
     * @param highlightStr  String to be determined whether it should be
     *     highlighted or not. Must not be {@code null}.
     * @param isHighlighted  The string should be highlighted or not.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public HighlightSpan(String highlightStr, boolean isHighlighted) {
        if (highlightStr == null) {
            throw new IllegalArgumentException("Required value for 'highlightStr' is null");
        }
        this.highlightStr = highlightStr;
        this.isHighlighted = isHighlighted;
    }

    /**
     * String to be determined whether it should be highlighted or not.
     *
     * @return value for this field, never {@code null}.
     */
    public String getHighlightStr() {
        return highlightStr;
    }

    /**
     * The string should be highlighted or not.
     *
     * @return value for this field.
     */
    public boolean getIsHighlighted() {
        return isHighlighted;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            highlightStr,
            isHighlighted
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
            HighlightSpan other = (HighlightSpan) obj;
            return ((this.highlightStr == other.highlightStr) || (this.highlightStr.equals(other.highlightStr)))
                && (this.isHighlighted == other.isHighlighted)
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
    static class Serializer extends StructSerializer<HighlightSpan> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(HighlightSpan value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("highlight_str");
            StoneSerializers.string().serialize(value.highlightStr, g);
            g.writeFieldName("is_highlighted");
            StoneSerializers.boolean_().serialize(value.isHighlighted, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public HighlightSpan deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            HighlightSpan value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_highlightStr = null;
                Boolean f_isHighlighted = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("highlight_str".equals(field)) {
                        f_highlightStr = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_highlighted".equals(field)) {
                        f_isHighlighted = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_highlightStr == null) {
                    throw new JsonParseException(p, "Required field \"highlight_str\" missing.");
                }
                if (f_isHighlighted == null) {
                    throw new JsonParseException(p, "Required field \"is_highlighted\" missing.");
                }
                value = new HighlightSpan(f_highlightStr, f_isHighlighted);
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
