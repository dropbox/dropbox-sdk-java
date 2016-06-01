/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class TeamSpaceAllocation {
    // struct TeamSpaceAllocation

    protected final long used;
    protected final long allocated;

    /**
     *
     * @param used  The total space currently used by the user's team (bytes).
     * @param allocated  The total space allocated to the user's team (bytes).
     */
    public TeamSpaceAllocation(long used, long allocated) {
        this.used = used;
        this.allocated = allocated;
    }

    /**
     * The total space currently used by the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The total space allocated to the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            used,
            allocated
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TeamSpaceAllocation other = (TeamSpaceAllocation) obj;
            return (this.used == other.used)
                && (this.allocated == other.allocated)
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
    static final class Serializer extends StructSerializer<TeamSpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamSpaceAllocation value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("used");
            StoneSerializers.uInt64().serialize(value.used, g);
            g.writeFieldName("allocated");
            StoneSerializers.uInt64().serialize(value.allocated, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamSpaceAllocation deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamSpaceAllocation value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_used = null;
                Long f_allocated = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("used".equals(field)) {
                        f_used = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("allocated".equals(field)) {
                        f_allocated = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_used == null) {
                    throw new JsonParseException(p, "Required field \"used\" missing.");
                }
                if (f_allocated == null) {
                    throw new JsonParseException(p, "Required field \"allocated\" missing.");
                }
                value = new TeamSpaceAllocation(f_used, f_allocated);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
