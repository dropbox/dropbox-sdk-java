/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
public final class FileLockContent {
    // union files.FileLockContent (files.stone)

    /**
     * Discriminating tag type for {@link FileLockContent}.
     */
    public enum Tag {
        /**
         * Empty type to indicate no lock.
         */
        UNLOCKED,
        /**
         * A lock held by a single user.
         */
        SINGLE_USER, // SingleUserLock
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
     * Empty type to indicate no lock.
     */
    public static final FileLockContent UNLOCKED = new FileLockContent().withTag(Tag.UNLOCKED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final FileLockContent OTHER = new FileLockContent().withTag(Tag.OTHER);

    private Tag _tag;
    private SingleUserLock singleUserValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FileLockContent() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FileLockContent withTag(Tag _tag) {
        FileLockContent result = new FileLockContent();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param singleUserValue  A lock held by a single user. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FileLockContent withTagAndSingleUser(Tag _tag, SingleUserLock singleUserValue) {
        FileLockContent result = new FileLockContent();
        result._tag = _tag;
        result.singleUserValue = singleUserValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FileLockContent}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#UNLOCKED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UNLOCKED},
     *     {@code false} otherwise.
     */
    public boolean isUnlocked() {
        return this._tag == Tag.UNLOCKED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SINGLE_USER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SINGLE_USER}, {@code false} otherwise.
     */
    public boolean isSingleUser() {
        return this._tag == Tag.SINGLE_USER;
    }

    /**
     * Returns an instance of {@code FileLockContent} that has its tag set to
     * {@link Tag#SINGLE_USER}.
     *
     * <p> A lock held by a single user. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileLockContent} with its tag set to {@link
     *     Tag#SINGLE_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FileLockContent singleUser(SingleUserLock value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileLockContent().withTagAndSingleUser(Tag.SINGLE_USER, value);
    }

    /**
     * A lock held by a single user.
     *
     * <p> This instance must be tagged as {@link Tag#SINGLE_USER}. </p>
     *
     * @return The {@link SingleUserLock} value associated with this instance if
     *     {@link #isSingleUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSingleUser} is {@code false}.
     */
    public SingleUserLock getSingleUserValue() {
        if (this._tag != Tag.SINGLE_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.SINGLE_USER, but was Tag." + this._tag.name());
        }
        return singleUserValue;
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
            singleUserValue
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
        else if (obj instanceof FileLockContent) {
            FileLockContent other = (FileLockContent) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case UNLOCKED:
                    return true;
                case SINGLE_USER:
                    return (this.singleUserValue == other.singleUserValue) || (this.singleUserValue.equals(other.singleUserValue));
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
    static class Serializer extends UnionSerializer<FileLockContent> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileLockContent value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case UNLOCKED: {
                    g.writeString("unlocked");
                    break;
                }
                case SINGLE_USER: {
                    g.writeStartObject();
                    writeTag("single_user", g);
                    SingleUserLock.Serializer.INSTANCE.serialize(value.singleUserValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileLockContent deserialize(JsonParser p) throws IOException, JsonParseException {
            FileLockContent value;
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
            else if ("unlocked".equals(tag)) {
                value = FileLockContent.UNLOCKED;
            }
            else if ("single_user".equals(tag)) {
                SingleUserLock fieldValue = null;
                fieldValue = SingleUserLock.Serializer.INSTANCE.deserialize(p, true);
                value = FileLockContent.singleUser(fieldValue);
            }
            else {
                value = FileLockContent.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
