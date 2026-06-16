/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

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

public class RemovedStatus {
    // struct team.RemovedStatus (team.stone)

    protected final boolean isRecoverable;
    protected final boolean isDisconnected;

    /**
     *
     * @param isRecoverable  True if the removed team member is recoverable.
     * @param isDisconnected  True if the team member's account was converted to
     *     individual account.
     */
    public RemovedStatus(boolean isRecoverable, boolean isDisconnected) {
        this.isRecoverable = isRecoverable;
        this.isDisconnected = isDisconnected;
    }

    /**
     * True if the removed team member is recoverable.
     *
     * @return value for this field.
     */
    public boolean getIsRecoverable() {
        return isRecoverable;
    }

    /**
     * True if the team member's account was converted to individual account.
     *
     * @return value for this field.
     */
    public boolean getIsDisconnected() {
        return isDisconnected;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.isRecoverable,
            this.isDisconnected
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
            RemovedStatus other = (RemovedStatus) obj;
            return (this.isRecoverable == other.isRecoverable)
                && (this.isDisconnected == other.isDisconnected)
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
    static class Serializer extends StructSerializer<RemovedStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemovedStatus value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_recoverable");
            StoneSerializers.boolean_().serialize(value.isRecoverable, g);
            g.writeFieldName("is_disconnected");
            StoneSerializers.boolean_().serialize(value.isDisconnected, g);
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
                Boolean f_isDisconnected = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_recoverable".equals(field)) {
                        f_isRecoverable = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("is_disconnected".equals(field)) {
                        f_isDisconnected = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isRecoverable == null) {
                    throw new JsonParseException(p, "Required field \"is_recoverable\" missing.");
                }
                if (f_isDisconnected == null) {
                    throw new JsonParseException(p, "Required field \"is_disconnected\" missing.");
                }
                value = new RemovedStatus(f_isRecoverable, f_isDisconnected);
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
