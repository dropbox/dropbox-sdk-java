/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

class TeamFolderArchiveArg extends TeamFolderIdArg {
    // struct team.TeamFolderArchiveArg (team_folders.stone)

    protected final boolean forceAsyncOff;

    /**
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param forceAsyncOff  Whether to force the archive to happen
     *     synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderArchiveArg(@Nonnull String teamFolderId, boolean forceAsyncOff) {
        super(teamFolderId);
        this.forceAsyncOff = forceAsyncOff;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderArchiveArg(@Nonnull String teamFolderId) {
        this(teamFolderId, false);
    }

    /**
     * The ID of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTeamFolderId() {
        return teamFolderId;
    }

    /**
     * Whether to force the archive to happen synchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsyncOff() {
        return forceAsyncOff;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.forceAsyncOff
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
            TeamFolderArchiveArg other = (TeamFolderArchiveArg) obj;
            return ((this.teamFolderId == other.teamFolderId) || (this.teamFolderId.equals(other.teamFolderId)))
                && (this.forceAsyncOff == other.forceAsyncOff)
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
    static class Serializer extends StructSerializer<TeamFolderArchiveArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderArchiveArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(value.teamFolderId, g);
            g.writeFieldName("force_async_off");
            StoneSerializers.boolean_().serialize(value.forceAsyncOff, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderArchiveArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderArchiveArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamFolderId = null;
                Boolean f_forceAsyncOff = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folder_id".equals(field)) {
                        f_teamFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("force_async_off".equals(field)) {
                        f_forceAsyncOff = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolderId == null) {
                    throw new JsonParseException(p, "Required field \"team_folder_id\" missing.");
                }
                value = new TeamFolderArchiveArg(f_teamFolderId, f_forceAsyncOff);
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
