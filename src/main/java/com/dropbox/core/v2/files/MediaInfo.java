/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class MediaInfo {
    // union MediaInfo

    /**
     * Discriminating tag type for {@link MediaInfo}.
     */
    public enum Tag {
        /**
         * Indicate the photo/video is still under processing and metadata is
         * not available yet.
         */
        PENDING,
        /**
         * The metadata for the photo/video.
         */
        METADATA; // MediaMetadata
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("pending", Tag.PENDING);
        VALUES_.put("metadata", Tag.METADATA);
    }

    public static final MediaInfo PENDING = new MediaInfo(Tag.PENDING, null);

    private final Tag tag;
    private final MediaMetadata metadataValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private MediaInfo(Tag tag, MediaMetadata metadataValue) {
        this.tag = tag;
        this.metadataValue = metadataValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code MediaInfo}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PENDING},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#PENDING},
     *     {@code false} otherwise.
     */
    public boolean isPending() {
        return this.tag == Tag.PENDING;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#METADATA},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#METADATA}, {@code false} otherwise.
     */
    public boolean isMetadata() {
        return this.tag == Tag.METADATA;
    }

    /**
     * Returns an instance of {@code MediaInfo} that has its tag set to {@link
     * Tag#METADATA}.
     *
     * <p> The metadata for the photo/video. </p>
     *
     * @param value  {@link MediaInfo#metadata} value to assign to this
     *     instance.
     *
     * @return Instance of {@code MediaInfo} with its tag set to {@link
     *     Tag#METADATA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MediaInfo metadata(MediaMetadata value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MediaInfo(Tag.METADATA, value);
    }

    /**
     * The metadata for the photo/video.
     *
     * <p> This instance must be tagged as {@link Tag#METADATA}. </p>
     *
     * @return The {@link MediaInfo#metadata} value associated with this
     *     instance if {@link #isMetadata} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMetadata} is {@code false}.
     */
    public MediaMetadata getMetadataValue() {
        if (this.tag != Tag.METADATA) {
            throw new IllegalStateException("Invalid tag: required Tag.METADATA, but was Tag." + tag.name());
        }
        return metadataValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            metadataValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof MediaInfo) {
            MediaInfo other = (MediaInfo) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PENDING:
                    return true;
                case METADATA:
                    return (this.metadataValue == other.metadataValue) || (this.metadataValue.equals(other.metadataValue));
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

    public static MediaInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MediaInfo> _JSON_WRITER = new JsonWriter<MediaInfo>() {
        public final void write(MediaInfo x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PENDING:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("pending");
                    g.writeEndObject();
                    break;
                case METADATA:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("metadata");
                    g.writeFieldName("metadata");
                    MediaMetadata._JSON_WRITER.write(x.getMetadataValue(), g);
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MediaInfo> _JSON_READER = new JsonReader<MediaInfo>() {

        public final MediaInfo read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case PENDING: return MediaInfo.PENDING;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            MediaInfo value = null;
            if (tag != null) {
                switch (tag) {
                    case PENDING: {
                        value = MediaInfo.PENDING;
                        break;
                    }
                    case METADATA: {
                        MediaMetadata v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = MediaMetadata._JSON_READER
                            .readField(parser, "metadata", v);
                        value = MediaInfo.metadata(v);
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
