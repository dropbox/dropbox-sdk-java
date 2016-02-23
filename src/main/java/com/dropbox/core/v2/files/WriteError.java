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

public final class WriteError {
    // union WriteError

    /**
     * Discriminating tag type for {@link WriteError}.
     */
    public enum Tag {
        MALFORMED_PATH, // String
        /**
         * Couldn't write to the target path because there was something in the
         * way.
         */
        CONFLICT, // WriteConflictError
        /**
         * The user doesn't have permissions to write to the target location.
         */
        NO_WRITE_PERMISSION,
        /**
         * The user doesn't have enough available space (bytes) to write more
         * data.
         */
        INSUFFICIENT_SPACE,
        /**
         * Dropbox will not save the file or folder because of its name.
         */
        DISALLOWED_NAME,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("malformed_path", Tag.MALFORMED_PATH);
        VALUES_.put("conflict", Tag.CONFLICT);
        VALUES_.put("no_write_permission", Tag.NO_WRITE_PERMISSION);
        VALUES_.put("insufficient_space", Tag.INSUFFICIENT_SPACE);
        VALUES_.put("disallowed_name", Tag.DISALLOWED_NAME);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final WriteError NO_WRITE_PERMISSION = new WriteError(Tag.NO_WRITE_PERMISSION, null, null);
    public static final WriteError INSUFFICIENT_SPACE = new WriteError(Tag.INSUFFICIENT_SPACE, null, null);
    public static final WriteError DISALLOWED_NAME = new WriteError(Tag.DISALLOWED_NAME, null, null);
    public static final WriteError OTHER = new WriteError(Tag.OTHER, null, null);

    private final Tag tag;
    private final String malformedPathValue;
    private final WriteConflictError conflictValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private WriteError(Tag tag, String malformedPathValue, WriteConflictError conflictValue) {
        this.tag = tag;
        this.malformedPathValue = malformedPathValue;
        this.conflictValue = conflictValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code WriteError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MALFORMED_PATH}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#MALFORMED_PATH}, {@code false} otherwise.
     */
    public boolean isMalformedPath() {
        return this.tag == Tag.MALFORMED_PATH;
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @param value  {@link WriteError#malformedPath} value to assign to this
     *     instance.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath(String value) {
        return new WriteError(Tag.MALFORMED_PATH, value, null);
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath() {
        return malformedPath(null);
    }

    /**
     * This instance must be tagged as {@link Tag#MALFORMED_PATH}.
     *
     * @return The {@link WriteError#malformedPath} value associated with this
     *     instance if {@link #isMalformedPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
     *     false}.
     */
    public String getMalformedPathValue() {
        if (this.tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + tag.name());
        }
        return malformedPathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CONFLICT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#CONFLICT}, {@code false} otherwise.
     */
    public boolean isConflict() {
        return this.tag == Tag.CONFLICT;
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#CONFLICT}.
     *
     * <p> Couldn't write to the target path because there was something in the
     * way. </p>
     *
     * @param value  {@link WriteError#conflict} value to assign to this
     *     instance.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#CONFLICT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static WriteError conflict(WriteConflictError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WriteError(Tag.CONFLICT, null, value);
    }

    /**
     * Couldn't write to the target path because there was something in the way.
     *
     * <p> This instance must be tagged as {@link Tag#CONFLICT}. </p>
     *
     * @return The {@link WriteError#conflict} value associated with this
     *     instance if {@link #isConflict} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isConflict} is {@code false}.
     */
    public WriteConflictError getConflictValue() {
        if (this.tag != Tag.CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.CONFLICT, but was Tag." + tag.name());
        }
        return conflictValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoWritePermission() {
        return this.tag == Tag.NO_WRITE_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     */
    public boolean isInsufficientSpace() {
        return this.tag == Tag.INSUFFICIENT_SPACE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DISALLOWED_NAME}, {@code false} otherwise.
     */
    public boolean isDisallowedName() {
        return this.tag == Tag.DISALLOWED_NAME;
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
            malformedPathValue,
            conflictValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof WriteError) {
            WriteError other = (WriteError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case MALFORMED_PATH:
                    return (this.malformedPathValue == other.malformedPathValue) || (this.malformedPathValue != null && this.malformedPathValue.equals(other.malformedPathValue));
                case CONFLICT:
                    return (this.conflictValue == other.conflictValue) || (this.conflictValue.equals(other.conflictValue));
                case NO_WRITE_PERMISSION:
                    return true;
                case INSUFFICIENT_SPACE:
                    return true;
                case DISALLOWED_NAME:
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

    public static WriteError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<WriteError> _JSON_WRITER = new JsonWriter<WriteError>() {
        public final void write(WriteError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case MALFORMED_PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("malformed_path");
                    if (x.getMalformedPathValue() != null) {
                        g.writeFieldName("malformed_path");
                        g.writeString(x.getMalformedPathValue());
                    }
                    g.writeEndObject();
                    break;
                case CONFLICT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("conflict");
                    g.writeFieldName("conflict");
                    WriteConflictError._JSON_WRITER.write(x.getConflictValue(), g);
                    g.writeEndObject();
                    break;
                case NO_WRITE_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_write_permission");
                    g.writeEndObject();
                    break;
                case INSUFFICIENT_SPACE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("insufficient_space");
                    g.writeEndObject();
                    break;
                case DISALLOWED_NAME:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("disallowed_name");
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

    public static final JsonReader<WriteError> _JSON_READER = new JsonReader<WriteError>() {

        public final WriteError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return WriteError.OTHER;
                }
                switch (tag) {
                    case MALFORMED_PATH: return WriteError.malformedPath();
                    case NO_WRITE_PERMISSION: return WriteError.NO_WRITE_PERMISSION;
                    case INSUFFICIENT_SPACE: return WriteError.INSUFFICIENT_SPACE;
                    case DISALLOWED_NAME: return WriteError.DISALLOWED_NAME;
                    case OTHER: return WriteError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            WriteError value = null;
            if (tag != null) {
                switch (tag) {
                    case MALFORMED_PATH: {
                        if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                            value = WriteError.malformedPath();
                            break;
                        }
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "malformed_path", v);
                        value = WriteError.malformedPath(v);
                        break;
                    }
                    case CONFLICT: {
                        WriteConflictError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = WriteConflictError._JSON_READER
                            .readField(parser, "conflict", v);
                        value = WriteError.conflict(v);
                        break;
                    }
                    case NO_WRITE_PERMISSION: {
                        value = WriteError.NO_WRITE_PERMISSION;
                        break;
                    }
                    case INSUFFICIENT_SPACE: {
                        value = WriteError.INSUFFICIENT_SPACE;
                        break;
                    }
                    case DISALLOWED_NAME: {
                        value = WriteError.DISALLOWED_NAME;
                        break;
                    }
                    case OTHER: {
                        value = WriteError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return WriteError.OTHER;
            }
            return value;
        }

    };
}
