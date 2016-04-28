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
@JsonSerialize(using=UploadSessionFinishError.Serializer.class)
@JsonDeserialize(using=UploadSessionFinishError.Deserializer.class)
public final class UploadSessionFinishError {
    // union UploadSessionFinishError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link UploadSessionFinishError}.
     */
    public enum Tag {
        /**
         * The session arguments are incorrect; the value explains the reason.
         */
        LOOKUP_FAILED, // UploadSessionLookupError
        /**
         * Unable to save the uploaded contents to a file.
         */
        PATH, // WriteError
        /**
         * The batch request commits files into too many different shared
         * folders. Please limit your batch request to files contained in a
         * single shared folder.
         */
        TOO_MANY_SHARED_FOLDER_TARGETS,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    /**
     * The batch request commits files into too many different shared folders.
     * Please limit your batch request to files contained in a single shared
     * folder.
     */
    public static final UploadSessionFinishError TOO_MANY_SHARED_FOLDER_TARGETS = new UploadSessionFinishError(Tag.TOO_MANY_SHARED_FOLDER_TARGETS, null, null);
    /**
     * An unspecified error.
     */
    public static final UploadSessionFinishError OTHER = new UploadSessionFinishError(Tag.OTHER, null, null);

    private final Tag tag;
    private final UploadSessionLookupError lookupFailedValue;
    private final WriteError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionFinishError(Tag tag, UploadSessionLookupError lookupFailedValue, WriteError pathValue) {
        this.tag = tag;
        this.lookupFailedValue = lookupFailedValue;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadSessionFinishError}. </p>
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
     * Tag#LOOKUP_FAILED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#LOOKUP_FAILED}, {@code false} otherwise.
     */
    public boolean isLookupFailed() {
        return this.tag == Tag.LOOKUP_FAILED;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#LOOKUP_FAILED}.
     *
     * <p> The session arguments are incorrect; the value explains the reason.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#LOOKUP_FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError lookupFailed(UploadSessionLookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError(Tag.LOOKUP_FAILED, value, null);
    }

    /**
     * The session arguments are incorrect; the value explains the reason.
     *
     * <p> This instance must be tagged as {@link Tag#LOOKUP_FAILED}. </p>
     *
     * @return The {@link UploadSessionFinishError#lookupFailed} value
     *     associated with this instance if {@link #isLookupFailed} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isLookupFailed} is {@code
     *     false}.
     */
    public UploadSessionLookupError getLookupFailedValue() {
        if (this.tag != Tag.LOOKUP_FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.LOOKUP_FAILED, but was Tag." + tag.name());
        }
        return lookupFailedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UploadSessionFinishError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> Unable to save the uploaded contents to a file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionFinishError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionFinishError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionFinishError(Tag.PATH, null, value);
    }

    /**
     * Unable to save the uploaded contents to a file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link UploadSessionFinishError#path} value associated with
     *     this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public WriteError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_SHARED_FOLDER_TARGETS}, {@code false} otherwise.
     */
    public boolean isTooManySharedFolderTargets() {
        return this.tag == Tag.TOO_MANY_SHARED_FOLDER_TARGETS;
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
            lookupFailedValue,
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadSessionFinishError) {
            UploadSessionFinishError other = (UploadSessionFinishError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case LOOKUP_FAILED:
                    return (this.lookupFailedValue == other.lookupFailedValue) || (this.lookupFailedValue.equals(other.lookupFailedValue));
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case TOO_MANY_SHARED_FOLDER_TARGETS:
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

    static final class Serializer extends UnionJsonSerializer<UploadSessionFinishError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionFinishError.class);
        }

        @Override
        public void serialize(UploadSessionFinishError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case LOOKUP_FAILED:
                    g.writeStartObject();
                    g.writeStringField(".tag", "lookup_failed");
                    g.writeObjectField("lookup_failed", value.lookupFailedValue);
                    g.writeEndObject();
                    break;
                case PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path");
                    g.writeObjectField("path", value.pathValue);
                    g.writeEndObject();
                    break;
                case TOO_MANY_SHARED_FOLDER_TARGETS:
                    g.writeString("too_many_shared_folder_targets");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UploadSessionFinishError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionFinishError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public UploadSessionFinishError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case LOOKUP_FAILED: {
                    UploadSessionLookupError value = null;
                    expectField(_p, "lookup_failed");
                    value = _p.readValueAs(UploadSessionLookupError.class);
                    _p.nextToken();
                    return UploadSessionFinishError.lookupFailed(value);
                }
                case PATH: {
                    WriteError value = null;
                    expectField(_p, "path");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return UploadSessionFinishError.path(value);
                }
                case TOO_MANY_SHARED_FOLDER_TARGETS: {
                    return UploadSessionFinishError.TOO_MANY_SHARED_FOLDER_TARGETS;
                }
                case OTHER: {
                    return UploadSessionFinishError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, UploadSessionFinishError.Tag> getTagMapping() {
            Map<String, UploadSessionFinishError.Tag> values = new HashMap<String, UploadSessionFinishError.Tag>();
            values.put("lookup_failed", UploadSessionFinishError.Tag.LOOKUP_FAILED);
            values.put("path", UploadSessionFinishError.Tag.PATH);
            values.put("too_many_shared_folder_targets", UploadSessionFinishError.Tag.TOO_MANY_SHARED_FOLDER_TARGETS);
            values.put("other", UploadSessionFinishError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
