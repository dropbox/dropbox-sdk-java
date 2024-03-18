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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class ListTeamDevicesArg {
    // struct team.ListTeamDevicesArg (team_devices.stone)

    @Nullable
    protected final String cursor;
    protected final boolean includeWebSessions;
    protected final boolean includeDesktopClients;
    protected final boolean includeMobileClients;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#devicesListTeamDevices} the cursor shouldn't be
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
    public ListTeamDevicesArg(@Nullable String cursor, boolean includeWebSessions, boolean includeDesktopClients, boolean includeMobileClients) {
        this.cursor = cursor;
        this.includeWebSessions = includeWebSessions;
        this.includeDesktopClients = includeDesktopClients;
        this.includeMobileClients = includeMobileClients;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListTeamDevicesArg() {
        this(null, true, true, true);
    }

    /**
     * At the first call to the {@link
     * DbxTeamTeamRequests#devicesListTeamDevices} the cursor shouldn't be
     * passed. Then, if the result of the call includes a cursor, the following
     * requests should include the received cursors in order to receive the next
     * sub list of team devices.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    /**
     * Whether to list web sessions of the team members.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeWebSessions() {
        return includeWebSessions;
    }

    /**
     * Whether to list desktop clients of the team members.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getIncludeDesktopClients() {
        return includeDesktopClients;
    }

    /**
     * Whether to list mobile clients of the team members.
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
         *     DbxTeamTeamRequests#devicesListTeamDevices} the cursor shouldn't
         *     be passed. Then, if the result of the call includes a cursor, the
         *     following requests should include the received cursors in order
         *     to receive the next sub list of team devices.
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<ListTeamDevicesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListTeamDevicesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
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
        public ListTeamDevicesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListTeamDevicesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_cursor = null;
                Boolean f_includeWebSessions = true;
                Boolean f_includeDesktopClients = true;
                Boolean f_includeMobileClients = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new ListTeamDevicesArg(f_cursor, f_includeWebSessions, f_includeDesktopClients, f_includeMobileClients);
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
