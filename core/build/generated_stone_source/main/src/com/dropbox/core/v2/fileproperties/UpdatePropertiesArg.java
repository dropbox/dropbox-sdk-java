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

public class UpdatePropertiesArg {
    // struct file_properties.UpdatePropertiesArg (file_properties.stone)

    @Nonnull
    protected final String path;
    @Nonnull
    protected final List<PropertyGroupUpdate> updatePropertyGroups;

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param updatePropertyGroups  The property groups "delta" updates to
     *     apply. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdatePropertiesArg(@Nonnull String path, @Nonnull List<PropertyGroupUpdate> updatePropertyGroups) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (updatePropertyGroups == null) {
            throw new IllegalArgumentException("Required value for 'updatePropertyGroups' is null");
        }
        for (PropertyGroupUpdate x : updatePropertyGroups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'updatePropertyGroups' is null");
            }
        }
        this.updatePropertyGroups = updatePropertyGroups;
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
     * The property groups "delta" updates to apply.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<PropertyGroupUpdate> getUpdatePropertyGroups() {
        return updatePropertyGroups;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.path,
            this.updatePropertyGroups
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
            UpdatePropertiesArg other = (UpdatePropertiesArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.updatePropertyGroups == other.updatePropertyGroups) || (this.updatePropertyGroups.equals(other.updatePropertyGroups)))
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
    public static class Serializer extends StructSerializer<UpdatePropertiesArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdatePropertiesArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("update_property_groups");
            StoneSerializers.list(PropertyGroupUpdate.Serializer.INSTANCE).serialize(value.updatePropertyGroups, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UpdatePropertiesArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UpdatePropertiesArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                List<PropertyGroupUpdate> f_updatePropertyGroups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("update_property_groups".equals(field)) {
                        f_updatePropertyGroups = StoneSerializers.list(PropertyGroupUpdate.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_updatePropertyGroups == null) {
                    throw new JsonParseException(p, "Required field \"update_property_groups\" missing.");
                }
                value = new UpdatePropertiesArg(f_path, f_updatePropertyGroups);
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
