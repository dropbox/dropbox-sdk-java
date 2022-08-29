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

public class ShowcaseUntrashedDeprecatedType {
    // struct team_log.ShowcaseUntrashedDeprecatedType (team_log_generated.stone)

    protected final String description;

    /**
     *
     * @param description  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShowcaseUntrashedDeprecatedType(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        this.description = description;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            description
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
            ShowcaseUntrashedDeprecatedType other = (ShowcaseUntrashedDeprecatedType) obj;
            return (this.description == other.description) || (this.description.equals(other.description));
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
    static class Serializer extends StructSerializer<ShowcaseUntrashedDeprecatedType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ShowcaseUntrashedDeprecatedType value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("description");
            StoneSerializers.string().serialize(value.description, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ShowcaseUntrashedDeprecatedType deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ShowcaseUntrashedDeprecatedType value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_description = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("description".equals(field)) {
                        f_description = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_description == null) {
                    throw new JsonParseException(p, "Required field \"description\" missing.");
                }
                value = new ShowcaseUntrashedDeprecatedType(f_description);
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
