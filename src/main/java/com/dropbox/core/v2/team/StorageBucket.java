/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

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

/**
 * Describes the number of users in a specific storage bucket.
 */
@JsonSerialize(using=StorageBucket.Serializer.class)
@JsonDeserialize(using=StorageBucket.Deserializer.class)
public class StorageBucket {
    // struct StorageBucket

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String bucket;
    protected final long users;

    /**
     * Describes the number of users in a specific storage bucket.
     *
     * @param bucket  The name of the storage bucket. For example, '1G' is a
     *     bucket of users with storage size up to 1 Giga. Must not be {@code
     *     null}.
     * @param users  The number of people whose storage is in the range of this
     *     storage bucket.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public StorageBucket(String bucket, long users) {
        if (bucket == null) {
            throw new IllegalArgumentException("Required value for 'bucket' is null");
        }
        this.bucket = bucket;
        this.users = users;
    }

    /**
     * The name of the storage bucket. For example, '1G' is a bucket of users
     * with storage size up to 1 Giga.
     *
     * @return value for this field, never {@code null}.
     */
    public String getBucket() {
        return bucket;
    }

    /**
     * The number of people whose storage is in the range of this storage
     * bucket.
     *
     * @return value for this field.
     */
    public long getUsers() {
        return users;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            bucket,
            users
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
            StorageBucket other = (StorageBucket) obj;
            return ((this.bucket == other.bucket) || (this.bucket.equals(other.bucket)))
                && (this.users == other.users)
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

    static final class Serializer extends StructJsonSerializer<StorageBucket> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(StorageBucket.class);
        }

        public Serializer(boolean unwrapping) {
            super(StorageBucket.class, unwrapping);
        }

        @Override
        protected JsonSerializer<StorageBucket> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(StorageBucket value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("bucket", value.bucket);
            g.writeObjectField("users", value.users);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<StorageBucket> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(StorageBucket.class);
        }

        public Deserializer(boolean unwrapping) {
            super(StorageBucket.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<StorageBucket> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public StorageBucket deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String bucket = null;
            Long users = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("bucket".equals(_field)) {
                    bucket = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("users".equals(_field)) {
                    users = _p.getLongValue();
                    assertUnsigned(_p, users);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (bucket == null) {
                throw new JsonParseException(_p, "Required field \"bucket\" is missing.");
            }
            if (users == null) {
                throw new JsonParseException(_p, "Required field \"users\" is missing.");
            }

            return new StorageBucket(bucket, users);
        }
    }
}
