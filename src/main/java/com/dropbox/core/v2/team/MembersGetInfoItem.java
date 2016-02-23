/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Describes a result obtained for a single user whose id was specified in the
 * parameter of {@link DbxTeam#membersGetInfo(java.util.List)}.
 */
public final class MembersGetInfoItem {
    // union MembersGetInfoItem

    /**
     * Discriminating tag type for {@link MembersGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeam#membersGetInfo(java.util.List)}, and did not match a
         * corresponding user. This might be a team_member_id, an email, or an
         * external ID, depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a team member.
         */
        MEMBER_INFO; // TeamMemberInfo
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("id_not_found", Tag.ID_NOT_FOUND);
        VALUES_.put("member_info", Tag.MEMBER_INFO);
    }

    private final Tag tag;
    private final String idNotFoundValue;
    private final TeamMemberInfo memberInfoValue;

    /**
     * Describes a result obtained for a single user whose id was specified in
     * the parameter of {@link DbxTeam#membersGetInfo(java.util.List)}.
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code MembersGetInfoItem}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * DbxTeam#membersGetInfo(java.util.List)}, and did not match a
     * corresponding user. This might be a team_member_id, an email, or an
     * external ID, depending on how the method was called. </p>
     *
     * @param value  {@link MembersGetInfoItem#idNotFound} value to assign to
     *     this instance.
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
     * DbxTeam#membersGetInfo(java.util.List)}, and did not match a
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link MembersGetInfoItem#memberInfo} value to assign to
     *     this instance.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersGetInfoItem fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersGetInfoItem> _JSON_WRITER = new JsonWriter<MembersGetInfoItem>() {
        public final void write(MembersGetInfoItem x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ID_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("id_not_found");
                    g.writeFieldName("id_not_found");
                    g.writeString(x.getIdNotFoundValue());
                    g.writeEndObject();
                    break;
                case MEMBER_INFO:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member_info");
                    g.writeFieldName("member_info");
                    TeamMemberInfo._JSON_WRITER.write(x.getMemberInfoValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersGetInfoItem> _JSON_READER = new JsonReader<MembersGetInfoItem>() {

        public final MembersGetInfoItem read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            MembersGetInfoItem value = null;
            if (tag != null) {
                switch (tag) {
                    case ID_NOT_FOUND: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "id_not_found", v);
                        value = MembersGetInfoItem.idNotFound(v);
                        break;
                    }
                    case MEMBER_INFO: {
                        TeamMemberInfo v = null;
                        v = TeamMemberInfo._JSON_READER.readFields(parser);
                        value = MembersGetInfoItem.memberInfo(v);
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
