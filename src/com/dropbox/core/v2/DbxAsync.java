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
import com.dropbox.core.LocalizedText;
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
            /**
             * This response indicates that the processing is asynchronous. The
             * string is an id that can be used to obtain the status of the
             * asynchronous job.
             */
            ASYNC_JOB_ID  // String
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
         * handle this {@code LaunchResultBase}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String asyncJobIdValue;

        private LaunchResultBase(Tag tag, String value) {
            this.tag = tag;
            this.asyncJobIdValue = value;
            validate();
        }

        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         *
         * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isAsyncJobId} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code
         *     false}.
         */
        public String getAsyncJobIdValue() {
            if (this.tag != Tag.ASYNC_JOB_ID) {
                throw new IllegalStateException("getAsyncJobIdValue() requires tag==ASYNC_JOB_ID, actual tag==" + tag);
            }
            return asyncJobIdValue;
        }

        /**
         * Returns an instance of {@code LaunchResultBase} that has its tag set
         * to {@link Tag#ASYNC_JOB_ID}.
         *
         * <p> This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code LaunchResultBase} with its tag set to
         *     {@link Tag#ASYNC_JOB_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static LaunchResultBase asyncJobId(String value) {
            return new LaunchResultBase(Tag.ASYNC_JOB_ID, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
         */
        public boolean isAsyncJobId() {
            return this.tag == Tag.ASYNC_JOB_ID;
        }


        private final void validate() {
            switch (this.tag) {
                case ASYNC_JOB_ID:
                    if (this.asyncJobIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.asyncJobIdValue.length() < 1) {
                        throw new IllegalArgumentException("String is shorter than 1");
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
                    case ASYNC_JOB_ID:
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
                        case ASYNC_JOB_ID: {
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
            _values.put("async_job_id", Tag.ASYNC_JOB_ID);
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
            /**
             * This response indicates that the processing is asynchronous. The
             * string is an id that can be used to obtain the status of the
             * asynchronous job.
             */
            ASYNC_JOB_ID,  // String
            /**
             * The job finished synchronously and successfully.
             */
            COMPLETE
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
         * handle this {@code LaunchEmptyResult}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String asyncJobIdValue;

        private LaunchEmptyResult(Tag tag, String value) {
            this.tag = tag;
            this.asyncJobIdValue = value;
            validate();
        }

        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         *
         * <p> This instance must be tagged as {@link Tag#ASYNC_JOB_ID}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isAsyncJobId} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAsyncJobId} is {@code
         *     false}.
         */
        public String getAsyncJobIdValue() {
            if (this.tag != Tag.ASYNC_JOB_ID) {
                throw new IllegalStateException("getAsyncJobIdValue() requires tag==ASYNC_JOB_ID, actual tag==" + tag);
            }
            return asyncJobIdValue;
        }

        /**
         * Returns an instance of {@code LaunchEmptyResult} that has its tag set
         * to {@link Tag#ASYNC_JOB_ID}.
         *
         * <p> This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code LaunchEmptyResult} with its tag set to
         *     {@link Tag#ASYNC_JOB_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static LaunchEmptyResult asyncJobId(String value) {
            return new LaunchEmptyResult(Tag.ASYNC_JOB_ID, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ASYNC_JOB_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ASYNC_JOB_ID}, {@code false} otherwise.
         */
        public boolean isAsyncJobId() {
            return this.tag == Tag.ASYNC_JOB_ID;
        }

        /**
         * The job finished synchronously and successfully.
         */
        private static final LaunchEmptyResult COMPLETE_INSTANCE = new LaunchEmptyResult(Tag.COMPLETE);

        /**
         * Returns an instance of {@code LaunchEmptyResult} that has its tag set
         * to {@link Tag#COMPLETE}.
         *
         * <p> The job finished synchronously and successfully. </p>
         *
         * @return Instance of {@code LaunchEmptyResult} with its tag set to
         *     {@link Tag#COMPLETE}.
         */
        public static LaunchEmptyResult complete() {
            return LaunchEmptyResult.COMPLETE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#COMPLETE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#COMPLETE}, {@code false} otherwise.
         */
        public boolean isComplete() {
            return this.tag == Tag.COMPLETE;
        }

        private LaunchEmptyResult(Tag t) {
            tag = t;
            asyncJobIdValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case COMPLETE:
                    break;
                case ASYNC_JOB_ID:
                    if (this.asyncJobIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.asyncJobIdValue.length() < 1) {
                        throw new IllegalArgumentException("String is shorter than 1");
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
                    case ASYNC_JOB_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("async_job_id");
                        g.writeStringField("async_job_id", x.asyncJobIdValue);
                        g.writeEndObject();
                        break;
                    case COMPLETE:
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
                        case COMPLETE: return LaunchEmptyResult.complete();
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
                        case ASYNC_JOB_ID: {
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
                        case COMPLETE: {
                            value = LaunchEmptyResult.complete();
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
            _values.put("complete", Tag.COMPLETE);
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

        /**
         * Arguments for methods that poll the status of an asynchronous job.
         *
         * @param asyncJobId  Id of the asynchronous job. This is the value of a
         *     response returned from the method that launched the job. {@code
         *     asyncJobId} must have length of at least 1 and not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public PollArg(String asyncJobId) {
            this.asyncJobId = asyncJobId;
            if (asyncJobId == null) {
                throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
            }
            if (asyncJobId.length() < 1) {
                throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
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
    public static final class PollResultBase {
        // union PollResultBase

        /**
         * The discriminating tag type for {@link PollResultBase}.
         */
        public enum Tag {
            /**
             * The asynchronous job is still in progress.
             */
            IN_PROGRESS
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
         * handle this {@code PollResultBase}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The asynchronous job is still in progress.
         */
        private static final PollResultBase IN_PROGRESS_INSTANCE = new PollResultBase(Tag.IN_PROGRESS);

        /**
         * Returns an instance of {@code PollResultBase} that has its tag set to
         * {@link Tag#IN_PROGRESS}.
         *
         * <p> The asynchronous job is still in progress. </p>
         *
         * @return Instance of {@code PollResultBase} with its tag set to {@link
         *     Tag#IN_PROGRESS}.
         */
        public static PollResultBase inProgress() {
            return PollResultBase.IN_PROGRESS_INSTANCE;
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

        private PollResultBase(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IN_PROGRESS:
                    break;
            }
        }

        static final JsonWriter<PollResultBase> _writer = new JsonWriter<PollResultBase>()
        {
            public final void write(PollResultBase x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case IN_PROGRESS:
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case IN_PROGRESS: return PollResultBase.inProgress();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                PollResultBase value = null;
                if (tag != null) {
                    switch (tag) {
                        case IN_PROGRESS: {
                            value = PollResultBase.inProgress();
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
            _values.put("in_progress", Tag.IN_PROGRESS);
        }

        public String toString() {
            return "PollResultBase." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PollResultBase." +  _writer.writeToString(this, true);
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
    public static final class PollEmptyResult {
        // union PollEmptyResult

        /**
         * The discriminating tag type for {@link PollEmptyResult}.
         */
        public enum Tag {
            /**
             * The asynchronous job is still in progress.
             */
            IN_PROGRESS,
            /**
             * The asynchronous job has completed successfully.
             */
            COMPLETE
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
         * handle this {@code PollEmptyResult}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The asynchronous job is still in progress.
         */
        private static final PollEmptyResult IN_PROGRESS_INSTANCE = new PollEmptyResult(Tag.IN_PROGRESS);

        /**
         * Returns an instance of {@code PollEmptyResult} that has its tag set
         * to {@link Tag#IN_PROGRESS}.
         *
         * <p> The asynchronous job is still in progress. </p>
         *
         * @return Instance of {@code PollEmptyResult} with its tag set to
         *     {@link Tag#IN_PROGRESS}.
         */
        public static PollEmptyResult inProgress() {
            return PollEmptyResult.IN_PROGRESS_INSTANCE;
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
         * The asynchronous job has completed successfully.
         */
        private static final PollEmptyResult COMPLETE_INSTANCE = new PollEmptyResult(Tag.COMPLETE);

        /**
         * Returns an instance of {@code PollEmptyResult} that has its tag set
         * to {@link Tag#COMPLETE}.
         *
         * <p> The asynchronous job has completed successfully. </p>
         *
         * @return Instance of {@code PollEmptyResult} with its tag set to
         *     {@link Tag#COMPLETE}.
         */
        public static PollEmptyResult complete() {
            return PollEmptyResult.COMPLETE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#COMPLETE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#COMPLETE}, {@code false} otherwise.
         */
        public boolean isComplete() {
            return this.tag == Tag.COMPLETE;
        }

        private PollEmptyResult(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IN_PROGRESS:
                case COMPLETE:
                    break;
            }
        }

        static final JsonWriter<PollEmptyResult> _writer = new JsonWriter<PollEmptyResult>()
        {
            public final void write(PollEmptyResult x, JsonGenerator g)
              throws IOException
            {
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case IN_PROGRESS: return PollEmptyResult.inProgress();
                        case COMPLETE: return PollEmptyResult.complete();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                PollEmptyResult value = null;
                if (tag != null) {
                    switch (tag) {
                        case IN_PROGRESS: {
                            value = PollEmptyResult.inProgress();
                            break;
                        }
                        case COMPLETE: {
                            value = PollEmptyResult.complete();
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
            _values.put("complete", Tag.COMPLETE);
        }

        public String toString() {
            return "PollEmptyResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PollEmptyResult." +  _writer.writeToString(this, true);
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
    public static final class PollError {
        // union PollError

        /**
         * The discriminating tag type for {@link PollError}.
         */
        public enum Tag {
            /**
             * The job ID is invalid.
             */
            INVALID_ASYNC_JOB_ID,
            /**
             * Something went wrong with the job on Dropbox's end. You'll need
             * to verify that the action you were taking succeeded, and if not,
             * try again. This should happen very rarely.
             */
            INTERNAL_ERROR,
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
         * handle this {@code PollError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The job ID is invalid.
         */
        private static final PollError INVALID_ASYNC_JOB_ID_INSTANCE = new PollError(Tag.INVALID_ASYNC_JOB_ID);

        /**
         * Returns an instance of {@code PollError} that has its tag set to
         * {@link Tag#INVALID_ASYNC_JOB_ID}.
         *
         * <p> The job ID is invalid. </p>
         *
         * @return Instance of {@code PollError} with its tag set to {@link
         *     Tag#INVALID_ASYNC_JOB_ID}.
         */
        public static PollError invalidAsyncJobId() {
            return PollError.INVALID_ASYNC_JOB_ID_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_ASYNC_JOB_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_ASYNC_JOB_ID}, {@code false} otherwise.
         */
        public boolean isInvalidAsyncJobId() {
            return this.tag == Tag.INVALID_ASYNC_JOB_ID;
        }

        /**
         * Something went wrong with the job on Dropbox's end. You'll need to
         * verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely.
         */
        private static final PollError INTERNAL_ERROR_INSTANCE = new PollError(Tag.INTERNAL_ERROR);

        /**
         * Returns an instance of {@code PollError} that has its tag set to
         * {@link Tag#INTERNAL_ERROR}.
         *
         * <p> Something went wrong with the job on Dropbox's end. You'll need
         * to verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely. </p>
         *
         * @return Instance of {@code PollError} with its tag set to {@link
         *     Tag#INTERNAL_ERROR}.
         */
        public static PollError internalError() {
            return PollError.INTERNAL_ERROR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INTERNAL_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INTERNAL_ERROR}, {@code false} otherwise.
         */
        public boolean isInternalError() {
            return this.tag == Tag.INTERNAL_ERROR;
        }

        /**
         * An unspecified error.
         */
        private static final PollError OTHER_INSTANCE = new PollError(Tag.OTHER);

        /**
         * Returns an instance of {@code PollError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> An unspecified error. </p>
         *
         * @return Instance of {@code PollError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static PollError other() {
            return PollError.OTHER_INSTANCE;
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

        private PollError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_ASYNC_JOB_ID:
                case INTERNAL_ERROR:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<PollError> _writer = new JsonWriter<PollError>()
        {
            public final void write(PollError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case INVALID_ASYNC_JOB_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_async_job_id");
                        g.writeEndObject();
                        break;
                    case INTERNAL_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("internal_error");
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
        public static final JsonReader<PollError> _reader = new JsonReader<PollError>()
        {
            public final PollError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return PollError.other(); }
                    switch (tag) {
                        case INVALID_ASYNC_JOB_ID: return PollError.invalidAsyncJobId();
                        case INTERNAL_ERROR: return PollError.internalError();
                        case OTHER: return PollError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                PollError value = null;
                if (tag != null) {
                    switch (tag) {
                        case INVALID_ASYNC_JOB_ID: {
                            value = PollError.invalidAsyncJobId();
                            break;
                        }
                        case INTERNAL_ERROR: {
                            value = PollError.internalError();
                            break;
                        }
                        case OTHER: {
                            value = PollError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return PollError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_async_job_id", Tag.INVALID_ASYNC_JOB_ID);
            _values.put("internal_error", Tag.INTERNAL_ERROR);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "PollError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PollError." +  _writer.writeToString(this, true);
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
