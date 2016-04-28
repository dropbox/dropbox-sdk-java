/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

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

@JsonSerialize(using=ListMembersDevicesResult.Serializer.class)
@JsonDeserialize(using=ListMembersDevicesResult.Deserializer.class)
public class ListMembersDevicesResult {
    // struct ListMembersDevicesResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<MemberDevices> devices;
    protected final boolean hasMore;
    protected final String cursor;

    /**
     *
     * @param devices  The devices of each member of the team. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more devices available. Pass the
     *     cursor to {@link DbxTeamTeamRequests#devicesListMembersDevices()} to
     *     retrieve the rest.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#devicesListMembersDevices()} to receive the next
     *     sub list of team's devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMembersDevicesResult(List<MemberDevices> devices, boolean hasMore, String cursor) {
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
     *     cursor to {@link DbxTeamTeamRequests#devicesListMembersDevices()} to
     *     retrieve the rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMembersDevicesResult(List<MemberDevices> devices, boolean hasMore) {
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
     * DbxTeamTeamRequests#devicesListMembersDevices()} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#devicesListMembersDevices()} to receive the next sub
     * list of team's devices.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            devices,
            hasMore,
            cursor
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
            ListMembersDevicesResult other = (ListMembersDevicesResult) obj;
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

    static final class Serializer extends StructJsonSerializer<ListMembersDevicesResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListMembersDevicesResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListMembersDevicesResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListMembersDevicesResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListMembersDevicesResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("devices", value.devices);
            g.writeObjectField("has_more", value.hasMore);
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListMembersDevicesResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListMembersDevicesResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListMembersDevicesResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListMembersDevicesResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListMembersDevicesResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<MemberDevices> devices = null;
            Boolean hasMore = null;
            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("devices".equals(_field)) {
                    expectArrayStart(_p);
                    devices = new java.util.ArrayList<MemberDevices>();
                    while (!isArrayEnd(_p)) {
                        MemberDevices _x = null;
                        _x = _p.readValueAs(MemberDevices.class);
                        _p.nextToken();
                        devices.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("has_more".equals(_field)) {
                    hasMore = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (devices == null) {
                throw new JsonParseException(_p, "Required field \"devices\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new ListMembersDevicesResult(devices, hasMore, cursor);
        }
    }
}
