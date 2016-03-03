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
 * Information about linked Dropbox desktop client sessions
 */
@JsonSerialize(using=DesktopClientSession.Serializer.class)
@JsonDeserialize(using=DesktopClientSession.Deserializer.class)
public class DesktopClientSession extends DeviceSession {
    // struct DesktopClientSession

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String hostName;
    protected final DesktopPlatform clientType;
    protected final String clientVersion;
    protected final String platform;
    protected final boolean isDeleteOnUnlinkSupported;

    /**
     * Information about linked Dropbox desktop client sessions
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param clientVersion  The Dropbox client version. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether it's possible to delete all of
     *     the account files upon unlinking.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param country  The country from which the last activity from this
     *     session was made.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DesktopClientSession(String sessionId, String hostName, DesktopPlatform clientType, String clientVersion, String platform, boolean isDeleteOnUnlinkSupported, String ipAddress, String country, Date created, Date updated) {
        super(sessionId, ipAddress, country, created, updated);
        if (hostName == null) {
            throw new IllegalArgumentException("Required value for 'hostName' is null");
        }
        this.hostName = hostName;
        if (clientType == null) {
            throw new IllegalArgumentException("Required value for 'clientType' is null");
        }
        this.clientType = clientType;
        if (clientVersion == null) {
            throw new IllegalArgumentException("Required value for 'clientVersion' is null");
        }
        this.clientVersion = clientVersion;
        if (platform == null) {
            throw new IllegalArgumentException("Required value for 'platform' is null");
        }
        this.platform = platform;
        this.isDeleteOnUnlinkSupported = isDeleteOnUnlinkSupported;
    }

    /**
     * Information about linked Dropbox desktop client sessions
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param clientVersion  The Dropbox client version. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether it's possible to delete all of
     *     the account files upon unlinking.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DesktopClientSession(String sessionId, String hostName, DesktopPlatform clientType, String clientVersion, String platform, boolean isDeleteOnUnlinkSupported) {
        this(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported, null, null, null, null);
    }

    /**
     * Name of the hosting desktop
     *
     * @return value for this field, never {@code null}.
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * The Dropbox desktop client type
     *
     * @return value for this field, never {@code null}.
     */
    public DesktopPlatform getClientType() {
        return clientType;
    }

    /**
     * The Dropbox client version
     *
     * @return value for this field, never {@code null}.
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Information on the hosting platform
     *
     * @return value for this field, never {@code null}.
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Whether it's possible to delete all of the account files upon unlinking
     *
     * @return value for this field.
     */
    public boolean getIsDeleteOnUnlinkSupported() {
        return isDeleteOnUnlinkSupported;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param hostName  Name of the hosting desktop. Must not be {@code null}.
     * @param clientType  The Dropbox desktop client type. Must not be {@code
     *     null}.
     * @param clientVersion  The Dropbox client version. Must not be {@code
     *     null}.
     * @param platform  Information on the hosting platform. Must not be {@code
     *     null}.
     * @param isDeleteOnUnlinkSupported  Whether it's possible to delete all of
     *     the account files upon unlinking.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sessionId, String hostName, DesktopPlatform clientType, String clientVersion, String platform, boolean isDeleteOnUnlinkSupported) {
        return new Builder(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported);
    }

    /**
     * Builder for {@link DesktopClientSession}.
     */
    public static class Builder extends DeviceSession.Builder {
        protected final String hostName;
        protected final DesktopPlatform clientType;
        protected final String clientVersion;
        protected final String platform;
        protected final boolean isDeleteOnUnlinkSupported;

        protected Builder(String sessionId, String hostName, DesktopPlatform clientType, String clientVersion, String platform, boolean isDeleteOnUnlinkSupported) {
            super(sessionId);
            if (hostName == null) {
                throw new IllegalArgumentException("Required value for 'hostName' is null");
            }
            this.hostName = hostName;
            if (clientType == null) {
                throw new IllegalArgumentException("Required value for 'clientType' is null");
            }
            this.clientType = clientType;
            if (clientVersion == null) {
                throw new IllegalArgumentException("Required value for 'clientVersion' is null");
            }
            this.clientVersion = clientVersion;
            if (platform == null) {
                throw new IllegalArgumentException("Required value for 'platform' is null");
            }
            this.platform = platform;
            this.isDeleteOnUnlinkSupported = isDeleteOnUnlinkSupported;
        }

        /**
         * Builds an instance of {@link DesktopClientSession} configured with
         * this builder's values
         *
         * @return new instance of {@link DesktopClientSession}
         */
        public DesktopClientSession build() {
            return new DesktopClientSession(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported, ipAddress, country, created, updated);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            hostName,
            clientType,
            clientVersion,
            platform,
            isDeleteOnUnlinkSupported
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
            DesktopClientSession other = (DesktopClientSession) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.hostName == other.hostName) || (this.hostName.equals(other.hostName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion.equals(other.clientVersion)))
                && ((this.platform == other.platform) || (this.platform.equals(other.platform)))
                && (this.isDeleteOnUnlinkSupported == other.isDeleteOnUnlinkSupported)
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

    static final class Serializer extends StructJsonSerializer<DesktopClientSession> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DesktopClientSession.class);
        }

        public Serializer(boolean unwrapping) {
            super(DesktopClientSession.class, unwrapping);
        }

        @Override
        protected JsonSerializer<DesktopClientSession> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(DesktopClientSession value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("session_id", value.sessionId);
            g.writeObjectField("host_name", value.hostName);
            g.writeObjectField("client_type", value.clientType);
            g.writeObjectField("client_version", value.clientVersion);
            g.writeObjectField("platform", value.platform);
            g.writeObjectField("is_delete_on_unlink_supported", value.isDeleteOnUnlinkSupported);
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

    static final class Deserializer extends StructJsonDeserializer<DesktopClientSession> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DesktopClientSession.class);
        }

        public Deserializer(boolean unwrapping) {
            super(DesktopClientSession.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<DesktopClientSession> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public DesktopClientSession deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String sessionId = null;
            String hostName = null;
            DesktopPlatform clientType = null;
            String clientVersion = null;
            String platform = null;
            Boolean isDeleteOnUnlinkSupported = null;
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
                else if ("host_name".equals(_field)) {
                    hostName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("client_type".equals(_field)) {
                    clientType = _p.readValueAs(DesktopPlatform.class);
                    _p.nextToken();
                }
                else if ("client_version".equals(_field)) {
                    clientVersion = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("platform".equals(_field)) {
                    platform = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("is_delete_on_unlink_supported".equals(_field)) {
                    isDeleteOnUnlinkSupported = _p.getValueAsBoolean();
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
            if (hostName == null) {
                throw new JsonParseException(_p, "Required field \"host_name\" is missing.");
            }
            if (clientType == null) {
                throw new JsonParseException(_p, "Required field \"client_type\" is missing.");
            }
            if (clientVersion == null) {
                throw new JsonParseException(_p, "Required field \"client_version\" is missing.");
            }
            if (platform == null) {
                throw new JsonParseException(_p, "Required field \"platform\" is missing.");
            }
            if (isDeleteOnUnlinkSupported == null) {
                throw new JsonParseException(_p, "Required field \"is_delete_on_unlink_supported\" is missing.");
            }

            return new DesktopClientSession(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported, ipAddress, country, created, updated);
        }
    }
}
