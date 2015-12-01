package com.dropbox.core.v1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.json.*;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.PolyNull; */

/**
 * Holds the metadata for a Dropbox file system entry.  Can either be a regular file or a folder.
 */
public abstract class DbxEntry extends Dumpable implements Serializable
{
    public static final long serialVersionUID = 0;

    /**
     * Just the last part of {@link #path}.  Derived automatically from {@link #path}.
     *
     * @see DbxPathV1#getName
     */
    public final String name;

    /**
     * The path to the file or folder, relative to your application's root.
     * The path always starts with a {@code "/"}.
     *
     * <p>
     * For full-Dropbox apps, the path is relative to the root
     * of the user's Dropbox.  For App Folder apps, the path
     * is relative to your application's App Folder within the user's Dropbox.
     * </p>
     */
    public final String path;

    /**
     * The name of the icon to use for this file.  The set of names returned by this call match up
     * with icons in a set of icons provided by Dropbox.  Read more about the <em>icon</em>
     * field in <a href="https://www.dropbox.com/developers/reference/api#metadata">
     * Dropbox's documentation for the {@code /metadata} HTTP endpoint</a>.
     */
    public final String iconName;

    /**
     * Whether this file or folder might have a thumbnail image you can retrieve via
     * the {@link DbxClientV1#getThumbnail DbxClientV1.getThumbnail} call.
     * If this is {@code true}, there might be a thumbnail available.  If this is
     * {@code false}, there is definitely no thumbnail available.
     */
    public final boolean mightHaveThumbnail;

    /**
     * @param path {@link #path}
     * @param iconName {@link #iconName}
     * @param mightHaveThumbnail {@link #mightHaveThumbnail}
     */
    private DbxEntry(String path, String iconName, boolean mightHaveThumbnail)
    {
        this.name = DbxPathV1.getName(path);
        this.path = path;
        this.iconName = iconName;
        this.mightHaveThumbnail = mightHaveThumbnail;
    }

    protected void dumpFields(DumpWriter w)
    {
        w.v(path);
        w.f("iconName").v(iconName);
        w.f("mightHaveThumbnail").v(mightHaveThumbnail);
    }

    /**
     * Whether this metadata is for a folder, which can be cast to type
     * {@link Folder}.  (Every metadata object is either for a file or a folder.)
     */
    public abstract boolean isFolder();

    /**
     * Whether this metadata is for a file, which can be cast to type
     * {@link File}.  (Every metadata object is either for a file or a folder.)
     */
    public abstract boolean isFile();

    /**
     * If this metadata entry is a folder, return it as a {@code DbxEntry.Folder}
     * instance.  If it's not a folder, return {@code null}.
     */
    public abstract Folder asFolder();

    /**
     * If this metadata entry is a file, return it as a {@code DbxEntry.File}
     * instance.  If it's not a file, return {@code null}.
     */
    public abstract File asFile();

    protected boolean partialEquals(DbxEntry o)
    {
        if (!name.equals(o.name)) return false;
        if (!path.equals(o.path)) return false;
        if (!iconName.equals(o.iconName)) return false;
        if (mightHaveThumbnail != o.mightHaveThumbnail) return false;
        return true;
    }

    protected int partialHashCode()
    {
        int h = name.hashCode();
        h = h*31 + path.hashCode();
        h = h*31 + iconName.hashCode();
        h = h*31 + path.hashCode();
        h = h*31 + (mightHaveThumbnail ? 1 : 0);
        return h;
    }

    /**
     * The subclass of {@link DbxEntry} used to represent folder metadata.  Folders
     * actually only have the same set of fields as {@link DbxEntry}.
     */
    public static final class Folder extends DbxEntry
    {
        public static final long serialVersionUID = 0;

        /**
         * @param path {@link #path}
         * @param iconName {@link #iconName}
         * @param mightHaveThumbnail {@link #mightHaveThumbnail}
         */
        public Folder(String path, String iconName, boolean mightHaveThumbnail)
        {
            super(path, iconName, mightHaveThumbnail);
        }

        protected String getTypeName() { return "Folder"; }

        public boolean isFolder() { return true; }
        public boolean isFile() { return false; }
        public Folder asFolder() { return this; }
        public File asFile() { throw new RuntimeException("not a file"); }

        public static final JsonReader<DbxEntry.Folder> Reader = new JsonReader<DbxEntry.Folder>()
        {
            public final DbxEntry.Folder read(JsonParser parser)
                throws IOException, JsonReadException
            {
                JsonLocation top = parser.getCurrentLocation();
                DbxEntry e = DbxEntry.read(parser, null).entry;
                if (!(e instanceof DbxEntry.Folder)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", top);
                }
                return (DbxEntry.Folder) e;
            }

        };

        public boolean equals(/*@Nullable*/Object o)
        {
            return o != null && getClass().equals(o.getClass()) && equals((Folder) o);
        }

        public boolean equals(Folder o)
        {
            if (!partialEquals(o)) return false;
            return true;
        }

        public int hashCode()
        {
            return partialHashCode();
        }
    }

    /**
     * The subclass of {@link DbxEntry} used to represent file metadata (as opposed
     * to folder metadata).
     */
    public static final class File extends DbxEntry
    {
        public static final long serialVersionUID = 0;

        /**
         * The size, in bytes, of the file content.
         */
        public final long numBytes;

        /**
         * A human-readable string version of the file size (ex: "13 kb").  This string will
         * be localized based on the {@link java.util.Locale Locale} in {@link DbxRequestConfig#userLocale}
         * (passed in to the {@link DbxClientV1} constructor).
         */
        public final String humanSize;

        /**
         * The time the file was added, moved, or last had it's contents changed on the Dropbox
         * server.  (This probably won't match the time on the Dropbox user's filesystem.  For that
         * the {@link #clientMtime} is a better estimate.)
         *
         */
        public final Date lastModified;

        /**
         * The modification time sent up by the Dropbox desktop client when the file was added
         * or modified.  This time is based on the system clock of the particular host that the
         * client was running on, as opposed to the system clock of the Dropbox servers.
         *
         * <p>
         * This field <em>should not</em> be used to determine if a file has changed, but only as
         * a way to sort files by date (when displaying a list of files to the user).
         * </p>
         */
        public final Date clientMtime;

        /**
         * The revision of the file at this path.  This can be used with {@link DbxClientV1#uploadFile}
         * and the {@link DbxWriteMode#update} mode to make sure you're overwriting the revision of
         * the file you think you're overwriting.
         */
        public final String rev;

        /**
         * If this file is a photo, this may contain additional photo-related information.  This field is
         * only populated if you use the {@code includeMediaInfo}
         */
        public final /*@Nullable*/PhotoInfo photoInfo;

        /**
         * Contains details about this file if it is a video
         */
        public final /*@Nullable*/VideoInfo videoInfo;

        /**
         * @param path {@link #path}
         * @param iconName {@link #iconName}
         * @param mightHaveThumbnail {@link #mightHaveThumbnail}
         * @param numBytes {@link #numBytes}
         * @param humanSize {@link #humanSize}
         * @param lastModified {@link #lastModified}
         * @param clientMtime {@link #clientMtime}
         * @param rev {@link #rev}
         * @param photoInfo {@link #photoInfo}
         * @param videoInfo {@link #videoInfo}
         */
        public File(String path, String iconName, boolean mightHaveThumbnail, long numBytes, String humanSize,
                    Date lastModified, Date clientMtime, String rev,
                    /*@Nullable*/PhotoInfo photoInfo, /*@Nullable*/VideoInfo videoInfo)
        {
            super(path, iconName, mightHaveThumbnail);
            this.numBytes = numBytes;
            this.humanSize = humanSize;
            this.lastModified = lastModified;
            this.clientMtime = clientMtime;
            this.rev = rev;
            this.photoInfo = photoInfo;
            this.videoInfo = videoInfo;
        }

        /**
         * Same as the other constructor except {@link #photoInfo} and {@link #videoInfo} are set to {@code null}.
         */
        public File(String path, String iconName, boolean mightHaveThumbnail, long numBytes, String humanSize,
                    Date lastModified, Date clientMtime, String rev)
        {
            this(path, iconName, mightHaveThumbnail, numBytes, humanSize, lastModified, clientMtime, rev, null, null);
        }

        protected void dumpFields(DumpWriter w)
        {
            super.dumpFields(w);
            w.f("numBytes").v(numBytes);
            w.f("humanSize").v(humanSize);
            w.f("lastModified").v(lastModified);
            w.f("clientMtime").v(clientMtime);
            w.f("rev").v(rev);
            File.<PhotoInfo>nullablePendingField(w, "photoInfo", photoInfo, PhotoInfo.PENDING);
            File.<VideoInfo>nullablePendingField(w, "videoInfo", videoInfo, VideoInfo.PENDING);
        }

        private static <T extends Dumpable> void nullablePendingField(
            DumpWriter w, String fieldName, /*@Nullable*/T value, T pendingValue)
        {
            if (value == null) return;

            w.f(fieldName);
            if (value == pendingValue) {
                w.verbatim("pending");
            } else {
                w.v(value);
            }
        }

        protected String getTypeName() { return "File"; }

        public boolean isFolder() { return false; }
        public boolean isFile() { return true; }
        public Folder asFolder() { throw new RuntimeException("not a folder"); }
        public File asFile() { return this; }

        public static final JsonReader<DbxEntry.File> Reader = new JsonReader<DbxEntry.File>()
        {
            public final DbxEntry.File read(JsonParser parser)
                throws IOException, JsonReadException
            {
                JsonLocation top = parser.getCurrentLocation();
                DbxEntry e = DbxEntry.read(parser, null).entry;
                if (!(e instanceof DbxEntry.File)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", top);
                }
                return (DbxEntry.File) e;
            }

        };

        public static final JsonReader<DbxEntry./*@Nullable*/File> ReaderMaybeDeleted = new JsonReader<DbxEntry./*@Nullable*/File>()
        {
            public final DbxEntry./*@Nullable*/File read(JsonParser parser)
                throws IOException, JsonReadException
            {
                JsonLocation top = parser.getCurrentLocation();
                WithChildrenC<?> wc = DbxEntry._read(parser, null, true);
                if (wc == null) return null;
                DbxEntry e = wc.entry;
                if (!(e instanceof DbxEntry.File)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", top);
                }
                return (DbxEntry.File) e;
            }

        };

        public boolean equals(/*@Nullable*/Object o)
        {
            return o != null && getClass().equals(o.getClass()) && equals((File) o);
        }

        public boolean equals(File o)
        {
            if (!partialEquals(o)) return false;
            if (numBytes != o.numBytes) return false;
            if (!humanSize.equals(o.humanSize)) return false;
            if (!lastModified.equals(o.lastModified)) return false;
            if (!clientMtime.equals(o.clientMtime)) return false;
            if (!rev.equals(o.rev)) return false;
            if (!LangUtil.nullableEquals(photoInfo, o.photoInfo)) return false;
            if (!LangUtil.nullableEquals(videoInfo, o.videoInfo)) return false;
            return true;
        }

        public int hashCode()
        {
            // Not including 'humanSize' since it's mostly derivable from 'numBytes'
            int h = partialHashCode();
            h = h*31 + (int) numBytes;
            h = h*31 + lastModified.hashCode();
            h = h*31 + clientMtime.hashCode();
            h = h*31 + rev.hashCode();
            h = h*31 + LangUtil.nullableHashCode(photoInfo);
            h = h*31 + LangUtil.nullableHashCode(videoInfo);
            return h;
        }

        /**
         * Photo metadata that the Dropbox server extracted from the photo file.
         */
        public static final class PhotoInfo extends Dumpable
        {
            /**
             * When the photo was taken.
             */
            public final /*@Nullable*/Date timeTaken;

            /**
             * Where the photo was taken.
             */
            public final /*@Nullable*/Location location;

            public PhotoInfo(/*@Nullable*/Date timeTaken, /*@Nullable*/Location location) {
                this.timeTaken = timeTaken;
                this.location = location;
            }

            public static JsonReader<PhotoInfo> Reader = new JsonReader<PhotoInfo>()
            {
                @Override
                public PhotoInfo read(JsonParser parser)
                    throws IOException, JsonReadException
                {
                    JsonReader.expectObjectStart(parser);
                    Date time_taken = null;
                    File.Location location = null;
                    while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                        String fieldName = parser.getCurrentName();
                        JsonReader.nextToken(parser);
                        if (fieldName.equals("lat_long")) {
                            location = Location.Reader.read(parser);
                        } else if (fieldName.equals("time_taken")) {
                            time_taken = JsonDateReader.Dropbox.readOptional(parser);
                        } else {
                            JsonReader.skipValue(parser);
                        }
                    }
                    JsonReader.expectObjectEnd(parser);
                    return new File.PhotoInfo(time_taken, location);
                }
            };

            public static final PhotoInfo PENDING = new PhotoInfo(null, null);

            @Override
            protected void dumpFields(DumpWriter w)
            {
                w.f("timeTaken").v(timeTaken);
                w.f("location").v(location);
            }

            @Override
            public boolean equals(/*@Nullable*/Object o)
            {
                return o != null && getClass().equals(o.getClass()) && equals((PhotoInfo) o);
            }

            public boolean equals(PhotoInfo o)
            {
                // For "pending" values, it must be an exact match.
                if (o == PENDING || this == PENDING) return o == this;
                if (!LangUtil.nullableEquals(timeTaken, o.timeTaken)) return false;
                if (!LangUtil.nullableEquals(location, o.location)) return false;
                return true;
            }

            @Override
            public int hashCode()
            {
                int h = 0;
                h = h*31 + LangUtil.nullableHashCode(timeTaken);
                h = h*31 + LangUtil.nullableHashCode(location);
                return h;
            }
        }

        /**
         * Video metadata that the Dropbox server extracted from the video file.
         */
        public static final class VideoInfo extends Dumpable
        {
            /**
             * When the video was recorded.
             */
            public final /*@Nullable*/Date timeTaken;

            /**
             * Where the video was recorded.
             */
            public final /*@Nullable*/Location location;

            /**
             * The duration of the video, in seconds.
             */
            public final /*@Nullable*/Long duration;

            public VideoInfo(/*@Nullable*/Date timeTaken, /*@Nullable*/Location location, /*@Nullable*/Long duration)
            {
                this.timeTaken = timeTaken;
                this.location = location;
                this.duration = duration;
            }

            public static JsonReader<VideoInfo> Reader = new JsonReader<VideoInfo>()
            {
                @Override
                public VideoInfo read(JsonParser parser)
                    throws IOException, JsonReadException
                {
                    JsonReader.expectObjectStart(parser);
                    File.Location location = null;
                    Date time_taken = null;
                    Long duration = null;
                    while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                        String fieldName = parser.getCurrentName();
                        JsonReader.nextToken(parser);
                        if (fieldName.equals("lat_long")) {
                            location = Location.Reader.read(parser);
                        } else if (fieldName.equals("time_taken")) {
                            time_taken = JsonDateReader.Dropbox.readOptional(parser);
                        } else if (fieldName.equals("duration")) {
                            duration = JsonReader.UnsignedLongReader.readOptional(parser);
                        } else {
                            JsonReader.skipValue(parser);
                        }
                    }
                    JsonReader.expectObjectEnd(parser);
                    return new File.VideoInfo(time_taken, location, duration);
                }
            };

            /**
             * The singleton value used when the Dropbox server returns "pending" for
             */
            public static final VideoInfo PENDING = new VideoInfo(null, null, null);

            @Override
            protected void dumpFields(DumpWriter w)
            {
                w.f("timeTaken").v(timeTaken);
                w.f("location").v(location);
                w.f("duration").v(duration);
            }

            @Override
            public boolean equals(/*@Nullable*/Object o)
            {
                return o != null && getClass().equals(o.getClass()) && equals((VideoInfo) o);
            }

            public boolean equals(VideoInfo o)
            {
                // For "pending" values, it must be an exact match.
                if (o == PENDING || this == PENDING) return o == this;
                if (!LangUtil.nullableEquals(timeTaken, o.timeTaken)) return false;
                if (!LangUtil.nullableEquals(location, o.location)) return false;
                if (!LangUtil.nullableEquals(duration, o.duration)) return false;
                return true;
            }

            @Override
            public int hashCode()
            {
                int h = 0;
                h = h*31 + LangUtil.nullableHashCode(timeTaken);
                h = h*31 + LangUtil.nullableHashCode(location);
                h = h*31 + LangUtil.nullableHashCode(duration);
                return h;
            }
        }

        /**
         * A geo location
         */
        public static class Location extends Dumpable
        {
            public final double latitude;
            public final double longitude;

            public Location(double latitude, double longitude) {
                this.latitude = latitude;
                this.longitude = longitude;
            }

            public static JsonReader</*@Nullable*/Location> Reader = new JsonReader</*@Nullable*/Location>()
            {
                @Override
                public /*@Nullable*/Location read(JsonParser parser)
                    throws IOException, JsonReadException
                {
                    Location location = null;
                    if (JsonArrayReader.isArrayStart(parser)) {
                        JsonReader.expectArrayStart(parser);
                        double latitude = JsonReader.readDouble(parser);
                        double longitude = JsonReader.readDouble(parser);
                        location = new Location(latitude,longitude);
                        JsonReader.expectArrayEnd(parser);
                    } else {
                        JsonReader.skipValue(parser);
                    }
                    return location;

                }
            };

            @Override
            protected void dumpFields(DumpWriter w)
            {
                w.f("latitude").v(latitude);
                w.f("longitude").v(longitude);
            }

            @Override
            public boolean equals(/*@Nullable*/Object o)
            {
                return o != null && getClass().equals(o.getClass()) && equals((Location) o);
            }

            public boolean equals(Location o)
            {
                if (latitude != o.latitude) return false;
                if (longitude != o.longitude) return false;
                return true;
            }
        }
    }

    // ------------------------------------------------------
    // JSON parsing

    public static final JsonReader<DbxEntry> Reader = new JsonReader<DbxEntry>()
    {
        public final DbxEntry read(JsonParser parser)
            throws IOException, JsonReadException
        {
            return DbxEntry.read(parser, null).entry;
        }
    };

    public static final JsonReader</*@Nullable*/DbxEntry> ReaderMaybeDeleted = new JsonReader</*@Nullable*/DbxEntry>()
    {
        public final /*@Nullable*/DbxEntry read(JsonParser parser)
            throws IOException, JsonReadException
        {
            WithChildrenC<?> wc = DbxEntry.readMaybeDeleted(parser, null);
            if (wc == null) return null;
            return wc.entry;
        }
    };

    /**
     * Holds the metadata for a file or folder; if it's a folder, we also store the folder's
     * hash and the metadata of its immediate children.
     *
     * @see DbxClientV1#getMetadataWithChildren
     * @see DbxClientV1#getMetadataWithChildrenIfChanged
     */
    public static final class WithChildren extends Dumpable implements Serializable
    {
        public static final long serialVersionUID = 0;

        /**
         * The metadata for the base file or folder.
         */
        public final DbxEntry entry;

        /**
         * If {@link #entry} is a folder, this will contain a hash that identifies the folder's
         * contents.  This value can be used with {@link DbxClientV1#getMetadataWithChildrenIfChanged}
         * to void downloading the folder contents if they havne't changed.
         */
        public final /*@PolyNull*/String hash;

        /**
         * If {@link #entry} is a folder, this will contain the metadata of the folder's
         * immediate children.  If it's not a folder, this will be {@code null}.
         */
        public final /*@PolyNull*/List<DbxEntry> children;

        /**
         * @param entry {@link #entry}
         * @param hash {@link #hash}
         * @param children {@link #children}
         */
        public WithChildren(DbxEntry entry, /*@PolyNull*/String hash, /*@PolyNull*/List<DbxEntry> children)
        {
            this.entry = entry;
            this.hash = hash;
            this.children = children;
        }

        public static final JsonReader<WithChildren> Reader = new JsonReader<WithChildren>()
        {
            public final WithChildren read(JsonParser parser)
                throws IOException, JsonReadException
            {
                WithChildrenC<List<DbxEntry>> c = DbxEntry.<List<DbxEntry>>read(parser, new Collector.ArrayListCollector<DbxEntry>());
                return new WithChildren(c.entry, c.hash, c.children);
            }
        };

        public static final JsonReader</*@Nullable*/WithChildren> ReaderMaybeDeleted = new JsonReader</*@Nullable*/WithChildren>()
        {
            public final /*@Nullable*/WithChildren read(JsonParser parser)
                throws IOException, JsonReadException
            {
                WithChildrenC<List<DbxEntry>> c = DbxEntry.<List<DbxEntry>>readMaybeDeleted(parser, new Collector.ArrayListCollector<DbxEntry>());
                if (c == null) return null;
                return new WithChildren(c.entry, c.hash, c.children);
            }
        };

        public boolean equals(/*@Nullable*/Object o)
        {
            return o != null && getClass().equals(o.getClass()) && equals((WithChildren) o);
        }

        public boolean equals(WithChildren o)
        {
            if (children != null ? !children.equals(o.children) : o.children != null)
                return false;
            if (!entry.equals(o.entry)) return false;
            if (hash != null ? !hash.equals(o.hash) : o.hash != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = entry.hashCode();
            result = 31 * result + (hash != null ? hash.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            return result;
        }

        @Override
        protected void dumpFields(DumpWriter w)
        {
            w.v(entry);
            w.f("hash").v(hash);
            w.f("children").v(children);
        }
    }

    /**
     * The more general case of {@link WithChildren}.  It's used in the {@code C}-suffixed
     * variants ({@link DbxClientV1#getMetadataWithChildrenC} and {@link DbxClientV1#getMetadataWithChildrenIfChanged}
     * to allow you to process the {@link DbxEntry} values as the come in and aggregate them into
     * your own object (instead of the default {@link List}) using a custom {@link Collector}.
     */
    public static final class WithChildrenC<C> extends Dumpable implements Serializable
    {
        public static final long serialVersionUID = 0;

        public final DbxEntry entry;

        /**
         * If {@link #entry} is a folder, this will contain a hash that identifies the folder's
         * contents.  This value can be used with {@link DbxClientV1#getMetadataWithChildrenIfChanged}
         * to void downloading the folder contents if they havne't changed.
         */
        public final /*@PolyNull*/String hash;

        /**
         * If {@link #entry} is a folder, this will contain the metadata of the folder's
         * immediate children.  If it's not a folder, this will be {@code null}.
         */
        public final /*@PolyNull*/C children;

        /**
         * @param entry {@link #entry}
         * @param hash {@link #hash}
         * @param children {@link #children}
         */
        public WithChildrenC(DbxEntry entry, /*@PolyNull*/String hash, /*@PolyNull*/C children)
        {
            this.entry = entry;
            this.hash = hash;
            this.children = children;
        }

        public static class Reader<C> extends JsonReader<WithChildrenC<C>>
        {
            private final Collector<DbxEntry,? extends C> collector;
            public Reader(Collector<DbxEntry,? extends C> collector) { this.collector = collector; }

            public final WithChildrenC<C> read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return DbxEntry.read(parser, collector);
            }
        }

        public static class ReaderMaybeDeleted<C> extends JsonReader</*@Nullable*/WithChildrenC<C>>
        {
            private final Collector<DbxEntry,? extends C> collector;
            public ReaderMaybeDeleted(Collector<DbxEntry,? extends C> collector) { this.collector = collector; }

            public final /*@Nullable*/WithChildrenC<C> read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return DbxEntry.readMaybeDeleted(parser, collector);
            }
        }

        @Override
        public boolean equals(/*@Nullable*/Object o)
        {
            return o != null && getClass().equals(o.getClass()) && equals((WithChildrenC) o);
        }

        public boolean equals(WithChildrenC o)
        {
            if (children != null ? !children.equals(o.children) : o.children != null)
                return false;
            if (!entry.equals(o.entry)) return false;
            if (hash != null ? !hash.equals(o.hash) : o.hash != null) return false;

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = entry.hashCode();
            result = 31 * result + (hash != null ? hash.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            return result;
        }

        @Override
        protected void dumpFields(DumpWriter w)
        {
            w.v(entry);
            w.f("hash").v(hash);
            if (children != null) {
                w.f("children").verbatim(children.toString());
            }
        }
    }

    public static <C> /*@Nullable*/WithChildrenC<C> readMaybeDeleted(JsonParser parser, /*@Nullable*/Collector<DbxEntry, ? extends C> collector)
            throws IOException, JsonReadException
    {
        return _read(parser, collector, true);
    }

    public static <C> WithChildrenC<C> read(JsonParser parser, /*@Nullable*/Collector<DbxEntry, ? extends C> collector)
        throws IOException, JsonReadException
    {
        WithChildrenC<C> r = _read(parser, collector, false);
        assert r != null : "@AssumeAssertion(nullness)";
        return r;
    }

    /**
     * @return
 *     {@code null} if the entry is an 'is_deleted' entry.
     */
    private static <C> /*@Nullable*/WithChildrenC<C> _read(JsonParser parser, /*@Nullable*/Collector<DbxEntry, ? extends C> collector, boolean allowDeleted)
        throws IOException, JsonReadException
    {
        JsonLocation top = JsonReader.expectObjectStart(parser);

        String size = null;
        long bytes = -1;
        String path = null;
        Boolean is_dir = null;
        Boolean is_deleted = null;
        String rev = null;
        Boolean thumb_exists = null;
        String icon = null;
        Date modified = null;
        Date client_mtime = null;
        String hash = null;
        C contents = null;
        File.PhotoInfo photo_info = null;
        File.VideoInfo video_info = null;

        while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
            String fieldName = parser.getCurrentName();
            JsonReader.nextToken(parser);

            int fi = FM.get(fieldName);
            try {
                switch (fi) {
                    case -1: JsonReader.skipValue(parser); break;
                    case FM_size: size = JsonReader.StringReader.readField(parser, fieldName, size); break;
                    case FM_bytes: bytes = JsonReader.readUnsignedLongField(parser, fieldName, bytes); break;
                    case FM_path: path = JsonReader.StringReader.readField(parser, fieldName, path); break;
                    case FM_is_dir: is_dir = JsonReader.BooleanReader.readField(parser, fieldName, is_dir); break;
                    case FM_is_deleted: is_deleted = JsonReader.BooleanReader.readField(parser, fieldName, is_deleted); break;
                    case FM_rev: rev = JsonReader.StringReader.readField(parser, fieldName, rev); break;
                    case FM_thumb_exists: thumb_exists = JsonReader.BooleanReader.readField(parser, fieldName, thumb_exists); break;
                    case FM_icon: icon = JsonReader.StringReader.readField(parser, fieldName, icon); break;
                    case FM_modified: modified = JsonDateReader.Dropbox.readField(parser, fieldName, modified); break;
                    case FM_client_mtime: client_mtime = JsonDateReader.Dropbox.readField(parser, fieldName, client_mtime); break;
                    case FM_hash:
                        if (collector == null) throw new JsonReadException("not expecting \"hash\" field, since we didn't ask for children", parser.getCurrentLocation());
                        hash = JsonReader.StringReader.readField(parser, fieldName, hash); break;
                    case FM_contents:
                        if (collector == null) throw new JsonReadException("not expecting \"contents\" field, since we didn't ask for children", parser.getCurrentLocation());
                        contents = JsonArrayReader.mk(Reader, collector).readField(parser, fieldName, contents); break;
                    case FM_photo_info:
                        photo_info = PendingReader.mk(File.PhotoInfo.Reader, File.PhotoInfo.PENDING).readField(parser, fieldName, photo_info);
                        break;
                    case FM_video_info:
                        video_info = PendingReader.mk(File.VideoInfo.Reader, File.VideoInfo.PENDING).readField(parser, fieldName, video_info);
                        break;
                    default:
                        throw new AssertionError("bad index: " + fi + ", field = \"" + fieldName + "\"");
                }
            }
            catch (JsonReadException ex) {
                throw ex.addFieldContext(fieldName);
            }
        }

        JsonReader.expectObjectEnd(parser);

        if (path == null) throw new JsonReadException("missing field \"path\"", top);
        if (icon == null) throw new JsonReadException("missing field \"icon\"", top);
        if (is_deleted == null) is_deleted = Boolean.FALSE;
        if (is_dir == null) is_dir = Boolean.FALSE;
        if (thumb_exists == null) thumb_exists = Boolean.FALSE;

        if (is_dir && (contents != null || hash != null)) {
            if (hash == null) throw new JsonReadException("missing \"hash\", when we asked for children", top);
            if (contents == null) throw new JsonReadException("missing \"contents\", when we asked for children", top);
        }

        DbxEntry e;
        if (is_dir) {
            e = new Folder(path, icon, thumb_exists);
        }
        else {
            // Normal File
            if (size == null) throw new JsonReadException("missing \"size\" for a file entry", top);
            if (bytes == -1) throw new JsonReadException("missing \"bytes\" for a file entry", top);
            if (modified == null) throw new JsonReadException("missing \"modified\" for a file entry", top);
            if (client_mtime == null) throw new JsonReadException("missing \"client_mtime\" for a file entry", top);
            if (rev == null) throw new JsonReadException("missing \"rev\" for a file entry", top);
            e = new File(path, icon, thumb_exists, bytes, size, modified, client_mtime, rev, photo_info, video_info);
        }

        if (is_deleted) {
            if (allowDeleted) {
                return null;
            } else {
                throw new JsonReadException("not expecting \"is_deleted\" entry here", top);
            }
        }
        return new WithChildrenC<C>(e, hash, contents);
    }

    private static final class PendingReader<T> extends JsonReader<T>
    {
        private final JsonReader<T> reader;
        private final T pendingValue;

        public PendingReader(JsonReader<T> reader, T pendingValue)
        {
            this.reader = reader;
            this.pendingValue = pendingValue;
        }

        public static <T> PendingReader<T> mk(JsonReader<T> reader, T pendingValue) { return new PendingReader<T>(reader, pendingValue); }

        @Override
        public T read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonToken token = parser.getCurrentToken();
            if (token == JsonToken.VALUE_STRING) {
                String s = parser.getText();
                if (!s.equals("pending")) {
                    throw new JsonReadException("got a string, but the value wasn't \"pending\"", parser.getTokenLocation());
                }
                parser.nextToken();
                return pendingValue;
            } else {
                return reader.read(parser);
            }
        }
    }

    private static final int FM_size = 0;
    private static final int FM_bytes = 1;
    private static final int FM_path = 2;
    private static final int FM_is_dir = 3;
    private static final int FM_is_deleted = 4;
    private static final int FM_rev = 5;
    private static final int FM_thumb_exists = 6;
    private static final int FM_icon = 7;
    private static final int FM_modified = 8;
    private static final int FM_client_mtime = 9;
    private static final int FM_hash = 10;
    private static final int FM_contents = 11;
    private static final int FM_photo_info = 12;
    private static final int FM_video_info = 13;
    private static final JsonReader.FieldMapping FM;

    static {
        JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
        b.add("size", FM_size);
        b.add("bytes", FM_bytes);
        b.add("path", FM_path);
        b.add("is_dir", FM_is_dir);
        b.add("is_deleted", FM_is_deleted);
        b.add("rev", FM_rev);
        b.add("thumb_exists", FM_thumb_exists);
        b.add("icon", FM_icon);
        b.add("modified", FM_modified);
        b.add("client_mtime", FM_client_mtime);
        b.add("hash", FM_hash);
        b.add("contents", FM_contents);
        b.add("photo_info", FM_photo_info);
        b.add("video_info", FM_video_info);
        FM = b.build();
    }
}
