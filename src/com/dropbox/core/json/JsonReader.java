package com.dropbox.core.json;

import com.dropbox.core.util.IOUtil;
import static com.dropbox.core.util.LangUtil.mkAssert;

import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;

/*>>> import checkers.nullness.quals.Nullable; */

public abstract class JsonReader<T>
{
    public abstract T read(JsonParser parser)
            throws IOException, JsonReadException;

    public T readFromTags(String[] tags, JsonParser parser)
            throws IOException, JsonReadException
    {
        return null;  // Must override for struct
    }

    public T readFields(JsonParser parser)
            throws IOException, JsonReadException
    {
        return null;  // Must override for struct
    }

    public void validate(T value)
    {
        // Base implementation does nothing.
    }

    public final T readField(JsonParser parser, String fieldName, /*@Nullable*/T v)
        throws IOException, JsonReadException
    {
        if (v != null) throw new JsonReadException("duplicate field \"" + fieldName + "\"", parser.getTokenLocation());
        return read(parser);
    }

    public final /*@Nullable*/T readOptional(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() == JsonToken.VALUE_NULL) {
            parser.nextToken();
            return null;
        } else {
            return read(parser);
        }
    }

    /**
     * Helper to read and parse the optional ".tag" field. If one is found, positions the parser
     * at the next field (or the closing brace); otherwise leaves the parser position unchanged.
     * Returns null if there isn't a ".tag" field; otherwise an array of strings (the tags).
     * Initially the parser must be positioned right after the opening brace.
     */
    public static String[] readTags(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() != JsonToken.FIELD_NAME) {
            return null;
        }
        if (!".tag".equals(parser.getCurrentName())) {
            return null;
        }
        parser.nextToken();
        if (parser.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonReadException("expected a string value for .tag field", parser.getTokenLocation());
        }
        String tag = parser.getText();
        parser.nextToken();
        return tag.split("\\.");
    }

    /**
     * A wrapper around 'JsonParser.nextToken' that throws our own better {@link JsonReadException}
     * instead of Jackson's {@link JsonParseException}.
     * <p>
     * JsonParseException is bad for two reasons.  First, it extends IOException, which makes it easy to
     * miss.  Second, there's no way to get the original error message, which makes it hard to chain
     * logical location information (see {@link JsonReadException#addFieldContext} and
     * {@link JsonReadException#addArrayContext}).
     */
    public static JsonToken nextToken(JsonParser parser)
        throws IOException, JsonReadException
    {
        try {
            return parser.nextToken();
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    // ------------------------------------------------------------------
    // Delimiter checking helpers.

    public static JsonLocation expectObjectStart(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new JsonReadException("expecting the start of an object (\"{\")", parser.getTokenLocation());
        }
        JsonLocation loc = parser.getTokenLocation();
        nextToken(parser);
        return loc;
    }

    public static void expectObjectEnd(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() != JsonToken.END_OBJECT) {
            throw new JsonReadException("expecting the end of an object (\"}\")", parser.getTokenLocation());
        }
        nextToken(parser);
    }

    public static JsonLocation expectArrayStart(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() != JsonToken.START_ARRAY) {
            throw new JsonReadException("expecting the start of an array (\"[\")", parser.getTokenLocation());
        }
        JsonLocation loc = parser.getTokenLocation();
        nextToken(parser);
        return loc;
    }

    public static JsonLocation expectArrayEnd(JsonParser parser)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() != JsonToken.END_ARRAY) {
            throw new JsonReadException("expecting the end of an array (\"[\")", parser.getTokenLocation());
        }
        JsonLocation loc = parser.getTokenLocation();
        nextToken(parser);
        return loc;
    }

    public static boolean isArrayEnd(JsonParser parser)
    {
        return (parser.getCurrentToken() == JsonToken.END_ARRAY);
    }

    public static boolean isArrayStart(JsonParser parser)
    {
        return (parser.getCurrentToken() == JsonToken.START_ARRAY);
    }

    public static void skipValue(JsonParser parser)
        throws IOException, JsonReadException
    {
        try {
            parser.skipChildren();
            parser.nextToken();
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    // ------------------------------------------------------------------
    // Helpers for various types.

    public static final JsonReader<Long> UnsignedLongReader = new JsonReader<Long>() {
        @Override
        public Long read(JsonParser parser)
            throws IOException, JsonReadException
        {
            return readUnsignedLong(parser);
        }
    };

    public static long readUnsignedLong(JsonParser parser)
        throws IOException, JsonReadException
    {
        try {
            long v = parser.getLongValue();
            if (v < 0) {
                throw new JsonReadException("expecting a non-negative number, got: " + v, parser.getTokenLocation());
            }
            parser.nextToken();
            return v;
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    public static long readUnsignedLongField(JsonParser parser, String fieldName, long v)
        throws IOException, JsonReadException
    {
        if (v >= 0) throw new JsonReadException("duplicate field \"" + fieldName + "\"", parser.getCurrentLocation());
        return JsonReader.readUnsignedLong(parser);
    }

    public static final JsonReader<Long> Int64Reader = new JsonReader<Long>()
    {
        public Long read(JsonParser parser)
                throws IOException, JsonReadException
        {
            long v = parser.getLongValue();
            parser.nextToken();
            return v;
        }
    };

    public static final JsonReader<Integer> Int32Reader = new JsonReader<Integer>()
    {
        public Integer read(JsonParser parser)
                throws IOException, JsonReadException
        {
            int v = parser.getIntValue();
            parser.nextToken();
            return v;
        }
    };

    // NOTE: This can't read values >= 2**63.
    public static final JsonReader<Long> UInt64Reader = new JsonReader<Long>()
    {
        public Long read(JsonParser parser)
                throws IOException, JsonReadException
        {
            return readUnsignedLong(parser);
        }
    };

    // NOTE: This stores the value in a Long.
    public static final JsonReader<Long> UInt32Reader = new JsonReader<Long>()
    {
        public Long read(JsonParser parser)
                throws IOException, JsonReadException
        {
            long v = readUnsignedLong(parser);
            if (v >= 4294967296L) {
                throw new JsonReadException("expecting a 32-bit unsigned integer, got: " + v, parser.getTokenLocation());
            }
            return v;
        }
    };

    public static final JsonReader<Double> Float64Reader = new JsonReader<Double>()
    {
        public Double read(JsonParser parser)
                throws IOException, JsonReadException
        {
            double v = parser.getDoubleValue();
            parser.nextToken();
            return v;
        }
    };

    public static final JsonReader<Float> Float32Reader = new JsonReader<Float>()
    {
        public Float read(JsonParser parser)
                throws IOException, JsonReadException
        {
            float v = parser.getFloatValue();
            parser.nextToken();
            return v;
        }
    };

    public static final JsonReader<String> StringReader = new JsonReader<String>()
    {
        public String read(JsonParser parser)
            throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }
    };

    public static final JsonReader<byte[]> BinaryReader = new JsonReader<byte[]>()
    {
        public byte[] read(JsonParser parser)
            throws IOException, JsonReadException
        {
            try {
                // TODO: Jackson's base64 parser is more lenient than we want (it allows whitespace
                // and other junk in some places).  Switch to something more strict.
                byte[] v = parser.getBinaryValue();
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }
    };

    public static final JsonReader<Boolean> BooleanReader = new JsonReader<Boolean>()
    {
        public Boolean read(JsonParser parser)
            throws IOException, JsonReadException
        {
            return readBoolean(parser);
        }
    };

    public static boolean readBoolean(JsonParser parser)
        throws IOException, JsonReadException
    {
        try {
            boolean b = parser.getBooleanValue();
            parser.nextToken();
            return b;
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    public static double readDouble(JsonParser parser)
        throws  IOException, JsonReadException
    {
        try {
            double v = parser.getDoubleValue();
            parser.nextToken();
            return v;
        } catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    public static final JsonReader<Object> VoidReader = new JsonReader<Object>()
    {
        public Object read(JsonParser parser)
            throws IOException, JsonReadException
        {
            skipValue(parser);
            return null;
        }
    };

    public static <T> T readEnum(JsonParser parser, HashMap<String,T> values, T catch_all)
        throws IOException, JsonReadException
    {
        if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
            // Allow {".tag": "foo"} or {"foo": <value>} or {".tag": "foo", "foo": <value>}.
            parser.nextToken();
            String text;
            String[] tags = readTags(parser);
            if (tags != null && parser.getCurrentToken() == JsonToken.END_OBJECT) {
                assert tags.length == 1 && tags[0] != null;
                text = tags[0];
            }
            else if (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                text = parser.getText();
                assert tags == null || tags[0].equals(text);
                parser.nextToken();
                skipValue(parser);
            }
            else {
                throw new JsonReadException("expecting a field name", parser.getTokenLocation());
            }
            T value = values.get(text);
            if (value == null)
                value = catch_all;
            if (value == null)
                throw new JsonReadException("Expected one of " + values + ", got: " + text, parser.getTokenLocation());
            expectObjectEnd(parser);
            return value;
        }
        if (parser.getCurrentToken() != JsonToken.VALUE_STRING)
            throw new JsonReadException("Expected a string value", parser.getTokenLocation());
        String text = parser.getText();
        T value = values.get(text);
        if (value == null)
            value = catch_all;
        if (value == null)
            throw new JsonReadException("Expected one of " + values + ", got: " + text, parser.getTokenLocation());
        parser.nextToken();
        return value;
    }

    /**
     * If you're implementing a {@link JsonReader} for a JSON object, you can use this to map
     * field names to a number you can {@code switch} on to efficiently locate assign a
     * field.
     */
    public static final class FieldMapping
    {
        // This is not optimized.  Potential optimizations:
        // - Store 'int' values instead of 'Integer' values.
        // - Don't use "HashMap".  Do something gperf-like that generates a faster hash
        //   function for when you know the valid strings ahead-of-time.
        // - The get() could take (char[], offset, length) instead of String, which we can
        //   provide straight from JsonParser's internal buffer.  This makes error reporting
        //   tricky, though, because we won't have a string for addFieldContext.
        public final HashMap<String,Integer> fields;

        private FieldMapping(HashMap<String,Integer> fields)
        {
            assert fields != null;
            this.fields = fields;
        }

        public int get(String fieldName)
        {
            Integer i = fields.get(fieldName);
            if (i == null) return -1;
            return i;
        }

        public static final class Builder
        {
            private /*@Nullable*/HashMap<String,Integer> fields = new HashMap<String,Integer>();

            public void add(String fieldName, int expectedIndex)
            {
                if (fields == null) throw new IllegalStateException("already called build(); can't call add() anymore");
                int i = fields.size();
                if (expectedIndex != i) {
                    throw new IllegalStateException("expectedIndex = " + expectedIndex + ", actual = " + i);
                }
                Object displaced = fields.put(fieldName, i);
                if (displaced != null) {
                    throw new IllegalStateException("duplicate field name: \"" + fieldName + "\"");
                }
            }

            public FieldMapping build()
            {
                if (fields == null) throw new IllegalStateException("already called build(); can't call build() again");
                HashMap<String,Integer> f = fields;
                this.fields = null;
                return new FieldMapping(f);
            }
        }
    }

    static final JsonFactory jsonFactory = new JsonFactory();

    public T readFully(InputStream utf8Body)
        throws IOException, JsonReadException
    {
        try {
            JsonParser parser = jsonFactory.createParser(utf8Body);
            return readFully(parser);
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
    }

    public T readFully(String body)
        throws JsonReadException
    {
        try {
            JsonParser parser = jsonFactory.createParser(body);
            try {
                return readFully(parser);
            }
            finally {
                parser.close();
            }
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
        catch (IOException ex) {
            throw mkAssert("IOException reading from String", ex);
        }
    }

    public T readFully(byte[] utf8Body)
        throws JsonReadException
    {
        try {
            JsonParser parser = jsonFactory.createParser(utf8Body);
            try {
                return readFully(parser);
            }
            finally {
                parser.close();
            }
        }
        catch (JsonParseException ex) {
            throw JsonReadException.fromJackson(ex);
        }
        catch (IOException ex) {
            throw mkAssert("IOException reading from byte[]", ex);
        }
    }

    public T readFromFile(String filePath)
        throws FileLoadException
    {
        return readFromFile(new File(filePath));
    }

    public T readFromFile(File file)
        throws FileLoadException
    {
        try {
            InputStream in = new FileInputStream(file);
            try {
                return readFully(in);
            }
            finally {
                IOUtil.closeInput(in);
            }
        }
        catch (JsonReadException ex) {
            throw new FileLoadException.JsonError(file, ex);
        }
        catch (IOException ex) {
            throw new FileLoadException.IOError(file, ex);
        }
    }

    public static abstract class FileLoadException extends Exception
    {
        protected FileLoadException(String message)
        {
            super(message);
        }

        public static final class IOError extends FileLoadException
        {
            public final IOException reason;

            public IOError(File file, IOException reason)
            {
                super("unable to read file \"" + file.getPath() + "\": " + reason.getMessage());
                this.reason = reason;
            }
        }

        public static final class JsonError extends FileLoadException
        {
            public final JsonReadException reason;

            public JsonError(File file, JsonReadException reason)
            {
                super(file.getPath() + ": " + reason.getMessage());
                this.reason = reason;
            }
        }
    }

    public T readFully(JsonParser parser)
        throws IOException, JsonReadException
    {
        parser.nextToken();
        T value = this.read(parser);
        if (parser.getCurrentToken() != null) {
            throw new AssertionError("The JSON library should ensure there's no tokens after the main value: "
                                     + parser.getCurrentToken() + "@" + parser.getCurrentLocation());
        }
        validate(value);
        return value;
    }
}
