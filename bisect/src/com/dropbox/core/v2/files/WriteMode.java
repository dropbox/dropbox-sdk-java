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
import java.util.regex.Pattern;

/**
 * Your intent when writing a file to some path. This is used to determine what
 * constitutes a conflict and what the autorename strategy is. In some
 * situations, the conflict behavior is identical: (a) If the target path
 * doesn't refer to anything, the file is always written; no conflict. (b) If
 * the target path refers to a folder, it's always a conflict. (c) If the target
 * path refers to a file with identical contents, nothing gets written; no
 * conflict. The conflict checking differs in the case where there's a file at
 * the target path with contents different from the contents you're trying to
 * write.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class WriteMode {
    // union files.WriteMode (files.stone)

    /**
     * Discriminating tag type for {@link WriteMode}.
     */
    public enum Tag {
        /**
         * Do not overwrite an existing file if there is a conflict. The
         * autorename strategy is to append a number to the file name. For
         * example, "document.txt" might become "document (2).txt".
         */
        ADD,
        /**
         * Always overwrite the existing file. The autorename strategy is the
         * same as it is for {@link WriteMode#ADD}.
         */
        OVERWRITE,
        /**
         * Overwrite if the given "rev" matches the existing file's "rev". The
         * autorename strategy is to append the string "conflicted copy" to the
         * file name. For example, "document.txt" might become "document
         * (conflicted copy).txt" or "document (Panda's conflicted copy).txt".
         */
        UPDATE; // String
    }

    /**
     * Do not overwrite an existing file if there is a conflict. The autorename
     * strategy is to append a number to the file name. For example,
     * "document.txt" might become "document (2).txt".
     */
    public static final WriteMode ADD = new WriteMode().withTag(Tag.ADD);
    /**
     * Always overwrite the existing file. The autorename strategy is the same
     * as it is for {@link WriteMode#ADD}.
     */
    public static final WriteMode OVERWRITE = new WriteMode().withTag(Tag.OVERWRITE);

    private Tag _tag;
    private String updateValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private WriteMode() {
    }


    /**
     * Your intent when writing a file to some path. This is used to determine
     * what constitutes a conflict and what the autorename strategy is. In some
     * situations, the conflict behavior is identical: (a) If the target path
     * doesn't refer to anything, the file is always written; no conflict. (b)
     * If the target path refers to a folder, it's always a conflict. (c) If the
     * target path refers to a file with identical contents, nothing gets
     * written; no conflict. The conflict checking differs in the case where
     * there's a file at the target path with contents different from the
     * contents you're trying to write.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private WriteMode withTag(Tag _tag) {
        WriteMode result = new WriteMode();
        result._tag = _tag;
        return result;
    }

    /**
     * Your intent when writing a file to some path. This is used to determine
     * what constitutes a conflict and what the autorename strategy is. In some
     * situations, the conflict behavior is identical: (a) If the target path
     * doesn't refer to anything, the file is always written; no conflict. (b)
     * If the target path refers to a folder, it's always a conflict. (c) If the
     * target path refers to a file with identical contents, nothing gets
     * written; no conflict. The conflict checking differs in the case where
     * there's a file at the target path with contents different from the
     * contents you're trying to write.
     *
     * @param updateValue  Overwrite if the given "rev" matches the existing
     *     file's "rev". The autorename strategy is to append the string
     *     "conflicted copy" to the file name. For example, "document.txt" might
     *     become "document (conflicted copy).txt" or "document (Panda's
     *     conflicted copy).txt". Must have length of at least 9, match pattern
     *     "{@code [0-9a-f]+}", and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private WriteMode withTagAndUpdate(Tag _tag, String updateValue) {
        WriteMode result = new WriteMode();
        result._tag = _tag;
        result.updateValue = updateValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code WriteMode}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ADD}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ADD},
     *     {@code false} otherwise.
     */
    public boolean isAdd() {
        return this._tag == Tag.ADD;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OVERWRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OVERWRITE},
     *     {@code false} otherwise.
     */
    public boolean isOverwrite() {
        return this._tag == Tag.OVERWRITE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#UPDATE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UPDATE},
     *     {@code false} otherwise.
     */
    public boolean isUpdate() {
        return this._tag == Tag.UPDATE;
    }

    /**
     * Returns an instance of {@code WriteMode} that has its tag set to {@link
     * Tag#UPDATE}.
     *
     * <p> Overwrite if the given "rev" matches the existing file's "rev". The
     * autorename strategy is to append the string "conflicted copy" to the file
     * name. For example, "document.txt" might become "document (conflicted
     * copy).txt" or "document (Panda's conflicted copy).txt". </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code WriteMode} with its tag set to {@link
     *     Tag#UPDATE}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 9,
     *     does not match pattern "{@code [0-9a-f]+}", or is {@code null}.
     */
    public static WriteMode update(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 9) {
            throw new IllegalArgumentException("String is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new WriteMode().withTagAndUpdate(Tag.UPDATE, value);
    }

    /**
     * Overwrite if the given "rev" matches the existing file's "rev". The
     * autorename strategy is to append the string "conflicted copy" to the file
     * name. For example, "document.txt" might become "document (conflicted
     * copy).txt" or "document (Panda's conflicted copy).txt".
     *
     * <p> This instance must be tagged as {@link Tag#UPDATE}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isUpdate} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUpdate} is {@code false}.
     */
    public String getUpdateValue() {
        if (this._tag != Tag.UPDATE) {
            throw new IllegalStateException("Invalid tag: required Tag.UPDATE, but was Tag." + this._tag.name());
        }
        return updateValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            updateValue
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
        else if (obj instanceof WriteMode) {
            WriteMode other = (WriteMode) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ADD:
                    return true;
                case OVERWRITE:
                    return true;
                case UPDATE:
                    return (this.updateValue == other.updateValue) || (this.updateValue.equals(other.updateValue));
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
    static class Serializer extends UnionSerializer<WriteMode> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WriteMode value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ADD: {
                    g.writeString("add");
                    break;
                }
                case OVERWRITE: {
                    g.writeString("overwrite");
                    break;
                }
                case UPDATE: {
                    g.writeStartObject();
                    writeTag("update", g);
                    g.writeFieldName("update");
                    StoneSerializers.string().serialize(value.updateValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public WriteMode deserialize(JsonParser p) throws IOException, JsonParseException {
            WriteMode value;
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
            else if ("add".equals(tag)) {
                value = WriteMode.ADD;
            }
            else if ("overwrite".equals(tag)) {
                value = WriteMode.OVERWRITE;
            }
            else if ("update".equals(tag)) {
                String fieldValue = null;
                expectField("update", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = WriteMode.update(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
