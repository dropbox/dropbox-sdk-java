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

/**
 * Information about a team member, after the change, like at {@link
 * DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
 */
public class TeamMemberInfoV2Result {
    // struct team.TeamMemberInfoV2Result (team_members.stone)

    protected final TeamMemberInfoV2 memberInfo;

    /**
     * Information about a team member, after the change, like at {@link
     * DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     *
     * @param memberInfo  Member info, after the change. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2Result(TeamMemberInfoV2 memberInfo) {
        if (memberInfo == null) {
            throw new IllegalArgumentException("Required value for 'memberInfo' is null");
        }
        this.memberInfo = memberInfo;
    }

    /**
     * Member info, after the change.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamMemberInfoV2 getMemberInfo() {
        return memberInfo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            memberInfo
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
            TeamMemberInfoV2Result other = (TeamMemberInfoV2Result) obj;
            return (this.memberInfo == other.memberInfo) || (this.memberInfo.equals(other.memberInfo));
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
    static class Serializer extends StructSerializer<TeamMemberInfoV2Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberInfoV2Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("member_info");
            TeamMemberInfoV2.Serializer.INSTANCE.serialize(value.memberInfo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberInfoV2Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberInfoV2Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamMemberInfoV2 f_memberInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("member_info".equals(field)) {
                        f_memberInfo = TeamMemberInfoV2.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_memberInfo == null) {
                    throw new JsonParseException(p, "Required field \"member_info\" missing.");
                }
                value = new TeamMemberInfoV2Result(f_memberInfo);
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
