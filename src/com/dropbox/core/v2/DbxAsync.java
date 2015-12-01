/* DO NOT EDIT */
/* This file was generated from async.babel */

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
 * Classes and routes in namespace "async".
 */
public final class DbxAsync {
    // namespace async

    private final DbxRawClientV2 client;

    DbxAsync(DbxRawClientV2 client) {
        this.client = client;
    }

    /**
     * Result returned by methods that launch an asynchronous job. A method who
     * may either launch an asynchronous job, or complete the request
     * synchronously, can use this union by extending it, and adding a
     * 'complete' field with the type of the synchronous response. See {@link
     * LaunchEmptyResult} for an example.
     */

    public static final class LaunchResultBase {
        // union LaunchResultBase

        /**
         * The discriminating tag type for {@link LaunchResultBase}.
         */
        public enum Tag {
            asyncJobId  // String
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String asyncJobIdValue;
        private LaunchResultBase(Tag t, String v) {
            tag = t;
            asyncJobIdValue = v;
            validate();
        }
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        public static LaunchResultBase asyncJobId(String v) {
            return new LaunchResultBase(Tag.asyncJobId, v);
        }
        public String getAsyncJobId() {
            if (tag != Tag.asyncJobId) {
                throw new RuntimeException("getAsyncJobId() requires tag==asyncJobId, actual tag=="+tag);
            }
            return asyncJobIdValue;
        }


        private void validate()
        {
            switch (tag) {
                case asyncJobId:
                    if (this.asyncJobIdValue == null) {
                        throw new RuntimeException("Required value for 'asyncJobId' is null");
                    }
                    if (this.asyncJobIdValue.length() < 1) {
                        throw new RuntimeException("String 'this.asyncJobIdValue' is shorter than 1");
                    }
                    break;
            }
        }
        static final JsonWriter<LaunchResultBase> _writer = new JsonWriter<LaunchResultBase>()
        {
            public final void write(LaunchResultBase x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case asyncJobId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("async_job_id");
                        g.writeStringField("async_job_id", x.asyncJobIdValue);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<LaunchResultBase> _reader = new JsonReader<LaunchResultBase>()
        {
            public final LaunchResultBase read(JsonParser parser)
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
                LaunchResultBase value = null;
                if (tag != null) {
                    switch (tag) {
                        case asyncJobId: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "async_job_id", v);
                            value = LaunchResultBase.asyncJobId(v);
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
            _values.put("async_job_id", Tag.asyncJobId);
        }

        public String toString() {
            return "LaunchResultBase." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "LaunchResultBase." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static LaunchResultBase fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Result returned by methods that may either launch an asynchronous job or
     * complete synchronously. Upon synchronous completion of the job, no
     * additional information is returned.
     */

    public static final class LaunchEmptyResult {
        // union LaunchEmptyResult

        /**
         * The discriminating tag type for {@link LaunchEmptyResult}.
         */
        public enum Tag {
            asyncJobId,  // String
            complete
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String asyncJobIdValue;
        private LaunchEmptyResult(Tag t, String v) {
            tag = t;
            asyncJobIdValue = v;
            validate();
        }
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        public static LaunchEmptyResult asyncJobId(String v) {
            return new LaunchEmptyResult(Tag.asyncJobId, v);
        }
        public String getAsyncJobId() {
            if (tag != Tag.asyncJobId) {
                throw new RuntimeException("getAsyncJobId() requires tag==asyncJobId, actual tag=="+tag);
            }
            return asyncJobIdValue;
        }

        /**
         * The job finished synchronously and successfully.
         */
        public static final LaunchEmptyResult complete = new LaunchEmptyResult(Tag.complete);

        private LaunchEmptyResult(Tag t) {
            tag = t;
            asyncJobIdValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case complete:
                    break;
                case asyncJobId:
                    if (this.asyncJobIdValue == null) {
                        throw new RuntimeException("Required value for 'asyncJobId' is null");
                    }
                    if (this.asyncJobIdValue.length() < 1) {
                        throw new RuntimeException("String 'this.asyncJobIdValue' is shorter than 1");
                    }
                    break;
            }
        }
        static final JsonWriter<LaunchEmptyResult> _writer = new JsonWriter<LaunchEmptyResult>()
        {
            public final void write(LaunchEmptyResult x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case asyncJobId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("async_job_id");
                        g.writeStringField("async_job_id", x.asyncJobIdValue);
                        g.writeEndObject();
                        break;
                    case complete:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("complete");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<LaunchEmptyResult> _reader = new JsonReader<LaunchEmptyResult>()
        {
            public final LaunchEmptyResult read(JsonParser parser)
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
                        case complete: return LaunchEmptyResult.complete;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                LaunchEmptyResult value = null;
                if (tag != null) {
                    switch (tag) {
                        case asyncJobId: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "async_job_id", v);
                            value = LaunchEmptyResult.asyncJobId(v);
                            break;
                        }
                        case complete: {
                            value = LaunchEmptyResult.complete;
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
            _values.put("complete", Tag.complete);
        }

        public String toString() {
            return "LaunchEmptyResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "LaunchEmptyResult." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static LaunchEmptyResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Arguments for methods that poll the status of an asynchronous job.
     */
    public static class PollArg {
        // struct PollArg
        /**
         * Id of the asynchronous job. This is the value of a response returned
         * from the method that launched the job.
         */
        public final String asyncJobId;

        public PollArg(String asyncJobId) {
            this.asyncJobId = asyncJobId;
            if (asyncJobId == null) {
                throw new RuntimeException("Required value for 'asyncJobId' is null");
            }
            if (asyncJobId.length() < 1) {
                throw new RuntimeException("String 'asyncJobId' is shorter than 1");
            }
        }
        static final JsonWriter<PollArg> _writer = new JsonWriter<PollArg>()
        {
            public final void write(PollArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                PollArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(PollArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("async_job_id", x.asyncJobId);
            }
        };

        public static final JsonReader<PollArg> _reader = new JsonReader<PollArg>() {

            public final PollArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                PollArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final PollArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String asyncJobId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("async_job_id".equals(fieldName)) {
                        asyncJobId = JsonReader.StringReader
                            .readField(parser, "async_job_id", asyncJobId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (asyncJobId == null) {
                    throw new JsonReadException("Required field \"async_job_id\" is missing.", parser.getTokenLocation());
                }
                return new PollArg(asyncJobId);
            }
        };

        public String toString() {
            return "PollArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PollArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PollArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Result returned by methods that poll for the status of an asynchronous
     * job. Unions that extend this union should add a 'complete' field with a
     * type of the information returned upon job completion. See {@link
     * PollEmptyResult} for an example.
     */
    public enum PollResultBase {
        // union PollResultBase
        /**
         * The asynchronous job is still in progress.
         */
        inProgress;

        static final JsonWriter<PollResultBase> _writer = new JsonWriter<PollResultBase>()
        {
            public void write(PollResultBase x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case inProgress:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("in_progress");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<PollResultBase> _reader = new JsonReader<PollResultBase>()
        {
            public final PollResultBase read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,PollResultBase> _values;
        static {
            _values = new java.util.HashMap<String,PollResultBase>();
            _values.put("in_progress", inProgress);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PollResultBase fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Result returned by methods that poll for the status of an asynchronous
     * job. Upon completion of the job, no additional information is returned.
     */
    public enum PollEmptyResult {
        // union PollEmptyResult
        /**
         * The asynchronous job is still in progress.
         */
        inProgress,
        /**
         * The asynchronous job has completed successfully.
         */
        complete;

        static final JsonWriter<PollEmptyResult> _writer = new JsonWriter<PollEmptyResult>()
        {
            public void write(PollEmptyResult x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case inProgress:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("in_progress");
                        g.writeEndObject();
                        break;
                    case complete:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("complete");
                        g.writeEndObject();
                        break;
                }
            }
        };

        public static final JsonReader<PollEmptyResult> _reader = new JsonReader<PollEmptyResult>()
        {
            public final PollEmptyResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,PollEmptyResult> _values;
        static {
            _values = new java.util.HashMap<String,PollEmptyResult>();
            _values.put("complete", complete);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PollEmptyResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Error returned by methods for polling the status of asynchronous job.
     */
    public enum PollError {
        // union PollError
        /**
         * The job ID is invalid.
         */
        invalidAsyncJobId,
        /**
         * Something went wrong with the job on Dropbox's end. You'll need to
         * verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely.
         */
        internalError,
        /**
         * An unspecified error.
         */
        other;  // *catch_all

        static final JsonWriter<PollError> _writer = new JsonWriter<PollError>()
        {
            public void write(PollError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case invalidAsyncJobId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_async_job_id");
                        g.writeEndObject();
                        break;
                    case internalError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("internal_error");
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

        public static final JsonReader<PollError> _reader = new JsonReader<PollError>()
        {
            public final PollError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,PollError> _values;
        static {
            _values = new java.util.HashMap<String,PollError>();
            _values.put("invalid_async_job_id", invalidAsyncJobId);
            _values.put("internal_error", internalError);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PollError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }
}
