/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Argument for selecting a list of users, either by team_member_ids,
 * external_ids or emails.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class UsersSelectorArg {
    // union UsersSelectorArg

    /**
     * Discriminating tag type for {@link UsersSelectorArg}.
     */
    public enum Tag {
        /**
         * List of member IDs.
         */
        TEAM_MEMBER_IDS, // List<String>
        /**
         * List of external user IDs.
         */
        EXTERNAL_IDS, // List<String>
        /**
         * List of email addresses.
         */
        EMAILS; // List<String>
    }

    private final Tag tag;
    private final List<String> teamMemberIdsValue;
    private final List<String> externalIdsValue;
    private final List<String> emailsValue;

    /**
     * Argument for selecting a list of users, either by team_member_ids,
     * external_ids or emails.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UsersSelectorArg(Tag tag, List<String> teamMemberIdsValue, List<String> externalIdsValue, List<String> emailsValue) {
        this.tag = tag;
        this.teamMemberIdsValue = teamMemberIdsValue;
        this.externalIdsValue = externalIdsValue;
        this.emailsValue = emailsValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UsersSelectorArg}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_MEMBER_IDS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_MEMBER_IDS}, {@code false} otherwise.
     */
    public boolean isTeamMemberIds() {
        return this.tag == Tag.TEAM_MEMBER_IDS;
    }

    /**
     * Returns an instance of {@code UsersSelectorArg} that has its tag set to
     * {@link Tag#TEAM_MEMBER_IDS}.
     *
     * <p> List of member IDs. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UsersSelectorArg} with its tag set to {@link
     *     Tag#TEAM_MEMBER_IDS}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static UsersSelectorArg teamMemberIds(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new UsersSelectorArg(Tag.TEAM_MEMBER_IDS, value, null, null);
    }

    /**
     * List of member IDs.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_MEMBER_IDS}. </p>
     *
     * @return The {@link UsersSelectorArg#teamMemberIds} value associated with
     *     this instance if {@link #isTeamMemberIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamMemberIds} is {@code
     *     false}.
     */
    public List<String> getTeamMemberIdsValue() {
        if (this.tag != Tag.TEAM_MEMBER_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER_IDS, but was Tag." + tag.name());
        }
        return teamMemberIdsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EXTERNAL_IDS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EXTERNAL_IDS}, {@code false} otherwise.
     */
    public boolean isExternalIds() {
        return this.tag == Tag.EXTERNAL_IDS;
    }

    /**
     * Returns an instance of {@code UsersSelectorArg} that has its tag set to
     * {@link Tag#EXTERNAL_IDS}.
     *
     * <p> List of external user IDs. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UsersSelectorArg} with its tag set to {@link
     *     Tag#EXTERNAL_IDS}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static UsersSelectorArg externalIds(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (x.length() > 64) {
                throw new IllegalArgumentException("Stringan item in list is longer than 64");
            }
        }
        return new UsersSelectorArg(Tag.EXTERNAL_IDS, null, value, null);
    }

    /**
     * List of external user IDs.
     *
     * <p> This instance must be tagged as {@link Tag#EXTERNAL_IDS}. </p>
     *
     * @return The {@link UsersSelectorArg#externalIds} value associated with
     *     this instance if {@link #isExternalIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isExternalIds} is {@code
     *     false}.
     */
    public List<String> getExternalIdsValue() {
        if (this.tag != Tag.EXTERNAL_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.EXTERNAL_IDS, but was Tag." + tag.name());
        }
        return externalIdsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#EMAILS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#EMAILS},
     *     {@code false} otherwise.
     */
    public boolean isEmails() {
        return this.tag == Tag.EMAILS;
    }

    /**
     * Returns an instance of {@code UsersSelectorArg} that has its tag set to
     * {@link Tag#EMAILS}.
     *
     * <p> List of email addresses. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UsersSelectorArg} with its tag set to {@link
     *     Tag#EMAILS}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static UsersSelectorArg emails(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
            if (x.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", x)) {
                throw new IllegalArgumentException("Stringan item in list does not match pattern");
            }
        }
        return new UsersSelectorArg(Tag.EMAILS, null, null, value);
    }

    /**
     * List of email addresses.
     *
     * <p> This instance must be tagged as {@link Tag#EMAILS}. </p>
     *
     * @return The {@link UsersSelectorArg#emails} value associated with this
     *     instance if {@link #isEmails} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEmails} is {@code false}.
     */
    public List<String> getEmailsValue() {
        if (this.tag != Tag.EMAILS) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAILS, but was Tag." + tag.name());
        }
        return emailsValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            teamMemberIdsValue,
            externalIdsValue,
            emailsValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UsersSelectorArg) {
            UsersSelectorArg other = (UsersSelectorArg) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case TEAM_MEMBER_IDS:
                    return (this.teamMemberIdsValue == other.teamMemberIdsValue) || (this.teamMemberIdsValue.equals(other.teamMemberIdsValue));
                case EXTERNAL_IDS:
                    return (this.externalIdsValue == other.externalIdsValue) || (this.externalIdsValue.equals(other.externalIdsValue));
                case EMAILS:
                    return (this.emailsValue == other.emailsValue) || (this.emailsValue.equals(other.emailsValue));
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
    static final class Serializer extends UnionSerializer<UsersSelectorArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UsersSelectorArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case TEAM_MEMBER_IDS: {
                    g.writeStartObject();
                    writeTag("team_member_ids", g);
                    g.writeFieldName("team_member_ids");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.teamMemberIdsValue, g);
                    g.writeEndObject();
                    break;
                }
                case EXTERNAL_IDS: {
                    g.writeStartObject();
                    writeTag("external_ids", g);
                    g.writeFieldName("external_ids");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.externalIdsValue, g);
                    g.writeEndObject();
                    break;
                }
                case EMAILS: {
                    g.writeStartObject();
                    writeTag("emails", g);
                    g.writeFieldName("emails");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.emailsValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UsersSelectorArg deserialize(JsonParser p) throws IOException, JsonParseException {
            UsersSelectorArg value;
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
            else if ("team_member_ids".equals(tag)) {
                List<String> fieldValue = null;
                expectField("team_member_ids", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = UsersSelectorArg.teamMemberIds(fieldValue);
            }
            else if ("external_ids".equals(tag)) {
                List<String> fieldValue = null;
                expectField("external_ids", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = UsersSelectorArg.externalIds(fieldValue);
            }
            else if ("emails".equals(tag)) {
                List<String> fieldValue = null;
                expectField("emails", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = UsersSelectorArg.emails(fieldValue);
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
