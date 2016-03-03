/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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
 * Describes a result obtained for a single user whose id was specified in the
 * parameter of {@link DbxTeamTeamRequests#membersGetInfo(java.util.List)}.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=MembersGetInfoItem.Serializer.class)
@JsonDeserialize(using=MembersGetInfoItem.Deserializer.class)
public final class MembersGetInfoItem {
    // union MembersGetInfoItem

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends UnionJsonSerializer<MembersGetInfoItem> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersGetInfoItem.class, TeamMemberInfo.class);
        }

        @Override
        public void serialize(MembersGetInfoItem value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ID_NOT_FOUND:
                    g.writeStartObject();
                    g.writeStringField(".tag", "id_not_found");
                    g.writeObjectField("id_not_found", value.idNotFoundValue);
                    g.writeEndObject();
                    break;
                case MEMBER_INFO:
                    g.writeStartObject();
                    g.writeStringField(".tag", "member_info");
                    getUnwrappingSerializer(TeamMemberInfo.class).serialize(value.memberInfoValue, g, provider);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MembersGetInfoItem, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersGetInfoItem.class, getTagMapping(), null, TeamMemberInfo.class);
        }

        @Override
        public MembersGetInfoItem deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ID_NOT_FOUND: {
                    String value = null;
                    expectField(_p, "id_not_found");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return MembersGetInfoItem.idNotFound(value);
                }
                case MEMBER_INFO: {
                    TeamMemberInfo value = null;
                    value = readCollapsedStructValue(TeamMemberInfo.class, _p, _ctx);
                    return MembersGetInfoItem.memberInfo(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, MembersGetInfoItem.Tag> getTagMapping() {
            Map<String, MembersGetInfoItem.Tag> values = new HashMap<String, MembersGetInfoItem.Tag>();
            values.put("id_not_found", MembersGetInfoItem.Tag.ID_NOT_FOUND);
            values.put("member_info", MembersGetInfoItem.Tag.MEMBER_INFO);
            return Collections.unmodifiableMap(values);
        }
    }
}
