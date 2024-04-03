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
 * Linked app for member.
 */
public class AppLinkUserDetails {
    // struct team_log.AppLinkUserDetails (team_log_generated.stone)

    @Nonnull
    protected final AppLogInfo appInfo;

    /**
     * Linked app for member.
     *
     * @param appInfo  Relevant application details. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AppLinkUserDetails(@Nonnull AppLogInfo appInfo) {
        if (appInfo == null) {
            throw new IllegalArgumentException("Required value for 'appInfo' is null");
        }
        this.appInfo = appInfo;
    }

    /**
     * Relevant application details.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AppLogInfo getAppInfo() {
        return appInfo;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.appInfo
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
            AppLinkUserDetails other = (AppLinkUserDetails) obj;
            return (this.appInfo == other.appInfo) || (this.appInfo.equals(other.appInfo));
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
    static class Serializer extends StructSerializer<AppLinkUserDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AppLinkUserDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("app_info");
            AppLogInfo.Serializer.INSTANCE.serialize(value.appInfo, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public AppLinkUserDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            AppLinkUserDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AppLogInfo f_appInfo = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("app_info".equals(field)) {
                        f_appInfo = AppLogInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_appInfo == null) {
                    throw new JsonParseException(p, "Required field \"app_info\" missing.");
                }
                value = new AppLinkUserDetails(f_appInfo);
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
