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

public class RevokeDesktopClientArg extends DeviceSessionArg {
    // struct team.RevokeDesktopClientArg (team_devices.stone)

    protected final boolean deleteOnUnlink;

    /**
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param deleteOnUnlink  Whether to delete all files of the account (this
     *     is possible only if supported by the desktop client and  will be made
     *     the next time the client access the account).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId, boolean deleteOnUnlink) {
        super(sessionId, teamMemberId);
        this.deleteOnUnlink = deleteOnUnlink;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param sessionId  The session id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDesktopClientArg(String sessionId, String teamMemberId) {
        this(sessionId, teamMemberId, false);
    }

    /**
     * The session id.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The unique id of the member owning the device.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Whether to delete all files of the account (this is possible only if
     * supported by the desktop client and  will be made the next time the
     * client access the account).
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getDeleteOnUnlink() {
        return deleteOnUnlink;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            deleteOnUnlink
        });
        hash = (31 * super.hashCode()) + hash;
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
            RevokeDesktopClientArg other = (RevokeDesktopClientArg) obj;
            return ((this.sessionId == other.sessionId) || (this.sessionId.equals(other.sessionId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && (this.deleteOnUnlink == other.deleteOnUnlink)
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
    static class Serializer extends StructSerializer<RevokeDesktopClientArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeDesktopClientArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("session_id");
            StoneSerializers.string().serialize(value.sessionId, g);
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            g.writeFieldName("delete_on_unlink");
            StoneSerializers.boolean_().serialize(value.deleteOnUnlink, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeDesktopClientArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeDesktopClientArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_sessionId = null;
                String f_teamMemberId = null;
                Boolean f_deleteOnUnlink = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("session_id".equals(field)) {
                        f_sessionId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("delete_on_unlink".equals(field)) {
                        f_deleteOnUnlink = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_sessionId == null) {
                    throw new JsonParseException(p, "Required field \"session_id\" missing.");
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                value = new RevokeDesktopClientArg(f_sessionId, f_teamMemberId, f_deleteOnUnlink);
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
