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
 * The origin from which the actor performed the action.
 */
public class OriginLogInfo {
    // struct team_log.OriginLogInfo (team_log_generated.stone)

    protected final GeoLocationLogInfo geoLocation;
    protected final AccessMethodLogInfo accessMethod;

    /**
     * The origin from which the actor performed the action.
     *
     * @param accessMethod  The method that was used to perform the action. Must
     *     not be {@code null}.
     * @param geoLocation  Geographic location details.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public OriginLogInfo(@Nonnull AccessMethodLogInfo accessMethod, @Nullable GeoLocationLogInfo geoLocation) {
        this.geoLocation = geoLocation;
        if (accessMethod == null) {
            throw new IllegalArgumentException("Required value for 'accessMethod' is null");
        }
        this.accessMethod = accessMethod;
    }

    /**
     * The origin from which the actor performed the action.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessMethod  The method that was used to perform the action. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public OriginLogInfo(AccessMethodLogInfo accessMethod) {
        this(accessMethod, null);
    }

    /**
     * The method that was used to perform the action.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessMethodLogInfo getAccessMethod() {
        return accessMethod;
    }

    /**
     * Geographic location details.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public GeoLocationLogInfo getGeoLocation() {
        return geoLocation;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            geoLocation,
            accessMethod
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
            OriginLogInfo other = (OriginLogInfo) obj;
            return ((this.accessMethod == other.accessMethod) || (this.accessMethod.equals(other.accessMethod)))
                && ((this.geoLocation == other.geoLocation) || (this.geoLocation != null && this.geoLocation.equals(other.geoLocation)))
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
    static class Serializer extends StructSerializer<OriginLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(OriginLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_method");
            AccessMethodLogInfo.Serializer.INSTANCE.serialize(value.accessMethod, g);
            if (value.geoLocation != null) {
                g.writeFieldName("geo_location");
                StoneSerializers.nullableStruct(GeoLocationLogInfo.Serializer.INSTANCE).serialize(value.geoLocation, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public OriginLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            OriginLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessMethodLogInfo f_accessMethod = null;
                GeoLocationLogInfo f_geoLocation = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_method".equals(field)) {
                        f_accessMethod = AccessMethodLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("geo_location".equals(field)) {
                        f_geoLocation = StoneSerializers.nullableStruct(GeoLocationLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessMethod == null) {
                    throw new JsonParseException(p, "Required field \"access_method\" missing.");
                }
                value = new OriginLogInfo(f_accessMethod, f_geoLocation);
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
