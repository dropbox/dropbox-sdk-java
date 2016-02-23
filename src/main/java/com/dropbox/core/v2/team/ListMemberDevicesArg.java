/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ListMemberDevicesArg {
    // struct ListMemberDevicesArg

    private final String teamMemberId;
    private final boolean includeWebSessions;
    private final boolean includeDesktopClients;
    private final boolean includeMobileClients;

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
    public ListMemberDevicesArg(String teamMemberId, boolean includeWebSessions, boolean includeDesktopClients, boolean includeMobileClients) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.includeWebSessions = includeWebSessions;
        this.includeDesktopClients = includeDesktopClients;
        this.includeMobileClients = includeMobileClients;
    }

    /**
     * The default values for unset fields will be used.
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
     * The team's member id
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Whether to list web sessions of the team's member
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeWebSessions() {
        return includeWebSessions;
    }

    /**
     * Whether to list linked desktop devices of the team's member
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeDesktopClients() {
        return includeDesktopClients;
    }

    /**
     * Whether to list linked mobile devices of the team's member
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
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListMemberDevicesArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListMemberDevicesArg> _JSON_WRITER = new JsonWriter<ListMemberDevicesArg>() {
        public final void write(ListMemberDevicesArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListMemberDevicesArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListMemberDevicesArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
            g.writeFieldName("include_web_sessions");
            g.writeBoolean(x.includeWebSessions);
            g.writeFieldName("include_desktop_clients");
            g.writeBoolean(x.includeDesktopClients);
            g.writeFieldName("include_mobile_clients");
            g.writeBoolean(x.includeMobileClients);
        }
    };

    public static final JsonReader<ListMemberDevicesArg> _JSON_READER = new JsonReader<ListMemberDevicesArg>() {
        public final ListMemberDevicesArg read(JsonParser parser) throws IOException, JsonReadException {
            ListMemberDevicesArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListMemberDevicesArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            Boolean includeWebSessions = null;
            Boolean includeDesktopClients = null;
            Boolean includeMobileClients = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else if ("include_web_sessions".equals(fieldName)) {
                    includeWebSessions = JsonReader.BooleanReader
                        .readField(parser, "include_web_sessions", includeWebSessions);
                }
                else if ("include_desktop_clients".equals(fieldName)) {
                    includeDesktopClients = JsonReader.BooleanReader
                        .readField(parser, "include_desktop_clients", includeDesktopClients);
                }
                else if ("include_mobile_clients".equals(fieldName)) {
                    includeMobileClients = JsonReader.BooleanReader
                        .readField(parser, "include_mobile_clients", includeMobileClients);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            return new ListMemberDevicesArg(teamMemberId, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    };
}
