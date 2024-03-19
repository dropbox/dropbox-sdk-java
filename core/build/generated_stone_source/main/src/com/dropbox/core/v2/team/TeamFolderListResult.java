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

/**
 * Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and {@link
 * DbxTeamTeamRequests#teamFolderListContinue(String)}.
 */
public class TeamFolderListResult {
    // struct team.TeamFolderListResult (team_folders.stone)

    @Nonnull
    protected final List<TeamFolderMetadata> teamFolders;
    @Nonnull
    protected final String cursor;
    protected final boolean hasMore;

    /**
     * Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and {@link
     * DbxTeamTeamRequests#teamFolderListContinue(String)}.
     *
     * @param teamFolders  List of all team folders in the authenticated team.
     *     Must not contain a {@code null} item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#teamFolderListContinue(String)} to obtain
     *     additional team folders. Must not be {@code null}.
     * @param hasMore  Is true if there are additional team folders that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#teamFolderListContinue(String)} can retrieve
     *     them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderListResult(@Nonnull List<TeamFolderMetadata> teamFolders, @Nonnull String cursor, boolean hasMore) {
        if (teamFolders == null) {
            throw new IllegalArgumentException("Required value for 'teamFolders' is null");
        }
        for (TeamFolderMetadata x : teamFolders) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'teamFolders' is null");
            }
        }
        this.teamFolders = teamFolders;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of all team folders in the authenticated team.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<TeamFolderMetadata> getTeamFolders() {
        return teamFolders;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#teamFolderListContinue(String)} to obtain additional
     * team folders.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional team folders that have not been returned
     * yet. An additional call to {@link
     * DbxTeamTeamRequests#teamFolderListContinue(String)} can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamFolders,
            cursor,
            hasMore
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
            TeamFolderListResult other = (TeamFolderListResult) obj;
            return ((this.teamFolders == other.teamFolders) || (this.teamFolders.equals(other.teamFolders)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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
    static class Serializer extends StructSerializer<TeamFolderListResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderListResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folders");
            StoneSerializers.list(TeamFolderMetadata.Serializer.INSTANCE).serialize(value.teamFolders, g);
            g.writeFieldName("cursor");
            StoneSerializers.string().serialize(value.cursor, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderListResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderListResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<TeamFolderMetadata> f_teamFolders = null;
                String f_cursor = null;
                Boolean f_hasMore = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folders".equals(field)) {
                        f_teamFolders = StoneSerializers.list(TeamFolderMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.string().deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolders == null) {
                    throw new JsonParseException(p, "Required field \"team_folders\" missing.");
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new TeamFolderListResult(f_teamFolders, f_cursor, f_hasMore);
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
