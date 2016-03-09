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

@JsonSerialize(using=ListTeamDevicesArg.Serializer.class)
@JsonDeserialize(using=ListTeamDevicesArg.Deserializer.class)
class ListTeamDevicesArg {
    // struct ListTeamDevicesArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String cursor;
    protected final boolean includeWebSessions;
    protected final boolean includeDesktopClients;
    protected final boolean includeMobileClients;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#devicesListTeamDevices()} the cursor shouldn't be
     *     passed. Then, if the result of the call includes a cursor, the
     *     following requests should include the received cursors in order to
     *     receive the next sub list of team devices.
     * @param includeWebSessions  Whether to list web sessions of the team
     *     members.
     * @param includeDesktopClients  Whether to list desktop clients of the team
     *     members.
     * @param includeMobileClients  Whether to list mobile clients of the team
     *     members.
     */
    public ListTeamDevicesArg(String cursor, boolean includeWebSessions, boolean includeDesktopClients, boolean includeMobileClients) {
        this.cursor = cursor;
        this.includeWebSessions = includeWebSessions;
        this.includeDesktopClients = includeDesktopClients;
        this.includeMobileClients = includeMobileClients;
    }

    /**
     * The default values for unset fields will be used.
     */
    public ListTeamDevicesArg() {
        this(null, true, true, true);
    }

    /**
     * At the first call to the {@link
     * DbxTeamTeamRequests#devicesListTeamDevices()} the cursor shouldn't be
     * passed. Then, if the result of the call includes a cursor, the following
     * requests should include the received cursors in order to receive the next
     * sub list of team devices
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * Whether to list web sessions of the team members
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeWebSessions() {
        return includeWebSessions;
    }

    /**
     * Whether to list desktop clients of the team members
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeDesktopClients() {
        return includeDesktopClients;
    }

    /**
     * Whether to list mobile clients of the team members
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
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link ListTeamDevicesArg}.
     */
    public static class Builder {

        protected String cursor;
        protected boolean includeWebSessions;
        protected boolean includeDesktopClients;
        protected boolean includeMobileClients;

        protected Builder() {
            this.cursor = null;
            this.includeWebSessions = true;
            this.includeDesktopClients = true;
            this.includeMobileClients = true;
        }

        /**
         * Set value for optional field.
         *
         * @param cursor  At the first call to the {@link
         *     DbxTeamTeamRequests#devicesListTeamDevices()} the cursor
         *     shouldn't be passed. Then, if the result of the call includes a
         *     cursor, the following requests should include the received
         *     cursors in order to receive the next sub list of team devices.
         *
         * @return this builder
         */
        public Builder withCursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param includeWebSessions  Whether to list web sessions of the team
         *     members. Defaults to {@code true} when set to {@code null}.
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
         * @param includeDesktopClients  Whether to list desktop clients of the
         *     team members. Defaults to {@code true} when set to {@code null}.
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
         * @param includeMobileClients  Whether to list mobile clients of the
         *     team members. Defaults to {@code true} when set to {@code null}.
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
         * Builds an instance of {@link ListTeamDevicesArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListTeamDevicesArg}
         */
        public ListTeamDevicesArg build() {
            return new ListTeamDevicesArg(cursor, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor,
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
            ListTeamDevicesArg other = (ListTeamDevicesArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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

    static final class Serializer extends StructJsonSerializer<ListTeamDevicesArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListTeamDevicesArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListTeamDevicesArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListTeamDevicesArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListTeamDevicesArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
            g.writeObjectField("include_web_sessions", value.includeWebSessions);
            g.writeObjectField("include_desktop_clients", value.includeDesktopClients);
            g.writeObjectField("include_mobile_clients", value.includeMobileClients);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListTeamDevicesArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListTeamDevicesArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListTeamDevicesArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListTeamDevicesArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListTeamDevicesArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String cursor = null;
            boolean includeWebSessions = true;
            boolean includeDesktopClients = true;
            boolean includeMobileClients = true;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
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


            return new ListTeamDevicesArg(cursor, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    }
}
