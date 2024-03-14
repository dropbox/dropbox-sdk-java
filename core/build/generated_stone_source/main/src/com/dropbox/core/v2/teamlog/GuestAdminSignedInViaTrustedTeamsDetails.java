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
 * Started trusted team admin session.
 */
public class GuestAdminSignedInViaTrustedTeamsDetails {
    // struct team_log.GuestAdminSignedInViaTrustedTeamsDetails (team_log_generated.stone)

    protected final String teamName;
    protected final String trustedTeamName;

    /**
     * Started trusted team admin session.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param teamName  Host team name.
     * @param trustedTeamName  Trusted team name.
     */
    public GuestAdminSignedInViaTrustedTeamsDetails(@javax.annotation.Nullable String teamName, @javax.annotation.Nullable String trustedTeamName) {
        this.teamName = teamName;
        this.trustedTeamName = trustedTeamName;
    }

    /**
     * Started trusted team admin session.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public GuestAdminSignedInViaTrustedTeamsDetails() {
        this(null, null);
    }

    /**
     * Host team name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getTeamName() {
        return teamName;
    }

    /**
     * Trusted team name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getTrustedTeamName() {
        return trustedTeamName;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link GuestAdminSignedInViaTrustedTeamsDetails}.
     */
    public static class Builder {

        protected String teamName;
        protected String trustedTeamName;

        protected Builder() {
            this.teamName = null;
            this.trustedTeamName = null;
        }

        /**
         * Set value for optional field.
         *
         * @param teamName  Host team name.
         *
         * @return this builder
         */
        public Builder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param trustedTeamName  Trusted team name.
         *
         * @return this builder
         */
        public Builder withTrustedTeamName(String trustedTeamName) {
            this.trustedTeamName = trustedTeamName;
            return this;
        }

        /**
         * Builds an instance of {@link
         * GuestAdminSignedInViaTrustedTeamsDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link
         *     GuestAdminSignedInViaTrustedTeamsDetails}
         */
        public GuestAdminSignedInViaTrustedTeamsDetails build() {
            return new GuestAdminSignedInViaTrustedTeamsDetails(teamName, trustedTeamName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamName,
            trustedTeamName
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
            GuestAdminSignedInViaTrustedTeamsDetails other = (GuestAdminSignedInViaTrustedTeamsDetails) obj;
            return ((this.teamName == other.teamName) || (this.teamName != null && this.teamName.equals(other.teamName)))
                && ((this.trustedTeamName == other.trustedTeamName) || (this.trustedTeamName != null && this.trustedTeamName.equals(other.trustedTeamName)))
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
    static class Serializer extends StructSerializer<GuestAdminSignedInViaTrustedTeamsDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GuestAdminSignedInViaTrustedTeamsDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.teamName != null) {
                g.writeFieldName("team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.teamName, g);
            }
            if (value.trustedTeamName != null) {
                g.writeFieldName("trusted_team_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.trustedTeamName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GuestAdminSignedInViaTrustedTeamsDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GuestAdminSignedInViaTrustedTeamsDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamName = null;
                String f_trustedTeamName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_name".equals(field)) {
                        f_teamName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("trusted_team_name".equals(field)) {
                        f_trustedTeamName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new GuestAdminSignedInViaTrustedTeamsDetails(f_teamName, f_trustedTeamName);
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
