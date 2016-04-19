package com.dropbox.core.v1;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.Collector;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * Represents a single "page" of results from a delta-style API call.  This is the more
 * generic version of {@link DbxDelta} object.
 *
 * @param <C>
 *     The type of value used to aggregate all the delta entries.  For example, if you
 *     process the delta entries as they come in and throw the rest away
 */
public class DbxDeltaC<C> extends Dumpable
{
    /**
     * If {@code true}, then you should reset your local state to be an empty
     * folder before processing the list of delta entries.
     *
     * <p>
     * This is always {@code true} for the first delta result, but for subsequent results
     * it is true only in {@code true} rare situations.  For example, if Dropbox
     * changes their cursor format, or if a user asks Dropbox to completely reset his/her
     * account, then the next time you call a delta API it may send down a reset and
     * start you from scratch.
     * </p>
     */
    public final boolean reset;

    /**
     * Apply these entries to your local state to catch up with the Dropbox server's state.
     */
    public final C entries;

    /**
     * A string that is used by the server to keep track of which entries have already been
     * returned to you.  This is what you pass in to the next API call to continue where you
     * left off.
     *
     * <p>
     * This cursor is valid for a long time.  You'd typically store this somewhere persistent
     * (such as a database) so you can resume continue you left off.
     * </p>
     */
    public final String cursor;

    /**
     * If {@code true}, then there are more entries available.  You can retrieve
     * them immediately by making the call again (passing in {@link #cursor}).
     * If {@code false}, then wait at least 5 minutes before checking again.
     */
    public final boolean hasMore;

    /**
     * @param reset {@link #reset}
     * @param entries {@link #entries}
     * @param cursor {@link #cursor}
     * @param hasMore {@link #hasMore}
     */
    public DbxDeltaC(boolean reset, C entries, String cursor, boolean hasMore)
    {
        this.reset = reset;
        this.entries = entries;
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    protected void dumpFields(DumpWriter out)
    {
        out.f("reset").v(reset);
        out.f("cursor").v(cursor);
        out.f("entries").v(hasMore);
        // TODO: Figure out how to print 'entries'.  Might be too much to make it a Dumpable?
    }

    /**
     * For JSON parsing.
     */
    public static final class Reader<C, MD extends Dumpable> extends JsonReader<DbxDeltaC<C>>
    {
        public final JsonReader<MD> metadataReader;
        public final Collector<DbxDeltaC.Entry<MD>, C> entryCollector;

        public Reader(JsonReader<MD> metadataReader, Collector<DbxDeltaC.Entry<MD>, C> entryCollector)
        {
            this.metadataReader = metadataReader;
            this.entryCollector = entryCollector;
        }

        public DbxDeltaC<C> read(JsonParser parser) throws IOException, JsonReadException
        {
            return read(parser, metadataReader, entryCollector);
        }

        public static <C, MD extends Dumpable> DbxDeltaC<C> read(JsonParser parser, JsonReader<MD> metadataReader, Collector<DbxDeltaC.Entry<MD>, C> entryCollector)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            Boolean reset = null;
            C entries = null;
            String cursor = null;
            Boolean has_more = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                JsonReader.nextToken(parser);

                int fi = FM.get(fieldName);
                try {
                    if (fi == -1) {
                        // Unknown field.  Skip over it.
                        JsonReader.skipValue(parser);
                        continue;
                    }
                    switch (fi) {
                        case FM_reset: reset = JsonReader.BooleanReader.readField(parser, fieldName, reset); break;
                        case FM_entries:
                            JsonReader<Entry<MD>> entryReader = new Entry.Reader<MD>(metadataReader);
                            entries = JsonArrayReader.mk(entryReader, entryCollector).readField(parser, fieldName, entries);
                            break;
                        case FM_cursor: cursor = JsonReader.StringReader.readField(parser, fieldName, cursor); break;
                        case FM_has_more: has_more = JsonReader.BooleanReader.readField(parser, fieldName, has_more); break;
                        default:
                            throw new AssertionError("bad index: " + fi + ", field = \"" + fieldName + "\"");
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (reset == null) throw new JsonReadException("missing field \"path\"", top);
            if (entries == null) throw new JsonReadException("missing field \"entries\"", top);
            if (cursor == null) throw new JsonReadException("missing field \"cursor\"", top);
            if (has_more == null) throw new JsonReadException("missing field \"has_more\"", top);

            return new DbxDeltaC<C>(reset, entries, cursor, has_more);
        }

        private static final int FM_reset = 0;
        private static final int FM_entries = 1;
        private static final int FM_cursor = 2;
        private static final int FM_has_more = 3;
        private static final JsonReader.FieldMapping FM;

        static {
            JsonReader.FieldMapping.Builder b = new JsonReader.FieldMapping.Builder();
            b.add("reset", FM_reset);
            b.add("entries", FM_entries);
            b.add("cursor", FM_cursor);
            b.add("has_more", FM_has_more);
            FM = b.build();
        }
    }

    /**
     * A single "delta entry" in a {@link DbxDeltaC} page.
     *
     * @param <MD>
     *     The type of metadata being returned in the delta results.
     */
    public static final class Entry<MD extends Dumpable> extends Dumpable
    {
        /**
         * The lower-cased path of the entry.  Dropbox compares file paths in a
         * case-insensitive manner.  For example, an entry for {@code "/readme.txt"}
         * should overwrite the entry for {@code "/ReadMe.TXT"}.
         *
         * <p>
         * To get the original case-preserved path, look in the {@link #metadata metadata} field.
         * </p>
         */
        public final String lcPath;

        /**
         * If this is {@code null}, it means that this path doesn't exist on
         * on Dropbox's copy of the file system.  To update your local state to
         * match, delete whatever is at that path, including any children.
         * If your local state doesn't have anything at this path, ignore this entry.
         *
         * <p>
         * If this is not {@code null}, it means that Dropbox has a file/folder
         * at this path with the given metadata.  To update your local state to match,
         * add the entry to your local state as well.
         * </p>
         * <ul>
         * <li>
         *     If the path refers to parent folders that don't exist yet in your local
         *     state, create those parent folders in your local state.
         * </li>
         * <li>
         *     If the metadata is for a file, replace whatever your local state has at
         *     that path with the new entry.
         * </li>
         * <li>
         *     If the metadata is for a folder, check what your local state has at the
         *     path.  If it's a file, replace it with the new entry.  If it's a folder,
         *     apply the new metadata to the folder, but do not modify the folder's
         *     children.
         * </li>
         * </ul>
         */
        public final /*@Nullable*/MD metadata;

        /**
         * @param lcPath {@link #lcPath}
         * @param metadata {@link #metadata}
         */
        public Entry(String lcPath, /*@Nullable*/MD metadata)
        {
            this.lcPath = lcPath;
            this.metadata = metadata;
        }

        protected void dumpFields(DumpWriter out)
        {
            out.f("lcPath").v(lcPath);
            out.f("metadata").v(metadata);
        }

        /**
         * For JSON parsing.
         */
        public static final class Reader<MD extends Dumpable> extends JsonReader<Entry<MD>>
        {
            public final JsonReader<MD> metadataReader;

            public Reader(JsonReader<MD> metadataReader)
            {
                this.metadataReader = metadataReader;
            }

            public Entry<MD> read(JsonParser parser) throws IOException, JsonReadException
            {
                return read(parser, metadataReader);
            }

            public static <MD extends Dumpable> Entry<MD> read(JsonParser parser, JsonReader<MD> metadataReader)
                throws IOException, JsonReadException
            {
                JsonLocation arrayStart = JsonReader.expectArrayStart(parser);

                if (JsonReader.isArrayEnd(parser)) {
                    throw new JsonReadException("expecting a two-element array of [path, metadata], found a zero-element array", arrayStart);
                }

                String lcPath;
                try {
                    lcPath = JsonReader.StringReader.read(parser);
                }
                catch (JsonReadException ex) {
                    throw ex.addArrayContext(0);
                }

                if (JsonReader.isArrayEnd(parser)) {
                    throw new JsonReadException("expecting a two-element array of [path, metadata], found a one-element array", arrayStart);
                }

                /*@Nullable*/MD metadata;
                try {
                    metadata = metadataReader.readOptional(parser);
                }
                catch (JsonReadException ex) {
                    throw ex.addArrayContext(1);
                }

                if (!JsonReader.isArrayEnd(parser)) {
                    throw new JsonReadException("expecting a two-element array of [path, metadata], found more than two elements", arrayStart);
                }

                parser.nextToken();

                return new Entry<MD>(lcPath, metadata);
            }
        }
    }
}

