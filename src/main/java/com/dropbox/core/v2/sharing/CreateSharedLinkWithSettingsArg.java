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

@JsonSerialize(using=CreateSharedLinkWithSettingsArg.Serializer.class)
@JsonDeserialize(using=CreateSharedLinkWithSettingsArg.Deserializer.class)
class CreateSharedLinkWithSettingsArg {
    // struct CreateSharedLinkWithSettingsArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final SharedLinkSettings settings;

    /**
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param settings  The requested settings for the newly created shared
     *     link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkWithSettingsArg(String path, SharedLinkSettings settings) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.settings = settings;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkWithSettingsArg(String path) {
        this(path, null);
    }

    /**
     * The path to be shared by the shared link
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The requested settings for the newly created shared link
     *
     * @return value for this field, or {@code null} if not present.
     */
    public SharedLinkSettings getSettings() {
        return settings;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
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
            CreateSharedLinkWithSettingsArg other = (CreateSharedLinkWithSettingsArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.settings == other.settings) || (this.settings != null && this.settings.equals(other.settings)))
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

    static final class Serializer extends StructJsonSerializer<CreateSharedLinkWithSettingsArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(CreateSharedLinkWithSettingsArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(CreateSharedLinkWithSettingsArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<CreateSharedLinkWithSettingsArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(CreateSharedLinkWithSettingsArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            if (value.settings != null) {
                g.writeObjectField("settings", value.settings);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<CreateSharedLinkWithSettingsArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(CreateSharedLinkWithSettingsArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(CreateSharedLinkWithSettingsArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<CreateSharedLinkWithSettingsArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public CreateSharedLinkWithSettingsArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            SharedLinkSettings settings = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
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

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new CreateSharedLinkWithSettingsArg(path, settings);
        }
    }
}
