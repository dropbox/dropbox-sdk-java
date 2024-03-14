/* DO NOT EDIT */
/* This file was generated from team_members.stone */

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
import java.util.List;

public class MembersListV2Result {
    // struct team.MembersListV2Result (team_members.stone)

    protected final List<TeamMemberInfoV2> members;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#membersListContinueV2(String)} to obtain the
     *     additional members. Must not be {@code null}.
     * @param hasMore  Is true if there are additional team members that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#membersListContinueV2(String)} can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListV2Result(List<TeamMemberInfoV2> members, String cursor, boolean hasMore) {
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (TeamMemberInfoV2 x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of team members.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<TeamMemberInfoV2> getMembers() {
        return members;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#membersListContinueV2(String)} to obtain the
     * additional members.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional team members that have not been returned
     * yet. An additional call to {@link
     * DbxTeamTeamRequests#membersListContinueV2(String)} can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            members,
            cursor,
            hasMore
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
            MembersListV2Result other = (MembersListV2Result) obj;
            return ((this.members == other.members) || (this.members.equals(other.members)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<MembersListV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersListV2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("members");
            StoneSerializers.list(TeamMemberInfoV2.Serializer.INSTANCE).serialize(value.members, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersListV2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersListV2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<TeamMemberInfoV2> f_members = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("members".equals(field)) {
                        f_members = StoneSerializers.list(TeamMemberInfoV2.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_members == null) {
                    throw new JsonParseException(p, "Required field \"members\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new MembersListV2Result(f_members, f_cursor, f_hasMore);
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
