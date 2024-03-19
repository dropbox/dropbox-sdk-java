/* DO NOT EDIT */
/* This file was generated from team_legal_holds.stone */

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

import javax.annotation.Nonnull;

public class MembersInfo {
    // struct team.MembersInfo (team_legal_holds.stone)

    @Nonnull
    protected final List<String> teamMemberIds;
    protected final long permanentlyDeletedUsers;

    /**
     *
     * @param teamMemberIds  Team member IDs of the users under this hold. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param permanentlyDeletedUsers  The number of permanently deleted users
     *     that were under this hold.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersInfo(@Nonnull List<String> teamMemberIds, long permanentlyDeletedUsers) {
        if (teamMemberIds == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberIds' is null");
        }
        for (String x : teamMemberIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'teamMemberIds' is null");
            }
        }
        this.teamMemberIds = teamMemberIds;
        this.permanentlyDeletedUsers = permanentlyDeletedUsers;
    }

    /**
     * Team member IDs of the users under this hold.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getTeamMemberIds() {
        return teamMemberIds;
    }

    /**
     * The number of permanently deleted users that were under this hold.
     *
     * @return value for this field.
     */
    public long getPermanentlyDeletedUsers() {
        return permanentlyDeletedUsers;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamMemberIds,
            permanentlyDeletedUsers
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
            MembersInfo other = (MembersInfo) obj;
            return ((this.teamMemberIds == other.teamMemberIds) || (this.teamMemberIds.equals(other.teamMemberIds)))
                && (this.permanentlyDeletedUsers == other.permanentlyDeletedUsers)
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
    static class Serializer extends StructSerializer<MembersInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.teamMemberIds, g);
            g.writeFieldName("permanently_deleted_users");
            StoneSerializers.uInt64().serialize(value.permanentlyDeletedUsers, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MembersInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MembersInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_teamMemberIds = null;
                Long f_permanentlyDeletedUsers = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_ids".equals(field)) {
                        f_teamMemberIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("permanently_deleted_users".equals(field)) {
                        f_permanentlyDeletedUsers = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberIds == null) {
                    throw new JsonParseException(p, "Required field \"team_member_ids\" missing.");
                }
                if (f_permanentlyDeletedUsers == null) {
                    throw new JsonParseException(p, "Required field \"permanently_deleted_users\" missing.");
                }
                value = new MembersInfo(f_teamMemberIds, f_permanentlyDeletedUsers);
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
