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
 * App's logged information.
 */
public class AppLogInfo {
    // struct team_log.AppLogInfo (team_log_generated.stone)

    protected final String appId;
    protected final String displayName;

    /**
     * App's logged information.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param appId  App unique ID.
     * @param displayName  App display name.
     */
    public AppLogInfo(@Nullable String appId, @Nullable String displayName) {
        this.appId = appId;
        this.displayName = displayName;
    }

    /**
     * App's logged information.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public AppLogInfo() {
        this(null, null);
    }

    /**
     * App unique ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getAppId() {
        return appId;
    }

    /**
     * App display name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDisplayName() {
        return displayName;
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
     * Builder for {@link AppLogInfo}.
     */
    public static class Builder {

        protected String appId;
        protected String displayName;

        protected Builder() {
            this.appId = null;
            this.displayName = null;
        }

        /**
         * Set value for optional field.
         *
         * @param appId  App unique ID.
         *
         * @return this builder
         */
        public Builder withAppId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param displayName  App display name.
         *
         * @return this builder
         */
        public Builder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * Builds an instance of {@link AppLogInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link AppLogInfo}
         */
        public AppLogInfo build() {
            return new AppLogInfo(appId, displayName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            appId,
            displayName
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
            AppLogInfo other = (AppLogInfo) obj;
            return ((this.appId == other.appId) || (this.appId != null && this.appId.equals(other.appId)))
                && ((this.displayName == other.displayName) || (this.displayName != null && this.displayName.equals(other.displayName)))
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
    static class Serializer extends StructSerializer<AppLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AppLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (value instanceof UserOrTeamLinkedAppLogInfo) {
                UserOrTeamLinkedAppLogInfo.Serializer.INSTANCE.serialize((UserOrTeamLinkedAppLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof UserLinkedAppLogInfo) {
                UserLinkedAppLogInfo.Serializer.INSTANCE.serialize((UserLinkedAppLogInfo) value, g, collapse);
                return;
            }
            if (value instanceof TeamLinkedAppLogInfo) {
                TeamLinkedAppLogInfo.Serializer.INSTANCE.serialize((TeamLinkedAppLogInfo) value, g, collapse);
                return;
            }
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.appId != null) {
                g.writeFieldName("app_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.appId, g);
            }
            if (value.displayName != null) {
                g.writeFieldName("display_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.displayName, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AppLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AppLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_appId = null;
                String f_displayName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("app_id".equals(field)) {
                        f_appId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new AppLogInfo(f_appId, f_displayName);
            }
            else if ("".equals(tag)) {
                value = Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("user_or_team_linked_app".equals(tag)) {
                value = UserOrTeamLinkedAppLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("user_linked_app".equals(tag)) {
                value = UserLinkedAppLogInfo.Serializer.INSTANCE.deserialize(p, true);
            }
            else if ("team_linked_app".equals(tag)) {
                value = TeamLinkedAppLogInfo.Serializer.INSTANCE.deserialize(p, true);
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
