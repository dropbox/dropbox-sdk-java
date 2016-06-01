/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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
    // union MembersGetInfoItem

    /**
     * Discriminating tag type for {@link MembersGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeamTeamRequests#membersGetInfo(java.util.List)}, and did not
         * match a corresponding user. This might be a team_member_id, an email,
         * or an external ID, depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a team member.
         */
        MEMBER_INFO; // TeamMemberInfo
    }

    private final Tag tag;
    private final String idNotFoundValue;
    private final TeamMemberInfo memberInfoValue;

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MembersGetInfoItem(Tag tag, String idNotFoundValue, TeamMemberInfo memberInfoValue) {
        this.tag = tag;
        this.idNotFoundValue = idNotFoundValue;
        this.memberInfoValue = memberInfoValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ID_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ID_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isIdNotFound() {
        return this.tag == Tag.ID_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code MembersGetInfoItem} that has its tag set to
     * {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}, and did not match a
     * corresponding user. This might be a team_member_id, an email, or an
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
        return new MembersGetInfoItem(Tag.ID_NOT_FOUND, value, null);
    }

    /**
     * An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#membersGetInfo(java.util.List)}, and did not match a
     * corresponding user. This might be a team_member_id, an email, or an
     * external ID, depending on how the method was called.
     *
     * <p> This instance must be tagged as {@link Tag#ID_NOT_FOUND}. </p>
     *
     * @return The {@link MembersGetInfoItem#idNotFound} value associated with
     *     this instance if {@link #isIdNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIdNotFound} is {@code false}.
     */
    public String getIdNotFoundValue() {
        if (this.tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + tag.name());
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
        return this.tag == Tag.MEMBER_INFO;
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
        return new MembersGetInfoItem(Tag.MEMBER_INFO, null, value);
    }

    /**
     * Info about a team member.
     *
     * <p> This instance must be tagged as {@link Tag#MEMBER_INFO}. </p>
     *
     * @return The {@link MembersGetInfoItem#memberInfo} value associated with
     *     this instance if {@link #isMemberInfo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMemberInfo} is {@code false}.
     */
    public TeamMemberInfo getMemberInfoValue() {
        if (this.tag != Tag.MEMBER_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.MEMBER_INFO, but was Tag." + tag.name());
        }
        return memberInfoValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            idNotFoundValue,
            memberInfoValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MembersGetInfoItem) {
            MembersGetInfoItem other = (MembersGetInfoItem) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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
    static final class Serializer extends UnionSerializer<MembersGetInfoItem> {
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
                expectEndObject(p);
            }
            return value;
        }
    }
}
