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
 * Merged another team into this team.
 */
public class TeamMergeFromDetails {
    // struct team_log.TeamMergeFromDetails (team_log_generated.stone)

    protected final String teamName;

    /**
     * Merged another team into this team.
     *
     * @param teamName  The name of the team that was merged into this team.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMergeFromDetails(String teamName) {
        if (teamName == null) {
            throw new IllegalArgumentException("Required value for 'teamName' is null");
        }
        this.teamName = teamName;
    }

    /**
     * The name of the team that was merged into this team.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamName() {
        return teamName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamName
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
            TeamMergeFromDetails other = (TeamMergeFromDetails) obj;
            return (this.teamName == other.teamName) || (this.teamName.equals(other.teamName));
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
    static class Serializer extends StructSerializer<TeamMergeFromDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMergeFromDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_name");
            StoneSerializers.string().serialize(value.teamName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamMergeFromDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamMergeFromDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_name".equals(field)) {
                        f_teamName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamName == null) {
                    throw new JsonParseException(p, "Required field \"team_name\" missing.");
                }
                value = new TeamMergeFromDetails(f_teamName);
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
