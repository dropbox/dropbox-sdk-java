/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=ListMemberDevicesArg.Serializer.class)
@JsonDeserialize(using=ListMemberDevicesArg.Deserializer.class)
class ListMemberDevicesArg {
    // struct ListMemberDevicesArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListMemberDevicesArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListMemberDevicesArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListMemberDevicesArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListMemberDevicesArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListMemberDevicesArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            g.writeObjectField("include_web_sessions", value.includeWebSessions);
            g.writeObjectField("include_desktop_clients", value.includeDesktopClients);
            g.writeObjectField("include_mobile_clients", value.includeMobileClients);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListMemberDevicesArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListMemberDevicesArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListMemberDevicesArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListMemberDevicesArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListMemberDevicesArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            Boolean includeWebSessions = null;
            Boolean includeDesktopClients = null;
            Boolean includeMobileClients = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("include_web_sessions".equals(_field)) {
                    includeWebSessions = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("include_desktop_clients".equals(_field)) {
                    includeDesktopClients = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("include_mobile_clients".equals(_field)) {
                    includeMobileClients = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }

            return new ListMemberDevicesArg(teamMemberId, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    }
}
