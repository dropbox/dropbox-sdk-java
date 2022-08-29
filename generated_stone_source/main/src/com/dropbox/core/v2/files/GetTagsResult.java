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

public class GetTagsResult {
    // struct files.GetTagsResult (file_tagging.stone)

    protected final List<PathToTags> pathsToTags;

    /**
     *
     * @param pathsToTags  List of paths and their corresponding tags. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTagsResult(List<PathToTags> pathsToTags) {
        if (pathsToTags == null) {
            throw new IllegalArgumentException("Required value for 'pathsToTags' is null");
        }
        for (PathToTags x : pathsToTags) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'pathsToTags' is null");
            }
        }
        this.pathsToTags = pathsToTags;
    }

    /**
     * List of paths and their corresponding tags.
     *
     * @return value for this field, never {@code null}.
     */
    public List<PathToTags> getPathsToTags() {
        return pathsToTags;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            pathsToTags
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
            GetTagsResult other = (GetTagsResult) obj;
            return (this.pathsToTags == other.pathsToTags) || (this.pathsToTags.equals(other.pathsToTags));
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
    static class Serializer extends StructSerializer<GetTagsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTagsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("paths_to_tags");
            StoneSerializers.list(PathToTags.Serializer.INSTANCE).serialize(value.pathsToTags, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetTagsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetTagsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<PathToTags> f_pathsToTags = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("paths_to_tags".equals(field)) {
                        f_pathsToTags = StoneSerializers.list(PathToTags.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_pathsToTags == null) {
                    throw new JsonParseException(p, "Required field \"paths_to_tags\" missing.");
                }
                value = new GetTagsResult(f_pathsToTags);
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
