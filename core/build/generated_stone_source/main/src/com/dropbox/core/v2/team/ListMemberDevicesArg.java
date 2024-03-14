/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

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

class ListMemberDevicesArg {
    // struct team.ListMemberDevicesArg (team_devices.stone)

    protected final String teamMemberId;
    protected final boolean includeWebSessions;
    protected final boolean includeDesktopClients;
    protected final boolean includeMobileClients;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param teamMemberId  The team's member id. Must not be {@code null}.
     * @param includeWebSessions  Whether to list web sessions of the team's
     *     member.
     * @param includeDesktopClients  Whether to list linked desktop devices of
     *     the team's member.
     * @param includeMobileClients  Whether to list linked mobile devices of the
     *     team's member.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberDevicesArg(@javax.annotation.Nonnull String teamMemberId, boolean includeWebSessions, boolean includeDesktopClients, boolean includeMobileClients) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.includeWebSessions = includeWebSessions;
        this.includeDesktopClients = includeDesktopClients;
        this.includeMobileClients = includeMobileClients;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamMemberId  The team's member id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberDevicesArg(String teamMemberId) {
        this(teamMemberId, true, true, true);
    }

    /**
     * The team's member id.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Whether to list web sessions of the team's member.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeWebSessions() {
        return includeWebSessions;
    }

    /**
     * Whether to list linked desktop devices of the team's member.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeDesktopClients() {
        return includeDesktopClients;
    }

    /**
     * Whether to list linked mobile devices of the team's member.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeMobileClients() {
        return includeMobileClients;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param teamMemberId  The team's member id. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String teamMemberId) {
        return new Builder(teamMemberId);
    }

    /**
     * Builder for {@link ListMemberDevicesArg}.
     */
    public static class Builder {
        protected final String teamMemberId;

        protected boolean includeWebSessions;
        protected boolean includeDesktopClients;
        protected boolean includeMobileClients;

        protected Builder(String teamMemberId) {
            if (teamMemberId == null) {
                throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
            }
            this.teamMemberId = teamMemberId;
            this.includeWebSessions = true;
            this.includeDesktopClients = true;
            this.includeMobileClients = true;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeWebSessions  Whether to list web sessions of the team's
         *     member. Defaults to {@code true} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withIncludeWebSessions(Boolean includeWebSessions) {
            if (includeWebSessions != null) {
                this.includeWebSessions = includeWebSessions;
            }
            else {
                this.includeWebSessions = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeDesktopClients  Whether to list linked desktop devices
         *     of the team's member. Defaults to {@code true} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withIncludeDesktopClients(Boolean includeDesktopClients) {
            if (includeDesktopClients != null) {
                this.includeDesktopClients = includeDesktopClients;
            }
            else {
                this.includeDesktopClients = true;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeMobileClients  Whether to list linked mobile devices of
         *     the team's member. Defaults to {@code true} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withIncludeMobileClients(Boolean includeMobileClients) {
            if (includeMobileClients != null) {
                this.includeMobileClients = includeMobileClients;
            }
            else {
                this.includeMobileClients = true;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ListMemberDevicesArg} configured with
         * this builder's values
         *
         * @return new instance of {@link ListMemberDevicesArg}
         */
        public ListMemberDevicesArg build() {
            return new ListMemberDevicesArg(teamMemberId, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamMemberId,
            includeWebSessions,
            includeDesktopClients,
            includeMobileClients
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
            ListMemberDevicesArg other = (ListMemberDevicesArg) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && (this.includeWebSessions == other.includeWebSessions)
                && (this.includeDesktopClients == other.includeDesktopClients)
                && (this.includeMobileClients == other.includeMobileClients)
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
    static class Serializer extends StructSerializer<ListMemberDevicesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMemberDevicesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            g.writeFieldName("include_web_sessions");
            StoneSerializers.boolean_().serialize(value.includeWebSessions, g);
            g.writeFieldName("include_desktop_clients");
            StoneSerializers.boolean_().serialize(value.includeDesktopClients, g);
            g.writeFieldName("include_mobile_clients");
            StoneSerializers.boolean_().serialize(value.includeMobileClients, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListMemberDevicesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListMemberDevicesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamMemberId = null;
                Boolean f_includeWebSessions = true;
                Boolean f_includeDesktopClients = true;
                Boolean f_includeMobileClients = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("include_web_sessions".equals(field)) {
                        f_includeWebSessions = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_desktop_clients".equals(field)) {
                        f_includeDesktopClients = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("include_mobile_clients".equals(field)) {
                        f_includeMobileClients = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                value = new ListMemberDevicesArg(f_teamMemberId, f_includeWebSessions, f_includeDesktopClients, f_includeMobileClients);
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
