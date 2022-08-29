/* DO NOT EDIT */
/* This file was generated from file_tagging.stone */

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
import java.util.List;

class GetTagsArg {
    // struct files.GetTagsArg (file_tagging.stone)

    protected final List<String> paths;

    /**
     *
     * @param paths  Path to the items. Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTagsArg(List<String> paths) {
        if (paths == null) {
            throw new IllegalArgumentException("Required value for 'paths' is null");
        }
        for (String x : paths) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'paths' is null");
            }
            if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", x)) {
                throw new IllegalArgumentException("Stringan item in list 'paths' does not match pattern");
            }
        }
        this.paths = paths;
    }

    /**
     * Path to the items.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getPaths() {
        return paths;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            paths
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
            GetTagsArg other = (GetTagsArg) obj;
            return (this.paths == other.paths) || (this.paths.equals(other.paths));
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
    static class Serializer extends StructSerializer<GetTagsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTagsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("paths");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.paths, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTagsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTagsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_paths = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("paths".equals(field)) {
                        f_paths = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_paths == null) {
                    throw new JsonParseException(p, "Required field \"paths\" missing.");
                }
                value = new GetTagsArg(f_paths);
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
