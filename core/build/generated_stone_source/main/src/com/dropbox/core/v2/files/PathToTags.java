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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

public class PathToTags {
    // struct files.PathToTags (file_tagging.stone)

    protected final String path;
    protected final List<TagObject> tags;

    /**
     *
     * @param path  Path of the item. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param tags  Tags assigned to this item. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathToTags(@Nonnull String path, @Nonnull List<TagObject> tags) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (tags == null) {
            throw new IllegalArgumentException("Required value for 'tags' is null");
        }
        for (TagObject x : tags) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'tags' is null");
            }
        }
        this.tags = tags;
    }

    /**
     * Path of the item.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Tags assigned to this item.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<TagObject> getTags() {
        return tags;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            tags
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
            PathToTags other = (PathToTags) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.tags == other.tags) || (this.tags.equals(other.tags)))
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
    static class Serializer extends StructSerializer<PathToTags> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PathToTags value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("tags");
            StoneSerializers.list(TagObject.Serializer.INSTANCE).serialize(value.tags, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PathToTags deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PathToTags value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                List<TagObject> f_tags = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("tags".equals(field)) {
                        f_tags = StoneSerializers.list(TagObject.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_tags == null) {
                    throw new JsonParseException(p, "Required field \"tags\" missing.");
                }
                value = new PathToTags(f_path, f_tags);
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
