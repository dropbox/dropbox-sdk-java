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

/**
 * Changed custom member space limit.
 */
public class MemberSpaceLimitsChangeCustomQuotaDetails {
    // struct team_log.MemberSpaceLimitsChangeCustomQuotaDetails (team_log_generated.stone)

    protected final long previousValue;
    protected final long newValue;

    /**
     * Changed custom member space limit.
     *
     * @param previousValue  Previous custom quota value in bytes.
     * @param newValue  New custom quota value in bytes.
     */
    public MemberSpaceLimitsChangeCustomQuotaDetails(long previousValue, long newValue) {
        this.previousValue = previousValue;
        this.newValue = newValue;
    }

    /**
     * Previous custom quota value in bytes.
     *
     * @return value for this field.
     */
    public long getPreviousValue() {
        return previousValue;
    }

    /**
     * New custom quota value in bytes.
     *
     * @return value for this field.
     */
    public long getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.previousValue,
            this.newValue
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
            MemberSpaceLimitsChangeCustomQuotaDetails other = (MemberSpaceLimitsChangeCustomQuotaDetails) obj;
            return (this.previousValue == other.previousValue)
                && (this.newValue == other.newValue)
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
    static class Serializer extends StructSerializer<MemberSpaceLimitsChangeCustomQuotaDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSpaceLimitsChangeCustomQuotaDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            StoneSerializers.uInt64().serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            StoneSerializers.uInt64().serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberSpaceLimitsChangeCustomQuotaDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberSpaceLimitsChangeCustomQuotaDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_previousValue = null;
                Long f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new MemberSpaceLimitsChangeCustomQuotaDetails(f_previousValue, f_newValue);
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
