/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class GetSharedLinksArg {
    // struct sharing.GetSharedLinksArg (shared_links.stone)

    @Nullable
    protected final String path;

    /**
     *
     * @param path  See {@link DbxUserSharingRequests#getSharedLinks(String)}
     *     description.
     */
    public GetSharedLinksArg(@Nullable String path) {
        this.path = path;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public GetSharedLinksArg() {
        this(null);
    }

    /**
     * See {@link DbxUserSharingRequests#getSharedLinks(String)} description.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path
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
            GetSharedLinksArg other = (GetSharedLinksArg) obj;
            return (this.path == other.path) || (this.path != null && this.path.equals(other.path));
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
    static class Serializer extends StructSerializer<GetSharedLinksArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetSharedLinksArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetSharedLinksArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetSharedLinksArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new GetSharedLinksArg(f_path);
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
