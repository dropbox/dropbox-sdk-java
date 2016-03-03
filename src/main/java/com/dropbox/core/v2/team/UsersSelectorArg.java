/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

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
import java.util.List;
import java.util.Map;

/**
 * Argument for selecting a list of users, either by team_member_ids,
 * external_ids or emails.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=UsersSelectorArg.Serializer.class)
@JsonDeserialize(using=UsersSelectorArg.Deserializer.class)
public final class UsersSelectorArg {
    // union UsersSelectorArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends UnionJsonSerializer<UsersSelectorArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UsersSelectorArg.class);
        }

        @Override
        public void serialize(UsersSelectorArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case TEAM_MEMBER_IDS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "team_member_ids");
                    g.writeObjectField("team_member_ids", value.teamMemberIdsValue);
                    g.writeEndObject();
                    break;
                case EXTERNAL_IDS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "external_ids");
                    g.writeObjectField("external_ids", value.externalIdsValue);
                    g.writeEndObject();
                    break;
                case EMAILS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "emails");
                    g.writeObjectField("emails", value.emailsValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UsersSelectorArg, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UsersSelectorArg.class, getTagMapping(), null);
        }

        @Override
        public UsersSelectorArg deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case TEAM_MEMBER_IDS: {
                    List<String> value = null;
                    expectField(_p, "team_member_ids");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return UsersSelectorArg.teamMemberIds(value);
                }
                case EXTERNAL_IDS: {
                    List<String> value = null;
                    expectField(_p, "external_ids");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return UsersSelectorArg.externalIds(value);
                }
                case EMAILS: {
                    List<String> value = null;
                    expectField(_p, "emails");
                    expectArrayStart(_p);
                    value = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        value.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                    return UsersSelectorArg.emails(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, UsersSelectorArg.Tag> getTagMapping() {
            Map<String, UsersSelectorArg.Tag> values = new HashMap<String, UsersSelectorArg.Tag>();
            values.put("team_member_ids", UsersSelectorArg.Tag.TEAM_MEMBER_IDS);
            values.put("external_ids", UsersSelectorArg.Tag.EXTERNAL_IDS);
            values.put("emails", UsersSelectorArg.Tag.EMAILS);
            return Collections.unmodifiableMap(values);
        }
    }
}
