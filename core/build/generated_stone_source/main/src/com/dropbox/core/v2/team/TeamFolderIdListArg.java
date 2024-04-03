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
import java.util.List;

import javax.annotation.Nonnull;

class TeamFolderIdListArg {
    // struct team.TeamFolderIdListArg (team_folders.stone)

    @Nonnull
    protected final List<String> teamFolderIds;

    /**
     *
     * @param teamFolderIds  The list of team folder IDs. Must contain at least
     *     1 items, not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderIdListArg(@Nonnull List<String> teamFolderIds) {
        if (teamFolderIds == null) {
            throw new IllegalArgumentException("Required value for 'teamFolderIds' is null");
        }
        if (teamFolderIds.size() < 1) {
            throw new IllegalArgumentException("List 'teamFolderIds' has fewer than 1 items");
        }
        for (String x : teamFolderIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'teamFolderIds' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", x)) {
                throw new IllegalArgumentException("Stringan item in list 'teamFolderIds' does not match pattern");
            }
        }
        this.teamFolderIds = teamFolderIds;
    }

    /**
     * The list of team folder IDs.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<String> getTeamFolderIds() {
        return teamFolderIds;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.teamFolderIds
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
            TeamFolderIdListArg other = (TeamFolderIdListArg) obj;
            return (this.teamFolderIds == other.teamFolderIds) || (this.teamFolderIds.equals(other.teamFolderIds));
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
    static class Serializer extends StructSerializer<TeamFolderIdListArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderIdListArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folder_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.teamFolderIds, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderIdListArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderIdListArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_teamFolderIds = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folder_ids".equals(field)) {
                        f_teamFolderIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolderIds == null) {
                    throw new JsonParseException(p, "Required field \"team_folder_ids\" missing.");
                }
                value = new TeamFolderIdListArg(f_teamFolderIds);
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
