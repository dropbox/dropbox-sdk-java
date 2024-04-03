/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.sharing.AccessLevel;
import com.dropbox.core.v2.sharing.LinkAudience;

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
 * Changed the audience of the shared link.
 */
public class SharedLinkSettingsChangeAudienceDetails {
    // struct team_log.SharedLinkSettingsChangeAudienceDetails (team_log_generated.stone)

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;
    @Nullable
    protected final String sharedContentLink;
    @Nonnull
    protected final LinkAudience newValue;
    @Nullable
    protected final LinkAudience previousValue;

    /**
     * Changed the audience of the shared link.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param newValue  New link audience value. Must not be {@code null}.
     * @param sharedContentLink  Shared content link.
     * @param previousValue  Previous link audience value.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsChangeAudienceDetails(@Nonnull AccessLevel sharedContentAccessLevel, @Nonnull LinkAudience newValue, @Nullable String sharedContentLink, @Nullable LinkAudience previousValue) {
        if (sharedContentAccessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = sharedContentAccessLevel;
        this.sharedContentLink = sharedContentLink;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Changed the audience of the shared link.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param newValue  New link audience value. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkSettingsChangeAudienceDetails(@Nonnull AccessLevel sharedContentAccessLevel, @Nonnull LinkAudience newValue) {
        this(sharedContentAccessLevel, newValue, null, null);
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
     * New link audience value.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public LinkAudience getNewValue() {
        return newValue;
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
     * Previous link audience value.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkAudience getPreviousValue() {
        return previousValue;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param sharedContentAccessLevel  Shared content access level. Must not be
     *     {@code null}.
     * @param newValue  New link audience value. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel sharedContentAccessLevel, LinkAudience newValue) {
        return new Builder(sharedContentAccessLevel, newValue);
    }

    /**
     * Builder for {@link SharedLinkSettingsChangeAudienceDetails}.
     */
    public static class Builder {
        protected final AccessLevel sharedContentAccessLevel;
        protected final LinkAudience newValue;

        protected String sharedContentLink;
        protected LinkAudience previousValue;

        protected Builder(AccessLevel sharedContentAccessLevel, LinkAudience newValue) {
            if (sharedContentAccessLevel == null) {
                throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
            }
            this.sharedContentAccessLevel = sharedContentAccessLevel;
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            this.sharedContentLink = null;
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
         * @param previousValue  Previous link audience value.
         *
         * @return this builder
         */
        public Builder withPreviousValue(LinkAudience previousValue) {
            this.previousValue = previousValue;
            return this;
        }

        /**
         * Builds an instance of {@link SharedLinkSettingsChangeAudienceDetails}
         * configured with this builder's values
         *
         * @return new instance of {@link
         *     SharedLinkSettingsChangeAudienceDetails}
         */
        public SharedLinkSettingsChangeAudienceDetails build() {
            return new SharedLinkSettingsChangeAudienceDetails(sharedContentAccessLevel, newValue, sharedContentLink, previousValue);
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
            SharedLinkSettingsChangeAudienceDetails other = (SharedLinkSettingsChangeAudienceDetails) obj;
            return ((this.sharedContentAccessLevel == other.sharedContentAccessLevel) || (this.sharedContentAccessLevel.equals(other.sharedContentAccessLevel)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.sharedContentLink == other.sharedContentLink) || (this.sharedContentLink != null && this.sharedContentLink.equals(other.sharedContentLink)))
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
    static class Serializer extends StructSerializer<SharedLinkSettingsChangeAudienceDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkSettingsChangeAudienceDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(value.sharedContentAccessLevel, g);
            g.writeFieldName("new_value");
            LinkAudience.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.sharedContentLink != null) {
                g.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedContentLink, g);
            }
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedLinkSettingsChangeAudienceDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedLinkSettingsChangeAudienceDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_sharedContentAccessLevel = null;
                LinkAudience f_newValue = null;
                String f_sharedContentLink = null;
                LinkAudience f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("shared_content_access_level".equals(field)) {
                        f_sharedContentAccessLevel = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = LinkAudience.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("shared_content_link".equals(field)) {
                        f_sharedContentLink = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sharedContentAccessLevel == null) {
                    throw new JsonParseException(p, "Required field \"shared_content_access_level\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new SharedLinkSettingsChangeAudienceDetails(f_sharedContentAccessLevel, f_newValue, f_sharedContentLink, f_previousValue);
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
