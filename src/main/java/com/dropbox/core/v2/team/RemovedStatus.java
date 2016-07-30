/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class RemovedStatus {
    // struct RemovedStatus

    protected final boolean isRecoverable;

    /**
     *
     * @param isRecoverable  True if the removed team member is recoverable.
     */
    public RemovedStatus(boolean isRecoverable) {
        this.isRecoverable = isRecoverable;
    }

    /**
     * True if the removed team member is recoverable
     *
     * @return value for this field.
     */
    public boolean getIsRecoverable() {
        return isRecoverable;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            isRecoverable
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
            RemovedStatus other = (RemovedStatus) obj;
            return this.isRecoverable == other.isRecoverable;
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
    static final class Serializer extends StructSerializer<RemovedStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemovedStatus value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_recoverable");
            StoneSerializers.boolean_().serialize(value.isRecoverable, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RemovedStatus deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RemovedStatus value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isRecoverable = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_recoverable".equals(field)) {
                        f_isRecoverable = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isRecoverable == null) {
                    throw new JsonParseException(p, "Required field \"is_recoverable\" missing.");
                }
                value = new RemovedStatus(f_isRecoverable);
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
