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

public class IncludeMembersArg {
    // struct IncludeMembersArg

    protected final boolean returnMembers;

    /**
     *
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     */
    public IncludeMembersArg(boolean returnMembers) {
        this.returnMembers = returnMembers;
    }

    /**
     * The default values for unset fields will be used.
     */
    public IncludeMembersArg() {
        this(true);
    }

    /**
     * Whether to return the list of members in the group.  Note that the
     * default value will cause all the group members  to be returned in the
     * response. This may take a long time for large groups.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getReturnMembers() {
        return returnMembers;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            returnMembers
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
            IncludeMembersArg other = (IncludeMembersArg) obj;
            return this.returnMembers == other.returnMembers;
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
    static final class Serializer extends StructSerializer<IncludeMembersArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(IncludeMembersArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("return_members");
            StoneSerializers.boolean_().serialize(value.returnMembers, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public IncludeMembersArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            IncludeMembersArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_returnMembers = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("return_members".equals(field)) {
                        f_returnMembers = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new IncludeMembersArg(f_returnMembers);
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
