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

class FeaturesGetValuesBatchArg {
    // struct team.FeaturesGetValuesBatchArg (team.stone)

    protected final List<Feature> features;

    /**
     *
     * @param features  A list of features in {@link Feature}. If the list is
     *     empty, this route will return {@link FeaturesGetValuesBatchError}.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FeaturesGetValuesBatchArg(List<Feature> features) {
        if (features == null) {
            throw new IllegalArgumentException("Required value for 'features' is null");
        }
        for (Feature x : features) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'features' is null");
            }
        }
        this.features = features;
    }

    /**
     * A list of features in {@link Feature}. If the list is empty, this route
     * will return {@link FeaturesGetValuesBatchError}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Feature> getFeatures() {
        return features;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            features
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
            FeaturesGetValuesBatchArg other = (FeaturesGetValuesBatchArg) obj;
            return (this.features == other.features) || (this.features.equals(other.features));
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
    static class Serializer extends StructSerializer<FeaturesGetValuesBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FeaturesGetValuesBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("features");
            StoneSerializers.list(Feature.Serializer.INSTANCE).serialize(value.features, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FeaturesGetValuesBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FeaturesGetValuesBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<Feature> f_features = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("features".equals(field)) {
                        f_features = StoneSerializers.list(Feature.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_features == null) {
                    throw new JsonParseException(p, "Required field \"features\" missing.");
                }
                value = new FeaturesGetValuesBatchArg(f_features);
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
