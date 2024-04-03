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
 * Api session.
 */
public class ApiSessionLogInfo {
    // struct team_log.ApiSessionLogInfo (team_log_generated.stone)

    @Nonnull
    protected final String requestId;

    /**
     * Api session.
     *
     * @param requestId  Api request ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ApiSessionLogInfo(@Nonnull String requestId) {
        if (requestId == null) {
            throw new IllegalArgumentException("Required value for 'requestId' is null");
        }
        this.requestId = requestId;
    }

    /**
     * Api request ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getRequestId() {
        return requestId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.requestId
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
            ApiSessionLogInfo other = (ApiSessionLogInfo) obj;
            return (this.requestId == other.requestId) || (this.requestId.equals(other.requestId));
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
    static class Serializer extends StructSerializer<ApiSessionLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ApiSessionLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("request_id");
            StoneSerializers.string().serialize(value.requestId, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ApiSessionLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ApiSessionLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_requestId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("request_id".equals(field)) {
                        f_requestId = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_requestId == null) {
                    throw new JsonParseException(p, "Required field \"request_id\" missing.");
                }
                value = new ApiSessionLogInfo(f_requestId);
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
