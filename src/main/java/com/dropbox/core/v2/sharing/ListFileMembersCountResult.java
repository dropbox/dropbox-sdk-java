/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListFileMembersCountResult {
    // struct ListFileMembersCountResult

    protected final SharedFileMembers members;
    protected final long memberCount;

    /**
     *
     * @param members  A list of members on this file. Must not be {@code null}.
     * @param memberCount  The number of members on this file. This does not
     *     include inherited members.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersCountResult(SharedFileMembers members, long memberCount) {
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        this.members = members;
        this.memberCount = memberCount;
    }

    /**
     * A list of members on this file.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedFileMembers getMembers() {
        return members;
    }

    /**
     * The number of members on this file. This does not include inherited
     * members
     *
     * @return value for this field.
     */
    public long getMemberCount() {
        return memberCount;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            members,
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
            ListFileMembersCountResult other = (ListFileMembersCountResult) obj;
            return ((this.members == other.members) || (this.members.equals(other.members)))
                && (this.memberCount == other.memberCount)
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
    static final class Serializer extends StructSerializer<ListFileMembersCountResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListFileMembersCountResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("members");
            SharedFileMembers.Serializer.INSTANCE.serialize(value.members, g);
            g.writeFieldName("member_count");
            StoneSerializers.uInt32().serialize(value.memberCount, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListFileMembersCountResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListFileMembersCountResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharedFileMembers f_members = null;
                Long f_memberCount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("members".equals(field)) {
                        f_members = SharedFileMembers.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("member_count".equals(field)) {
                        f_memberCount = StoneSerializers.uInt32().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                if (f_memberCount == null) {
                    throw new JsonParseException(p, "Required field \"member_count\" missing.");
                }
                value = new ListFileMembersCountResult(f_members, f_memberCount);
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
