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

public final class DeleteError {
    // union DeleteError

    /**
     * Discriminating tag type for {@link DeleteError}.
     */
    public enum Tag {
        PATH_LOOKUP, // LookupError
        PATH_WRITE, // WriteError
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path_lookup", Tag.PATH_LOOKUP);
        VALUES_.put("path_write", Tag.PATH_WRITE);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final DeleteError OTHER = new DeleteError(Tag.OTHER, null, null);

    private final Tag tag;
    private final LookupError pathLookupValue;
    private final WriteError pathWriteValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private DeleteError(Tag tag, LookupError pathLookupValue, WriteError pathWriteValue) {
        this.tag = tag;
        this.pathLookupValue = pathLookupValue;
        this.pathWriteValue = pathWriteValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code DeleteError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PATH_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#PATH_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPathLookup() {
        return this.tag == Tag.PATH_LOOKUP;
    }

    /**
     * Returns an instance of {@code DeleteError} that has its tag set to {@link
     * Tag#PATH_LOOKUP}.
     *
     * @param value  {@link DeleteError#pathLookup} value to assign to this
     *     instance.
     *
     * @return Instance of {@code DeleteError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static DeleteError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError(Tag.PATH_LOOKUP, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH_LOOKUP}.
     *
     * @return The {@link DeleteError#pathLookup} value associated with this
     *     instance if {@link #isPathLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathLookup} is {@code false}.
     */
    public LookupError getPathLookupValue() {
        if (this.tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + tag.name());
        }
        return pathLookupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH_WRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#PATH_WRITE}, {@code false} otherwise.
     */
    public boolean isPathWrite() {
        return this.tag == Tag.PATH_WRITE;
    }

    /**
     * Returns an instance of {@code DeleteError} that has its tag set to {@link
     * Tag#PATH_WRITE}.
     *
     * @param value  {@link DeleteError#pathWrite} value to assign to this
     *     instance.
     *
     * @return Instance of {@code DeleteError} with its tag set to {@link
     *     Tag#PATH_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static DeleteError pathWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError(Tag.PATH_WRITE, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH_WRITE}.
     *
     * @return The {@link DeleteError#pathWrite} value associated with this
     *     instance if {@link #isPathWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathWrite} is {@code false}.
     */
    public WriteError getPathWriteValue() {
        if (this.tag != Tag.PATH_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_WRITE, but was Tag." + tag.name());
        }
        return pathWriteValue;
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
            pathLookupValue,
            pathWriteValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof DeleteError) {
            DeleteError other = (DeleteError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case PATH_WRITE:
                    return (this.pathWriteValue == other.pathWriteValue) || (this.pathWriteValue.equals(other.pathWriteValue));
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

    public static DeleteError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DeleteError> _JSON_WRITER = new JsonWriter<DeleteError>() {
        public final void write(DeleteError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PATH_LOOKUP:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path_lookup");
                    g.writeFieldName("path_lookup");
                    LookupError._JSON_WRITER.write(x.getPathLookupValue(), g);
                    g.writeEndObject();
                    break;
                case PATH_WRITE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path_write");
                    g.writeFieldName("path_write");
                    WriteError._JSON_WRITER.write(x.getPathWriteValue(), g);
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

    public static final JsonReader<DeleteError> _JSON_READER = new JsonReader<DeleteError>() {

        public final DeleteError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return DeleteError.OTHER;
                }
                switch (tag) {
                    case OTHER: return DeleteError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            DeleteError value = null;
            if (tag != null) {
                switch (tag) {
                    case PATH_LOOKUP: {
                        LookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = LookupError._JSON_READER
                            .readField(parser, "path_lookup", v);
                        value = DeleteError.pathLookup(v);
                        break;
                    }
                    case PATH_WRITE: {
                        WriteError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = WriteError._JSON_READER
                            .readField(parser, "path_write", v);
                        value = DeleteError.pathWrite(v);
                        break;
                    }
                    case OTHER: {
                        value = DeleteError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return DeleteError.OTHER;
            }
            return value;
        }

    };
}
