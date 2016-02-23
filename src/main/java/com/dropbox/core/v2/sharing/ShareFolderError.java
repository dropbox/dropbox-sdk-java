/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class ShareFolderError {
    // union ShareFolderError

    /**
     * Discriminating tag type for {@link ShareFolderError}.
     */
    public enum Tag {
        /**
         * The current account's e-mail address is unverified.
         */
        EMAIL_UNVERIFIED,
        /**
         * {@link ShareFolderArg#getPath} is invalid.
         */
        BAD_PATH, // SharePathError
        /**
         * Team policy is more restrictive than {@link
         * ShareFolderArg#getMemberPolicy}.
         */
        TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
        /**
         * The current account is not allowed to select the specified {@link
         * ShareFolderArg#getSharedLinkPolicy}.
         */
        DISALLOWED_SHARED_LINK_POLICY,
        /**
         * The current account does not have permission to perform this action.
         */
        NO_PERMISSION,
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("email_unverified", Tag.EMAIL_UNVERIFIED);
        VALUES_.put("bad_path", Tag.BAD_PATH);
        VALUES_.put("team_policy_disallows_member_policy", Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
        VALUES_.put("disallowed_shared_link_policy", Tag.DISALLOWED_SHARED_LINK_POLICY);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final ShareFolderError EMAIL_UNVERIFIED = new ShareFolderError(Tag.EMAIL_UNVERIFIED, null);
    public static final ShareFolderError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new ShareFolderError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY, null);
    public static final ShareFolderError DISALLOWED_SHARED_LINK_POLICY = new ShareFolderError(Tag.DISALLOWED_SHARED_LINK_POLICY, null);
    public static final ShareFolderError NO_PERMISSION = new ShareFolderError(Tag.NO_PERMISSION, null);
    public static final ShareFolderError OTHER = new ShareFolderError(Tag.OTHER, null);

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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code ShareFolderError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailUnverified() {
        return this.tag == Tag.EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#BAD_PATH}, {@code false} otherwise.
     */
    public boolean isBadPath() {
        return this.tag == Tag.BAD_PATH;
    }

    /**
     * Returns an instance of {@code ShareFolderError} that has its tag set to
     * {@link Tag#BAD_PATH}.
     *
     * <p> {@link ShareFolderArg#getPath} is invalid. </p>
     *
     * @param value  {@link ShareFolderError#badPath} value to assign to this
     *     instance.
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
     * {@link ShareFolderArg#getPath} is invalid.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     */
    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     */
    public boolean isDisallowedSharedLinkPolicy() {
        return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ShareFolderError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ShareFolderError> _JSON_WRITER = new JsonWriter<ShareFolderError>() {
        public final void write(ShareFolderError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case EMAIL_UNVERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_unverified");
                    g.writeEndObject();
                    break;
                case BAD_PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("bad_path");
                    g.writeFieldName("bad_path");
                    SharePathError._JSON_WRITER.write(x.getBadPathValue(), g);
                    g.writeEndObject();
                    break;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_policy_disallows_member_policy");
                    g.writeEndObject();
                    break;
                case DISALLOWED_SHARED_LINK_POLICY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("disallowed_shared_link_policy");
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ShareFolderError> _JSON_READER = new JsonReader<ShareFolderError>() {

        public final ShareFolderError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return ShareFolderError.OTHER;
                }
                switch (tag) {
                    case EMAIL_UNVERIFIED: return ShareFolderError.EMAIL_UNVERIFIED;
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: return ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                    case DISALLOWED_SHARED_LINK_POLICY: return ShareFolderError.DISALLOWED_SHARED_LINK_POLICY;
                    case NO_PERMISSION: return ShareFolderError.NO_PERMISSION;
                    case OTHER: return ShareFolderError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            ShareFolderError value = null;
            if (tag != null) {
                switch (tag) {
                    case EMAIL_UNVERIFIED: {
                        value = ShareFolderError.EMAIL_UNVERIFIED;
                        break;
                    }
                    case BAD_PATH: {
                        SharePathError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharePathError._JSON_READER
                            .readField(parser, "bad_path", v);
                        value = ShareFolderError.badPath(v);
                        break;
                    }
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                        value = ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                        break;
                    }
                    case DISALLOWED_SHARED_LINK_POLICY: {
                        value = ShareFolderError.DISALLOWED_SHARED_LINK_POLICY;
                        break;
                    }
                    case NO_PERMISSION: {
                        value = ShareFolderError.NO_PERMISSION;
                        break;
                    }
                    case OTHER: {
                        value = ShareFolderError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return ShareFolderError.OTHER;
            }
            return value;
        }

    };
}
