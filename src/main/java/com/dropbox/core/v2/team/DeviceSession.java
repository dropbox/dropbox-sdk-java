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

public class DeviceSession {
    // struct DeviceSession

    private final String sessionId;
    private final String ipAddress;
    private final String country;
    private final Date created;
    private final Date updated;

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
    public DeviceSession(String sessionId, String ipAddress, String country, Date created, Date updated) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value for 'sessionId' is null");
        }
        this.sessionId = sessionId;
        this.ipAddress = ipAddress;
        this.country = country;
        this.created = created;
        this.updated = updated;
    }

    /**
     * The default values for unset fields will be used.
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
     * The session id
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The IP address of the last activity from this session
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * The country from which the last activity from this session was made
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCountry() {
        return country;
    }

    /**
     * The time this session was created
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * The time of the last activity from this session
     *
     * @return value for this field, or {@code null} if not present.
     */
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
            this.created = created;
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
            this.updated = updated;
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
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static DeviceSession fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DeviceSession> _JSON_WRITER = new JsonWriter<DeviceSession>() {
        public final void write(DeviceSession x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DeviceSession._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DeviceSession x, JsonGenerator g) throws IOException {
            g.writeFieldName("session_id");
            g.writeString(x.sessionId);
            if (x.ipAddress != null) {
                g.writeFieldName("ip_address");
                g.writeString(x.ipAddress);
            }
            if (x.country != null) {
                g.writeFieldName("country");
                g.writeString(x.country);
            }
            if (x.created != null) {
                g.writeFieldName("created");
                writeDateIso(x.created, g);
            }
            if (x.updated != null) {
                g.writeFieldName("updated");
                writeDateIso(x.updated, g);
            }
        }
    };

    public static final JsonReader<DeviceSession> _JSON_READER = new JsonReader<DeviceSession>() {
        public final DeviceSession read(JsonParser parser) throws IOException, JsonReadException {
            DeviceSession result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DeviceSession readFields(JsonParser parser) throws IOException, JsonReadException {
            String sessionId = null;
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
            return new DeviceSession(sessionId, ipAddress, country, created, updated);
        }
    };
}
