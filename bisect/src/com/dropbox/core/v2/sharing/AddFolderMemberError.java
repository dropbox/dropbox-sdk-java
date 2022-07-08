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
public final class AddFolderMemberError {
    // union sharing.AddFolderMemberError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link AddFolderMemberError}.
     */
    public enum Tag {
        /**
         * Unable to access shared folder.
         */
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * The current user's e-mail address is unverified.
         */
        EMAIL_UNVERIFIED,
        /**
         * The current user has been banned.
         */
        BANNED_MEMBER,
        /**
         * {@link AddFolderMemberArg#getMembers} contains a bad invitation
         * recipient.
         */
        BAD_MEMBER, // AddMemberSelectorError
        /**
         * Your team policy does not allow sharing outside of the team.
         */
        CANT_SHARE_OUTSIDE_TEAM,
        /**
         * The value is the member limit that was reached.
         */
        TOO_MANY_MEMBERS, // long
        /**
         * The value is the pending invite limit that was reached.
         */
        TOO_MANY_PENDING_INVITES, // long
        /**
         * The current user has hit the limit of invites they can send per day.
         * Try again in 24 hours.
         */
        RATE_LIMIT,
        /**
         * The current user is trying to share with too many people at once.
         */
        TOO_MANY_INVITEES,
        /**
         * The current user's account doesn't support this action. An example of
         * this is when adding a read-only member. This action can only be
         * performed by users that have upgraded to a Pro or Business plan.
         */
        INSUFFICIENT_PLAN,
        /**
         * This action cannot be performed on a team shared folder.
         */
        TEAM_FOLDER,
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
    public static final AddFolderMemberError EMAIL_UNVERIFIED = new AddFolderMemberError().withTag(Tag.EMAIL_UNVERIFIED);
    /**
     * The current user has been banned.
     */
    public static final AddFolderMemberError BANNED_MEMBER = new AddFolderMemberError().withTag(Tag.BANNED_MEMBER);
    /**
     * Your team policy does not allow sharing outside of the team.
     */
    public static final AddFolderMemberError CANT_SHARE_OUTSIDE_TEAM = new AddFolderMemberError().withTag(Tag.CANT_SHARE_OUTSIDE_TEAM);
    /**
     * The current user has hit the limit of invites they can send per day. Try
     * again in 24 hours.
     */
    public static final AddFolderMemberError RATE_LIMIT = new AddFolderMemberError().withTag(Tag.RATE_LIMIT);
    /**
     * The current user is trying to share with too many people at once.
     */
    public static final AddFolderMemberError TOO_MANY_INVITEES = new AddFolderMemberError().withTag(Tag.TOO_MANY_INVITEES);
    /**
     * The current user's account doesn't support this action. An example of
     * this is when adding a read-only member. This action can only be performed
     * by users that have upgraded to a Pro or Business plan.
     */
    public static final AddFolderMemberError INSUFFICIENT_PLAN = new AddFolderMemberError().withTag(Tag.INSUFFICIENT_PLAN);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final AddFolderMemberError TEAM_FOLDER = new AddFolderMemberError().withTag(Tag.TEAM_FOLDER);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final AddFolderMemberError NO_PERMISSION = new AddFolderMemberError().withTag(Tag.NO_PERMISSION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final AddFolderMemberError OTHER = new AddFolderMemberError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private AddMemberSelectorError badMemberValue;
    private Long tooManyMembersValue;
    private Long tooManyPendingInvitesValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AddFolderMemberError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AddFolderMemberError withTag(Tag _tag) {
        AddFolderMemberError result = new AddFolderMemberError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Unable to access shared folder. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddFolderMemberError withTagAndAccessError(Tag _tag, SharedFolderAccessError accessErrorValue) {
        AddFolderMemberError result = new AddFolderMemberError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     *
     * @param badMemberValue  {@link AddFolderMemberArg#getMembers} contains a
     *     bad invitation recipient. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AddFolderMemberError withTagAndBadMember(Tag _tag, AddMemberSelectorError badMemberValue) {
        AddFolderMemberError result = new AddFolderMemberError();
        result._tag = _tag;
        result.badMemberValue = badMemberValue;
        return result;
    }

    /**
     *
     * @param tooManyMembersValue  The value is the member limit that was
     *     reached.
     * @param _tag  Discriminating tag for this instance.
     */
    private AddFolderMemberError withTagAndTooManyMembers(Tag _tag, Long tooManyMembersValue) {
        AddFolderMemberError result = new AddFolderMemberError();
        result._tag = _tag;
        result.tooManyMembersValue = tooManyMembersValue;
        return result;
    }

    /**
     *
     * @param tooManyPendingInvitesValue  The value is the pending invite limit
     *     that was reached.
     * @param _tag  Discriminating tag for this instance.
     */
    private AddFolderMemberError withTagAndTooManyPendingInvites(Tag _tag, Long tooManyPendingInvitesValue) {
        AddFolderMemberError result = new AddFolderMemberError();
        result._tag = _tag;
        result.tooManyPendingInvitesValue = tooManyPendingInvitesValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AddFolderMemberError}. </p>
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
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
     *
     * <p> Unable to access shared folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddFolderMemberError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AddFolderMemberError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFolderMemberError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * Unable to access shared folder.
     *
     * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
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
     * Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailUnverified() {
        return this._tag == Tag.EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#BANNED_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BANNED_MEMBER}, {@code false} otherwise.
     */
    public boolean isBannedMember() {
        return this._tag == Tag.BANNED_MEMBER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_MEMBER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BAD_MEMBER}, {@code false} otherwise.
     */
    public boolean isBadMember() {
        return this._tag == Tag.BAD_MEMBER;
    }

    /**
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#BAD_MEMBER}.
     *
     * <p> {@link AddFolderMemberArg#getMembers} contains a bad invitation
     * recipient. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddFolderMemberError} with its tag set to
     *     {@link Tag#BAD_MEMBER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AddFolderMemberError badMember(AddMemberSelectorError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AddFolderMemberError().withTagAndBadMember(Tag.BAD_MEMBER, value);
    }

    /**
     * {@link AddFolderMemberArg#getMembers} contains a bad invitation
     * recipient.
     *
     * <p> This instance must be tagged as {@link Tag#BAD_MEMBER}. </p>
     *
     * @return The {@link AddMemberSelectorError} value associated with this
     *     instance if {@link #isBadMember} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBadMember} is {@code false}.
     */
    public AddMemberSelectorError getBadMemberValue() {
        if (this._tag != Tag.BAD_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_MEMBER, but was Tag." + this._tag.name());
        }
        return badMemberValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
     */
    public boolean isCantShareOutsideTeam() {
        return this._tag == Tag.CANT_SHARE_OUTSIDE_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
     */
    public boolean isTooManyMembers() {
        return this._tag == Tag.TOO_MANY_MEMBERS;
    }

    /**
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#TOO_MANY_MEMBERS}.
     *
     * <p> The value is the member limit that was reached. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddFolderMemberError} with its tag set to
     *     {@link Tag#TOO_MANY_MEMBERS}.
     */
    public static AddFolderMemberError tooManyMembers(long value) {
        return new AddFolderMemberError().withTagAndTooManyMembers(Tag.TOO_MANY_MEMBERS, value);
    }

    /**
     * The value is the member limit that was reached.
     *
     * <p> This instance must be tagged as {@link Tag#TOO_MANY_MEMBERS}. </p>
     *
     * @return The {@link long} value associated with this instance if {@link
     *     #isTooManyMembers} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooManyMembers} is {@code
     *     false}.
     */
    public long getTooManyMembersValue() {
        if (this._tag != Tag.TOO_MANY_MEMBERS) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_MEMBERS, but was Tag." + this._tag.name());
        }
        return tooManyMembersValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_PENDING_INVITES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_PENDING_INVITES}, {@code false} otherwise.
     */
    public boolean isTooManyPendingInvites() {
        return this._tag == Tag.TOO_MANY_PENDING_INVITES;
    }

    /**
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#TOO_MANY_PENDING_INVITES}.
     *
     * <p> The value is the pending invite limit that was reached. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AddFolderMemberError} with its tag set to
     *     {@link Tag#TOO_MANY_PENDING_INVITES}.
     */
    public static AddFolderMemberError tooManyPendingInvites(long value) {
        return new AddFolderMemberError().withTagAndTooManyPendingInvites(Tag.TOO_MANY_PENDING_INVITES, value);
    }

    /**
     * The value is the pending invite limit that was reached.
     *
     * <p> This instance must be tagged as {@link Tag#TOO_MANY_PENDING_INVITES}.
     * </p>
     *
     * @return The {@link long} value associated with this instance if {@link
     *     #isTooManyPendingInvites} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooManyPendingInvites} is
     *     {@code false}.
     */
    public long getTooManyPendingInvitesValue() {
        if (this._tag != Tag.TOO_MANY_PENDING_INVITES) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_PENDING_INVITES, but was Tag." + this._tag.name());
        }
        return tooManyPendingInvitesValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#RATE_LIMIT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RATE_LIMIT}, {@code false} otherwise.
     */
    public boolean isRateLimit() {
        return this._tag == Tag.RATE_LIMIT;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_INVITEES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_INVITEES}, {@code false} otherwise.
     */
    public boolean isTooManyInvitees() {
        return this._tag == Tag.TOO_MANY_INVITEES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     */
    public boolean isInsufficientPlan() {
        return this._tag == Tag.INSUFFICIENT_PLAN;
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
            _tag,
            accessErrorValue,
            badMemberValue,
            tooManyMembersValue,
            tooManyPendingInvitesValue
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
        else if (obj instanceof AddFolderMemberError) {
            AddFolderMemberError other = (AddFolderMemberError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case EMAIL_UNVERIFIED:
                    return true;
                case BANNED_MEMBER:
                    return true;
                case BAD_MEMBER:
                    return (this.badMemberValue == other.badMemberValue) || (this.badMemberValue.equals(other.badMemberValue));
                case CANT_SHARE_OUTSIDE_TEAM:
                    return true;
                case TOO_MANY_MEMBERS:
                    return this.tooManyMembersValue == other.tooManyMembersValue;
                case TOO_MANY_PENDING_INVITES:
                    return this.tooManyPendingInvitesValue == other.tooManyPendingInvitesValue;
                case RATE_LIMIT:
                    return true;
                case TOO_MANY_INVITEES:
                    return true;
                case INSUFFICIENT_PLAN:
                    return true;
                case TEAM_FOLDER:
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
    static class Serializer extends UnionSerializer<AddFolderMemberError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AddFolderMemberError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case EMAIL_UNVERIFIED: {
                    g.writeString("email_unverified");
                    break;
                }
                case BANNED_MEMBER: {
                    g.writeString("banned_member");
                    break;
                }
                case BAD_MEMBER: {
                    g.writeStartObject();
                    writeTag("bad_member", g);
                    g.writeFieldName("bad_member");
                    AddMemberSelectorError.Serializer.INSTANCE.serialize(value.badMemberValue, g);
                    g.writeEndObject();
                    break;
                }
                case CANT_SHARE_OUTSIDE_TEAM: {
                    g.writeString("cant_share_outside_team");
                    break;
                }
                case TOO_MANY_MEMBERS: {
                    g.writeStartObject();
                    writeTag("too_many_members", g);
                    g.writeFieldName("too_many_members");
                    StoneSerializers.uInt64().serialize(value.tooManyMembersValue, g);
                    g.writeEndObject();
                    break;
                }
                case TOO_MANY_PENDING_INVITES: {
                    g.writeStartObject();
                    writeTag("too_many_pending_invites", g);
                    g.writeFieldName("too_many_pending_invites");
                    StoneSerializers.uInt64().serialize(value.tooManyPendingInvitesValue, g);
                    g.writeEndObject();
                    break;
                }
                case RATE_LIMIT: {
                    g.writeString("rate_limit");
                    break;
                }
                case TOO_MANY_INVITEES: {
                    g.writeString("too_many_invitees");
                    break;
                }
                case INSUFFICIENT_PLAN: {
                    g.writeString("insufficient_plan");
                    break;
                }
                case TEAM_FOLDER: {
                    g.writeString("team_folder");
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
        public AddFolderMemberError deserialize(JsonParser p) throws IOException, JsonParseException {
            AddFolderMemberError value;
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
                value = AddFolderMemberError.accessError(fieldValue);
            }
            else if ("email_unverified".equals(tag)) {
                value = AddFolderMemberError.EMAIL_UNVERIFIED;
            }
            else if ("banned_member".equals(tag)) {
                value = AddFolderMemberError.BANNED_MEMBER;
            }
            else if ("bad_member".equals(tag)) {
                AddMemberSelectorError fieldValue = null;
                expectField("bad_member", p);
                fieldValue = AddMemberSelectorError.Serializer.INSTANCE.deserialize(p);
                value = AddFolderMemberError.badMember(fieldValue);
            }
            else if ("cant_share_outside_team".equals(tag)) {
                value = AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM;
            }
            else if ("too_many_members".equals(tag)) {
                Long fieldValue = null;
                expectField("too_many_members", p);
                fieldValue = StoneSerializers.uInt64().deserialize(p);
                value = AddFolderMemberError.tooManyMembers(fieldValue);
            }
            else if ("too_many_pending_invites".equals(tag)) {
                Long fieldValue = null;
                expectField("too_many_pending_invites", p);
                fieldValue = StoneSerializers.uInt64().deserialize(p);
                value = AddFolderMemberError.tooManyPendingInvites(fieldValue);
            }
            else if ("rate_limit".equals(tag)) {
                value = AddFolderMemberError.RATE_LIMIT;
            }
            else if ("too_many_invitees".equals(tag)) {
                value = AddFolderMemberError.TOO_MANY_INVITEES;
            }
            else if ("insufficient_plan".equals(tag)) {
                value = AddFolderMemberError.INSUFFICIENT_PLAN;
            }
            else if ("team_folder".equals(tag)) {
                value = AddFolderMemberError.TEAM_FOLDER;
            }
            else if ("no_permission".equals(tag)) {
                value = AddFolderMemberError.NO_PERMISSION;
            }
            else {
                value = AddFolderMemberError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
