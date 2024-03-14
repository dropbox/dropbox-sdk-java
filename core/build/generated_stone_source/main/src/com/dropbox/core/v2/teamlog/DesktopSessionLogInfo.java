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

/**
 * Desktop session.
 */
public class DesktopSessionLogInfo extends SessionLogInfo {
    // struct team_log.DesktopSessionLogInfo (team_log_generated.stone)


    /**
     * Desktop session.
     *
     * @param sessionId  Session ID.
     */
    public DesktopSessionLogInfo(String sessionId) {
        super(sessionId);
    }

    /**
     * Desktop session.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DesktopSessionLogInfo() {
        this(null);
    }

    /**
     * Session ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
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
            DesktopSessionLogInfo other = (DesktopSessionLogInfo) obj;
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
    static class Serializer extends StructSerializer<DesktopSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DesktopSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("desktop", g);
            if (value.sessionId != null) {
                g.writeFieldName("session_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sessionId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DesktopSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DesktopSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("desktop".equals(tag)) {
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
                value = new DesktopSessionLogInfo(f_sessionId);
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
