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

/**
 * Completed restrictions on data center locations where team data resides.
 */
public class DataPlacementRestrictionSatisfyPolicyDetails {
    // struct team_log.DataPlacementRestrictionSatisfyPolicyDetails (team_log_generated.stone)

    protected final PlacementRestriction placementRestriction;

    /**
     * Completed restrictions on data center locations where team data resides.
     *
     * @param placementRestriction  Placement restriction. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DataPlacementRestrictionSatisfyPolicyDetails(@Nonnull PlacementRestriction placementRestriction) {
        if (placementRestriction == null) {
            throw new IllegalArgumentException("Required value for 'placementRestriction' is null");
        }
        this.placementRestriction = placementRestriction;
    }

    /**
     * Placement restriction.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public PlacementRestriction getPlacementRestriction() {
        return placementRestriction;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            placementRestriction
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
            DataPlacementRestrictionSatisfyPolicyDetails other = (DataPlacementRestrictionSatisfyPolicyDetails) obj;
            return (this.placementRestriction == other.placementRestriction) || (this.placementRestriction.equals(other.placementRestriction));
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
    static class Serializer extends StructSerializer<DataPlacementRestrictionSatisfyPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DataPlacementRestrictionSatisfyPolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("placement_restriction");
            PlacementRestriction.Serializer.INSTANCE.serialize(value.placementRestriction, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DataPlacementRestrictionSatisfyPolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DataPlacementRestrictionSatisfyPolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                PlacementRestriction f_placementRestriction = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("placement_restriction".equals(field)) {
                        f_placementRestriction = PlacementRestriction.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_placementRestriction == null) {
                    throw new JsonParseException(p, "Required field \"placement_restriction\" missing.");
                }
                value = new DataPlacementRestrictionSatisfyPolicyDetails(f_placementRestriction);
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
