/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class AlphaGroupsGetInfoItem {
    // union AlphaGroupsGetInfoItem

    /**
     * Discriminating tag type for {@link AlphaGroupsGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@code alphaGroupsGetInfo},
         * and did not match a corresponding group. The ID can be a group ID, or
         * an external ID, depending on how the method was called.
         */
        ID_NOT_FOUND, // String
        /**
         * Info about a group.
         */
        GROUP_INFO; // AlphaGroupFullInfo
    }

    private final Tag tag;
    private final String idNotFoundValue;
    private final AlphaGroupFullInfo groupInfoValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private AlphaGroupsGetInfoItem(Tag tag, String idNotFoundValue, AlphaGroupFullInfo groupInfoValue) {
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
     * values for this {@code AlphaGroupsGetInfoItem}. </p>
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
     * Returns an instance of {@code AlphaGroupsGetInfoItem} that has its tag
     * set to {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@code alphaGroupsGetInfo},
     * and did not match a corresponding group. The ID can be a group ID, or an
     * external ID, depending on how the method was called. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AlphaGroupsGetInfoItem} with its tag set to
     *     {@link Tag#ID_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AlphaGroupsGetInfoItem idNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGroupsGetInfoItem(Tag.ID_NOT_FOUND, value, null);
    }

    /**
     * An ID that was provided as a parameter to {@code alphaGroupsGetInfo}, and
     * did not match a corresponding group. The ID can be a group ID, or an
     * external ID, depending on how the method was called.
     *
     * <p> This instance must be tagged as {@link Tag#ID_NOT_FOUND}. </p>
     *
     * @return The {@link AlphaGroupsGetInfoItem#idNotFound} value associated
     *     with this instance if {@link #isIdNotFound} is {@code true}.
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
     * Returns an instance of {@code AlphaGroupsGetInfoItem} that has its tag
     * set to {@link Tag#GROUP_INFO}.
     *
     * <p> Info about a group. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AlphaGroupsGetInfoItem} with its tag set to
     *     {@link Tag#GROUP_INFO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AlphaGroupsGetInfoItem groupInfo(AlphaGroupFullInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGroupsGetInfoItem(Tag.GROUP_INFO, null, value);
    }

    /**
     * Info about a group.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP_INFO}. </p>
     *
     * @return The {@link AlphaGroupsGetInfoItem#groupInfo} value associated
     *     with this instance if {@link #isGroupInfo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroupInfo} is {@code false}.
     */
    public AlphaGroupFullInfo getGroupInfoValue() {
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
        else if (obj instanceof AlphaGroupsGetInfoItem) {
            AlphaGroupsGetInfoItem other = (AlphaGroupsGetInfoItem) obj;
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
    static final class Serializer extends UnionSerializer<AlphaGroupsGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGroupsGetInfoItem value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ID_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("id_not_found", g);
                    g.writeFieldName("id_not_found");
                    StoneSerializers.string().serialize(value.idNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                case GROUP_INFO: {
                    g.writeStartObject();
                    writeTag("group_info", g);
                    AlphaGroupFullInfo.Serializer.INSTANCE.serialize(value.groupInfoValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public AlphaGroupsGetInfoItem deserialize(JsonParser p) throws IOException, JsonParseException {
            AlphaGroupsGetInfoItem value;
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
            else if ("id_not_found".equals(tag)) {
                String fieldValue = null;
                expectField("id_not_found", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = AlphaGroupsGetInfoItem.idNotFound(fieldValue);
            }
            else if ("group_info".equals(tag)) {
                AlphaGroupFullInfo fieldValue = null;
                fieldValue = AlphaGroupFullInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AlphaGroupsGetInfoItem.groupInfo(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
