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

/**
 * Your intent when writing a file to some path. This is used to determine what
 * constitutes a conflict and what the autorename strategy is. In some
 * situations, the conflict behavior is identical: (a) If the target path
 * doesn't contain anything, the file is always written; no conflict. (b) If the
 * target path contains a folder, it's always a conflict. (c) If the target path
 * contains a file with identical contents, nothing gets written; no conflict.
 * The conflict checking differs in the case where there's a file at the target
 * path with contents different from the contents you're trying to write.
 */
public final class WriteMode {
    // union WriteMode

    /**
     * Discriminating tag type for {@link WriteMode}.
     */
    public enum Tag {
        /**
         * Never overwrite the existing file. The autorename strategy is to
         * append a number to the file name. For example, "document.txt" might
         * become "document (2).txt".
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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("add", Tag.ADD);
        VALUES_.put("overwrite", Tag.OVERWRITE);
        VALUES_.put("update", Tag.UPDATE);
    }

    public static final WriteMode ADD = new WriteMode(Tag.ADD, null);
    public static final WriteMode OVERWRITE = new WriteMode(Tag.OVERWRITE, null);

    private final Tag tag;
    private final String updateValue;

    /**
     * Your intent when writing a file to some path. This is used to determine
     * what constitutes a conflict and what the autorename strategy is. In some
     * situations, the conflict behavior is identical: (a) If the target path
     * doesn't contain anything, the file is always written; no conflict. (b) If
     * the target path contains a folder, it's always a conflict. (c) If the
     * target path contains a file with identical contents, nothing gets
     * written; no conflict. The conflict checking differs in the case where
     * there's a file at the target path with contents different from the
     * contents you're trying to write.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private WriteMode(Tag tag, String updateValue) {
        this.tag = tag;
        this.updateValue = updateValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code WriteMode}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ADD}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#ADD},
     *     {@code false} otherwise.
     */
    public boolean isAdd() {
        return this.tag == Tag.ADD;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OVERWRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#OVERWRITE}, {@code false} otherwise.
     */
    public boolean isOverwrite() {
        return this.tag == Tag.OVERWRITE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#UPDATE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#UPDATE},
     *     {@code false} otherwise.
     */
    public boolean isUpdate() {
        return this.tag == Tag.UPDATE;
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
     * @param value  {@link WriteMode#update} value to assign to this instance.
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
        if (!java.util.regex.Pattern.matches("[0-9a-f]+", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new WriteMode(Tag.UPDATE, value);
    }

    /**
     * Overwrite if the given "rev" matches the existing file's "rev". The
     * autorename strategy is to append the string "conflicted copy" to the file
     * name. For example, "document.txt" might become "document (conflicted
     * copy).txt" or "document (Panda's conflicted copy).txt".
     *
     * <p> This instance must be tagged as {@link Tag#UPDATE}. </p>
     *
     * @return The {@link WriteMode#update} value associated with this instance
     *     if {@link #isUpdate} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUpdate} is {@code false}.
     */
    public String getUpdateValue() {
        if (this.tag != Tag.UPDATE) {
            throw new IllegalStateException("Invalid tag: required Tag.UPDATE, but was Tag." + tag.name());
        }
        return updateValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            updateValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof WriteMode) {
            WriteMode other = (WriteMode) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static WriteMode fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<WriteMode> _JSON_WRITER = new JsonWriter<WriteMode>() {
        public final void write(WriteMode x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ADD:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("add");
                    g.writeEndObject();
                    break;
                case OVERWRITE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("overwrite");
                    g.writeEndObject();
                    break;
                case UPDATE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("update");
                    g.writeFieldName("update");
                    g.writeString(x.getUpdateValue());
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<WriteMode> _JSON_READER = new JsonReader<WriteMode>() {

        public final WriteMode read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case ADD: return WriteMode.ADD;
                    case OVERWRITE: return WriteMode.OVERWRITE;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            WriteMode value = null;
            if (tag != null) {
                switch (tag) {
                    case ADD: {
                        value = WriteMode.ADD;
                        break;
                    }
                    case OVERWRITE: {
                        value = WriteMode.OVERWRITE;
                        break;
                    }
                    case UPDATE: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "update", v);
                        value = WriteMode.update(v);
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
