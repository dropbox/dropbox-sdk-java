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
 * Information about linked Dropbox desktop client sessions
 */
public class DesktopClientSession extends DeviceSession {
    // struct DesktopClientSession

    private final String hostName;
    private final DesktopPlatform clientType;
    private final String clientVersion;
    private final String platform;
    private final boolean isDeleteOnUnlinkSupported;

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
            return ((this.hostName == other.hostName) || (this.hostName.equals(other.hostName)))
                && ((this.clientType == other.clientType) || (this.clientType.equals(other.clientType)))
                && ((this.clientVersion == other.clientVersion) || (this.clientVersion.equals(other.clientVersion)))
                && ((this.platform == other.platform) || (this.platform.equals(other.platform)))
                && (this.isDeleteOnUnlinkSupported == other.isDeleteOnUnlinkSupported)
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

    public static DesktopClientSession fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DesktopClientSession> _JSON_WRITER = new JsonWriter<DesktopClientSession>() {
        public final void write(DesktopClientSession x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSession._JSON_WRITER.writeFields(x, g);
            DesktopClientSession._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DesktopClientSession x, JsonGenerator g) throws IOException {
            g.writeFieldName("host_name");
            g.writeString(x.hostName);
            g.writeFieldName("client_type");
            DesktopPlatform._JSON_WRITER.write(x.clientType, g);
            g.writeFieldName("client_version");
            g.writeString(x.clientVersion);
            g.writeFieldName("platform");
            g.writeString(x.platform);
            g.writeFieldName("is_delete_on_unlink_supported");
            g.writeBoolean(x.isDeleteOnUnlinkSupported);
        }
    };

    public static final JsonReader<DesktopClientSession> _JSON_READER = new JsonReader<DesktopClientSession>() {
        public final DesktopClientSession read(JsonParser parser) throws IOException, JsonReadException {
            DesktopClientSession result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DesktopClientSession readFields(JsonParser parser) throws IOException, JsonReadException {
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
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("session_id".equals(fieldName)) {
                    sessionId = JsonReader.StringReader
                        .readField(parser, "session_id", sessionId);
                }
                else if ("host_name".equals(fieldName)) {
                    hostName = JsonReader.StringReader
                        .readField(parser, "host_name", hostName);
                }
                else if ("client_type".equals(fieldName)) {
                    clientType = DesktopPlatform._JSON_READER
                        .readField(parser, "client_type", clientType);
                }
                else if ("client_version".equals(fieldName)) {
                    clientVersion = JsonReader.StringReader
                        .readField(parser, "client_version", clientVersion);
                }
                else if ("platform".equals(fieldName)) {
                    platform = JsonReader.StringReader
                        .readField(parser, "platform", platform);
                }
                else if ("is_delete_on_unlink_supported".equals(fieldName)) {
                    isDeleteOnUnlinkSupported = JsonReader.BooleanReader
                        .readField(parser, "is_delete_on_unlink_supported", isDeleteOnUnlinkSupported);
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
            if (hostName == null) {
                throw new JsonReadException("Required field \"host_name\" is missing.", parser.getTokenLocation());
            }
            if (clientType == null) {
                throw new JsonReadException("Required field \"client_type\" is missing.", parser.getTokenLocation());
            }
            if (clientVersion == null) {
                throw new JsonReadException("Required field \"client_version\" is missing.", parser.getTokenLocation());
            }
            if (platform == null) {
                throw new JsonReadException("Required field \"platform\" is missing.", parser.getTokenLocation());
            }
            if (isDeleteOnUnlinkSupported == null) {
                throw new JsonReadException("Required field \"is_delete_on_unlink_supported\" is missing.", parser.getTokenLocation());
            }
            return new DesktopClientSession(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported, ipAddress, country, created, updated);
        }
    };
}
