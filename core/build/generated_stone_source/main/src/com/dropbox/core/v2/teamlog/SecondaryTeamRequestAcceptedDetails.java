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
 * Team merge request acceptance details shown to the secondary team
 */
public class SecondaryTeamRequestAcceptedDetails {
    // struct team_log.SecondaryTeamRequestAcceptedDetails (team_log_generated.stone)

    protected final String primaryTeam;
    protected final String sentBy;

    /**
     * Team merge request acceptance details shown to the secondary team
     *
     * @param primaryTeam  The primary team name. Must not be {@code null}.
     * @param sentBy  The name of the secondary team admin who sent the request
     *     originally. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SecondaryTeamRequestAcceptedDetails(@Nonnull String primaryTeam, @Nonnull String sentBy) {
        if (primaryTeam == null) {
            throw new IllegalArgumentException("Required value for 'primaryTeam' is null");
        }
        this.primaryTeam = primaryTeam;
        if (sentBy == null) {
            throw new IllegalArgumentException("Required value for 'sentBy' is null");
        }
        this.sentBy = sentBy;
    }

    /**
     * The primary team name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPrimaryTeam() {
        return primaryTeam;
    }

    /**
     * The name of the secondary team admin who sent the request originally.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSentBy() {
        return sentBy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            primaryTeam,
            sentBy
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
            SecondaryTeamRequestAcceptedDetails other = (SecondaryTeamRequestAcceptedDetails) obj;
            return ((this.primaryTeam == other.primaryTeam) || (this.primaryTeam.equals(other.primaryTeam)))
                && ((this.sentBy == other.sentBy) || (this.sentBy.equals(other.sentBy)))
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
    static class Serializer extends StructSerializer<SecondaryTeamRequestAcceptedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SecondaryTeamRequestAcceptedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("primary_team");
            StoneSerializers.string().serialize(value.primaryTeam, g);
            g.writeFieldName("sent_by");
            StoneSerializers.string().serialize(value.sentBy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SecondaryTeamRequestAcceptedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SecondaryTeamRequestAcceptedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_primaryTeam = null;
                String f_sentBy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("primary_team".equals(field)) {
                        f_primaryTeam = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sent_by".equals(field)) {
                        f_sentBy = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_primaryTeam == null) {
                    throw new JsonParseException(p, "Required field \"primary_team\" missing.");
                }
                if (f_sentBy == null) {
                    throw new JsonParseException(p, "Required field \"sent_by\" missing.");
                }
                value = new SecondaryTeamRequestAcceptedDetails(f_primaryTeam, f_sentBy);
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
