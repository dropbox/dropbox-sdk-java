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
 * Changed app permissions.
 */
public class AppPermissionsChangedDetails {
    // struct team_log.AppPermissionsChangedDetails (team_log_generated.stone)

    @Nullable
    protected final String appName;
    @Nullable
    protected final AdminConsoleAppPermission permission;
    @Nonnull
    protected final AdminConsoleAppPolicy previousValue;
    @Nonnull
    protected final AdminConsoleAppPolicy newValue;

    /**
     * Changed app permissions.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param previousValue  Previous policy. Must not be {@code null}.
     * @param newValue  New policy. Must not be {@code null}.
     * @param appName  Name of the app.
     * @param permission  Permission that was changed.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AppPermissionsChangedDetails(@Nonnull AdminConsoleAppPolicy previousValue, @Nonnull AdminConsoleAppPolicy newValue, @Nullable String appName, @Nullable AdminConsoleAppPermission permission) {
        this.appName = appName;
        this.permission = permission;
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
     * Changed app permissions.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param previousValue  Previous policy. Must not be {@code null}.
     * @param newValue  New policy. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AppPermissionsChangedDetails(@Nonnull AdminConsoleAppPolicy previousValue, @Nonnull AdminConsoleAppPolicy newValue) {
        this(previousValue, newValue, null, null);
    }

    /**
     * Previous policy.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminConsoleAppPolicy getPreviousValue() {
        return previousValue;
    }

    /**
     * New policy.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AdminConsoleAppPolicy getNewValue() {
        return newValue;
    }

    /**
     * Name of the app.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getAppName() {
        return appName;
    }

    /**
     * Permission that was changed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public AdminConsoleAppPermission getPermission() {
        return permission;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param previousValue  Previous policy. Must not be {@code null}.
     * @param newValue  New policy. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AdminConsoleAppPolicy previousValue, AdminConsoleAppPolicy newValue) {
        return new Builder(previousValue, newValue);
    }

    /**
     * Builder for {@link AppPermissionsChangedDetails}.
     */
    public static class Builder {
        protected final AdminConsoleAppPolicy previousValue;
        protected final AdminConsoleAppPolicy newValue;

        protected String appName;
        protected AdminConsoleAppPermission permission;

        protected Builder(AdminConsoleAppPolicy previousValue, AdminConsoleAppPolicy newValue) {
            if (previousValue == null) {
                throw new IllegalArgumentException("Required value for 'previousValue' is null");
            }
            this.previousValue = previousValue;
            if (newValue == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = newValue;
            this.appName = null;
            this.permission = null;
        }

        /**
         * Set value for optional field.
         *
         * @param appName  Name of the app.
         *
         * @return this builder
         */
        public Builder withAppName(String appName) {
            this.appName = appName;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param permission  Permission that was changed.
         *
         * @return this builder
         */
        public Builder withPermission(AdminConsoleAppPermission permission) {
            this.permission = permission;
            return this;
        }

        /**
         * Builds an instance of {@link AppPermissionsChangedDetails} configured
         * with this builder's values
         *
         * @return new instance of {@link AppPermissionsChangedDetails}
         */
        public AppPermissionsChangedDetails build() {
            return new AppPermissionsChangedDetails(previousValue, newValue, appName, permission);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            appName,
            permission,
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
            AppPermissionsChangedDetails other = (AppPermissionsChangedDetails) obj;
            return ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.appName == other.appName) || (this.appName != null && this.appName.equals(other.appName)))
                && ((this.permission == other.permission) || (this.permission != null && this.permission.equals(other.permission)))
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
    static class Serializer extends StructSerializer<AppPermissionsChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AppPermissionsChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            AdminConsoleAppPolicy.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            AdminConsoleAppPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.appName != null) {
                g.writeFieldName("app_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.appName, g);
            }
            if (value.permission != null) {
                g.writeFieldName("permission");
                StoneSerializers.nullable(AdminConsoleAppPermission.Serializer.INSTANCE).serialize(value.permission, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AppPermissionsChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AppPermissionsChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AdminConsoleAppPolicy f_previousValue = null;
                AdminConsoleAppPolicy f_newValue = null;
                String f_appName = null;
                AdminConsoleAppPermission f_permission = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = AdminConsoleAppPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = AdminConsoleAppPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("app_name".equals(field)) {
                        f_appName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("permission".equals(field)) {
                        f_permission = StoneSerializers.nullable(AdminConsoleAppPermission.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new AppPermissionsChangedDetails(f_previousValue, f_newValue, f_appName, f_permission);
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
