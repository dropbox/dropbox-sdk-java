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
 * The device sessions that user is linked to.
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
public final class LinkedDeviceLogInfo {
    // union team_log.LinkedDeviceLogInfo (team_log_generated.stone)

    /**
     * Discriminating tag type for {@link LinkedDeviceLogInfo}.
     */
    public enum Tag {
        /**
         * desktop device session's details.
         */
        DESKTOP_DEVICE_SESSION, // DesktopDeviceSessionLogInfo
        /**
         * legacy device session's details.
         */
        LEGACY_DEVICE_SESSION, // LegacyDeviceSessionLogInfo
        /**
         * mobile device session's details.
         */
        MOBILE_DEVICE_SESSION, // MobileDeviceSessionLogInfo
        /**
         * web device session's details.
         */
        WEB_DEVICE_SESSION, // WebDeviceSessionLogInfo
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
    public static final LinkedDeviceLogInfo OTHER = new LinkedDeviceLogInfo().withTag(Tag.OTHER);

    private Tag _tag;
    private DesktopDeviceSessionLogInfo desktopDeviceSessionValue;
    private LegacyDeviceSessionLogInfo legacyDeviceSessionValue;
    private MobileDeviceSessionLogInfo mobileDeviceSessionValue;
    private WebDeviceSessionLogInfo webDeviceSessionValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private LinkedDeviceLogInfo() {
    }


    /**
     * The device sessions that user is linked to.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private LinkedDeviceLogInfo withTag(Tag _tag) {
        LinkedDeviceLogInfo result = new LinkedDeviceLogInfo();
        result._tag = _tag;
        return result;
    }

    /**
     * The device sessions that user is linked to.
     *
     * @param desktopDeviceSessionValue  desktop device session's details. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkedDeviceLogInfo withTagAndDesktopDeviceSession(Tag _tag, DesktopDeviceSessionLogInfo desktopDeviceSessionValue) {
        LinkedDeviceLogInfo result = new LinkedDeviceLogInfo();
        result._tag = _tag;
        result.desktopDeviceSessionValue = desktopDeviceSessionValue;
        return result;
    }

    /**
     * The device sessions that user is linked to.
     *
     * @param legacyDeviceSessionValue  legacy device session's details. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkedDeviceLogInfo withTagAndLegacyDeviceSession(Tag _tag, LegacyDeviceSessionLogInfo legacyDeviceSessionValue) {
        LinkedDeviceLogInfo result = new LinkedDeviceLogInfo();
        result._tag = _tag;
        result.legacyDeviceSessionValue = legacyDeviceSessionValue;
        return result;
    }

    /**
     * The device sessions that user is linked to.
     *
     * @param mobileDeviceSessionValue  mobile device session's details. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkedDeviceLogInfo withTagAndMobileDeviceSession(Tag _tag, MobileDeviceSessionLogInfo mobileDeviceSessionValue) {
        LinkedDeviceLogInfo result = new LinkedDeviceLogInfo();
        result._tag = _tag;
        result.mobileDeviceSessionValue = mobileDeviceSessionValue;
        return result;
    }

    /**
     * The device sessions that user is linked to.
     *
     * @param webDeviceSessionValue  web device session's details. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LinkedDeviceLogInfo withTagAndWebDeviceSession(Tag _tag, WebDeviceSessionLogInfo webDeviceSessionValue) {
        LinkedDeviceLogInfo result = new LinkedDeviceLogInfo();
        result._tag = _tag;
        result.webDeviceSessionValue = webDeviceSessionValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LinkedDeviceLogInfo}. </p>
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
     * Tag#DESKTOP_DEVICE_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DESKTOP_DEVICE_SESSION}, {@code false} otherwise.
     */
    public boolean isDesktopDeviceSession() {
        return this._tag == Tag.DESKTOP_DEVICE_SESSION;
    }

    /**
     * Returns an instance of {@code LinkedDeviceLogInfo} that has its tag set
     * to {@link Tag#DESKTOP_DEVICE_SESSION}.
     *
     * <p> desktop device session's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkedDeviceLogInfo} with its tag set to
     *     {@link Tag#DESKTOP_DEVICE_SESSION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkedDeviceLogInfo desktopDeviceSession(DesktopDeviceSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndDesktopDeviceSession(Tag.DESKTOP_DEVICE_SESSION, value);
    }

    /**
     * desktop device session's details.
     *
     * <p> This instance must be tagged as {@link Tag#DESKTOP_DEVICE_SESSION}.
     * </p>
     *
     * @return The {@link DesktopDeviceSessionLogInfo} value associated with
     *     this instance if {@link #isDesktopDeviceSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDesktopDeviceSession} is
     *     {@code false}.
     */
    public DesktopDeviceSessionLogInfo getDesktopDeviceSessionValue() {
        if (this._tag != Tag.DESKTOP_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.DESKTOP_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return desktopDeviceSessionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#LEGACY_DEVICE_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#LEGACY_DEVICE_SESSION}, {@code false} otherwise.
     */
    public boolean isLegacyDeviceSession() {
        return this._tag == Tag.LEGACY_DEVICE_SESSION;
    }

    /**
     * Returns an instance of {@code LinkedDeviceLogInfo} that has its tag set
     * to {@link Tag#LEGACY_DEVICE_SESSION}.
     *
     * <p> legacy device session's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkedDeviceLogInfo} with its tag set to
     *     {@link Tag#LEGACY_DEVICE_SESSION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkedDeviceLogInfo legacyDeviceSession(LegacyDeviceSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndLegacyDeviceSession(Tag.LEGACY_DEVICE_SESSION, value);
    }

    /**
     * legacy device session's details.
     *
     * <p> This instance must be tagged as {@link Tag#LEGACY_DEVICE_SESSION}.
     * </p>
     *
     * @return The {@link LegacyDeviceSessionLogInfo} value associated with this
     *     instance if {@link #isLegacyDeviceSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isLegacyDeviceSession} is
     *     {@code false}.
     */
    public LegacyDeviceSessionLogInfo getLegacyDeviceSessionValue() {
        if (this._tag != Tag.LEGACY_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.LEGACY_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return legacyDeviceSessionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MOBILE_DEVICE_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MOBILE_DEVICE_SESSION}, {@code false} otherwise.
     */
    public boolean isMobileDeviceSession() {
        return this._tag == Tag.MOBILE_DEVICE_SESSION;
    }

    /**
     * Returns an instance of {@code LinkedDeviceLogInfo} that has its tag set
     * to {@link Tag#MOBILE_DEVICE_SESSION}.
     *
     * <p> mobile device session's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkedDeviceLogInfo} with its tag set to
     *     {@link Tag#MOBILE_DEVICE_SESSION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkedDeviceLogInfo mobileDeviceSession(MobileDeviceSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndMobileDeviceSession(Tag.MOBILE_DEVICE_SESSION, value);
    }

    /**
     * mobile device session's details.
     *
     * <p> This instance must be tagged as {@link Tag#MOBILE_DEVICE_SESSION}.
     * </p>
     *
     * @return The {@link MobileDeviceSessionLogInfo} value associated with this
     *     instance if {@link #isMobileDeviceSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMobileDeviceSession} is
     *     {@code false}.
     */
    public MobileDeviceSessionLogInfo getMobileDeviceSessionValue() {
        if (this._tag != Tag.MOBILE_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.MOBILE_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return mobileDeviceSessionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#WEB_DEVICE_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#WEB_DEVICE_SESSION}, {@code false} otherwise.
     */
    public boolean isWebDeviceSession() {
        return this._tag == Tag.WEB_DEVICE_SESSION;
    }

    /**
     * Returns an instance of {@code LinkedDeviceLogInfo} that has its tag set
     * to {@link Tag#WEB_DEVICE_SESSION}.
     *
     * <p> web device session's details. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LinkedDeviceLogInfo} with its tag set to
     *     {@link Tag#WEB_DEVICE_SESSION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LinkedDeviceLogInfo webDeviceSession(WebDeviceSessionLogInfo value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LinkedDeviceLogInfo().withTagAndWebDeviceSession(Tag.WEB_DEVICE_SESSION, value);
    }

    /**
     * web device session's details.
     *
     * <p> This instance must be tagged as {@link Tag#WEB_DEVICE_SESSION}. </p>
     *
     * @return The {@link WebDeviceSessionLogInfo} value associated with this
     *     instance if {@link #isWebDeviceSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isWebDeviceSession} is {@code
     *     false}.
     */
    public WebDeviceSessionLogInfo getWebDeviceSessionValue() {
        if (this._tag != Tag.WEB_DEVICE_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.WEB_DEVICE_SESSION, but was Tag." + this._tag.name());
        }
        return webDeviceSessionValue;
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
            this._tag,
            this.desktopDeviceSessionValue,
            this.legacyDeviceSessionValue,
            this.mobileDeviceSessionValue,
            this.webDeviceSessionValue
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
        else if (obj instanceof LinkedDeviceLogInfo) {
            LinkedDeviceLogInfo other = (LinkedDeviceLogInfo) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case DESKTOP_DEVICE_SESSION:
                    return (this.desktopDeviceSessionValue == other.desktopDeviceSessionValue) || (this.desktopDeviceSessionValue.equals(other.desktopDeviceSessionValue));
                case LEGACY_DEVICE_SESSION:
                    return (this.legacyDeviceSessionValue == other.legacyDeviceSessionValue) || (this.legacyDeviceSessionValue.equals(other.legacyDeviceSessionValue));
                case MOBILE_DEVICE_SESSION:
                    return (this.mobileDeviceSessionValue == other.mobileDeviceSessionValue) || (this.mobileDeviceSessionValue.equals(other.mobileDeviceSessionValue));
                case WEB_DEVICE_SESSION:
                    return (this.webDeviceSessionValue == other.webDeviceSessionValue) || (this.webDeviceSessionValue.equals(other.webDeviceSessionValue));
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
    static class Serializer extends UnionSerializer<LinkedDeviceLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LinkedDeviceLogInfo value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case DESKTOP_DEVICE_SESSION: {
                    g.writeStartObject();
                    writeTag("desktop_device_session", g);
                    DesktopDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.desktopDeviceSessionValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case LEGACY_DEVICE_SESSION: {
                    g.writeStartObject();
                    writeTag("legacy_device_session", g);
                    LegacyDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.legacyDeviceSessionValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case MOBILE_DEVICE_SESSION: {
                    g.writeStartObject();
                    writeTag("mobile_device_session", g);
                    MobileDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.mobileDeviceSessionValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case WEB_DEVICE_SESSION: {
                    g.writeStartObject();
                    writeTag("web_device_session", g);
                    WebDeviceSessionLogInfo.Serializer.INSTANCE.serialize(value.webDeviceSessionValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LinkedDeviceLogInfo deserialize(JsonParser p) throws IOException, JsonParseException {
            LinkedDeviceLogInfo value;
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
            else if ("desktop_device_session".equals(tag)) {
                DesktopDeviceSessionLogInfo fieldValue = null;
                fieldValue = DesktopDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = LinkedDeviceLogInfo.desktopDeviceSession(fieldValue);
            }
            else if ("legacy_device_session".equals(tag)) {
                LegacyDeviceSessionLogInfo fieldValue = null;
                fieldValue = LegacyDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = LinkedDeviceLogInfo.legacyDeviceSession(fieldValue);
            }
            else if ("mobile_device_session".equals(tag)) {
                MobileDeviceSessionLogInfo fieldValue = null;
                fieldValue = MobileDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = LinkedDeviceLogInfo.mobileDeviceSession(fieldValue);
            }
            else if ("web_device_session".equals(tag)) {
                WebDeviceSessionLogInfo fieldValue = null;
                fieldValue = WebDeviceSessionLogInfo.Serializer.INSTANCE.deserialize(p, true);
                value = LinkedDeviceLogInfo.webDeviceSession(fieldValue);
            }
            else {
                value = LinkedDeviceLogInfo.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
