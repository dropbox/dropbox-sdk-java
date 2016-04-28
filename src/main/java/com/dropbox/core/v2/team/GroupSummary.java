/* DO NOT EDIT */
/* This file was generated from team_common.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Information about a group.
 */
@JsonSerialize(using=GroupSummary.Serializer.class)
@JsonDeserialize(using=GroupSummary.Deserializer.class)
public class GroupSummary {
    // struct GroupSummary

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String groupName;
    protected final String groupId;
    protected final String groupExternalId;
    protected final Long memberCount;

    /**
     * Information about a group.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     * @param memberCount  The number of members in the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupSummary(String groupName, String groupId, String groupExternalId, Long memberCount) {
        if (groupName == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = groupName;
        if (groupId == null) {
            throw new IllegalArgumentException("Required value for 'groupId' is null");
        }
        this.groupId = groupId;
        this.groupExternalId = groupExternalId;
        this.memberCount = memberCount;
    }

    /**
     * Information about a group.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupSummary(String groupName, String groupId) {
        this(groupName, groupId, null, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * External ID of group. This is an arbitrary ID that an admin can attach to
     * a group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getGroupExternalId() {
        return groupExternalId;
    }

    /**
     * The number of members in the group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Long getMemberCount() {
        return memberCount;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName, String groupId) {
        return new Builder(groupName, groupId);
    }

    /**
     * Builder for {@link GroupSummary}.
     */
    public static class Builder {
        protected final String groupName;
        protected final String groupId;

        protected String groupExternalId;
        protected Long memberCount;

        protected Builder(String groupName, String groupId) {
            if (groupName == null) {
                throw new IllegalArgumentException("Required value for 'groupName' is null");
            }
            this.groupName = groupName;
            if (groupId == null) {
                throw new IllegalArgumentException("Required value for 'groupId' is null");
            }
            this.groupId = groupId;
            this.groupExternalId = null;
            this.memberCount = null;
        }

        /**
         * Set value for optional field.
         *
         * @param groupExternalId  External ID of group. This is an arbitrary ID
         *     that an admin can attach to a group.
         *
         * @return this builder
         */
        public Builder withGroupExternalId(String groupExternalId) {
            this.groupExternalId = groupExternalId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberCount  The number of members in the group.
         *
         * @return this builder
         */
        public Builder withMemberCount(Long memberCount) {
            this.memberCount = memberCount;
            return this;
        }

        /**
         * Builds an instance of {@link GroupSummary} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupSummary}
         */
        public GroupSummary build() {
            return new GroupSummary(groupName, groupId, groupExternalId, memberCount);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupName,
            groupId,
            groupExternalId,
            memberCount
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupSummary other = (GroupSummary) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
                && ((this.memberCount == other.memberCount) || (this.memberCount != null && this.memberCount.equals(other.memberCount)))
                ;
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

    static final class Serializer extends StructJsonSerializer<GroupSummary> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupSummary.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupSummary.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupSummary> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupSummary value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group_name", value.groupName);
            g.writeObjectField("group_id", value.groupId);
            if (value.groupExternalId != null) {
                g.writeObjectField("group_external_id", value.groupExternalId);
            }
            if (value.memberCount != null) {
                g.writeObjectField("member_count", value.memberCount);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupSummary> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupSummary.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupSummary.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupSummary> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupSummary deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String groupName = null;
            String groupId = null;
            String groupExternalId = null;
            Long memberCount = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group_name".equals(_field)) {
                    groupName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("group_id".equals(_field)) {
                    groupId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("group_external_id".equals(_field)) {
                    groupExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_count".equals(_field)) {
                    memberCount = _p.getLongValue();
                    assertUnsigned(_p, memberCount);
                    if (memberCount > Integer.MAX_VALUE) {
                        throw new JsonParseException(_p, "expecting a 32-bit unsigned integer, got: " + memberCount);
                    }
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (groupName == null) {
                throw new JsonParseException(_p, "Required field \"group_name\" is missing.");
            }
            if (groupId == null) {
                throw new JsonParseException(_p, "Required field \"group_id\" is missing.");
            }

            return new GroupSummary(groupName, groupId, groupExternalId, memberCount);
        }
    }
}
