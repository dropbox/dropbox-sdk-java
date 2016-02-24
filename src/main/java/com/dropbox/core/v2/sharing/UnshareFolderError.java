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

public final class UnshareFolderError {
    // union UnshareFolderError

    /**
     * Discriminating tag type for {@link UnshareFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * This action cannot be performed on a team shared folder.
         */
        TEAM_FOLDER,
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("team_folder", Tag.TEAM_FOLDER);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final UnshareFolderError TEAM_FOLDER = new UnshareFolderError(Tag.TEAM_FOLDER, null);
    public static final UnshareFolderError NO_PERMISSION = new UnshareFolderError(Tag.NO_PERMISSION, null);
    public static final UnshareFolderError OTHER = new UnshareFolderError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UnshareFolderError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UnshareFolderError}. </p>
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
     * Returns an instance of {@code UnshareFolderError} that has its tag set to
     * {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link UnshareFolderError#accessError} value to assign to
     *     this instance.
     *
     * @return Instance of {@code UnshareFolderError} with its tag set to {@link
     *     Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UnshareFolderError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UnshareFolderError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link UnshareFolderError#accessError} value associated with
     *     this instance if {@link #isAccessError} is {@code true}.
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
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this.tag == Tag.TEAM_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
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
        else if (obj instanceof UnshareFolderError) {
            UnshareFolderError other = (UnshareFolderError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case TEAM_FOLDER:
                    return true;
                case NO_PERMISSION:
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

    public static UnshareFolderError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UnshareFolderError> _JSON_WRITER = new JsonWriter<UnshareFolderError>() {
        public final void write(UnshareFolderError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case TEAM_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_folder");
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
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

    public static final JsonReader<UnshareFolderError> _JSON_READER = new JsonReader<UnshareFolderError>() {

        public final UnshareFolderError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return UnshareFolderError.OTHER;
                }
                switch (tag) {
                    case TEAM_FOLDER: return UnshareFolderError.TEAM_FOLDER;
                    case NO_PERMISSION: return UnshareFolderError.NO_PERMISSION;
                    case OTHER: return UnshareFolderError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            UnshareFolderError value = null;
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
                        value = UnshareFolderError.accessError(v);
                        break;
                    }
                    case TEAM_FOLDER: {
                        value = UnshareFolderError.TEAM_FOLDER;
                        break;
                    }
                    case NO_PERMISSION: {
                        value = UnshareFolderError.NO_PERMISSION;
                        break;
                    }
                    case OTHER: {
                        value = UnshareFolderError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return UnshareFolderError.OTHER;
            }
            return value;
        }

    };
}
