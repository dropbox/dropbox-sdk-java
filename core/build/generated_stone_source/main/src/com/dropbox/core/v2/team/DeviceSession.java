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

public class DeviceSession {
    // struct team.DeviceSession (team_devices.stone)

    protected final String sessionId;
    protected final String ipAddress;
    protected final String country;
    protected final Date created;
    protected final Date updated;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param ipAddress  The IP address of the last activity from this session.
     * @param country  The country from which the last activity from this
     *     session was made.
     * @param created  The time this session was created.
     * @param updated  The time of the last activity from this session.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSession(@javax.annotation.Nonnull String sessionId, @javax.annotation.Nullable String ipAddress, @javax.annotation.Nullable String country, @javax.annotation.Nullable Date created, @javax.annotation.Nullable Date updated) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        this.ipAddress = ipAddress;
        this.country = country;
        this.created = LangUtil.truncateMillis(created);
        this.updated = LangUtil.truncateMillis(updated);
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceSession(String sessionId) {
        this(sessionId, null, null, null, null);
    }

    /**
     * The session id.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getSessionId() {
        return sessionId;
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
     * The country from which the last activity from this session was made.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getCountry() {
        return country;
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
     * Returns a new builder for creating an instance of this class.
     *
     * @param sessionId  The session id. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String sessionId) {
        return new Builder(sessionId);
    }

    /**
     * Builder for {@link DeviceSession}.
     */
    public static class Builder {
        protected final String sessionId;

        protected String ipAddress;
        protected String country;
        protected Date created;
        protected Date updated;

        protected Builder(String sessionId) {
            if (sessionId == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
            }
            this.sessionId = sessionId;
            this.ipAddress = null;
            this.country = null;
            this.created = null;
            this.updated = null;
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
            this.ipAddress = ipAddress;
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
            this.country = country;
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
            this.created = LangUtil.truncateMillis(created);
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
            this.updated = LangUtil.truncateMillis(updated);
            return this;
        }

        /**
         * Builds an instance of {@link DeviceSession} configured with this
         * builder's values
         *
         * @return new instance of {@link DeviceSession}
         */
        public DeviceSession build() {
            return new DeviceSession(sessionId, ipAddress, country, created, updated);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sessionId,
            ipAddress,
            country,
            created,
            updated
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
            DeviceSession other = (DeviceSession) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
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
    private static class Serializer extends StructSerializer<DeviceSession> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceSession value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
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
        public DeviceSession deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceSession value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
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
                value = new DeviceSession(f_sessionId, f_ipAddress, f_country, f_created, f_updated);
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
