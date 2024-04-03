/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

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
 * Excluded users list argument.
 */
class ExcludedUsersListArg {
    // struct team.ExcludedUsersListArg (team_member_space_limits.stone)

    protected final long limit;

    /**
     * Excluded users list argument.
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersListArg(long limit) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
    }

    /**
     * Excluded users list argument.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ExcludedUsersListArg() {
        this(1000L);
    }

    /**
     * Number of results to return per call.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.limit
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
            ExcludedUsersListArg other = (ExcludedUsersListArg) obj;
            return this.limit == other.limit;
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
    static class Serializer extends StructSerializer<ExcludedUsersListArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExcludedUsersListArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExcludedUsersListArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExcludedUsersListArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_limit = 1000L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ExcludedUsersListArg(f_limit);
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
