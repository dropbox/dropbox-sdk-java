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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Removed link expiration date of shared file/folder.
 */
public class SharedContentRemoveLinkExpiryDetails {
    // struct team_log.SharedContentRemoveLinkExpiryDetails (team_log_generated.stone)

    @Nullable
    protected final Date previousValue;

    /**
     * Removed link expiration date of shared file/folder.
     *
     * @param previousValue  Previous shared content link expiration date. Might
     *     be missing due to historical data gap.
     */
    public SharedContentRemoveLinkExpiryDetails(@Nullable Date previousValue) {
        this.previousValue = LangUtil.truncateMillis(previousValue);
    }

    /**
     * Removed link expiration date of shared file/folder.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedContentRemoveLinkExpiryDetails() {
        this(null);
    }

    /**
     * Previous shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getPreviousValue() {
        return previousValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.previousValue
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
            SharedContentRemoveLinkExpiryDetails other = (SharedContentRemoveLinkExpiryDetails) obj;
            return (this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue));
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
    static class Serializer extends StructSerializer<SharedContentRemoveLinkExpiryDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedContentRemoveLinkExpiryDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedContentRemoveLinkExpiryDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedContentRemoveLinkExpiryDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Date f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedContentRemoveLinkExpiryDetails(f_previousValue);
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
