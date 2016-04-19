/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=ModifySharedLinkSettingsArgs.Serializer.class)
@JsonDeserialize(using=ModifySharedLinkSettingsArgs.Deserializer.class)
class ModifySharedLinkSettingsArgs {
    // struct ModifySharedLinkSettingsArgs

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String url;
    protected final SharedLinkSettings settings;

    /**
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
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (settings == null) {
            throw new IllegalArgumentException("Required value for 'settings' is null");
        }
        this.settings = settings;
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            url,
            settings
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
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ModifySharedLinkSettingsArgs> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ModifySharedLinkSettingsArgs.class);
        }

        public Serializer(boolean unwrapping) {
            super(ModifySharedLinkSettingsArgs.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ModifySharedLinkSettingsArgs> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ModifySharedLinkSettingsArgs value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("url", value.url);
            g.writeObjectField("settings", value.settings);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ModifySharedLinkSettingsArgs> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ModifySharedLinkSettingsArgs.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ModifySharedLinkSettingsArgs.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ModifySharedLinkSettingsArgs> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ModifySharedLinkSettingsArgs deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String url = null;
            SharedLinkSettings settings = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("url".equals(_field)) {
                    url = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("settings".equals(_field)) {
                    settings = _p.readValueAs(SharedLinkSettings.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (url == null) {
                throw new JsonParseException(_p, "Required field \"url\" is missing.");
            }
            if (settings == null) {
                throw new JsonParseException(_p, "Required field \"settings\" is missing.");
            }

            return new ModifySharedLinkSettingsArgs(url, settings);
        }
    }
}
