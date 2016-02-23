/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class GetAccountBatchArg {
    // struct GetAccountBatchArg

    private final List<String> accountIds;

    /**
     *
     * @param accountIds  List of user account identifiers.  Should not contain
     *     any duplicate account IDs. Must contain at least 1 items, not contain
     *     a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetAccountBatchArg(List<String> accountIds) {
        if (accountIds == null) {
            throw new IllegalArgumentException("Required value for 'accountIds' is null");
        }
        if (accountIds.size() < 1) {
            throw new IllegalArgumentException("List 'accountIds' has fewer than 1 items");
        }
        for (String x : accountIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'accountIds' is null");
            }
            if (x.length() < 40) {
                throw new IllegalArgumentException("Stringan item in list 'accountIds' is shorter than 40");
            }
            if (x.length() > 40) {
                throw new IllegalArgumentException("Stringan item in list 'accountIds' is longer than 40");
            }
        }
        this.accountIds = accountIds;
    }

    /**
     * List of user account identifiers.  Should not contain any duplicate
     * account IDs.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getAccountIds() {
        return accountIds;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetAccountBatchArg other = (GetAccountBatchArg) obj;
            return (this.accountIds == other.accountIds) || (this.accountIds.equals(other.accountIds));
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

    public static GetAccountBatchArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetAccountBatchArg> _JSON_WRITER = new JsonWriter<GetAccountBatchArg>() {
        public final void write(GetAccountBatchArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GetAccountBatchArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GetAccountBatchArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("account_ids");
            g.writeStartArray();
            for (String item: x.accountIds) {
                if (item != null) {
                    g.writeString(item);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<GetAccountBatchArg> _JSON_READER = new JsonReader<GetAccountBatchArg>() {
        public final GetAccountBatchArg read(JsonParser parser) throws IOException, JsonReadException {
            GetAccountBatchArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GetAccountBatchArg readFields(JsonParser parser) throws IOException, JsonReadException {
            List<String> accountIds = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("account_ids".equals(fieldName)) {
                    accountIds = JsonArrayReader.mk(JsonReader.StringReader)
                        .readField(parser, "account_ids", accountIds);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accountIds == null) {
                throw new JsonReadException("Required field \"account_ids\" is missing.", parser.getTokenLocation());
            }
            return new GetAccountBatchArg(accountIds);
        }
    };
}
