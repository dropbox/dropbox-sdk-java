/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class ModifySharedLinkSettingsArgs {
    // struct ModifySharedLinkSettingsArgs

    private final String url;
    private final SharedLinkSettings settings;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ModifySharedLinkSettingsArgs fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ModifySharedLinkSettingsArgs> _JSON_WRITER = new JsonWriter<ModifySharedLinkSettingsArgs>() {
        public final void write(ModifySharedLinkSettingsArgs x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ModifySharedLinkSettingsArgs._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ModifySharedLinkSettingsArgs x, JsonGenerator g) throws IOException {
            g.writeFieldName("url");
            g.writeString(x.url);
            g.writeFieldName("settings");
            SharedLinkSettings._JSON_WRITER.write(x.settings, g);
        }
    };

    public static final JsonReader<ModifySharedLinkSettingsArgs> _JSON_READER = new JsonReader<ModifySharedLinkSettingsArgs>() {
        public final ModifySharedLinkSettingsArgs read(JsonParser parser) throws IOException, JsonReadException {
            ModifySharedLinkSettingsArgs result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ModifySharedLinkSettingsArgs readFields(JsonParser parser) throws IOException, JsonReadException {
            String url = null;
            SharedLinkSettings settings = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("url".equals(fieldName)) {
                    url = JsonReader.StringReader
                        .readField(parser, "url", url);
                }
                else if ("settings".equals(fieldName)) {
                    settings = SharedLinkSettings._JSON_READER
                        .readField(parser, "settings", settings);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (url == null) {
                throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
            }
            if (settings == null) {
                throw new JsonReadException("Required field \"settings\" is missing.", parser.getTokenLocation());
            }
            return new ModifySharedLinkSettingsArgs(url, settings);
        }
    };
}
