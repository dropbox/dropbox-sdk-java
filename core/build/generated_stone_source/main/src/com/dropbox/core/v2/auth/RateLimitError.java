/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

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
 * Error occurred because the app is being rate limited.
 */
public class RateLimitError {
    // struct auth.RateLimitError (auth.stone)

    protected final RateLimitReason reason;
    protected final long retryAfter;

    /**
     * Error occurred because the app is being rate limited.
     *
     * @param reason  The reason why the app is being rate limited. Must not be
     *     {@code null}.
     * @param retryAfter  The number of seconds that the app should wait before
     *     making another request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RateLimitError(@javax.annotation.Nonnull RateLimitReason reason, long retryAfter) {
        if (reason == null) {
            throw new IllegalArgumentException("Required value for 'reason' is null");
        }
        this.reason = reason;
        this.retryAfter = retryAfter;
    }

    /**
     * Error occurred because the app is being rate limited.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param reason  The reason why the app is being rate limited. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RateLimitError(RateLimitReason reason) {
        this(reason, 1L);
    }

    /**
     * The reason why the app is being rate limited.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public RateLimitReason getReason() {
        return reason;
    }

    /**
     * The number of seconds that the app should wait before making another
     * request.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1L.
     */
    public long getRetryAfter() {
        return retryAfter;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            reason,
            retryAfter
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
            RateLimitError other = (RateLimitError) obj;
            return ((this.reason == other.reason) || (this.reason.equals(other.reason)))
                && (this.retryAfter == other.retryAfter)
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
    public static class Serializer extends StructSerializer<RateLimitError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RateLimitError value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("reason");
            RateLimitReason.Serializer.INSTANCE.serialize(value.reason, g);
            g.writeFieldName("retry_after");
            StoneSerializers.uInt64().serialize(value.retryAfter, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RateLimitError deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RateLimitError value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                RateLimitReason f_reason = null;
                Long f_retryAfter = 1L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("reason".equals(field)) {
                        f_reason = RateLimitReason.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("retry_after".equals(field)) {
                        f_retryAfter = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_reason == null) {
                    throw new JsonParseException(p, "Required field \"reason\" missing.");
                }
                value = new RateLimitError(f_reason, f_retryAfter);
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
