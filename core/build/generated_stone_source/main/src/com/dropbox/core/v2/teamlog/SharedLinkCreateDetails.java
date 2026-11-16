/* DO NOT EDIT */
/* This file was generated from team_log.stone */

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
 * Created shared link.
 */
public class SharedLinkCreateDetails {
    // struct team_log.SharedLinkCreateDetails (team_log.stone)

    @Nullable
    protected final SharedLinkAccessLevel sharedLinkAccessLevel;
    @Nullable
    protected final String subdomain;

    /**
     * Created shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedLinkAccessLevel  Defines who can access the shared link.
     *     Might be missing due to historical data gap.
     * @param subdomain  Team subdomain associated with this shared-link action.
     */
    public SharedLinkCreateDetails(@Nullable SharedLinkAccessLevel sharedLinkAccessLevel, @Nullable String subdomain) {
        this.sharedLinkAccessLevel = sharedLinkAccessLevel;
        this.subdomain = subdomain;
    }

    /**
     * Created shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkCreateDetails() {
        this(null, null);
    }

    /**
     * Defines who can access the shared link. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedLinkAccessLevel getSharedLinkAccessLevel() {
        return sharedLinkAccessLevel;
    }

    /**
     * Team subdomain associated with this shared-link action.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSubdomain() {
        return subdomain;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link SharedLinkCreateDetails}.
     */
    public static class Builder {

        protected SharedLinkAccessLevel sharedLinkAccessLevel;
        protected String subdomain;

        protected Builder() {
            this.sharedLinkAccessLevel = null;
            this.subdomain = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedLinkAccessLevel  Defines who can access the shared link.
         *     Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withSharedLinkAccessLevel(SharedLinkAccessLevel sharedLinkAccessLevel) {
            this.sharedLinkAccessLevel = sharedLinkAccessLevel;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param subdomain  Team subdomain associated with this shared-link
         *     action.
         *
         * @return this builder
         */
        public Builder withSubdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkCreateDetails} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedLinkCreateDetails}
         */
        public SharedLinkCreateDetails build() {
            return new SharedLinkCreateDetails(sharedLinkAccessLevel, subdomain);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedLinkAccessLevel,
            this.subdomain
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
            SharedLinkCreateDetails other = (SharedLinkCreateDetails) obj;
            return ((this.sharedLinkAccessLevel == other.sharedLinkAccessLevel) || (this.sharedLinkAccessLevel != null && this.sharedLinkAccessLevel.equals(other.sharedLinkAccessLevel)))
                && ((this.subdomain == other.subdomain) || (this.subdomain != null && this.subdomain.equals(other.subdomain)))
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
    static class Serializer extends StructSerializer<SharedLinkCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkCreateDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedLinkAccessLevel != null) {
                g.writeFieldName("shared_link_access_level");
                StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).serialize(value.sharedLinkAccessLevel, g);
            }
            if (value.subdomain != null) {
                g.writeFieldName("subdomain");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.subdomain, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkCreateDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkCreateDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SharedLinkAccessLevel f_sharedLinkAccessLevel = null;
                String f_subdomain = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_link_access_level".equals(field)) {
                        f_sharedLinkAccessLevel = StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("subdomain".equals(field)) {
                        f_subdomain = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkCreateDetails(f_sharedLinkAccessLevel, f_subdomain);
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
