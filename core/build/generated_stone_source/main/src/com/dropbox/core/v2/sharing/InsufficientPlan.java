/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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

public class InsufficientPlan {
    // struct sharing.InsufficientPlan (sharing_folders.stone)

    protected final String message;
    protected final String upsellUrl;

    /**
     *
     * @param message  A message to tell the user to upgrade in order to support
     *     expected action. Must not be {@code null}.
     * @param upsellUrl  A URL to send the user to in order to obtain the
     *     account type they need, e.g. upgrading. Absent if there is no action
     *     the user can take to upgrade.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InsufficientPlan(@Nonnull String message, @Nullable String upsellUrl) {
        if (message == null) {
            throw new IllegalArgumentException("Required value for 'message' is null");
        }
        this.message = message;
        this.upsellUrl = upsellUrl;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param message  A message to tell the user to upgrade in order to support
     *     expected action. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InsufficientPlan(@Nonnull String message) {
        this(message, null);
    }

    /**
     * A message to tell the user to upgrade in order to support expected
     * action.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getMessage() {
        return message;
    }

    /**
     * A URL to send the user to in order to obtain the account type they need,
     * e.g. upgrading. Absent if there is no action the user can take to
     * upgrade.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getUpsellUrl() {
        return upsellUrl;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            message,
            upsellUrl
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
            InsufficientPlan other = (InsufficientPlan) obj;
            return ((this.message == other.message) || (this.message.equals(other.message)))
                && ((this.upsellUrl == other.upsellUrl) || (this.upsellUrl != null && this.upsellUrl.equals(other.upsellUrl)))
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
    static class Serializer extends StructSerializer<InsufficientPlan> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InsufficientPlan value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("message");
            StoneSerializers.string().serialize(value.message, g);
            if (value.upsellUrl != null) {
                g.writeFieldName("upsell_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.upsellUrl, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public InsufficientPlan deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            InsufficientPlan value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_message = null;
                String f_upsellUrl = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("message".equals(field)) {
                        f_message = StoneSerializers.string().deserialize(p);
                    }
                    else if ("upsell_url".equals(field)) {
                        f_upsellUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_message == null) {
                    throw new JsonParseException(p, "Required field \"message\" missing.");
                }
                value = new InsufficientPlan(f_message, f_upsellUrl);
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
