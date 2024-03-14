/* DO NOT EDIT */
/* This file was generated from team_sharing_allowlist.stone */

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

/**
 * This struct is empty. The comment here is intentionally emitted to avoid
 * indentation issues with Stone.
 */
public class SharingAllowlistRemoveResponse {
    // struct team.SharingAllowlistRemoveResponse (team_sharing_allowlist.stone)


    /**
     * This struct is empty. The comment here is intentionally emitted to avoid
     * indentation issues with Stone.
     */
    public SharingAllowlistRemoveResponse() {
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
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
            SharingAllowlistRemoveResponse other = (SharingAllowlistRemoveResponse) obj;
            return true;
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
    static class Serializer extends StructSerializer<SharingAllowlistRemoveResponse> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingAllowlistRemoveResponse value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingAllowlistRemoveResponse deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingAllowlistRemoveResponse value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                value = new SharingAllowlistRemoveResponse();
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
