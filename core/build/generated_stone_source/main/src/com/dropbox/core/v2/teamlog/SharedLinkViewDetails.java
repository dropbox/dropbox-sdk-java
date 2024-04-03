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
 * Opened shared link.
 */
public class SharedLinkViewDetails {
    // struct team_log.SharedLinkViewDetails (team_log_generated.stone)

    @Nullable
    protected final UserLogInfo sharedLinkOwner;

    /**
     * Opened shared link.
     *
     * @param sharedLinkOwner  Shared link owner details. Might be missing due
     *     to historical data gap.
     */
    public SharedLinkViewDetails(@Nullable UserLogInfo sharedLinkOwner) {
        this.sharedLinkOwner = sharedLinkOwner;
    }

    /**
     * Opened shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkViewDetails() {
        this(null);
    }

    /**
     * Shared link owner details. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public UserLogInfo getSharedLinkOwner() {
        return sharedLinkOwner;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedLinkOwner
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
            SharedLinkViewDetails other = (SharedLinkViewDetails) obj;
            return (this.sharedLinkOwner == other.sharedLinkOwner) || (this.sharedLinkOwner != null && this.sharedLinkOwner.equals(other.sharedLinkOwner));
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
    static class Serializer extends StructSerializer<SharedLinkViewDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkViewDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedLinkOwner != null) {
                g.writeFieldName("shared_link_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(value.sharedLinkOwner, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkViewDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkViewDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserLogInfo f_sharedLinkOwner = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_link_owner".equals(field)) {
                        f_sharedLinkOwner = StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkViewDetails(f_sharedLinkOwner);
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
