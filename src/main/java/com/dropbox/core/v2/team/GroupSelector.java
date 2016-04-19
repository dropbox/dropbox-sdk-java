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
 * Argument for selecting a single group, either by group_id or by external
 * group ID.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=GroupSelector.Serializer.class)
@JsonDeserialize(using=GroupSelector.Deserializer.class)
public final class GroupSelector {
    // union GroupSelector

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link GroupSelector}.
     */
    public enum Tag {
        /**
         * Group ID.
         */
        GROUP_ID, // String
        /**
         * External ID of the group.
         */
        GROUP_EXTERNAL_ID; // String
    }

    private final Tag tag;
    private final String groupIdValue;
    private final String groupExternalIdValue;

    /**
     * Argument for selecting a single group, either by group_id or by external
     * group ID.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GroupSelector(Tag tag, String groupIdValue, String groupExternalIdValue) {
        this.tag = tag;
        this.groupIdValue = groupIdValue;
        this.groupExternalIdValue = groupExternalIdValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GroupSelector}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP_ID},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#GROUP_ID},
     *     {@code false} otherwise.
     */
    public boolean isGroupId() {
        return this.tag == Tag.GROUP_ID;
    }

    /**
     * Returns an instance of {@code GroupSelector} that has its tag set to
     * {@link Tag#GROUP_ID}.
     *
     * <p> Group ID. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupSelector} with its tag set to {@link
     *     Tag#GROUP_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GroupSelector groupId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupSelector(Tag.GROUP_ID, value, null);
    }

    /**
     * Group ID.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_ID}. </p>
     *
     * @return The {@link GroupSelector#groupId} value associated with this
     *     instance if {@link #isGroupId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupId} is {@code false}.
     */
    public String getGroupIdValue() {
        if (this.tag != Tag.GROUP_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_ID, but was Tag." + tag.name());
        }
        return groupIdValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_EXTERNAL_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_EXTERNAL_ID}, {@code false} otherwise.
     */
    public boolean isGroupExternalId() {
        return this.tag == Tag.GROUP_EXTERNAL_ID;
    }

    /**
     * Returns an instance of {@code GroupSelector} that has its tag set to
     * {@link Tag#GROUP_EXTERNAL_ID}.
     *
     * <p> External ID of the group. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupSelector} with its tag set to {@link
     *     Tag#GROUP_EXTERNAL_ID}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GroupSelector groupExternalId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GroupSelector(Tag.GROUP_EXTERNAL_ID, null, value);
    }

    /**
     * External ID of the group.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_EXTERNAL_ID}. </p>
     *
     * @return The {@link GroupSelector#groupExternalId} value associated with
     *     this instance if {@link #isGroupExternalId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupExternalId} is {@code
     *     false}.
     */
    public String getGroupExternalIdValue() {
        if (this.tag != Tag.GROUP_EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_ID, but was Tag." + tag.name());
        }
        return groupExternalIdValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            groupIdValue,
            groupExternalIdValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GroupSelector) {
            GroupSelector other = (GroupSelector) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case GROUP_ID:
                    return (this.groupIdValue == other.groupIdValue) || (this.groupIdValue.equals(other.groupIdValue));
                case GROUP_EXTERNAL_ID:
                    return (this.groupExternalIdValue == other.groupExternalIdValue) || (this.groupExternalIdValue.equals(other.groupExternalIdValue));
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

    static final class Serializer extends UnionJsonSerializer<GroupSelector> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupSelector.class);
        }

        @Override
        public void serialize(GroupSelector value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case GROUP_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "group_id");
                    g.writeObjectField("group_id", value.groupIdValue);
                    g.writeEndObject();
                    break;
                case GROUP_EXTERNAL_ID:
                    g.writeStartObject();
                    g.writeStringField(".tag", "group_external_id");
                    g.writeObjectField("group_external_id", value.groupExternalIdValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupSelector, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupSelector.class, getTagMapping(), null);
        }

        @Override
        public GroupSelector deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case GROUP_ID: {
                    String value = null;
                    expectField(_p, "group_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return GroupSelector.groupId(value);
                }
                case GROUP_EXTERNAL_ID: {
                    String value = null;
                    expectField(_p, "group_external_id");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return GroupSelector.groupExternalId(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, GroupSelector.Tag> getTagMapping() {
            Map<String, GroupSelector.Tag> values = new HashMap<String, GroupSelector.Tag>();
            values.put("group_id", GroupSelector.Tag.GROUP_ID);
            values.put("group_external_id", GroupSelector.Tag.GROUP_EXTERNAL_ID);
            return Collections.unmodifiableMap(values);
        }
    }
}
