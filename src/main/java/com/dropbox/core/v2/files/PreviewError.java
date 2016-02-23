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

public final class PreviewError {
    // union PreviewError

    /**
     * Discriminating tag type for {@link PreviewError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the file.
         */
        PATH, // LookupError
        /**
         * This preview generation is still in progress and the file is not
         * ready  for preview yet.
         */
        IN_PROGRESS,
        /**
         * The file extension is not supported preview generation.
         */
        UNSUPPORTED_EXTENSION,
        /**
         * The file content is not supported for preview generation.
         */
        UNSUPPORTED_CONTENT;
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path", Tag.PATH);
        VALUES_.put("in_progress", Tag.IN_PROGRESS);
        VALUES_.put("unsupported_extension", Tag.UNSUPPORTED_EXTENSION);
        VALUES_.put("unsupported_content", Tag.UNSUPPORTED_CONTENT);
    }

    public static final PreviewError IN_PROGRESS = new PreviewError(Tag.IN_PROGRESS, null);
    public static final PreviewError UNSUPPORTED_EXTENSION = new PreviewError(Tag.UNSUPPORTED_EXTENSION, null);
    public static final PreviewError UNSUPPORTED_CONTENT = new PreviewError(Tag.UNSUPPORTED_CONTENT, null);

    private final Tag tag;
    private final LookupError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private PreviewError(Tag tag, LookupError pathValue) {
        this.tag = tag;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code PreviewError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
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
     * Returns an instance of {@code PreviewError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> An error occurs when downloading metadata for the file. </p>
     *
     * @param value  {@link PreviewError#path} value to assign to this instance.
     *
     * @return Instance of {@code PreviewError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PreviewError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PreviewError(Tag.PATH, value);
    }

    /**
     * An error occurs when downloading metadata for the file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link PreviewError#path} value associated with this instance
     *     if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     */
    public boolean isUnsupportedExtension() {
        return this.tag == Tag.UNSUPPORTED_EXTENSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
     */
    public boolean isUnsupportedContent() {
        return this.tag == Tag.UNSUPPORTED_CONTENT;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof PreviewError) {
            PreviewError other = (PreviewError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case IN_PROGRESS:
                    return true;
                case UNSUPPORTED_EXTENSION:
                    return true;
                case UNSUPPORTED_CONTENT:
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

    public static PreviewError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PreviewError> _JSON_WRITER = new JsonWriter<PreviewError>() {
        public final void write(PreviewError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path");
                    g.writeFieldName("path");
                    LookupError._JSON_WRITER.write(x.getPathValue(), g);
                    g.writeEndObject();
                    break;
                case IN_PROGRESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("in_progress");
                    g.writeEndObject();
                    break;
                case UNSUPPORTED_EXTENSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unsupported_extension");
                    g.writeEndObject();
                    break;
                case UNSUPPORTED_CONTENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unsupported_content");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<PreviewError> _JSON_READER = new JsonReader<PreviewError>() {

        public final PreviewError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case IN_PROGRESS: return PreviewError.IN_PROGRESS;
                    case UNSUPPORTED_EXTENSION: return PreviewError.UNSUPPORTED_EXTENSION;
                    case UNSUPPORTED_CONTENT: return PreviewError.UNSUPPORTED_CONTENT;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            PreviewError value = null;
            if (tag != null) {
                switch (tag) {
                    case PATH: {
                        LookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = LookupError._JSON_READER
                            .readField(parser, "path", v);
                        value = PreviewError.path(v);
                        break;
                    }
                    case IN_PROGRESS: {
                        value = PreviewError.IN_PROGRESS;
                        break;
                    }
                    case UNSUPPORTED_EXTENSION: {
                        value = PreviewError.UNSUPPORTED_EXTENSION;
                        break;
                    }
                    case UNSUPPORTED_CONTENT: {
                        value = PreviewError.UNSUPPORTED_CONTENT;
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
