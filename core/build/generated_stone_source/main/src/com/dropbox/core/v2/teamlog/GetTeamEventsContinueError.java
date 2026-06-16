/* DO NOT EDIT */
/* This file was generated from team_log.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Errors that can be raised when calling {@link
 * DbxTeamTeamLogRequests#getEventsContinue(String)}.
 *
 * <p> This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance. </p>
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class GetTeamEventsContinueError {
    // union team_log.GetTeamEventsContinueError (team_log.stone)

    /**
     * Discriminating tag type for {@link GetTeamEventsContinueError}.
     */
    public enum Tag {
        /**
         * Bad cursor.
         */
        BAD_CURSOR,
        /**
         * Cursors are intended to be used quickly. Individual cursor values are
         * normally valid for days, but in rare cases may be reset sooner.
         * Cursor reset errors should be handled by fetching a new cursor from
         * {@link DbxTeamTeamLogRequests#getEvents}. The associated value is the
         * approximate timestamp of the most recent event returned by the
         * cursor. This should be used as a resumption point when calling {@link
         * DbxTeamTeamLogRequests#getEvents} to obtain a new cursor.
         */
        RESET, // Date
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
     * Bad cursor.
     */
    public static final GetTeamEventsContinueError BAD_CURSOR = new GetTeamEventsContinueError().withTag(Tag.BAD_CURSOR);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final GetTeamEventsContinueError OTHER = new GetTeamEventsContinueError().withTag(Tag.OTHER);

    private Tag _tag;
    private Date resetValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private GetTeamEventsContinueError() {
    }


    /**
     * Errors that can be raised when calling {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)}.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private GetTeamEventsContinueError withTag(Tag _tag) {
        GetTeamEventsContinueError result = new GetTeamEventsContinueError();
        result._tag = _tag;
        return result;
    }

    /**
     * Errors that can be raised when calling {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)}.
     *
     * @param resetValue  Cursors are intended to be used quickly. Individual
     *     cursor values are normally valid for days, but in rare cases may be
     *     reset sooner. Cursor reset errors should be handled by fetching a new
     *     cursor from {@link DbxTeamTeamLogRequests#getEvents}. The associated
     *     value is the approximate timestamp of the most recent event returned
     *     by the cursor. This should be used as a resumption point when calling
     *     {@link DbxTeamTeamLogRequests#getEvents} to obtain a new cursor. Must
     *     not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private GetTeamEventsContinueError withTagAndReset(Tag _tag, Date resetValue) {
        GetTeamEventsContinueError result = new GetTeamEventsContinueError();
        result._tag = _tag;
        result.resetValue = resetValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code GetTeamEventsContinueError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link Tag#BAD_CURSOR},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#BAD_CURSOR}, {@code false} otherwise.
     */
    public boolean isBadCursor() {
        return this._tag == Tag.BAD_CURSOR;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#RESET},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#RESET},
     *     {@code false} otherwise.
     */
    public boolean isReset() {
        return this._tag == Tag.RESET;
    }

    /**
     * Returns an instance of {@code GetTeamEventsContinueError} that has its
     * tag set to {@link Tag#RESET}.
     *
     * <p> Cursors are intended to be used quickly. Individual cursor values are
     * normally valid for days, but in rare cases may be reset sooner. Cursor
     * reset errors should be handled by fetching a new cursor from {@link
     * DbxTeamTeamLogRequests#getEvents}. The associated value is the
     * approximate timestamp of the most recent event returned by the cursor.
     * This should be used as a resumption point when calling {@link
     * DbxTeamTeamLogRequests#getEvents} to obtain a new cursor. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code GetTeamEventsContinueError} with its tag set
     *     to {@link Tag#RESET}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static GetTeamEventsContinueError reset(Date value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new GetTeamEventsContinueError().withTagAndReset(Tag.RESET, value);
    }

    /**
     * Cursors are intended to be used quickly. Individual cursor values are
     * normally valid for days, but in rare cases may be reset sooner. Cursor
     * reset errors should be handled by fetching a new cursor from {@link
     * DbxTeamTeamLogRequests#getEvents}. The associated value is the
     * approximate timestamp of the most recent event returned by the cursor.
     * This should be used as a resumption point when calling {@link
     * DbxTeamTeamLogRequests#getEvents} to obtain a new cursor.
     *
     * <p> This instance must be tagged as {@link Tag#RESET}. </p>
     *
     * @return The {@link Date} value associated with this instance if {@link
     *     #isReset} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isReset} is {@code false}.
     */
    public Date getResetValue() {
        if (this._tag != Tag.RESET) {
            throw new IllegalStateException("Invalid tag: required Tag.RESET, but was Tag." + this._tag.name());
        }
        return resetValue;
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
            this.resetValue
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
        else if (obj instanceof GetTeamEventsContinueError) {
            GetTeamEventsContinueError other = (GetTeamEventsContinueError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case BAD_CURSOR:
                    return true;
                case RESET:
                    return (this.resetValue == other.resetValue) || (this.resetValue.equals(other.resetValue));
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
    static class Serializer extends UnionSerializer<GetTeamEventsContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetTeamEventsContinueError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case BAD_CURSOR: {
                    g.writeString("bad_cursor");
                    break;
                }
                case RESET: {
                    g.writeStartObject();
                    writeTag("reset", g);
                    g.writeFieldName("reset");
                    StoneSerializers.timestamp().serialize(value.resetValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GetTeamEventsContinueError deserialize(JsonParser p) throws IOException, JsonParseException {
            GetTeamEventsContinueError value;
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
            else if ("bad_cursor".equals(tag)) {
                value = GetTeamEventsContinueError.BAD_CURSOR;
            }
            else if ("reset".equals(tag)) {
                Date fieldValue = null;
                expectField("reset", p);
                fieldValue = StoneSerializers.timestamp().deserialize(p);
                value = GetTeamEventsContinueError.reset(fieldValue);
            }
            else {
                value = GetTeamEventsContinueError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
