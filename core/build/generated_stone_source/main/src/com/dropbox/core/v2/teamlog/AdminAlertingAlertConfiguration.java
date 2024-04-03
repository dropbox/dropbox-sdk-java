/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Alert configurations
 */
public class AdminAlertingAlertConfiguration {
    // struct team_log.AdminAlertingAlertConfiguration (team_log_generated.stone)

    @Nullable
    protected final AdminAlertingAlertStatePolicy alertState;
    @Nullable
    protected final AdminAlertingAlertSensitivity sensitivityLevel;
    @Nullable
    protected final RecipientsConfiguration recipientsSettings;
    @Nullable
    protected final String text;
    @Nullable
    protected final String excludedFileExtensions;

    /**
     * Alert configurations
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param alertState  Alert state.
     * @param sensitivityLevel  Sensitivity level.
     * @param recipientsSettings  Recipient settings.
     * @param text  Text.
     * @param excludedFileExtensions  Excluded file extensions.
     */
    public AdminAlertingAlertConfiguration(@Nullable AdminAlertingAlertStatePolicy alertState, @Nullable AdminAlertingAlertSensitivity sensitivityLevel, @Nullable RecipientsConfiguration recipientsSettings, @Nullable String text, @Nullable String excludedFileExtensions) {
        this.alertState = alertState;
        this.sensitivityLevel = sensitivityLevel;
        this.recipientsSettings = recipientsSettings;
        this.text = text;
        this.excludedFileExtensions = excludedFileExtensions;
    }

    /**
     * Alert configurations
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public AdminAlertingAlertConfiguration() {
        this(null, null, null, null, null);
    }

    /**
     * Alert state.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AdminAlertingAlertStatePolicy getAlertState() {
        return alertState;
    }

    /**
     * Sensitivity level.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AdminAlertingAlertSensitivity getSensitivityLevel() {
        return sensitivityLevel;
    }

    /**
     * Recipient settings.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public RecipientsConfiguration getRecipientsSettings() {
        return recipientsSettings;
    }

    /**
     * Text.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getText() {
        return text;
    }

    /**
     * Excluded file extensions.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getExcludedFileExtensions() {
        return excludedFileExtensions;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link AdminAlertingAlertConfiguration}.
     */
    public static class Builder {

        protected AdminAlertingAlertStatePolicy alertState;
        protected AdminAlertingAlertSensitivity sensitivityLevel;
        protected RecipientsConfiguration recipientsSettings;
        protected String text;
        protected String excludedFileExtensions;

        protected Builder() {
            this.alertState = null;
            this.sensitivityLevel = null;
            this.recipientsSettings = null;
            this.text = null;
            this.excludedFileExtensions = null;
        }

        /**
         * Set value for optional field.
         *
         * @param alertState  Alert state.
         *
         * @return this builder
         */
        public Builder withAlertState(AdminAlertingAlertStatePolicy alertState) {
            this.alertState = alertState;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sensitivityLevel  Sensitivity level.
         *
         * @return this builder
         */
        public Builder withSensitivityLevel(AdminAlertingAlertSensitivity sensitivityLevel) {
            this.sensitivityLevel = sensitivityLevel;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param recipientsSettings  Recipient settings.
         *
         * @return this builder
         */
        public Builder withRecipientsSettings(RecipientsConfiguration recipientsSettings) {
            this.recipientsSettings = recipientsSettings;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param text  Text.
         *
         * @return this builder
         */
        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param excludedFileExtensions  Excluded file extensions.
         *
         * @return this builder
         */
        public Builder withExcludedFileExtensions(String excludedFileExtensions) {
            this.excludedFileExtensions = excludedFileExtensions;
            return this;
        }

        /**
         * Builds an instance of {@link AdminAlertingAlertConfiguration}
         * configured with this builder's values
         *
         * @return new instance of {@link AdminAlertingAlertConfiguration}
         */
        public AdminAlertingAlertConfiguration build() {
            return new AdminAlertingAlertConfiguration(alertState, sensitivityLevel, recipientsSettings, text, excludedFileExtensions);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.alertState,
            this.sensitivityLevel,
            this.recipientsSettings,
            this.text,
            this.excludedFileExtensions
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
            AdminAlertingAlertConfiguration other = (AdminAlertingAlertConfiguration) obj;
            return ((this.alertState == other.alertState) || (this.alertState != null && this.alertState.equals(other.alertState)))
                && ((this.sensitivityLevel == other.sensitivityLevel) || (this.sensitivityLevel != null && this.sensitivityLevel.equals(other.sensitivityLevel)))
                && ((this.recipientsSettings == other.recipientsSettings) || (this.recipientsSettings != null && this.recipientsSettings.equals(other.recipientsSettings)))
                && ((this.text == other.text) || (this.text != null && this.text.equals(other.text)))
                && ((this.excludedFileExtensions == other.excludedFileExtensions) || (this.excludedFileExtensions != null && this.excludedFileExtensions.equals(other.excludedFileExtensions)))
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
    static class Serializer extends StructSerializer<AdminAlertingAlertConfiguration> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertingAlertConfiguration value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.alertState != null) {
                g.writeFieldName("alert_state");
                StoneSerializers.nullable(AdminAlertingAlertStatePolicy.Serializer.INSTANCE).serialize(value.alertState, g);
            }
            if (value.sensitivityLevel != null) {
                g.writeFieldName("sensitivity_level");
                StoneSerializers.nullable(AdminAlertingAlertSensitivity.Serializer.INSTANCE).serialize(value.sensitivityLevel, g);
            }
            if (value.recipientsSettings != null) {
                g.writeFieldName("recipients_settings");
                StoneSerializers.nullableStruct(RecipientsConfiguration.Serializer.INSTANCE).serialize(value.recipientsSettings, g);
            }
            if (value.text != null) {
                g.writeFieldName("text");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.text, g);
            }
            if (value.excludedFileExtensions != null) {
                g.writeFieldName("excluded_file_extensions");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.excludedFileExtensions, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AdminAlertingAlertConfiguration deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AdminAlertingAlertConfiguration value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AdminAlertingAlertStatePolicy f_alertState = null;
                AdminAlertingAlertSensitivity f_sensitivityLevel = null;
                RecipientsConfiguration f_recipientsSettings = null;
                String f_text = null;
                String f_excludedFileExtensions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("alert_state".equals(field)) {
                        f_alertState = StoneSerializers.nullable(AdminAlertingAlertStatePolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("sensitivity_level".equals(field)) {
                        f_sensitivityLevel = StoneSerializers.nullable(AdminAlertingAlertSensitivity.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("recipients_settings".equals(field)) {
                        f_recipientsSettings = StoneSerializers.nullableStruct(RecipientsConfiguration.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("text".equals(field)) {
                        f_text = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("excluded_file_extensions".equals(field)) {
                        f_excludedFileExtensions = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new AdminAlertingAlertConfiguration(f_alertState, f_sensitivityLevel, f_recipientsSettings, f_text, f_excludedFileExtensions);
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
