/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

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

class GroupsMembersListArg {
    // struct team.GroupsMembersListArg (team_groups.stone)

    protected final GroupSelector group;
    protected final long limit;

    /**
     *
     * @param group  The group whose members are to be listed. Must not be
     *     {@code null}.
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsMembersListArg(@javax.annotation.Nonnull GroupSelector group, long limit) {
        if (group == null) {
            throw new IllegalArgumentException("Required value for 'group' is null");
        }
        this.group = group;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        this.limit = limit;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param group  The group whose members are to be listed. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsMembersListArg(GroupSelector group) {
        this(group, 1000L);
    }

    /**
     * The group whose members are to be listed.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public GroupSelector getGroup() {
        return group;
    }

    /**
     * Number of results to return per call.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     1000L.
     */
    public long getLimit() {
        return limit;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            group,
            limit
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
            GroupsMembersListArg other = (GroupsMembersListArg) obj;
            return ((this.group == other.group) || (this.group.equals(other.group)))
                && (this.limit == other.limit)
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
    static class Serializer extends StructSerializer<GroupsMembersListArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupsMembersListArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group");
            GroupSelector.Serializer.INSTANCE.serialize(value.group, g);
            g.writeFieldName("limit");
            StoneSerializers.uInt32().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupsMembersListArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupsMembersListArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupSelector f_group = null;
                Long f_limit = 1000L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group".equals(field)) {
                        f_group = GroupSelector.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_group == null) {
                    throw new JsonParseException(p, "Required field \"group\" missing.");
                }
                value = new GroupsMembersListArg(f_group, f_limit);
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
