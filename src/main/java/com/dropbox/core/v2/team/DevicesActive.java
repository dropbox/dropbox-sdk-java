/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * Each of the items is an array of values, one value per day. The value is the
 * number of devices active within a time window, ending with that day. If there
 * is no data for a day, then the value will be None.
 */
@JsonSerialize(using=DevicesActive.Serializer.class)
@JsonDeserialize(using=DevicesActive.Deserializer.class)
public class DevicesActive {
    // struct DevicesActive

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<Long> windows;
    protected final List<Long> macos;
    protected final List<Long> linux;
    protected final List<Long> ios;
    protected final List<Long> android;
    protected final List<Long> other;
    protected final List<Long> total;

    /**
     * Each of the items is an array of values, one value per day. The value is
     * the number of devices active within a time window, ending with that day.
     * If there is no data for a day, then the value will be None.
     *
     * @param windows  Array of number of linked windows (desktop) clients with
     *     activity. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param macos  Array of number of linked mac (desktop) clients with
     *     activity. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param linux  Array of number of linked linus (desktop) clients with
     *     activity. Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param ios  Array of number of linked ios devices with activity. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param android  Array of number of linked android devices with activity.
     *     Must not contain a {@code null} item and not be {@code null}.
     * @param other  Array of number of other linked devices (blackberry,
     *     windows phone, etc)  with activity. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param total  Array of total number of linked clients with activity. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DevicesActive(List<Long> windows, List<Long> macos, List<Long> linux, List<Long> ios, List<Long> android, List<Long> other, List<Long> total) {
        if (windows == null) {
            throw new IllegalArgumentException("Required value for 'windows' is null");
        }
        for (Long x : windows) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'windows' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'windows': type Nullable");
        }
        this.windows = windows;
        if (macos == null) {
            throw new IllegalArgumentException("Required value for 'macos' is null");
        }
        for (Long x : macos) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'macos' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'macos': type Nullable");
        }
        this.macos = macos;
        if (linux == null) {
            throw new IllegalArgumentException("Required value for 'linux' is null");
        }
        for (Long x : linux) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linux' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'linux': type Nullable");
        }
        this.linux = linux;
        if (ios == null) {
            throw new IllegalArgumentException("Required value for 'ios' is null");
        }
        for (Long x : ios) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'ios' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'ios': type Nullable");
        }
        this.ios = ios;
        if (android == null) {
            throw new IllegalArgumentException("Required value for 'android' is null");
        }
        for (Long x : android) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'android' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'android': type Nullable");
        }
        this.android = android;
        if (other == null) {
            throw new IllegalArgumentException("Required value for 'other' is null");
        }
        for (Long x : other) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'other' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'other': type Nullable");
        }
        this.other = other;
        if (total == null) {
            throw new IllegalArgumentException("Required value for 'total' is null");
        }
        for (Long x : total) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'total' is null");
            }
            throw new RuntimeException("XXX Don't know how to validate an item in list 'total': type Nullable");
        }
        this.total = total;
    }

    /**
     * Array of number of linked windows (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getWindows() {
        return windows;
    }

    /**
     * Array of number of linked mac (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getMacos() {
        return macos;
    }

    /**
     * Array of number of linked linus (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getLinux() {
        return linux;
    }

    /**
     * Array of number of linked ios devices with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getIos() {
        return ios;
    }

    /**
     * Array of number of linked android devices with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getAndroid() {
        return android;
    }

    /**
     * Array of number of other linked devices (blackberry, windows phone, etc)
     * with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getOther() {
        return other;
    }

    /**
     * Array of total number of linked clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    public List<Long> getTotal() {
        return total;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            windows,
            macos,
            linux,
            ios,
            android,
            other,
            total
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DevicesActive other = (DevicesActive) obj;
            return ((this.windows == other.windows) || (this.windows.equals(other.windows)))
                && ((this.macos == other.macos) || (this.macos.equals(other.macos)))
                && ((this.linux == other.linux) || (this.linux.equals(other.linux)))
                && ((this.ios == other.ios) || (this.ios.equals(other.ios)))
                && ((this.android == other.android) || (this.android.equals(other.android)))
                && ((this.other == other.other) || (this.other.equals(other.other)))
                && ((this.total == other.total) || (this.total.equals(other.total)))
                ;
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

    static final class Serializer extends StructJsonSerializer<DevicesActive> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DevicesActive.class);
        }

        public Serializer(boolean unwrapping) {
            super(DevicesActive.class, unwrapping);
        }

        @Override
        protected JsonSerializer<DevicesActive> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(DevicesActive value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("windows", value.windows);
            g.writeObjectField("macos", value.macos);
            g.writeObjectField("linux", value.linux);
            g.writeObjectField("ios", value.ios);
            g.writeObjectField("android", value.android);
            g.writeObjectField("other", value.other);
            g.writeObjectField("total", value.total);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<DevicesActive> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DevicesActive.class);
        }

        public Deserializer(boolean unwrapping) {
            super(DevicesActive.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<DevicesActive> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public DevicesActive deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<Long> windows = null;
            List<Long> macos = null;
            List<Long> linux = null;
            List<Long> ios = null;
            List<Long> android = null;
            List<Long> other = null;
            List<Long> total = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("windows".equals(_field)) {
                    expectArrayStart(_p);
                    windows = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        windows.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("macos".equals(_field)) {
                    expectArrayStart(_p);
                    macos = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        macos.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("linux".equals(_field)) {
                    expectArrayStart(_p);
                    linux = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        linux.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("ios".equals(_field)) {
                    expectArrayStart(_p);
                    ios = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        ios.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("android".equals(_field)) {
                    expectArrayStart(_p);
                    android = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        android.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("other".equals(_field)) {
                    expectArrayStart(_p);
                    other = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        other.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("total".equals(_field)) {
                    expectArrayStart(_p);
                    total = new java.util.ArrayList<Long>();
                    while (!isArrayEnd(_p)) {
                        Long _x = null;
                        _x = _p.getLongValue();
                        assertUnsigned(_p, _x);
                        _p.nextToken();
                        total.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (windows == null) {
                throw new JsonParseException(_p, "Required field \"windows\" is missing.");
            }
            if (macos == null) {
                throw new JsonParseException(_p, "Required field \"macos\" is missing.");
            }
            if (linux == null) {
                throw new JsonParseException(_p, "Required field \"linux\" is missing.");
            }
            if (ios == null) {
                throw new JsonParseException(_p, "Required field \"ios\" is missing.");
            }
            if (android == null) {
                throw new JsonParseException(_p, "Required field \"android\" is missing.");
            }
            if (other == null) {
                throw new JsonParseException(_p, "Required field \"other\" is missing.");
            }
            if (total == null) {
                throw new JsonParseException(_p, "Required field \"total\" is missing.");
            }

            return new DevicesActive(windows, macos, linux, ios, android, other, total);
        }
    }
}
