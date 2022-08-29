/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

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

public class RevokeLinkedApiAppArg {
    // struct team.RevokeLinkedApiAppArg (team_linked_apps.stone)

    protected final String appId;
    protected final String teamMemberId;
    protected final boolean keepAppFolder;

    /**
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param keepAppFolder  This flag is not longer supported, the application
     *     dedicated folder (in case the application uses  one) will be kept.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppArg(String appId, String teamMemberId, boolean keepAppFolder) {
        if (appId == null) {
            throw new IllegalArgumentException("Required value for 'appId' is null");
        }
        this.appId = appId;
        if (teamMemberId == null) {
            throw new IllegalArgumentException("Required value for 'teamMemberId' is null");
        }
        this.teamMemberId = teamMemberId;
        this.keepAppFolder = keepAppFolder;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedApiAppArg(String appId, String teamMemberId) {
        this(appId, teamMemberId, true);
    }

    /**
     * The application's unique id.
     *
     * @return value for this field, never {@code null}.
     */
    public String getAppId() {
        return appId;
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
     * This flag is not longer supported, the application dedicated folder (in
     * case the application uses  one) will be kept.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getKeepAppFolder() {
        return keepAppFolder;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            appId,
            teamMemberId,
            keepAppFolder
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
            RevokeLinkedApiAppArg other = (RevokeLinkedApiAppArg) obj;
            return ((this.appId == other.appId) || (this.appId.equals(other.appId)))
                && ((this.teamMemberId == other.teamMemberId) || (this.teamMemberId.equals(other.teamMemberId)))
                && (this.keepAppFolder == other.keepAppFolder)
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
    static class Serializer extends StructSerializer<RevokeLinkedApiAppArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RevokeLinkedApiAppArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("app_id");
            StoneSerializers.string().serialize(value.appId, g);
            g.writeFieldName("team_member_id");
            StoneSerializers.string().serialize(value.teamMemberId, g);
            g.writeFieldName("keep_app_folder");
            StoneSerializers.boolean_().serialize(value.keepAppFolder, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RevokeLinkedApiAppArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RevokeLinkedApiAppArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_appId = null;
                String f_teamMemberId = null;
                Boolean f_keepAppFolder = true;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("app_id".equals(field)) {
                        f_appId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("team_member_id".equals(field)) {
                        f_teamMemberId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("keep_app_folder".equals(field)) {
                        f_keepAppFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_appId == null) {
                    throw new JsonParseException(p, "Required field \"app_id\" missing.");
                }
                if (f_teamMemberId == null) {
                    throw new JsonParseException(p, "Required field \"team_member_id\" missing.");
                }
                value = new RevokeLinkedApiAppArg(f_appId, f_teamMemberId, f_keepAppFolder);
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
