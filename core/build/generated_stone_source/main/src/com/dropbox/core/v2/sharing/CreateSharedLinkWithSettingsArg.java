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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class CreateSharedLinkWithSettingsArg {
    // struct sharing.CreateSharedLinkWithSettingsArg (shared_links.stone)

    @Nonnull
    protected final String path;
    @Nullable
    protected final SharedLinkSettings settings;

    /**
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     * @param settings  The requested settings for the newly created shared
     *     link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkWithSettingsArg(@Nonnull String path, @Nullable SharedLinkSettings settings) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        this.settings = settings;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkWithSettingsArg(@Nonnull String path) {
        this(path, null);
    }

    /**
     * The path to be shared by the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * The requested settings for the newly created shared link.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedLinkSettings getSettings() {
        return settings;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.path,
            this.settings
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
    static class Serializer extends StructSerializer<CreateSharedLinkWithSettingsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateSharedLinkWithSettingsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (value.settings != null) {
                g.writeFieldName("settings");
                StoneSerializers.nullableStruct(SharedLinkSettings.Serializer.INSTANCE).serialize(value.settings, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CreateSharedLinkWithSettingsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CreateSharedLinkWithSettingsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                SharedLinkSettings f_settings = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("settings".equals(field)) {
                        f_settings = StoneSerializers.nullableStruct(SharedLinkSettings.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new CreateSharedLinkWithSettingsArg(f_path, f_settings);
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
