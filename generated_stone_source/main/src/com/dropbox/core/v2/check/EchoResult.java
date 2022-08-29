/* DO NOT EDIT */
/* This file was generated from check_api_v2_types.stone */

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
 * EchoResult contains the result returned from the Dropbox servers.
 */
public class EchoResult {
    // struct check.EchoResult (check_api_v2_types.stone)

    protected final String result;

    /**
     * EchoResult contains the result returned from the Dropbox servers.
     *
     * @param result  If everything worked correctly, this would be the same as
     *     query. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EchoResult(String result) {
        if (result == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = result;
    }

    /**
     * EchoResult contains the result returned from the Dropbox servers.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public EchoResult() {
        this("");
    }

    /**
     * If everything worked correctly, this would be the same as query.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     "".
     */
    public String getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            result
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
            EchoResult other = (EchoResult) obj;
            return (this.result == other.result) || (this.result.equals(other.result));
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
    static class Serializer extends StructSerializer<EchoResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(EchoResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("result");
            StoneSerializers.string().serialize(value.result, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public EchoResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            EchoResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_result = "";
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("result".equals(field)) {
                        f_result = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new EchoResult(f_result);
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
