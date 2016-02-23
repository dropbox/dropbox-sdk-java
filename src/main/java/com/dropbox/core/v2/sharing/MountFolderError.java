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

public final class MountFolderError {
    // union MountFolderError

    /**
     * Discriminating tag type for {@link MountFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * Mounting would cause a shared folder to be inside another, which is
         * disallowed.
         */
        INSIDE_SHARED_FOLDER,
        /**
         * The current user does not have enough space to mount the shared
         * folder.
         */
        INSUFFICIENT_QUOTA,
        /**
         * The shared folder is already mounted.
         */
        ALREADY_MOUNTED,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("inside_shared_folder", Tag.INSIDE_SHARED_FOLDER);
        VALUES_.put("insufficient_quota", Tag.INSUFFICIENT_QUOTA);
        VALUES_.put("already_mounted", Tag.ALREADY_MOUNTED);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final MountFolderError INSIDE_SHARED_FOLDER = new MountFolderError(Tag.INSIDE_SHARED_FOLDER, null);
    public static final MountFolderError INSUFFICIENT_QUOTA = new MountFolderError(Tag.INSUFFICIENT_QUOTA, null);
    public static final MountFolderError ALREADY_MOUNTED = new MountFolderError(Tag.ALREADY_MOUNTED, null);
    public static final MountFolderError OTHER = new MountFolderError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MountFolderError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code MountFolderError}. </p>
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
     * Returns an instance of {@code MountFolderError} that has its tag set to
     * {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link MountFolderError#accessError} value to assign to
     *     this instance.
     *
     * @return Instance of {@code MountFolderError} with its tag set to {@link
     *     Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MountFolderError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MountFolderError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link MountFolderError#accessError} value associated with
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
     * Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isInsideSharedFolder() {
        return this.tag == Tag.INSIDE_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     */
    public boolean isInsufficientQuota() {
        return this.tag == Tag.INSUFFICIENT_QUOTA;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     */
    public boolean isAlreadyMounted() {
        return this.tag == Tag.ALREADY_MOUNTED;
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
        else if (obj instanceof MountFolderError) {
            MountFolderError other = (MountFolderError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case INSIDE_SHARED_FOLDER:
                    return true;
                case INSUFFICIENT_QUOTA:
                    return true;
                case ALREADY_MOUNTED:
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

    public static MountFolderError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MountFolderError> _JSON_WRITER = new JsonWriter<MountFolderError>() {
        public final void write(MountFolderError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case INSIDE_SHARED_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("inside_shared_folder");
                    g.writeEndObject();
                    break;
                case INSUFFICIENT_QUOTA:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("insufficient_quota");
                    g.writeEndObject();
                    break;
                case ALREADY_MOUNTED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("already_mounted");
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

    public static final JsonReader<MountFolderError> _JSON_READER = new JsonReader<MountFolderError>() {

        public final MountFolderError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return MountFolderError.OTHER;
                }
                switch (tag) {
                    case INSIDE_SHARED_FOLDER: return MountFolderError.INSIDE_SHARED_FOLDER;
                    case INSUFFICIENT_QUOTA: return MountFolderError.INSUFFICIENT_QUOTA;
                    case ALREADY_MOUNTED: return MountFolderError.ALREADY_MOUNTED;
                    case OTHER: return MountFolderError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            MountFolderError value = null;
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
                        value = MountFolderError.accessError(v);
                        break;
                    }
                    case INSIDE_SHARED_FOLDER: {
                        value = MountFolderError.INSIDE_SHARED_FOLDER;
                        break;
                    }
                    case INSUFFICIENT_QUOTA: {
                        value = MountFolderError.INSUFFICIENT_QUOTA;
                        break;
                    }
                    case ALREADY_MOUNTED: {
                        value = MountFolderError.ALREADY_MOUNTED;
                        break;
                    }
                    case OTHER: {
                        value = MountFolderError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return MountFolderError.OTHER;
            }
            return value;
        }

    };
}
