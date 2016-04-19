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
import java.util.Date;

/**
 * Information on active web sessions
 */
@JsonSerialize(using=ActiveWebSession.Serializer.class)
@JsonDeserialize(using=ActiveWebSession.Deserializer.class)
public class ActiveWebSession extends DeviceSession {
    // struct ActiveWebSession

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<ActiveWebSession> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ActiveWebSession.class);
        }

        public Serializer(boolean unwrapping) {
            super(ActiveWebSession.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ActiveWebSession> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ActiveWebSession value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("user_agent", value.userAgent);
            g.writeObjectField("os", value.os);
            g.writeObjectField("browser", value.browser);
            if (value.ipAddress != null) {
                g.writeObjectField("ip_address", value.ipAddress);
            }
            if (value.country != null) {
                g.writeObjectField("country", value.country);
            }
            if (value.created != null) {
                g.writeObjectField("created", value.created);
            }
            if (value.updated != null) {
                g.writeObjectField("updated", value.updated);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ActiveWebSession> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ActiveWebSession.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ActiveWebSession.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ActiveWebSession> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ActiveWebSession deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String userAgent = null;
            String os = null;
            String browser = null;
            String ipAddress = null;
            String country = null;
            Date created = null;
            Date updated = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("session_id".equals(_field)) {
                    sessionId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("user_agent".equals(_field)) {
                    userAgent = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("os".equals(_field)) {
                    os = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("browser".equals(_field)) {
                    browser = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("ip_address".equals(_field)) {
                    ipAddress = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("country".equals(_field)) {
                    country = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("created".equals(_field)) {
                    created = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("updated".equals(_field)) {
                    updated = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (sessionId == null) {
                throw new JsonParseException(_p, "Required field \"session_id\" is missing.");
            }
            if (userAgent == null) {
                throw new JsonParseException(_p, "Required field \"user_agent\" is missing.");
            }
            if (os == null) {
                throw new JsonParseException(_p, "Required field \"os\" is missing.");
            }
            if (browser == null) {
                throw new JsonParseException(_p, "Required field \"browser\" is missing.");
            }

            return new ActiveWebSession(sessionId, userAgent, os, browser, ipAddress, country, created, updated);
        }
    }
}
