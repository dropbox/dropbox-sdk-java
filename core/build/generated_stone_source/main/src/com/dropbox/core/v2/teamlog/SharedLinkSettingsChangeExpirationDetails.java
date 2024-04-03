/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.sharing.AccessLevel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Changed the expiration date of the shared link.
 */
public class SharedLinkSettingsChangeExpirationDetails {
    // struct team_log.SharedLinkSettingsChangeExpirationDetails (team_log_generated.stone)

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;
    @Nullable
    protected final String sharedContentLink;
    @Nullable
    protected final Date newValue;
    @Nullable
    protected final Date previousValue;

    /**
     * Changed the expiration date of the shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param sharedContentLink  Shared content link.
     * @param newValue  New shared content link expiration date. Might be
     *     missing due to historical data gap.
     * @param previousValue  Previous shared content link expiration date. Might
     *     be missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsChangeExpirationDetails(@Nonnull AccessLevel sharedContentAccessLevel, @Nullable String sharedContentLink, @Nullable Date newValue, @Nullable Date previousValue) {
        if (sharedContentAccessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = sharedContentAccessLevel;
        this.sharedContentLink = sharedContentLink;
        this.newValue = LangUtil.truncateMillis(newValue);
        this.previousValue = LangUtil.truncateMillis(previousValue);
    }

    /**
     * Changed the expiration date of the shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsChangeExpirationDetails(@Nonnull AccessLevel sharedContentAccessLevel) {
        this(sharedContentAccessLevel, null, null, null);
    }

    /**
     * Shared content access level.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return sharedContentAccessLevel;
    }

    /**
     * Shared content link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSharedContentLink() {
        return sharedContentLink;
    }

    /**
     * New shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getNewValue() {
        return newValue;
    }

    /**
     * Previous shared content link expiration date. Might be missing due to
     * historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getPreviousValue() {
        return previousValue;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel sharedContentAccessLevel) {
        return new Builder(sharedContentAccessLevel);
    }

    /**
     * Builder for {@link SharedLinkSettingsChangeExpirationDetails}.
     */
    public static class Builder {
        protected final AccessLevel sharedContentAccessLevel;

        protected String sharedContentLink;
        protected Date newValue;
        protected Date previousValue;

        protected Builder(AccessLevel sharedContentAccessLevel) {
            if (sharedContentAccessLevel == null) {
                throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
            }
            this.sharedContentAccessLevel = sharedContentAccessLevel;
            this.sharedContentLink = null;
            this.newValue = null;
            this.previousValue = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedContentLink  Shared content link.
         *
         * @return this builder
         */
        public Builder withSharedContentLink(String sharedContentLink) {
            this.sharedContentLink = sharedContentLink;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param newValue  New shared content link expiration date. Might be
         *     missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withNewValue(Date newValue) {
            this.newValue = LangUtil.truncateMillis(newValue);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previousValue  Previous shared content link expiration date.
         *     Might be missing due to historical data gap.
         *
         * @return this builder
         */
        public Builder withPreviousValue(Date previousValue) {
            this.previousValue = LangUtil.truncateMillis(previousValue);
            return this;
        }

        /**
         * Builds an instance of {@link
         * SharedLinkSettingsChangeExpirationDetails} configured with this
         * builder's values
         *
         * @return new instance of {@link
         *     SharedLinkSettingsChangeExpirationDetails}
         */
        public SharedLinkSettingsChangeExpirationDetails build() {
            return new SharedLinkSettingsChangeExpirationDetails(sharedContentAccessLevel, sharedContentLink, newValue, previousValue);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.sharedContentAccessLevel,
            this.sharedContentLink,
            this.newValue,
            this.previousValue
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
            SharedLinkSettingsChangeExpirationDetails other = (SharedLinkSettingsChangeExpirationDetails) obj;
            return ((this.sharedContentAccessLevel == other.sharedContentAccessLevel) || (this.sharedContentAccessLevel.equals(other.sharedContentAccessLevel)))
                && ((this.sharedContentLink == other.sharedContentLink) || (this.sharedContentLink != null && this.sharedContentLink.equals(other.sharedContentLink)))
                && ((this.newValue == other.newValue) || (this.newValue != null && this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<SharedLinkSettingsChangeExpirationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettingsChangeExpirationDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.sharedContentAccessLevel, g);
            if (value.sharedContentLink != null) {
                g.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedContentLink, g);
            }
            if (value.newValue != null) {
                g.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.newValue, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkSettingsChangeExpirationDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkSettingsChangeExpirationDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_sharedContentAccessLevel = null;
                String f_sharedContentLink = null;
                Date f_newValue = null;
                Date f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_access_level".equals(field)) {
                        f_sharedContentAccessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_content_link".equals(field)) {
                        f_sharedContentLink = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedContentAccessLevel == null) {
                    throw new JsonParseException(p, "Required field \"shared_content_access_level\" missing.");
                }
                value = new SharedLinkSettingsChangeExpirationDetails(f_sharedContentAccessLevel, f_sharedContentLink, f_newValue, f_previousValue);
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
