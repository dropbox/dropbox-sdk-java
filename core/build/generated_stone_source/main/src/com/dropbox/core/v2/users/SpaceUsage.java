/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

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
 * Information about a user's space usage and quota.
 */
public class SpaceUsage {
    // struct users.SpaceUsage (users.stone)

    protected final long used;
    @Nonnull
    protected final SpaceAllocation allocation;

    /**
     * Information about a user's space usage and quota.
     *
     * @param used  The user's total space usage (bytes).
     * @param allocation  The user's space allocation. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SpaceUsage(long used, @Nonnull SpaceAllocation allocation) {
        this.used = used;
        if (allocation == null) {
            throw new IllegalArgumentException("Required value for 'allocation' is null");
        }
        this.allocation = allocation;
    }

    /**
     * The user's total space usage (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The user's space allocation.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public SpaceAllocation getAllocation() {
        return allocation;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.used,
            this.allocation
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
            SpaceUsage other = (SpaceUsage) obj;
            return (this.used == other.used)
                && ((this.allocation == other.allocation) || (this.allocation.equals(other.allocation)))
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
    static class Serializer extends StructSerializer<SpaceUsage> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SpaceUsage value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("used");
            StoneSerializers.uInt64().serialize(value.used, g);
            g.writeFieldName("allocation");
            SpaceAllocation.Serializer.INSTANCE.serialize(value.allocation, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SpaceUsage deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SpaceUsage value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_used = null;
                SpaceAllocation f_allocation = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("used".equals(field)) {
                        f_used = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("allocation".equals(field)) {
                        f_allocation = SpaceAllocation.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_used == null) {
                    throw new JsonParseException(p, "Required field \"used\" missing.");
                }
                if (f_allocation == null) {
                    throw new JsonParseException(p, "Required field \"allocation\" missing.");
                }
                value = new SpaceUsage(f_used, f_allocation);
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
