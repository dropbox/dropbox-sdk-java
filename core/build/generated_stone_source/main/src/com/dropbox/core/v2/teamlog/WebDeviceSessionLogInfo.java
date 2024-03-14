/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Information on active web sessions
 */
public class WebDeviceSessionLogInfo extends DeviceSessionLogInfo {
    // struct team_log.WebDeviceSessionLogInfo (team_log_generated.stone)

    protected final WebSessionLogInfo sessionInfo;
    protected final String userAgent;
    protected final String os;
    protected final String browser;

    /**
     * Information on active web sessions
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param userAgent  Information on the hosting device. Must not be {@code
     *     null}.
     * @param os  Information on the hosting operating system. Must not be
     *     {@code null}.
     * @param browser  Information on the browser used for this web session.
     *     Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     * @param sessionInfo  Web session unique id.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public WebDeviceSessionLogInfo(String userAgent, String os, String browser, String ipAddress, Date created, Date updated, WebSessionLogInfo sessionInfo) {
        super(ipAddress, created, updated);
        this.sessionInfo = sessionInfo;
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
    public WebDeviceSessionLogInfo(String userAgent, String os, String browser) {
        this(userAgent, os, browser, null, null, null, null);
    }

    /**
     * Information on the hosting device.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Information on the hosting operating system.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getOs() {
        return os;
    }

    /**
     * Information on the browser used for this web session.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getBrowser() {
        return browser;
    }

    /**
     * The IP address of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The time this session was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getUpdated() {
        return updated;
    }

    /**
     * Web session unique id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public WebSessionLogInfo getSessionInfo() {
        return sessionInfo;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
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
    public static Builder newBuilder(String userAgent, String os, String browser) {
        return new Builder(userAgent, os, browser);
    }

    /**
     * Builder for {@link WebDeviceSessionLogInfo}.
     */
    public static class Builder extends DeviceSessionLogInfo.Builder {
        protected final String userAgent;
        protected final String os;
        protected final String browser;

        protected WebSessionLogInfo sessionInfo;

        protected Builder(String userAgent, String os, String browser) {
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
            this.sessionInfo = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sessionInfo  Web session unique id.
         *
         * @return this builder
         */
        public Builder withSessionInfo(WebSessionLogInfo sessionInfo) {
            this.sessionInfo = sessionInfo;
            return this;
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
         * Builds an instance of {@link WebDeviceSessionLogInfo} configured with
         * this builder's values
         *
         * @return new instance of {@link WebDeviceSessionLogInfo}
         */
        public WebDeviceSessionLogInfo build() {
            return new WebDeviceSessionLogInfo(userAgent, os, browser, ipAddress, created, updated, sessionInfo);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionInfo,
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            WebDeviceSessionLogInfo other = (WebDeviceSessionLogInfo) obj;
            return ((this.userAgent == other.userAgent) || (this.userAgent.equals(other.userAgent)))
                && ((this.os == other.os) || (this.os.equals(other.os)))
                && ((this.browser == other.browser) || (this.browser.equals(other.browser)))
                && ((this.ipAddress == other.ipAddress) || (this.ipAddress != null && this.ipAddress.equals(other.ipAddress)))
                && ((this.created == other.created) || (this.created != null && this.created.equals(other.created)))
                && ((this.updated == other.updated) || (this.updated != null && this.updated.equals(other.updated)))
                && ((this.sessionInfo == other.sessionInfo) || (this.sessionInfo != null && this.sessionInfo.equals(other.sessionInfo)))
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
    static class Serializer extends StructSerializer<WebDeviceSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WebDeviceSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("web_device_session", g);
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
            if (value.created != null) {
                g.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.created, g);
            }
            if (value.updated != null) {
                g.writeFieldName("updated");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.updated, g);
            }
            if (value.sessionInfo != null) {
                g.writeFieldName("session_info");
                StoneSerializers.nullableStruct(WebSessionLogInfo.Serializer.INSTANCE).serialize(value.sessionInfo, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public WebDeviceSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            WebDeviceSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("web_device_session".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_userAgent = null;
                String f_os = null;
                String f_browser = null;
                String f_ipAddress = null;
                Date f_created = null;
                Date f_updated = null;
                WebSessionLogInfo f_sessionInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user_agent".equals(field)) {
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
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("updated".equals(field)) {
                        f_updated = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("session_info".equals(field)) {
                        f_sessionInfo = StoneSerializers.nullableStruct(WebSessionLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
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
                value = new WebDeviceSessionLogInfo(f_userAgent, f_os, f_browser, f_ipAddress, f_created, f_updated, f_sessionInfo);
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
