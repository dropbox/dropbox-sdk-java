/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class SharePathError {
    // union SharePathError

    /**
     * Discriminating tag type for {@link SharePathError}.
     */
    public enum Tag {
        /**
         * A file is at the specified path.
         */
        IS_FILE,
        /**
         * We do not support sharing a folder inside a shared folder.
         */
        INSIDE_SHARED_FOLDER,
        /**
         * We do not support shared folders that contain shared folders.
         */
        CONTAINS_SHARED_FOLDER,
        /**
         * We do not support sharing an app folder.
         */
        IS_APP_FOLDER,
        /**
         * We do not support sharing a folder inside an app folder.
         */
        INSIDE_APP_FOLDER,
        /**
         * A public folder can't be shared this way. Use a public link instead.
         */
        IS_PUBLIC_FOLDER,
        /**
         * A folder inside a public folder can't be shared this way. Use a
         * public link instead.
         */
        INSIDE_PUBLIC_FOLDER,
        /**
         * Folder is already shared. Contains metadata about the existing shared
         * folder.
         */
        ALREADY_SHARED, // SharedFolderMetadata
        /**
         * Path is not valid.
         */
        INVALID_PATH,
        /**
         * We do not support sharing a Mac OS X package.
         */
        IS_OSX_PACKAGE,
        /**
         * We do not support sharing a folder inside a Mac OS X package.
         */
        INSIDE_OSX_PACKAGE,
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
     * A file is at the specified path.
     */
    public static final SharePathError IS_FILE = new SharePathError(Tag.IS_FILE, null);
    /**
     * We do not support sharing a folder inside a shared folder.
     */
    public static final SharePathError INSIDE_SHARED_FOLDER = new SharePathError(Tag.INSIDE_SHARED_FOLDER, null);
    /**
     * We do not support shared folders that contain shared folders.
     */
    public static final SharePathError CONTAINS_SHARED_FOLDER = new SharePathError(Tag.CONTAINS_SHARED_FOLDER, null);
    /**
     * We do not support sharing an app folder.
     */
    public static final SharePathError IS_APP_FOLDER = new SharePathError(Tag.IS_APP_FOLDER, null);
    /**
     * We do not support sharing a folder inside an app folder.
     */
    public static final SharePathError INSIDE_APP_FOLDER = new SharePathError(Tag.INSIDE_APP_FOLDER, null);
    /**
     * A public folder can't be shared this way. Use a public link instead.
     */
    public static final SharePathError IS_PUBLIC_FOLDER = new SharePathError(Tag.IS_PUBLIC_FOLDER, null);
    /**
     * A folder inside a public folder can't be shared this way. Use a public
     * link instead.
     */
    public static final SharePathError INSIDE_PUBLIC_FOLDER = new SharePathError(Tag.INSIDE_PUBLIC_FOLDER, null);
    /**
     * Path is not valid.
     */
    public static final SharePathError INVALID_PATH = new SharePathError(Tag.INVALID_PATH, null);
    /**
     * We do not support sharing a Mac OS X package.
     */
    public static final SharePathError IS_OSX_PACKAGE = new SharePathError(Tag.IS_OSX_PACKAGE, null);
    /**
     * We do not support sharing a folder inside a Mac OS X package.
     */
    public static final SharePathError INSIDE_OSX_PACKAGE = new SharePathError(Tag.INSIDE_OSX_PACKAGE, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SharePathError OTHER = new SharePathError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderMetadata alreadySharedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private SharePathError(Tag tag, SharedFolderMetadata alreadySharedValue) {
        this.tag = tag;
        this.alreadySharedValue = alreadySharedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SharePathError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#IS_FILE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#IS_FILE},
     *     {@code false} otherwise.
     */
    public boolean isIsFile() {
        return this.tag == Tag.IS_FILE;
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
     * Tag#CONTAINS_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTAINS_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isContainsSharedFolder() {
        return this.tag == Tag.CONTAINS_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IS_APP_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IS_APP_FOLDER}, {@code false} otherwise.
     */
    public boolean isIsAppFolder() {
        return this.tag == Tag.IS_APP_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSIDE_APP_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSIDE_APP_FOLDER}, {@code false} otherwise.
     */
    public boolean isInsideAppFolder() {
        return this.tag == Tag.INSIDE_APP_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IS_PUBLIC_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IS_PUBLIC_FOLDER}, {@code false} otherwise.
     */
    public boolean isIsPublicFolder() {
        return this.tag == Tag.IS_PUBLIC_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSIDE_PUBLIC_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSIDE_PUBLIC_FOLDER}, {@code false} otherwise.
     */
    public boolean isInsidePublicFolder() {
        return this.tag == Tag.INSIDE_PUBLIC_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_SHARED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ALREADY_SHARED}, {@code false} otherwise.
     */
    public boolean isAlreadyShared() {
        return this.tag == Tag.ALREADY_SHARED;
    }

    /**
     * Returns an instance of {@code SharePathError} that has its tag set to
     * {@link Tag#ALREADY_SHARED}.
     *
     * <p> Folder is already shared. Contains metadata about the existing shared
     * folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SharePathError} with its tag set to {@link
     *     Tag#ALREADY_SHARED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SharePathError alreadyShared(SharedFolderMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharePathError(Tag.ALREADY_SHARED, value);
    }

    /**
     * Folder is already shared. Contains metadata about the existing shared
     * folder.
     *
     * <p> This instance must be tagged as {@link Tag#ALREADY_SHARED}. </p>
     *
     * @return The {@link SharePathError#alreadyShared} value associated with
     *     this instance if {@link #isAlreadyShared} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAlreadyShared} is {@code
     *     false}.
     */
    public SharedFolderMetadata getAlreadySharedValue() {
        if (this.tag != Tag.ALREADY_SHARED) {
            throw new IllegalStateException("Invalid tag: required Tag.ALREADY_SHARED, but was Tag." + tag.name());
        }
        return alreadySharedValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_PATH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_PATH}, {@code false} otherwise.
     */
    public boolean isInvalidPath() {
        return this.tag == Tag.INVALID_PATH;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IS_OSX_PACKAGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IS_OSX_PACKAGE}, {@code false} otherwise.
     */
    public boolean isIsOsxPackage() {
        return this.tag == Tag.IS_OSX_PACKAGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSIDE_OSX_PACKAGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSIDE_OSX_PACKAGE}, {@code false} otherwise.
     */
    public boolean isInsideOsxPackage() {
        return this.tag == Tag.INSIDE_OSX_PACKAGE;
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
            alreadySharedValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof SharePathError) {
            SharePathError other = (SharePathError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case IS_FILE:
                    return true;
                case INSIDE_SHARED_FOLDER:
                    return true;
                case CONTAINS_SHARED_FOLDER:
                    return true;
                case IS_APP_FOLDER:
                    return true;
                case INSIDE_APP_FOLDER:
                    return true;
                case IS_PUBLIC_FOLDER:
                    return true;
                case INSIDE_PUBLIC_FOLDER:
                    return true;
                case ALREADY_SHARED:
                    return (this.alreadySharedValue == other.alreadySharedValue) || (this.alreadySharedValue.equals(other.alreadySharedValue));
                case INVALID_PATH:
                    return true;
                case IS_OSX_PACKAGE:
                    return true;
                case INSIDE_OSX_PACKAGE:
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
    static final class Serializer extends UnionSerializer<SharePathError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharePathError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case IS_FILE: {
                    g.writeString("is_file");
                    break;
                }
                case INSIDE_SHARED_FOLDER: {
                    g.writeString("inside_shared_folder");
                    break;
                }
                case CONTAINS_SHARED_FOLDER: {
                    g.writeString("contains_shared_folder");
                    break;
                }
                case IS_APP_FOLDER: {
                    g.writeString("is_app_folder");
                    break;
                }
                case INSIDE_APP_FOLDER: {
                    g.writeString("inside_app_folder");
                    break;
                }
                case IS_PUBLIC_FOLDER: {
                    g.writeString("is_public_folder");
                    break;
                }
                case INSIDE_PUBLIC_FOLDER: {
                    g.writeString("inside_public_folder");
                    break;
                }
                case ALREADY_SHARED: {
                    g.writeStartObject();
                    writeTag("already_shared", g);
                    SharedFolderMetadata.Serializer.INSTANCE.serialize(value.alreadySharedValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case INVALID_PATH: {
                    g.writeString("invalid_path");
                    break;
                }
                case IS_OSX_PACKAGE: {
                    g.writeString("is_osx_package");
                    break;
                }
                case INSIDE_OSX_PACKAGE: {
                    g.writeString("inside_osx_package");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharePathError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharePathError value;
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
            else if ("is_file".equals(tag)) {
                value = SharePathError.IS_FILE;
            }
            else if ("inside_shared_folder".equals(tag)) {
                value = SharePathError.INSIDE_SHARED_FOLDER;
            }
            else if ("contains_shared_folder".equals(tag)) {
                value = SharePathError.CONTAINS_SHARED_FOLDER;
            }
            else if ("is_app_folder".equals(tag)) {
                value = SharePathError.IS_APP_FOLDER;
            }
            else if ("inside_app_folder".equals(tag)) {
                value = SharePathError.INSIDE_APP_FOLDER;
            }
            else if ("is_public_folder".equals(tag)) {
                value = SharePathError.IS_PUBLIC_FOLDER;
            }
            else if ("inside_public_folder".equals(tag)) {
                value = SharePathError.INSIDE_PUBLIC_FOLDER;
            }
            else if ("already_shared".equals(tag)) {
                SharedFolderMetadata fieldValue = null;
                fieldValue = SharedFolderMetadata.Serializer.INSTANCE.deserialize(p, true);
                value = SharePathError.alreadyShared(fieldValue);
            }
            else if ("invalid_path".equals(tag)) {
                value = SharePathError.INVALID_PATH;
            }
            else if ("is_osx_package".equals(tag)) {
                value = SharePathError.IS_OSX_PACKAGE;
            }
            else if ("inside_osx_package".equals(tag)) {
                value = SharePathError.INSIDE_OSX_PACKAGE;
            }
            else {
                value = SharePathError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
