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

/**
 * Result returned by {@link
 * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,java.util.List,boolean)}
 * and {@link
 * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,java.util.List,boolean)}.
 */
public class GroupMembersChangeResult {
    // struct team.GroupMembersChangeResult (team_groups.stone)

    protected final GroupFullInfo groupInfo;
    protected final String asyncJobId;

    /**
     * Result returned by {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,java.util.List,boolean)}
     * and {@link
     * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,java.util.List,boolean)}.
     *
     * @param groupInfo  The group info after member change operation has been
     *     performed. Must not be {@code null}.
     * @param asyncJobId  For legacy purposes async_job_id will always return
     *     one space ' '. Formerly, it was an ID that was used to obtain the
     *     status of granting/revoking group-owned resources. It's no longer
     *     necessary because the async processing now happens automatically.
     *     Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult(GroupFullInfo groupInfo, String asyncJobId) {
        if (groupInfo == null) {
            throw new IllegalArgumentException("Required value for 'groupInfo' is null");
        }
        this.groupInfo = groupInfo;
        if (asyncJobId == null) {
            throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
        }
        if (asyncJobId.length() < 1) {
            throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
        }
        this.asyncJobId = asyncJobId;
    }

    /**
     * The group info after member change operation has been performed.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupFullInfo getGroupInfo() {
        return groupInfo;
    }

    /**
     * For legacy purposes async_job_id will always return one space ' '.
     * Formerly, it was an ID that was used to obtain the status of
     * granting/revoking group-owned resources. It's no longer necessary because
     * the async processing now happens automatically.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAsyncJobId() {
        return asyncJobId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            groupInfo,
            asyncJobId
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
            GroupMembersChangeResult other = (GroupMembersChangeResult) obj;
            return ((this.groupInfo == other.groupInfo) || (this.groupInfo.equals(other.groupInfo)))
                && ((this.asyncJobId == other.asyncJobId) || (this.asyncJobId.equals(other.asyncJobId)))
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
    static class Serializer extends StructSerializer<GroupMembersChangeResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersChangeResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("group_info");
            GroupFullInfo.Serializer.INSTANCE.serialize(value.groupInfo, g);
            g.writeFieldName("async_job_id");
            StoneSerializers.string().serialize(value.asyncJobId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GroupMembersChangeResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GroupMembersChangeResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                GroupFullInfo f_groupInfo = null;
                String f_asyncJobId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("group_info".equals(field)) {
                        f_groupInfo = GroupFullInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("async_job_id".equals(field)) {
                        f_asyncJobId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_groupInfo == null) {
                    throw new JsonParseException(p, "Required field \"group_info\" missing.");
                }
                if (f_asyncJobId == null) {
                    throw new JsonParseException(p, "Required field \"async_job_id\" missing.");
                }
                value = new GroupMembersChangeResult(f_groupInfo, f_asyncJobId);
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
