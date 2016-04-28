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
import java.util.Date;

@JsonSerialize(using=GetCopyReferenceResult.Serializer.class)
@JsonDeserialize(using=GetCopyReferenceResult.Deserializer.class)
public class GetCopyReferenceResult {
    // struct GetCopyReferenceResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final Metadata metadata;
    protected final String copyReference;
    protected final Date expires;

    /**
     *
     * @param metadata  Metadata of the file or folder. Must not be {@code
     *     null}.
     * @param copyReference  A copy reference to the file or folder. Must not be
     *     {@code null}.
     * @param expires  The expiration date of the copy reference. This value is
     *     currently set to be far enough in the future so that expiration is
     *     effectively not an issue. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetCopyReferenceResult(Metadata metadata, String copyReference, Date expires) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (copyReference == null) {
            throw new IllegalArgumentException("Required value for 'copyReference' is null");
        }
        this.copyReference = copyReference;
        if (expires == null) {
            throw new IllegalArgumentException("Required value for 'expires' is null");
        }
        this.expires = com.dropbox.core.util.LangUtil.truncateMillis(expires);
    }

    /**
     * Metadata of the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * A copy reference to the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCopyReference() {
        return copyReference;
    }

    /**
     * The expiration date of the copy reference. This value is currently set to
     * be far enough in the future so that expiration is effectively not an
     * issue.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getExpires() {
        return expires;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            metadata,
            copyReference,
            expires
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
            GetCopyReferenceResult other = (GetCopyReferenceResult) obj;
            return ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
                && ((this.copyReference == other.copyReference) || (this.copyReference.equals(other.copyReference)))
                && ((this.expires == other.expires) || (this.expires.equals(other.expires)))
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

    static final class Serializer extends StructJsonSerializer<GetCopyReferenceResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetCopyReferenceResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetCopyReferenceResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetCopyReferenceResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetCopyReferenceResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("metadata", value.metadata);
            g.writeObjectField("copy_reference", value.copyReference);
            g.writeObjectField("expires", value.expires);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetCopyReferenceResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetCopyReferenceResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetCopyReferenceResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetCopyReferenceResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetCopyReferenceResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Metadata metadata = null;
            String copyReference = null;
            Date expires = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("metadata".equals(_field)) {
                    metadata = _p.readValueAs(Metadata.class);
                    _p.nextToken();
                }
                else if ("copy_reference".equals(_field)) {
                    copyReference = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("expires".equals(_field)) {
                    expires = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (metadata == null) {
                throw new JsonParseException(_p, "Required field \"metadata\" is missing.");
            }
            if (copyReference == null) {
                throw new JsonParseException(_p, "Required field \"copy_reference\" is missing.");
            }
            if (expires == null) {
                throw new JsonParseException(_p, "Required field \"expires\" is missing.");
            }

            return new GetCopyReferenceResult(metadata, copyReference, expires);
        }
    }
}
