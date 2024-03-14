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

public class OverwritePropertyGroupArg {
    // struct file_properties.OverwritePropertyGroupArg (file_properties.stone)

    protected final String path;
    protected final List<PropertyGroup> propertyGroups;

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyGroups  The property groups "snapshot" updates to force
     *     apply. No two groups in the input should  refer to the same template.
     *     Must contain at least 1 items, not contain a {@code null} item, and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public OverwritePropertyGroupArg(@javax.annotation.Nonnull String path, @javax.annotation.Nonnull List<PropertyGroup> propertyGroups) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (propertyGroups == null) {
            throw new IllegalArgumentException("Required value for 'propertyGroups' is null");
        }
        if (propertyGroups.size() < 1) {
            throw new IllegalArgumentException("List 'propertyGroups' has fewer than 1 items");
        }
        for (PropertyGroup x : propertyGroups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
            }
        }
        this.propertyGroups = propertyGroups;
    }

    /**
     * A unique identifier for the file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPath() {
        return path;
    }

    /**
     * The property groups "snapshot" updates to force apply. No two groups in
     * the input should  refer to the same template.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            propertyGroups
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
            OverwritePropertyGroupArg other = (OverwritePropertyGroupArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups.equals(other.propertyGroups)))
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
    public static class Serializer extends StructSerializer<OverwritePropertyGroupArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(OverwritePropertyGroupArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("property_groups");
            StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).serialize(value.propertyGroups, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public OverwritePropertyGroupArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            OverwritePropertyGroupArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                List<PropertyGroup> f_propertyGroups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_propertyGroups == null) {
                    throw new JsonParseException(p, "Required field \"property_groups\" missing.");
                }
                value = new OverwritePropertyGroupArg(f_path, f_propertyGroups);
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
