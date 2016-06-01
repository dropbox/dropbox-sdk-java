/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

class GetAccountBatchArg {
    // struct GetAccountBatchArg

    protected final List<String> accountIds;

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
        int hash = java.util.Arrays.hashCode(new Object [] {
            accountIds
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
            GetAccountBatchArg other = (GetAccountBatchArg) obj;
            return (this.accountIds == other.accountIds) || (this.accountIds.equals(other.accountIds));
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
    static final class Serializer extends StructSerializer<GetAccountBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetAccountBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("account_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.accountIds, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetAccountBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetAccountBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_accountIds = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("account_ids".equals(field)) {
                        f_accountIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accountIds == null) {
                    throw new JsonParseException(p, "Required field \"account_ids\" missing.");
                }
                value = new GetAccountBatchArg(f_accountIds);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
