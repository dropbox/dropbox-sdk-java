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

/**
 * Argument for selecting a single group, either by group_id or by external
 * group ID.
 *
 * <p> This class is a tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 */
public final class GroupSelector {
    // union team.GroupSelector (team_groups.stone)

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

    private Tag _tag;
    private String groupIdValue;
    private String groupExternalIdValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GroupSelector() {
    }


    /**
     * Argument for selecting a single group, either by group_id or by external
     * group ID.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GroupSelector withTag(Tag _tag) {
        GroupSelector result = new GroupSelector();
        result._tag = _tag;
        return result;
    }

    /**
     * Argument for selecting a single group, either by group_id or by external
     * group ID.
     *
     * @param groupIdValue  Group ID. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupSelector withTagAndGroupId(Tag _tag, String groupIdValue) {
        GroupSelector result = new GroupSelector();
        result._tag = _tag;
        result.groupIdValue = groupIdValue;
        return result;
    }

    /**
     * Argument for selecting a single group, either by group_id or by external
     * group ID.
     *
     * @param groupExternalIdValue  External ID of the group. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GroupSelector withTagAndGroupExternalId(Tag _tag, String groupExternalIdValue) {
        GroupSelector result = new GroupSelector();
        result._tag = _tag;
        result.groupExternalIdValue = groupExternalIdValue;
        return result;
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
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP_ID},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#GROUP_ID},
     *     {@code false} otherwise.
     */
    public boolean isGroupId() {
        return this._tag == Tag.GROUP_ID;
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
        return new GroupSelector().withTagAndGroupId(Tag.GROUP_ID, value);
    }

    /**
     * Group ID.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_ID}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isGroupId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupId} is {@code false}.
     */
    public String getGroupIdValue() {
        if (this._tag != Tag.GROUP_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_ID, but was Tag." + this._tag.name());
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
        return this._tag == Tag.GROUP_EXTERNAL_ID;
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
        return new GroupSelector().withTagAndGroupExternalId(Tag.GROUP_EXTERNAL_ID, value);
    }

    /**
     * External ID of the group.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_EXTERNAL_ID}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isGroupExternalId} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupExternalId} is {@code
     *     false}.
     */
    public String getGroupExternalIdValue() {
        if (this._tag != Tag.GROUP_EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP_EXTERNAL_ID, but was Tag." + this._tag.name());
        }
        return groupExternalIdValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
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
        if (obj == null) {
            return false;
        }
        else if (obj instanceof GroupSelector) {
            GroupSelector other = (GroupSelector) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    static class Serializer extends UnionSerializer<GroupSelector> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupSelector value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case GROUP_ID: {
                    g.writeStartObject();
                    writeTag("group_id", g);
                    g.writeFieldName("group_id");
                    StoneSerializers.string().serialize(value.groupIdValue, g);
                    g.writeEndObject();
                    break;
                }
                case GROUP_EXTERNAL_ID: {
                    g.writeStartObject();
                    writeTag("group_external_id", g);
                    g.writeFieldName("group_external_id");
                    StoneSerializers.string().serialize(value.groupExternalIdValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public GroupSelector deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupSelector value;
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
            else if ("group_id".equals(tag)) {
                String fieldValue = null;
                expectField("group_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = GroupSelector.groupId(fieldValue);
            }
            else if ("group_external_id".equals(tag)) {
                String fieldValue = null;
                expectField("group_external_id", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = GroupSelector.groupExternalId(fieldValue);
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
