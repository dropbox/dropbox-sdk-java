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

/**
 * Indicates the method in which the action was performed.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class AccessMethodLogInfo {
    // union team_log.AccessMethodLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link AccessMethodLogInfo}.
     */
    public enum Tag {
        /**
         * Admin console session details.
         */
        ADMIN_CONSOLE, // WebSessionLogInfo
        /**
         * Api session details.
         */
        API, // ApiSessionLogInfo
        /**
         * Content manager session details.
         */
        CONTENT_MANAGER, // WebSessionLogInfo
        /**
         * End user session details.
         */
        END_USER, // SessionLogInfo
        /**
         * Enterprise console session details.
         */
        ENTERPRISE_CONSOLE, // WebSessionLogInfo
        /**
         * Sign in as session details.
         */
        SIGN_IN_AS, // WebSessionLogInfo
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final AccessMethodLogInfo OTHER = new AccessMethodLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private WebSessionLogInfo adminConsoleValue;
    private ApiSessionLogInfo apiValue;
    private WebSessionLogInfo contentManagerValue;
    private SessionLogInfo endUserValue;
    private WebSessionLogInfo enterpriseConsoleValue;
    private WebSessionLogInfo signInAsValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private AccessMethodLogInfo() {
    }


    /**
     * Indicates the method in which the action was performed.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private AccessMethodLogInfo withTag(Tag _tag) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param adminConsoleValue  Admin console session details. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndAdminConsole(Tag _tag, WebSessionLogInfo adminConsoleValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.adminConsoleValue = adminConsoleValue;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param apiValue  Api session details. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndApi(Tag _tag, ApiSessionLogInfo apiValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.apiValue = apiValue;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param contentManagerValue  Content manager session details. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndContentManager(Tag _tag, WebSessionLogInfo contentManagerValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.contentManagerValue = contentManagerValue;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param endUserValue  End user session details. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndEndUser(Tag _tag, SessionLogInfo endUserValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.endUserValue = endUserValue;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param enterpriseConsoleValue  Enterprise console session details. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndEnterpriseConsole(Tag _tag, WebSessionLogInfo enterpriseConsoleValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.enterpriseConsoleValue = enterpriseConsoleValue;
        return result;
    }

    /**
     * Indicates the method in which the action was performed.
     *
     * @param signInAsValue  Sign in as session details. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private AccessMethodLogInfo withTagAndSignInAs(Tag _tag, WebSessionLogInfo signInAsValue) {
        AccessMethodLogInfo result = new AccessMethodLogInfo();
        result._tag = _tag;
        result.signInAsValue = signInAsValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code AccessMethodLogInfo}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ADMIN_CONSOLE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ADMIN_CONSOLE}, {@code false} otherwise.
     */
    public boolean isAdminConsole() {
        return this._tag == Tag.ADMIN_CONSOLE;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#ADMIN_CONSOLE}.
     *
     * <p> Admin console session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#ADMIN_CONSOLE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo adminConsole(WebSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndAdminConsole(Tag.ADMIN_CONSOLE, value);
    }

    /**
     * Admin console session details.
     *
     * <p> This instance must be tagged as {@link Tag#ADMIN_CONSOLE}. </p>
     *
     * @return The {@link WebSessionLogInfo} value associated with this instance
     *     if {@link #isAdminConsole} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAdminConsole} is {@code
     *     false}.
     */
    public WebSessionLogInfo getAdminConsoleValue() {
        if (this._tag != Tag.ADMIN_CONSOLE) {
            throw new IllegalStateException("Invalid tag: required Tag.ADMIN_CONSOLE, but was Tag." + this._tag.name());
        }
        return adminConsoleValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#API}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#API},
     *     {@code false} otherwise.
     */
    public boolean isApi() {
        return this._tag == Tag.API;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#API}.
     *
     * <p> Api session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#API}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo api(ApiSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndApi(Tag.API, value);
    }

    /**
     * Api session details.
     *
     * <p> This instance must be tagged as {@link Tag#API}. </p>
     *
     * @return The {@link ApiSessionLogInfo} value associated with this instance
     *     if {@link #isApi} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isApi} is {@code false}.
     */
    public ApiSessionLogInfo getApiValue() {
        if (this._tag != Tag.API) {
            throw new IllegalStateException("Invalid tag: required Tag.API, but was Tag." + this._tag.name());
        }
        return apiValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONTENT_MANAGER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONTENT_MANAGER}, {@code false} otherwise.
     */
    public boolean isContentManager() {
        return this._tag == Tag.CONTENT_MANAGER;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#CONTENT_MANAGER}.
     *
     * <p> Content manager session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#CONTENT_MANAGER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo contentManager(WebSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndContentManager(Tag.CONTENT_MANAGER, value);
    }

    /**
     * Content manager session details.
     *
     * <p> This instance must be tagged as {@link Tag#CONTENT_MANAGER}. </p>
     *
     * @return The {@link WebSessionLogInfo} value associated with this instance
     *     if {@link #isContentManager} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isContentManager} is {@code
     *     false}.
     */
    public WebSessionLogInfo getContentManagerValue() {
        if (this._tag != Tag.CONTENT_MANAGER) {
            throw new IllegalStateException("Invalid tag: required Tag.CONTENT_MANAGER, but was Tag." + this._tag.name());
        }
        return contentManagerValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#END_USER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#END_USER},
     *     {@code false} otherwise.
     */
    public boolean isEndUser() {
        return this._tag == Tag.END_USER;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#END_USER}.
     *
     * <p> End user session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#END_USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo endUser(SessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndEndUser(Tag.END_USER, value);
    }

    /**
     * End user session details.
     *
     * <p> This instance must be tagged as {@link Tag#END_USER}. </p>
     *
     * @return The {@link SessionLogInfo} value associated with this instance if
     *     {@link #isEndUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEndUser} is {@code false}.
     */
    public SessionLogInfo getEndUserValue() {
        if (this._tag != Tag.END_USER) {
            throw new IllegalStateException("Invalid tag: required Tag.END_USER, but was Tag." + this._tag.name());
        }
        return endUserValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ENTERPRISE_CONSOLE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ENTERPRISE_CONSOLE}, {@code false} otherwise.
     */
    public boolean isEnterpriseConsole() {
        return this._tag == Tag.ENTERPRISE_CONSOLE;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#ENTERPRISE_CONSOLE}.
     *
     * <p> Enterprise console session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#ENTERPRISE_CONSOLE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo enterpriseConsole(WebSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndEnterpriseConsole(Tag.ENTERPRISE_CONSOLE, value);
    }

    /**
     * Enterprise console session details.
     *
     * <p> This instance must be tagged as {@link Tag#ENTERPRISE_CONSOLE}. </p>
     *
     * @return The {@link WebSessionLogInfo} value associated with this instance
     *     if {@link #isEnterpriseConsole} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEnterpriseConsole} is {@code
     *     false}.
     */
    public WebSessionLogInfo getEnterpriseConsoleValue() {
        if (this._tag != Tag.ENTERPRISE_CONSOLE) {
            throw new IllegalStateException("Invalid tag: required Tag.ENTERPRISE_CONSOLE, but was Tag." + this._tag.name());
        }
        return enterpriseConsoleValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#SIGN_IN_AS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SIGN_IN_AS}, {@code false} otherwise.
     */
    public boolean isSignInAs() {
        return this._tag == Tag.SIGN_IN_AS;
    }

    /**
     * Returns an instance of {@code AccessMethodLogInfo} that has its tag set
     * to {@link Tag#SIGN_IN_AS}.
     *
     * <p> Sign in as session details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AccessMethodLogInfo} with its tag set to
     *     {@link Tag#SIGN_IN_AS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AccessMethodLogInfo signInAs(WebSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AccessMethodLogInfo().withTagAndSignInAs(Tag.SIGN_IN_AS, value);
    }

    /**
     * Sign in as session details.
     *
     * <p> This instance must be tagged as {@link Tag#SIGN_IN_AS}. </p>
     *
     * @return The {@link WebSessionLogInfo} value associated with this instance
     *     if {@link #isSignInAs} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSignInAs} is {@code false}.
     */
    public WebSessionLogInfo getSignInAsValue() {
        if (this._tag != Tag.SIGN_IN_AS) {
            throw new IllegalStateException("Invalid tag: required Tag.SIGN_IN_AS, but was Tag." + this._tag.name());
        }
        return signInAsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            adminConsoleValue,
            apiValue,
            contentManagerValue,
            endUserValue,
            enterpriseConsoleValue,
            signInAsValue
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
        else if (obj instanceof AccessMethodLogInfo) {
            AccessMethodLogInfo other = (AccessMethodLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ADMIN_CONSOLE:
                    return (this.adminConsoleValue == other.adminConsoleValue) || (this.adminConsoleValue.equals(other.adminConsoleValue));
                case API:
                    return (this.apiValue == other.apiValue) || (this.apiValue.equals(other.apiValue));
                case CONTENT_MANAGER:
                    return (this.contentManagerValue == other.contentManagerValue) || (this.contentManagerValue.equals(other.contentManagerValue));
                case END_USER:
                    return (this.endUserValue == other.endUserValue) || (this.endUserValue.equals(other.endUserValue));
                case ENTERPRISE_CONSOLE:
                    return (this.enterpriseConsoleValue == other.enterpriseConsoleValue) || (this.enterpriseConsoleValue.equals(other.enterpriseConsoleValue));
                case SIGN_IN_AS:
                    return (this.signInAsValue == other.signInAsValue) || (this.signInAsValue.equals(other.signInAsValue));
                case OTHER:
                    return true;
                default:
                    return false;
            }
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
    static class Serializer extends UnionSerializer<AccessMethodLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AccessMethodLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ADMIN_CONSOLE: {
                    g.writeStartObject();
                    writeTag("admin_console", g);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(value.adminConsoleValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case API: {
                    g.writeStartObject();
                    writeTag("api", g);
                    ApiSessionLogInfo.Serializer.INSTANCE.serialize(value.apiValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case CONTENT_MANAGER: {
                    g.writeStartObject();
                    writeTag("content_manager", g);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(value.contentManagerValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case END_USER: {
                    g.writeStartObject();
                    writeTag("end_user", g);
                    g.writeFieldName("end_user");
                    SessionLogInfo.Serializer.INSTANCE.serialize(value.endUserValue, g);
                    g.writeEndObject();
                    break;
                }
                case ENTERPRISE_CONSOLE: {
                    g.writeStartObject();
                    writeTag("enterprise_console", g);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(value.enterpriseConsoleValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case SIGN_IN_AS: {
                    g.writeStartObject();
                    writeTag("sign_in_as", g);
                    WebSessionLogInfo.Serializer.INSTANCE.serialize(value.signInAsValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AccessMethodLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            AccessMethodLogInfo value;
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
            else if ("admin_console".equals(tag)) {
                WebSessionLogInfo fieldValue = null;
                fieldValue = WebSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AccessMethodLogInfo.adminConsole(fieldValue);
            }
            else if ("api".equals(tag)) {
                ApiSessionLogInfo fieldValue = null;
                fieldValue = ApiSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AccessMethodLogInfo.api(fieldValue);
            }
            else if ("content_manager".equals(tag)) {
                WebSessionLogInfo fieldValue = null;
                fieldValue = WebSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AccessMethodLogInfo.contentManager(fieldValue);
            }
            else if ("end_user".equals(tag)) {
                SessionLogInfo fieldValue = null;
                expectField("end_user", p);
                fieldValue = SessionLogInfo.Serializer.INSTANCE.deserialize(p);
                value = AccessMethodLogInfo.endUser(fieldValue);
            }
            else if ("enterprise_console".equals(tag)) {
                WebSessionLogInfo fieldValue = null;
                fieldValue = WebSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AccessMethodLogInfo.enterpriseConsole(fieldValue);
            }
            else if ("sign_in_as".equals(tag)) {
                WebSessionLogInfo fieldValue = null;
                fieldValue = WebSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = AccessMethodLogInfo.signInAs(fieldValue);
            }
            else {
                value = AccessMethodLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
