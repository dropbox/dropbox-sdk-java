/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Group's logged information.
 */
public class GroupLogInfo {
    // struct team_log.GroupLogInfo (team_log_generated.stone)

    @Nullable
    protected final String groupId;
    @Nonnull
    protected final String displayName;
    @Nullable
    protected final String externalId;

    /**
     * Group's logged information.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param displayName  The name of this group. Must not be {@code null}.
     * @param groupId  The unique id of this group.
     * @param externalId  External group ID.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupLogInfo(@Nonnull String displayName, @Nullable String groupId, @Nullable String externalId) {
        this.groupId = groupId;
        if (displayName == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = displayName;
        this.externalId = externalId;
    }

    /**
     * Group's logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param displayName  The name of this group. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupLogInfo(@Nonnull String displayName) {
        this(displayName, null, null);
    }

    /**
     * The name of this group.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDisplayName() {
        return displayName;
    }

    /**
     * The unique id of this group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getGroupId() {
        return groupId;
    }

    /**
     * External group ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getExternalId() {
        return externalId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param displayName  The name of this group. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String displayName) {
        return new Builder(displayName);
    }

    /**
     * Builder for {@link GroupLogInfo}.
     */
    public static class Builder {
        protected final String displayName;

        protected String groupId;
        protected String externalId;

        protected Builder(String displayName) {
            if (displayName == null) {
                throw new IllegalArgumentException("Required value for 'displayName' is null");
            }
            this.displayName = displayName;
            this.groupId = null;
            this.externalId = null;
        }

        /**
         * Set value for optional field.
         *
         * @param groupId  The unique id of this group.
         *
         * @return this builder
         */
        public Builder withGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param externalId  External group ID.
         *
         * @return this builder
         */
        public Builder withExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        /**
         * Builds an instance of {@link GroupLogInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupLogInfo}
         */
        public GroupLogInfo build() {
            return new GroupLogInfo(displayName, groupId, externalId);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            groupId,
            displayName,
            externalId
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupLogInfo other = (GroupLogInfo) obj;
            return ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
                && ((this.groupId == other.groupId) || (this.groupId != null && this.groupId.equals(other.groupId)))
                && ((this.externalId == other.externalId) || (this.externalId != null && this.externalId.equals(other.externalId)))
                ;
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
    static class Serializer extends StructSerializer<GroupLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("display_name");
            StoneSerializers.string().serialize(value.displayName, g);
            if (value.groupId != null) {
                g.writeFieldName("group_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupId, g);
            }
            if (value.externalId != null) {
                g.writeFieldName("external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.externalId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_displayName = null;
                String f_groupId = null;
                String f_externalId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_id".equals(field)) {
                        f_groupId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("external_id".equals(field)) {
                        f_externalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_displayName == null) {
                    throw new JsonParseException(p, "Required field \"display_name\" missing.");
                }
                value = new GroupLogInfo(f_displayName, f_groupId, f_externalId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
