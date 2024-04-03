/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

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
public final class RelinquishFileMembershipError {
    // union sharing.RelinquishFileMembershipError (sharing_files.stone)

    /**
     * Discriminating tag type for {@link RelinquishFileMembershipError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharingFileAccessError
        /**
         * The current user has access to the shared file via a group.  You
         * can't relinquish membership to a file shared via groups.
         */
        GROUP_ACCESS,
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
     * The current user has access to the shared file via a group.  You can't
     * relinquish membership to a file shared via groups.
     */
    public static final RelinquishFileMembershipError GROUP_ACCESS = new RelinquishFileMembershipError().withTag(Tag.GROUP_ACCESS);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final RelinquishFileMembershipError NO_PERMISSION = new RelinquishFileMembershipError().withTag(Tag.NO_PERMISSION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RelinquishFileMembershipError OTHER = new RelinquishFileMembershipError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharingFileAccessError accessErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelinquishFileMembershipError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelinquishFileMembershipError withTag(Tag _tag) {
        RelinquishFileMembershipError result = new RelinquishFileMembershipError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelinquishFileMembershipError withTagAndAccessError(Tag _tag, SharingFileAccessError accessErrorValue) {
        RelinquishFileMembershipError result = new RelinquishFileMembershipError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RelinquishFileMembershipError}. </p>
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
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code RelinquishFileMembershipError} that has its
     * tag set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelinquishFileMembershipError} with its tag
     *     set to {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelinquishFileMembershipError accessError(SharingFileAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelinquishFileMembershipError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link SharingFileAccessError} value associated with this
     *     instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharingFileAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_ACCESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_ACCESS}, {@code false} otherwise.
     */
    public boolean isGroupAccess() {
        return this._tag == Tag.GROUP_ACCESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
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
            this.accessErrorValue
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
        else if (obj instanceof RelinquishFileMembershipError) {
            RelinquishFileMembershipError other = (RelinquishFileMembershipError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case GROUP_ACCESS:
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
    static class Serializer extends UnionSerializer<RelinquishFileMembershipError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelinquishFileMembershipError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharingFileAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case GROUP_ACCESS: {
                    g.writeString("group_access");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RelinquishFileMembershipError deserialize(JsonParser p) throws IOException, JsonParseException {
            RelinquishFileMembershipError value;
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
            else if ("access_error".equals(tag)) {
                SharingFileAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharingFileAccessError.Serializer.INSTANCE.deserialize(p);
                value = RelinquishFileMembershipError.accessError(fieldValue);
            }
            else if ("group_access".equals(tag)) {
                value = RelinquishFileMembershipError.GROUP_ACCESS;
            }
            else if ("no_permission".equals(tag)) {
                value = RelinquishFileMembershipError.NO_PERMISSION;
            }
            else {
                value = RelinquishFileMembershipError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
