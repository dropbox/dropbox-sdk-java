/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Argument for selecting a single group, either by group_id or by external
 * group ID.
 */
public final class GroupSelector {
    // union GroupSelector

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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("group_id", Tag.GROUP_ID);
        VALUES_.put("group_external_id", Tag.GROUP_EXTERNAL_ID);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GroupSelector}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_ID}, {@code false} otherwise.
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
     * @param value  {@link GroupSelector#groupId} value to assign to this
     *     instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link GroupSelector#groupExternalId} value to assign to
     *     this instance.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupSelector fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupSelector> _JSON_WRITER = new JsonWriter<GroupSelector>() {
        public final void write(GroupSelector x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case GROUP_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_id");
                    g.writeFieldName("group_id");
                    g.writeString(x.getGroupIdValue());
                    g.writeEndObject();
                    break;
                case GROUP_EXTERNAL_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_external_id");
                    g.writeFieldName("group_external_id");
                    g.writeString(x.getGroupExternalIdValue());
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupSelector> _JSON_READER = new JsonReader<GroupSelector>() {

        public final GroupSelector read(JsonParser parser) throws IOException, JsonReadException {
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
            GroupSelector value = null;
            if (tag != null) {
                switch (tag) {
                    case GROUP_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "group_id", v);
                        value = GroupSelector.groupId(v);
                        break;
                    }
                    case GROUP_EXTERNAL_ID: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "group_external_id", v);
                        value = GroupSelector.groupExternalId(v);
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
