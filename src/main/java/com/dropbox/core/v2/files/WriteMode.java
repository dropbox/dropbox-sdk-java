/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Your intent when writing a file to some path. This is used to determine what
 * constitutes a conflict and what the autorename strategy is. In some
 * situations, the conflict behavior is identical: (a) If the target path
 * doesn't contain anything, the file is always written; no conflict. (b) If the
 * target path contains a folder, it's always a conflict. (c) If the target path
 * contains a file with identical contents, nothing gets written; no conflict.
 * The conflict checking differs in the case where there's a file at the target
 * path with contents different from the contents you're trying to write.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=WriteMode.Serializer.class)
@JsonDeserialize(using=WriteMode.Deserializer.class)
public final class WriteMode {
    // union WriteMode

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    /**
     * Never overwrite the existing file. The autorename strategy is to append a
     * number to the file name. For example, "document.txt" might become
     * "document (2).txt".
     */
    public static final WriteMode ADD = new WriteMode(Tag.ADD, null);
    /**
     * Always overwrite the existing file. The autorename strategy is the same
     * as it is for {@link WriteMode#ADD}.
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code WriteMode}. </p>
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
     * @return {@code true} if this instance is tagged as {@link Tag#ADD},
     *     {@code false} otherwise.
     */
    public boolean isAdd() {
        return this.tag == Tag.ADD;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OVERWRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OVERWRITE},
     *     {@code false} otherwise.
     */
    public boolean isOverwrite() {
        return this.tag == Tag.OVERWRITE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#UPDATE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#UPDATE},
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends UnionJsonSerializer<WriteMode> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(WriteMode.class);
        }

        @Override
        public void serialize(WriteMode value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ADD:
                    g.writeString("add");
                    break;
                case OVERWRITE:
                    g.writeString("overwrite");
                    break;
                case UPDATE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "update");
                    g.writeObjectField("update", value.updateValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<WriteMode, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(WriteMode.class, getTagMapping(), null);
        }

        @Override
        public WriteMode deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ADD: {
                    return WriteMode.ADD;
                }
                case OVERWRITE: {
                    return WriteMode.OVERWRITE;
                }
                case UPDATE: {
                    String value = null;
                    expectField(_p, "update");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return WriteMode.update(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, WriteMode.Tag> getTagMapping() {
            Map<String, WriteMode.Tag> values = new HashMap<String, WriteMode.Tag>();
            values.put("add", WriteMode.Tag.ADD);
            values.put("overwrite", WriteMode.Tag.OVERWRITE);
            values.put("update", WriteMode.Tag.UPDATE);
            return Collections.unmodifiableMap(values);
        }
    }
}
