/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

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

import javax.annotation.Nonnull;

class Uninitialized {
    // struct test.Uninitialized (test.stone)

    @Nonnull
    protected final UninitializedReason reason;
    @Nonnull
    protected final String sessionId;

    /**
     *
     * @param reason  Must not be {@code null}.
     * @param sessionId  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Uninitialized(@Nonnull UninitializedReason reason, @Nonnull String sessionId) {
        if (reason == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = reason;
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UninitializedReason getReason() {
        return reason;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.reason,
            this.sessionId
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
            Uninitialized other = (Uninitialized) obj;
            return ((this.reason == other.reason) || (this.reason.equals(other.reason)))
                && ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
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
    static class Serializer extends StructSerializer<Uninitialized> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Uninitialized value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("reason");
            UninitializedReason.Serializer.INSTANCE.serialize(value.reason, g);
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Uninitialized deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Uninitialized value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UninitializedReason f_reason = null;
                String f_sessionId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("reason".equals(field)) {
                        f_reason = UninitializedReason.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_reason == null) {
                    throw new JsonParseException(p, "Required field \"reason\" missing.");
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                value = new Uninitialized(f_reason, f_sessionId);
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
