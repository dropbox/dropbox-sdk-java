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
import javax.annotation.Nullable;

public class UpdateTemplateArg {
    // struct file_properties.UpdateTemplateArg (file_properties.stone)

    protected final String templateId;
    protected final String name;
    protected final String description;
    protected final List<PropertyFieldTemplate> addFields;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     * @param name  A display name for the template. template names can be up to
     *     256 bytes.
     * @param description  Description for the new template. Template
     *     descriptions can be up to 1024 bytes.
     * @param addFields  Property field templates to be added to the group
     *     template. There can be up to 32 properties in a single template. Must
     *     not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateTemplateArg(@Nonnull String templateId, @Nullable String name, @Nullable String description, @Nullable List<PropertyFieldTemplate> addFields) {
        if (templateId == null) {
            throw new IllegalArgumentException("Required value for 'templateId' is null");
        }
        if (templateId.length() < 1) {
            throw new IllegalArgumentException("String 'templateId' is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", templateId)) {
            throw new IllegalArgumentException("String 'templateId' does not match pattern");
        }
        this.templateId = templateId;
        this.name = name;
        this.description = description;
        if (addFields != null) {
            for (PropertyFieldTemplate x : addFields) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'addFields' is null");
                }
            }
        }
        this.addFields = addFields;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param templateId  An identifier for template added by  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateTemplateArg(@Nonnull String templateId) {
        this(templateId, null, null, null);
    }

    /**
     * An identifier for template added by  See {@link
     * DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)} or
     * {@link
     * DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTemplateId() {
        return templateId;
    }

    /**
     * A display name for the template. template names can be up to 256 bytes.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Description for the new template. Template descriptions can be up to 1024
     * bytes.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Property field templates to be added to the group template. There can be
     * up to 32 properties in a single template.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<PropertyFieldTemplate> getAddFields() {
        return addFields;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String templateId) {
        return new Builder(templateId);
    }

    /**
     * Builder for {@link UpdateTemplateArg}.
     */
    public static class Builder {
        protected final String templateId;

        protected String name;
        protected String description;
        protected List<PropertyFieldTemplate> addFields;

        protected Builder(String templateId) {
            if (templateId == null) {
                throw new IllegalArgumentException("Required value for 'templateId' is null");
            }
            if (templateId.length() < 1) {
                throw new IllegalArgumentException("String 'templateId' is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", templateId)) {
                throw new IllegalArgumentException("String 'templateId' does not match pattern");
            }
            this.templateId = templateId;
            this.name = null;
            this.description = null;
            this.addFields = null;
        }

        /**
         * Set value for optional field.
         *
         * @param name  A display name for the template. template names can be
         *     up to 256 bytes.
         *
         * @return this builder
         */
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param description  Description for the new template. Template
         *     descriptions can be up to 1024 bytes.
         *
         * @return this builder
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param addFields  Property field templates to be added to the group
         *     template. There can be up to 32 properties in a single template.
         *     Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAddFields(List<PropertyFieldTemplate> addFields) {
            if (addFields != null) {
                for (PropertyFieldTemplate x : addFields) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'addFields' is null");
                    }
                }
            }
            this.addFields = addFields;
            return this;
        }

        /**
         * Builds an instance of {@link UpdateTemplateArg} configured with this
         * builder's values
         *
         * @return new instance of {@link UpdateTemplateArg}
         */
        public UpdateTemplateArg build() {
            return new UpdateTemplateArg(templateId, name, description, addFields);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            templateId,
            name,
            description,
            addFields
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
            UpdateTemplateArg other = (UpdateTemplateArg) obj;
            return ((this.templateId == other.templateId) || (this.templateId.equals(other.templateId)))
                && ((this.name == other.name) || (this.name != null && this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
                && ((this.addFields == other.addFields) || (this.addFields != null && this.addFields.equals(other.addFields)))
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
    public static class Serializer extends StructSerializer<UpdateTemplateArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateTemplateArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("template_id");
            StoneSerializers.string().serialize(value.templateId, g);
            if (value.name != null) {
                g.writeFieldName("name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.name, g);
            }
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (value.addFields != null) {
                g.writeFieldName("add_fields");
                StoneSerializers.nullable(StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE)).serialize(value.addFields, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UpdateTemplateArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UpdateTemplateArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_templateId = null;
                String f_name = null;
                String f_description = null;
                List<PropertyFieldTemplate> f_addFields = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("template_id".equals(field)) {
                        f_templateId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("add_fields".equals(field)) {
                        f_addFields = StoneSerializers.nullable(StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_templateId == null) {
                    throw new JsonParseException(p, "Required field \"template_id\" missing.");
                }
                value = new UpdateTemplateArg(f_templateId, f_name, f_description, f_addFields);
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
