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

public final class AddFolderMemberError {
    // union AddFolderMemberError

    /**
     * Discriminating tag type for {@link AddFolderMemberError}.
     */
    public enum Tag {
        /**
         * Unable to access shared folder.
         */
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * The current account's e-mail address is unverified.
         */
        EMAIL_UNVERIFIED,
        /**
         * {@link AddFolderMemberArg#getMembers} contains a bad invitation
         * recipient.
         */
        BAD_MEMBER, // AddMemberSelectorError
        /**
         * The current account does not have permission to perform this action.
         */
        NO_PERMISSION,
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
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("email_unverified", Tag.EMAIL_UNVERIFIED);
        VALUES_.put("bad_member", Tag.BAD_MEMBER);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("cant_share_outside_team", Tag.CANT_SHARE_OUTSIDE_TEAM);
        VALUES_.put("too_many_members", Tag.TOO_MANY_MEMBERS);
        VALUES_.put("too_many_pending_invites", Tag.TOO_MANY_PENDING_INVITES);
        VALUES_.put("rate_limit", Tag.RATE_LIMIT);
        VALUES_.put("insufficient_plan", Tag.INSUFFICIENT_PLAN);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final AddFolderMemberError EMAIL_UNVERIFIED = new AddFolderMemberError(Tag.EMAIL_UNVERIFIED, null, null, null, null);
    public static final AddFolderMemberError NO_PERMISSION = new AddFolderMemberError(Tag.NO_PERMISSION, null, null, null, null);
    public static final AddFolderMemberError CANT_SHARE_OUTSIDE_TEAM = new AddFolderMemberError(Tag.CANT_SHARE_OUTSIDE_TEAM, null, null, null, null);
    public static final AddFolderMemberError RATE_LIMIT = new AddFolderMemberError(Tag.RATE_LIMIT, null, null, null, null);
    public static final AddFolderMemberError INSUFFICIENT_PLAN = new AddFolderMemberError(Tag.INSUFFICIENT_PLAN, null, null, null, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code AddFolderMemberError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link AddFolderMemberError#accessError} value to assign to
     *     this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isEmailUnverified() {
        return this.tag == Tag.EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_MEMBER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#BAD_MEMBER}, {@code false} otherwise.
     */
    public boolean isBadMember() {
        return this.tag == Tag.BAD_MEMBER;
    }

    /**
     * Returns an instance of {@code AddFolderMemberError} that has its tag set
     * to {@link Tag#BAD_MEMBER}.
     *
     * <p> {@link AddFolderMemberArg#getMembers} contains a bad invitation
     * recipient. </p>
     *
     * @param value  {@link AddFolderMemberError#badMember} value to assign to
     *     this instance.
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
     * {@link AddFolderMemberArg#getMembers} contains a bad invitation
     * recipient.
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
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
     */
    public boolean isCantShareOutsideTeam() {
        return this.tag == Tag.CANT_SHARE_OUTSIDE_TEAM;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link AddFolderMemberError#tooManyMembers} value to assign
     *     to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link AddFolderMemberError#tooManyPendingInvites} value to
     *     assign to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#RATE_LIMIT}, {@code false} otherwise.
     */
    public boolean isRateLimit() {
        return this.tag == Tag.RATE_LIMIT;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
     */
    public boolean isInsufficientPlan() {
        return this.tag == Tag.INSUFFICIENT_PLAN;
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
                case NO_PERMISSION:
                    return true;
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

    public static AddFolderMemberError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AddFolderMemberError> _JSON_WRITER = new JsonWriter<AddFolderMemberError>() {
        public final void write(AddFolderMemberError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case EMAIL_UNVERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_unverified");
                    g.writeEndObject();
                    break;
                case BAD_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("bad_member");
                    g.writeFieldName("bad_member");
                    AddMemberSelectorError._JSON_WRITER.write(x.getBadMemberValue(), g);
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
                    g.writeEndObject();
                    break;
                case CANT_SHARE_OUTSIDE_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("cant_share_outside_team");
                    g.writeEndObject();
                    break;
                case TOO_MANY_MEMBERS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("too_many_members");
                    g.writeFieldName("too_many_members");
                    g.writeNumber(x.getTooManyMembersValue());
                    g.writeEndObject();
                    break;
                case TOO_MANY_PENDING_INVITES:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("too_many_pending_invites");
                    g.writeFieldName("too_many_pending_invites");
                    g.writeNumber(x.getTooManyPendingInvitesValue());
                    g.writeEndObject();
                    break;
                case RATE_LIMIT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("rate_limit");
                    g.writeEndObject();
                    break;
                case INSUFFICIENT_PLAN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("insufficient_plan");
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

    public static final JsonReader<AddFolderMemberError> _JSON_READER = new JsonReader<AddFolderMemberError>() {

        public final AddFolderMemberError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return AddFolderMemberError.OTHER;
                }
                switch (tag) {
                    case EMAIL_UNVERIFIED: return AddFolderMemberError.EMAIL_UNVERIFIED;
                    case NO_PERMISSION: return AddFolderMemberError.NO_PERMISSION;
                    case CANT_SHARE_OUTSIDE_TEAM: return AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM;
                    case RATE_LIMIT: return AddFolderMemberError.RATE_LIMIT;
                    case INSUFFICIENT_PLAN: return AddFolderMemberError.INSUFFICIENT_PLAN;
                    case OTHER: return AddFolderMemberError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            AddFolderMemberError value = null;
            if (tag != null) {
                switch (tag) {
                    case ACCESS_ERROR: {
                        SharedFolderAccessError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderAccessError._JSON_READER
                            .readField(parser, "access_error", v);
                        value = AddFolderMemberError.accessError(v);
                        break;
                    }
                    case EMAIL_UNVERIFIED: {
                        value = AddFolderMemberError.EMAIL_UNVERIFIED;
                        break;
                    }
                    case BAD_MEMBER: {
                        AddMemberSelectorError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = AddMemberSelectorError._JSON_READER
                            .readField(parser, "bad_member", v);
                        value = AddFolderMemberError.badMember(v);
                        break;
                    }
                    case NO_PERMISSION: {
                        value = AddFolderMemberError.NO_PERMISSION;
                        break;
                    }
                    case CANT_SHARE_OUTSIDE_TEAM: {
                        value = AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM;
                        break;
                    }
                    case TOO_MANY_MEMBERS: {
                        Long v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.UInt64Reader
                            .readField(parser, "too_many_members", v);
                        value = AddFolderMemberError.tooManyMembers(v);
                        break;
                    }
                    case TOO_MANY_PENDING_INVITES: {
                        Long v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.UInt64Reader
                            .readField(parser, "too_many_pending_invites", v);
                        value = AddFolderMemberError.tooManyPendingInvites(v);
                        break;
                    }
                    case RATE_LIMIT: {
                        value = AddFolderMemberError.RATE_LIMIT;
                        break;
                    }
                    case INSUFFICIENT_PLAN: {
                        value = AddFolderMemberError.INSUFFICIENT_PLAN;
                        break;
                    }
                    case OTHER: {
                        value = AddFolderMemberError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return AddFolderMemberError.OTHER;
            }
            return value;
        }

    };
}
