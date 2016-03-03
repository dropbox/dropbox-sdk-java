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
import java.util.List;
import java.util.Map;

/**
 * Argument for selecting a list of groups, either by group_ids, or external
 * group IDs.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
@JsonSerialize(using=GroupsSelector.Serializer.class)
@JsonDeserialize(using=GroupsSelector.Deserializer.class)
public final class GroupsSelector {
    // union GroupsSelector

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link GroupsSelector}.
     */
    public enum Tag {
        /**
         * List of group IDs.
         */
        GROUP_IDS, // List<String>
        /**
         * List of external IDs of groups.
         */
        GROUP_EXTERNAL_IDS; // List<String>
    }

    private final Tag tag;
    private final List<String> groupIdsValue;
    private final List<String> groupExternalIdsValue;

    /**
     * Argument for selecting a list of groups, either by group_ids, or external
     * group IDs.
     *
     * @param tag  Discriminating tag for this instance.
     */
    private GroupsSelector(Tag tag, List<String> groupIdsValue, List<String> groupExternalIdsValue) {
        this.tag = tag;
        this.groupIdsValue = groupIdsValue;
        this.groupExternalIdsValue = groupExternalIdsValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GroupsSelector}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP_IDS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#GROUP_IDS},
     *     {@code false} otherwise.
     */
    public boolean isGroupIds() {
        return this.tag == Tag.GROUP_IDS;
    }

    /**
     * Returns an instance of {@code GroupsSelector} that has its tag set to
     * {@link Tag#GROUP_IDS}.
     *
     * <p> List of group IDs. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupsSelector} with its tag set to {@link
     *     Tag#GROUP_IDS}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupsSelector groupIds(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupsSelector(Tag.GROUP_IDS, value, null);
    }

    /**
     * List of group IDs.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_IDS}. </p>
     *
     * @return The {@link GroupsSelector#groupIds} value associated with this
     *     instance if {@link #isGroupIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupIds} is {@code false}.
     */
    public List<String> getGroupIdsValue() {
        if (this.tag != Tag.GROUP_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_IDS, but was Tag." + tag.name());
        }
        return groupIdsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_EXTERNAL_IDS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_EXTERNAL_IDS}, {@code false} otherwise.
     */
    public boolean isGroupExternalIds() {
        return this.tag == Tag.GROUP_EXTERNAL_IDS;
    }

    /**
     * Returns an instance of {@code GroupsSelector} that has its tag set to
     * {@link Tag#GROUP_EXTERNAL_IDS}.
     *
     * <p> List of external IDs of groups. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GroupsSelector} with its tag set to {@link
     *     Tag#GROUP_EXTERNAL_IDS}.
     *
     * @throws IllegalArgumentException  if {@code value} contains a {@code
     *     null} item or is {@code null}.
     */
    public static GroupsSelector groupExternalIds(List<String> value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        for (String x : value) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list is null");
            }
        }
        return new GroupsSelector(Tag.GROUP_EXTERNAL_IDS, null, value);
    }

    /**
     * List of external IDs of groups.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_EXTERNAL_IDS}. </p>
     *
     * @return The {@link GroupsSelector#groupExternalIds} value associated with
     *     this instance if {@link #isGroupExternalIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupExternalIds} is {@code
     *     false}.
     */
    public List<String> getGroupExternalIdsValue() {
        if (this.tag != Tag.GROUP_EXTERNAL_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_IDS, but was Tag." + tag.name());
        }
        return groupExternalIdsValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            groupIdsValue,
            groupExternalIdsValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof GroupsSelector) {
            GroupsSelector other = (GroupsSelector) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case GROUP_IDS:
                    return (this.groupIdsValue == other.groupIdsValue) || (this.groupIdsValue.equals(other.groupIdsValue));
                case GROUP_EXTERNAL_IDS:
                    return (this.groupExternalIdsValue == other.groupExternalIdsValue) || (this.groupExternalIdsValue.equals(other.groupExternalIdsValue));
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

    static final class Serializer extends UnionJsonSerializer<GroupsSelector> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsSelector.class);
        }

        @Override
        public void serialize(GroupsSelector value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case GROUP_IDS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "group_ids");
                    g.writeObjectField("group_ids", value.groupIdsValue);
                    g.writeEndObject();
                    break;
                case GROUP_EXTERNAL_IDS:
                    g.writeStartObject();
                    g.writeStringField(".tag", "group_external_ids");
                    g.writeObjectField("group_external_ids", value.groupExternalIdsValue);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupsSelector, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsSelector.class, getTagMapping(), null);
        }

        @Override
        public GroupsSelector deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case GROUP_IDS: {
                    List<String> value = null;
                    expectField(_p, "group_ids");
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
                    return GroupsSelector.groupIds(value);
                }
                case GROUP_EXTERNAL_IDS: {
                    List<String> value = null;
                    expectField(_p, "group_external_ids");
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
                    return GroupsSelector.groupExternalIds(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, GroupsSelector.Tag> getTagMapping() {
            Map<String, GroupsSelector.Tag> values = new HashMap<String, GroupsSelector.Tag>();
            values.put("group_ids", GroupsSelector.Tag.GROUP_IDS);
            values.put("group_external_ids", GroupsSelector.Tag.GROUP_EXTERNAL_IDS);
            return Collections.unmodifiableMap(values);
        }
    }
}
