/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Describes the number of users in a specific storage bucket.
 */
public class StorageBucket {
    // struct team.StorageBucket (team_reports.stone)

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
    public StorageBucket(@javax.annotation.Nonnull String bucket, long users) {
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
    @javax.annotation.Nonnull
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<StorageBucket> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(StorageBucket value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("bucket");
            StoneSerializers.string().serialize(value.bucket, g);
            g.writeFieldName("users");
            StoneSerializers.uInt64().serialize(value.users, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public StorageBucket deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            StorageBucket value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_bucket = null;
                Long f_users = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("bucket".equals(field)) {
                        f_bucket = StoneSerializers.string().deserialize(p);
                    }
                    else if ("users".equals(field)) {
                        f_users = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_bucket == null) {
                    throw new JsonParseException(p, "Required field \"bucket\" missing.");
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                value = new StorageBucket(f_bucket, f_users);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
