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
 * Signed out.
 */
public class LogoutDetails {
    // struct team_log.LogoutDetails (team_log_generated.stone)

    protected final String loginId;

    /**
     * Signed out.
     *
     * @param loginId  Login session id.
     */
    public LogoutDetails(@Nullable String loginId) {
        this.loginId = loginId;
    }

    /**
     * Signed out.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public LogoutDetails() {
        this(null);
    }

    /**
     * Login session id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getLoginId() {
        return loginId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            loginId
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
            LogoutDetails other = (LogoutDetails) obj;
            return (this.loginId == other.loginId) || (this.loginId != null && this.loginId.equals(other.loginId));
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
    static class Serializer extends StructSerializer<LogoutDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LogoutDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.loginId != null) {
                g.writeFieldName("login_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.loginId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LogoutDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LogoutDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_loginId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("login_id".equals(field)) {
                        f_loginId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new LogoutDetails(f_loginId);
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
