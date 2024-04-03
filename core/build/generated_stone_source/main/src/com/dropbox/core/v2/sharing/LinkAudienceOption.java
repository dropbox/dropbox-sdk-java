/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

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

public class LinkAudienceOption {
    // struct sharing.LinkAudienceOption (shared_links.stone)

    @Nonnull
    protected final LinkAudience audience;
    protected final boolean allowed;
    @Nullable
    protected final LinkAudienceDisallowedReason disallowedReason;

    /**
     *
     * @param audience  Specifies who can access the link. Must not be {@code
     *     null}.
     * @param allowed  Whether the user calling this API can select this
     *     audience option.
     * @param disallowedReason  If {@link LinkAudienceOption#getAllowed} is
     *     {@code false}, this will provide the reason that the user is not
     *     permitted to set the visibility to this policy.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkAudienceOption(@Nonnull LinkAudience audience, boolean allowed, @Nullable LinkAudienceDisallowedReason disallowedReason) {
        if (audience == null) {
            throw new IllegalArgumentException("Required value for 'audience' is null");
        }
        this.audience = audience;
        this.allowed = allowed;
        this.disallowedReason = disallowedReason;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param audience  Specifies who can access the link. Must not be {@code
     *     null}.
     * @param allowed  Whether the user calling this API can select this
     *     audience option.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LinkAudienceOption(@Nonnull LinkAudience audience, boolean allowed) {
        this(audience, allowed, null);
    }

    /**
     * Specifies who can access the link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public LinkAudience getAudience() {
        return audience;
    }

    /**
     * Whether the user calling this API can select this audience option.
     *
     * @return value for this field.
     */
    public boolean getAllowed() {
        return allowed;
    }

    /**
     * If {@link LinkAudienceOption#getAllowed} is {@code false}, this will
     * provide the reason that the user is not permitted to set the visibility
     * to this policy.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public LinkAudienceDisallowedReason getDisallowedReason() {
        return disallowedReason;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.audience,
            this.allowed,
            this.disallowedReason
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
            LinkAudienceOption other = (LinkAudienceOption) obj;
            return ((this.audience == other.audience) || (this.audience.equals(other.audience)))
                && (this.allowed == other.allowed)
                && ((this.disallowedReason == other.disallowedReason) || (this.disallowedReason != null && this.disallowedReason.equals(other.disallowedReason)))
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
    static class Serializer extends StructSerializer<LinkAudienceOption> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkAudienceOption value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("audience");
            LinkAudience.Serializer.INSTANCE.serialize(value.audience, g);
            g.writeFieldName("allowed");
            StoneSerializers.boolean_().serialize(value.allowed, g);
            if (value.disallowedReason != null) {
                g.writeFieldName("disallowed_reason");
                StoneSerializers.nullable(LinkAudienceDisallowedReason.Serializer.INSTANCE).serialize(value.disallowedReason, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LinkAudienceOption deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LinkAudienceOption value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                LinkAudience f_audience = null;
                Boolean f_allowed = null;
                LinkAudienceDisallowedReason f_disallowedReason = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("audience".equals(field)) {
                        f_audience = LinkAudience.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("allowed".equals(field)) {
                        f_allowed = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("disallowed_reason".equals(field)) {
                        f_disallowedReason = StoneSerializers.nullable(LinkAudienceDisallowedReason.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_audience == null) {
                    throw new JsonParseException(p, "Required field \"audience\" missing.");
                }
                if (f_allowed == null) {
                    throw new JsonParseException(p, "Required field \"allowed\" missing.");
                }
                value = new LinkAudienceOption(f_audience, f_allowed, f_disallowedReason);
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
