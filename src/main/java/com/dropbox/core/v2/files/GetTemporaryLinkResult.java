/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

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

@JsonSerialize(using=GetTemporaryLinkResult.Serializer.class)
@JsonDeserialize(using=GetTemporaryLinkResult.Deserializer.class)
public class GetTemporaryLinkResult {
    // struct GetTemporaryLinkResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final FileMetadata metadata;
    protected final String link;

    /**
     *
     * @param metadata  Metadata of the file. Must not be {@code null}.
     * @param link  The temporary link which can be used to stream content the
     *     file. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryLinkResult(FileMetadata metadata, String link) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (link == null) {
            throw new IllegalArgumentException("Required value for 'link' is null");
        }
        this.link = link;
    }

    /**
     * Metadata of the file.
     *
     * @return value for this field, never {@code null}.
     */
    public FileMetadata getMetadata() {
        return metadata;
    }

    /**
     * The temporary link which can be used to stream content the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getLink() {
        return link;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            metadata,
            link
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
            GetTemporaryLinkResult other = (GetTemporaryLinkResult) obj;
            return ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
                && ((this.link == other.link) || (this.link.equals(other.link)))
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

    static final class Serializer extends StructJsonSerializer<GetTemporaryLinkResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetTemporaryLinkResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetTemporaryLinkResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetTemporaryLinkResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetTemporaryLinkResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("metadata", value.metadata);
            g.writeObjectField("link", value.link);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetTemporaryLinkResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetTemporaryLinkResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetTemporaryLinkResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetTemporaryLinkResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetTemporaryLinkResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            FileMetadata metadata = null;
            String link = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("metadata".equals(_field)) {
                    metadata = _p.readValueAs(FileMetadata.class);
                    _p.nextToken();
                }
                else if ("link".equals(_field)) {
                    link = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (metadata == null) {
                throw new JsonParseException(_p, "Required field \"metadata\" is missing.");
            }
            if (link == null) {
                throw new JsonParseException(_p, "Required field \"link\" is missing.");
            }

            return new GetTemporaryLinkResult(metadata, link);
        }
    }
}
