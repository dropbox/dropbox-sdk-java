/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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
public final class ListFileMembersIndividualResult {
    // union ListFileMembersIndividualResult

    /**
     * Discriminating tag type for {@link ListFileMembersIndividualResult}.
     */
    public enum Tag {
        /**
         * The results of the query for this file if it was successful
         */
        RESULT, // ListFileMembersCountResult
        /**
         * The result of the query for this file if it was an error.
         */
        ACCESS_ERROR, // SharingFileAccessError
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
    public static final ListFileMembersIndividualResult OTHER = new ListFileMembersIndividualResult(Tag.OTHER, null, null);

    private final Tag tag;
    private final ListFileMembersCountResult resultValue;
    private final SharingFileAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ListFileMembersIndividualResult(Tag tag, ListFileMembersCountResult resultValue, SharingFileAccessError accessErrorValue) {
        this.tag = tag;
        this.resultValue = resultValue;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ListFileMembersIndividualResult}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#RESULT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#RESULT},
     *     {@code false} otherwise.
     */
    public boolean isResult() {
        return this.tag == Tag.RESULT;
    }

    /**
     * Returns an instance of {@code ListFileMembersIndividualResult} that has
     * its tag set to {@link Tag#RESULT}.
     *
     * <p> The results of the query for this file if it was successful </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ListFileMembersIndividualResult} with its tag
     *     set to {@link Tag#RESULT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ListFileMembersIndividualResult result(ListFileMembersCountResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersIndividualResult(Tag.RESULT, value, null);
    }

    /**
     * The results of the query for this file if it was successful
     *
     * <p> This instance must be tagged as {@link Tag#RESULT}. </p>
     *
     * @return The {@link ListFileMembersIndividualResult#result} value
     *     associated with this instance if {@link #isResult} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isResult} is {@code false}.
     */
    public ListFileMembersCountResult getResultValue() {
        if (this.tag != Tag.RESULT) {
            throw new IllegalStateException("Invalid tag: required Tag.RESULT, but was Tag." + tag.name());
        }
        return resultValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code ListFileMembersIndividualResult} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> The result of the query for this file if it was an error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ListFileMembersIndividualResult} with its tag
     *     set to {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ListFileMembersIndividualResult accessError(SharingFileAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFileMembersIndividualResult(Tag.ACCESS_ERROR, null, value);
    }

    /**
     * The result of the query for this file if it was an error.
     *
     * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
     *
     * @return The {@link ListFileMembersIndividualResult#accessError} value
     *     associated with this instance if {@link #isAccessError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharingFileAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
        }
        return accessErrorValue;
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
            resultValue,
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ListFileMembersIndividualResult) {
            ListFileMembersIndividualResult other = (ListFileMembersIndividualResult) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case RESULT:
                    return (this.resultValue == other.resultValue) || (this.resultValue.equals(other.resultValue));
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
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
    static final class Serializer extends UnionSerializer<ListFileMembersIndividualResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersIndividualResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case RESULT: {
                    g.writeStartObject();
                    writeTag("result", g);
                    ListFileMembersCountResult.Serializer.INSTANCE.serialize(value.resultValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharingFileAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListFileMembersIndividualResult deserialize(JsonParser p) throws IOException, JsonParseException {
            ListFileMembersIndividualResult value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("result".equals(tag)) {
                ListFileMembersCountResult fieldValue = null;
                fieldValue = ListFileMembersCountResult.Serializer.INSTANCE.deserialize(p, true);
                value = ListFileMembersIndividualResult.result(fieldValue);
            }
            else if ("access_error".equals(tag)) {
                SharingFileAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharingFileAccessError.Serializer.INSTANCE.deserialize(p);
                value = ListFileMembersIndividualResult.accessError(fieldValue);
            }
            else {
                value = ListFileMembersIndividualResult.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
