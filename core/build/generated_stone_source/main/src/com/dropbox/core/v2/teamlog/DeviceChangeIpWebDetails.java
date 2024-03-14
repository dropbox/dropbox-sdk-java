/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;

/**
 * Changed IP address associated with active web session.
 */
public class DeviceChangeIpWebDetails {
    // struct team_log.DeviceChangeIpWebDetails (team_log_generated.stone)

    protected final String userAgent;

    /**
     * Changed IP address associated with active web session.
     *
     * @param userAgent  Web browser name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeviceChangeIpWebDetails(@Nonnull String userAgent) {
        if (userAgent == null) {
            throw new IllegalArgumentException("Required value for 'userAgent' is null");
        }
        this.userAgent = userAgent;
    }

    /**
     * Web browser name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            userAgent
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
            DeviceChangeIpWebDetails other = (DeviceChangeIpWebDetails) obj;
            return (this.userAgent == other.userAgent) || (this.userAgent.equals(other.userAgent));
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
    static class Serializer extends StructSerializer<DeviceChangeIpWebDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeviceChangeIpWebDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user_agent");
            StoneSerializers.string().serialize(value.userAgent, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeviceChangeIpWebDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeviceChangeIpWebDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_userAgent = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user_agent".equals(field)) {
                        f_userAgent = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_userAgent == null) {
                    throw new JsonParseException(p, "Required field \"user_agent\" missing.");
                }
                value = new DeviceChangeIpWebDetails(f_userAgent);
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
