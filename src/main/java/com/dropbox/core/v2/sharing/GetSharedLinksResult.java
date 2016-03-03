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

@JsonSerialize(using=GetSharedLinksResult.Serializer.class)
@JsonDeserialize(using=GetSharedLinksResult.Deserializer.class)
public class GetSharedLinksResult {
    // struct GetSharedLinksResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<LinkMetadata> links;

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
        int hash = java.util.Arrays.hashCode(new Object [] {
            links
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
            GetSharedLinksResult other = (GetSharedLinksResult) obj;
            return (this.links == other.links) || (this.links.equals(other.links));
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

    static final class Serializer extends StructJsonSerializer<GetSharedLinksResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetSharedLinksResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetSharedLinksResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetSharedLinksResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetSharedLinksResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("links", value.links);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetSharedLinksResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetSharedLinksResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetSharedLinksResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetSharedLinksResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetSharedLinksResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<LinkMetadata> links = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("links".equals(_field)) {
                    expectArrayStart(_p);
                    links = new java.util.ArrayList<LinkMetadata>();
                    while (!isArrayEnd(_p)) {
                        LinkMetadata _x = null;
                        _x = _p.readValueAs(LinkMetadata.class);
                        _p.nextToken();
                        links.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (links == null) {
                throw new JsonParseException(_p, "Required field \"links\" is missing.");
            }

            return new GetSharedLinksResult(links);
        }
    }
}
