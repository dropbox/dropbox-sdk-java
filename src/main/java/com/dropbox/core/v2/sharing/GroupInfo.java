/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.team.GroupSummary;
import com.dropbox.core.v2.team.GroupType;

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
 * The information about a group. Groups is a way to manage a list of users  who
 * need same access permission to the shared folder.
 */
@JsonSerialize(using=GroupInfo.Serializer.class)
@JsonDeserialize(using=GroupInfo.Deserializer.class)
public class GroupInfo extends GroupSummary {
    // struct GroupInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupType groupType;
    protected final boolean sameTeam;

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param sameTeam  If the group is owned by the current user's team.
     * @param groupExternalId  External ID of group. This is an arbitrary ID
     *     that an admin can attach to a group.
     * @param memberCount  The number of members in the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, GroupType groupType, boolean sameTeam, String groupExternalId, Long memberCount) {
        super(groupName, groupId, groupExternalId, memberCount);
        if (groupType == null) {
            throw new IllegalArgumentException("Required value for 'groupType' is null");
        }
        this.groupType = groupType;
        this.sameTeam = sameTeam;
    }

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param sameTeam  If the group is owned by the current user's team.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupInfo(String groupName, String groupId, GroupType groupType, boolean sameTeam) {
        this(groupName, groupId, groupType, sameTeam, null, null);
    }

    /**
     * The type of group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupType getGroupType() {
        return groupType;
    }

    /**
     * If the group is owned by the current user's team.
     *
     * @return value for this field.
     */
    public boolean getSameTeam() {
        return sameTeam;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param groupName  Must not be {@code null}.
     * @param groupId  Must not be {@code null}.
     * @param groupType  The type of group. Must not be {@code null}.
     * @param sameTeam  If the group is owned by the current user's team.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String groupName, String groupId, GroupType groupType, boolean sameTeam) {
        return new Builder(groupName, groupId, groupType, sameTeam);
    }

    /**
     * Builder for {@link GroupInfo}.
     */
    public static class Builder extends GroupSummary.Builder {
        protected final GroupType groupType;
        protected final boolean sameTeam;

        protected Builder(String groupName, String groupId, GroupType groupType, boolean sameTeam) {
            super(groupName, groupId);
            if (groupType == null) {
                throw new IllegalArgumentException("Required value for 'groupType' is null");
            }
            this.groupType = groupType;
            this.sameTeam = sameTeam;
        }

        /**
         * Builds an instance of {@link GroupInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupInfo}
         */
        public GroupInfo build() {
            return new GroupInfo(groupName, groupId, groupType, sameTeam, groupExternalId, memberCount);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupType,
            sameTeam
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GroupInfo other = (GroupInfo) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupId == other.groupId) || (this.groupId.equals(other.groupId)))
                && ((this.groupType == other.groupType) || (this.groupType.equals(other.groupType)))
                && (this.sameTeam == other.sameTeam)
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

    static final class Serializer extends StructJsonSerializer<GroupInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group_name", value.groupName);
            g.writeObjectField("group_id", value.groupId);
            g.writeObjectField("group_type", value.groupType);
            g.writeObjectField("same_team", value.sameTeam);
            if (value.groupExternalId != null) {
                g.writeObjectField("group_external_id", value.groupExternalId);
            }
            if (value.memberCount != null) {
                g.writeObjectField("member_count", value.memberCount);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String groupName = null;
            String groupId = null;
            GroupType groupType = null;
            Boolean sameTeam = null;
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
                else if ("group_type".equals(_field)) {
                    groupType = _p.readValueAs(GroupType.class);
                    _p.nextToken();
                }
                else if ("same_team".equals(_field)) {
                    sameTeam = _p.getValueAsBoolean();
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
            if (groupType == null) {
                throw new JsonParseException(_p, "Required field \"group_type\" is missing.");
            }
            if (sameTeam == null) {
                throw new JsonParseException(_p, "Required field \"same_team\" is missing.");
            }

            return new GroupInfo(groupName, groupId, groupType, sameTeam, groupExternalId, memberCount);
        }
    }
}
