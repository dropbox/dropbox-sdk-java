/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class UploadSessionLookupError {
    // union UploadSessionLookupError

    /**
     * Discriminating tag type for {@link UploadSessionLookupError}.
     */
    public enum Tag {
        /**
         * The upload session id was not found.
         */
        NOT_FOUND,
        /**
         * The specified offset was incorrect. See the value for the correct
         * offset. (This error may occur when a previous request was received
         * and processed successfully but the client did not receive the
         * response, e.g. due to a network error.)
         */
        INCORRECT_OFFSET, // UploadSessionOffsetError
        /**
         * You are attempting to append data to an upload session that has
         * alread been closed (i.e. committed).
         */
        CLOSED,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("not_found", Tag.NOT_FOUND);
        VALUES_.put("incorrect_offset", Tag.INCORRECT_OFFSET);
        VALUES_.put("closed", Tag.CLOSED);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final UploadSessionLookupError NOT_FOUND = new UploadSessionLookupError(Tag.NOT_FOUND, null);
    public static final UploadSessionLookupError CLOSED = new UploadSessionLookupError(Tag.CLOSED, null);
    public static final UploadSessionLookupError OTHER = new UploadSessionLookupError(Tag.OTHER, null);

    private final Tag tag;
    private final UploadSessionOffsetError incorrectOffsetValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionLookupError(Tag tag, UploadSessionOffsetError incorrectOffsetValue) {
        this.tag = tag;
        this.incorrectOffsetValue = incorrectOffsetValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UploadSessionLookupError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this.tag == Tag.NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     */
    public boolean isIncorrectOffset() {
        return this.tag == Tag.INCORRECT_OFFSET;
    }

    /**
     * Returns an instance of {@code UploadSessionLookupError} that has its tag
     * set to {@link Tag#INCORRECT_OFFSET}.
     *
     * <p> The specified offset was incorrect. See the value for the correct
     * offset. (This error may occur when a previous request was received and
     * processed successfully but the client did not receive the response, e.g.
     * due to a network error.) </p>
     *
     * @param value  {@link UploadSessionLookupError#incorrectOffset} value to
     *     assign to this instance.
     *
     * @return Instance of {@code UploadSessionLookupError} with its tag set to
     *     {@link Tag#INCORRECT_OFFSET}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionLookupError(Tag.INCORRECT_OFFSET, value);
    }

    /**
     * The specified offset was incorrect. See the value for the correct offset.
     * (This error may occur when a previous request was received and processed
     * successfully but the client did not receive the response, e.g. due to a
     * network error.)
     *
     * <p> This instance must be tagged as {@link Tag#INCORRECT_OFFSET}. </p>
     *
     * @return The {@link UploadSessionLookupError#incorrectOffset} value
     *     associated with this instance if {@link #isIncorrectOffset} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isIncorrectOffset} is {@code
     *     false}.
     */
    public UploadSessionOffsetError getIncorrectOffsetValue() {
        if (this.tag != Tag.INCORRECT_OFFSET) {
            throw new IllegalStateException("Invalid tag: required Tag.INCORRECT_OFFSET, but was Tag." + tag.name());
        }
        return incorrectOffsetValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CLOSED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#CLOSED},
     *     {@code false} otherwise.
     */
    public boolean isClosed() {
        return this.tag == Tag.CLOSED;
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
            incorrectOffsetValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadSessionLookupError) {
            UploadSessionLookupError other = (UploadSessionLookupError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case NOT_FOUND:
                    return true;
                case INCORRECT_OFFSET:
                    return (this.incorrectOffsetValue == other.incorrectOffsetValue) || (this.incorrectOffsetValue.equals(other.incorrectOffsetValue));
                case CLOSED:
                    return true;
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

    public static UploadSessionLookupError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionLookupError> _JSON_WRITER = new JsonWriter<UploadSessionLookupError>() {
        public final void write(UploadSessionLookupError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_found");
                    g.writeEndObject();
                    break;
                case INCORRECT_OFFSET:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("incorrect_offset");
                    g.writeFieldName("incorrect_offset");
                    UploadSessionOffsetError._JSON_WRITER.write(x.getIncorrectOffsetValue(), g);
                    g.writeEndObject();
                    break;
                case CLOSED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("closed");
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

    public static final JsonReader<UploadSessionLookupError> _JSON_READER = new JsonReader<UploadSessionLookupError>() {

        public final UploadSessionLookupError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return UploadSessionLookupError.OTHER;
                }
                switch (tag) {
                    case NOT_FOUND: return UploadSessionLookupError.NOT_FOUND;
                    case CLOSED: return UploadSessionLookupError.CLOSED;
                    case OTHER: return UploadSessionLookupError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            UploadSessionLookupError value = null;
            if (tag != null) {
                switch (tag) {
                    case NOT_FOUND: {
                        value = UploadSessionLookupError.NOT_FOUND;
                        break;
                    }
                    case INCORRECT_OFFSET: {
                        UploadSessionOffsetError v = null;
                        v = UploadSessionOffsetError._JSON_READER.readFields(parser);
                        value = UploadSessionLookupError.incorrectOffset(v);
                        break;
                    }
                    case CLOSED: {
                        value = UploadSessionLookupError.CLOSED;
                        break;
                    }
                    case OTHER: {
                        value = UploadSessionLookupError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return UploadSessionLookupError.OTHER;
            }
            return value;
        }

    };
}
