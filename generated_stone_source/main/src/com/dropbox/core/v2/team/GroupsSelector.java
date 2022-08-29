/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

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
import java.util.List;

/**
 * Argument for selecting a list of groups, either by group_ids, or external
 * group IDs.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class GroupsSelector {
    // union team.GroupsSelector (team_groups.stone)

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

    private Tag _tag;
    private List<String> groupIdsValue;
    private List<String> groupExternalIdsValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GroupsSelector() {
    }


    /**
     * Argument for selecting a list of groups, either by group_ids, or external
     * group IDs.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GroupsSelector withTag(Tag _tag) {
        GroupsSelector result = new GroupsSelector();
        result._tag = _tag;
        return result;
    }

    /**
     * Argument for selecting a list of groups, either by group_ids, or external
     * group IDs.
     *
     * @param groupIdsValue  List of group IDs. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupsSelector withTagAndGroupIds(Tag _tag, List<String> groupIdsValue) {
        GroupsSelector result = new GroupsSelector();
        result._tag = _tag;
        result.groupIdsValue = groupIdsValue;
        return result;
    }

    /**
     * Argument for selecting a list of groups, either by group_ids, or external
     * group IDs.
     *
     * @param groupExternalIdsValue  List of external IDs of groups. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupsSelector withTagAndGroupExternalIds(Tag _tag, List<String> groupExternalIdsValue) {
        GroupsSelector result = new GroupsSelector();
        result._tag = _tag;
        result.groupExternalIdsValue = groupExternalIdsValue;
        return result;
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
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP_IDS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#GROUP_IDS},
     *     {@code false} otherwise.
     */
    public boolean isGroupIds() {
        return this._tag == Tag.GROUP_IDS;
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
        return new GroupsSelector().withTagAndGroupIds(Tag.GROUP_IDS, value);
    }

    /**
     * List of group IDs.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_IDS}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isGroupIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupIds} is {@code false}.
     */
    public List<String> getGroupIdsValue() {
        if (this._tag != Tag.GROUP_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_IDS, but was Tag." + this._tag.name());
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
        return this._tag == Tag.GROUP_EXTERNAL_IDS;
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
        return new GroupsSelector().withTagAndGroupExternalIds(Tag.GROUP_EXTERNAL_IDS, value);
    }

    /**
     * List of external IDs of groups.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_EXTERNAL_IDS}. </p>
     *
     * @return The {@link List} value associated with this instance if {@link
     *     #isGroupExternalIds} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupExternalIds} is {@code
     *     false}.
     */
    public List<String> getGroupExternalIdsValue() {
        if (this._tag != Tag.GROUP_EXTERNAL_IDS) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_IDS, but was Tag." + this._tag.name());
        }
        return groupExternalIdsValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
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
        if (obj == null) {
            return false;
        }
        else if (obj instanceof GroupsSelector) {
            GroupsSelector other = (GroupsSelector) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    static class Serializer extends UnionSerializer<GroupsSelector> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupsSelector value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case GROUP_IDS: {
                    g.writeStartObject();
                    writeTag("group_ids", g);
                    g.writeFieldName("group_ids");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.groupIdsValue, g);
                    g.writeEndObject();
                    break;
                }
                case GROUP_EXTERNAL_IDS: {
                    g.writeStartObject();
                    writeTag("group_external_ids", g);
                    g.writeFieldName("group_external_ids");
                    StoneSerializers.list(StoneSerializers.string()).serialize(value.groupExternalIdsValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public GroupsSelector deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupsSelector value;
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
            else if ("group_ids".equals(tag)) {
                List<String> fieldValue = null;
                expectField("group_ids", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupsSelector.groupIds(fieldValue);
            }
            else if ("group_external_ids".equals(tag)) {
                List<String> fieldValue = null;
                expectField("group_external_ids", p);
                fieldValue = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                value = GroupsSelector.groupExternalIds(fieldValue);
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
