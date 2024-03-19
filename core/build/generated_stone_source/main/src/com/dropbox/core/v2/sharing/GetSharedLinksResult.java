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
import java.util.List;

import javax.annotation.Nonnull;

public class GetSharedLinksResult {
    // struct sharing.GetSharedLinksResult (shared_links.stone)

    @Nonnull
    protected final List<LinkMetadata> links;

    /**
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinksResult(@Nonnull List<LinkMetadata> links) {
        if (links == null) {
            throw new IllegalArgumentException("Required value for 'links' is null");
        }
        for (LinkMetadata x : links) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'links' is null");
            }
        }
        this.links = links;
    }

    /**
     * Shared links applicable to the path argument.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<LinkMetadata> getLinks() {
        return links;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            links
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
            GetSharedLinksResult other = (GetSharedLinksResult) obj;
            return (this.links == other.links) || (this.links.equals(other.links));
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
    static class Serializer extends StructSerializer<GetSharedLinksResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetSharedLinksResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("links");
            StoneSerializers.list(LinkMetadata.Serializer.INSTANCE).serialize(value.links, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetSharedLinksResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetSharedLinksResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<LinkMetadata> f_links = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("links".equals(field)) {
                        f_links = StoneSerializers.list(LinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_links == null) {
                    throw new JsonParseException(p, "Required field \"links\" missing.");
                }
                value = new GetSharedLinksResult(f_links);
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
