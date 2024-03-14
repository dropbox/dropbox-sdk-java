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

/**
 * User or team linked app. Used when linked type is missing due to historical
 * data gap.
 */
public class UserOrTeamLinkedAppLogInfo extends AppLogInfo {
    // struct team_log.UserOrTeamLinkedAppLogInfo (team_log_generated.stone)


    /**
     * User or team linked app. Used when linked type is missing due to
     * historical data gap.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param appId  App unique ID.
     * @param displayName  App display name.
     */
    public UserOrTeamLinkedAppLogInfo(String appId, String displayName) {
        super(appId, displayName);
    }

    /**
     * User or team linked app. Used when linked type is missing due to
     * historical data gap.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public UserOrTeamLinkedAppLogInfo() {
        this(null, null);
    }

    /**
     * App unique ID.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getAppId() {
        return appId;
    }

    /**
     * App display name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
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
     * Builder for {@link UserOrTeamLinkedAppLogInfo}.
     */
    public static class Builder extends AppLogInfo.Builder {

        protected Builder() {
        }

        /**
         * Set value for optional field.
         *
         * @param appId  App unique ID.
         *
         * @return this builder
         */
        public Builder withAppId(String appId) {
            super.withAppId(appId);
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
            super.withDisplayName(displayName);
            return this;
        }

        /**
         * Builds an instance of {@link UserOrTeamLinkedAppLogInfo} configured
         * with this builder's values
         *
         * @return new instance of {@link UserOrTeamLinkedAppLogInfo}
         */
        public UserOrTeamLinkedAppLogInfo build() {
            return new UserOrTeamLinkedAppLogInfo(appId, displayName);
        }
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
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
            UserOrTeamLinkedAppLogInfo other = (UserOrTeamLinkedAppLogInfo) obj;
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
    static class Serializer extends StructSerializer<UserOrTeamLinkedAppLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserOrTeamLinkedAppLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("user_or_team_linked_app", g);
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
        public UserOrTeamLinkedAppLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserOrTeamLinkedAppLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("user_or_team_linked_app".equals(tag)) {
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
                value = new UserOrTeamLinkedAppLogInfo(f_appId, f_displayName);
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
