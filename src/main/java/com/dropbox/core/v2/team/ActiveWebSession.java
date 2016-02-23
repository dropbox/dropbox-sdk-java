/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Information on active web sessions
 */
public class ActiveWebSession extends DeviceSession {
    // struct ActiveWebSession

    private final String userAgent;
    private final String os;
    private final String browser;

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
            return ((this.userAgent == other.userAgent) || (this.userAgent.equals(other.userAgent)))
                && ((this.os == other.os) || (this.os.equals(other.os)))
                && ((this.browser == other.browser) || (this.browser.equals(other.browser)))
                && ((this.getSessionId() == other.getSessionId()) || (this.getSessionId().equals(other.getSessionId())))
                && ((this.getIpAddress() == other.getIpAddress()) || (this.getIpAddress() != null && this.getIpAddress().equals(other.getIpAddress())))
                && ((this.getCountry() == other.getCountry()) || (this.getCountry() != null && this.getCountry().equals(other.getCountry())))
                && ((this.getCreated() == other.getCreated()) || (this.getCreated() != null && this.getCreated().equals(other.getCreated())))
                && ((this.getUpdated() == other.getUpdated()) || (this.getUpdated() != null && this.getUpdated().equals(other.getUpdated())))
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

    public static ActiveWebSession fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ActiveWebSession> _JSON_WRITER = new JsonWriter<ActiveWebSession>() {
        public final void write(ActiveWebSession x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSession._JSON_WRITER.writeFields(x, g);
            ActiveWebSession._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ActiveWebSession x, JsonGenerator g) throws IOException {
            g.writeFieldName("user_agent");
            g.writeString(x.userAgent);
            g.writeFieldName("os");
            g.writeString(x.os);
            g.writeFieldName("browser");
            g.writeString(x.browser);
        }
    };

    public static final JsonReader<ActiveWebSession> _JSON_READER = new JsonReader<ActiveWebSession>() {
        public final ActiveWebSession read(JsonParser parser) throws IOException, JsonReadException {
            ActiveWebSession result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ActiveWebSession readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
            String userAgent = null;
            String os = null;
            String browser = null;
            String ipAddress = null;
            String country = null;
            Date created = null;
            Date updated = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else if ("user_agent".equals(fieldName)) {
                    userAgent = JsonReader.StringReader
                        .readField(parser, "user_agent", userAgent);
                }
                else if ("os".equals(fieldName)) {
                    os = JsonReader.StringReader
                        .readField(parser, "os", os);
                }
                else if ("browser".equals(fieldName)) {
                    browser = JsonReader.StringReader
                        .readField(parser, "browser", browser);
                }
                else if ("ip_address".equals(fieldName)) {
                    ipAddress = JsonReader.StringReader
                        .readField(parser, "ip_address", ipAddress);
                }
                else if ("country".equals(fieldName)) {
                    country = JsonReader.StringReader
                        .readField(parser, "country", country);
                }
                else if ("created".equals(fieldName)) {
                    created = JsonDateReader.DropboxV2
                        .readField(parser, "created", created);
                }
                else if ("updated".equals(fieldName)) {
                    updated = JsonDateReader.DropboxV2
                        .readField(parser, "updated", updated);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (sessionId == null) {
                throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
            }
            if (userAgent == null) {
                throw new JsonReadException("Required field \"user_agent\" is missing.", parser.getTokenLocation());
            }
            if (os == null) {
                throw new JsonReadException("Required field \"os\" is missing.", parser.getTokenLocation());
            }
            if (browser == null) {
                throw new JsonReadException("Required field \"browser\" is missing.", parser.getTokenLocation());
            }
            return new ActiveWebSession(sessionId, userAgent, os, browser, ipAddress, country, created, updated);
        }
    };
}
