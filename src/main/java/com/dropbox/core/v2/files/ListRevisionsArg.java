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

class ListRevisionsArg {
    // struct ListRevisionsArg

    protected final String path;
    protected final long limit;

    /**
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param limit  The maximum number of revision entries returned. Must be
     *     greater than or equal to 1 and be less than or equal to 100.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path, long limit) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 100L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(String path) {
        this(path, 10L);
    }

    /**
     * The path to the file you want to see the revisions of.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The maximum number of revision entries returned.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     10L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            limit
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
            ListRevisionsArg other = (ListRevisionsArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.limit == other.limit)
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
    static final class Serializer extends StructSerializer<ListRevisionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListRevisionsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("limit");
            StoneSerializers.uInt64().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListRevisionsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListRevisionsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                Long f_limit = 10L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ListRevisionsArg(f_path, f_limit);
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
