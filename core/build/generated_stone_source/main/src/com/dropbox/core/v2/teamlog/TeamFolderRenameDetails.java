/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

/**
 * Renamed active/archived team folder.
 */
public class TeamFolderRenameDetails {
    // struct team_log.TeamFolderRenameDetails (team_log_generated.stone)

    protected final String previousFolderName;
    protected final String newFolderName;

    /**
     * Renamed active/archived team folder.
     *
     * @param previousFolderName  Previous folder name. Must not be {@code
     *     null}.
     * @param newFolderName  New folder name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderRenameDetails(@javax.annotation.Nonnull String previousFolderName, @javax.annotation.Nonnull String newFolderName) {
        if (previousFolderName == null) {
            throw new IllegalArgumentException("Required value for 'previousFolderName' is null");
        }
        this.previousFolderName = previousFolderName;
        if (newFolderName == null) {
            throw new IllegalArgumentException("Required value for 'newFolderName' is null");
        }
        this.newFolderName = newFolderName;
    }

    /**
     * Previous folder name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPreviousFolderName() {
        return previousFolderName;
    }

    /**
     * New folder name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getNewFolderName() {
        return newFolderName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousFolderName,
            newFolderName
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
            TeamFolderRenameDetails other = (TeamFolderRenameDetails) obj;
            return ((this.previousFolderName == other.previousFolderName) || (this.previousFolderName.equals(other.previousFolderName)))
                && ((this.newFolderName == other.newFolderName) || (this.newFolderName.equals(other.newFolderName)))
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
    static class Serializer extends StructSerializer<TeamFolderRenameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderRenameDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_folder_name");
            StoneSerializers.string().serialize(value.previousFolderName, g);
            g.writeFieldName("new_folder_name");
            StoneSerializers.string().serialize(value.newFolderName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderRenameDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderRenameDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_previousFolderName = null;
                String f_newFolderName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_folder_name".equals(field)) {
                        f_previousFolderName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_folder_name".equals(field)) {
                        f_newFolderName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousFolderName == null) {
                    throw new JsonParseException(p, "Required field \"previous_folder_name\" missing.");
                }
                if (f_newFolderName == null) {
                    throw new JsonParseException(p, "Required field \"new_folder_name\" missing.");
                }
                value = new TeamFolderRenameDetails(f_previousFolderName, f_newFolderName);
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
