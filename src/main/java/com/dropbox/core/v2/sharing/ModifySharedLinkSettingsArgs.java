/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class ModifySharedLinkSettingsArgs {
    // struct ModifySharedLinkSettingsArgs

    protected final String url;
    protected final SharedLinkSettings settings;
    protected final boolean removeExpiration;

    /**
     *
     * @param url  URL of the shared link to change its settings. Must not be
     *     {@code null}.
     * @param settings  Set of settings for the shared link. Must not be {@code
     *     null}.
     * @param removeExpiration  If set to true, removes the expiration of the
     *     shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ModifySharedLinkSettingsArgs(String url, SharedLinkSettings settings, boolean removeExpiration) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (settings == null) {
            throw new IllegalArgumentException("Required value for 'settings' is null");
        }
        this.settings = settings;
        this.removeExpiration = removeExpiration;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param url  URL of the shared link to change its settings. Must not be
     *     {@code null}.
     * @param settings  Set of settings for the shared link. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ModifySharedLinkSettingsArgs(String url, SharedLinkSettings settings) {
        this(url, settings, false);
    }

    /**
     * URL of the shared link to change its settings
     *
     * @return value for this field, never {@code null}.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set of settings for the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    public SharedLinkSettings getSettings() {
        return settings;
    }

    /**
     * If set to true, removes the expiration of the shared link.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getRemoveExpiration() {
        return removeExpiration;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            url,
            settings,
            removeExpiration
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ModifySharedLinkSettingsArgs other = (ModifySharedLinkSettingsArgs) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.settings == other.settings) || (this.settings.equals(other.settings)))
                && (this.removeExpiration == other.removeExpiration)
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
    static final class Serializer extends StructSerializer<ModifySharedLinkSettingsArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ModifySharedLinkSettingsArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("settings");
            SharedLinkSettings.Serializer.INSTANCE.serialize(value.settings, g);
            g.writeFieldName("remove_expiration");
            StoneSerializers.boolean_().serialize(value.removeExpiration, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ModifySharedLinkSettingsArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ModifySharedLinkSettingsArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                SharedLinkSettings f_settings = null;
                Boolean f_removeExpiration = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("settings".equals(field)) {
                        f_settings = SharedLinkSettings.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("remove_expiration".equals(field)) {
                        f_removeExpiration = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_settings == null) {
                    throw new JsonParseException(p, "Required field \"settings\" missing.");
                }
                value = new ModifySharedLinkSettingsArgs(f_url, f_settings, f_removeExpiration);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
