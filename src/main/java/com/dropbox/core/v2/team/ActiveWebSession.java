/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Information on active web sessions
 */
public class ActiveWebSession extends DeviceSession {
    // struct ActiveWebSession

    protected final String userAgent;
    protected final String os;
    protected final String browser;

    /**
     * Information on active web sessions
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param userAgent  Information on the hosting device. Must not be {@code
     *     null}.
     * @param os  Information on the hosting operating system. Must not be
     *     {@code null}.
     * @param browser  Information on the browser used for this web session.
     *     Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param country  The country from which the last activity from this
     *     session was made.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ActiveWebSession(String sessionId, String userAgent, String os, String browser, String ipAddress, String country, Date created, Date updated) {
        super(sessionId, ipAddress, country, created, updated);
        if (userAgent == null) {
            throw new IllegalArgumentException("Required value for 'userAgent' is null");
        }
        this.userAgent = userAgent;
        if (os == null) {
            throw new IllegalArgumentException("Required value for 'os' is null");
        }
        this.os = os;
        if (browser == null) {
            throw new IllegalArgumentException("Required value for 'browser' is null");
        }
        this.browser = browser;
    }

    /**
     * Information on active web sessions
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param userAgent  Information on the hosting device. Must not be {@code
     *     null}.
     * @param os  Information on the hosting operating system. Must not be
     *     {@code null}.
     * @param browser  Information on the browser used for this web session.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ActiveWebSession(String sessionId, String userAgent, String os, String browser) {
        this(sessionId, userAgent, os, browser, null, null, null, null);
    }

    /**
     * Information on the hosting device
     *
     * @return value for this field, never {@code null}.
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Information on the hosting operating system
     *
     * @return value for this field, never {@code null}.
     */
    public String getOs() {
        return os;
    }

    /**
     * Information on the browser used for this web session
     *
     * @return value for this field, never {@code null}.
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param userAgent  Information on the hosting device. Must not be {@code
     *     null}.
     * @param os  Information on the hosting operating system. Must not be
     *     {@code null}.
     * @param browser  Information on the browser used for this web session.
     *     Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sessionId, String userAgent, String os, String browser) {
        return new Builder(sessionId, userAgent, os, browser);
    }

    /**
     * Builder for {@link ActiveWebSession}.
     */
    public static class Builder extends DeviceSession.Builder {
        protected final String userAgent;
        protected final String os;
        protected final String browser;

        protected Builder(String sessionId, String userAgent, String os, String browser) {
            super(sessionId);
            if (userAgent == null) {
                throw new IllegalArgumentException("Required value for 'userAgent' is null");
            }
            this.userAgent = userAgent;
            if (os == null) {
                throw new IllegalArgumentException("Required value for 'os' is null");
            }
            this.os = os;
            if (browser == null) {
                throw new IllegalArgumentException("Required value for 'browser' is null");
            }
            this.browser = browser;
        }

        /**
         * Set value for optional field.
         *
         * @param ipAddress  The IP address of the last activity from this
         *     session.
         *
         * @return this builder
         */
        public Builder withIpAddress(String ipAddress) {
            super.withIpAddress(ipAddress);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param country  The country from which the last activity from this
         *     session was made.
         *
         * @return this builder
         */
        public Builder withCountry(String country) {
            super.withCountry(country);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param created  The time this session was created.
         *
         * @return this builder
         */
        public Builder withCreated(Date created) {
            super.withCreated(created);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param updated  The time of the last activity from this session.
         *
         * @return this builder
         */
        public Builder withUpdated(Date updated) {
            super.withUpdated(updated);
            return this;
        }

        /**
         * Builds an instance of {@link ActiveWebSession} configured with this
         * builder's values
         *
         * @return new instance of {@link ActiveWebSession}
         */
        public ActiveWebSession build() {
            return new ActiveWebSession(sessionId, userAgent, os, browser, ipAddress, country, created, updated);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            userAgent,
            os,
            browser
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ActiveWebSession other = (ActiveWebSession) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.userAgent == other.userAgent) || (this.userAgent.equals(other.userAgent)))
                && ((this.os == other.os) || (this.os.equals(other.os)))
                && ((this.browser == other.browser) || (this.browser.equals(other.browser)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
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
    static final class Serializer extends StructSerializer<ActiveWebSession> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ActiveWebSession value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            g.writeFieldName("user_agent");
            StoneSerializers.string().serialize(value.userAgent, g);
            g.writeFieldName("os");
            StoneSerializers.string().serialize(value.os, g);
            g.writeFieldName("browser");
            StoneSerializers.string().serialize(value.browser, g);
            if (value.ipAddress != null) {
                g.writeFieldName("ip_address");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.ipAddress, g);
            }
            if (value.country != null) {
                g.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.country, g);
            }
            if (value.created != null) {
                g.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.created, g);
            }
            if (value.updated != null) {
                g.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.updated, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ActiveWebSession deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ActiveWebSession value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                String f_userAgent = null;
                String f_os = null;
                String f_browser = null;
                String f_ipAddress = null;
                String f_country = null;
                Date f_created = null;
                Date f_updated = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("user_agent".equals(field)) {
                        f_userAgent = StoneSerializers.string().deserialize(p);
                    }
                    else if ("os".equals(field)) {
                        f_os = StoneSerializers.string().deserialize(p);
                    }
                    else if ("browser".equals(field)) {
                        f_browser = StoneSerializers.string().deserialize(p);
                    }
                    else if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("country".equals(field)) {
                        f_country = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("updated".equals(field)) {
                        f_updated = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                if (f_userAgent == null) {
                    throw new JsonParseException(p, "Required field \"user_agent\" missing.");
                }
                if (f_os == null) {
                    throw new JsonParseException(p, "Required field \"os\" missing.");
                }
                if (f_browser == null) {
                    throw new JsonParseException(p, "Required field \"browser\" missing.");
                }
                value = new ActiveWebSession(f_sessionId, f_userAgent, f_os, f_browser, f_ipAddress, f_country, f_created, f_updated);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
