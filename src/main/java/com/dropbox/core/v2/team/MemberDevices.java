/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Information on devices of a team's member.
 */
public class MemberDevices {
    // struct MemberDevices

    private final String teamMemberId;
    private final List<ActiveWebSession> webSessions;
    private final List<DesktopClientSession> desktopClients;
    private final List<MobileClientSession> mobileClients;

    /**
     * Information on devices of a team's member.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param teamMemberId  The member unique Id. Must not be {@code null}.
     * @param webSessions  List of web sessions made by this team member. Must
     *     not contain a {@code null} item.
     * @param desktopClients  List of desktop clients by this team member. Must
     *     not contain a {@code null} item.
     * @param mobileClients  List of mobile clients by this team member. Must
     *     not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberDevices(String teamMemberId, List<ActiveWebSession> webSessions, List<DesktopClientSession> desktopClients, List<MobileClientSession> mobileClients) {
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        if (webSessions != null) {
            for (ActiveWebSession x : webSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'webSessions' is null");
                }
            }
        }
        this.webSessions = webSessions;
        if (desktopClients != null) {
            for (DesktopClientSession x : desktopClients) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'desktopClients' is null");
                }
            }
        }
        this.desktopClients = desktopClients;
        if (mobileClients != null) {
            for (MobileClientSession x : mobileClients) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'mobileClients' is null");
                }
            }
        }
        this.mobileClients = mobileClients;
    }

    /**
     * Information on devices of a team's member.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamMemberId  The member unique Id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberDevices(String teamMemberId) {
        this(teamMemberId, null, null, null);
    }

    /**
     * The member unique Id
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * List of web sessions made by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<ActiveWebSession> getWebSessions() {
        return webSessions;
    }

    /**
     * List of desktop clients by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<DesktopClientSession> getDesktopClients() {
        return desktopClients;
    }

    /**
     * List of mobile clients by this team member
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<MobileClientSession> getMobileClients() {
        return mobileClients;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param teamMemberId  The member unique Id. Must not be {@code null}.
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
     * Builder for {@link MemberDevices}.
     */
    public static class Builder {
        protected final String teamMemberId;

        protected List<ActiveWebSession> webSessions;
        protected List<DesktopClientSession> desktopClients;
        protected List<MobileClientSession> mobileClients;

        protected Builder(String teamMemberId) {
            if (teamMemberId == null) {
                throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
            }
            this.teamMemberId = teamMemberId;
            this.webSessions = null;
            this.desktopClients = null;
            this.mobileClients = null;
        }

        /**
         * Set value for optional field.
         *
         * @param webSessions  List of web sessions made by this team member.
         *     Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withWebSessions(List<ActiveWebSession> webSessions) {
            if (webSessions != null) {
                for (ActiveWebSession x : webSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'webSessions' is null");
                    }
                }
            }
            this.webSessions = webSessions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param desktopClients  List of desktop clients by this team member.
         *     Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDesktopClients(List<DesktopClientSession> desktopClients) {
            if (desktopClients != null) {
                for (DesktopClientSession x : desktopClients) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'desktopClients' is null");
                    }
                }
            }
            this.desktopClients = desktopClients;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param mobileClients  List of mobile clients by this team member.
         *     Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMobileClients(List<MobileClientSession> mobileClients) {
            if (mobileClients != null) {
                for (MobileClientSession x : mobileClients) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'mobileClients' is null");
                    }
                }
            }
            this.mobileClients = mobileClients;
            return this;
        }

        /**
         * Builds an instance of {@link MemberDevices} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberDevices}
         */
        public MemberDevices build() {
            return new MemberDevices(teamMemberId, webSessions, desktopClients, mobileClients);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            teamMemberId,
            webSessions,
            desktopClients,
            mobileClients
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
            MemberDevices other = (MemberDevices) obj;
            return ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && ((this.webSessions == other.webSessions) || (this.webSessions != null && this.webSessions.equals(other.webSessions)))
                && ((this.desktopClients == other.desktopClients) || (this.desktopClients != null && this.desktopClients.equals(other.desktopClients)))
                && ((this.mobileClients == other.mobileClients) || (this.mobileClients != null && this.mobileClients.equals(other.mobileClients)))
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

    public static MemberDevices fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberDevices> _JSON_WRITER = new JsonWriter<MemberDevices>() {
        public final void write(MemberDevices x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            MemberDevices._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(MemberDevices x, JsonGenerator g) throws IOException {
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
            if (x.webSessions != null) {
                g.writeFieldName("web_sessions");
                g.writeStartArray();
                for (ActiveWebSession item: x.webSessions) {
                    if (item != null) {
                        ActiveWebSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            if (x.desktopClients != null) {
                g.writeFieldName("desktop_clients");
                g.writeStartArray();
                for (DesktopClientSession item: x.desktopClients) {
                    if (item != null) {
                        DesktopClientSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
            if (x.mobileClients != null) {
                g.writeFieldName("mobile_clients");
                g.writeStartArray();
                for (MobileClientSession item: x.mobileClients) {
                    if (item != null) {
                        MobileClientSession._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        }
    };

    public static final JsonReader<MemberDevices> _JSON_READER = new JsonReader<MemberDevices>() {
        public final MemberDevices read(JsonParser parser) throws IOException, JsonReadException {
            MemberDevices result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final MemberDevices readFields(JsonParser parser) throws IOException, JsonReadException {
            String teamMemberId = null;
            List<ActiveWebSession> webSessions = null;
            List<DesktopClientSession> desktopClients = null;
            List<MobileClientSession> mobileClients = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else if ("web_sessions".equals(fieldName)) {
                    webSessions = JsonArrayReader.mk(ActiveWebSession._JSON_READER)
                        .readField(parser, "web_sessions", webSessions);
                }
                else if ("desktop_clients".equals(fieldName)) {
                    desktopClients = JsonArrayReader.mk(DesktopClientSession._JSON_READER)
                        .readField(parser, "desktop_clients", desktopClients);
                }
                else if ("mobile_clients".equals(fieldName)) {
                    mobileClients = JsonArrayReader.mk(MobileClientSession._JSON_READER)
                        .readField(parser, "mobile_clients", mobileClients);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            return new MemberDevices(teamMemberId, webSessions, desktopClients, mobileClients);
        }
    };
}
