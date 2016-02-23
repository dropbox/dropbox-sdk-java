/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class ListSharedLinksResult {
    // struct ListSharedLinksResult

    private final List<SharedLinkMetadata> links;
    private final boolean hasMore;
    private final String cursor;

    /**
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  Is true if there are additional shared links that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxSharing#listSharedLinks()} to retrieve them.
     * @param cursor  Pass the cursor into {@link DbxSharing#listSharedLinks()}
     *     to obtain the additional links. Cursor is returned only if no path is
     *     given or the path is empty.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksResult(List<SharedLinkMetadata> links, boolean hasMore, String cursor) {
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
     * The default values for unset fields will be used.
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  Is true if there are additional shared links that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxSharing#listSharedLinks()} to retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListSharedLinksResult(List<SharedLinkMetadata> links, boolean hasMore) {
        this(links, hasMore, null);
    }

    /**
     * Shared links applicable to the path argument.
     *
     * @return value for this field, never {@code null}.
     */
    public List<SharedLinkMetadata> getLinks() {
        return links;
    }

    /**
     * Is true if there are additional shared links that have not been returned
     * yet. Pass the cursor into {@link DbxSharing#listSharedLinks()} to
     * retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link DbxSharing#listSharedLinks()} to obtain the
     * additional links. Cursor is returned only if no path is given or the path
     * is empty.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListSharedLinksResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListSharedLinksResult> _JSON_WRITER = new JsonWriter<ListSharedLinksResult>() {
        public final void write(ListSharedLinksResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListSharedLinksResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListSharedLinksResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("links");
            g.writeStartArray();
            for (SharedLinkMetadata item: x.links) {
                if (item != null) {
                    SharedLinkMetadata._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("has_more");
            g.writeBoolean(x.hasMore);
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListSharedLinksResult> _JSON_READER = new JsonReader<ListSharedLinksResult>() {
        public final ListSharedLinksResult read(JsonParser parser) throws IOException, JsonReadException {
            ListSharedLinksResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListSharedLinksResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<SharedLinkMetadata> links = null;
            Boolean hasMore = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("links".equals(fieldName)) {
                    links = JsonArrayReader.mk(SharedLinkMetadata._JSON_READER)
                        .readField(parser, "links", links);
                }
                else if ("has_more".equals(fieldName)) {
                    hasMore = JsonReader.BooleanReader
                        .readField(parser, "has_more", hasMore);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (links == null) {
                throw new JsonReadException("Required field \"links\" is missing.", parser.getTokenLocation());
            }
            if (hasMore == null) {
                throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
            }
            return new ListSharedLinksResult(links, hasMore, cursor);
        }
    };
}
