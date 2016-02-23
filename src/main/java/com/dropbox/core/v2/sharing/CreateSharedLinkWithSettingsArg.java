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

public class CreateSharedLinkWithSettingsArg {
    // struct CreateSharedLinkWithSettingsArg

    private final String path;
    private final SharedLinkSettings settings;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static CreateSharedLinkWithSettingsArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<CreateSharedLinkWithSettingsArg> _JSON_WRITER = new JsonWriter<CreateSharedLinkWithSettingsArg>() {
        public final void write(CreateSharedLinkWithSettingsArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            CreateSharedLinkWithSettingsArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(CreateSharedLinkWithSettingsArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            if (x.settings != null) {
                g.writeFieldName("settings");
                SharedLinkSettings._JSON_WRITER.write(x.settings, g);
            }
        }
    };

    public static final JsonReader<CreateSharedLinkWithSettingsArg> _JSON_READER = new JsonReader<CreateSharedLinkWithSettingsArg>() {
        public final CreateSharedLinkWithSettingsArg read(JsonParser parser) throws IOException, JsonReadException {
            CreateSharedLinkWithSettingsArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final CreateSharedLinkWithSettingsArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            SharedLinkSettings settings = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("settings".equals(fieldName)) {
                    settings = SharedLinkSettings._JSON_READER
                        .readField(parser, "settings", settings);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new CreateSharedLinkWithSettingsArg(path, settings);
        }
    };
}
