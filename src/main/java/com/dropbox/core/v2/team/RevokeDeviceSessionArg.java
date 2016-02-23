/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class RevokeDeviceSessionArg {
    // union RevokeDeviceSessionArg

    /**
     * Discriminating tag type for {@link RevokeDeviceSessionArg}.
     */
    public enum Tag {
        /**
         * End an active session
         */
        WEB_SESSION, // DeviceSessionArg
        /**
         * Unlink a linked desktop device
         */
        DESKTOP_CLIENT, // RevokeDesktopClientArg
        /**
         * Unlink a linked mobile device
         */
        MOBILE_CLIENT; // DeviceSessionArg
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("web_session", Tag.WEB_SESSION);
        VALUES_.put("desktop_client", Tag.DESKTOP_CLIENT);
        VALUES_.put("mobile_client", Tag.MOBILE_CLIENT);
    }

    private final Tag tag;
    private final DeviceSessionArg webSessionValue;
    private final RevokeDesktopClientArg desktopClientValue;
    private final DeviceSessionArg mobileClientValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RevokeDeviceSessionArg(Tag tag, DeviceSessionArg webSessionValue, RevokeDesktopClientArg desktopClientValue, DeviceSessionArg mobileClientValue) {
        this.tag = tag;
        this.webSessionValue = webSessionValue;
        this.desktopClientValue = desktopClientValue;
        this.mobileClientValue = mobileClientValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code RevokeDeviceSessionArg}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#WEB_SESSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#WEB_SESSION}, {@code false} otherwise.
     */
    public boolean isWebSession() {
        return this.tag == Tag.WEB_SESSION;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#WEB_SESSION}.
     *
     * <p> End an active session </p>
     *
     * @param value  {@link RevokeDeviceSessionArg#webSession} value to assign
     *     to this instance.
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
        return new RevokeDeviceSessionArg(Tag.WEB_SESSION, value, null, null);
    }

    /**
     * End an active session
     *
     * <p> This instance must be tagged as {@link Tag#WEB_SESSION}. </p>
     *
     * @return The {@link RevokeDeviceSessionArg#webSession} value associated
     *     with this instance if {@link #isWebSession} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isWebSession} is {@code false}.
     */
    public DeviceSessionArg getWebSessionValue() {
        if (this.tag != Tag.WEB_SESSION) {
            throw new IllegalStateException("Invalid tag: required Tag.WEB_SESSION, but was Tag." + tag.name());
        }
        return webSessionValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DESKTOP_CLIENT}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#DESKTOP_CLIENT}, {@code false} otherwise.
     */
    public boolean isDesktopClient() {
        return this.tag == Tag.DESKTOP_CLIENT;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#DESKTOP_CLIENT}.
     *
     * <p> Unlink a linked desktop device </p>
     *
     * @param value  {@link RevokeDeviceSessionArg#desktopClient} value to
     *     assign to this instance.
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
        return new RevokeDeviceSessionArg(Tag.DESKTOP_CLIENT, null, value, null);
    }

    /**
     * Unlink a linked desktop device
     *
     * <p> This instance must be tagged as {@link Tag#DESKTOP_CLIENT}. </p>
     *
     * @return The {@link RevokeDeviceSessionArg#desktopClient} value associated
     *     with this instance if {@link #isDesktopClient} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isDesktopClient} is {@code
     *     false}.
     */
    public RevokeDesktopClientArg getDesktopClientValue() {
        if (this.tag != Tag.DESKTOP_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.DESKTOP_CLIENT, but was Tag." + tag.name());
        }
        return desktopClientValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MOBILE_CLIENT}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#MOBILE_CLIENT}, {@code false} otherwise.
     */
    public boolean isMobileClient() {
        return this.tag == Tag.MOBILE_CLIENT;
    }

    /**
     * Returns an instance of {@code RevokeDeviceSessionArg} that has its tag
     * set to {@link Tag#MOBILE_CLIENT}.
     *
     * <p> Unlink a linked mobile device </p>
     *
     * @param value  {@link RevokeDeviceSessionArg#mobileClient} value to assign
     *     to this instance.
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
        return new RevokeDeviceSessionArg(Tag.MOBILE_CLIENT, null, null, value);
    }

    /**
     * Unlink a linked mobile device
     *
     * <p> This instance must be tagged as {@link Tag#MOBILE_CLIENT}. </p>
     *
     * @return The {@link RevokeDeviceSessionArg#mobileClient} value associated
     *     with this instance if {@link #isMobileClient} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMobileClient} is {@code
     *     false}.
     */
    public DeviceSessionArg getMobileClientValue() {
        if (this.tag != Tag.MOBILE_CLIENT) {
            throw new IllegalStateException("Invalid tag: required Tag.MOBILE_CLIENT, but was Tag." + tag.name());
        }
        return mobileClientValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
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
        else if (obj instanceof RevokeDeviceSessionArg) {
            RevokeDeviceSessionArg other = (RevokeDeviceSessionArg) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeDeviceSessionArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDeviceSessionArg> _JSON_WRITER = new JsonWriter<RevokeDeviceSessionArg>() {
        public final void write(RevokeDeviceSessionArg x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case WEB_SESSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("web_session");
                    g.writeFieldName("web_session");
                    DeviceSessionArg._JSON_WRITER.write(x.getWebSessionValue(), g);
                    g.writeEndObject();
                    break;
                case DESKTOP_CLIENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("desktop_client");
                    g.writeFieldName("desktop_client");
                    RevokeDesktopClientArg._JSON_WRITER.write(x.getDesktopClientValue(), g);
                    g.writeEndObject();
                    break;
                case MOBILE_CLIENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("mobile_client");
                    g.writeFieldName("mobile_client");
                    DeviceSessionArg._JSON_WRITER.write(x.getMobileClientValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<RevokeDeviceSessionArg> _JSON_READER = new JsonReader<RevokeDeviceSessionArg>() {

        public final RevokeDeviceSessionArg read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            RevokeDeviceSessionArg value = null;
            if (tag != null) {
                switch (tag) {
                    case WEB_SESSION: {
                        DeviceSessionArg v = null;
                        v = DeviceSessionArg._JSON_READER.readFields(parser);
                        value = RevokeDeviceSessionArg.webSession(v);
                        break;
                    }
                    case DESKTOP_CLIENT: {
                        RevokeDesktopClientArg v = null;
                        v = RevokeDesktopClientArg._JSON_READER.readFields(parser);
                        value = RevokeDeviceSessionArg.desktopClient(v);
                        break;
                    }
                    case MOBILE_CLIENT: {
                        DeviceSessionArg v = null;
                        v = DeviceSessionArg._JSON_READER.readFields(parser);
                        value = RevokeDeviceSessionArg.mobileClient(v);
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
