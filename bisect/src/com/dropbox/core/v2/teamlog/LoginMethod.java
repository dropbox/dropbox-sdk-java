/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public enum LoginMethod {
    // union team_log.LoginMethod (team_log_generated.stone)
    PASSWORD,
    TWO_FACTOR_AUTHENTICATION,
    SAML,
    GOOGLE_OAUTH,
    WEB_SESSION,
    QR_CODE,
    APPLE_OAUTH,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<LoginMethod> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LoginMethod value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case PASSWORD: {
                    g.writeString("password");
                    break;
                }
                case TWO_FACTOR_AUTHENTICATION: {
                    g.writeString("two_factor_authentication");
                    break;
                }
                case SAML: {
                    g.writeString("saml");
                    break;
                }
                case GOOGLE_OAUTH: {
                    g.writeString("google_oauth");
                    break;
                }
                case WEB_SESSION: {
                    g.writeString("web_session");
                    break;
                }
                case QR_CODE: {
                    g.writeString("qr_code");
                    break;
                }
                case APPLE_OAUTH: {
                    g.writeString("apple_oauth");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LoginMethod deserialize(JsonParser p) throws IOException, JsonParseException {
            LoginMethod value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("password".equals(tag)) {
                value = LoginMethod.PASSWORD;
            }
            else if ("two_factor_authentication".equals(tag)) {
                value = LoginMethod.TWO_FACTOR_AUTHENTICATION;
            }
            else if ("saml".equals(tag)) {
                value = LoginMethod.SAML;
            }
            else if ("google_oauth".equals(tag)) {
                value = LoginMethod.GOOGLE_OAUTH;
            }
            else if ("web_session".equals(tag)) {
                value = LoginMethod.WEB_SESSION;
            }
            else if ("qr_code".equals(tag)) {
                value = LoginMethod.QR_CODE;
            }
            else if ("apple_oauth".equals(tag)) {
                value = LoginMethod.APPLE_OAUTH;
            }
            else {
                value = LoginMethod.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
