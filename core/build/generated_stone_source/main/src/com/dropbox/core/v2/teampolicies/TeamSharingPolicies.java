/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

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

import javax.annotation.Nonnull;

/**
 * Policies governing sharing within and outside of the team.
 */
public class TeamSharingPolicies {
    // struct team_policies.TeamSharingPolicies (team_policies.stone)

    protected final SharedFolderMemberPolicy sharedFolderMemberPolicy;
    protected final SharedFolderJoinPolicy sharedFolderJoinPolicy;
    protected final SharedLinkCreatePolicy sharedLinkCreatePolicy;
    protected final GroupCreation groupCreationPolicy;
    protected final SharedFolderBlanketLinkRestrictionPolicy sharedFolderLinkRestrictionPolicy;

    /**
     * Policies governing sharing within and outside of the team.
     *
     * @param sharedFolderMemberPolicy  Who can join folders shared by team
     *     members. Must not be {@code null}.
     * @param sharedFolderJoinPolicy  Which shared folders team members can
     *     join. Must not be {@code null}.
     * @param sharedLinkCreatePolicy  Who can view shared links owned by team
     *     members. Must not be {@code null}.
     * @param groupCreationPolicy  Who can create groups. Must not be {@code
     *     null}.
     * @param sharedFolderLinkRestrictionPolicy  Who can view links to content
     *     in shared folders. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamSharingPolicies(@Nonnull SharedFolderMemberPolicy sharedFolderMemberPolicy, @Nonnull SharedFolderJoinPolicy sharedFolderJoinPolicy, @Nonnull SharedLinkCreatePolicy sharedLinkCreatePolicy, @Nonnull GroupCreation groupCreationPolicy, @Nonnull SharedFolderBlanketLinkRestrictionPolicy sharedFolderLinkRestrictionPolicy) {
        if (sharedFolderMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderMemberPolicy' is null");
        }
        this.sharedFolderMemberPolicy = sharedFolderMemberPolicy;
        if (sharedFolderJoinPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderJoinPolicy' is null");
        }
        this.sharedFolderJoinPolicy = sharedFolderJoinPolicy;
        if (sharedLinkCreatePolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedLinkCreatePolicy' is null");
        }
        this.sharedLinkCreatePolicy = sharedLinkCreatePolicy;
        if (groupCreationPolicy == null) {
            throw new IllegalArgumentException("Required value for 'groupCreationPolicy' is null");
        }
        this.groupCreationPolicy = groupCreationPolicy;
        if (sharedFolderLinkRestrictionPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderLinkRestrictionPolicy' is null");
        }
        this.sharedFolderLinkRestrictionPolicy = sharedFolderLinkRestrictionPolicy;
    }

    /**
     * Who can join folders shared by team members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedFolderMemberPolicy getSharedFolderMemberPolicy() {
        return sharedFolderMemberPolicy;
    }

    /**
     * Which shared folders team members can join.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedFolderJoinPolicy getSharedFolderJoinPolicy() {
        return sharedFolderJoinPolicy;
    }

    /**
     * Who can view shared links owned by team members.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedLinkCreatePolicy getSharedLinkCreatePolicy() {
        return sharedLinkCreatePolicy;
    }

    /**
     * Who can create groups.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public GroupCreation getGroupCreationPolicy() {
        return groupCreationPolicy;
    }

    /**
     * Who can view links to content in shared folders.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SharedFolderBlanketLinkRestrictionPolicy getSharedFolderLinkRestrictionPolicy() {
        return sharedFolderLinkRestrictionPolicy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharedFolderMemberPolicy,
            sharedFolderJoinPolicy,
            sharedLinkCreatePolicy,
            groupCreationPolicy,
            sharedFolderLinkRestrictionPolicy
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
            TeamSharingPolicies other = (TeamSharingPolicies) obj;
            return ((this.sharedFolderMemberPolicy == other.sharedFolderMemberPolicy) || (this.sharedFolderMemberPolicy.equals(other.sharedFolderMemberPolicy)))
                && ((this.sharedFolderJoinPolicy == other.sharedFolderJoinPolicy) || (this.sharedFolderJoinPolicy.equals(other.sharedFolderJoinPolicy)))
                && ((this.sharedLinkCreatePolicy == other.sharedLinkCreatePolicy) || (this.sharedLinkCreatePolicy.equals(other.sharedLinkCreatePolicy)))
                && ((this.groupCreationPolicy == other.groupCreationPolicy) || (this.groupCreationPolicy.equals(other.groupCreationPolicy)))
                && ((this.sharedFolderLinkRestrictionPolicy == other.sharedFolderLinkRestrictionPolicy) || (this.sharedFolderLinkRestrictionPolicy.equals(other.sharedFolderLinkRestrictionPolicy)))
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
    public static class Serializer extends StructSerializer<TeamSharingPolicies> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamSharingPolicies value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_folder_member_policy");
            SharedFolderMemberPolicy.Serializer.INSTANCE.serialize(value.sharedFolderMemberPolicy, g);
            g.writeFieldName("shared_folder_join_policy");
            SharedFolderJoinPolicy.Serializer.INSTANCE.serialize(value.sharedFolderJoinPolicy, g);
            g.writeFieldName("shared_link_create_policy");
            SharedLinkCreatePolicy.Serializer.INSTANCE.serialize(value.sharedLinkCreatePolicy, g);
            g.writeFieldName("group_creation_policy");
            GroupCreation.Serializer.INSTANCE.serialize(value.groupCreationPolicy, g);
            g.writeFieldName("shared_folder_link_restriction_policy");
            SharedFolderBlanketLinkRestrictionPolicy.Serializer.INSTANCE.serialize(value.sharedFolderLinkRestrictionPolicy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamSharingPolicies deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamSharingPolicies value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharedFolderMemberPolicy f_sharedFolderMemberPolicy = null;
                SharedFolderJoinPolicy f_sharedFolderJoinPolicy = null;
                SharedLinkCreatePolicy f_sharedLinkCreatePolicy = null;
                GroupCreation f_groupCreationPolicy = null;
                SharedFolderBlanketLinkRestrictionPolicy f_sharedFolderLinkRestrictionPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_folder_member_policy".equals(field)) {
                        f_sharedFolderMemberPolicy = SharedFolderMemberPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_folder_join_policy".equals(field)) {
                        f_sharedFolderJoinPolicy = SharedFolderJoinPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_link_create_policy".equals(field)) {
                        f_sharedLinkCreatePolicy = SharedLinkCreatePolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("group_creation_policy".equals(field)) {
                        f_groupCreationPolicy = GroupCreation.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_folder_link_restriction_policy".equals(field)) {
                        f_sharedFolderLinkRestrictionPolicy = SharedFolderBlanketLinkRestrictionPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedFolderMemberPolicy == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_member_policy\" missing.");
                }
                if (f_sharedFolderJoinPolicy == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_join_policy\" missing.");
                }
                if (f_sharedLinkCreatePolicy == null) {
                    throw new JsonParseException(p, "Required field \"shared_link_create_policy\" missing.");
                }
                if (f_groupCreationPolicy == null) {
                    throw new JsonParseException(p, "Required field \"group_creation_policy\" missing.");
                }
                if (f_sharedFolderLinkRestrictionPolicy == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_link_restriction_policy\" missing.");
                }
                value = new TeamSharingPolicies(f_sharedFolderMemberPolicy, f_sharedFolderJoinPolicy, f_sharedLinkCreatePolicy, f_groupCreationPolicy, f_sharedFolderLinkRestrictionPolicy);
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
