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

@JsonSerialize(using=GroupUpdateArgs.Serializer.class)
@JsonDeserialize(using=GroupUpdateArgs.Deserializer.class)
class GroupUpdateArgs extends IncludeMembersArg {
    // struct GroupUpdateArgs

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final GroupSelector group;
    protected final String newGroupName;
    protected final String newGroupExternalId;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     * @param newGroupName  Optional argument. Set group name to this if
     *     provided.
     * @param newGroupExternalId  Optional argument. New group external ID. If
     *     the argument is None, the group's external_id won't be updated. If
     *     the argument is empty string, the group's external id will be
     *     cleared.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupUpdateArgs(GroupSelector group, boolean returnMembers, String newGroupName, String newGroupExternalId) {
        super(returnMembers);
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        this.newGroupName = newGroupName;
        this.newGroupExternalId = newGroupExternalId;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupUpdateArgs(GroupSelector group) {
        this(group, true, null, null);
    }

    /**
     * Specify a group.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * Optional argument. Set group name to this if provided.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewGroupName() {
        return newGroupName;
    }

    /**
     * Optional argument. New group external ID. If the argument is None, the
     * group's external_id won't be updated. If the argument is empty string,
     * the group's external id will be cleared.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getNewGroupExternalId() {
        return newGroupExternalId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(GroupSelector group) {
        return new Builder(group);
    }

    /**
     * Builder for {@link GroupUpdateArgs}.
     */
    public static class Builder {
        protected final GroupSelector group;

        protected boolean returnMembers;
        protected String newGroupName;
        protected String newGroupExternalId;

        protected Builder(GroupSelector group) {
            if (group == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = group;
            this.returnMembers = true;
            this.newGroupName = null;
            this.newGroupExternalId = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param returnMembers  Whether to return the list of members in the
         *     group.  Note that the default value will cause all the group
         *     members  to be returned in the response. This may take a long
         *     time for large groups. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withReturnMembers(Boolean returnMembers) {
            if (returnMembers != null) {
                this.returnMembers = returnMembers;
            }
            else {
                this.returnMembers = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGroupName  Optional argument. Set group name to this if
         *     provided.
         *
         * @return this builder
         */
        public Builder withNewGroupName(String newGroupName) {
            this.newGroupName = newGroupName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newGroupExternalId  Optional argument. New group external ID.
         *     If the argument is None, the group's external_id won't be
         *     updated. If the argument is empty string, the group's external id
         *     will be cleared.
         *
         * @return this builder
         */
        public Builder withNewGroupExternalId(String newGroupExternalId) {
            this.newGroupExternalId = newGroupExternalId;
            return this;
        }

        /**
         * Builds an instance of {@link GroupUpdateArgs} configured with this
         * builder's values
         *
         * @return new instance of {@link GroupUpdateArgs}
         */
        public GroupUpdateArgs build() {
            return new GroupUpdateArgs(group, returnMembers, newGroupName, newGroupExternalId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            newGroupName,
            newGroupExternalId
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
            GroupUpdateArgs other = (GroupUpdateArgs) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && (this.returnMembers == other.returnMembers)
                && ((this.newGroupName == other.newGroupName) || (this.newGroupName != null && this.newGroupName.equals(other.newGroupName)))
                && ((this.newGroupExternalId == other.newGroupExternalId) || (this.newGroupExternalId != null && this.newGroupExternalId.equals(other.newGroupExternalId)))
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

    static final class Serializer extends StructJsonSerializer<GroupUpdateArgs> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupUpdateArgs.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupUpdateArgs.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupUpdateArgs> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupUpdateArgs value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("group", value.group);
            g.writeObjectField("return_members", value.returnMembers);
            if (value.newGroupName != null) {
                g.writeObjectField("new_group_name", value.newGroupName);
            }
            if (value.newGroupExternalId != null) {
                g.writeObjectField("new_group_external_id", value.newGroupExternalId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupUpdateArgs> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupUpdateArgs.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupUpdateArgs.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupUpdateArgs> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupUpdateArgs deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            GroupSelector group = null;
            boolean returnMembers = true;
            String newGroupName = null;
            String newGroupExternalId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("group".equals(_field)) {
                    group = _p.readValueAs(GroupSelector.class);
                    _p.nextToken();
                }
                else if ("return_members".equals(_field)) {
                    returnMembers = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("new_group_name".equals(_field)) {
                    newGroupName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("new_group_external_id".equals(_field)) {
                    newGroupExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (group == null) {
                throw new JsonParseException(_p, "Required field \"group\" is missing.");
            }

            return new GroupUpdateArgs(group, returnMembers, newGroupName, newGroupExternalId);
        }
    }
}
