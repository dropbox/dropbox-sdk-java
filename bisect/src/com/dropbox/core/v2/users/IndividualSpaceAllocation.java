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

public class IndividualSpaceAllocation {
    // struct users.IndividualSpaceAllocation (users.stone)

    protected final long allocated;

    /**
     *
     * @param allocated  The total space allocated to the user's account
     *     (bytes).
     */
    public IndividualSpaceAllocation(long allocated) {
        this.allocated = allocated;
    }

    /**
     * The total space allocated to the user's account (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            allocated
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
            IndividualSpaceAllocation other = (IndividualSpaceAllocation) obj;
            return this.allocated == other.allocated;
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
    static class Serializer extends StructSerializer<IndividualSpaceAllocation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(IndividualSpaceAllocation value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("allocated");
            StoneSerializers.uInt64().serialize(value.allocated, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public IndividualSpaceAllocation deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            IndividualSpaceAllocation value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_allocated = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("allocated".equals(field)) {
                        f_allocated = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_allocated == null) {
                    throw new JsonParseException(p, "Required field \"allocated\" missing.");
                }
                value = new IndividualSpaceAllocation(f_allocated);
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
