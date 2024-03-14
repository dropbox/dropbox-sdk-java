/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

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

/**
 * Information on linked applications of a team member.
 */
public class MemberLinkedApps {
    // struct team.MemberLinkedApps (team_linked_apps.stone)

    protected final String teamMemberId;
    protected final List<ApiApp> linkedApiApps;

    /**
     * Information on linked applications of a team member.
     *
     * @param teamMemberId  The member unique Id. Must not be {@code null}.
     * @param linkedApiApps  List of third party applications linked by this
     *     team member. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberLinkedApps(@javax.annotation.Nonnull String teamMemberId, @javax.annotation.Nonnull List<ApiApp> linkedApiApps) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (linkedApiApps == null) {
            throw new IllegalArgumentException("Required value for 'linkedApiApps' is null");
        }
        for (ApiApp x : linkedApiApps) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedApiApps' is null");
            }
        }
        this.linkedApiApps = linkedApiApps;
    }

    /**
     * The member unique Id.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * List of third party applications linked by this team member.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<ApiApp> getLinkedApiApps() {
        return linkedApiApps;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamMemberId,
            linkedApiApps
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
            MemberLinkedApps other = (MemberLinkedApps) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.linkedApiApps == other.linkedApiApps) || (this.linkedApiApps.equals(other.linkedApiApps)))
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
    static class Serializer extends StructSerializer<MemberLinkedApps> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberLinkedApps value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            g.writeFieldName("linked_api_apps");
            StoneSerializers.list(ApiApp.Serializer.INSTANCE).serialize(value.linkedApiApps, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberLinkedApps deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberLinkedApps value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamMemberId = null;
                List<ApiApp> f_linkedApiApps = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("linked_api_apps".equals(field)) {
                        f_linkedApiApps = StoneSerializers.list(ApiApp.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                if (f_linkedApiApps == null) {
                    throw new JsonParseException(p, "Required field \"linked_api_apps\" missing.");
                }
                value = new MemberLinkedApps(f_teamMemberId, f_linkedApiApps);
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
