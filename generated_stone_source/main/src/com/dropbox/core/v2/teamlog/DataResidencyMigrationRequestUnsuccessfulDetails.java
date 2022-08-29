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

/**
 * Request for data residency migration for team data has failed.
 */
public class DataResidencyMigrationRequestUnsuccessfulDetails {
    // struct team_log.DataResidencyMigrationRequestUnsuccessfulDetails (team_log_generated.stone)


    /**
     * Request for data residency migration for team data has failed.
     */
    public DataResidencyMigrationRequestUnsuccessfulDetails() {
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
            DataResidencyMigrationRequestUnsuccessfulDetails other = (DataResidencyMigrationRequestUnsuccessfulDetails) obj;
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
    static class Serializer extends StructSerializer<DataResidencyMigrationRequestUnsuccessfulDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DataResidencyMigrationRequestUnsuccessfulDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DataResidencyMigrationRequestUnsuccessfulDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DataResidencyMigrationRequestUnsuccessfulDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                value = new DataResidencyMigrationRequestUnsuccessfulDetails();
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
