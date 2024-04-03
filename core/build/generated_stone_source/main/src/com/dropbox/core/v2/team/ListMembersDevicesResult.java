/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ListMembersDevicesResult {
    // struct team.ListMembersDevicesResult (team_devices.stone)

    @Nonnull
    protected final List<MemberDevices> devices;
    protected final boolean hasMore;
    @Nullable
    protected final String cursor;

    /**
     *
     * @param devices  The devices of each member of the team. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more devices available. Pass the
     *     cursor to {@link DbxTeamTeamRequests#devicesListMembersDevices} to
     *     retrieve the rest.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#devicesListMembersDevices} to receive the next
     *     sub list of team's devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMembersDevicesResult(@Nonnull List<MemberDevices> devices, boolean hasMore, @Nullable String cursor) {
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
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param devices  The devices of each member of the team. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more devices available. Pass the
     *     cursor to {@link DbxTeamTeamRequests#devicesListMembersDevices} to
     *     retrieve the rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMembersDevicesResult(@Nonnull List<MemberDevices> devices, boolean hasMore) {
        this(devices, hasMore, null);
    }

    /**
     * The devices of each member of the team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<MemberDevices> getDevices() {
        return devices;
    }

    /**
     * If true, then there are more devices available. Pass the cursor to {@link
     * DbxTeamTeamRequests#devicesListMembersDevices} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#devicesListMembersDevices} to receive the next sub
     * list of team's devices.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.devices,
            this.hasMore,
            this.cursor
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
    static class Serializer extends StructSerializer<ListMembersDevicesResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMembersDevicesResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("devices");
            StoneSerializers.list(MemberDevices.Serializer.INSTANCE).serialize(value.devices, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListMembersDevicesResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListMembersDevicesResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<MemberDevices> f_devices = null;
                Boolean f_hasMore = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("devices".equals(field)) {
                        f_devices = StoneSerializers.list(MemberDevices.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_devices == null) {
                    throw new JsonParseException(p, "Required field \"devices\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ListMembersDevicesResult(f_devices, f_hasMore, f_cursor);
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
