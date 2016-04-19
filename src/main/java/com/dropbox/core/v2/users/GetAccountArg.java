/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

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

@JsonSerialize(using=GetAccountArg.Serializer.class)
@JsonDeserialize(using=GetAccountArg.Deserializer.class)
class GetAccountArg {
    // struct GetAccountArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String accountId;

    /**
     *
     * @param accountId  A user's account identifier. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetAccountArg(String accountId) {
        if (accountId == null) {
            throw new IllegalArgumentException("Required value for 'accountId' is null");
        }
        if (accountId.length() < 40) {
            throw new IllegalArgumentException("String 'accountId' is shorter than 40");
        }
        if (accountId.length() > 40) {
            throw new IllegalArgumentException("String 'accountId' is longer than 40");
        }
        this.accountId = accountId;
    }

    /**
     * A user's account identifier.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAccountId() {
        return accountId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accountId
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
            GetAccountArg other = (GetAccountArg) obj;
            return (this.accountId == other.accountId) || (this.accountId.equals(other.accountId));
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

    static final class Serializer extends StructJsonSerializer<GetAccountArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetAccountArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetAccountArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetAccountArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetAccountArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("account_id", value.accountId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetAccountArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetAccountArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetAccountArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetAccountArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetAccountArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String accountId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("account_id".equals(_field)) {
                    accountId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accountId == null) {
                throw new JsonParseException(_p, "Required field \"account_id\" is missing.");
            }

            return new GetAccountArg(accountId);
        }
    }
}
