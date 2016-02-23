/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Argument for selecting a single user, either by team_member_id, external_id
 * or email.
 */
public final class UserSelectorArg {
    // union UserSelectorArg

    /**
     * Discriminating tag type for {@link UserSelectorArg}.
     */
    public enum Tag {
        TEAM_MEMBER_ID, // String
        EXTERNAL_ID, // String
        EMAIL; // String
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("team_member_id", Tag.TEAM_MEMBER_ID);
        VALUES_.put("external_id", Tag.EXTERNAL_ID);
        VALUES_.put("email", Tag.EMAIL);
    }

    private final Tag tag;
    private final String teamMemberIdValue;
    private final String externalIdValue;
    private final String emailValue;

    /**
     * Argument for selecting a single user, either by team_member_id,
     * external_id or email.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UserSelectorArg(Tag tag, String teamMemberIdValue, String externalIdValue, String emailValue) {
        this.tag = tag;
        this.teamMemberIdValue = teamMemberIdValue;
        this.externalIdValue = externalIdValue;
        this.emailValue = emailValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code UserSelectorArg}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_MEMBER_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TEAM_MEMBER_ID}, {@code false} otherwise.
     */
    public boolean isTeamMemberId() {
        return this.tag == Tag.TEAM_MEMBER_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#TEAM_MEMBER_ID}.
     *
     * @param value  {@link UserSelectorArg#teamMemberId} value to assign to
     *     this instance.
     *
     * @return Instance of {@code UserSelectorArg} with its tag set to {@link
     *     Tag#TEAM_MEMBER_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserSelectorArg teamMemberId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserSelectorArg(Tag.TEAM_MEMBER_ID, value, null, null);
    }

    /**
     * This instance must be tagged as {@link Tag#TEAM_MEMBER_ID}.
     *
     * @return The {@link UserSelectorArg#teamMemberId} value associated with
     *     this instance if {@link #isTeamMemberId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamMemberId} is {@code
     *     false}.
     */
    public String getTeamMemberIdValue() {
        if (this.tag != Tag.TEAM_MEMBER_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER_ID, but was Tag." + tag.name());
        }
        return teamMemberIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EXTERNAL_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#EXTERNAL_ID}, {@code false} otherwise.
     */
    public boolean isExternalId() {
        return this.tag == Tag.EXTERNAL_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EXTERNAL_ID}.
     *
     * @param value  {@link UserSelectorArg#externalId} value to assign to this
     *     instance.
     *
     * @return Instance of {@code UserSelectorArg} with its tag set to {@link
     *     Tag#EXTERNAL_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserSelectorArg externalId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserSelectorArg(Tag.EXTERNAL_ID, null, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#EXTERNAL_ID}.
     *
     * @return The {@link UserSelectorArg#externalId} value associated with this
     *     instance if {@link #isExternalId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isExternalId} is {@code false}.
     */
    public String getExternalIdValue() {
        if (this.tag != Tag.EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.EXTERNAL_ID, but was Tag." + tag.name());
        }
        return externalIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#EMAIL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#EMAIL},
     *     {@code false} otherwise.
     */
    public boolean isEmail() {
        return this.tag == Tag.EMAIL;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EMAIL}.
     *
     * @param value  {@link UserSelectorArg#email} value to assign to this
     *     instance.
     *
     * @return Instance of {@code UserSelectorArg} with its tag set to {@link
     *     Tag#EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UserSelectorArg email(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserSelectorArg(Tag.EMAIL, null, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#EMAIL}.
     *
     * @return The {@link UserSelectorArg#email} value associated with this
     *     instance if {@link #isEmail} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEmail} is {@code false}.
     */
    public String getEmailValue() {
        if (this.tag != Tag.EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAIL, but was Tag." + tag.name());
        }
        return emailValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            teamMemberIdValue,
            externalIdValue,
            emailValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UserSelectorArg) {
            UserSelectorArg other = (UserSelectorArg) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case TEAM_MEMBER_ID:
                    return (this.teamMemberIdValue == other.teamMemberIdValue) || (this.teamMemberIdValue.equals(other.teamMemberIdValue));
                case EXTERNAL_ID:
                    return (this.externalIdValue == other.externalIdValue) || (this.externalIdValue.equals(other.externalIdValue));
                case EMAIL:
                    return (this.emailValue == other.emailValue) || (this.emailValue.equals(other.emailValue));
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

    public static UserSelectorArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UserSelectorArg> _JSON_WRITER = new JsonWriter<UserSelectorArg>() {
        public final void write(UserSelectorArg x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case TEAM_MEMBER_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_member_id");
                    g.writeFieldName("team_member_id");
                    g.writeString(x.getTeamMemberIdValue());
                    g.writeEndObject();
                    break;
                case EXTERNAL_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_id");
                    g.writeFieldName("external_id");
                    g.writeString(x.getExternalIdValue());
                    g.writeEndObject();
                    break;
                case EMAIL:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email");
                    g.writeFieldName("email");
                    g.writeString(x.getEmailValue());
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<UserSelectorArg> _JSON_READER = new JsonReader<UserSelectorArg>() {

        public final UserSelectorArg read(JsonParser parser) throws IOException, JsonReadException {
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
            UserSelectorArg value = null;
            if (tag != null) {
                switch (tag) {
                    case TEAM_MEMBER_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "team_member_id", v);
                        value = UserSelectorArg.teamMemberId(v);
                        break;
                    }
                    case EXTERNAL_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "external_id", v);
                        value = UserSelectorArg.externalId(v);
                        break;
                    }
                    case EMAIL: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "email", v);
                        value = UserSelectorArg.email(v);
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
