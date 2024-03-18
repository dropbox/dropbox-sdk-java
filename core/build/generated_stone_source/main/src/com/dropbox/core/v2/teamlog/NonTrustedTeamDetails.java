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

import javax.annotation.Nonnull;

/**
 * The email to which the request was sent
 */
public class NonTrustedTeamDetails {
    // struct team_log.NonTrustedTeamDetails (team_log_generated.stone)

    @Nonnull
    protected final String team;

    /**
     * The email to which the request was sent
     *
     * @param team  The email to which the request was sent. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public NonTrustedTeamDetails(@Nonnull String team) {
        if (team == null) {
            throw new IllegalArgumentException("Required value for 'team' is null");
        }
        this.team = team;
    }

    /**
     * The email to which the request was sent.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTeam() {
        return team;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            team
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
            NonTrustedTeamDetails other = (NonTrustedTeamDetails) obj;
            return (this.team == other.team) || (this.team.equals(other.team));
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
    static class Serializer extends StructSerializer<NonTrustedTeamDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(NonTrustedTeamDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team");
            StoneSerializers.string().serialize(value.team, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public NonTrustedTeamDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            NonTrustedTeamDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_team = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team".equals(field)) {
                        f_team = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_team == null) {
                    throw new JsonParseException(p, "Required field \"team\" missing.");
                }
                value = new NonTrustedTeamDetails(f_team);
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
