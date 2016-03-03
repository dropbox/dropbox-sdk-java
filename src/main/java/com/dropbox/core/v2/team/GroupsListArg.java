/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=GroupsListArg.Serializer.class)
@JsonDeserialize(using=GroupsListArg.Deserializer.class)
class GroupsListArg {
    // struct GroupsListArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final long limit;

    /**
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListArg(long limit) {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
    }

    /**
     * The default values for unset fields will be used.
     */
    public GroupsListArg() {
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
        int hash = java.util.Arrays.hashCode(new Object [] {
            limit
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
            GroupsListArg other = (GroupsListArg) obj;
            return this.limit == other.limit;
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

    static final class Serializer extends StructJsonSerializer<GroupsListArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsListArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupsListArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupsListArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupsListArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("limit", value.limit);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupsListArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsListArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupsListArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupsListArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupsListArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            Long limit = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("limit".equals(_field)) {
                    limit = _p.getLongValue();
                    assertUnsigned(_p, limit);
                    if (limit > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + limit);
                    }
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }


            return new GroupsListArg(limit);
        }
    }
}
