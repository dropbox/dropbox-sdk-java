/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class GetSharedLinksError {
    // union GetSharedLinksError

    /**
     * Discriminating tag type for {@link GetSharedLinksError}.
     */
    public enum Tag {
        PATH, // String
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path", Tag.PATH);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final GetSharedLinksError OTHER = new GetSharedLinksError(Tag.OTHER, null);

    private final Tag tag;
    private final String pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GetSharedLinksError(Tag tag, String pathValue) {
        this.tag = tag;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GetSharedLinksError}. </p>
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
     * Returns an instance of {@code GetSharedLinksError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * @param value  {@link GetSharedLinksError#path} value to assign to this
     *     instance.
     *
     * @return Instance of {@code GetSharedLinksError} with its tag set to
     *     {@link Tag#PATH}.
     */
    public static GetSharedLinksError path(String value) {
        return new GetSharedLinksError(Tag.PATH, value);
    }

    /**
     * Returns an instance of {@code GetSharedLinksError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * @return Instance of {@code GetSharedLinksError} with its tag set to
     *     {@link Tag#PATH}.
     */
    public static GetSharedLinksError path() {
        return path(null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link GetSharedLinksError#path} value associated with this
     *     instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public String getPathValue() {
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
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GetSharedLinksError) {
            GetSharedLinksError other = (GetSharedLinksError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue != null && this.pathValue.equals(other.pathValue));
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

    public static GetSharedLinksError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetSharedLinksError> _JSON_WRITER = new JsonWriter<GetSharedLinksError>() {
        public final void write(GetSharedLinksError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path");
                    if (x.getPathValue() != null) {
                        g.writeFieldName("path");
                        g.writeString(x.getPathValue());
                    }
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

    public static final JsonReader<GetSharedLinksError> _JSON_READER = new JsonReader<GetSharedLinksError>() {

        public final GetSharedLinksError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return GetSharedLinksError.OTHER;
                }
                switch (tag) {
                    case PATH: return GetSharedLinksError.path();
                    case OTHER: return GetSharedLinksError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            GetSharedLinksError value = null;
            if (tag != null) {
                switch (tag) {
                    case PATH: {
                        if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                            value = GetSharedLinksError.path();
                            break;
                        }
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "path", v);
                        value = GetSharedLinksError.path(v);
                        break;
                    }
                    case OTHER: {
                        value = GetSharedLinksError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return GetSharedLinksError.OTHER;
            }
            return value;
        }

    };
}
