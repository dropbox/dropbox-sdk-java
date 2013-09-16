package com.dropbox.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dropbox.core.json.*;
import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Holds the metadata for a Dropbox file system entry.  Can either be a regular file or a folder.
 */
public abstract class DbxEntry extends Dumpable implements Serializable
{
    public static final long serialVersionUID = 0;

    /**
     * Just the last part of {@link #path}.  Derived automatically from {@link #path}.
     *
     * @see DbxPath#getName
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
     * the {@link DbxClient#getThumbnail DbxClient.getThumbnail} call.
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
        this.name = DbxPath.getName(path);
        this.path = path;
        this.iconName = iconName;
        this.mightHaveThumbnail = mightHaveThumbnail;
    }

    protected void dumpFields(DumpWriter w)
    {
        w.value(path);
        w.field("iconName", iconName);
        w.field("mightHaveThumbnail", mightHaveThumbnail);
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
                DbxEntry.WithChildrenC<?> ewc = DbxEntry.read(parser, null);
                if (ewc == null) return null;
                DbxEntry e = ewc.entry;
                if (!(e instanceof DbxEntry.Folder)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", top);
                }
                return (DbxEntry.Folder) e;
            }

        };

        public boolean equals(Object o)
        {
            if (!getClass().equals(o.getClass())) return false;
            return equals((Folder) o);
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
         * (passed in to the {@link DbxClient} constructor).
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
         * The revision of the file at this path.  This can be used with {@link DbxClient#uploadFile}
         * and the {@link DbxWriteMode#update} mode to make sure you're overwriting the revision of
         * the file you think you're overwriting.
         */
        public final String rev;

        /**
         * @param path {@link #path}
         * @param iconName {@link #iconName}
         * @param mightHaveThumbnail {@link #mightHaveThumbnail}
         * @param numBytes {@link #numBytes}
         * @param humanSize {@link #humanSize}
         * @param lastModified {@link #lastModified}
         * @param clientMtime {@link #clientMtime}
         * @param rev {@link #rev}
         */
        public File(String path, String iconName, boolean mightHaveThumbnail, long numBytes, String humanSize, Date lastModified, Date clientMtime, String rev)
        {
            super(path, iconName, mightHaveThumbnail);
            this.numBytes = numBytes;
            this.humanSize = humanSize;
            this.lastModified = lastModified;
            this.clientMtime = clientMtime;
            this.rev = rev;
        }

        protected void dumpFields(DumpWriter w)
        {
            super.dumpFields(w);
            w.field("numBytes", numBytes);
            w.field("humanSize", humanSize);
            w.field("lastModified", lastModified);
            w.field("clientMtime", clientMtime);
            w.field("rev", rev);
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
                DbxEntry.WithChildrenC<?> ewc = DbxEntry.read(parser, null);
                if (ewc == null) return null;
                DbxEntry e = ewc.entry;
                if (!(e instanceof DbxEntry.File)) {
                    throw new JsonReadException("Expecting a file entry, got a folder entry", top);
                }
                return (DbxEntry.File) e;
            }

        };

        public boolean equals(Object o)
        {
            if (!getClass().equals(o.getClass())) return false;
            return equals((File) o);
        }

        public boolean equals(File o)
        {
            if (!partialEquals(o)) return false;
            if (numBytes != o.numBytes) return false;
            if (!humanSize.equals(o.humanSize)) return false;
            if (!lastModified.equals(o.lastModified)) return false;
            if (!clientMtime.equals(o.clientMtime)) return false;
            if (!rev.equals(o.rev)) return false;
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
            return h;
        }
    }

    // ------------------------------------------------------
    // JSON parsing

    public static final JsonReader<DbxEntry> Reader = new JsonReader<DbxEntry>()
    {
        public final DbxEntry read(JsonParser parser)
            throws IOException, JsonReadException
        {
            WithChildrenC<?> wc = DbxEntry.read(parser, null);
            if (wc == null) return null;
            return wc.entry;
        }
    };

    /**
     * Holds the metadata for a file or folder; if it's a folder, we also store the folder's
     * hash and the metadata of its immediate children.
     *
     * @see DbxClient#getMetadataWithChildren
     * @see DbxClient#getMetadataWithChildrenIfChanged
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
         * contents.  This value can be used with {@link DbxClient#getMetadataWithChildrenIfChanged}
         * to void downloading the folder contents if they havne't changed.
         */
        public final String hash;

        /**
         * If {@link #entry} is a folder, this will contain the metadata of the folder's
         * immediate children.  If it's not a folder, this will be {@code null}.
         */
        public final List<DbxEntry> children;

        /**
         * @param entry {@link #entry}
         * @param hash {@link #hash}
         * @param children {@link #children}
         */
        public WithChildren(DbxEntry entry, String hash, List<DbxEntry> children)
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
                if (c == null) return null;
                return new WithChildren(c.entry, c.hash, c.children);
            }
        };

        @Override
        public boolean equals(Object o)
        {
            return getClass().equals(o.getClass()) && equals((WithChildren) o);
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
            w.value(entry);
            w.field("hash", hash);
            w.fieldStart("children").list(children);
        }
    }

    /**
     * The more general case of {@link WithChildren}.  It's used in the {@code C}-suffixed
     * variants ({@link DbxClient#getMetadataWithChildrenC} and {@link DbxClient#getMetadataWithChildrenIfChanged}
     * to allow you to process the {@link DbxEntry} values as the come in and aggregate them into
     * your own object (instead of the default {@link List}) using a custom {@link Collector}.
     */
    public static final class WithChildrenC<C> extends Dumpable implements Serializable
    {
        public static final long serialVersionUID = 0;

        public final DbxEntry entry;

        /**
         * If {@link #entry} is a folder, this will contain a hash that identifies the folder's
         * contents.  This value can be used with {@link DbxClient#getMetadataWithChildrenIfChanged}
         * to void downloading the folder contents if they havne't changed.
         */
        public final String hash;

        /**
         * If {@link #entry} is a folder, this will contain the metadata of the folder's
         * immediate children.  If it's not a folder, this will be {@code null}.
         */
        public final C children;

        /**
         * @param entry {@link #entry}
         * @param hash {@link #hash}
         * @param children {@link #children}
         */
        public WithChildrenC(DbxEntry entry, String hash, C children)
        {
            this.entry = entry;
            this.hash = hash;
            this.children = children;
        }

        public static class Reader<C> extends JsonReader<WithChildrenC<C>>
        {
            private final Collector<DbxEntry,? extends C> collector;
            public Reader(Collector<DbxEntry, ? extends C> collector) { this.collector = collector; }

            public final WithChildrenC<C> read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return DbxEntry.read(parser, collector);
            }
        }

        @Override
        public boolean equals(Object o)
        {
            return getClass().equals(o.getClass()) && equals((WithChildren) o);
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
            w.value(entry);
            w.field("hash", hash);
            w.fieldVebatim("children", children.toString());
        }
    }

    /**
     * @return
     *     {@code null} if the entry is an 'is_deleted' entry.
     */
    public static <C> WithChildrenC<C> read(JsonParser parser, Collector<DbxEntry, ? extends C> collector)
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
            e = new File(path, icon, thumb_exists, bytes, size, modified, client_mtime, rev);
        }

        if (is_deleted) return null;
        return new WithChildrenC<C>(e, hash, contents);
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
        FM = b.build();
    }
}
