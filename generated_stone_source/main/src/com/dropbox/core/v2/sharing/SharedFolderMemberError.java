/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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
public final class SharedFolderMemberError {
    // union sharing.SharedFolderMemberError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link SharedFolderMemberError}.
     */
    public enum Tag {
        /**
         * The target dropbox_id is invalid.
         */
        INVALID_DROPBOX_ID,
        /**
         * The target dropbox_id is not a member of the shared folder.
         */
        NOT_A_MEMBER,
        /**
         * The target member only has inherited access to the shared folder.
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
     * The target dropbox_id is invalid.
     */
    public static final SharedFolderMemberError INVALID_DROPBOX_ID = new SharedFolderMemberError().withTag(Tag.INVALID_DROPBOX_ID);
    /**
     * The target dropbox_id is not a member of the shared folder.
     */
    public static final SharedFolderMemberError NOT_A_MEMBER = new SharedFolderMemberError().withTag(Tag.NOT_A_MEMBER);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SharedFolderMemberError OTHER = new SharedFolderMemberError().withTag(Tag.OTHER);

    private Tag _tag;
    private MemberAccessLevelResult noExplicitAccessValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SharedFolderMemberError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SharedFolderMemberError withTag(Tag _tag) {
        SharedFolderMemberError result = new SharedFolderMemberError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param noExplicitAccessValue  The target member only has inherited access
     *     to the shared folder. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SharedFolderMemberError withTagAndNoExplicitAccess(Tag _tag, MemberAccessLevelResult noExplicitAccessValue) {
        SharedFolderMemberError result = new SharedFolderMemberError();
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
     * values for this {@code SharedFolderMemberError}. </p>
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
     * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     */
    public boolean isInvalidDropboxId() {
        return this._tag == Tag.INVALID_DROPBOX_ID;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NOT_A_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_A_MEMBER}, {@code false} otherwise.
     */
    public boolean isNotAMember() {
        return this._tag == Tag.NOT_A_MEMBER;
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
     * Returns an instance of {@code SharedFolderMemberError} that has its tag
     * set to {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * <p> The target member only has inherited access to the shared folder.
     * </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SharedFolderMemberError} with its tag set to
     *     {@link Tag#NO_EXPLICIT_ACCESS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SharedFolderMemberError noExplicitAccess(MemberAccessLevelResult value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharedFolderMemberError().withTagAndNoExplicitAccess(Tag.NO_EXPLICIT_ACCESS, value);
    }

    /**
     * The target member only has inherited access to the shared folder.
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
        else if (obj instanceof SharedFolderMemberError) {
            SharedFolderMemberError other = (SharedFolderMemberError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_DROPBOX_ID:
                    return true;
                case NOT_A_MEMBER:
                    return true;
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
    static class Serializer extends UnionSerializer<SharedFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMemberError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_DROPBOX_ID: {
                    g.writeString("invalid_dropbox_id");
                    break;
                }
                case NOT_A_MEMBER: {
                    g.writeString("not_a_member");
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
        public SharedFolderMemberError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedFolderMemberError value;
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
            else if ("invalid_dropbox_id".equals(tag)) {
                value = SharedFolderMemberError.INVALID_DROPBOX_ID;
            }
            else if ("not_a_member".equals(tag)) {
                value = SharedFolderMemberError.NOT_A_MEMBER;
            }
            else if ("no_explicit_access".equals(tag)) {
                MemberAccessLevelResult fieldValue = null;
                fieldValue = MemberAccessLevelResult.Serializer.INSTANCE.deserialize(p, true);
                value = SharedFolderMemberError.noExplicitAccess(fieldValue);
            }
            else {
                value = SharedFolderMemberError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
