/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * A user or group
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class ParticipantLogInfo {
    // union team_log.ParticipantLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link ParticipantLogInfo}.
     */
    public enum Tag {
        /**
         * Group details.
         */
        GROUP, // GroupLogInfo
        /**
         * A user with a Dropbox account.
         */
        USER, // UserLogInfo
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ParticipantLogInfo OTHER = new ParticipantLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private GroupLogInfo groupValue;
    private UserLogInfo userValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ParticipantLogInfo() {
    }


    /**
     * A user or group
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ParticipantLogInfo withTag(Tag _tag) {
        ParticipantLogInfo result = new ParticipantLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * A user or group
     *
     * @param groupValue  Group details. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ParticipantLogInfo withTagAndGroup(Tag _tag, GroupLogInfo groupValue) {
        ParticipantLogInfo result = new ParticipantLogInfo();
        result._tag = _tag;
        result.groupValue = groupValue;
        return result;
    }

    /**
     * A user or group
     *
     * @param userValue  A user with a Dropbox account. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ParticipantLogInfo withTagAndUser(Tag _tag, UserLogInfo userValue) {
        ParticipantLogInfo result = new ParticipantLogInfo();
        result._tag = _tag;
        result.userValue = userValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ParticipantLogInfo}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#GROUP},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#GROUP},
     *     {@code false} otherwise.
     */
    public boolean isGroup() {
        return this._tag == Tag.GROUP;
    }

    /**
     * Returns an instance of {@code ParticipantLogInfo} that has its tag set to
     * {@link Tag#GROUP}.
     *
     * <p> Group details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ParticipantLogInfo} with its tag set to {@link
     *     Tag#GROUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ParticipantLogInfo group(GroupLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ParticipantLogInfo().withTagAndGroup(Tag.GROUP, value);
    }

    /**
     * Group details.
     *
     * <p> This instance must be tagged as {@link Tag#GROUP}. </p>
     *
     * @return The {@link GroupLogInfo} value associated with this instance if
     *     {@link #isGroup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isGroup} is {@code false}.
     */
    public GroupLogInfo getGroupValue() {
        if (this._tag != Tag.GROUP) {
            throw new IllegalStateException("Invalid tag: required Tag.GROUP, but was Tag." + this._tag.name());
        }
        return groupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#USER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#USER},
     *     {@code false} otherwise.
     */
    public boolean isUser() {
        return this._tag == Tag.USER;
    }

    /**
     * Returns an instance of {@code ParticipantLogInfo} that has its tag set to
     * {@link Tag#USER}.
     *
     * <p> A user with a Dropbox account. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ParticipantLogInfo} with its tag set to {@link
     *     Tag#USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ParticipantLogInfo user(UserLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ParticipantLogInfo().withTagAndUser(Tag.USER, value);
    }

    /**
     * A user with a Dropbox account.
     *
     * <p> This instance must be tagged as {@link Tag#USER}. </p>
     *
     * @return The {@link UserLogInfo} value associated with this instance if
     *     {@link #isUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUser} is {@code false}.
     */
    public UserLogInfo getUserValue() {
        if (this._tag != Tag.USER) {
            throw new IllegalStateException("Invalid tag: required Tag.USER, but was Tag." + this._tag.name());
        }
        return userValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.groupValue,
            this.userValue
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
        else if (obj instanceof ParticipantLogInfo) {
            ParticipantLogInfo other = (ParticipantLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case GROUP:
                    return (this.groupValue == other.groupValue) || (this.groupValue.equals(other.groupValue));
                case USER:
                    return (this.userValue == other.userValue) || (this.userValue.equals(other.userValue));
                case OTHER:
                    return true;
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
    static class Serializer extends UnionSerializer<ParticipantLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ParticipantLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case GROUP: {
                    g.writeStartObject();
                    writeTag("group", g);
                    GroupLogInfo.Serializer.INSTANCE.serialize(value.groupValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case USER: {
                    g.writeStartObject();
                    writeTag("user", g);
                    g.writeFieldName("user");
                    UserLogInfo.Serializer.INSTANCE.serialize(value.userValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ParticipantLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            ParticipantLogInfo value;
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
            else if ("group".equals(tag)) {
                GroupLogInfo fieldValue = null;
                fieldValue = GroupLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ParticipantLogInfo.group(fieldValue);
            }
            else if ("user".equals(tag)) {
                UserLogInfo fieldValue = null;
                expectField("user", p);
                fieldValue = UserLogInfo.Serializer.INSTANCE.deserialize(p);
                value = ParticipantLogInfo.user(fieldValue);
            }
            else {
                value = ParticipantLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
