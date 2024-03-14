/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Cursor {
    // struct paper.Cursor (paper.stone)

    protected final String value;
    protected final Date expiration;

    /**
     *
     * @param value  The actual cursor value. Must not be {@code null}.
     * @param expiration  Expiration time of {@link Cursor#getValue}. Some
     *     cursors might have expiration time assigned. This is a UTC value
     *     after which the cursor is no longer valid and the API starts
     *     returning an error. If cursor expires a new one needs to be obtained
     *     and pagination needs to be restarted. Some cursors might be
     *     short-lived some cursors might be long-lived. This really depends on
     *     the sorting type and order, e.g.: 1. on one hand, listing docs
     *     created by the user, sorted by the created time ascending will have
     *     undefinite expiration because the results cannot change while the
     *     iteration is happening. This cursor would be suitable for long term
     *     polling. 2. on the other hand, listing docs sorted by the last
     *     modified time will have a very short expiration as docs do get
     *     modified very often and the modified time can be changed while the
     *     iteration is happening thus altering the results.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Cursor(@Nonnull String value, @Nullable Date expiration) {
        if (value == null) {
            throw new IllegalArgumentException("Required value for 'value' is null");
        }
        this.value = value;
        this.expiration = LangUtil.truncateMillis(expiration);
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param value  The actual cursor value. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Cursor(@Nonnull String value) {
        this(value, null);
    }

    /**
     * The actual cursor value.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getValue() {
        return value;
    }

    /**
     * Expiration time of {@link Cursor#getValue}. Some cursors might have
     * expiration time assigned. This is a UTC value after which the cursor is
     * no longer valid and the API starts returning an error. If cursor expires
     * a new one needs to be obtained and pagination needs to be restarted. Some
     * cursors might be short-lived some cursors might be long-lived. This
     * really depends on the sorting type and order, e.g.: 1. on one hand,
     * listing docs created by the user, sorted by the created time ascending
     * will have undefinite expiration because the results cannot change while
     * the iteration is happening. This cursor would be suitable for long term
     * polling. 2. on the other hand, listing docs sorted by the last modified
     * time will have a very short expiration as docs do get modified very often
     * and the modified time can be changed while the iteration is happening
     * thus altering the results.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getExpiration() {
        return expiration;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            value,
            expiration
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
            Cursor other = (Cursor) obj;
            return ((this.value == other.value) || (this.value.equals(other.value)))
                && ((this.expiration == other.expiration) || (this.expiration != null && this.expiration.equals(other.expiration)))
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
    static class Serializer extends StructSerializer<Cursor> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Cursor value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("value");
            StoneSerializers.string().serialize(value.value, g);
            if (value.expiration != null) {
                g.writeFieldName("expiration");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.expiration, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Cursor deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Cursor value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_value = null;
                Date f_expiration = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("value".equals(field)) {
                        f_value = StoneSerializers.string().deserialize(p);
                    }
                    else if ("expiration".equals(field)) {
                        f_expiration = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_value == null) {
                    throw new JsonParseException(p, "Required field \"value\" missing.");
                }
                value = new Cursor(f_value, f_expiration);
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
