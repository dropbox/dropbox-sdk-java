/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error results for {@link
 * DbxUserSharingRequests#listReceivedFilesContinue(String)}.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class ListFilesContinueError {
    // union ListFilesContinueError

    /**
     * Discriminating tag type for {@link ListFilesContinueError}.
     */
    public enum Tag {
        /**
         * User account had a problem.
         */
        USER_ERROR, // SharingUserError
        /**
         * the {@code cursor} argument to {@link
         * DbxUserSharingRequests#listReceivedFilesContinue(String)} is invalid.
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
     * the {@code cursor} argument to {@link
     * DbxUserSharingRequests#listReceivedFilesContinue(String)} is invalid.
     */
    public static final ListFilesContinueError INVALID_CURSOR = new ListFilesContinueError(Tag.INVALID_CURSOR, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ListFilesContinueError OTHER = new ListFilesContinueError(Tag.OTHER, null);

    private final Tag tag;
    private final SharingUserError userErrorValue;

    /**
     * Error results for {@link
     * DbxUserSharingRequests#listReceivedFilesContinue(String)}.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ListFilesContinueError(Tag tag, SharingUserError userErrorValue) {
        this.tag = tag;
        this.userErrorValue = userErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ListFilesContinueError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#USER_ERROR},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ERROR}, {@code false} otherwise.
     */
    public boolean isUserError() {
        return this.tag == Tag.USER_ERROR;
    }

    /**
     * Returns an instance of {@code ListFilesContinueError} that has its tag
     * set to {@link Tag#USER_ERROR}.
     *
     * <p> User account had a problem. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ListFilesContinueError} with its tag set to
     *     {@link Tag#USER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ListFilesContinueError userError(SharingUserError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ListFilesContinueError(Tag.USER_ERROR, value);
    }

    /**
     * User account had a problem.
     *
     * <p> This instance must be tagged as {@link Tag#USER_ERROR}. </p>
     *
     * @return The {@link ListFilesContinueError#userError} value associated
     *     with this instance if {@link #isUserError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserError} is {@code false}.
     */
    public SharingUserError getUserErrorValue() {
        if (this.tag != Tag.USER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ERROR, but was Tag." + tag.name());
        }
        return userErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_CURSOR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_CURSOR}, {@code false} otherwise.
     */
    public boolean isInvalidCursor() {
        return this.tag == Tag.INVALID_CURSOR;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            userErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ListFilesContinueError) {
            ListFilesContinueError other = (ListFilesContinueError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case USER_ERROR:
                    return (this.userErrorValue == other.userErrorValue) || (this.userErrorValue.equals(other.userErrorValue));
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
    static final class Serializer extends UnionSerializer<ListFilesContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFilesContinueError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case USER_ERROR: {
                    g.writeStartObject();
                    writeTag("user_error", g);
                    g.writeFieldName("user_error");
                    SharingUserError.Serializer.INSTANCE.serialize(value.userErrorValue, g);
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
        public ListFilesContinueError deserialize(JsonParser p) throws IOException, JsonParseException {
            ListFilesContinueError value;
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
            else if ("user_error".equals(tag)) {
                SharingUserError fieldValue = null;
                expectField("user_error", p);
                fieldValue = SharingUserError.Serializer.INSTANCE.deserialize(p);
                value = ListFilesContinueError.userError(fieldValue);
            }
            else if ("invalid_cursor".equals(tag)) {
                value = ListFilesContinueError.INVALID_CURSOR;
            }
            else {
                value = ListFilesContinueError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
