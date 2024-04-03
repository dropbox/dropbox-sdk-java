/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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
 * Values that correspond to entries in {@link UserFeature}.
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
public final class UserFeatureValue {
    // union users.UserFeatureValue (users.stone)

    /**
     * Discriminating tag type for {@link UserFeatureValue}.
     */
    public enum Tag {
        PAPER_AS_FILES, // PaperAsFilesValue
        FILE_LOCKING, // FileLockingValue
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UserFeatureValue OTHER = new UserFeatureValue().withTag(Tag.OTHER);

    private Tag _tag;
    private PaperAsFilesValue paperAsFilesValue;
    private FileLockingValue fileLockingValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UserFeatureValue() {
    }


    /**
     * Values that correspond to entries in {@link UserFeature}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UserFeatureValue withTag(Tag _tag) {
        UserFeatureValue result = new UserFeatureValue();
        result._tag = _tag;
        return result;
    }

    /**
     * Values that correspond to entries in {@link UserFeature}.
     *
     * @param paperAsFilesValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserFeatureValue withTagAndPaperAsFiles(Tag _tag, PaperAsFilesValue paperAsFilesValue) {
        UserFeatureValue result = new UserFeatureValue();
        result._tag = _tag;
        result.paperAsFilesValue = paperAsFilesValue;
        return result;
    }

    /**
     * Values that correspond to entries in {@link UserFeature}.
     *
     * @param fileLockingValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserFeatureValue withTagAndFileLocking(Tag _tag, FileLockingValue fileLockingValue) {
        UserFeatureValue result = new UserFeatureValue();
        result._tag = _tag;
        result.fileLockingValue = fileLockingValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UserFeatureValue}. </p>
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
     * Tag#PAPER_AS_FILES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PAPER_AS_FILES}, {@code false} otherwise.
     */
    public boolean isPaperAsFiles() {
        return this._tag == Tag.PAPER_AS_FILES;
    }

    /**
     * Returns an instance of {@code UserFeatureValue} that has its tag set to
     * {@link Tag#PAPER_AS_FILES}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserFeatureValue} with its tag set to {@link
     *     Tag#PAPER_AS_FILES}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserFeatureValue paperAsFiles(PaperAsFilesValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserFeatureValue().withTagAndPaperAsFiles(Tag.PAPER_AS_FILES, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PAPER_AS_FILES}.
     *
     * @return The {@link PaperAsFilesValue} value associated with this instance
     *     if {@link #isPaperAsFiles} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPaperAsFiles} is {@code
     *     false}.
     */
    public PaperAsFilesValue getPaperAsFilesValue() {
        if (this._tag != Tag.PAPER_AS_FILES) {
            throw new IllegalStateException("Invalid tag: required Tag.PAPER_AS_FILES, but was Tag." + this._tag.name());
        }
        return paperAsFilesValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FILE_LOCKING}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FILE_LOCKING}, {@code false} otherwise.
     */
    public boolean isFileLocking() {
        return this._tag == Tag.FILE_LOCKING;
    }

    /**
     * Returns an instance of {@code UserFeatureValue} that has its tag set to
     * {@link Tag#FILE_LOCKING}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserFeatureValue} with its tag set to {@link
     *     Tag#FILE_LOCKING}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserFeatureValue fileLocking(FileLockingValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserFeatureValue().withTagAndFileLocking(Tag.FILE_LOCKING, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FILE_LOCKING}.
     *
     * @return The {@link FileLockingValue} value associated with this instance
     *     if {@link #isFileLocking} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFileLocking} is {@code
     *     false}.
     */
    public FileLockingValue getFileLockingValue() {
        if (this._tag != Tag.FILE_LOCKING) {
            throw new IllegalStateException("Invalid tag: required Tag.FILE_LOCKING, but was Tag." + this._tag.name());
        }
        return fileLockingValue;
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
            this._tag,
            this.paperAsFilesValue,
            this.fileLockingValue
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
        else if (obj instanceof UserFeatureValue) {
            UserFeatureValue other = (UserFeatureValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PAPER_AS_FILES:
                    return (this.paperAsFilesValue == other.paperAsFilesValue) || (this.paperAsFilesValue.equals(other.paperAsFilesValue));
                case FILE_LOCKING:
                    return (this.fileLockingValue == other.fileLockingValue) || (this.fileLockingValue.equals(other.fileLockingValue));
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
    static class Serializer extends UnionSerializer<UserFeatureValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserFeatureValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PAPER_AS_FILES: {
                    g.writeStartObject();
                    writeTag("paper_as_files", g);
                    g.writeFieldName("paper_as_files");
                    PaperAsFilesValue.Serializer.INSTANCE.serialize(value.paperAsFilesValue, g);
                    g.writeEndObject();
                    break;
                }
                case FILE_LOCKING: {
                    g.writeStartObject();
                    writeTag("file_locking", g);
                    g.writeFieldName("file_locking");
                    FileLockingValue.Serializer.INSTANCE.serialize(value.fileLockingValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UserFeatureValue deserialize(JsonParser p) throws IOException, JsonParseException {
            UserFeatureValue value;
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
            else if ("paper_as_files".equals(tag)) {
                PaperAsFilesValue fieldValue = null;
                expectField("paper_as_files", p);
                fieldValue = PaperAsFilesValue.Serializer.INSTANCE.deserialize(p);
                value = UserFeatureValue.paperAsFiles(fieldValue);
            }
            else if ("file_locking".equals(tag)) {
                FileLockingValue fieldValue = null;
                expectField("file_locking", p);
                fieldValue = FileLockingValue.Serializer.INSTANCE.deserialize(p);
                value = UserFeatureValue.fileLocking(fieldValue);
            }
            else {
                value = UserFeatureValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
