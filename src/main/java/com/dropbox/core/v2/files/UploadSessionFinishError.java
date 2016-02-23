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

public final class UploadSessionFinishError {
    // union UploadSessionFinishError

    /**
     * Discriminating tag type for {@link UploadSessionFinishError}.
     */
    public enum Tag {
        /**
         * The session arguments are incorrect; the value explains the reason.
         */
        LOOKUP_FAILED, // UploadSessionLookupError
        /**
         * Unable to save the uploaded contents to a file.
         */
        PATH, // WriteError
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("lookup_failed", Tag.LOOKUP_FAILED);
        VALUES_.put("path", Tag.PATH);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final UploadSessionFinishError OTHER = new UploadSessionFinishError(Tag.OTHER, null, null);

    private final Tag tag;
    private final UploadSessionLookupError lookupFailedValue;
    private final WriteError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionFinishError(Tag tag, UploadSessionLookupError lookupFailedValue, WriteError pathValue) {
        this.tag = tag;
        this.lookupFailedValue = lookupFailedValue;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UploadSessionFinishError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#LOOKUP_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#LOOKUP_FAILED}, {@code false} otherwise.
     */
    public boolean isLookupFailed() {
        return this.tag == Tag.LOOKUP_FAILED;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#LOOKUP_FAILED}.
     *
     * <p> The session arguments are incorrect; the value explains the reason.
     * </p>
     *
     * @param value  {@link UploadSessionFinishError#lookupFailed} value to
     *     assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#LOOKUP_FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError lookupFailed(UploadSessionLookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError(Tag.LOOKUP_FAILED, value, null);
    }

    /**
     * The session arguments are incorrect; the value explains the reason.
     *
     * <p> This instance must be tagged as {@link Tag#LOOKUP_FAILED}. </p>
     *
     * @return The {@link UploadSessionFinishError#lookupFailed} value
     *     associated with this instance if {@link #isLookupFailed} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isLookupFailed} is {@code
     *     false}.
     */
    public UploadSessionLookupError getLookupFailedValue() {
        if (this.tag != Tag.LOOKUP_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.LOOKUP_FAILED, but was Tag." + tag.name());
        }
        return lookupFailedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> Unable to save the uploaded contents to a file. </p>
     *
     * @param value  {@link UploadSessionFinishError#path} value to assign to
     *     this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError(Tag.PATH, null, value);
    }

    /**
     * Unable to save the uploaded contents to a file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link UploadSessionFinishError#path} value associated with
     *     this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public WriteError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
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
            lookupFailedValue,
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadSessionFinishError) {
            UploadSessionFinishError other = (UploadSessionFinishError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case LOOKUP_FAILED:
                    return (this.lookupFailedValue == other.lookupFailedValue) || (this.lookupFailedValue.equals(other.lookupFailedValue));
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
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

    public static UploadSessionFinishError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionFinishError> _JSON_WRITER = new JsonWriter<UploadSessionFinishError>() {
        public final void write(UploadSessionFinishError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case LOOKUP_FAILED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("lookup_failed");
                    g.writeFieldName("lookup_failed");
                    UploadSessionLookupError._JSON_WRITER.write(x.getLookupFailedValue(), g);
                    g.writeEndObject();
                    break;
                case PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path");
                    g.writeFieldName("path");
                    WriteError._JSON_WRITER.write(x.getPathValue(), g);
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

    public static final JsonReader<UploadSessionFinishError> _JSON_READER = new JsonReader<UploadSessionFinishError>() {

        public final UploadSessionFinishError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return UploadSessionFinishError.OTHER;
                }
                switch (tag) {
                    case OTHER: return UploadSessionFinishError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            UploadSessionFinishError value = null;
            if (tag != null) {
                switch (tag) {
                    case LOOKUP_FAILED: {
                        UploadSessionLookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = UploadSessionLookupError._JSON_READER
                            .readField(parser, "lookup_failed", v);
                        value = UploadSessionFinishError.lookupFailed(v);
                        break;
                    }
                    case PATH: {
                        WriteError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = WriteError._JSON_READER
                            .readField(parser, "path", v);
                        value = UploadSessionFinishError.path(v);
                        break;
                    }
                    case OTHER: {
                        value = UploadSessionFinishError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return UploadSessionFinishError.OTHER;
            }
            return value;
        }

    };
}
