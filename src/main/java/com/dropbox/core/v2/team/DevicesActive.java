/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Each of the items is an array of values, one value per day. The value is the
 * number of devices active within a time window, ending with that day. If there
 * is no data for a day, then the value will be None.
 */
public class DevicesActive {
    // struct DevicesActive

    private final List<Long> windows;
    private final List<Long> macos;
    private final List<Long> linux;
    private final List<Long> ios;
    private final List<Long> android;
    private final List<Long> other;
    private final List<Long> total;

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
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static DevicesActive fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DevicesActive> _JSON_WRITER = new JsonWriter<DevicesActive>() {
        public final void write(DevicesActive x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            DevicesActive._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(DevicesActive x, JsonGenerator g) throws IOException {
            g.writeFieldName("windows");
            g.writeStartArray();
            for (Long item: x.windows) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("macos");
            g.writeStartArray();
            for (Long item: x.macos) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("linux");
            g.writeStartArray();
            for (Long item: x.linux) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("ios");
            g.writeStartArray();
            for (Long item: x.ios) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("android");
            g.writeStartArray();
            for (Long item: x.android) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("other");
            g.writeStartArray();
            for (Long item: x.other) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
            g.writeFieldName("total");
            g.writeStartArray();
            for (Long item: x.total) {
                if (item != null) {
                    g.writeNumber(item);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<DevicesActive> _JSON_READER = new JsonReader<DevicesActive>() {
        public final DevicesActive read(JsonParser parser) throws IOException, JsonReadException {
            DevicesActive result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final DevicesActive readFields(JsonParser parser) throws IOException, JsonReadException {
            List<Long> windows = null;
            List<Long> macos = null;
            List<Long> linux = null;
            List<Long> ios = null;
            List<Long> android = null;
            List<Long> other = null;
            List<Long> total = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("windows".equals(fieldName)) {
                    windows = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "windows", windows);
                }
                else if ("macos".equals(fieldName)) {
                    macos = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "macos", macos);
                }
                else if ("linux".equals(fieldName)) {
                    linux = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "linux", linux);
                }
                else if ("ios".equals(fieldName)) {
                    ios = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "ios", ios);
                }
                else if ("android".equals(fieldName)) {
                    android = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "android", android);
                }
                else if ("other".equals(fieldName)) {
                    other = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "other", other);
                }
                else if ("total".equals(fieldName)) {
                    total = JsonArrayReader.mk(JsonReader.UInt64Reader)
                        .readField(parser, "total", total);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (windows == null) {
                throw new JsonReadException("Required field \"windows\" is missing.", parser.getTokenLocation());
            }
            if (macos == null) {
                throw new JsonReadException("Required field \"macos\" is missing.", parser.getTokenLocation());
            }
            if (linux == null) {
                throw new JsonReadException("Required field \"linux\" is missing.", parser.getTokenLocation());
            }
            if (ios == null) {
                throw new JsonReadException("Required field \"ios\" is missing.", parser.getTokenLocation());
            }
            if (android == null) {
                throw new JsonReadException("Required field \"android\" is missing.", parser.getTokenLocation());
            }
            if (other == null) {
                throw new JsonReadException("Required field \"other\" is missing.", parser.getTokenLocation());
            }
            if (total == null) {
                throw new JsonReadException("Required field \"total\" is missing.", parser.getTokenLocation());
            }
            return new DevicesActive(windows, macos, linux, ios, android, other, total);
        }
    };
}
