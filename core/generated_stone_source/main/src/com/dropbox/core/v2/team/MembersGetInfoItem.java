/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

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
 * Describes a result obtained for a single user whose id was specified in the
 * parameter of {@link DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class MembersGetInfoItem {
    // union team.MembersGetInfoItem (team_members.stone)

    /**
     * Discriminating tag type for {@link MembersGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeamTeamRequests#membersGetInfo(java.util.List)} or {@link
         * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}, and did not
         * match a corresponding user. This might be a team_member_id, an email,
         * or an external ID, depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a team member.
         */
        MEMBER_INFO; // TeamMemberInfo
    }

    private Tag _tag;
    private String idNotFoundValue;
    private TeamMemberInfo memberInfoValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MembersGetInfoItem() {
    }


    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MembersGetInfoItem withTag(Tag _tag) {
        MembersGetInfoItem result = new MembersGetInfoItem();
        result._tag = _tag;
        return result;
    }

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
     *
     * @param idNotFoundValue  An ID that was provided as a parameter to {@link
     *     DbxTeamTeamRequests#membersGetInfo(java.util.List)} or {@link
     *     DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}, and did not
     *     match a corresponding user. This might be a team_member_id, an email,
     *     or an external ID, depending on how the method was called. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersGetInfoItem withTagAndIdNotFound(Tag _tag, String idNotFoundValue) {
        MembersGetInfoItem result = new MembersGetInfoItem();
        result._tag = _tag;
        result.idNotFoundValue = idNotFoundValue;
        return result;
    }

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
     *
     * @param memberInfoValue  Info about a team member. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersGetInfoItem withTagAndMemberInfo(Tag _tag, TeamMemberInfo memberInfoValue) {
        MembersGetInfoItem result = new MembersGetInfoItem();
        result._tag = _tag;
        result.memberInfoValue = memberInfoValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MembersGetInfoItem}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ID_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ID_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code MembersGetInfoItem} that has its tag set to
     * {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)} or {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}, and did not match
     * a corresponding user. This might be a team_member_id, an email, or an
     * external ID, depending on how the method was called. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersGetInfoItem} with its tag set to {@link
     *     Tag#ID_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersGetInfoItem idNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItem().withTagAndIdNotFound(Tag.ID_NOT_FOUND, value);
    }

    /**
     * An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)} or {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}, and did not match
     * a corresponding user. This might be a team_member_id, an email, or an
     * external ID, depending on how the method was called.
     *
     * <p> This instance must be tagged as {@link Tag#ID_NOT_FOUND}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isIdNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIdNotFound} is {@code false}.
     */
    public String getIdNotFoundValue() {
        if (this._tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return idNotFoundValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MEMBER_INFO}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MEMBER_INFO}, {@code false} otherwise.
     */
    public boolean isMemberInfo() {
        return this._tag == Tag.MEMBER_INFO;
    }

    /**
     * Returns an instance of {@code MembersGetInfoItem} that has its tag set to
     * {@link Tag#MEMBER_INFO}.
     *
     * <p> Info about a team member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersGetInfoItem} with its tag set to {@link
     *     Tag#MEMBER_INFO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersGetInfoItem memberInfo(TeamMemberInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItem().withTagAndMemberInfo(Tag.MEMBER_INFO, value);
    }

    /**
     * Info about a team member.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBER_INFO}. </p>
     *
     * @return The {@link TeamMemberInfo} value associated with this instance if
     *     {@link #isMemberInfo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMemberInfo} is {@code false}.
     */
    public TeamMemberInfo getMemberInfoValue() {
        if (this._tag != Tag.MEMBER_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_INFO, but was Tag." + this._tag.name());
        }
        return memberInfoValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            idNotFoundValue,
            memberInfoValue
        });
        hash = (31 * super.hashCode()) + hash;
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
        else if (obj instanceof MembersGetInfoItem) {
            MembersGetInfoItem other = (MembersGetInfoItem) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ID_NOT_FOUND:
                    return (this.idNotFoundValue == other.idNotFoundValue) || (this.idNotFoundValue.equals(other.idNotFoundValue));
                case MEMBER_INFO:
                    return (this.memberInfoValue == other.memberInfoValue) || (this.memberInfoValue.equals(other.memberInfoValue));
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
    static class Serializer extends UnionSerializer<MembersGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersGetInfoItem value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ID_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("id_not_found", g);
                    g.writeFieldName("id_not_found");
                    StoneSerializers.string().serialize(value.idNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                case MEMBER_INFO: {
                    g.writeStartObject();
                    writeTag("member_info", g);
                    TeamMemberInfo.Serializer.INSTANCE.serialize(value.memberInfoValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public MembersGetInfoItem deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersGetInfoItem value;
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
            else if ("id_not_found".equals(tag)) {
                String fieldValue = null;
                expectField("id_not_found", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = MembersGetInfoItem.idNotFound(fieldValue);
            }
            else if ("member_info".equals(tag)) {
                TeamMemberInfo fieldValue = null;
                fieldValue = TeamMemberInfo.Serializer.INSTANCE.deserialize(p, true);
                value = MembersGetInfoItem.memberInfo(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
