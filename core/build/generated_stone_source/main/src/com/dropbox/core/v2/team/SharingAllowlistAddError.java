/* DO NOT EDIT */
/* This file was generated from team_sharing_allowlist.stone */

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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class SharingAllowlistAddError {
    // union team.SharingAllowlistAddError (team_sharing_allowlist.stone)

    /**
     * Discriminating tag type for {@link SharingAllowlistAddError}.
     */
    public enum Tag {
        /**
         * One of provided values is not valid.
         */
        MALFORMED_ENTRY, // String
        /**
         * Neither single domain nor email provided.
         */
        NO_ENTRIES_PROVIDED,
        /**
         * Too many entries provided within one call.
         */
        TOO_MANY_ENTRIES_PROVIDED,
        /**
         * Team entries limit reached.
         */
        TEAM_LIMIT_REACHED,
        /**
         * Unknown error.
         */
        UNKNOWN_ERROR,
        /**
         * Entries already exists.
         */
        ENTRIES_ALREADY_EXIST, // String
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
     * Neither single domain nor email provided.
     */
    public static final SharingAllowlistAddError NO_ENTRIES_PROVIDED = new SharingAllowlistAddError().withTag(Tag.NO_ENTRIES_PROVIDED);
    /**
     * Too many entries provided within one call.
     */
    public static final SharingAllowlistAddError TOO_MANY_ENTRIES_PROVIDED = new SharingAllowlistAddError().withTag(Tag.TOO_MANY_ENTRIES_PROVIDED);
    /**
     * Team entries limit reached.
     */
    public static final SharingAllowlistAddError TEAM_LIMIT_REACHED = new SharingAllowlistAddError().withTag(Tag.TEAM_LIMIT_REACHED);
    /**
     * Unknown error.
     */
    public static final SharingAllowlistAddError UNKNOWN_ERROR = new SharingAllowlistAddError().withTag(Tag.UNKNOWN_ERROR);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SharingAllowlistAddError OTHER = new SharingAllowlistAddError().withTag(Tag.OTHER);

    private Tag _tag;
    private String malformedEntryValue;
    private String entriesAlreadyExistValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private SharingAllowlistAddError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private SharingAllowlistAddError withTag(Tag _tag) {
        SharingAllowlistAddError result = new SharingAllowlistAddError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param malformedEntryValue  One of provided values is not valid. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SharingAllowlistAddError withTagAndMalformedEntry(Tag _tag, String malformedEntryValue) {
        SharingAllowlistAddError result = new SharingAllowlistAddError();
        result._tag = _tag;
        result.malformedEntryValue = malformedEntryValue;
        return result;
    }

    /**
     *
     * @param entriesAlreadyExistValue  Entries already exists. Must not be
     *     {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private SharingAllowlistAddError withTagAndEntriesAlreadyExist(Tag _tag, String entriesAlreadyExistValue) {
        SharingAllowlistAddError result = new SharingAllowlistAddError();
        result._tag = _tag;
        result.entriesAlreadyExistValue = entriesAlreadyExistValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code SharingAllowlistAddError}. </p>
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
     * Tag#MALFORMED_ENTRY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MALFORMED_ENTRY}, {@code false} otherwise.
     */
    public boolean isMalformedEntry() {
        return this._tag == Tag.MALFORMED_ENTRY;
    }

    /**
     * Returns an instance of {@code SharingAllowlistAddError} that has its tag
     * set to {@link Tag#MALFORMED_ENTRY}.
     *
     * <p> One of provided values is not valid. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SharingAllowlistAddError} with its tag set to
     *     {@link Tag#MALFORMED_ENTRY}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SharingAllowlistAddError malformedEntry(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistAddError().withTagAndMalformedEntry(Tag.MALFORMED_ENTRY, value);
    }

    /**
     * One of provided values is not valid.
     *
     * <p> This instance must be tagged as {@link Tag#MALFORMED_ENTRY}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isMalformedEntry} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMalformedEntry} is {@code
     *     false}.
     */
    public String getMalformedEntryValue() {
        if (this._tag != Tag.MALFORMED_ENTRY) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_ENTRY, but was Tag." + this._tag.name());
        }
        return malformedEntryValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_ENTRIES_PROVIDED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_ENTRIES_PROVIDED}, {@code false} otherwise.
     */
    public boolean isNoEntriesProvided() {
        return this._tag == Tag.NO_ENTRIES_PROVIDED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_ENTRIES_PROVIDED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_ENTRIES_PROVIDED}, {@code false} otherwise.
     */
    public boolean isTooManyEntriesProvided() {
        return this._tag == Tag.TOO_MANY_ENTRIES_PROVIDED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_LIMIT_REACHED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_LIMIT_REACHED}, {@code false} otherwise.
     */
    public boolean isTeamLimitReached() {
        return this._tag == Tag.TEAM_LIMIT_REACHED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNKNOWN_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNKNOWN_ERROR}, {@code false} otherwise.
     */
    public boolean isUnknownError() {
        return this._tag == Tag.UNKNOWN_ERROR;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ENTRIES_ALREADY_EXIST}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ENTRIES_ALREADY_EXIST}, {@code false} otherwise.
     */
    public boolean isEntriesAlreadyExist() {
        return this._tag == Tag.ENTRIES_ALREADY_EXIST;
    }

    /**
     * Returns an instance of {@code SharingAllowlistAddError} that has its tag
     * set to {@link Tag#ENTRIES_ALREADY_EXIST}.
     *
     * <p> Entries already exists. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SharingAllowlistAddError} with its tag set to
     *     {@link Tag#ENTRIES_ALREADY_EXIST}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SharingAllowlistAddError entriesAlreadyExist(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SharingAllowlistAddError().withTagAndEntriesAlreadyExist(Tag.ENTRIES_ALREADY_EXIST, value);
    }

    /**
     * Entries already exists.
     *
     * <p> This instance must be tagged as {@link Tag#ENTRIES_ALREADY_EXIST}.
     * </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isEntriesAlreadyExist} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isEntriesAlreadyExist} is
     *     {@code false}.
     */
    public String getEntriesAlreadyExistValue() {
        if (this._tag != Tag.ENTRIES_ALREADY_EXIST) {
            throw new IllegalStateException("Invalid tag: required Tag.ENTRIES_ALREADY_EXIST, but was Tag." + this._tag.name());
        }
        return entriesAlreadyExistValue;
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
            malformedEntryValue,
            entriesAlreadyExistValue
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
        else if (obj instanceof SharingAllowlistAddError) {
            SharingAllowlistAddError other = (SharingAllowlistAddError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case MALFORMED_ENTRY:
                    return (this.malformedEntryValue == other.malformedEntryValue) || (this.malformedEntryValue.equals(other.malformedEntryValue));
                case NO_ENTRIES_PROVIDED:
                    return true;
                case TOO_MANY_ENTRIES_PROVIDED:
                    return true;
                case TEAM_LIMIT_REACHED:
                    return true;
                case UNKNOWN_ERROR:
                    return true;
                case ENTRIES_ALREADY_EXIST:
                    return (this.entriesAlreadyExistValue == other.entriesAlreadyExistValue) || (this.entriesAlreadyExistValue.equals(other.entriesAlreadyExistValue));
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
    static class Serializer extends UnionSerializer<SharingAllowlistAddError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingAllowlistAddError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case MALFORMED_ENTRY: {
                    g.writeStartObject();
                    writeTag("malformed_entry", g);
                    g.writeFieldName("malformed_entry");
                    StoneSerializers.string().serialize(value.malformedEntryValue, g);
                    g.writeEndObject();
                    break;
                }
                case NO_ENTRIES_PROVIDED: {
                    g.writeString("no_entries_provided");
                    break;
                }
                case TOO_MANY_ENTRIES_PROVIDED: {
                    g.writeString("too_many_entries_provided");
                    break;
                }
                case TEAM_LIMIT_REACHED: {
                    g.writeString("team_limit_reached");
                    break;
                }
                case UNKNOWN_ERROR: {
                    g.writeString("unknown_error");
                    break;
                }
                case ENTRIES_ALREADY_EXIST: {
                    g.writeStartObject();
                    writeTag("entries_already_exist", g);
                    g.writeFieldName("entries_already_exist");
                    StoneSerializers.string().serialize(value.entriesAlreadyExistValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingAllowlistAddError deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingAllowlistAddError value;
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
            else if ("malformed_entry".equals(tag)) {
                String fieldValue = null;
                expectField("malformed_entry", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = SharingAllowlistAddError.malformedEntry(fieldValue);
            }
            else if ("no_entries_provided".equals(tag)) {
                value = SharingAllowlistAddError.NO_ENTRIES_PROVIDED;
            }
            else if ("too_many_entries_provided".equals(tag)) {
                value = SharingAllowlistAddError.TOO_MANY_ENTRIES_PROVIDED;
            }
            else if ("team_limit_reached".equals(tag)) {
                value = SharingAllowlistAddError.TEAM_LIMIT_REACHED;
            }
            else if ("unknown_error".equals(tag)) {
                value = SharingAllowlistAddError.UNKNOWN_ERROR;
            }
            else if ("entries_already_exist".equals(tag)) {
                String fieldValue = null;
                expectField("entries_already_exist", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = SharingAllowlistAddError.entriesAlreadyExist(fieldValue);
            }
            else {
                value = SharingAllowlistAddError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
