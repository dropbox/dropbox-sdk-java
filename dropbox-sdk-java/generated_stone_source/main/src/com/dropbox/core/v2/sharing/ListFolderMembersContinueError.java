/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class ListFolderMembersContinueError {
    // union sharing.ListFolderMembersContinueError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link ListFolderMembersContinueError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * {@link ListFolderMembersContinueArg#getCursor} is invalid.
         */
        INVALID_CURSOR,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * {@link ListFolderMembersContinueArg#getCursor} is invalid.
     */
    public static final ListFolderMembersContinueError INVALID_CURSOR = new ListFolderMembersContinueError().withTag(Tag.INVALID_CURSOR);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ListFolderMembersContinueError OTHER = new ListFolderMembersContinueError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ListFolderMembersContinueError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ListFolderMembersContinueError withTag(Tag _tag) {
        ListFolderMembersContinueError result = new ListFolderMembersContinueError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ListFolderMembersContinueError withTagAndAccessError(Tag _tag, SharedFolderAccessError accessErrorValue) {
        ListFolderMembersContinueError result = new ListFolderMembersContinueError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ListFolderMembersContinueError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code ListFolderMembersContinueError} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
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
        return new ListFolderMembersContinueError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link SharedFolderAccessError} value associated with this
     *     instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_CURSOR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_CURSOR}, {@code false} otherwise.
     */
    public boolean isInvalidCursor() {
        return this._tag == Tag.INVALID_CURSOR;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        else if (obj instanceof ListFolderMembersContinueError) {
            ListFolderMembersContinueError other = (ListFolderMembersContinueError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<ListFolderMembersContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFolderMembersContinueError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case INVALID_CURSOR: {
                    g.writeString("invalid_cursor");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ListFolderMembersContinueError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListFolderMembersContinueError value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("access_error".equals(tag)) {
                SharedFolderAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharedFolderAccessError.Serializer.INSTANCE.deserialize(p);
                value = ListFolderMembersContinueError.accessError(fieldValue);
            }
            else if ("invalid_cursor".equals(tag)) {
                value = ListFolderMembersContinueError.INVALID_CURSOR;
            }
            else {
                value = ListFolderMembersContinueError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
