/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Argument for selecting a list of users, either by team_member_ids,
 * external_ids or emails.
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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("team_member_ids", Tag.TEAM_MEMBER_IDS);
        VALUES_.put("external_ids", Tag.EXTERNAL_IDS);
        VALUES_.put("emails", Tag.EMAILS);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UsersSelectorArg}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link UsersSelectorArg#teamMemberIds} value to assign to
     *     this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link UsersSelectorArg#externalIds} value to assign to
     *     this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#EMAILS},
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
     * @param value  {@link UsersSelectorArg#emails} value to assign to this
     *     instance.
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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UsersSelectorArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UsersSelectorArg> _JSON_WRITER = new JsonWriter<UsersSelectorArg>() {
        public final void write(UsersSelectorArg x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case TEAM_MEMBER_IDS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_member_ids");
                    g.writeFieldName("team_member_ids");
                    g.writeStartArray();
                    for (String item: x.getTeamMemberIdsValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case EXTERNAL_IDS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_ids");
                    g.writeFieldName("external_ids");
                    g.writeStartArray();
                    for (String item: x.getExternalIdsValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case EMAILS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("emails");
                    g.writeFieldName("emails");
                    g.writeStartArray();
                    for (String item: x.getEmailsValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<UsersSelectorArg> _JSON_READER = new JsonReader<UsersSelectorArg>() {

        public final UsersSelectorArg read(JsonParser parser) throws IOException, JsonReadException {
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
            UsersSelectorArg value = null;
            if (tag != null) {
                switch (tag) {
                    case TEAM_MEMBER_IDS: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "team_member_ids", v);
                        value = UsersSelectorArg.teamMemberIds(v);
                        break;
                    }
                    case EXTERNAL_IDS: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "external_ids", v);
                        value = UsersSelectorArg.externalIds(v);
                        break;
                    }
                    case EMAILS: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "emails", v);
                        value = UsersSelectorArg.emails(v);
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
