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

public class GetSharedLinksResult {
    // struct GetSharedLinksResult

    private final List<LinkMetadata> links;

    /**
     *
     * @param links  Shared links applicable to the path argument. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinksResult(List<LinkMetadata> links) {
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
    public List<LinkMetadata> getLinks() {
        return links;
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
            GetSharedLinksResult other = (GetSharedLinksResult) obj;
            return (this.links == other.links) || (this.links.equals(other.links));
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

    public static GetSharedLinksResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetSharedLinksResult> _JSON_WRITER = new JsonWriter<GetSharedLinksResult>() {
        public final void write(GetSharedLinksResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GetSharedLinksResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetSharedLinksResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("links");
            g.writeStartArray();
            for (LinkMetadata item: x.links) {
                if (item != null) {
                    LinkMetadata._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GetSharedLinksResult> _JSON_READER = new JsonReader<GetSharedLinksResult>() {
        public final GetSharedLinksResult read(JsonParser parser) throws IOException, JsonReadException {
            GetSharedLinksResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetSharedLinksResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<LinkMetadata> links = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("links".equals(fieldName)) {
                    links = JsonArrayReader.mk(LinkMetadata._JSON_READER)
                        .readField(parser, "links", links);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (links == null) {
                throw new JsonReadException("Required field \"links\" is missing.", parser.getTokenLocation());
            }
            return new GetSharedLinksResult(links);
        }
    };
}
