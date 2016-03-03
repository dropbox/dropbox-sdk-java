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

@JsonSerialize(using=UploadSessionFinishArg.Serializer.class)
@JsonDeserialize(using=UploadSessionFinishArg.Deserializer.class)
class UploadSessionFinishArg {
    // struct UploadSessionFinishArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UploadSessionCursor cursor;
    protected final CommitInfo commit;

    /**
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishArg(UploadSessionCursor cursor, CommitInfo commit) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        if (commit == null) {
            throw new IllegalArgumentException("Required value for 'commit' is null");
        }
        this.commit = commit;
    }

    /**
     * Contains the upload session ID and the offset.
     *
     * @return value for this field, never {@code null}.
     */
    public UploadSessionCursor getCursor() {
        return cursor;
    }

    /**
     * Contains the path and other optional modifiers for the commit.
     *
     * @return value for this field, never {@code null}.
     */
    public CommitInfo getCommit() {
        return commit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor,
            commit
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
            UploadSessionFinishArg other = (UploadSessionFinishArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && ((this.commit == other.commit) || (this.commit.equals(other.commit)))
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

    static final class Serializer extends StructJsonSerializer<UploadSessionFinishArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionFinishArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UploadSessionFinishArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UploadSessionFinishArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UploadSessionFinishArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("commit", value.commit);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UploadSessionFinishArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionFinishArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UploadSessionFinishArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UploadSessionFinishArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UploadSessionFinishArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UploadSessionCursor cursor = null;
            CommitInfo commit = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("cursor".equals(_field)) {
                    cursor = _p.readValueAs(UploadSessionCursor.class);
                    _p.nextToken();
                }
                else if ("commit".equals(_field)) {
                    commit = _p.readValueAs(CommitInfo.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }
            if (commit == null) {
                throw new JsonParseException(_p, "Required field \"commit\" is missing.");
            }

            return new UploadSessionFinishArg(cursor, commit);
        }
    }
}
