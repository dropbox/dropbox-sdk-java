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
 * The entity who performed the action.
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
public final class ActorLogInfo {
    // union team_log.ActorLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link ActorLogInfo}.
     */
    public enum Tag {
        /**
         * The admin who did the action.
         */
        ADMIN, // UserLogInfo
        /**
         * Anonymous actor.
         */
        ANONYMOUS,
        /**
         * The application who did the action.
         */
        APP, // AppLogInfo
        /**
         * Action done by Dropbox.
         */
        DROPBOX,
        /**
         * Action done by reseller.
         */
        RESELLER, // ResellerLogInfo
        /**
         * The user who did the action.
         */
        USER, // UserLogInfo
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
     * Anonymous actor.
     */
    public static final ActorLogInfo ANONYMOUS = new ActorLogInfo().withTag(Tag.ANONYMOUS);
    /**
     * Action done by Dropbox.
     */
    public static final ActorLogInfo DROPBOX = new ActorLogInfo().withTag(Tag.DROPBOX);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ActorLogInfo OTHER = new ActorLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private UserLogInfo adminValue;
    private AppLogInfo appValue;
    private ResellerLogInfo resellerValue;
    private UserLogInfo userValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ActorLogInfo() {
    }


    /**
     * The entity who performed the action.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ActorLogInfo withTag(Tag _tag) {
        ActorLogInfo result = new ActorLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * The entity who performed the action.
     *
     * @param adminValue  The admin who did the action. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActorLogInfo withTagAndAdmin(Tag _tag, UserLogInfo adminValue) {
        ActorLogInfo result = new ActorLogInfo();
        result._tag = _tag;
        result.adminValue = adminValue;
        return result;
    }

    /**
     * The entity who performed the action.
     *
     * @param appValue  The application who did the action. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActorLogInfo withTagAndApp(Tag _tag, AppLogInfo appValue) {
        ActorLogInfo result = new ActorLogInfo();
        result._tag = _tag;
        result.appValue = appValue;
        return result;
    }

    /**
     * The entity who performed the action.
     *
     * @param resellerValue  Action done by reseller. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActorLogInfo withTagAndReseller(Tag _tag, ResellerLogInfo resellerValue) {
        ActorLogInfo result = new ActorLogInfo();
        result._tag = _tag;
        result.resellerValue = resellerValue;
        return result;
    }

    /**
     * The entity who performed the action.
     *
     * @param userValue  The user who did the action. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ActorLogInfo withTagAndUser(Tag _tag, UserLogInfo userValue) {
        ActorLogInfo result = new ActorLogInfo();
        result._tag = _tag;
        result.userValue = userValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ActorLogInfo}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#ADMIN},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ADMIN},
     *     {@code false} otherwise.
     */
    public boolean isAdmin() {
        return this._tag == Tag.ADMIN;
    }

    /**
     * Returns an instance of {@code ActorLogInfo} that has its tag set to
     * {@link Tag#ADMIN}.
     *
     * <p> The admin who did the action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActorLogInfo} with its tag set to {@link
     *     Tag#ADMIN}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActorLogInfo admin(UserLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndAdmin(Tag.ADMIN, value);
    }

    /**
     * The admin who did the action.
     *
     * <p> This instance must be tagged as {@link Tag#ADMIN}. </p>
     *
     * @return The {@link UserLogInfo} value associated with this instance if
     *     {@link #isAdmin} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAdmin} is {@code false}.
     */
    public UserLogInfo getAdminValue() {
        if (this._tag != Tag.ADMIN) {
            throw new IllegalStateException("Invalid tag: required Tag.ADMIN, but was Tag." + this._tag.name());
        }
        return adminValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#ANONYMOUS},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#ANONYMOUS},
     *     {@code false} otherwise.
     */
    public boolean isAnonymous() {
        return this._tag == Tag.ANONYMOUS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#APP}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#APP},
     *     {@code false} otherwise.
     */
    public boolean isApp() {
        return this._tag == Tag.APP;
    }

    /**
     * Returns an instance of {@code ActorLogInfo} that has its tag set to
     * {@link Tag#APP}.
     *
     * <p> The application who did the action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActorLogInfo} with its tag set to {@link
     *     Tag#APP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActorLogInfo app(AppLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndApp(Tag.APP, value);
    }

    /**
     * The application who did the action.
     *
     * <p> This instance must be tagged as {@link Tag#APP}. </p>
     *
     * @return The {@link AppLogInfo} value associated with this instance if
     *     {@link #isApp} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isApp} is {@code false}.
     */
    public AppLogInfo getAppValue() {
        if (this._tag != Tag.APP) {
            throw new IllegalStateException("Invalid tag: required Tag.APP, but was Tag." + this._tag.name());
        }
        return appValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#DROPBOX},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#DROPBOX},
     *     {@code false} otherwise.
     */
    public boolean isDropbox() {
        return this._tag == Tag.DROPBOX;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#RESELLER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#RESELLER},
     *     {@code false} otherwise.
     */
    public boolean isReseller() {
        return this._tag == Tag.RESELLER;
    }

    /**
     * Returns an instance of {@code ActorLogInfo} that has its tag set to
     * {@link Tag#RESELLER}.
     *
     * <p> Action done by reseller. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActorLogInfo} with its tag set to {@link
     *     Tag#RESELLER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActorLogInfo reseller(ResellerLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndReseller(Tag.RESELLER, value);
    }

    /**
     * Action done by reseller.
     *
     * <p> This instance must be tagged as {@link Tag#RESELLER}. </p>
     *
     * @return The {@link ResellerLogInfo} value associated with this instance
     *     if {@link #isReseller} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isReseller} is {@code false}.
     */
    public ResellerLogInfo getResellerValue() {
        if (this._tag != Tag.RESELLER) {
            throw new IllegalStateException("Invalid tag: required Tag.RESELLER, but was Tag." + this._tag.name());
        }
        return resellerValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#USER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#USER},
     *     {@code false} otherwise.
     */
    public boolean isUser() {
        return this._tag == Tag.USER;
    }

    /**
     * Returns an instance of {@code ActorLogInfo} that has its tag set to
     * {@link Tag#USER}.
     *
     * <p> The user who did the action. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ActorLogInfo} with its tag set to {@link
     *     Tag#USER}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ActorLogInfo user(UserLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ActorLogInfo().withTagAndUser(Tag.USER, value);
    }

    /**
     * The user who did the action.
     *
     * <p> This instance must be tagged as {@link Tag#USER}. </p>
     *
     * @return The {@link UserLogInfo} value associated with this instance if
     *     {@link #isUser} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUser} is {@code false}.
     */
    public UserLogInfo getUserValue() {
        if (this._tag != Tag.USER) {
            throw new IllegalStateException("Invalid tag: required Tag.USER, but was Tag." + this._tag.name());
        }
        return userValue;
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
            adminValue,
            appValue,
            resellerValue,
            userValue
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
        else if (obj instanceof ActorLogInfo) {
            ActorLogInfo other = (ActorLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ADMIN:
                    return (this.adminValue == other.adminValue) || (this.adminValue.equals(other.adminValue));
                case ANONYMOUS:
                    return true;
                case APP:
                    return (this.appValue == other.appValue) || (this.appValue.equals(other.appValue));
                case DROPBOX:
                    return true;
                case RESELLER:
                    return (this.resellerValue == other.resellerValue) || (this.resellerValue.equals(other.resellerValue));
                case USER:
                    return (this.userValue == other.userValue) || (this.userValue.equals(other.userValue));
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
    static class Serializer extends UnionSerializer<ActorLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ActorLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ADMIN: {
                    g.writeStartObject();
                    writeTag("admin", g);
                    g.writeFieldName("admin");
                    UserLogInfo.Serializer.INSTANCE.serialize(value.adminValue, g);
                    g.writeEndObject();
                    break;
                }
                case ANONYMOUS: {
                    g.writeString("anonymous");
                    break;
                }
                case APP: {
                    g.writeStartObject();
                    writeTag("app", g);
                    g.writeFieldName("app");
                    AppLogInfo.Serializer.INSTANCE.serialize(value.appValue, g);
                    g.writeEndObject();
                    break;
                }
                case DROPBOX: {
                    g.writeString("dropbox");
                    break;
                }
                case RESELLER: {
                    g.writeStartObject();
                    writeTag("reseller", g);
                    ResellerLogInfo.Serializer.INSTANCE.serialize(value.resellerValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case USER: {
                    g.writeStartObject();
                    writeTag("user", g);
                    g.writeFieldName("user");
                    UserLogInfo.Serializer.INSTANCE.serialize(value.userValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ActorLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            ActorLogInfo value;
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
            else if ("admin".equals(tag)) {
                UserLogInfo fieldValue = null;
                expectField("admin", p);
                fieldValue = UserLogInfo.Serializer.INSTANCE.deserialize(p);
                value = ActorLogInfo.admin(fieldValue);
            }
            else if ("anonymous".equals(tag)) {
                value = ActorLogInfo.ANONYMOUS;
            }
            else if ("app".equals(tag)) {
                AppLogInfo fieldValue = null;
                expectField("app", p);
                fieldValue = AppLogInfo.Serializer.INSTANCE.deserialize(p);
                value = ActorLogInfo.app(fieldValue);
            }
            else if ("dropbox".equals(tag)) {
                value = ActorLogInfo.DROPBOX;
            }
            else if ("reseller".equals(tag)) {
                ResellerLogInfo fieldValue = null;
                fieldValue = ResellerLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = ActorLogInfo.reseller(fieldValue);
            }
            else if ("user".equals(tag)) {
                UserLogInfo fieldValue = null;
                expectField("user", p);
                fieldValue = UserLogInfo.Serializer.INSTANCE.deserialize(p);
                value = ActorLogInfo.user(fieldValue);
            }
            else {
                value = ActorLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
