/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=GroupCreateArg.Serializer.class)
@JsonDeserialize(using=GroupCreateArg.Deserializer.class)
class GroupCreateArg {
    // struct GroupCreateArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String groupName;
    protected final String groupExternalId;

    /**
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param groupExternalId  Optional argument. The creator of a team can
     *     associate an arbitrary external ID to the group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(String groupName, String groupExternalId) {
        if (groupName == null) {
            throw new IllegalArgumentException("Required value for 'groupName' is null");
        }
        this.groupName = groupName;
        this.groupExternalId = groupExternalId;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupCreateArg(String groupName) {
        this(groupName, null);
    }

    /**
     * Group name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Optional argument. The creator of a team can associate an arbitrary
     * external ID to the group.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getGroupExternalId() {
        return groupExternalId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groupName,
            groupExternalId
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
            GroupCreateArg other = (GroupCreateArg) obj;
            return ((this.groupName == other.groupName) || (this.groupName.equals(other.groupName)))
                && ((this.groupExternalId == other.groupExternalId) || (this.groupExternalId != null && this.groupExternalId.equals(other.groupExternalId)))
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

    static final class Serializer extends StructJsonSerializer<GroupCreateArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupCreateArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupCreateArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupCreateArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupCreateArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group_name", value.groupName);
            if (value.groupExternalId != null) {
                g.writeObjectField("group_external_id", value.groupExternalId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupCreateArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupCreateArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupCreateArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupCreateArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupCreateArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String groupName = null;
            String groupExternalId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group_name".equals(_field)) {
                    groupName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("group_external_id".equals(_field)) {
                    groupExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (groupName == null) {
                throw new JsonParseException(_p, "Required field \"group_name\" is missing.");
            }

            return new GroupCreateArg(groupName, groupExternalId);
        }
    }
}
