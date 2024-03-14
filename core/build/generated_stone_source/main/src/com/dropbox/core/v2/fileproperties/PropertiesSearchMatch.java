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

public class PropertiesSearchMatch {
    // struct file_properties.PropertiesSearchMatch (file_properties.stone)

    protected final String id;
    protected final String path;
    protected final boolean isDeleted;
    protected final List<PropertyGroup> propertyGroups;

    /**
     *
     * @param id  The ID for the matched file or folder. Must have length of at
     *     least 1 and not be {@code null}.
     * @param path  The path for the matched file or folder. Must not be {@code
     *     null}.
     * @param isDeleted  Whether the file or folder is deleted.
     * @param propertyGroups  List of custom property groups associated with the
     *     file. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchMatch(String id, String path, boolean isDeleted, List<PropertyGroup> propertyGroups) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.id = id;
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = path;
        this.isDeleted = isDeleted;
        if (propertyGroups == null) {
            throw new IllegalArgumentException("Required value for 'propertyGroups' is null");
        }
        for (PropertyGroup x : propertyGroups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
            }
        }
        this.propertyGroups = propertyGroups;
    }

    /**
     * The ID for the matched file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * The path for the matched file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Whether the file or folder is deleted.
     *
     * @return value for this field.
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * List of custom property groups associated with the file.
     *
     * @return value for this field, never {@code null}.
     */
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
            path,
            isDeleted,
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
            PropertiesSearchMatch other = (PropertiesSearchMatch) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.path == other.path) || (this.path.equals(other.path)))
                && (this.isDeleted == other.isDeleted)
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
    static class Serializer extends StructSerializer<PropertiesSearchMatch> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchMatch value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("is_deleted");
            StoneSerializers.boolean_().serialize(value.isDeleted, g);
            g.writeFieldName("property_groups");
            StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).serialize(value.propertyGroups, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertiesSearchMatch deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertiesSearchMatch value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_path = null;
                Boolean f_isDeleted = null;
                List<PropertyGroup> f_propertyGroups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_deleted".equals(field)) {
                        f_isDeleted = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.list(PropertyGroup.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_isDeleted == null) {
                    throw new JsonParseException(p, "Required field \"is_deleted\" missing.");
                }
                if (f_propertyGroups == null) {
                    throw new JsonParseException(p, "Required field \"property_groups\" missing.");
                }
                value = new PropertiesSearchMatch(f_id, f_path, f_isDeleted, f_propertyGroups);
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
