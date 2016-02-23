/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class ListFolderMembersContinueError {
    // union ListFolderMembersContinueError

    /**
     * Discriminating tag type for {@link ListFolderMembersContinueError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * {@link ListFolderMembersContinueArg#getCursor} is invalid.
         */
        INVALID_CURSOR,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("invalid_cursor", Tag.INVALID_CURSOR);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final ListFolderMembersContinueError INVALID_CURSOR = new ListFolderMembersContinueError(Tag.INVALID_CURSOR, null);
    public static final ListFolderMembersContinueError OTHER = new ListFolderMembersContinueError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ListFolderMembersContinueError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code ListFolderMembersContinueError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code ListFolderMembersContinueError} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link ListFolderMembersContinueError#accessError} value to
     *     assign to this instance.
     *
     * @return Instance of {@code ListFolderMembersContinueError} with its tag
     *     set to {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ListFolderMembersContinueError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFolderMembersContinueError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link ListFolderMembersContinueError#accessError} value
     *     associated with this instance if {@link #isAccessError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_CURSOR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INVALID_CURSOR}, {@code false} otherwise.
     */
    public boolean isInvalidCursor() {
        return this.tag == Tag.INVALID_CURSOR;
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
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ListFolderMembersContinueError) {
            ListFolderMembersContinueError other = (ListFolderMembersContinueError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case INVALID_CURSOR:
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

    public static ListFolderMembersContinueError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderMembersContinueError> _JSON_WRITER = new JsonWriter<ListFolderMembersContinueError>() {
        public final void write(ListFolderMembersContinueError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case INVALID_CURSOR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_cursor");
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

    public static final JsonReader<ListFolderMembersContinueError> _JSON_READER = new JsonReader<ListFolderMembersContinueError>() {

        public final ListFolderMembersContinueError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return ListFolderMembersContinueError.OTHER;
                }
                switch (tag) {
                    case INVALID_CURSOR: return ListFolderMembersContinueError.INVALID_CURSOR;
                    case OTHER: return ListFolderMembersContinueError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            ListFolderMembersContinueError value = null;
            if (tag != null) {
                switch (tag) {
                    case ACCESS_ERROR: {
                        SharedFolderAccessError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderAccessError._JSON_READER
                            .readField(parser, "access_error", v);
                        value = ListFolderMembersContinueError.accessError(v);
                        break;
                    }
                    case INVALID_CURSOR: {
                        value = ListFolderMembersContinueError.INVALID_CURSOR;
                        break;
                    }
                    case OTHER: {
                        value = ListFolderMembersContinueError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return ListFolderMembersContinueError.OTHER;
            }
            return value;
        }

    };
}
