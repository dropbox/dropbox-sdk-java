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
 * Created shared link.
 */
public class SharedLinkCreateDetails {
    // struct team_log.SharedLinkCreateDetails (team_log_generated.stone)

    @Nullable
    protected final SharedLinkAccessLevel sharedLinkAccessLevel;

    /**
     * Created shared link.
     *
     * @param sharedLinkAccessLevel  Defines who can access the shared link.
     *     Might be missing due to historical data gap.
     */
    public SharedLinkCreateDetails(@Nullable SharedLinkAccessLevel sharedLinkAccessLevel) {
        this.sharedLinkAccessLevel = sharedLinkAccessLevel;
    }

    /**
     * Created shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkCreateDetails() {
        this(null);
    }

    /**
     * Defines who can access the shared link. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedLinkAccessLevel getSharedLinkAccessLevel() {
        return sharedLinkAccessLevel;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedLinkAccessLevel
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
            SharedLinkCreateDetails other = (SharedLinkCreateDetails) obj;
            return (this.sharedLinkAccessLevel == other.sharedLinkAccessLevel) || (this.sharedLinkAccessLevel != null && this.sharedLinkAccessLevel.equals(other.sharedLinkAccessLevel));
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
    static class Serializer extends StructSerializer<SharedLinkCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkCreateDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedLinkAccessLevel != null) {
                g.writeFieldName("shared_link_access_level");
                StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).serialize(value.sharedLinkAccessLevel, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkCreateDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkCreateDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharedLinkAccessLevel f_sharedLinkAccessLevel = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_link_access_level".equals(field)) {
                        f_sharedLinkAccessLevel = StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkCreateDetails(f_sharedLinkAccessLevel);
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
