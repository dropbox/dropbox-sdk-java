/* DO NOT EDIT */
/* This file was generated from sharing.babel */

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
 * Classes and routes in namespace "sharing".
 */
public final class DbxSharing {
    // namespace sharing

    private final DbxRawClientV2 client;

    DbxSharing(DbxRawClientV2 client) {
        this.client = client;
    }

    /**
     * Who can access a shared link. The most open visibility is {@code
     * public_}. The default depends on many aspects, such as team and user
     * preferences and shared folder settings.
     */
    public enum Visibility {
        // union Visibility
        /**
         * Anyone who has received the link can access it. No login required.
         */
        public_,
        /**
         * Only members of the same DfB (Dropbox for Business) team can access
         * the link. Login is required.
         */
        teamOnly,
        /**
         * A link-specific password is required to access the link. Login is not
         * required.
         */
        password,
        /**
         * Only members of the same DfB (Dropbox for Business) team who have the
         * link-specific password can access the link.
         */
        teamAndPassword,
        /**
         * Only members of the shared folder containing the linked file can
         * access the link. Login is required.
         */
        sharedFolderOnly,
        /**
         * An unknown restriction is in place.
         */
        other;  // *catch_all

        static final JsonWriter<Visibility> _writer = new JsonWriter<Visibility>()
        {
            public void write(Visibility x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case public_:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("public");
                        g.writeEndObject();
                        break;
                    case teamOnly:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_only");
                        g.writeEndObject();
                        break;
                    case password:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("password");
                        g.writeEndObject();
                        break;
                    case teamAndPassword:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_and_password");
                        g.writeEndObject();
                        break;
                    case sharedFolderOnly:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_folder_only");
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

        public static final JsonReader<Visibility> _reader = new JsonReader<Visibility>()
        {
            public final Visibility read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,Visibility> _values;
        static {
            _values = new java.util.HashMap<String,Visibility>();
            _values.put("public", public_);
            _values.put("team_only", teamOnly);
            _values.put("password", password);
            _values.put("team_and_password", teamAndPassword);
            _values.put("shared_folder_only", sharedFolderOnly);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static Visibility fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a shared link. This can be either a {@link PathLinkMetadata}
     * or {@link CollectionLinkMetadata}.
     */
    public static class LinkMetadata {
        // struct LinkMetadata
        /**
         * URL of the shared link.
         */
        public final String url;
        /**
         * Who can access the link.
         */
        public final Visibility visibility;
        /**
         * Expiration time, if set. By default the link won't expire.
         */
        public final java.util.Date expires;

        public LinkMetadata(String url, Visibility visibility, java.util.Date expires) {
            this.url = url;
            if (url == null) {
                throw new RuntimeException("Required value for 'url' is null");
            }
            this.visibility = visibility;
            if (visibility == null) {
                throw new RuntimeException("Required value for 'visibility' is null");
            }
            this.expires = expires;
        }
        public JsonWriter getWriter() {
            return LinkMetadata._writer;
        }
        static final JsonWriter<LinkMetadata> _writer = new JsonWriter<LinkMetadata>()
        {
            public final void write(LinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                LinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(LinkMetadata x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("url", x.url);
                g.writeFieldName("visibility");
                Visibility._writer.write(x.visibility, g);
                if (x.expires != null) {
                    g.writeFieldName("expires");
                    writeDateIso(x.expires, g);
                }
            }
        };

        public static final JsonReader<LinkMetadata> _reader = new JsonReader<LinkMetadata>() {

            public final LinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                LinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final LinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null && tags.length > 0) {
                    if ("path".equals(tags[0])) {
                        return PathLinkMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("collection".equals(tags[0])) {
                        return CollectionLinkMetadata._reader.readFromTags(tags, parser);
                    }
                    // If no match, fall back to base class
                }
                return readFields(parser);
            }

            public final LinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                Visibility visibility = null;
                java.util.Date expires = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("visibility".equals(fieldName)) {
                        visibility = Visibility._reader
                            .readField(parser, "visibility", visibility);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (visibility == null) {
                    throw new JsonReadException("Required field \"visibility\" is missing.", parser.getTokenLocation());
                }
                return new LinkMetadata(url, visibility, expires);
            }
        };

        public String toString() {
            return "LinkMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "LinkMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static LinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a path-based shared link.
     */
    public static class PathLinkMetadata extends LinkMetadata  {
        // struct PathLinkMetadata
        /**
         * Path in user's Dropbox.
         */
        public final String path;

        public PathLinkMetadata(String url, Visibility visibility, String path, java.util.Date expires) {
            super(url, visibility, expires);
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
        }
        public JsonWriter getWriter() {
            return PathLinkMetadata._writer;
        }
        static final JsonWriter<PathLinkMetadata> _writer = new JsonWriter<PathLinkMetadata>()
        {
            public final void write(PathLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "path");
                LinkMetadata._writer.writeFields(x, g);
                PathLinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(PathLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
            }
        };

        public static final JsonReader<PathLinkMetadata> _reader = new JsonReader<PathLinkMetadata>() {

            public final PathLinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                PathLinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final PathLinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "path".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final PathLinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                Visibility visibility = null;
                String path = null;
                java.util.Date expires = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("visibility".equals(fieldName)) {
                        visibility = Visibility._reader
                            .readField(parser, "visibility", visibility);
                    }
                    else if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (visibility == null) {
                    throw new JsonReadException("Required field \"visibility\" is missing.", parser.getTokenLocation());
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new PathLinkMetadata(url, visibility, path, expires);
            }
        };

        public String toString() {
            return "PathLinkMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PathLinkMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PathLinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Metadata for a collection-based shared link.
     */
    public static class CollectionLinkMetadata extends LinkMetadata  {
        // struct CollectionLinkMetadata

        public CollectionLinkMetadata(String url, Visibility visibility, java.util.Date expires) {
            super(url, visibility, expires);
        }
        public JsonWriter getWriter() {
            return CollectionLinkMetadata._writer;
        }
        static final JsonWriter<CollectionLinkMetadata> _writer = new JsonWriter<CollectionLinkMetadata>()
        {
            public final void write(CollectionLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "collection");
                LinkMetadata._writer.writeFields(x, g);
                CollectionLinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(CollectionLinkMetadata x, JsonGenerator g)
             throws IOException
            {
            }
        };

        public static final JsonReader<CollectionLinkMetadata> _reader = new JsonReader<CollectionLinkMetadata>() {

            public final CollectionLinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                CollectionLinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final CollectionLinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "collection".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final CollectionLinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                Visibility visibility = null;
                java.util.Date expires = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("visibility".equals(fieldName)) {
                        visibility = Visibility._reader
                            .readField(parser, "visibility", visibility);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (visibility == null) {
                    throw new JsonReadException("Required field \"visibility\" is missing.", parser.getTokenLocation());
                }
                return new CollectionLinkMetadata(url, visibility, expires);
            }
        };

        public String toString() {
            return "CollectionLinkMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CollectionLinkMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CollectionLinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class GetSharedLinksArg {
        // struct GetSharedLinksArg
        /**
         * See {@link #getSharedLinks} description.
         */
        public final String path;

        public GetSharedLinksArg(String path) {
            this.path = path;
        }
        static final JsonWriter<GetSharedLinksArg> _writer = new JsonWriter<GetSharedLinksArg>()
        {
            public final void write(GetSharedLinksArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetSharedLinksArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetSharedLinksArg x, JsonGenerator g)
             throws IOException
            {
                if (x.path != null) {
                    g.writeFieldName("path");
                    g.writeString(x.path);
                }
            }
        };

        public static final JsonReader<GetSharedLinksArg> _reader = new JsonReader<GetSharedLinksArg>() {

            public final GetSharedLinksArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetSharedLinksArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetSharedLinksArg readFields(JsonParser parser)
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
                return new GetSharedLinksArg(path);
            }
        };

        public String toString() {
            return "GetSharedLinksArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetSharedLinksArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetSharedLinksArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class GetSharedLinksResult {
        // struct GetSharedLinksResult
        /**
         * Shared links applicable to the path argument.
         */
        public final java.util.ArrayList<LinkMetadata> links;

        public GetSharedLinksResult(java.util.ArrayList<LinkMetadata> links) {
            this.links = links;
            if (links == null) {
                throw new RuntimeException("Required value for 'links' is null");
            }
            for (LinkMetadata x : links) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'links' is null");
                }
            }
        }
        static final JsonWriter<GetSharedLinksResult> _writer = new JsonWriter<GetSharedLinksResult>()
        {
            public final void write(GetSharedLinksResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetSharedLinksResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetSharedLinksResult x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("links");
                g.writeStartArray();
                for (LinkMetadata item: x.links) {
                    if (item != null) {
                        LinkMetadata._writer.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        };

        public static final JsonReader<GetSharedLinksResult> _reader = new JsonReader<GetSharedLinksResult>() {

            public final GetSharedLinksResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetSharedLinksResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetSharedLinksResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.ArrayList<LinkMetadata> links = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("links".equals(fieldName)) {
                        links = JsonArrayReader.mk(LinkMetadata._reader)
                            .readField(parser, "links", links);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (links == null) {
                    throw new JsonReadException("Required field \"links\" is missing.", parser.getTokenLocation());
                }
                return new GetSharedLinksResult(links);
            }
        };

        public String toString() {
            return "GetSharedLinksResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetSharedLinksResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetSharedLinksResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class GetSharedLinksError {
        // union GetSharedLinksError

        /**
         * The discriminating tag type for {@link GetSharedLinksError}.
         */
        public enum Tag {
            path,  // Nullable
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String pathValue;
        private GetSharedLinksError(Tag t, String v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static GetSharedLinksError path(String v) {
            return new GetSharedLinksError(Tag.path, v);
        }
        public String getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        public static final GetSharedLinksError other = new GetSharedLinksError(Tag.other);

        private GetSharedLinksError(Tag t) {
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
                    break;
            }
        }
        static final JsonWriter<GetSharedLinksError> _writer = new JsonWriter<GetSharedLinksError>()
        {
            public final void write(GetSharedLinksError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        if (x.pathValue != null) {
                            g.writeFieldName("path");
                            g.writeString(x.pathValue);
                        }
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
        public static final JsonReader<GetSharedLinksError> _reader = new JsonReader<GetSharedLinksError>()
        {
            public final GetSharedLinksError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return GetSharedLinksError.other; }
                    switch (tag) {
                        case path: return GetSharedLinksError.path(null);
                        case other: return GetSharedLinksError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                GetSharedLinksError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
                                break;
                            }
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "path", v);
                            value = GetSharedLinksError.path(v);
                            break;
                        }
                        case other: {
                            value = GetSharedLinksError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return GetSharedLinksError.other; }
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
            return "GetSharedLinksError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetSharedLinksError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetSharedLinksError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Flag to indicate pending upload default (for linking to not-yet-existing
     * paths).
     */
    public enum PendingUploadMode {
        // union PendingUploadMode
        /**
         * Assume pending uploads are files.
         */
        file,
        /**
         * Assume pending uploads are folders.
         */
        folder;

        static final JsonWriter<PendingUploadMode> _writer = new JsonWriter<PendingUploadMode>()
        {
            public void write(PendingUploadMode x, JsonGenerator g)
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
                }
            }
        };

        public static final JsonReader<PendingUploadMode> _reader = new JsonReader<PendingUploadMode>()
        {
            public final PendingUploadMode read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, null);
            }
        };
        private static final java.util.HashMap<String,PendingUploadMode> _values;
        static {
            _values = new java.util.HashMap<String,PendingUploadMode>();
            _values.put("file", file);
            _values.put("folder", folder);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static PendingUploadMode fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class CreateSharedLinkArg {
        // struct CreateSharedLinkArg
        /**
         * The path to share.
         */
        public final String path;
        /**
         * Whether to return a shortened URL.
         */
        public final boolean shortUrl;
        /**
         * If it's okay to share a path that does not yet exist, set this to
         * either 'file' or 'folder' to indicate whether to assume it's a file
         * or folder.
         */
        public final PendingUploadMode pendingUpload;

        public CreateSharedLinkArg(String path, Boolean shortUrl, PendingUploadMode pendingUpload) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (shortUrl != null) {
                this.shortUrl = shortUrl.booleanValue();
            }
            else {
                this.shortUrl = false;
            }
            this.pendingUpload = pendingUpload;
            if (pendingUpload != null) {
            }
        }
        static final JsonWriter<CreateSharedLinkArg> _writer = new JsonWriter<CreateSharedLinkArg>()
        {
            public final void write(CreateSharedLinkArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                CreateSharedLinkArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(CreateSharedLinkArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeBooleanField("short_url", x.shortUrl);
                if (x.pendingUpload != null) {
                    g.writeFieldName("pending_upload");
                    PendingUploadMode._writer.write(x.pendingUpload, g);
                }
            }
        };

        public static final JsonReader<CreateSharedLinkArg> _reader = new JsonReader<CreateSharedLinkArg>() {

            public final CreateSharedLinkArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                CreateSharedLinkArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final CreateSharedLinkArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                Boolean shortUrl = null;
                PendingUploadMode pendingUpload = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("short_url".equals(fieldName)) {
                        shortUrl = JsonReader.BooleanReader
                            .readField(parser, "short_url", shortUrl);
                    }
                    else if ("pending_upload".equals(fieldName)) {
                        pendingUpload = PendingUploadMode._reader
                            .readField(parser, "pending_upload", pendingUpload);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new CreateSharedLinkArg(path, shortUrl, pendingUpload);
            }
        };

        public String toString() {
            return "CreateSharedLinkArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CreateSharedLinkArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CreateSharedLinkArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class CreateSharedLinkError {
        // union CreateSharedLinkError

        /**
         * The discriminating tag type for {@link CreateSharedLinkError}.
         */
        public enum Tag {
            path,  // LookupError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final DbxFiles.LookupError pathValue;
        private CreateSharedLinkError(Tag t, DbxFiles.LookupError v) {
            tag = t;
            pathValue = v;
            validate();
        }
        public static CreateSharedLinkError path(DbxFiles.LookupError v) {
            return new CreateSharedLinkError(Tag.path, v);
        }
        public DbxFiles.LookupError getPath() {
            if (tag != Tag.path) {
                throw new RuntimeException("getPath() requires tag==path, actual tag=="+tag);
            }
            return pathValue;
        }

        public static final CreateSharedLinkError other = new CreateSharedLinkError(Tag.other);

        private CreateSharedLinkError(Tag t) {
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
        static final JsonWriter<CreateSharedLinkError> _writer = new JsonWriter<CreateSharedLinkError>()
        {
            public final void write(CreateSharedLinkError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case path:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        DbxFiles.LookupError._writer.write(x.pathValue, g);
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
        public static final JsonReader<CreateSharedLinkError> _reader = new JsonReader<CreateSharedLinkError>()
        {
            public final CreateSharedLinkError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return CreateSharedLinkError.other; }
                    switch (tag) {
                        case other: return CreateSharedLinkError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                CreateSharedLinkError value = null;
                if (tag != null) {
                    switch (tag) {
                        case path: {
                            DbxFiles.LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = DbxFiles.LookupError._reader
                                .readField(parser, "path", v);
                            value = CreateSharedLinkError.path(v);
                            break;
                        }
                        case other: {
                            value = CreateSharedLinkError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return CreateSharedLinkError.other; }
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
            return "CreateSharedLinkError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CreateSharedLinkError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CreateSharedLinkError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class RevokeSharedLinkArg {
        // struct RevokeSharedLinkArg
        /**
         * URL of the shared link.
         */
        public final String url;

        public RevokeSharedLinkArg(String url) {
            this.url = url;
            if (url == null) {
                throw new RuntimeException("Required value for 'url' is null");
            }
        }
        static final JsonWriter<RevokeSharedLinkArg> _writer = new JsonWriter<RevokeSharedLinkArg>()
        {
            public final void write(RevokeSharedLinkArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                RevokeSharedLinkArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(RevokeSharedLinkArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("url", x.url);
            }
        };

        public static final JsonReader<RevokeSharedLinkArg> _reader = new JsonReader<RevokeSharedLinkArg>() {

            public final RevokeSharedLinkArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                RevokeSharedLinkArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final RevokeSharedLinkArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                return new RevokeSharedLinkArg(url);
            }
        };

        public String toString() {
            return "RevokeSharedLinkArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RevokeSharedLinkArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RevokeSharedLinkArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum RevokeSharedLinkError {
        // union RevokeSharedLinkError
        /**
         * Shared link is malformed.
         */
        sharedLinkMalformed,
        /**
         * Shared link not found.
         */
        sharedLinkNotFound,
        /**
         * Shared link access denied.
         */
        sharedLinkAccessDenied,
        /**
         * An unspecified error.
         */
        other;  // *catch_all

        static final JsonWriter<RevokeSharedLinkError> _writer = new JsonWriter<RevokeSharedLinkError>()
        {
            public void write(RevokeSharedLinkError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case sharedLinkMalformed:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_malformed");
                        g.writeEndObject();
                        break;
                    case sharedLinkNotFound:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_not_found");
                        g.writeEndObject();
                        break;
                    case sharedLinkAccessDenied:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_access_denied");
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

        public static final JsonReader<RevokeSharedLinkError> _reader = new JsonReader<RevokeSharedLinkError>()
        {
            public final RevokeSharedLinkError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,RevokeSharedLinkError> _values;
        static {
            _values = new java.util.HashMap<String,RevokeSharedLinkError>();
            _values.put("shared_link_malformed", sharedLinkMalformed);
            _values.put("shared_link_not_found", sharedLinkNotFound);
            _values.put("shared_link_access_denied", sharedLinkAccessDenied);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RevokeSharedLinkError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Defines the access levels for collaborators.
     */
    public enum AccessLevel {
        // union AccessLevel
        /**
         * The collaborator is the owner of the shared folder. Owners can view
         * and edit the shared folder as well as set the folder's policies using
         * {@link #updateFolderPolicy}.
         */
        owner,
        /**
         * The collaborator can both view and edit the shared folder.
         */
        editor,
        /**
         * The collaborator can only view the shared folder.
         */
        viewer,
        other;  // *catch_all

        static final JsonWriter<AccessLevel> _writer = new JsonWriter<AccessLevel>()
        {
            public void write(AccessLevel x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case owner:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("owner");
                        g.writeEndObject();
                        break;
                    case editor:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("editor");
                        g.writeEndObject();
                        break;
                    case viewer:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("viewer");
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

        public static final JsonReader<AccessLevel> _reader = new JsonReader<AccessLevel>()
        {
            public final AccessLevel read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,AccessLevel> _values;
        static {
            _values = new java.util.HashMap<String,AccessLevel>();
            _values.put("owner", owner);
            _values.put("editor", editor);
            _values.put("viewer", viewer);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AccessLevel fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * A set of policies governing membership and privileges for a shared
     * folder.
     */
    public static class FolderPolicy {
        // struct FolderPolicy
        /**
         * Who can be a member of this shared folder. Only set if the user is a
         * member of a team.
         */
        public final MemberPolicy memberPolicy;
        /**
         * Who can add and remove members from this shared folder.
         */
        public final AclUpdatePolicy aclUpdatePolicy;
        /**
         * Who links can be shared with.
         */
        public final SharedLinkPolicy sharedLinkPolicy;

        public FolderPolicy(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            if (memberPolicy != null) {
            }
            this.aclUpdatePolicy = aclUpdatePolicy;
            if (aclUpdatePolicy == null) {
                throw new RuntimeException("Required value for 'aclUpdatePolicy' is null");
            }
            this.sharedLinkPolicy = sharedLinkPolicy;
            if (sharedLinkPolicy == null) {
                throw new RuntimeException("Required value for 'sharedLinkPolicy' is null");
            }
        }
        static final JsonWriter<FolderPolicy> _writer = new JsonWriter<FolderPolicy>()
        {
            public final void write(FolderPolicy x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                FolderPolicy._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FolderPolicy x, JsonGenerator g)
             throws IOException
            {
                if (x.memberPolicy != null) {
                    g.writeFieldName("member_policy");
                    MemberPolicy._writer.write(x.memberPolicy, g);
                }
                g.writeFieldName("acl_update_policy");
                AclUpdatePolicy._writer.write(x.aclUpdatePolicy, g);
                g.writeFieldName("shared_link_policy");
                SharedLinkPolicy._writer.write(x.sharedLinkPolicy, g);
            }
        };

        public static final JsonReader<FolderPolicy> _reader = new JsonReader<FolderPolicy>() {

            public final FolderPolicy read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FolderPolicy result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FolderPolicy readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                AclUpdatePolicy aclUpdatePolicy = null;
                SharedLinkPolicy sharedLinkPolicy = null;
                MemberPolicy memberPolicy = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("acl_update_policy".equals(fieldName)) {
                        aclUpdatePolicy = AclUpdatePolicy._reader
                            .readField(parser, "acl_update_policy", aclUpdatePolicy);
                    }
                    else if ("shared_link_policy".equals(fieldName)) {
                        sharedLinkPolicy = SharedLinkPolicy._reader
                            .readField(parser, "shared_link_policy", sharedLinkPolicy);
                    }
                    else if ("member_policy".equals(fieldName)) {
                        memberPolicy = MemberPolicy._reader
                            .readField(parser, "member_policy", memberPolicy);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (aclUpdatePolicy == null) {
                    throw new JsonReadException("Required field \"acl_update_policy\" is missing.", parser.getTokenLocation());
                }
                if (sharedLinkPolicy == null) {
                    throw new JsonReadException("Required field \"shared_link_policy\" is missing.", parser.getTokenLocation());
                }
                return new FolderPolicy(aclUpdatePolicy, sharedLinkPolicy, memberPolicy);
            }
        };

        public String toString() {
            return "FolderPolicy." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "FolderPolicy." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static FolderPolicy fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Policy governing who can be a member of a shared folder. Only applicable
     * to folders owned by a user on a team.
     */
    public enum MemberPolicy {
        // union MemberPolicy
        /**
         * Only a teammate can become a member.
         */
        team,
        /**
         * Anyone can become a member.
         */
        anyone,
        other;  // *catch_all

        static final JsonWriter<MemberPolicy> _writer = new JsonWriter<MemberPolicy>()
        {
            public void write(MemberPolicy x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case team:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team");
                        g.writeEndObject();
                        break;
                    case anyone:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("anyone");
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

        public static final JsonReader<MemberPolicy> _reader = new JsonReader<MemberPolicy>()
        {
            public final MemberPolicy read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,MemberPolicy> _values;
        static {
            _values = new java.util.HashMap<String,MemberPolicy>();
            _values.put("team", team);
            _values.put("anyone", anyone);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MemberPolicy fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Policy governing who can change a shared folder's access control list
     * (ACL). In other words, who can add, remove, or change the privileges of
     * members.
     */
    public enum AclUpdatePolicy {
        // union AclUpdatePolicy
        /**
         * Only the owner can update the ACL.
         */
        owner,
        /**
         * Any editor can update the ACL. This may be further restricted to
         * editors on the same team.
         */
        editors,
        other;  // *catch_all

        static final JsonWriter<AclUpdatePolicy> _writer = new JsonWriter<AclUpdatePolicy>()
        {
            public void write(AclUpdatePolicy x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case owner:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("owner");
                        g.writeEndObject();
                        break;
                    case editors:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("editors");
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

        public static final JsonReader<AclUpdatePolicy> _reader = new JsonReader<AclUpdatePolicy>()
        {
            public final AclUpdatePolicy read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,AclUpdatePolicy> _values;
        static {
            _values = new java.util.HashMap<String,AclUpdatePolicy>();
            _values.put("owner", owner);
            _values.put("editors", editors);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AclUpdatePolicy fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Policy governing who can view shared links.
     */
    public enum SharedLinkPolicy {
        // union SharedLinkPolicy
        /**
         * Links can be shared with anyone.
         */
        anyone,
        /**
         * Links can only be shared among members of the shared folder.
         */
        members,
        /**
         * An unknown shared link policy.
         */
        other;  // *catch_all

        static final JsonWriter<SharedLinkPolicy> _writer = new JsonWriter<SharedLinkPolicy>()
        {
            public void write(SharedLinkPolicy x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case anyone:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("anyone");
                        g.writeEndObject();
                        break;
                    case members:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("members");
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

        public static final JsonReader<SharedLinkPolicy> _reader = new JsonReader<SharedLinkPolicy>()
        {
            public final SharedLinkPolicy read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,SharedLinkPolicy> _values;
        static {
            _values = new java.util.HashMap<String,SharedLinkPolicy>();
            _values.put("anyone", anyone);
            _values.put("members", members);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedLinkPolicy fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a member of the shared folder.
     */
    public static class MembershipInfo {
        // struct MembershipInfo
        /**
         * The access type for this member.
         */
        public final AccessLevel accessType;

        public MembershipInfo(AccessLevel accessType) {
            this.accessType = accessType;
            if (accessType == null) {
                throw new RuntimeException("Required value for 'accessType' is null");
            }
        }
        static final JsonWriter<MembershipInfo> _writer = new JsonWriter<MembershipInfo>()
        {
            public final void write(MembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                MembershipInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(MembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("access_type");
                AccessLevel._writer.write(x.accessType, g);
            }
        };

        public static final JsonReader<MembershipInfo> _reader = new JsonReader<MembershipInfo>() {

            public final MembershipInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                MembershipInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final MembershipInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                AccessLevel accessType = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                return new MembershipInfo(accessType);
            }
        };

        public String toString() {
            return "MembershipInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MembershipInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MembershipInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Basic information about a user. Use {@link #users.getAccount} and {@link
     * #users.getAccountBatch}` to obtain more detailed information.
     */
    public static class UserInfo {
        // struct UserInfo
        /**
         * The account ID of the user.
         */
        public final String accountId;
        /**
         * If the user is in the same team as current user.
         */
        public final boolean sameTeam;
        /**
         * The team member ID of the shared folder member. Only present if
         * {@code sameTeam} is true.
         */
        public final String teamMemberId;

        public UserInfo(String accountId, boolean sameTeam, String teamMemberId) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new RuntimeException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new RuntimeException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new RuntimeException("String 'accountId' is longer than 40");
            }
            this.sameTeam = sameTeam;
            this.teamMemberId = teamMemberId;
        }
        static final JsonWriter<UserInfo> _writer = new JsonWriter<UserInfo>()
        {
            public final void write(UserInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UserInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UserInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("account_id", x.accountId);
                g.writeBooleanField("same_team", x.sameTeam);
                if (x.teamMemberId != null) {
                    g.writeFieldName("team_member_id");
                    g.writeString(x.teamMemberId);
                }
            }
        };

        public static final JsonReader<UserInfo> _reader = new JsonReader<UserInfo>() {

            public final UserInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UserInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UserInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String accountId = null;
                Boolean sameTeam = null;
                String teamMemberId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("account_id".equals(fieldName)) {
                        accountId = JsonReader.StringReader
                            .readField(parser, "account_id", accountId);
                    }
                    else if ("same_team".equals(fieldName)) {
                        sameTeam = JsonReader.BooleanReader
                            .readField(parser, "same_team", sameTeam);
                    }
                    else if ("team_member_id".equals(fieldName)) {
                        teamMemberId = JsonReader.StringReader
                            .readField(parser, "team_member_id", teamMemberId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accountId == null) {
                    throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
                }
                if (sameTeam == null) {
                    throw new JsonReadException("Required field \"same_team\" is missing.", parser.getTokenLocation());
                }
                return new UserInfo(accountId, sameTeam, teamMemberId);
            }
        };

        public String toString() {
            return "UserInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UserInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UserInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a user member of the shared folder.
     */
    public static class UserMembershipInfo extends MembershipInfo  {
        // struct UserMembershipInfo
        /**
         * The account information for the membership user.
         */
        public final UserInfo user;

        public UserMembershipInfo(AccessLevel accessType, UserInfo user) {
            super(accessType);
            this.user = user;
            if (user == null) {
                throw new RuntimeException("Required value for 'user' is null");
            }
        }
        static final JsonWriter<UserMembershipInfo> _writer = new JsonWriter<UserMembershipInfo>()
        {
            public final void write(UserMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                MembershipInfo._writer.writeFields(x, g);
                UserMembershipInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UserMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("user");
                UserInfo._writer.write(x.user, g);
            }
        };

        public static final JsonReader<UserMembershipInfo> _reader = new JsonReader<UserMembershipInfo>() {

            public final UserMembershipInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UserMembershipInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UserMembershipInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                AccessLevel accessType = null;
                UserInfo user = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("user".equals(fieldName)) {
                        user = UserInfo._reader
                            .readField(parser, "user", user);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (user == null) {
                    throw new JsonReadException("Required field \"user\" is missing.", parser.getTokenLocation());
                }
                return new UserMembershipInfo(accessType, user);
            }
        };

        public String toString() {
            return "UserMembershipInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UserMembershipInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UserMembershipInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a non-Dropbox user invited to join a shared folder.
     */

    public static final class InviteeInfo {
        // union InviteeInfo

        /**
         * The discriminating tag type for {@link InviteeInfo}.
         */
        public enum Tag {
            email,  // String
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String emailValue;
        private InviteeInfo(Tag t, String v) {
            tag = t;
            emailValue = v;
            validate();
        }
        /**
         * E-mail address of invited user.
         */
        public static InviteeInfo email(String v) {
            return new InviteeInfo(Tag.email, v);
        }
        public String getEmail() {
            if (tag != Tag.email) {
                throw new RuntimeException("getEmail() requires tag==email, actual tag=="+tag);
            }
            return emailValue;
        }

        public static final InviteeInfo other = new InviteeInfo(Tag.other);

        private InviteeInfo(Tag t) {
            tag = t;
            emailValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case email:
                    if (this.emailValue == null) {
                        throw new RuntimeException("Required value for 'email' is null");
                    }
                    if (!java.util.regex.Pattern.matches("\\A^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$\\Z", this.emailValue)) {
                        throw new RuntimeException("String 'this.emailValue' does not match pattern");
                    }
                    break;
            }
        }
        static final JsonWriter<InviteeInfo> _writer = new JsonWriter<InviteeInfo>()
        {
            public final void write(InviteeInfo x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case email:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email");
                        g.writeStringField("email", x.emailValue);
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
        public static final JsonReader<InviteeInfo> _reader = new JsonReader<InviteeInfo>()
        {
            public final InviteeInfo read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return InviteeInfo.other; }
                    switch (tag) {
                        case other: return InviteeInfo.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                InviteeInfo value = null;
                if (tag != null) {
                    switch (tag) {
                        case email: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "email", v);
                            value = InviteeInfo.email(v);
                            break;
                        }
                        case other: {
                            value = InviteeInfo.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return InviteeInfo.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("email", Tag.email);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "InviteeInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "InviteeInfo." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static InviteeInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a non-Dropbox member invited to join a shared
     * folder.
     */
    public static class InviteeMembershipInfo extends MembershipInfo  {
        // struct InviteeMembershipInfo
        /**
         * The information for the invited user.
         */
        public final InviteeInfo invitee;

        public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee) {
            super(accessType);
            this.invitee = invitee;
            if (invitee == null) {
                throw new RuntimeException("Required value for 'invitee' is null");
            }
        }
        static final JsonWriter<InviteeMembershipInfo> _writer = new JsonWriter<InviteeMembershipInfo>()
        {
            public final void write(InviteeMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                MembershipInfo._writer.writeFields(x, g);
                InviteeMembershipInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(InviteeMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("invitee");
                InviteeInfo._writer.write(x.invitee, g);
            }
        };

        public static final JsonReader<InviteeMembershipInfo> _reader = new JsonReader<InviteeMembershipInfo>() {

            public final InviteeMembershipInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                InviteeMembershipInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final InviteeMembershipInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                AccessLevel accessType = null;
                InviteeInfo invitee = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("invitee".equals(fieldName)) {
                        invitee = InviteeInfo._reader
                            .readField(parser, "invitee", invitee);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (invitee == null) {
                    throw new JsonReadException("Required field \"invitee\" is missing.", parser.getTokenLocation());
                }
                return new InviteeMembershipInfo(accessType, invitee);
            }
        };

        public String toString() {
            return "InviteeMembershipInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "InviteeMembershipInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static InviteeMembershipInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a group. Groups is a way to manage a list of users
     * who need same access permission to the shared folder.
     */
    public static class GroupInfo extends DbxTeam.GroupSummary  {
        // struct GroupInfo
        /**
         * If the group is owned by the current user's team.
         */
        public final boolean sameTeam;

        public GroupInfo(String groupName, String groupId, long memberCount, boolean sameTeam, String groupExternalId) {
            super(groupName, groupId, memberCount, groupExternalId);
            this.sameTeam = sameTeam;
        }
        static final JsonWriter<GroupInfo> _writer = new JsonWriter<GroupInfo>()
        {
            public final void write(GroupInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                DbxTeam.GroupSummary._writer.writeFields(x, g);
                GroupInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GroupInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("same_team", x.sameTeam);
            }
        };

        public static final JsonReader<GroupInfo> _reader = new JsonReader<GroupInfo>() {

            public final GroupInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GroupInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GroupInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String groupName = null;
                String groupId = null;
                Long memberCount = null;
                Boolean sameTeam = null;
                String groupExternalId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("group_name".equals(fieldName)) {
                        groupName = JsonReader.StringReader
                            .readField(parser, "group_name", groupName);
                    }
                    else if ("group_id".equals(fieldName)) {
                        groupId = JsonReader.StringReader
                            .readField(parser, "group_id", groupId);
                    }
                    else if ("member_count".equals(fieldName)) {
                        memberCount = JsonReader.UInt32Reader
                            .readField(parser, "member_count", memberCount);
                    }
                    else if ("same_team".equals(fieldName)) {
                        sameTeam = JsonReader.BooleanReader
                            .readField(parser, "same_team", sameTeam);
                    }
                    else if ("group_external_id".equals(fieldName)) {
                        groupExternalId = JsonReader.StringReader
                            .readField(parser, "group_external_id", groupExternalId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (groupName == null) {
                    throw new JsonReadException("Required field \"group_name\" is missing.", parser.getTokenLocation());
                }
                if (groupId == null) {
                    throw new JsonReadException("Required field \"group_id\" is missing.", parser.getTokenLocation());
                }
                if (memberCount == null) {
                    throw new JsonReadException("Required field \"member_count\" is missing.", parser.getTokenLocation());
                }
                if (sameTeam == null) {
                    throw new JsonReadException("Required field \"same_team\" is missing.", parser.getTokenLocation());
                }
                return new GroupInfo(groupName, groupId, memberCount, sameTeam, groupExternalId);
            }
        };

        public String toString() {
            return "GroupInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GroupInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GroupInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The information about a group member of the shared folder.
     */
    public static class GroupMembershipInfo extends MembershipInfo  {
        // struct GroupMembershipInfo
        /**
         * The information about the membership group.
         */
        public final GroupInfo group;

        public GroupMembershipInfo(AccessLevel accessType, GroupInfo group) {
            super(accessType);
            this.group = group;
            if (group == null) {
                throw new RuntimeException("Required value for 'group' is null");
            }
        }
        static final JsonWriter<GroupMembershipInfo> _writer = new JsonWriter<GroupMembershipInfo>()
        {
            public final void write(GroupMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                MembershipInfo._writer.writeFields(x, g);
                GroupMembershipInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GroupMembershipInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("group");
                GroupInfo._writer.write(x.group, g);
            }
        };

        public static final JsonReader<GroupMembershipInfo> _reader = new JsonReader<GroupMembershipInfo>() {

            public final GroupMembershipInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GroupMembershipInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GroupMembershipInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                AccessLevel accessType = null;
                GroupInfo group = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("group".equals(fieldName)) {
                        group = GroupInfo._reader
                            .readField(parser, "group", group);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (group == null) {
                    throw new JsonReadException("Required field \"group\" is missing.", parser.getTokenLocation());
                }
                return new GroupMembershipInfo(accessType, group);
            }
        };

        public String toString() {
            return "GroupMembershipInfo." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GroupMembershipInfo." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GroupMembershipInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The base type for shared folder metadata.
     */
    public static class SharedFolderMetadata {
        // struct SharedFolderMetadata
        /**
         * The lower-cased full path of this shared folder. Absent for unmounted
         * folders.
         */
        public final String pathLower;
        /**
         * The name of the this shared folder.
         */
        public final String name;
        /**
         * The ID of the shared folder.
         */
        public final String id;
        /**
         * The current user's access level for this shared folder.
         */
        public final AccessLevel accessType;
        /**
         * Whether this folder is a <a
         * href="https://www.dropbox.com/en/help/986">team folder</a>.
         */
        public final boolean isTeamFolder;
        /**
         * Policies governing this shared folder.
         */
        public final FolderPolicy policy;

        public SharedFolderMetadata(String name, String id, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String pathLower) {
            this.pathLower = pathLower;
            this.name = name;
            if (name == null) {
                throw new RuntimeException("Required value for 'name' is null");
            }
            this.id = id;
            if (id == null) {
                throw new RuntimeException("Required value for 'id' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", id)) {
                throw new RuntimeException("String 'id' does not match pattern");
            }
            this.accessType = accessType;
            if (accessType == null) {
                throw new RuntimeException("Required value for 'accessType' is null");
            }
            this.isTeamFolder = isTeamFolder;
            this.policy = policy;
            if (policy == null) {
                throw new RuntimeException("Required value for 'policy' is null");
            }
        }
        public JsonWriter getWriter() {
            return SharedFolderMetadata._writer;
        }
        static final JsonWriter<SharedFolderMetadata> _writer = new JsonWriter<SharedFolderMetadata>()
        {
            public final void write(SharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                SharedFolderMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
                if (x.pathLower != null) {
                    g.writeFieldName("path_lower");
                    g.writeString(x.pathLower);
                }
                g.writeStringField("name", x.name);
                g.writeStringField("id", x.id);
                g.writeFieldName("access_type");
                AccessLevel._writer.write(x.accessType, g);
                g.writeBooleanField("is_team_folder", x.isTeamFolder);
                g.writeFieldName("policy");
                FolderPolicy._writer.write(x.policy, g);
            }
        };

        public static final JsonReader<SharedFolderMetadata> _reader = new JsonReader<SharedFolderMetadata>() {

            public final SharedFolderMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SharedFolderMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharedFolderMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null && tags.length > 0) {
                    if ("basic".equals(tags[0])) {
                        return BasicSharedFolderMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("full".equals(tags[0])) {
                        return FullSharedFolderMetadata._reader.readFromTags(tags, parser);
                    }
                    // If no match, fall back to base class
                }
                return readFields(parser);
            }

            public final SharedFolderMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String id = null;
                AccessLevel accessType = null;
                Boolean isTeamFolder = null;
                FolderPolicy policy = null;
                String pathLower = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("is_team_folder".equals(fieldName)) {
                        isTeamFolder = JsonReader.BooleanReader
                            .readField(parser, "is_team_folder", isTeamFolder);
                    }
                    else if ("policy".equals(fieldName)) {
                        policy = FolderPolicy._reader
                            .readField(parser, "policy", policy);
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
                if (id == null) {
                    throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (isTeamFolder == null) {
                    throw new JsonReadException("Required field \"is_team_folder\" is missing.", parser.getTokenLocation());
                }
                if (policy == null) {
                    throw new JsonReadException("Required field \"policy\" is missing.", parser.getTokenLocation());
                }
                return new SharedFolderMetadata(name, id, accessType, isTeamFolder, policy, pathLower);
            }
        };

        public String toString() {
            return "SharedFolderMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedFolderMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedFolderMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The metadata which includes basic information about the shared folder.
     */
    public static class BasicSharedFolderMetadata extends SharedFolderMetadata  {
        // struct BasicSharedFolderMetadata

        public BasicSharedFolderMetadata(String name, String id, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String pathLower) {
            super(name, id, accessType, isTeamFolder, policy, pathLower);
        }
        public JsonWriter getWriter() {
            return BasicSharedFolderMetadata._writer;
        }
        static final JsonWriter<BasicSharedFolderMetadata> _writer = new JsonWriter<BasicSharedFolderMetadata>()
        {
            public final void write(BasicSharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "basic");
                SharedFolderMetadata._writer.writeFields(x, g);
                BasicSharedFolderMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(BasicSharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
            }
        };

        public static final JsonReader<BasicSharedFolderMetadata> _reader = new JsonReader<BasicSharedFolderMetadata>() {

            public final BasicSharedFolderMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                BasicSharedFolderMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final BasicSharedFolderMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "basic".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final BasicSharedFolderMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String id = null;
                AccessLevel accessType = null;
                Boolean isTeamFolder = null;
                FolderPolicy policy = null;
                String pathLower = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("is_team_folder".equals(fieldName)) {
                        isTeamFolder = JsonReader.BooleanReader
                            .readField(parser, "is_team_folder", isTeamFolder);
                    }
                    else if ("policy".equals(fieldName)) {
                        policy = FolderPolicy._reader
                            .readField(parser, "policy", policy);
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
                if (id == null) {
                    throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (isTeamFolder == null) {
                    throw new JsonReadException("Required field \"is_team_folder\" is missing.", parser.getTokenLocation());
                }
                if (policy == null) {
                    throw new JsonReadException("Required field \"policy\" is missing.", parser.getTokenLocation());
                }
                return new BasicSharedFolderMetadata(name, id, accessType, isTeamFolder, policy, pathLower);
            }
        };

        public String toString() {
            return "BasicSharedFolderMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "BasicSharedFolderMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static BasicSharedFolderMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The full metadata for the shared folder which includes user and group
     * membership.
     */
    public static class FullSharedFolderMetadata extends SharedFolderMetadata  {
        // struct FullSharedFolderMetadata
        /**
         * The list of user members of the shared folder.
         */
        public final java.util.ArrayList<UserMembershipInfo> membership;
        /**
         * The list of group members of the shared folder.
         */
        public final java.util.ArrayList<GroupMembershipInfo> groups;
        /**
         * The list of non-Dropbox users invited to join the shared folder.
         */
        public final java.util.ArrayList<InviteeMembershipInfo> invitees;

        public FullSharedFolderMetadata(String name, String id, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, java.util.ArrayList<UserMembershipInfo> membership, java.util.ArrayList<GroupMembershipInfo> groups, java.util.ArrayList<InviteeMembershipInfo> invitees, String pathLower) {
            super(name, id, accessType, isTeamFolder, policy, pathLower);
            this.membership = membership;
            if (membership == null) {
                throw new RuntimeException("Required value for 'membership' is null");
            }
            for (UserMembershipInfo x : membership) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'membership' is null");
                }
            }
            this.groups = groups;
            if (groups == null) {
                throw new RuntimeException("Required value for 'groups' is null");
            }
            for (GroupMembershipInfo x : groups) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'groups' is null");
                }
            }
            this.invitees = invitees;
            if (invitees == null) {
                throw new RuntimeException("Required value for 'invitees' is null");
            }
            for (InviteeMembershipInfo x : invitees) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'invitees' is null");
                }
            }
        }
        public JsonWriter getWriter() {
            return FullSharedFolderMetadata._writer;
        }
        static final JsonWriter<FullSharedFolderMetadata> _writer = new JsonWriter<FullSharedFolderMetadata>()
        {
            public final void write(FullSharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "full");
                SharedFolderMetadata._writer.writeFields(x, g);
                FullSharedFolderMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FullSharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("membership");
                g.writeStartArray();
                for (UserMembershipInfo item: x.membership) {
                    if (item != null) {
                        UserMembershipInfo._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeFieldName("groups");
                g.writeStartArray();
                for (GroupMembershipInfo item: x.groups) {
                    if (item != null) {
                        GroupMembershipInfo._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeFieldName("invitees");
                g.writeStartArray();
                for (InviteeMembershipInfo item: x.invitees) {
                    if (item != null) {
                        InviteeMembershipInfo._writer.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        };

        public static final JsonReader<FullSharedFolderMetadata> _reader = new JsonReader<FullSharedFolderMetadata>() {

            public final FullSharedFolderMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FullSharedFolderMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FullSharedFolderMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "full".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final FullSharedFolderMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String id = null;
                AccessLevel accessType = null;
                Boolean isTeamFolder = null;
                FolderPolicy policy = null;
                java.util.ArrayList<UserMembershipInfo> membership = null;
                java.util.ArrayList<GroupMembershipInfo> groups = null;
                java.util.ArrayList<InviteeMembershipInfo> invitees = null;
                String pathLower = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("access_type".equals(fieldName)) {
                        accessType = AccessLevel._reader
                            .readField(parser, "access_type", accessType);
                    }
                    else if ("is_team_folder".equals(fieldName)) {
                        isTeamFolder = JsonReader.BooleanReader
                            .readField(parser, "is_team_folder", isTeamFolder);
                    }
                    else if ("policy".equals(fieldName)) {
                        policy = FolderPolicy._reader
                            .readField(parser, "policy", policy);
                    }
                    else if ("membership".equals(fieldName)) {
                        membership = JsonArrayReader.mk(UserMembershipInfo._reader)
                            .readField(parser, "membership", membership);
                    }
                    else if ("groups".equals(fieldName)) {
                        groups = JsonArrayReader.mk(GroupMembershipInfo._reader)
                            .readField(parser, "groups", groups);
                    }
                    else if ("invitees".equals(fieldName)) {
                        invitees = JsonArrayReader.mk(InviteeMembershipInfo._reader)
                            .readField(parser, "invitees", invitees);
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
                if (id == null) {
                    throw new JsonReadException("Required field \"id\" is missing.", parser.getTokenLocation());
                }
                if (accessType == null) {
                    throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
                }
                if (isTeamFolder == null) {
                    throw new JsonReadException("Required field \"is_team_folder\" is missing.", parser.getTokenLocation());
                }
                if (policy == null) {
                    throw new JsonReadException("Required field \"policy\" is missing.", parser.getTokenLocation());
                }
                if (membership == null) {
                    throw new JsonReadException("Required field \"membership\" is missing.", parser.getTokenLocation());
                }
                if (groups == null) {
                    throw new JsonReadException("Required field \"groups\" is missing.", parser.getTokenLocation());
                }
                if (invitees == null) {
                    throw new JsonReadException("Required field \"invitees\" is missing.", parser.getTokenLocation());
                }
                return new FullSharedFolderMetadata(name, id, accessType, isTeamFolder, policy, membership, groups, invitees, pathLower);
            }
        };

        public String toString() {
            return "FullSharedFolderMetadata." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "FullSharedFolderMetadata." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static FullSharedFolderMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * There is an error accessing the shared folder.
     */
    public enum SharedFolderAccessError {
        // union SharedFolderAccessError
        /**
         * This shared folder ID is invalid.
         */
        invalidId,
        /**
         * The user is not a member of the shared folder thus cannot access it.
         */
        notMember,
        /**
         * The current user does not have sufficient privileges to perform the
         * desired action.
         */
        noPermission,
        /**
         * The current account's e-mail address is unverified.
         */
        emailUnverified,
        /**
         * The current user cannot perform this action on a team shared folder.
         */
        teamFolder,
        /**
         * The shared folder is unmounted.
         */
        unmounted,
        other;  // *catch_all

        static final JsonWriter<SharedFolderAccessError> _writer = new JsonWriter<SharedFolderAccessError>()
        {
            public void write(SharedFolderAccessError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case invalidId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_id");
                        g.writeEndObject();
                        break;
                    case notMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_member");
                        g.writeEndObject();
                        break;
                    case noPermission:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case emailUnverified:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case teamFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_folder");
                        g.writeEndObject();
                        break;
                    case unmounted:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unmounted");
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

        public static final JsonReader<SharedFolderAccessError> _reader = new JsonReader<SharedFolderAccessError>()
        {
            public final SharedFolderAccessError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,SharedFolderAccessError> _values;
        static {
            _values = new java.util.HashMap<String,SharedFolderAccessError>();
            _values.put("invalid_id", invalidId);
            _values.put("not_member", notMember);
            _values.put("no_permission", noPermission);
            _values.put("email_unverified", emailUnverified);
            _values.put("team_folder", teamFolder);
            _values.put("unmounted", unmounted);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedFolderAccessError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class GetMetadataArgs {
        // struct GetMetadataArgs
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * If {@literal true}, user and group membership included in the
         * response.
         */
        public final boolean includeMembership;

        public GetMetadataArgs(String sharedFolderId, Boolean includeMembership) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            if (includeMembership != null) {
                this.includeMembership = includeMembership.booleanValue();
            }
            else {
                this.includeMembership = true;
            }
        }
        static final JsonWriter<GetMetadataArgs> _writer = new JsonWriter<GetMetadataArgs>()
        {
            public final void write(GetMetadataArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetMetadataArgs._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetMetadataArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeBooleanField("include_membership", x.includeMembership);
            }
        };

        public static final JsonReader<GetMetadataArgs> _reader = new JsonReader<GetMetadataArgs>() {

            public final GetMetadataArgs read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetMetadataArgs result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetMetadataArgs readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                Boolean includeMembership = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("include_membership".equals(fieldName)) {
                        includeMembership = JsonReader.BooleanReader
                            .readField(parser, "include_membership", includeMembership);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new GetMetadataArgs(sharedFolderId, includeMembership);
            }
        };

        public String toString() {
            return "GetMetadataArgs." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetMetadataArgs." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetMetadataArgs fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ListFoldersArgs {
        // struct ListFoldersArgs
        /**
         * If include user and group membership information in the response.
         */
        public final boolean includeMembership;

        public ListFoldersArgs(Boolean includeMembership) {
            if (includeMembership != null) {
                this.includeMembership = includeMembership.booleanValue();
            }
            else {
                this.includeMembership = false;
            }
        }
        static final JsonWriter<ListFoldersArgs> _writer = new JsonWriter<ListFoldersArgs>()
        {
            public final void write(ListFoldersArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFoldersArgs._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFoldersArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeBooleanField("include_membership", x.includeMembership);
            }
        };

        public static final JsonReader<ListFoldersArgs> _reader = new JsonReader<ListFoldersArgs>() {

            public final ListFoldersArgs read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFoldersArgs result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFoldersArgs readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean includeMembership = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("include_membership".equals(fieldName)) {
                        includeMembership = JsonReader.BooleanReader
                            .readField(parser, "include_membership", includeMembership);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new ListFoldersArgs(includeMembership);
            }
        };

        public String toString() {
            return "ListFoldersArgs." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFoldersArgs." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFoldersArgs fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Result for {@link #listFolders}. Unmounted shared folders can be
     * identified by the absence of {@code sharedFolderMetadata.pathLower}.
     */
    public static class ListFoldersResult {
        // struct ListFoldersResult
        /**
         * List of all shared folders the authenticated user has access to.
         */
        public final java.util.ArrayList<SharedFolderMetadata> entries;

        public ListFoldersResult(java.util.ArrayList<SharedFolderMetadata> entries) {
            this.entries = entries;
            if (entries == null) {
                throw new RuntimeException("Required value for 'entries' is null");
            }
            for (SharedFolderMetadata x : entries) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'entries' is null");
                }
            }
        }
        static final JsonWriter<ListFoldersResult> _writer = new JsonWriter<ListFoldersResult>()
        {
            public final void write(ListFoldersResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFoldersResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFoldersResult x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("entries");
                g.writeStartArray();
                for (SharedFolderMetadata item: x.entries) {
                    if (item != null) {
                        SharedFolderMetadata._writer.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        };

        public static final JsonReader<ListFoldersResult> _reader = new JsonReader<ListFoldersResult>() {

            public final ListFoldersResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFoldersResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFoldersResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.ArrayList<SharedFolderMetadata> entries = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("entries".equals(fieldName)) {
                        entries = JsonArrayReader.mk(SharedFolderMetadata._reader)
                            .readField(parser, "entries", entries);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (entries == null) {
                    throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
                }
                return new ListFoldersResult(entries);
            }
        };

        public String toString() {
            return "ListFoldersResult." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFoldersResult." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFoldersResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class ShareFolderArg {
        // struct ShareFolderArg
        /**
         * The path to the folder to share. If it does not exist, then a new one
         * is created.
         */
        public final String path;
        /**
         * Who can be a member of this shared folder.
         */
        public final MemberPolicy memberPolicy;
        /**
         * Who can add and remove members of this shared folder.
         */
        public final AclUpdatePolicy aclUpdatePolicy;
        /**
         * The policy to apply to shared links created for content inside this
         * shared folder.
         */
        public final SharedLinkPolicy sharedLinkPolicy;
        /**
         * Whether to force the share to happen asynchronously.
         */
        public final boolean forceAsync;

        public ShareFolderArg(String path, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, Boolean forceAsync) {
            this.path = path;
            if (path == null) {
                throw new RuntimeException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A/.*\\Z", path)) {
                throw new RuntimeException("String 'path' does not match pattern");
            }
            if (memberPolicy != null) {
                this.memberPolicy = memberPolicy;
            }
            else {
                this.memberPolicy = MemberPolicy.anyone;
            }
            if (aclUpdatePolicy != null) {
                this.aclUpdatePolicy = aclUpdatePolicy;
            }
            else {
                this.aclUpdatePolicy = AclUpdatePolicy.owner;
            }
            if (sharedLinkPolicy != null) {
                this.sharedLinkPolicy = sharedLinkPolicy;
            }
            else {
                this.sharedLinkPolicy = SharedLinkPolicy.anyone;
            }
            if (forceAsync != null) {
                this.forceAsync = forceAsync.booleanValue();
            }
            else {
                this.forceAsync = false;
            }
        }
        static final JsonWriter<ShareFolderArg> _writer = new JsonWriter<ShareFolderArg>()
        {
            public final void write(ShareFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ShareFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ShareFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                g.writeFieldName("member_policy");
                MemberPolicy._writer.write(x.memberPolicy, g);
                g.writeFieldName("acl_update_policy");
                AclUpdatePolicy._writer.write(x.aclUpdatePolicy, g);
                g.writeFieldName("shared_link_policy");
                SharedLinkPolicy._writer.write(x.sharedLinkPolicy, g);
                g.writeBooleanField("force_async", x.forceAsync);
            }
        };

        public static final JsonReader<ShareFolderArg> _reader = new JsonReader<ShareFolderArg>() {

            public final ShareFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ShareFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ShareFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                MemberPolicy memberPolicy = null;
                AclUpdatePolicy aclUpdatePolicy = null;
                SharedLinkPolicy sharedLinkPolicy = null;
                Boolean forceAsync = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("member_policy".equals(fieldName)) {
                        memberPolicy = MemberPolicy._reader
                            .readField(parser, "member_policy", memberPolicy);
                    }
                    else if ("acl_update_policy".equals(fieldName)) {
                        aclUpdatePolicy = AclUpdatePolicy._reader
                            .readField(parser, "acl_update_policy", aclUpdatePolicy);
                    }
                    else if ("shared_link_policy".equals(fieldName)) {
                        sharedLinkPolicy = SharedLinkPolicy._reader
                            .readField(parser, "shared_link_policy", sharedLinkPolicy);
                    }
                    else if ("force_async".equals(fieldName)) {
                        forceAsync = JsonReader.BooleanReader
                            .readField(parser, "force_async", forceAsync);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
            }
        };

        public String toString() {
            return "ShareFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ShareFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ShareFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ShareFolderError {
        // union ShareFolderError

        /**
         * The discriminating tag type for {@link ShareFolderError}.
         */
        public enum Tag {
            emailUnverified,
            badPath,  // SharePathError
            teamPolicyDisallowsMemberPolicy,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * The current account's e-mail address is unverified.
         */
        public static final ShareFolderError emailUnverified = new ShareFolderError(Tag.emailUnverified);

        private final SharePathError badPathValue;
        private ShareFolderError(Tag t, SharePathError v) {
            tag = t;
            badPathValue = v;
            validate();
        }
        /**
         * {@code shareFolderArg.path} is invalid.
         */
        public static ShareFolderError badPath(SharePathError v) {
            return new ShareFolderError(Tag.badPath, v);
        }
        public SharePathError getBadPath() {
            if (tag != Tag.badPath) {
                throw new RuntimeException("getBadPath() requires tag==badPath, actual tag=="+tag);
            }
            return badPathValue;
        }

        /**
         * Team policy is more restrictive than {@code
         * shareFolderArg.memberPolicy}.
         */
        public static final ShareFolderError teamPolicyDisallowsMemberPolicy = new ShareFolderError(Tag.teamPolicyDisallowsMemberPolicy);

        public static final ShareFolderError other = new ShareFolderError(Tag.other);

        private ShareFolderError(Tag t) {
            tag = t;
            badPathValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case emailUnverified:
                case teamPolicyDisallowsMemberPolicy:
                case other:
                    break;
                case badPath:
                    if (this.badPathValue == null) {
                        throw new RuntimeException("Required value for 'badPath' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ShareFolderError> _writer = new JsonWriter<ShareFolderError>()
        {
            public final void write(ShareFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case emailUnverified:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case badPath:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("bad_path");
                        g.writeFieldName("bad_path");
                        SharePathError._writer.write(x.badPathValue, g);
                        g.writeEndObject();
                        break;
                    case teamPolicyDisallowsMemberPolicy:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_policy_disallows_member_policy");
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
        public static final JsonReader<ShareFolderError> _reader = new JsonReader<ShareFolderError>()
        {
            public final ShareFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ShareFolderError.other; }
                    switch (tag) {
                        case emailUnverified: return ShareFolderError.emailUnverified;
                        case teamPolicyDisallowsMemberPolicy: return ShareFolderError.teamPolicyDisallowsMemberPolicy;
                        case other: return ShareFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ShareFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case emailUnverified: {
                            value = ShareFolderError.emailUnverified;
                            break;
                        }
                        case badPath: {
                            SharePathError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharePathError._reader
                                .readField(parser, "bad_path", v);
                            value = ShareFolderError.badPath(v);
                            break;
                        }
                        case teamPolicyDisallowsMemberPolicy: {
                            value = ShareFolderError.teamPolicyDisallowsMemberPolicy;
                            break;
                        }
                        case other: {
                            value = ShareFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ShareFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("email_unverified", Tag.emailUnverified);
            _values.put("bad_path", Tag.badPath);
            _values.put("team_policy_disallows_member_policy", Tag.teamPolicyDisallowsMemberPolicy);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "ShareFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ShareFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ShareFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum SharePathError {
        // union SharePathError
        /**
         * A file is at the specified path.
         */
        isFile,
        /**
         * We do not support sharing a folder inside a shared folder.
         */
        insideSharedFolder,
        /**
         * We do not support shared folders that contain shared folders.
         */
        containsSharedFolder,
        /**
         * We do not support sharing an app folder.
         */
        isAppFolder,
        /**
         * We do not support sharing a folder inside an app folder.
         */
        insideAppFolder,
        /**
         * Folder is already shared.
         */
        alreadyShared,
        /**
         * Path is not valid.
         */
        invalidPath,
        other;  // *catch_all

        static final JsonWriter<SharePathError> _writer = new JsonWriter<SharePathError>()
        {
            public void write(SharePathError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case isFile:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("is_file");
                        g.writeEndObject();
                        break;
                    case insideSharedFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_shared_folder");
                        g.writeEndObject();
                        break;
                    case containsSharedFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("contains_shared_folder");
                        g.writeEndObject();
                        break;
                    case isAppFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("is_app_folder");
                        g.writeEndObject();
                        break;
                    case insideAppFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_app_folder");
                        g.writeEndObject();
                        break;
                    case alreadyShared:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("already_shared");
                        g.writeEndObject();
                        break;
                    case invalidPath:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_path");
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

        public static final JsonReader<SharePathError> _reader = new JsonReader<SharePathError>()
        {
            public final SharePathError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,SharePathError> _values;
        static {
            _values = new java.util.HashMap<String,SharePathError>();
            _values.put("is_file", isFile);
            _values.put("inside_shared_folder", insideSharedFolder);
            _values.put("contains_shared_folder", containsSharedFolder);
            _values.put("is_app_folder", isAppFolder);
            _values.put("inside_app_folder", insideAppFolder);
            _values.put("already_shared", alreadyShared);
            _values.put("invalid_path", invalidPath);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharePathError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * If any of the policy's are unset, then they retain their current setting.
     */
    public static class UpdateFolderPolicyArg {
        // struct UpdateFolderPolicyArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * Who can be a member of this shared folder. Only set this if the
         * current user is on a team.
         */
        public final MemberPolicy memberPolicy;
        /**
         * Who can add and remove members of this shared folder.
         */
        public final AclUpdatePolicy aclUpdatePolicy;
        /**
         * The policy to apply to shared links created for content inside this
         * shared folder.
         */
        public final SharedLinkPolicy sharedLinkPolicy;

        public UpdateFolderPolicyArg(String sharedFolderId, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.memberPolicy = memberPolicy;
            if (memberPolicy != null) {
            }
            this.aclUpdatePolicy = aclUpdatePolicy;
            if (aclUpdatePolicy != null) {
            }
            this.sharedLinkPolicy = sharedLinkPolicy;
            if (sharedLinkPolicy != null) {
            }
        }
        static final JsonWriter<UpdateFolderPolicyArg> _writer = new JsonWriter<UpdateFolderPolicyArg>()
        {
            public final void write(UpdateFolderPolicyArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UpdateFolderPolicyArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UpdateFolderPolicyArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                if (x.memberPolicy != null) {
                    g.writeFieldName("member_policy");
                    MemberPolicy._writer.write(x.memberPolicy, g);
                }
                if (x.aclUpdatePolicy != null) {
                    g.writeFieldName("acl_update_policy");
                    AclUpdatePolicy._writer.write(x.aclUpdatePolicy, g);
                }
                if (x.sharedLinkPolicy != null) {
                    g.writeFieldName("shared_link_policy");
                    SharedLinkPolicy._writer.write(x.sharedLinkPolicy, g);
                }
            }
        };

        public static final JsonReader<UpdateFolderPolicyArg> _reader = new JsonReader<UpdateFolderPolicyArg>() {

            public final UpdateFolderPolicyArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UpdateFolderPolicyArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UpdateFolderPolicyArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                MemberPolicy memberPolicy = null;
                AclUpdatePolicy aclUpdatePolicy = null;
                SharedLinkPolicy sharedLinkPolicy = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("member_policy".equals(fieldName)) {
                        memberPolicy = MemberPolicy._reader
                            .readField(parser, "member_policy", memberPolicy);
                    }
                    else if ("acl_update_policy".equals(fieldName)) {
                        aclUpdatePolicy = AclUpdatePolicy._reader
                            .readField(parser, "acl_update_policy", aclUpdatePolicy);
                    }
                    else if ("shared_link_policy".equals(fieldName)) {
                        sharedLinkPolicy = SharedLinkPolicy._reader
                            .readField(parser, "shared_link_policy", sharedLinkPolicy);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
            }
        };

        public String toString() {
            return "UpdateFolderPolicyArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UpdateFolderPolicyArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UpdateFolderPolicyArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UpdateFolderPolicyError {
        // union UpdateFolderPolicyError

        /**
         * The discriminating tag type for {@link UpdateFolderPolicyError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            notOnTeam,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private UpdateFolderPolicyError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static UpdateFolderPolicyError accessError(SharedFolderAccessError v) {
            return new UpdateFolderPolicyError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * {@code updateFolderPolicyArg.memberPolicy} was set even though user
         * is not on a team.
         */
        public static final UpdateFolderPolicyError notOnTeam = new UpdateFolderPolicyError(Tag.notOnTeam);

        public static final UpdateFolderPolicyError other = new UpdateFolderPolicyError(Tag.other);

        private UpdateFolderPolicyError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case notOnTeam:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UpdateFolderPolicyError> _writer = new JsonWriter<UpdateFolderPolicyError>()
        {
            public final void write(UpdateFolderPolicyError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case notOnTeam:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_on_team");
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
        public static final JsonReader<UpdateFolderPolicyError> _reader = new JsonReader<UpdateFolderPolicyError>()
        {
            public final UpdateFolderPolicyError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UpdateFolderPolicyError.other; }
                    switch (tag) {
                        case notOnTeam: return UpdateFolderPolicyError.notOnTeam;
                        case other: return UpdateFolderPolicyError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UpdateFolderPolicyError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = UpdateFolderPolicyError.accessError(v);
                            break;
                        }
                        case notOnTeam: {
                            value = UpdateFolderPolicyError.notOnTeam;
                            break;
                        }
                        case other: {
                            value = UpdateFolderPolicyError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UpdateFolderPolicyError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("not_on_team", Tag.notOnTeam);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UpdateFolderPolicyError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UpdateFolderPolicyError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UpdateFolderPolicyError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UnshareFolderArg {
        // struct UnshareFolderArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * If true, members of this shared folder will get a copy of this folder
         * after it's unshared. Otherwise, it will be removed from their
         * Dropbox. The current user, who is an owner, will always retain their
         * copy.
         */
        public final boolean leaveACopy;

        public UnshareFolderArg(String sharedFolderId, boolean leaveACopy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.leaveACopy = leaveACopy;
        }
        static final JsonWriter<UnshareFolderArg> _writer = new JsonWriter<UnshareFolderArg>()
        {
            public final void write(UnshareFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UnshareFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UnshareFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeBooleanField("leave_a_copy", x.leaveACopy);
            }
        };

        public static final JsonReader<UnshareFolderArg> _reader = new JsonReader<UnshareFolderArg>() {

            public final UnshareFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UnshareFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UnshareFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                Boolean leaveACopy = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("leave_a_copy".equals(fieldName)) {
                        leaveACopy = JsonReader.BooleanReader
                            .readField(parser, "leave_a_copy", leaveACopy);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                if (leaveACopy == null) {
                    throw new JsonReadException("Required field \"leave_a_copy\" is missing.", parser.getTokenLocation());
                }
                return new UnshareFolderArg(sharedFolderId, leaveACopy);
            }
        };

        public String toString() {
            return "UnshareFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UnshareFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UnshareFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UnshareFolderError {
        // union UnshareFolderError

        /**
         * The discriminating tag type for {@link UnshareFolderError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private UnshareFolderError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static UnshareFolderError accessError(SharedFolderAccessError v) {
            return new UnshareFolderError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        public static final UnshareFolderError other = new UnshareFolderError(Tag.other);

        private UnshareFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UnshareFolderError> _writer = new JsonWriter<UnshareFolderError>()
        {
            public final void write(UnshareFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
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
        public static final JsonReader<UnshareFolderError> _reader = new JsonReader<UnshareFolderError>()
        {
            public final UnshareFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UnshareFolderError.other; }
                    switch (tag) {
                        case other: return UnshareFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UnshareFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = UnshareFolderError.accessError(v);
                            break;
                        }
                        case other: {
                            value = UnshareFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UnshareFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UnshareFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UnshareFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UnshareFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class TransferFolderArg {
        // struct TransferFolderArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * A account or team member ID to transfer ownership to.
         */
        public final String toDropboxId;

        public TransferFolderArg(String sharedFolderId, String toDropboxId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.toDropboxId = toDropboxId;
            if (toDropboxId == null) {
                throw new RuntimeException("Required value for 'toDropboxId' is null");
            }
            if (toDropboxId.length() < 1) {
                throw new RuntimeException("String 'toDropboxId' is shorter than 1");
            }
        }
        static final JsonWriter<TransferFolderArg> _writer = new JsonWriter<TransferFolderArg>()
        {
            public final void write(TransferFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                TransferFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(TransferFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeStringField("to_dropbox_id", x.toDropboxId);
            }
        };

        public static final JsonReader<TransferFolderArg> _reader = new JsonReader<TransferFolderArg>() {

            public final TransferFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                TransferFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final TransferFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                String toDropboxId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("to_dropbox_id".equals(fieldName)) {
                        toDropboxId = JsonReader.StringReader
                            .readField(parser, "to_dropbox_id", toDropboxId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                if (toDropboxId == null) {
                    throw new JsonReadException("Required field \"to_dropbox_id\" is missing.", parser.getTokenLocation());
                }
                return new TransferFolderArg(sharedFolderId, toDropboxId);
            }
        };

        public String toString() {
            return "TransferFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "TransferFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static TransferFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class TransferFolderError {
        // union TransferFolderError

        /**
         * The discriminating tag type for {@link TransferFolderError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            invalidDropboxId,
            noPermission,
            newOwnerNotMember,
            newOwnerUnmounted,
            newOwnerEmailUnverified,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private TransferFolderError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static TransferFolderError accessError(SharedFolderAccessError v) {
            return new TransferFolderError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        public static final TransferFolderError invalidDropboxId = new TransferFolderError(Tag.invalidDropboxId);

        public static final TransferFolderError noPermission = new TransferFolderError(Tag.noPermission);

        /**
         * The new designated owner is not currently a member of the shared
         * folder.
         */
        public static final TransferFolderError newOwnerNotMember = new TransferFolderError(Tag.newOwnerNotMember);

        /**
         * The new desginated owner does not have the shared folder mounted.
         */
        public static final TransferFolderError newOwnerUnmounted = new TransferFolderError(Tag.newOwnerUnmounted);

        /**
         * The new designated owner's e-mail address is unverified.
         */
        public static final TransferFolderError newOwnerEmailUnverified = new TransferFolderError(Tag.newOwnerEmailUnverified);

        public static final TransferFolderError other = new TransferFolderError(Tag.other);

        private TransferFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case invalidDropboxId:
                case noPermission:
                case newOwnerNotMember:
                case newOwnerUnmounted:
                case newOwnerEmailUnverified:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<TransferFolderError> _writer = new JsonWriter<TransferFolderError>()
        {
            public final void write(TransferFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case invalidDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case noPermission:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case newOwnerNotMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_not_member");
                        g.writeEndObject();
                        break;
                    case newOwnerUnmounted:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_unmounted");
                        g.writeEndObject();
                        break;
                    case newOwnerEmailUnverified:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_email_unverified");
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
        public static final JsonReader<TransferFolderError> _reader = new JsonReader<TransferFolderError>()
        {
            public final TransferFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return TransferFolderError.other; }
                    switch (tag) {
                        case invalidDropboxId: return TransferFolderError.invalidDropboxId;
                        case noPermission: return TransferFolderError.noPermission;
                        case newOwnerNotMember: return TransferFolderError.newOwnerNotMember;
                        case newOwnerUnmounted: return TransferFolderError.newOwnerUnmounted;
                        case newOwnerEmailUnverified: return TransferFolderError.newOwnerEmailUnverified;
                        case other: return TransferFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                TransferFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = TransferFolderError.accessError(v);
                            break;
                        }
                        case invalidDropboxId: {
                            value = TransferFolderError.invalidDropboxId;
                            break;
                        }
                        case noPermission: {
                            value = TransferFolderError.noPermission;
                            break;
                        }
                        case newOwnerNotMember: {
                            value = TransferFolderError.newOwnerNotMember;
                            break;
                        }
                        case newOwnerUnmounted: {
                            value = TransferFolderError.newOwnerUnmounted;
                            break;
                        }
                        case newOwnerEmailUnverified: {
                            value = TransferFolderError.newOwnerEmailUnverified;
                            break;
                        }
                        case other: {
                            value = TransferFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return TransferFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("invalid_dropbox_id", Tag.invalidDropboxId);
            _values.put("no_permission", Tag.noPermission);
            _values.put("new_owner_not_member", Tag.newOwnerNotMember);
            _values.put("new_owner_unmounted", Tag.newOwnerUnmounted);
            _values.put("new_owner_email_unverified", Tag.newOwnerEmailUnverified);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "TransferFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "TransferFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static TransferFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UnmountFolderArg {
        // struct UnmountFolderArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;

        public UnmountFolderArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
        }
        static final JsonWriter<UnmountFolderArg> _writer = new JsonWriter<UnmountFolderArg>()
        {
            public final void write(UnmountFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UnmountFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UnmountFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
            }
        };

        public static final JsonReader<UnmountFolderArg> _reader = new JsonReader<UnmountFolderArg>() {

            public final UnmountFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UnmountFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UnmountFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new UnmountFolderArg(sharedFolderId);
            }
        };

        public String toString() {
            return "UnmountFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UnmountFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UnmountFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UnmountFolderError {
        // union UnmountFolderError

        /**
         * The discriminating tag type for {@link UnmountFolderError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private UnmountFolderError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static UnmountFolderError accessError(SharedFolderAccessError v) {
            return new UnmountFolderError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        public static final UnmountFolderError other = new UnmountFolderError(Tag.other);

        private UnmountFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UnmountFolderError> _writer = new JsonWriter<UnmountFolderError>()
        {
            public final void write(UnmountFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
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
        public static final JsonReader<UnmountFolderError> _reader = new JsonReader<UnmountFolderError>()
        {
            public final UnmountFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UnmountFolderError.other; }
                    switch (tag) {
                        case other: return UnmountFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UnmountFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = UnmountFolderError.accessError(v);
                            break;
                        }
                        case other: {
                            value = UnmountFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UnmountFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UnmountFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UnmountFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UnmountFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class MountFolderArg {
        // struct MountFolderArg
        /**
         * The ID of the shared folder to mount.
         */
        public final String sharedFolderId;

        public MountFolderArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
        }
        static final JsonWriter<MountFolderArg> _writer = new JsonWriter<MountFolderArg>()
        {
            public final void write(MountFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                MountFolderArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(MountFolderArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
            }
        };

        public static final JsonReader<MountFolderArg> _reader = new JsonReader<MountFolderArg>() {

            public final MountFolderArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                MountFolderArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final MountFolderArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new MountFolderArg(sharedFolderId);
            }
        };

        public String toString() {
            return "MountFolderArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MountFolderArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MountFolderArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class MountFolderError {
        // union MountFolderError

        /**
         * The discriminating tag type for {@link MountFolderError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            insideSharedFolder,
            insufficientQuota,
            alreadyMounted,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private MountFolderError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static MountFolderError accessError(SharedFolderAccessError v) {
            return new MountFolderError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * Mounting would cause a shared folder to be inside another, which is
         * disallowed.
         */
        public static final MountFolderError insideSharedFolder = new MountFolderError(Tag.insideSharedFolder);

        /**
         * The current user does not have enough space to mount the shared
         * folder.
         */
        public static final MountFolderError insufficientQuota = new MountFolderError(Tag.insufficientQuota);

        /**
         * The shared folder is already mounted.
         */
        public static final MountFolderError alreadyMounted = new MountFolderError(Tag.alreadyMounted);

        public static final MountFolderError other = new MountFolderError(Tag.other);

        private MountFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case insideSharedFolder:
                case insufficientQuota:
                case alreadyMounted:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<MountFolderError> _writer = new JsonWriter<MountFolderError>()
        {
            public final void write(MountFolderError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case insideSharedFolder:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_shared_folder");
                        g.writeEndObject();
                        break;
                    case insufficientQuota:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_quota");
                        g.writeEndObject();
                        break;
                    case alreadyMounted:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("already_mounted");
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
        public static final JsonReader<MountFolderError> _reader = new JsonReader<MountFolderError>()
        {
            public final MountFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return MountFolderError.other; }
                    switch (tag) {
                        case insideSharedFolder: return MountFolderError.insideSharedFolder;
                        case insufficientQuota: return MountFolderError.insufficientQuota;
                        case alreadyMounted: return MountFolderError.alreadyMounted;
                        case other: return MountFolderError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                MountFolderError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = MountFolderError.accessError(v);
                            break;
                        }
                        case insideSharedFolder: {
                            value = MountFolderError.insideSharedFolder;
                            break;
                        }
                        case insufficientQuota: {
                            value = MountFolderError.insufficientQuota;
                            break;
                        }
                        case alreadyMounted: {
                            value = MountFolderError.alreadyMounted;
                            break;
                        }
                        case other: {
                            value = MountFolderError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return MountFolderError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("inside_shared_folder", Tag.insideSharedFolder);
            _values.put("insufficient_quota", Tag.insufficientQuota);
            _values.put("already_mounted", Tag.alreadyMounted);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "MountFolderError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MountFolderError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MountFolderError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class AddFolderMemberArg {
        // struct AddFolderMemberArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * The intended list of members to add.  Added members will receive
         * invites to join the shared folder.
         */
        public final java.util.ArrayList<AddMember> members;
        /**
         * Whether added members should be notified via email and device
         * notifications of their invite.
         */
        public final boolean quiet;
        /**
         * Optional message to display to added members in their invitation.
         */
        public final String customMessage;

        public AddFolderMemberArg(String sharedFolderId, java.util.ArrayList<AddMember> members, Boolean quiet, String customMessage) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.members = members;
            if (members == null) {
                throw new RuntimeException("Required value for 'members' is null");
            }
            for (AddMember x : members) {
                if (x == null) {
                    throw new RuntimeException("An item in list 'members' is null");
                }
            }
            if (quiet != null) {
                this.quiet = quiet.booleanValue();
            }
            else {
                this.quiet = false;
            }
            this.customMessage = customMessage;
            if (customMessage != null) {
                if (customMessage.length() < 1) {
                    throw new RuntimeException("String 'customMessage' is shorter than 1");
                }
            }
        }
        static final JsonWriter<AddFolderMemberArg> _writer = new JsonWriter<AddFolderMemberArg>()
        {
            public final void write(AddFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                AddFolderMemberArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(AddFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeFieldName("members");
                g.writeStartArray();
                for (AddMember item: x.members) {
                    if (item != null) {
                        AddMember._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeBooleanField("quiet", x.quiet);
                if (x.customMessage != null) {
                    g.writeFieldName("custom_message");
                    g.writeString(x.customMessage);
                }
            }
        };

        public static final JsonReader<AddFolderMemberArg> _reader = new JsonReader<AddFolderMemberArg>() {

            public final AddFolderMemberArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                AddFolderMemberArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final AddFolderMemberArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                java.util.ArrayList<AddMember> members = null;
                Boolean quiet = null;
                String customMessage = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("members".equals(fieldName)) {
                        members = JsonArrayReader.mk(AddMember._reader)
                            .readField(parser, "members", members);
                    }
                    else if ("quiet".equals(fieldName)) {
                        quiet = JsonReader.BooleanReader
                            .readField(parser, "quiet", quiet);
                    }
                    else if ("custom_message".equals(fieldName)) {
                        customMessage = JsonReader.StringReader
                            .readField(parser, "custom_message", customMessage);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                if (members == null) {
                    throw new JsonReadException("Required field \"members\" is missing.", parser.getTokenLocation());
                }
                return new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
            }
        };

        public String toString() {
            return "AddFolderMemberArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AddFolderMemberArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AddFolderMemberArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * The member and type of access the member should have when added to a
     * shared folder.
     */
    public static class AddMember {
        // struct AddMember
        /**
         * The member to add to the shared folder.
         */
        public final MemberSelector member;
        /**
         * The access level to grant {@code member} to the shared folder.
         * {@code accessLevel.owner} is disallowed.
         */
        public final AccessLevel accessLevel;

        public AddMember(MemberSelector member, AccessLevel accessLevel) {
            this.member = member;
            if (member == null) {
                throw new RuntimeException("Required value for 'member' is null");
            }
            if (accessLevel != null) {
                this.accessLevel = accessLevel;
            }
            else {
                this.accessLevel = AccessLevel.viewer;
            }
        }
        static final JsonWriter<AddMember> _writer = new JsonWriter<AddMember>()
        {
            public final void write(AddMember x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                AddMember._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(AddMember x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("member");
                MemberSelector._writer.write(x.member, g);
                g.writeFieldName("access_level");
                AccessLevel._writer.write(x.accessLevel, g);
            }
        };

        public static final JsonReader<AddMember> _reader = new JsonReader<AddMember>() {

            public final AddMember read(JsonParser parser)
                throws IOException, JsonReadException
            {
                AddMember result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final AddMember readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                MemberSelector member = null;
                AccessLevel accessLevel = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("member".equals(fieldName)) {
                        member = MemberSelector._reader
                            .readField(parser, "member", member);
                    }
                    else if ("access_level".equals(fieldName)) {
                        accessLevel = AccessLevel._reader
                            .readField(parser, "access_level", accessLevel);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (member == null) {
                    throw new JsonReadException("Required field \"member\" is missing.", parser.getTokenLocation());
                }
                return new AddMember(member, accessLevel);
            }
        };

        public String toString() {
            return "AddMember." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AddMember." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AddMember fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Includes different ways to identify a member to add to a shared folder.
     */

    public static final class MemberSelector {
        // union MemberSelector

        /**
         * The discriminating tag type for {@link MemberSelector}.
         */
        public enum Tag {
            dropboxId,  // String
            email,  // String
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String dropboxIdValue;
        private MemberSelector(Tag t, String v) {
            tag = t;
            dropboxIdValue = v;
            validate();
        }
        /**
         * Dropbox account, team member, or group ID of member to add.
         */
        public static MemberSelector dropboxId(String v) {
            return new MemberSelector(Tag.dropboxId, v);
        }
        public String getDropboxId() {
            if (tag != Tag.dropboxId) {
                throw new RuntimeException("getDropboxId() requires tag==dropboxId, actual tag=="+tag);
            }
            return dropboxIdValue;
        }

        // Reusing dropboxIdValue for email
        /**
         * E-mail address of member to add.
         */
        public static MemberSelector email(String v) {
            return new MemberSelector(Tag.email, v);
        }
        public String getEmail() {
            if (tag != Tag.email) {
                throw new RuntimeException("getEmail() requires tag==email, actual tag=="+tag);
            }
            return dropboxIdValue;
        }

        public static final MemberSelector other = new MemberSelector(Tag.other);

        private MemberSelector(Tag t) {
            tag = t;
            dropboxIdValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case dropboxId:
                    if (this.dropboxIdValue == null) {
                        throw new RuntimeException("Required value for 'dropboxId' is null");
                    }
                    if (this.dropboxIdValue.length() < 1) {
                        throw new RuntimeException("String 'this.dropboxIdValue' is shorter than 1");
                    }
                    break;
                case email:
                    if (this.dropboxIdValue == null) {
                        throw new RuntimeException("Required value for 'email' is null");
                    }
                    if (!java.util.regex.Pattern.matches("\\A^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$\\Z", this.dropboxIdValue)) {
                        throw new RuntimeException("String 'this.dropboxIdValue' does not match pattern");
                    }
                    break;
            }
        }
        static final JsonWriter<MemberSelector> _writer = new JsonWriter<MemberSelector>()
        {
            public final void write(MemberSelector x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case dropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("dropbox_id");
                        g.writeStringField("dropbox_id", x.dropboxIdValue);
                        g.writeEndObject();
                        break;
                    case email:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email");
                        g.writeStringField("email", x.dropboxIdValue);
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
        public static final JsonReader<MemberSelector> _reader = new JsonReader<MemberSelector>()
        {
            public final MemberSelector read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return MemberSelector.other; }
                    switch (tag) {
                        case other: return MemberSelector.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                MemberSelector value = null;
                if (tag != null) {
                    switch (tag) {
                        case dropboxId: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "dropbox_id", v);
                            value = MemberSelector.dropboxId(v);
                            break;
                        }
                        case email: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "email", v);
                            value = MemberSelector.email(v);
                            break;
                        }
                        case other: {
                            value = MemberSelector.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return MemberSelector.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("dropbox_id", Tag.dropboxId);
            _values.put("email", Tag.email);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "MemberSelector." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MemberSelector." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static MemberSelector fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class AddFolderMemberError {
        // union AddFolderMemberError

        /**
         * The discriminating tag type for {@link AddFolderMemberError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            emailUnverified,
            badMember,  // AddMemberSelectorError
            noPermission,
            cantShareOutsideTeam,
            tooManyMembers,  // UInt64
            tooManyPendingInvites,  // UInt64
            insufficientPlan,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private AddFolderMemberError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            badMemberValue = null;
            tooManyMembersValue = null;
            validate();
        }
        /**
         * Unable to access shared folder.
         */
        public static AddFolderMemberError accessError(SharedFolderAccessError v) {
            return new AddFolderMemberError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * The current account's e-mail address is unverified.
         */
        public static final AddFolderMemberError emailUnverified = new AddFolderMemberError(Tag.emailUnverified);

        private final AddMemberSelectorError badMemberValue;
        private AddFolderMemberError(Tag t, AddMemberSelectorError v) {
            tag = t;
            accessErrorValue = null;
            badMemberValue = v;
            tooManyMembersValue = null;
            validate();
        }
        /**
         * {@code addFolderMemberArg.members} contains a bad invitation
         * recipient.
         */
        public static AddFolderMemberError badMember(AddMemberSelectorError v) {
            return new AddFolderMemberError(Tag.badMember, v);
        }
        public AddMemberSelectorError getBadMember() {
            if (tag != Tag.badMember) {
                throw new RuntimeException("getBadMember() requires tag==badMember, actual tag=="+tag);
            }
            return badMemberValue;
        }

        /**
         * The current account does not have permission to perform this action.
         */
        public static final AddFolderMemberError noPermission = new AddFolderMemberError(Tag.noPermission);

        /**
         * Your team policy does not allow sharing outside of the team.
         */
        public static final AddFolderMemberError cantShareOutsideTeam = new AddFolderMemberError(Tag.cantShareOutsideTeam);

        private final Long tooManyMembersValue;
        private AddFolderMemberError(Tag t, Long v) {
            tag = t;
            accessErrorValue = null;
            badMemberValue = null;
            tooManyMembersValue = v;
            validate();
        }
        /**
         * The value is the member limit that was reached.
         */
        public static AddFolderMemberError tooManyMembers(Long v) {
            return new AddFolderMemberError(Tag.tooManyMembers, v);
        }
        public Long getTooManyMembers() {
            if (tag != Tag.tooManyMembers) {
                throw new RuntimeException("getTooManyMembers() requires tag==tooManyMembers, actual tag=="+tag);
            }
            return tooManyMembersValue;
        }

        // Reusing tooManyMembersValue for tooManyPendingInvites
        /**
         * The value is the pending invite limit that was reached.
         */
        public static AddFolderMemberError tooManyPendingInvites(Long v) {
            return new AddFolderMemberError(Tag.tooManyPendingInvites, v);
        }
        public Long getTooManyPendingInvites() {
            if (tag != Tag.tooManyPendingInvites) {
                throw new RuntimeException("getTooManyPendingInvites() requires tag==tooManyPendingInvites, actual tag=="+tag);
            }
            return tooManyMembersValue;
        }

        /**
         * The current user's account doesn't support this action. An example of
         * this is when adding a read-only member. This action can only be
         * performed by users that have upgraded to a Pro or Business plan.
         */
        public static final AddFolderMemberError insufficientPlan = new AddFolderMemberError(Tag.insufficientPlan);

        public static final AddFolderMemberError other = new AddFolderMemberError(Tag.other);

        private AddFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            badMemberValue = null;
            tooManyMembersValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case emailUnverified:
                case noPermission:
                case cantShareOutsideTeam:
                case insufficientPlan:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
                case badMember:
                    if (this.badMemberValue == null) {
                        throw new RuntimeException("Required value for 'badMember' is null");
                    }
                    break;
                case tooManyMembers:
                    break;
                case tooManyPendingInvites:
                    break;
            }
        }
        static final JsonWriter<AddFolderMemberError> _writer = new JsonWriter<AddFolderMemberError>()
        {
            public final void write(AddFolderMemberError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case emailUnverified:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case badMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("bad_member");
                        g.writeFieldName("bad_member");
                        AddMemberSelectorError._writer.write(x.badMemberValue, g);
                        g.writeEndObject();
                        break;
                    case noPermission:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case cantShareOutsideTeam:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_share_outside_team");
                        g.writeEndObject();
                        break;
                    case tooManyMembers:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_members");
                        g.writeNumberField("too_many_members", x.tooManyMembersValue);
                        g.writeEndObject();
                        break;
                    case tooManyPendingInvites:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_pending_invites");
                        g.writeNumberField("too_many_pending_invites", x.tooManyMembersValue);
                        g.writeEndObject();
                        break;
                    case insufficientPlan:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_plan");
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
        public static final JsonReader<AddFolderMemberError> _reader = new JsonReader<AddFolderMemberError>()
        {
            public final AddFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AddFolderMemberError.other; }
                    switch (tag) {
                        case emailUnverified: return AddFolderMemberError.emailUnverified;
                        case noPermission: return AddFolderMemberError.noPermission;
                        case cantShareOutsideTeam: return AddFolderMemberError.cantShareOutsideTeam;
                        case insufficientPlan: return AddFolderMemberError.insufficientPlan;
                        case other: return AddFolderMemberError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                AddFolderMemberError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = AddFolderMemberError.accessError(v);
                            break;
                        }
                        case emailUnverified: {
                            value = AddFolderMemberError.emailUnverified;
                            break;
                        }
                        case badMember: {
                            AddMemberSelectorError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = AddMemberSelectorError._reader
                                .readField(parser, "bad_member", v);
                            value = AddFolderMemberError.badMember(v);
                            break;
                        }
                        case noPermission: {
                            value = AddFolderMemberError.noPermission;
                            break;
                        }
                        case cantShareOutsideTeam: {
                            value = AddFolderMemberError.cantShareOutsideTeam;
                            break;
                        }
                        case tooManyMembers: {
                            Long v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.UInt64Reader
                                .readField(parser, "too_many_members", v);
                            value = AddFolderMemberError.tooManyMembers(v);
                            break;
                        }
                        case tooManyPendingInvites: {
                            Long v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.UInt64Reader
                                .readField(parser, "too_many_pending_invites", v);
                            value = AddFolderMemberError.tooManyPendingInvites(v);
                            break;
                        }
                        case insufficientPlan: {
                            value = AddFolderMemberError.insufficientPlan;
                            break;
                        }
                        case other: {
                            value = AddFolderMemberError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AddFolderMemberError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("email_unverified", Tag.emailUnverified);
            _values.put("bad_member", Tag.badMember);
            _values.put("no_permission", Tag.noPermission);
            _values.put("cant_share_outside_team", Tag.cantShareOutsideTeam);
            _values.put("too_many_members", Tag.tooManyMembers);
            _values.put("too_many_pending_invites", Tag.tooManyPendingInvites);
            _values.put("insufficient_plan", Tag.insufficientPlan);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "AddFolderMemberError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AddFolderMemberError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AddFolderMemberError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class AddMemberSelectorError {
        // union AddMemberSelectorError

        /**
         * The discriminating tag type for {@link AddMemberSelectorError}.
         */
        public enum Tag {
            invalidDropboxId,  // String
            invalidEmail,  // String
            unverifiedDropboxId,  // String
            groupDeleted,
            groupNotOnTeam,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String invalidDropboxIdValue;
        private AddMemberSelectorError(Tag t, String v) {
            tag = t;
            invalidDropboxIdValue = v;
            validate();
        }
        /**
         * The value is the ID that could not be identified.
         */
        public static AddMemberSelectorError invalidDropboxId(String v) {
            return new AddMemberSelectorError(Tag.invalidDropboxId, v);
        }
        public String getInvalidDropboxId() {
            if (tag != Tag.invalidDropboxId) {
                throw new RuntimeException("getInvalidDropboxId() requires tag==invalidDropboxId, actual tag=="+tag);
            }
            return invalidDropboxIdValue;
        }

        // Reusing invalidDropboxIdValue for invalidEmail
        /**
         * The value is the e-email address that is malformed.
         */
        public static AddMemberSelectorError invalidEmail(String v) {
            return new AddMemberSelectorError(Tag.invalidEmail, v);
        }
        public String getInvalidEmail() {
            if (tag != Tag.invalidEmail) {
                throw new RuntimeException("getInvalidEmail() requires tag==invalidEmail, actual tag=="+tag);
            }
            return invalidDropboxIdValue;
        }

        // Reusing invalidDropboxIdValue for unverifiedDropboxId
        /**
         * The value is the ID of the Dropbox user with an unverified e-mail
         * address.  Invite unverified users by e-mail address instead of by
         * their Dropbox ID.
         */
        public static AddMemberSelectorError unverifiedDropboxId(String v) {
            return new AddMemberSelectorError(Tag.unverifiedDropboxId, v);
        }
        public String getUnverifiedDropboxId() {
            if (tag != Tag.unverifiedDropboxId) {
                throw new RuntimeException("getUnverifiedDropboxId() requires tag==unverifiedDropboxId, actual tag=="+tag);
            }
            return invalidDropboxIdValue;
        }

        /**
         * At least one of the specified groups in {@code
         * addFolderMemberArg.members} is deleted.
         */
        public static final AddMemberSelectorError groupDeleted = new AddMemberSelectorError(Tag.groupDeleted);

        /**
         * Sharing to a group that is not on the current account's team.
         */
        public static final AddMemberSelectorError groupNotOnTeam = new AddMemberSelectorError(Tag.groupNotOnTeam);

        public static final AddMemberSelectorError other = new AddMemberSelectorError(Tag.other);

        private AddMemberSelectorError(Tag t) {
            tag = t;
            invalidDropboxIdValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case groupDeleted:
                case groupNotOnTeam:
                case other:
                    break;
                case invalidDropboxId:
                    if (this.invalidDropboxIdValue == null) {
                        throw new RuntimeException("Required value for 'invalidDropboxId' is null");
                    }
                    if (this.invalidDropboxIdValue.length() < 1) {
                        throw new RuntimeException("String 'this.invalidDropboxIdValue' is shorter than 1");
                    }
                    break;
                case invalidEmail:
                    if (this.invalidDropboxIdValue == null) {
                        throw new RuntimeException("Required value for 'invalidEmail' is null");
                    }
                    if (!java.util.regex.Pattern.matches("\\A^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$\\Z", this.invalidDropboxIdValue)) {
                        throw new RuntimeException("String 'this.invalidDropboxIdValue' does not match pattern");
                    }
                    break;
                case unverifiedDropboxId:
                    if (this.invalidDropboxIdValue == null) {
                        throw new RuntimeException("Required value for 'unverifiedDropboxId' is null");
                    }
                    if (this.invalidDropboxIdValue.length() < 1) {
                        throw new RuntimeException("String 'this.invalidDropboxIdValue' is shorter than 1");
                    }
                    break;
            }
        }
        static final JsonWriter<AddMemberSelectorError> _writer = new JsonWriter<AddMemberSelectorError>()
        {
            public final void write(AddMemberSelectorError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case invalidDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeStringField("invalid_dropbox_id", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case invalidEmail:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_email");
                        g.writeStringField("invalid_email", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case unverifiedDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unverified_dropbox_id");
                        g.writeStringField("unverified_dropbox_id", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case groupDeleted:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_deleted");
                        g.writeEndObject();
                        break;
                    case groupNotOnTeam:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_not_on_team");
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
        public static final JsonReader<AddMemberSelectorError> _reader = new JsonReader<AddMemberSelectorError>()
        {
            public final AddMemberSelectorError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AddMemberSelectorError.other; }
                    switch (tag) {
                        case groupDeleted: return AddMemberSelectorError.groupDeleted;
                        case groupNotOnTeam: return AddMemberSelectorError.groupNotOnTeam;
                        case other: return AddMemberSelectorError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                AddMemberSelectorError value = null;
                if (tag != null) {
                    switch (tag) {
                        case invalidDropboxId: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "invalid_dropbox_id", v);
                            value = AddMemberSelectorError.invalidDropboxId(v);
                            break;
                        }
                        case invalidEmail: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "invalid_email", v);
                            value = AddMemberSelectorError.invalidEmail(v);
                            break;
                        }
                        case unverifiedDropboxId: {
                            String v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JsonReader.StringReader
                                .readField(parser, "unverified_dropbox_id", v);
                            value = AddMemberSelectorError.unverifiedDropboxId(v);
                            break;
                        }
                        case groupDeleted: {
                            value = AddMemberSelectorError.groupDeleted;
                            break;
                        }
                        case groupNotOnTeam: {
                            value = AddMemberSelectorError.groupNotOnTeam;
                            break;
                        }
                        case other: {
                            value = AddMemberSelectorError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AddMemberSelectorError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_dropbox_id", Tag.invalidDropboxId);
            _values.put("invalid_email", Tag.invalidEmail);
            _values.put("unverified_dropbox_id", Tag.unverifiedDropboxId);
            _values.put("group_deleted", Tag.groupDeleted);
            _values.put("group_not_on_team", Tag.groupNotOnTeam);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "AddMemberSelectorError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AddMemberSelectorError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static AddMemberSelectorError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ShareFolderJobStatus {
        // union ShareFolderJobStatus

        /**
         * The discriminating tag type for {@link ShareFolderJobStatus}.
         */
        public enum Tag {
            inProgress,
            complete,  // FullSharedFolderMetadata
            failed  // ShareFolderError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * The asynchronous job is still in progress.
         */
        public static final ShareFolderJobStatus inProgress = new ShareFolderJobStatus(Tag.inProgress);

        private final FullSharedFolderMetadata completeValue;
        private ShareFolderJobStatus(Tag t, FullSharedFolderMetadata v) {
            tag = t;
            completeValue = v;
            failedValue = null;
            validate();
        }
        /**
         * The share job has finished. The value is the metadata for the folder.
         */
        public static ShareFolderJobStatus complete(FullSharedFolderMetadata v) {
            return new ShareFolderJobStatus(Tag.complete, v);
        }
        public FullSharedFolderMetadata getComplete() {
            if (tag != Tag.complete) {
                throw new RuntimeException("getComplete() requires tag==complete, actual tag=="+tag);
            }
            return completeValue;
        }

        private final ShareFolderError failedValue;
        private ShareFolderJobStatus(Tag t, ShareFolderError v) {
            tag = t;
            completeValue = null;
            failedValue = v;
            validate();
        }
        public static ShareFolderJobStatus failed(ShareFolderError v) {
            return new ShareFolderJobStatus(Tag.failed, v);
        }
        public ShareFolderError getFailed() {
            if (tag != Tag.failed) {
                throw new RuntimeException("getFailed() requires tag==failed, actual tag=="+tag);
            }
            return failedValue;
        }

        private ShareFolderJobStatus(Tag t) {
            tag = t;
            completeValue = null;
            failedValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case inProgress:
                    break;
                case complete:
                    if (this.completeValue == null) {
                        throw new RuntimeException("Required value for 'complete' is null");
                    }
                    break;
                case failed:
                    if (this.failedValue == null) {
                        throw new RuntimeException("Required value for 'failed' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ShareFolderJobStatus> _writer = new JsonWriter<ShareFolderJobStatus>()
        {
            public final void write(ShareFolderJobStatus x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
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
                        FullSharedFolderMetadata._writer.writeFields(x.completeValue, g);
                        g.writeEndObject();
                        break;
                    case failed:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("failed");
                        g.writeFieldName("failed");
                        ShareFolderError._writer.write(x.failedValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ShareFolderJobStatus> _reader = new JsonReader<ShareFolderJobStatus>()
        {
            public final ShareFolderJobStatus read(JsonParser parser)
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
                        case inProgress: return ShareFolderJobStatus.inProgress;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ShareFolderJobStatus value = null;
                if (tag != null) {
                    switch (tag) {
                        case inProgress: {
                            value = ShareFolderJobStatus.inProgress;
                            break;
                        }
                        case complete: {
                            FullSharedFolderMetadata v = null;
                            v = FullSharedFolderMetadata._reader.readFields(parser);
                            value = ShareFolderJobStatus.complete(v);
                            break;
                        }
                        case failed: {
                            ShareFolderError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = ShareFolderError._reader
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
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("complete", Tag.complete);
            _values.put("failed", Tag.failed);
        }

        public String toString() {
            return "ShareFolderJobStatus." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ShareFolderJobStatus." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ShareFolderJobStatus fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ShareFolderLaunch {
        // union ShareFolderLaunch

        /**
         * The discriminating tag type for {@link ShareFolderLaunch}.
         */
        public enum Tag {
            asyncJobId,  // String
            complete  // FullSharedFolderMetadata
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final String asyncJobIdValue;
        private ShareFolderLaunch(Tag t, String v) {
            tag = t;
            asyncJobIdValue = v;
            completeValue = null;
            validate();
        }
        /**
         * This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job.
         */
        public static ShareFolderLaunch asyncJobId(String v) {
            return new ShareFolderLaunch(Tag.asyncJobId, v);
        }
        public String getAsyncJobId() {
            if (tag != Tag.asyncJobId) {
                throw new RuntimeException("getAsyncJobId() requires tag==asyncJobId, actual tag=="+tag);
            }
            return asyncJobIdValue;
        }

        private final FullSharedFolderMetadata completeValue;
        private ShareFolderLaunch(Tag t, FullSharedFolderMetadata v) {
            tag = t;
            asyncJobIdValue = null;
            completeValue = v;
            validate();
        }
        public static ShareFolderLaunch complete(FullSharedFolderMetadata v) {
            return new ShareFolderLaunch(Tag.complete, v);
        }
        public FullSharedFolderMetadata getComplete() {
            if (tag != Tag.complete) {
                throw new RuntimeException("getComplete() requires tag==complete, actual tag=="+tag);
            }
            return completeValue;
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
                case complete:
                    if (this.completeValue == null) {
                        throw new RuntimeException("Required value for 'complete' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<ShareFolderLaunch> _writer = new JsonWriter<ShareFolderLaunch>()
        {
            public final void write(ShareFolderLaunch x, JsonGenerator g)
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
                        FullSharedFolderMetadata._writer.writeFields(x.completeValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ShareFolderLaunch> _reader = new JsonReader<ShareFolderLaunch>()
        {
            public final ShareFolderLaunch read(JsonParser parser)
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
                ShareFolderLaunch value = null;
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
                            value = ShareFolderLaunch.asyncJobId(v);
                            break;
                        }
                        case complete: {
                            FullSharedFolderMetadata v = null;
                            v = FullSharedFolderMetadata._reader.readFields(parser);
                            value = ShareFolderLaunch.complete(v);
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
            return "ShareFolderLaunch." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ShareFolderLaunch." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ShareFolderLaunch fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class JobStatus {
        // union JobStatus

        /**
         * The discriminating tag type for {@link JobStatus}.
         */
        public enum Tag {
            inProgress,
            complete,
            failed  // JobError
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        /**
         * The asynchronous job is still in progress.
         */
        public static final JobStatus inProgress = new JobStatus(Tag.inProgress);

        /**
         * The asynchronous job has finished.
         */
        public static final JobStatus complete = new JobStatus(Tag.complete);

        private final JobError failedValue;
        private JobStatus(Tag t, JobError v) {
            tag = t;
            failedValue = v;
            validate();
        }
        /**
         * The asynchronous job returned an error.
         */
        public static JobStatus failed(JobError v) {
            return new JobStatus(Tag.failed, v);
        }
        public JobError getFailed() {
            if (tag != Tag.failed) {
                throw new RuntimeException("getFailed() requires tag==failed, actual tag=="+tag);
            }
            return failedValue;
        }

        private JobStatus(Tag t) {
            tag = t;
            failedValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case inProgress:
                case complete:
                    break;
                case failed:
                    if (this.failedValue == null) {
                        throw new RuntimeException("Required value for 'failed' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<JobStatus> _writer = new JsonWriter<JobStatus>()
        {
            public final void write(JobStatus x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
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
                    case failed:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("failed");
                        g.writeFieldName("failed");
                        JobError._writer.write(x.failedValue, g);
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<JobStatus> _reader = new JsonReader<JobStatus>()
        {
            public final JobStatus read(JsonParser parser)
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
                        case inProgress: return JobStatus.inProgress;
                        case complete: return JobStatus.complete;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                JobStatus value = null;
                if (tag != null) {
                    switch (tag) {
                        case inProgress: {
                            value = JobStatus.inProgress;
                            break;
                        }
                        case complete: {
                            value = JobStatus.complete;
                            break;
                        }
                        case failed: {
                            JobError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = JobError._reader
                                .readField(parser, "failed", v);
                            value = JobStatus.failed(v);
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
            _values.put("failed", Tag.failed);
        }

        public String toString() {
            return "JobStatus." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "JobStatus." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static JobStatus fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public enum SharedFolderMemberError {
        // union SharedFolderMemberError
        /**
         * The target dropbox_id is invalid.
         */
        invalidDropboxId,
        /**
         * The target dropbox_id is not a member of the shared folder.
         */
        notAMember,
        other;  // *catch_all

        static final JsonWriter<SharedFolderMemberError> _writer = new JsonWriter<SharedFolderMemberError>()
        {
            public void write(SharedFolderMemberError x, JsonGenerator g)
             throws IOException
            {
                switch (x) {
                    case invalidDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case notAMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_a_member");
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

        public static final JsonReader<SharedFolderMemberError> _reader = new JsonReader<SharedFolderMemberError>()
        {
            public final SharedFolderMemberError read(JsonParser parser)
                throws IOException, JsonReadException
            {
                return JsonReader.readEnum(parser, _values, other);
            }
        };
        private static final java.util.HashMap<String,SharedFolderMemberError> _values;
        static {
            _values = new java.util.HashMap<String,SharedFolderMemberError>();
            _values.put("invalid_dropbox_id", invalidDropboxId);
            _values.put("not_a_member", notAMember);
            _values.put("other", other);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedFolderMemberError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class JobError {
        // union JobError

        /**
         * The discriminating tag type for {@link JobError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            memberError,  // SharedFolderMemberError
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private JobError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            memberErrorValue = null;
            validate();
        }
        public static JobError accessError(SharedFolderAccessError v) {
            return new JobError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        private final SharedFolderMemberError memberErrorValue;
        private JobError(Tag t, SharedFolderMemberError v) {
            tag = t;
            accessErrorValue = null;
            memberErrorValue = v;
            validate();
        }
        public static JobError memberError(SharedFolderMemberError v) {
            return new JobError(Tag.memberError, v);
        }
        public SharedFolderMemberError getMemberError() {
            if (tag != Tag.memberError) {
                throw new RuntimeException("getMemberError() requires tag==memberError, actual tag=="+tag);
            }
            return memberErrorValue;
        }

        public static final JobError other = new JobError(Tag.other);

        private JobError(Tag t) {
            tag = t;
            accessErrorValue = null;
            memberErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
                case memberError:
                    if (this.memberErrorValue == null) {
                        throw new RuntimeException("Required value for 'memberError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<JobError> _writer = new JsonWriter<JobError>()
        {
            public final void write(JobError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case memberError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("member_error");
                        g.writeFieldName("member_error");
                        SharedFolderMemberError._writer.write(x.memberErrorValue, g);
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
        public static final JsonReader<JobError> _reader = new JsonReader<JobError>()
        {
            public final JobError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return JobError.other; }
                    switch (tag) {
                        case other: return JobError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                JobError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = JobError.accessError(v);
                            break;
                        }
                        case memberError: {
                            SharedFolderMemberError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderMemberError._reader
                                .readField(parser, "member_error", v);
                            value = JobError.memberError(v);
                            break;
                        }
                        case other: {
                            value = JobError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return JobError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("member_error", Tag.memberError);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "JobError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "JobError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static JobError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class RemoveFolderMemberArg {
        // struct RemoveFolderMemberArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * The member to remove from the folder. Only the {@code
         * memberSelector.dropboxId} may be set at this time.
         */
        public final MemberSelector member;
        /**
         * If true, the removed user will keep their copy of the folder after
         * it's unshared, assuming it was mounted. Otherwise, it will be removed
         * from their Dropbox. Also, this must be set to false when kicking a
         * group.
         */
        public final boolean leaveACopy;

        public RemoveFolderMemberArg(String sharedFolderId, MemberSelector member, boolean leaveACopy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.member = member;
            if (member == null) {
                throw new RuntimeException("Required value for 'member' is null");
            }
            this.leaveACopy = leaveACopy;
        }
        static final JsonWriter<RemoveFolderMemberArg> _writer = new JsonWriter<RemoveFolderMemberArg>()
        {
            public final void write(RemoveFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                RemoveFolderMemberArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(RemoveFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeFieldName("member");
                MemberSelector._writer.write(x.member, g);
                g.writeBooleanField("leave_a_copy", x.leaveACopy);
            }
        };

        public static final JsonReader<RemoveFolderMemberArg> _reader = new JsonReader<RemoveFolderMemberArg>() {

            public final RemoveFolderMemberArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                RemoveFolderMemberArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final RemoveFolderMemberArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                MemberSelector member = null;
                Boolean leaveACopy = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("member".equals(fieldName)) {
                        member = MemberSelector._reader
                            .readField(parser, "member", member);
                    }
                    else if ("leave_a_copy".equals(fieldName)) {
                        leaveACopy = JsonReader.BooleanReader
                            .readField(parser, "leave_a_copy", leaveACopy);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                if (member == null) {
                    throw new JsonReadException("Required field \"member\" is missing.", parser.getTokenLocation());
                }
                if (leaveACopy == null) {
                    throw new JsonReadException("Required field \"leave_a_copy\" is missing.", parser.getTokenLocation());
                }
                return new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
            }
        };

        public String toString() {
            return "RemoveFolderMemberArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RemoveFolderMemberArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RemoveFolderMemberArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class RemoveFolderMemberError {
        // union RemoveFolderMemberError

        /**
         * The discriminating tag type for {@link RemoveFolderMemberError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            invalidDropboxId,
            notAMember,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private RemoveFolderMemberError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static RemoveFolderMemberError accessError(SharedFolderAccessError v) {
            return new RemoveFolderMemberError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * The target {@code memberSelector.dropboxId} is invalid.
         */
        public static final RemoveFolderMemberError invalidDropboxId = new RemoveFolderMemberError(Tag.invalidDropboxId);

        /**
         * The target {@code memberSelector.dropboxId} is not a member of the
         * shared folder.
         */
        public static final RemoveFolderMemberError notAMember = new RemoveFolderMemberError(Tag.notAMember);

        public static final RemoveFolderMemberError other = new RemoveFolderMemberError(Tag.other);

        private RemoveFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case invalidDropboxId:
                case notAMember:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<RemoveFolderMemberError> _writer = new JsonWriter<RemoveFolderMemberError>()
        {
            public final void write(RemoveFolderMemberError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case invalidDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case notAMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_a_member");
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
        public static final JsonReader<RemoveFolderMemberError> _reader = new JsonReader<RemoveFolderMemberError>()
        {
            public final RemoveFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RemoveFolderMemberError.other; }
                    switch (tag) {
                        case invalidDropboxId: return RemoveFolderMemberError.invalidDropboxId;
                        case notAMember: return RemoveFolderMemberError.notAMember;
                        case other: return RemoveFolderMemberError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RemoveFolderMemberError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = RemoveFolderMemberError.accessError(v);
                            break;
                        }
                        case invalidDropboxId: {
                            value = RemoveFolderMemberError.invalidDropboxId;
                            break;
                        }
                        case notAMember: {
                            value = RemoveFolderMemberError.notAMember;
                            break;
                        }
                        case other: {
                            value = RemoveFolderMemberError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RemoveFolderMemberError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("invalid_dropbox_id", Tag.invalidDropboxId);
            _values.put("not_a_member", Tag.notAMember);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "RemoveFolderMemberError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RemoveFolderMemberError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RemoveFolderMemberError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class UpdateFolderMemberArg {
        // struct UpdateFolderMemberArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * The member of the shared folder to update.  Only the {@code
         * memberSelector.dropboxId} may be set at this time.
         */
        public final MemberSelector member;
        /**
         * The new access level for {@code member}. {@code accessLevel.owner} is
         * disallowed.
         */
        public final AccessLevel accessLevel;

        public UpdateFolderMemberArg(String sharedFolderId, MemberSelector member, AccessLevel accessLevel) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
            this.member = member;
            if (member == null) {
                throw new RuntimeException("Required value for 'member' is null");
            }
            this.accessLevel = accessLevel;
            if (accessLevel == null) {
                throw new RuntimeException("Required value for 'accessLevel' is null");
            }
        }
        static final JsonWriter<UpdateFolderMemberArg> _writer = new JsonWriter<UpdateFolderMemberArg>()
        {
            public final void write(UpdateFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                UpdateFolderMemberArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(UpdateFolderMemberArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
                g.writeFieldName("member");
                MemberSelector._writer.write(x.member, g);
                g.writeFieldName("access_level");
                AccessLevel._writer.write(x.accessLevel, g);
            }
        };

        public static final JsonReader<UpdateFolderMemberArg> _reader = new JsonReader<UpdateFolderMemberArg>() {

            public final UpdateFolderMemberArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                UpdateFolderMemberArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final UpdateFolderMemberArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                MemberSelector member = null;
                AccessLevel accessLevel = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else if ("member".equals(fieldName)) {
                        member = MemberSelector._reader
                            .readField(parser, "member", member);
                    }
                    else if ("access_level".equals(fieldName)) {
                        accessLevel = AccessLevel._reader
                            .readField(parser, "access_level", accessLevel);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                if (member == null) {
                    throw new JsonReadException("Required field \"member\" is missing.", parser.getTokenLocation());
                }
                if (accessLevel == null) {
                    throw new JsonReadException("Required field \"access_level\" is missing.", parser.getTokenLocation());
                }
                return new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
            }
        };

        public String toString() {
            return "UpdateFolderMemberArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UpdateFolderMemberArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UpdateFolderMemberArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class UpdateFolderMemberError {
        // union UpdateFolderMemberError

        /**
         * The discriminating tag type for {@link UpdateFolderMemberError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            invalidDropboxId,
            notAMember,
            insufficientPlan,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private UpdateFolderMemberError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static UpdateFolderMemberError accessError(SharedFolderAccessError v) {
            return new UpdateFolderMemberError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * The target {@code memberSelector.dropboxId} is invalid.
         */
        public static final UpdateFolderMemberError invalidDropboxId = new UpdateFolderMemberError(Tag.invalidDropboxId);

        /**
         * The target {@code updateFolderMemberArg.member} is not a member of
         * the shared folder.
         */
        public static final UpdateFolderMemberError notAMember = new UpdateFolderMemberError(Tag.notAMember);

        /**
         * The current user's account doesn't support this action. An example of
         * this is when downgrading a member from editor to viewer. This action
         * can only be performed by users that have upgraded to a Pro or
         * Business plan.
         */
        public static final UpdateFolderMemberError insufficientPlan = new UpdateFolderMemberError(Tag.insufficientPlan);

        public static final UpdateFolderMemberError other = new UpdateFolderMemberError(Tag.other);

        private UpdateFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case invalidDropboxId:
                case notAMember:
                case insufficientPlan:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<UpdateFolderMemberError> _writer = new JsonWriter<UpdateFolderMemberError>()
        {
            public final void write(UpdateFolderMemberError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case invalidDropboxId:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case notAMember:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_a_member");
                        g.writeEndObject();
                        break;
                    case insufficientPlan:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_plan");
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
        public static final JsonReader<UpdateFolderMemberError> _reader = new JsonReader<UpdateFolderMemberError>()
        {
            public final UpdateFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UpdateFolderMemberError.other; }
                    switch (tag) {
                        case invalidDropboxId: return UpdateFolderMemberError.invalidDropboxId;
                        case notAMember: return UpdateFolderMemberError.notAMember;
                        case insufficientPlan: return UpdateFolderMemberError.insufficientPlan;
                        case other: return UpdateFolderMemberError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                UpdateFolderMemberError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = UpdateFolderMemberError.accessError(v);
                            break;
                        }
                        case invalidDropboxId: {
                            value = UpdateFolderMemberError.invalidDropboxId;
                            break;
                        }
                        case notAMember: {
                            value = UpdateFolderMemberError.notAMember;
                            break;
                        }
                        case insufficientPlan: {
                            value = UpdateFolderMemberError.insufficientPlan;
                            break;
                        }
                        case other: {
                            value = UpdateFolderMemberError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UpdateFolderMemberError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("invalid_dropbox_id", Tag.invalidDropboxId);
            _values.put("not_a_member", Tag.notAMember);
            _values.put("insufficient_plan", Tag.insufficientPlan);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "UpdateFolderMemberError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "UpdateFolderMemberError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static UpdateFolderMemberError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    public static class RelinquishFolderMembershipArg {
        // struct RelinquishFolderMembershipArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;

        public RelinquishFolderMembershipArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new RuntimeException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("\\A[-_0-9a-zA-Z]+\\Z", sharedFolderId)) {
                throw new RuntimeException("String 'sharedFolderId' does not match pattern");
            }
        }
        static final JsonWriter<RelinquishFolderMembershipArg> _writer = new JsonWriter<RelinquishFolderMembershipArg>()
        {
            public final void write(RelinquishFolderMembershipArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                RelinquishFolderMembershipArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(RelinquishFolderMembershipArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
            }
        };

        public static final JsonReader<RelinquishFolderMembershipArg> _reader = new JsonReader<RelinquishFolderMembershipArg>() {

            public final RelinquishFolderMembershipArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                RelinquishFolderMembershipArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final RelinquishFolderMembershipArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String sharedFolderId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
                }
                return new RelinquishFolderMembershipArg(sharedFolderId);
            }
        };

        public String toString() {
            return "RelinquishFolderMembershipArg." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RelinquishFolderMembershipArg." + _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RelinquishFolderMembershipArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class RelinquishFolderMembershipError {
        // union RelinquishFolderMembershipError

        /**
         * The discriminating tag type for {@link
         * RelinquishFolderMembershipError}.
         */
        public enum Tag {
            accessError,  // SharedFolderAccessError
            folderOwner,
            mounted,
            groupAccess,
            other  // *catch_all
        }

        /**
         * The discriminating tag for this instance.
         */
        public final Tag tag;

        private final SharedFolderAccessError accessErrorValue;
        private RelinquishFolderMembershipError(Tag t, SharedFolderAccessError v) {
            tag = t;
            accessErrorValue = v;
            validate();
        }
        public static RelinquishFolderMembershipError accessError(SharedFolderAccessError v) {
            return new RelinquishFolderMembershipError(Tag.accessError, v);
        }
        public SharedFolderAccessError getAccessError() {
            if (tag != Tag.accessError) {
                throw new RuntimeException("getAccessError() requires tag==accessError, actual tag=="+tag);
            }
            return accessErrorValue;
        }

        /**
         * The current user is the owner of the shared folder. Owners cannot
         * relinquish membership to their own folders. Try unsharing or
         * transfering ownership first.
         */
        public static final RelinquishFolderMembershipError folderOwner = new RelinquishFolderMembershipError(Tag.folderOwner);

        /**
         * The shared folder is currently mounted.  Unmount the shared folder
         * before relinquishing membership.
         */
        public static final RelinquishFolderMembershipError mounted = new RelinquishFolderMembershipError(Tag.mounted);

        /**
         * The current user has access to the shared folder via a group.  You
         * can't relinquish membership to folders shared via groups.
         */
        public static final RelinquishFolderMembershipError groupAccess = new RelinquishFolderMembershipError(Tag.groupAccess);

        public static final RelinquishFolderMembershipError other = new RelinquishFolderMembershipError(Tag.other);

        private RelinquishFolderMembershipError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private void validate()
        {
            switch (tag) {
                case folderOwner:
                case mounted:
                case groupAccess:
                case other:
                    break;
                case accessError:
                    if (this.accessErrorValue == null) {
                        throw new RuntimeException("Required value for 'accessError' is null");
                    }
                    break;
            }
        }
        static final JsonWriter<RelinquishFolderMembershipError> _writer = new JsonWriter<RelinquishFolderMembershipError>()
        {
            public final void write(RelinquishFolderMembershipError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case accessError:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case folderOwner:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("folder_owner");
                        g.writeEndObject();
                        break;
                    case mounted:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("mounted");
                        g.writeEndObject();
                        break;
                    case groupAccess:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_access");
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
        public static final JsonReader<RelinquishFolderMembershipError> _reader = new JsonReader<RelinquishFolderMembershipError>()
        {
            public final RelinquishFolderMembershipError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RelinquishFolderMembershipError.other; }
                    switch (tag) {
                        case folderOwner: return RelinquishFolderMembershipError.folderOwner;
                        case mounted: return RelinquishFolderMembershipError.mounted;
                        case groupAccess: return RelinquishFolderMembershipError.groupAccess;
                        case other: return RelinquishFolderMembershipError.other;
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RelinquishFolderMembershipError value = null;
                if (tag != null) {
                    switch (tag) {
                        case accessError: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = RelinquishFolderMembershipError.accessError(v);
                            break;
                        }
                        case folderOwner: {
                            value = RelinquishFolderMembershipError.folderOwner;
                            break;
                        }
                        case mounted: {
                            value = RelinquishFolderMembershipError.mounted;
                            break;
                        }
                        case groupAccess: {
                            value = RelinquishFolderMembershipError.groupAccess;
                            break;
                        }
                        case other: {
                            value = RelinquishFolderMembershipError.other;
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RelinquishFolderMembershipError.other; }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.accessError);
            _values.put("folder_owner", Tag.folderOwner);
            _values.put("mounted", Tag.mounted);
            _values.put("group_access", Tag.groupAccess);
            _values.put("other", Tag.other);
        }

        public String toString() {
            return "RelinquishFolderMembershipError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RelinquishFolderMembershipError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RelinquishFolderMembershipError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }

    /**
     * Exception thrown by {@link #getSharedLinks}.
     */
    public static class GetSharedLinksException extends DbxApiException {
        /**
         * The error reported by getSharedLinks.
         */
        public final GetSharedLinksError errorValue;

        public GetSharedLinksException(GetSharedLinksError errorValue) {
            super("Exception in get_shared_links: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL. This API is not supported for App Folder and filetypes
     * apps.
     */
    private GetSharedLinksResult getSharedLinks(GetSharedLinksArg arg)
            throws GetSharedLinksException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/get_shared_links",
                                           arg,
                                           GetSharedLinksArg._writer,
                                           GetSharedLinksResult._reader,
                                           GetSharedLinksError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinksException((GetSharedLinksError) (ew.errValue));
        }
    }
    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL. This API is not supported for App Folder and filetypes
     * apps.
     */
    public GetSharedLinksResult getSharedLinks()
          throws GetSharedLinksException, DbxException
    {
        GetSharedLinksArg arg = new GetSharedLinksArg(null);
        return getSharedLinks(arg);
    }
    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL. This API is not supported for App Folder and filetypes
     * apps.
     */
    public GetSharedLinksResult getSharedLinks(String path)
          throws GetSharedLinksException, DbxException
    {
        GetSharedLinksArg arg = new GetSharedLinksArg(path);
        return getSharedLinks(arg);
    }

    /**
     * Exception thrown by {@link #createSharedLink}.
     */
    public static class CreateSharedLinkException extends DbxApiException {
        /**
         * The error reported by createSharedLink.
         */
        public final CreateSharedLinkError errorValue;

        public CreateSharedLinkException(CreateSharedLinkError errorValue) {
            super("Exception in create_shared_link: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the url field is the shortened URL if the short_url
     * argument is set to {@literal true}. This API is not supported for App
     * Folder and filetypes apps.
     */
    private PathLinkMetadata createSharedLink(CreateSharedLinkArg arg)
            throws CreateSharedLinkException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/create_shared_link",
                                           arg,
                                           CreateSharedLinkArg._writer,
                                           PathLinkMetadata._reader,
                                           CreateSharedLinkError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateSharedLinkException((CreateSharedLinkError) (ew.errValue));
        }
    }
    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the url field is the shortened URL if the short_url
     * argument is set to {@literal true}. This API is not supported for App
     * Folder and filetypes apps.
     */
    public PathLinkMetadata createSharedLink(String path)
          throws CreateSharedLinkException, DbxException
    {
        CreateSharedLinkArg arg = new CreateSharedLinkArg(path, null, null);
        return createSharedLink(arg);
    }
    /**
     * The builder object returned by {@link #createSharedLinkBuilder}
     */
    public final class CreateSharedLinkBuilder
    {
        private String path;
        private Boolean shortUrl;
        private PendingUploadMode pendingUpload;
        private CreateSharedLinkBuilder(String path)
        {
            this.path = path;
        }
        public CreateSharedLinkBuilder shortUrl(boolean shortUrl)
        {
            this.shortUrl = shortUrl;
            return this;
        }
        public CreateSharedLinkBuilder pendingUpload(PendingUploadMode pendingUpload)
        {
            this.pendingUpload = pendingUpload;
            return this;
        }
        public PathLinkMetadata start() throws CreateSharedLinkException, DbxException
        {
            CreateSharedLinkArg arg = new CreateSharedLinkArg(path, shortUrl, pendingUpload);
            return DbxSharing.this.createSharedLink(arg);
        }
    }
    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the url field is the shortened URL if the short_url
     * argument is set to {@literal true}. This API is not supported for App
     * Folder and filetypes apps.
     */
    public CreateSharedLinkBuilder createSharedLinkBuilder(String path)
    {
        return new CreateSharedLinkBuilder(path);
    }

    /**
     * Exception thrown by {@link #revokeSharedLink}.
     */
    public static class RevokeSharedLinkException extends DbxApiException {
        /**
         * The error reported by revokeSharedLink.
         */
        public final RevokeSharedLinkError errorValue;

        public RevokeSharedLinkException(RevokeSharedLinkError errorValue) {
            super("Exception in revoke_shared_link: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Revoke a shared link. This API is only supported for full dropbox apps.
     */
    private void revokeSharedLink(RevokeSharedLinkArg arg)
            throws RevokeSharedLinkException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/revoke_shared_link",
                                    arg,
                                    RevokeSharedLinkArg._writer,
                                    JsonReader.VoidReader,
                                    RevokeSharedLinkError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeSharedLinkException((RevokeSharedLinkError) (ew.errValue));
        }
    }
    /**
     * Revoke a shared link. This API is only supported for full dropbox apps.
     */
    public void revokeSharedLink(String url)
          throws RevokeSharedLinkException, DbxException
    {
        RevokeSharedLinkArg arg = new RevokeSharedLinkArg(url);
        revokeSharedLink(arg);
    }

    /**
     * Exception thrown by {@link #getFolderMetadata}.
     */
    public static class GetFolderMetadataException extends DbxApiException {
        /**
         * The error reported by getFolderMetadata.
         */
        public final SharedFolderAccessError errorValue;

        public GetFolderMetadataException(SharedFolderAccessError errorValue) {
            super("Exception in get_folder_metadata: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns shared folder metadata by its folder ID. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    private SharedFolderMetadata getFolderMetadata(GetMetadataArgs arg)
            throws GetFolderMetadataException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/get_folder_metadata",
                                           arg,
                                           GetMetadataArgs._writer,
                                           SharedFolderMetadata._reader,
                                           SharedFolderAccessError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetFolderMetadataException((SharedFolderAccessError) (ew.errValue));
        }
    }
    /**
     * Returns shared folder metadata by its folder ID. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId)
          throws GetFolderMetadataException, DbxException
    {
        GetMetadataArgs arg = new GetMetadataArgs(sharedFolderId, null);
        return getFolderMetadata(arg);
    }
    /**
     * Returns shared folder metadata by its folder ID. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId, boolean includeMembership)
          throws GetFolderMetadataException, DbxException
    {
        GetMetadataArgs arg = new GetMetadataArgs(sharedFolderId, includeMembership);
        return getFolderMetadata(arg);
    }

    /**
     * Exception thrown by {@link #listFolders}.
     */
    public static class ListFoldersException extends DbxApiException {
        public ListFoldersException() {
            super("Exception in list_folders");
        }
    }
    /**
     * Return the list of all shared folders the current user has access to.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private ListFoldersResult listFolders(ListFoldersArgs arg)
            throws ListFoldersException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/list_folders",
                                           arg,
                                           ListFoldersArgs._writer,
                                           ListFoldersResult._reader,
                                           JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFoldersException();
        }
    }
    /**
     * Return the list of all shared folders the current user has access to.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    public ListFoldersResult listFolders()
          throws ListFoldersException, DbxException
    {
        ListFoldersArgs arg = new ListFoldersArgs(null);
        return listFolders(arg);
    }
    /**
     * Return the list of all shared folders the current user has access to.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    public ListFoldersResult listFolders(boolean includeMembership)
          throws ListFoldersException, DbxException
    {
        ListFoldersArgs arg = new ListFoldersArgs(includeMembership);
        return listFolders(arg);
    }

    /**
     * Exception thrown by {@link #shareFolder}.
     */
    public static class ShareFolderException extends DbxApiException {
        /**
         * The error reported by shareFolder.
         */
        public final ShareFolderError errorValue;

        public ShareFolderException(ShareFolderError errorValue) {
            super("Exception in share_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@code shareFolderLaunch.asyncJobId} is returned, you'll need to call
     * {@link #checkShareJobStatus} until the action completes to get the
     * metadata for the folder. Warning: This endpoint is in beta and is subject
     * to minor but possibly backwards-incompatible changes.
     */
    private ShareFolderLaunch shareFolder(ShareFolderArg arg)
            throws ShareFolderException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/share_folder",
                                           arg,
                                           ShareFolderArg._writer,
                                           ShareFolderLaunch._reader,
                                           ShareFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ShareFolderException((ShareFolderError) (ew.errValue));
        }
    }
    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@code shareFolderLaunch.asyncJobId} is returned, you'll need to call
     * {@link #checkShareJobStatus} until the action completes to get the
     * metadata for the folder. Warning: This endpoint is in beta and is subject
     * to minor but possibly backwards-incompatible changes.
     */
    public ShareFolderLaunch shareFolder(String path)
          throws ShareFolderException, DbxException
    {
        ShareFolderArg arg = new ShareFolderArg(path, null, null, null, null);
        return shareFolder(arg);
    }
    /**
     * The builder object returned by {@link #shareFolderBuilder}
     */
    public final class ShareFolderBuilder
    {
        private String path;
        private MemberPolicy memberPolicy;
        private AclUpdatePolicy aclUpdatePolicy;
        private SharedLinkPolicy sharedLinkPolicy;
        private Boolean forceAsync;
        private ShareFolderBuilder(String path)
        {
            this.path = path;
        }
        public ShareFolderBuilder memberPolicy(MemberPolicy memberPolicy)
        {
            this.memberPolicy = memberPolicy;
            return this;
        }
        public ShareFolderBuilder aclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy)
        {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }
        public ShareFolderBuilder sharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy)
        {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }
        public ShareFolderBuilder forceAsync(boolean forceAsync)
        {
            this.forceAsync = forceAsync;
            return this;
        }
        public ShareFolderLaunch start() throws ShareFolderException, DbxException
        {
            ShareFolderArg arg = new ShareFolderArg(path, memberPolicy, aclUpdatePolicy, sharedLinkPolicy, forceAsync);
            return DbxSharing.this.shareFolder(arg);
        }
    }
    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@code shareFolderLaunch.asyncJobId} is returned, you'll need to call
     * {@link #checkShareJobStatus} until the action completes to get the
     * metadata for the folder. Warning: This endpoint is in beta and is subject
     * to minor but possibly backwards-incompatible changes.
     */
    public ShareFolderBuilder shareFolderBuilder(String path)
    {
        return new ShareFolderBuilder(path);
    }

    /**
     * Exception thrown by {@link #updateFolderPolicy}.
     */
    public static class UpdateFolderPolicyException extends DbxApiException {
        /**
         * The error reported by updateFolderPolicy.
         */
        public final UpdateFolderPolicyError errorValue;

        public UpdateFolderPolicyException(UpdateFolderPolicyError errorValue) {
            super("Exception in update_folder_policy: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Update the sharing policies for a shared folder. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    private BasicSharedFolderMetadata updateFolderPolicy(UpdateFolderPolicyArg arg)
            throws UpdateFolderPolicyException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/update_folder_policy",
                                           arg,
                                           UpdateFolderPolicyArg._writer,
                                           BasicSharedFolderMetadata._reader,
                                           UpdateFolderPolicyError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderPolicyException((UpdateFolderPolicyError) (ew.errValue));
        }
    }
    /**
     * Update the sharing policies for a shared folder. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public BasicSharedFolderMetadata updateFolderPolicy(String sharedFolderId)
          throws UpdateFolderPolicyException, DbxException
    {
        UpdateFolderPolicyArg arg = new UpdateFolderPolicyArg(sharedFolderId, null, null, null);
        return updateFolderPolicy(arg);
    }
    /**
     * The builder object returned by {@link #updateFolderPolicyBuilder}
     */
    public final class UpdateFolderPolicyBuilder
    {
        private String sharedFolderId;
        private MemberPolicy memberPolicy;
        private AclUpdatePolicy aclUpdatePolicy;
        private SharedLinkPolicy sharedLinkPolicy;
        private UpdateFolderPolicyBuilder(String sharedFolderId)
        {
            this.sharedFolderId = sharedFolderId;
        }
        public UpdateFolderPolicyBuilder memberPolicy(MemberPolicy memberPolicy)
        {
            this.memberPolicy = memberPolicy;
            return this;
        }
        public UpdateFolderPolicyBuilder aclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy)
        {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }
        public UpdateFolderPolicyBuilder sharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy)
        {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }
        public BasicSharedFolderMetadata start() throws UpdateFolderPolicyException, DbxException
        {
            UpdateFolderPolicyArg arg = new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
            return DbxSharing.this.updateFolderPolicy(arg);
        }
    }
    /**
     * Update the sharing policies for a shared folder. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public UpdateFolderPolicyBuilder updateFolderPolicyBuilder(String sharedFolderId)
    {
        return new UpdateFolderPolicyBuilder(sharedFolderId);
    }

    /**
     * Exception thrown by {@link #unshareFolder}.
     */
    public static class UnshareFolderException extends DbxApiException {
        /**
         * The error reported by unshareFolder.
         */
        public final UnshareFolderError errorValue;

        public UnshareFolderException(UnshareFolderError errorValue) {
            super("Exception in unshare_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link #checkJobStatus} to determine if the action has completed
     * successfully. Warning: This endpoint is in beta and is subject to minor
     * but possibly backwards-incompatible changes.
     */
    private DbxAsync.LaunchEmptyResult unshareFolder(UnshareFolderArg arg)
            throws UnshareFolderException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/unshare_folder",
                                           arg,
                                           UnshareFolderArg._writer,
                                           DbxAsync.LaunchEmptyResult._reader,
                                           UnshareFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnshareFolderException((UnshareFolderError) (ew.errValue));
        }
    }
    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link #checkJobStatus} to determine if the action has completed
     * successfully. Warning: This endpoint is in beta and is subject to minor
     * but possibly backwards-incompatible changes.
     */
    public DbxAsync.LaunchEmptyResult unshareFolder(String sharedFolderId, boolean leaveACopy)
          throws UnshareFolderException, DbxException
    {
        UnshareFolderArg arg = new UnshareFolderArg(sharedFolderId, leaveACopy);
        return unshareFolder(arg);
    }

    /**
     * Exception thrown by {@link #transferFolder}.
     */
    public static class TransferFolderException extends DbxApiException {
        /**
         * The error reported by transferFolder.
         */
        public final TransferFolderError errorValue;

        public TransferFolderException(TransferFolderError errorValue) {
            super("Exception in transfer_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private void transferFolder(TransferFolderArg arg)
            throws TransferFolderException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/transfer_folder",
                                    arg,
                                    TransferFolderArg._writer,
                                    JsonReader.VoidReader,
                                    TransferFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new TransferFolderException((TransferFolderError) (ew.errValue));
        }
    }
    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    public void transferFolder(String sharedFolderId, String toDropboxId)
          throws TransferFolderException, DbxException
    {
        TransferFolderArg arg = new TransferFolderArg(sharedFolderId, toDropboxId);
        transferFolder(arg);
    }

    /**
     * Exception thrown by {@link #unmountFolder}.
     */
    public static class UnmountFolderException extends DbxApiException {
        /**
         * The error reported by unmountFolder.
         */
        public final UnmountFolderError errorValue;

        public UnmountFolderException(UnmountFolderError errorValue) {
            super("Exception in unmount_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link #mountFolder}. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    private void unmountFolder(UnmountFolderArg arg)
            throws UnmountFolderException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/unmount_folder",
                                    arg,
                                    UnmountFolderArg._writer,
                                    JsonReader.VoidReader,
                                    UnmountFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnmountFolderException((UnmountFolderError) (ew.errValue));
        }
    }
    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link #mountFolder}. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public void unmountFolder(String sharedFolderId)
          throws UnmountFolderException, DbxException
    {
        UnmountFolderArg arg = new UnmountFolderArg(sharedFolderId);
        unmountFolder(arg);
    }

    /**
     * Exception thrown by {@link #mountFolder}.
     */
    public static class MountFolderException extends DbxApiException {
        /**
         * The error reported by mountFolder.
         */
        public final MountFolderError errorValue;

        public MountFolderException(MountFolderError errorValue) {
            super("Exception in mount_folder: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private BasicSharedFolderMetadata mountFolder(MountFolderArg arg)
            throws MountFolderException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/mount_folder",
                                           arg,
                                           MountFolderArg._writer,
                                           BasicSharedFolderMetadata._reader,
                                           MountFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MountFolderException((MountFolderError) (ew.errValue));
        }
    }
    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    public BasicSharedFolderMetadata mountFolder(String sharedFolderId)
          throws MountFolderException, DbxException
    {
        MountFolderArg arg = new MountFolderArg(sharedFolderId);
        return mountFolder(arg);
    }

    /**
     * Exception thrown by {@link #addFolderMember}.
     */
    public static class AddFolderMemberException extends DbxApiException {
        /**
         * The error reported by addFolderMember.
         */
        public final AddFolderMemberError errorValue;

        public AddFolderMemberException(AddFolderMemberError errorValue) {
            super("Exception in add_folder_member: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link #mountFolder}
     * on their behalf. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    private void addFolderMember(AddFolderMemberArg arg)
            throws AddFolderMemberException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/add_folder_member",
                                    arg,
                                    AddFolderMemberArg._writer,
                                    JsonReader.VoidReader,
                                    AddFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new AddFolderMemberException((AddFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link #mountFolder}
     * on their behalf. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    public void addFolderMember(String sharedFolderId, java.util.ArrayList<AddMember> members)
          throws AddFolderMemberException, DbxException
    {
        AddFolderMemberArg arg = new AddFolderMemberArg(sharedFolderId, members, null, null);
        addFolderMember(arg);
    }
    /**
     * The builder object returned by {@link #addFolderMemberBuilder}
     */
    public final class AddFolderMemberBuilder
    {
        private String sharedFolderId;
        private java.util.ArrayList<AddMember> members;
        private Boolean quiet;
        private String customMessage;
        private AddFolderMemberBuilder(String sharedFolderId, java.util.ArrayList<AddMember> members)
        {
            this.sharedFolderId = sharedFolderId;
            this.members = members;
        }
        public AddFolderMemberBuilder quiet(boolean quiet)
        {
            this.quiet = quiet;
            return this;
        }
        public AddFolderMemberBuilder customMessage(String customMessage)
        {
            this.customMessage = customMessage;
            return this;
        }
        public void start() throws AddFolderMemberException, DbxException
        {
            AddFolderMemberArg arg = new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
            DbxSharing.this.addFolderMember(arg);
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link #mountFolder}
     * on their behalf. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    public AddFolderMemberBuilder addFolderMemberBuilder(String sharedFolderId, java.util.ArrayList<AddMember> members)
    {
        return new AddFolderMemberBuilder(sharedFolderId, members);
    }

    /**
     * Exception thrown by {@link #checkShareJobStatus}.
     */
    public static class CheckShareJobStatusException extends DbxApiException {
        /**
         * The error reported by checkShareJobStatus.
         */
        public final DbxAsync.PollError errorValue;

        public CheckShareJobStatusException(DbxAsync.PollError errorValue) {
            super("Exception in check_share_job_status: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the status of an asynchronous job for sharing a folder. Warning:
     * This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private ShareFolderJobStatus checkShareJobStatus(DbxAsync.PollArg arg)
            throws CheckShareJobStatusException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/check_share_job_status",
                                           arg,
                                           DbxAsync.PollArg._writer,
                                           ShareFolderJobStatus._reader,
                                           DbxAsync.PollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CheckShareJobStatusException((DbxAsync.PollError) (ew.errValue));
        }
    }
    /**
     * Returns the status of an asynchronous job for sharing a folder. Warning:
     * This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    public ShareFolderJobStatus checkShareJobStatus(String asyncJobId)
          throws CheckShareJobStatusException, DbxException
    {
        DbxAsync.PollArg arg = new DbxAsync.PollArg(asyncJobId);
        return checkShareJobStatus(arg);
    }

    /**
     * Exception thrown by {@link #checkJobStatus}.
     */
    public static class CheckJobStatusException extends DbxApiException {
        /**
         * The error reported by checkJobStatus.
         */
        public final DbxAsync.PollError errorValue;

        public CheckJobStatusException(DbxAsync.PollError errorValue) {
            super("Exception in check_job_status: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the status of an asynchronous job. Warning: This endpoint is in
     * beta and is subject to minor but possibly backwards-incompatible changes.
     */
    private JobStatus checkJobStatus(DbxAsync.PollArg arg)
            throws CheckJobStatusException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/check_job_status",
                                           arg,
                                           DbxAsync.PollArg._writer,
                                           JobStatus._reader,
                                           DbxAsync.PollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CheckJobStatusException((DbxAsync.PollError) (ew.errValue));
        }
    }
    /**
     * Returns the status of an asynchronous job. Warning: This endpoint is in
     * beta and is subject to minor but possibly backwards-incompatible changes.
     */
    public JobStatus checkJobStatus(String asyncJobId)
          throws CheckJobStatusException, DbxException
    {
        DbxAsync.PollArg arg = new DbxAsync.PollArg(asyncJobId);
        return checkJobStatus(arg);
    }

    /**
     * Exception thrown by {@link #removeFolderMember}.
     */
    public static class RemoveFolderMemberException extends DbxApiException {
        /**
         * The error reported by removeFolderMember.
         */
        public final RemoveFolderMemberError errorValue;

        public RemoveFolderMemberException(RemoveFolderMemberError errorValue) {
            super("Exception in remove_folder_member: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     */
    private DbxAsync.LaunchEmptyResult removeFolderMember(RemoveFolderMemberArg arg)
            throws RemoveFolderMemberException, DbxException
    {
        try {
            return DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                           client.getAccessToken(),
                                           client.getHost().api,
                                           "2-beta-2/sharing/remove_folder_member",
                                           arg,
                                           RemoveFolderMemberArg._writer,
                                           DbxAsync.LaunchEmptyResult._reader,
                                           RemoveFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RemoveFolderMemberException((RemoveFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     */
    public DbxAsync.LaunchEmptyResult removeFolderMember(String sharedFolderId, MemberSelector member, boolean leaveACopy)
          throws RemoveFolderMemberException, DbxException
    {
        RemoveFolderMemberArg arg = new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        return removeFolderMember(arg);
    }

    /**
     * Exception thrown by {@link #updateFolderMember}.
     */
    public static class UpdateFolderMemberException extends DbxApiException {
        /**
         * The error reported by updateFolderMember.
         */
        public final UpdateFolderMemberError errorValue;

        public UpdateFolderMemberException(UpdateFolderMemberError errorValue) {
            super("Exception in update_folder_member: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Warning: This endpoint is in beta and is subject to minor
     * but possibly backwards-incompatible changes.
     */
    private void updateFolderMember(UpdateFolderMemberArg arg)
            throws UpdateFolderMemberException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/update_folder_member",
                                    arg,
                                    UpdateFolderMemberArg._writer,
                                    JsonReader.VoidReader,
                                    UpdateFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderMemberException((UpdateFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Warning: This endpoint is in beta and is subject to minor
     * but possibly backwards-incompatible changes.
     */
    public void updateFolderMember(String sharedFolderId, MemberSelector member, AccessLevel accessLevel)
          throws UpdateFolderMemberException, DbxException
    {
        UpdateFolderMemberArg arg = new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        updateFolderMember(arg);
    }

    /**
     * Exception thrown by {@link #relinquishFolderMembership}.
     */
    public static class RelinquishFolderMembershipException extends DbxApiException {
        /**
         * The error reported by relinquishFolderMembership.
         */
        public final RelinquishFolderMembershipError errorValue;

        public RelinquishFolderMembershipException(RelinquishFolderMembershipError errorValue) {
            super("Exception in relinquish_folder_membership: " + errorValue);
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    private void relinquishFolderMembership(RelinquishFolderMembershipArg arg)
            throws RelinquishFolderMembershipException, DbxException
    {
        try {
            DbxRawClientV2.rpcStyle(client.getRequestConfig(),
                                    client.getAccessToken(),
                                    client.getHost().api,
                                    "2-beta-2/sharing/relinquish_folder_membership",
                                    arg,
                                    RelinquishFolderMembershipArg._writer,
                                    JsonReader.VoidReader,
                                    RelinquishFolderMembershipError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RelinquishFolderMembershipException((RelinquishFolderMembershipError) (ew.errValue));
        }
    }
    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Warning: This endpoint
     * is in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    public void relinquishFolderMembership(String sharedFolderId)
          throws RelinquishFolderMembershipException, DbxException
    {
        RelinquishFolderMembershipArg arg = new RelinquishFolderMembershipArg(sharedFolderId);
        relinquishFolderMembership(arg);
    }
}
