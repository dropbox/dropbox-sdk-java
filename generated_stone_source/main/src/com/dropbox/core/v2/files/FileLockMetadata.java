/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class FileLockMetadata {
    // struct files.FileLockMetadata (files.stone)

    protected final Boolean isLockholder;
    protected final String lockholderName;
    protected final String lockholderAccountId;
    protected final Date created;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param isLockholder  True if caller holds the file lock.
     * @param lockholderName  The display name of the lock holder.
     * @param lockholderAccountId  The account ID of the lock holder if known.
     *     Must have length of at least 40 and have length of at most 40.
     * @param created  The timestamp of the lock was created.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileLockMetadata(Boolean isLockholder, String lockholderName, String lockholderAccountId, Date created) {
        this.isLockholder = isLockholder;
        this.lockholderName = lockholderName;
        if (lockholderAccountId != null) {
            if (lockholderAccountId.length() < 40) {
                throw new IllegalArgumentException("String 'lockholderAccountId' is shorter than 40");
            }
            if (lockholderAccountId.length() > 40) {
                throw new IllegalArgumentException("String 'lockholderAccountId' is longer than 40");
            }
        }
        this.lockholderAccountId = lockholderAccountId;
        this.created = LangUtil.truncateMillis(created);
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public FileLockMetadata() {
        this(null, null, null, null);
    }

    /**
     * True if caller holds the file lock.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getIsLockholder() {
        return isLockholder;
    }

    /**
     * The display name of the lock holder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLockholderName() {
        return lockholderName;
    }

    /**
     * The account ID of the lock holder if known.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getLockholderAccountId() {
        return lockholderAccountId;
    }

    /**
     * The timestamp of the lock was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link FileLockMetadata}.
     */
    public static class Builder {

        protected Boolean isLockholder;
        protected String lockholderName;
        protected String lockholderAccountId;
        protected Date created;

        protected Builder() {
            this.isLockholder = null;
            this.lockholderName = null;
            this.lockholderAccountId = null;
            this.created = null;
        }

        /**
         * Set value for optional field.
         *
         * @param isLockholder  True if caller holds the file lock.
         *
         * @return this builder
         */
        public Builder withIsLockholder(Boolean isLockholder) {
            this.isLockholder = isLockholder;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param lockholderName  The display name of the lock holder.
         *
         * @return this builder
         */
        public Builder withLockholderName(String lockholderName) {
            this.lockholderName = lockholderName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param lockholderAccountId  The account ID of the lock holder if
         *     known. Must have length of at least 40 and have length of at most
         *     40.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLockholderAccountId(String lockholderAccountId) {
            if (lockholderAccountId != null) {
                if (lockholderAccountId.length() < 40) {
                    throw new IllegalArgumentException("String 'lockholderAccountId' is shorter than 40");
                }
                if (lockholderAccountId.length() > 40) {
                    throw new IllegalArgumentException("String 'lockholderAccountId' is longer than 40");
                }
            }
            this.lockholderAccountId = lockholderAccountId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param created  The timestamp of the lock was created.
         *
         * @return this builder
         */
        public Builder withCreated(Date created) {
            this.created = LangUtil.truncateMillis(created);
            return this;
        }

        /**
         * Builds an instance of {@link FileLockMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FileLockMetadata}
         */
        public FileLockMetadata build() {
            return new FileLockMetadata(isLockholder, lockholderName, lockholderAccountId, created);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            isLockholder,
            lockholderName,
            lockholderAccountId,
            created
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
            FileLockMetadata other = (FileLockMetadata) obj;
            return ((this.isLockholder == other.isLockholder) || (this.isLockholder != null && this.isLockholder.equals(other.isLockholder)))
                && ((this.lockholderName == other.lockholderName) || (this.lockholderName != null && this.lockholderName.equals(other.lockholderName)))
                && ((this.lockholderAccountId == other.lockholderAccountId) || (this.lockholderAccountId != null && this.lockholderAccountId.equals(other.lockholderAccountId)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
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
    static class Serializer extends StructSerializer<FileLockMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileLockMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.isLockholder != null) {
                g.writeFieldName("is_lockholder");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isLockholder, g);
            }
            if (value.lockholderName != null) {
                g.writeFieldName("lockholder_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.lockholderName, g);
            }
            if (value.lockholderAccountId != null) {
                g.writeFieldName("lockholder_account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.lockholderAccountId, g);
            }
            if (value.created != null) {
                g.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.created, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileLockMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileLockMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isLockholder = null;
                String f_lockholderName = null;
                String f_lockholderAccountId = null;
                Date f_created = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_lockholder".equals(field)) {
                        f_isLockholder = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("lockholder_name".equals(field)) {
                        f_lockholderName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("lockholder_account_id".equals(field)) {
                        f_lockholderAccountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new FileLockMetadata(f_isLockholder, f_lockholderName, f_lockholderAccountId, f_created);
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
