/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class RevokeDeviceSessionArg {
    // union team.RevokeDeviceSessionArg (team_devices.stone)

    /**
     * Discriminating tag type for {@link RevokeDeviceSessionArg}.
     */
    public enum Tag {
        /**
         * End an active session.
         */
        WEB_SESSION, // DeviceSessionArg
        /**
         * Unlink a linked desktop device.
         */
        DESKTOP_CLIENT, // RevokeDesktopClientArg
        /**
         * Unlink a linked mobile device.
         */
        MOBILE_CLIENT; // DeviceSessionArg
    }

    private Tag _tag;
    private DeviceSessionArg webSessionValue;
    private RevokeDesktopClientArg desktopClientValue;
    private DeviceSessionArg mobileClientValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RevokeDeviceSessionArg() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RevokeDeviceSessionArg withTag(Tag _tag) {
        RevokeDeviceSessionArg result = new RevokeDeviceSessionArg();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param webSessionValue  End an active session. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RevokeDeviceSessionArg withTagAndWebSession(Tag _tag, DeviceSessionArg webSessionValue) {
        RevokeDeviceSessionArg result = new RevokeDeviceSessionArg();
        result._tag = _tag;
        result.webSessionValue = webSessionValue;
        return result;
    }

    /**
     *
     * @param desktopClientValue  Unlink a linked desktop device. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RevokeDeviceSessionArg withTagAndDesktopClient(Tag _tag, RevokeDesktopClientArg desktopClientValue) {
        RevokeDeviceSessionArg result = new RevokeDeviceSessionArg();
        result._tag = _tag;
        result.desktopClientValue = desktopClientValue;
        return result;
    }

    /**
     *
     * @param mobileClientValue  Unlink a linked mobile device. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RevokeDeviceSessionArg withTagAndMobileClient(Tag _tag, DeviceSessionArg mobileClientValue) {
        RevokeDeviceSessionArg result = new RevokeDeviceSessionArg();
        result._tag = _tag;
        result.mobileClientValue = mobileClientValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RevokeDeviceSessionArg}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#WEB_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#WEB_SESSION}, {@code false} otherwise.
     */
    public boolean isWebSession() {
        return this._tag == Tag.WEB_SESSION;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#WEB_SESSION}.
     *
     * <p> End an active session. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RevokeDeviceSessionArg} with its tag set to
     *     {@link Tag#WEB_SESSION}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RevokeDeviceSessionArg webSession(DeviceSessionArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndWebSession(Tag.WEB_SESSION, value);
    }

    /**
     * End an active session.
     *
     * <p> This instance must be tagged as {@link Tag#WEB_SESSION}. </p>
     *
     * @return The {@link DeviceSessionArg} value associated with this instance
     *     if {@link #isWebSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isWebSession} is {@code false}.
     */
    public DeviceSessionArg getWebSessionValue() {
        if (this._tag != Tag.WEB_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.WEB_SESSION, but was Tag." + this._tag.name());
        }
        return webSessionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DESKTOP_CLIENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DESKTOP_CLIENT}, {@code false} otherwise.
     */
    public boolean isDesktopClient() {
        return this._tag == Tag.DESKTOP_CLIENT;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#DESKTOP_CLIENT}.
     *
     * <p> Unlink a linked desktop device. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RevokeDeviceSessionArg} with its tag set to
     *     {@link Tag#DESKTOP_CLIENT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RevokeDeviceSessionArg desktopClient(RevokeDesktopClientArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndDesktopClient(Tag.DESKTOP_CLIENT, value);
    }

    /**
     * Unlink a linked desktop device.
     *
     * <p> This instance must be tagged as {@link Tag#DESKTOP_CLIENT}. </p>
     *
     * @return The {@link RevokeDesktopClientArg} value associated with this
     *     instance if {@link #isDesktopClient} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDesktopClient} is {@code
     *     false}.
     */
    public RevokeDesktopClientArg getDesktopClientValue() {
        if (this._tag != Tag.DESKTOP_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.DESKTOP_CLIENT, but was Tag." + this._tag.name());
        }
        return desktopClientValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MOBILE_CLIENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MOBILE_CLIENT}, {@code false} otherwise.
     */
    public boolean isMobileClient() {
        return this._tag == Tag.MOBILE_CLIENT;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#MOBILE_CLIENT}.
     *
     * <p> Unlink a linked mobile device. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RevokeDeviceSessionArg} with its tag set to
     *     {@link Tag#MOBILE_CLIENT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RevokeDeviceSessionArg mobileClient(DeviceSessionArg value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RevokeDeviceSessionArg().withTagAndMobileClient(Tag.MOBILE_CLIENT, value);
    }

    /**
     * Unlink a linked mobile device.
     *
     * <p> This instance must be tagged as {@link Tag#MOBILE_CLIENT}. </p>
     *
     * @return The {@link DeviceSessionArg} value associated with this instance
     *     if {@link #isMobileClient} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMobileClient} is {@code
     *     false}.
     */
    public DeviceSessionArg getMobileClientValue() {
        if (this._tag != Tag.MOBILE_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.MOBILE_CLIENT, but was Tag." + this._tag.name());
        }
        return mobileClientValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            webSessionValue,
            desktopClientValue,
            mobileClientValue
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
        else if (obj instanceof RevokeDeviceSessionArg) {
            RevokeDeviceSessionArg other = (RevokeDeviceSessionArg) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case WEB_SESSION:
                    return (this.webSessionValue == other.webSessionValue) || (this.webSessionValue.equals(other.webSessionValue));
                case DESKTOP_CLIENT:
                    return (this.desktopClientValue == other.desktopClientValue) || (this.desktopClientValue.equals(other.desktopClientValue));
                case MOBILE_CLIENT:
                    return (this.mobileClientValue == other.mobileClientValue) || (this.mobileClientValue.equals(other.mobileClientValue));
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
    static class Serializer extends UnionSerializer<RevokeDeviceSessionArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeDeviceSessionArg value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case WEB_SESSION: {
                    g.writeStartObject();
                    writeTag("web_session", g);
                    DeviceSessionArg.Serializer.INSTANCE.serialize(value.webSessionValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case DESKTOP_CLIENT: {
                    g.writeStartObject();
                    writeTag("desktop_client", g);
                    RevokeDesktopClientArg.Serializer.INSTANCE.serialize(value.desktopClientValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case MOBILE_CLIENT: {
                    g.writeStartObject();
                    writeTag("mobile_client", g);
                    DeviceSessionArg.Serializer.INSTANCE.serialize(value.mobileClientValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public RevokeDeviceSessionArg deserialize(JsonParser p) throws IOException, JsonParseException {
            RevokeDeviceSessionArg value;
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
            else if ("web_session".equals(tag)) {
                DeviceSessionArg fieldValue = null;
                fieldValue = DeviceSessionArg.Serializer.INSTANCE.deserialize(p, true);
                value = RevokeDeviceSessionArg.webSession(fieldValue);
            }
            else if ("desktop_client".equals(tag)) {
                RevokeDesktopClientArg fieldValue = null;
                fieldValue = RevokeDesktopClientArg.Serializer.INSTANCE.deserialize(p, true);
                value = RevokeDeviceSessionArg.desktopClient(fieldValue);
            }
            else if ("mobile_client".equals(tag)) {
                DeviceSessionArg fieldValue = null;
                fieldValue = DeviceSessionArg.Serializer.INSTANCE.deserialize(p, true);
                value = RevokeDeviceSessionArg.mobileClient(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
