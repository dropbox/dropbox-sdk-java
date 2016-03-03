/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=GroupsGetInfoItem.Serializer.class)
@JsonDeserialize(using=GroupsGetInfoItem.Deserializer.class)
public final class GroupsGetInfoItem {
    // union GroupsGetInfoItem

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link GroupsGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeamTeamRequests#groupsGetInfo(GroupsSelector)}, and did not match
         * a corresponding group. The ID can be a group ID, or an external ID,
         * depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a group.
         */
        GROUP_INFO; // GroupFullInfo
    }

    private final Tag tag;
    private final String idNotFoundValue;
    private final GroupFullInfo groupInfoValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GroupsGetInfoItem(Tag tag, String idNotFoundValue, GroupFullInfo groupInfoValue) {
        this.tag = tag;
        this.idNotFoundValue = idNotFoundValue;
        this.groupInfoValue = groupInfoValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GroupsGetInfoItem}. </p>
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
     * Returns an instance of {@code GroupsGetInfoItem} that has its tag set to
     * {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#groupsGetInfo(GroupsSelector)}, and did not match a
     * corresponding group. The ID can be a group ID, or an external ID,
     * depending on how the method was called. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupsGetInfoItem} with its tag set to {@link
     *     Tag#ID_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GroupsGetInfoItem idNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupsGetInfoItem(Tag.ID_NOT_FOUND, value, null);
    }

    /**
     * An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#groupsGetInfo(GroupsSelector)}, and did not match a
     * corresponding group. The ID can be a group ID, or an external ID,
     * depending on how the method was called.
     *
     * <p> This instance must be tagged as {@link Tag#ID_NOT_FOUND}. </p>
     *
     * @return The {@link GroupsGetInfoItem#idNotFound} value associated with
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
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP_INFO},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_INFO}, {@code false} otherwise.
     */
    public boolean isGroupInfo() {
        return this.tag == Tag.GROUP_INFO;
    }

    /**
     * Returns an instance of {@code GroupsGetInfoItem} that has its tag set to
     * {@link Tag#GROUP_INFO}.
     *
     * <p> Info about a group. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupsGetInfoItem} with its tag set to {@link
     *     Tag#GROUP_INFO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GroupsGetInfoItem groupInfo(GroupFullInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupsGetInfoItem(Tag.GROUP_INFO, null, value);
    }

    /**
     * Info about a group.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_INFO}. </p>
     *
     * @return The {@link GroupsGetInfoItem#groupInfo} value associated with
     *     this instance if {@link #isGroupInfo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupInfo} is {@code false}.
     */
    public GroupFullInfo getGroupInfoValue() {
        if (this.tag != Tag.GROUP_INFO) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_INFO, but was Tag." + tag.name());
        }
        return groupInfoValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            idNotFoundValue,
            groupInfoValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GroupsGetInfoItem) {
            GroupsGetInfoItem other = (GroupsGetInfoItem) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ID_NOT_FOUND:
                    return (this.idNotFoundValue == other.idNotFoundValue) || (this.idNotFoundValue.equals(other.idNotFoundValue));
                case GROUP_INFO:
                    return (this.groupInfoValue == other.groupInfoValue) || (this.groupInfoValue.equals(other.groupInfoValue));
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

    static final class Serializer extends UnionJsonSerializer<GroupsGetInfoItem> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsGetInfoItem.class, GroupFullInfo.class);
        }

        @Override
        public void serialize(GroupsGetInfoItem value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ID_NOT_FOUND:
                    g.writeStartObject();
                    g.writeStringField(".tag", "id_not_found");
                    g.writeObjectField("id_not_found", value.idNotFoundValue);
                    g.writeEndObject();
                    break;
                case GROUP_INFO:
                    g.writeStartObject();
                    g.writeStringField(".tag", "group_info");
                    getUnwrappingSerializer(GroupFullInfo.class).serialize(value.groupInfoValue, g, provider);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupsGetInfoItem, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsGetInfoItem.class, getTagMapping(), null, GroupFullInfo.class);
        }

        @Override
        public GroupsGetInfoItem deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ID_NOT_FOUND: {
                    String value = null;
                    expectField(_p, "id_not_found");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return GroupsGetInfoItem.idNotFound(value);
                }
                case GROUP_INFO: {
                    GroupFullInfo value = null;
                    value = readCollapsedStructValue(GroupFullInfo.class, _p, _ctx);
                    return GroupsGetInfoItem.groupInfo(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, GroupsGetInfoItem.Tag> getTagMapping() {
            Map<String, GroupsGetInfoItem.Tag> values = new HashMap<String, GroupsGetInfoItem.Tag>();
            values.put("id_not_found", GroupsGetInfoItem.Tag.ID_NOT_FOUND);
            values.put("group_info", GroupsGetInfoItem.Tag.GROUP_INFO);
            return Collections.unmodifiableMap(values);
        }
    }
}
