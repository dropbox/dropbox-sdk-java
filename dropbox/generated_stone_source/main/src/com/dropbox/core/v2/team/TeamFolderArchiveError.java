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
public final class TeamFolderArchiveError {
    // union team.TeamFolderArchiveError (team_folders.stone)

    /**
     * Discriminating tag type for {@link TeamFolderArchiveError}.
     */
    public enum Tag {
        ACCESS_ERROR, // TeamFolderAccessError
        STATUS_ERROR, // TeamFolderInvalidStatusError
        TEAM_SHARED_DROPBOX_ERROR, // TeamFolderTeamSharedDropboxError
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER;
    }

    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final TeamFolderArchiveError OTHER = new TeamFolderArchiveError().withTag(Tag.OTHER);

    private Tag _tag;
    private TeamFolderAccessError accessErrorValue;
    private TeamFolderInvalidStatusError statusErrorValue;
    private TeamFolderTeamSharedDropboxError teamSharedDropboxErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TeamFolderArchiveError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TeamFolderArchiveError withTag(Tag _tag) {
        TeamFolderArchiveError result = new TeamFolderArchiveError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderArchiveError withTagAndAccessError(Tag _tag, TeamFolderAccessError accessErrorValue) {
        TeamFolderArchiveError result = new TeamFolderArchiveError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     *
     * @param statusErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderArchiveError withTagAndStatusError(Tag _tag, TeamFolderInvalidStatusError statusErrorValue) {
        TeamFolderArchiveError result = new TeamFolderArchiveError();
        result._tag = _tag;
        result.statusErrorValue = statusErrorValue;
        return result;
    }

    /**
     *
     * @param teamSharedDropboxErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderArchiveError withTagAndTeamSharedDropboxError(Tag _tag, TeamFolderTeamSharedDropboxError teamSharedDropboxErrorValue) {
        TeamFolderArchiveError result = new TeamFolderArchiveError();
        result._tag = _tag;
        result.teamSharedDropboxErrorValue = teamSharedDropboxErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TeamFolderArchiveError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code TeamFolderArchiveError} that has its tag
     * set to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderArchiveError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderArchiveError accessError(TeamFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link TeamFolderAccessError} value associated with this
     *     instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public TeamFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#STATUS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#STATUS_ERROR}, {@code false} otherwise.
     */
    public boolean isStatusError() {
        return this._tag == Tag.STATUS_ERROR;
    }

    /**
     * Returns an instance of {@code TeamFolderArchiveError} that has its tag
     * set to {@link Tag#STATUS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderArchiveError} with its tag set to
     *     {@link Tag#STATUS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderArchiveError statusError(TeamFolderInvalidStatusError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndStatusError(Tag.STATUS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#STATUS_ERROR}.
     *
     * @return The {@link TeamFolderInvalidStatusError} value associated with
     *     this instance if {@link #isStatusError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isStatusError} is {@code
     *     false}.
     */
    public TeamFolderInvalidStatusError getStatusErrorValue() {
        if (this._tag != Tag.STATUS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.STATUS_ERROR, but was Tag." + this._tag.name());
        }
        return statusErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_SHARED_DROPBOX_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_SHARED_DROPBOX_ERROR}, {@code false} otherwise.
     */
    public boolean isTeamSharedDropboxError() {
        return this._tag == Tag.TEAM_SHARED_DROPBOX_ERROR;
    }

    /**
     * Returns an instance of {@code TeamFolderArchiveError} that has its tag
     * set to {@link Tag#TEAM_SHARED_DROPBOX_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderArchiveError} with its tag set to
     *     {@link Tag#TEAM_SHARED_DROPBOX_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderArchiveError teamSharedDropboxError(TeamFolderTeamSharedDropboxError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderArchiveError().withTagAndTeamSharedDropboxError(Tag.TEAM_SHARED_DROPBOX_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TEAM_SHARED_DROPBOX_ERROR}.
     *
     * @return The {@link TeamFolderTeamSharedDropboxError} value associated
     *     with this instance if {@link #isTeamSharedDropboxError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isTeamSharedDropboxError} is
     *     {@code false}.
     */
    public TeamFolderTeamSharedDropboxError getTeamSharedDropboxErrorValue() {
        if (this._tag != Tag.TEAM_SHARED_DROPBOX_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_SHARED_DROPBOX_ERROR, but was Tag." + this._tag.name());
        }
        return teamSharedDropboxErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            accessErrorValue,
            statusErrorValue,
            teamSharedDropboxErrorValue
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
        else if (obj instanceof TeamFolderArchiveError) {
            TeamFolderArchiveError other = (TeamFolderArchiveError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case STATUS_ERROR:
                    return (this.statusErrorValue == other.statusErrorValue) || (this.statusErrorValue.equals(other.statusErrorValue));
                case TEAM_SHARED_DROPBOX_ERROR:
                    return (this.teamSharedDropboxErrorValue == other.teamSharedDropboxErrorValue) || (this.teamSharedDropboxErrorValue.equals(other.teamSharedDropboxErrorValue));
                case OTHER:
                    return true;
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
    static class Serializer extends UnionSerializer<TeamFolderArchiveError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderArchiveError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    TeamFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case STATUS_ERROR: {
                    g.writeStartObject();
                    writeTag("status_error", g);
                    g.writeFieldName("status_error");
                    TeamFolderInvalidStatusError.Serializer.INSTANCE.serialize(value.statusErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case TEAM_SHARED_DROPBOX_ERROR: {
                    g.writeStartObject();
                    writeTag("team_shared_dropbox_error", g);
                    g.writeFieldName("team_shared_dropbox_error");
                    TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.serialize(value.teamSharedDropboxErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public TeamFolderArchiveError deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderArchiveError value;
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
            else if ("access_error".equals(tag)) {
                TeamFolderAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = TeamFolderAccessError.Serializer.INSTANCE.deserialize(p);
                value = TeamFolderArchiveError.accessError(fieldValue);
            }
            else if ("status_error".equals(tag)) {
                TeamFolderInvalidStatusError fieldValue = null;
                expectField("status_error", p);
                fieldValue = TeamFolderInvalidStatusError.Serializer.INSTANCE.deserialize(p);
                value = TeamFolderArchiveError.statusError(fieldValue);
            }
            else if ("team_shared_dropbox_error".equals(tag)) {
                TeamFolderTeamSharedDropboxError fieldValue = null;
                expectField("team_shared_dropbox_error", p);
                fieldValue = TeamFolderTeamSharedDropboxError.Serializer.INSTANCE.deserialize(p);
                value = TeamFolderArchiveError.teamSharedDropboxError(fieldValue);
            }
            else if ("other".equals(tag)) {
                value = TeamFolderArchiveError.OTHER;
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
