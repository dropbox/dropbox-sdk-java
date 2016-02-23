/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class RevokeLinkedApiAppArg {
    // struct RevokeLinkedApiAppArg

    private final String appId;
    private final String teamMemberId;
    private final boolean keepAppFolder;

    /**
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param keepAppFolder  Whether to keep the application dedicated folder
     *     (in case the application uses  one).
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
     * The default values for unset fields will be used.
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
     * The application's unique id
     *
     * @return value for this field, never {@code null}.
     */
    public String getAppId() {
        return appId;
    }

    /**
     * The unique id of the member owning the device
     *
     * @return value for this field, never {@code null}.
     */
    public String getTeamMemberId() {
        return teamMemberId;
    }

    /**
     * Whether to keep the application dedicated folder (in case the application
     * uses  one)
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getKeepAppFolder() {
        return keepAppFolder;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeLinkedApiAppArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedApiAppArg> _JSON_WRITER = new JsonWriter<RevokeLinkedApiAppArg>() {
        public final void write(RevokeLinkedApiAppArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            RevokeLinkedApiAppArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(RevokeLinkedApiAppArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("app_id");
            g.writeString(x.appId);
            g.writeFieldName("team_member_id");
            g.writeString(x.teamMemberId);
            g.writeFieldName("keep_app_folder");
            g.writeBoolean(x.keepAppFolder);
        }
    };

    public static final JsonReader<RevokeLinkedApiAppArg> _JSON_READER = new JsonReader<RevokeLinkedApiAppArg>() {
        public final RevokeLinkedApiAppArg read(JsonParser parser) throws IOException, JsonReadException {
            RevokeLinkedApiAppArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final RevokeLinkedApiAppArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String appId = null;
            String teamMemberId = null;
            Boolean keepAppFolder = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("app_id".equals(fieldName)) {
                    appId = JsonReader.StringReader
                        .readField(parser, "app_id", appId);
                }
                else if ("team_member_id".equals(fieldName)) {
                    teamMemberId = JsonReader.StringReader
                        .readField(parser, "team_member_id", teamMemberId);
                }
                else if ("keep_app_folder".equals(fieldName)) {
                    keepAppFolder = JsonReader.BooleanReader
                        .readField(parser, "keep_app_folder", keepAppFolder);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (appId == null) {
                throw new JsonReadException("Required field \"app_id\" is missing.", parser.getTokenLocation());
            }
            if (teamMemberId == null) {
                throw new JsonReadException("Required field \"team_member_id\" is missing.", parser.getTokenLocation());
            }
            return new RevokeLinkedApiAppArg(appId, teamMemberId, keepAppFolder);
        }
    };
}
