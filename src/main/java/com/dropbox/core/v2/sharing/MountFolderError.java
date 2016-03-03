/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
@JsonSerialize(using=MountFolderError.Serializer.class)
@JsonDeserialize(using=MountFolderError.Deserializer.class)
public final class MountFolderError {
    // union MountFolderError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
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
     * Mounting would cause a shared folder to be inside another, which is
     * disallowed.
     */
    public static final MountFolderError INSIDE_SHARED_FOLDER = new MountFolderError(Tag.INSIDE_SHARED_FOLDER, null);
    /**
     * The current user does not have enough space to mount the shared folder.
     */
    public static final MountFolderError INSUFFICIENT_QUOTA = new MountFolderError(Tag.INSUFFICIENT_QUOTA, null);
    /**
     * The shared folder is already mounted.
     */
    public static final MountFolderError ALREADY_MOUNTED = new MountFolderError(Tag.ALREADY_MOUNTED, null);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final MountFolderError NO_PERMISSION = new MountFolderError(Tag.NO_PERMISSION, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MountFolderError}. </p>
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
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code MountFolderError} that has its tag set to
     * {@link Tag#ACCESS_ERROR}.
     *
     * @param value  value to assign to this instance.
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
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isInsideSharedFolder() {
        return this.tag == Tag.INSIDE_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     */
    public boolean isInsufficientQuota() {
        return this.tag == Tag.INSUFFICIENT_QUOTA;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     */
    public boolean isAlreadyMounted() {
        return this.tag == Tag.ALREADY_MOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
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
                case NO_PERMISSION:
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

    static final class Serializer extends UnionJsonSerializer<MountFolderError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MountFolderError.class);
        }

        @Override
        public void serialize(MountFolderError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "access_error");
                    g.writeObjectField("access_error", value.accessErrorValue);
                    g.writeEndObject();
                    break;
                case INSIDE_SHARED_FOLDER:
                    g.writeString("inside_shared_folder");
                    break;
                case INSUFFICIENT_QUOTA:
                    g.writeString("insufficient_quota");
                    break;
                case ALREADY_MOUNTED:
                    g.writeString("already_mounted");
                    break;
                case NO_PERMISSION:
                    g.writeString("no_permission");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MountFolderError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MountFolderError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public MountFolderError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ACCESS_ERROR: {
                    SharedFolderAccessError value = null;
                    expectField(_p, "access_error");
                    value = _p.readValueAs(SharedFolderAccessError.class);
                    _p.nextToken();
                    return MountFolderError.accessError(value);
                }
                case INSIDE_SHARED_FOLDER: {
                    return MountFolderError.INSIDE_SHARED_FOLDER;
                }
                case INSUFFICIENT_QUOTA: {
                    return MountFolderError.INSUFFICIENT_QUOTA;
                }
                case ALREADY_MOUNTED: {
                    return MountFolderError.ALREADY_MOUNTED;
                }
                case NO_PERMISSION: {
                    return MountFolderError.NO_PERMISSION;
                }
                case OTHER: {
                    return MountFolderError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MountFolderError.Tag> getTagMapping() {
            Map<String, MountFolderError.Tag> values = new HashMap<String, MountFolderError.Tag>();
            values.put("access_error", MountFolderError.Tag.ACCESS_ERROR);
            values.put("inside_shared_folder", MountFolderError.Tag.INSIDE_SHARED_FOLDER);
            values.put("insufficient_quota", MountFolderError.Tag.INSUFFICIENT_QUOTA);
            values.put("already_mounted", MountFolderError.Tag.ALREADY_MOUNTED);
            values.put("no_permission", MountFolderError.Tag.NO_PERMISSION);
            values.put("other", MountFolderError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
