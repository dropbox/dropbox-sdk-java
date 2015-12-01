/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2;

import java.io.IOException;
import java.util.regex.Pattern;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.dropbox.core.DbxApiException;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonWriter;

/**
 * Classes and routes in namespace "files".
 */
public final class DbxFiles {
    // namespace files

    private final DbxRawClientV2 client;

    DbxFiles(DbxRawClientV2 client) {
        this.client = client;
    }

    /**
     * Metadata for a file or folder.
     */
    public static class Metadata {
        // struct Metadata
        /**
         * The last component of the path (including extension). This never
         * contains a slash.
         */
        public final String name;
        /**
         * The lowercased full path in the user's Dropbox. This always starts
         * with a slash.
         */
        public final String pathLower;

        public Metadata(String name, String pathLower) {
            this.name = name;
            if (name == null) {
                throw new RuntimeException("Required value for 'name' is null");
            }
            this.pathLower = pathLower;
            if (pathLower == null) {
                throw new RuntimeException("Required value for 'pathLower' is null");
            }
        }
        public JsonWriter getWriter() {
            return Metadata._writer;
        }
        static final JsonWriter<Metadata> _writer = new JsonWriter<Metadata>()
        {
            public final void write(Metadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                Metadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(Metadata x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("name", x.name);
                g.writeStringField("path_lower", x.pathLower);
            }
        };

        public static final JsonReader<Metadata> _reader = new JsonReader<Metadata>() {

            public final Metadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                Metadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final Metadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null && tags.length > 0) {
                    if ("file".equals(tags[0])) {
                        return FileMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("folder".equals(tags[0])) {
                        return FolderMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("deleted".equals(tags[0])) {
                        return DeletedMetadata._reader.readFromTags(tags, parser);
                    }
                    // If no match, fall back to base class
                }
                return readFields(parser);
            }

            public final Metadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String pathLower = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new Metadata(name, pathLower);
            }
        };

        public String toString() {
            return "Metadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Metadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Metadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Dimensions for a photo or video.
     */
    public static class Dimensions {
        // struct Dimensions
        /**
         * Height of the photo/video.
         */
        public final long height;
        /**
         * Width of the photo/video.
         */
        public final long width;

        public Dimensions(long height, long width) {
            this.height = height;
            this.width = width;
        }
        static final JsonWriter<Dimensions> _writer = new JsonWriter<Dimensions>()
        {
            public final void write(Dimensions x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                Dimensions._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(Dimensions x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("height", x.height);
                g.writeNumberField("width", x.width);
            }
        };

        public static final JsonReader<Dimensions> _reader = new JsonReader<Dimensions>() {

            public final Dimensions read(JsonParser parser)
                throws IOException, JsonReadException
            {
                Dimensions result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final Dimensions readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Long height = null;
                Long width = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("height".equals(fieldName)) {
                        height = JsonReader.UInt64Reader
                            .readField(parser, "height", height);
                    }
                    else if ("width".equals(fieldName)) {
                        width = JsonReader.UInt64Reader
                            .readField(parser, "width", width);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (height == null) {
                    throw new JsonReadException("Required field \"height\" is missing.", parser.getTokenLocation());
                }
                if (width == null) {
                    throw new JsonReadException("Required field \"width\" is missing.", parser.getTokenLocation());
                }
                return new Dimensions(height, width);
            }
        };

        public String toString() {
            return "Dimensions." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Dimensions." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Dimensions fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * GPS coordinates for a photo or video.
     */
    public static class GpsCoordinates {
        // struct GpsCoordinates
        /**
         * Latitude of the GPS coordinates.
         */
        public final double latitude;
        /**
         * Longitude of the GPS coordinates.
         */
        public final double longitude;

        public GpsCoordinates(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
        static final JsonWriter<GpsCoordinates> _writer = new JsonWriter<GpsCoordinates>()
        {
            public final void write(GpsCoordinates x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GpsCoordinates._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GpsCoordinates x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("latitude", x.latitude);
                g.writeNumberField("longitude", x.longitude);
            }
        };

        public static final JsonReader<GpsCoordinates> _reader = new JsonReader<GpsCoordinates>() {

            public final GpsCoordinates read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GpsCoordinates result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GpsCoordinates readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Double latitude = null;
                Double longitude = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("latitude".equals(fieldName)) {
                        latitude = JsonReader.Float64Reader
                            .readField(parser, "latitude", latitude);
                    }
                    else if ("longitude".equals(fieldName)) {
                        longitude = JsonReader.Float64Reader
                            .readField(parser, "longitude", longitude);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (latitude == null) {
                    throw new JsonReadException("Required field \"latitude\" is missing.", parser.getTokenLocation());
                }
                if (longitude == null) {
                    throw new JsonReadException("Required field \"longitude\" is missing.", parser.getTokenLocation());
                }
                return new GpsCoordinates(latitude, longitude);
            }
        };

        public String toString() {
            return "GpsCoordinates." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GpsCoordinates." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GpsCoordinates fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a photo or video.
     */
    public static class MediaMetadata {
        // struct MediaMetadata
        /**
         * Dimension of the photo/video.
         */
        public final Dimensions dimensions;
        /**
         * The GPS coordinate of the photo/video.
         */
        public final GpsCoordinates location;
        /**
         * The timestamp when the photo/video is taken.
         */
        public final java.util.Date timeTaken;

        public MediaMetadata(Dimensions dimensions, GpsCoordinates location, java.util.Date timeTaken) {
            this.dimensions = dimensions;
            if (dimensions != null) {
            }
            this.location = location;
            if (location != null) {
            }
            this.timeTaken = timeTaken;
        }
        public JsonWriter getWriter() {
            return MediaMetadata._writer;
        }
        static final JsonWriter<MediaMetadata> _writer = new JsonWriter<MediaMetadata>()
        {
            public final void write(MediaMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                MediaMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(MediaMetadata x, JsonGenerator g)
             throws IOException
            {
                if (x.dimensions != null) {
                    g.writeFieldName("dimensions");
                    Dimensions._writer.write(x.dimensions, g);
                }
                if (x.location != null) {
                    g.writeFieldName("location");
                    GpsCoordinates._writer.write(x.location, g);
                }
                if (x.timeTaken != null) {
                    g.writeFieldName("time_taken");
                    writeDateIso(x.timeTaken, g);
                }
            }
        };

        public static final JsonReader<MediaMetadata> _reader = new JsonReader<MediaMetadata>() {

            public final MediaMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                MediaMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final MediaMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null && tags.length > 0) {
                    if ("photo".equals(tags[0])) {
                        return PhotoMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("video".equals(tags[0])) {
                        return VideoMetadata._reader.readFromTags(tags, parser);
                    }
                    // If no match, fall back to base class
                }
                return readFields(parser);
            }

            public final MediaMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Dimensions dimensions = null;
                GpsCoordinates location = null;
                java.util.Date timeTaken = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("dimensions".equals(fieldName)) {
                        dimensions = Dimensions._reader
                            .readField(parser, "dimensions", dimensions);
                    }
                    else if ("location".equals(fieldName)) {
                        location = GpsCoordinates._reader
                            .readField(parser, "location", location);
                    }
                    else if ("time_taken".equals(fieldName)) {
                        timeTaken = JsonDateReader.DropboxV2
                            .readField(parser, "time_taken", timeTaken);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new MediaMetadata(dimensions, location, timeTaken);
            }
        };

        public String toString() {
            return "MediaMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MediaMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MediaMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a photo.
     */
    public static class PhotoMetadata extends MediaMetadata  {
        // struct PhotoMetadata

        public PhotoMetadata(Dimensions dimensions, GpsCoordinates location, java.util.Date timeTaken) {
            super(dimensions, location, timeTaken);
        }
        public JsonWriter getWriter() {
            return PhotoMetadata._writer;
        }
        static final JsonWriter<PhotoMetadata> _writer = new JsonWriter<PhotoMetadata>()
        {
            public final void write(PhotoMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "photo");
                MediaMetadata._writer.writeFields(x, g);
                PhotoMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(PhotoMetadata x, JsonGenerator g)
             throws IOException
            {
            }
        };

        public static final JsonReader<PhotoMetadata> _reader = new JsonReader<PhotoMetadata>() {

            public final PhotoMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                PhotoMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final PhotoMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "photo".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final PhotoMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Dimensions dimensions = null;
                GpsCoordinates location = null;
                java.util.Date timeTaken = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("dimensions".equals(fieldName)) {
                        dimensions = Dimensions._reader
                            .readField(parser, "dimensions", dimensions);
                    }
                    else if ("location".equals(fieldName)) {
                        location = GpsCoordinates._reader
                            .readField(parser, "location", location);
                    }
                    else if ("time_taken".equals(fieldName)) {
                        timeTaken = JsonDateReader.DropboxV2
                            .readField(parser, "time_taken", timeTaken);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new PhotoMetadata(dimensions, location, timeTaken);
            }
        };

        public String toString() {
            return "PhotoMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PhotoMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PhotoMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a video.
     */
    public static class VideoMetadata extends MediaMetadata  {
        // struct VideoMetadata
        /**
         * The duration of the video in milliseconds.
         */
        public final Long duration;

        public VideoMetadata(Dimensions dimensions, GpsCoordinates location, java.util.Date timeTaken, Long duration) {
            super(dimensions, location, timeTaken);
            this.duration = duration;
        }
        public JsonWriter getWriter() {
            return VideoMetadata._writer;
        }
        static final JsonWriter<VideoMetadata> _writer = new JsonWriter<VideoMetadata>()
        {
            public final void write(VideoMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "video");
                MediaMetadata._writer.writeFields(x, g);
                VideoMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(VideoMetadata x, JsonGenerator g)
             throws IOException
            {
                if (x.duration != null) {
                    g.writeFieldName("duration");
                    g.writeNumber(x.duration);
                }
            }
        };

        public static final JsonReader<VideoMetadata> _reader = new JsonReader<VideoMetadata>() {

            public final VideoMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                VideoMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final VideoMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "video".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final VideoMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Dimensions dimensions = null;
                GpsCoordinates location = null;
                java.util.Date timeTaken = null;
                Long duration = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("dimensions".equals(fieldName)) {
                        dimensions = Dimensions._reader
                            .readField(parser, "dimensions", dimensions);
                    }
                    else if ("location".equals(fieldName)) {
                        location = GpsCoordinates._reader
                            .readField(parser, "location", location);
                    }
                    else if ("time_taken".equals(fieldName)) {
                        timeTaken = JsonDateReader.DropboxV2
                            .readField(parser, "time_taken", timeTaken);
                    }
                    else if ("duration".equals(fieldName)) {
                        duration = JsonReader.UInt64Reader
                            .readField(parser, "duration", duration);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new VideoMetadata(dimensions, location, timeTaken, duration);
            }
        };

        public String toString() {
            return "VideoMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "VideoMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static VideoMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class MediaInfo {
        // union MediaInfo

        /**
         * The discriminating tag type for {@link MediaInfo}.
         */
        public enum Tag {
            pending,
            metadata  // MediaMetadata
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Indicate the photo/video is still under processing and metadata is
         * not available yet.
         */
        public static final MediaInfo pending = new MediaInfo(Tag.pending);

        private final MediaMetadata metadataValue;
        private MediaInfo(Tag t, MediaMetadata v) {
            tag = t;
            metadataValue = v;
            validate();
        }
        /**
         * The metadata for the photo/video.
         */
        public static MediaInfo metadata(MediaMetadata v) {
            return new MediaInfo(Tag.metadata, v);
        }
        public MediaMetadata getMetadata() {
            if (tag != Tag.metadata) {
                throw new RuntimeException("getMetadata() requires tag==metadata, actual tag=="+tag);
            }
            return metadataValue;
        }

        private MediaInfo(Tag t) {
            tag = t;
            metadataValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case pending:
                    break;
                case metadata:
                    if (this.metadataValue == null) {
                        throw new RuntimeException("Required value for 'metadata' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<MediaInfo> _writer = new JsonWriter<MediaInfo>()
        {
            public final void write(MediaInfo x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case pending:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("pending");
                        g.writeEndObject();
                        break;
                    case metadata:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("metadata");
                        g.writeFieldName("metadata");
                        MediaMetadata._writer.write(x.metadataValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<MediaInfo> _reader = new JsonReader<MediaInfo>()
        {
            public final MediaInfo read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case pending: return MediaInfo.pending;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                MediaInfo value = null;
                if (tag != null) {
                    switch (tag) {
                        case pending: {
                            value = MediaInfo.pending;
                            break;
                        }
                        case metadata: {
                            MediaMetadata v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = MediaMetadata._reader
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("pending", Tag.pending);
            _values.put("metadata", Tag.metadata);
        }

        public String toString() {
            return "MediaInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MediaInfo." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MediaInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class FileMetadata extends Metadata  {
        // struct FileMetadata
        /**
         * A unique identifier for the file.
         */
        public final String id;
        /**
         * For files, this is the modification time set by the desktop client
         * when the file was added to Dropbox. Since this time is not verified
         * (the Dropbox server stores whatever the desktop client sends up),
         * this should only be used for display purposes (such as sorting) and
         * not, for example, to determine if a file has changed or not.
         */
        public final java.util.Date clientModified;
        /**
         * The last time the file was modified on Dropbox.
         */
        public final java.util.Date serverModified;
        /**
         * A unique identifier for the current revision of a file. This field is
         * the same rev as elsewhere in the API and can be used to detect
         * changes and avoid conflicts.
         */
        public final String rev;
        /**
         * The file size in bytes.
         */
        public final long size;
        /**
         * Additional information if the file is a photo or video.
         */
        public final MediaInfo mediaInfo;

        public FileMetadata(String name, String pathLower, java.util.Date clientModified, java.util.Date serverModified, String rev, long size, String id, MediaInfo mediaInfo) {
            super(name, pathLower);
            this.id = id;
            if (id != null) {
                if (id.length() < 1) {
                    throw new RuntimeException("String 'id' is shorter than 1");
                }
            }
            this.clientModified = clientModified;
            if (clientModified == null) {
                throw new RuntimeException("Required value for 'clientModified' is null");
            }
            this.serverModified = serverModified;
            if (serverModified == null) {
                throw new RuntimeException("Required value for 'serverModified' is null");
            }
            this.rev = rev;
            if (rev == null) {
                throw new RuntimeException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new RuntimeException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("\\A[0-9a-f]+\\Z", rev)) {
                throw new RuntimeException("String 'rev' does not match pattern");
            }
            this.size = size;
            this.mediaInfo = mediaInfo;
            if (mediaInfo != null) {
            }
        }
        public JsonWriter getWriter() {
            return FileMetadata._writer;
        }
        static final JsonWriter<FileMetadata> _writer = new JsonWriter<FileMetadata>()
        {
            public final void write(FileMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "file");
                Metadata._writer.writeFields(x, g);
                FileMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FileMetadata x, JsonGenerator g)
             throws IOException
            {
                if (x.id != null) {
                    g.writeFieldName("id");
                    g.writeString(x.id);
                }
                g.writeFieldName("client_modified");
                writeDateIso(x.clientModified, g);
                g.writeFieldName("server_modified");
                writeDateIso(x.serverModified, g);
                g.writeStringField("rev", x.rev);
                g.writeNumberField("size", x.size);
                if (x.mediaInfo != null) {
                    g.writeFieldName("media_info");
                    MediaInfo._writer.write(x.mediaInfo, g);
                }
            }
        };

        public static final JsonReader<FileMetadata> _reader = new JsonReader<FileMetadata>() {

            public final FileMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FileMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FileMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "file".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final FileMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String pathLower = null;
                java.util.Date clientModified = null;
                java.util.Date serverModified = null;
                String rev = null;
                Long size = null;
                String id = null;
                MediaInfo mediaInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else if ("client_modified".equals(fieldName)) {
                        clientModified = JsonDateReader.DropboxV2
                            .readField(parser, "client_modified", clientModified);
                    }
                    else if ("server_modified".equals(fieldName)) {
                        serverModified = JsonDateReader.DropboxV2
                            .readField(parser, "server_modified", serverModified);
                    }
                    else if ("rev".equals(fieldName)) {
                        rev = JsonReader.StringReader
                            .readField(parser, "rev", rev);
                    }
                    else if ("size".equals(fieldName)) {
                        size = JsonReader.UInt64Reader
                            .readField(parser, "size", size);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("media_info".equals(fieldName)) {
                        mediaInfo = MediaInfo._reader
                            .readField(parser, "media_info", mediaInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                if (clientModified == null) {
                    throw new JsonReadException("Required field \"client_modified\" is missing.", parser.getTokenLocation());
                }
                if (serverModified == null) {
                    throw new JsonReadException("Required field \"server_modified\" is missing.", parser.getTokenLocation());
                }
                if (rev == null) {
                    throw new JsonReadException("Required field \"rev\" is missing.", parser.getTokenLocation());
                }
                if (size == null) {
                    throw new JsonReadException("Required field \"size\" is missing.", parser.getTokenLocation());
                }
                return new FileMetadata(name, pathLower, clientModified, serverModified, rev, size, id, mediaInfo);
            }
        };

        public String toString() {
            return "FileMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "FileMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static FileMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class FolderMetadata extends Metadata  {
        // struct FolderMetadata
        /**
         * A unique identifier for the folder.
         */
        public final String id;

        public FolderMetadata(String name, String pathLower, String id) {
            super(name, pathLower);
            this.id = id;
            if (id != null) {
                if (id.length() < 1) {
                    throw new RuntimeException("String 'id' is shorter than 1");
                }
            }
        }
        public JsonWriter getWriter() {
            return FolderMetadata._writer;
        }
        static final JsonWriter<FolderMetadata> _writer = new JsonWriter<FolderMetadata>()
        {
            public final void write(FolderMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "folder");
                Metadata._writer.writeFields(x, g);
                FolderMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FolderMetadata x, JsonGenerator g)
             throws IOException
            {
                if (x.id != null) {
                    g.writeFieldName("id");
                    g.writeString(x.id);
                }
            }
        };

        public static final JsonReader<FolderMetadata> _reader = new JsonReader<FolderMetadata>() {

            public final FolderMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FolderMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FolderMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "folder".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final FolderMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String pathLower = null;
                String id = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new FolderMetadata(name, pathLower, id);
            }
        };

        public String toString() {
            return "FolderMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "FolderMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static FolderMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Indicates that there used to be a file or folder at this path, but it no
     * longer exists.
     */
    public static class DeletedMetadata extends Metadata  {
        // struct DeletedMetadata

        public DeletedMetadata(String name, String pathLower) {
            super(name, pathLower);
        }
        public JsonWriter getWriter() {
            return DeletedMetadata._writer;
        }
        static final JsonWriter<DeletedMetadata> _writer = new JsonWriter<DeletedMetadata>()
        {
            public final void write(DeletedMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "deleted");
                Metadata._writer.writeFields(x, g);
                DeletedMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(DeletedMetadata x, JsonGenerator g)
             throws IOException
            {
            }
        };

        public static final JsonReader<DeletedMetadata> _reader = new JsonReader<DeletedMetadata>() {

            public final DeletedMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                DeletedMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final DeletedMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "deleted".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final DeletedMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String pathLower = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new DeletedMetadata(name, pathLower);
            }
        };

        public String toString() {
            return "DeletedMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "DeletedMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static DeletedMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class GetMetadataError {
        // union GetMetadataError

        /**
         * The discriminating tag type for {@link GetMetadataError}.
         */
        public enum Tag {
            path  // LookupError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private GetMetadataError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static GetMetadataError path(LookupError v) {
            return new GetMetadataError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }


        private void validate()
        {
            switch (tag) {
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<GetMetadataError> _writer = new JsonWriter<GetMetadataError>()
        {
            public final void write(GetMetadataError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<GetMetadataError> _reader = new JsonReader<GetMetadataError>()
        {
            public final GetMetadataError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                GetMetadataError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = GetMetadataError.path(v);
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
        }

        public String toString() {
            return "GetMetadataError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetMetadataError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetMetadataError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class GetMetadataArg {
        // struct GetMetadataArg
        /**
         * The path of a file or folder on Dropbox
         */
        public final String path;
        /**
         * If true, :field:'FileMetadata.media_info' is set for photo and video.
         */
        public final boolean includeMediaInfo;

        public GetMetadataArg(String path, Boolean includeMediaInfo) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A((/|id:).*)|(rev:[0-9a-f]{9,})\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (includeMediaInfo != null) {
                this.includeMediaInfo = includeMediaInfo.booleanValue();
            }
            else {
                this.includeMediaInfo = false;
            }
        }
        static final JsonWriter<GetMetadataArg> _writer = new JsonWriter<GetMetadataArg>()
        {
            public final void write(GetMetadataArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetMetadataArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetMetadataArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeBooleanField("include_media_info", x.includeMediaInfo);
            }
        };

        public static final JsonReader<GetMetadataArg> _reader = new JsonReader<GetMetadataArg>() {

            public final GetMetadataArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetMetadataArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetMetadataArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                Boolean includeMediaInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("include_media_info".equals(fieldName)) {
                        includeMediaInfo = JsonReader.BooleanReader
                            .readField(parser, "include_media_info", includeMediaInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new GetMetadataArg(path, includeMediaInfo);
            }
        };

        public String toString() {
            return "GetMetadataArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetMetadataArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetMetadataArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderLongpollArg {
        // struct ListFolderLongpollArg
        /**
         * A cursor as returned by {@link #listFolder} or {@link
         * #listFolderContinue}
         */
        public final String cursor;
        /**
         * A timeout in seconds. The request will block for at most this length
         * of time, plus up to 90 seconds of random jitter added to avoid the
         * thundering herd problem. Care should be taken when using this
         * parameter, as some network infrastructure does not support long
         * timeouts.
         */
        public final long timeout;

        public ListFolderLongpollArg(String cursor, Long timeout) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new RuntimeException("Required value for 'cursor' is null");
            }
            if (timeout != null) {
                this.timeout = timeout.longValue();
            }
            else {
                this.timeout = 30L;
            }
            if (this.timeout < 30L) {
                throw new RuntimeException("Number 'this.timeout' is smaller than 30L");
            }
            if (this.timeout > 480L) {
                throw new RuntimeException("Number 'this.timeout' is larger than 480L");
            }
        }
        static final JsonWriter<ListFolderLongpollArg> _writer = new JsonWriter<ListFolderLongpollArg>()
        {
            public final void write(ListFolderLongpollArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderLongpollArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderLongpollArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("cursor", x.cursor);
                g.writeNumberField("timeout", x.timeout);
            }
        };

        public static final JsonReader<ListFolderLongpollArg> _reader = new JsonReader<ListFolderLongpollArg>() {

            public final ListFolderLongpollArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderLongpollArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderLongpollArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String cursor = null;
                Long timeout = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else if ("timeout".equals(fieldName)) {
                        timeout = JsonReader.UInt64Reader
                            .readField(parser, "timeout", timeout);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (cursor == null) {
                    throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderLongpollArg(cursor, timeout);
            }
        };

        public String toString() {
            return "ListFolderLongpollArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderLongpollArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderLongpollArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderLongpollResult {
        // struct ListFolderLongpollResult
        /**
         * Indicates whether new changes are available. If true, call {@link
         * #listFolder} to retrieve the changes.
         */
        public final boolean changes;
        /**
         * If present, backoff for at least this many seconds before calling
         * {@link #listFolderLongpoll} again.
         */
        public final Long backoff;

        public ListFolderLongpollResult(boolean changes, Long backoff) {
            this.changes = changes;
            this.backoff = backoff;
        }
        static final JsonWriter<ListFolderLongpollResult> _writer = new JsonWriter<ListFolderLongpollResult>()
        {
            public final void write(ListFolderLongpollResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderLongpollResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderLongpollResult x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("changes", x.changes);
                if (x.backoff != null) {
                    g.writeFieldName("backoff");
                    g.writeNumber(x.backoff);
                }
            }
        };

        public static final JsonReader<ListFolderLongpollResult> _reader = new JsonReader<ListFolderLongpollResult>() {

            public final ListFolderLongpollResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderLongpollResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderLongpollResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean changes = null;
                Long backoff = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("changes".equals(fieldName)) {
                        changes = JsonReader.BooleanReader
                            .readField(parser, "changes", changes);
                    }
                    else if ("backoff".equals(fieldName)) {
                        backoff = JsonReader.UInt64Reader
                            .readField(parser, "backoff", backoff);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (changes == null) {
                    throw new JsonReadException("Required field \"changes\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderLongpollResult(changes, backoff);
            }
        };

        public String toString() {
            return "ListFolderLongpollResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderLongpollResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderLongpollResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum ListFolderLongpollError {
        // union ListFolderLongpollError
        /**
         * Indicates that the cursor has been invalidated. Call {@link
         * #listFolder} to obtain a new cursor.
         */
        reset,
        other;  // *catch_all

        static final JsonWriter<ListFolderLongpollError> _writer = new JsonWriter<ListFolderLongpollError>()
        {
            public void write(ListFolderLongpollError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case reset:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("reset");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<ListFolderLongpollError> _reader = new JsonReader<ListFolderLongpollError>()
        {
            public final ListFolderLongpollError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,ListFolderLongpollError> _values;
        static {
            _values = new java.util.HashMap<String,ListFolderLongpollError>();
            _values.put("reset", reset);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderLongpollError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderArg {
        // struct ListFolderArg
        /**
         * The path to the folder you want to see the contents of.
         */
        public final String path;
        /**
         * If true, the list folder operation will be applied recursively to all
         * subfolders and the response will contain contents of all subfolders.
         */
        public final boolean recursive;
        /**
         * If true, :field:'FileMetadata.media_info' is set for photo and video.
         */
        public final boolean includeMediaInfo;

        public ListFolderArg(String path, Boolean recursive, Boolean includeMediaInfo) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A(/.*)?\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (recursive != null) {
                this.recursive = recursive.booleanValue();
            }
            else {
                this.recursive = false;
            }
            if (includeMediaInfo != null) {
                this.includeMediaInfo = includeMediaInfo.booleanValue();
            }
            else {
                this.includeMediaInfo = false;
            }
        }
        static final JsonWriter<ListFolderArg> _writer = new JsonWriter<ListFolderArg>()
        {
            public final void write(ListFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeBooleanField("recursive", x.recursive);
                g.writeBooleanField("include_media_info", x.includeMediaInfo);
            }
        };

        public static final JsonReader<ListFolderArg> _reader = new JsonReader<ListFolderArg>() {

            public final ListFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                Boolean recursive = null;
                Boolean includeMediaInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("recursive".equals(fieldName)) {
                        recursive = JsonReader.BooleanReader
                            .readField(parser, "recursive", recursive);
                    }
                    else if ("include_media_info".equals(fieldName)) {
                        includeMediaInfo = JsonReader.BooleanReader
                            .readField(parser, "include_media_info", includeMediaInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderArg(path, recursive, includeMediaInfo);
            }
        };

        public String toString() {
            return "ListFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderResult {
        // struct ListFolderResult
        /**
         * The files and (direct) subfolders in the folder.
         */
        public final java.util.ArrayList<Metadata> entries;
        /**
         * Pass the cursor into {@link #listFolderContinue} to see what's
         * changed in the folder since your previous query.
         */
        public final String cursor;
        /**
         * If true, then there are more entries available. Pass the cursor to
         * {@link #listFolderContinue} to retrieve the rest.
         */
        public final boolean hasMore;

        public ListFolderResult(java.util.ArrayList<Metadata> entries, String cursor, boolean hasMore) {
            this.entries = entries;
            if (entries == null) {
                throw new RuntimeException("Required value for 'entries' is null");
            }
            for (Metadata x : entries) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'entries' is null");
                }
            }
            this.cursor = cursor;
            if (cursor == null) {
                throw new RuntimeException("Required value for 'cursor' is null");
            }
            this.hasMore = hasMore;
        }
        static final JsonWriter<ListFolderResult> _writer = new JsonWriter<ListFolderResult>()
        {
            public final void write(ListFolderResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderResult x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("entries");
                g.writeStartArray();
                for (Metadata item: x.entries) {
                    if (item != null) {
                        Metadata._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeStringField("cursor", x.cursor);
                g.writeBooleanField("has_more", x.hasMore);
            }
        };

        public static final JsonReader<ListFolderResult> _reader = new JsonReader<ListFolderResult>() {

            public final ListFolderResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.ArrayList<Metadata> entries = null;
                String cursor = null;
                Boolean hasMore = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("entries".equals(fieldName)) {
                        entries = JsonArrayReader.mk(Metadata._reader)
                            .readField(parser, "entries", entries);
                    }
                    else if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else if ("has_more".equals(fieldName)) {
                        hasMore = JsonReader.BooleanReader
                            .readField(parser, "has_more", hasMore);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (entries == null) {
                    throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
                }
                if (cursor == null) {
                    throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
                }
                if (hasMore == null) {
                    throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderResult(entries, cursor, hasMore);
            }
        };

        public String toString() {
            return "ListFolderResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListFolderError {
        // union ListFolderError

        /**
         * The discriminating tag type for {@link ListFolderError}.
         */
        public enum Tag {
            path,  // LookupError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private ListFolderError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static ListFolderError path(LookupError v) {
            return new ListFolderError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * An unspecified error.
         */
        public static final ListFolderError other = new ListFolderError(Tag.other);

        private ListFolderError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ListFolderError> _writer = new JsonWriter<ListFolderError>()
        {
            public final void write(ListFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ListFolderError> _reader = new JsonReader<ListFolderError>()
        {
            public final ListFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListFolderError.other; }
                    switch (tag) {
                        case other: return ListFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = ListFolderError.path(v);
                            break;
                        }
                        case other: {
                            value = ListFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "ListFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderContinueArg {
        // struct ListFolderContinueArg
        /**
         * The cursor returned by your last call to {@link #listFolder} or
         * {@link #listFolderContinue}.
         */
        public final String cursor;

        public ListFolderContinueArg(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new RuntimeException("Required value for 'cursor' is null");
            }
        }
        static final JsonWriter<ListFolderContinueArg> _writer = new JsonWriter<ListFolderContinueArg>()
        {
            public final void write(ListFolderContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderContinueArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("cursor", x.cursor);
            }
        };

        public static final JsonReader<ListFolderContinueArg> _reader = new JsonReader<ListFolderContinueArg>() {

            public final ListFolderContinueArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderContinueArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderContinueArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (cursor == null) {
                    throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderContinueArg(cursor);
            }
        };

        public String toString() {
            return "ListFolderContinueArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderContinueArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderContinueArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListFolderContinueError {
        // union ListFolderContinueError

        /**
         * The discriminating tag type for {@link ListFolderContinueError}.
         */
        public enum Tag {
            path,  // LookupError
            reset,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private ListFolderContinueError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static ListFolderContinueError path(LookupError v) {
            return new ListFolderContinueError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * Indicates that the cursor has been invalidated. Call {@link
         * #listFolder} to obtain a new cursor.
         */
        public static final ListFolderContinueError reset = new ListFolderContinueError(Tag.reset);

        public static final ListFolderContinueError other = new ListFolderContinueError(Tag.other);

        private ListFolderContinueError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case reset:
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ListFolderContinueError> _writer = new JsonWriter<ListFolderContinueError>()
        {
            public final void write(ListFolderContinueError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case reset:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("reset");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ListFolderContinueError> _reader = new JsonReader<ListFolderContinueError>()
        {
            public final ListFolderContinueError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListFolderContinueError.other; }
                    switch (tag) {
                        case reset: return ListFolderContinueError.reset;
                        case other: return ListFolderContinueError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListFolderContinueError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = ListFolderContinueError.path(v);
                            break;
                        }
                        case reset: {
                            value = ListFolderContinueError.reset;
                            break;
                        }
                        case other: {
                            value = ListFolderContinueError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderContinueError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("reset", Tag.reset);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "ListFolderContinueError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderContinueError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderContinueError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFolderGetLatestCursorResult {
        // struct ListFolderGetLatestCursorResult
        /**
         * Pass the cursor into {@link #listFolderContinue} to see what's
         * changed in the folder since your previous query.
         */
        public final String cursor;

        public ListFolderGetLatestCursorResult(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new RuntimeException("Required value for 'cursor' is null");
            }
        }
        static final JsonWriter<ListFolderGetLatestCursorResult> _writer = new JsonWriter<ListFolderGetLatestCursorResult>()
        {
            public final void write(ListFolderGetLatestCursorResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderGetLatestCursorResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderGetLatestCursorResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("cursor", x.cursor);
            }
        };

        public static final JsonReader<ListFolderGetLatestCursorResult> _reader = new JsonReader<ListFolderGetLatestCursorResult>() {

            public final ListFolderGetLatestCursorResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderGetLatestCursorResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderGetLatestCursorResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (cursor == null) {
                    throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderGetLatestCursorResult(cursor);
            }
        };

        public String toString() {
            return "ListFolderGetLatestCursorResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderGetLatestCursorResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderGetLatestCursorResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class DownloadError {
        // union DownloadError

        /**
         * The discriminating tag type for {@link DownloadError}.
         */
        public enum Tag {
            path,  // LookupError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private DownloadError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static DownloadError path(LookupError v) {
            return new DownloadError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * An unspecified error.
         */
        public static final DownloadError other = new DownloadError(Tag.other);

        private DownloadError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<DownloadError> _writer = new JsonWriter<DownloadError>()
        {
            public final void write(DownloadError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<DownloadError> _reader = new JsonReader<DownloadError>()
        {
            public final DownloadError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return DownloadError.other; }
                    switch (tag) {
                        case other: return DownloadError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                DownloadError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = DownloadError.path(v);
                            break;
                        }
                        case other: {
                            value = DownloadError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return DownloadError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "DownloadError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "DownloadError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static DownloadError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class DownloadArg {
        // struct DownloadArg
        /**
         * The path of the file to download.
         */
        public final String path;
        /**
         * Deprecated. Please specify revision in :field:'path' instead
         */
        public final String rev;

        public DownloadArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A((/|id:).*)|(rev:[0-9a-f]{9,})\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new RuntimeException("String 'rev' is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("\\A[0-9a-f]+\\Z", rev)) {
                    throw new RuntimeException("String 'rev' does not match pattern");
                }
            }
        }
        static final JsonWriter<DownloadArg> _writer = new JsonWriter<DownloadArg>()
        {
            public final void write(DownloadArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                DownloadArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(DownloadArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                if (x.rev != null) {
                    g.writeFieldName("rev");
                    g.writeString(x.rev);
                }
            }
        };

        public static final JsonReader<DownloadArg> _reader = new JsonReader<DownloadArg>() {

            public final DownloadArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                DownloadArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final DownloadArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                String rev = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("rev".equals(fieldName)) {
                        rev = JsonReader.StringReader
                            .readField(parser, "rev", rev);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new DownloadArg(path, rev);
            }
        };

        public String toString() {
            return "DownloadArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "DownloadArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static DownloadArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UploadWriteFailed {
        // struct UploadWriteFailed
        /**
         * The reason why the file couldn't be saved.
         */
        public final WriteError reason;
        /**
         * The upload session ID; this may be used to retry the commit.
         */
        public final String uploadSessionId;

        public UploadWriteFailed(WriteError reason, String uploadSessionId) {
            this.reason = reason;
            if (reason == null) {
                throw new RuntimeException("Required value for 'reason' is null");
            }
            this.uploadSessionId = uploadSessionId;
            if (uploadSessionId == null) {
                throw new RuntimeException("Required value for 'uploadSessionId' is null");
            }
        }
        static final JsonWriter<UploadWriteFailed> _writer = new JsonWriter<UploadWriteFailed>()
        {
            public final void write(UploadWriteFailed x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UploadWriteFailed._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UploadWriteFailed x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("reason");
                WriteError._writer.write(x.reason, g);
                g.writeStringField("upload_session_id", x.uploadSessionId);
            }
        };

        public static final JsonReader<UploadWriteFailed> _reader = new JsonReader<UploadWriteFailed>() {

            public final UploadWriteFailed read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadWriteFailed result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UploadWriteFailed readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                WriteError reason = null;
                String uploadSessionId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("reason".equals(fieldName)) {
                        reason = WriteError._reader
                            .readField(parser, "reason", reason);
                    }
                    else if ("upload_session_id".equals(fieldName)) {
                        uploadSessionId = JsonReader.StringReader
                            .readField(parser, "upload_session_id", uploadSessionId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (reason == null) {
                    throw new JsonReadException("Required field \"reason\" is missing.", parser.getTokenLocation());
                }
                if (uploadSessionId == null) {
                    throw new JsonReadException("Required field \"upload_session_id\" is missing.", parser.getTokenLocation());
                }
                return new UploadWriteFailed(reason, uploadSessionId);
            }
        };

        public String toString() {
            return "UploadWriteFailed." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadWriteFailed." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadWriteFailed fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UploadError {
        // union UploadError

        /**
         * The discriminating tag type for {@link UploadError}.
         */
        public enum Tag {
            path,  // UploadWriteFailed
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final UploadWriteFailed pathValue;
        private UploadError(Tag t, UploadWriteFailed v) {
            tag = t;
            pathValue = v;
            validate();
        }
        /**
         * Unable to save the uploaded contents to a file.
         */
        public static UploadError path(UploadWriteFailed v) {
            return new UploadError(Tag.path, v);
        }
        public UploadWriteFailed getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * An unspecified error.
         */
        public static final UploadError other = new UploadError(Tag.other);

        private UploadError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UploadError> _writer = new JsonWriter<UploadError>()
        {
            public final void write(UploadError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        UploadWriteFailed._writer.writeFields(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<UploadError> _reader = new JsonReader<UploadError>()
        {
            public final UploadError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UploadError.other; }
                    switch (tag) {
                        case other: return UploadError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UploadError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            UploadWriteFailed v = null;
                            v = UploadWriteFailed._reader.readFields(parser);
                            value = UploadError.path(v);
                            break;
                        }
                        case other: {
                            value = UploadError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UploadError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UploadSessionOffsetError {
        // struct UploadSessionOffsetError
        /**
         * The offset up to which data has been collected.
         */
        public final long correctOffset;

        public UploadSessionOffsetError(long correctOffset) {
            this.correctOffset = correctOffset;
        }
        static final JsonWriter<UploadSessionOffsetError> _writer = new JsonWriter<UploadSessionOffsetError>()
        {
            public final void write(UploadSessionOffsetError x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UploadSessionOffsetError._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UploadSessionOffsetError x, JsonGenerator g)
             throws IOException
            {
                g.writeNumberField("correct_offset", x.correctOffset);
            }
        };

        public static final JsonReader<UploadSessionOffsetError> _reader = new JsonReader<UploadSessionOffsetError>() {

            public final UploadSessionOffsetError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadSessionOffsetError result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UploadSessionOffsetError readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Long correctOffset = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("correct_offset".equals(fieldName)) {
                        correctOffset = JsonReader.UInt64Reader
                            .readField(parser, "correct_offset", correctOffset);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (correctOffset == null) {
                    throw new JsonReadException("Required field \"correct_offset\" is missing.", parser.getTokenLocation());
                }
                return new UploadSessionOffsetError(correctOffset);
            }
        };

        public String toString() {
            return "UploadSessionOffsetError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionOffsetError." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionOffsetError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UploadSessionLookupError {
        // union UploadSessionLookupError

        /**
         * The discriminating tag type for {@link UploadSessionLookupError}.
         */
        public enum Tag {
            notFound,
            incorrectOffset,  // UploadSessionOffsetError
            closed,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * The upload session id was not found.
         */
        public static final UploadSessionLookupError notFound = new UploadSessionLookupError(Tag.notFound);

        private final UploadSessionOffsetError incorrectOffsetValue;
        private UploadSessionLookupError(Tag t, UploadSessionOffsetError v) {
            tag = t;
            incorrectOffsetValue = v;
            validate();
        }
        /**
         * The specified offset was incorrect. See the value for the correct
         * offset. (This error may occur when a previous request was received
         * and processed successfully but the client did not receive the
         * response, e.g. due to a network error.)
         */
        public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError v) {
            return new UploadSessionLookupError(Tag.incorrectOffset, v);
        }
        public UploadSessionOffsetError getIncorrectOffset() {
            if (tag != Tag.incorrectOffset) {
                throw new RuntimeException("getIncorrectOffset() requires tag==incorrectOffset, actual tag=="+tag);
            }
            return incorrectOffsetValue;
        }

        /**
         * You are attempting to append data to an upload session that has
         * alread been closed (i.e. committed).
         */
        public static final UploadSessionLookupError closed = new UploadSessionLookupError(Tag.closed);

        /**
         * An unspecified error.
         */
        public static final UploadSessionLookupError other = new UploadSessionLookupError(Tag.other);

        private UploadSessionLookupError(Tag t) {
            tag = t;
            incorrectOffsetValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case notFound:
                case closed:
                case other:
                    break;
                case incorrectOffset:
                    if (this.incorrectOffsetValue == null) {
                        throw new RuntimeException("Required value for 'incorrectOffset' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UploadSessionLookupError> _writer = new JsonWriter<UploadSessionLookupError>()
        {
            public final void write(UploadSessionLookupError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case notFound:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_found");
                        g.writeEndObject();
                        break;
                    case incorrectOffset:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("incorrect_offset");
                        UploadSessionOffsetError._writer.writeFields(x.incorrectOffsetValue, g);
                        g.writeEndObject();
                        break;
                    case closed:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("closed");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<UploadSessionLookupError> _reader = new JsonReader<UploadSessionLookupError>()
        {
            public final UploadSessionLookupError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UploadSessionLookupError.other; }
                    switch (tag) {
                        case notFound: return UploadSessionLookupError.notFound;
                        case closed: return UploadSessionLookupError.closed;
                        case other: return UploadSessionLookupError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UploadSessionLookupError value = null;
                if (tag != null) {
                    switch (tag) {
                        case notFound: {
                            value = UploadSessionLookupError.notFound;
                            break;
                        }
                        case incorrectOffset: {
                            UploadSessionOffsetError v = null;
                            v = UploadSessionOffsetError._reader.readFields(parser);
                            value = UploadSessionLookupError.incorrectOffset(v);
                            break;
                        }
                        case closed: {
                            value = UploadSessionLookupError.closed;
                            break;
                        }
                        case other: {
                            value = UploadSessionLookupError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadSessionLookupError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("not_found", Tag.notFound);
            _values.put("incorrect_offset", Tag.incorrectOffset);
            _values.put("closed", Tag.closed);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UploadSessionLookupError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionLookupError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionLookupError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UploadSessionFinishError {
        // union UploadSessionFinishError

        /**
         * The discriminating tag type for {@link UploadSessionFinishError}.
         */
        public enum Tag {
            lookupFailed,  // UploadSessionLookupError
            path,  // WriteError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final UploadSessionLookupError lookupFailedValue;
        private UploadSessionFinishError(Tag t, UploadSessionLookupError v) {
            tag = t;
            lookupFailedValue = v;
            pathValue = null;
            validate();
        }
        /**
         * The session arguments are incorrect; the value explains the reason.
         */
        public static UploadSessionFinishError lookupFailed(UploadSessionLookupError v) {
            return new UploadSessionFinishError(Tag.lookupFailed, v);
        }
        public UploadSessionLookupError getLookupFailed() {
            if (tag != Tag.lookupFailed) {
                throw new RuntimeException("getLookupFailed() requires tag==lookupFailed, actual tag=="+tag);
            }
            return lookupFailedValue;
        }

        private final WriteError pathValue;
        private UploadSessionFinishError(Tag t, WriteError v) {
            tag = t;
            lookupFailedValue = null;
            pathValue = v;
            validate();
        }
        /**
         * Unable to save the uploaded contents to a file.
         */
        public static UploadSessionFinishError path(WriteError v) {
            return new UploadSessionFinishError(Tag.path, v);
        }
        public WriteError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * An unspecified error.
         */
        public static final UploadSessionFinishError other = new UploadSessionFinishError(Tag.other);

        private UploadSessionFinishError(Tag t) {
            tag = t;
            lookupFailedValue = null;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case lookupFailed:
                    if (this.lookupFailedValue == null) {
                        throw new RuntimeException("Required value for 'lookupFailed' is null");
                    }
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UploadSessionFinishError> _writer = new JsonWriter<UploadSessionFinishError>()
        {
            public final void write(UploadSessionFinishError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case lookupFailed:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("lookup_failed");
                        g.writeFieldName("lookup_failed");
                        UploadSessionLookupError._writer.write(x.lookupFailedValue, g);
                        g.writeEndObject();
                        break;
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        WriteError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<UploadSessionFinishError> _reader = new JsonReader<UploadSessionFinishError>()
        {
            public final UploadSessionFinishError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UploadSessionFinishError.other; }
                    switch (tag) {
                        case other: return UploadSessionFinishError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UploadSessionFinishError value = null;
                if (tag != null) {
                    switch (tag) {
                        case lookupFailed: {
                            UploadSessionLookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = UploadSessionLookupError._reader
                                .readField(parser, "lookup_failed", v);
                            value = UploadSessionFinishError.lookupFailed(v);
                            break;
                        }
                        case path: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "path", v);
                            value = UploadSessionFinishError.path(v);
                            break;
                        }
                        case other: {
                            value = UploadSessionFinishError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadSessionFinishError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("lookup_failed", Tag.lookupFailed);
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UploadSessionFinishError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionFinishError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionFinishError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UploadSessionStartResult {
        // struct UploadSessionStartResult
        /**
         * A unique identifier for the upload session. Pass this to {@link
         * #uploadSessionAppend} and {@link #uploadSessionFinish}.
         */
        public final String sessionId;

        public UploadSessionStartResult(String sessionId) {
            this.sessionId = sessionId;
            if (sessionId == null) {
                throw new RuntimeException("Required value for 'sessionId' is null");
            }
        }
        static final JsonWriter<UploadSessionStartResult> _writer = new JsonWriter<UploadSessionStartResult>()
        {
            public final void write(UploadSessionStartResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UploadSessionStartResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UploadSessionStartResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("session_id", x.sessionId);
            }
        };

        public static final JsonReader<UploadSessionStartResult> _reader = new JsonReader<UploadSessionStartResult>() {

            public final UploadSessionStartResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadSessionStartResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UploadSessionStartResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sessionId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("session_id".equals(fieldName)) {
                        sessionId = JsonReader.StringReader
                            .readField(parser, "session_id", sessionId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sessionId == null) {
                    throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
                }
                return new UploadSessionStartResult(sessionId);
            }
        };

        public String toString() {
            return "UploadSessionStartResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionStartResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionStartResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UploadSessionCursor {
        // struct UploadSessionCursor
        /**
         * The upload session ID (returned by {@link #uploadSessionStart}).
         */
        public final String sessionId;
        /**
         * The amount of data that has been uploaded so far. We use this to make
         * sure upload data isn't lost or duplicated in the event of a network
         * error.
         */
        public final long offset;

        public UploadSessionCursor(String sessionId, long offset) {
            this.sessionId = sessionId;
            if (sessionId == null) {
                throw new RuntimeException("Required value for 'sessionId' is null");
            }
            this.offset = offset;
        }
        static final JsonWriter<UploadSessionCursor> _writer = new JsonWriter<UploadSessionCursor>()
        {
            public final void write(UploadSessionCursor x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UploadSessionCursor._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UploadSessionCursor x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("session_id", x.sessionId);
                g.writeNumberField("offset", x.offset);
            }
        };

        public static final JsonReader<UploadSessionCursor> _reader = new JsonReader<UploadSessionCursor>() {

            public final UploadSessionCursor read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadSessionCursor result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UploadSessionCursor readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sessionId = null;
                Long offset = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("session_id".equals(fieldName)) {
                        sessionId = JsonReader.StringReader
                            .readField(parser, "session_id", sessionId);
                    }
                    else if ("offset".equals(fieldName)) {
                        offset = JsonReader.UInt64Reader
                            .readField(parser, "offset", offset);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sessionId == null) {
                    throw new JsonReadException("Required field \"session_id\" is missing.", parser.getTokenLocation());
                }
                if (offset == null) {
                    throw new JsonReadException("Required field \"offset\" is missing.", parser.getTokenLocation());
                }
                return new UploadSessionCursor(sessionId, offset);
            }
        };

        public String toString() {
            return "UploadSessionCursor." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionCursor." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionCursor fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Your intent when writing a file to some path. This is used to determine
     * what constitutes a conflict and what the autorename strategy is. In some
     * situations, the conflict behavior is identical: (a) If the target path
     * doesn't contain anything, the file is always written; no conflict. (b) If
     * the target path contains a folder, it's always a conflict. (c) If the
     * target path contains a file with identical contents, nothing gets
     * written; no conflict. The conflict checking differs in the case where
     * there's a file at the target path with contents different from the
     * contents you're trying to write.
     */

    public static final class WriteMode {
        // union WriteMode

        /**
         * The discriminating tag type for {@link WriteMode}.
         */
        public enum Tag {
            add,
            overwrite,
            update  // String
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Never overwrite the existing file. The autorename strategy is to
         * append a number to the file name. For example, "document.txt" might
         * become "document (2).txt".
         */
        public static final WriteMode add = new WriteMode(Tag.add);

        /**
         * Always overwrite the existing file. The autorename strategy is the
         * same as it is for {@code add}.
         */
        public static final WriteMode overwrite = new WriteMode(Tag.overwrite);

        private final String updateValue;
        private WriteMode(Tag t, String v) {
            tag = t;
            updateValue = v;
            validate();
        }
        /**
         * Overwrite if the given "rev" matches the existing file's "rev". The
         * autorename strategy is to append the string "conflicted copy" to the
         * file name. For example, "document.txt" might become "document
         * (conflicted copy).txt" or "document (Panda's conflicted copy).txt".
         */
        public static WriteMode update(String v) {
            return new WriteMode(Tag.update, v);
        }
        public String getUpdate() {
            if (tag != Tag.update) {
                throw new RuntimeException("getUpdate() requires tag==update, actual tag=="+tag);
            }
            return updateValue;
        }

        private WriteMode(Tag t) {
            tag = t;
            updateValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case add:
                case overwrite:
                    break;
                case update:
                    if (this.updateValue == null) {
                        throw new RuntimeException("Required value for 'update' is null");
                    }
                    if (this.updateValue.length() < 9) {
                        throw new RuntimeException("String 'this.updateValue' is shorter than 9");
                    }
                    if (!java.util.regex.Pattern.matches("\\A[0-9a-f]+\\Z", this.updateValue)) {
                        throw new RuntimeException("String 'this.updateValue' does not match pattern");
                    }
                    break;
            }
        }
        static final JsonWriter<WriteMode> _writer = new JsonWriter<WriteMode>()
        {
            public final void write(WriteMode x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case add:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("add");
                        g.writeEndObject();
                        break;
                    case overwrite:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("overwrite");
                        g.writeEndObject();
                        break;
                    case update:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("update");
                        g.writeStringField("update", x.updateValue);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<WriteMode> _reader = new JsonReader<WriteMode>()
        {
            public final WriteMode read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case add: return WriteMode.add;
                        case overwrite: return WriteMode.overwrite;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                WriteMode value = null;
                if (tag != null) {
                    switch (tag) {
                        case add: {
                            value = WriteMode.add;
                            break;
                        }
                        case overwrite: {
                            value = WriteMode.overwrite;
                            break;
                        }
                        case update: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "update", v);
                            value = WriteMode.update(v);
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("add", Tag.add);
            _values.put("overwrite", Tag.overwrite);
            _values.put("update", Tag.update);
        }

        public String toString() {
            return "WriteMode." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "WriteMode." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static WriteMode fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class CommitInfo {
        // struct CommitInfo
        /**
         * Path in the user's Dropbox to save the file.
         */
        public final String path;
        /**
         * Selects what to do if the file already exists.
         */
        public final WriteMode mode;
        /**
         * If there's a conflict, as determined by {@code mode}, have the
         * Dropbox server try to autorename the file to avoid conflict.
         */
        public final boolean autorename;
        /**
         * The value to store as the {@code clientModified} timestamp. Dropbox
         * automatically records the time at which the file was written to the
         * Dropbox servers. It can also record an additional timestamp, provided
         * by Dropbox desktop clients, mobile clients, and API apps of when the
         * file was actually created or modified.
         */
        public final java.util.Date clientModified;
        /**
         * Normally, users are made aware of any file modifications in their
         * Dropbox account via notifications in the client software. If
         * {@literal true}, this tells the clients that this modification
         * shouldn't result in a user notification.
         */
        public final boolean mute;

        public CommitInfo(String path, WriteMode mode, Boolean autorename, java.util.Date clientModified, Boolean mute) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = WriteMode.add;
            }
            if (autorename != null) {
                this.autorename = autorename.booleanValue();
            }
            else {
                this.autorename = false;
            }
            this.clientModified = clientModified;
            if (mute != null) {
                this.mute = mute.booleanValue();
            }
            else {
                this.mute = false;
            }
        }
        static final JsonWriter<CommitInfo> _writer = new JsonWriter<CommitInfo>()
        {
            public final void write(CommitInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                CommitInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(CommitInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeFieldName("mode");
                WriteMode._writer.write(x.mode, g);
                g.writeBooleanField("autorename", x.autorename);
                if (x.clientModified != null) {
                    g.writeFieldName("client_modified");
                    writeDateIso(x.clientModified, g);
                }
                g.writeBooleanField("mute", x.mute);
            }
        };

        public static final JsonReader<CommitInfo> _reader = new JsonReader<CommitInfo>() {

            public final CommitInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                CommitInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final CommitInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                WriteMode mode = null;
                Boolean autorename = null;
                java.util.Date clientModified = null;
                Boolean mute = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("mode".equals(fieldName)) {
                        mode = WriteMode._reader
                            .readField(parser, "mode", mode);
                    }
                    else if ("autorename".equals(fieldName)) {
                        autorename = JsonReader.BooleanReader
                            .readField(parser, "autorename", autorename);
                    }
                    else if ("client_modified".equals(fieldName)) {
                        clientModified = JsonDateReader.DropboxV2
                            .readField(parser, "client_modified", clientModified);
                    }
                    else if ("mute".equals(fieldName)) {
                        mute = JsonReader.BooleanReader
                            .readField(parser, "mute", mute);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new CommitInfo(path, mode, autorename, clientModified, mute);
            }
        };

        public String toString() {
            return "CommitInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CommitInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CommitInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UploadSessionFinishArg {
        // struct UploadSessionFinishArg
        /**
         * Contains the upload session ID and the offset.
         */
        public final UploadSessionCursor cursor;
        /**
         * Contains the path and other optional modifiers for the commit.
         */
        public final CommitInfo commit;

        public UploadSessionFinishArg(UploadSessionCursor cursor, CommitInfo commit) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new RuntimeException("Required value for 'cursor' is null");
            }
            this.commit = commit;
            if (commit == null) {
                throw new RuntimeException("Required value for 'commit' is null");
            }
        }
        static final JsonWriter<UploadSessionFinishArg> _writer = new JsonWriter<UploadSessionFinishArg>()
        {
            public final void write(UploadSessionFinishArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UploadSessionFinishArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UploadSessionFinishArg x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("cursor");
                UploadSessionCursor._writer.write(x.cursor, g);
                g.writeFieldName("commit");
                CommitInfo._writer.write(x.commit, g);
            }
        };

        public static final JsonReader<UploadSessionFinishArg> _reader = new JsonReader<UploadSessionFinishArg>() {

            public final UploadSessionFinishArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadSessionFinishArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UploadSessionFinishArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                UploadSessionCursor cursor = null;
                CommitInfo commit = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("cursor".equals(fieldName)) {
                        cursor = UploadSessionCursor._reader
                            .readField(parser, "cursor", cursor);
                    }
                    else if ("commit".equals(fieldName)) {
                        commit = CommitInfo._reader
                            .readField(parser, "commit", commit);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (cursor == null) {
                    throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
                }
                if (commit == null) {
                    throw new JsonReadException("Required field \"commit\" is missing.", parser.getTokenLocation());
                }
                return new UploadSessionFinishArg(cursor, commit);
            }
        };

        public String toString() {
            return "UploadSessionFinishArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UploadSessionFinishArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UploadSessionFinishArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum SearchMode {
        // union SearchMode
        /**
         * Search file and folder names.
         */
        filename,
        /**
         * Search file and folder names as well as file contents.
         */
        filenameAndContent,
        /**
         * Search for deleted file and folder names.
         */
        deletedFilename;

        static final JsonWriter<SearchMode> _writer = new JsonWriter<SearchMode>()
        {
            public void write(SearchMode x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case filename:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename");
                        g.writeEndObject();
                        break;
                    case filenameAndContent:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename_and_content");
                        g.writeEndObject();
                        break;
                    case deletedFilename:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("deleted_filename");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<SearchMode> _reader = new JsonReader<SearchMode>()
        {
            public final SearchMode read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,SearchMode> _values;
        static {
            _values = new java.util.HashMap<String,SearchMode>();
            _values.put("filename", filename);
            _values.put("filename_and_content", filenameAndContent);
            _values.put("deleted_filename", deletedFilename);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchMode fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class SearchArg {
        // struct SearchArg
        /**
         * The path in the user's Dropbox to search. Should probably be a
         * folder.
         */
        public final String path;
        /**
         * The string to search for. The search string is split on spaces into
         * multiple tokens. For file name searching, the last token is used for
         * prefix matching (i.e. "bat c" matches "bat cave" but not "batman
         * car").
         */
        public final String query;
        /**
         * The starting index within the search results (used for paging).
         */
        public final long start;
        /**
         * The maximum number of search results to return.
         */
        public final long maxResults;
        /**
         * The search mode (filename, filename_and_content, or
         * deleted_filename).
         */
        public final SearchMode mode;

        public SearchArg(String path, String query, Long start, Long maxResults, SearchMode mode) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A(/.*)?\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            this.query = query;
            if (query == null) {
                throw new RuntimeException("Required value for 'query' is null");
            }
            if (start != null) {
                this.start = start.longValue();
            }
            else {
                this.start = 0L;
            }
            if (maxResults != null) {
                this.maxResults = maxResults.longValue();
            }
            else {
                this.maxResults = 100L;
            }
            if (this.maxResults < 1L) {
                throw new RuntimeException("Number 'this.maxResults' is smaller than 1L");
            }
            if (this.maxResults > 1000L) {
                throw new RuntimeException("Number 'this.maxResults' is larger than 1000L");
            }
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = SearchMode.filename;
            }
        }
        static final JsonWriter<SearchArg> _writer = new JsonWriter<SearchArg>()
        {
            public final void write(SearchArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SearchArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SearchArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeStringField("query", x.query);
                g.writeNumberField("start", x.start);
                g.writeNumberField("max_results", x.maxResults);
                g.writeFieldName("mode");
                SearchMode._writer.write(x.mode, g);
            }
        };

        public static final JsonReader<SearchArg> _reader = new JsonReader<SearchArg>() {

            public final SearchArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SearchArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SearchArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                String query = null;
                Long start = null;
                Long maxResults = null;
                SearchMode mode = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("query".equals(fieldName)) {
                        query = JsonReader.StringReader
                            .readField(parser, "query", query);
                    }
                    else if ("start".equals(fieldName)) {
                        start = JsonReader.UInt64Reader
                            .readField(parser, "start", start);
                    }
                    else if ("max_results".equals(fieldName)) {
                        maxResults = JsonReader.UInt64Reader
                            .readField(parser, "max_results", maxResults);
                    }
                    else if ("mode".equals(fieldName)) {
                        mode = SearchMode._reader
                            .readField(parser, "mode", mode);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                if (query == null) {
                    throw new JsonReadException("Required field \"query\" is missing.", parser.getTokenLocation());
                }
                return new SearchArg(path, query, start, maxResults, mode);
            }
        };

        public String toString() {
            return "SearchArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Indicates what type of match was found for a given item.
     */
    public enum SearchMatchType {
        // union SearchMatchType
        /**
         * This item was matched on its file or folder name.
         */
        filename,
        /**
         * This item was matched based on its file contents.
         */
        content,
        /**
         * This item was matched based on both its contents and its file name.
         */
        both;

        static final JsonWriter<SearchMatchType> _writer = new JsonWriter<SearchMatchType>()
        {
            public void write(SearchMatchType x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case filename:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename");
                        g.writeEndObject();
                        break;
                    case content:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("content");
                        g.writeEndObject();
                        break;
                    case both:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("both");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<SearchMatchType> _reader = new JsonReader<SearchMatchType>()
        {
            public final SearchMatchType read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,SearchMatchType> _values;
        static {
            _values = new java.util.HashMap<String,SearchMatchType>();
            _values.put("filename", filename);
            _values.put("content", content);
            _values.put("both", both);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchMatchType fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class SearchMatch {
        // struct SearchMatch
        /**
         * The type of the match.
         */
        public final SearchMatchType matchType;
        /**
         * The metadata for the matched file or folder.
         */
        public final Metadata metadata;

        public SearchMatch(SearchMatchType matchType, Metadata metadata) {
            this.matchType = matchType;
            if (matchType == null) {
                throw new RuntimeException("Required value for 'matchType' is null");
            }
            this.metadata = metadata;
            if (metadata == null) {
                throw new RuntimeException("Required value for 'metadata' is null");
            }
        }
        static final JsonWriter<SearchMatch> _writer = new JsonWriter<SearchMatch>()
        {
            public final void write(SearchMatch x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SearchMatch._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SearchMatch x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("match_type");
                SearchMatchType._writer.write(x.matchType, g);
                g.writeFieldName("metadata");
                Metadata._writer.write(x.metadata, g);
            }
        };

        public static final JsonReader<SearchMatch> _reader = new JsonReader<SearchMatch>() {

            public final SearchMatch read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SearchMatch result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SearchMatch readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                SearchMatchType matchType = null;
                Metadata metadata = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("match_type".equals(fieldName)) {
                        matchType = SearchMatchType._reader
                            .readField(parser, "match_type", matchType);
                    }
                    else if ("metadata".equals(fieldName)) {
                        metadata = Metadata._reader
                            .readField(parser, "metadata", metadata);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (matchType == null) {
                    throw new JsonReadException("Required field \"match_type\" is missing.", parser.getTokenLocation());
                }
                if (metadata == null) {
                    throw new JsonReadException("Required field \"metadata\" is missing.", parser.getTokenLocation());
                }
                return new SearchMatch(matchType, metadata);
            }
        };

        public String toString() {
            return "SearchMatch." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchMatch." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchMatch fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class SearchResult {
        // struct SearchResult
        /**
         * A list (possibly empty) of matches for the query.
         */
        public final java.util.ArrayList<SearchMatch> matches;
        /**
         * Used for paging. If true, indicates there is another page of results
         * available that can be fetched by calling {@link #search} again.
         */
        public final boolean more;
        /**
         * Used for paging. Value to set the start argument to when calling
         * {@link #search} to fetch the next page of results.
         */
        public final long start;

        public SearchResult(java.util.ArrayList<SearchMatch> matches, boolean more, long start) {
            this.matches = matches;
            if (matches == null) {
                throw new RuntimeException("Required value for 'matches' is null");
            }
            for (SearchMatch x : matches) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'matches' is null");
                }
            }
            this.more = more;
            this.start = start;
        }
        static final JsonWriter<SearchResult> _writer = new JsonWriter<SearchResult>()
        {
            public final void write(SearchResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SearchResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SearchResult x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("matches");
                g.writeStartArray();
                for (SearchMatch item: x.matches) {
                    if (item != null) {
                        SearchMatch._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeBooleanField("more", x.more);
                g.writeNumberField("start", x.start);
            }
        };

        public static final JsonReader<SearchResult> _reader = new JsonReader<SearchResult>() {

            public final SearchResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SearchResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SearchResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.ArrayList<SearchMatch> matches = null;
                Boolean more = null;
                Long start = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("matches".equals(fieldName)) {
                        matches = JsonArrayReader.mk(SearchMatch._reader)
                            .readField(parser, "matches", matches);
                    }
                    else if ("more".equals(fieldName)) {
                        more = JsonReader.BooleanReader
                            .readField(parser, "more", more);
                    }
                    else if ("start".equals(fieldName)) {
                        start = JsonReader.UInt64Reader
                            .readField(parser, "start", start);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (matches == null) {
                    throw new JsonReadException("Required field \"matches\" is missing.", parser.getTokenLocation());
                }
                if (more == null) {
                    throw new JsonReadException("Required field \"more\" is missing.", parser.getTokenLocation());
                }
                if (start == null) {
                    throw new JsonReadException("Required field \"start\" is missing.", parser.getTokenLocation());
                }
                return new SearchResult(matches, more, start);
            }
        };

        public String toString() {
            return "SearchResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class SearchError {
        // union SearchError

        /**
         * The discriminating tag type for {@link SearchError}.
         */
        public enum Tag {
            path,  // LookupError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private SearchError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static SearchError path(LookupError v) {
            return new SearchError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * An unspecified error.
         */
        public static final SearchError other = new SearchError(Tag.other);

        private SearchError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<SearchError> _writer = new JsonWriter<SearchError>()
        {
            public final void write(SearchError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<SearchError> _reader = new JsonReader<SearchError>()
        {
            public final SearchError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SearchError.other; }
                    switch (tag) {
                        case other: return SearchError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SearchError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = SearchError.path(v);
                            break;
                        }
                        case other: {
                            value = SearchError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SearchError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "SearchError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SearchError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class LookupError {
        // union LookupError

        /**
         * The discriminating tag type for {@link LookupError}.
         */
        public enum Tag {
            malformedPath,  // Nullable
            notFound,
            notFile,
            notFolder,
            restrictedContent,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String malformedPathValue;
        private LookupError(Tag t, String v) {
            tag = t;
            malformedPathValue = v;
            validate();
        }
        public static LookupError malformedPath(String v) {
            return new LookupError(Tag.malformedPath, v);
        }
        public String getMalformedPath() {
            if (tag != Tag.malformedPath) {
                throw new RuntimeException("getMalformedPath() requires tag==malformedPath, actual tag=="+tag);
            }
            return malformedPathValue;
        }

        /**
         * There is nothing at the given path.
         */
        public static final LookupError notFound = new LookupError(Tag.notFound);

        /**
         * We were expecting a file, but the given path refers to something that
         * isn't a file.
         */
        public static final LookupError notFile = new LookupError(Tag.notFile);

        /**
         * We were expecting a folder, but the given path refers to something
         * that isn't a folder.
         */
        public static final LookupError notFolder = new LookupError(Tag.notFolder);

        /**
         * The file cannot be transferred because the content is restricted.
         * For example, sometimes there are legal restrictions due to copyright
         * claims.
         */
        public static final LookupError restrictedContent = new LookupError(Tag.restrictedContent);

        public static final LookupError other = new LookupError(Tag.other);

        private LookupError(Tag t) {
            tag = t;
            malformedPathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case notFound:
                case notFile:
                case notFolder:
                case restrictedContent:
                case other:
                    break;
                case malformedPath:
                    break;
            }
        }
        static final JsonWriter<LookupError> _writer = new JsonWriter<LookupError>()
        {
            public final void write(LookupError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case malformedPath:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("malformed_path");
                        if (x.malformedPathValue != null) {
                            g.writeFieldName("malformed_path");
                            g.writeString(x.malformedPathValue);
                        }
                        g.writeEndObject();
                        break;
                    case notFound:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_found");
                        g.writeEndObject();
                        break;
                    case notFile:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_file");
                        g.writeEndObject();
                        break;
                    case notFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_folder");
                        g.writeEndObject();
                        break;
                    case restrictedContent:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("restricted_content");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<LookupError> _reader = new JsonReader<LookupError>()
        {
            public final LookupError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return LookupError.other; }
                    switch (tag) {
                        case malformedPath: return LookupError.malformedPath(null);
                        case notFound: return LookupError.notFound;
                        case notFile: return LookupError.notFile;
                        case notFolder: return LookupError.notFolder;
                        case restrictedContent: return LookupError.restrictedContent;
                        case other: return LookupError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                LookupError value = null;
                if (tag != null) {
                    switch (tag) {
                        case malformedPath: {
                            if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                                break;
                            }
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "malformed_path", v);
                            value = LookupError.malformedPath(v);
                            break;
                        }
                        case notFound: {
                            value = LookupError.notFound;
                            break;
                        }
                        case notFile: {
                            value = LookupError.notFile;
                            break;
                        }
                        case notFolder: {
                            value = LookupError.notFolder;
                            break;
                        }
                        case restrictedContent: {
                            value = LookupError.restrictedContent;
                            break;
                        }
                        case other: {
                            value = LookupError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return LookupError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("malformed_path", Tag.malformedPath);
            _values.put("not_found", Tag.notFound);
            _values.put("not_file", Tag.notFile);
            _values.put("not_folder", Tag.notFolder);
            _values.put("restricted_content", Tag.restrictedContent);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "LookupError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "LookupError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static LookupError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class WriteError {
        // union WriteError

        /**
         * The discriminating tag type for {@link WriteError}.
         */
        public enum Tag {
            malformedPath,  // Nullable
            conflict,  // WriteConflictError
            noWritePermission,
            insufficientSpace,
            disallowedName,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String malformedPathValue;
        private WriteError(Tag t, String v) {
            tag = t;
            malformedPathValue = v;
            conflictValue = null;
            validate();
        }
        public static WriteError malformedPath(String v) {
            return new WriteError(Tag.malformedPath, v);
        }
        public String getMalformedPath() {
            if (tag != Tag.malformedPath) {
                throw new RuntimeException("getMalformedPath() requires tag==malformedPath, actual tag=="+tag);
            }
            return malformedPathValue;
        }

        private final WriteConflictError conflictValue;
        private WriteError(Tag t, WriteConflictError v) {
            tag = t;
            malformedPathValue = null;
            conflictValue = v;
            validate();
        }
        /**
         * Couldn't write to the target path because there was something in the
         * way.
         */
        public static WriteError conflict(WriteConflictError v) {
            return new WriteError(Tag.conflict, v);
        }
        public WriteConflictError getConflict() {
            if (tag != Tag.conflict) {
                throw new RuntimeException("getConflict() requires tag==conflict, actual tag=="+tag);
            }
            return conflictValue;
        }

        /**
         * The user doesn't have permissions to write to the target location.
         */
        public static final WriteError noWritePermission = new WriteError(Tag.noWritePermission);

        /**
         * The user doesn't have enough available space (bytes) to write more
         * data.
         */
        public static final WriteError insufficientSpace = new WriteError(Tag.insufficientSpace);

        /**
         * Dropbox will not save the file or folder because it of its name.
         */
        public static final WriteError disallowedName = new WriteError(Tag.disallowedName);

        public static final WriteError other = new WriteError(Tag.other);

        private WriteError(Tag t) {
            tag = t;
            malformedPathValue = null;
            conflictValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case noWritePermission:
                case insufficientSpace:
                case disallowedName:
                case other:
                    break;
                case malformedPath:
                    break;
                case conflict:
                    if (this.conflictValue == null) {
                        throw new RuntimeException("Required value for 'conflict' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<WriteError> _writer = new JsonWriter<WriteError>()
        {
            public final void write(WriteError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case malformedPath:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("malformed_path");
                        if (x.malformedPathValue != null) {
                            g.writeFieldName("malformed_path");
                            g.writeString(x.malformedPathValue);
                        }
                        g.writeEndObject();
                        break;
                    case conflict:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("conflict");
                        g.writeFieldName("conflict");
                        WriteConflictError._writer.write(x.conflictValue, g);
                        g.writeEndObject();
                        break;
                    case noWritePermission:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_write_permission");
                        g.writeEndObject();
                        break;
                    case insufficientSpace:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_space");
                        g.writeEndObject();
                        break;
                    case disallowedName:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("disallowed_name");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<WriteError> _reader = new JsonReader<WriteError>()
        {
            public final WriteError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return WriteError.other; }
                    switch (tag) {
                        case malformedPath: return WriteError.malformedPath(null);
                        case noWritePermission: return WriteError.noWritePermission;
                        case insufficientSpace: return WriteError.insufficientSpace;
                        case disallowedName: return WriteError.disallowedName;
                        case other: return WriteError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                WriteError value = null;
                if (tag != null) {
                    switch (tag) {
                        case malformedPath: {
                            if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                                break;
                            }
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "malformed_path", v);
                            value = WriteError.malformedPath(v);
                            break;
                        }
                        case conflict: {
                            WriteConflictError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteConflictError._reader
                                .readField(parser, "conflict", v);
                            value = WriteError.conflict(v);
                            break;
                        }
                        case noWritePermission: {
                            value = WriteError.noWritePermission;
                            break;
                        }
                        case insufficientSpace: {
                            value = WriteError.insufficientSpace;
                            break;
                        }
                        case disallowedName: {
                            value = WriteError.disallowedName;
                            break;
                        }
                        case other: {
                            value = WriteError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return WriteError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("malformed_path", Tag.malformedPath);
            _values.put("conflict", Tag.conflict);
            _values.put("no_write_permission", Tag.noWritePermission);
            _values.put("insufficient_space", Tag.insufficientSpace);
            _values.put("disallowed_name", Tag.disallowedName);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "WriteError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "WriteError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static WriteError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum WriteConflictError {
        // union WriteConflictError
        /**
         * There's a file in the way.
         */
        file,
        /**
         * There's a folder in the way.
         */
        folder,
        /**
         * There's a file at an ancestor path, so we couldn't create the
         * required parent folders.
         */
        fileAncestor,
        other;  // *catch_all

        static final JsonWriter<WriteConflictError> _writer = new JsonWriter<WriteConflictError>()
        {
            public void write(WriteConflictError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case file:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("file");
                        g.writeEndObject();
                        break;
                    case folder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("folder");
                        g.writeEndObject();
                        break;
                    case fileAncestor:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("file_ancestor");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<WriteConflictError> _reader = new JsonReader<WriteConflictError>()
        {
            public final WriteConflictError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,WriteConflictError> _values;
        static {
            _values = new java.util.HashMap<String,WriteConflictError>();
            _values.put("file", file);
            _values.put("folder", folder);
            _values.put("file_ancestor", fileAncestor);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static WriteConflictError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class CreateFolderArg {
        // struct CreateFolderArg
        /**
         * Path in the user's Dropbox to create.
         */
        public final String path;

        public CreateFolderArg(String path) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
        }
        static final JsonWriter<CreateFolderArg> _writer = new JsonWriter<CreateFolderArg>()
        {
            public final void write(CreateFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                CreateFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(CreateFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
            }
        };

        public static final JsonReader<CreateFolderArg> _reader = new JsonReader<CreateFolderArg>() {

            public final CreateFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                CreateFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final CreateFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new CreateFolderArg(path);
            }
        };

        public String toString() {
            return "CreateFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CreateFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CreateFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class CreateFolderError {
        // union CreateFolderError

        /**
         * The discriminating tag type for {@link CreateFolderError}.
         */
        public enum Tag {
            path  // WriteError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final WriteError pathValue;
        private CreateFolderError(Tag t, WriteError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static CreateFolderError path(WriteError v) {
            return new CreateFolderError(Tag.path, v);
        }
        public WriteError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }


        private void validate()
        {
            switch (tag) {
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<CreateFolderError> _writer = new JsonWriter<CreateFolderError>()
        {
            public final void write(CreateFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        WriteError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<CreateFolderError> _reader = new JsonReader<CreateFolderError>()
        {
            public final CreateFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                CreateFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "path", v);
                            value = CreateFolderError.path(v);
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
        }

        public String toString() {
            return "CreateFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CreateFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CreateFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class DeleteArg {
        // struct DeleteArg
        /**
         * Path in the user's Dropbox to delete.
         */
        public final String path;

        public DeleteArg(String path) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
        }
        static final JsonWriter<DeleteArg> _writer = new JsonWriter<DeleteArg>()
        {
            public final void write(DeleteArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                DeleteArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(DeleteArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
            }
        };

        public static final JsonReader<DeleteArg> _reader = new JsonReader<DeleteArg>() {

            public final DeleteArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                DeleteArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final DeleteArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new DeleteArg(path);
            }
        };

        public String toString() {
            return "DeleteArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "DeleteArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static DeleteArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class DeleteError {
        // union DeleteError

        /**
         * The discriminating tag type for {@link DeleteError}.
         */
        public enum Tag {
            pathLookup,  // LookupError
            pathWrite,  // WriteError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathLookupValue;
        private DeleteError(Tag t, LookupError v) {
            tag = t;
            pathLookupValue = v;
            pathWriteValue = null;
            validate();
        }
        public static DeleteError pathLookup(LookupError v) {
            return new DeleteError(Tag.pathLookup, v);
        }
        public LookupError getPathLookup() {
            if (tag != Tag.pathLookup) {
                throw new RuntimeException("getPathLookup() requires tag==pathLookup, actual tag=="+tag);
            }
            return pathLookupValue;
        }

        private final WriteError pathWriteValue;
        private DeleteError(Tag t, WriteError v) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = v;
            validate();
        }
        public static DeleteError pathWrite(WriteError v) {
            return new DeleteError(Tag.pathWrite, v);
        }
        public WriteError getPathWrite() {
            if (tag != Tag.pathWrite) {
                throw new RuntimeException("getPathWrite() requires tag==pathWrite, actual tag=="+tag);
            }
            return pathWriteValue;
        }

        public static final DeleteError other = new DeleteError(Tag.other);

        private DeleteError(Tag t) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case pathLookup:
                    if (this.pathLookupValue == null) {
                        throw new RuntimeException("Required value for 'pathLookup' is null");
                    }
                    break;
                case pathWrite:
                    if (this.pathWriteValue == null) {
                        throw new RuntimeException("Required value for 'pathWrite' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<DeleteError> _writer = new JsonWriter<DeleteError>()
        {
            public final void write(DeleteError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case pathLookup:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_lookup");
                        g.writeFieldName("path_lookup");
                        LookupError._writer.write(x.pathLookupValue, g);
                        g.writeEndObject();
                        break;
                    case pathWrite:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_write");
                        g.writeFieldName("path_write");
                        WriteError._writer.write(x.pathWriteValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<DeleteError> _reader = new JsonReader<DeleteError>()
        {
            public final DeleteError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return DeleteError.other; }
                    switch (tag) {
                        case other: return DeleteError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                DeleteError value = null;
                if (tag != null) {
                    switch (tag) {
                        case pathLookup: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path_lookup", v);
                            value = DeleteError.pathLookup(v);
                            break;
                        }
                        case pathWrite: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "path_write", v);
                            value = DeleteError.pathWrite(v);
                            break;
                        }
                        case other: {
                            value = DeleteError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return DeleteError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path_lookup", Tag.pathLookup);
            _values.put("path_write", Tag.pathWrite);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "DeleteError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "DeleteError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static DeleteError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class RelocationArg {
        // struct RelocationArg
        /**
         * Path in the user's Dropbox to be copied or moved.
         */
        public final String fromPath;
        /**
         * Path in the user's Dropbox that is the destination.
         */
        public final String toPath;

        public RelocationArg(String fromPath, String toPath) {
            this.fromPath = fromPath;
            if (fromPath == null) {
                throw new RuntimeException("Required value for 'fromPath' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", fromPath)) {
                throw new RuntimeException("String 'fromPath' does not match pattern");
            }
            this.toPath = toPath;
            if (toPath == null) {
                throw new RuntimeException("Required value for 'toPath' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", toPath)) {
                throw new RuntimeException("String 'toPath' does not match pattern");
            }
        }
        static final JsonWriter<RelocationArg> _writer = new JsonWriter<RelocationArg>()
        {
            public final void write(RelocationArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                RelocationArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(RelocationArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("from_path", x.fromPath);
                g.writeStringField("to_path", x.toPath);
            }
        };

        public static final JsonReader<RelocationArg> _reader = new JsonReader<RelocationArg>() {

            public final RelocationArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                RelocationArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final RelocationArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String fromPath = null;
                String toPath = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("from_path".equals(fieldName)) {
                        fromPath = JsonReader.StringReader
                            .readField(parser, "from_path", fromPath);
                    }
                    else if ("to_path".equals(fieldName)) {
                        toPath = JsonReader.StringReader
                            .readField(parser, "to_path", toPath);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (fromPath == null) {
                    throw new JsonReadException("Required field \"from_path\" is missing.", parser.getTokenLocation());
                }
                if (toPath == null) {
                    throw new JsonReadException("Required field \"to_path\" is missing.", parser.getTokenLocation());
                }
                return new RelocationArg(fromPath, toPath);
            }
        };

        public String toString() {
            return "RelocationArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RelocationArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RelocationArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class RelocationError {
        // union RelocationError

        /**
         * The discriminating tag type for {@link RelocationError}.
         */
        public enum Tag {
            fromLookup,  // LookupError
            fromWrite,  // WriteError
            to,  // WriteError
            cantCopySharedFolder,
            cantNestSharedFolder,
            tooManyFiles,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError fromLookupValue;
        private RelocationError(Tag t, LookupError v) {
            tag = t;
            fromLookupValue = v;
            fromWriteValue = null;
            validate();
        }
        public static RelocationError fromLookup(LookupError v) {
            return new RelocationError(Tag.fromLookup, v);
        }
        public LookupError getFromLookup() {
            if (tag != Tag.fromLookup) {
                throw new RuntimeException("getFromLookup() requires tag==fromLookup, actual tag=="+tag);
            }
            return fromLookupValue;
        }

        private final WriteError fromWriteValue;
        private RelocationError(Tag t, WriteError v) {
            tag = t;
            fromLookupValue = null;
            fromWriteValue = v;
            validate();
        }
        public static RelocationError fromWrite(WriteError v) {
            return new RelocationError(Tag.fromWrite, v);
        }
        public WriteError getFromWrite() {
            if (tag != Tag.fromWrite) {
                throw new RuntimeException("getFromWrite() requires tag==fromWrite, actual tag=="+tag);
            }
            return fromWriteValue;
        }

        // Reusing fromWriteValue for to
        public static RelocationError to(WriteError v) {
            return new RelocationError(Tag.to, v);
        }
        public WriteError getTo() {
            if (tag != Tag.to) {
                throw new RuntimeException("getTo() requires tag==to, actual tag=="+tag);
            }
            return fromWriteValue;
        }

        /**
         * Shared folders can't be copied.
         */
        public static final RelocationError cantCopySharedFolder = new RelocationError(Tag.cantCopySharedFolder);

        /**
         * Your move operation would result in nested shared folders.  This is
         * not allowed.
         */
        public static final RelocationError cantNestSharedFolder = new RelocationError(Tag.cantNestSharedFolder);

        /**
         * The operation would involve more than 10,000 files and folders.
         */
        public static final RelocationError tooManyFiles = new RelocationError(Tag.tooManyFiles);

        /**
         * An unspecified error.
         */
        public static final RelocationError other = new RelocationError(Tag.other);

        private RelocationError(Tag t) {
            tag = t;
            fromLookupValue = null;
            fromWriteValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case cantCopySharedFolder:
                case cantNestSharedFolder:
                case tooManyFiles:
                case other:
                    break;
                case fromLookup:
                    if (this.fromLookupValue == null) {
                        throw new RuntimeException("Required value for 'fromLookup' is null");
                    }
                    break;
                case fromWrite:
                    if (this.fromWriteValue == null) {
                        throw new RuntimeException("Required value for 'fromWrite' is null");
                    }
                    break;
                case to:
                    if (this.fromWriteValue == null) {
                        throw new RuntimeException("Required value for 'to' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<RelocationError> _writer = new JsonWriter<RelocationError>()
        {
            public final void write(RelocationError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case fromLookup:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("from_lookup");
                        g.writeFieldName("from_lookup");
                        LookupError._writer.write(x.fromLookupValue, g);
                        g.writeEndObject();
                        break;
                    case fromWrite:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("from_write");
                        g.writeFieldName("from_write");
                        WriteError._writer.write(x.fromWriteValue, g);
                        g.writeEndObject();
                        break;
                    case to:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("to");
                        g.writeFieldName("to");
                        WriteError._writer.write(x.fromWriteValue, g);
                        g.writeEndObject();
                        break;
                    case cantCopySharedFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_copy_shared_folder");
                        g.writeEndObject();
                        break;
                    case cantNestSharedFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_nest_shared_folder");
                        g.writeEndObject();
                        break;
                    case tooManyFiles:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_files");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<RelocationError> _reader = new JsonReader<RelocationError>()
        {
            public final RelocationError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RelocationError.other; }
                    switch (tag) {
                        case cantCopySharedFolder: return RelocationError.cantCopySharedFolder;
                        case cantNestSharedFolder: return RelocationError.cantNestSharedFolder;
                        case tooManyFiles: return RelocationError.tooManyFiles;
                        case other: return RelocationError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RelocationError value = null;
                if (tag != null) {
                    switch (tag) {
                        case fromLookup: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "from_lookup", v);
                            value = RelocationError.fromLookup(v);
                            break;
                        }
                        case fromWrite: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "from_write", v);
                            value = RelocationError.fromWrite(v);
                            break;
                        }
                        case to: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "to", v);
                            value = RelocationError.to(v);
                            break;
                        }
                        case cantCopySharedFolder: {
                            value = RelocationError.cantCopySharedFolder;
                            break;
                        }
                        case cantNestSharedFolder: {
                            value = RelocationError.cantNestSharedFolder;
                            break;
                        }
                        case tooManyFiles: {
                            value = RelocationError.tooManyFiles;
                            break;
                        }
                        case other: {
                            value = RelocationError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RelocationError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("from_lookup", Tag.fromLookup);
            _values.put("from_write", Tag.fromWrite);
            _values.put("to", Tag.to);
            _values.put("cant_copy_shared_folder", Tag.cantCopySharedFolder);
            _values.put("cant_nest_shared_folder", Tag.cantNestSharedFolder);
            _values.put("too_many_files", Tag.tooManyFiles);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "RelocationError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RelocationError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RelocationError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum ThumbnailSize {
        // union ThumbnailSize
        /**
         * 32 by 32 px.
         */
        w32h32,
        /**
         * 64 by 64 px.
         */
        w64h64,
        /**
         * 128 by 128 px.
         */
        w128h128,
        /**
         * 640 by 480 px.
         */
        w640h480,
        /**
         * 1024 by 768
         */
        w1024h768;

        static final JsonWriter<ThumbnailSize> _writer = new JsonWriter<ThumbnailSize>()
        {
            public void write(ThumbnailSize x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case w32h32:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w32h32");
                        g.writeEndObject();
                        break;
                    case w64h64:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w64h64");
                        g.writeEndObject();
                        break;
                    case w128h128:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w128h128");
                        g.writeEndObject();
                        break;
                    case w640h480:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w640h480");
                        g.writeEndObject();
                        break;
                    case w1024h768:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w1024h768");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<ThumbnailSize> _reader = new JsonReader<ThumbnailSize>()
        {
            public final ThumbnailSize read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,ThumbnailSize> _values;
        static {
            _values = new java.util.HashMap<String,ThumbnailSize>();
            _values.put("w32h32", w32h32);
            _values.put("w64h64", w64h64);
            _values.put("w128h128", w128h128);
            _values.put("w640h480", w640h480);
            _values.put("w1024h768", w1024h768);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ThumbnailSize fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum ThumbnailFormat {
        // union ThumbnailFormat
        jpeg,
        png;

        static final JsonWriter<ThumbnailFormat> _writer = new JsonWriter<ThumbnailFormat>()
        {
            public void write(ThumbnailFormat x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case jpeg:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("jpeg");
                        g.writeEndObject();
                        break;
                    case png:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("png");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<ThumbnailFormat> _reader = new JsonReader<ThumbnailFormat>()
        {
            public final ThumbnailFormat read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,ThumbnailFormat> _values;
        static {
            _values = new java.util.HashMap<String,ThumbnailFormat>();
            _values.put("jpeg", jpeg);
            _values.put("png", png);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ThumbnailFormat fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ThumbnailArg {
        // struct ThumbnailArg
        /**
         * The path to the image file you want to thumbnail.
         */
        public final String path;
        /**
         * The format for the thumbnail image, jpeg (default) or png. For
         * images that are photos, jpeg should be preferred, while png is
         * better for screenshots and digital arts.
         */
        public final ThumbnailFormat format;
        /**
         * The size for the thumbnail image.
         */
        public final ThumbnailSize size;

        public ThumbnailArg(String path, ThumbnailFormat format, ThumbnailSize size) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A((/|id:).*)|(rev:[0-9a-f]{9,})\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (format != null) {
                this.format = format;
            }
            else {
                this.format = ThumbnailFormat.jpeg;
            }
            if (size != null) {
                this.size = size;
            }
            else {
                this.size = ThumbnailSize.w64h64;
            }
        }
        static final JsonWriter<ThumbnailArg> _writer = new JsonWriter<ThumbnailArg>()
        {
            public final void write(ThumbnailArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ThumbnailArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ThumbnailArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeFieldName("format");
                ThumbnailFormat._writer.write(x.format, g);
                g.writeFieldName("size");
                ThumbnailSize._writer.write(x.size, g);
            }
        };

        public static final JsonReader<ThumbnailArg> _reader = new JsonReader<ThumbnailArg>() {

            public final ThumbnailArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ThumbnailArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ThumbnailArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                ThumbnailFormat format = null;
                ThumbnailSize size = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("format".equals(fieldName)) {
                        format = ThumbnailFormat._reader
                            .readField(parser, "format", format);
                    }
                    else if ("size".equals(fieldName)) {
                        size = ThumbnailSize._reader
                            .readField(parser, "size", size);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new ThumbnailArg(path, format, size);
            }
        };

        public String toString() {
            return "ThumbnailArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ThumbnailArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ThumbnailArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ThumbnailError {
        // union ThumbnailError

        /**
         * The discriminating tag type for {@link ThumbnailError}.
         */
        public enum Tag {
            path,  // LookupError
            unsupportedExtension,
            unsupportedImage,
            conversionError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private ThumbnailError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        /**
         * An error occurs when downloading metadata for the image.
         */
        public static ThumbnailError path(LookupError v) {
            return new ThumbnailError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * The file extension doesn't allow conversion to a thumbnail.
         */
        public static final ThumbnailError unsupportedExtension = new ThumbnailError(Tag.unsupportedExtension);

        /**
         * The image cannot be converted to a thumbnail.
         */
        public static final ThumbnailError unsupportedImage = new ThumbnailError(Tag.unsupportedImage);

        /**
         * An error occurs during thumbnail conversion.
         */
        public static final ThumbnailError conversionError = new ThumbnailError(Tag.conversionError);

        private ThumbnailError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case unsupportedExtension:
                case unsupportedImage:
                case conversionError:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ThumbnailError> _writer = new JsonWriter<ThumbnailError>()
        {
            public final void write(ThumbnailError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case unsupportedExtension:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_extension");
                        g.writeEndObject();
                        break;
                    case unsupportedImage:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_image");
                        g.writeEndObject();
                        break;
                    case conversionError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("conversion_error");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ThumbnailError> _reader = new JsonReader<ThumbnailError>()
        {
            public final ThumbnailError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case unsupportedExtension: return ThumbnailError.unsupportedExtension;
                        case unsupportedImage: return ThumbnailError.unsupportedImage;
                        case conversionError: return ThumbnailError.conversionError;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ThumbnailError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = ThumbnailError.path(v);
                            break;
                        }
                        case unsupportedExtension: {
                            value = ThumbnailError.unsupportedExtension;
                            break;
                        }
                        case unsupportedImage: {
                            value = ThumbnailError.unsupportedImage;
                            break;
                        }
                        case conversionError: {
                            value = ThumbnailError.conversionError;
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("unsupported_extension", Tag.unsupportedExtension);
            _values.put("unsupported_image", Tag.unsupportedImage);
            _values.put("conversion_error", Tag.conversionError);
        }

        public String toString() {
            return "ThumbnailError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ThumbnailError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ThumbnailError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class PreviewArg {
        // struct PreviewArg
        /**
         * The path of the file to preview.
         */
        public final String path;
        /**
         * Deprecated. Please specify revision in :field:'path' instead
         */
        public final String rev;

        public PreviewArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A((/|id:).*)|(rev:[0-9a-f]{9,})\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new RuntimeException("String 'rev' is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("\\A[0-9a-f]+\\Z", rev)) {
                    throw new RuntimeException("String 'rev' does not match pattern");
                }
            }
        }
        static final JsonWriter<PreviewArg> _writer = new JsonWriter<PreviewArg>()
        {
            public final void write(PreviewArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                PreviewArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(PreviewArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                if (x.rev != null) {
                    g.writeFieldName("rev");
                    g.writeString(x.rev);
                }
            }
        };

        public static final JsonReader<PreviewArg> _reader = new JsonReader<PreviewArg>() {

            public final PreviewArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                PreviewArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final PreviewArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                String rev = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("rev".equals(fieldName)) {
                        rev = JsonReader.StringReader
                            .readField(parser, "rev", rev);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new PreviewArg(path, rev);
            }
        };

        public String toString() {
            return "PreviewArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PreviewArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PreviewArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class PreviewError {
        // union PreviewError

        /**
         * The discriminating tag type for {@link PreviewError}.
         */
        public enum Tag {
            path,  // LookupError
            inProgress,
            unsupportedExtension,
            unsupportedContent
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private PreviewError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        /**
         * An error occurs when downloading metadata for the file.
         */
        public static PreviewError path(LookupError v) {
            return new PreviewError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        /**
         * This preview generation is still in progress and the file is not
         * ready  for preview yet.
         */
        public static final PreviewError inProgress = new PreviewError(Tag.inProgress);

        /**
         * The file extension is not supported preview generation.
         */
        public static final PreviewError unsupportedExtension = new PreviewError(Tag.unsupportedExtension);

        /**
         * The file content is not supported for preview generation.
         */
        public static final PreviewError unsupportedContent = new PreviewError(Tag.unsupportedContent);

        private PreviewError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case inProgress:
                case unsupportedExtension:
                case unsupportedContent:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<PreviewError> _writer = new JsonWriter<PreviewError>()
        {
            public final void write(PreviewError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case inProgress:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("in_progress");
                        g.writeEndObject();
                        break;
                    case unsupportedExtension:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_extension");
                        g.writeEndObject();
                        break;
                    case unsupportedContent:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_content");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<PreviewError> _reader = new JsonReader<PreviewError>()
        {
            public final PreviewError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case inProgress: return PreviewError.inProgress;
                        case unsupportedExtension: return PreviewError.unsupportedExtension;
                        case unsupportedContent: return PreviewError.unsupportedContent;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                PreviewError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = PreviewError.path(v);
                            break;
                        }
                        case inProgress: {
                            value = PreviewError.inProgress;
                            break;
                        }
                        case unsupportedExtension: {
                            value = PreviewError.unsupportedExtension;
                            break;
                        }
                        case unsupportedContent: {
                            value = PreviewError.unsupportedContent;
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("in_progress", Tag.inProgress);
            _values.put("unsupported_extension", Tag.unsupportedExtension);
            _values.put("unsupported_content", Tag.unsupportedContent);
        }

        public String toString() {
            return "PreviewError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PreviewError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PreviewError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListRevisionsArg {
        // struct ListRevisionsArg
        /**
         * The path to the file you want to see the revisions of.
         */
        public final String path;
        /**
         * The maximum number of revision entries returned.
         */
        public final long limit;

        public ListRevisionsArg(String path, Long limit) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (limit != null) {
                this.limit = limit.longValue();
            }
            else {
                this.limit = 10L;
            }
            if (this.limit < 1L) {
                throw new RuntimeException("Number 'this.limit' is smaller than 1L");
            }
            if (this.limit > 100L) {
                throw new RuntimeException("Number 'this.limit' is larger than 100L");
            }
        }
        static final JsonWriter<ListRevisionsArg> _writer = new JsonWriter<ListRevisionsArg>()
        {
            public final void write(ListRevisionsArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListRevisionsArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListRevisionsArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeNumberField("limit", x.limit);
            }
        };

        public static final JsonReader<ListRevisionsArg> _reader = new JsonReader<ListRevisionsArg>() {

            public final ListRevisionsArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListRevisionsArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListRevisionsArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                Long limit = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("limit".equals(fieldName)) {
                        limit = JsonReader.UInt64Reader
                            .readField(parser, "limit", limit);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new ListRevisionsArg(path, limit);
            }
        };

        public String toString() {
            return "ListRevisionsArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListRevisionsArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListRevisionsArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListRevisionsError {
        // union ListRevisionsError

        /**
         * The discriminating tag type for {@link ListRevisionsError}.
         */
        public enum Tag {
            path,  // LookupError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathValue;
        private ListRevisionsError(Tag t, LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static ListRevisionsError path(LookupError v) {
            return new ListRevisionsError(Tag.path, v);
        }
        public LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        public static final ListRevisionsError other = new ListRevisionsError(Tag.other);

        private ListRevisionsError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case path:
                    if (this.pathValue == null) {
                        throw new RuntimeException("Required value for 'path' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ListRevisionsError> _writer = new JsonWriter<ListRevisionsError>()
        {
            public final void write(ListRevisionsError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ListRevisionsError> _reader = new JsonReader<ListRevisionsError>()
        {
            public final ListRevisionsError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListRevisionsError.other; }
                    switch (tag) {
                        case other: return ListRevisionsError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListRevisionsError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path", v);
                            value = ListRevisionsError.path(v);
                            break;
                        }
                        case other: {
                            value = ListRevisionsError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListRevisionsError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.path);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "ListRevisionsError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListRevisionsError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListRevisionsError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListRevisionsResult {
        // struct ListRevisionsResult
        /**
         * If the file is deleted.
         */
        public final boolean isDeleted;
        /**
         * The revisions for the file. Only non-delete revisions will show up
         * here.
         */
        public final java.util.ArrayList<FileMetadata> entries;

        public ListRevisionsResult(boolean isDeleted, java.util.ArrayList<FileMetadata> entries) {
            this.isDeleted = isDeleted;
            this.entries = entries;
            if (entries == null) {
                throw new RuntimeException("Required value for 'entries' is null");
            }
            for (FileMetadata x : entries) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'entries' is null");
                }
            }
        }
        static final JsonWriter<ListRevisionsResult> _writer = new JsonWriter<ListRevisionsResult>()
        {
            public final void write(ListRevisionsResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListRevisionsResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListRevisionsResult x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("is_deleted", x.isDeleted);
                g.writeFieldName("entries");
                g.writeStartArray();
                for (FileMetadata item: x.entries) {
                    if (item != null) {
                        FileMetadata._writer.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        };

        public static final JsonReader<ListRevisionsResult> _reader = new JsonReader<ListRevisionsResult>() {

            public final ListRevisionsResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListRevisionsResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListRevisionsResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean isDeleted = null;
                java.util.ArrayList<FileMetadata> entries = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("is_deleted".equals(fieldName)) {
                        isDeleted = JsonReader.BooleanReader
                            .readField(parser, "is_deleted", isDeleted);
                    }
                    else if ("entries".equals(fieldName)) {
                        entries = JsonArrayReader.mk(FileMetadata._reader)
                            .readField(parser, "entries", entries);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (isDeleted == null) {
                    throw new JsonReadException("Required field \"is_deleted\" is missing.", parser.getTokenLocation());
                }
                if (entries == null) {
                    throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
                }
                return new ListRevisionsResult(isDeleted, entries);
            }
        };

        public String toString() {
            return "ListRevisionsResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListRevisionsResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListRevisionsResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class RestoreArg {
        // struct RestoreArg
        /**
         * The path to the file you want to restore.
         */
        public final String path;
        /**
         * The revision to restore for the file.
         */
        public final String rev;

        public RestoreArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev == null) {
                throw new RuntimeException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new RuntimeException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("\\A[0-9a-f]+\\Z", rev)) {
                throw new RuntimeException("String 'rev' does not match pattern");
            }
        }
        static final JsonWriter<RestoreArg> _writer = new JsonWriter<RestoreArg>()
        {
            public final void write(RestoreArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                RestoreArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(RestoreArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeStringField("rev", x.rev);
            }
        };

        public static final JsonReader<RestoreArg> _reader = new JsonReader<RestoreArg>() {

            public final RestoreArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                RestoreArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final RestoreArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                String rev = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("rev".equals(fieldName)) {
                        rev = JsonReader.StringReader
                            .readField(parser, "rev", rev);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                if (rev == null) {
                    throw new JsonReadException("Required field \"rev\" is missing.", parser.getTokenLocation());
                }
                return new RestoreArg(path, rev);
            }
        };

        public String toString() {
            return "RestoreArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RestoreArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RestoreArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class RestoreError {
        // union RestoreError

        /**
         * The discriminating tag type for {@link RestoreError}.
         */
        public enum Tag {
            pathLookup,  // LookupError
            pathWrite,  // WriteError
            invalidRevision,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final LookupError pathLookupValue;
        private RestoreError(Tag t, LookupError v) {
            tag = t;
            pathLookupValue = v;
            pathWriteValue = null;
            validate();
        }
        /**
         * An error occurs when downloading metadata for the file.
         */
        public static RestoreError pathLookup(LookupError v) {
            return new RestoreError(Tag.pathLookup, v);
        }
        public LookupError getPathLookup() {
            if (tag != Tag.pathLookup) {
                throw new RuntimeException("getPathLookup() requires tag==pathLookup, actual tag=="+tag);
            }
            return pathLookupValue;
        }

        private final WriteError pathWriteValue;
        private RestoreError(Tag t, WriteError v) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = v;
            validate();
        }
        /**
         * An error occurs when trying to restore the file to that path.
         */
        public static RestoreError pathWrite(WriteError v) {
            return new RestoreError(Tag.pathWrite, v);
        }
        public WriteError getPathWrite() {
            if (tag != Tag.pathWrite) {
                throw new RuntimeException("getPathWrite() requires tag==pathWrite, actual tag=="+tag);
            }
            return pathWriteValue;
        }

        /**
         * The revision is invalid. It may point to a different file.
         */
        public static final RestoreError invalidRevision = new RestoreError(Tag.invalidRevision);

        public static final RestoreError other = new RestoreError(Tag.other);

        private RestoreError(Tag t) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case invalidRevision:
                case other:
                    break;
                case pathLookup:
                    if (this.pathLookupValue == null) {
                        throw new RuntimeException("Required value for 'pathLookup' is null");
                    }
                    break;
                case pathWrite:
                    if (this.pathWriteValue == null) {
                        throw new RuntimeException("Required value for 'pathWrite' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<RestoreError> _writer = new JsonWriter<RestoreError>()
        {
            public final void write(RestoreError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case pathLookup:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_lookup");
                        g.writeFieldName("path_lookup");
                        LookupError._writer.write(x.pathLookupValue, g);
                        g.writeEndObject();
                        break;
                    case pathWrite:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_write");
                        g.writeFieldName("path_write");
                        WriteError._writer.write(x.pathWriteValue, g);
                        g.writeEndObject();
                        break;
                    case invalidRevision:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_revision");
                        g.writeEndObject();
                        break;
                    case other:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<RestoreError> _reader = new JsonReader<RestoreError>()
        {
            public final RestoreError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RestoreError.other; }
                    switch (tag) {
                        case invalidRevision: return RestoreError.invalidRevision;
                        case other: return RestoreError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RestoreError value = null;
                if (tag != null) {
                    switch (tag) {
                        case pathLookup: {
                            LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = LookupError._reader
                                .readField(parser, "path_lookup", v);
                            value = RestoreError.pathLookup(v);
                            break;
                        }
                        case pathWrite: {
                            WriteError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = WriteError._reader
                                .readField(parser, "path_write", v);
                            value = RestoreError.pathWrite(v);
                            break;
                        }
                        case invalidRevision: {
                            value = RestoreError.invalidRevision;
                            break;
                        }
                        case other: {
                            value = RestoreError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RestoreError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path_lookup", Tag.pathLookup);
            _values.put("path_write", Tag.pathWrite);
            _values.put("invalid_revision", Tag.invalidRevision);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "RestoreError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RestoreError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RestoreError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Exception thrown by {@link #getMetadata}.
     */
    public static class GetMetadataException extends DbxApiException {
        /**
         * The error reported by getMetadata.
         */
        public final GetMetadataError errorValue;

        public GetMetadataException(GetMetadataError errorValue) {
            super("Exception in get_metadata: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the metadata for a file or folder.
     */
    private Metadata getMetadata(GetMetadataArg arg)
            throws GetMetadataException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/get_metadata",
                                           arg,
                                           GetMetadataArg._writer,
                                           Metadata._reader,
                                           GetMetadataError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetMetadataException((GetMetadataError) (ew.errValue));
        }
    }
    /**
     * Returns the metadata for a file or folder.
     */
    public Metadata getMetadata(String path)
          throws GetMetadataException, DbxException
    {
        GetMetadataArg arg = new GetMetadataArg(path, null);
        return getMetadata(arg);
    }
    /**
     * Returns the metadata for a file or folder.
     */
    public Metadata getMetadata(String path, boolean includeMediaInfo)
          throws GetMetadataException, DbxException
    {
        GetMetadataArg arg = new GetMetadataArg(path, includeMediaInfo);
        return getMetadata(arg);
    }

    /**
     * Exception thrown by {@link #listFolderLongpoll}.
     */
    public static class ListFolderLongpollException extends DbxApiException {
        /**
         * The error reported by listFolderLongpoll.
         */
        public final ListFolderLongpollError errorValue;

        public ListFolderLongpollException(ListFolderLongpollError errorValue) {
            super("Exception in list_folder/longpoll: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link #listFolder}, this call gives you a low-latency way to
     * monitor an account for file changes. The connection will block until
     * there are changes available or a timeout occurs.
     */
    private ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg arg)
            throws ListFolderLongpollException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().notify,
                                           "2-beta-2/files/list_folder/longpoll",
                                           arg,
                                           ListFolderLongpollArg._writer,
                                           ListFolderLongpollResult._reader,
                                           ListFolderLongpollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderLongpollException((ListFolderLongpollError) (ew.errValue));
        }
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link #listFolder}, this call gives you a low-latency way to
     * monitor an account for file changes. The connection will block until
     * there are changes available or a timeout occurs.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor)
          throws ListFolderLongpollException, DbxException
    {
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor, null);
        return listFolderLongpoll(arg);
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link #listFolder}, this call gives you a low-latency way to
     * monitor an account for file changes. The connection will block until
     * there are changes available or a timeout occurs.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor, long timeout)
          throws ListFolderLongpollException, DbxException
    {
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor, timeout);
        return listFolderLongpoll(arg);
    }

    /**
     * Exception thrown by {@link #listFolder}.
     */
    public static class ListFolderException extends DbxApiException {
        /**
         * The error reported by listFolder.
         */
        public final ListFolderError errorValue;

        public ListFolderException(ListFolderError errorValue) {
            super("Exception in list_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the contents of a folder.
     */
    private ListFolderResult listFolder(ListFolderArg arg)
            throws ListFolderException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/list_folder",
                                           arg,
                                           ListFolderArg._writer,
                                           ListFolderResult._reader,
                                           ListFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderException((ListFolderError) (ew.errValue));
        }
    }
    /**
     * Returns the contents of a folder.
     */
    public ListFolderResult listFolder(String path)
          throws ListFolderException, DbxException
    {
        ListFolderArg arg = new ListFolderArg(path, null, null);
        return listFolder(arg);
    }
    /**
     * The builder object returned by {@link #listFolderBuilder}
     */
    public final class ListFolderBuilder
    {
        private String path;
        private Boolean recursive;
        private Boolean includeMediaInfo;
        private ListFolderBuilder(String path)
        {
            this.path = path;
        }
        public ListFolderBuilder recursive(boolean recursive)
        {
            this.recursive = recursive;
            return this;
        }
        public ListFolderBuilder includeMediaInfo(boolean includeMediaInfo)
        {
            this.includeMediaInfo = includeMediaInfo;
            return this;
        }
        public ListFolderResult start() throws ListFolderException, DbxException
        {
            ListFolderArg arg = new ListFolderArg(path, recursive, includeMediaInfo);
            return DbxFiles.this.listFolder(arg);
        }
    }
    /**
     * Returns the contents of a folder.
     */
    public ListFolderBuilder listFolderBuilder(String path)
    {
        return new ListFolderBuilder(path);
    }

    /**
     * Exception thrown by {@link #listFolderContinue}.
     */
    public static class ListFolderContinueException extends DbxApiException {
        /**
         * The error reported by listFolderContinue.
         */
        public final ListFolderContinueError errorValue;

        public ListFolderContinueException(ListFolderContinueError errorValue) {
            super("Exception in list_folder/continue: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Once a cursor has been retrieved from {@link #listFolder}, use this to
     * paginate through all files and retrieve updates to the folder.
     */
    private ListFolderResult listFolderContinue(ListFolderContinueArg arg)
            throws ListFolderContinueException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/list_folder/continue",
                                           arg,
                                           ListFolderContinueArg._writer,
                                           ListFolderResult._reader,
                                           ListFolderContinueError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderContinueException((ListFolderContinueError) (ew.errValue));
        }
    }
    /**
     * Once a cursor has been retrieved from {@link #listFolder}, use this to
     * paginate through all files and retrieve updates to the folder.
     */
    public ListFolderResult listFolderContinue(String cursor)
          throws ListFolderContinueException, DbxException
    {
        ListFolderContinueArg arg = new ListFolderContinueArg(cursor);
        return listFolderContinue(arg);
    }

    /**
     * Exception thrown by {@link #listFolderGetLatestCursor}.
     */
    public static class ListFolderGetLatestCursorException extends DbxApiException {
        /**
         * The error reported by listFolderGetLatestCursor.
         */
        public final ListFolderError errorValue;

        public ListFolderGetLatestCursorException(ListFolderError errorValue) {
            super("Exception in list_folder/get_latest_cursor: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * #listFolder}, {@link #listFolderGetLatestCursor} doesn't return any
     * entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     */
    private ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg arg)
            throws ListFolderGetLatestCursorException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/list_folder/get_latest_cursor",
                                           arg,
                                           ListFolderArg._writer,
                                           ListFolderGetLatestCursorResult._reader,
                                           ListFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderGetLatestCursorException((ListFolderError) (ew.errValue));
        }
    }
    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * #listFolder}, {@link #listFolderGetLatestCursor} doesn't return any
     * entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     */
    public ListFolderGetLatestCursorResult listFolderGetLatestCursor(String path)
          throws ListFolderGetLatestCursorException, DbxException
    {
        ListFolderArg arg = new ListFolderArg(path, null, null);
        return listFolderGetLatestCursor(arg);
    }
    /**
     * The builder object returned by {@link #listFolderGetLatestCursorBuilder}
     */
    public final class ListFolderGetLatestCursorBuilder
    {
        private String path;
        private Boolean recursive;
        private Boolean includeMediaInfo;
        private ListFolderGetLatestCursorBuilder(String path)
        {
            this.path = path;
        }
        public ListFolderGetLatestCursorBuilder recursive(boolean recursive)
        {
            this.recursive = recursive;
            return this;
        }
        public ListFolderGetLatestCursorBuilder includeMediaInfo(boolean includeMediaInfo)
        {
            this.includeMediaInfo = includeMediaInfo;
            return this;
        }
        public ListFolderGetLatestCursorResult start() throws ListFolderGetLatestCursorException, DbxException
        {
            ListFolderArg arg = new ListFolderArg(path, recursive, includeMediaInfo);
            return DbxFiles.this.listFolderGetLatestCursor(arg);
        }
    }
    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * #listFolder}, {@link #listFolderGetLatestCursor} doesn't return any
     * entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     */
    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String path)
    {
        return new ListFolderGetLatestCursorBuilder(path);
    }

    /**
     * Exception thrown by {@link #download}.
     */
    public static class DownloadException extends DbxApiException {
        /**
         * The error reported by download.
         */
        public final DownloadError errorValue;

        public DownloadException(DownloadError errorValue) {
            super("Exception in download: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Download a file from a user's Dropbox.
     */
    private com.dropbox.core.DbxDownloader<FileMetadata> download(DownloadArg arg)
            throws DownloadException, DbxException
    {
        try {
            return DbxRawClientV2.downloadStyle(client.getRequestConfig(),
                                                client.getAccessToken(),
                                                client.getHost().content,
                                                "2-beta-2/files/download",
                                                arg,
                                                DownloadArg._writer,
                                                FileMetadata._reader,
                                                DownloadError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DownloadException((DownloadError) (ew.errValue));
        }
    }
    /**
     * The {@link com.dropbox.core.v2.DbxDownloadStyleBuilder} returned by
     * {@link #downloadBuilder}.
     */
    public final class DownloadBuilder extends DbxDownloadStyleBuilder<FileMetadata>
    {
        private String path;
        private String rev;
        private DownloadBuilder(String path)
        {
            this.path = path;
        }
        public DownloadBuilder rev(String rev)
        {
            this.rev = rev;
            return this;
        }
        public com.dropbox.core.DbxDownloader<FileMetadata> start() throws DownloadException, DbxException
        {
            DownloadArg arg = new DownloadArg(path, rev);
            return DbxFiles.this.download(arg);
        }
    }
    /**
     * Download a file from a user's Dropbox.
     */
    public DownloadBuilder downloadBuilder(String path)
    {
        return new DownloadBuilder(path);
    }

    /**
     * Exception thrown by {@link #uploadSessionStart}.
     */
    public static class UploadSessionStartException extends DbxApiException {
        public UploadSessionStartException() {
            super("Exception in upload_session/start");
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionStartException> uploadSessionStartErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionStartException>()
    {
        @Override
        public UploadSessionStartException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionStartException();
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * #uploadSessionStart}.
     */
    public static class UploadSessionStartUploader extends com.dropbox.core.DbxUploader<UploadSessionStartResult,Object,UploadSessionStartException> {
        UploadSessionStartUploader(HttpRequestor.Uploader httpUploader, JsonReader<UploadSessionStartResult> resultReader, JsonReader<Object>errorReader, DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionStartException> errorMaker) {
            super(httpUploader, resultReader, errorReader, errorMaker);
        }
    }
    static com.dropbox.core.DbxUploader.UploaderMaker<UploadSessionStartResult,Object,UploadSessionStartException> uploadSessionStartUploaderMaker = new com.dropbox.core.DbxUploader.UploaderMaker<UploadSessionStartResult,Object,UploadSessionStartException>()
    {
        @Override
        public com.dropbox.core.DbxUploader<UploadSessionStartResult,Object,UploadSessionStartException> makeUploader(HttpRequestor.Uploader httpUploader) {
            return new UploadSessionStartUploader(httpUploader, UploadSessionStartResult._reader, JsonReader.VoidReader, uploadSessionStartErrorMaker);
        }
    };
    /**
     * Upload sessions allow you to upload a single file using multiple
     * requests. This call starts a new upload session with the given data.  You
     * can then use {@link #uploadSessionAppend} to add more data and {@link
     * #uploadSessionFinish} to save all the data to a file in Dropbox.
     */
    public UploadSessionStartUploader uploadSessionStart()
            throws DbxException
    {
        try {
            return (UploadSessionStartUploader) DbxRawClientV2.uploadStyle(client.getRequestConfig(),
                                                                           client.getAccessToken(),
                                                                           client.getHost().content,
                                                                           "2-beta-2/files/upload_session/start",
                                                                           null,
                                                                           null,
                                                                           uploadSessionStartUploaderMaker);
        }
        catch (DbxException ex) { throw ex; } // Dummy
    }

    /**
     * Exception thrown by {@link #uploadSessionAppend}.
     */
    public static class UploadSessionAppendException extends DbxApiException {
        /**
         * The error reported by uploadSessionAppend.
         */
        public final UploadSessionLookupError errorValue;

        public UploadSessionAppendException(UploadSessionLookupError errorValue) {
            super("Exception in upload_session/append: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionAppendException> uploadSessionAppendErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionAppendException>()
    {
        @Override
        public UploadSessionAppendException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionAppendException((UploadSessionLookupError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * #uploadSessionAppend}.
     */
    public static class UploadSessionAppendUploader extends com.dropbox.core.DbxUploader<Object,UploadSessionLookupError,UploadSessionAppendException> {
        UploadSessionAppendUploader(HttpRequestor.Uploader httpUploader, JsonReader<Object> resultReader, JsonReader<UploadSessionLookupError>errorReader, DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionAppendException> errorMaker) {
            super(httpUploader, resultReader, errorReader, errorMaker);
        }
    }
    static com.dropbox.core.DbxUploader.UploaderMaker<Object,UploadSessionLookupError,UploadSessionAppendException> uploadSessionAppendUploaderMaker = new com.dropbox.core.DbxUploader.UploaderMaker<Object,UploadSessionLookupError,UploadSessionAppendException>()
    {
        @Override
        public com.dropbox.core.DbxUploader<Object,UploadSessionLookupError,UploadSessionAppendException> makeUploader(HttpRequestor.Uploader httpUploader) {
            return new UploadSessionAppendUploader(httpUploader, JsonReader.VoidReader, UploadSessionLookupError._reader, uploadSessionAppendErrorMaker);
        }
    };
    /**
     * Append more data to an upload session.
     */
    private UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor arg)
            throws DbxException
    {
        try {
            return (UploadSessionAppendUploader) DbxRawClientV2.uploadStyle(client.getRequestConfig(),
                                                                            client.getAccessToken(),
                                                                            client.getHost().content,
                                                                            "2-beta-2/files/upload_session/append",
                                                                            arg,
                                                                            UploadSessionCursor._writer,
                                                                            uploadSessionAppendUploaderMaker);
        }
        catch (DbxException ex) { throw ex; } // Dummy
    }
    /**
     * The {@link com.dropbox.core.v2.DbxUploadStyleBuilder} returned by {@link
     * #uploadSessionAppendBuilder}.
     */
    public final class UploadSessionAppendBuilder extends DbxUploadStyleBuilder<Object,UploadSessionLookupError,UploadSessionAppendException>
    {
        private String sessionId;
        private Long offset;
        private UploadSessionAppendBuilder(String sessionId, long offset)
        {
            this.sessionId = sessionId;
            this.offset = offset;
        }
        public UploadSessionAppendUploader start() throws UploadSessionAppendException, DbxException
        {
            UploadSessionCursor arg = new UploadSessionCursor(sessionId, offset);
            return DbxFiles.this.uploadSessionAppend(arg);
        }
    }
    /**
     * Append more data to an upload session.
     */
    public UploadSessionAppendBuilder uploadSessionAppendBuilder(String sessionId, long offset)
    {
        return new UploadSessionAppendBuilder(sessionId, offset);
    }

    /**
     * Exception thrown by {@link #uploadSessionFinish}.
     */
    public static class UploadSessionFinishException extends DbxApiException {
        /**
         * The error reported by uploadSessionFinish.
         */
        public final UploadSessionFinishError errorValue;

        public UploadSessionFinishException(UploadSessionFinishError errorValue) {
            super("Exception in upload_session/finish: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionFinishException> uploadSessionFinishErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionFinishException>()
    {
        @Override
        public UploadSessionFinishException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionFinishException((UploadSessionFinishError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * #uploadSessionFinish}.
     */
    public static class UploadSessionFinishUploader extends com.dropbox.core.DbxUploader<FileMetadata,UploadSessionFinishError,UploadSessionFinishException> {
        UploadSessionFinishUploader(HttpRequestor.Uploader httpUploader, JsonReader<FileMetadata> resultReader, JsonReader<UploadSessionFinishError>errorReader, DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionFinishException> errorMaker) {
            super(httpUploader, resultReader, errorReader, errorMaker);
        }
    }
    static com.dropbox.core.DbxUploader.UploaderMaker<FileMetadata,UploadSessionFinishError,UploadSessionFinishException> uploadSessionFinishUploaderMaker = new com.dropbox.core.DbxUploader.UploaderMaker<FileMetadata,UploadSessionFinishError,UploadSessionFinishException>()
    {
        @Override
        public com.dropbox.core.DbxUploader<FileMetadata,UploadSessionFinishError,UploadSessionFinishException> makeUploader(HttpRequestor.Uploader httpUploader) {
            return new UploadSessionFinishUploader(httpUploader, FileMetadata._reader, UploadSessionFinishError._reader, uploadSessionFinishErrorMaker);
        }
    };
    /**
     * Finish an upload session and save the uploaded data to the given file
     * path.
     */
    private UploadSessionFinishUploader uploadSessionFinish(UploadSessionFinishArg arg)
            throws DbxException
    {
        try {
            return (UploadSessionFinishUploader) DbxRawClientV2.uploadStyle(client.getRequestConfig(),
                                                                            client.getAccessToken(),
                                                                            client.getHost().content,
                                                                            "2-beta-2/files/upload_session/finish",
                                                                            arg,
                                                                            UploadSessionFinishArg._writer,
                                                                            uploadSessionFinishUploaderMaker);
        }
        catch (DbxException ex) { throw ex; } // Dummy
    }
    /**
     * The {@link com.dropbox.core.v2.DbxUploadStyleBuilder} returned by {@link
     * #uploadSessionFinishBuilder}.
     */
    public final class UploadSessionFinishBuilder extends DbxUploadStyleBuilder<FileMetadata,UploadSessionFinishError,UploadSessionFinishException>
    {
        private UploadSessionCursor cursor;
        private CommitInfo commit;
        private UploadSessionFinishBuilder(UploadSessionCursor cursor, CommitInfo commit)
        {
            this.cursor = cursor;
            this.commit = commit;
        }
        public UploadSessionFinishUploader start() throws UploadSessionFinishException, DbxException
        {
            UploadSessionFinishArg arg = new UploadSessionFinishArg(cursor, commit);
            return DbxFiles.this.uploadSessionFinish(arg);
        }
    }
    /**
     * Finish an upload session and save the uploaded data to the given file
     * path.
     */
    public UploadSessionFinishBuilder uploadSessionFinishBuilder(UploadSessionCursor cursor, CommitInfo commit)
    {
        return new UploadSessionFinishBuilder(cursor, commit);
    }

    /**
     * Exception thrown by {@link #upload}.
     */
    public static class UploadException extends DbxApiException {
        /**
         * The error reported by upload.
         */
        public final UploadError errorValue;

        public UploadException(UploadError errorValue) {
            super("Exception in upload: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadException> uploadErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadException>()
    {
        @Override
        public UploadException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadException((UploadError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link #upload}.
     */
    public static class UploadUploader extends com.dropbox.core.DbxUploader<FileMetadata,UploadError,UploadException> {
        UploadUploader(HttpRequestor.Uploader httpUploader, JsonReader<FileMetadata> resultReader, JsonReader<UploadError>errorReader, DbxRequestUtil.RouteSpecificErrorMaker<UploadException> errorMaker) {
            super(httpUploader, resultReader, errorReader, errorMaker);
        }
    }
    static com.dropbox.core.DbxUploader.UploaderMaker<FileMetadata,UploadError,UploadException> uploadUploaderMaker = new com.dropbox.core.DbxUploader.UploaderMaker<FileMetadata,UploadError,UploadException>()
    {
        @Override
        public com.dropbox.core.DbxUploader<FileMetadata,UploadError,UploadException> makeUploader(HttpRequestor.Uploader httpUploader) {
            return new UploadUploader(httpUploader, FileMetadata._reader, UploadError._reader, uploadErrorMaker);
        }
    };
    /**
     * Create a new file with the contents provided in the request.
     */
    private UploadUploader upload(CommitInfo arg)
            throws DbxException
    {
        try {
            return (UploadUploader) DbxRawClientV2.uploadStyle(client.getRequestConfig(),
                                                               client.getAccessToken(),
                                                               client.getHost().content,
                                                               "2-beta-2/files/upload",
                                                               arg,
                                                               CommitInfo._writer,
                                                               uploadUploaderMaker);
        }
        catch (DbxException ex) { throw ex; } // Dummy
    }
    /**
     * The {@link com.dropbox.core.v2.DbxUploadStyleBuilder} returned by {@link
     * #uploadBuilder}.
     */
    public final class UploadBuilder extends DbxUploadStyleBuilder<FileMetadata,UploadError,UploadException>
    {
        private String path;
        private WriteMode mode;
        private Boolean autorename;
        private java.util.Date clientModified;
        private Boolean mute;
        private UploadBuilder(String path)
        {
            this.path = path;
        }
        public UploadBuilder mode(WriteMode mode)
        {
            this.mode = mode;
            return this;
        }
        public UploadBuilder autorename(boolean autorename)
        {
            this.autorename = autorename;
            return this;
        }
        public UploadBuilder clientModified(java.util.Date clientModified)
        {
            this.clientModified = clientModified;
            return this;
        }
        public UploadBuilder mute(boolean mute)
        {
            this.mute = mute;
            return this;
        }
        public UploadUploader start() throws UploadException, DbxException
        {
            CommitInfo arg = new CommitInfo(path, mode, autorename, clientModified, mute);
            return DbxFiles.this.upload(arg);
        }
    }
    /**
     * Create a new file with the contents provided in the request.
     */
    public UploadBuilder uploadBuilder(String path)
    {
        return new UploadBuilder(path);
    }

    /**
     * Exception thrown by {@link #search}.
     */
    public static class SearchException extends DbxApiException {
        /**
         * The error reported by search.
         */
        public final SearchError errorValue;

        public SearchException(SearchError errorValue) {
            super("Exception in search: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Searches for files and folders.
     */
    private SearchResult search(SearchArg arg)
            throws SearchException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/search",
                                           arg,
                                           SearchArg._writer,
                                           SearchResult._reader,
                                           SearchError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SearchException((SearchError) (ew.errValue));
        }
    }
    /**
     * Searches for files and folders.
     */
    public SearchResult search(String path, String query)
          throws SearchException, DbxException
    {
        SearchArg arg = new SearchArg(path, query, null, null, null);
        return search(arg);
    }
    /**
     * The builder object returned by {@link #searchBuilder}
     */
    public final class SearchBuilder
    {
        private String path;
        private String query;
        private Long start;
        private Long maxResults;
        private SearchMode mode;
        private SearchBuilder(String path, String query)
        {
            this.path = path;
            this.query = query;
        }
        public SearchBuilder start(long start)
        {
            this.start = start;
            return this;
        }
        public SearchBuilder maxResults(long maxResults)
        {
            this.maxResults = maxResults;
            return this;
        }
        public SearchBuilder mode(SearchMode mode)
        {
            this.mode = mode;
            return this;
        }
        public SearchResult start() throws SearchException, DbxException
        {
            SearchArg arg = new SearchArg(path, query, start, maxResults, mode);
            return DbxFiles.this.search(arg);
        }
    }
    /**
     * Searches for files and folders.
     */
    public SearchBuilder searchBuilder(String path, String query)
    {
        return new SearchBuilder(path, query);
    }

    /**
     * Exception thrown by {@link #createFolder}.
     */
    public static class CreateFolderException extends DbxApiException {
        /**
         * The error reported by createFolder.
         */
        public final CreateFolderError errorValue;

        public CreateFolderException(CreateFolderError errorValue) {
            super("Exception in create_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Create a folder at a given path.
     */
    private FolderMetadata createFolder(CreateFolderArg arg)
            throws CreateFolderException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/create_folder",
                                           arg,
                                           CreateFolderArg._writer,
                                           FolderMetadata._reader,
                                           CreateFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateFolderException((CreateFolderError) (ew.errValue));
        }
    }
    /**
     * Create a folder at a given path.
     */
    public FolderMetadata createFolder(String path)
          throws CreateFolderException, DbxException
    {
        CreateFolderArg arg = new CreateFolderArg(path);
        return createFolder(arg);
    }

    /**
     * Exception thrown by {@link #delete}.
     */
    public static class DeleteException extends DbxApiException {
        /**
         * The error reported by delete.
         */
        public final DeleteError errorValue;

        public DeleteException(DeleteError errorValue) {
            super("Exception in delete: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too.
     */
    private Metadata delete(DeleteArg arg)
            throws DeleteException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/delete",
                                           arg,
                                           DeleteArg._writer,
                                           Metadata._reader,
                                           DeleteError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DeleteException((DeleteError) (ew.errValue));
        }
    }
    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too.
     */
    public Metadata delete(String path)
          throws DeleteException, DbxException
    {
        DeleteArg arg = new DeleteArg(path);
        return delete(arg);
    }

    /**
     * Exception thrown by {@link #permanentlyDelete}.
     */
    public static class PermanentlyDeleteException extends DbxApiException {
        /**
         * The error reported by permanentlyDelete.
         */
        public final DeleteError errorValue;

        public PermanentlyDeleteException(DeleteError errorValue) {
            super("Exception in permanently_delete: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40).
     */
    private void permanentlyDelete(DeleteArg arg)
            throws PermanentlyDeleteException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/files/permanently_delete",
                                    arg,
                                    DeleteArg._writer,
                                    JsonReader.VoidReader,
                                    DeleteError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PermanentlyDeleteException((DeleteError) (ew.errValue));
        }
    }
    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40).
     */
    public void permanentlyDelete(String path)
          throws PermanentlyDeleteException, DbxException
    {
        DeleteArg arg = new DeleteArg(path);
        permanentlyDelete(arg);
    }

    /**
     * Exception thrown by {@link #copy}.
     */
    public static class CopyException extends DbxApiException {
        /**
         * The error reported by copy.
         */
        public final RelocationError errorValue;

        public CopyException(RelocationError errorValue) {
            super("Exception in copy: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     */
    private Metadata copy(RelocationArg arg)
            throws CopyException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/copy",
                                           arg,
                                           RelocationArg._writer,
                                           Metadata._reader,
                                           RelocationError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CopyException((RelocationError) (ew.errValue));
        }
    }
    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     */
    public Metadata copy(String fromPath, String toPath)
          throws CopyException, DbxException
    {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return copy(arg);
    }

    /**
     * Exception thrown by {@link #move}.
     */
    public static class MoveException extends DbxApiException {
        /**
         * The error reported by move.
         */
        public final RelocationError errorValue;

        public MoveException(RelocationError errorValue) {
            super("Exception in move: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     */
    private Metadata move(RelocationArg arg)
            throws MoveException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/move",
                                           arg,
                                           RelocationArg._writer,
                                           Metadata._reader,
                                           RelocationError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MoveException((RelocationError) (ew.errValue));
        }
    }
    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     */
    public Metadata move(String fromPath, String toPath)
          throws MoveException, DbxException
    {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return move(arg);
    }

    /**
     * Exception thrown by {@link #getThumbnail}.
     */
    public static class GetThumbnailException extends DbxApiException {
        /**
         * The error reported by getThumbnail.
         */
        public final ThumbnailError errorValue;

        public GetThumbnailException(ThumbnailError errorValue) {
            super("Exception in get_thumbnail: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     */
    private com.dropbox.core.DbxDownloader<FileMetadata> getThumbnail(ThumbnailArg arg)
            throws GetThumbnailException, DbxException
    {
        try {
            return DbxRawClientV2.downloadStyle(client.getRequestConfig(),
                                                client.getAccessToken(),
                                                client.getHost().content,
                                                "2-beta-2/files/get_thumbnail",
                                                arg,
                                                ThumbnailArg._writer,
                                                FileMetadata._reader,
                                                ThumbnailError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetThumbnailException((ThumbnailError) (ew.errValue));
        }
    }
    /**
     * The {@link com.dropbox.core.v2.DbxDownloadStyleBuilder} returned by
     * {@link #getThumbnailBuilder}.
     */
    public final class GetThumbnailBuilder extends DbxDownloadStyleBuilder<FileMetadata>
    {
        private String path;
        private ThumbnailFormat format;
        private ThumbnailSize size;
        private GetThumbnailBuilder(String path)
        {
            this.path = path;
        }
        public GetThumbnailBuilder format(ThumbnailFormat format)
        {
            this.format = format;
            return this;
        }
        public GetThumbnailBuilder size(ThumbnailSize size)
        {
            this.size = size;
            return this;
        }
        public com.dropbox.core.DbxDownloader<FileMetadata> start() throws GetThumbnailException, DbxException
        {
            ThumbnailArg arg = new ThumbnailArg(path, format, size);
            return DbxFiles.this.getThumbnail(arg);
        }
    }
    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     */
    public GetThumbnailBuilder getThumbnailBuilder(String path)
    {
        return new GetThumbnailBuilder(path);
    }

    /**
     * Exception thrown by {@link #getPreview}.
     */
    public static class GetPreviewException extends DbxApiException {
        /**
         * The error reported by getPreview.
         */
        public final PreviewError errorValue;

        public GetPreviewException(PreviewError errorValue) {
            super("Exception in get_preview: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     */
    private com.dropbox.core.DbxDownloader<FileMetadata> getPreview(PreviewArg arg)
            throws GetPreviewException, DbxException
    {
        try {
            return DbxRawClientV2.downloadStyle(client.getRequestConfig(),
                                                client.getAccessToken(),
                                                client.getHost().content,
                                                "2-beta-2/files/get_preview",
                                                arg,
                                                PreviewArg._writer,
                                                FileMetadata._reader,
                                                PreviewError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetPreviewException((PreviewError) (ew.errValue));
        }
    }
    /**
     * The {@link com.dropbox.core.v2.DbxDownloadStyleBuilder} returned by
     * {@link #getPreviewBuilder}.
     */
    public final class GetPreviewBuilder extends DbxDownloadStyleBuilder<FileMetadata>
    {
        private String path;
        private String rev;
        private GetPreviewBuilder(String path)
        {
            this.path = path;
        }
        public GetPreviewBuilder rev(String rev)
        {
            this.rev = rev;
            return this;
        }
        public com.dropbox.core.DbxDownloader<FileMetadata> start() throws GetPreviewException, DbxException
        {
            PreviewArg arg = new PreviewArg(path, rev);
            return DbxFiles.this.getPreview(arg);
        }
    }
    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     */
    public GetPreviewBuilder getPreviewBuilder(String path)
    {
        return new GetPreviewBuilder(path);
    }

    /**
     * Exception thrown by {@link #listRevisions}.
     */
    public static class ListRevisionsException extends DbxApiException {
        /**
         * The error reported by listRevisions.
         */
        public final ListRevisionsError errorValue;

        public ListRevisionsException(ListRevisionsError errorValue) {
            super("Exception in list_revisions: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Return revisions of a file
     */
    private ListRevisionsResult listRevisions(ListRevisionsArg arg)
            throws ListRevisionsException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/list_revisions",
                                           arg,
                                           ListRevisionsArg._writer,
                                           ListRevisionsResult._reader,
                                           ListRevisionsError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListRevisionsException((ListRevisionsError) (ew.errValue));
        }
    }
    /**
     * Return revisions of a file
     */
    public ListRevisionsResult listRevisions(String path)
          throws ListRevisionsException, DbxException
    {
        ListRevisionsArg arg = new ListRevisionsArg(path, null);
        return listRevisions(arg);
    }
    /**
     * Return revisions of a file
     */
    public ListRevisionsResult listRevisions(String path, long limit)
          throws ListRevisionsException, DbxException
    {
        ListRevisionsArg arg = new ListRevisionsArg(path, limit);
        return listRevisions(arg);
    }

    /**
     * Exception thrown by {@link #restore}.
     */
    public static class RestoreException extends DbxApiException {
        /**
         * The error reported by restore.
         */
        public final RestoreError errorValue;

        public RestoreException(RestoreError errorValue) {
            super("Exception in restore: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Restore a file to a specific revision
     */
    private FileMetadata restore(RestoreArg arg)
            throws RestoreException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/files/restore",
                                           arg,
                                           RestoreArg._writer,
                                           FileMetadata._reader,
                                           RestoreError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RestoreException((RestoreError) (ew.errValue));
        }
    }
    /**
     * Restore a file to a specific revision
     */
    public FileMetadata restore(String path, String rev)
          throws RestoreException, DbxException
    {
        RestoreArg arg = new RestoreArg(path, rev);
        return restore(arg);
    }
}
