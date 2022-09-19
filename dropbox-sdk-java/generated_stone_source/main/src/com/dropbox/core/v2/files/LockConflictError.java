/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

public class LockConflictError {
    // struct files.LockConflictError (files.stone)

    protected final FileLock lock;

    /**
     *
     * @param lock  The lock that caused the conflict. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LockConflictError(FileLock lock) {
        if (lock == null) {
            throw new IllegalArgumentException("Required value for 'lock' is null");
        }
        this.lock = lock;
    }

    /**
     * The lock that caused the conflict.
     *
     * @return value for this field, never {@code null}.
     */
    public FileLock getLock() {
        return lock;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            lock
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
            LockConflictError other = (LockConflictError) obj;
            return (this.lock == other.lock) || (this.lock.equals(other.lock));
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
    static class Serializer extends StructSerializer<LockConflictError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LockConflictError value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("lock");
            FileLock.Serializer.INSTANCE.serialize(value.lock, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LockConflictError deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LockConflictError value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FileLock f_lock = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("lock".equals(field)) {
                        f_lock = FileLock.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_lock == null) {
                    throw new JsonParseException(p, "Required field \"lock\" missing.");
                }
                value = new LockConflictError(f_lock);
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
