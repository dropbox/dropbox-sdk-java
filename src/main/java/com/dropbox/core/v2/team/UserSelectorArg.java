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
import java.util.Map;

/**
 * Argument for selecting a single user, either by team_member_id, external_id
 * or email.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=UserSelectorArg.Serializer.class)
@JsonDeserialize(using=UserSelectorArg.Deserializer.class)
public final class UserSelectorArg {
    // union UserSelectorArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link UserSelectorArg}.
     */
    public enum Tag {
        TEAM_MEMBER_ID, // String
        EXTERNAL_ID, // String
        EMAIL; // String
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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UserSelectorArg}. </p>
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
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_MEMBER_ID}, {@code false} otherwise.
     */
    public boolean isTeamMemberId() {
        return this.tag == Tag.TEAM_MEMBER_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#TEAM_MEMBER_ID}.
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
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#EXTERNAL_ID}, {@code false} otherwise.
     */
    public boolean isExternalId() {
        return this.tag == Tag.EXTERNAL_ID;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EXTERNAL_ID}.
     *
     * @param value  value to assign to this instance.
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
     * @return {@code true} if this instance is tagged as {@link Tag#EMAIL},
     *     {@code false} otherwise.
     */
    public boolean isEmail() {
        return this.tag == Tag.EMAIL;
    }

    /**
     * Returns an instance of {@code UserSelectorArg} that has its tag set to
     * {@link Tag#EMAIL}.
     *
     * @param value  value to assign to this instance.
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

    static final class Serializer extends UnionJsonSerializer<UserSelectorArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UserSelectorArg.class);
        }

        @Override
        public void serialize(UserSelectorArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case TEAM_MEMBER_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "team_member_id");
                    g.writeObjectField("team_member_id", value.teamMemberIdValue);
                    g.writeEndObject();
                    break;
                case EXTERNAL_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "external_id");
                    g.writeObjectField("external_id", value.externalIdValue);
                    g.writeEndObject();
                    break;
                case EMAIL:
                    g.writeStartObject();
                    g.writeStringField(".tag", "email");
                    g.writeObjectField("email", value.emailValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UserSelectorArg, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UserSelectorArg.class, getTagMapping(), null);
        }

        @Override
        public UserSelectorArg deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case TEAM_MEMBER_ID: {
                    String value = null;
                    expectField(_p, "team_member_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return UserSelectorArg.teamMemberId(value);
                }
                case EXTERNAL_ID: {
                    String value = null;
                    expectField(_p, "external_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return UserSelectorArg.externalId(value);
                }
                case EMAIL: {
                    String value = null;
                    expectField(_p, "email");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return UserSelectorArg.email(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, UserSelectorArg.Tag> getTagMapping() {
            Map<String, UserSelectorArg.Tag> values = new HashMap<String, UserSelectorArg.Tag>();
            values.put("team_member_id", UserSelectorArg.Tag.TEAM_MEMBER_ID);
            values.put("external_id", UserSelectorArg.Tag.EXTERNAL_ID);
            values.put("email", UserSelectorArg.Tag.EMAIL);
            return Collections.unmodifiableMap(values);
        }
    }
}
