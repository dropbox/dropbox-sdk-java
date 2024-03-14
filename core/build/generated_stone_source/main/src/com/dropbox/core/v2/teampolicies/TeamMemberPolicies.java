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

/**
 * Policies governing team members.
 */
public class TeamMemberPolicies {
    // struct team_policies.TeamMemberPolicies (team_policies.stone)

    protected final TeamSharingPolicies sharing;
    protected final EmmState emmState;
    protected final OfficeAddInPolicy officeAddin;
    protected final SuggestMembersPolicy suggestMembersPolicy;

    /**
     * Policies governing team members.
     *
     * @param sharing  Policies governing sharing. Must not be {@code null}.
     * @param emmState  This describes the Enterprise Mobility Management (EMM)
     *     state for this team. This information can be used to understand if an
     *     organization is integrating with a third-party EMM vendor to further
     *     manage and apply restrictions upon the team's Dropbox usage on mobile
     *     devices. This is a new feature and in the future we'll be adding more
     *     new fields and additional documentation. Must not be {@code null}.
     * @param officeAddin  The admin policy around the Dropbox Office Add-In for
     *     this team. Must not be {@code null}.
     * @param suggestMembersPolicy  The team policy on if teammembers are
     *     allowed to suggest users for admins to invite to the team. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberPolicies(@javax.annotation.Nonnull TeamSharingPolicies sharing, @javax.annotation.Nonnull EmmState emmState, @javax.annotation.Nonnull OfficeAddInPolicy officeAddin, @javax.annotation.Nonnull SuggestMembersPolicy suggestMembersPolicy) {
        if (sharing == null) {
            throw new IllegalArgumentException("Required value for 'sharing' is null");
        }
        this.sharing = sharing;
        if (emmState == null) {
            throw new IllegalArgumentException("Required value for 'emmState' is null");
        }
        this.emmState = emmState;
        if (officeAddin == null) {
            throw new IllegalArgumentException("Required value for 'officeAddin' is null");
        }
        this.officeAddin = officeAddin;
        if (suggestMembersPolicy == null) {
            throw new IllegalArgumentException("Required value for 'suggestMembersPolicy' is null");
        }
        this.suggestMembersPolicy = suggestMembersPolicy;
    }

    /**
     * Policies governing sharing.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamSharingPolicies getSharing() {
        return sharing;
    }

    /**
     * This describes the Enterprise Mobility Management (EMM) state for this
     * team. This information can be used to understand if an organization is
     * integrating with a third-party EMM vendor to further manage and apply
     * restrictions upon the team's Dropbox usage on mobile devices. This is a
     * new feature and in the future we'll be adding more new fields and
     * additional documentation.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public EmmState getEmmState() {
        return emmState;
    }

    /**
     * The admin policy around the Dropbox Office Add-In for this team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public OfficeAddInPolicy getOfficeAddin() {
        return officeAddin;
    }

    /**
     * The team policy on if teammembers are allowed to suggest users for admins
     * to invite to the team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public SuggestMembersPolicy getSuggestMembersPolicy() {
        return suggestMembersPolicy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharing,
            emmState,
            officeAddin,
            suggestMembersPolicy
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
            TeamMemberPolicies other = (TeamMemberPolicies) obj;
            return ((this.sharing == other.sharing) || (this.sharing.equals(other.sharing)))
                && ((this.emmState == other.emmState) || (this.emmState.equals(other.emmState)))
                && ((this.officeAddin == other.officeAddin) || (this.officeAddin.equals(other.officeAddin)))
                && ((this.suggestMembersPolicy == other.suggestMembersPolicy) || (this.suggestMembersPolicy.equals(other.suggestMembersPolicy)))
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
    public static class Serializer extends StructSerializer<TeamMemberPolicies> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberPolicies value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("sharing");
            TeamSharingPolicies.Serializer.INSTANCE.serialize(value.sharing, g);
            g.writeFieldName("emm_state");
            EmmState.Serializer.INSTANCE.serialize(value.emmState, g);
            g.writeFieldName("office_addin");
            OfficeAddInPolicy.Serializer.INSTANCE.serialize(value.officeAddin, g);
            g.writeFieldName("suggest_members_policy");
            SuggestMembersPolicy.Serializer.INSTANCE.serialize(value.suggestMembersPolicy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMemberPolicies deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMemberPolicies value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TeamSharingPolicies f_sharing = null;
                EmmState f_emmState = null;
                OfficeAddInPolicy f_officeAddin = null;
                SuggestMembersPolicy f_suggestMembersPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("sharing".equals(field)) {
                        f_sharing = TeamSharingPolicies.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("emm_state".equals(field)) {
                        f_emmState = EmmState.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("office_addin".equals(field)) {
                        f_officeAddin = OfficeAddInPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("suggest_members_policy".equals(field)) {
                        f_suggestMembersPolicy = SuggestMembersPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharing == null) {
                    throw new JsonParseException(p, "Required field \"sharing\" missing.");
                }
                if (f_emmState == null) {
                    throw new JsonParseException(p, "Required field \"emm_state\" missing.");
                }
                if (f_officeAddin == null) {
                    throw new JsonParseException(p, "Required field \"office_addin\" missing.");
                }
                if (f_suggestMembersPolicy == null) {
                    throw new JsonParseException(p, "Required field \"suggest_members_policy\" missing.");
                }
                value = new TeamMemberPolicies(f_sharing, f_emmState, f_officeAddin, f_suggestMembersPolicy);
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
