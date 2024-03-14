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

/**
 * Geographic location details.
 */
public class GeoLocationLogInfo {
    // struct team_log.GeoLocationLogInfo (team_log_generated.stone)

    protected final String city;
    protected final String region;
    protected final String country;
    protected final String ipAddress;

    /**
     * Geographic location details.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param ipAddress  IP address. Must not be {@code null}.
     * @param city  City name.
     * @param region  Region name.
     * @param country  Country code.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GeoLocationLogInfo(String ipAddress, String city, String region, String country) {
        this.city = city;
        this.region = region;
        this.country = country;
        if (ipAddress == null) {
            throw new IllegalArgumentException("Required value for 'ipAddress' is null");
        }
        this.ipAddress = ipAddress;
    }

    /**
     * Geographic location details.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param ipAddress  IP address. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GeoLocationLogInfo(String ipAddress) {
        this(ipAddress, null, null, null);
    }

    /**
     * IP address.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * City name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getCity() {
        return city;
    }

    /**
     * Region name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getRegion() {
        return region;
    }

    /**
     * Country code.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getCountry() {
        return country;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param ipAddress  IP address. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String ipAddress) {
        return new Builder(ipAddress);
    }

    /**
     * Builder for {@link GeoLocationLogInfo}.
     */
    public static class Builder {
        protected final String ipAddress;

        protected String city;
        protected String region;
        protected String country;

        protected Builder(String ipAddress) {
            if (ipAddress == null) {
                throw new IllegalArgumentException("Required value for 'ipAddress' is null");
            }
            this.ipAddress = ipAddress;
            this.city = null;
            this.region = null;
            this.country = null;
        }

        /**
         * Set value for optional field.
         *
         * @param city  City name.
         *
         * @return this builder
         */
        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param region  Region name.
         *
         * @return this builder
         */
        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param country  Country code.
         *
         * @return this builder
         */
        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * Builds an instance of {@link GeoLocationLogInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link GeoLocationLogInfo}
         */
        public GeoLocationLogInfo build() {
            return new GeoLocationLogInfo(ipAddress, city, region, country);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            city,
            region,
            country,
            ipAddress
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
            GeoLocationLogInfo other = (GeoLocationLogInfo) obj;
            return ((this.ipAddress == other.ipAddress) || (this.ipAddress.equals(other.ipAddress)))
                && ((this.city == other.city) || (this.city != null && this.city.equals(other.city)))
                && ((this.region == other.region) || (this.region != null && this.region.equals(other.region)))
                && ((this.country == other.country) || (this.country != null && this.country.equals(other.country)))
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
    static class Serializer extends StructSerializer<GeoLocationLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GeoLocationLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("ip_address");
            StoneSerializers.string().serialize(value.ipAddress, g);
            if (value.city != null) {
                g.writeFieldName("city");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.city, g);
            }
            if (value.region != null) {
                g.writeFieldName("region");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.region, g);
            }
            if (value.country != null) {
                g.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.country, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GeoLocationLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GeoLocationLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_ipAddress = null;
                String f_city = null;
                String f_region = null;
                String f_country = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("ip_address".equals(field)) {
                        f_ipAddress = StoneSerializers.string().deserialize(p);
                    }
                    else if ("city".equals(field)) {
                        f_city = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("region".equals(field)) {
                        f_region = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("country".equals(field)) {
                        f_country = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_ipAddress == null) {
                    throw new JsonParseException(p, "Required field \"ip_address\" missing.");
                }
                value = new GeoLocationLogInfo(f_ipAddress, f_city, f_region, f_country);
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
