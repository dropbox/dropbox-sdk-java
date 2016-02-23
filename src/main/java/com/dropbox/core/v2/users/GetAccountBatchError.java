/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class GetAccountBatchError {
    // union GetAccountBatchError

    /**
     * Discriminating tag type for {@link GetAccountBatchError}.
     */
    public enum Tag {
        /**
         * The value is an account ID specified in {@link
         * GetAccountBatchArg#getAccountIds} that does not exist.
         */
        NO_ACCOUNT, // String
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("no_account", Tag.NO_ACCOUNT);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final GetAccountBatchError OTHER = new GetAccountBatchError(Tag.OTHER, null);

    private final Tag tag;
    private final String noAccountValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GetAccountBatchError(Tag tag, String noAccountValue) {
        this.tag = tag;
        this.noAccountValue = noAccountValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GetAccountBatchError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NO_ACCOUNT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_ACCOUNT}, {@code false} otherwise.
     */
    public boolean isNoAccount() {
        return this.tag == Tag.NO_ACCOUNT;
    }

    /**
     * Returns an instance of {@code GetAccountBatchError} that has its tag set
     * to {@link Tag#NO_ACCOUNT}.
     *
     * <p> The value is an account ID specified in {@link
     * GetAccountBatchArg#getAccountIds} that does not exist. </p>
     *
     * @param value  {@link GetAccountBatchError#noAccount} value to assign to
     *     this instance.
     *
     * @return Instance of {@code GetAccountBatchError} with its tag set to
     *     {@link Tag#NO_ACCOUNT}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 40, is
     *     longer than 40, or is {@code null}.
     */
    public static GetAccountBatchError noAccount(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 40) {
            throw new IllegalArgumentException("String is shorter than 40");
        }
        if (value.length() > 40) {
            throw new IllegalArgumentException("String is longer than 40");
        }
        return new GetAccountBatchError(Tag.NO_ACCOUNT, value);
    }

    /**
     * The value is an account ID specified in {@link
     * GetAccountBatchArg#getAccountIds} that does not exist.
     *
     * <p> This instance must be tagged as {@link Tag#NO_ACCOUNT}. </p>
     *
     * @return The {@link GetAccountBatchError#noAccount} value associated with
     *     this instance if {@link #isNoAccount} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNoAccount} is {@code false}.
     */
    public String getNoAccountValue() {
        if (this.tag != Tag.NO_ACCOUNT) {
            throw new IllegalStateException("Invalid tag: required Tag.NO_ACCOUNT, but was Tag." + tag.name());
        }
        return noAccountValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            noAccountValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GetAccountBatchError) {
            GetAccountBatchError other = (GetAccountBatchError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case NO_ACCOUNT:
                    return (this.noAccountValue == other.noAccountValue) || (this.noAccountValue.equals(other.noAccountValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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

    public static GetAccountBatchError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetAccountBatchError> _JSON_WRITER = new JsonWriter<GetAccountBatchError>() {
        public final void write(GetAccountBatchError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case NO_ACCOUNT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_account");
                    g.writeFieldName("no_account");
                    g.writeString(x.getNoAccountValue());
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GetAccountBatchError> _JSON_READER = new JsonReader<GetAccountBatchError>() {

        public final GetAccountBatchError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return GetAccountBatchError.OTHER;
                }
                switch (tag) {
                    case OTHER: return GetAccountBatchError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            GetAccountBatchError value = null;
            if (tag != null) {
                switch (tag) {
                    case NO_ACCOUNT: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "no_account", v);
                        value = GetAccountBatchError.noAccount(v);
                        break;
                    }
                    case OTHER: {
                        value = GetAccountBatchError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return GetAccountBatchError.OTHER;
            }
            return value;
        }

    };
}
