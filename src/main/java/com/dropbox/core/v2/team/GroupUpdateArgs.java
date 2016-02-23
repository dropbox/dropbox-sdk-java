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

public class GroupUpdateArgs {
    // struct GroupUpdateArgs

    private final GroupSelector group;
    private final String newGroupName;
    private final String newGroupExternalId;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param group  Specify a group. Must not be {@code null}.
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
    public GroupUpdateArgs(GroupSelector group, String newGroupName, String newGroupExternalId) {
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
        this(group, null, null);
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

        protected String newGroupName;
        protected String newGroupExternalId;

        protected Builder(GroupSelector group) {
            if (group == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
            }
            this.group = group;
            this.newGroupName = null;
            this.newGroupExternalId = null;
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
            return new GroupUpdateArgs(group, newGroupName, newGroupExternalId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            group,
            newGroupName,
            newGroupExternalId
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
            GroupUpdateArgs other = (GroupUpdateArgs) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupUpdateArgs fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupUpdateArgs> _JSON_WRITER = new JsonWriter<GroupUpdateArgs>() {
        public final void write(GroupUpdateArgs x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            GroupUpdateArgs._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(GroupUpdateArgs x, JsonGenerator g) throws IOException {
            g.writeFieldName("group");
            GroupSelector._JSON_WRITER.write(x.group, g);
            if (x.newGroupName != null) {
                g.writeFieldName("new_group_name");
                g.writeString(x.newGroupName);
            }
            if (x.newGroupExternalId != null) {
                g.writeFieldName("new_group_external_id");
                g.writeString(x.newGroupExternalId);
            }
        }
    };

    public static final JsonReader<GroupUpdateArgs> _JSON_READER = new JsonReader<GroupUpdateArgs>() {
        public final GroupUpdateArgs read(JsonParser parser) throws IOException, JsonReadException {
            GroupUpdateArgs result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final GroupUpdateArgs readFields(JsonParser parser) throws IOException, JsonReadException {
            GroupSelector group = null;
            String newGroupName = null;
            String newGroupExternalId = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("group".equals(fieldName)) {
                    group = GroupSelector._JSON_READER
                        .readField(parser, "group", group);
                }
                else if ("new_group_name".equals(fieldName)) {
                    newGroupName = JsonReader.StringReader
                        .readField(parser, "new_group_name", newGroupName);
                }
                else if ("new_group_external_id".equals(fieldName)) {
                    newGroupExternalId = JsonReader.StringReader
                        .readField(parser, "new_group_external_id", newGroupExternalId);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (group == null) {
                throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
            }
            return new GroupUpdateArgs(group, newGroupName, newGroupExternalId);
        }
    };
}
