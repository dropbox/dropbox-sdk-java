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

public class ListMemberDevicesResult {
    // struct team.ListMemberDevicesResult (team_devices.stone)

    @Nullable
    protected final List<ActiveWebSession> activeWebSessions;
    @Nullable
    protected final List<DesktopClientSession> desktopClientSessions;
    @Nullable
    protected final List<MobileClientSession> mobileClientSessions;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param activeWebSessions  List of web sessions made by this team member.
     *     Must not contain a {@code null} item.
     * @param desktopClientSessions  List of desktop clients used by this team
     *     member. Must not contain a {@code null} item.
     * @param mobileClientSessions  List of mobile client used by this team
     *     member. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberDevicesResult(@Nullable List<ActiveWebSession> activeWebSessions, @Nullable List<DesktopClientSession> desktopClientSessions, @Nullable List<MobileClientSession> mobileClientSessions) {
        if (activeWebSessions != null) {
            for (ActiveWebSession x : activeWebSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                }
            }
        }
        this.activeWebSessions = activeWebSessions;
        if (desktopClientSessions != null) {
            for (DesktopClientSession x : desktopClientSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                }
            }
        }
        this.desktopClientSessions = desktopClientSessions;
        if (mobileClientSessions != null) {
            for (MobileClientSession x : mobileClientSessions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                }
            }
        }
        this.mobileClientSessions = mobileClientSessions;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListMemberDevicesResult() {
        this(null, null, null);
    }

    /**
     * List of web sessions made by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<ActiveWebSession> getActiveWebSessions() {
        return activeWebSessions;
    }

    /**
     * List of desktop clients used by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<DesktopClientSession> getDesktopClientSessions() {
        return desktopClientSessions;
    }

    /**
     * List of mobile client used by this team member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<MobileClientSession> getMobileClientSessions() {
        return mobileClientSessions;
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
     * Builder for {@link ListMemberDevicesResult}.
     */
    public static class Builder {

        protected List<ActiveWebSession> activeWebSessions;
        protected List<DesktopClientSession> desktopClientSessions;
        protected List<MobileClientSession> mobileClientSessions;

        protected Builder() {
            this.activeWebSessions = null;
            this.desktopClientSessions = null;
            this.mobileClientSessions = null;
        }

        /**
         * Set value for optional field.
         *
         * @param activeWebSessions  List of web sessions made by this team
         *     member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withActiveWebSessions(List<ActiveWebSession> activeWebSessions) {
            if (activeWebSessions != null) {
                for (ActiveWebSession x : activeWebSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'activeWebSessions' is null");
                    }
                }
            }
            this.activeWebSessions = activeWebSessions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param desktopClientSessions  List of desktop clients used by this
         *     team member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDesktopClientSessions(List<DesktopClientSession> desktopClientSessions) {
            if (desktopClientSessions != null) {
                for (DesktopClientSession x : desktopClientSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'desktopClientSessions' is null");
                    }
                }
            }
            this.desktopClientSessions = desktopClientSessions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param mobileClientSessions  List of mobile client used by this team
         *     member. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMobileClientSessions(List<MobileClientSession> mobileClientSessions) {
            if (mobileClientSessions != null) {
                for (MobileClientSession x : mobileClientSessions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'mobileClientSessions' is null");
                    }
                }
            }
            this.mobileClientSessions = mobileClientSessions;
            return this;
        }

        /**
         * Builds an instance of {@link ListMemberDevicesResult} configured with
         * this builder's values
         *
         * @return new instance of {@link ListMemberDevicesResult}
         */
        public ListMemberDevicesResult build() {
            return new ListMemberDevicesResult(activeWebSessions, desktopClientSessions, mobileClientSessions);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            activeWebSessions,
            desktopClientSessions,
            mobileClientSessions
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
            ListMemberDevicesResult other = (ListMemberDevicesResult) obj;
            return ((this.activeWebSessions == other.activeWebSessions) || (this.activeWebSessions != null && this.activeWebSessions.equals(other.activeWebSessions)))
                && ((this.desktopClientSessions == other.desktopClientSessions) || (this.desktopClientSessions != null && this.desktopClientSessions.equals(other.desktopClientSessions)))
                && ((this.mobileClientSessions == other.mobileClientSessions) || (this.mobileClientSessions != null && this.mobileClientSessions.equals(other.mobileClientSessions)))
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
    static class Serializer extends StructSerializer<ListMemberDevicesResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMemberDevicesResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.activeWebSessions != null) {
                g.writeFieldName("active_web_sessions");
                StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).serialize(value.activeWebSessions, g);
            }
            if (value.desktopClientSessions != null) {
                g.writeFieldName("desktop_client_sessions");
                StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).serialize(value.desktopClientSessions, g);
            }
            if (value.mobileClientSessions != null) {
                g.writeFieldName("mobile_client_sessions");
                StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).serialize(value.mobileClientSessions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListMemberDevicesResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListMemberDevicesResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<ActiveWebSession> f_activeWebSessions = null;
                List<DesktopClientSession> f_desktopClientSessions = null;
                List<MobileClientSession> f_mobileClientSessions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("active_web_sessions".equals(field)) {
                        f_activeWebSessions = StoneSerializers.nullable(StoneSerializers.list(ActiveWebSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("desktop_client_sessions".equals(field)) {
                        f_desktopClientSessions = StoneSerializers.nullable(StoneSerializers.list(DesktopClientSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("mobile_client_sessions".equals(field)) {
                        f_mobileClientSessions = StoneSerializers.nullable(StoneSerializers.list(MobileClientSession.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListMemberDevicesResult(f_activeWebSessions, f_desktopClientSessions, f_mobileClientSessions);
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
