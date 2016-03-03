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
import java.util.List;

@JsonSerialize(using=ListRevisionsResult.Serializer.class)
@JsonDeserialize(using=ListRevisionsResult.Deserializer.class)
public class ListRevisionsResult {
    // struct ListRevisionsResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final boolean isDeleted;
    protected final List<FileMetadata> entries;

    /**
     *
     * @param isDeleted  If the file is deleted.
     * @param entries  The revisions for the file. Only non-delete revisions
     *     will show up here. Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult(boolean isDeleted, List<FileMetadata> entries) {
        this.isDeleted = isDeleted;
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (FileMetadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
    }

    /**
     * If the file is deleted.
     *
     * @return value for this field.
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * The revisions for the file. Only non-delete revisions will show up here.
     *
     * @return value for this field, never {@code null}.
     */
    public List<FileMetadata> getEntries() {
        return entries;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            isDeleted,
            entries
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
            ListRevisionsResult other = (ListRevisionsResult) obj;
            return (this.isDeleted == other.isDeleted)
                && ((this.entries == other.entries) || (this.entries.equals(other.entries)))
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

    static final class Serializer extends StructJsonSerializer<ListRevisionsResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListRevisionsResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListRevisionsResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListRevisionsResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListRevisionsResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("is_deleted", value.isDeleted);
            g.writeObjectField("entries", value.entries);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListRevisionsResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListRevisionsResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListRevisionsResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListRevisionsResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListRevisionsResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean isDeleted = null;
            List<FileMetadata> entries = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("is_deleted".equals(_field)) {
                    isDeleted = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("entries".equals(_field)) {
                    expectArrayStart(_p);
                    entries = new java.util.ArrayList<FileMetadata>();
                    while (!isArrayEnd(_p)) {
                        FileMetadata _x = null;
                        _x = _p.readValueAs(FileMetadata.class);
                        _p.nextToken();
                        entries.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (isDeleted == null) {
                throw new JsonParseException(_p, "Required field \"is_deleted\" is missing.");
            }
            if (entries == null) {
                throw new JsonParseException(_p, "Required field \"entries\" is missing.");
            }

            return new ListRevisionsResult(isDeleted, entries);
        }
    }
}
