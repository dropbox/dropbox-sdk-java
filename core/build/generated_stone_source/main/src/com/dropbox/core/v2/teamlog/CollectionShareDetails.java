/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Shared album.
 */
public class CollectionShareDetails {
    // struct team_log.CollectionShareDetails (team_log_generated.stone)

    @Nonnull
    protected final String albumName;

    /**
     * Shared album.
     *
     * @param albumName  Album name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CollectionShareDetails(@Nonnull String albumName) {
        if (albumName == null) {
            throw new IllegalArgumentException("Required value for 'albumName' is null");
        }
        this.albumName = albumName;
    }

    /**
     * Album name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAlbumName() {
        return albumName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            albumName
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
            CollectionShareDetails other = (CollectionShareDetails) obj;
            return (this.albumName == other.albumName) || (this.albumName.equals(other.albumName));
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
    static class Serializer extends StructSerializer<CollectionShareDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CollectionShareDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("album_name");
            StoneSerializers.string().serialize(value.albumName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CollectionShareDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CollectionShareDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_albumName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("album_name".equals(field)) {
                        f_albumName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_albumName == null) {
                    throw new JsonParseException(p, "Required field \"album_name\" missing.");
                }
                value = new CollectionShareDetails(f_albumName);
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
