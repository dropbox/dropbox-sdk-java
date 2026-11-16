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
 * Opened shared link.
 */
public class SharedLinkViewDetails {
    // struct team_log.SharedLinkViewDetails (team_log.stone)

    @Nullable
    protected final UserLogInfo sharedLinkOwner;
    @Nullable
    protected final String subdomain;

    /**
     * Opened shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedLinkOwner  Shared link owner details. Might be missing due
     *     to historical data gap.
     * @param subdomain  Team subdomain used to access the shared link.
     */
    public SharedLinkViewDetails(@Nullable UserLogInfo sharedLinkOwner, @Nullable String subdomain) {
        this.sharedLinkOwner = sharedLinkOwner;
        this.subdomain = subdomain;
    }

    /**
     * Opened shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SharedLinkViewDetails() {
        this(null, null);
    }

    /**
     * Shared link owner details. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public UserLogInfo getSharedLinkOwner() {
        return sharedLinkOwner;
    }

    /**
     * Team subdomain used to access the shared link.
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
     * Builder for {@link SharedLinkViewDetails}.
     */
    public static class Builder {

        protected UserLogInfo sharedLinkOwner;
        protected String subdomain;

        protected Builder() {
            this.sharedLinkOwner = null;
            this.subdomain = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedLinkOwner  Shared link owner details. Might be missing
         *     due to historical data gap.
         *
         * @return this builder
         */
        public Builder withSharedLinkOwner(UserLogInfo sharedLinkOwner) {
            this.sharedLinkOwner = sharedLinkOwner;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param subdomain  Team subdomain used to access the shared link.
         *
         * @return this builder
         */
        public Builder withSubdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkViewDetails} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedLinkViewDetails}
         */
        public SharedLinkViewDetails build() {
            return new SharedLinkViewDetails(sharedLinkOwner, subdomain);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedLinkOwner,
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
            SharedLinkViewDetails other = (SharedLinkViewDetails) obj;
            return ((this.sharedLinkOwner == other.sharedLinkOwner) || (this.sharedLinkOwner != null && this.sharedLinkOwner.equals(other.sharedLinkOwner)))
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
    static class Serializer extends StructSerializer<SharedLinkViewDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkViewDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.sharedLinkOwner != null) {
                g.writeFieldName("shared_link_owner");
                StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).serialize(value.sharedLinkOwner, g);
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
        public SharedLinkViewDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkViewDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserLogInfo f_sharedLinkOwner = null;
                String f_subdomain = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_link_owner".equals(field)) {
                        f_sharedLinkOwner = StoneSerializers.nullableStruct(UserLogInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("subdomain".equals(field)) {
                        f_subdomain = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SharedLinkViewDetails(f_sharedLinkOwner, f_subdomain);
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
