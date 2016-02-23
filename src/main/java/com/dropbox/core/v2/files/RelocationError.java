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

public final class RelocationError {
    // union RelocationError

    /**
     * Discriminating tag type for {@link RelocationError}.
     */
    public enum Tag {
        FROM_LOOKUP, // LookupError
        FROM_WRITE, // WriteError
        TO, // WriteError
        /**
         * Shared folders can't be copied.
         */
        CANT_COPY_SHARED_FOLDER,
        /**
         * Your move operation would result in nested shared folders.  This is
         * not allowed.
         */
        CANT_NEST_SHARED_FOLDER,
        /**
         * You cannot move a folder into itself.
         */
        CANT_MOVE_FOLDER_INTO_ITSELF,
        /**
         * The operation would involve more than 10,000 files and folders.
         */
        TOO_MANY_FILES,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("from_lookup", Tag.FROM_LOOKUP);
        VALUES_.put("from_write", Tag.FROM_WRITE);
        VALUES_.put("to", Tag.TO);
        VALUES_.put("cant_copy_shared_folder", Tag.CANT_COPY_SHARED_FOLDER);
        VALUES_.put("cant_nest_shared_folder", Tag.CANT_NEST_SHARED_FOLDER);
        VALUES_.put("cant_move_folder_into_itself", Tag.CANT_MOVE_FOLDER_INTO_ITSELF);
        VALUES_.put("too_many_files", Tag.TOO_MANY_FILES);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final RelocationError CANT_COPY_SHARED_FOLDER = new RelocationError(Tag.CANT_COPY_SHARED_FOLDER, null, null, null);
    public static final RelocationError CANT_NEST_SHARED_FOLDER = new RelocationError(Tag.CANT_NEST_SHARED_FOLDER, null, null, null);
    public static final RelocationError CANT_MOVE_FOLDER_INTO_ITSELF = new RelocationError(Tag.CANT_MOVE_FOLDER_INTO_ITSELF, null, null, null);
    public static final RelocationError TOO_MANY_FILES = new RelocationError(Tag.TOO_MANY_FILES, null, null, null);
    public static final RelocationError OTHER = new RelocationError(Tag.OTHER, null, null, null);

    private final Tag tag;
    private final LookupError fromLookupValue;
    private final WriteError fromWriteValue;
    private final WriteError toValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RelocationError(Tag tag, LookupError fromLookupValue, WriteError fromWriteValue, WriteError toValue) {
        this.tag = tag;
        this.fromLookupValue = fromLookupValue;
        this.fromWriteValue = fromWriteValue;
        this.toValue = toValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code RelocationError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FROM_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#FROM_LOOKUP}, {@code false} otherwise.
     */
    public boolean isFromLookup() {
        return this.tag == Tag.FROM_LOOKUP;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#FROM_LOOKUP}.
     *
     * @param value  {@link RelocationError#fromLookup} value to assign to this
     *     instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#FROM_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError fromLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.FROM_LOOKUP, value, null, null);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_LOOKUP}.
     *
     * @return The {@link RelocationError#fromLookup} value associated with this
     *     instance if {@link #isFromLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromLookup} is {@code false}.
     */
    public LookupError getFromLookupValue() {
        if (this.tag != Tag.FROM_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_LOOKUP, but was Tag." + tag.name());
        }
        return fromLookupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FROM_WRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#FROM_WRITE}, {@code false} otherwise.
     */
    public boolean isFromWrite() {
        return this.tag == Tag.FROM_WRITE;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#FROM_WRITE}.
     *
     * @param value  {@link RelocationError#fromWrite} value to assign to this
     *     instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#FROM_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError fromWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.FROM_WRITE, null, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_WRITE}.
     *
     * @return The {@link RelocationError#fromWrite} value associated with this
     *     instance if {@link #isFromWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromWrite} is {@code false}.
     */
    public WriteError getFromWriteValue() {
        if (this.tag != Tag.FROM_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_WRITE, but was Tag." + tag.name());
        }
        return fromWriteValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TO}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#TO},
     *     {@code false} otherwise.
     */
    public boolean isTo() {
        return this.tag == Tag.TO;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#TO}.
     *
     * @param value  {@link RelocationError#to} value to assign to this
     *     instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#TO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError to(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.TO, null, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TO}.
     *
     * @return The {@link RelocationError#to} value associated with this
     *     instance if {@link #isTo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTo} is {@code false}.
     */
    public WriteError getToValue() {
        if (this.tag != Tag.TO) {
            throw new IllegalStateException("Invalid tag: required Tag.TO, but was Tag." + tag.name());
        }
        return toValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantCopySharedFolder() {
        return this.tag == Tag.CANT_COPY_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantNestSharedFolder() {
        return this.tag == Tag.CANT_NEST_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     */
    public boolean isCantMoveFolderIntoItself() {
        return this.tag == Tag.CANT_MOVE_FOLDER_INTO_ITSELF;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_FILES}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TOO_MANY_FILES}, {@code false} otherwise.
     */
    public boolean isTooManyFiles() {
        return this.tag == Tag.TOO_MANY_FILES;
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
            fromLookupValue,
            fromWriteValue,
            toValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof RelocationError) {
            RelocationError other = (RelocationError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case FROM_LOOKUP:
                    return (this.fromLookupValue == other.fromLookupValue) || (this.fromLookupValue.equals(other.fromLookupValue));
                case FROM_WRITE:
                    return (this.fromWriteValue == other.fromWriteValue) || (this.fromWriteValue.equals(other.fromWriteValue));
                case TO:
                    return (this.toValue == other.toValue) || (this.toValue.equals(other.toValue));
                case CANT_COPY_SHARED_FOLDER:
                    return true;
                case CANT_NEST_SHARED_FOLDER:
                    return true;
                case CANT_MOVE_FOLDER_INTO_ITSELF:
                    return true;
                case TOO_MANY_FILES:
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

    public static RelocationError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RelocationError> _JSON_WRITER = new JsonWriter<RelocationError>() {
        public final void write(RelocationError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case FROM_LOOKUP:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("from_lookup");
                    g.writeFieldName("from_lookup");
                    LookupError._JSON_WRITER.write(x.getFromLookupValue(), g);
                    g.writeEndObject();
                    break;
                case FROM_WRITE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("from_write");
                    g.writeFieldName("from_write");
                    WriteError._JSON_WRITER.write(x.getFromWriteValue(), g);
                    g.writeEndObject();
                    break;
                case TO:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("to");
                    g.writeFieldName("to");
                    WriteError._JSON_WRITER.write(x.getToValue(), g);
                    g.writeEndObject();
                    break;
                case CANT_COPY_SHARED_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("cant_copy_shared_folder");
                    g.writeEndObject();
                    break;
                case CANT_NEST_SHARED_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("cant_nest_shared_folder");
                    g.writeEndObject();
                    break;
                case CANT_MOVE_FOLDER_INTO_ITSELF:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("cant_move_folder_into_itself");
                    g.writeEndObject();
                    break;
                case TOO_MANY_FILES:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("too_many_files");
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

    public static final JsonReader<RelocationError> _JSON_READER = new JsonReader<RelocationError>() {

        public final RelocationError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return RelocationError.OTHER;
                }
                switch (tag) {
                    case CANT_COPY_SHARED_FOLDER: return RelocationError.CANT_COPY_SHARED_FOLDER;
                    case CANT_NEST_SHARED_FOLDER: return RelocationError.CANT_NEST_SHARED_FOLDER;
                    case CANT_MOVE_FOLDER_INTO_ITSELF: return RelocationError.CANT_MOVE_FOLDER_INTO_ITSELF;
                    case TOO_MANY_FILES: return RelocationError.TOO_MANY_FILES;
                    case OTHER: return RelocationError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            RelocationError value = null;
            if (tag != null) {
                switch (tag) {
                    case FROM_LOOKUP: {
                        LookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = LookupError._JSON_READER
                            .readField(parser, "from_lookup", v);
                        value = RelocationError.fromLookup(v);
                        break;
                    }
                    case FROM_WRITE: {
                        WriteError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = WriteError._JSON_READER
                            .readField(parser, "from_write", v);
                        value = RelocationError.fromWrite(v);
                        break;
                    }
                    case TO: {
                        WriteError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = WriteError._JSON_READER
                            .readField(parser, "to", v);
                        value = RelocationError.to(v);
                        break;
                    }
                    case CANT_COPY_SHARED_FOLDER: {
                        value = RelocationError.CANT_COPY_SHARED_FOLDER;
                        break;
                    }
                    case CANT_NEST_SHARED_FOLDER: {
                        value = RelocationError.CANT_NEST_SHARED_FOLDER;
                        break;
                    }
                    case CANT_MOVE_FOLDER_INTO_ITSELF: {
                        value = RelocationError.CANT_MOVE_FOLDER_INTO_ITSELF;
                        break;
                    }
                    case TOO_MANY_FILES: {
                        value = RelocationError.TOO_MANY_FILES;
                        break;
                    }
                    case OTHER: {
                        value = RelocationError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return RelocationError.OTHER;
            }
            return value;
        }

    };
}
