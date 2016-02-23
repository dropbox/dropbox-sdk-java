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

public final class LookupError {
    // union LookupError

    /**
     * Discriminating tag type for {@link LookupError}.
     */
    public enum Tag {
        MALFORMED_PATH, // String
        /**
         * There is nothing at the given path.
         */
        NOT_FOUND,
        /**
         * We were expecting a file, but the given path refers to something that
         * isn't a file.
         */
        NOT_FILE,
        /**
         * We were expecting a folder, but the given path refers to something
         * that isn't a folder.
         */
        NOT_FOLDER,
        /**
         * The file cannot be transferred because the content is restricted.
         * For example, sometimes there are legal restrictions due to copyright
         * claims.
         */
        RESTRICTED_CONTENT,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("malformed_path", Tag.MALFORMED_PATH);
        VALUES_.put("not_found", Tag.NOT_FOUND);
        VALUES_.put("not_file", Tag.NOT_FILE);
        VALUES_.put("not_folder", Tag.NOT_FOLDER);
        VALUES_.put("restricted_content", Tag.RESTRICTED_CONTENT);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final LookupError NOT_FOUND = new LookupError(Tag.NOT_FOUND, null);
    public static final LookupError NOT_FILE = new LookupError(Tag.NOT_FILE, null);
    public static final LookupError NOT_FOLDER = new LookupError(Tag.NOT_FOLDER, null);
    public static final LookupError RESTRICTED_CONTENT = new LookupError(Tag.RESTRICTED_CONTENT, null);
    public static final LookupError OTHER = new LookupError(Tag.OTHER, null);

    private final Tag tag;
    private final String malformedPathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private LookupError(Tag tag, String malformedPathValue) {
        this.tag = tag;
        this.malformedPathValue = malformedPathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code LookupError}. </p>
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
     * Returns an instance of {@code LookupError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @param value  {@link LookupError#malformedPath} value to assign to this
     *     instance.
     *
     * @return Instance of {@code LookupError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static LookupError malformedPath(String value) {
        return new LookupError(Tag.MALFORMED_PATH, value);
    }

    /**
     * Returns an instance of {@code LookupError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @return Instance of {@code LookupError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static LookupError malformedPath() {
        return malformedPath(null);
    }

    /**
     * This instance must be tagged as {@link Tag#MALFORMED_PATH}.
     *
     * @return The {@link LookupError#malformedPath} value associated with this
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
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FILE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NOT_FILE}, {@code false} otherwise.
     */
    public boolean isNotFile() {
        return this.tag == Tag.NOT_FILE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOLDER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NOT_FOLDER}, {@code false} otherwise.
     */
    public boolean isNotFolder() {
        return this.tag == Tag.NOT_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     */
    public boolean isRestrictedContent() {
        return this.tag == Tag.RESTRICTED_CONTENT;
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
            malformedPathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof LookupError) {
            LookupError other = (LookupError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case MALFORMED_PATH:
                    return (this.malformedPathValue == other.malformedPathValue) || (this.malformedPathValue != null && this.malformedPathValue.equals(other.malformedPathValue));
                case NOT_FOUND:
                    return true;
                case NOT_FILE:
                    return true;
                case NOT_FOLDER:
                    return true;
                case RESTRICTED_CONTENT:
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

    public static LookupError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<LookupError> _JSON_WRITER = new JsonWriter<LookupError>() {
        public final void write(LookupError x, JsonGenerator g) throws IOException {
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
                case NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_found");
                    g.writeEndObject();
                    break;
                case NOT_FILE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_file");
                    g.writeEndObject();
                    break;
                case NOT_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_folder");
                    g.writeEndObject();
                    break;
                case RESTRICTED_CONTENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("restricted_content");
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

    public static final JsonReader<LookupError> _JSON_READER = new JsonReader<LookupError>() {

        public final LookupError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return LookupError.OTHER;
                }
                switch (tag) {
                    case MALFORMED_PATH: return LookupError.malformedPath();
                    case NOT_FOUND: return LookupError.NOT_FOUND;
                    case NOT_FILE: return LookupError.NOT_FILE;
                    case NOT_FOLDER: return LookupError.NOT_FOLDER;
                    case RESTRICTED_CONTENT: return LookupError.RESTRICTED_CONTENT;
                    case OTHER: return LookupError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            LookupError value = null;
            if (tag != null) {
                switch (tag) {
                    case MALFORMED_PATH: {
                        if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                            value = LookupError.malformedPath();
                            break;
                        }
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "malformed_path", v);
                        value = LookupError.malformedPath(v);
                        break;
                    }
                    case NOT_FOUND: {
                        value = LookupError.NOT_FOUND;
                        break;
                    }
                    case NOT_FILE: {
                        value = LookupError.NOT_FILE;
                        break;
                    }
                    case NOT_FOLDER: {
                        value = LookupError.NOT_FOLDER;
                        break;
                    }
                    case RESTRICTED_CONTENT: {
                        value = LookupError.RESTRICTED_CONTENT;
                        break;
                    }
                    case OTHER: {
                        value = LookupError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return LookupError.OTHER;
            }
            return value;
        }

    };
}
