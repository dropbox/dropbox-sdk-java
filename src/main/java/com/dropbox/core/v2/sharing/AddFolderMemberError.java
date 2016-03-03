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
@JsonSerialize(using=AddFolderMemberError.Serializer.class)
@JsonDeserialize(using=AddFolderMemberError.Deserializer.class)
public final class AddFolderMemberError {
    // union AddFolderMemberError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
         * the {@code members} argument to {@link
         * DbxUserSharingRequests#addFolderMember(String,java.util.List)}
         * contains a bad invitation recipient.
         */
        BAD_MEMBER, // AddMemberSelectorError
        /**
         * Your team policy does not allow sharing outside of the team.
         */
        CANT_SHARE_OUTSIDE_TEAM,
        /**
         * The value is the member limit that was reached.
         */
        TOO_MANY_MEMBERS, // Long
        /**
         * The value is the pending invite limit that was reached.
         */
        TOO_MANY_PENDING_INVITES, // Long
        /**
         * The user has reached the rate limit for invitations.
         */
        RATE_LIMIT,
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
    public static final AddFolderMemberError EMAIL_UNVERIFIED = new AddFolderMemberError(Tag.EMAIL_UNVERIFIED, null, null, null, null);
    /**
     * Your team policy does not allow sharing outside of the team.
     */
    public static final AddFolderMemberError CANT_SHARE_OUTSIDE_TEAM = new AddFolderMemberError(Tag.CANT_SHARE_OUTSIDE_TEAM, null, null, null, null);
    /**
     * The user has reached the rate limit for invitations.
     */
    public static final AddFolderMemberError RATE_LIMIT = new AddFolderMemberError(Tag.RATE_LIMIT, null, null, null, null);
    /**
     * The current user's account doesn't support this action. An example of
     * this is when adding a read-only member. This action can only be performed
     * by users that have upgraded to a Pro or Business plan.
     */
    public static final AddFolderMemberError INSUFFICIENT_PLAN = new AddFolderMemberError(Tag.INSUFFICIENT_PLAN, null, null, null, null);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final AddFolderMemberError TEAM_FOLDER = new AddFolderMemberError(Tag.TEAM_FOLDER, null, null, null, null);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final AddFolderMemberError NO_PERMISSION = new AddFolderMemberError(Tag.NO_PERMISSION, null, null, null, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final AddFolderMemberError OTHER = new AddFolderMemberError(Tag.OTHER, null, null, null, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;
    private final AddMemberSelectorError badMemberValue;
    private final Long tooManyMembersValue;
    private final Long tooManyPendingInvitesValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private AddFolderMemberError(Tag tag, SharedFolderAccessError accessErrorValue, AddMemberSelectorError badMemberValue, Long tooManyMembersValue, Long tooManyPendingInvitesValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
        this.badMemberValue = badMemberValue;
        this.tooManyMembersValue = tooManyMembersValue;
        this.tooManyPendingInvitesValue = tooManyPendingInvitesValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
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
        return new AddFolderMemberError(Tag.ACCESS_ERROR, value, null, null, null);
    }

    /**
     * Unable to access shared folder.
     *
     * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
     *
     * @return The {@link AddFolderMemberError#accessError} value associated
     *     with this instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
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
        return this.tag == Tag.EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_MEMBER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BAD_MEMBER}, {@code false} otherwise.
     */
    public boolean isBadMember() {
        return this.tag == Tag.BAD_MEMBER;
    }

    /**
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#BAD_MEMBER}.
     *
     * <p> the {@code members} argument to {@link
     * DbxUserSharingRequests#addFolderMember(String,java.util.List)} contains a
     * bad invitation recipient. </p>
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
        return new AddFolderMemberError(Tag.BAD_MEMBER, null, value, null, null);
    }

    /**
     * the {@code members} argument to {@link
     * DbxUserSharingRequests#addFolderMember(String,java.util.List)} contains a
     * bad invitation recipient.
     *
     * <p> This instance must be tagged as {@link Tag#BAD_MEMBER}. </p>
     *
     * @return The {@link AddFolderMemberError#badMember} value associated with
     *     this instance if {@link #isBadMember} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isBadMember} is {@code false}.
     */
    public AddMemberSelectorError getBadMemberValue() {
        if (this.tag != Tag.BAD_MEMBER) {
            throw new IllegalStateException("Invalid tag: required Tag.BAD_MEMBER, but was Tag." + tag.name());
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
        return this.tag == Tag.CANT_SHARE_OUTSIDE_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
     */
    public boolean isTooManyMembers() {
        return this.tag == Tag.TOO_MANY_MEMBERS;
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
        return new AddFolderMemberError(Tag.TOO_MANY_MEMBERS, null, null, value, null);
    }

    /**
     * The value is the member limit that was reached.
     *
     * <p> This instance must be tagged as {@link Tag#TOO_MANY_MEMBERS}. </p>
     *
     * @return The {@link AddFolderMemberError#tooManyMembers} value associated
     *     with this instance if {@link #isTooManyMembers} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooManyMembers} is {@code
     *     false}.
     */
    public long getTooManyMembersValue() {
        if (this.tag != Tag.TOO_MANY_MEMBERS) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_MEMBERS, but was Tag." + tag.name());
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
        return this.tag == Tag.TOO_MANY_PENDING_INVITES;
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
        return new AddFolderMemberError(Tag.TOO_MANY_PENDING_INVITES, null, null, null, value);
    }

    /**
     * The value is the pending invite limit that was reached.
     *
     * <p> This instance must be tagged as {@link Tag#TOO_MANY_PENDING_INVITES}.
     * </p>
     *
     * @return The {@link AddFolderMemberError#tooManyPendingInvites} value
     *     associated with this instance if {@link #isTooManyPendingInvites} is
     *     {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTooManyPendingInvites} is
     *     {@code false}.
     */
    public long getTooManyPendingInvitesValue() {
        if (this.tag != Tag.TOO_MANY_PENDING_INVITES) {
            throw new IllegalStateException("Invalid tag: required Tag.TOO_MANY_PENDING_INVITES, but was Tag." + tag.name());
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
        return this.tag == Tag.RATE_LIMIT;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     */
    public boolean isInsufficientPlan() {
        return this.tag == Tag.INSUFFICIENT_PLAN;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this.tag == Tag.TEAM_FOLDER;
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
        else if (obj instanceof AddFolderMemberError) {
            AddFolderMemberError other = (AddFolderMemberError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case EMAIL_UNVERIFIED:
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

    static final class Serializer extends UnionJsonSerializer<AddFolderMemberError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AddFolderMemberError.class);
        }

        @Override
        public void serialize(AddFolderMemberError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "access_error");
                    g.writeObjectField("access_error", value.accessErrorValue);
                    g.writeEndObject();
                    break;
                case EMAIL_UNVERIFIED:
                    g.writeString("email_unverified");
                    break;
                case BAD_MEMBER:
                    g.writeStartObject();
                    g.writeStringField(".tag", "bad_member");
                    g.writeObjectField("bad_member", value.badMemberValue);
                    g.writeEndObject();
                    break;
                case CANT_SHARE_OUTSIDE_TEAM:
                    g.writeString("cant_share_outside_team");
                    break;
                case TOO_MANY_MEMBERS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "too_many_members");
                    g.writeObjectField("too_many_members", value.tooManyMembersValue);
                    g.writeEndObject();
                    break;
                case TOO_MANY_PENDING_INVITES:
                    g.writeStartObject();
                    g.writeStringField(".tag", "too_many_pending_invites");
                    g.writeObjectField("too_many_pending_invites", value.tooManyPendingInvitesValue);
                    g.writeEndObject();
                    break;
                case RATE_LIMIT:
                    g.writeString("rate_limit");
                    break;
                case INSUFFICIENT_PLAN:
                    g.writeString("insufficient_plan");
                    break;
                case TEAM_FOLDER:
                    g.writeString("team_folder");
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

    static final class Deserializer extends UnionJsonDeserializer<AddFolderMemberError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AddFolderMemberError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public AddFolderMemberError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ACCESS_ERROR: {
                    SharedFolderAccessError value = null;
                    expectField(_p, "access_error");
                    value = _p.readValueAs(SharedFolderAccessError.class);
                    _p.nextToken();
                    return AddFolderMemberError.accessError(value);
                }
                case EMAIL_UNVERIFIED: {
                    return AddFolderMemberError.EMAIL_UNVERIFIED;
                }
                case BAD_MEMBER: {
                    AddMemberSelectorError value = null;
                    expectField(_p, "bad_member");
                    value = _p.readValueAs(AddMemberSelectorError.class);
                    _p.nextToken();
                    return AddFolderMemberError.badMember(value);
                }
                case CANT_SHARE_OUTSIDE_TEAM: {
                    return AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM;
                }
                case TOO_MANY_MEMBERS: {
                    Long value = null;
                    expectField(_p, "too_many_members");
                    value = _p.getLongValue();
                    assertUnsigned(_p, value);
                    _p.nextToken();
                    return AddFolderMemberError.tooManyMembers(value);
                }
                case TOO_MANY_PENDING_INVITES: {
                    Long value = null;
                    expectField(_p, "too_many_pending_invites");
                    value = _p.getLongValue();
                    assertUnsigned(_p, value);
                    _p.nextToken();
                    return AddFolderMemberError.tooManyPendingInvites(value);
                }
                case RATE_LIMIT: {
                    return AddFolderMemberError.RATE_LIMIT;
                }
                case INSUFFICIENT_PLAN: {
                    return AddFolderMemberError.INSUFFICIENT_PLAN;
                }
                case TEAM_FOLDER: {
                    return AddFolderMemberError.TEAM_FOLDER;
                }
                case NO_PERMISSION: {
                    return AddFolderMemberError.NO_PERMISSION;
                }
                case OTHER: {
                    return AddFolderMemberError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, AddFolderMemberError.Tag> getTagMapping() {
            Map<String, AddFolderMemberError.Tag> values = new HashMap<String, AddFolderMemberError.Tag>();
            values.put("access_error", AddFolderMemberError.Tag.ACCESS_ERROR);
            values.put("email_unverified", AddFolderMemberError.Tag.EMAIL_UNVERIFIED);
            values.put("bad_member", AddFolderMemberError.Tag.BAD_MEMBER);
            values.put("cant_share_outside_team", AddFolderMemberError.Tag.CANT_SHARE_OUTSIDE_TEAM);
            values.put("too_many_members", AddFolderMemberError.Tag.TOO_MANY_MEMBERS);
            values.put("too_many_pending_invites", AddFolderMemberError.Tag.TOO_MANY_PENDING_INVITES);
            values.put("rate_limit", AddFolderMemberError.Tag.RATE_LIMIT);
            values.put("insufficient_plan", AddFolderMemberError.Tag.INSUFFICIENT_PLAN);
            values.put("team_folder", AddFolderMemberError.Tag.TEAM_FOLDER);
            values.put("no_permission", AddFolderMemberError.Tag.NO_PERMISSION);
            values.put("other", AddFolderMemberError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
