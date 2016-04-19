/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=RevokeDeviceSessionArg.Serializer.class)
@JsonDeserialize(using=RevokeDeviceSessionArg.Deserializer.class)
public final class RevokeDeviceSessionArg {
    // union RevokeDeviceSessionArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RevokeDeviceSessionArg}. </p>
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
     * @return {@code true} if this instance is tagged as {@link
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
     * @return {@code true} if this instance is tagged as {@link
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
     * @return {@code true} if this instance is tagged as {@link
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends UnionJsonSerializer<RevokeDeviceSessionArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RevokeDeviceSessionArg.class, DeviceSessionArg.class, RevokeDesktopClientArg.class, DeviceSessionArg.class);
        }

        @Override
        public void serialize(RevokeDeviceSessionArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case WEB_SESSION:
                    g.writeStartObject();
                    g.writeStringField(".tag", "web_session");
                    getUnwrappingSerializer(DeviceSessionArg.class).serialize(value.webSessionValue, g, provider);
                    g.writeEndObject();
                    break;
                case DESKTOP_CLIENT:
                    g.writeStartObject();
                    g.writeStringField(".tag", "desktop_client");
                    getUnwrappingSerializer(RevokeDesktopClientArg.class).serialize(value.desktopClientValue, g, provider);
                    g.writeEndObject();
                    break;
                case MOBILE_CLIENT:
                    g.writeStartObject();
                    g.writeStringField(".tag", "mobile_client");
                    getUnwrappingSerializer(DeviceSessionArg.class).serialize(value.mobileClientValue, g, provider);
                    g.writeEndObject();
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RevokeDeviceSessionArg, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RevokeDeviceSessionArg.class, getTagMapping(), null, DeviceSessionArg.class, RevokeDesktopClientArg.class, DeviceSessionArg.class);
        }

        @Override
        public RevokeDeviceSessionArg deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case WEB_SESSION: {
                    DeviceSessionArg value = null;
                    value = readCollapsedStructValue(DeviceSessionArg.class, _p, _ctx);
                    return RevokeDeviceSessionArg.webSession(value);
                }
                case DESKTOP_CLIENT: {
                    RevokeDesktopClientArg value = null;
                    value = readCollapsedStructValue(RevokeDesktopClientArg.class, _p, _ctx);
                    return RevokeDeviceSessionArg.desktopClient(value);
                }
                case MOBILE_CLIENT: {
                    DeviceSessionArg value = null;
                    value = readCollapsedStructValue(DeviceSessionArg.class, _p, _ctx);
                    return RevokeDeviceSessionArg.mobileClient(value);
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, RevokeDeviceSessionArg.Tag> getTagMapping() {
            Map<String, RevokeDeviceSessionArg.Tag> values = new HashMap<String, RevokeDeviceSessionArg.Tag>();
            values.put("web_session", RevokeDeviceSessionArg.Tag.WEB_SESSION);
            values.put("desktop_client", RevokeDeviceSessionArg.Tag.DESKTOP_CLIENT);
            values.put("mobile_client", RevokeDeviceSessionArg.Tag.MOBILE_CLIENT);
            return Collections.unmodifiableMap(values);
        }
    }
}
