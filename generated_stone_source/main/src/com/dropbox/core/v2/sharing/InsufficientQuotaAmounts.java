/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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

public class InsufficientQuotaAmounts {
    // struct sharing.InsufficientQuotaAmounts (sharing_folders.stone)

    protected final long spaceNeeded;
    protected final long spaceShortage;
    protected final long spaceLeft;

    /**
     *
     * @param spaceNeeded  The amount of space needed to add the item (the size
     *     of the item).
     * @param spaceShortage  The amount of extra space needed to add the item.
     * @param spaceLeft  The amount of space left in the user's Dropbox, less
     *     than space_needed.
     */
    public InsufficientQuotaAmounts(long spaceNeeded, long spaceShortage, long spaceLeft) {
        this.spaceNeeded = spaceNeeded;
        this.spaceShortage = spaceShortage;
        this.spaceLeft = spaceLeft;
    }

    /**
     * The amount of space needed to add the item (the size of the item).
     *
     * @return value for this field.
     */
    public long getSpaceNeeded() {
        return spaceNeeded;
    }

    /**
     * The amount of extra space needed to add the item.
     *
     * @return value for this field.
     */
    public long getSpaceShortage() {
        return spaceShortage;
    }

    /**
     * The amount of space left in the user's Dropbox, less than space_needed.
     *
     * @return value for this field.
     */
    public long getSpaceLeft() {
        return spaceLeft;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            spaceNeeded,
            spaceShortage,
            spaceLeft
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
            InsufficientQuotaAmounts other = (InsufficientQuotaAmounts) obj;
            return (this.spaceNeeded == other.spaceNeeded)
                && (this.spaceShortage == other.spaceShortage)
                && (this.spaceLeft == other.spaceLeft)
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
    static class Serializer extends StructSerializer<InsufficientQuotaAmounts> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InsufficientQuotaAmounts value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("space_needed");
            StoneSerializers.uInt64().serialize(value.spaceNeeded, g);
            g.writeFieldName("space_shortage");
            StoneSerializers.uInt64().serialize(value.spaceShortage, g);
            g.writeFieldName("space_left");
            StoneSerializers.uInt64().serialize(value.spaceLeft, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public InsufficientQuotaAmounts deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            InsufficientQuotaAmounts value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Long f_spaceNeeded = null;
                Long f_spaceShortage = null;
                Long f_spaceLeft = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("space_needed".equals(field)) {
                        f_spaceNeeded = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("space_shortage".equals(field)) {
                        f_spaceShortage = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("space_left".equals(field)) {
                        f_spaceLeft = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_spaceNeeded == null) {
                    throw new JsonParseException(p, "Required field \"space_needed\" missing.");
                }
                if (f_spaceShortage == null) {
                    throw new JsonParseException(p, "Required field \"space_shortage\" missing.");
                }
                if (f_spaceLeft == null) {
                    throw new JsonParseException(p, "Required field \"space_left\" missing.");
                }
                value = new InsufficientQuotaAmounts(f_spaceNeeded, f_spaceShortage, f_spaceLeft);
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
