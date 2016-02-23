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

public class ListTeamDevicesArg {
    // struct ListTeamDevicesArg

    private final String cursor;
    private final boolean includeWebSessions;
    private final boolean includeDesktopClients;
    private final boolean includeMobileClients;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeam#devicesListTeamDevices()} the cursor shouldn't be passed.
     *     Then, if the result of the call includes a cursor, the following
     *     requests should include the received cursors in order to receive the
     *     next sub list of team devices.
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
     * At the first call to the {@link DbxTeam#devicesListTeamDevices()} the
     * cursor shouldn't be passed. Then, if the result of the call includes a
     * cursor, the following requests should include the received cursors in
     * order to receive the next sub list of team devices
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
         *     DbxTeam#devicesListTeamDevices()} the cursor shouldn't be passed.
         *     Then, if the result of the call includes a cursor, the following
         *     requests should include the received cursors in order to receive
         *     the next sub list of team devices.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListTeamDevicesArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListTeamDevicesArg> _JSON_WRITER = new JsonWriter<ListTeamDevicesArg>() {
        public final void write(ListTeamDevicesArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListTeamDevicesArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListTeamDevicesArg x, JsonGenerator g) throws IOException {
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
            g.writeFieldName("include_web_sessions");
            g.writeBoolean(x.includeWebSessions);
            g.writeFieldName("include_desktop_clients");
            g.writeBoolean(x.includeDesktopClients);
            g.writeFieldName("include_mobile_clients");
            g.writeBoolean(x.includeMobileClients);
        }
    };

    public static final JsonReader<ListTeamDevicesArg> _JSON_READER = new JsonReader<ListTeamDevicesArg>() {
        public final ListTeamDevicesArg read(JsonParser parser) throws IOException, JsonReadException {
            ListTeamDevicesArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListTeamDevicesArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String cursor = null;
            Boolean includeWebSessions = null;
            Boolean includeDesktopClients = null;
            Boolean includeMobileClients = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
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
            return new ListTeamDevicesArg(cursor, includeWebSessions, includeDesktopClients, includeMobileClients);
        }
    };
}
