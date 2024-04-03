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

/**
 * Changed manager permissions of group member.
 */
public class GroupChangeMemberRoleDetails {
    // struct team_log.GroupChangeMemberRoleDetails (team_log_generated.stone)

    protected final boolean isGroupOwner;

    /**
     * Changed manager permissions of group member.
     *
     * @param isGroupOwner  Is group owner.
     */
    public GroupChangeMemberRoleDetails(boolean isGroupOwner) {
        this.isGroupOwner = isGroupOwner;
    }

    /**
     * Is group owner.
     *
     * @return value for this field.
     */
    public boolean getIsGroupOwner() {
        return isGroupOwner;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.isGroupOwner
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
            GroupChangeMemberRoleDetails other = (GroupChangeMemberRoleDetails) obj;
            return this.isGroupOwner == other.isGroupOwner;
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
    static class Serializer extends StructSerializer<GroupChangeMemberRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupChangeMemberRoleDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_group_owner");
            StoneSerializers.boolean_().serialize(value.isGroupOwner, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupChangeMemberRoleDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupChangeMemberRoleDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isGroupOwner = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_group_owner".equals(field)) {
                        f_isGroupOwner = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isGroupOwner == null) {
                    throw new JsonParseException(p, "Required field \"is_group_owner\" missing.");
                }
                value = new GroupChangeMemberRoleDetails(f_isGroupOwner);
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
