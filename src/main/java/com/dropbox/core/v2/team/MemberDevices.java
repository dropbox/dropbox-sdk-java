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
import java.util.List;

/**
 * Information on devices of a team's member.
 */
@JsonSerialize(using=MemberDevices.Serializer.class)
@JsonDeserialize(using=MemberDevices.Deserializer.class)
public class MemberDevices {
    // struct MemberDevices

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String teamMemberId;
    protected final List<ActiveWebSession> webSessions;
    protected final List<DesktopClientSession> desktopClients;
    protected final List<MobileClientSession> mobileClients;

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

    static final class Serializer extends StructJsonSerializer<MemberDevices> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberDevices.class);
        }

        public Serializer(boolean unwrapping) {
            super(MemberDevices.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MemberDevices> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MemberDevices value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("team_member_id", value.teamMemberId);
            if (value.webSessions != null) {
                g.writeObjectField("web_sessions", value.webSessions);
            }
            if (value.desktopClients != null) {
                g.writeObjectField("desktop_clients", value.desktopClients);
            }
            if (value.mobileClients != null) {
                g.writeObjectField("mobile_clients", value.mobileClients);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MemberDevices> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberDevices.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MemberDevices.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MemberDevices> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MemberDevices deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String teamMemberId = null;
            List<ActiveWebSession> webSessions = null;
            List<DesktopClientSession> desktopClients = null;
            List<MobileClientSession> mobileClients = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("team_member_id".equals(_field)) {
                    teamMemberId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("web_sessions".equals(_field)) {
                    expectArrayStart(_p);
                    webSessions = new java.util.ArrayList<ActiveWebSession>();
                    while (!isArrayEnd(_p)) {
                        ActiveWebSession _x = null;
                        _x = _p.readValueAs(ActiveWebSession.class);
                        _p.nextToken();
                        webSessions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("desktop_clients".equals(_field)) {
                    expectArrayStart(_p);
                    desktopClients = new java.util.ArrayList<DesktopClientSession>();
                    while (!isArrayEnd(_p)) {
                        DesktopClientSession _x = null;
                        _x = _p.readValueAs(DesktopClientSession.class);
                        _p.nextToken();
                        desktopClients.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("mobile_clients".equals(_field)) {
                    expectArrayStart(_p);
                    mobileClients = new java.util.ArrayList<MobileClientSession>();
                    while (!isArrayEnd(_p)) {
                        MobileClientSession _x = null;
                        _x = _p.readValueAs(MobileClientSession.class);
                        _p.nextToken();
                        mobileClients.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (teamMemberId == null) {
                throw new JsonParseException(_p, "Required field \"team_member_id\" is missing.");
            }

            return new MemberDevices(teamMemberId, webSessions, desktopClients, mobileClients);
        }
    }
}
