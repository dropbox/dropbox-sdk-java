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

public final class GroupsGetInfoItem {
    // union GroupsGetInfoItem

    /**
     * Discriminating tag type for {@link GroupsGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeam#groupsGetInfo(GroupsSelector)}, and did not match a
         * corresponding group. The ID can be a group ID, or an external ID,
         * depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a group.
         */
        GROUP_INFO; // GroupFullInfo
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("id_not_found", Tag.ID_NOT_FOUND);
        VALUES_.put("group_info", Tag.GROUP_INFO);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code GroupsGetInfoItem}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * DbxTeam#groupsGetInfo(GroupsSelector)}, and did not match a corresponding
     * group. The ID can be a group ID, or an external ID, depending on how the
     * method was called. </p>
     *
     * @param value  {@link GroupsGetInfoItem#idNotFound} value to assign to
     *     this instance.
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
     * DbxTeam#groupsGetInfo(GroupsSelector)}, and did not match a corresponding
     * group. The ID can be a group ID, or an external ID, depending on how the
     * method was called.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
     * @param value  {@link GroupsGetInfoItem#groupInfo} value to assign to this
     *     instance.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupsGetInfoItem fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupsGetInfoItem> _JSON_WRITER = new JsonWriter<GroupsGetInfoItem>() {
        public final void write(GroupsGetInfoItem x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ID_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("id_not_found");
                    g.writeFieldName("id_not_found");
                    g.writeString(x.getIdNotFoundValue());
                    g.writeEndObject();
                    break;
                case GROUP_INFO:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_info");
                    g.writeFieldName("group_info");
                    GroupFullInfo._JSON_WRITER.write(x.getGroupInfoValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupsGetInfoItem> _JSON_READER = new JsonReader<GroupsGetInfoItem>() {

        public final GroupsGetInfoItem read(JsonParser parser) throws IOException, JsonReadException {
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
            GroupsGetInfoItem value = null;
            if (tag != null) {
                switch (tag) {
                    case ID_NOT_FOUND: {
                        String v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = JsonReader.StringReader
                            .readField(parser, "id_not_found", v);
                        value = GroupsGetInfoItem.idNotFound(v);
                        break;
                    }
                    case GROUP_INFO: {
                        GroupFullInfo v = null;
                        v = GroupFullInfo._JSON_READER.readFields(parser);
                        value = GroupsGetInfoItem.groupInfo(v);
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
