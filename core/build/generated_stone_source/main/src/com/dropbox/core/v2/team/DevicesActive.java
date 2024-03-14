/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

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
import java.util.List;

/**
 * Each of the items is an array of values, one value per day. The value is the
 * number of devices active within a time window, ending with that day. If there
 * is no data for a day, then the value will be None.
 */
public class DevicesActive {
    // struct team.DevicesActive (team_reports.stone)

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
    public DevicesActive(@javax.annotation.Nonnull List<Long> windows, @javax.annotation.Nonnull List<Long> macos, @javax.annotation.Nonnull List<Long> linux, @javax.annotation.Nonnull List<Long> ios, @javax.annotation.Nonnull List<Long> android, @javax.annotation.Nonnull List<Long> other, @javax.annotation.Nonnull List<Long> total) {
        if (windows == null) {
            throw new IllegalArgumentException("Required value for 'windows' is null");
        }
        for (Long x : windows) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'windows' is null");
            }
        }
        this.windows = windows;
        if (macos == null) {
            throw new IllegalArgumentException("Required value for 'macos' is null");
        }
        for (Long x : macos) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'macos' is null");
            }
        }
        this.macos = macos;
        if (linux == null) {
            throw new IllegalArgumentException("Required value for 'linux' is null");
        }
        for (Long x : linux) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linux' is null");
            }
        }
        this.linux = linux;
        if (ios == null) {
            throw new IllegalArgumentException("Required value for 'ios' is null");
        }
        for (Long x : ios) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'ios' is null");
            }
        }
        this.ios = ios;
        if (android == null) {
            throw new IllegalArgumentException("Required value for 'android' is null");
        }
        for (Long x : android) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'android' is null");
            }
        }
        this.android = android;
        if (other == null) {
            throw new IllegalArgumentException("Required value for 'other' is null");
        }
        for (Long x : other) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'other' is null");
            }
        }
        this.other = other;
        if (total == null) {
            throw new IllegalArgumentException("Required value for 'total' is null");
        }
        for (Long x : total) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'total' is null");
            }
        }
        this.total = total;
    }

    /**
     * Array of number of linked windows (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getWindows() {
        return windows;
    }

    /**
     * Array of number of linked mac (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getMacos() {
        return macos;
    }

    /**
     * Array of number of linked linus (desktop) clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getLinux() {
        return linux;
    }

    /**
     * Array of number of linked ios devices with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getIos() {
        return ios;
    }

    /**
     * Array of number of linked android devices with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getAndroid() {
        return android;
    }

    /**
     * Array of number of other linked devices (blackberry, windows phone, etc)
     * with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getOther() {
        return other;
    }

    /**
     * Array of total number of linked clients with activity.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<Long> getTotal() {
        return total;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<DevicesActive> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DevicesActive value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("windows");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.windows, g);
            g.writeFieldName("macos");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.macos, g);
            g.writeFieldName("linux");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.linux, g);
            g.writeFieldName("ios");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.ios, g);
            g.writeFieldName("android");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.android, g);
            g.writeFieldName("other");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.other, g);
            g.writeFieldName("total");
            StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).serialize(value.total, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DevicesActive deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DevicesActive value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<Long> f_windows = null;
                List<Long> f_macos = null;
                List<Long> f_linux = null;
                List<Long> f_ios = null;
                List<Long> f_android = null;
                List<Long> f_other = null;
                List<Long> f_total = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("windows".equals(field)) {
                        f_windows = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("macos".equals(field)) {
                        f_macos = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("linux".equals(field)) {
                        f_linux = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("ios".equals(field)) {
                        f_ios = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("android".equals(field)) {
                        f_android = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("other".equals(field)) {
                        f_other = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else if ("total".equals(field)) {
                        f_total = StoneSerializers.list(StoneSerializers.nullable(StoneSerializers.uInt64())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_windows == null) {
                    throw new JsonParseException(p, "Required field \"windows\" missing.");
                }
                if (f_macos == null) {
                    throw new JsonParseException(p, "Required field \"macos\" missing.");
                }
                if (f_linux == null) {
                    throw new JsonParseException(p, "Required field \"linux\" missing.");
                }
                if (f_ios == null) {
                    throw new JsonParseException(p, "Required field \"ios\" missing.");
                }
                if (f_android == null) {
                    throw new JsonParseException(p, "Required field \"android\" missing.");
                }
                if (f_other == null) {
                    throw new JsonParseException(p, "Required field \"other\" missing.");
                }
                if (f_total == null) {
                    throw new JsonParseException(p, "Required field \"total\" missing.");
                }
                value = new DevicesActive(f_windows, f_macos, f_linux, f_ios, f_android, f_other, f_total);
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
