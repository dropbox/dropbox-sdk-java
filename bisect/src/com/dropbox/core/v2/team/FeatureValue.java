/* DO NOT EDIT */
/* This file was generated from team.stone */

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
 * The values correspond to entries in {@link Feature}. You may get different
 * value according to your Dropbox Business plan.
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
public final class FeatureValue {
    // union team.FeatureValue (team.stone)

    /**
     * Discriminating tag type for {@link FeatureValue}.
     */
    public enum Tag {
        UPLOAD_API_RATE_LIMIT, // UploadApiRateLimitValue
        HAS_TEAM_SHARED_DROPBOX, // HasTeamSharedDropboxValue
        HAS_TEAM_FILE_EVENTS, // HasTeamFileEventsValue
        HAS_TEAM_SELECTIVE_SYNC, // HasTeamSelectiveSyncValue
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final FeatureValue OTHER = new FeatureValue().withTag(Tag.OTHER);

    private Tag _tag;
    private UploadApiRateLimitValue uploadApiRateLimitValue;
    private HasTeamSharedDropboxValue hasTeamSharedDropboxValue;
    private HasTeamFileEventsValue hasTeamFileEventsValue;
    private HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private FeatureValue() {
    }


    /**
     * The values correspond to entries in {@link Feature}. You may get
     * different value according to your Dropbox Business plan.
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private FeatureValue withTag(Tag _tag) {
        FeatureValue result = new FeatureValue();
        result._tag = _tag;
        return result;
    }

    /**
     * The values correspond to entries in {@link Feature}. You may get
     * different value according to your Dropbox Business plan.
     *
     * @param uploadApiRateLimitValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FeatureValue withTagAndUploadApiRateLimit(Tag _tag, UploadApiRateLimitValue uploadApiRateLimitValue) {
        FeatureValue result = new FeatureValue();
        result._tag = _tag;
        result.uploadApiRateLimitValue = uploadApiRateLimitValue;
        return result;
    }

    /**
     * The values correspond to entries in {@link Feature}. You may get
     * different value according to your Dropbox Business plan.
     *
     * @param hasTeamSharedDropboxValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FeatureValue withTagAndHasTeamSharedDropbox(Tag _tag, HasTeamSharedDropboxValue hasTeamSharedDropboxValue) {
        FeatureValue result = new FeatureValue();
        result._tag = _tag;
        result.hasTeamSharedDropboxValue = hasTeamSharedDropboxValue;
        return result;
    }

    /**
     * The values correspond to entries in {@link Feature}. You may get
     * different value according to your Dropbox Business plan.
     *
     * @param hasTeamFileEventsValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FeatureValue withTagAndHasTeamFileEvents(Tag _tag, HasTeamFileEventsValue hasTeamFileEventsValue) {
        FeatureValue result = new FeatureValue();
        result._tag = _tag;
        result.hasTeamFileEventsValue = hasTeamFileEventsValue;
        return result;
    }

    /**
     * The values correspond to entries in {@link Feature}. You may get
     * different value according to your Dropbox Business plan.
     *
     * @param hasTeamSelectiveSyncValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private FeatureValue withTagAndHasTeamSelectiveSync(Tag _tag, HasTeamSelectiveSyncValue hasTeamSelectiveSyncValue) {
        FeatureValue result = new FeatureValue();
        result._tag = _tag;
        result.hasTeamSelectiveSyncValue = hasTeamSelectiveSyncValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code FeatureValue}. </p>
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
     * Tag#UPLOAD_API_RATE_LIMIT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UPLOAD_API_RATE_LIMIT}, {@code false} otherwise.
     */
    public boolean isUploadApiRateLimit() {
        return this._tag == Tag.UPLOAD_API_RATE_LIMIT;
    }

    /**
     * Returns an instance of {@code FeatureValue} that has its tag set to
     * {@link Tag#UPLOAD_API_RATE_LIMIT}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FeatureValue} with its tag set to {@link
     *     Tag#UPLOAD_API_RATE_LIMIT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FeatureValue uploadApiRateLimit(UploadApiRateLimitValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndUploadApiRateLimit(Tag.UPLOAD_API_RATE_LIMIT, value);
    }

    /**
     * This instance must be tagged as {@link Tag#UPLOAD_API_RATE_LIMIT}.
     *
     * @return The {@link UploadApiRateLimitValue} value associated with this
     *     instance if {@link #isUploadApiRateLimit} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isUploadApiRateLimit} is {@code
     *     false}.
     */
    public UploadApiRateLimitValue getUploadApiRateLimitValue() {
        if (this._tag != Tag.UPLOAD_API_RATE_LIMIT) {
            throw new IllegalStateException("Invalid tag: required Tag.UPLOAD_API_RATE_LIMIT, but was Tag." + this._tag.name());
        }
        return uploadApiRateLimitValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#HAS_TEAM_SHARED_DROPBOX}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#HAS_TEAM_SHARED_DROPBOX}, {@code false} otherwise.
     */
    public boolean isHasTeamSharedDropbox() {
        return this._tag == Tag.HAS_TEAM_SHARED_DROPBOX;
    }

    /**
     * Returns an instance of {@code FeatureValue} that has its tag set to
     * {@link Tag#HAS_TEAM_SHARED_DROPBOX}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FeatureValue} with its tag set to {@link
     *     Tag#HAS_TEAM_SHARED_DROPBOX}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FeatureValue hasTeamSharedDropbox(HasTeamSharedDropboxValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamSharedDropbox(Tag.HAS_TEAM_SHARED_DROPBOX, value);
    }

    /**
     * This instance must be tagged as {@link Tag#HAS_TEAM_SHARED_DROPBOX}.
     *
     * @return The {@link HasTeamSharedDropboxValue} value associated with this
     *     instance if {@link #isHasTeamSharedDropbox} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isHasTeamSharedDropbox} is
     *     {@code false}.
     */
    public HasTeamSharedDropboxValue getHasTeamSharedDropboxValue() {
        if (this._tag != Tag.HAS_TEAM_SHARED_DROPBOX) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SHARED_DROPBOX, but was Tag." + this._tag.name());
        }
        return hasTeamSharedDropboxValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#HAS_TEAM_FILE_EVENTS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#HAS_TEAM_FILE_EVENTS}, {@code false} otherwise.
     */
    public boolean isHasTeamFileEvents() {
        return this._tag == Tag.HAS_TEAM_FILE_EVENTS;
    }

    /**
     * Returns an instance of {@code FeatureValue} that has its tag set to
     * {@link Tag#HAS_TEAM_FILE_EVENTS}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FeatureValue} with its tag set to {@link
     *     Tag#HAS_TEAM_FILE_EVENTS}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FeatureValue hasTeamFileEvents(HasTeamFileEventsValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamFileEvents(Tag.HAS_TEAM_FILE_EVENTS, value);
    }

    /**
     * This instance must be tagged as {@link Tag#HAS_TEAM_FILE_EVENTS}.
     *
     * @return The {@link HasTeamFileEventsValue} value associated with this
     *     instance if {@link #isHasTeamFileEvents} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isHasTeamFileEvents} is {@code
     *     false}.
     */
    public HasTeamFileEventsValue getHasTeamFileEventsValue() {
        if (this._tag != Tag.HAS_TEAM_FILE_EVENTS) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_FILE_EVENTS, but was Tag." + this._tag.name());
        }
        return hasTeamFileEventsValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#HAS_TEAM_SELECTIVE_SYNC}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#HAS_TEAM_SELECTIVE_SYNC}, {@code false} otherwise.
     */
    public boolean isHasTeamSelectiveSync() {
        return this._tag == Tag.HAS_TEAM_SELECTIVE_SYNC;
    }

    /**
     * Returns an instance of {@code FeatureValue} that has its tag set to
     * {@link Tag#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code FeatureValue} with its tag set to {@link
     *     Tag#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static FeatureValue hasTeamSelectiveSync(HasTeamSelectiveSyncValue value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new FeatureValue().withTagAndHasTeamSelectiveSync(Tag.HAS_TEAM_SELECTIVE_SYNC, value);
    }

    /**
     * This instance must be tagged as {@link Tag#HAS_TEAM_SELECTIVE_SYNC}.
     *
     * @return The {@link HasTeamSelectiveSyncValue} value associated with this
     *     instance if {@link #isHasTeamSelectiveSync} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isHasTeamSelectiveSync} is
     *     {@code false}.
     */
    public HasTeamSelectiveSyncValue getHasTeamSelectiveSyncValue() {
        if (this._tag != Tag.HAS_TEAM_SELECTIVE_SYNC) {
            throw new IllegalStateException("Invalid tag: required Tag.HAS_TEAM_SELECTIVE_SYNC, but was Tag." + this._tag.name());
        }
        return hasTeamSelectiveSyncValue;
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
            uploadApiRateLimitValue,
            hasTeamSharedDropboxValue,
            hasTeamFileEventsValue,
            hasTeamSelectiveSyncValue
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
        else if (obj instanceof FeatureValue) {
            FeatureValue other = (FeatureValue) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case UPLOAD_API_RATE_LIMIT:
                    return (this.uploadApiRateLimitValue == other.uploadApiRateLimitValue) || (this.uploadApiRateLimitValue.equals(other.uploadApiRateLimitValue));
                case HAS_TEAM_SHARED_DROPBOX:
                    return (this.hasTeamSharedDropboxValue == other.hasTeamSharedDropboxValue) || (this.hasTeamSharedDropboxValue.equals(other.hasTeamSharedDropboxValue));
                case HAS_TEAM_FILE_EVENTS:
                    return (this.hasTeamFileEventsValue == other.hasTeamFileEventsValue) || (this.hasTeamFileEventsValue.equals(other.hasTeamFileEventsValue));
                case HAS_TEAM_SELECTIVE_SYNC:
                    return (this.hasTeamSelectiveSyncValue == other.hasTeamSelectiveSyncValue) || (this.hasTeamSelectiveSyncValue.equals(other.hasTeamSelectiveSyncValue));
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
    static class Serializer extends UnionSerializer<FeatureValue> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FeatureValue value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case UPLOAD_API_RATE_LIMIT: {
                    g.writeStartObject();
                    writeTag("upload_api_rate_limit", g);
                    g.writeFieldName("upload_api_rate_limit");
                    UploadApiRateLimitValue.Serializer.INSTANCE.serialize(value.uploadApiRateLimitValue, g);
                    g.writeEndObject();
                    break;
                }
                case HAS_TEAM_SHARED_DROPBOX: {
                    g.writeStartObject();
                    writeTag("has_team_shared_dropbox", g);
                    g.writeFieldName("has_team_shared_dropbox");
                    HasTeamSharedDropboxValue.Serializer.INSTANCE.serialize(value.hasTeamSharedDropboxValue, g);
                    g.writeEndObject();
                    break;
                }
                case HAS_TEAM_FILE_EVENTS: {
                    g.writeStartObject();
                    writeTag("has_team_file_events", g);
                    g.writeFieldName("has_team_file_events");
                    HasTeamFileEventsValue.Serializer.INSTANCE.serialize(value.hasTeamFileEventsValue, g);
                    g.writeEndObject();
                    break;
                }
                case HAS_TEAM_SELECTIVE_SYNC: {
                    g.writeStartObject();
                    writeTag("has_team_selective_sync", g);
                    g.writeFieldName("has_team_selective_sync");
                    HasTeamSelectiveSyncValue.Serializer.INSTANCE.serialize(value.hasTeamSelectiveSyncValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public FeatureValue deserialize(JsonParser p) throws IOException, JsonParseException {
            FeatureValue value;
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
            else if ("upload_api_rate_limit".equals(tag)) {
                UploadApiRateLimitValue fieldValue = null;
                expectField("upload_api_rate_limit", p);
                fieldValue = UploadApiRateLimitValue.Serializer.INSTANCE.deserialize(p);
                value = FeatureValue.uploadApiRateLimit(fieldValue);
            }
            else if ("has_team_shared_dropbox".equals(tag)) {
                HasTeamSharedDropboxValue fieldValue = null;
                expectField("has_team_shared_dropbox", p);
                fieldValue = HasTeamSharedDropboxValue.Serializer.INSTANCE.deserialize(p);
                value = FeatureValue.hasTeamSharedDropbox(fieldValue);
            }
            else if ("has_team_file_events".equals(tag)) {
                HasTeamFileEventsValue fieldValue = null;
                expectField("has_team_file_events", p);
                fieldValue = HasTeamFileEventsValue.Serializer.INSTANCE.deserialize(p);
                value = FeatureValue.hasTeamFileEvents(fieldValue);
            }
            else if ("has_team_selective_sync".equals(tag)) {
                HasTeamSelectiveSyncValue fieldValue = null;
                expectField("has_team_selective_sync", p);
                fieldValue = HasTeamSelectiveSyncValue.Serializer.INSTANCE.deserialize(p);
                value = FeatureValue.hasTeamSelectiveSync(fieldValue);
            }
            else {
                value = FeatureValue.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
