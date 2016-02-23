/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Argument for selecting a list of groups, either by group_ids, or external
 * group IDs.
 */
public final class GroupsSelector {
    // union GroupsSelector

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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("group_ids", Tag.GROUP_IDS);
        VALUES_.put("group_external_ids", Tag.GROUP_EXTERNAL_IDS);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GroupsSelector}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_IDS}, {@code false} otherwise.
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
     * @param value  {@link GroupsSelector#groupIds} value to assign to this
     *     instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link GroupsSelector#groupExternalIds} value to assign to
     *     this instance.
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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupsSelector fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupsSelector> _JSON_WRITER = new JsonWriter<GroupsSelector>() {
        public final void write(GroupsSelector x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case GROUP_IDS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_ids");
                    g.writeFieldName("group_ids");
                    g.writeStartArray();
                    for (String item: x.getGroupIdsValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
                case GROUP_EXTERNAL_IDS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_external_ids");
                    g.writeFieldName("group_external_ids");
                    g.writeStartArray();
                    for (String item: x.getGroupExternalIdsValue()) {
                        if (item != null) {
                            g.writeString(item);
                        }
                    }
                    g.writeEndArray();
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupsSelector> _JSON_READER = new JsonReader<GroupsSelector>() {

        public final GroupsSelector read(JsonParser parser) throws IOException, JsonReadException {
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
            GroupsSelector value = null;
            if (tag != null) {
                switch (tag) {
                    case GROUP_IDS: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "group_ids", v);
                        value = GroupsSelector.groupIds(v);
                        break;
                    }
                    case GROUP_EXTERNAL_IDS: {
                        List<String> v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonArrayReader.mk(JsonReader.StringReader)
                            .readField(parser, "group_external_ids", v);
                        value = GroupsSelector.groupExternalIds(v);
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
