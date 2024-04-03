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
import javax.annotation.Nullable;

public class ListSharedLinksResult {
    // struct sharing.ListSharedLinksResult (shared_links.stone)

    @Nonnull
    protected final List<SharedLinkMetadata> links;
    protected final boolean hasMore;
    @Nullable
    protected final String cursor;

    /**
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  Is true if there are additional shared links that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listSharedLinks} to retrieve them.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserSharingRequests#listSharedLinks} to obtain the additional
     *     links. Cursor is returned only if no path is given.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksResult(@Nonnull List<SharedLinkMetadata> links, boolean hasMore, @Nullable String cursor) {
        if (links == null) {
            throw new IllegalArgumentException("Required value for 'links' is null");
        }
        for (SharedLinkMetadata x : links) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'links' is null");
            }
        }
        this.links = links;
        this.hasMore = hasMore;
        this.cursor = cursor;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  Is true if there are additional shared links that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listSharedLinks} to retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksResult(@Nonnull List<SharedLinkMetadata> links, boolean hasMore) {
        this(links, hasMore, null);
    }

    /**
     * Shared links applicable to the path argument.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<SharedLinkMetadata> getLinks() {
        return links;
    }

    /**
     * Is true if there are additional shared links that have not been returned
     * yet. Pass the cursor into {@link DbxUserSharingRequests#listSharedLinks}
     * to retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link DbxUserSharingRequests#listSharedLinks} to
     * obtain the additional links. Cursor is returned only if no path is given.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.links,
            this.hasMore,
            this.cursor
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
            ListSharedLinksResult other = (ListSharedLinksResult) obj;
            return ((this.links == other.links) || (this.links.equals(other.links)))
                && (this.hasMore == other.hasMore)
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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
    static class Serializer extends StructSerializer<ListSharedLinksResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListSharedLinksResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("links");
            StoneSerializers.list(SharedLinkMetadata.Serializer.INSTANCE).serialize(value.links, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListSharedLinksResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListSharedLinksResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<SharedLinkMetadata> f_links = null;
                Boolean f_hasMore = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("links".equals(field)) {
                        f_links = StoneSerializers.list(SharedLinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_links == null) {
                    throw new JsonParseException(p, "Required field \"links\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListSharedLinksResult(f_links, f_hasMore, f_cursor);
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
