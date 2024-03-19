/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Information about linked Dropbox desktop client sessions.
 */
public class DesktopClientSession extends DeviceSession {
    // struct team.DesktopClientSession (team_devices.stone)

    @Nonnull
    protected final String hostName;
    @Nonnull
    protected final DesktopPlatform clientType;
    @Nonnull
    protected final String clientVersion;
    @Nonnull
    protected final String platform;
    protected final boolean isDeleteOnUnlinkSupported;

    /**
     * Information about linked Dropbox desktop client sessions.
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
    public DesktopClientSession(@Nonnull String sessionId, @Nonnull String hostName, @Nonnull DesktopPlatform clientType, @Nonnull String clientVersion, @Nonnull String platform, boolean isDeleteOnUnlinkSupported, @Nullable String ipAddress, @Nullable String country, @Nullable Date created, @Nullable Date updated) {
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
     * Information about linked Dropbox desktop client sessions.
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
    public DesktopClientSession(@Nonnull String sessionId, @Nonnull String hostName, @Nonnull DesktopPlatform clientType, @Nonnull String clientVersion, @Nonnull String platform, boolean isDeleteOnUnlinkSupported) {
        this(sessionId, hostName, clientType, clientVersion, platform, isDeleteOnUnlinkSupported, null, null, null, null);
    }

    /**
     * The session id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Name of the hosting desktop.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getHostName() {
        return hostName;
    }

    /**
     * The Dropbox desktop client type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public DesktopPlatform getClientType() {
        return clientType;
    }

    /**
     * The Dropbox client version.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Information on the hosting platform.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPlatform() {
        return platform;
    }

    /**
     * Whether it's possible to delete all of the account files upon unlinking.
     *
     * @return value for this field.
     */
    public boolean getIsDeleteOnUnlinkSupported() {
        return isDeleteOnUnlinkSupported;
    }

    /**
     * The IP address of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The country from which the last activity from this session was made.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCountry() {
        return country;
    }

    /**
     * The time this session was created.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getUpdated() {
        return updated;
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<DesktopClientSession> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DesktopClientSession value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            g.writeFieldName("host_name");
            StoneSerializers.string().serialize(value.hostName, g);
            g.writeFieldName("client_type");
            DesktopPlatform.Serializer.INSTANCE.serialize(value.clientType, g);
            g.writeFieldName("client_version");
            StoneSerializers.string().serialize(value.clientVersion, g);
            g.writeFieldName("platform");
            StoneSerializers.string().serialize(value.platform, g);
            g.writeFieldName("is_delete_on_unlink_supported");
            StoneSerializers.boolean_().serialize(value.isDeleteOnUnlinkSupported, g);
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
        public DesktopClientSession deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DesktopClientSession value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                String f_hostName = null;
                DesktopPlatform f_clientType = null;
                String f_clientVersion = null;
                String f_platform = null;
                Boolean f_isDeleteOnUnlinkSupported = null;
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
                    else if ("host_name".equals(field)) {
                        f_hostName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("client_type".equals(field)) {
                        f_clientType = DesktopPlatform.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("client_version".equals(field)) {
                        f_clientVersion = StoneSerializers.string().deserialize(p);
                    }
                    else if ("platform".equals(field)) {
                        f_platform = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_delete_on_unlink_supported".equals(field)) {
                        f_isDeleteOnUnlinkSupported = StoneSerializers.boolean_().deserialize(p);
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
                if (f_hostName == null) {
                    throw new JsonParseException(p, "Required field \"host_name\" missing.");
                }
                if (f_clientType == null) {
                    throw new JsonParseException(p, "Required field \"client_type\" missing.");
                }
                if (f_clientVersion == null) {
                    throw new JsonParseException(p, "Required field \"client_version\" missing.");
                }
                if (f_platform == null) {
                    throw new JsonParseException(p, "Required field \"platform\" missing.");
                }
                if (f_isDeleteOnUnlinkSupported == null) {
                    throw new JsonParseException(p, "Required field \"is_delete_on_unlink_supported\" missing.");
                }
                value = new DesktopClientSession(f_sessionId, f_hostName, f_clientType, f_clientVersion, f_platform, f_isDeleteOnUnlinkSupported, f_ipAddress, f_country, f_created, f_updated);
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
