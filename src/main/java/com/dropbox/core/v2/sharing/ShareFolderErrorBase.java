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
public final class ShareFolderErrorBase {
    // union ShareFolderErrorBase

    /**
     * Discriminating tag type for {@link ShareFolderErrorBase}.
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
     * The current user's e-mail address is unverified.
     */
    public static final ShareFolderErrorBase EMAIL_UNVERIFIED = new ShareFolderErrorBase(Tag.EMAIL_UNVERIFIED, null);
    /**
     * Team policy is more restrictive than the {@code memberPolicy} argument to
     * {@link DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final ShareFolderErrorBase TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new ShareFolderErrorBase(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY, null);
    /**
     * The current user's account is not allowed to select the specified the
     * {@code sharedLinkPolicy} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)}.
     */
    public static final ShareFolderErrorBase DISALLOWED_SHARED_LINK_POLICY = new ShareFolderErrorBase(Tag.DISALLOWED_SHARED_LINK_POLICY, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ShareFolderErrorBase OTHER = new ShareFolderErrorBase(Tag.OTHER, null);

    private final Tag tag;
    private final SharePathError badPathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ShareFolderErrorBase(Tag tag, SharePathError badPathValue) {
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
     * values for this {@code ShareFolderErrorBase}. </p>
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
     * Returns an instance of {@code ShareFolderErrorBase} that has its tag set
     * to {@link Tag#BAD_PATH}.
     *
     * <p> the {@code path} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)} is invalid. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ShareFolderErrorBase} with its tag set to
     *     {@link Tag#BAD_PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderErrorBase badPath(SharePathError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderErrorBase(Tag.BAD_PATH, value);
    }

    /**
     * the {@code path} argument to {@link
     * DbxUserSharingRequests#shareFolder(String)} is invalid.
     *
     * <p> This instance must be tagged as {@link Tag#BAD_PATH}. </p>
     *
     * @return The {@link ShareFolderErrorBase#badPath} value associated with
     *     this instance if {@link #isBadPath} is {@code true}.
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            badPathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ShareFolderErrorBase) {
            ShareFolderErrorBase other = (ShareFolderErrorBase) obj;
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
    static final class Serializer extends UnionSerializer<ShareFolderErrorBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShareFolderErrorBase value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ShareFolderErrorBase deserialize(JsonParser p) throws IOException, JsonParseException {
            ShareFolderErrorBase value;
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
                value = ShareFolderErrorBase.EMAIL_UNVERIFIED;
            }
            else if ("bad_path".equals(tag)) {
                SharePathError fieldValue = null;
                expectField("bad_path", p);
                fieldValue = SharePathError.Serializer.INSTANCE.deserialize(p);
                value = ShareFolderErrorBase.badPath(fieldValue);
            }
            else if ("team_policy_disallows_member_policy".equals(tag)) {
                value = ShareFolderErrorBase.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
            }
            else if ("disallowed_shared_link_policy".equals(tag)) {
                value = ShareFolderErrorBase.DISALLOWED_SHARED_LINK_POLICY;
            }
            else {
                value = ShareFolderErrorBase.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
