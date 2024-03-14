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

class TeamFolderRenameArg extends TeamFolderIdArg {
    // struct team.TeamFolderRenameArg (team_folders.stone)

    protected final String name;

    /**
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param name  New team folder name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderRenameArg(String teamFolderId, String name) {
        super(teamFolderId);
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
    }

    /**
     * The ID of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamFolderId() {
        return teamFolderId;
    }

    /**
     * New team folder name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            name
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
            TeamFolderRenameArg other = (TeamFolderRenameArg) obj;
            return ((this.teamFolderId == other.teamFolderId) || (this.teamFolderId.equals(other.teamFolderId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
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
    static class Serializer extends StructSerializer<TeamFolderRenameArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderRenameArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(value.teamFolderId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderRenameArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderRenameArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamFolderId = null;
                String f_name = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folder_id".equals(field)) {
                        f_teamFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolderId == null) {
                    throw new JsonParseException(p, "Required field \"team_folder_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                value = new TeamFolderRenameArg(f_teamFolderId, f_name);
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
