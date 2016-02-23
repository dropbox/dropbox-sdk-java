/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

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

public class ListTeamDevicesResult {
    // struct ListTeamDevicesResult

    private final List<MemberDevices> devices;
    private final boolean hasMore;
    private final String cursor;

    /**
     *
     * @param devices  The devices of each member of the team. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more devices available. Pass the
     *     cursor to {@link DbxTeam#devicesListTeamDevices()} to retrieve the
     *     rest.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeam#devicesListTeamDevices()} to receive the next sub list of
     *     team's devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListTeamDevicesResult(List<MemberDevices> devices, boolean hasMore, String cursor) {
        if (devices == null) {
            throw new IllegalArgumentException("Required value for 'devices' is null");
        }
        for (MemberDevices x : devices) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'devices' is null");
            }
        }
        this.devices = devices;
        this.hasMore = hasMore;
        this.cursor = cursor;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param devices  The devices of each member of the team. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more devices available. Pass the
     *     cursor to {@link DbxTeam#devicesListTeamDevices()} to retrieve the
     *     rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListTeamDevicesResult(List<MemberDevices> devices, boolean hasMore) {
        this(devices, hasMore, null);
    }

    /**
     * The devices of each member of the team
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberDevices> getDevices() {
        return devices;
    }

    /**
     * If true, then there are more devices available. Pass the cursor to {@link
     * DbxTeam#devicesListTeamDevices()} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link DbxTeam#devicesListTeamDevices()} to receive
     * the next sub list of team's devices.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
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
            ListTeamDevicesResult other = (ListTeamDevicesResult) obj;
            return ((this.devices == other.devices) || (this.devices.equals(other.devices)))
                && (this.hasMore == other.hasMore)
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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

    public static ListTeamDevicesResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListTeamDevicesResult> _JSON_WRITER = new JsonWriter<ListTeamDevicesResult>() {
        public final void write(ListTeamDevicesResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListTeamDevicesResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListTeamDevicesResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("devices");
            g.writeStartArray();
            for (MemberDevices item: x.devices) {
                if (item != null) {
                    MemberDevices._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("has_more");
            g.writeBoolean(x.hasMore);
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListTeamDevicesResult> _JSON_READER = new JsonReader<ListTeamDevicesResult>() {
        public final ListTeamDevicesResult read(JsonParser parser) throws IOException, JsonReadException {
            ListTeamDevicesResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListTeamDevicesResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<MemberDevices> devices = null;
            Boolean hasMore = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("devices".equals(fieldName)) {
                    devices = JsonArrayReader.mk(MemberDevices._JSON_READER)
                        .readField(parser, "devices", devices);
                }
                else if ("has_more".equals(fieldName)) {
                    hasMore = JsonReader.BooleanReader
                        .readField(parser, "has_more", hasMore);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (devices == null) {
                throw new JsonReadException("Required field \"devices\" is missing.", parser.getTokenLocation());
            }
            if (hasMore == null) {
                throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
            }
            return new ListTeamDevicesResult(devices, hasMore, cursor);
        }
    };
}
