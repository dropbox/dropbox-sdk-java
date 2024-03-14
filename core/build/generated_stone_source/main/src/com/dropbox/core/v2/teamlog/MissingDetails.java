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
 * An indication that an error occurred while retrieving the event. Some
 * attributes of the event may be omitted as a result.
 */
public class MissingDetails {
    // struct team_log.MissingDetails (team_log_generated.stone)

    protected final String sourceEventFields;

    /**
     * An indication that an error occurred while retrieving the event. Some
     * attributes of the event may be omitted as a result.
     *
     * @param sourceEventFields  All the data that could be retrieved and
     *     converted from the source event.
     */
    public MissingDetails(@Nullable String sourceEventFields) {
        this.sourceEventFields = sourceEventFields;
    }

    /**
     * An indication that an error occurred while retrieving the event. Some
     * attributes of the event may be omitted as a result.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public MissingDetails() {
        this(null);
    }

    /**
     * All the data that could be retrieved and converted from the source event.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSourceEventFields() {
        return sourceEventFields;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sourceEventFields
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
            MissingDetails other = (MissingDetails) obj;
            return (this.sourceEventFields == other.sourceEventFields) || (this.sourceEventFields != null && this.sourceEventFields.equals(other.sourceEventFields));
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
    static class Serializer extends StructSerializer<MissingDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MissingDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sourceEventFields != null) {
                g.writeFieldName("source_event_fields");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sourceEventFields, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MissingDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MissingDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sourceEventFields = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("source_event_fields".equals(field)) {
                        f_sourceEventFields = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new MissingDetails(f_sourceEventFields);
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
