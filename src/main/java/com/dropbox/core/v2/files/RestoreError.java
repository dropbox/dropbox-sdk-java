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

public final class RestoreError {
    // union RestoreError

    /**
     * Discriminating tag type for {@link RestoreError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the file.
         */
        PATH_LOOKUP, // LookupError
        /**
         * An error occurs when trying to restore the file to that path.
         */
        PATH_WRITE, // WriteError
        /**
         * The revision is invalid. It may point to a different file.
         */
        INVALID_REVISION,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path_lookup", Tag.PATH_LOOKUP);
        VALUES_.put("path_write", Tag.PATH_WRITE);
        VALUES_.put("invalid_revision", Tag.INVALID_REVISION);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final RestoreError INVALID_REVISION = new RestoreError(Tag.INVALID_REVISION, null, null);
    public static final RestoreError OTHER = new RestoreError(Tag.OTHER, null, null);

    private final Tag tag;
    private final LookupError pathLookupValue;
    private final WriteError pathWriteValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RestoreError(Tag tag, LookupError pathLookupValue, WriteError pathWriteValue) {
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
     * this {@code RestoreError}. </p>
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
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_LOOKUP}.
     *
     * <p> An error occurs when downloading metadata for the file. </p>
     *
     * @param value  {@link RestoreError#pathLookup} value to assign to this
     *     instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError(Tag.PATH_LOOKUP, value, null);
    }

    /**
     * An error occurs when downloading metadata for the file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
     *
     * @return The {@link RestoreError#pathLookup} value associated with this
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
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_WRITE}.
     *
     * <p> An error occurs when trying to restore the file to that path. </p>
     *
     * @param value  {@link RestoreError#pathWrite} value to assign to this
     *     instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError(Tag.PATH_WRITE, null, value);
    }

    /**
     * An error occurs when trying to restore the file to that path.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_WRITE}. </p>
     *
     * @return The {@link RestoreError#pathWrite} value associated with this
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_REVISION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INVALID_REVISION}, {@code false} otherwise.
     */
    public boolean isInvalidRevision() {
        return this.tag == Tag.INVALID_REVISION;
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
        else if (obj instanceof RestoreError) {
            RestoreError other = (RestoreError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case PATH_WRITE:
                    return (this.pathWriteValue == other.pathWriteValue) || (this.pathWriteValue.equals(other.pathWriteValue));
                case INVALID_REVISION:
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

    public static RestoreError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RestoreError> _JSON_WRITER = new JsonWriter<RestoreError>() {
        public final void write(RestoreError x, JsonGenerator g) throws IOException {
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
                case INVALID_REVISION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_revision");
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

    public static final JsonReader<RestoreError> _JSON_READER = new JsonReader<RestoreError>() {

        public final RestoreError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return RestoreError.OTHER;
                }
                switch (tag) {
                    case INVALID_REVISION: return RestoreError.INVALID_REVISION;
                    case OTHER: return RestoreError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            RestoreError value = null;
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
                        value = RestoreError.pathLookup(v);
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
                        value = RestoreError.pathWrite(v);
                        break;
                    }
                    case INVALID_REVISION: {
                        value = RestoreError.INVALID_REVISION;
                        break;
                    }
                    case OTHER: {
                        value = RestoreError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return RestoreError.OTHER;
            }
            return value;
        }

    };
}
