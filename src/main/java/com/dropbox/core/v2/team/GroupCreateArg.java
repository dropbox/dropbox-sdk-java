/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class GroupCreateArg {
    // struct GroupCreateArg

    protected final String groupName;
    protected final String groupExternalId;

    /**
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param groupExternalId  The creator of a team can associate an arbitrary
     *     external ID to the group.
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
     * The creator of a team can associate an arbitrary external ID to the
     * group.
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
    static final class Serializer extends StructSerializer<GroupCreateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupCreateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_name");
            StoneSerializers.string().serialize(value.groupName, g);
            if (value.groupExternalId != null) {
                g.writeFieldName("group_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.groupExternalId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupCreateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupCreateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_groupName = null;
                String f_groupExternalId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_name".equals(field)) {
                        f_groupName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("group_external_id".equals(field)) {
                        f_groupExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_groupName == null) {
                    throw new JsonParseException(p, "Required field \"group_name\" missing.");
                }
                value = new GroupCreateArg(f_groupName, f_groupExternalId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
