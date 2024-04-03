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
import javax.annotation.Nullable;

/**
 * Session's logged information.
 */
public class SessionLogInfo {
    // struct team_log.SessionLogInfo (team_log_generated.stone)

    @Nullable
    protected final String sessionId;

    /**
     * Session's logged information.
     *
     * @param sessionId  Session ID.
     */
    public SessionLogInfo(@Nullable String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Session's logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SessionLogInfo() {
        this(null);
    }

    /**
     * Session ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sessionId
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
            SessionLogInfo other = (SessionLogInfo) obj;
            return (this.sessionId == other.sessionId) || (this.sessionId != null && this.sessionId.equals(other.sessionId));
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
    static class Serializer extends StructSerializer<SessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof WebSessionLogInfo) {
                WebSessionLogInfo.Serializer.INSTANCE.serialize((WebSessionLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof DesktopSessionLogInfo) {
                DesktopSessionLogInfo.Serializer.INSTANCE.serialize((DesktopSessionLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof MobileSessionLogInfo) {
                MobileSessionLogInfo.Serializer.INSTANCE.serialize((MobileSessionLogInfo) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sessionId != null) {
                g.writeFieldName("session_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sessionId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_sessionId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SessionLogInfo(f_sessionId);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("web".equals(tag)) {
                value = WebSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("desktop".equals(tag)) {
                value = DesktopSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("mobile".equals(tag)) {
                value = MobileSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
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
