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
 * Team merge request reminder details shown to the primary team
 */
public class PrimaryTeamRequestReminderDetails {
    // struct team_log.PrimaryTeamRequestReminderDetails (team_log_generated.stone)

    @Nonnull
    protected final String secondaryTeam;
    @Nonnull
    protected final String sentTo;

    /**
     * Team merge request reminder details shown to the primary team
     *
     * @param secondaryTeam  The secondary team name. Must not be {@code null}.
     * @param sentTo  The name of the primary team admin the request was sent
     *     to. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PrimaryTeamRequestReminderDetails(@Nonnull String secondaryTeam, @Nonnull String sentTo) {
        if (secondaryTeam == null) {
            throw new IllegalArgumentException("Required value for 'secondaryTeam' is null");
        }
        this.secondaryTeam = secondaryTeam;
        if (sentTo == null) {
            throw new IllegalArgumentException("Required value for 'sentTo' is null");
        }
        this.sentTo = sentTo;
    }

    /**
     * The secondary team name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSecondaryTeam() {
        return secondaryTeam;
    }

    /**
     * The name of the primary team admin the request was sent to.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSentTo() {
        return sentTo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            secondaryTeam,
            sentTo
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
            PrimaryTeamRequestReminderDetails other = (PrimaryTeamRequestReminderDetails) obj;
            return ((this.secondaryTeam == other.secondaryTeam) || (this.secondaryTeam.equals(other.secondaryTeam)))
                && ((this.sentTo == other.sentTo) || (this.sentTo.equals(other.sentTo)))
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
    static class Serializer extends StructSerializer<PrimaryTeamRequestReminderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PrimaryTeamRequestReminderDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("secondary_team");
            StoneSerializers.string().serialize(value.secondaryTeam, g);
            g.writeFieldName("sent_to");
            StoneSerializers.string().serialize(value.sentTo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PrimaryTeamRequestReminderDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PrimaryTeamRequestReminderDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_secondaryTeam = null;
                String f_sentTo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("secondary_team".equals(field)) {
                        f_secondaryTeam = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sent_to".equals(field)) {
                        f_sentTo = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_secondaryTeam == null) {
                    throw new JsonParseException(p, "Required field \"secondary_team\" missing.");
                }
                if (f_sentTo == null) {
                    throw new JsonParseException(p, "Required field \"sent_to\" missing.");
                }
                value = new PrimaryTeamRequestReminderDetails(f_secondaryTeam, f_sentTo);
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
