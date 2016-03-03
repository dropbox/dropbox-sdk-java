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

@JsonSerialize(using=ListFolderLongpollResult.Serializer.class)
@JsonDeserialize(using=ListFolderLongpollResult.Deserializer.class)
public class ListFolderLongpollResult {
    // struct ListFolderLongpollResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final boolean changes;
    protected final Long backoff;

    /**
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxUserFilesRequests#listFolder(String)} to retrieve the
     *     changes.
     * @param backoff  If present, backoff for at least this many seconds before
     *     calling {@link DbxUserFilesRequests#listFolderLongpoll(String)}
     *     again.
     */
    public ListFolderLongpollResult(boolean changes, Long backoff) {
        this.changes = changes;
        this.backoff = backoff;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param changes  Indicates whether new changes are available. If true,
     *     call {@link DbxUserFilesRequests#listFolder(String)} to retrieve the
     *     changes.
     */
    public ListFolderLongpollResult(boolean changes) {
        this(changes, null);
    }

    /**
     * Indicates whether new changes are available. If true, call {@link
     * DbxUserFilesRequests#listFolder(String)} to retrieve the changes.
     *
     * @return value for this field.
     */
    public boolean getChanges() {
        return changes;
    }

    /**
     * If present, backoff for at least this many seconds before calling {@link
     * DbxUserFilesRequests#listFolderLongpoll(String)} again.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Long getBackoff() {
        return backoff;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            changes,
            backoff
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
            ListFolderLongpollResult other = (ListFolderLongpollResult) obj;
            return (this.changes == other.changes)
                && ((this.backoff == other.backoff) || (this.backoff != null && this.backoff.equals(other.backoff)))
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

    static final class Serializer extends StructJsonSerializer<ListFolderLongpollResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListFolderLongpollResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListFolderLongpollResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListFolderLongpollResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListFolderLongpollResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("changes", value.changes);
            if (value.backoff != null) {
                g.writeObjectField("backoff", value.backoff);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListFolderLongpollResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListFolderLongpollResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListFolderLongpollResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListFolderLongpollResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListFolderLongpollResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Boolean changes = null;
            Long backoff = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("changes".equals(_field)) {
                    changes = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("backoff".equals(_field)) {
                    backoff = _p.getLongValue();
                    assertUnsigned(_p, backoff);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (changes == null) {
                throw new JsonParseException(_p, "Required field \"changes\" is missing.");
            }

            return new ListFolderLongpollResult(changes, backoff);
        }
    }
}
