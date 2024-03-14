/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Added expiration date to link for shared file/folder.
 */
public class SharedContentAddLinkExpiryDetails {
    // struct team_log.SharedContentAddLinkExpiryDetails (team_log_generated.stone)

    protected final Date newValue;

    /**
     * Added expiration date to link for shared file/folder.
     *
     * @param newValue  New shared content link expiration date. Might be
     *     missing due to historical data gap.
     */
    public SharedContentAddLinkExpiryDetails(Date newValue) {
        this.newValue = LangUtil.truncateMillis(newValue);
    }

    /**
     * Added expiration date to link for shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedContentAddLinkExpiryDetails() {
        this(null);
    }

    /**
     * New shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newValue
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
            SharedContentAddLinkExpiryDetails other = (SharedContentAddLinkExpiryDetails) obj;
            return (this.newValue == other.newValue) || (this.newValue != null && this.newValue.equals(other.newValue));
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
    static class Serializer extends StructSerializer<SharedContentAddLinkExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentAddLinkExpiryDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.newValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentAddLinkExpiryDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentAddLinkExpiryDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedContentAddLinkExpiryDetails(f_newValue);
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
