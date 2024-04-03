/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.v2.files.SyncSettingsError;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class TeamFolderCreateError {
    // union team.TeamFolderCreateError (team_folders.stone)

    /**
     * Discriminating tag type for {@link TeamFolderCreateError}.
     */
    public enum Tag {
        /**
         * The provided name cannot be used.
         */
        INVALID_FOLDER_NAME,
        /**
         * There is already a team folder with the provided name.
         */
        FOLDER_NAME_ALREADY_USED,
        /**
         * The provided name cannot be used because it is reserved.
         */
        FOLDER_NAME_RESERVED,
        /**
         * An error occurred setting the sync settings.
         */
        SYNC_SETTINGS_ERROR, // SyncSettingsError
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * The provided name cannot be used.
     */
    public static final TeamFolderCreateError INVALID_FOLDER_NAME = new TeamFolderCreateError().withTag(Tag.INVALID_FOLDER_NAME);
    /**
     * There is already a team folder with the provided name.
     */
    public static final TeamFolderCreateError FOLDER_NAME_ALREADY_USED = new TeamFolderCreateError().withTag(Tag.FOLDER_NAME_ALREADY_USED);
    /**
     * The provided name cannot be used because it is reserved.
     */
    public static final TeamFolderCreateError FOLDER_NAME_RESERVED = new TeamFolderCreateError().withTag(Tag.FOLDER_NAME_RESERVED);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final TeamFolderCreateError OTHER = new TeamFolderCreateError().withTag(Tag.OTHER);

    private Tag _tag;
    private SyncSettingsError syncSettingsErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TeamFolderCreateError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TeamFolderCreateError withTag(Tag _tag) {
        TeamFolderCreateError result = new TeamFolderCreateError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param syncSettingsErrorValue  An error occurred setting the sync
     *     settings. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private TeamFolderCreateError withTagAndSyncSettingsError(Tag _tag, SyncSettingsError syncSettingsErrorValue) {
        TeamFolderCreateError result = new TeamFolderCreateError();
        result._tag = _tag;
        result.syncSettingsErrorValue = syncSettingsErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TeamFolderCreateError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_FOLDER_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_FOLDER_NAME}, {@code false} otherwise.
     */
    public boolean isInvalidFolderName() {
        return this._tag == Tag.INVALID_FOLDER_NAME;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FOLDER_NAME_ALREADY_USED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FOLDER_NAME_ALREADY_USED}, {@code false} otherwise.
     */
    public boolean isFolderNameAlreadyUsed() {
        return this._tag == Tag.FOLDER_NAME_ALREADY_USED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FOLDER_NAME_RESERVED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FOLDER_NAME_RESERVED}, {@code false} otherwise.
     */
    public boolean isFolderNameReserved() {
        return this._tag == Tag.FOLDER_NAME_RESERVED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#SYNC_SETTINGS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#SYNC_SETTINGS_ERROR}, {@code false} otherwise.
     */
    public boolean isSyncSettingsError() {
        return this._tag == Tag.SYNC_SETTINGS_ERROR;
    }

    /**
     * Returns an instance of {@code TeamFolderCreateError} that has its tag set
     * to {@link Tag#SYNC_SETTINGS_ERROR}.
     *
     * <p> An error occurred setting the sync settings. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TeamFolderCreateError} with its tag set to
     *     {@link Tag#SYNC_SETTINGS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TeamFolderCreateError syncSettingsError(SyncSettingsError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TeamFolderCreateError().withTagAndSyncSettingsError(Tag.SYNC_SETTINGS_ERROR, value);
    }

    /**
     * An error occurred setting the sync settings.
     *
     * <p> This instance must be tagged as {@link Tag#SYNC_SETTINGS_ERROR}. </p>
     *
     * @return The {@link SyncSettingsError} value associated with this instance
     *     if {@link #isSyncSettingsError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isSyncSettingsError} is {@code
     *     false}.
     */
    public SyncSettingsError getSyncSettingsErrorValue() {
        if (this._tag != Tag.SYNC_SETTINGS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.SYNC_SETTINGS_ERROR, but was Tag." + this._tag.name());
        }
        return syncSettingsErrorValue;
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
            this._tag,
            this.syncSettingsErrorValue
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
        else if (obj instanceof TeamFolderCreateError) {
            TeamFolderCreateError other = (TeamFolderCreateError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case INVALID_FOLDER_NAME:
                    return true;
                case FOLDER_NAME_ALREADY_USED:
                    return true;
                case FOLDER_NAME_RESERVED:
                    return true;
                case SYNC_SETTINGS_ERROR:
                    return (this.syncSettingsErrorValue == other.syncSettingsErrorValue) || (this.syncSettingsErrorValue.equals(other.syncSettingsErrorValue));
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
    static class Serializer extends UnionSerializer<TeamFolderCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderCreateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case INVALID_FOLDER_NAME: {
                    g.writeString("invalid_folder_name");
                    break;
                }
                case FOLDER_NAME_ALREADY_USED: {
                    g.writeString("folder_name_already_used");
                    break;
                }
                case FOLDER_NAME_RESERVED: {
                    g.writeString("folder_name_reserved");
                    break;
                }
                case SYNC_SETTINGS_ERROR: {
                    g.writeStartObject();
                    writeTag("sync_settings_error", g);
                    g.writeFieldName("sync_settings_error");
                    SyncSettingsError.Serializer.INSTANCE.serialize(value.syncSettingsErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TeamFolderCreateError deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamFolderCreateError value;
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
            else if ("invalid_folder_name".equals(tag)) {
                value = TeamFolderCreateError.INVALID_FOLDER_NAME;
            }
            else if ("folder_name_already_used".equals(tag)) {
                value = TeamFolderCreateError.FOLDER_NAME_ALREADY_USED;
            }
            else if ("folder_name_reserved".equals(tag)) {
                value = TeamFolderCreateError.FOLDER_NAME_RESERVED;
            }
            else if ("sync_settings_error".equals(tag)) {
                SyncSettingsError fieldValue = null;
                expectField("sync_settings_error", p);
                fieldValue = SyncSettingsError.Serializer.INSTANCE.deserialize(p);
                value = TeamFolderCreateError.syncSettingsError(fieldValue);
            }
            else {
                value = TeamFolderCreateError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
