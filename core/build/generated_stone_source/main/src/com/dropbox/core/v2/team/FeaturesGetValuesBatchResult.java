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
import java.util.List;

import javax.annotation.Nonnull;

public class FeaturesGetValuesBatchResult {
    // struct team.FeaturesGetValuesBatchResult (team.stone)

    @Nonnull
    protected final List<FeatureValue> values;

    /**
     *
     * @param values  Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FeaturesGetValuesBatchResult(@Nonnull List<FeatureValue> values) {
        if (values == null) {
            throw new IllegalArgumentException("Required value for 'values' is null");
        }
        for (FeatureValue x : values) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'values' is null");
            }
        }
        this.values = values;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<FeatureValue> getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            values
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
            FeaturesGetValuesBatchResult other = (FeaturesGetValuesBatchResult) obj;
            return (this.values == other.values) || (this.values.equals(other.values));
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
    static class Serializer extends StructSerializer<FeaturesGetValuesBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FeaturesGetValuesBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("values");
            StoneSerializers.list(FeatureValue.Serializer.INSTANCE).serialize(value.values, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FeaturesGetValuesBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FeaturesGetValuesBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<FeatureValue> f_values = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("values".equals(field)) {
                        f_values = StoneSerializers.list(FeatureValue.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_values == null) {
                    throw new JsonParseException(p, "Required field \"values\" missing.");
                }
                value = new FeaturesGetValuesBatchResult(f_values);
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
