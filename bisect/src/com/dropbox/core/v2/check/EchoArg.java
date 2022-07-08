/* DO NOT EDIT */
/* This file was generated from api_proxy_dev_check_api_v2_service.stone */

package com.dropbox.core.v2.check;

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

/**
 * EchoArg contains the arguments to be sent to the Dropbox servers.
 */
class EchoArg {
    // struct check.EchoArg (api_proxy_dev_check_api_v2_service.stone)

    protected final String query;

    /**
     * EchoArg contains the arguments to be sent to the Dropbox servers.
     *
     * @param query  The string that you'd like to be echoed back to you. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EchoArg(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        this.query = query;
    }

    /**
     * EchoArg contains the arguments to be sent to the Dropbox servers.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public EchoArg() {
        this("\"\"");
    }

    /**
     * The string that you'd like to be echoed back to you.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "\"\"".
     */
    public String getQuery() {
        return query;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            query
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
            EchoArg other = (EchoArg) obj;
            return (this.query == other.query) || (this.query.equals(other.query));
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
    static class Serializer extends StructSerializer<EchoArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EchoArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("query");
            StoneSerializers.string().serialize(value.query, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public EchoArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            EchoArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_query = "\"\"";
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("query".equals(field)) {
                        f_query = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new EchoArg(f_query);
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
