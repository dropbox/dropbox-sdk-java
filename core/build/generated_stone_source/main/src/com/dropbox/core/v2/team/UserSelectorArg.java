/* DO NOT EDIT */
/* This file was generated from team.stone */

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
import java.util.regex.Pattern;

/**
 * Argument for selecting a single user, either by team_member_id, external_id
 * or email.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class UserSelectorArg {
    // union team.UserSelectorArg (team.stone)

    /**
     * Discriminating tag type for {@link UserSelectorArg}.
     */
    public enum Tag {
        TEAM_MEMBER_ID, // String
        EXTERNAL_ID, // String
        EMAIL; // String
    }

    private Tag _tag;
    private String teamMemberIdValue;
    private String externalIdValue;
    private String emailValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UserSelectorArg() {
    }


    /**
     * Argument for selecting a single user, either by team_member_id,
     * external_id or email.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UserSelectorArg withTag(Tag _tag) {
        UserSelectorArg result = new UserSelectorArg();
        result._tag = _tag;
        return result;
    }

    /**
     * Argument for selecting a single user, either by team_member_id,
     * external_id or email.
     *
     * @param teamMemberIdValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserSelectorArg withTagAndTeamMemberId(Tag _tag, String teamMemberIdValue) {
        UserSelectorArg result = new UserSelectorArg();
        result._tag = _tag;
        result.teamMemberIdValue = teamMemberIdValue;
        return result;
    }

    /**
     * Argument for selecting a single user, either by team_member_id,
     * external_id or email.
     *
     * @param externalIdValue  Must have length of at most 64 and not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserSelectorArg withTagAndExternalId(Tag _tag, String externalIdValue) {
        UserSelectorArg result = new UserSelectorArg();
        result._tag = _tag;
        result.externalIdValue = externalIdValue;
        return result;
    }

    /**
     * Argument for selecting a single user, either by team_member_id,
     * external_id or email.
     *
     * @param emailValue  Must have length of at most 255, match pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UserSelectorArg withTagAndEmail(Tag _tag, String emailValue) {
        UserSelectorArg result = new UserSelectorArg();
        result._tag = _tag;
        result.emailValue = emailValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UserSelectorArg}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_MEMBER_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_MEMBER_ID}, {@code false} otherwise.
     */
    public boolean isTeamMemberId() {
        return this._tag == Tag.TEAM_MEMBER_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#TEAM_MEMBER_ID}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
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
        return new UserSelectorArg().withTagAndTeamMemberId(Tag.TEAM_MEMBER_ID, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TEAM_MEMBER_ID}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isTeamMemberId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamMemberId} is {@code
     *     false}.
     */
    public String getTeamMemberIdValue() {
        if (this._tag != Tag.TEAM_MEMBER_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER_ID, but was Tag." + this._tag.name());
        }
        return teamMemberIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#EXTERNAL_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EXTERNAL_ID}, {@code false} otherwise.
     */
    public boolean isExternalId() {
        return this._tag == Tag.EXTERNAL_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EXTERNAL_ID}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserSelectorArg} with its tag set to {@link
     *     Tag#EXTERNAL_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 64 or
     *     is {@code null}.
     */
    public static UserSelectorArg externalId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 64) {
            throw new IllegalArgumentException("String is longer than 64");
        }
        return new UserSelectorArg().withTagAndExternalId(Tag.EXTERNAL_ID, value);
    }

    /**
     * This instance must be tagged as {@link Tag#EXTERNAL_ID}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isExternalId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isExternalId} is {@code false}.
     */
    public String getExternalIdValue() {
        if (this._tag != Tag.EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.EXTERNAL_ID, but was Tag." + this._tag.name());
        }
        return externalIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#EMAIL},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#EMAIL},
     *     {@code false} otherwise.
     */
    public boolean isEmail() {
        return this._tag == Tag.EMAIL;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EMAIL}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UserSelectorArg} with its tag set to {@link
     *     Tag#EMAIL}.
     *
     * @throws IllegalArgumentException  if {@code value} is longer than 255,
     *     does not match pattern "{@code
     *     ^['#&amp;A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     or is {@code null}.
     */
    public static UserSelectorArg email(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new UserSelectorArg().withTagAndEmail(Tag.EMAIL, value);
    }

    /**
     * This instance must be tagged as {@link Tag#EMAIL}.
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isEmail} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEmail} is {@code false}.
     */
    public String getEmailValue() {
        if (this._tag != Tag.EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAIL, but was Tag." + this._tag.name());
        }
        return emailValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.teamMemberIdValue,
            this.externalIdValue,
            this.emailValue
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
        else if (obj instanceof UserSelectorArg) {
            UserSelectorArg other = (UserSelectorArg) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    static class Serializer extends UnionSerializer<UserSelectorArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserSelectorArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case TEAM_MEMBER_ID: {
                    g.writeStartObject();
                    writeTag("team_member_id", g);
                    g.writeFieldName("team_member_id");
                    StoneSerializers.string().serialize(value.teamMemberIdValue, g);
                    g.writeEndObject();
                    break;
                }
                case EXTERNAL_ID: {
                    g.writeStartObject();
                    writeTag("external_id", g);
                    g.writeFieldName("external_id");
                    StoneSerializers.string().serialize(value.externalIdValue, g);
                    g.writeEndObject();
                    break;
                }
                case EMAIL: {
                    g.writeStartObject();
                    writeTag("email", g);
                    g.writeFieldName("email");
                    StoneSerializers.string().serialize(value.emailValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UserSelectorArg deserialize(JsonParser p) throws IOException, JsonParseException {
            UserSelectorArg value;
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
            else if ("team_member_id".equals(tag)) {
                String fieldValue = null;
                expectField("team_member_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = UserSelectorArg.teamMemberId(fieldValue);
            }
            else if ("external_id".equals(tag)) {
                String fieldValue = null;
                expectField("external_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = UserSelectorArg.externalId(fieldValue);
            }
            else if ("email".equals(tag)) {
                String fieldValue = null;
                expectField("email", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = UserSelectorArg.email(fieldValue);
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
