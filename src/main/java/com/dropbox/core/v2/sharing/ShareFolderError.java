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
@JsonSerialize(using=ShareFolderError.Serializer.class)
@JsonDeserialize(using=ShareFolderError.Deserializer.class)
public final class ShareFolderError {
    // union ShareFolderError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
    /**
     * The current user does not have permission to perform this action.
     */
    public static final ShareFolderError NO_PERMISSION = new ShareFolderError(Tag.NO_PERMISSION, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ShareFolderError}. </p>
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

    static final class Serializer extends UnionJsonSerializer<ShareFolderError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ShareFolderError.class);
        }

        @Override
        public void serialize(ShareFolderError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case EMAIL_UNVERIFIED:
                    g.writeString("email_unverified");
                    break;
                case BAD_PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "bad_path");
                    g.writeObjectField("bad_path", value.badPathValue);
                    g.writeEndObject();
                    break;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    g.writeString("team_policy_disallows_member_policy");
                    break;
                case DISALLOWED_SHARED_LINK_POLICY:
                    g.writeString("disallowed_shared_link_policy");
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

    static final class Deserializer extends UnionJsonDeserializer<ShareFolderError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ShareFolderError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public ShareFolderError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case EMAIL_UNVERIFIED: {
                    return ShareFolderError.EMAIL_UNVERIFIED;
                }
                case BAD_PATH: {
                    SharePathError value = null;
                    expectField(_p, "bad_path");
                    value = _p.readValueAs(SharePathError.class);
                    _p.nextToken();
                    return ShareFolderError.badPath(value);
                }
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                    return ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
                }
                case DISALLOWED_SHARED_LINK_POLICY: {
                    return ShareFolderError.DISALLOWED_SHARED_LINK_POLICY;
                }
                case NO_PERMISSION: {
                    return ShareFolderError.NO_PERMISSION;
                }
                case OTHER: {
                    return ShareFolderError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, ShareFolderError.Tag> getTagMapping() {
            Map<String, ShareFolderError.Tag> values = new HashMap<String, ShareFolderError.Tag>();
            values.put("email_unverified", ShareFolderError.Tag.EMAIL_UNVERIFIED);
            values.put("bad_path", ShareFolderError.Tag.BAD_PATH);
            values.put("team_policy_disallows_member_policy", ShareFolderError.Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
            values.put("disallowed_shared_link_policy", ShareFolderError.Tag.DISALLOWED_SHARED_LINK_POLICY);
            values.put("no_permission", ShareFolderError.Tag.NO_PERMISSION);
            values.put("other", ShareFolderError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
