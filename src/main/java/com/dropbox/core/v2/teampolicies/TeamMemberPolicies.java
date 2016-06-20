/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Policies governing team members.
 */
public class TeamMemberPolicies {
    // struct TeamMemberPolicies

    protected final TeamSharingPolicies sharing;
    protected final EmmState emmState;

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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberPolicies(TeamSharingPolicies sharing, EmmState emmState) {
        if (sharing == null) {
            throw new IllegalArgumentException("Required value for 'sharing' is null");
        }
        this.sharing = sharing;
        if (emmState == null) {
            throw new IllegalArgumentException("Required value for 'emmState' is null");
        }
        this.emmState = emmState;
    }

    /**
     * Policies governing sharing.
     *
     * @return value for this field, never {@code null}.
     */
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
    public EmmState getEmmState() {
        return emmState;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            sharing,
            emmState
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
            TeamMemberPolicies other = (TeamMemberPolicies) obj;
            return ((this.sharing == other.sharing) || (this.sharing.equals(other.sharing)))
                && ((this.emmState == other.emmState) || (this.emmState.equals(other.emmState)))
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
    public static final class Serializer extends StructSerializer<TeamMemberPolicies> {
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
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("sharing".equals(field)) {
                        f_sharing = TeamSharingPolicies.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("emm_state".equals(field)) {
                        f_emmState = EmmState.Serializer.INSTANCE.deserialize(p);
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
                value = new TeamMemberPolicies(f_sharing, f_emmState);
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
