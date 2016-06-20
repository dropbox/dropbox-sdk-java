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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class ShareFolderError {
    // union ShareFolderError

    /**
     * Discriminating tag type for {@link ShareFolderError}.
     */
    public enum Tag {
        /**
         * The current user's e-mail address is unverified.
         */
        EMAIL_UNVERIFIED,
        /**
         * the {@code path} argument to {@link
         * DbxUserSharingRequests#shareFolder(String)} is invalid.
         */
        BAD_PATH, // SharePathError
        /**
         * Team policy is more restrictive than the {@code memberPolicy}
         * argument to {@link DbxUserSharingRequests#shareFolder(String)}.
         */
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        /**
         * The current user's account is not allowed to select the specified the
         * {@code sharedLinkPolicy} argument to {@link
         * DbxUserSharingRequests#shareFolder(String)}.
         */
        DISALLOWED_SHARED_LINK_POLICY,
        OTHER,
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION;
    }

    /**
     * The current user's e-mail address is unverified.
     */
    public static final ShareFolderError EMAIL_UNVERIFIED = new ShareFolderError(Tag.EMAIL_UNVERIFIED, null);
    /**
     * Team policy is more restrictive than the {@code memberPolicy} argument to
     * {@link DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final ShareFolderError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new ShareFolderError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY, null);
    /**
     * The current user's account is not allowed to select the specified the
     * {@code sharedLinkPolicy} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final ShareFolderError DISALLOWED_SHARED_LINK_POLICY = new ShareFolderError(Tag.DISALLOWED_SHARED_LINK_POLICY, null);
    public static final ShareFolderError OTHER = new ShareFolderError(Tag.OTHER, null);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final ShareFolderError NO_PERMISSION = new ShareFolderError(Tag.NO_PERMISSION, null);

    private final Tag tag;
    private final SharePathError badPathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ShareFolderError(Tag tag, SharePathError badPathValue) {
        this.tag = tag;
        this.badPathValue = badPathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ShareFolderError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailUnverified() {
        return this.tag == Tag.EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#BAD_PATH},
     *     {@code false} otherwise.
     */
    public boolean isBadPath() {
        return this.tag == Tag.BAD_PATH;
    }

    /**
     * Returns an instance of {@code ShareFolderError} that has its tag set to
     * {@link Tag#BAD_PATH}.
     *
     * <p> the {@code path} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)} is invalid. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ShareFolderError} with its tag set to {@link
     *     Tag#BAD_PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderError badPath(SharePathError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderError(Tag.BAD_PATH, value);
    }

    /**
     * the {@code path} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)} is invalid.
     *
     * <p> This instance must be tagged as {@link Tag#BAD_PATH}. </p>
     *
     * @return The {@link ShareFolderError#badPath} value associated with this
     *     instance if {@link #isBadPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBadPath} is {@code false}.
     */
    public SharePathError getBadPathValue() {
        if (this.tag != Tag.BAD_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_PATH, but was Tag." + tag.name());
        }
        return badPathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     */
    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     */
    public boolean isDisallowedSharedLinkPolicy() {
        return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            badPathValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ShareFolderError) {
            ShareFolderError other = (ShareFolderError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case EMAIL_UNVERIFIED:
                    return true;
                case BAD_PATH:
                    return (this.badPathValue == other.badPathValue) || (this.badPathValue.equals(other.badPathValue));
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    return true;
                case DISALLOWED_SHARED_LINK_POLICY:
                    return true;
                case OTHER:
                    return true;
                case NO_PERMISSION:
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
    static final class Serializer extends UnionSerializer<ShareFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShareFolderError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                case BAD_PATH: {
                    g.writeStartObject();
                    writeTag("bad_path", g);
                    g.writeFieldName("bad_path");
                    SharePathError.Serializer.INSTANCE.serialize(value.badPathValue, g);
                    g.writeEndObject();
                    break;
                }
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                    g.writeString("team_policy_disallows_member_policy");
                    break;
                }
                case DISALLOWED_SHARED_LINK_POLICY: {
                    g.writeString("disallowed_shared_link_policy");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public ShareFolderError deserialize(JsonParser p) throws IOException, JsonParseException {
            ShareFolderError value;
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
            else if ("email_unverified".equals(tag)) {
                value = ShareFolderError.EMAIL_UNVERIFIED;
            }
            else if ("bad_path".equals(tag)) {
                SharePathError fieldValue = null;
                expectField("bad_path", p);
                fieldValue = SharePathError.Serializer.INSTANCE.deserialize(p);
                value = ShareFolderError.badPath(fieldValue);
            }
            else if ("team_policy_disallows_member_policy".equals(tag)) {
                value = ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
            }
            else if ("disallowed_shared_link_policy".equals(tag)) {
                value = ShareFolderError.DISALLOWED_SHARED_LINK_POLICY;
            }
            else if ("other".equals(tag)) {
                value = ShareFolderError.OTHER;
            }
            else if ("no_permission".equals(tag)) {
                value = ShareFolderError.NO_PERMISSION;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
