/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=GetAccountBatchError.Serializer.class)
@JsonDeserialize(using=GetAccountBatchError.Deserializer.class)
public final class GetAccountBatchError {
    // union GetAccountBatchError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link GetAccountBatchError}.
     */
    public enum Tag {
        /**
         * The value is an account ID specified in the {@code accountIds}
         * argument to {@link
         * DbxUserUsersRequests#getAccountBatch(java.util.List)} that does not
         * exist.
         */
        NO_ACCOUNT, // String
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GetAccountBatchError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
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
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_ACCOUNT}, {@code false} otherwise.
     */
    public boolean isNoAccount() {
        return this.tag == Tag.NO_ACCOUNT;
    }

    /**
     * Returns an instance of {@code GetAccountBatchError} that has its tag set
     * to {@link Tag#NO_ACCOUNT}.
     *
     * <p> The value is an account ID specified in the {@code accountIds}
     * argument to {@link DbxUserUsersRequests#getAccountBatch(java.util.List)}
     * that does not exist. </p>
     *
     * @param value  value to assign to this instance.
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
     * The value is an account ID specified in the {@code accountIds} argument
     * to {@link DbxUserUsersRequests#getAccountBatch(java.util.List)} that does
     * not exist.
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
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
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

    static final class Serializer extends UnionJsonSerializer<GetAccountBatchError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetAccountBatchError.class);
        }

        @Override
        public void serialize(GetAccountBatchError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case NO_ACCOUNT:
                    g.writeStartObject();
                    g.writeStringField(".tag", "no_account");
                    g.writeObjectField("no_account", value.noAccountValue);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GetAccountBatchError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetAccountBatchError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public GetAccountBatchError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case NO_ACCOUNT: {
                    String value = null;
                    expectField(_p, "no_account");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return GetAccountBatchError.noAccount(value);
                }
                case OTHER: {
                    return GetAccountBatchError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, GetAccountBatchError.Tag> getTagMapping() {
            Map<String, GetAccountBatchError.Tag> values = new HashMap<String, GetAccountBatchError.Tag>();
            values.put("no_account", GetAccountBatchError.Tag.NO_ACCOUNT);
            values.put("other", GetAccountBatchError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
