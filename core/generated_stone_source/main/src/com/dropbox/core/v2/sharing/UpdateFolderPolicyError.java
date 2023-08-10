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
public final class UpdateFolderPolicyError {
    // union sharing.UpdateFolderPolicyError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link UpdateFolderPolicyError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * {@link UpdateFolderPolicyArg#getMemberPolicy} was set even though
         * user is not on a team.
         */
        NOT_ON_TEAM,
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
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
        /**
         * This action cannot be performed on a team shared folder.
         */
        TEAM_FOLDER,
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
     * {@link UpdateFolderPolicyArg#getMemberPolicy} was set even though user is
     * not on a team.
     */
    public static final UpdateFolderPolicyError NOT_ON_TEAM = new UpdateFolderPolicyError().withTag(Tag.NOT_ON_TEAM);
    /**
     * Team policy is more restrictive than {@link
     * ShareFolderArg#getMemberPolicy}.
     */
    public static final UpdateFolderPolicyError TEAM_POLICY_DISALLOWS_MEMBER_POLICY = new UpdateFolderPolicyError().withTag(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
    /**
     * The current account is not allowed to select the specified {@link
     * ShareFolderArg#getSharedLinkPolicy}.
     */
    public static final UpdateFolderPolicyError DISALLOWED_SHARED_LINK_POLICY = new UpdateFolderPolicyError().withTag(Tag.DISALLOWED_SHARED_LINK_POLICY);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final UpdateFolderPolicyError NO_PERMISSION = new UpdateFolderPolicyError().withTag(Tag.NO_PERMISSION);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final UpdateFolderPolicyError TEAM_FOLDER = new UpdateFolderPolicyError().withTag(Tag.TEAM_FOLDER);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UpdateFolderPolicyError OTHER = new UpdateFolderPolicyError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UpdateFolderPolicyError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UpdateFolderPolicyError withTag(Tag _tag) {
        UpdateFolderPolicyError result = new UpdateFolderPolicyError();
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
    private UpdateFolderPolicyError withTagAndAccessError(Tag _tag, SharedFolderAccessError accessErrorValue) {
        UpdateFolderPolicyError result = new UpdateFolderPolicyError();
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
     * values for this {@code UpdateFolderPolicyError}. </p>
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
     * Returns an instance of {@code UpdateFolderPolicyError} that has its tag
     * set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdateFolderPolicyError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdateFolderPolicyError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdateFolderPolicyError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link SharedFolderAccessError} value associated with this
     *     instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NOT_ON_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_ON_TEAM}, {@code false} otherwise.
     */
    public boolean isNotOnTeam() {
        return this._tag == Tag.NOT_ON_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
     */
    public boolean isTeamPolicyDisallowsMemberPolicy() {
        return this._tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
     */
    public boolean isDisallowedSharedLinkPolicy() {
        return this._tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
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
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
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
            accessErrorValue
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
        else if (obj instanceof UpdateFolderPolicyError) {
            UpdateFolderPolicyError other = (UpdateFolderPolicyError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case NOT_ON_TEAM:
                    return true;
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                    return true;
                case DISALLOWED_SHARED_LINK_POLICY:
                    return true;
                case NO_PERMISSION:
                    return true;
                case TEAM_FOLDER:
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
    static class Serializer extends UnionSerializer<UpdateFolderPolicyError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateFolderPolicyError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case NOT_ON_TEAM: {
                    g.writeString("not_on_team");
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
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case TEAM_FOLDER: {
                    g.writeString("team_folder");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public UpdateFolderPolicyError deserialize(JsonParser p) throws IOException, JsonParseException {
            UpdateFolderPolicyError value;
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
                SharedFolderAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharedFolderAccessError.Serializer.INSTANCE.deserialize(p);
                value = UpdateFolderPolicyError.accessError(fieldValue);
            }
            else if ("not_on_team".equals(tag)) {
                value = UpdateFolderPolicyError.NOT_ON_TEAM;
            }
            else if ("team_policy_disallows_member_policy".equals(tag)) {
                value = UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
            }
            else if ("disallowed_shared_link_policy".equals(tag)) {
                value = UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY;
            }
            else if ("no_permission".equals(tag)) {
                value = UpdateFolderPolicyError.NO_PERMISSION;
            }
            else if ("team_folder".equals(tag)) {
                value = UpdateFolderPolicyError.TEAM_FOLDER;
            }
            else {
                value = UpdateFolderPolicyError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
