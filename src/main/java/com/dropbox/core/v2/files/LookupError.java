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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=LookupError.Serializer.class)
@JsonDeserialize(using=LookupError.Deserializer.class)
public final class LookupError {
    // union LookupError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link LookupError}.
     */
    public enum Tag {
        MALFORMED_PATH, // String
        /**
         * There is nothing at the given path.
         */
        NOT_FOUND,
        /**
         * We were expecting a file, but the given path refers to something that
         * isn't a file.
         */
        NOT_FILE,
        /**
         * We were expecting a folder, but the given path refers to something
         * that isn't a folder.
         */
        NOT_FOLDER,
        /**
         * The file cannot be transferred because the content is restricted.
         * For example, sometimes there are legal restrictions due to copyright
         * claims.
         */
        RESTRICTED_CONTENT,
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
     * There is nothing at the given path.
     */
    public static final LookupError NOT_FOUND = new LookupError(Tag.NOT_FOUND, null);
    /**
     * We were expecting a file, but the given path refers to something that
     * isn't a file.
     */
    public static final LookupError NOT_FILE = new LookupError(Tag.NOT_FILE, null);
    /**
     * We were expecting a folder, but the given path refers to something that
     * isn't a folder.
     */
    public static final LookupError NOT_FOLDER = new LookupError(Tag.NOT_FOLDER, null);
    /**
     * The file cannot be transferred because the content is restricted.  For
     * example, sometimes there are legal restrictions due to copyright claims.
     */
    public static final LookupError RESTRICTED_CONTENT = new LookupError(Tag.RESTRICTED_CONTENT, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final LookupError OTHER = new LookupError(Tag.OTHER, null);

    private final Tag tag;
    private final String malformedPathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private LookupError(Tag tag, String malformedPathValue) {
        this.tag = tag;
        this.malformedPathValue = malformedPathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LookupError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MALFORMED_PATH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MALFORMED_PATH}, {@code false} otherwise.
     */
    public boolean isMalformedPath() {
        return this.tag == Tag.MALFORMED_PATH;
    }

    /**
     * Returns an instance of {@code LookupError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LookupError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static LookupError malformedPath(String value) {
        return new LookupError(Tag.MALFORMED_PATH, value);
    }

    /**
     * Returns an instance of {@code LookupError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @return Instance of {@code LookupError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static LookupError malformedPath() {
        return malformedPath(null);
    }

    /**
     * This instance must be tagged as {@link Tag#MALFORMED_PATH}.
     *
     * @return The {@link LookupError#malformedPath} value associated with this
     *     instance if {@link #isMalformedPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
     *     false}.
     */
    public String getMalformedPathValue() {
        if (this.tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + tag.name());
        }
        return malformedPathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FOUND},
     *     {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this.tag == Tag.NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FILE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FILE},
     *     {@code false} otherwise.
     */
    public boolean isNotFile() {
        return this.tag == Tag.NOT_FILE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOLDER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_FOLDER}, {@code false} otherwise.
     */
    public boolean isNotFolder() {
        return this.tag == Tag.NOT_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     */
    public boolean isRestrictedContent() {
        return this.tag == Tag.RESTRICTED_CONTENT;
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
            malformedPathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof LookupError) {
            LookupError other = (LookupError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case MALFORMED_PATH:
                    return (this.malformedPathValue == other.malformedPathValue) || (this.malformedPathValue != null && this.malformedPathValue.equals(other.malformedPathValue));
                case NOT_FOUND:
                    return true;
                case NOT_FILE:
                    return true;
                case NOT_FOLDER:
                    return true;
                case RESTRICTED_CONTENT:
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

    static final class Serializer extends UnionJsonSerializer<LookupError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(LookupError.class);
        }

        @Override
        public void serialize(LookupError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case MALFORMED_PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "malformed_path");
                    if (value.malformedPathValue != null) {
                        g.writeObjectField("malformed_path", value.malformedPathValue);
                    }
                    g.writeEndObject();
                    break;
                case NOT_FOUND:
                    g.writeString("not_found");
                    break;
                case NOT_FILE:
                    g.writeString("not_file");
                    break;
                case NOT_FOLDER:
                    g.writeString("not_folder");
                    break;
                case RESTRICTED_CONTENT:
                    g.writeString("restricted_content");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<LookupError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(LookupError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public LookupError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case MALFORMED_PATH: {
                    if (isObjectEnd(_p)) {
                        return LookupError.malformedPath();
                    }
                    String value = null;
                    expectField(_p, "malformed_path");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return LookupError.malformedPath(value);
                }
                case NOT_FOUND: {
                    return LookupError.NOT_FOUND;
                }
                case NOT_FILE: {
                    return LookupError.NOT_FILE;
                }
                case NOT_FOLDER: {
                    return LookupError.NOT_FOLDER;
                }
                case RESTRICTED_CONTENT: {
                    return LookupError.RESTRICTED_CONTENT;
                }
                case OTHER: {
                    return LookupError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, LookupError.Tag> getTagMapping() {
            Map<String, LookupError.Tag> values = new HashMap<String, LookupError.Tag>();
            values.put("malformed_path", LookupError.Tag.MALFORMED_PATH);
            values.put("not_found", LookupError.Tag.NOT_FOUND);
            values.put("not_file", LookupError.Tag.NOT_FILE);
            values.put("not_folder", LookupError.Tag.NOT_FOLDER);
            values.put("restricted_content", LookupError.Tag.RESTRICTED_CONTENT);
            values.put("other", LookupError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
