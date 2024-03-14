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

/**
 * Triggered security alert.
 */
public class AdminAlertingTriggeredAlertDetails {
    // struct team_log.AdminAlertingTriggeredAlertDetails (team_log_generated.stone)

    protected final String alertName;
    protected final AdminAlertSeverityEnum alertSeverity;
    protected final AdminAlertCategoryEnum alertCategory;
    protected final String alertInstanceId;

    /**
     * Triggered security alert.
     *
     * @param alertName  Alert name. Must not be {@code null}.
     * @param alertSeverity  Alert severity. Must not be {@code null}.
     * @param alertCategory  Alert category. Must not be {@code null}.
     * @param alertInstanceId  Alert ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AdminAlertingTriggeredAlertDetails(@javax.annotation.Nonnull String alertName, @javax.annotation.Nonnull AdminAlertSeverityEnum alertSeverity, @javax.annotation.Nonnull AdminAlertCategoryEnum alertCategory, @javax.annotation.Nonnull String alertInstanceId) {
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
    }

    /**
     * Alert name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAlertName() {
        return alertName;
    }

    /**
     * Alert severity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public AdminAlertSeverityEnum getAlertSeverity() {
        return alertSeverity;
    }

    /**
     * Alert category.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public AdminAlertCategoryEnum getAlertCategory() {
        return alertCategory;
    }

    /**
     * Alert ID.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAlertInstanceId() {
        return alertInstanceId;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            alertName,
            alertSeverity,
            alertCategory,
            alertInstanceId
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
            AdminAlertingTriggeredAlertDetails other = (AdminAlertingTriggeredAlertDetails) obj;
            return ((this.alertName == other.alertName) || (this.alertName.equals(other.alertName)))
                && ((this.alertSeverity == other.alertSeverity) || (this.alertSeverity.equals(other.alertSeverity)))
                && ((this.alertCategory == other.alertCategory) || (this.alertCategory.equals(other.alertCategory)))
                && ((this.alertInstanceId == other.alertInstanceId) || (this.alertInstanceId.equals(other.alertInstanceId)))
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
    static class Serializer extends StructSerializer<AdminAlertingTriggeredAlertDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertingTriggeredAlertDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AdminAlertingTriggeredAlertDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AdminAlertingTriggeredAlertDetails value;
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
                value = new AdminAlertingTriggeredAlertDetails(f_alertName, f_alertSeverity, f_alertCategory, f_alertInstanceId);
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
