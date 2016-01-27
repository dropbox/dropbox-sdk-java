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
import com.dropbox.core.LocalizedText;
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
        /**
         * Deprecated. Please use
         * :field:'FileSharingInfo.parent_shared_folder_id' or
         * :field:'FolderSharingInfo.parent_shared_folder_id' instead.
         */
        public final String parentSharedFolderId;

        /**
         * Metadata for a file or folder.
         *
         * @param name  The last component of the path (including extension).
         *     This never contains a slash. {@code name} must not be {@code
         *     null}.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. {@code pathLower} must not be
         *     {@code null}.
         * @param parentSharedFolderId  Deprecated. Please use
         *     :field:'FileSharingInfo.parent_shared_folder_id' or
         *     :field:'FolderSharingInfo.parent_shared_folder_id' instead.
         *     {@code parentSharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public Metadata(String name, String pathLower, String parentSharedFolderId) {
            this.name = name;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.pathLower = pathLower;
            if (pathLower == null) {
                throw new IllegalArgumentException("Required value for 'pathLower' is null");
            }
            this.parentSharedFolderId = parentSharedFolderId;
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
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
                if (x.parentSharedFolderId != null) {
                    g.writeFieldName("parent_shared_folder_id");
                    g.writeString(x.parentSharedFolderId);
                }
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
                String parentSharedFolderId = null;
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
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new Metadata(name, pathLower, parentSharedFolderId);
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
     * Sharing info for a file or folder.
     */
    public static class SharingInfo {
        // struct SharingInfo
        /**
         * True if the file or folder is inside a read-only shared folder.
         */
        public final boolean readOnly;

        /**
         * Sharing info for a file or folder.
         *
         * @param readOnly  True if the file or folder is inside a read-only
         *     shared folder.
         */
        public SharingInfo(boolean readOnly) {
            this.readOnly = readOnly;
        }

        static final JsonWriter<SharingInfo> _writer = new JsonWriter<SharingInfo>()
        {
            public final void write(SharingInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SharingInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SharingInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("read_only", x.readOnly);
            }
        };

        public static final JsonReader<SharingInfo> _reader = new JsonReader<SharingInfo>() {

            public final SharingInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SharingInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharingInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean readOnly = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("read_only".equals(fieldName)) {
                        readOnly = JsonReader.BooleanReader
                            .readField(parser, "read_only", readOnly);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (readOnly == null) {
                    throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
                }
                return new SharingInfo(readOnly);
            }
        };

        public String toString() {
            return "SharingInfo." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "SharingInfo." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static SharingInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * Sharing info for a file which is contained by a shared folder.
     */
    public static class FileSharingInfo extends SharingInfo  {
        // struct FileSharingInfo
        /**
         * ID of shared folder that holds this file.
         */
        public final String parentSharedFolderId;
        /**
         * The last user who modified the file. This field will be null if the
         * user's account has been deleted.
         */
        public final String modifiedBy;

        /**
         * Sharing info for a file which is contained by a shared folder.
         *
         * @param readOnly  True if the file or folder is inside a read-only
         *     shared folder.
         * @param parentSharedFolderId  ID of shared folder that holds this
         *     file. {@code parentSharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}" and not be {@code null}.
         * @param modifiedBy  The last user who modified the file. This field
         *     will be null if the user's account has been deleted. {@code
         *     modifiedBy} must have length of at least 40 and have length of at
         *     most 40.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FileSharingInfo(boolean readOnly, String parentSharedFolderId, String modifiedBy) {
            super(readOnly);
            this.parentSharedFolderId = parentSharedFolderId;
            if (parentSharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'parentSharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
            this.modifiedBy = modifiedBy;
            if (modifiedBy != null) {
                if (modifiedBy.length() < 40) {
                    throw new IllegalArgumentException("String 'modifiedBy' is shorter than 40");
                }
                if (modifiedBy.length() > 40) {
                    throw new IllegalArgumentException("String 'modifiedBy' is longer than 40");
                }
            }
        }

        static final JsonWriter<FileSharingInfo> _writer = new JsonWriter<FileSharingInfo>()
        {
            public final void write(FileSharingInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SharingInfo._writer.writeFields(x, g);
                FileSharingInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FileSharingInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("parent_shared_folder_id", x.parentSharedFolderId);
                if (x.modifiedBy != null) {
                    g.writeFieldName("modified_by");
                    g.writeString(x.modifiedBy);
                }
            }
        };

        public static final JsonReader<FileSharingInfo> _reader = new JsonReader<FileSharingInfo>() {

            public final FileSharingInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FileSharingInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FileSharingInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean readOnly = null;
                String parentSharedFolderId = null;
                String modifiedBy = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("read_only".equals(fieldName)) {
                        readOnly = JsonReader.BooleanReader
                            .readField(parser, "read_only", readOnly);
                    }
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else if ("modified_by".equals(fieldName)) {
                        modifiedBy = JsonReader.StringReader
                            .readField(parser, "modified_by", modifiedBy);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (readOnly == null) {
                    throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
                }
                if (parentSharedFolderId == null) {
                    throw new JsonReadException("Required field \"parent_shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new FileSharingInfo(readOnly, parentSharedFolderId, modifiedBy);
            }
        };

        public String toString() {
            return "FileSharingInfo." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "FileSharingInfo." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static FileSharingInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * Sharing info for a folder which is contained in a shared folder or is a
     * shared folder mount point.
     */
    public static class FolderSharingInfo extends SharingInfo  {
        // struct FolderSharingInfo
        /**
         * Set if the folder is contained by a shared folder.
         */
        public final String parentSharedFolderId;
        /**
         * If this folder is a shared folder mount point, the ID of the shared
         * folder mounted at this location.
         */
        public final String sharedFolderId;

        /**
         * Sharing info for a folder which is contained in a shared folder or is
         * a shared folder mount point.
         *
         * @param readOnly  True if the file or folder is inside a read-only
         *     shared folder.
         * @param parentSharedFolderId  Set if the folder is contained by a
         *     shared folder. {@code parentSharedFolderId} must match pattern
         *     "{@code [-_0-9a-zA-Z:]+}".
         * @param sharedFolderId  If this folder is a shared folder mount point,
         *     the ID of the shared folder mounted at this location. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FolderSharingInfo(boolean readOnly, String parentSharedFolderId, String sharedFolderId) {
            super(readOnly);
            this.parentSharedFolderId = parentSharedFolderId;
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                    throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
                }
            }
        }

        static final JsonWriter<FolderSharingInfo> _writer = new JsonWriter<FolderSharingInfo>()
        {
            public final void write(FolderSharingInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SharingInfo._writer.writeFields(x, g);
                FolderSharingInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FolderSharingInfo x, JsonGenerator g)
             throws IOException
            {
                if (x.parentSharedFolderId != null) {
                    g.writeFieldName("parent_shared_folder_id");
                    g.writeString(x.parentSharedFolderId);
                }
                if (x.sharedFolderId != null) {
                    g.writeFieldName("shared_folder_id");
                    g.writeString(x.sharedFolderId);
                }
            }
        };

        public static final JsonReader<FolderSharingInfo> _reader = new JsonReader<FolderSharingInfo>() {

            public final FolderSharingInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FolderSharingInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FolderSharingInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean readOnly = null;
                String parentSharedFolderId = null;
                String sharedFolderId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("read_only".equals(fieldName)) {
                        readOnly = JsonReader.BooleanReader
                            .readField(parser, "read_only", readOnly);
                    }
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (readOnly == null) {
                    throw new JsonReadException("Required field \"read_only\" is missing.", parser.getTokenLocation());
                }
                return new FolderSharingInfo(readOnly, parentSharedFolderId, sharedFolderId);
            }
        };

        public String toString() {
            return "FolderSharingInfo." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "FolderSharingInfo." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static FolderSharingInfo fromJson(String s)
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

        /**
         * Dimensions for a photo or video.
         *
         * @param height  Height of the photo/video.
         * @param width  Width of the photo/video.
         */
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

        /**
         * GPS coordinates for a photo or video.
         *
         * @param latitude  Latitude of the GPS coordinates.
         * @param longitude  Longitude of the GPS coordinates.
         */
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

        /**
         * Metadata for a photo or video.
         *
         * @param dimensions  Dimension of the photo/video.
         * @param location  The GPS coordinate of the photo/video.
         * @param timeTaken  The timestamp when the photo/video is taken.
         */
        public MediaMetadata(Dimensions dimensions, GpsCoordinates location, java.util.Date timeTaken) {
            this.dimensions = dimensions;
            this.location = location;
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

        /**
         * Metadata for a photo.
         *
         * @param dimensions  Dimension of the photo/video.
         * @param location  The GPS coordinate of the photo/video.
         * @param timeTaken  The timestamp when the photo/video is taken.
         */
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

        /**
         * Metadata for a video.
         *
         * @param dimensions  Dimension of the photo/video.
         * @param location  The GPS coordinate of the photo/video.
         * @param timeTaken  The timestamp when the photo/video is taken.
         * @param duration  The duration of the video in milliseconds.
         */
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
            /**
             * Indicate the photo/video is still under processing and metadata
             * is not available yet.
             */
            PENDING,
            /**
             * The metadata for the photo/video.
             */
            METADATA  // MediaMetadata
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code MediaInfo}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Indicate the photo/video is still under processing and metadata is
         * not available yet.
         */
        private static final MediaInfo PENDING_INSTANCE = new MediaInfo(Tag.PENDING);

        /**
         * Returns an instance of {@code MediaInfo} that has its tag set to
         * {@link Tag#PENDING}.
         *
         * <p> Indicate the photo/video is still under processing and metadata
         * is not available yet. </p>
         *
         * @return Instance of {@code MediaInfo} with its tag set to {@link
         *     Tag#PENDING}.
         */
        public static MediaInfo pending() {
            return MediaInfo.PENDING_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PENDING}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PENDING}, {@code false} otherwise.
         */
        public boolean isPending() {
            return this.tag == Tag.PENDING;
        }

        private final MediaMetadata metadataValue;

        private MediaInfo(Tag tag, MediaMetadata value) {
            this.tag = tag;
            this.metadataValue = value;
            validate();
        }

        /**
         * The metadata for the photo/video.
         *
         * <p> This instance must be tagged as {@link Tag#METADATA}. </p>
         *
         * @return The {@link MediaMetadata} value associated with this instance
         *     if {@link #isMetadata} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMetadata} is {@code
         *     false}.
         */
        public MediaMetadata getMetadataValue() {
            if (this.tag != Tag.METADATA) {
                throw new IllegalStateException("getMetadataValue() requires tag==METADATA, actual tag==" + tag);
            }
            return metadataValue;
        }

        /**
         * Returns an instance of {@code MediaInfo} that has its tag set to
         * {@link Tag#METADATA}.
         *
         * <p> The metadata for the photo/video. </p>
         *
         * @param value  {@link MediaMetadata} value to assign to this instance.
         *
         * @return Instance of {@code MediaInfo} with its tag set to {@link
         *     Tag#METADATA}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static MediaInfo metadata(MediaMetadata value) {
            return new MediaInfo(Tag.METADATA, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#METADATA}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#METADATA}, {@code false} otherwise.
         */
        public boolean isMetadata() {
            return this.tag == Tag.METADATA;
        }

        private MediaInfo(Tag t) {
            tag = t;
            metadataValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case PENDING:
                    break;
                case METADATA:
                    if (this.metadataValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                        case PENDING: return MediaInfo.pending();
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
                        case PENDING: {
                            value = MediaInfo.pending();
                            break;
                        }
                        case METADATA: {
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
            _values.put("pending", Tag.PENDING);
            _values.put("metadata", Tag.METADATA);
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
        /**
         * Set if this file is contained in a shared folder.
         */
        public final FileSharingInfo sharingInfo;

        /**
         *
         * @param name  The last component of the path (including extension).
         *     This never contains a slash. {@code name} must not be {@code
         *     null}.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. {@code pathLower} must not be
         *     {@code null}.
         * @param clientModified  For files, this is the modification time set
         *     by the desktop client when the file was added to Dropbox. Since
         *     this time is not verified (the Dropbox server stores whatever the
         *     desktop client sends up), this should only be used for display
         *     purposes (such as sorting) and not, for example, to determine if
         *     a file has changed or not. {@code clientModified} must not be
         *     {@code null}.
         * @param serverModified  The last time the file was modified on
         *     Dropbox. {@code serverModified} must not be {@code null}.
         * @param rev  A unique identifier for the current revision of a file.
         *     This field is the same rev as elsewhere in the API and can be
         *     used to detect changes and avoid conflicts. {@code rev} must have
         *     length of at least 9, match pattern "{@code [0-9a-f]+}", and not
         *     be {@code null}.
         * @param size  The file size in bytes.
         * @param parentSharedFolderId  Deprecated. Please use
         *     :field:'FileSharingInfo.parent_shared_folder_id' or
         *     :field:'FolderSharingInfo.parent_shared_folder_id' instead.
         *     {@code parentSharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}".
         * @param id  A unique identifier for the file. {@code id} must have
         *     length of at least 1.
         * @param mediaInfo  Additional information if the file is a photo or
         *     video.
         * @param sharingInfo  Set if this file is contained in a shared folder.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FileMetadata(String name, String pathLower, java.util.Date clientModified, java.util.Date serverModified, String rev, long size, String parentSharedFolderId, String id, MediaInfo mediaInfo, FileSharingInfo sharingInfo) {
            super(name, pathLower, parentSharedFolderId);
            this.id = id;
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.clientModified = clientModified;
            if (clientModified == null) {
                throw new IllegalArgumentException("Required value for 'clientModified' is null");
            }
            this.serverModified = serverModified;
            if (serverModified == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.rev = rev;
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.size = size;
            this.mediaInfo = mediaInfo;
            this.sharingInfo = sharingInfo;
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
                if (x.sharingInfo != null) {
                    g.writeFieldName("sharing_info");
                    FileSharingInfo._writer.write(x.sharingInfo, g);
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
                String parentSharedFolderId = null;
                String id = null;
                MediaInfo mediaInfo = null;
                FileSharingInfo sharingInfo = null;
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
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("media_info".equals(fieldName)) {
                        mediaInfo = MediaInfo._reader
                            .readField(parser, "media_info", mediaInfo);
                    }
                    else if ("sharing_info".equals(fieldName)) {
                        sharingInfo = FileSharingInfo._reader
                            .readField(parser, "sharing_info", sharingInfo);
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
                return new FileMetadata(name, pathLower, clientModified, serverModified, rev, size, parentSharedFolderId, id, mediaInfo, sharingInfo);
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
        /**
         * Deprecated. Please use :field:'sharing_info' instead.
         */
        public final String sharedFolderId;
        /**
         * Set if the folder is contained in a shared folder or is a shared
         * folder mount point.
         */
        public final FolderSharingInfo sharingInfo;

        /**
         *
         * @param name  The last component of the path (including extension).
         *     This never contains a slash. {@code name} must not be {@code
         *     null}.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. {@code pathLower} must not be
         *     {@code null}.
         * @param parentSharedFolderId  Deprecated. Please use
         *     :field:'FileSharingInfo.parent_shared_folder_id' or
         *     :field:'FolderSharingInfo.parent_shared_folder_id' instead.
         *     {@code parentSharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}".
         * @param id  A unique identifier for the folder. {@code id} must have
         *     length of at least 1.
         * @param sharedFolderId  Deprecated. Please use :field:'sharing_info'
         *     instead. {@code sharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}".
         * @param sharingInfo  Set if the folder is contained in a shared folder
         *     or is a shared folder mount point.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FolderMetadata(String name, String pathLower, String parentSharedFolderId, String id, String sharedFolderId, FolderSharingInfo sharingInfo) {
            super(name, pathLower, parentSharedFolderId);
            this.id = id;
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                    throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
                }
            }
            this.sharingInfo = sharingInfo;
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
                if (x.sharedFolderId != null) {
                    g.writeFieldName("shared_folder_id");
                    g.writeString(x.sharedFolderId);
                }
                if (x.sharingInfo != null) {
                    g.writeFieldName("sharing_info");
                    FolderSharingInfo._writer.write(x.sharingInfo, g);
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
                String parentSharedFolderId = null;
                String id = null;
                String sharedFolderId = null;
                FolderSharingInfo sharingInfo = null;
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
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("sharing_info".equals(fieldName)) {
                        sharingInfo = FolderSharingInfo._reader
                            .readField(parser, "sharing_info", sharingInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new FolderMetadata(name, pathLower, parentSharedFolderId, id, sharedFolderId, sharingInfo);
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

        /**
         * Indicates that there used to be a file or folder at this path, but it
         * no longer exists.
         *
         * @param name  The last component of the path (including extension).
         *     This never contains a slash. {@code name} must not be {@code
         *     null}.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. {@code pathLower} must not be
         *     {@code null}.
         * @param parentSharedFolderId  Deprecated. Please use
         *     :field:'FileSharingInfo.parent_shared_folder_id' or
         *     :field:'FolderSharingInfo.parent_shared_folder_id' instead.
         *     {@code parentSharedFolderId} must match pattern "{@code
         *     [-_0-9a-zA-Z:]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public DeletedMetadata(String name, String pathLower, String parentSharedFolderId) {
            super(name, pathLower, parentSharedFolderId);
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
                String parentSharedFolderId = null;
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
                    else if ("parent_shared_folder_id".equals(fieldName)) {
                        parentSharedFolderId = JsonReader.StringReader
                            .readField(parser, "parent_shared_folder_id", parentSharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (pathLower == null) {
                    throw new JsonReadException("Required field \"path_lower\" is missing.", parser.getTokenLocation());
                }
                return new DeletedMetadata(name, pathLower, parentSharedFolderId);
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
            PATH  // LookupError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code GetMetadataError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private GetMetadataError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code GetMetadataError} that has its tag set
         * to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code GetMetadataError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static GetMetadataError path(LookupError value) {
            return new GetMetadataError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }


        private final void validate() {
            switch (this.tag) {
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
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
                        case PATH: {
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
            _values.put("path", Tag.PATH);
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

        /**
         *
         * @param path  The path of a file or folder on Dropbox. {@code path}
         *     must match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and
         *     not be {@code null}.
         * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is
         *     set for photo and video.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetMetadataArg(String path, Boolean includeMediaInfo) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
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
         * A cursor as returned by {@link DbxFiles#listFolderBuilder} or {@link
         * DbxFiles#listFolderContinue(String)}
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

        /**
         *
         * @param cursor  A cursor as returned by {@link
         *     DbxFiles#listFolderBuilder} or {@link
         *     DbxFiles#listFolderContinue(String)}. {@code cursor} must have
         *     length of at least 1 and not be {@code null}.
         * @param timeout  A timeout in seconds. The request will block for at
         *     most this length of time, plus up to 90 seconds of random jitter
         *     added to avoid the thundering herd problem. Care should be taken
         *     when using this parameter, as some network infrastructure does
         *     not support long timeouts. {@code timeout} must be greater than
         *     or equal to 30 and be less than or equal to 480.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderLongpollArg(String cursor, Long timeout) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
            }
            if (timeout != null) {
                this.timeout = timeout.longValue();
            }
            else {
                this.timeout = 30L;
            }
            if (this.timeout < 30L) {
                throw new IllegalArgumentException("Number 'this.timeout' is smaller than 30L");
            }
            if (this.timeout > 480L) {
                throw new IllegalArgumentException("Number 'this.timeout' is larger than 480L");
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
         * DbxFiles#listFolderBuilder} to retrieve the changes.
         */
        public final boolean changes;
        /**
         * If present, backoff for at least this many seconds before calling
         * {@link DbxFiles#listFolderLongpoll(String,long)} again.
         */
        public final Long backoff;

        /**
         *
         * @param changes  Indicates whether new changes are available. If true,
         *     call {@link DbxFiles#listFolderBuilder} to retrieve the changes.
         * @param backoff  If present, backoff for at least this many seconds
         *     before calling {@link DbxFiles#listFolderLongpoll(String,long)}
         *     again.
         */
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


    public static final class ListFolderLongpollError {
        // union ListFolderLongpollError

        /**
         * The discriminating tag type for {@link ListFolderLongpollError}.
         */
        public enum Tag {
            /**
             * Indicates that the cursor has been invalidated. Call {@link
             * DbxFiles#listFolderBuilder} to obtain a new cursor.
             */
            RESET,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ListFolderLongpollError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Indicates that the cursor has been invalidated. Call {@link
         * DbxFiles#listFolderBuilder} to obtain a new cursor.
         */
        private static final ListFolderLongpollError RESET_INSTANCE = new ListFolderLongpollError(Tag.RESET);

        /**
         * Returns an instance of {@code ListFolderLongpollError} that has its
         * tag set to {@link Tag#RESET}.
         *
         * <p> Indicates that the cursor has been invalidated. Call {@link
         * DbxFiles#listFolderBuilder} to obtain a new cursor. </p>
         *
         * @return Instance of {@code ListFolderLongpollError} with its tag set
         *     to {@link Tag#RESET}.
         */
        public static ListFolderLongpollError reset() {
            return ListFolderLongpollError.RESET_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#RESET},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#RESET},
         *     {@code false} otherwise.
         */
        public boolean isReset() {
            return this.tag == Tag.RESET;
        }

        private static final ListFolderLongpollError OTHER_INSTANCE = new ListFolderLongpollError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListFolderLongpollError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListFolderLongpollError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static ListFolderLongpollError other() {
            return ListFolderLongpollError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private ListFolderLongpollError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case RESET:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<ListFolderLongpollError> _writer = new JsonWriter<ListFolderLongpollError>()
        {
            public final void write(ListFolderLongpollError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case RESET:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("reset");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListFolderLongpollError.other(); }
                    switch (tag) {
                        case RESET: return ListFolderLongpollError.reset();
                        case OTHER: return ListFolderLongpollError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListFolderLongpollError value = null;
                if (tag != null) {
                    switch (tag) {
                        case RESET: {
                            value = ListFolderLongpollError.reset();
                            break;
                        }
                        case OTHER: {
                            value = ListFolderLongpollError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderLongpollError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("reset", Tag.RESET);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "ListFolderLongpollError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderLongpollError." +  _writer.writeToString(this, true);
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
        /**
         * If true, the results will include entries for files and folders that
         * used to exist but were deleted.
         */
        public final boolean includeDeleted;

        /**
         *
         * @param path  The path to the folder you want to see the contents of.
         *     {@code path} must match pattern "{@code (/.*)?}" and not be
         *     {@code null}.
         * @param recursive  If true, the list folder operation will be applied
         *     recursively to all subfolders and the response will contain
         *     contents of all subfolders.
         * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is
         *     set for photo and video.
         * @param includeDeleted  If true, the results will include entries for
         *     files and folders that used to exist but were deleted.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderArg(String path, Boolean recursive, Boolean includeMediaInfo, Boolean includeDeleted) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
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
            if (includeDeleted != null) {
                this.includeDeleted = includeDeleted.booleanValue();
            }
            else {
                this.includeDeleted = false;
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
                g.writeBooleanField("include_deleted", x.includeDeleted);
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
                Boolean includeDeleted = null;
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
                    else if ("include_deleted".equals(fieldName)) {
                        includeDeleted = JsonReader.BooleanReader
                            .readField(parser, "include_deleted", includeDeleted);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted);
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
        public final java.util.List<Metadata> entries;
        /**
         * Pass the cursor into {@link DbxFiles#listFolderContinue(String)} to
         * see what's changed in the folder since your previous query.
         */
        public final String cursor;
        /**
         * If true, then there are more entries available. Pass the cursor to
         * {@link DbxFiles#listFolderContinue(String)} to retrieve the rest.
         */
        public final boolean hasMore;

        /**
         *
         * @param entries  The files and (direct) subfolders in the folder.
         *     {@code entries} must not contain a {@code null} item and not be
         *     {@code null}.
         * @param cursor  Pass the cursor into {@link
         *     DbxFiles#listFolderContinue(String)} to see what's changed in the
         *     folder since your previous query. {@code cursor} must have length
         *     of at least 1 and not be {@code null}.
         * @param hasMore  If true, then there are more entries available. Pass
         *     the cursor to {@link DbxFiles#listFolderContinue(String)} to
         *     retrieve the rest.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderResult(java.util.List<Metadata> entries, String cursor, boolean hasMore) {
            this.entries = entries;
            if (entries == null) {
                throw new IllegalArgumentException("Required value for 'entries' is null");
            }
            for (Metadata x : entries) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'entries' is null");
                }
            }
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
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
                java.util.List<Metadata> entries = null;
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
            PATH,  // LookupError
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ListFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private ListFolderError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code ListFolderError} that has its tag set
         * to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code ListFolderError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ListFolderError path(LookupError value) {
            return new ListFolderError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * An unspecified error.
         */
        private static final ListFolderError OTHER_INSTANCE = new ListFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListFolderError} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code ListFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static ListFolderError other() {
            return ListFolderError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private ListFolderError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return ListFolderError.other(); }
                    switch (tag) {
                        case OTHER: return ListFolderError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = ListFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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
         * The cursor returned by your last call to {@link
         * DbxFiles#listFolderBuilder} or {@link
         * DbxFiles#listFolderContinue(String)}.
         */
        public final String cursor;

        /**
         *
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxFiles#listFolderBuilder} or {@link
         *     DbxFiles#listFolderContinue(String)}. {@code cursor} must have
         *     length of at least 1 and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderContinueArg(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
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
            PATH,  // LookupError
            /**
             * Indicates that the cursor has been invalidated. Call {@link
             * DbxFiles#listFolderBuilder} to obtain a new cursor.
             */
            RESET,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ListFolderContinueError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private ListFolderContinueError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code ListFolderContinueError} that has its
         * tag set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code ListFolderContinueError} with its tag set
         *     to {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ListFolderContinueError path(LookupError value) {
            return new ListFolderContinueError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * Indicates that the cursor has been invalidated. Call {@link
         * DbxFiles#listFolderBuilder} to obtain a new cursor.
         */
        private static final ListFolderContinueError RESET_INSTANCE = new ListFolderContinueError(Tag.RESET);

        /**
         * Returns an instance of {@code ListFolderContinueError} that has its
         * tag set to {@link Tag#RESET}.
         *
         * <p> Indicates that the cursor has been invalidated. Call {@link
         * DbxFiles#listFolderBuilder} to obtain a new cursor. </p>
         *
         * @return Instance of {@code ListFolderContinueError} with its tag set
         *     to {@link Tag#RESET}.
         */
        public static ListFolderContinueError reset() {
            return ListFolderContinueError.RESET_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#RESET},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#RESET},
         *     {@code false} otherwise.
         */
        public boolean isReset() {
            return this.tag == Tag.RESET;
        }

        private static final ListFolderContinueError OTHER_INSTANCE = new ListFolderContinueError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListFolderContinueError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListFolderContinueError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static ListFolderContinueError other() {
            return ListFolderContinueError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private ListFolderContinueError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case RESET:
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case RESET:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("reset");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return ListFolderContinueError.other(); }
                    switch (tag) {
                        case RESET: return ListFolderContinueError.reset();
                        case OTHER: return ListFolderContinueError.other();
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
                        case PATH: {
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
                        case RESET: {
                            value = ListFolderContinueError.reset();
                            break;
                        }
                        case OTHER: {
                            value = ListFolderContinueError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderContinueError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("reset", Tag.RESET);
            _values.put("other", Tag.OTHER);
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
         * Pass the cursor into {@link DbxFiles#listFolderContinue(String)} to
         * see what's changed in the folder since your previous query.
         */
        public final String cursor;

        /**
         *
         * @param cursor  Pass the cursor into {@link
         *     DbxFiles#listFolderContinue(String)} to see what's changed in the
         *     folder since your previous query. {@code cursor} must have length
         *     of at least 1 and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderGetLatestCursorResult(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
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
            PATH,  // LookupError
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code DownloadError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private DownloadError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code DownloadError} that has its tag set to
         * {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code DownloadError} with its tag set to {@link
         *     Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static DownloadError path(LookupError value) {
            return new DownloadError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * An unspecified error.
         */
        private static final DownloadError OTHER_INSTANCE = new DownloadError(Tag.OTHER);

        /**
         * Returns an instance of {@code DownloadError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code DownloadError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static DownloadError other() {
            return DownloadError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private DownloadError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return DownloadError.other(); }
                    switch (tag) {
                        case OTHER: return DownloadError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = DownloadError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return DownloadError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param path  The path of the file to download. {@code path} must
         *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
         *     {@code null}.
         * @param rev  Deprecated. Please specify revision in :field:'path'
         *     instead. {@code rev} must have length of at least 9 and match
         *     pattern "{@code [0-9a-f]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public DownloadArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new IllegalArgumentException("String 'rev' is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                    throw new IllegalArgumentException("String 'rev' does not match pattern");
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

        /**
         *
         * @param reason  The reason why the file couldn't be saved. {@code
         *     reason} must not be {@code null}.
         * @param uploadSessionId  The upload session ID; this may be used to
         *     retry the commit. {@code uploadSessionId} must not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UploadWriteFailed(WriteError reason, String uploadSessionId) {
            this.reason = reason;
            if (reason == null) {
                throw new IllegalArgumentException("Required value for 'reason' is null");
            }
            this.uploadSessionId = uploadSessionId;
            if (uploadSessionId == null) {
                throw new IllegalArgumentException("Required value for 'uploadSessionId' is null");
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
            /**
             * Unable to save the uploaded contents to a file.
             */
            PATH,  // UploadWriteFailed
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code UploadError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final UploadWriteFailed pathValue;

        private UploadError(Tag tag, UploadWriteFailed value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * Unable to save the uploaded contents to a file.
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link UploadWriteFailed} value associated with this
         *     instance if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public UploadWriteFailed getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code UploadError} that has its tag set to
         * {@link Tag#PATH}.
         *
         * <p> Unable to save the uploaded contents to a file. </p>
         *
         * @param value  {@link UploadWriteFailed} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UploadError} with its tag set to {@link
         *     Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UploadError path(UploadWriteFailed value) {
            return new UploadError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * An unspecified error.
         */
        private static final UploadError OTHER_INSTANCE = new UploadError(Tag.OTHER);

        /**
         * Returns an instance of {@code UploadError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code UploadError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static UploadError other() {
            return UploadError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private UploadError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        UploadWriteFailed._writer.writeFields(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return UploadError.other(); }
                    switch (tag) {
                        case OTHER: return UploadError.other();
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
                        case PATH: {
                            UploadWriteFailed v = null;
                            v = UploadWriteFailed._reader.readFields(parser);
                            value = UploadError.path(v);
                            break;
                        }
                        case OTHER: {
                            value = UploadError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param correctOffset  The offset up to which data has been collected.
         */
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
            /**
             * The upload session id was not found.
             */
            NOT_FOUND,
            /**
             * The specified offset was incorrect. See the value for the correct
             * offset. (This error may occur when a previous request was
             * received and processed successfully but the client did not
             * receive the response, e.g. due to a network error.)
             */
            INCORRECT_OFFSET,  // UploadSessionOffsetError
            /**
             * You are attempting to append data to an upload session that has
             * alread been closed (i.e. committed).
             */
            CLOSED,
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code UploadSessionLookupError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The upload session id was not found.
         */
        private static final UploadSessionLookupError NOT_FOUND_INSTANCE = new UploadSessionLookupError(Tag.NOT_FOUND);

        /**
         * Returns an instance of {@code UploadSessionLookupError} that has its
         * tag set to {@link Tag#NOT_FOUND}.
         *
         * <p> The upload session id was not found. </p>
         *
         * @return Instance of {@code UploadSessionLookupError} with its tag set
         *     to {@link Tag#NOT_FOUND}.
         */
        public static UploadSessionLookupError notFound() {
            return UploadSessionLookupError.NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isNotFound() {
            return this.tag == Tag.NOT_FOUND;
        }

        private final UploadSessionOffsetError incorrectOffsetValue;

        private UploadSessionLookupError(Tag tag, UploadSessionOffsetError value) {
            this.tag = tag;
            this.incorrectOffsetValue = value;
            validate();
        }

        /**
         * The specified offset was incorrect. See the value for the correct
         * offset. (This error may occur when a previous request was received
         * and processed successfully but the client did not receive the
         * response, e.g. due to a network error.)
         *
         * <p> This instance must be tagged as {@link Tag#INCORRECT_OFFSET}.
         * </p>
         *
         * @return The {@link UploadSessionOffsetError} value associated with
         *     this instance if {@link #isIncorrectOffset} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isIncorrectOffset} is
         *     {@code false}.
         */
        public UploadSessionOffsetError getIncorrectOffsetValue() {
            if (this.tag != Tag.INCORRECT_OFFSET) {
                throw new IllegalStateException("getIncorrectOffsetValue() requires tag==INCORRECT_OFFSET, actual tag==" + tag);
            }
            return incorrectOffsetValue;
        }

        /**
         * Returns an instance of {@code UploadSessionLookupError} that has its
         * tag set to {@link Tag#INCORRECT_OFFSET}.
         *
         * <p> The specified offset was incorrect. See the value for the correct
         * offset. (This error may occur when a previous request was received
         * and processed successfully but the client did not receive the
         * response, e.g. due to a network error.) </p>
         *
         * @param value  {@link UploadSessionOffsetError} value to assign to
         *     this instance.
         *
         * @return Instance of {@code UploadSessionLookupError} with its tag set
         *     to {@link Tag#INCORRECT_OFFSET}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError value) {
            return new UploadSessionLookupError(Tag.INCORRECT_OFFSET, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INCORRECT_OFFSET}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INCORRECT_OFFSET}, {@code false} otherwise.
         */
        public boolean isIncorrectOffset() {
            return this.tag == Tag.INCORRECT_OFFSET;
        }

        /**
         * You are attempting to append data to an upload session that has
         * alread been closed (i.e. committed).
         */
        private static final UploadSessionLookupError CLOSED_INSTANCE = new UploadSessionLookupError(Tag.CLOSED);

        /**
         * Returns an instance of {@code UploadSessionLookupError} that has its
         * tag set to {@link Tag#CLOSED}.
         *
         * <p> You are attempting to append data to an upload session that has
         * alread been closed (i.e. committed). </p>
         *
         * @return Instance of {@code UploadSessionLookupError} with its tag set
         *     to {@link Tag#CLOSED}.
         */
        public static UploadSessionLookupError closed() {
            return UploadSessionLookupError.CLOSED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#CLOSED},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CLOSED}, {@code false} otherwise.
         */
        public boolean isClosed() {
            return this.tag == Tag.CLOSED;
        }

        /**
         * An unspecified error.
         */
        private static final UploadSessionLookupError OTHER_INSTANCE = new UploadSessionLookupError(Tag.OTHER);

        /**
         * Returns an instance of {@code UploadSessionLookupError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code UploadSessionLookupError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static UploadSessionLookupError other() {
            return UploadSessionLookupError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private UploadSessionLookupError(Tag t) {
            tag = t;
            incorrectOffsetValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NOT_FOUND:
                case CLOSED:
                case OTHER:
                    break;
                case INCORRECT_OFFSET:
                    if (this.incorrectOffsetValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_found");
                        g.writeEndObject();
                        break;
                    case INCORRECT_OFFSET:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("incorrect_offset");
                        UploadSessionOffsetError._writer.writeFields(x.incorrectOffsetValue, g);
                        g.writeEndObject();
                        break;
                    case CLOSED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("closed");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return UploadSessionLookupError.other(); }
                    switch (tag) {
                        case NOT_FOUND: return UploadSessionLookupError.notFound();
                        case CLOSED: return UploadSessionLookupError.closed();
                        case OTHER: return UploadSessionLookupError.other();
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
                        case NOT_FOUND: {
                            value = UploadSessionLookupError.notFound();
                            break;
                        }
                        case INCORRECT_OFFSET: {
                            UploadSessionOffsetError v = null;
                            v = UploadSessionOffsetError._reader.readFields(parser);
                            value = UploadSessionLookupError.incorrectOffset(v);
                            break;
                        }
                        case CLOSED: {
                            value = UploadSessionLookupError.closed();
                            break;
                        }
                        case OTHER: {
                            value = UploadSessionLookupError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadSessionLookupError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("not_found", Tag.NOT_FOUND);
            _values.put("incorrect_offset", Tag.INCORRECT_OFFSET);
            _values.put("closed", Tag.CLOSED);
            _values.put("other", Tag.OTHER);
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
            /**
             * The session arguments are incorrect; the value explains the
             * reason.
             */
            LOOKUP_FAILED,  // UploadSessionLookupError
            /**
             * Unable to save the uploaded contents to a file.
             */
            PATH,  // WriteError
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code UploadSessionFinishError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final UploadSessionLookupError lookupFailedValue;

        private UploadSessionFinishError(Tag tag, UploadSessionLookupError value) {
            this.tag = tag;
            this.lookupFailedValue = value;
            this.pathValue = null;
            validate();
        }

        /**
         * The session arguments are incorrect; the value explains the reason.
         *
         * <p> This instance must be tagged as {@link Tag#LOOKUP_FAILED}. </p>
         *
         * @return The {@link UploadSessionLookupError} value associated with
         *     this instance if {@link #isLookupFailed} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isLookupFailed} is {@code
         *     false}.
         */
        public UploadSessionLookupError getLookupFailedValue() {
            if (this.tag != Tag.LOOKUP_FAILED) {
                throw new IllegalStateException("getLookupFailedValue() requires tag==LOOKUP_FAILED, actual tag==" + tag);
            }
            return lookupFailedValue;
        }

        /**
         * Returns an instance of {@code UploadSessionFinishError} that has its
         * tag set to {@link Tag#LOOKUP_FAILED}.
         *
         * <p> The session arguments are incorrect; the value explains the
         * reason. </p>
         *
         * @param value  {@link UploadSessionLookupError} value to assign to
         *     this instance.
         *
         * @return Instance of {@code UploadSessionFinishError} with its tag set
         *     to {@link Tag#LOOKUP_FAILED}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UploadSessionFinishError lookupFailed(UploadSessionLookupError value) {
            return new UploadSessionFinishError(Tag.LOOKUP_FAILED, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#LOOKUP_FAILED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#LOOKUP_FAILED}, {@code false} otherwise.
         */
        public boolean isLookupFailed() {
            return this.tag == Tag.LOOKUP_FAILED;
        }

        private final WriteError pathValue;

        private UploadSessionFinishError(Tag tag, WriteError value) {
            this.tag = tag;
            this.lookupFailedValue = null;
            this.pathValue = value;
            validate();
        }

        /**
         * Unable to save the uploaded contents to a file.
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public WriteError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code UploadSessionFinishError} that has its
         * tag set to {@link Tag#PATH}.
         *
         * <p> Unable to save the uploaded contents to a file. </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code UploadSessionFinishError} with its tag set
         *     to {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UploadSessionFinishError path(WriteError value) {
            return new UploadSessionFinishError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * An unspecified error.
         */
        private static final UploadSessionFinishError OTHER_INSTANCE = new UploadSessionFinishError(Tag.OTHER);

        /**
         * Returns an instance of {@code UploadSessionFinishError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code UploadSessionFinishError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static UploadSessionFinishError other() {
            return UploadSessionFinishError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private UploadSessionFinishError(Tag t) {
            tag = t;
            lookupFailedValue = null;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case LOOKUP_FAILED:
                    if (this.lookupFailedValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case LOOKUP_FAILED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("lookup_failed");
                        g.writeFieldName("lookup_failed");
                        UploadSessionLookupError._writer.write(x.lookupFailedValue, g);
                        g.writeEndObject();
                        break;
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        WriteError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return UploadSessionFinishError.other(); }
                    switch (tag) {
                        case OTHER: return UploadSessionFinishError.other();
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
                        case LOOKUP_FAILED: {
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
                        case PATH: {
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
                        case OTHER: {
                            value = UploadSessionFinishError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UploadSessionFinishError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("lookup_failed", Tag.LOOKUP_FAILED);
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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
         * DbxFiles#uploadSessionAppendBuilder} and {@link
         * DbxFiles#uploadSessionFinishBuilder}.
         */
        public final String sessionId;

        /**
         *
         * @param sessionId  A unique identifier for the upload session. Pass
         *     this to {@link DbxFiles#uploadSessionAppendBuilder} and {@link
         *     DbxFiles#uploadSessionFinishBuilder}. {@code sessionId} must not
         *     be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UploadSessionStartResult(String sessionId) {
            this.sessionId = sessionId;
            if (sessionId == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
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
         * The upload session ID (returned by {@link
         * DbxFiles#uploadSessionStart}).
         */
        public final String sessionId;
        /**
         * The amount of data that has been uploaded so far. We use this to make
         * sure upload data isn't lost or duplicated in the event of a network
         * error.
         */
        public final long offset;

        /**
         *
         * @param sessionId  The upload session ID (returned by {@link
         *     DbxFiles#uploadSessionStart}). {@code sessionId} must not be
         *     {@code null}.
         * @param offset  The amount of data that has been uploaded so far. We
         *     use this to make sure upload data isn't lost or duplicated in the
         *     event of a network error.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UploadSessionCursor(String sessionId, long offset) {
            this.sessionId = sessionId;
            if (sessionId == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
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
            /**
             * Never overwrite the existing file. The autorename strategy is to
             * append a number to the file name. For example, "document.txt"
             * might become "document (2).txt".
             */
            ADD,
            /**
             * Always overwrite the existing file. The autorename strategy is
             * the same as it is for {@link WriteMode#add}.
             */
            OVERWRITE,
            /**
             * Overwrite if the given "rev" matches the existing file's "rev".
             * The autorename strategy is to append the string "conflicted copy"
             * to the file name. For example, "document.txt" might become
             * "document (conflicted copy).txt" or "document (Panda's conflicted
             * copy).txt".
             */
            UPDATE  // String
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code WriteMode}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Never overwrite the existing file. The autorename strategy is to
         * append a number to the file name. For example, "document.txt" might
         * become "document (2).txt".
         */
        private static final WriteMode ADD_INSTANCE = new WriteMode(Tag.ADD);

        /**
         * Returns an instance of {@code WriteMode} that has its tag set to
         * {@link Tag#ADD}.
         *
         * <p> Never overwrite the existing file. The autorename strategy is to
         * append a number to the file name. For example, "document.txt" might
         * become "document (2).txt". </p>
         *
         * @return Instance of {@code WriteMode} with its tag set to {@link
         *     Tag#ADD}.
         */
        public static WriteMode add() {
            return WriteMode.ADD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#ADD},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#ADD},
         *     {@code false} otherwise.
         */
        public boolean isAdd() {
            return this.tag == Tag.ADD;
        }

        /**
         * Always overwrite the existing file. The autorename strategy is the
         * same as it is for {@link WriteMode#add}.
         */
        private static final WriteMode OVERWRITE_INSTANCE = new WriteMode(Tag.OVERWRITE);

        /**
         * Returns an instance of {@code WriteMode} that has its tag set to
         * {@link Tag#OVERWRITE}.
         *
         * <p> Always overwrite the existing file. The autorename strategy is
         * the same as it is for {@link WriteMode#add}. </p>
         *
         * @return Instance of {@code WriteMode} with its tag set to {@link
         *     Tag#OVERWRITE}.
         */
        public static WriteMode overwrite() {
            return WriteMode.OVERWRITE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#OVERWRITE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#OVERWRITE}, {@code false} otherwise.
         */
        public boolean isOverwrite() {
            return this.tag == Tag.OVERWRITE;
        }

        private final String updateValue;

        private WriteMode(Tag tag, String value) {
            this.tag = tag;
            this.updateValue = value;
            validate();
        }

        /**
         * Overwrite if the given "rev" matches the existing file's "rev". The
         * autorename strategy is to append the string "conflicted copy" to the
         * file name. For example, "document.txt" might become "document
         * (conflicted copy).txt" or "document (Panda's conflicted copy).txt".
         *
         * <p> This instance must be tagged as {@link Tag#UPDATE}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isUpdate} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isUpdate} is {@code false}.
         */
        public String getUpdateValue() {
            if (this.tag != Tag.UPDATE) {
                throw new IllegalStateException("getUpdateValue() requires tag==UPDATE, actual tag==" + tag);
            }
            return updateValue;
        }

        /**
         * Returns an instance of {@code WriteMode} that has its tag set to
         * {@link Tag#UPDATE}.
         *
         * <p> Overwrite if the given "rev" matches the existing file's "rev".
         * The autorename strategy is to append the string "conflicted copy" to
         * the file name. For example, "document.txt" might become "document
         * (conflicted copy).txt" or "document (Panda's conflicted copy).txt".
         * </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code WriteMode} with its tag set to {@link
         *     Tag#UPDATE}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 9,
         *     does not match pattern "{@code [0-9a-f]+}", or is {@code null}.
         */
        public static WriteMode update(String value) {
            return new WriteMode(Tag.UPDATE, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#UPDATE},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UPDATE}, {@code false} otherwise.
         */
        public boolean isUpdate() {
            return this.tag == Tag.UPDATE;
        }

        private WriteMode(Tag t) {
            tag = t;
            updateValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case ADD:
                case OVERWRITE:
                    break;
                case UPDATE:
                    if (this.updateValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.updateValue.length() < 9) {
                        throw new IllegalArgumentException("String is shorter than 9");
                    }
                    if (!java.util.regex.Pattern.matches("[0-9a-f]+", this.updateValue)) {
                        throw new IllegalArgumentException("String does not match pattern");
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
                    case ADD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("add");
                        g.writeEndObject();
                        break;
                    case OVERWRITE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("overwrite");
                        g.writeEndObject();
                        break;
                    case UPDATE:
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
                        case ADD: return WriteMode.add();
                        case OVERWRITE: return WriteMode.overwrite();
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
                        case ADD: {
                            value = WriteMode.add();
                            break;
                        }
                        case OVERWRITE: {
                            value = WriteMode.overwrite();
                            break;
                        }
                        case UPDATE: {
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
            _values.put("add", Tag.ADD);
            _values.put("overwrite", Tag.OVERWRITE);
            _values.put("update", Tag.UPDATE);
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
         * If there's a conflict, as determined by {@link CommitInfo#mode}, have
         * the Dropbox server try to autorename the file to avoid conflict.
         */
        public final boolean autorename;
        /**
         * The value to store as the {@link CommitInfo#clientModified}
         * timestamp. Dropbox automatically records the time at which the file
         * was written to the Dropbox servers. It can also record an additional
         * timestamp, provided by Dropbox desktop clients, mobile clients, and
         * API apps of when the file was actually created or modified.
         */
        public final java.util.Date clientModified;
        /**
         * Normally, users are made aware of any file modifications in their
         * Dropbox account via notifications in the client software. If {@code
         * true}, this tells the clients that this modification shouldn't result
         * in a user notification.
         */
        public final boolean mute;

        /**
         *
         * @param path  Path in the user's Dropbox to save the file. {@code
         *     path} must match pattern "{@code /.*}" and not be {@code null}.
         * @param mode  Selects what to do if the file already exists.
         * @param autorename  If there's a conflict, as determined by {@code
         *     mode}, have the Dropbox server try to autorename the file to
         *     avoid conflict.
         * @param clientModified  The value to store as the {@code
         *     clientModified} timestamp. Dropbox automatically records the time
         *     at which the file was written to the Dropbox servers. It can also
         *     record an additional timestamp, provided by Dropbox desktop
         *     clients, mobile clients, and API apps of when the file was
         *     actually created or modified.
         * @param mute  Normally, users are made aware of any file modifications
         *     in their Dropbox account via notifications in the client
         *     software. If {@code true}, this tells the clients that this
         *     modification shouldn't result in a user notification.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public CommitInfo(String path, WriteMode mode, Boolean autorename, java.util.Date clientModified, Boolean mute) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = WriteMode.add();
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

        /**
         *
         * @param cursor  Contains the upload session ID and the offset. {@code
         *     cursor} must not be {@code null}.
         * @param commit  Contains the path and other optional modifiers for the
         *     commit. {@code commit} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UploadSessionFinishArg(UploadSessionCursor cursor, CommitInfo commit) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            this.commit = commit;
            if (commit == null) {
                throw new IllegalArgumentException("Required value for 'commit' is null");
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


    public static final class SearchMode {
        // union SearchMode

        /**
         * The discriminating tag type for {@link SearchMode}.
         */
        public enum Tag {
            /**
             * Search file and folder names.
             */
            FILENAME,
            /**
             * Search file and folder names as well as file contents.
             */
            FILENAME_AND_CONTENT,
            /**
             * Search for deleted file and folder names.
             */
            DELETED_FILENAME
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code SearchMode}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Search file and folder names.
         */
        private static final SearchMode FILENAME_INSTANCE = new SearchMode(Tag.FILENAME);

        /**
         * Returns an instance of {@code SearchMode} that has its tag set to
         * {@link Tag#FILENAME}.
         *
         * <p> Search file and folder names. </p>
         *
         * @return Instance of {@code SearchMode} with its tag set to {@link
         *     Tag#FILENAME}.
         */
        public static SearchMode filename() {
            return SearchMode.FILENAME_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FILENAME}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FILENAME}, {@code false} otherwise.
         */
        public boolean isFilename() {
            return this.tag == Tag.FILENAME;
        }

        /**
         * Search file and folder names as well as file contents.
         */
        private static final SearchMode FILENAME_AND_CONTENT_INSTANCE = new SearchMode(Tag.FILENAME_AND_CONTENT);

        /**
         * Returns an instance of {@code SearchMode} that has its tag set to
         * {@link Tag#FILENAME_AND_CONTENT}.
         *
         * <p> Search file and folder names as well as file contents. </p>
         *
         * @return Instance of {@code SearchMode} with its tag set to {@link
         *     Tag#FILENAME_AND_CONTENT}.
         */
        public static SearchMode filenameAndContent() {
            return SearchMode.FILENAME_AND_CONTENT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FILENAME_AND_CONTENT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FILENAME_AND_CONTENT}, {@code false} otherwise.
         */
        public boolean isFilenameAndContent() {
            return this.tag == Tag.FILENAME_AND_CONTENT;
        }

        /**
         * Search for deleted file and folder names.
         */
        private static final SearchMode DELETED_FILENAME_INSTANCE = new SearchMode(Tag.DELETED_FILENAME);

        /**
         * Returns an instance of {@code SearchMode} that has its tag set to
         * {@link Tag#DELETED_FILENAME}.
         *
         * <p> Search for deleted file and folder names. </p>
         *
         * @return Instance of {@code SearchMode} with its tag set to {@link
         *     Tag#DELETED_FILENAME}.
         */
        public static SearchMode deletedFilename() {
            return SearchMode.DELETED_FILENAME_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#DELETED_FILENAME}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#DELETED_FILENAME}, {@code false} otherwise.
         */
        public boolean isDeletedFilename() {
            return this.tag == Tag.DELETED_FILENAME;
        }

        private SearchMode(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FILENAME:
                case FILENAME_AND_CONTENT:
                case DELETED_FILENAME:
                    break;
            }
        }

        static final JsonWriter<SearchMode> _writer = new JsonWriter<SearchMode>()
        {
            public final void write(SearchMode x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case FILENAME:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename");
                        g.writeEndObject();
                        break;
                    case FILENAME_AND_CONTENT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename_and_content");
                        g.writeEndObject();
                        break;
                    case DELETED_FILENAME:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case FILENAME: return SearchMode.filename();
                        case FILENAME_AND_CONTENT: return SearchMode.filenameAndContent();
                        case DELETED_FILENAME: return SearchMode.deletedFilename();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SearchMode value = null;
                if (tag != null) {
                    switch (tag) {
                        case FILENAME: {
                            value = SearchMode.filename();
                            break;
                        }
                        case FILENAME_AND_CONTENT: {
                            value = SearchMode.filenameAndContent();
                            break;
                        }
                        case DELETED_FILENAME: {
                            value = SearchMode.deletedFilename();
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
            _values.put("filename", Tag.FILENAME);
            _values.put("filename_and_content", Tag.FILENAME_AND_CONTENT);
            _values.put("deleted_filename", Tag.DELETED_FILENAME);
        }

        public String toString() {
            return "SearchMode." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchMode." +  _writer.writeToString(this, true);
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
         * deleted_filename). Note that searching file content is only available
         * for Dropbox Business accounts.
         */
        public final SearchMode mode;

        /**
         *
         * @param path  The path in the user's Dropbox to search. Should
         *     probably be a folder. {@code path} must match pattern "{@code
         *     (/.*)?}" and not be {@code null}.
         * @param query  The string to search for. The search string is split on
         *     spaces into multiple tokens. For file name searching, the last
         *     token is used for prefix matching (i.e. "bat c" matches "bat
         *     cave" but not "batman car"). {@code query} must not be {@code
         *     null}.
         * @param start  The starting index within the search results (used for
         *     paging).
         * @param maxResults  The maximum number of search results to return.
         *     {@code maxResults} must be greater than or equal to 1 and be less
         *     than or equal to 1000.
         * @param mode  The search mode (filename, filename_and_content, or
         *     deleted_filename). Note that searching file content is only
         *     available for Dropbox Business accounts.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SearchArg(String path, String query, Long start, Long maxResults, SearchMode mode) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.query = query;
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
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
                throw new IllegalArgumentException("Number 'this.maxResults' is smaller than 1L");
            }
            if (this.maxResults > 1000L) {
                throw new IllegalArgumentException("Number 'this.maxResults' is larger than 1000L");
            }
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = SearchMode.filename();
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
    public static final class SearchMatchType {
        // union SearchMatchType

        /**
         * The discriminating tag type for {@link SearchMatchType}.
         */
        public enum Tag {
            /**
             * This item was matched on its file or folder name.
             */
            FILENAME,
            /**
             * This item was matched based on its file contents.
             */
            CONTENT,
            /**
             * This item was matched based on both its contents and its file
             * name.
             */
            BOTH
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code SearchMatchType}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * This item was matched on its file or folder name.
         */
        private static final SearchMatchType FILENAME_INSTANCE = new SearchMatchType(Tag.FILENAME);

        /**
         * Returns an instance of {@code SearchMatchType} that has its tag set
         * to {@link Tag#FILENAME}.
         *
         * <p> This item was matched on its file or folder name. </p>
         *
         * @return Instance of {@code SearchMatchType} with its tag set to
         *     {@link Tag#FILENAME}.
         */
        public static SearchMatchType filename() {
            return SearchMatchType.FILENAME_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FILENAME}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FILENAME}, {@code false} otherwise.
         */
        public boolean isFilename() {
            return this.tag == Tag.FILENAME;
        }

        /**
         * This item was matched based on its file contents.
         */
        private static final SearchMatchType CONTENT_INSTANCE = new SearchMatchType(Tag.CONTENT);

        /**
         * Returns an instance of {@code SearchMatchType} that has its tag set
         * to {@link Tag#CONTENT}.
         *
         * <p> This item was matched based on its file contents. </p>
         *
         * @return Instance of {@code SearchMatchType} with its tag set to
         *     {@link Tag#CONTENT}.
         */
        public static SearchMatchType content() {
            return SearchMatchType.CONTENT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CONTENT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CONTENT}, {@code false} otherwise.
         */
        public boolean isContent() {
            return this.tag == Tag.CONTENT;
        }

        /**
         * This item was matched based on both its contents and its file name.
         */
        private static final SearchMatchType BOTH_INSTANCE = new SearchMatchType(Tag.BOTH);

        /**
         * Returns an instance of {@code SearchMatchType} that has its tag set
         * to {@link Tag#BOTH}.
         *
         * <p> This item was matched based on both its contents and its file
         * name. </p>
         *
         * @return Instance of {@code SearchMatchType} with its tag set to
         *     {@link Tag#BOTH}.
         */
        public static SearchMatchType both() {
            return SearchMatchType.BOTH_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#BOTH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#BOTH},
         *     {@code false} otherwise.
         */
        public boolean isBoth() {
            return this.tag == Tag.BOTH;
        }

        private SearchMatchType(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FILENAME:
                case CONTENT:
                case BOTH:
                    break;
            }
        }

        static final JsonWriter<SearchMatchType> _writer = new JsonWriter<SearchMatchType>()
        {
            public final void write(SearchMatchType x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case FILENAME:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("filename");
                        g.writeEndObject();
                        break;
                    case CONTENT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("content");
                        g.writeEndObject();
                        break;
                    case BOTH:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case FILENAME: return SearchMatchType.filename();
                        case CONTENT: return SearchMatchType.content();
                        case BOTH: return SearchMatchType.both();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SearchMatchType value = null;
                if (tag != null) {
                    switch (tag) {
                        case FILENAME: {
                            value = SearchMatchType.filename();
                            break;
                        }
                        case CONTENT: {
                            value = SearchMatchType.content();
                            break;
                        }
                        case BOTH: {
                            value = SearchMatchType.both();
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
            _values.put("filename", Tag.FILENAME);
            _values.put("content", Tag.CONTENT);
            _values.put("both", Tag.BOTH);
        }

        public String toString() {
            return "SearchMatchType." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SearchMatchType." +  _writer.writeToString(this, true);
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

        /**
         *
         * @param matchType  The type of the match. {@code matchType} must not
         *     be {@code null}.
         * @param metadata  The metadata for the matched file or folder. {@code
         *     metadata} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SearchMatch(SearchMatchType matchType, Metadata metadata) {
            this.matchType = matchType;
            if (matchType == null) {
                throw new IllegalArgumentException("Required value for 'matchType' is null");
            }
            this.metadata = metadata;
            if (metadata == null) {
                throw new IllegalArgumentException("Required value for 'metadata' is null");
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
        public final java.util.List<SearchMatch> matches;
        /**
         * Used for paging. If true, indicates there is another page of results
         * available that can be fetched by calling {@link
         * DbxFiles#searchBuilder} again.
         */
        public final boolean more;
        /**
         * Used for paging. Value to set the start argument to when calling
         * {@link DbxFiles#searchBuilder} to fetch the next page of results.
         */
        public final long start;

        /**
         *
         * @param matches  A list (possibly empty) of matches for the query.
         *     {@code matches} must not contain a {@code null} item and not be
         *     {@code null}.
         * @param more  Used for paging. If true, indicates there is another
         *     page of results available that can be fetched by calling {@link
         *     DbxFiles#searchBuilder} again.
         * @param start  Used for paging. Value to set the start argument to
         *     when calling {@link DbxFiles#searchBuilder} to fetch the next
         *     page of results.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SearchResult(java.util.List<SearchMatch> matches, boolean more, long start) {
            this.matches = matches;
            if (matches == null) {
                throw new IllegalArgumentException("Required value for 'matches' is null");
            }
            for (SearchMatch x : matches) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'matches' is null");
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
                java.util.List<SearchMatch> matches = null;
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
            PATH,  // LookupError
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code SearchError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private SearchError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code SearchError} that has its tag set to
         * {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code SearchError} with its tag set to {@link
         *     Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static SearchError path(LookupError value) {
            return new SearchError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * An unspecified error.
         */
        private static final SearchError OTHER_INSTANCE = new SearchError(Tag.OTHER);

        /**
         * Returns an instance of {@code SearchError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code SearchError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static SearchError other() {
            return SearchError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private SearchError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return SearchError.other(); }
                    switch (tag) {
                        case OTHER: return SearchError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = SearchError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SearchError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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
            MALFORMED_PATH,  // Nullable
            /**
             * There is nothing at the given path.
             */
            NOT_FOUND,
            /**
             * We were expecting a file, but the given path refers to something
             * that isn't a file.
             */
            NOT_FILE,
            /**
             * We were expecting a folder, but the given path refers to
             * something that isn't a folder.
             */
            NOT_FOLDER,
            /**
             * The file cannot be transferred because the content is restricted.
             * For example, sometimes there are legal restrictions due to
             * copyright claims.
             */
            RESTRICTED_CONTENT,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code LookupError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String malformedPathValue;

        private LookupError(Tag tag, String value) {
            this.tag = tag;
            this.malformedPathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#MALFORMED_PATH}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isMalformedPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
         *     false}.
         */
        public String getMalformedPathValue() {
            if (this.tag != Tag.MALFORMED_PATH) {
                throw new IllegalStateException("getMalformedPathValue() requires tag==MALFORMED_PATH, actual tag==" + tag);
            }
            return malformedPathValue;
        }

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#MALFORMED_PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#MALFORMED_PATH}.
         */
        public static LookupError malformedPath(String value) {
            return new LookupError(Tag.MALFORMED_PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MALFORMED_PATH}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MALFORMED_PATH}, {@code false} otherwise.
         */
        public boolean isMalformedPath() {
            return this.tag == Tag.MALFORMED_PATH;
        }

        /**
         * There is nothing at the given path.
         */
        private static final LookupError NOT_FOUND_INSTANCE = new LookupError(Tag.NOT_FOUND);

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#NOT_FOUND}.
         *
         * <p> There is nothing at the given path. </p>
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#NOT_FOUND}.
         */
        public static LookupError notFound() {
            return LookupError.NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isNotFound() {
            return this.tag == Tag.NOT_FOUND;
        }

        /**
         * We were expecting a file, but the given path refers to something that
         * isn't a file.
         */
        private static final LookupError NOT_FILE_INSTANCE = new LookupError(Tag.NOT_FILE);

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#NOT_FILE}.
         *
         * <p> We were expecting a file, but the given path refers to something
         * that isn't a file. </p>
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#NOT_FILE}.
         */
        public static LookupError notFile() {
            return LookupError.NOT_FILE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_FILE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_FILE}, {@code false} otherwise.
         */
        public boolean isNotFile() {
            return this.tag == Tag.NOT_FILE;
        }

        /**
         * We were expecting a folder, but the given path refers to something
         * that isn't a folder.
         */
        private static final LookupError NOT_FOLDER_INSTANCE = new LookupError(Tag.NOT_FOLDER);

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#NOT_FOLDER}.
         *
         * <p> We were expecting a folder, but the given path refers to
         * something that isn't a folder. </p>
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#NOT_FOLDER}.
         */
        public static LookupError notFolder() {
            return LookupError.NOT_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_FOLDER}, {@code false} otherwise.
         */
        public boolean isNotFolder() {
            return this.tag == Tag.NOT_FOLDER;
        }

        /**
         * The file cannot be transferred because the content is restricted.
         * For example, sometimes there are legal restrictions due to copyright
         * claims.
         */
        private static final LookupError RESTRICTED_CONTENT_INSTANCE = new LookupError(Tag.RESTRICTED_CONTENT);

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#RESTRICTED_CONTENT}.
         *
         * <p> The file cannot be transferred because the content is restricted.
         * For example, sometimes there are legal restrictions due to copyright
         * claims. </p>
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#RESTRICTED_CONTENT}.
         */
        public static LookupError restrictedContent() {
            return LookupError.RESTRICTED_CONTENT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
         */
        public boolean isRestrictedContent() {
            return this.tag == Tag.RESTRICTED_CONTENT;
        }

        private static final LookupError OTHER_INSTANCE = new LookupError(Tag.OTHER);

        /**
         * Returns an instance of {@code LookupError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code LookupError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static LookupError other() {
            return LookupError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private LookupError(Tag t) {
            tag = t;
            malformedPathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NOT_FOUND:
                case NOT_FILE:
                case NOT_FOLDER:
                case RESTRICTED_CONTENT:
                case OTHER:
                    break;
                case MALFORMED_PATH:
                    break;
            }
        }

        static final JsonWriter<LookupError> _writer = new JsonWriter<LookupError>()
        {
            public final void write(LookupError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case MALFORMED_PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("malformed_path");
                        if (x.malformedPathValue != null) {
                            g.writeFieldName("malformed_path");
                            g.writeString(x.malformedPathValue);
                        }
                        g.writeEndObject();
                        break;
                    case NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_found");
                        g.writeEndObject();
                        break;
                    case NOT_FILE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_file");
                        g.writeEndObject();
                        break;
                    case NOT_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_folder");
                        g.writeEndObject();
                        break;
                    case RESTRICTED_CONTENT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("restricted_content");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return LookupError.other(); }
                    switch (tag) {
                        case MALFORMED_PATH: return LookupError.malformedPath(null);
                        case NOT_FOUND: return LookupError.notFound();
                        case NOT_FILE: return LookupError.notFile();
                        case NOT_FOLDER: return LookupError.notFolder();
                        case RESTRICTED_CONTENT: return LookupError.restrictedContent();
                        case OTHER: return LookupError.other();
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
                        case MALFORMED_PATH: {
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
                        case NOT_FOUND: {
                            value = LookupError.notFound();
                            break;
                        }
                        case NOT_FILE: {
                            value = LookupError.notFile();
                            break;
                        }
                        case NOT_FOLDER: {
                            value = LookupError.notFolder();
                            break;
                        }
                        case RESTRICTED_CONTENT: {
                            value = LookupError.restrictedContent();
                            break;
                        }
                        case OTHER: {
                            value = LookupError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return LookupError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("malformed_path", Tag.MALFORMED_PATH);
            _values.put("not_found", Tag.NOT_FOUND);
            _values.put("not_file", Tag.NOT_FILE);
            _values.put("not_folder", Tag.NOT_FOLDER);
            _values.put("restricted_content", Tag.RESTRICTED_CONTENT);
            _values.put("other", Tag.OTHER);
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
            MALFORMED_PATH,  // Nullable
            /**
             * Couldn't write to the target path because there was something in
             * the way.
             */
            CONFLICT,  // WriteConflictError
            /**
             * The user doesn't have permissions to write to the target
             * location.
             */
            NO_WRITE_PERMISSION,
            /**
             * The user doesn't have enough available space (bytes) to write
             * more data.
             */
            INSUFFICIENT_SPACE,
            /**
             * Dropbox will not save the file or folder because of its name.
             */
            DISALLOWED_NAME,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code WriteError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String malformedPathValue;

        private WriteError(Tag tag, String value) {
            this.tag = tag;
            this.malformedPathValue = value;
            this.conflictValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#MALFORMED_PATH}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isMalformedPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
         *     false}.
         */
        public String getMalformedPathValue() {
            if (this.tag != Tag.MALFORMED_PATH) {
                throw new IllegalStateException("getMalformedPathValue() requires tag==MALFORMED_PATH, actual tag==" + tag);
            }
            return malformedPathValue;
        }

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#MALFORMED_PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#MALFORMED_PATH}.
         */
        public static WriteError malformedPath(String value) {
            return new WriteError(Tag.MALFORMED_PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MALFORMED_PATH}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MALFORMED_PATH}, {@code false} otherwise.
         */
        public boolean isMalformedPath() {
            return this.tag == Tag.MALFORMED_PATH;
        }

        private final WriteConflictError conflictValue;

        private WriteError(Tag tag, WriteConflictError value) {
            this.tag = tag;
            this.malformedPathValue = null;
            this.conflictValue = value;
            validate();
        }

        /**
         * Couldn't write to the target path because there was something in the
         * way.
         *
         * <p> This instance must be tagged as {@link Tag#CONFLICT}. </p>
         *
         * @return The {@link WriteConflictError} value associated with this
         *     instance if {@link #isConflict} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isConflict} is {@code
         *     false}.
         */
        public WriteConflictError getConflictValue() {
            if (this.tag != Tag.CONFLICT) {
                throw new IllegalStateException("getConflictValue() requires tag==CONFLICT, actual tag==" + tag);
            }
            return conflictValue;
        }

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#CONFLICT}.
         *
         * <p> Couldn't write to the target path because there was something in
         * the way. </p>
         *
         * @param value  {@link WriteConflictError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#CONFLICT}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static WriteError conflict(WriteConflictError value) {
            return new WriteError(Tag.CONFLICT, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CONFLICT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CONFLICT}, {@code false} otherwise.
         */
        public boolean isConflict() {
            return this.tag == Tag.CONFLICT;
        }

        /**
         * The user doesn't have permissions to write to the target location.
         */
        private static final WriteError NO_WRITE_PERMISSION_INSTANCE = new WriteError(Tag.NO_WRITE_PERMISSION);

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#NO_WRITE_PERMISSION}.
         *
         * <p> The user doesn't have permissions to write to the target
         * location. </p>
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#NO_WRITE_PERMISSION}.
         */
        public static WriteError noWritePermission() {
            return WriteError.NO_WRITE_PERMISSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
         */
        public boolean isNoWritePermission() {
            return this.tag == Tag.NO_WRITE_PERMISSION;
        }

        /**
         * The user doesn't have enough available space (bytes) to write more
         * data.
         */
        private static final WriteError INSUFFICIENT_SPACE_INSTANCE = new WriteError(Tag.INSUFFICIENT_SPACE);

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#INSUFFICIENT_SPACE}.
         *
         * <p> The user doesn't have enough available space (bytes) to write
         * more data. </p>
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#INSUFFICIENT_SPACE}.
         */
        public static WriteError insufficientSpace() {
            return WriteError.INSUFFICIENT_SPACE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
         */
        public boolean isInsufficientSpace() {
            return this.tag == Tag.INSUFFICIENT_SPACE;
        }

        /**
         * Dropbox will not save the file or folder because of its name.
         */
        private static final WriteError DISALLOWED_NAME_INSTANCE = new WriteError(Tag.DISALLOWED_NAME);

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#DISALLOWED_NAME}.
         *
         * <p> Dropbox will not save the file or folder because of its name.
         * </p>
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#DISALLOWED_NAME}.
         */
        public static WriteError disallowedName() {
            return WriteError.DISALLOWED_NAME_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#DISALLOWED_NAME}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#DISALLOWED_NAME}, {@code false} otherwise.
         */
        public boolean isDisallowedName() {
            return this.tag == Tag.DISALLOWED_NAME;
        }

        private static final WriteError OTHER_INSTANCE = new WriteError(Tag.OTHER);

        /**
         * Returns an instance of {@code WriteError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code WriteError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static WriteError other() {
            return WriteError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private WriteError(Tag t) {
            tag = t;
            malformedPathValue = null;
            conflictValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NO_WRITE_PERMISSION:
                case INSUFFICIENT_SPACE:
                case DISALLOWED_NAME:
                case OTHER:
                    break;
                case MALFORMED_PATH:
                    break;
                case CONFLICT:
                    if (this.conflictValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case MALFORMED_PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("malformed_path");
                        if (x.malformedPathValue != null) {
                            g.writeFieldName("malformed_path");
                            g.writeString(x.malformedPathValue);
                        }
                        g.writeEndObject();
                        break;
                    case CONFLICT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("conflict");
                        g.writeFieldName("conflict");
                        WriteConflictError._writer.write(x.conflictValue, g);
                        g.writeEndObject();
                        break;
                    case NO_WRITE_PERMISSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_write_permission");
                        g.writeEndObject();
                        break;
                    case INSUFFICIENT_SPACE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_space");
                        g.writeEndObject();
                        break;
                    case DISALLOWED_NAME:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("disallowed_name");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return WriteError.other(); }
                    switch (tag) {
                        case MALFORMED_PATH: return WriteError.malformedPath(null);
                        case NO_WRITE_PERMISSION: return WriteError.noWritePermission();
                        case INSUFFICIENT_SPACE: return WriteError.insufficientSpace();
                        case DISALLOWED_NAME: return WriteError.disallowedName();
                        case OTHER: return WriteError.other();
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
                        case MALFORMED_PATH: {
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
                        case CONFLICT: {
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
                        case NO_WRITE_PERMISSION: {
                            value = WriteError.noWritePermission();
                            break;
                        }
                        case INSUFFICIENT_SPACE: {
                            value = WriteError.insufficientSpace();
                            break;
                        }
                        case DISALLOWED_NAME: {
                            value = WriteError.disallowedName();
                            break;
                        }
                        case OTHER: {
                            value = WriteError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return WriteError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("malformed_path", Tag.MALFORMED_PATH);
            _values.put("conflict", Tag.CONFLICT);
            _values.put("no_write_permission", Tag.NO_WRITE_PERMISSION);
            _values.put("insufficient_space", Tag.INSUFFICIENT_SPACE);
            _values.put("disallowed_name", Tag.DISALLOWED_NAME);
            _values.put("other", Tag.OTHER);
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


    public static final class WriteConflictError {
        // union WriteConflictError

        /**
         * The discriminating tag type for {@link WriteConflictError}.
         */
        public enum Tag {
            /**
             * There's a file in the way.
             */
            FILE,
            /**
             * There's a folder in the way.
             */
            FOLDER,
            /**
             * There's a file at an ancestor path, so we couldn't create the
             * required parent folders.
             */
            FILE_ANCESTOR,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code WriteConflictError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * There's a file in the way.
         */
        private static final WriteConflictError FILE_INSTANCE = new WriteConflictError(Tag.FILE);

        /**
         * Returns an instance of {@code WriteConflictError} that has its tag
         * set to {@link Tag#FILE}.
         *
         * <p> There's a file in the way. </p>
         *
         * @return Instance of {@code WriteConflictError} with its tag set to
         *     {@link Tag#FILE}.
         */
        public static WriteConflictError file() {
            return WriteConflictError.FILE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#FILE},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#FILE},
         *     {@code false} otherwise.
         */
        public boolean isFile() {
            return this.tag == Tag.FILE;
        }

        /**
         * There's a folder in the way.
         */
        private static final WriteConflictError FOLDER_INSTANCE = new WriteConflictError(Tag.FOLDER);

        /**
         * Returns an instance of {@code WriteConflictError} that has its tag
         * set to {@link Tag#FOLDER}.
         *
         * <p> There's a folder in the way. </p>
         *
         * @return Instance of {@code WriteConflictError} with its tag set to
         *     {@link Tag#FOLDER}.
         */
        public static WriteConflictError folder() {
            return WriteConflictError.FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#FOLDER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FOLDER}, {@code false} otherwise.
         */
        public boolean isFolder() {
            return this.tag == Tag.FOLDER;
        }

        /**
         * There's a file at an ancestor path, so we couldn't create the
         * required parent folders.
         */
        private static final WriteConflictError FILE_ANCESTOR_INSTANCE = new WriteConflictError(Tag.FILE_ANCESTOR);

        /**
         * Returns an instance of {@code WriteConflictError} that has its tag
         * set to {@link Tag#FILE_ANCESTOR}.
         *
         * <p> There's a file at an ancestor path, so we couldn't create the
         * required parent folders. </p>
         *
         * @return Instance of {@code WriteConflictError} with its tag set to
         *     {@link Tag#FILE_ANCESTOR}.
         */
        public static WriteConflictError fileAncestor() {
            return WriteConflictError.FILE_ANCESTOR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FILE_ANCESTOR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FILE_ANCESTOR}, {@code false} otherwise.
         */
        public boolean isFileAncestor() {
            return this.tag == Tag.FILE_ANCESTOR;
        }

        private static final WriteConflictError OTHER_INSTANCE = new WriteConflictError(Tag.OTHER);

        /**
         * Returns an instance of {@code WriteConflictError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code WriteConflictError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static WriteConflictError other() {
            return WriteConflictError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private WriteConflictError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FILE:
                case FOLDER:
                case FILE_ANCESTOR:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<WriteConflictError> _writer = new JsonWriter<WriteConflictError>()
        {
            public final void write(WriteConflictError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case FILE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("file");
                        g.writeEndObject();
                        break;
                    case FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("folder");
                        g.writeEndObject();
                        break;
                    case FILE_ANCESTOR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("file_ancestor");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return WriteConflictError.other(); }
                    switch (tag) {
                        case FILE: return WriteConflictError.file();
                        case FOLDER: return WriteConflictError.folder();
                        case FILE_ANCESTOR: return WriteConflictError.fileAncestor();
                        case OTHER: return WriteConflictError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                WriteConflictError value = null;
                if (tag != null) {
                    switch (tag) {
                        case FILE: {
                            value = WriteConflictError.file();
                            break;
                        }
                        case FOLDER: {
                            value = WriteConflictError.folder();
                            break;
                        }
                        case FILE_ANCESTOR: {
                            value = WriteConflictError.fileAncestor();
                            break;
                        }
                        case OTHER: {
                            value = WriteConflictError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return WriteConflictError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("file", Tag.FILE);
            _values.put("folder", Tag.FOLDER);
            _values.put("file_ancestor", Tag.FILE_ANCESTOR);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "WriteConflictError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "WriteConflictError." +  _writer.writeToString(this, true);
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

        /**
         *
         * @param path  Path in the user's Dropbox to create. {@code path} must
         *     match pattern "{@code /.*}" and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public CreateFolderArg(String path) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
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
            PATH  // WriteError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code CreateFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final WriteError pathValue;

        private CreateFolderError(Tag tag, WriteError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public WriteError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code CreateFolderError} that has its tag set
         * to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code CreateFolderError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static CreateFolderError path(WriteError value) {
            return new CreateFolderError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }


        private final void validate() {
            switch (this.tag) {
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
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
                        case PATH: {
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
            _values.put("path", Tag.PATH);
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

        /**
         *
         * @param path  Path in the user's Dropbox to delete. {@code path} must
         *     match pattern "{@code /.*}" and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public DeleteArg(String path) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
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
            PATH_LOOKUP,  // LookupError
            PATH_WRITE,  // WriteError
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code DeleteError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathLookupValue;

        private DeleteError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathLookupValue = value;
            this.pathWriteValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPathLookup} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPathLookup} is {@code
         *     false}.
         */
        public LookupError getPathLookupValue() {
            if (this.tag != Tag.PATH_LOOKUP) {
                throw new IllegalStateException("getPathLookupValue() requires tag==PATH_LOOKUP, actual tag==" + tag);
            }
            return pathLookupValue;
        }

        /**
         * Returns an instance of {@code DeleteError} that has its tag set to
         * {@link Tag#PATH_LOOKUP}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code DeleteError} with its tag set to {@link
         *     Tag#PATH_LOOKUP}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static DeleteError pathLookup(LookupError value) {
            return new DeleteError(Tag.PATH_LOOKUP, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PATH_LOOKUP}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PATH_LOOKUP}, {@code false} otherwise.
         */
        public boolean isPathLookup() {
            return this.tag == Tag.PATH_LOOKUP;
        }

        private final WriteError pathWriteValue;

        private DeleteError(Tag tag, WriteError value) {
            this.tag = tag;
            this.pathLookupValue = null;
            this.pathWriteValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH_WRITE}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isPathWrite} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPathWrite} is {@code
         *     false}.
         */
        public WriteError getPathWriteValue() {
            if (this.tag != Tag.PATH_WRITE) {
                throw new IllegalStateException("getPathWriteValue() requires tag==PATH_WRITE, actual tag==" + tag);
            }
            return pathWriteValue;
        }

        /**
         * Returns an instance of {@code DeleteError} that has its tag set to
         * {@link Tag#PATH_WRITE}.
         *
         * <p> None </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code DeleteError} with its tag set to {@link
         *     Tag#PATH_WRITE}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static DeleteError pathWrite(WriteError value) {
            return new DeleteError(Tag.PATH_WRITE, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PATH_WRITE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PATH_WRITE}, {@code false} otherwise.
         */
        public boolean isPathWrite() {
            return this.tag == Tag.PATH_WRITE;
        }

        private static final DeleteError OTHER_INSTANCE = new DeleteError(Tag.OTHER);

        /**
         * Returns an instance of {@code DeleteError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code DeleteError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static DeleteError other() {
            return DeleteError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private DeleteError(Tag t) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH_LOOKUP:
                    if (this.pathLookupValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case PATH_WRITE:
                    if (this.pathWriteValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH_LOOKUP:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_lookup");
                        g.writeFieldName("path_lookup");
                        LookupError._writer.write(x.pathLookupValue, g);
                        g.writeEndObject();
                        break;
                    case PATH_WRITE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_write");
                        g.writeFieldName("path_write");
                        WriteError._writer.write(x.pathWriteValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return DeleteError.other(); }
                    switch (tag) {
                        case OTHER: return DeleteError.other();
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
                        case PATH_LOOKUP: {
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
                        case PATH_WRITE: {
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
                        case OTHER: {
                            value = DeleteError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return DeleteError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path_lookup", Tag.PATH_LOOKUP);
            _values.put("path_write", Tag.PATH_WRITE);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param fromPath  Path in the user's Dropbox to be copied or moved.
         *     {@code fromPath} must match pattern "{@code /.*}" and not be
         *     {@code null}.
         * @param toPath  Path in the user's Dropbox that is the destination.
         *     {@code toPath} must match pattern "{@code /.*}" and not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public RelocationArg(String fromPath, String toPath) {
            this.fromPath = fromPath;
            if (fromPath == null) {
                throw new IllegalArgumentException("Required value for 'fromPath' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", fromPath)) {
                throw new IllegalArgumentException("String 'fromPath' does not match pattern");
            }
            this.toPath = toPath;
            if (toPath == null) {
                throw new IllegalArgumentException("Required value for 'toPath' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", toPath)) {
                throw new IllegalArgumentException("String 'toPath' does not match pattern");
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
            FROM_LOOKUP,  // LookupError
            FROM_WRITE,  // WriteError
            TO,  // WriteError
            /**
             * Shared folders can't be copied.
             */
            CANT_COPY_SHARED_FOLDER,
            /**
             * Your move operation would result in nested shared folders.  This
             * is not allowed.
             */
            CANT_NEST_SHARED_FOLDER,
            /**
             * You cannot move a folder into itself.
             */
            CANT_MOVE_FOLDER_INTO_ITSELF,
            /**
             * The operation would involve more than 10,000 files and folders.
             */
            TOO_MANY_FILES,
            /**
             * An unspecified error.
             */
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code RelocationError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError fromLookupValue;

        private RelocationError(Tag tag, LookupError value) {
            this.tag = tag;
            this.fromLookupValue = value;
            this.fromWriteValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#FROM_LOOKUP}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isFromLookup} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isFromLookup} is {@code
         *     false}.
         */
        public LookupError getFromLookupValue() {
            if (this.tag != Tag.FROM_LOOKUP) {
                throw new IllegalStateException("getFromLookupValue() requires tag==FROM_LOOKUP, actual tag==" + tag);
            }
            return fromLookupValue;
        }

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#FROM_LOOKUP}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#FROM_LOOKUP}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RelocationError fromLookup(LookupError value) {
            return new RelocationError(Tag.FROM_LOOKUP, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FROM_LOOKUP}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FROM_LOOKUP}, {@code false} otherwise.
         */
        public boolean isFromLookup() {
            return this.tag == Tag.FROM_LOOKUP;
        }

        private final WriteError fromWriteValue;

        private RelocationError(Tag tag, WriteError value) {
            this.tag = tag;
            this.fromLookupValue = null;
            this.fromWriteValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#FROM_WRITE}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isFromWrite} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isFromWrite} is {@code
         *     false}.
         */
        public WriteError getFromWriteValue() {
            if (this.tag != Tag.FROM_WRITE) {
                throw new IllegalStateException("getFromWriteValue() requires tag==FROM_WRITE, actual tag==" + tag);
            }
            return fromWriteValue;
        }

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#FROM_WRITE}.
         *
         * <p> None </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#FROM_WRITE}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RelocationError fromWrite(WriteError value) {
            return new RelocationError(Tag.FROM_WRITE, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FROM_WRITE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FROM_WRITE}, {@code false} otherwise.
         */
        public boolean isFromWrite() {
            return this.tag == Tag.FROM_WRITE;
        }

        // Reusing fromWriteValue for to

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#TO}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isTo} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isTo} is {@code false}.
         */
        public WriteError getToValue() {
            if (this.tag != Tag.TO) {
                throw new IllegalStateException("getToValue() requires tag==TO, actual tag==" + tag);
            }
            return fromWriteValue;
        }

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#TO}.
         *
         * <p> None </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#TO}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RelocationError to(WriteError value) {
            return new RelocationError(Tag.TO, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#TO},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#TO},
         *     {@code false} otherwise.
         */
        public boolean isTo() {
            return this.tag == Tag.TO;
        }

        /**
         * Shared folders can't be copied.
         */
        private static final RelocationError CANT_COPY_SHARED_FOLDER_INSTANCE = new RelocationError(Tag.CANT_COPY_SHARED_FOLDER);

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#CANT_COPY_SHARED_FOLDER}.
         *
         * <p> Shared folders can't be copied. </p>
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#CANT_COPY_SHARED_FOLDER}.
         */
        public static RelocationError cantCopySharedFolder() {
            return RelocationError.CANT_COPY_SHARED_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
         */
        public boolean isCantCopySharedFolder() {
            return this.tag == Tag.CANT_COPY_SHARED_FOLDER;
        }

        /**
         * Your move operation would result in nested shared folders.  This is
         * not allowed.
         */
        private static final RelocationError CANT_NEST_SHARED_FOLDER_INSTANCE = new RelocationError(Tag.CANT_NEST_SHARED_FOLDER);

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#CANT_NEST_SHARED_FOLDER}.
         *
         * <p> Your move operation would result in nested shared folders.  This
         * is not allowed. </p>
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#CANT_NEST_SHARED_FOLDER}.
         */
        public static RelocationError cantNestSharedFolder() {
            return RelocationError.CANT_NEST_SHARED_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
         */
        public boolean isCantNestSharedFolder() {
            return this.tag == Tag.CANT_NEST_SHARED_FOLDER;
        }

        /**
         * You cannot move a folder into itself.
         */
        private static final RelocationError CANT_MOVE_FOLDER_INTO_ITSELF_INSTANCE = new RelocationError(Tag.CANT_MOVE_FOLDER_INTO_ITSELF);

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#CANT_MOVE_FOLDER_INTO_ITSELF}.
         *
         * <p> You cannot move a folder into itself. </p>
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#CANT_MOVE_FOLDER_INTO_ITSELF}.
         */
        public static RelocationError cantMoveFolderIntoItself() {
            return RelocationError.CANT_MOVE_FOLDER_INTO_ITSELF_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
         */
        public boolean isCantMoveFolderIntoItself() {
            return this.tag == Tag.CANT_MOVE_FOLDER_INTO_ITSELF;
        }

        /**
         * The operation would involve more than 10,000 files and folders.
         */
        private static final RelocationError TOO_MANY_FILES_INSTANCE = new RelocationError(Tag.TOO_MANY_FILES);

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#TOO_MANY_FILES}.
         *
         * <p> The operation would involve more than 10,000 files and folders.
         * </p>
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#TOO_MANY_FILES}.
         */
        public static RelocationError tooManyFiles() {
            return RelocationError.TOO_MANY_FILES_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TOO_MANY_FILES}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TOO_MANY_FILES}, {@code false} otherwise.
         */
        public boolean isTooManyFiles() {
            return this.tag == Tag.TOO_MANY_FILES;
        }

        /**
         * An unspecified error.
         */
        private static final RelocationError OTHER_INSTANCE = new RelocationError(Tag.OTHER);

        /**
         * Returns an instance of {@code RelocationError} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code RelocationError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static RelocationError other() {
            return RelocationError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private RelocationError(Tag t) {
            tag = t;
            fromLookupValue = null;
            fromWriteValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case CANT_COPY_SHARED_FOLDER:
                case CANT_NEST_SHARED_FOLDER:
                case CANT_MOVE_FOLDER_INTO_ITSELF:
                case TOO_MANY_FILES:
                case OTHER:
                    break;
                case FROM_LOOKUP:
                    if (this.fromLookupValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case FROM_WRITE:
                    if (this.fromWriteValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case TO:
                    if (this.fromWriteValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case FROM_LOOKUP:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("from_lookup");
                        g.writeFieldName("from_lookup");
                        LookupError._writer.write(x.fromLookupValue, g);
                        g.writeEndObject();
                        break;
                    case FROM_WRITE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("from_write");
                        g.writeFieldName("from_write");
                        WriteError._writer.write(x.fromWriteValue, g);
                        g.writeEndObject();
                        break;
                    case TO:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("to");
                        g.writeFieldName("to");
                        WriteError._writer.write(x.fromWriteValue, g);
                        g.writeEndObject();
                        break;
                    case CANT_COPY_SHARED_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_copy_shared_folder");
                        g.writeEndObject();
                        break;
                    case CANT_NEST_SHARED_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_nest_shared_folder");
                        g.writeEndObject();
                        break;
                    case CANT_MOVE_FOLDER_INTO_ITSELF:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_move_folder_into_itself");
                        g.writeEndObject();
                        break;
                    case TOO_MANY_FILES:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_files");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return RelocationError.other(); }
                    switch (tag) {
                        case CANT_COPY_SHARED_FOLDER: return RelocationError.cantCopySharedFolder();
                        case CANT_NEST_SHARED_FOLDER: return RelocationError.cantNestSharedFolder();
                        case CANT_MOVE_FOLDER_INTO_ITSELF: return RelocationError.cantMoveFolderIntoItself();
                        case TOO_MANY_FILES: return RelocationError.tooManyFiles();
                        case OTHER: return RelocationError.other();
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
                        case FROM_LOOKUP: {
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
                        case FROM_WRITE: {
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
                        case TO: {
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
                        case CANT_COPY_SHARED_FOLDER: {
                            value = RelocationError.cantCopySharedFolder();
                            break;
                        }
                        case CANT_NEST_SHARED_FOLDER: {
                            value = RelocationError.cantNestSharedFolder();
                            break;
                        }
                        case CANT_MOVE_FOLDER_INTO_ITSELF: {
                            value = RelocationError.cantMoveFolderIntoItself();
                            break;
                        }
                        case TOO_MANY_FILES: {
                            value = RelocationError.tooManyFiles();
                            break;
                        }
                        case OTHER: {
                            value = RelocationError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RelocationError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("from_lookup", Tag.FROM_LOOKUP);
            _values.put("from_write", Tag.FROM_WRITE);
            _values.put("to", Tag.TO);
            _values.put("cant_copy_shared_folder", Tag.CANT_COPY_SHARED_FOLDER);
            _values.put("cant_nest_shared_folder", Tag.CANT_NEST_SHARED_FOLDER);
            _values.put("cant_move_folder_into_itself", Tag.CANT_MOVE_FOLDER_INTO_ITSELF);
            _values.put("too_many_files", Tag.TOO_MANY_FILES);
            _values.put("other", Tag.OTHER);
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


    public static final class ThumbnailSize {
        // union ThumbnailSize

        /**
         * The discriminating tag type for {@link ThumbnailSize}.
         */
        public enum Tag {
            /**
             * 32 by 32 px.
             */
            W32H32,
            /**
             * 64 by 64 px.
             */
            W64H64,
            /**
             * 128 by 128 px.
             */
            W128H128,
            /**
             * 640 by 480 px.
             */
            W640H480,
            /**
             * 1024 by 768
             */
            W1024H768
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ThumbnailSize}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * 32 by 32 px.
         */
        private static final ThumbnailSize W32H32_INSTANCE = new ThumbnailSize(Tag.W32H32);

        /**
         * Returns an instance of {@code ThumbnailSize} that has its tag set to
         * {@link Tag#W32H32}.
         *
         * <p> 32 by 32 px. </p>
         *
         * @return Instance of {@code ThumbnailSize} with its tag set to {@link
         *     Tag#W32H32}.
         */
        public static ThumbnailSize w32h32() {
            return ThumbnailSize.W32H32_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#W32H32},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#W32H32}, {@code false} otherwise.
         */
        public boolean isW32h32() {
            return this.tag == Tag.W32H32;
        }

        /**
         * 64 by 64 px.
         */
        private static final ThumbnailSize W64H64_INSTANCE = new ThumbnailSize(Tag.W64H64);

        /**
         * Returns an instance of {@code ThumbnailSize} that has its tag set to
         * {@link Tag#W64H64}.
         *
         * <p> 64 by 64 px. </p>
         *
         * @return Instance of {@code ThumbnailSize} with its tag set to {@link
         *     Tag#W64H64}.
         */
        public static ThumbnailSize w64h64() {
            return ThumbnailSize.W64H64_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#W64H64},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#W64H64}, {@code false} otherwise.
         */
        public boolean isW64h64() {
            return this.tag == Tag.W64H64;
        }

        /**
         * 128 by 128 px.
         */
        private static final ThumbnailSize W128H128_INSTANCE = new ThumbnailSize(Tag.W128H128);

        /**
         * Returns an instance of {@code ThumbnailSize} that has its tag set to
         * {@link Tag#W128H128}.
         *
         * <p> 128 by 128 px. </p>
         *
         * @return Instance of {@code ThumbnailSize} with its tag set to {@link
         *     Tag#W128H128}.
         */
        public static ThumbnailSize w128h128() {
            return ThumbnailSize.W128H128_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#W128H128}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#W128H128}, {@code false} otherwise.
         */
        public boolean isW128h128() {
            return this.tag == Tag.W128H128;
        }

        /**
         * 640 by 480 px.
         */
        private static final ThumbnailSize W640H480_INSTANCE = new ThumbnailSize(Tag.W640H480);

        /**
         * Returns an instance of {@code ThumbnailSize} that has its tag set to
         * {@link Tag#W640H480}.
         *
         * <p> 640 by 480 px. </p>
         *
         * @return Instance of {@code ThumbnailSize} with its tag set to {@link
         *     Tag#W640H480}.
         */
        public static ThumbnailSize w640h480() {
            return ThumbnailSize.W640H480_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#W640H480}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#W640H480}, {@code false} otherwise.
         */
        public boolean isW640h480() {
            return this.tag == Tag.W640H480;
        }

        /**
         * 1024 by 768
         */
        private static final ThumbnailSize W1024H768_INSTANCE = new ThumbnailSize(Tag.W1024H768);

        /**
         * Returns an instance of {@code ThumbnailSize} that has its tag set to
         * {@link Tag#W1024H768}.
         *
         * <p> 1024 by 768 </p>
         *
         * @return Instance of {@code ThumbnailSize} with its tag set to {@link
         *     Tag#W1024H768}.
         */
        public static ThumbnailSize w1024h768() {
            return ThumbnailSize.W1024H768_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#W1024H768}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#W1024H768}, {@code false} otherwise.
         */
        public boolean isW1024h768() {
            return this.tag == Tag.W1024H768;
        }

        private ThumbnailSize(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case W32H32:
                case W64H64:
                case W128H128:
                case W640H480:
                case W1024H768:
                    break;
            }
        }

        static final JsonWriter<ThumbnailSize> _writer = new JsonWriter<ThumbnailSize>()
        {
            public final void write(ThumbnailSize x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case W32H32:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w32h32");
                        g.writeEndObject();
                        break;
                    case W64H64:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w64h64");
                        g.writeEndObject();
                        break;
                    case W128H128:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w128h128");
                        g.writeEndObject();
                        break;
                    case W640H480:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("w640h480");
                        g.writeEndObject();
                        break;
                    case W1024H768:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case W32H32: return ThumbnailSize.w32h32();
                        case W64H64: return ThumbnailSize.w64h64();
                        case W128H128: return ThumbnailSize.w128h128();
                        case W640H480: return ThumbnailSize.w640h480();
                        case W1024H768: return ThumbnailSize.w1024h768();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ThumbnailSize value = null;
                if (tag != null) {
                    switch (tag) {
                        case W32H32: {
                            value = ThumbnailSize.w32h32();
                            break;
                        }
                        case W64H64: {
                            value = ThumbnailSize.w64h64();
                            break;
                        }
                        case W128H128: {
                            value = ThumbnailSize.w128h128();
                            break;
                        }
                        case W640H480: {
                            value = ThumbnailSize.w640h480();
                            break;
                        }
                        case W1024H768: {
                            value = ThumbnailSize.w1024h768();
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
            _values.put("w32h32", Tag.W32H32);
            _values.put("w64h64", Tag.W64H64);
            _values.put("w128h128", Tag.W128H128);
            _values.put("w640h480", Tag.W640H480);
            _values.put("w1024h768", Tag.W1024H768);
        }

        public String toString() {
            return "ThumbnailSize." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ThumbnailSize." +  _writer.writeToString(this, true);
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


    public static final class ThumbnailFormat {
        // union ThumbnailFormat

        /**
         * The discriminating tag type for {@link ThumbnailFormat}.
         */
        public enum Tag {
            JPEG,
            PNG
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ThumbnailFormat}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private static final ThumbnailFormat JPEG_INSTANCE = new ThumbnailFormat(Tag.JPEG);

        /**
         * Returns an instance of {@code ThumbnailFormat} that has its tag set
         * to {@link Tag#JPEG}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ThumbnailFormat} with its tag set to
         *     {@link Tag#JPEG}.
         */
        public static ThumbnailFormat jpeg() {
            return ThumbnailFormat.JPEG_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#JPEG},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#JPEG},
         *     {@code false} otherwise.
         */
        public boolean isJpeg() {
            return this.tag == Tag.JPEG;
        }

        private static final ThumbnailFormat PNG_INSTANCE = new ThumbnailFormat(Tag.PNG);

        /**
         * Returns an instance of {@code ThumbnailFormat} that has its tag set
         * to {@link Tag#PNG}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ThumbnailFormat} with its tag set to
         *     {@link Tag#PNG}.
         */
        public static ThumbnailFormat png() {
            return ThumbnailFormat.PNG_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PNG},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PNG},
         *     {@code false} otherwise.
         */
        public boolean isPng() {
            return this.tag == Tag.PNG;
        }

        private ThumbnailFormat(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case JPEG:
                case PNG:
                    break;
            }
        }

        static final JsonWriter<ThumbnailFormat> _writer = new JsonWriter<ThumbnailFormat>()
        {
            public final void write(ThumbnailFormat x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case JPEG:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("jpeg");
                        g.writeEndObject();
                        break;
                    case PNG:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case JPEG: return ThumbnailFormat.jpeg();
                        case PNG: return ThumbnailFormat.png();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ThumbnailFormat value = null;
                if (tag != null) {
                    switch (tag) {
                        case JPEG: {
                            value = ThumbnailFormat.jpeg();
                            break;
                        }
                        case PNG: {
                            value = ThumbnailFormat.png();
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
            _values.put("jpeg", Tag.JPEG);
            _values.put("png", Tag.PNG);
        }

        public String toString() {
            return "ThumbnailFormat." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ThumbnailFormat." +  _writer.writeToString(this, true);
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

        /**
         *
         * @param path  The path to the image file you want to thumbnail. {@code
         *     path} must match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}"
         *     and not be {@code null}.
         * @param format  The format for the thumbnail image, jpeg (default) or
         *     png. For  images that are photos, jpeg should be preferred, while
         *     png is  better for screenshots and digital arts.
         * @param size  The size for the thumbnail image.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ThumbnailArg(String path, ThumbnailFormat format, ThumbnailSize size) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            if (format != null) {
                this.format = format;
            }
            else {
                this.format = ThumbnailFormat.jpeg();
            }
            if (size != null) {
                this.size = size;
            }
            else {
                this.size = ThumbnailSize.w64h64();
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
            /**
             * An error occurs when downloading metadata for the image.
             */
            PATH,  // LookupError
            /**
             * The file extension doesn't allow conversion to a thumbnail.
             */
            UNSUPPORTED_EXTENSION,
            /**
             * The image cannot be converted to a thumbnail.
             */
            UNSUPPORTED_IMAGE,
            /**
             * An error occurs during thumbnail conversion.
             */
            CONVERSION_ERROR
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ThumbnailError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private ThumbnailError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * An error occurs when downloading metadata for the image.
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code ThumbnailError} that has its tag set to
         * {@link Tag#PATH}.
         *
         * <p> An error occurs when downloading metadata for the image. </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code ThumbnailError} with its tag set to {@link
         *     Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ThumbnailError path(LookupError value) {
            return new ThumbnailError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * The file extension doesn't allow conversion to a thumbnail.
         */
        private static final ThumbnailError UNSUPPORTED_EXTENSION_INSTANCE = new ThumbnailError(Tag.UNSUPPORTED_EXTENSION);

        /**
         * Returns an instance of {@code ThumbnailError} that has its tag set to
         * {@link Tag#UNSUPPORTED_EXTENSION}.
         *
         * <p> The file extension doesn't allow conversion to a thumbnail. </p>
         *
         * @return Instance of {@code ThumbnailError} with its tag set to {@link
         *     Tag#UNSUPPORTED_EXTENSION}.
         */
        public static ThumbnailError unsupportedExtension() {
            return ThumbnailError.UNSUPPORTED_EXTENSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
         */
        public boolean isUnsupportedExtension() {
            return this.tag == Tag.UNSUPPORTED_EXTENSION;
        }

        /**
         * The image cannot be converted to a thumbnail.
         */
        private static final ThumbnailError UNSUPPORTED_IMAGE_INSTANCE = new ThumbnailError(Tag.UNSUPPORTED_IMAGE);

        /**
         * Returns an instance of {@code ThumbnailError} that has its tag set to
         * {@link Tag#UNSUPPORTED_IMAGE}.
         *
         * <p> The image cannot be converted to a thumbnail. </p>
         *
         * @return Instance of {@code ThumbnailError} with its tag set to {@link
         *     Tag#UNSUPPORTED_IMAGE}.
         */
        public static ThumbnailError unsupportedImage() {
            return ThumbnailError.UNSUPPORTED_IMAGE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
         */
        public boolean isUnsupportedImage() {
            return this.tag == Tag.UNSUPPORTED_IMAGE;
        }

        /**
         * An error occurs during thumbnail conversion.
         */
        private static final ThumbnailError CONVERSION_ERROR_INSTANCE = new ThumbnailError(Tag.CONVERSION_ERROR);

        /**
         * Returns an instance of {@code ThumbnailError} that has its tag set to
         * {@link Tag#CONVERSION_ERROR}.
         *
         * <p> An error occurs during thumbnail conversion. </p>
         *
         * @return Instance of {@code ThumbnailError} with its tag set to {@link
         *     Tag#CONVERSION_ERROR}.
         */
        public static ThumbnailError conversionError() {
            return ThumbnailError.CONVERSION_ERROR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CONVERSION_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CONVERSION_ERROR}, {@code false} otherwise.
         */
        public boolean isConversionError() {
            return this.tag == Tag.CONVERSION_ERROR;
        }

        private ThumbnailError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case UNSUPPORTED_EXTENSION:
                case UNSUPPORTED_IMAGE:
                case CONVERSION_ERROR:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case UNSUPPORTED_EXTENSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_extension");
                        g.writeEndObject();
                        break;
                    case UNSUPPORTED_IMAGE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_image");
                        g.writeEndObject();
                        break;
                    case CONVERSION_ERROR:
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
                        case UNSUPPORTED_EXTENSION: return ThumbnailError.unsupportedExtension();
                        case UNSUPPORTED_IMAGE: return ThumbnailError.unsupportedImage();
                        case CONVERSION_ERROR: return ThumbnailError.conversionError();
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
                        case PATH: {
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
                        case UNSUPPORTED_EXTENSION: {
                            value = ThumbnailError.unsupportedExtension();
                            break;
                        }
                        case UNSUPPORTED_IMAGE: {
                            value = ThumbnailError.unsupportedImage();
                            break;
                        }
                        case CONVERSION_ERROR: {
                            value = ThumbnailError.conversionError();
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
            _values.put("path", Tag.PATH);
            _values.put("unsupported_extension", Tag.UNSUPPORTED_EXTENSION);
            _values.put("unsupported_image", Tag.UNSUPPORTED_IMAGE);
            _values.put("conversion_error", Tag.CONVERSION_ERROR);
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

        /**
         *
         * @param path  The path of the file to preview. {@code path} must match
         *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
         *     {@code null}.
         * @param rev  Deprecated. Please specify revision in :field:'path'
         *     instead. {@code rev} must have length of at least 9 and match
         *     pattern "{@code [0-9a-f]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public PreviewArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new IllegalArgumentException("String 'rev' is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                    throw new IllegalArgumentException("String 'rev' does not match pattern");
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
            /**
             * An error occurs when downloading metadata for the file.
             */
            PATH,  // LookupError
            /**
             * This preview generation is still in progress and the file is not
             * ready  for preview yet.
             */
            IN_PROGRESS,
            /**
             * The file extension is not supported preview generation.
             */
            UNSUPPORTED_EXTENSION,
            /**
             * The file content is not supported for preview generation.
             */
            UNSUPPORTED_CONTENT
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code PreviewError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private PreviewError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * An error occurs when downloading metadata for the file.
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code PreviewError} that has its tag set to
         * {@link Tag#PATH}.
         *
         * <p> An error occurs when downloading metadata for the file. </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code PreviewError} with its tag set to {@link
         *     Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static PreviewError path(LookupError value) {
            return new PreviewError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        /**
         * This preview generation is still in progress and the file is not
         * ready  for preview yet.
         */
        private static final PreviewError IN_PROGRESS_INSTANCE = new PreviewError(Tag.IN_PROGRESS);

        /**
         * Returns an instance of {@code PreviewError} that has its tag set to
         * {@link Tag#IN_PROGRESS}.
         *
         * <p> This preview generation is still in progress and the file is not
         * ready  for preview yet. </p>
         *
         * @return Instance of {@code PreviewError} with its tag set to {@link
         *     Tag#IN_PROGRESS}.
         */
        public static PreviewError inProgress() {
            return PreviewError.IN_PROGRESS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#IN_PROGRESS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#IN_PROGRESS}, {@code false} otherwise.
         */
        public boolean isInProgress() {
            return this.tag == Tag.IN_PROGRESS;
        }

        /**
         * The file extension is not supported preview generation.
         */
        private static final PreviewError UNSUPPORTED_EXTENSION_INSTANCE = new PreviewError(Tag.UNSUPPORTED_EXTENSION);

        /**
         * Returns an instance of {@code PreviewError} that has its tag set to
         * {@link Tag#UNSUPPORTED_EXTENSION}.
         *
         * <p> The file extension is not supported preview generation. </p>
         *
         * @return Instance of {@code PreviewError} with its tag set to {@link
         *     Tag#UNSUPPORTED_EXTENSION}.
         */
        public static PreviewError unsupportedExtension() {
            return PreviewError.UNSUPPORTED_EXTENSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
         */
        public boolean isUnsupportedExtension() {
            return this.tag == Tag.UNSUPPORTED_EXTENSION;
        }

        /**
         * The file content is not supported for preview generation.
         */
        private static final PreviewError UNSUPPORTED_CONTENT_INSTANCE = new PreviewError(Tag.UNSUPPORTED_CONTENT);

        /**
         * Returns an instance of {@code PreviewError} that has its tag set to
         * {@link Tag#UNSUPPORTED_CONTENT}.
         *
         * <p> The file content is not supported for preview generation. </p>
         *
         * @return Instance of {@code PreviewError} with its tag set to {@link
         *     Tag#UNSUPPORTED_CONTENT}.
         */
        public static PreviewError unsupportedContent() {
            return PreviewError.UNSUPPORTED_CONTENT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
         */
        public boolean isUnsupportedContent() {
            return this.tag == Tag.UNSUPPORTED_CONTENT;
        }

        private PreviewError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IN_PROGRESS:
                case UNSUPPORTED_EXTENSION:
                case UNSUPPORTED_CONTENT:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case IN_PROGRESS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("in_progress");
                        g.writeEndObject();
                        break;
                    case UNSUPPORTED_EXTENSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unsupported_extension");
                        g.writeEndObject();
                        break;
                    case UNSUPPORTED_CONTENT:
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
                        case IN_PROGRESS: return PreviewError.inProgress();
                        case UNSUPPORTED_EXTENSION: return PreviewError.unsupportedExtension();
                        case UNSUPPORTED_CONTENT: return PreviewError.unsupportedContent();
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
                        case PATH: {
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
                        case IN_PROGRESS: {
                            value = PreviewError.inProgress();
                            break;
                        }
                        case UNSUPPORTED_EXTENSION: {
                            value = PreviewError.unsupportedExtension();
                            break;
                        }
                        case UNSUPPORTED_CONTENT: {
                            value = PreviewError.unsupportedContent();
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
            _values.put("path", Tag.PATH);
            _values.put("in_progress", Tag.IN_PROGRESS);
            _values.put("unsupported_extension", Tag.UNSUPPORTED_EXTENSION);
            _values.put("unsupported_content", Tag.UNSUPPORTED_CONTENT);
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

        /**
         *
         * @param path  The path to the file you want to see the revisions of.
         *     {@code path} must match pattern "{@code /.*}" and not be {@code
         *     null}.
         * @param limit  The maximum number of revision entries returned. {@code
         *     limit} must be greater than or equal to 1 and be less than or
         *     equal to 100.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListRevisionsArg(String path, Long limit) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            if (limit != null) {
                this.limit = limit.longValue();
            }
            else {
                this.limit = 10L;
            }
            if (this.limit < 1L) {
                throw new IllegalArgumentException("Number 'this.limit' is smaller than 1L");
            }
            if (this.limit > 100L) {
                throw new IllegalArgumentException("Number 'this.limit' is larger than 100L");
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
            PATH,  // LookupError
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code ListRevisionsError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathValue;

        private ListRevisionsError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code ListRevisionsError} that has its tag
         * set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code ListRevisionsError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ListRevisionsError path(LookupError value) {
            return new ListRevisionsError(Tag.PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PATH},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#PATH},
         *     {@code false} otherwise.
         */
        public boolean isPath() {
            return this.tag == Tag.PATH;
        }

        private static final ListRevisionsError OTHER_INSTANCE = new ListRevisionsError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListRevisionsError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListRevisionsError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static ListRevisionsError other() {
            return ListRevisionsError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private ListRevisionsError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return ListRevisionsError.other(); }
                    switch (tag) {
                        case OTHER: return ListRevisionsError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = ListRevisionsError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListRevisionsError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path", Tag.PATH);
            _values.put("other", Tag.OTHER);
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
        public final java.util.List<FileMetadata> entries;

        /**
         *
         * @param isDeleted  If the file is deleted.
         * @param entries  The revisions for the file. Only non-delete revisions
         *     will show up here. {@code entries} must not contain a {@code
         *     null} item and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListRevisionsResult(boolean isDeleted, java.util.List<FileMetadata> entries) {
            this.isDeleted = isDeleted;
            this.entries = entries;
            if (entries == null) {
                throw new IllegalArgumentException("Required value for 'entries' is null");
            }
            for (FileMetadata x : entries) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'entries' is null");
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
                java.util.List<FileMetadata> entries = null;
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

        /**
         *
         * @param path  The path to the file you want to restore. {@code path}
         *     must match pattern "{@code /.*}" and not be {@code null}.
         * @param rev  The revision to restore for the file. {@code rev} must
         *     have length of at least 9, match pattern "{@code [0-9a-f]+}", and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public RestoreArg(String path, String rev) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.rev = rev;
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
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
            /**
             * An error occurs when downloading metadata for the file.
             */
            PATH_LOOKUP,  // LookupError
            /**
             * An error occurs when trying to restore the file to that path.
             */
            PATH_WRITE,  // WriteError
            /**
             * The revision is invalid. It may point to a different file.
             */
            INVALID_REVISION,
            OTHER  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * Returns the tag for this instance.
         *
         * <p> This class is a tagged union.  Tagged unions instances are always
         * associated to a specific tag.  Callers are recommended to use the tag
         * value in a {@code switch} statement to determine how to properly
         * handle this {@code RestoreError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final LookupError pathLookupValue;

        private RestoreError(Tag tag, LookupError value) {
            this.tag = tag;
            this.pathLookupValue = value;
            this.pathWriteValue = null;
            validate();
        }

        /**
         * An error occurs when downloading metadata for the file.
         *
         * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
         *
         * @return The {@link LookupError} value associated with this instance
         *     if {@link #isPathLookup} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPathLookup} is {@code
         *     false}.
         */
        public LookupError getPathLookupValue() {
            if (this.tag != Tag.PATH_LOOKUP) {
                throw new IllegalStateException("getPathLookupValue() requires tag==PATH_LOOKUP, actual tag==" + tag);
            }
            return pathLookupValue;
        }

        /**
         * Returns an instance of {@code RestoreError} that has its tag set to
         * {@link Tag#PATH_LOOKUP}.
         *
         * <p> An error occurs when downloading metadata for the file. </p>
         *
         * @param value  {@link LookupError} value to assign to this instance.
         *
         * @return Instance of {@code RestoreError} with its tag set to {@link
         *     Tag#PATH_LOOKUP}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RestoreError pathLookup(LookupError value) {
            return new RestoreError(Tag.PATH_LOOKUP, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PATH_LOOKUP}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PATH_LOOKUP}, {@code false} otherwise.
         */
        public boolean isPathLookup() {
            return this.tag == Tag.PATH_LOOKUP;
        }

        private final WriteError pathWriteValue;

        private RestoreError(Tag tag, WriteError value) {
            this.tag = tag;
            this.pathLookupValue = null;
            this.pathWriteValue = value;
            validate();
        }

        /**
         * An error occurs when trying to restore the file to that path.
         *
         * <p> This instance must be tagged as {@link Tag#PATH_WRITE}. </p>
         *
         * @return The {@link WriteError} value associated with this instance if
         *     {@link #isPathWrite} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPathWrite} is {@code
         *     false}.
         */
        public WriteError getPathWriteValue() {
            if (this.tag != Tag.PATH_WRITE) {
                throw new IllegalStateException("getPathWriteValue() requires tag==PATH_WRITE, actual tag==" + tag);
            }
            return pathWriteValue;
        }

        /**
         * Returns an instance of {@code RestoreError} that has its tag set to
         * {@link Tag#PATH_WRITE}.
         *
         * <p> An error occurs when trying to restore the file to that path.
         * </p>
         *
         * @param value  {@link WriteError} value to assign to this instance.
         *
         * @return Instance of {@code RestoreError} with its tag set to {@link
         *     Tag#PATH_WRITE}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RestoreError pathWrite(WriteError value) {
            return new RestoreError(Tag.PATH_WRITE, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PATH_WRITE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PATH_WRITE}, {@code false} otherwise.
         */
        public boolean isPathWrite() {
            return this.tag == Tag.PATH_WRITE;
        }

        /**
         * The revision is invalid. It may point to a different file.
         */
        private static final RestoreError INVALID_REVISION_INSTANCE = new RestoreError(Tag.INVALID_REVISION);

        /**
         * Returns an instance of {@code RestoreError} that has its tag set to
         * {@link Tag#INVALID_REVISION}.
         *
         * <p> The revision is invalid. It may point to a different file. </p>
         *
         * @return Instance of {@code RestoreError} with its tag set to {@link
         *     Tag#INVALID_REVISION}.
         */
        public static RestoreError invalidRevision() {
            return RestoreError.INVALID_REVISION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_REVISION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_REVISION}, {@code false} otherwise.
         */
        public boolean isInvalidRevision() {
            return this.tag == Tag.INVALID_REVISION;
        }

        private static final RestoreError OTHER_INSTANCE = new RestoreError(Tag.OTHER);

        /**
         * Returns an instance of {@code RestoreError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code RestoreError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static RestoreError other() {
            return RestoreError.OTHER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
         *     {@code false} otherwise.
         */
        public boolean isOther() {
            return this.tag == Tag.OTHER;
        }

        private RestoreError(Tag t) {
            tag = t;
            pathLookupValue = null;
            pathWriteValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_REVISION:
                case OTHER:
                    break;
                case PATH_LOOKUP:
                    if (this.pathLookupValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case PATH_WRITE:
                    if (this.pathWriteValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case PATH_LOOKUP:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_lookup");
                        g.writeFieldName("path_lookup");
                        LookupError._writer.write(x.pathLookupValue, g);
                        g.writeEndObject();
                        break;
                    case PATH_WRITE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path_write");
                        g.writeFieldName("path_write");
                        WriteError._writer.write(x.pathWriteValue, g);
                        g.writeEndObject();
                        break;
                    case INVALID_REVISION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_revision");
                        g.writeEndObject();
                        break;
                    case OTHER:
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
                    if (tag == null) { return RestoreError.other(); }
                    switch (tag) {
                        case INVALID_REVISION: return RestoreError.invalidRevision();
                        case OTHER: return RestoreError.other();
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
                        case PATH_LOOKUP: {
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
                        case PATH_WRITE: {
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
                        case INVALID_REVISION: {
                            value = RestoreError.invalidRevision();
                            break;
                        }
                        case OTHER: {
                            value = RestoreError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RestoreError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("path_lookup", Tag.PATH_LOOKUP);
            _values.put("path_write", Tag.PATH_WRITE);
            _values.put("invalid_revision", Tag.INVALID_REVISION);
            _values.put("other", Tag.OTHER);
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
     * Exception thrown by {@link DbxFiles#getMetadata(String,boolean)}.
     */
    public static class GetMetadataException extends DbxApiException {
        /**
         * The error reported by getMetadata.
         */
        public final GetMetadataError errorValue;

        public GetMetadataException(String requestId, LocalizedText userMessage, GetMetadataError errorValue) {
            super(requestId, userMessage, buildMessage("get_metadata", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/get_metadata",
                                   arg,
                                   false,
                                   GetMetadataArg._writer,
                                   Metadata._reader,
                                   GetMetadataError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetMetadataException(ew.requestId, ew.userMessage, (GetMetadataError) (ew.errValue));
        }
    }
    /**
     * Returns the metadata for a file or folder.
     *
     * @param path  The path of a file or folder on Dropbox. {@code path} must
     *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public Metadata getMetadata(String path)
          throws GetMetadataException, DbxException
    {
        GetMetadataArg arg = new GetMetadataArg(path, null);
        return getMetadata(arg);
    }
    /**
     * Returns the metadata for a file or folder.
     *
     * @param path  The path of a file or folder on Dropbox. {@code path} must
     *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
     *     {@code null}.
     * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is set
     *     for photo and video.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public Metadata getMetadata(String path, boolean includeMediaInfo)
          throws GetMetadataException, DbxException
    {
        GetMetadataArg arg = new GetMetadataArg(path, includeMediaInfo);
        return getMetadata(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#listFolderLongpoll(String,long)}.
     */
    public static class ListFolderLongpollException extends DbxApiException {
        /**
         * The error reported by listFolderLongpoll.
         */
        public final ListFolderLongpollError errorValue;

        public ListFolderLongpollException(String requestId, LocalizedText userMessage, ListFolderLongpollError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder/longpoll", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolderBuilder}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     */
    private ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg arg)
            throws ListFolderLongpollException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().notify,
                                   "2/files/list_folder/longpoll",
                                   arg,
                                   true,
                                   ListFolderLongpollArg._writer,
                                   ListFolderLongpollResult._reader,
                                   ListFolderLongpollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderLongpollException(ew.requestId, ew.userMessage, (ListFolderLongpollError) (ew.errValue));
        }
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolderBuilder}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     *
     * @param cursor  A cursor as returned by {@link DbxFiles#listFolderBuilder}
     *     or {@link DbxFiles#listFolderContinue(String)}. {@code cursor} must
     *     have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor)
          throws ListFolderLongpollException, DbxException
    {
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor, null);
        return listFolderLongpoll(arg);
    }
    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolderBuilder}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     *
     * @param cursor  A cursor as returned by {@link DbxFiles#listFolderBuilder}
     *     or {@link DbxFiles#listFolderContinue(String)}. {@code cursor} must
     *     have length of at least 1 and not be {@code null}.
     * @param timeout  A timeout in seconds. The request will block for at most
     *     this length of time, plus up to 90 seconds of random jitter added to
     *     avoid the thundering herd problem. Care should be taken when using
     *     this parameter, as some network infrastructure does not support long
     *     timeouts. {@code timeout} must be greater than or equal to 30 and be
     *     less than or equal to 480.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor, long timeout)
          throws ListFolderLongpollException, DbxException
    {
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor, timeout);
        return listFolderLongpoll(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#listFolderBuilder}.
     */
    public static class ListFolderException extends DbxApiException {
        /**
         * The error reported by listFolder.
         */
        public final ListFolderError errorValue;

        public ListFolderException(String requestId, LocalizedText userMessage, ListFolderError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/list_folder",
                                   arg,
                                   false,
                                   ListFolderArg._writer,
                                   ListFolderResult._reader,
                                   ListFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderException(ew.requestId, ew.userMessage, (ListFolderError) (ew.errValue));
        }
    }
    /**
     * Returns the contents of a folder.
     *
     * @param path  The path to the folder you want to see the contents of.
     *     {@code path} must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolder(String path)
          throws ListFolderException, DbxException
    {
        ListFolderArg arg = new ListFolderArg(path, null, null, null);
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
        private Boolean includeDeleted;

        private ListFolderBuilder(String path)
        {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code recursive}.
         *
         * @param recursive  If true, the list folder operation will be applied
         *     recursively to all subfolders and the response will contain
         *     contents of all subfolders.
         */
        public ListFolderBuilder recursive(boolean recursive)
        {
            this.recursive = recursive;
            return this;
        }

        /**
         * Set value for optional request field {@code includeMediaInfo}.
         *
         * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is
         *     set for photo and video.
         */
        public ListFolderBuilder includeMediaInfo(boolean includeMediaInfo)
        {
            this.includeMediaInfo = includeMediaInfo;
            return this;
        }

        /**
         * Set value for optional request field {@code includeDeleted}.
         *
         * @param includeDeleted  If true, the results will include entries for
         *     files and folders that used to exist but were deleted.
         */
        public ListFolderBuilder includeDeleted(boolean includeDeleted)
        {
            this.includeDeleted = includeDeleted;
            return this;
        }

        /**
         * Issues the request.
         */
        public ListFolderResult start() throws ListFolderException, DbxException
        {
            ListFolderArg arg = new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted);
            return DbxFiles.this.listFolder(arg);
        }
    }

    /**
     * Returns the contents of a folder.
     *
     * @param path  The path to the folder you want to see the contents of.
     *     {@code path} must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderBuilder listFolderBuilder(String path)
    {
        return new ListFolderBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#listFolderContinue(String)}.
     */
    public static class ListFolderContinueException extends DbxApiException {
        /**
         * The error reported by listFolderContinue.
         */
        public final ListFolderContinueError errorValue;

        public ListFolderContinueException(String requestId, LocalizedText userMessage, ListFolderContinueError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder/continue", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Once a cursor has been retrieved from {@link DbxFiles#listFolderBuilder},
     * use this to paginate through all files and retrieve updates to the
     * folder.
     */
    private ListFolderResult listFolderContinue(ListFolderContinueArg arg)
            throws ListFolderContinueException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/files/list_folder/continue",
                                   arg,
                                   false,
                                   ListFolderContinueArg._writer,
                                   ListFolderResult._reader,
                                   ListFolderContinueError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderContinueException(ew.requestId, ew.userMessage, (ListFolderContinueError) (ew.errValue));
        }
    }
    /**
     * Once a cursor has been retrieved from {@link DbxFiles#listFolderBuilder},
     * use this to paginate through all files and retrieve updates to the
     * folder.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxFiles#listFolderBuilder} or {@link
     *     DbxFiles#listFolderContinue(String)}. {@code cursor} must have length
     *     of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolderContinue(String cursor)
          throws ListFolderContinueException, DbxException
    {
        ListFolderContinueArg arg = new ListFolderContinueArg(cursor);
        return listFolderContinue(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#listFolderGetLatestCursorBuilder}.
     */
    public static class ListFolderGetLatestCursorException extends DbxApiException {
        /**
         * The error reported by listFolderGetLatestCursor.
         */
        public final ListFolderError errorValue;

        public ListFolderGetLatestCursorException(String requestId, LocalizedText userMessage, ListFolderError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder/get_latest_cursor", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolderBuilder}, {@link
     * DbxFiles#listFolderGetLatestCursorBuilder} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     */
    private ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg arg)
            throws ListFolderGetLatestCursorException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/files/list_folder/get_latest_cursor",
                                   arg,
                                   false,
                                   ListFolderArg._writer,
                                   ListFolderGetLatestCursorResult._reader,
                                   ListFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderGetLatestCursorException(ew.requestId, ew.userMessage, (ListFolderError) (ew.errValue));
        }
    }
    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolderBuilder}, {@link
     * DbxFiles#listFolderGetLatestCursorBuilder} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     *
     * @param path  The path to the folder you want to see the contents of.
     *     {@code path} must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorResult listFolderGetLatestCursor(String path)
          throws ListFolderGetLatestCursorException, DbxException
    {
        ListFolderArg arg = new ListFolderArg(path, null, null, null);
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
        private Boolean includeDeleted;

        private ListFolderGetLatestCursorBuilder(String path)
        {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code recursive}.
         *
         * @param recursive  If true, the list folder operation will be applied
         *     recursively to all subfolders and the response will contain
         *     contents of all subfolders.
         */
        public ListFolderGetLatestCursorBuilder recursive(boolean recursive)
        {
            this.recursive = recursive;
            return this;
        }

        /**
         * Set value for optional request field {@code includeMediaInfo}.
         *
         * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is
         *     set for photo and video.
         */
        public ListFolderGetLatestCursorBuilder includeMediaInfo(boolean includeMediaInfo)
        {
            this.includeMediaInfo = includeMediaInfo;
            return this;
        }

        /**
         * Set value for optional request field {@code includeDeleted}.
         *
         * @param includeDeleted  If true, the results will include entries for
         *     files and folders that used to exist but were deleted.
         */
        public ListFolderGetLatestCursorBuilder includeDeleted(boolean includeDeleted)
        {
            this.includeDeleted = includeDeleted;
            return this;
        }

        /**
         * Issues the request.
         */
        public ListFolderGetLatestCursorResult start() throws ListFolderGetLatestCursorException, DbxException
        {
            ListFolderArg arg = new ListFolderArg(path, recursive, includeMediaInfo, includeDeleted);
            return DbxFiles.this.listFolderGetLatestCursor(arg);
        }
    }

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolderBuilder}, {@link
     * DbxFiles#listFolderGetLatestCursorBuilder} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     *
     * @param path  The path to the folder you want to see the contents of.
     *     {@code path} must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String path)
    {
        return new ListFolderGetLatestCursorBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#downloadBuilder}.
     */
    public static class DownloadException extends DbxApiException {
        /**
         * The error reported by download.
         */
        public final DownloadError errorValue;

        public DownloadException(String requestId, LocalizedText userMessage, DownloadError errorValue) {
            super(requestId, userMessage, buildMessage("download", userMessage, errorValue));
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
            return client.downloadStyle(client.getHost().content,
                                        "2/files/download",
                                        arg,
                                        false,
                                        DownloadArg._writer,
                                        FileMetadata._reader,
                                        DownloadError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DownloadException(ew.requestId, ew.userMessage, (DownloadError) (ew.errValue));
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code rev}.
         *
         * @param rev  Deprecated. Please specify revision in :field:'path'
         *     instead. {@code rev} must have length of at least 9 and match
         *     pattern "{@code [0-9a-f]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public DownloadBuilder rev(String rev)
        {
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new IllegalArgumentException("String is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                    throw new IllegalArgumentException("String does not match pattern");
                }
            }
            this.rev = rev;
            return this;
        }

        /**
         * Issues the request.
         */
        public com.dropbox.core.DbxDownloader<FileMetadata> start() throws DownloadException, DbxException
        {
            DownloadArg arg = new DownloadArg(path, rev);
            return DbxFiles.this.download(arg);
        }
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. {@code path} must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public DownloadBuilder downloadBuilder(String path)
    {
        return new DownloadBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#uploadSessionStart}.
     */
    public static class UploadSessionStartException extends DbxApiException {
        public UploadSessionStartException(String requestId, LocalizedText userMessage) {
            super(requestId, userMessage, buildMessage("upload_session/start", userMessage));
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionStartException> uploadSessionStartErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionStartException>()
    {
        @Override
        public UploadSessionStartException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionStartException(ew.requestId, ew.userMessage);
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * DbxFiles#uploadSessionStart}.
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
     * can then use {@link DbxFiles#uploadSessionAppendBuilder} to add more data
     * and {@link DbxFiles#uploadSessionFinishBuilder} to save all the data to a
     * file in Dropbox. A single request should not upload more than 150 MB of
     * file contents.
     */
    public UploadSessionStartUploader uploadSessionStart()
            throws DbxException
    {
        try {
            return (UploadSessionStartUploader) client.uploadStyle(client.getHost().content,
                                                                   "2/files/upload_session/start",
                                                                   null,
                                                                   false,
                                                                   null,
                                                                   uploadSessionStartUploaderMaker);
        }
        catch (DbxException ex) { throw ex; } // Dummy
    }

    /**
     * Exception thrown by {@link DbxFiles#uploadSessionAppendBuilder}.
     */
    public static class UploadSessionAppendException extends DbxApiException {
        /**
         * The error reported by uploadSessionAppend.
         */
        public final UploadSessionLookupError errorValue;

        public UploadSessionAppendException(String requestId, LocalizedText userMessage, UploadSessionLookupError errorValue) {
            super(requestId, userMessage, buildMessage("upload_session/append", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionAppendException> uploadSessionAppendErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionAppendException>()
    {
        @Override
        public UploadSessionAppendException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionAppendException(ew.requestId, ew.userMessage, (UploadSessionLookupError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * DbxFiles#uploadSessionAppendBuilder}.
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
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB of file contents.
     */
    private UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor arg)
            throws DbxException
    {
        try {
            return (UploadSessionAppendUploader) client.uploadStyle(client.getHost().content,
                                                                    "2/files/upload_session/append",
                                                                    arg,
                                                                    false,
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
            if (sessionId == null) {
                throw new IllegalArgumentException("Required value for 'sessionId' is null");
            }
            this.sessionId = sessionId;
            this.offset = offset;
        }

        /**
         * Issues the request.
         */
        public UploadSessionAppendUploader start() throws UploadSessionAppendException, DbxException
        {
            UploadSessionCursor arg = new UploadSessionCursor(sessionId, offset);
            return DbxFiles.this.uploadSessionAppend(arg);
        }
    }

    /**
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB of file contents.
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxFiles#uploadSessionStart}). {@code sessionId} must not be {@code
     *     null}.
     * @param offset  The amount of data that has been uploaded so far. We use
     *     this to make sure upload data isn't lost or duplicated in the event
     *     of a network error.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendBuilder uploadSessionAppendBuilder(String sessionId, long offset)
    {
        return new UploadSessionAppendBuilder(sessionId, offset);
    }

    /**
     * Exception thrown by {@link DbxFiles#uploadSessionFinishBuilder}.
     */
    public static class UploadSessionFinishException extends DbxApiException {
        /**
         * The error reported by uploadSessionFinish.
         */
        public final UploadSessionFinishError errorValue;

        public UploadSessionFinishException(String requestId, LocalizedText userMessage, UploadSessionFinishError errorValue) {
            super(requestId, userMessage, buildMessage("upload_session/finish", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionFinishException> uploadSessionFinishErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadSessionFinishException>()
    {
        @Override
        public UploadSessionFinishException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadSessionFinishException(ew.requestId, ew.userMessage, (UploadSessionFinishError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * DbxFiles#uploadSessionFinishBuilder}.
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
     * path. A single request should not upload more than 150 MB of file
     * contents.
     */
    private UploadSessionFinishUploader uploadSessionFinish(UploadSessionFinishArg arg)
            throws DbxException
    {
        try {
            return (UploadSessionFinishUploader) client.uploadStyle(client.getHost().content,
                                                                    "2/files/upload_session/finish",
                                                                    arg,
                                                                    false,
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
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            this.cursor = cursor;
            if (commit == null) {
                throw new IllegalArgumentException("Required value for 'commit' is null");
            }
            this.commit = commit;
        }

        /**
         * Issues the request.
         */
        public UploadSessionFinishUploader start() throws UploadSessionFinishException, DbxException
        {
            UploadSessionFinishArg arg = new UploadSessionFinishArg(cursor, commit);
            return DbxFiles.this.uploadSessionFinish(arg);
        }
    }

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path. A single request should not upload more than 150 MB of file
     * contents.
     *
     * @param cursor  Contains the upload session ID and the offset. {@code
     *     cursor} must not be {@code null}.
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. {@code commit} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishBuilder uploadSessionFinishBuilder(UploadSessionCursor cursor, CommitInfo commit)
    {
        return new UploadSessionFinishBuilder(cursor, commit);
    }

    /**
     * Exception thrown by {@link DbxFiles#uploadBuilder}.
     */
    public static class UploadException extends DbxApiException {
        /**
         * The error reported by upload.
         */
        public final UploadError errorValue;

        public UploadException(String requestId, LocalizedText userMessage, UploadError errorValue) {
            super(requestId, userMessage, buildMessage("upload", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    static DbxRequestUtil.RouteSpecificErrorMaker<UploadException> uploadErrorMaker = new DbxRequestUtil.RouteSpecificErrorMaker<UploadException>()
    {
        @Override
        public UploadException makeError(DbxRequestUtil.ErrorWrapper ew) {
            return new UploadException(ew.requestId, ew.userMessage, (UploadError) (ew.errValue));
        }
    };
    /**
     * The {@link com.dropbox.core.DbxUploader} returned by {@link
     * DbxFiles#uploadBuilder}.
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
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxFiles#uploadSessionStart}.
     */
    private UploadUploader upload(CommitInfo arg)
            throws DbxException
    {
        try {
            return (UploadUploader) client.uploadStyle(client.getHost().content,
                                                       "2/files/upload",
                                                       arg,
                                                       false,
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code mode}.
         *
         * @param mode  Selects what to do if the file already exists.
         */
        public UploadBuilder mode(WriteMode mode)
        {
            this.mode = mode;
            return this;
        }

        /**
         * Set value for optional request field {@code autorename}.
         *
         * @param autorename  If there's a conflict, as determined by {@code
         *     mode}, have the Dropbox server try to autorename the file to
         *     avoid conflict.
         */
        public UploadBuilder autorename(boolean autorename)
        {
            this.autorename = autorename;
            return this;
        }

        /**
         * Set value for optional request field {@code clientModified}.
         *
         * @param clientModified  The value to store as the {@code
         *     clientModified} timestamp. Dropbox automatically records the time
         *     at which the file was written to the Dropbox servers. It can also
         *     record an additional timestamp, provided by Dropbox desktop
         *     clients, mobile clients, and API apps of when the file was
         *     actually created or modified.
         */
        public UploadBuilder clientModified(java.util.Date clientModified)
        {
            this.clientModified = clientModified;
            return this;
        }

        /**
         * Set value for optional request field {@code mute}.
         *
         * @param mute  Normally, users are made aware of any file modifications
         *     in their Dropbox account via notifications in the client
         *     software. If {@code true}, this tells the clients that this
         *     modification shouldn't result in a user notification.
         */
        public UploadBuilder mute(boolean mute)
        {
            this.mute = mute;
            return this;
        }

        /**
         * Issues the request.
         */
        public UploadUploader start() throws UploadException, DbxException
        {
            CommitInfo arg = new CommitInfo(path, mode, autorename, clientModified, mute);
            return DbxFiles.this.upload(arg);
        }
    }

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxFiles#uploadSessionStart}.
     *
     * @param path  Path in the user's Dropbox to save the file. {@code path}
     *     must match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public UploadBuilder uploadBuilder(String path)
    {
        return new UploadBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#searchBuilder}.
     */
    public static class SearchException extends DbxApiException {
        /**
         * The error reported by search.
         */
        public final SearchError errorValue;

        public SearchException(String requestId, LocalizedText userMessage, SearchError errorValue) {
            super(requestId, userMessage, buildMessage("search", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/search",
                                   arg,
                                   false,
                                   SearchArg._writer,
                                   SearchResult._reader,
                                   SearchError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SearchException(ew.requestId, ew.userMessage, (SearchError) (ew.errValue));
        }
    }
    /**
     * Searches for files and folders.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. {@code path} must match pattern "{@code (/.*)?}" and not be
     *     {@code null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). {@code query} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            this.query = query;
        }

        /**
         * Set value for optional request field {@code start}.
         *
         * @param start  The starting index within the search results (used for
         *     paging).
         */
        public SearchBuilder start(long start)
        {
            this.start = start;
            return this;
        }

        /**
         * Set value for optional request field {@code maxResults}.
         *
         * @param maxResults  The maximum number of search results to return.
         *     {@code maxResults} must be greater than or equal to 1 and be less
         *     than or equal to 1000.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SearchBuilder maxResults(long maxResults)
        {
            if (this.maxResults < 1L) {
                throw new IllegalArgumentException("Number is smaller than 1L");
            }
            if (this.maxResults > 1000L) {
                throw new IllegalArgumentException("Number is larger than 1000L");
            }
            this.maxResults = maxResults;
            return this;
        }

        /**
         * Set value for optional request field {@code mode}.
         *
         * @param mode  The search mode (filename, filename_and_content, or
         *     deleted_filename). Note that searching file content is only
         *     available for Dropbox Business accounts.
         */
        public SearchBuilder mode(SearchMode mode)
        {
            this.mode = mode;
            return this;
        }

        /**
         * Issues the request.
         */
        public SearchResult start() throws SearchException, DbxException
        {
            SearchArg arg = new SearchArg(path, query, start, maxResults, mode);
            return DbxFiles.this.search(arg);
        }
    }

    /**
     * Searches for files and folders.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. {@code path} must match pattern "{@code (/.*)?}" and not be
     *     {@code null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). {@code query} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SearchBuilder searchBuilder(String path, String query)
    {
        return new SearchBuilder(path, query);
    }

    /**
     * Exception thrown by {@link DbxFiles#createFolder(String)}.
     */
    public static class CreateFolderException extends DbxApiException {
        /**
         * The error reported by createFolder.
         */
        public final CreateFolderError errorValue;

        public CreateFolderException(String requestId, LocalizedText userMessage, CreateFolderError errorValue) {
            super(requestId, userMessage, buildMessage("create_folder", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/create_folder",
                                   arg,
                                   false,
                                   CreateFolderArg._writer,
                                   FolderMetadata._reader,
                                   CreateFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateFolderException(ew.requestId, ew.userMessage, (CreateFolderError) (ew.errValue));
        }
    }
    /**
     * Create a folder at a given path.
     *
     * @param path  Path in the user's Dropbox to create. {@code path} must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata createFolder(String path)
          throws CreateFolderException, DbxException
    {
        CreateFolderArg arg = new CreateFolderArg(path);
        return createFolder(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#delete(String)}.
     */
    public static class DeleteException extends DbxApiException {
        /**
         * The error reported by delete.
         */
        public final DeleteError errorValue;

        public DeleteException(String requestId, LocalizedText userMessage, DeleteError errorValue) {
            super(requestId, userMessage, buildMessage("delete", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/delete",
                                   arg,
                                   false,
                                   DeleteArg._writer,
                                   Metadata._reader,
                                   DeleteError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DeleteException(ew.requestId, ew.userMessage, (DeleteError) (ew.errValue));
        }
    }
    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too.
     *
     * @param path  Path in the user's Dropbox to delete. {@code path} must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public Metadata delete(String path)
          throws DeleteException, DbxException
    {
        DeleteArg arg = new DeleteArg(path);
        return delete(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#permanentlyDelete(String)}.
     */
    public static class PermanentlyDeleteException extends DbxApiException {
        /**
         * The error reported by permanentlyDelete.
         */
        public final DeleteError errorValue;

        public PermanentlyDeleteException(String requestId, LocalizedText userMessage, DeleteError errorValue) {
            super(requestId, userMessage, buildMessage("permanently_delete", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). Note: This endpoint is only
     * available for Dropbox Business apps.
     */
    private void permanentlyDelete(DeleteArg arg)
            throws PermanentlyDeleteException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/files/permanently_delete",
                            arg,
                            false,
                            DeleteArg._writer,
                            JsonReader.VoidReader,
                            DeleteError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PermanentlyDeleteException(ew.requestId, ew.userMessage, (DeleteError) (ew.errValue));
        }
    }
    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). Note: This endpoint is only
     * available for Dropbox Business apps.
     *
     * @param path  Path in the user's Dropbox to delete. {@code path} must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void permanentlyDelete(String path)
          throws PermanentlyDeleteException, DbxException
    {
        DeleteArg arg = new DeleteArg(path);
        permanentlyDelete(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#copy(String,String)}.
     */
    public static class CopyException extends DbxApiException {
        /**
         * The error reported by copy.
         */
        public final RelocationError errorValue;

        public CopyException(String requestId, LocalizedText userMessage, RelocationError errorValue) {
            super(requestId, userMessage, buildMessage("copy", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/copy",
                                   arg,
                                   false,
                                   RelocationArg._writer,
                                   Metadata._reader,
                                   RelocationError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CopyException(ew.requestId, ew.userMessage, (RelocationError) (ew.errValue));
        }
    }
    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. {@code
     *     fromPath} must match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. {@code
     *     toPath} must match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public Metadata copy(String fromPath, String toPath)
          throws CopyException, DbxException
    {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return copy(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#move(String,String)}.
     */
    public static class MoveException extends DbxApiException {
        /**
         * The error reported by move.
         */
        public final RelocationError errorValue;

        public MoveException(String requestId, LocalizedText userMessage, RelocationError errorValue) {
            super(requestId, userMessage, buildMessage("move", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/move",
                                   arg,
                                   false,
                                   RelocationArg._writer,
                                   Metadata._reader,
                                   RelocationError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MoveException(ew.requestId, ew.userMessage, (RelocationError) (ew.errValue));
        }
    }
    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. {@code
     *     fromPath} must match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. {@code
     *     toPath} must match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public Metadata move(String fromPath, String toPath)
          throws MoveException, DbxException
    {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return move(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#getThumbnailBuilder}.
     */
    public static class GetThumbnailException extends DbxApiException {
        /**
         * The error reported by getThumbnail.
         */
        public final ThumbnailError errorValue;

        public GetThumbnailException(String requestId, LocalizedText userMessage, ThumbnailError errorValue) {
            super(requestId, userMessage, buildMessage("get_thumbnail", userMessage, errorValue));
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
            return client.downloadStyle(client.getHost().content,
                                        "2/files/get_thumbnail",
                                        arg,
                                        false,
                                        ThumbnailArg._writer,
                                        FileMetadata._reader,
                                        ThumbnailError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetThumbnailException(ew.requestId, ew.userMessage, (ThumbnailError) (ew.errValue));
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code format}.
         *
         * @param format  The format for the thumbnail image, jpeg (default) or
         *     png. For  images that are photos, jpeg should be preferred, while
         *     png is  better for screenshots and digital arts.
         */
        public GetThumbnailBuilder format(ThumbnailFormat format)
        {
            this.format = format;
            return this;
        }

        /**
         * Set value for optional request field {@code size}.
         *
         * @param size  The size for the thumbnail image.
         */
        public GetThumbnailBuilder size(ThumbnailSize size)
        {
            this.size = size;
            return this;
        }

        /**
         * Issues the request.
         */
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
     *
     * @param path  The path to the image file you want to thumbnail. {@code
     *     path} must match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public GetThumbnailBuilder getThumbnailBuilder(String path)
    {
        return new GetThumbnailBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#getPreviewBuilder}.
     */
    public static class GetPreviewException extends DbxApiException {
        /**
         * The error reported by getPreview.
         */
        public final PreviewError errorValue;

        public GetPreviewException(String requestId, LocalizedText userMessage, PreviewError errorValue) {
            super(requestId, userMessage, buildMessage("get_preview", userMessage, errorValue));
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
            return client.downloadStyle(client.getHost().content,
                                        "2/files/get_preview",
                                        arg,
                                        false,
                                        PreviewArg._writer,
                                        FileMetadata._reader,
                                        PreviewError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetPreviewException(ew.requestId, ew.userMessage, (PreviewError) (ew.errValue));
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code rev}.
         *
         * @param rev  Deprecated. Please specify revision in :field:'path'
         *     instead. {@code rev} must have length of at least 9 and match
         *     pattern "{@code [0-9a-f]+}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetPreviewBuilder rev(String rev)
        {
            if (rev != null) {
                if (rev.length() < 9) {
                    throw new IllegalArgumentException("String is shorter than 9");
                }
                if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                    throw new IllegalArgumentException("String does not match pattern");
                }
            }
            this.rev = rev;
            return this;
        }

        /**
         * Issues the request.
         */
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
     *
     * @param path  The path of the file to preview. {@code path} must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public GetPreviewBuilder getPreviewBuilder(String path)
    {
        return new GetPreviewBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxFiles#listRevisions(String,long)}.
     */
    public static class ListRevisionsException extends DbxApiException {
        /**
         * The error reported by listRevisions.
         */
        public final ListRevisionsError errorValue;

        public ListRevisionsException(String requestId, LocalizedText userMessage, ListRevisionsError errorValue) {
            super(requestId, userMessage, buildMessage("list_revisions", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/list_revisions",
                                   arg,
                                   false,
                                   ListRevisionsArg._writer,
                                   ListRevisionsResult._reader,
                                   ListRevisionsError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListRevisionsException(ew.requestId, ew.userMessage, (ListRevisionsError) (ew.errValue));
        }
    }
    /**
     * Return revisions of a file
     *
     * @param path  The path to the file you want to see the revisions of.
     *     {@code path} must match pattern "{@code /.*}" and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult listRevisions(String path)
          throws ListRevisionsException, DbxException
    {
        ListRevisionsArg arg = new ListRevisionsArg(path, null);
        return listRevisions(arg);
    }
    /**
     * Return revisions of a file
     *
     * @param path  The path to the file you want to see the revisions of.
     *     {@code path} must match pattern "{@code /.*}" and not be {@code
     *     null}.
     * @param limit  The maximum number of revision entries returned. {@code
     *     limit} must be greater than or equal to 1 and be less than or equal
     *     to 100.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult listRevisions(String path, long limit)
          throws ListRevisionsException, DbxException
    {
        ListRevisionsArg arg = new ListRevisionsArg(path, limit);
        return listRevisions(arg);
    }

    /**
     * Exception thrown by {@link DbxFiles#restore(String,String)}.
     */
    public static class RestoreException extends DbxApiException {
        /**
         * The error reported by restore.
         */
        public final RestoreError errorValue;

        public RestoreException(String requestId, LocalizedText userMessage, RestoreError errorValue) {
            super(requestId, userMessage, buildMessage("restore", userMessage, errorValue));
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
            return client.rpcStyle(client.getHost().api,
                                   "2/files/restore",
                                   arg,
                                   false,
                                   RestoreArg._writer,
                                   FileMetadata._reader,
                                   RestoreError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RestoreException(ew.requestId, ew.userMessage, (RestoreError) (ew.errValue));
        }
    }
    /**
     * Restore a file to a specific revision
     *
     * @param path  The path to the file you want to restore. {@code path} must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param rev  The revision to restore for the file. {@code rev} must have
     *     length of at least 9, match pattern "{@code [0-9a-f]+}", and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public FileMetadata restore(String path, String rev)
          throws RestoreException, DbxException
    {
        RestoreArg arg = new RestoreArg(path, rev);
        return restore(arg);
    }
}
