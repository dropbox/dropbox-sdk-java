/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Describes the number of users in a specific storage bucket.
 */
public class StorageBucket {
    // struct StorageBucket

    private final String bucket;
    private final long users;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static StorageBucket fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<StorageBucket> _JSON_WRITER = new JsonWriter<StorageBucket>() {
        public final void write(StorageBucket x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            StorageBucket._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(StorageBucket x, JsonGenerator g) throws IOException {
            g.writeFieldName("bucket");
            g.writeString(x.bucket);
            g.writeFieldName("users");
            g.writeNumber(x.users);
        }
    };

    public static final JsonReader<StorageBucket> _JSON_READER = new JsonReader<StorageBucket>() {
        public final StorageBucket read(JsonParser parser) throws IOException, JsonReadException {
            StorageBucket result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final StorageBucket readFields(JsonParser parser) throws IOException, JsonReadException {
            String bucket = null;
            Long users = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("bucket".equals(fieldName)) {
                    bucket = JsonReader.StringReader
                        .readField(parser, "bucket", bucket);
                }
                else if ("users".equals(fieldName)) {
                    users = JsonReader.UInt64Reader
                        .readField(parser, "users", users);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (bucket == null) {
                throw new JsonReadException("Required field \"bucket\" is missing.", parser.getTokenLocation());
            }
            if (users == null) {
                throw new JsonReadException("Required field \"users\" is missing.", parser.getTokenLocation());
            }
            return new StorageBucket(bucket, users);
        }
    };
}
