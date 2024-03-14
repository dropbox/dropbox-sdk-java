/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

public class RemovePropertiesArg {
    // struct file_properties.RemovePropertiesArg (file_properties.stone)

    protected final String path;
    protected final List<String> propertyTemplateIds;

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyTemplateIds  A list of identifiers for a template created
     *     by {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@code templatesAddForTeam}. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RemovePropertiesArg(@Nonnull String path, @Nonnull List<String> propertyTemplateIds) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (propertyTemplateIds == null) {
            throw new IllegalArgumentException("Required value for 'propertyTemplateIds' is null");
        }
        for (String x : propertyTemplateIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'propertyTemplateIds' is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'propertyTemplateIds' is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", x)) {
                throw new IllegalArgumentException("Stringan item in list 'propertyTemplateIds' does not match pattern");
            }
        }
        this.propertyTemplateIds = propertyTemplateIds;
    }

    /**
     * A unique identifier for the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * A list of identifiers for a template created by {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)} or
     * {@code templatesAddForTeam}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getPropertyTemplateIds() {
        return propertyTemplateIds;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            propertyTemplateIds
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
            RemovePropertiesArg other = (RemovePropertiesArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.propertyTemplateIds == other.propertyTemplateIds) || (this.propertyTemplateIds.equals(other.propertyTemplateIds)))
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
    public static class Serializer extends StructSerializer<RemovePropertiesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RemovePropertiesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("property_template_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.propertyTemplateIds, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RemovePropertiesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RemovePropertiesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                List<String> f_propertyTemplateIds = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("property_template_ids".equals(field)) {
                        f_propertyTemplateIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_propertyTemplateIds == null) {
                    throw new JsonParseException(p, "Required field \"property_template_ids\" missing.");
                }
                value = new RemovePropertiesArg(f_path, f_propertyTemplateIds);
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
