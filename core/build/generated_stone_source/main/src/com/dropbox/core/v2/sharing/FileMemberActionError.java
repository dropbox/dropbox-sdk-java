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
public final class FileMemberActionError {
    // union sharing.FileMemberActionError (sharing_files.stone)

    /**
     * Discriminating tag type for {@link FileMemberActionError}.
     */
    public enum Tag {
        /**
         * Specified member was not found.
         */
        INVALID_MEMBER,
        /**
         * User does not have permission to perform this action on this member.
         */
        NO_PERMISSION,
        /**
         * Specified file was invalid or user does not have access.
         */
        ACCESS_ERROR, // SharingFileAccessError
        /**
         * The action cannot be completed because the target member does not
         * have explicit access to the file. The return value is the access that
         * the member has to the file from a parent folder.
         */
        NO_EXPLICIT_ACCESS, // MemberAccessLevelResult
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
     * Specified member was not found.
     */
    public static final FileMemberActionError INVALID_MEMBER = new FileMemberActionError().withTag(Tag.INVALID_MEMBER);
    /**
     * User does not have permission to perform this action on this member.
     */
    public static final FileMemberActionError NO_PERMISSION = new FileMemberActionError().withTag(Tag.NO_PERMISSION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final FileMemberActionError OTHER = new FileMemberActionError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharingFileAccessError accessErrorValue;
    private MemberAccessLevelResult noExplicitAccessValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FileMemberActionError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FileMemberActionError withTag(Tag _tag) {
        FileMemberActionError result = new FileMemberActionError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Specified file was invalid or user does not have
     *     access. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FileMemberActionError withTagAndAccessError(Tag _tag, SharingFileAccessError accessErrorValue) {
        FileMemberActionError result = new FileMemberActionError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     *
     * @param noExplicitAccessValue  The action cannot be completed because the
     *     target member does not have explicit access to the file. The return
     *     value is the access that the member has to the file from a parent
     *     folder. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FileMemberActionError withTagAndNoExplicitAccess(Tag _tag, MemberAccessLevelResult noExplicitAccessValue) {
        FileMemberActionError result = new FileMemberActionError();
        result._tag = _tag;
        result.noExplicitAccessValue = noExplicitAccessValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FileMemberActionError}. </p>
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
     * Tag#INVALID_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_MEMBER}, {@code false} otherwise.
     */
    public boolean isInvalidMember() {
        return this._tag == Tag.INVALID_MEMBER;
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
     * Returns an instance of {@code FileMemberActionError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
     *
     * <p> Specified file was invalid or user does not have access. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileMemberActionError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FileMemberActionError accessError(SharingFileAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberActionError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * Specified file was invalid or user does not have access.
     *
     * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
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
     * Tag#NO_EXPLICIT_ACCESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_EXPLICIT_ACCESS}, {@code false} otherwise.
     */
    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
    }

    /**
     * Returns an instance of {@code FileMemberActionError} that has its tag set
     * to {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * <p> The action cannot be completed because the target member does not
     * have explicit access to the file. The return value is the access that the
     * member has to the file from a parent folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FileMemberActionError} with its tag set to
     *     {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FileMemberActionError noExplicitAccess(MemberAccessLevelResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FileMemberActionError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, value);
    }

    /**
     * The action cannot be completed because the target member does not have
     * explicit access to the file. The return value is the access that the
     * member has to the file from a parent folder.
     *
     * <p> This instance must be tagged as {@link Tag#NO_EXPLICIT_ACCESS}. </p>
     *
     * @return The {@link MemberAccessLevelResult} value associated with this
     *     instance if {@link #isNoExplicitAccess} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isNoExplicitAccess} is {@code
     *     false}.
     */
    public MemberAccessLevelResult getNoExplicitAccessValue() {
        if (this._tag != Tag.NO_EXPLICIT_ACCESS) {
            throw new IllegalStateException("Invalid tag: required Tag.NO_EXPLICIT_ACCESS, but was Tag." + this._tag.name());
        }
        return noExplicitAccessValue;
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
            this.accessErrorValue,
            this.noExplicitAccessValue
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
        else if (obj instanceof FileMemberActionError) {
            FileMemberActionError other = (FileMemberActionError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_MEMBER:
                    return true;
                case NO_PERMISSION:
                    return true;
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case NO_EXPLICIT_ACCESS:
                    return (this.noExplicitAccessValue == other.noExplicitAccessValue) || (this.noExplicitAccessValue.equals(other.noExplicitAccessValue));
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
    static class Serializer extends UnionSerializer<FileMemberActionError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMemberActionError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_MEMBER: {
                    g.writeString("invalid_member");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharingFileAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case NO_EXPLICIT_ACCESS: {
                    g.writeStartObject();
                    writeTag("no_explicit_access", g);
                    MemberAccessLevelResult.Serializer.INSTANCE.serialize(value.noExplicitAccessValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FileMemberActionError deserialize(JsonParser p) throws IOException, JsonParseException {
            FileMemberActionError value;
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
            else if ("invalid_member".equals(tag)) {
                value = FileMemberActionError.INVALID_MEMBER;
            }
            else if ("no_permission".equals(tag)) {
                value = FileMemberActionError.NO_PERMISSION;
            }
            else if ("access_error".equals(tag)) {
                SharingFileAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharingFileAccessError.Serializer.INSTANCE.deserialize(p);
                value = FileMemberActionError.accessError(fieldValue);
            }
            else if ("no_explicit_access".equals(tag)) {
                MemberAccessLevelResult fieldValue = null;
                fieldValue = MemberAccessLevelResult.Serializer.INSTANCE.deserialize(p, true);
                value = FileMemberActionError.noExplicitAccess(fieldValue);
            }
            else {
                value = FileMemberActionError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
