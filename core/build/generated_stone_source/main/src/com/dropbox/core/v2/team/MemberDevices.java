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
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Information on devices of a team's member.
 */
public class MemberDevices {
    // struct team.MemberDevices (team_devices.stone)

    @Nonnull
    protected final String teamMemberId;
    @Nullable
    protected final List<ActiveWebSession> webSessions;
    @Nullable
    protected final List<DesktopClientSession> desktopClients;
    @Nullable
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
    public MemberDevices(@Nonnull String teamMemberId, @Nullable List<ActiveWebSession> webSessions, @Nullable List<DesktopClientSession> desktopClients, @Nullable List<MobileClientSession> mobileClients) {
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
    public MemberDevices(@Nonnull String teamMemberId) {
        this(teamMemberId, null, null, null);
    }

    /**
     * The member unique Id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * List of web sessions made by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<ActiveWebSession> getWebSessions() {
        return webSessions;
    }

    /**
     * List of desktop clients by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<DesktopClientSession> getDesktopClients() {
        return desktopClients;
    }

    /**
     * List of mobile clients by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
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
        int hash = Arrays.hashCode(new Object [] {
            this.teamMemberId,
            this.webSessions,
            this.desktopClients,
            this.mobileClients
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
    static class Serializer extends StructSerializer<MemberDevices> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberDevices value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            if (value.webSessions != null) {
                g.writeFieldName("web_sessions");
                StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).serialize(value.webSessions, g);
            }
            if (value.desktopClients != null) {
                g.writeFieldName("desktop_clients");
                StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).serialize(value.desktopClients, g);
            }
            if (value.mobileClients != null) {
                g.writeFieldName("mobile_clients");
                StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).serialize(value.mobileClients, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberDevices deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberDevices value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamMemberId = null;
                List<ActiveWebSession> f_webSessions = null;
                List<DesktopClientSession> f_desktopClients = null;
                List<MobileClientSession> f_mobileClients = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("web_sessions".equals(field)) {
                        f_webSessions = StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("desktop_clients".equals(field)) {
                        f_desktopClients = StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("mobile_clients".equals(field)) {
                        f_mobileClients = StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                value = new MemberDevices(f_teamMemberId, f_webSessions, f_desktopClients, f_mobileClients);
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
