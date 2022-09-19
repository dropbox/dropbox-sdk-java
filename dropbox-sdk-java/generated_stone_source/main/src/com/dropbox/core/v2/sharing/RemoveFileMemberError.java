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
 * Errors for {@link
 * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
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
public final class RemoveFileMemberError {
    // union sharing.RemoveFileMemberError (sharing_files.stone)

    /**
     * Discriminating tag type for {@link RemoveFileMemberError}.
     */
    public enum Tag {
        USER_ERROR, // SharingUserError
        ACCESS_ERROR, // SharingFileAccessError
        /**
         * This member does not have explicit access to the file and therefore
         * cannot be removed. The return value is the access that a user might
         * have to the file from a parent folder.
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RemoveFileMemberError OTHER = new RemoveFileMemberError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharingUserError userErrorValue;
    private SharingFileAccessError accessErrorValue;
    private MemberAccessLevelResult noExplicitAccessValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RemoveFileMemberError() {
    }


    /**
     * Errors for {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RemoveFileMemberError withTag(Tag _tag) {
        RemoveFileMemberError result = new RemoveFileMemberError();
        result._tag = _tag;
        return result;
    }

    /**
     * Errors for {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     *
     * @param userErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RemoveFileMemberError withTagAndUserError(Tag _tag, SharingUserError userErrorValue) {
        RemoveFileMemberError result = new RemoveFileMemberError();
        result._tag = _tag;
        result.userErrorValue = userErrorValue;
        return result;
    }

    /**
     * Errors for {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     *
     * @param accessErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RemoveFileMemberError withTagAndAccessError(Tag _tag, SharingFileAccessError accessErrorValue) {
        RemoveFileMemberError result = new RemoveFileMemberError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     * Errors for {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     *
     * @param noExplicitAccessValue  This member does not have explicit access
     *     to the file and therefore cannot be removed. The return value is the
     *     access that a user might have to the file from a parent folder. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RemoveFileMemberError withTagAndNoExplicitAccess(Tag _tag, MemberAccessLevelResult noExplicitAccessValue) {
        RemoveFileMemberError result = new RemoveFileMemberError();
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
     * values for this {@code RemoveFileMemberError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#USER_ERROR},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#USER_ERROR}, {@code false} otherwise.
     */
    public boolean isUserError() {
        return this._tag == Tag.USER_ERROR;
    }

    /**
     * Returns an instance of {@code RemoveFileMemberError} that has its tag set
     * to {@link Tag#USER_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RemoveFileMemberError} with its tag set to
     *     {@link Tag#USER_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RemoveFileMemberError userError(SharingUserError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndUserError(Tag.USER_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#USER_ERROR}.
     *
     * @return The {@link SharingUserError} value associated with this instance
     *     if {@link #isUserError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUserError} is {@code false}.
     */
    public SharingUserError getUserErrorValue() {
        if (this._tag != Tag.USER_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.USER_ERROR, but was Tag." + this._tag.name());
        }
        return userErrorValue;
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
     * Returns an instance of {@code RemoveFileMemberError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RemoveFileMemberError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RemoveFileMemberError accessError(SharingFileAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
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
     * Tag#NO_EXPLICIT_ACCESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_EXPLICIT_ACCESS}, {@code false} otherwise.
     */
    public boolean isNoExplicitAccess() {
        return this._tag == Tag.NO_EXPLICIT_ACCESS;
    }

    /**
     * Returns an instance of {@code RemoveFileMemberError} that has its tag set
     * to {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * <p> This member does not have explicit access to the file and therefore
     * cannot be removed. The return value is the access that a user might have
     * to the file from a parent folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RemoveFileMemberError} with its tag set to
     *     {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RemoveFileMemberError noExplicitAccess(MemberAccessLevelResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RemoveFileMemberError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, value);
    }

    /**
     * This member does not have explicit access to the file and therefore
     * cannot be removed. The return value is the access that a user might have
     * to the file from a parent folder.
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
            _tag,
            userErrorValue,
            accessErrorValue,
            noExplicitAccessValue
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
        else if (obj instanceof RemoveFileMemberError) {
            RemoveFileMemberError other = (RemoveFileMemberError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case USER_ERROR:
                    return (this.userErrorValue == other.userErrorValue) || (this.userErrorValue.equals(other.userErrorValue));
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
    static class Serializer extends UnionSerializer<RemoveFileMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemoveFileMemberError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case USER_ERROR: {
                    g.writeStartObject();
                    writeTag("user_error", g);
                    g.writeFieldName("user_error");
                    SharingUserError.Serializer.INSTANCE.serialize(value.userErrorValue, g);
                    g.writeEndObject();
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
        public RemoveFileMemberError deserialize(JsonParser p) throws IOException, JsonParseException {
            RemoveFileMemberError value;
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
            else if ("user_error".equals(tag)) {
                SharingUserError fieldValue = null;
                expectField("user_error", p);
                fieldValue = SharingUserError.Serializer.INSTANCE.deserialize(p);
                value = RemoveFileMemberError.userError(fieldValue);
            }
            else if ("access_error".equals(tag)) {
                SharingFileAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharingFileAccessError.Serializer.INSTANCE.deserialize(p);
                value = RemoveFileMemberError.accessError(fieldValue);
            }
            else if ("no_explicit_access".equals(tag)) {
                MemberAccessLevelResult fieldValue = null;
                fieldValue = MemberAccessLevelResult.Serializer.INSTANCE.deserialize(p, true);
                value = RemoveFileMemberError.noExplicitAccess(fieldValue);
            }
            else {
                value = RemoveFileMemberError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
