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

/**
 * Changed an alert setting.
 */
public class AdminAlertingChangedAlertConfigDetails {
    // struct team_log.AdminAlertingChangedAlertConfigDetails (team_log_generated.stone)

    protected final String alertName;
    protected final AdminAlertingAlertConfiguration previousAlertConfig;
    protected final AdminAlertingAlertConfiguration newAlertConfig;

    /**
     * Changed an alert setting.
     *
     * @param alertName  Alert Name. Must not be {@code null}.
     * @param previousAlertConfig  Previous alert configuration. Must not be
     *     {@code null}.
     * @param newAlertConfig  New alert configuration. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AdminAlertingChangedAlertConfigDetails(@Nonnull String alertName, @Nonnull AdminAlertingAlertConfiguration previousAlertConfig, @Nonnull AdminAlertingAlertConfiguration newAlertConfig) {
        if (alertName == null) {
            throw new IllegalArgumentException("Required value for 'alertName' is null");
        }
        this.alertName = alertName;
        if (previousAlertConfig == null) {
            throw new IllegalArgumentException("Required value for 'previousAlertConfig' is null");
        }
        this.previousAlertConfig = previousAlertConfig;
        if (newAlertConfig == null) {
            throw new IllegalArgumentException("Required value for 'newAlertConfig' is null");
        }
        this.newAlertConfig = newAlertConfig;
    }

    /**
     * Alert Name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAlertName() {
        return alertName;
    }

    /**
     * Previous alert configuration.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertingAlertConfiguration getPreviousAlertConfig() {
        return previousAlertConfig;
    }

    /**
     * New alert configuration.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertingAlertConfiguration getNewAlertConfig() {
        return newAlertConfig;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            alertName,
            previousAlertConfig,
            newAlertConfig
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
            AdminAlertingChangedAlertConfigDetails other = (AdminAlertingChangedAlertConfigDetails) obj;
            return ((this.alertName == other.alertName) || (this.alertName.equals(other.alertName)))
                && ((this.previousAlertConfig == other.previousAlertConfig) || (this.previousAlertConfig.equals(other.previousAlertConfig)))
                && ((this.newAlertConfig == other.newAlertConfig) || (this.newAlertConfig.equals(other.newAlertConfig)))
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
    static class Serializer extends StructSerializer<AdminAlertingChangedAlertConfigDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertingChangedAlertConfigDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("alert_name");
            StoneSerializers.string().serialize(value.alertName, g);
            g.writeFieldName("previous_alert_config");
            AdminAlertingAlertConfiguration.Serializer.INSTANCE.serialize(value.previousAlertConfig, g);
            g.writeFieldName("new_alert_config");
            AdminAlertingAlertConfiguration.Serializer.INSTANCE.serialize(value.newAlertConfig, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AdminAlertingChangedAlertConfigDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AdminAlertingChangedAlertConfigDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_alertName = null;
                AdminAlertingAlertConfiguration f_previousAlertConfig = null;
                AdminAlertingAlertConfiguration f_newAlertConfig = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("alert_name".equals(field)) {
                        f_alertName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_alert_config".equals(field)) {
                        f_previousAlertConfig = AdminAlertingAlertConfiguration.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_alert_config".equals(field)) {
                        f_newAlertConfig = AdminAlertingAlertConfiguration.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_alertName == null) {
                    throw new JsonParseException(p, "Required field \"alert_name\" missing.");
                }
                if (f_previousAlertConfig == null) {
                    throw new JsonParseException(p, "Required field \"previous_alert_config\" missing.");
                }
                if (f_newAlertConfig == null) {
                    throw new JsonParseException(p, "Required field \"new_alert_config\" missing.");
                }
                value = new AdminAlertingChangedAlertConfigDetails(f_alertName, f_previousAlertConfig, f_newAlertConfig);
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
