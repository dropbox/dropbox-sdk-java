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
 * parameter of {@link DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class MembersGetInfoItemV2 {
    // union team.MembersGetInfoItemV2 (team_members.stone)

    /**
     * Discriminating tag type for {@link MembersGetInfoItemV2}.
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
        MEMBER_INFO, // TeamMemberInfoV2
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final MembersGetInfoItemV2 OTHER = new MembersGetInfoItemV2().withTag(Tag.OTHER);

    private Tag _tag;
    private String idNotFoundValue;
    private TeamMemberInfoV2 memberInfoValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MembersGetInfoItemV2() {
    }


    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MembersGetInfoItemV2 withTag(Tag _tag) {
        MembersGetInfoItemV2 result = new MembersGetInfoItemV2();
        result._tag = _tag;
        return result;
    }

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}.
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
    private MembersGetInfoItemV2 withTagAndIdNotFound(Tag _tag, String idNotFoundValue) {
        MembersGetInfoItemV2 result = new MembersGetInfoItemV2();
        result._tag = _tag;
        result.idNotFoundValue = idNotFoundValue;
        return result;
    }

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}.
     *
     * @param memberInfoValue  Info about a team member. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MembersGetInfoItemV2 withTagAndMemberInfo(Tag _tag, TeamMemberInfoV2 memberInfoValue) {
        MembersGetInfoItemV2 result = new MembersGetInfoItemV2();
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
     * values for this {@code MembersGetInfoItemV2}. </p>
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
     * Tag#ID_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ID_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code MembersGetInfoItemV2} that has its tag set
     * to {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)} or {@link
     * DbxTeamTeamRequests#membersGetInfoV2(java.util.List)}, and did not match
     * a corresponding user. This might be a team_member_id, an email, or an
     * external ID, depending on how the method was called. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersGetInfoItemV2} with its tag set to
     *     {@link Tag#ID_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersGetInfoItemV2 idNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItemV2().withTagAndIdNotFound(Tag.ID_NOT_FOUND, value);
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
     * Returns an instance of {@code MembersGetInfoItemV2} that has its tag set
     * to {@link Tag#MEMBER_INFO}.
     *
     * <p> Info about a team member. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MembersGetInfoItemV2} with its tag set to
     *     {@link Tag#MEMBER_INFO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MembersGetInfoItemV2 memberInfo(TeamMemberInfoV2 value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MembersGetInfoItemV2().withTagAndMemberInfo(Tag.MEMBER_INFO, value);
    }

    /**
     * Info about a team member.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBER_INFO}. </p>
     *
     * @return The {@link TeamMemberInfoV2} value associated with this instance
     *     if {@link #isMemberInfo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMemberInfo} is {@code false}.
     */
    public TeamMemberInfoV2 getMemberInfoValue() {
        if (this._tag != Tag.MEMBER_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_INFO, but was Tag." + this._tag.name());
        }
        return memberInfoValue;
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
        else if (obj instanceof MembersGetInfoItemV2) {
            MembersGetInfoItemV2 other = (MembersGetInfoItemV2) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ID_NOT_FOUND:
                    return (this.idNotFoundValue == other.idNotFoundValue) || (this.idNotFoundValue.equals(other.idNotFoundValue));
                case MEMBER_INFO:
                    return (this.memberInfoValue == other.memberInfoValue) || (this.memberInfoValue.equals(other.memberInfoValue));
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
    static class Serializer extends UnionSerializer<MembersGetInfoItemV2> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersGetInfoItemV2 value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                    TeamMemberInfoV2.Serializer.INSTANCE.serialize(value.memberInfoValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersGetInfoItemV2 deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersGetInfoItemV2 value;
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
                value = MembersGetInfoItemV2.idNotFound(fieldValue);
            }
            else if ("member_info".equals(tag)) {
                TeamMemberInfoV2 fieldValue = null;
                fieldValue = TeamMemberInfoV2.Serializer.INSTANCE.deserialize(p, true);
                value = MembersGetInfoItemV2.memberInfo(fieldValue);
            }
            else {
                value = MembersGetInfoItemV2.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
