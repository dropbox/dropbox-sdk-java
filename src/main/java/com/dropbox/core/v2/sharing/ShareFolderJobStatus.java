/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class ShareFolderJobStatus {
    // union ShareFolderJobStatus

    /**
     * Discriminating tag type for {@link ShareFolderJobStatus}.
     */
    public enum Tag {
        /**
         * The asynchronous job is still in progress.
         */
        IN_PROGRESS,
        /**
         * The share job has finished. The value is the metadata for the folder.
         */
        COMPLETE, // SharedFolderMetadata
        FAILED; // ShareFolderError
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("complete", Tag.COMPLETE);
        VALUES_.put("failed", Tag.FAILED);
    }

    public static final ShareFolderJobStatus IN_PROGRESS = new ShareFolderJobStatus(Tag.IN_PROGRESS, null, null);

    private final Tag tag;
    private final SharedFolderMetadata completeValue;
    private final ShareFolderError failedValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ShareFolderJobStatus(Tag tag, SharedFolderMetadata completeValue, ShareFolderError failedValue) {
        this.tag = tag;
        this.completeValue = completeValue;
        this.failedValue = failedValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code ShareFolderJobStatus}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#COMPLETE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#COMPLETE}, {@code false} otherwise.
     */
    public boolean isComplete() {
        return this.tag == Tag.COMPLETE;
    }

    /**
     * Returns an instance of {@code ShareFolderJobStatus} that has its tag set
     * to {@link Tag#COMPLETE}.
     *
     * <p> The share job has finished. The value is the metadata for the folder.
     * </p>
     *
     * @param value  {@link ShareFolderJobStatus#complete} value to assign to
     *     this instance.
     *
     * @return Instance of {@code ShareFolderJobStatus} with its tag set to
     *     {@link Tag#COMPLETE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderJobStatus complete(SharedFolderMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus(Tag.COMPLETE, value, null);
    }

    /**
     * The share job has finished. The value is the metadata for the folder.
     *
     * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
     *
     * @return The {@link ShareFolderJobStatus#complete} value associated with
     *     this instance if {@link #isComplete} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isComplete} is {@code false}.
     */
    public SharedFolderMetadata getCompleteValue() {
        if (this.tag != Tag.COMPLETE) {
            throw new IllegalStateException("Invalid tag: required Tag.COMPLETE, but was Tag." + tag.name());
        }
        return completeValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#FAILED},
     *     {@code false} otherwise.
     */
    public boolean isFailed() {
        return this.tag == Tag.FAILED;
    }

    /**
     * Returns an instance of {@code ShareFolderJobStatus} that has its tag set
     * to {@link Tag#FAILED}.
     *
     * @param value  {@link ShareFolderJobStatus#failed} value to assign to this
     *     instance.
     *
     * @return Instance of {@code ShareFolderJobStatus} with its tag set to
     *     {@link Tag#FAILED}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ShareFolderJobStatus failed(ShareFolderError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ShareFolderJobStatus(Tag.FAILED, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FAILED}.
     *
     * @return The {@link ShareFolderJobStatus#failed} value associated with
     *     this instance if {@link #isFailed} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
     */
    public ShareFolderError getFailedValue() {
        if (this.tag != Tag.FAILED) {
            throw new IllegalStateException("Invalid tag: required Tag.FAILED, but was Tag." + tag.name());
        }
        return failedValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            completeValue,
            failedValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ShareFolderJobStatus) {
            ShareFolderJobStatus other = (ShareFolderJobStatus) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case IN_PROGRESS:
                    return true;
                case COMPLETE:
                    return (this.completeValue == other.completeValue) || (this.completeValue.equals(other.completeValue));
                case FAILED:
                    return (this.failedValue == other.failedValue) || (this.failedValue.equals(other.failedValue));
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ShareFolderJobStatus fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ShareFolderJobStatus> _JSON_WRITER = new JsonWriter<ShareFolderJobStatus>() {
        public final void write(ShareFolderJobStatus x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case IN_PROGRESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("in_progress");
                    g.writeEndObject();
                    break;
                case COMPLETE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("complete");
                    g.writeFieldName("complete");
                    SharedFolderMetadata._JSON_WRITER.write(x.getCompleteValue(), g);
                    g.writeEndObject();
                    break;
                case FAILED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("failed");
                    g.writeFieldName("failed");
                    ShareFolderError._JSON_WRITER.write(x.getFailedValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ShareFolderJobStatus> _JSON_READER = new JsonReader<ShareFolderJobStatus>() {

        public final ShareFolderJobStatus read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case IN_PROGRESS: return ShareFolderJobStatus.IN_PROGRESS;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            ShareFolderJobStatus value = null;
            if (tag != null) {
                switch (tag) {
                    case IN_PROGRESS: {
                        value = ShareFolderJobStatus.IN_PROGRESS;
                        break;
                    }
                    case COMPLETE: {
                        SharedFolderMetadata v = null;
                        v = SharedFolderMetadata._JSON_READER.readFields(parser);
                        value = ShareFolderJobStatus.complete(v);
                        break;
                    }
                    case FAILED: {
                        ShareFolderError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = ShareFolderError._JSON_READER
                            .readField(parser, "failed", v);
                        value = ShareFolderJobStatus.failed(v);
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
