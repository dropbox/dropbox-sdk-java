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
 * Changed an alert state.
 */
public class AdminAlertingAlertStateChangedDetails {
    // struct team_log.AdminAlertingAlertStateChangedDetails (team_log_generated.stone)

    @Nonnull
    protected final String alertName;
    @Nonnull
    protected final AdminAlertSeverityEnum alertSeverity;
    @Nonnull
    protected final AdminAlertCategoryEnum alertCategory;
    @Nonnull
    protected final String alertInstanceId;
    @Nonnull
    protected final AdminAlertGeneralStateEnum previousValue;
    @Nonnull
    protected final AdminAlertGeneralStateEnum newValue;

    /**
     * Changed an alert state.
     *
     * @param alertName  Alert name. Must not be {@code null}.
     * @param alertSeverity  Alert severity. Must not be {@code null}.
     * @param alertCategory  Alert category. Must not be {@code null}.
     * @param alertInstanceId  Alert ID. Must not be {@code null}.
     * @param previousValue  Alert state before the change. Must not be {@code
     *     null}.
     * @param newValue  Alert state after the change. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AdminAlertingAlertStateChangedDetails(@Nonnull String alertName, @Nonnull AdminAlertSeverityEnum alertSeverity, @Nonnull AdminAlertCategoryEnum alertCategory, @Nonnull String alertInstanceId, @Nonnull AdminAlertGeneralStateEnum previousValue, @Nonnull AdminAlertGeneralStateEnum newValue) {
        if (alertName == null) {
            throw new IllegalArgumentException("Required value for 'alertName' is null");
        }
        this.alertName = alertName;
        if (alertSeverity == null) {
            throw new IllegalArgumentException("Required value for 'alertSeverity' is null");
        }
        this.alertSeverity = alertSeverity;
        if (alertCategory == null) {
            throw new IllegalArgumentException("Required value for 'alertCategory' is null");
        }
        this.alertCategory = alertCategory;
        if (alertInstanceId == null) {
            throw new IllegalArgumentException("Required value for 'alertInstanceId' is null");
        }
        this.alertInstanceId = alertInstanceId;
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * Alert name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAlertName() {
        return alertName;
    }

    /**
     * Alert severity.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertSeverityEnum getAlertSeverity() {
        return alertSeverity;
    }

    /**
     * Alert category.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertCategoryEnum getAlertCategory() {
        return alertCategory;
    }

    /**
     * Alert ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAlertInstanceId() {
        return alertInstanceId;
    }

    /**
     * Alert state before the change.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertGeneralStateEnum getPreviousValue() {
        return previousValue;
    }

    /**
     * Alert state after the change.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminAlertGeneralStateEnum getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            alertName,
            alertSeverity,
            alertCategory,
            alertInstanceId,
            previousValue,
            newValue
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
            AdminAlertingAlertStateChangedDetails other = (AdminAlertingAlertStateChangedDetails) obj;
            return ((this.alertName == other.alertName) || (this.alertName.equals(other.alertName)))
                && ((this.alertSeverity == other.alertSeverity) || (this.alertSeverity.equals(other.alertSeverity)))
                && ((this.alertCategory == other.alertCategory) || (this.alertCategory.equals(other.alertCategory)))
                && ((this.alertInstanceId == other.alertInstanceId) || (this.alertInstanceId.equals(other.alertInstanceId)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
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
    static class Serializer extends StructSerializer<AdminAlertingAlertStateChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertingAlertStateChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("alert_name");
            StoneSerializers.string().serialize(value.alertName, g);
            g.writeFieldName("alert_severity");
            AdminAlertSeverityEnum.Serializer.INSTANCE.serialize(value.alertSeverity, g);
            g.writeFieldName("alert_category");
            AdminAlertCategoryEnum.Serializer.INSTANCE.serialize(value.alertCategory, g);
            g.writeFieldName("alert_instance_id");
            StoneSerializers.string().serialize(value.alertInstanceId, g);
            g.writeFieldName("previous_value");
            AdminAlertGeneralStateEnum.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            AdminAlertGeneralStateEnum.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AdminAlertingAlertStateChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AdminAlertingAlertStateChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_alertName = null;
                AdminAlertSeverityEnum f_alertSeverity = null;
                AdminAlertCategoryEnum f_alertCategory = null;
                String f_alertInstanceId = null;
                AdminAlertGeneralStateEnum f_previousValue = null;
                AdminAlertGeneralStateEnum f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("alert_name".equals(field)) {
                        f_alertName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("alert_severity".equals(field)) {
                        f_alertSeverity = AdminAlertSeverityEnum.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("alert_category".equals(field)) {
                        f_alertCategory = AdminAlertCategoryEnum.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("alert_instance_id".equals(field)) {
                        f_alertInstanceId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = AdminAlertGeneralStateEnum.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = AdminAlertGeneralStateEnum.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_alertName == null) {
                    throw new JsonParseException(p, "Required field \"alert_name\" missing.");
                }
                if (f_alertSeverity == null) {
                    throw new JsonParseException(p, "Required field \"alert_severity\" missing.");
                }
                if (f_alertCategory == null) {
                    throw new JsonParseException(p, "Required field \"alert_category\" missing.");
                }
                if (f_alertInstanceId == null) {
                    throw new JsonParseException(p, "Required field \"alert_instance_id\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new AdminAlertingAlertStateChangedDetails(f_alertName, f_alertSeverity, f_alertCategory, f_alertInstanceId, f_previousValue, f_newValue);
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
