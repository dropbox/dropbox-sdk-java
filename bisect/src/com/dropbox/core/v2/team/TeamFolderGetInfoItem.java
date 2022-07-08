/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class TeamFolderGetInfoItem {
    // union team.TeamFolderGetInfoItem (team_folders.stone)

    /**
     * Discriminating tag type for {@link TeamFolderGetInfoItem}.
     */
    public enum Tag {
        /**
         * An ID that was provided as a parameter to {@link
         * DbxTeamTeamRequests#teamFolderGetInfo(java.util.List)} did not match
         * any of the team's team folders.
         */
        ID_NOT_FOUND, // String
        /**
         * Properties of a team folder.
         */
        TEAM_FOLDER_METADATA; // TeamFolderMetadata
    }

    private Tag _tag;
    private String idNotFoundValue;
    private TeamFolderMetadata teamFolderMetadataValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TeamFolderGetInfoItem() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TeamFolderGetInfoItem withTag(Tag _tag) {
        TeamFolderGetInfoItem result = new TeamFolderGetInfoItem();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param idNotFoundValue  An ID that was provided as a parameter to {@link
     *     DbxTeamTeamRequests#teamFolderGetInfo(java.util.List)} did not match
     *     any of the team's team folders. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderGetInfoItem withTagAndIdNotFound(Tag _tag, String idNotFoundValue) {
        TeamFolderGetInfoItem result = new TeamFolderGetInfoItem();
        result._tag = _tag;
        result.idNotFoundValue = idNotFoundValue;
        return result;
    }

    /**
     *
     * @param teamFolderMetadataValue  Properties of a team folder. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderGetInfoItem withTagAndTeamFolderMetadata(Tag _tag, TeamFolderMetadata teamFolderMetadataValue) {
        TeamFolderGetInfoItem result = new TeamFolderGetInfoItem();
        result._tag = _tag;
        result.teamFolderMetadataValue = teamFolderMetadataValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TeamFolderGetInfoItem}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ID_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ID_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isIdNotFound() {
        return this._tag == Tag.ID_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code TeamFolderGetInfoItem} that has its tag set
     * to {@link Tag#ID_NOT_FOUND}.
     *
     * <p> An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#teamFolderGetInfo(java.util.List)} did not match any
     * of the team's team folders. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderGetInfoItem} with its tag set to
     *     {@link Tag#ID_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderGetInfoItem idNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderGetInfoItem().withTagAndIdNotFound(Tag.ID_NOT_FOUND, value);
    }

    /**
     * An ID that was provided as a parameter to {@link
     * DbxTeamTeamRequests#teamFolderGetInfo(java.util.List)} did not match any
     * of the team's team folders.
     *
     * <p> This instance must be tagged as {@link Tag#ID_NOT_FOUND}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isIdNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isIdNotFound} is {@code false}.
     */
    public String getIdNotFoundValue() {
        if (this._tag != Tag.ID_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.ID_NOT_FOUND, but was Tag." + this._tag.name());
        }
        return idNotFoundValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_FOLDER_METADATA}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_FOLDER_METADATA}, {@code false} otherwise.
     */
    public boolean isTeamFolderMetadata() {
        return this._tag == Tag.TEAM_FOLDER_METADATA;
    }

    /**
     * Returns an instance of {@code TeamFolderGetInfoItem} that has its tag set
     * to {@link Tag#TEAM_FOLDER_METADATA}.
     *
     * <p> Properties of a team folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderGetInfoItem} with its tag set to
     *     {@link Tag#TEAM_FOLDER_METADATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderGetInfoItem teamFolderMetadata(TeamFolderMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderGetInfoItem().withTagAndTeamFolderMetadata(Tag.TEAM_FOLDER_METADATA, value);
    }

    /**
     * Properties of a team folder.
     *
     * <p> This instance must be tagged as {@link Tag#TEAM_FOLDER_METADATA}.
     * </p>
     *
     * @return The {@link TeamFolderMetadata} value associated with this
     *     instance if {@link #isTeamFolderMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTeamFolderMetadata} is {@code
     *     false}.
     */
    public TeamFolderMetadata getTeamFolderMetadataValue() {
        if (this._tag != Tag.TEAM_FOLDER_METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_FOLDER_METADATA, but was Tag." + this._tag.name());
        }
        return teamFolderMetadataValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            idNotFoundValue,
            teamFolderMetadataValue
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
        else if (obj instanceof TeamFolderGetInfoItem) {
            TeamFolderGetInfoItem other = (TeamFolderGetInfoItem) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ID_NOT_FOUND:
                    return (this.idNotFoundValue == other.idNotFoundValue) || (this.idNotFoundValue.equals(other.idNotFoundValue));
                case TEAM_FOLDER_METADATA:
                    return (this.teamFolderMetadataValue == other.teamFolderMetadataValue) || (this.teamFolderMetadataValue.equals(other.teamFolderMetadataValue));
                default:
                    return false;
            }
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
    static class Serializer extends UnionSerializer<TeamFolderGetInfoItem> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderGetInfoItem value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ID_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("id_not_found", g);
                    g.writeFieldName("id_not_found");
                    StoneSerializers.string().serialize(value.idNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                case TEAM_FOLDER_METADATA: {
                    g.writeStartObject();
                    writeTag("team_folder_metadata", g);
                    TeamFolderMetadata.Serializer.INSTANCE.serialize(value.teamFolderMetadataValue, g, true);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public TeamFolderGetInfoItem deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderGetInfoItem value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("id_not_found".equals(tag)) {
                String fieldValue = null;
                expectField("id_not_found", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = TeamFolderGetInfoItem.idNotFound(fieldValue);
            }
            else if ("team_folder_metadata".equals(tag)) {
                TeamFolderMetadata fieldValue = null;
                fieldValue = TeamFolderMetadata.Serializer.INSTANCE.deserialize(p, true);
                value = TeamFolderGetInfoItem.teamFolderMetadata(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
