/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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
 * Team name details
 */
public class TeamName {
    // struct team_log.TeamName (team_log_generated.stone)

    protected final String teamDisplayName;
    protected final String teamLegalName;

    /**
     * Team name details
     *
     * @param teamDisplayName  Team's display name. Must not be {@code null}.
     * @param teamLegalName  Team's legal name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamName(@javax.annotation.Nonnull String teamDisplayName, @javax.annotation.Nonnull String teamLegalName) {
        if (teamDisplayName == null) {
            throw new IllegalArgumentException("Required value for 'teamDisplayName' is null");
        }
        this.teamDisplayName = teamDisplayName;
        if (teamLegalName == null) {
            throw new IllegalArgumentException("Required value for 'teamLegalName' is null");
        }
        this.teamLegalName = teamLegalName;
    }

    /**
     * Team's display name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamDisplayName() {
        return teamDisplayName;
    }

    /**
     * Team's legal name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamLegalName() {
        return teamLegalName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamDisplayName,
            teamLegalName
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
            TeamName other = (TeamName) obj;
            return ((this.teamDisplayName == other.teamDisplayName) || (this.teamDisplayName.equals(other.teamDisplayName)))
                && ((this.teamLegalName == other.teamLegalName) || (this.teamLegalName.equals(other.teamLegalName)))
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
    static class Serializer extends StructSerializer<TeamName> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamName value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_display_name");
            StoneSerializers.string().serialize(value.teamDisplayName, g);
            g.writeFieldName("team_legal_name");
            StoneSerializers.string().serialize(value.teamLegalName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamName deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamName value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamDisplayName = null;
                String f_teamLegalName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_display_name".equals(field)) {
                        f_teamDisplayName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_legal_name".equals(field)) {
                        f_teamLegalName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamDisplayName == null) {
                    throw new JsonParseException(p, "Required field \"team_display_name\" missing.");
                }
                if (f_teamLegalName == null) {
                    throw new JsonParseException(p, "Required field \"team_legal_name\" missing.");
                }
                value = new TeamName(f_teamDisplayName, f_teamLegalName);
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
