/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

@JsonSerialize(using=ListSharedLinksResult.Serializer.class)
@JsonDeserialize(using=ListSharedLinksResult.Deserializer.class)
public class ListSharedLinksResult {
    // struct ListSharedLinksResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<SharedLinkMetadata> links;
    protected final boolean hasMore;
    protected final String cursor;

    /**
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  Is true if there are additional shared links that have
     *     not been returned yet. Pass the cursor into {@link
     *     DbxUserSharingRequests#listSharedLinks()} to retrieve them.
     * @param cursor  Pass the cursor into {@link
     *     DbxUserSharingRequests#listSharedLinks()} to obtain the additional
     *     links. Cursor is returned only if no path is given or the path is
     *     empty.
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
     *     DbxUserSharingRequests#listSharedLinks()} to retrieve them.
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
     * yet. Pass the cursor into {@link
     * DbxUserSharingRequests#listSharedLinks()} to retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link DbxUserSharingRequests#listSharedLinks()} to
     * obtain the additional links. Cursor is returned only if no path is given
     * or the path is empty.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            links,
            hasMore,
            cursor
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListSharedLinksResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListSharedLinksResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListSharedLinksResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListSharedLinksResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListSharedLinksResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("links", value.links);
            g.writeObjectField("has_more", value.hasMore);
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListSharedLinksResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListSharedLinksResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListSharedLinksResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListSharedLinksResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListSharedLinksResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<SharedLinkMetadata> links = null;
            Boolean hasMore = null;
            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("links".equals(_field)) {
                    expectArrayStart(_p);
                    links = new java.util.ArrayList<SharedLinkMetadata>();
                    while (!isArrayEnd(_p)) {
                        SharedLinkMetadata _x = null;
                        _x = _p.readValueAs(SharedLinkMetadata.class);
                        _p.nextToken();
                        links.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("has_more".equals(_field)) {
                    hasMore = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (links == null) {
                throw new JsonParseException(_p, "Required field \"links\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new ListSharedLinksResult(links, hasMore, cursor);
        }
    }
}
