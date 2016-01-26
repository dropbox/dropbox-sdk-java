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
import com.dropbox.core.LocalizedText;
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


    public static class GetSharedLinkMetadataArg {
        // struct GetSharedLinkMetadataArg
        /**
         * URL of the shared link.
         */
        public final String url;
        /**
         * If the shared link is to a folder, this parameter can be used to
         * retrieve the metadata for a specific file or sub-folder in this
         * folder. A relative path should be used.
         */
        public final String path;
        /**
         * If the shared link has a password, this parameter can be used.
         */
        public final String linkPassword;

        /**
         *
         * @param path  If the shared link is to a folder, this parameter can be
         *     used to retrieve the metadata for a specific file or sub-folder
         *     in this folder. A relative path should be used. {@code path} must
         *     match pattern "{@code /.*}".
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         * @param linkPassword  If the shared link has a password, this
         *     parameter can be used.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetSharedLinkMetadataArg(String url, String path, String linkPassword) {
            this.url = url;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.path = path;
            if (path != null) {
                if (!java.util.regex.Pattern.matches("/.*", path)) {
                    throw new IllegalArgumentException("String 'path' does not match pattern");
                }
            }
            this.linkPassword = linkPassword;
        }

        static final JsonWriter<GetSharedLinkMetadataArg> _writer = new JsonWriter<GetSharedLinkMetadataArg>()
        {
            public final void write(GetSharedLinkMetadataArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                GetSharedLinkMetadataArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(GetSharedLinkMetadataArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("url", x.url);
                if (x.path != null) {
                    g.writeFieldName("path");
                    g.writeString(x.path);
                }
                if (x.linkPassword != null) {
                    g.writeFieldName("link_password");
                    g.writeString(x.linkPassword);
                }
            }
        };

        public static final JsonReader<GetSharedLinkMetadataArg> _reader = new JsonReader<GetSharedLinkMetadataArg>() {

            public final GetSharedLinkMetadataArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                GetSharedLinkMetadataArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final GetSharedLinkMetadataArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                String path = null;
                String linkPassword = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("link_password".equals(fieldName)) {
                        linkPassword = JsonReader.StringReader
                            .readField(parser, "link_password", linkPassword);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                return new GetSharedLinkMetadataArg(url, path, linkPassword);
            }
        };

        public String toString() {
            return "GetSharedLinkMetadataArg." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "GetSharedLinkMetadataArg." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static GetSharedLinkMetadataArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * The access permission that can be requested by the caller for the shared
     * link. Note that the final resolved visibility of the shared link takes
     * into account other aspects, such as team and shared folder settings.
     * Check the {@link ResolvedVisibility} for more info on the possible
     * resolved visibility values of shared links.
     */
    public static final class RequestedVisibility {
        // union RequestedVisibility

        /**
         * The discriminating tag type for {@link RequestedVisibility}.
         */
        public enum Tag {
            /**
             * Anyone who has received the link can access it. No login
             * required.
             */
            PUBLIC,
            /**
             * Only members of the same team can access the link. Login is
             * required.
             */
            TEAM_ONLY,
            /**
             * A link-specific password is required to access the link. Login is
             * not required.
             */
            PASSWORD
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
         * handle this {@code RequestedVisibility}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Anyone who has received the link can access it. No login required.
         */
        private static final RequestedVisibility PUBLIC_INSTANCE = new RequestedVisibility(Tag.PUBLIC);

        /**
         * Returns an instance of {@code RequestedVisibility} that has its tag
         * set to {@link Tag#PUBLIC}.
         *
         * <p> Anyone who has received the link can access it. No login
         * required. </p>
         *
         * @return Instance of {@code RequestedVisibility} with its tag set to
         *     {@link Tag#PUBLIC}.
         */
        public static RequestedVisibility public_() {
            return RequestedVisibility.PUBLIC_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PUBLIC},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PUBLIC}, {@code false} otherwise.
         */
        public boolean isPublic() {
            return this.tag == Tag.PUBLIC;
        }

        /**
         * Only members of the same team can access the link. Login is required.
         */
        private static final RequestedVisibility TEAM_ONLY_INSTANCE = new RequestedVisibility(Tag.TEAM_ONLY);

        /**
         * Returns an instance of {@code RequestedVisibility} that has its tag
         * set to {@link Tag#TEAM_ONLY}.
         *
         * <p> Only members of the same team can access the link. Login is
         * required. </p>
         *
         * @return Instance of {@code RequestedVisibility} with its tag set to
         *     {@link Tag#TEAM_ONLY}.
         */
        public static RequestedVisibility teamOnly() {
            return RequestedVisibility.TEAM_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_ONLY}, {@code false} otherwise.
         */
        public boolean isTeamOnly() {
            return this.tag == Tag.TEAM_ONLY;
        }

        /**
         * A link-specific password is required to access the link. Login is not
         * required.
         */
        private static final RequestedVisibility PASSWORD_INSTANCE = new RequestedVisibility(Tag.PASSWORD);

        /**
         * Returns an instance of {@code RequestedVisibility} that has its tag
         * set to {@link Tag#PASSWORD}.
         *
         * <p> A link-specific password is required to access the link. Login is
         * not required. </p>
         *
         * @return Instance of {@code RequestedVisibility} with its tag set to
         *     {@link Tag#PASSWORD}.
         */
        public static RequestedVisibility password() {
            return RequestedVisibility.PASSWORD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PASSWORD}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PASSWORD}, {@code false} otherwise.
         */
        public boolean isPassword() {
            return this.tag == Tag.PASSWORD;
        }

        private RequestedVisibility(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case PUBLIC:
                case TEAM_ONLY:
                case PASSWORD:
                    break;
            }
        }

        static final JsonWriter<RequestedVisibility> _writer = new JsonWriter<RequestedVisibility>()
        {
            public final void write(RequestedVisibility x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PUBLIC:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("public");
                        g.writeEndObject();
                        break;
                    case TEAM_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_only");
                        g.writeEndObject();
                        break;
                    case PASSWORD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("password");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<RequestedVisibility> _reader = new JsonReader<RequestedVisibility>()
        {
            public final RequestedVisibility read(JsonParser parser)
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
                        case PUBLIC: return RequestedVisibility.public_();
                        case TEAM_ONLY: return RequestedVisibility.teamOnly();
                        case PASSWORD: return RequestedVisibility.password();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RequestedVisibility value = null;
                if (tag != null) {
                    switch (tag) {
                        case PUBLIC: {
                            value = RequestedVisibility.public_();
                            break;
                        }
                        case TEAM_ONLY: {
                            value = RequestedVisibility.teamOnly();
                            break;
                        }
                        case PASSWORD: {
                            value = RequestedVisibility.password();
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
            _values.put("public", Tag.PUBLIC);
            _values.put("team_only", Tag.TEAM_ONLY);
            _values.put("password", Tag.PASSWORD);
        }

        public String toString() {
            return "RequestedVisibility." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RequestedVisibility." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static RequestedVisibility fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * The actual access permissions values of shared links after taking into
     * account user preferences and the team and shared folder settings. Check
     * the {@link RequestedVisibility} for more info on the possible visibility
     * values that can be set by the shared link's owner.
     */
    public static final class ResolvedVisibility {
        // union ResolvedVisibility

        /**
         * The discriminating tag type for {@link ResolvedVisibility}.
         */
        public enum Tag {
            /**
             * Anyone who has received the link can access it. No login
             * required.
             */
            PUBLIC,
            /**
             * Only members of the same team can access the link. Login is
             * required.
             */
            TEAM_ONLY,
            /**
             * A link-specific password is required to access the link. Login is
             * not required.
             */
            PASSWORD,
            /**
             * Only members of the same team who have the link-specific password
             * can access the link. Login is required.
             */
            TEAM_AND_PASSWORD,
            /**
             * Only members of the shared folder containing the linked file can
             * access the link. Login is required.
             */
            SHARED_FOLDER_ONLY,
            /**
             * An unknown restriction is in place.
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
         * handle this {@code ResolvedVisibility}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Anyone who has received the link can access it. No login required.
         */
        private static final ResolvedVisibility PUBLIC_INSTANCE = new ResolvedVisibility(Tag.PUBLIC);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#PUBLIC}.
         *
         * <p> Anyone who has received the link can access it. No login
         * required. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#PUBLIC}.
         */
        public static ResolvedVisibility public_() {
            return ResolvedVisibility.PUBLIC_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PUBLIC},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PUBLIC}, {@code false} otherwise.
         */
        public boolean isPublic() {
            return this.tag == Tag.PUBLIC;
        }

        /**
         * Only members of the same team can access the link. Login is required.
         */
        private static final ResolvedVisibility TEAM_ONLY_INSTANCE = new ResolvedVisibility(Tag.TEAM_ONLY);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#TEAM_ONLY}.
         *
         * <p> Only members of the same team can access the link. Login is
         * required. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#TEAM_ONLY}.
         */
        public static ResolvedVisibility teamOnly() {
            return ResolvedVisibility.TEAM_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_ONLY}, {@code false} otherwise.
         */
        public boolean isTeamOnly() {
            return this.tag == Tag.TEAM_ONLY;
        }

        /**
         * A link-specific password is required to access the link. Login is not
         * required.
         */
        private static final ResolvedVisibility PASSWORD_INSTANCE = new ResolvedVisibility(Tag.PASSWORD);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#PASSWORD}.
         *
         * <p> A link-specific password is required to access the link. Login is
         * not required. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#PASSWORD}.
         */
        public static ResolvedVisibility password() {
            return ResolvedVisibility.PASSWORD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PASSWORD}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PASSWORD}, {@code false} otherwise.
         */
        public boolean isPassword() {
            return this.tag == Tag.PASSWORD;
        }

        /**
         * Only members of the same team who have the link-specific password can
         * access the link. Login is required.
         */
        private static final ResolvedVisibility TEAM_AND_PASSWORD_INSTANCE = new ResolvedVisibility(Tag.TEAM_AND_PASSWORD);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#TEAM_AND_PASSWORD}.
         *
         * <p> Only members of the same team who have the link-specific password
         * can access the link. Login is required. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#TEAM_AND_PASSWORD}.
         */
        public static ResolvedVisibility teamAndPassword() {
            return ResolvedVisibility.TEAM_AND_PASSWORD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_AND_PASSWORD}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_AND_PASSWORD}, {@code false} otherwise.
         */
        public boolean isTeamAndPassword() {
            return this.tag == Tag.TEAM_AND_PASSWORD;
        }

        /**
         * Only members of the shared folder containing the linked file can
         * access the link. Login is required.
         */
        private static final ResolvedVisibility SHARED_FOLDER_ONLY_INSTANCE = new ResolvedVisibility(Tag.SHARED_FOLDER_ONLY);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#SHARED_FOLDER_ONLY}.
         *
         * <p> Only members of the shared folder containing the linked file can
         * access the link. Login is required. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#SHARED_FOLDER_ONLY}.
         */
        public static ResolvedVisibility sharedFolderOnly() {
            return ResolvedVisibility.SHARED_FOLDER_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_FOLDER_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_FOLDER_ONLY}, {@code false} otherwise.
         */
        public boolean isSharedFolderOnly() {
            return this.tag == Tag.SHARED_FOLDER_ONLY;
        }

        /**
         * An unknown restriction is in place.
         */
        private static final ResolvedVisibility OTHER_INSTANCE = new ResolvedVisibility(Tag.OTHER);

        /**
         * Returns an instance of {@code ResolvedVisibility} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> An unknown restriction is in place. </p>
         *
         * @return Instance of {@code ResolvedVisibility} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static ResolvedVisibility other() {
            return ResolvedVisibility.OTHER_INSTANCE;
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

        private ResolvedVisibility(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case PUBLIC:
                case TEAM_ONLY:
                case PASSWORD:
                case TEAM_AND_PASSWORD:
                case SHARED_FOLDER_ONLY:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<ResolvedVisibility> _writer = new JsonWriter<ResolvedVisibility>()
        {
            public final void write(ResolvedVisibility x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PUBLIC:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("public");
                        g.writeEndObject();
                        break;
                    case TEAM_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_only");
                        g.writeEndObject();
                        break;
                    case PASSWORD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("password");
                        g.writeEndObject();
                        break;
                    case TEAM_AND_PASSWORD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_and_password");
                        g.writeEndObject();
                        break;
                    case SHARED_FOLDER_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_folder_only");
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
        public static final JsonReader<ResolvedVisibility> _reader = new JsonReader<ResolvedVisibility>()
        {
            public final ResolvedVisibility read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ResolvedVisibility.other(); }
                    switch (tag) {
                        case PUBLIC: return ResolvedVisibility.public_();
                        case TEAM_ONLY: return ResolvedVisibility.teamOnly();
                        case PASSWORD: return ResolvedVisibility.password();
                        case TEAM_AND_PASSWORD: return ResolvedVisibility.teamAndPassword();
                        case SHARED_FOLDER_ONLY: return ResolvedVisibility.sharedFolderOnly();
                        case OTHER: return ResolvedVisibility.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ResolvedVisibility value = null;
                if (tag != null) {
                    switch (tag) {
                        case PUBLIC: {
                            value = ResolvedVisibility.public_();
                            break;
                        }
                        case TEAM_ONLY: {
                            value = ResolvedVisibility.teamOnly();
                            break;
                        }
                        case PASSWORD: {
                            value = ResolvedVisibility.password();
                            break;
                        }
                        case TEAM_AND_PASSWORD: {
                            value = ResolvedVisibility.teamAndPassword();
                            break;
                        }
                        case SHARED_FOLDER_ONLY: {
                            value = ResolvedVisibility.sharedFolderOnly();
                            break;
                        }
                        case OTHER: {
                            value = ResolvedVisibility.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ResolvedVisibility.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("team_and_password", Tag.TEAM_AND_PASSWORD);
            _values.put("shared_folder_only", Tag.SHARED_FOLDER_ONLY);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "ResolvedVisibility." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ResolvedVisibility." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ResolvedVisibility fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class SharedLinkAccessFailureReason {
        // union SharedLinkAccessFailureReason

        /**
         * The discriminating tag type for {@link
         * SharedLinkAccessFailureReason}.
         */
        public enum Tag {
            /**
             * User is not logged in.
             */
            LOGIN_REQUIRED,
            /**
             * User's email is not verified.
             */
            EMAIL_VERIFY_REQUIRED,
            /**
             * The link is password protected.
             */
            PASSWORD_REQUIRED,
            /**
             * Access is allowed for team members only.
             */
            TEAM_ONLY,
            /**
             * Access is allowed for the shared link's owner only.
             */
            OWNER_ONLY,
            /**
             * An unknown accessibility failure.
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
         * handle this {@code SharedLinkAccessFailureReason}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * User is not logged in.
         */
        private static final SharedLinkAccessFailureReason LOGIN_REQUIRED_INSTANCE = new SharedLinkAccessFailureReason(Tag.LOGIN_REQUIRED);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#LOGIN_REQUIRED}.
         *
         * <p> User is not logged in. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#LOGIN_REQUIRED}.
         */
        public static SharedLinkAccessFailureReason loginRequired() {
            return SharedLinkAccessFailureReason.LOGIN_REQUIRED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#LOGIN_REQUIRED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#LOGIN_REQUIRED}, {@code false} otherwise.
         */
        public boolean isLoginRequired() {
            return this.tag == Tag.LOGIN_REQUIRED;
        }

        /**
         * User's email is not verified.
         */
        private static final SharedLinkAccessFailureReason EMAIL_VERIFY_REQUIRED_INSTANCE = new SharedLinkAccessFailureReason(Tag.EMAIL_VERIFY_REQUIRED);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#EMAIL_VERIFY_REQUIRED}.
         *
         * <p> User's email is not verified. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#EMAIL_VERIFY_REQUIRED}.
         */
        public static SharedLinkAccessFailureReason emailVerifyRequired() {
            return SharedLinkAccessFailureReason.EMAIL_VERIFY_REQUIRED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_VERIFY_REQUIRED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_VERIFY_REQUIRED}, {@code false} otherwise.
         */
        public boolean isEmailVerifyRequired() {
            return this.tag == Tag.EMAIL_VERIFY_REQUIRED;
        }

        /**
         * The link is password protected.
         */
        private static final SharedLinkAccessFailureReason PASSWORD_REQUIRED_INSTANCE = new SharedLinkAccessFailureReason(Tag.PASSWORD_REQUIRED);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#PASSWORD_REQUIRED}.
         *
         * <p> The link is password protected. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#PASSWORD_REQUIRED}.
         */
        public static SharedLinkAccessFailureReason passwordRequired() {
            return SharedLinkAccessFailureReason.PASSWORD_REQUIRED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PASSWORD_REQUIRED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PASSWORD_REQUIRED}, {@code false} otherwise.
         */
        public boolean isPasswordRequired() {
            return this.tag == Tag.PASSWORD_REQUIRED;
        }

        /**
         * Access is allowed for team members only.
         */
        private static final SharedLinkAccessFailureReason TEAM_ONLY_INSTANCE = new SharedLinkAccessFailureReason(Tag.TEAM_ONLY);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#TEAM_ONLY}.
         *
         * <p> Access is allowed for team members only. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#TEAM_ONLY}.
         */
        public static SharedLinkAccessFailureReason teamOnly() {
            return SharedLinkAccessFailureReason.TEAM_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_ONLY}, {@code false} otherwise.
         */
        public boolean isTeamOnly() {
            return this.tag == Tag.TEAM_ONLY;
        }

        /**
         * Access is allowed for the shared link's owner only.
         */
        private static final SharedLinkAccessFailureReason OWNER_ONLY_INSTANCE = new SharedLinkAccessFailureReason(Tag.OWNER_ONLY);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#OWNER_ONLY}.
         *
         * <p> Access is allowed for the shared link's owner only. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#OWNER_ONLY}.
         */
        public static SharedLinkAccessFailureReason ownerOnly() {
            return SharedLinkAccessFailureReason.OWNER_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#OWNER_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#OWNER_ONLY}, {@code false} otherwise.
         */
        public boolean isOwnerOnly() {
            return this.tag == Tag.OWNER_ONLY;
        }

        /**
         * An unknown accessibility failure.
         */
        private static final SharedLinkAccessFailureReason OTHER_INSTANCE = new SharedLinkAccessFailureReason(Tag.OTHER);

        /**
         * Returns an instance of {@code SharedLinkAccessFailureReason} that has
         * its tag set to {@link Tag#OTHER}.
         *
         * <p> An unknown accessibility failure. </p>
         *
         * @return Instance of {@code SharedLinkAccessFailureReason} with its
         *     tag set to {@link Tag#OTHER}.
         */
        public static SharedLinkAccessFailureReason other() {
            return SharedLinkAccessFailureReason.OTHER_INSTANCE;
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

        private SharedLinkAccessFailureReason(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case LOGIN_REQUIRED:
                case EMAIL_VERIFY_REQUIRED:
                case PASSWORD_REQUIRED:
                case TEAM_ONLY:
                case OWNER_ONLY:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharedLinkAccessFailureReason> _writer = new JsonWriter<SharedLinkAccessFailureReason>()
        {
            public final void write(SharedLinkAccessFailureReason x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case LOGIN_REQUIRED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("login_required");
                        g.writeEndObject();
                        break;
                    case EMAIL_VERIFY_REQUIRED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_verify_required");
                        g.writeEndObject();
                        break;
                    case PASSWORD_REQUIRED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("password_required");
                        g.writeEndObject();
                        break;
                    case TEAM_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_only");
                        g.writeEndObject();
                        break;
                    case OWNER_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("owner_only");
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
        public static final JsonReader<SharedLinkAccessFailureReason> _reader = new JsonReader<SharedLinkAccessFailureReason>()
        {
            public final SharedLinkAccessFailureReason read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharedLinkAccessFailureReason.other(); }
                    switch (tag) {
                        case LOGIN_REQUIRED: return SharedLinkAccessFailureReason.loginRequired();
                        case EMAIL_VERIFY_REQUIRED: return SharedLinkAccessFailureReason.emailVerifyRequired();
                        case PASSWORD_REQUIRED: return SharedLinkAccessFailureReason.passwordRequired();
                        case TEAM_ONLY: return SharedLinkAccessFailureReason.teamOnly();
                        case OWNER_ONLY: return SharedLinkAccessFailureReason.ownerOnly();
                        case OTHER: return SharedLinkAccessFailureReason.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedLinkAccessFailureReason value = null;
                if (tag != null) {
                    switch (tag) {
                        case LOGIN_REQUIRED: {
                            value = SharedLinkAccessFailureReason.loginRequired();
                            break;
                        }
                        case EMAIL_VERIFY_REQUIRED: {
                            value = SharedLinkAccessFailureReason.emailVerifyRequired();
                            break;
                        }
                        case PASSWORD_REQUIRED: {
                            value = SharedLinkAccessFailureReason.passwordRequired();
                            break;
                        }
                        case TEAM_ONLY: {
                            value = SharedLinkAccessFailureReason.teamOnly();
                            break;
                        }
                        case OWNER_ONLY: {
                            value = SharedLinkAccessFailureReason.ownerOnly();
                            break;
                        }
                        case OTHER: {
                            value = SharedLinkAccessFailureReason.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharedLinkAccessFailureReason.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("login_required", Tag.LOGIN_REQUIRED);
            _values.put("email_verify_required", Tag.EMAIL_VERIFY_REQUIRED);
            _values.put("password_required", Tag.PASSWORD_REQUIRED);
            _values.put("team_only", Tag.TEAM_ONLY);
            _values.put("owner_only", Tag.OWNER_ONLY);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharedLinkAccessFailureReason." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedLinkAccessFailureReason." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedLinkAccessFailureReason fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class LinkPermissions {
        // struct LinkPermissions
        /**
         * The current visibility of the link after considering the shared links
         * policies of the the team (in case the link's owner is part of a team)
         * and the shared folder (in case the linked file is part of a shared
         * folder). This field is shown only if the caller has access to this
         * info (the link's owner always has access to this data).
         */
        public final ResolvedVisibility resolvedVisibility;
        /**
         * The shared link's requested visibility. This can be overridden by the
         * team and shared folder policies. The final visibility, after
         * considering these policies, can be found in {@link
         * LinkPermissions#resolvedVisibility}. This is shown only if the caller
         * is the link's owner.
         */
        public final RequestedVisibility requestedVisibility;
        /**
         * Whether the caller can revoke the shared link
         */
        public final boolean canRevoke;
        /**
         * The failure reason for revoking the link. This field will only be
         * present if the {@link LinkPermissions#canRevoke} is {@code false}.
         */
        public final SharedLinkAccessFailureReason revokeFailureReason;

        /**
         *
         * @param canRevoke  Whether the caller can revoke the shared link.
         * @param requestedVisibility  The shared link's requested visibility.
         *     This can be overridden by the team and shared folder policies.
         *     The final visibility, after considering these policies, can be
         *     found in {@code resolvedVisibility}. This is shown only if the
         *     caller is the link's owner.
         * @param revokeFailureReason  The failure reason for revoking the link.
         *     This field will only be present if the {@code canRevoke} is
         *     {@code false}.
         * @param resolvedVisibility  The current visibility of the link after
         *     considering the shared links policies of the the team (in case
         *     the link's owner is part of a team) and the shared folder (in
         *     case the linked file is part of a shared folder). This field is
         *     shown only if the caller has access to this info (the link's
         *     owner always has access to this data).
         */
        public LinkPermissions(boolean canRevoke, ResolvedVisibility resolvedVisibility, RequestedVisibility requestedVisibility, SharedLinkAccessFailureReason revokeFailureReason) {
            this.resolvedVisibility = resolvedVisibility;
            this.requestedVisibility = requestedVisibility;
            this.canRevoke = canRevoke;
            this.revokeFailureReason = revokeFailureReason;
        }

        static final JsonWriter<LinkPermissions> _writer = new JsonWriter<LinkPermissions>()
        {
            public final void write(LinkPermissions x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                LinkPermissions._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(LinkPermissions x, JsonGenerator g)
             throws IOException
            {
                if (x.resolvedVisibility != null) {
                    g.writeFieldName("resolved_visibility");
                    ResolvedVisibility._writer.write(x.resolvedVisibility, g);
                }
                if (x.requestedVisibility != null) {
                    g.writeFieldName("requested_visibility");
                    RequestedVisibility._writer.write(x.requestedVisibility, g);
                }
                g.writeBooleanField("can_revoke", x.canRevoke);
                if (x.revokeFailureReason != null) {
                    g.writeFieldName("revoke_failure_reason");
                    SharedLinkAccessFailureReason._writer.write(x.revokeFailureReason, g);
                }
            }
        };

        public static final JsonReader<LinkPermissions> _reader = new JsonReader<LinkPermissions>() {

            public final LinkPermissions read(JsonParser parser)
                throws IOException, JsonReadException
            {
                LinkPermissions result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final LinkPermissions readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                Boolean canRevoke = null;
                ResolvedVisibility resolvedVisibility = null;
                RequestedVisibility requestedVisibility = null;
                SharedLinkAccessFailureReason revokeFailureReason = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("can_revoke".equals(fieldName)) {
                        canRevoke = JsonReader.BooleanReader
                            .readField(parser, "can_revoke", canRevoke);
                    }
                    else if ("resolved_visibility".equals(fieldName)) {
                        resolvedVisibility = ResolvedVisibility._reader
                            .readField(parser, "resolved_visibility", resolvedVisibility);
                    }
                    else if ("requested_visibility".equals(fieldName)) {
                        requestedVisibility = RequestedVisibility._reader
                            .readField(parser, "requested_visibility", requestedVisibility);
                    }
                    else if ("revoke_failure_reason".equals(fieldName)) {
                        revokeFailureReason = SharedLinkAccessFailureReason._reader
                            .readField(parser, "revoke_failure_reason", revokeFailureReason);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (canRevoke == null) {
                    throw new JsonReadException("Required field \"can_revoke\" is missing.", parser.getTokenLocation());
                }
                return new LinkPermissions(canRevoke, resolvedVisibility, requestedVisibility, revokeFailureReason);
            }
        };

        public String toString() {
            return "LinkPermissions." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "LinkPermissions." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static LinkPermissions fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * Information about a team member.
     */
    public static class TeamMemberInfo {
        // struct TeamMemberInfo
        /**
         * Information about the member's team
         */
        public final DbxUsers.Team teamInfo;
        /**
         * The display name of the user.
         */
        public final String displayName;
        /**
         * ID of user as a member of a team. This field will only be present if
         * the member is in the same team as current user.
         */
        public final String memberId;

        /**
         * Information about a team member.
         *
         * @param displayName  The display name of the user. {@code displayName}
         *     must not be {@code null}.
         * @param teamInfo  Information about the member's team. {@code
         *     teamInfo} must not be {@code null}.
         * @param memberId  ID of user as a member of a team. This field will
         *     only be present if the member is in the same team as current
         *     user.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public TeamMemberInfo(DbxUsers.Team teamInfo, String displayName, String memberId) {
            this.teamInfo = teamInfo;
            if (teamInfo == null) {
                throw new IllegalArgumentException("Required value for 'teamInfo' is null");
            }
            this.displayName = displayName;
            if (displayName == null) {
                throw new IllegalArgumentException("Required value for 'displayName' is null");
            }
            this.memberId = memberId;
        }

        static final JsonWriter<TeamMemberInfo> _writer = new JsonWriter<TeamMemberInfo>()
        {
            public final void write(TeamMemberInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                TeamMemberInfo._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(TeamMemberInfo x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("team_info");
                DbxUsers.Team._writer.write(x.teamInfo, g);
                g.writeStringField("display_name", x.displayName);
                if (x.memberId != null) {
                    g.writeFieldName("member_id");
                    g.writeString(x.memberId);
                }
            }
        };

        public static final JsonReader<TeamMemberInfo> _reader = new JsonReader<TeamMemberInfo>() {

            public final TeamMemberInfo read(JsonParser parser)
                throws IOException, JsonReadException
            {
                TeamMemberInfo result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final TeamMemberInfo readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                DbxUsers.Team teamInfo = null;
                String displayName = null;
                String memberId = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("team_info".equals(fieldName)) {
                        teamInfo = DbxUsers.Team._reader
                            .readField(parser, "team_info", teamInfo);
                    }
                    else if ("display_name".equals(fieldName)) {
                        displayName = JsonReader.StringReader
                            .readField(parser, "display_name", displayName);
                    }
                    else if ("member_id".equals(fieldName)) {
                        memberId = JsonReader.StringReader
                            .readField(parser, "member_id", memberId);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (teamInfo == null) {
                    throw new JsonReadException("Required field \"team_info\" is missing.", parser.getTokenLocation());
                }
                if (displayName == null) {
                    throw new JsonReadException("Required field \"display_name\" is missing.", parser.getTokenLocation());
                }
                return new TeamMemberInfo(teamInfo, displayName, memberId);
            }
        };

        public String toString() {
            return "TeamMemberInfo." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "TeamMemberInfo." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static TeamMemberInfo fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * The metadata of a shared link
     */
    public static class SharedLinkMetadata {
        // struct SharedLinkMetadata
        /**
         * URL of the shared link.
         */
        public final String url;
        /**
         * A unique identifier for the linked file.
         */
        public final String id;
        /**
         * The linked file name (including extension). This never contains a
         * slash.
         */
        public final String name;
        /**
         * Expiration time, if set. By default the link won't expire.
         */
        public final java.util.Date expires;
        /**
         * The lowercased full path in the user's Dropbox. This always starts
         * with a slash. This field will only be present only if the linked file
         * is in the authenticated user's  dropbox.
         */
        public final String pathLower;
        /**
         * The link's access permissions.
         */
        public final LinkPermissions linkPermissions;
        /**
         * The team membership information of the link's owner.  This field will
         * only be present  if the link's owner is a team member.
         */
        public final TeamMemberInfo teamMemberInfo;
        /**
         * The team information of the content's owner. This field will only be
         * present if the content's owner is a team member and the content's
         * owner team is different from the link's owner team.
         */
        public final DbxUsers.Team contentOwnerTeamInfo;

        /**
         * The metadata of a shared link
         *
         * @param name  The linked file name (including extension). This never
         *     contains a slash. {@code name} must not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param contentOwnerTeamInfo  The team information of the content's
         *     owner. This field will only be present if the content's owner is
         *     a team member and the content's owner team is different from the
         *     link's owner team.
         * @param linkPermissions  The link's access permissions. {@code
         *     linkPermissions} must not be {@code null}.
         * @param teamMemberInfo  The team membership information of the link's
         *     owner.  This field will only be present  if the link's owner is a
         *     team member.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         * @param id  A unique identifier for the linked file. {@code id} must
         *     have length of at least 1.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will only be present
         *     only if the linked file is in the authenticated user's  dropbox.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SharedLinkMetadata(String url, String name, LinkPermissions linkPermissions, String id, java.util.Date expires, String pathLower, TeamMemberInfo teamMemberInfo, DbxUsers.Team contentOwnerTeamInfo) {
            this.url = url;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.id = id;
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.name = name;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.expires = expires;
            this.pathLower = pathLower;
            this.linkPermissions = linkPermissions;
            if (linkPermissions == null) {
                throw new IllegalArgumentException("Required value for 'linkPermissions' is null");
            }
            this.teamMemberInfo = teamMemberInfo;
            this.contentOwnerTeamInfo = contentOwnerTeamInfo;
        }
        public JsonWriter getWriter() {
            return SharedLinkMetadata._writer;
        }

        static final JsonWriter<SharedLinkMetadata> _writer = new JsonWriter<SharedLinkMetadata>()
        {
            public final void write(SharedLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                SharedLinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SharedLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("url", x.url);
                if (x.id != null) {
                    g.writeFieldName("id");
                    g.writeString(x.id);
                }
                g.writeStringField("name", x.name);
                if (x.expires != null) {
                    g.writeFieldName("expires");
                    writeDateIso(x.expires, g);
                }
                if (x.pathLower != null) {
                    g.writeFieldName("path_lower");
                    g.writeString(x.pathLower);
                }
                g.writeFieldName("link_permissions");
                LinkPermissions._writer.write(x.linkPermissions, g);
                if (x.teamMemberInfo != null) {
                    g.writeFieldName("team_member_info");
                    TeamMemberInfo._writer.write(x.teamMemberInfo, g);
                }
                if (x.contentOwnerTeamInfo != null) {
                    g.writeFieldName("content_owner_team_info");
                    DbxUsers.Team._writer.write(x.contentOwnerTeamInfo, g);
                }
            }
        };

        public static final JsonReader<SharedLinkMetadata> _reader = new JsonReader<SharedLinkMetadata>() {

            public final SharedLinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SharedLinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharedLinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null && tags.length > 0) {
                    if ("file".equals(tags[0])) {
                        return FileLinkMetadata._reader.readFromTags(tags, parser);
                    }
                    if ("folder".equals(tags[0])) {
                        return FolderLinkMetadata._reader.readFromTags(tags, parser);
                    }
                    // If no match, fall back to base class
                }
                return readFields(parser);
            }

            public final SharedLinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                String name = null;
                LinkPermissions linkPermissions = null;
                String id = null;
                java.util.Date expires = null;
                String pathLower = null;
                TeamMemberInfo teamMemberInfo = null;
                DbxUsers.Team contentOwnerTeamInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("link_permissions".equals(fieldName)) {
                        linkPermissions = LinkPermissions._reader
                            .readField(parser, "link_permissions", linkPermissions);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else if ("team_member_info".equals(fieldName)) {
                        teamMemberInfo = TeamMemberInfo._reader
                            .readField(parser, "team_member_info", teamMemberInfo);
                    }
                    else if ("content_owner_team_info".equals(fieldName)) {
                        contentOwnerTeamInfo = DbxUsers.Team._reader
                            .readField(parser, "content_owner_team_info", contentOwnerTeamInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (linkPermissions == null) {
                    throw new JsonReadException("Required field \"link_permissions\" is missing.", parser.getTokenLocation());
                }
                return new SharedLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
            }
        };

        public String toString() {
            return "SharedLinkMetadata." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "SharedLinkMetadata." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static SharedLinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * The metadata of a file shared link
     */
    public static class FileLinkMetadata extends SharedLinkMetadata  {
        // struct FileLinkMetadata
        /**
         * The modification time set by the desktop client when the file was
         * added to Dropbox. Since this time is not verified (the Dropbox server
         * stores whatever the desktop client sends up), this should only be
         * used for display purposes (such as sorting) and not, for example, to
         * determine if a file has changed or not.
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
         * The metadata of a file shared link
         *
         * @param name  The linked file name (including extension). This never
         *     contains a slash. {@code name} must not be {@code null}.
         * @param rev  A unique identifier for the current revision of a file.
         *     This field is the same rev as elsewhere in the API and can be
         *     used to detect changes and avoid conflicts. {@code rev} must have
         *     length of at least 9, match pattern "{@code [0-9a-f]+}", and not
         *     be {@code null}.
         * @param contentOwnerTeamInfo  The team information of the content's
         *     owner. This field will only be present if the content's owner is
         *     a team member and the content's owner team is different from the
         *     link's owner team.
         * @param linkPermissions  The link's access permissions. {@code
         *     linkPermissions} must not be {@code null}.
         * @param teamMemberInfo  The team membership information of the link's
         *     owner.  This field will only be present  if the link's owner is a
         *     team member.
         * @param clientModified  The modification time set by the desktop
         *     client when the file was added to Dropbox. Since this time is not
         *     verified (the Dropbox server stores whatever the desktop client
         *     sends up), this should only be used for display purposes (such as
         *     sorting) and not, for example, to determine if a file has changed
         *     or not. {@code clientModified} must not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         * @param serverModified  The last time the file was modified on
         *     Dropbox. {@code serverModified} must not be {@code null}.
         * @param id  A unique identifier for the linked file. {@code id} must
         *     have length of at least 1.
         * @param size  The file size in bytes.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will only be present
         *     only if the linked file is in the authenticated user's  dropbox.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FileLinkMetadata(String url, String name, LinkPermissions linkPermissions, java.util.Date clientModified, java.util.Date serverModified, String rev, long size, String id, java.util.Date expires, String pathLower, TeamMemberInfo teamMemberInfo, DbxUsers.Team contentOwnerTeamInfo) {
            super(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
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
        }
        public JsonWriter getWriter() {
            return FileLinkMetadata._writer;
        }

        static final JsonWriter<FileLinkMetadata> _writer = new JsonWriter<FileLinkMetadata>()
        {
            public final void write(FileLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "file");
                SharedLinkMetadata._writer.writeFields(x, g);
                FileLinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FileLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("client_modified");
                writeDateIso(x.clientModified, g);
                g.writeFieldName("server_modified");
                writeDateIso(x.serverModified, g);
                g.writeStringField("rev", x.rev);
                g.writeNumberField("size", x.size);
            }
        };

        public static final JsonReader<FileLinkMetadata> _reader = new JsonReader<FileLinkMetadata>() {

            public final FileLinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FileLinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FileLinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "file".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final FileLinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                String name = null;
                LinkPermissions linkPermissions = null;
                java.util.Date clientModified = null;
                java.util.Date serverModified = null;
                String rev = null;
                Long size = null;
                String id = null;
                java.util.Date expires = null;
                String pathLower = null;
                TeamMemberInfo teamMemberInfo = null;
                DbxUsers.Team contentOwnerTeamInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("link_permissions".equals(fieldName)) {
                        linkPermissions = LinkPermissions._reader
                            .readField(parser, "link_permissions", linkPermissions);
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
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else if ("team_member_info".equals(fieldName)) {
                        teamMemberInfo = TeamMemberInfo._reader
                            .readField(parser, "team_member_info", teamMemberInfo);
                    }
                    else if ("content_owner_team_info".equals(fieldName)) {
                        contentOwnerTeamInfo = DbxUsers.Team._reader
                            .readField(parser, "content_owner_team_info", contentOwnerTeamInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (linkPermissions == null) {
                    throw new JsonReadException("Required field \"link_permissions\" is missing.", parser.getTokenLocation());
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
                return new FileLinkMetadata(url, name, linkPermissions, clientModified, serverModified, rev, size, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
            }
        };

        public String toString() {
            return "FileLinkMetadata." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "FileLinkMetadata." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static FileLinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * The metadata of a folder shared link
     */
    public static class FolderLinkMetadata extends SharedLinkMetadata  {
        // struct FolderLinkMetadata

        /**
         * The metadata of a folder shared link
         *
         * @param name  The linked file name (including extension). This never
         *     contains a slash. {@code name} must not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param contentOwnerTeamInfo  The team information of the content's
         *     owner. This field will only be present if the content's owner is
         *     a team member and the content's owner team is different from the
         *     link's owner team.
         * @param linkPermissions  The link's access permissions. {@code
         *     linkPermissions} must not be {@code null}.
         * @param teamMemberInfo  The team membership information of the link's
         *     owner.  This field will only be present  if the link's owner is a
         *     team member.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         * @param id  A unique identifier for the linked file. {@code id} must
         *     have length of at least 1.
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will only be present
         *     only if the linked file is in the authenticated user's  dropbox.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FolderLinkMetadata(String url, String name, LinkPermissions linkPermissions, String id, java.util.Date expires, String pathLower, TeamMemberInfo teamMemberInfo, DbxUsers.Team contentOwnerTeamInfo) {
            super(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
        }
        public JsonWriter getWriter() {
            return FolderLinkMetadata._writer;
        }

        static final JsonWriter<FolderLinkMetadata> _writer = new JsonWriter<FolderLinkMetadata>()
        {
            public final void write(FolderLinkMetadata x, JsonGenerator g)
             throws IOException
            {
                JsonWriter w = x.getWriter();
                if (w != this) {
                    w.write(x, g);
                    return;
                }
                g.writeStartObject();
                g.writeStringField(".tag", "folder");
                SharedLinkMetadata._writer.writeFields(x, g);
                FolderLinkMetadata._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(FolderLinkMetadata x, JsonGenerator g)
             throws IOException
            {
            }
        };

        public static final JsonReader<FolderLinkMetadata> _reader = new JsonReader<FolderLinkMetadata>() {

            public final FolderLinkMetadata read(JsonParser parser)
                throws IOException, JsonReadException
            {
                FolderLinkMetadata result;
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                result = readFromTags(tags, parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final FolderLinkMetadata readFromTags(String[] tags, JsonParser parser)
                throws IOException, JsonReadException
            {
                if (tags != null) {
                    assert tags.length >= 1;
                    assert "folder".equals(tags[0]);
                }
                return readFields(parser);
            }

            public final FolderLinkMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                String name = null;
                LinkPermissions linkPermissions = null;
                String id = null;
                java.util.Date expires = null;
                String pathLower = null;
                TeamMemberInfo teamMemberInfo = null;
                DbxUsers.Team contentOwnerTeamInfo = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("name".equals(fieldName)) {
                        name = JsonReader.StringReader
                            .readField(parser, "name", name);
                    }
                    else if ("link_permissions".equals(fieldName)) {
                        linkPermissions = LinkPermissions._reader
                            .readField(parser, "link_permissions", linkPermissions);
                    }
                    else if ("id".equals(fieldName)) {
                        id = JsonReader.StringReader
                            .readField(parser, "id", id);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else if ("path_lower".equals(fieldName)) {
                        pathLower = JsonReader.StringReader
                            .readField(parser, "path_lower", pathLower);
                    }
                    else if ("team_member_info".equals(fieldName)) {
                        teamMemberInfo = TeamMemberInfo._reader
                            .readField(parser, "team_member_info", teamMemberInfo);
                    }
                    else if ("content_owner_team_info".equals(fieldName)) {
                        contentOwnerTeamInfo = DbxUsers.Team._reader
                            .readField(parser, "content_owner_team_info", contentOwnerTeamInfo);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (name == null) {
                    throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
                }
                if (linkPermissions == null) {
                    throw new JsonReadException("Required field \"link_permissions\" is missing.", parser.getTokenLocation());
                }
                return new FolderLinkMetadata(url, name, linkPermissions, id, expires, pathLower, teamMemberInfo, contentOwnerTeamInfo);
            }
        };

        public String toString() {
            return "FolderLinkMetadata." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "FolderLinkMetadata." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static FolderLinkMetadata fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class SharedLinkError {
        // union SharedLinkError

        /**
         * The discriminating tag type for {@link SharedLinkError}.
         */
        public enum Tag {
            /**
             * The shared link wasn't found
             */
            SHARED_LINK_NOT_FOUND,
            /**
             * The caller is not allowed to access this shared link
             */
            SHARED_LINK_ACCESS_DENIED,
            /**
             * An unspecified error
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
         * handle this {@code SharedLinkError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The shared link wasn't found
         */
        private static final SharedLinkError SHARED_LINK_NOT_FOUND_INSTANCE = new SharedLinkError(Tag.SHARED_LINK_NOT_FOUND);

        /**
         * Returns an instance of {@code SharedLinkError} that has its tag set
         * to {@link Tag#SHARED_LINK_NOT_FOUND}.
         *
         * <p> The shared link wasn't found </p>
         *
         * @return Instance of {@code SharedLinkError} with its tag set to
         *     {@link Tag#SHARED_LINK_NOT_FOUND}.
         */
        public static SharedLinkError sharedLinkNotFound() {
            return SharedLinkError.SHARED_LINK_NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isSharedLinkNotFound() {
            return this.tag == Tag.SHARED_LINK_NOT_FOUND;
        }

        /**
         * The caller is not allowed to access this shared link
         */
        private static final SharedLinkError SHARED_LINK_ACCESS_DENIED_INSTANCE = new SharedLinkError(Tag.SHARED_LINK_ACCESS_DENIED);

        /**
         * Returns an instance of {@code SharedLinkError} that has its tag set
         * to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         *
         * <p> The caller is not allowed to access this shared link </p>
         *
         * @return Instance of {@code SharedLinkError} with its tag set to
         *     {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         */
        public static SharedLinkError sharedLinkAccessDenied() {
            return SharedLinkError.SHARED_LINK_ACCESS_DENIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         */
        public boolean isSharedLinkAccessDenied() {
            return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
        }

        /**
         * An unspecified error
         */
        private static final SharedLinkError OTHER_INSTANCE = new SharedLinkError(Tag.OTHER);

        /**
         * Returns an instance of {@code SharedLinkError} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> An unspecified error </p>
         *
         * @return Instance of {@code SharedLinkError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static SharedLinkError other() {
            return SharedLinkError.OTHER_INSTANCE;
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

        private SharedLinkError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case SHARED_LINK_NOT_FOUND:
                case SHARED_LINK_ACCESS_DENIED:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharedLinkError> _writer = new JsonWriter<SharedLinkError>()
        {
            public final void write(SharedLinkError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case SHARED_LINK_NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_not_found");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_ACCESS_DENIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_access_denied");
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
        public static final JsonReader<SharedLinkError> _reader = new JsonReader<SharedLinkError>()
        {
            public final SharedLinkError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharedLinkError.other(); }
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: return SharedLinkError.sharedLinkNotFound();
                        case SHARED_LINK_ACCESS_DENIED: return SharedLinkError.sharedLinkAccessDenied();
                        case OTHER: return SharedLinkError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedLinkError value = null;
                if (tag != null) {
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: {
                            value = SharedLinkError.sharedLinkNotFound();
                            break;
                        }
                        case SHARED_LINK_ACCESS_DENIED: {
                            value = SharedLinkError.sharedLinkAccessDenied();
                            break;
                        }
                        case OTHER: {
                            value = SharedLinkError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharedLinkError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("shared_link_not_found", Tag.SHARED_LINK_NOT_FOUND);
            _values.put("shared_link_access_denied", Tag.SHARED_LINK_ACCESS_DENIED);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharedLinkError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedLinkError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedLinkError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class ListSharedLinksArg {
        // struct ListSharedLinksArg
        /**
         * See {@link DbxSharing#listSharedLinksBuilder} description.
         */
        public final String path;
        /**
         * The cursor returned by your last call to {@link
         * DbxSharing#listSharedLinksBuilder}.
         */
        public final String cursor;

        /**
         *
         * @param path  See {@link DbxSharing#listSharedLinksBuilder}
         *     description. {@code path} must match pattern "{@code
         *     ((/|id:).*)|(rev:[0-9a-f]{9,})}".
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxSharing#listSharedLinksBuilder}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListSharedLinksArg(String path, String cursor) {
            this.path = path;
            if (path != null) {
                if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                    throw new IllegalArgumentException("String 'path' does not match pattern");
                }
            }
            this.cursor = cursor;
        }

        static final JsonWriter<ListSharedLinksArg> _writer = new JsonWriter<ListSharedLinksArg>()
        {
            public final void write(ListSharedLinksArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListSharedLinksArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListSharedLinksArg x, JsonGenerator g)
             throws IOException
            {
                if (x.path != null) {
                    g.writeFieldName("path");
                    g.writeString(x.path);
                }
                if (x.cursor != null) {
                    g.writeFieldName("cursor");
                    g.writeString(x.cursor);
                }
            }
        };

        public static final JsonReader<ListSharedLinksArg> _reader = new JsonReader<ListSharedLinksArg>() {

            public final ListSharedLinksArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListSharedLinksArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListSharedLinksArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new ListSharedLinksArg(path, cursor);
            }
        };

        public String toString() {
            return "ListSharedLinksArg." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ListSharedLinksArg." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ListSharedLinksArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class ListSharedLinksResult {
        // struct ListSharedLinksResult
        /**
         * Shared links applicable to the path argument.
         */
        public final java.util.List<SharedLinkMetadata> links;
        /**
         * Is true if there are additional shared links that have not been
         * returned yet. Pass the cursor into {@link
         * DbxSharing#listSharedLinksBuilder} to retrieve them.
         */
        public final boolean hasMore;
        /**
         * Pass the cursor into {@link DbxSharing#listSharedLinksBuilder} to
         * obtain the additional links. Cursor is returned only if no path is
         * given or the path is empty.
         */
        public final String cursor;

        /**
         *
         * @param hasMore  Is true if there are additional shared links that
         *     have not been returned yet. Pass the cursor into {@link
         *     DbxSharing#listSharedLinksBuilder} to retrieve them.
         * @param cursor  Pass the cursor into {@link
         *     DbxSharing#listSharedLinksBuilder} to obtain the additional
         *     links. Cursor is returned only if no path is given or the path is
         *     empty.
         * @param links  Shared links applicable to the path argument. {@code
         *     links} must not contain a {@code null} item and not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListSharedLinksResult(java.util.List<SharedLinkMetadata> links, boolean hasMore, String cursor) {
            this.links = links;
            if (links == null) {
                throw new IllegalArgumentException("Required value for 'links' is null");
            }
            for (SharedLinkMetadata x : links) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'links' is null");
                }
            }
            this.hasMore = hasMore;
            this.cursor = cursor;
        }

        static final JsonWriter<ListSharedLinksResult> _writer = new JsonWriter<ListSharedLinksResult>()
        {
            public final void write(ListSharedLinksResult x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListSharedLinksResult._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListSharedLinksResult x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("links");
                g.writeStartArray();
                for (SharedLinkMetadata item: x.links) {
                    if (item != null) {
                        SharedLinkMetadata._writer.write(item, g);
                    }
                }
                g.writeEndArray();
                g.writeBooleanField("has_more", x.hasMore);
                if (x.cursor != null) {
                    g.writeFieldName("cursor");
                    g.writeString(x.cursor);
                }
            }
        };

        public static final JsonReader<ListSharedLinksResult> _reader = new JsonReader<ListSharedLinksResult>() {

            public final ListSharedLinksResult read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListSharedLinksResult result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListSharedLinksResult readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.List<SharedLinkMetadata> links = null;
                Boolean hasMore = null;
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("links".equals(fieldName)) {
                        links = JsonArrayReader.mk(SharedLinkMetadata._reader)
                            .readField(parser, "links", links);
                    }
                    else if ("has_more".equals(fieldName)) {
                        hasMore = JsonReader.BooleanReader
                            .readField(parser, "has_more", hasMore);
                    }
                    else if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (links == null) {
                    throw new JsonReadException("Required field \"links\" is missing.", parser.getTokenLocation());
                }
                if (hasMore == null) {
                    throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
                }
                return new ListSharedLinksResult(links, hasMore, cursor);
            }
        };

        public String toString() {
            return "ListSharedLinksResult." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ListSharedLinksResult." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ListSharedLinksResult fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListSharedLinksError {
        // union ListSharedLinksError

        /**
         * The discriminating tag type for {@link ListSharedLinksError}.
         */
        public enum Tag {
            PATH,  // LookupError
            /**
             * Indicates that the cursor has been invalidated. Call {@link
             * DbxSharing#listSharedLinksBuilder} to obtain a new cursor.
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
         * handle this {@code ListSharedLinksError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final DbxFiles.LookupError pathValue;

        private ListSharedLinksError(Tag tag, DbxFiles.LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link DbxFiles.LookupError} value associated with this
         *     instance if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public DbxFiles.LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code ListSharedLinksError} that has its tag
         * set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link DbxFiles.LookupError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ListSharedLinksError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ListSharedLinksError path(DbxFiles.LookupError value) {
            return new ListSharedLinksError(Tag.PATH, value);
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
         * DbxSharing#listSharedLinksBuilder} to obtain a new cursor.
         */
        private static final ListSharedLinksError RESET_INSTANCE = new ListSharedLinksError(Tag.RESET);

        /**
         * Returns an instance of {@code ListSharedLinksError} that has its tag
         * set to {@link Tag#RESET}.
         *
         * <p> Indicates that the cursor has been invalidated. Call {@link
         * DbxSharing#listSharedLinksBuilder} to obtain a new cursor. </p>
         *
         * @return Instance of {@code ListSharedLinksError} with its tag set to
         *     {@link Tag#RESET}.
         */
        public static ListSharedLinksError reset() {
            return ListSharedLinksError.RESET_INSTANCE;
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

        private static final ListSharedLinksError OTHER_INSTANCE = new ListSharedLinksError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListSharedLinksError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListSharedLinksError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static ListSharedLinksError other() {
            return ListSharedLinksError.OTHER_INSTANCE;
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

        private ListSharedLinksError(Tag t) {
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

        static final JsonWriter<ListSharedLinksError> _writer = new JsonWriter<ListSharedLinksError>()
        {
            public final void write(ListSharedLinksError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        DbxFiles.LookupError._writer.write(x.pathValue, g);
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
        public static final JsonReader<ListSharedLinksError> _reader = new JsonReader<ListSharedLinksError>()
        {
            public final ListSharedLinksError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListSharedLinksError.other(); }
                    switch (tag) {
                        case RESET: return ListSharedLinksError.reset();
                        case OTHER: return ListSharedLinksError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListSharedLinksError value = null;
                if (tag != null) {
                    switch (tag) {
                        case PATH: {
                            DbxFiles.LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = DbxFiles.LookupError._reader
                                .readField(parser, "path", v);
                            value = ListSharedLinksError.path(v);
                            break;
                        }
                        case RESET: {
                            value = ListSharedLinksError.reset();
                            break;
                        }
                        case OTHER: {
                            value = ListSharedLinksError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListSharedLinksError.other(); }
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
            return "ListSharedLinksError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListSharedLinksError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListSharedLinksError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class SharedLinkSettings {
        // struct SharedLinkSettings
        /**
         * The requested access for this shared link.
         */
        public final RequestedVisibility requestedVisibility;
        /**
         * If {@link SharedLinkSettings#requestedVisibility} is {@link
         * RequestedVisibility#password} this is needed to specify the password
         * to access the link.
         */
        public final String linkPassword;
        /**
         * Expiration time of the shared link. By default the link won't expire.
         */
        public final java.util.Date expires;

        /**
         *
         * @param requestedVisibility  The requested access for this shared
         *     link.
         * @param expires  Expiration time of the shared link. By default the
         *     link won't expire.
         * @param linkPassword  If {@code requestedVisibility} is {@link
         *     RequestedVisibility#password} this is needed to specify the
         *     password to access the link.
         */
        public SharedLinkSettings(RequestedVisibility requestedVisibility, String linkPassword, java.util.Date expires) {
            this.requestedVisibility = requestedVisibility;
            this.linkPassword = linkPassword;
            this.expires = expires;
        }

        static final JsonWriter<SharedLinkSettings> _writer = new JsonWriter<SharedLinkSettings>()
        {
            public final void write(SharedLinkSettings x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SharedLinkSettings._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SharedLinkSettings x, JsonGenerator g)
             throws IOException
            {
                if (x.requestedVisibility != null) {
                    g.writeFieldName("requested_visibility");
                    RequestedVisibility._writer.write(x.requestedVisibility, g);
                }
                if (x.linkPassword != null) {
                    g.writeFieldName("link_password");
                    g.writeString(x.linkPassword);
                }
                if (x.expires != null) {
                    g.writeFieldName("expires");
                    writeDateIso(x.expires, g);
                }
            }
        };

        public static final JsonReader<SharedLinkSettings> _reader = new JsonReader<SharedLinkSettings>() {

            public final SharedLinkSettings read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SharedLinkSettings result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharedLinkSettings readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                RequestedVisibility requestedVisibility = null;
                String linkPassword = null;
                java.util.Date expires = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("requested_visibility".equals(fieldName)) {
                        requestedVisibility = RequestedVisibility._reader
                            .readField(parser, "requested_visibility", requestedVisibility);
                    }
                    else if ("link_password".equals(fieldName)) {
                        linkPassword = JsonReader.StringReader
                            .readField(parser, "link_password", linkPassword);
                    }
                    else if ("expires".equals(fieldName)) {
                        expires = JsonDateReader.DropboxV2
                            .readField(parser, "expires", expires);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                return new SharedLinkSettings(requestedVisibility, linkPassword, expires);
            }
        };

        public String toString() {
            return "SharedLinkSettings." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "SharedLinkSettings." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static SharedLinkSettings fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class ModifySharedLinkSettingsArgs {
        // struct ModifySharedLinkSettingsArgs
        /**
         * URL of the shared link to change its settings
         */
        public final String url;
        /**
         * Set of settings for the shared link.
         */
        public final SharedLinkSettings settings;

        /**
         *
         * @param settings  Set of settings for the shared link. {@code
         *     settings} must not be {@code null}.
         * @param url  URL of the shared link to change its settings. {@code
         *     url} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ModifySharedLinkSettingsArgs(String url, SharedLinkSettings settings) {
            this.url = url;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.settings = settings;
            if (settings == null) {
                throw new IllegalArgumentException("Required value for 'settings' is null");
            }
        }

        static final JsonWriter<ModifySharedLinkSettingsArgs> _writer = new JsonWriter<ModifySharedLinkSettingsArgs>()
        {
            public final void write(ModifySharedLinkSettingsArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ModifySharedLinkSettingsArgs._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ModifySharedLinkSettingsArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("url", x.url);
                g.writeFieldName("settings");
                SharedLinkSettings._writer.write(x.settings, g);
            }
        };

        public static final JsonReader<ModifySharedLinkSettingsArgs> _reader = new JsonReader<ModifySharedLinkSettingsArgs>() {

            public final ModifySharedLinkSettingsArgs read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ModifySharedLinkSettingsArgs result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ModifySharedLinkSettingsArgs readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String url = null;
                SharedLinkSettings settings = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("url".equals(fieldName)) {
                        url = JsonReader.StringReader
                            .readField(parser, "url", url);
                    }
                    else if ("settings".equals(fieldName)) {
                        settings = SharedLinkSettings._reader
                            .readField(parser, "settings", settings);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (url == null) {
                    throw new JsonReadException("Required field \"url\" is missing.", parser.getTokenLocation());
                }
                if (settings == null) {
                    throw new JsonReadException("Required field \"settings\" is missing.", parser.getTokenLocation());
                }
                return new ModifySharedLinkSettingsArgs(url, settings);
            }
        };

        public String toString() {
            return "ModifySharedLinkSettingsArgs." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ModifySharedLinkSettingsArgs." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ModifySharedLinkSettingsArgs fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class SharedLinkSettingsError {
        // union SharedLinkSettingsError

        /**
         * The discriminating tag type for {@link SharedLinkSettingsError}.
         */
        public enum Tag {
            /**
             * The given settings are invalid (for example, all attributes of
             * the {@link SharedLinkSettings} are empty, the requested
             * visibility is {@link RequestedVisibility#password} but the {@link
             * SharedLinkSettings#linkPassword} is missing, {@link
             * SharedLinkSettings#expires} is set to the past, etc.)
             */
            INVALID_SETTINGS,
            /**
             * User is not allowed to modify the settings of this link. Note
             * that basic users can only set {@link RequestedVisibility#public_}
             * as the {@link SharedLinkSettings#requestedVisibility} and cannot
             * set {@link SharedLinkSettings#expires}
             */
            NOT_AUTHORIZED
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
         * handle this {@code SharedLinkSettingsError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The given settings are invalid (for example, all attributes of the
         * {@link SharedLinkSettings} are empty, the requested visibility is
         * {@link RequestedVisibility#password} but the {@link
         * SharedLinkSettings#linkPassword} is missing, {@link
         * SharedLinkSettings#expires} is set to the past, etc.)
         */
        private static final SharedLinkSettingsError INVALID_SETTINGS_INSTANCE = new SharedLinkSettingsError(Tag.INVALID_SETTINGS);

        /**
         * Returns an instance of {@code SharedLinkSettingsError} that has its
         * tag set to {@link Tag#INVALID_SETTINGS}.
         *
         * <p> The given settings are invalid (for example, all attributes of
         * the {@link SharedLinkSettings} are empty, the requested visibility is
         * {@link RequestedVisibility#password} but the {@link
         * SharedLinkSettings#linkPassword} is missing, {@link
         * SharedLinkSettings#expires} is set to the past, etc.) </p>
         *
         * @return Instance of {@code SharedLinkSettingsError} with its tag set
         *     to {@link Tag#INVALID_SETTINGS}.
         */
        public static SharedLinkSettingsError invalidSettings() {
            return SharedLinkSettingsError.INVALID_SETTINGS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_SETTINGS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_SETTINGS}, {@code false} otherwise.
         */
        public boolean isInvalidSettings() {
            return this.tag == Tag.INVALID_SETTINGS;
        }

        /**
         * User is not allowed to modify the settings of this link. Note that
         * basic users can only set {@link RequestedVisibility#public_} as the
         * {@link SharedLinkSettings#requestedVisibility} and cannot set {@link
         * SharedLinkSettings#expires}
         */
        private static final SharedLinkSettingsError NOT_AUTHORIZED_INSTANCE = new SharedLinkSettingsError(Tag.NOT_AUTHORIZED);

        /**
         * Returns an instance of {@code SharedLinkSettingsError} that has its
         * tag set to {@link Tag#NOT_AUTHORIZED}.
         *
         * <p> User is not allowed to modify the settings of this link. Note
         * that basic users can only set {@link RequestedVisibility#public_} as
         * the {@link SharedLinkSettings#requestedVisibility} and cannot set
         * {@link SharedLinkSettings#expires} </p>
         *
         * @return Instance of {@code SharedLinkSettingsError} with its tag set
         *     to {@link Tag#NOT_AUTHORIZED}.
         */
        public static SharedLinkSettingsError notAuthorized() {
            return SharedLinkSettingsError.NOT_AUTHORIZED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_AUTHORIZED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_AUTHORIZED}, {@code false} otherwise.
         */
        public boolean isNotAuthorized() {
            return this.tag == Tag.NOT_AUTHORIZED;
        }

        private SharedLinkSettingsError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_SETTINGS:
                case NOT_AUTHORIZED:
                    break;
            }
        }

        static final JsonWriter<SharedLinkSettingsError> _writer = new JsonWriter<SharedLinkSettingsError>()
        {
            public final void write(SharedLinkSettingsError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case INVALID_SETTINGS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_settings");
                        g.writeEndObject();
                        break;
                    case NOT_AUTHORIZED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_authorized");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<SharedLinkSettingsError> _reader = new JsonReader<SharedLinkSettingsError>()
        {
            public final SharedLinkSettingsError read(JsonParser parser)
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
                        case INVALID_SETTINGS: return SharedLinkSettingsError.invalidSettings();
                        case NOT_AUTHORIZED: return SharedLinkSettingsError.notAuthorized();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedLinkSettingsError value = null;
                if (tag != null) {
                    switch (tag) {
                        case INVALID_SETTINGS: {
                            value = SharedLinkSettingsError.invalidSettings();
                            break;
                        }
                        case NOT_AUTHORIZED: {
                            value = SharedLinkSettingsError.notAuthorized();
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
            _values.put("invalid_settings", Tag.INVALID_SETTINGS);
            _values.put("not_authorized", Tag.NOT_AUTHORIZED);
        }

        public String toString() {
            return "SharedLinkSettingsError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedLinkSettingsError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static SharedLinkSettingsError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ModifySharedLinkSettingsError {
        // union ModifySharedLinkSettingsError

        /**
         * The discriminating tag type for {@link
         * ModifySharedLinkSettingsError}.
         */
        public enum Tag {
            /**
             * The shared link wasn't found
             */
            SHARED_LINK_NOT_FOUND,
            /**
             * The caller is not allowed to access this shared link
             */
            SHARED_LINK_ACCESS_DENIED,
            /**
             * An unspecified error
             */
            OTHER,
            /**
             * There is an error with the given settings
             */
            SETTINGS_ERROR,  // SharedLinkSettingsError
            /**
             * The caller's email should be verified
             */
            EMAIL_NOT_VERIFIED
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
         * handle this {@code ModifySharedLinkSettingsError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The shared link wasn't found
         */
        private static final ModifySharedLinkSettingsError SHARED_LINK_NOT_FOUND_INSTANCE = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_NOT_FOUND);

        /**
         * Returns an instance of {@code ModifySharedLinkSettingsError} that has
         * its tag set to {@link Tag#SHARED_LINK_NOT_FOUND}.
         *
         * <p> The shared link wasn't found </p>
         *
         * @return Instance of {@code ModifySharedLinkSettingsError} with its
         *     tag set to {@link Tag#SHARED_LINK_NOT_FOUND}.
         */
        public static ModifySharedLinkSettingsError sharedLinkNotFound() {
            return ModifySharedLinkSettingsError.SHARED_LINK_NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isSharedLinkNotFound() {
            return this.tag == Tag.SHARED_LINK_NOT_FOUND;
        }

        /**
         * The caller is not allowed to access this shared link
         */
        private static final ModifySharedLinkSettingsError SHARED_LINK_ACCESS_DENIED_INSTANCE = new ModifySharedLinkSettingsError(Tag.SHARED_LINK_ACCESS_DENIED);

        /**
         * Returns an instance of {@code ModifySharedLinkSettingsError} that has
         * its tag set to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         *
         * <p> The caller is not allowed to access this shared link </p>
         *
         * @return Instance of {@code ModifySharedLinkSettingsError} with its
         *     tag set to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         */
        public static ModifySharedLinkSettingsError sharedLinkAccessDenied() {
            return ModifySharedLinkSettingsError.SHARED_LINK_ACCESS_DENIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         */
        public boolean isSharedLinkAccessDenied() {
            return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
        }

        /**
         * An unspecified error
         */
        private static final ModifySharedLinkSettingsError OTHER_INSTANCE = new ModifySharedLinkSettingsError(Tag.OTHER);

        /**
         * Returns an instance of {@code ModifySharedLinkSettingsError} that has
         * its tag set to {@link Tag#OTHER}.
         *
         * <p> An unspecified error </p>
         *
         * @return Instance of {@code ModifySharedLinkSettingsError} with its
         *     tag set to {@link Tag#OTHER}.
         */
        public static ModifySharedLinkSettingsError other() {
            return ModifySharedLinkSettingsError.OTHER_INSTANCE;
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

        private final SharedLinkSettingsError settingsErrorValue;

        private ModifySharedLinkSettingsError(Tag tag, SharedLinkSettingsError value) {
            this.tag = tag;
            this.settingsErrorValue = value;
            validate();
        }

        /**
         * There is an error with the given settings
         *
         * <p> This instance must be tagged as {@link Tag#SETTINGS_ERROR}. </p>
         *
         * @return The {@link SharedLinkSettingsError} value associated with
         *     this instance if {@link #isSettingsError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isSettingsError} is {@code
         *     false}.
         */
        public SharedLinkSettingsError getSettingsErrorValue() {
            if (this.tag != Tag.SETTINGS_ERROR) {
                throw new IllegalStateException("getSettingsErrorValue() requires tag==SETTINGS_ERROR, actual tag==" + tag);
            }
            return settingsErrorValue;
        }

        /**
         * Returns an instance of {@code ModifySharedLinkSettingsError} that has
         * its tag set to {@link Tag#SETTINGS_ERROR}.
         *
         * <p> There is an error with the given settings </p>
         *
         * @param value  {@link SharedLinkSettingsError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ModifySharedLinkSettingsError} with its
         *     tag set to {@link Tag#SETTINGS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ModifySharedLinkSettingsError settingsError(SharedLinkSettingsError value) {
            return new ModifySharedLinkSettingsError(Tag.SETTINGS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SETTINGS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SETTINGS_ERROR}, {@code false} otherwise.
         */
        public boolean isSettingsError() {
            return this.tag == Tag.SETTINGS_ERROR;
        }

        /**
         * The caller's email should be verified
         */
        private static final ModifySharedLinkSettingsError EMAIL_NOT_VERIFIED_INSTANCE = new ModifySharedLinkSettingsError(Tag.EMAIL_NOT_VERIFIED);

        /**
         * Returns an instance of {@code ModifySharedLinkSettingsError} that has
         * its tag set to {@link Tag#EMAIL_NOT_VERIFIED}.
         *
         * <p> The caller's email should be verified </p>
         *
         * @return Instance of {@code ModifySharedLinkSettingsError} with its
         *     tag set to {@link Tag#EMAIL_NOT_VERIFIED}.
         */
        public static ModifySharedLinkSettingsError emailNotVerified() {
            return ModifySharedLinkSettingsError.EMAIL_NOT_VERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
         */
        public boolean isEmailNotVerified() {
            return this.tag == Tag.EMAIL_NOT_VERIFIED;
        }

        private ModifySharedLinkSettingsError(Tag t) {
            tag = t;
            settingsErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case SHARED_LINK_NOT_FOUND:
                case SHARED_LINK_ACCESS_DENIED:
                case OTHER:
                case EMAIL_NOT_VERIFIED:
                    break;
                case SETTINGS_ERROR:
                    if (this.settingsErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
            }
        }

        static final JsonWriter<ModifySharedLinkSettingsError> _writer = new JsonWriter<ModifySharedLinkSettingsError>()
        {
            public final void write(ModifySharedLinkSettingsError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case SHARED_LINK_NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_not_found");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_ACCESS_DENIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_access_denied");
                        g.writeEndObject();
                        break;
                    case OTHER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                    case SETTINGS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("settings_error");
                        g.writeFieldName("settings_error");
                        SharedLinkSettingsError._writer.write(x.settingsErrorValue, g);
                        g.writeEndObject();
                        break;
                    case EMAIL_NOT_VERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_not_verified");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<ModifySharedLinkSettingsError> _reader = new JsonReader<ModifySharedLinkSettingsError>()
        {
            public final ModifySharedLinkSettingsError read(JsonParser parser)
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
                        case SHARED_LINK_NOT_FOUND: return ModifySharedLinkSettingsError.sharedLinkNotFound();
                        case SHARED_LINK_ACCESS_DENIED: return ModifySharedLinkSettingsError.sharedLinkAccessDenied();
                        case OTHER: return ModifySharedLinkSettingsError.other();
                        case EMAIL_NOT_VERIFIED: return ModifySharedLinkSettingsError.emailNotVerified();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ModifySharedLinkSettingsError value = null;
                if (tag != null) {
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: {
                            value = ModifySharedLinkSettingsError.sharedLinkNotFound();
                            break;
                        }
                        case SHARED_LINK_ACCESS_DENIED: {
                            value = ModifySharedLinkSettingsError.sharedLinkAccessDenied();
                            break;
                        }
                        case OTHER: {
                            value = ModifySharedLinkSettingsError.other();
                            break;
                        }
                        case SETTINGS_ERROR: {
                            SharedLinkSettingsError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedLinkSettingsError._reader
                                .readField(parser, "settings_error", v);
                            value = ModifySharedLinkSettingsError.settingsError(v);
                            break;
                        }
                        case EMAIL_NOT_VERIFIED: {
                            value = ModifySharedLinkSettingsError.emailNotVerified();
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
            _values.put("settings_error", Tag.SETTINGS_ERROR);
            _values.put("email_not_verified", Tag.EMAIL_NOT_VERIFIED);
        }

        public String toString() {
            return "ModifySharedLinkSettingsError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ModifySharedLinkSettingsError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ModifySharedLinkSettingsError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class CreateSharedLinkWithSettingsArg {
        // struct CreateSharedLinkWithSettingsArg
        /**
         * The path to be shared by the shared link
         */
        public final String path;
        /**
         * The requested settings for the newly created shared link
         */
        public final SharedLinkSettings settings;

        /**
         *
         * @param path  The path to be shared by the shared link. {@code path}
         *     must match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and
         *     not be {@code null}.
         * @param settings  The requested settings for the newly created shared
         *     link.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public CreateSharedLinkWithSettingsArg(String path, SharedLinkSettings settings) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.settings = settings;
        }

        static final JsonWriter<CreateSharedLinkWithSettingsArg> _writer = new JsonWriter<CreateSharedLinkWithSettingsArg>()
        {
            public final void write(CreateSharedLinkWithSettingsArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                CreateSharedLinkWithSettingsArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(CreateSharedLinkWithSettingsArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("path", x.path);
                if (x.settings != null) {
                    g.writeFieldName("settings");
                    SharedLinkSettings._writer.write(x.settings, g);
                }
            }
        };

        public static final JsonReader<CreateSharedLinkWithSettingsArg> _reader = new JsonReader<CreateSharedLinkWithSettingsArg>() {

            public final CreateSharedLinkWithSettingsArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                CreateSharedLinkWithSettingsArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final CreateSharedLinkWithSettingsArg readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String path = null;
                SharedLinkSettings settings = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("path".equals(fieldName)) {
                        path = JsonReader.StringReader
                            .readField(parser, "path", path);
                    }
                    else if ("settings".equals(fieldName)) {
                        settings = SharedLinkSettings._reader
                            .readField(parser, "settings", settings);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (path == null) {
                    throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
                }
                return new CreateSharedLinkWithSettingsArg(path, settings);
            }
        };

        public String toString() {
            return "CreateSharedLinkWithSettingsArg." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "CreateSharedLinkWithSettingsArg." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static CreateSharedLinkWithSettingsArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class CreateSharedLinkWithSettingsError {
        // union CreateSharedLinkWithSettingsError

        /**
         * The discriminating tag type for {@link
         * CreateSharedLinkWithSettingsError}.
         */
        public enum Tag {
            PATH,  // LookupError
            /**
             * User's email should be verified
             */
            EMAIL_NOT_VERIFIED,
            /**
             * The shared link already exists
             */
            SHARED_LINK_ALREADY_EXISTS,
            /**
             * There is an error with the given settings
             */
            SETTINGS_ERROR,  // SharedLinkSettingsError
            /**
             * Access to the requested path is forbidden
             */
            ACCESS_DENIED
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
         * handle this {@code CreateSharedLinkWithSettingsError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final DbxFiles.LookupError pathValue;

        private CreateSharedLinkWithSettingsError(Tag tag, DbxFiles.LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            this.settingsErrorValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link DbxFiles.LookupError} value associated with this
         *     instance if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public DbxFiles.LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code CreateSharedLinkWithSettingsError} that
         * has its tag set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link DbxFiles.LookupError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code CreateSharedLinkWithSettingsError} with
         *     its tag set to {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static CreateSharedLinkWithSettingsError path(DbxFiles.LookupError value) {
            return new CreateSharedLinkWithSettingsError(Tag.PATH, value);
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
         * User's email should be verified
         */
        private static final CreateSharedLinkWithSettingsError EMAIL_NOT_VERIFIED_INSTANCE = new CreateSharedLinkWithSettingsError(Tag.EMAIL_NOT_VERIFIED);

        /**
         * Returns an instance of {@code CreateSharedLinkWithSettingsError} that
         * has its tag set to {@link Tag#EMAIL_NOT_VERIFIED}.
         *
         * <p> User's email should be verified </p>
         *
         * @return Instance of {@code CreateSharedLinkWithSettingsError} with
         *     its tag set to {@link Tag#EMAIL_NOT_VERIFIED}.
         */
        public static CreateSharedLinkWithSettingsError emailNotVerified() {
            return CreateSharedLinkWithSettingsError.EMAIL_NOT_VERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_NOT_VERIFIED}, {@code false} otherwise.
         */
        public boolean isEmailNotVerified() {
            return this.tag == Tag.EMAIL_NOT_VERIFIED;
        }

        /**
         * The shared link already exists
         */
        private static final CreateSharedLinkWithSettingsError SHARED_LINK_ALREADY_EXISTS_INSTANCE = new CreateSharedLinkWithSettingsError(Tag.SHARED_LINK_ALREADY_EXISTS);

        /**
         * Returns an instance of {@code CreateSharedLinkWithSettingsError} that
         * has its tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
         *
         * <p> The shared link already exists </p>
         *
         * @return Instance of {@code CreateSharedLinkWithSettingsError} with
         *     its tag set to {@link Tag#SHARED_LINK_ALREADY_EXISTS}.
         */
        public static CreateSharedLinkWithSettingsError sharedLinkAlreadyExists() {
            return CreateSharedLinkWithSettingsError.SHARED_LINK_ALREADY_EXISTS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_ALREADY_EXISTS}, {@code false} otherwise.
         */
        public boolean isSharedLinkAlreadyExists() {
            return this.tag == Tag.SHARED_LINK_ALREADY_EXISTS;
        }

        private final SharedLinkSettingsError settingsErrorValue;

        private CreateSharedLinkWithSettingsError(Tag tag, SharedLinkSettingsError value) {
            this.tag = tag;
            this.pathValue = null;
            this.settingsErrorValue = value;
            validate();
        }

        /**
         * There is an error with the given settings
         *
         * <p> This instance must be tagged as {@link Tag#SETTINGS_ERROR}. </p>
         *
         * @return The {@link SharedLinkSettingsError} value associated with
         *     this instance if {@link #isSettingsError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isSettingsError} is {@code
         *     false}.
         */
        public SharedLinkSettingsError getSettingsErrorValue() {
            if (this.tag != Tag.SETTINGS_ERROR) {
                throw new IllegalStateException("getSettingsErrorValue() requires tag==SETTINGS_ERROR, actual tag==" + tag);
            }
            return settingsErrorValue;
        }

        /**
         * Returns an instance of {@code CreateSharedLinkWithSettingsError} that
         * has its tag set to {@link Tag#SETTINGS_ERROR}.
         *
         * <p> There is an error with the given settings </p>
         *
         * @param value  {@link SharedLinkSettingsError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code CreateSharedLinkWithSettingsError} with
         *     its tag set to {@link Tag#SETTINGS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static CreateSharedLinkWithSettingsError settingsError(SharedLinkSettingsError value) {
            return new CreateSharedLinkWithSettingsError(Tag.SETTINGS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SETTINGS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SETTINGS_ERROR}, {@code false} otherwise.
         */
        public boolean isSettingsError() {
            return this.tag == Tag.SETTINGS_ERROR;
        }

        /**
         * Access to the requested path is forbidden
         */
        private static final CreateSharedLinkWithSettingsError ACCESS_DENIED_INSTANCE = new CreateSharedLinkWithSettingsError(Tag.ACCESS_DENIED);

        /**
         * Returns an instance of {@code CreateSharedLinkWithSettingsError} that
         * has its tag set to {@link Tag#ACCESS_DENIED}.
         *
         * <p> Access to the requested path is forbidden </p>
         *
         * @return Instance of {@code CreateSharedLinkWithSettingsError} with
         *     its tag set to {@link Tag#ACCESS_DENIED}.
         */
        public static CreateSharedLinkWithSettingsError accessDenied() {
            return CreateSharedLinkWithSettingsError.ACCESS_DENIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_DENIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_DENIED}, {@code false} otherwise.
         */
        public boolean isAccessDenied() {
            return this.tag == Tag.ACCESS_DENIED;
        }

        private CreateSharedLinkWithSettingsError(Tag t) {
            tag = t;
            pathValue = null;
            settingsErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case EMAIL_NOT_VERIFIED:
                case SHARED_LINK_ALREADY_EXISTS:
                case ACCESS_DENIED:
                    break;
                case PATH:
                    if (this.pathValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case SETTINGS_ERROR:
                    if (this.settingsErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
            }
        }

        static final JsonWriter<CreateSharedLinkWithSettingsError> _writer = new JsonWriter<CreateSharedLinkWithSettingsError>()
        {
            public final void write(CreateSharedLinkWithSettingsError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        DbxFiles.LookupError._writer.write(x.pathValue, g);
                        g.writeEndObject();
                        break;
                    case EMAIL_NOT_VERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_not_verified");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_ALREADY_EXISTS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_already_exists");
                        g.writeEndObject();
                        break;
                    case SETTINGS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("settings_error");
                        g.writeFieldName("settings_error");
                        SharedLinkSettingsError._writer.write(x.settingsErrorValue, g);
                        g.writeEndObject();
                        break;
                    case ACCESS_DENIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_denied");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<CreateSharedLinkWithSettingsError> _reader = new JsonReader<CreateSharedLinkWithSettingsError>()
        {
            public final CreateSharedLinkWithSettingsError read(JsonParser parser)
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
                        case EMAIL_NOT_VERIFIED: return CreateSharedLinkWithSettingsError.emailNotVerified();
                        case SHARED_LINK_ALREADY_EXISTS: return CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists();
                        case ACCESS_DENIED: return CreateSharedLinkWithSettingsError.accessDenied();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                CreateSharedLinkWithSettingsError value = null;
                if (tag != null) {
                    switch (tag) {
                        case PATH: {
                            DbxFiles.LookupError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = DbxFiles.LookupError._reader
                                .readField(parser, "path", v);
                            value = CreateSharedLinkWithSettingsError.path(v);
                            break;
                        }
                        case EMAIL_NOT_VERIFIED: {
                            value = CreateSharedLinkWithSettingsError.emailNotVerified();
                            break;
                        }
                        case SHARED_LINK_ALREADY_EXISTS: {
                            value = CreateSharedLinkWithSettingsError.sharedLinkAlreadyExists();
                            break;
                        }
                        case SETTINGS_ERROR: {
                            SharedLinkSettingsError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedLinkSettingsError._reader
                                .readField(parser, "settings_error", v);
                            value = CreateSharedLinkWithSettingsError.settingsError(v);
                            break;
                        }
                        case ACCESS_DENIED: {
                            value = CreateSharedLinkWithSettingsError.accessDenied();
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
            _values.put("email_not_verified", Tag.EMAIL_NOT_VERIFIED);
            _values.put("shared_link_already_exists", Tag.SHARED_LINK_ALREADY_EXISTS);
            _values.put("settings_error", Tag.SETTINGS_ERROR);
            _values.put("access_denied", Tag.ACCESS_DENIED);
        }

        public String toString() {
            return "CreateSharedLinkWithSettingsError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "CreateSharedLinkWithSettingsError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static CreateSharedLinkWithSettingsError fromJson(String s)
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

        /**
         *
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public RevokeSharedLinkArg(String url) {
            this.url = url;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
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


    public static final class RevokeSharedLinkError {
        // union RevokeSharedLinkError

        /**
         * The discriminating tag type for {@link RevokeSharedLinkError}.
         */
        public enum Tag {
            /**
             * The shared link wasn't found
             */
            SHARED_LINK_NOT_FOUND,
            /**
             * The caller is not allowed to access this shared link
             */
            SHARED_LINK_ACCESS_DENIED,
            /**
             * An unspecified error
             */
            OTHER,
            /**
             * Shared link is malformed.
             */
            SHARED_LINK_MALFORMED
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
         * handle this {@code RevokeSharedLinkError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The shared link wasn't found
         */
        private static final RevokeSharedLinkError SHARED_LINK_NOT_FOUND_INSTANCE = new RevokeSharedLinkError(Tag.SHARED_LINK_NOT_FOUND);

        /**
         * Returns an instance of {@code RevokeSharedLinkError} that has its tag
         * set to {@link Tag#SHARED_LINK_NOT_FOUND}.
         *
         * <p> The shared link wasn't found </p>
         *
         * @return Instance of {@code RevokeSharedLinkError} with its tag set to
         *     {@link Tag#SHARED_LINK_NOT_FOUND}.
         */
        public static RevokeSharedLinkError sharedLinkNotFound() {
            return RevokeSharedLinkError.SHARED_LINK_NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isSharedLinkNotFound() {
            return this.tag == Tag.SHARED_LINK_NOT_FOUND;
        }

        /**
         * The caller is not allowed to access this shared link
         */
        private static final RevokeSharedLinkError SHARED_LINK_ACCESS_DENIED_INSTANCE = new RevokeSharedLinkError(Tag.SHARED_LINK_ACCESS_DENIED);

        /**
         * Returns an instance of {@code RevokeSharedLinkError} that has its tag
         * set to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         *
         * <p> The caller is not allowed to access this shared link </p>
         *
         * @return Instance of {@code RevokeSharedLinkError} with its tag set to
         *     {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         */
        public static RevokeSharedLinkError sharedLinkAccessDenied() {
            return RevokeSharedLinkError.SHARED_LINK_ACCESS_DENIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         */
        public boolean isSharedLinkAccessDenied() {
            return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
        }

        /**
         * An unspecified error
         */
        private static final RevokeSharedLinkError OTHER_INSTANCE = new RevokeSharedLinkError(Tag.OTHER);

        /**
         * Returns an instance of {@code RevokeSharedLinkError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> An unspecified error </p>
         *
         * @return Instance of {@code RevokeSharedLinkError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static RevokeSharedLinkError other() {
            return RevokeSharedLinkError.OTHER_INSTANCE;
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

        /**
         * Shared link is malformed.
         */
        private static final RevokeSharedLinkError SHARED_LINK_MALFORMED_INSTANCE = new RevokeSharedLinkError(Tag.SHARED_LINK_MALFORMED);

        /**
         * Returns an instance of {@code RevokeSharedLinkError} that has its tag
         * set to {@link Tag#SHARED_LINK_MALFORMED}.
         *
         * <p> Shared link is malformed. </p>
         *
         * @return Instance of {@code RevokeSharedLinkError} with its tag set to
         *     {@link Tag#SHARED_LINK_MALFORMED}.
         */
        public static RevokeSharedLinkError sharedLinkMalformed() {
            return RevokeSharedLinkError.SHARED_LINK_MALFORMED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_MALFORMED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_MALFORMED}, {@code false} otherwise.
         */
        public boolean isSharedLinkMalformed() {
            return this.tag == Tag.SHARED_LINK_MALFORMED;
        }

        private RevokeSharedLinkError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case SHARED_LINK_NOT_FOUND:
                case SHARED_LINK_ACCESS_DENIED:
                case OTHER:
                case SHARED_LINK_MALFORMED:
                    break;
            }
        }

        static final JsonWriter<RevokeSharedLinkError> _writer = new JsonWriter<RevokeSharedLinkError>()
        {
            public final void write(RevokeSharedLinkError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case SHARED_LINK_NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_not_found");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_ACCESS_DENIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_access_denied");
                        g.writeEndObject();
                        break;
                    case OTHER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_MALFORMED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_malformed");
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
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) {
                        throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                    }
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: return RevokeSharedLinkError.sharedLinkNotFound();
                        case SHARED_LINK_ACCESS_DENIED: return RevokeSharedLinkError.sharedLinkAccessDenied();
                        case OTHER: return RevokeSharedLinkError.other();
                        case SHARED_LINK_MALFORMED: return RevokeSharedLinkError.sharedLinkMalformed();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                RevokeSharedLinkError value = null;
                if (tag != null) {
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: {
                            value = RevokeSharedLinkError.sharedLinkNotFound();
                            break;
                        }
                        case SHARED_LINK_ACCESS_DENIED: {
                            value = RevokeSharedLinkError.sharedLinkAccessDenied();
                            break;
                        }
                        case OTHER: {
                            value = RevokeSharedLinkError.other();
                            break;
                        }
                        case SHARED_LINK_MALFORMED: {
                            value = RevokeSharedLinkError.sharedLinkMalformed();
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
            _values.put("shared_link_malformed", Tag.SHARED_LINK_MALFORMED);
        }

        public String toString() {
            return "RevokeSharedLinkError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "RevokeSharedLinkError." +  _writer.writeToString(this, true);
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


    public static final class GetSharedLinkFileError {
        // union GetSharedLinkFileError

        /**
         * The discriminating tag type for {@link GetSharedLinkFileError}.
         */
        public enum Tag {
            /**
             * The shared link wasn't found
             */
            SHARED_LINK_NOT_FOUND,
            /**
             * The caller is not allowed to access this shared link
             */
            SHARED_LINK_ACCESS_DENIED,
            /**
             * An unspecified error
             */
            OTHER,
            /**
             * Directories cannot be retrieved by this endpoint.
             */
            SHARED_LINK_IS_DIRECTORY
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
         * handle this {@code GetSharedLinkFileError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The shared link wasn't found
         */
        private static final GetSharedLinkFileError SHARED_LINK_NOT_FOUND_INSTANCE = new GetSharedLinkFileError(Tag.SHARED_LINK_NOT_FOUND);

        /**
         * Returns an instance of {@code GetSharedLinkFileError} that has its
         * tag set to {@link Tag#SHARED_LINK_NOT_FOUND}.
         *
         * <p> The shared link wasn't found </p>
         *
         * @return Instance of {@code GetSharedLinkFileError} with its tag set
         *     to {@link Tag#SHARED_LINK_NOT_FOUND}.
         */
        public static GetSharedLinkFileError sharedLinkNotFound() {
            return GetSharedLinkFileError.SHARED_LINK_NOT_FOUND_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_NOT_FOUND}, {@code false} otherwise.
         */
        public boolean isSharedLinkNotFound() {
            return this.tag == Tag.SHARED_LINK_NOT_FOUND;
        }

        /**
         * The caller is not allowed to access this shared link
         */
        private static final GetSharedLinkFileError SHARED_LINK_ACCESS_DENIED_INSTANCE = new GetSharedLinkFileError(Tag.SHARED_LINK_ACCESS_DENIED);

        /**
         * Returns an instance of {@code GetSharedLinkFileError} that has its
         * tag set to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         *
         * <p> The caller is not allowed to access this shared link </p>
         *
         * @return Instance of {@code GetSharedLinkFileError} with its tag set
         *     to {@link Tag#SHARED_LINK_ACCESS_DENIED}.
         */
        public static GetSharedLinkFileError sharedLinkAccessDenied() {
            return GetSharedLinkFileError.SHARED_LINK_ACCESS_DENIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_ACCESS_DENIED}, {@code false} otherwise.
         */
        public boolean isSharedLinkAccessDenied() {
            return this.tag == Tag.SHARED_LINK_ACCESS_DENIED;
        }

        /**
         * An unspecified error
         */
        private static final GetSharedLinkFileError OTHER_INSTANCE = new GetSharedLinkFileError(Tag.OTHER);

        /**
         * Returns an instance of {@code GetSharedLinkFileError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> An unspecified error </p>
         *
         * @return Instance of {@code GetSharedLinkFileError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static GetSharedLinkFileError other() {
            return GetSharedLinkFileError.OTHER_INSTANCE;
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

        /**
         * Directories cannot be retrieved by this endpoint.
         */
        private static final GetSharedLinkFileError SHARED_LINK_IS_DIRECTORY_INSTANCE = new GetSharedLinkFileError(Tag.SHARED_LINK_IS_DIRECTORY);

        /**
         * Returns an instance of {@code GetSharedLinkFileError} that has its
         * tag set to {@link Tag#SHARED_LINK_IS_DIRECTORY}.
         *
         * <p> Directories cannot be retrieved by this endpoint. </p>
         *
         * @return Instance of {@code GetSharedLinkFileError} with its tag set
         *     to {@link Tag#SHARED_LINK_IS_DIRECTORY}.
         */
        public static GetSharedLinkFileError sharedLinkIsDirectory() {
            return GetSharedLinkFileError.SHARED_LINK_IS_DIRECTORY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_LINK_IS_DIRECTORY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_LINK_IS_DIRECTORY}, {@code false} otherwise.
         */
        public boolean isSharedLinkIsDirectory() {
            return this.tag == Tag.SHARED_LINK_IS_DIRECTORY;
        }

        private GetSharedLinkFileError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case SHARED_LINK_NOT_FOUND:
                case SHARED_LINK_ACCESS_DENIED:
                case OTHER:
                case SHARED_LINK_IS_DIRECTORY:
                    break;
            }
        }

        static final JsonWriter<GetSharedLinkFileError> _writer = new JsonWriter<GetSharedLinkFileError>()
        {
            public final void write(GetSharedLinkFileError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case SHARED_LINK_NOT_FOUND:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_not_found");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_ACCESS_DENIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_access_denied");
                        g.writeEndObject();
                        break;
                    case OTHER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("other");
                        g.writeEndObject();
                        break;
                    case SHARED_LINK_IS_DIRECTORY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_link_is_directory");
                        g.writeEndObject();
                        break;
                }
            }
        };
        public static final JsonReader<GetSharedLinkFileError> _reader = new JsonReader<GetSharedLinkFileError>()
        {
            public final GetSharedLinkFileError read(JsonParser parser)
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
                        case SHARED_LINK_NOT_FOUND: return GetSharedLinkFileError.sharedLinkNotFound();
                        case SHARED_LINK_ACCESS_DENIED: return GetSharedLinkFileError.sharedLinkAccessDenied();
                        case OTHER: return GetSharedLinkFileError.other();
                        case SHARED_LINK_IS_DIRECTORY: return GetSharedLinkFileError.sharedLinkIsDirectory();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                GetSharedLinkFileError value = null;
                if (tag != null) {
                    switch (tag) {
                        case SHARED_LINK_NOT_FOUND: {
                            value = GetSharedLinkFileError.sharedLinkNotFound();
                            break;
                        }
                        case SHARED_LINK_ACCESS_DENIED: {
                            value = GetSharedLinkFileError.sharedLinkAccessDenied();
                            break;
                        }
                        case OTHER: {
                            value = GetSharedLinkFileError.other();
                            break;
                        }
                        case SHARED_LINK_IS_DIRECTORY: {
                            value = GetSharedLinkFileError.sharedLinkIsDirectory();
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
            _values.put("shared_link_is_directory", Tag.SHARED_LINK_IS_DIRECTORY);
        }

        public String toString() {
            return "GetSharedLinkFileError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "GetSharedLinkFileError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static GetSharedLinkFileError fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * Who can access a shared link. The most open visibility is {@link
     * Visibility#public_}. The default depends on many aspects, such as team
     * and user preferences and shared folder settings.
     */
    public static final class Visibility {
        // union Visibility

        /**
         * The discriminating tag type for {@link Visibility}.
         */
        public enum Tag {
            /**
             * Anyone who has received the link can access it. No login
             * required.
             */
            PUBLIC,
            /**
             * Only members of the same team can access the link. Login is
             * required.
             */
            TEAM_ONLY,
            /**
             * A link-specific password is required to access the link. Login is
             * not required.
             */
            PASSWORD,
            /**
             * Only members of the same team who have the link-specific password
             * can access the link.
             */
            TEAM_AND_PASSWORD,
            /**
             * Only members of the shared folder containing the linked file can
             * access the link. Login is required.
             */
            SHARED_FOLDER_ONLY,
            /**
             * An unknown restriction is in place.
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
         * handle this {@code Visibility}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Anyone who has received the link can access it. No login required.
         */
        private static final Visibility PUBLIC_INSTANCE = new Visibility(Tag.PUBLIC);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#PUBLIC}.
         *
         * <p> Anyone who has received the link can access it. No login
         * required. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#PUBLIC}.
         */
        public static Visibility public_() {
            return Visibility.PUBLIC_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#PUBLIC},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PUBLIC}, {@code false} otherwise.
         */
        public boolean isPublic() {
            return this.tag == Tag.PUBLIC;
        }

        /**
         * Only members of the same team can access the link. Login is required.
         */
        private static final Visibility TEAM_ONLY_INSTANCE = new Visibility(Tag.TEAM_ONLY);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#TEAM_ONLY}.
         *
         * <p> Only members of the same team can access the link. Login is
         * required. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#TEAM_ONLY}.
         */
        public static Visibility teamOnly() {
            return Visibility.TEAM_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_ONLY}, {@code false} otherwise.
         */
        public boolean isTeamOnly() {
            return this.tag == Tag.TEAM_ONLY;
        }

        /**
         * A link-specific password is required to access the link. Login is not
         * required.
         */
        private static final Visibility PASSWORD_INSTANCE = new Visibility(Tag.PASSWORD);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#PASSWORD}.
         *
         * <p> A link-specific password is required to access the link. Login is
         * not required. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#PASSWORD}.
         */
        public static Visibility password() {
            return Visibility.PASSWORD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#PASSWORD}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#PASSWORD}, {@code false} otherwise.
         */
        public boolean isPassword() {
            return this.tag == Tag.PASSWORD;
        }

        /**
         * Only members of the same team who have the link-specific password can
         * access the link.
         */
        private static final Visibility TEAM_AND_PASSWORD_INSTANCE = new Visibility(Tag.TEAM_AND_PASSWORD);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#TEAM_AND_PASSWORD}.
         *
         * <p> Only members of the same team who have the link-specific password
         * can access the link. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#TEAM_AND_PASSWORD}.
         */
        public static Visibility teamAndPassword() {
            return Visibility.TEAM_AND_PASSWORD_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_AND_PASSWORD}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_AND_PASSWORD}, {@code false} otherwise.
         */
        public boolean isTeamAndPassword() {
            return this.tag == Tag.TEAM_AND_PASSWORD;
        }

        /**
         * Only members of the shared folder containing the linked file can
         * access the link. Login is required.
         */
        private static final Visibility SHARED_FOLDER_ONLY_INSTANCE = new Visibility(Tag.SHARED_FOLDER_ONLY);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#SHARED_FOLDER_ONLY}.
         *
         * <p> Only members of the shared folder containing the linked file can
         * access the link. Login is required. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#SHARED_FOLDER_ONLY}.
         */
        public static Visibility sharedFolderOnly() {
            return Visibility.SHARED_FOLDER_ONLY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#SHARED_FOLDER_ONLY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#SHARED_FOLDER_ONLY}, {@code false} otherwise.
         */
        public boolean isSharedFolderOnly() {
            return this.tag == Tag.SHARED_FOLDER_ONLY;
        }

        /**
         * An unknown restriction is in place.
         */
        private static final Visibility OTHER_INSTANCE = new Visibility(Tag.OTHER);

        /**
         * Returns an instance of {@code Visibility} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> An unknown restriction is in place. </p>
         *
         * @return Instance of {@code Visibility} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static Visibility other() {
            return Visibility.OTHER_INSTANCE;
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

        private Visibility(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case PUBLIC:
                case TEAM_ONLY:
                case PASSWORD:
                case TEAM_AND_PASSWORD:
                case SHARED_FOLDER_ONLY:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<Visibility> _writer = new JsonWriter<Visibility>()
        {
            public final void write(Visibility x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PUBLIC:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("public");
                        g.writeEndObject();
                        break;
                    case TEAM_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_only");
                        g.writeEndObject();
                        break;
                    case PASSWORD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("password");
                        g.writeEndObject();
                        break;
                    case TEAM_AND_PASSWORD:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_and_password");
                        g.writeEndObject();
                        break;
                    case SHARED_FOLDER_ONLY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("shared_folder_only");
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
        public static final JsonReader<Visibility> _reader = new JsonReader<Visibility>()
        {
            public final Visibility read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return Visibility.other(); }
                    switch (tag) {
                        case PUBLIC: return Visibility.public_();
                        case TEAM_ONLY: return Visibility.teamOnly();
                        case PASSWORD: return Visibility.password();
                        case TEAM_AND_PASSWORD: return Visibility.teamAndPassword();
                        case SHARED_FOLDER_ONLY: return Visibility.sharedFolderOnly();
                        case OTHER: return Visibility.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                Visibility value = null;
                if (tag != null) {
                    switch (tag) {
                        case PUBLIC: {
                            value = Visibility.public_();
                            break;
                        }
                        case TEAM_ONLY: {
                            value = Visibility.teamOnly();
                            break;
                        }
                        case PASSWORD: {
                            value = Visibility.password();
                            break;
                        }
                        case TEAM_AND_PASSWORD: {
                            value = Visibility.teamAndPassword();
                            break;
                        }
                        case SHARED_FOLDER_ONLY: {
                            value = Visibility.sharedFolderOnly();
                            break;
                        }
                        case OTHER: {
                            value = Visibility.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return Visibility.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("public", Tag.PUBLIC);
            _values.put("team_only", Tag.TEAM_ONLY);
            _values.put("password", Tag.PASSWORD);
            _values.put("team_and_password", Tag.TEAM_AND_PASSWORD);
            _values.put("shared_folder_only", Tag.SHARED_FOLDER_ONLY);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "Visibility." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "Visibility." +  _writer.writeToString(this, true);
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

        /**
         * Metadata for a shared link. This can be either a {@link
         * PathLinkMetadata} or {@link CollectionLinkMetadata}.
         *
         * @param visibility  Who can access the link. {@code visibility} must
         *     not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public LinkMetadata(String url, Visibility visibility, java.util.Date expires) {
            this.url = url;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.visibility = visibility;
            if (visibility == null) {
                throw new IllegalArgumentException("Required value for 'visibility' is null");
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

        /**
         * Metadata for a path-based shared link.
         *
         * @param path  Path in user's Dropbox. {@code path} must not be {@code
         *     null}.
         * @param visibility  Who can access the link. {@code visibility} must
         *     not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public PathLinkMetadata(String url, Visibility visibility, String path, java.util.Date expires) {
            super(url, visibility, expires);
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
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

        /**
         * Metadata for a collection-based shared link.
         *
         * @param visibility  Who can access the link. {@code visibility} must
         *     not be {@code null}.
         * @param expires  Expiration time, if set. By default the link won't
         *     expire.
         * @param url  URL of the shared link. {@code url} must not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
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
         * See {@link DbxSharing#getSharedLinks(String)} description.
         */
        public final String path;

        /**
         *
         * @param path  See {@link DbxSharing#getSharedLinks(String)}
         *     description.
         */
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
        public final java.util.List<LinkMetadata> links;

        /**
         *
         * @param links  Shared links applicable to the path argument. {@code
         *     links} must not contain a {@code null} item and not be {@code
         *     null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetSharedLinksResult(java.util.List<LinkMetadata> links) {
            this.links = links;
            if (links == null) {
                throw new IllegalArgumentException("Required value for 'links' is null");
            }
            for (LinkMetadata x : links) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'links' is null");
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
                java.util.List<LinkMetadata> links = null;
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
            PATH,  // Nullable
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
         * handle this {@code GetSharedLinksError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String pathValue;

        private GetSharedLinksError(Tag tag, String value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public String getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code GetSharedLinksError} that has its tag
         * set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code GetSharedLinksError} with its tag set to
         *     {@link Tag#PATH}.
         */
        public static GetSharedLinksError path(String value) {
            return new GetSharedLinksError(Tag.PATH, value);
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

        private static final GetSharedLinksError OTHER_INSTANCE = new GetSharedLinksError(Tag.OTHER);

        /**
         * Returns an instance of {@code GetSharedLinksError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code GetSharedLinksError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static GetSharedLinksError other() {
            return GetSharedLinksError.OTHER_INSTANCE;
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

        private GetSharedLinksError(Tag t) {
            tag = t;
            pathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case PATH:
                    break;
            }
        }

        static final JsonWriter<GetSharedLinksError> _writer = new JsonWriter<GetSharedLinksError>()
        {
            public final void write(GetSharedLinksError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        if (x.pathValue != null) {
                            g.writeFieldName("path");
                            g.writeString(x.pathValue);
                        }
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
        public static final JsonReader<GetSharedLinksError> _reader = new JsonReader<GetSharedLinksError>()
        {
            public final GetSharedLinksError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return GetSharedLinksError.other(); }
                    switch (tag) {
                        case PATH: return GetSharedLinksError.path(null);
                        case OTHER: return GetSharedLinksError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = GetSharedLinksError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return GetSharedLinksError.other(); }
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
    public static final class PendingUploadMode {
        // union PendingUploadMode

        /**
         * The discriminating tag type for {@link PendingUploadMode}.
         */
        public enum Tag {
            /**
             * Assume pending uploads are files.
             */
            FILE,
            /**
             * Assume pending uploads are folders.
             */
            FOLDER
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
         * handle this {@code PendingUploadMode}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Assume pending uploads are files.
         */
        private static final PendingUploadMode FILE_INSTANCE = new PendingUploadMode(Tag.FILE);

        /**
         * Returns an instance of {@code PendingUploadMode} that has its tag set
         * to {@link Tag#FILE}.
         *
         * <p> Assume pending uploads are files. </p>
         *
         * @return Instance of {@code PendingUploadMode} with its tag set to
         *     {@link Tag#FILE}.
         */
        public static PendingUploadMode file() {
            return PendingUploadMode.FILE_INSTANCE;
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
         * Assume pending uploads are folders.
         */
        private static final PendingUploadMode FOLDER_INSTANCE = new PendingUploadMode(Tag.FOLDER);

        /**
         * Returns an instance of {@code PendingUploadMode} that has its tag set
         * to {@link Tag#FOLDER}.
         *
         * <p> Assume pending uploads are folders. </p>
         *
         * @return Instance of {@code PendingUploadMode} with its tag set to
         *     {@link Tag#FOLDER}.
         */
        public static PendingUploadMode folder() {
            return PendingUploadMode.FOLDER_INSTANCE;
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

        private PendingUploadMode(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FILE:
                case FOLDER:
                    break;
            }
        }

        static final JsonWriter<PendingUploadMode> _writer = new JsonWriter<PendingUploadMode>()
        {
            public final void write(PendingUploadMode x, JsonGenerator g)
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
                }
            }
        };
        public static final JsonReader<PendingUploadMode> _reader = new JsonReader<PendingUploadMode>()
        {
            public final PendingUploadMode read(JsonParser parser)
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
                        case FILE: return PendingUploadMode.file();
                        case FOLDER: return PendingUploadMode.folder();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                PendingUploadMode value = null;
                if (tag != null) {
                    switch (tag) {
                        case FILE: {
                            value = PendingUploadMode.file();
                            break;
                        }
                        case FOLDER: {
                            value = PendingUploadMode.folder();
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
            _values.put("file", Tag.FILE);
            _values.put("folder", Tag.FOLDER);
        }

        public String toString() {
            return "PendingUploadMode." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "PendingUploadMode." +  _writer.writeToString(this, true);
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
         * either {@link PendingUploadMode#file} or {@link
         * PendingUploadMode#folder} to indicate whether to assume it's a file
         * or folder.
         */
        public final PendingUploadMode pendingUpload;

        /**
         *
         * @param path  The path to share. {@code path} must not be {@code
         *     null}.
         * @param pendingUpload  If it's okay to share a path that does not yet
         *     exist, set this to either {@link PendingUploadMode#file} or
         *     {@link PendingUploadMode#folder} to indicate whether to assume
         *     it's a file or folder.
         * @param shortUrl  Whether to return a shortened URL.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public CreateSharedLinkArg(String path, Boolean shortUrl, PendingUploadMode pendingUpload) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (shortUrl != null) {
                this.shortUrl = shortUrl.booleanValue();
            }
            else {
                this.shortUrl = false;
            }
            this.pendingUpload = pendingUpload;
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
         * handle this {@code CreateSharedLinkError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final DbxFiles.LookupError pathValue;

        private CreateSharedLinkError(Tag tag, DbxFiles.LookupError value) {
            this.tag = tag;
            this.pathValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#PATH}. </p>
         *
         * @return The {@link DbxFiles.LookupError} value associated with this
         *     instance if {@link #isPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isPath} is {@code false}.
         */
        public DbxFiles.LookupError getPathValue() {
            if (this.tag != Tag.PATH) {
                throw new IllegalStateException("getPathValue() requires tag==PATH, actual tag==" + tag);
            }
            return pathValue;
        }

        /**
         * Returns an instance of {@code CreateSharedLinkError} that has its tag
         * set to {@link Tag#PATH}.
         *
         * <p> None </p>
         *
         * @param value  {@link DbxFiles.LookupError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code CreateSharedLinkError} with its tag set to
         *     {@link Tag#PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static CreateSharedLinkError path(DbxFiles.LookupError value) {
            return new CreateSharedLinkError(Tag.PATH, value);
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

        private static final CreateSharedLinkError OTHER_INSTANCE = new CreateSharedLinkError(Tag.OTHER);

        /**
         * Returns an instance of {@code CreateSharedLinkError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code CreateSharedLinkError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static CreateSharedLinkError other() {
            return CreateSharedLinkError.OTHER_INSTANCE;
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

        private CreateSharedLinkError(Tag t) {
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

        static final JsonWriter<CreateSharedLinkError> _writer = new JsonWriter<CreateSharedLinkError>()
        {
            public final void write(CreateSharedLinkError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("path");
                        g.writeFieldName("path");
                        DbxFiles.LookupError._writer.write(x.pathValue, g);
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
        public static final JsonReader<CreateSharedLinkError> _reader = new JsonReader<CreateSharedLinkError>()
        {
            public final CreateSharedLinkError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return CreateSharedLinkError.other(); }
                    switch (tag) {
                        case OTHER: return CreateSharedLinkError.other();
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
                        case PATH: {
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
                        case OTHER: {
                            value = CreateSharedLinkError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return CreateSharedLinkError.other(); }
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


    /**
     * Defines the access levels for collaborators.
     */
    public static final class AccessLevel {
        // union AccessLevel

        /**
         * The discriminating tag type for {@link AccessLevel}.
         */
        public enum Tag {
            /**
             * The collaborator is the owner of the shared folder. Owners can
             * view and edit the shared folder as well as set the folder's
             * policies using {@link DbxSharing#updateFolderPolicyBuilder}.
             */
            OWNER,
            /**
             * The collaborator can both view and edit the shared folder.
             */
            EDITOR,
            /**
             * The collaborator can only view the shared folder.
             */
            VIEWER,
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
         * handle this {@code AccessLevel}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The collaborator is the owner of the shared folder. Owners can view
         * and edit the shared folder as well as set the folder's policies using
         * {@link DbxSharing#updateFolderPolicyBuilder}.
         */
        private static final AccessLevel OWNER_INSTANCE = new AccessLevel(Tag.OWNER);

        /**
         * Returns an instance of {@code AccessLevel} that has its tag set to
         * {@link Tag#OWNER}.
         *
         * <p> The collaborator is the owner of the shared folder. Owners can
         * view and edit the shared folder as well as set the folder's policies
         * using {@link DbxSharing#updateFolderPolicyBuilder}. </p>
         *
         * @return Instance of {@code AccessLevel} with its tag set to {@link
         *     Tag#OWNER}.
         */
        public static AccessLevel owner() {
            return AccessLevel.OWNER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OWNER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OWNER},
         *     {@code false} otherwise.
         */
        public boolean isOwner() {
            return this.tag == Tag.OWNER;
        }

        /**
         * The collaborator can both view and edit the shared folder.
         */
        private static final AccessLevel EDITOR_INSTANCE = new AccessLevel(Tag.EDITOR);

        /**
         * Returns an instance of {@code AccessLevel} that has its tag set to
         * {@link Tag#EDITOR}.
         *
         * <p> The collaborator can both view and edit the shared folder. </p>
         *
         * @return Instance of {@code AccessLevel} with its tag set to {@link
         *     Tag#EDITOR}.
         */
        public static AccessLevel editor() {
            return AccessLevel.EDITOR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#EDITOR},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EDITOR}, {@code false} otherwise.
         */
        public boolean isEditor() {
            return this.tag == Tag.EDITOR;
        }

        /**
         * The collaborator can only view the shared folder.
         */
        private static final AccessLevel VIEWER_INSTANCE = new AccessLevel(Tag.VIEWER);

        /**
         * Returns an instance of {@code AccessLevel} that has its tag set to
         * {@link Tag#VIEWER}.
         *
         * <p> The collaborator can only view the shared folder. </p>
         *
         * @return Instance of {@code AccessLevel} with its tag set to {@link
         *     Tag#VIEWER}.
         */
        public static AccessLevel viewer() {
            return AccessLevel.VIEWER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#VIEWER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#VIEWER}, {@code false} otherwise.
         */
        public boolean isViewer() {
            return this.tag == Tag.VIEWER;
        }

        private static final AccessLevel OTHER_INSTANCE = new AccessLevel(Tag.OTHER);

        /**
         * Returns an instance of {@code AccessLevel} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code AccessLevel} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static AccessLevel other() {
            return AccessLevel.OTHER_INSTANCE;
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

        private AccessLevel(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OWNER:
                case EDITOR:
                case VIEWER:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<AccessLevel> _writer = new JsonWriter<AccessLevel>()
        {
            public final void write(AccessLevel x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case OWNER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("owner");
                        g.writeEndObject();
                        break;
                    case EDITOR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("editor");
                        g.writeEndObject();
                        break;
                    case VIEWER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("viewer");
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
        public static final JsonReader<AccessLevel> _reader = new JsonReader<AccessLevel>()
        {
            public final AccessLevel read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AccessLevel.other(); }
                    switch (tag) {
                        case OWNER: return AccessLevel.owner();
                        case EDITOR: return AccessLevel.editor();
                        case VIEWER: return AccessLevel.viewer();
                        case OTHER: return AccessLevel.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                AccessLevel value = null;
                if (tag != null) {
                    switch (tag) {
                        case OWNER: {
                            value = AccessLevel.owner();
                            break;
                        }
                        case EDITOR: {
                            value = AccessLevel.editor();
                            break;
                        }
                        case VIEWER: {
                            value = AccessLevel.viewer();
                            break;
                        }
                        case OTHER: {
                            value = AccessLevel.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AccessLevel.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("owner", Tag.OWNER);
            _values.put("editor", Tag.EDITOR);
            _values.put("viewer", Tag.VIEWER);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "AccessLevel." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AccessLevel." +  _writer.writeToString(this, true);
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

        /**
         * A set of policies governing membership and privileges for a shared
         * folder.
         *
         * @param aclUpdatePolicy  Who can add and remove members from this
         *     shared folder. {@code aclUpdatePolicy} must not be {@code null}.
         * @param sharedLinkPolicy  Who links can be shared with. {@code
         *     sharedLinkPolicy} must not be {@code null}.
         * @param memberPolicy  Who can be a member of this shared folder. Only
         *     set if the user is a member of a team.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public FolderPolicy(AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, MemberPolicy memberPolicy) {
            this.memberPolicy = memberPolicy;
            this.aclUpdatePolicy = aclUpdatePolicy;
            if (aclUpdatePolicy == null) {
                throw new IllegalArgumentException("Required value for 'aclUpdatePolicy' is null");
            }
            this.sharedLinkPolicy = sharedLinkPolicy;
            if (sharedLinkPolicy == null) {
                throw new IllegalArgumentException("Required value for 'sharedLinkPolicy' is null");
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
    public static final class MemberPolicy {
        // union MemberPolicy

        /**
         * The discriminating tag type for {@link MemberPolicy}.
         */
        public enum Tag {
            /**
             * Only a teammate can become a member.
             */
            TEAM,
            /**
             * Anyone can become a member.
             */
            ANYONE,
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
         * handle this {@code MemberPolicy}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Only a teammate can become a member.
         */
        private static final MemberPolicy TEAM_INSTANCE = new MemberPolicy(Tag.TEAM);

        /**
         * Returns an instance of {@code MemberPolicy} that has its tag set to
         * {@link Tag#TEAM}.
         *
         * <p> Only a teammate can become a member. </p>
         *
         * @return Instance of {@code MemberPolicy} with its tag set to {@link
         *     Tag#TEAM}.
         */
        public static MemberPolicy team() {
            return MemberPolicy.TEAM_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#TEAM},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#TEAM},
         *     {@code false} otherwise.
         */
        public boolean isTeam() {
            return this.tag == Tag.TEAM;
        }

        /**
         * Anyone can become a member.
         */
        private static final MemberPolicy ANYONE_INSTANCE = new MemberPolicy(Tag.ANYONE);

        /**
         * Returns an instance of {@code MemberPolicy} that has its tag set to
         * {@link Tag#ANYONE}.
         *
         * <p> Anyone can become a member. </p>
         *
         * @return Instance of {@code MemberPolicy} with its tag set to {@link
         *     Tag#ANYONE}.
         */
        public static MemberPolicy anyone() {
            return MemberPolicy.ANYONE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#ANYONE},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ANYONE}, {@code false} otherwise.
         */
        public boolean isAnyone() {
            return this.tag == Tag.ANYONE;
        }

        private static final MemberPolicy OTHER_INSTANCE = new MemberPolicy(Tag.OTHER);

        /**
         * Returns an instance of {@code MemberPolicy} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code MemberPolicy} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static MemberPolicy other() {
            return MemberPolicy.OTHER_INSTANCE;
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

        private MemberPolicy(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case TEAM:
                case ANYONE:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<MemberPolicy> _writer = new JsonWriter<MemberPolicy>()
        {
            public final void write(MemberPolicy x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case TEAM:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team");
                        g.writeEndObject();
                        break;
                    case ANYONE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("anyone");
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
        public static final JsonReader<MemberPolicy> _reader = new JsonReader<MemberPolicy>()
        {
            public final MemberPolicy read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return MemberPolicy.other(); }
                    switch (tag) {
                        case TEAM: return MemberPolicy.team();
                        case ANYONE: return MemberPolicy.anyone();
                        case OTHER: return MemberPolicy.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                MemberPolicy value = null;
                if (tag != null) {
                    switch (tag) {
                        case TEAM: {
                            value = MemberPolicy.team();
                            break;
                        }
                        case ANYONE: {
                            value = MemberPolicy.anyone();
                            break;
                        }
                        case OTHER: {
                            value = MemberPolicy.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return MemberPolicy.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("team", Tag.TEAM);
            _values.put("anyone", Tag.ANYONE);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "MemberPolicy." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "MemberPolicy." +  _writer.writeToString(this, true);
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
    public static final class AclUpdatePolicy {
        // union AclUpdatePolicy

        /**
         * The discriminating tag type for {@link AclUpdatePolicy}.
         */
        public enum Tag {
            /**
             * Only the owner can update the ACL.
             */
            OWNER,
            /**
             * Any editor can update the ACL. This may be further restricted to
             * editors on the same team.
             */
            EDITORS,
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
         * handle this {@code AclUpdatePolicy}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Only the owner can update the ACL.
         */
        private static final AclUpdatePolicy OWNER_INSTANCE = new AclUpdatePolicy(Tag.OWNER);

        /**
         * Returns an instance of {@code AclUpdatePolicy} that has its tag set
         * to {@link Tag#OWNER}.
         *
         * <p> Only the owner can update the ACL. </p>
         *
         * @return Instance of {@code AclUpdatePolicy} with its tag set to
         *     {@link Tag#OWNER}.
         */
        public static AclUpdatePolicy owner() {
            return AclUpdatePolicy.OWNER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#OWNER},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#OWNER},
         *     {@code false} otherwise.
         */
        public boolean isOwner() {
            return this.tag == Tag.OWNER;
        }

        /**
         * Any editor can update the ACL. This may be further restricted to
         * editors on the same team.
         */
        private static final AclUpdatePolicy EDITORS_INSTANCE = new AclUpdatePolicy(Tag.EDITORS);

        /**
         * Returns an instance of {@code AclUpdatePolicy} that has its tag set
         * to {@link Tag#EDITORS}.
         *
         * <p> Any editor can update the ACL. This may be further restricted to
         * editors on the same team. </p>
         *
         * @return Instance of {@code AclUpdatePolicy} with its tag set to
         *     {@link Tag#EDITORS}.
         */
        public static AclUpdatePolicy editors() {
            return AclUpdatePolicy.EDITORS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EDITORS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EDITORS}, {@code false} otherwise.
         */
        public boolean isEditors() {
            return this.tag == Tag.EDITORS;
        }

        private static final AclUpdatePolicy OTHER_INSTANCE = new AclUpdatePolicy(Tag.OTHER);

        /**
         * Returns an instance of {@code AclUpdatePolicy} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code AclUpdatePolicy} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static AclUpdatePolicy other() {
            return AclUpdatePolicy.OTHER_INSTANCE;
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

        private AclUpdatePolicy(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OWNER:
                case EDITORS:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<AclUpdatePolicy> _writer = new JsonWriter<AclUpdatePolicy>()
        {
            public final void write(AclUpdatePolicy x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case OWNER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("owner");
                        g.writeEndObject();
                        break;
                    case EDITORS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("editors");
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
        public static final JsonReader<AclUpdatePolicy> _reader = new JsonReader<AclUpdatePolicy>()
        {
            public final AclUpdatePolicy read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AclUpdatePolicy.other(); }
                    switch (tag) {
                        case OWNER: return AclUpdatePolicy.owner();
                        case EDITORS: return AclUpdatePolicy.editors();
                        case OTHER: return AclUpdatePolicy.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                AclUpdatePolicy value = null;
                if (tag != null) {
                    switch (tag) {
                        case OWNER: {
                            value = AclUpdatePolicy.owner();
                            break;
                        }
                        case EDITORS: {
                            value = AclUpdatePolicy.editors();
                            break;
                        }
                        case OTHER: {
                            value = AclUpdatePolicy.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AclUpdatePolicy.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("owner", Tag.OWNER);
            _values.put("editors", Tag.EDITORS);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "AclUpdatePolicy." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "AclUpdatePolicy." +  _writer.writeToString(this, true);
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
    public static final class SharedLinkPolicy {
        // union SharedLinkPolicy

        /**
         * The discriminating tag type for {@link SharedLinkPolicy}.
         */
        public enum Tag {
            /**
             * Links can be shared with anyone.
             */
            ANYONE,
            /**
             * Links can only be shared among members of the shared folder.
             */
            MEMBERS,
            /**
             * An unknown shared link policy.
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
         * handle this {@code SharedLinkPolicy}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * Links can be shared with anyone.
         */
        private static final SharedLinkPolicy ANYONE_INSTANCE = new SharedLinkPolicy(Tag.ANYONE);

        /**
         * Returns an instance of {@code SharedLinkPolicy} that has its tag set
         * to {@link Tag#ANYONE}.
         *
         * <p> Links can be shared with anyone. </p>
         *
         * @return Instance of {@code SharedLinkPolicy} with its tag set to
         *     {@link Tag#ANYONE}.
         */
        public static SharedLinkPolicy anyone() {
            return SharedLinkPolicy.ANYONE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#ANYONE},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ANYONE}, {@code false} otherwise.
         */
        public boolean isAnyone() {
            return this.tag == Tag.ANYONE;
        }

        /**
         * Links can only be shared among members of the shared folder.
         */
        private static final SharedLinkPolicy MEMBERS_INSTANCE = new SharedLinkPolicy(Tag.MEMBERS);

        /**
         * Returns an instance of {@code SharedLinkPolicy} that has its tag set
         * to {@link Tag#MEMBERS}.
         *
         * <p> Links can only be shared among members of the shared folder. </p>
         *
         * @return Instance of {@code SharedLinkPolicy} with its tag set to
         *     {@link Tag#MEMBERS}.
         */
        public static SharedLinkPolicy members() {
            return SharedLinkPolicy.MEMBERS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MEMBERS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MEMBERS}, {@code false} otherwise.
         */
        public boolean isMembers() {
            return this.tag == Tag.MEMBERS;
        }

        /**
         * An unknown shared link policy.
         */
        private static final SharedLinkPolicy OTHER_INSTANCE = new SharedLinkPolicy(Tag.OTHER);

        /**
         * Returns an instance of {@code SharedLinkPolicy} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> An unknown shared link policy. </p>
         *
         * @return Instance of {@code SharedLinkPolicy} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static SharedLinkPolicy other() {
            return SharedLinkPolicy.OTHER_INSTANCE;
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

        private SharedLinkPolicy(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case ANYONE:
                case MEMBERS:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharedLinkPolicy> _writer = new JsonWriter<SharedLinkPolicy>()
        {
            public final void write(SharedLinkPolicy x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case ANYONE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("anyone");
                        g.writeEndObject();
                        break;
                    case MEMBERS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("members");
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
        public static final JsonReader<SharedLinkPolicy> _reader = new JsonReader<SharedLinkPolicy>()
        {
            public final SharedLinkPolicy read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharedLinkPolicy.other(); }
                    switch (tag) {
                        case ANYONE: return SharedLinkPolicy.anyone();
                        case MEMBERS: return SharedLinkPolicy.members();
                        case OTHER: return SharedLinkPolicy.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedLinkPolicy value = null;
                if (tag != null) {
                    switch (tag) {
                        case ANYONE: {
                            value = SharedLinkPolicy.anyone();
                            break;
                        }
                        case MEMBERS: {
                            value = SharedLinkPolicy.members();
                            break;
                        }
                        case OTHER: {
                            value = SharedLinkPolicy.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharedLinkPolicy.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("anyone", Tag.ANYONE);
            _values.put("members", Tag.MEMBERS);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharedLinkPolicy." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedLinkPolicy." +  _writer.writeToString(this, true);
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

        /**
         * The information about a member of the shared folder.
         *
         * @param accessType  The access type for this member. {@code
         *     accessType} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public MembershipInfo(AccessLevel accessType) {
            this.accessType = accessType;
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
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
     * Basic information about a user. Use {@link DbxUsers#getAccount(String)}
     * and {@link DbxUsers#getAccountBatch(java.util.List)}` to obtain more
     * detailed information.
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
         * {@link UserInfo#sameTeam} is true.
         */
        public final String teamMemberId;

        /**
         * Basic information about a user. Use {@link
         * DbxUsers#getAccount(String)} and {@link
         * DbxUsers#getAccountBatch(java.util.List)}` to obtain more detailed
         * information.
         *
         * @param teamMemberId  The team member ID of the shared folder member.
         *     Only present if {@code sameTeam} is true.
         * @param sameTeam  If the user is in the same team as current user.
         * @param accountId  The account ID of the user. {@code accountId} must
         *     have length of at least 40, have length of at most 40, and not be
         *     {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UserInfo(String accountId, boolean sameTeam, String teamMemberId) {
            this.accountId = accountId;
            if (accountId == null) {
                throw new IllegalArgumentException("Required value for 'accountId' is null");
            }
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
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

        /**
         * The information about a user member of the shared folder.
         *
         * @param accessType  The access type for this member. {@code
         *     accessType} must not be {@code null}.
         * @param user  The account information for the membership user. {@code
         *     user} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UserMembershipInfo(AccessLevel accessType, UserInfo user) {
            super(accessType);
            this.user = user;
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
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
     * The information about a user invited to become a member a shared folder.
     */
    public static final class InviteeInfo {
        // union InviteeInfo

        /**
         * The discriminating tag type for {@link InviteeInfo}.
         */
        public enum Tag {
            /**
             * E-mail address of invited user.
             */
            EMAIL,  // String
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
         * handle this {@code InviteeInfo}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String emailValue;

        private InviteeInfo(Tag tag, String value) {
            this.tag = tag;
            this.emailValue = value;
            validate();
        }

        /**
         * E-mail address of invited user.
         *
         * <p> This instance must be tagged as {@link Tag#EMAIL}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isEmail} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isEmail} is {@code false}.
         */
        public String getEmailValue() {
            if (this.tag != Tag.EMAIL) {
                throw new IllegalStateException("getEmailValue() requires tag==EMAIL, actual tag==" + tag);
            }
            return emailValue;
        }

        /**
         * Returns an instance of {@code InviteeInfo} that has its tag set to
         * {@link Tag#EMAIL}.
         *
         * <p> E-mail address of invited user. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code InviteeInfo} with its tag set to {@link
         *     Tag#EMAIL}.
         *
         * @throws IllegalArgumentException  if {@code value} does not match
         *     pattern "{@code
         *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}"
         *     or is {@code null}.
         */
        public static InviteeInfo email(String value) {
            return new InviteeInfo(Tag.EMAIL, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#EMAIL},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#EMAIL},
         *     {@code false} otherwise.
         */
        public boolean isEmail() {
            return this.tag == Tag.EMAIL;
        }

        private static final InviteeInfo OTHER_INSTANCE = new InviteeInfo(Tag.OTHER);

        /**
         * Returns an instance of {@code InviteeInfo} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code InviteeInfo} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static InviteeInfo other() {
            return InviteeInfo.OTHER_INSTANCE;
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

        private InviteeInfo(Tag t) {
            tag = t;
            emailValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case EMAIL:
                    if (this.emailValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", this.emailValue)) {
                        throw new IllegalArgumentException("String does not match pattern");
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
                    case EMAIL:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email");
                        g.writeStringField("email", x.emailValue);
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
        public static final JsonReader<InviteeInfo> _reader = new JsonReader<InviteeInfo>()
        {
            public final InviteeInfo read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return InviteeInfo.other(); }
                    switch (tag) {
                        case OTHER: return InviteeInfo.other();
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
                        case EMAIL: {
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
                        case OTHER: {
                            value = InviteeInfo.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return InviteeInfo.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("email", Tag.EMAIL);
            _values.put("other", Tag.OTHER);
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
     * The information about a user invited to become a member of a shared
     * folder.
     */
    public static class InviteeMembershipInfo extends MembershipInfo  {
        // struct InviteeMembershipInfo
        /**
         * The information for the invited user.
         */
        public final InviteeInfo invitee;

        /**
         * The information about a user invited to become a member of a shared
         * folder.
         *
         * @param invitee  The information for the invited user. {@code invitee}
         *     must not be {@code null}.
         * @param accessType  The access type for this member. {@code
         *     accessType} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee) {
            super(accessType);
            this.invitee = invitee;
            if (invitee == null) {
                throw new IllegalArgumentException("Required value for 'invitee' is null");
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

        /**
         * The information about a group. Groups is a way to manage a list of
         * users  who need same access permission to the shared folder.
         *
         * @param memberCount  The number of members in the group.
         * @param groupId  . {@code groupId} must not be {@code null}.
         * @param sameTeam  If the group is owned by the current user's team.
         * @param groupExternalId  External ID of group. This is an arbitrary ID
         *     that an admin can attach to a group.
         * @param groupName  . {@code groupName} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
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

        /**
         * The information about a group member of the shared folder.
         *
         * @param group  The information about the membership group. {@code
         *     group} must not be {@code null}.
         * @param accessType  The access type for this member. {@code
         *     accessType} must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GroupMembershipInfo(AccessLevel accessType, GroupInfo group) {
            super(accessType);
            this.group = group;
            if (group == null) {
                throw new IllegalArgumentException("Required value for 'group' is null");
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
     * The metadata which includes basic information about the shared folder.
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
        public final String sharedFolderId;
        /**
         * The current user's access level for this shared folder.
         */
        public final AccessLevel accessType;
        /**
         * Whether this folder is a &lt;a
         * href="https://www.dropbox.com/en/help/986"&gt;team folder&lt;/a&gt;.
         */
        public final boolean isTeamFolder;
        /**
         * Policies governing this shared folder.
         */
        public final FolderPolicy policy;

        /**
         * The metadata which includes basic information about the shared
         * folder.
         *
         * @param sharedFolderId  The ID of the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param name  The name of the this shared folder. {@code name} must
         *     not be {@code null}.
         * @param isTeamFolder  Whether this folder is a <a
         *     href="https://www.dropbox.com/en/help/986">team folder</a>.
         * @param policy  Policies governing this shared folder. {@code policy}
         *     must not be {@code null}.
         * @param accessType  The current user's access level for this shared
         *     folder. {@code accessType} must not be {@code null}.
         * @param pathLower  The lower-cased full path of this shared folder.
         *     Absent for unmounted folders.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SharedFolderMetadata(String name, String sharedFolderId, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String pathLower) {
            this.pathLower = pathLower;
            this.name = name;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.accessType = accessType;
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.isTeamFolder = isTeamFolder;
            this.policy = policy;
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
        }

        static final JsonWriter<SharedFolderMetadata> _writer = new JsonWriter<SharedFolderMetadata>()
        {
            public final void write(SharedFolderMetadata x, JsonGenerator g)
             throws IOException
            {
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
                g.writeStringField("shared_folder_id", x.sharedFolderId);
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
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharedFolderMetadata readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                String name = null;
                String sharedFolderId = null;
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
                    else if ("shared_folder_id".equals(fieldName)) {
                        sharedFolderId = JsonReader.StringReader
                            .readField(parser, "shared_folder_id", sharedFolderId);
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
                if (sharedFolderId == null) {
                    throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
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
                return new SharedFolderMetadata(name, sharedFolderId, accessType, isTeamFolder, policy, pathLower);
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
     * There is an error accessing the shared folder.
     */
    public static final class SharedFolderAccessError {
        // union SharedFolderAccessError

        /**
         * The discriminating tag type for {@link SharedFolderAccessError}.
         */
        public enum Tag {
            /**
             * This shared folder ID is invalid.
             */
            INVALID_ID,
            /**
             * The user is not a member of the shared folder thus cannot access
             * it.
             */
            NOT_A_MEMBER,
            /**
             * The current user does not have sufficient privileges to perform
             * the desired action.
             */
            NO_PERMISSION,
            /**
             * The current account's e-mail address is unverified.
             */
            EMAIL_UNVERIFIED,
            /**
             * The current user cannot perform this action on a team shared
             * folder.
             */
            TEAM_FOLDER,
            /**
             * The shared folder is unmounted.
             */
            UNMOUNTED,
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
         * handle this {@code SharedFolderAccessError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * This shared folder ID is invalid.
         */
        private static final SharedFolderAccessError INVALID_ID_INSTANCE = new SharedFolderAccessError(Tag.INVALID_ID);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#INVALID_ID}.
         *
         * <p> This shared folder ID is invalid. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#INVALID_ID}.
         */
        public static SharedFolderAccessError invalidId() {
            return SharedFolderAccessError.INVALID_ID_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_ID}, {@code false} otherwise.
         */
        public boolean isInvalidId() {
            return this.tag == Tag.INVALID_ID;
        }

        /**
         * The user is not a member of the shared folder thus cannot access it.
         */
        private static final SharedFolderAccessError NOT_A_MEMBER_INSTANCE = new SharedFolderAccessError(Tag.NOT_A_MEMBER);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#NOT_A_MEMBER}.
         *
         * <p> The user is not a member of the shared folder thus cannot access
         * it. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#NOT_A_MEMBER}.
         */
        public static SharedFolderAccessError notAMember() {
            return SharedFolderAccessError.NOT_A_MEMBER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_A_MEMBER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_A_MEMBER}, {@code false} otherwise.
         */
        public boolean isNotAMember() {
            return this.tag == Tag.NOT_A_MEMBER;
        }

        /**
         * The current user does not have sufficient privileges to perform the
         * desired action.
         */
        private static final SharedFolderAccessError NO_PERMISSION_INSTANCE = new SharedFolderAccessError(Tag.NO_PERMISSION);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#NO_PERMISSION}.
         *
         * <p> The current user does not have sufficient privileges to perform
         * the desired action. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#NO_PERMISSION}.
         */
        public static SharedFolderAccessError noPermission() {
            return SharedFolderAccessError.NO_PERMISSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_PERMISSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_PERMISSION}, {@code false} otherwise.
         */
        public boolean isNoPermission() {
            return this.tag == Tag.NO_PERMISSION;
        }

        /**
         * The current account's e-mail address is unverified.
         */
        private static final SharedFolderAccessError EMAIL_UNVERIFIED_INSTANCE = new SharedFolderAccessError(Tag.EMAIL_UNVERIFIED);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#EMAIL_UNVERIFIED}.
         *
         * <p> The current account's e-mail address is unverified. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#EMAIL_UNVERIFIED}.
         */
        public static SharedFolderAccessError emailUnverified() {
            return SharedFolderAccessError.EMAIL_UNVERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         */
        public boolean isEmailUnverified() {
            return this.tag == Tag.EMAIL_UNVERIFIED;
        }

        /**
         * The current user cannot perform this action on a team shared folder.
         */
        private static final SharedFolderAccessError TEAM_FOLDER_INSTANCE = new SharedFolderAccessError(Tag.TEAM_FOLDER);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#TEAM_FOLDER}.
         *
         * <p> The current user cannot perform this action on a team shared
         * folder. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#TEAM_FOLDER}.
         */
        public static SharedFolderAccessError teamFolder() {
            return SharedFolderAccessError.TEAM_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_FOLDER}, {@code false} otherwise.
         */
        public boolean isTeamFolder() {
            return this.tag == Tag.TEAM_FOLDER;
        }

        /**
         * The shared folder is unmounted.
         */
        private static final SharedFolderAccessError UNMOUNTED_INSTANCE = new SharedFolderAccessError(Tag.UNMOUNTED);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#UNMOUNTED}.
         *
         * <p> The shared folder is unmounted. </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#UNMOUNTED}.
         */
        public static SharedFolderAccessError unmounted() {
            return SharedFolderAccessError.UNMOUNTED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNMOUNTED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNMOUNTED}, {@code false} otherwise.
         */
        public boolean isUnmounted() {
            return this.tag == Tag.UNMOUNTED;
        }

        private static final SharedFolderAccessError OTHER_INSTANCE = new SharedFolderAccessError(Tag.OTHER);

        /**
         * Returns an instance of {@code SharedFolderAccessError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code SharedFolderAccessError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static SharedFolderAccessError other() {
            return SharedFolderAccessError.OTHER_INSTANCE;
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

        private SharedFolderAccessError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_ID:
                case NOT_A_MEMBER:
                case NO_PERMISSION:
                case EMAIL_UNVERIFIED:
                case TEAM_FOLDER:
                case UNMOUNTED:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharedFolderAccessError> _writer = new JsonWriter<SharedFolderAccessError>()
        {
            public final void write(SharedFolderAccessError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case INVALID_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_id");
                        g.writeEndObject();
                        break;
                    case NOT_A_MEMBER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_a_member");
                        g.writeEndObject();
                        break;
                    case NO_PERMISSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case EMAIL_UNVERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case TEAM_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_folder");
                        g.writeEndObject();
                        break;
                    case UNMOUNTED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unmounted");
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
        public static final JsonReader<SharedFolderAccessError> _reader = new JsonReader<SharedFolderAccessError>()
        {
            public final SharedFolderAccessError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharedFolderAccessError.other(); }
                    switch (tag) {
                        case INVALID_ID: return SharedFolderAccessError.invalidId();
                        case NOT_A_MEMBER: return SharedFolderAccessError.notAMember();
                        case NO_PERMISSION: return SharedFolderAccessError.noPermission();
                        case EMAIL_UNVERIFIED: return SharedFolderAccessError.emailUnverified();
                        case TEAM_FOLDER: return SharedFolderAccessError.teamFolder();
                        case UNMOUNTED: return SharedFolderAccessError.unmounted();
                        case OTHER: return SharedFolderAccessError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedFolderAccessError value = null;
                if (tag != null) {
                    switch (tag) {
                        case INVALID_ID: {
                            value = SharedFolderAccessError.invalidId();
                            break;
                        }
                        case NOT_A_MEMBER: {
                            value = SharedFolderAccessError.notAMember();
                            break;
                        }
                        case NO_PERMISSION: {
                            value = SharedFolderAccessError.noPermission();
                            break;
                        }
                        case EMAIL_UNVERIFIED: {
                            value = SharedFolderAccessError.emailUnverified();
                            break;
                        }
                        case TEAM_FOLDER: {
                            value = SharedFolderAccessError.teamFolder();
                            break;
                        }
                        case UNMOUNTED: {
                            value = SharedFolderAccessError.unmounted();
                            break;
                        }
                        case OTHER: {
                            value = SharedFolderAccessError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharedFolderAccessError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_id", Tag.INVALID_ID);
            _values.put("not_a_member", Tag.NOT_A_MEMBER);
            _values.put("no_permission", Tag.NO_PERMISSION);
            _values.put("email_unverified", Tag.EMAIL_UNVERIFIED);
            _values.put("team_folder", Tag.TEAM_FOLDER);
            _values.put("unmounted", Tag.UNMOUNTED);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharedFolderAccessError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedFolderAccessError." +  _writer.writeToString(this, true);
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


    /**
     * Result for {@link DbxSharing#listFolders}. Unmounted shared folders can
     * be identified by the absence of {@link SharedFolderMetadata#pathLower}.
     */
    public static class ListFoldersResult {
        // struct ListFoldersResult
        /**
         * List of all shared folders the authenticated user has access to.
         */
        public final java.util.List<SharedFolderMetadata> entries;
        /**
         * Present if there are additional shared folders that have not been
         * returned yet. Pass the cursor into {@link
         * DbxSharing#listFoldersContinue(String)} to list additional folders.
         */
        public final String cursor;

        /**
         * Result for {@link DbxSharing#listFolders}. Unmounted shared folders
         * can be identified by the absence of {@link
         * SharedFolderMetadata#pathLower}.
         *
         * @param cursor  Present if there are additional shared folders that
         *     have not been returned yet. Pass the cursor into {@link
         *     DbxSharing#listFoldersContinue(String)} to list additional
         *     folders.
         * @param entries  List of all shared folders the authenticated user has
         *     access to. {@code entries} must not contain a {@code null} item
         *     and not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFoldersResult(java.util.List<SharedFolderMetadata> entries, String cursor) {
            this.entries = entries;
            if (entries == null) {
                throw new IllegalArgumentException("Required value for 'entries' is null");
            }
            for (SharedFolderMetadata x : entries) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'entries' is null");
                }
            }
            this.cursor = cursor;
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
                if (x.cursor != null) {
                    g.writeFieldName("cursor");
                    g.writeString(x.cursor);
                }
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
                java.util.List<SharedFolderMetadata> entries = null;
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("entries".equals(fieldName)) {
                        entries = JsonArrayReader.mk(SharedFolderMetadata._reader)
                            .readField(parser, "entries", entries);
                    }
                    else if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (entries == null) {
                    throw new JsonReadException("Required field \"entries\" is missing.", parser.getTokenLocation());
                }
                return new ListFoldersResult(entries, cursor);
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


    public static class ListFoldersContinueArg {
        // struct ListFoldersContinueArg
        /**
         * The cursor returned by your last call to {@link
         * DbxSharing#listFolders} or {@link
         * DbxSharing#listFoldersContinue(String)}.
         */
        public final String cursor;

        /**
         *
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxSharing#listFolders} or {@link
         *     DbxSharing#listFoldersContinue(String)}. {@code cursor} must not
         *     be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFoldersContinueArg(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
        }

        static final JsonWriter<ListFoldersContinueArg> _writer = new JsonWriter<ListFoldersContinueArg>()
        {
            public final void write(ListFoldersContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFoldersContinueArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFoldersContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("cursor", x.cursor);
            }
        };

        public static final JsonReader<ListFoldersContinueArg> _reader = new JsonReader<ListFoldersContinueArg>() {

            public final ListFoldersContinueArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFoldersContinueArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFoldersContinueArg readFields(JsonParser parser)
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
                return new ListFoldersContinueArg(cursor);
            }
        };

        public String toString() {
            return "ListFoldersContinueArg." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ListFoldersContinueArg." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ListFoldersContinueArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListFoldersContinueError {
        // union ListFoldersContinueError

        /**
         * The discriminating tag type for {@link ListFoldersContinueError}.
         */
        public enum Tag {
            /**
             * {@link ListFoldersContinueArg#cursor} is invalid.
             */
            INVALID_CURSOR,
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
         * handle this {@code ListFoldersContinueError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * {@link ListFoldersContinueArg#cursor} is invalid.
         */
        private static final ListFoldersContinueError INVALID_CURSOR_INSTANCE = new ListFoldersContinueError(Tag.INVALID_CURSOR);

        /**
         * Returns an instance of {@code ListFoldersContinueError} that has its
         * tag set to {@link Tag#INVALID_CURSOR}.
         *
         * <p> {@link ListFoldersContinueArg#cursor} is invalid. </p>
         *
         * @return Instance of {@code ListFoldersContinueError} with its tag set
         *     to {@link Tag#INVALID_CURSOR}.
         */
        public static ListFoldersContinueError invalidCursor() {
            return ListFoldersContinueError.INVALID_CURSOR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_CURSOR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_CURSOR}, {@code false} otherwise.
         */
        public boolean isInvalidCursor() {
            return this.tag == Tag.INVALID_CURSOR;
        }

        private static final ListFoldersContinueError OTHER_INSTANCE = new ListFoldersContinueError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListFoldersContinueError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListFoldersContinueError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static ListFoldersContinueError other() {
            return ListFoldersContinueError.OTHER_INSTANCE;
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

        private ListFoldersContinueError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_CURSOR:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<ListFoldersContinueError> _writer = new JsonWriter<ListFoldersContinueError>()
        {
            public final void write(ListFoldersContinueError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case INVALID_CURSOR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_cursor");
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
        public static final JsonReader<ListFoldersContinueError> _reader = new JsonReader<ListFoldersContinueError>()
        {
            public final ListFoldersContinueError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListFoldersContinueError.other(); }
                    switch (tag) {
                        case INVALID_CURSOR: return ListFoldersContinueError.invalidCursor();
                        case OTHER: return ListFoldersContinueError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListFoldersContinueError value = null;
                if (tag != null) {
                    switch (tag) {
                        case INVALID_CURSOR: {
                            value = ListFoldersContinueError.invalidCursor();
                            break;
                        }
                        case OTHER: {
                            value = ListFoldersContinueError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFoldersContinueError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_cursor", Tag.INVALID_CURSOR);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "ListFoldersContinueError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFoldersContinueError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFoldersContinueError fromJson(String s)
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
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetMetadataArgs(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
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
                return new GetMetadataArgs(sharedFolderId);
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


    public static class ListFolderMembersArgs {
        // struct ListFolderMembersArgs
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderMembersArgs(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
        }

        static final JsonWriter<ListFolderMembersArgs> _writer = new JsonWriter<ListFolderMembersArgs>()
        {
            public final void write(ListFolderMembersArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderMembersArgs._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderMembersArgs x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("shared_folder_id", x.sharedFolderId);
            }
        };

        public static final JsonReader<ListFolderMembersArgs> _reader = new JsonReader<ListFolderMembersArgs>() {

            public final ListFolderMembersArgs read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderMembersArgs result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderMembersArgs readFields(JsonParser parser)
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
                return new ListFolderMembersArgs(sharedFolderId);
            }
        };

        public String toString() {
            return "ListFolderMembersArgs." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ListFolderMembersArgs." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ListFolderMembersArgs fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    /**
     * Shared folder user and group membership.
     */
    public static class SharedFolderMembers {
        // struct SharedFolderMembers
        /**
         * The list of user members of the shared folder.
         */
        public final java.util.List<UserMembershipInfo> users;
        /**
         * The list of group members of the shared folder.
         */
        public final java.util.List<GroupMembershipInfo> groups;
        /**
         * The list of invited members of the shared folder. This list will not
         * include invitees that have already accepted or declined to join the
         * shared folder.
         */
        public final java.util.List<InviteeMembershipInfo> invitees;
        /**
         * Present if there are additional shared folder members that have not
         * been returned yet. Pass the cursor into {@link
         * DbxSharing#listFolderMembersContinue(String)} to list additional
         * members.
         */
        public final String cursor;

        /**
         * Shared folder user and group membership.
         *
         * @param groups  The list of group members of the shared folder. {@code
         *     groups} must not contain a {@code null} item and not be {@code
         *     null}.
         * @param users  The list of user members of the shared folder. {@code
         *     users} must not contain a {@code null} item and not be {@code
         *     null}.
         * @param invitees  The list of invited members of the shared folder.
         *     This list will not include invitees that have already accepted or
         *     declined to join the shared folder. {@code invitees} must not
         *     contain a {@code null} item and not be {@code null}.
         * @param cursor  Present if there are additional shared folder members
         *     that have not been returned yet. Pass the cursor into {@link
         *     DbxSharing#listFolderMembersContinue(String)} to list additional
         *     members.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public SharedFolderMembers(java.util.List<UserMembershipInfo> users, java.util.List<GroupMembershipInfo> groups, java.util.List<InviteeMembershipInfo> invitees, String cursor) {
            this.users = users;
            if (users == null) {
                throw new IllegalArgumentException("Required value for 'users' is null");
            }
            for (UserMembershipInfo x : users) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
            this.groups = groups;
            if (groups == null) {
                throw new IllegalArgumentException("Required value for 'groups' is null");
            }
            for (GroupMembershipInfo x : groups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'groups' is null");
                }
            }
            this.invitees = invitees;
            if (invitees == null) {
                throw new IllegalArgumentException("Required value for 'invitees' is null");
            }
            for (InviteeMembershipInfo x : invitees) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'invitees' is null");
                }
            }
            this.cursor = cursor;
        }

        static final JsonWriter<SharedFolderMembers> _writer = new JsonWriter<SharedFolderMembers>()
        {
            public final void write(SharedFolderMembers x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                SharedFolderMembers._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(SharedFolderMembers x, JsonGenerator g)
             throws IOException
            {
                g.writeFieldName("users");
                g.writeStartArray();
                for (UserMembershipInfo item: x.users) {
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
                if (x.cursor != null) {
                    g.writeFieldName("cursor");
                    g.writeString(x.cursor);
                }
            }
        };

        public static final JsonReader<SharedFolderMembers> _reader = new JsonReader<SharedFolderMembers>() {

            public final SharedFolderMembers read(JsonParser parser)
                throws IOException, JsonReadException
            {
                SharedFolderMembers result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final SharedFolderMembers readFields(JsonParser parser)
                throws IOException, JsonReadException
            {
                java.util.List<UserMembershipInfo> users = null;
                java.util.List<GroupMembershipInfo> groups = null;
                java.util.List<InviteeMembershipInfo> invitees = null;
                String cursor = null;
                while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();
                    if ("users".equals(fieldName)) {
                        users = JsonArrayReader.mk(UserMembershipInfo._reader)
                            .readField(parser, "users", users);
                    }
                    else if ("groups".equals(fieldName)) {
                        groups = JsonArrayReader.mk(GroupMembershipInfo._reader)
                            .readField(parser, "groups", groups);
                    }
                    else if ("invitees".equals(fieldName)) {
                        invitees = JsonArrayReader.mk(InviteeMembershipInfo._reader)
                            .readField(parser, "invitees", invitees);
                    }
                    else if ("cursor".equals(fieldName)) {
                        cursor = JsonReader.StringReader
                            .readField(parser, "cursor", cursor);
                    }
                    else { JsonReader.skipValue(parser); }
                }
                if (users == null) {
                    throw new JsonReadException("Required field \"users\" is missing.", parser.getTokenLocation());
                }
                if (groups == null) {
                    throw new JsonReadException("Required field \"groups\" is missing.", parser.getTokenLocation());
                }
                if (invitees == null) {
                    throw new JsonReadException("Required field \"invitees\" is missing.", parser.getTokenLocation());
                }
                return new SharedFolderMembers(users, groups, invitees, cursor);
            }
        };

        public String toString() {
            return "SharedFolderMembers." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "SharedFolderMembers." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static SharedFolderMembers fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static class ListFolderMembersContinueArg {
        // struct ListFolderMembersContinueArg
        /**
         * The cursor returned by your last call to {@link
         * DbxSharing#listFolderMembers(String)} or {@link
         * DbxSharing#listFolderMembersContinue(String)}.
         */
        public final String cursor;

        /**
         *
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxSharing#listFolderMembers(String)} or {@link
         *     DbxSharing#listFolderMembersContinue(String)}. {@code cursor}
         *     must not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListFolderMembersContinueArg(String cursor) {
            this.cursor = cursor;
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
        }

        static final JsonWriter<ListFolderMembersContinueArg> _writer = new JsonWriter<ListFolderMembersContinueArg>()
        {
            public final void write(ListFolderMembersContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStartObject();
                ListFolderMembersContinueArg._writer.writeFields(x, g);
                g.writeEndObject();
            }
            public final void writeFields(ListFolderMembersContinueArg x, JsonGenerator g)
             throws IOException
            {
                g.writeStringField("cursor", x.cursor);
            }
        };

        public static final JsonReader<ListFolderMembersContinueArg> _reader = new JsonReader<ListFolderMembersContinueArg>() {

            public final ListFolderMembersContinueArg read(JsonParser parser)
                throws IOException, JsonReadException
            {
                ListFolderMembersContinueArg result;
                JsonReader.expectObjectStart(parser);
                result = readFields(parser);
                JsonReader.expectObjectEnd(parser);
                return result;
            }

            public final ListFolderMembersContinueArg readFields(JsonParser parser)
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
                return new ListFolderMembersContinueArg(cursor);
            }
        };

        public String toString() {
            return "ListFolderMembersContinueArg." + _writer.writeToString(this, false);
        }

        public String toStringMultiline() {
            return "ListFolderMembersContinueArg." + _writer.writeToString(this, true);
        }

        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }

        public static ListFolderMembersContinueArg fromJson(String s)
            throws JsonReadException
        {
            return _reader.readFully(s);
        }
    }


    public static final class ListFolderMembersContinueError {
        // union ListFolderMembersContinueError

        /**
         * The discriminating tag type for {@link
         * ListFolderMembersContinueError}.
         */
        public enum Tag {
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * {@link ListFolderMembersContinueArg#cursor} is invalid.
             */
            INVALID_CURSOR,
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
         * handle this {@code ListFolderMembersContinueError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private ListFolderMembersContinueError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code ListFolderMembersContinueError} that
         * has its tag set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ListFolderMembersContinueError} with its
         *     tag set to {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ListFolderMembersContinueError accessError(SharedFolderAccessError value) {
            return new ListFolderMembersContinueError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * {@link ListFolderMembersContinueArg#cursor} is invalid.
         */
        private static final ListFolderMembersContinueError INVALID_CURSOR_INSTANCE = new ListFolderMembersContinueError(Tag.INVALID_CURSOR);

        /**
         * Returns an instance of {@code ListFolderMembersContinueError} that
         * has its tag set to {@link Tag#INVALID_CURSOR}.
         *
         * <p> {@link ListFolderMembersContinueArg#cursor} is invalid. </p>
         *
         * @return Instance of {@code ListFolderMembersContinueError} with its
         *     tag set to {@link Tag#INVALID_CURSOR}.
         */
        public static ListFolderMembersContinueError invalidCursor() {
            return ListFolderMembersContinueError.INVALID_CURSOR_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_CURSOR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_CURSOR}, {@code false} otherwise.
         */
        public boolean isInvalidCursor() {
            return this.tag == Tag.INVALID_CURSOR;
        }

        private static final ListFolderMembersContinueError OTHER_INSTANCE = new ListFolderMembersContinueError(Tag.OTHER);

        /**
         * Returns an instance of {@code ListFolderMembersContinueError} that
         * has its tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ListFolderMembersContinueError} with its
         *     tag set to {@link Tag#OTHER}.
         */
        public static ListFolderMembersContinueError other() {
            return ListFolderMembersContinueError.OTHER_INSTANCE;
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

        private ListFolderMembersContinueError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_CURSOR:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
            }
        }

        static final JsonWriter<ListFolderMembersContinueError> _writer = new JsonWriter<ListFolderMembersContinueError>()
        {
            public final void write(ListFolderMembersContinueError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case INVALID_CURSOR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_cursor");
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
        public static final JsonReader<ListFolderMembersContinueError> _reader = new JsonReader<ListFolderMembersContinueError>()
        {
            public final ListFolderMembersContinueError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ListFolderMembersContinueError.other(); }
                    switch (tag) {
                        case INVALID_CURSOR: return ListFolderMembersContinueError.invalidCursor();
                        case OTHER: return ListFolderMembersContinueError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                ListFolderMembersContinueError value = null;
                if (tag != null) {
                    switch (tag) {
                        case ACCESS_ERROR: {
                            SharedFolderAccessError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderAccessError._reader
                                .readField(parser, "access_error", v);
                            value = ListFolderMembersContinueError.accessError(v);
                            break;
                        }
                        case INVALID_CURSOR: {
                            value = ListFolderMembersContinueError.invalidCursor();
                            break;
                        }
                        case OTHER: {
                            value = ListFolderMembersContinueError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ListFolderMembersContinueError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("invalid_cursor", Tag.INVALID_CURSOR);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "ListFolderMembersContinueError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "ListFolderMembersContinueError." +  _writer.writeToString(this, true);
        }
        public String toJson(Boolean longForm) {
            return _writer.writeToString(this, longForm);
        }
        public static ListFolderMembersContinueError fromJson(String s)
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

        /**
         *
         * @param path  The path to the folder to share. If it does not exist,
         *     then a new one is created. {@code path} must match pattern
         *     "{@code /.*}" and not be {@code null}.
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder.
         * @param memberPolicy  Who can be a member of this shared folder.
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.
         * @param forceAsync  Whether to force the share to happen
         *     asynchronously.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ShareFolderArg(String path, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy, Boolean forceAsync) {
            this.path = path;
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            if (memberPolicy != null) {
                this.memberPolicy = memberPolicy;
            }
            else {
                this.memberPolicy = MemberPolicy.anyone();
            }
            if (aclUpdatePolicy != null) {
                this.aclUpdatePolicy = aclUpdatePolicy;
            }
            else {
                this.aclUpdatePolicy = AclUpdatePolicy.owner();
            }
            if (sharedLinkPolicy != null) {
                this.sharedLinkPolicy = sharedLinkPolicy;
            }
            else {
                this.sharedLinkPolicy = SharedLinkPolicy.anyone();
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
            /**
             * The current account's e-mail address is unverified.
             */
            EMAIL_UNVERIFIED,
            /**
             * {@link ShareFolderArg#path} is invalid.
             */
            BAD_PATH,  // SharePathError
            /**
             * Team policy is more restrictive than {@link
             * ShareFolderArg#memberPolicy}.
             */
            TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
            /**
             * The current account is not allowed to select the specified {@link
             * ShareFolderArg#sharedLinkPolicy}.
             */
            DISALLOWED_SHARED_LINK_POLICY,
            /**
             * The current account does not have permission to perform this
             * action.
             */
            NO_PERMISSION,
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
         * handle this {@code ShareFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The current account's e-mail address is unverified.
         */
        private static final ShareFolderError EMAIL_UNVERIFIED_INSTANCE = new ShareFolderError(Tag.EMAIL_UNVERIFIED);

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#EMAIL_UNVERIFIED}.
         *
         * <p> The current account's e-mail address is unverified. </p>
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#EMAIL_UNVERIFIED}.
         */
        public static ShareFolderError emailUnverified() {
            return ShareFolderError.EMAIL_UNVERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         */
        public boolean isEmailUnverified() {
            return this.tag == Tag.EMAIL_UNVERIFIED;
        }

        private final SharePathError badPathValue;

        private ShareFolderError(Tag tag, SharePathError value) {
            this.tag = tag;
            this.badPathValue = value;
            validate();
        }

        /**
         * {@link ShareFolderArg#path} is invalid.
         *
         * <p> This instance must be tagged as {@link Tag#BAD_PATH}. </p>
         *
         * @return The {@link SharePathError} value associated with this
         *     instance if {@link #isBadPath} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isBadPath} is {@code
         *     false}.
         */
        public SharePathError getBadPathValue() {
            if (this.tag != Tag.BAD_PATH) {
                throw new IllegalStateException("getBadPathValue() requires tag==BAD_PATH, actual tag==" + tag);
            }
            return badPathValue;
        }

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#BAD_PATH}.
         *
         * <p> {@link ShareFolderArg#path} is invalid. </p>
         *
         * @param value  {@link SharePathError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#BAD_PATH}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ShareFolderError badPath(SharePathError value) {
            return new ShareFolderError(Tag.BAD_PATH, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#BAD_PATH}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#BAD_PATH}, {@code false} otherwise.
         */
        public boolean isBadPath() {
            return this.tag == Tag.BAD_PATH;
        }

        /**
         * Team policy is more restrictive than {@link
         * ShareFolderArg#memberPolicy}.
         */
        private static final ShareFolderError TEAM_POLICY_DISALLOWS_MEMBER_POLICY_INSTANCE = new ShareFolderError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}.
         *
         * <p> Team policy is more restrictive than {@link
         * ShareFolderArg#memberPolicy}. </p>
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}.
         */
        public static ShareFolderError teamPolicyDisallowsMemberPolicy() {
            return ShareFolderError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false}
         *     otherwise.
         */
        public boolean isTeamPolicyDisallowsMemberPolicy() {
            return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
        }

        /**
         * The current account is not allowed to select the specified {@link
         * ShareFolderArg#sharedLinkPolicy}.
         */
        private static final ShareFolderError DISALLOWED_SHARED_LINK_POLICY_INSTANCE = new ShareFolderError(Tag.DISALLOWED_SHARED_LINK_POLICY);

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#DISALLOWED_SHARED_LINK_POLICY}.
         *
         * <p> The current account is not allowed to select the specified {@link
         * ShareFolderArg#sharedLinkPolicy}. </p>
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#DISALLOWED_SHARED_LINK_POLICY}.
         */
        public static ShareFolderError disallowedSharedLinkPolicy() {
            return ShareFolderError.DISALLOWED_SHARED_LINK_POLICY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
         */
        public boolean isDisallowedSharedLinkPolicy() {
            return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
        }

        /**
         * The current account does not have permission to perform this action.
         */
        private static final ShareFolderError NO_PERMISSION_INSTANCE = new ShareFolderError(Tag.NO_PERMISSION);

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#NO_PERMISSION}.
         *
         * <p> The current account does not have permission to perform this
         * action. </p>
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#NO_PERMISSION}.
         */
        public static ShareFolderError noPermission() {
            return ShareFolderError.NO_PERMISSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_PERMISSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_PERMISSION}, {@code false} otherwise.
         */
        public boolean isNoPermission() {
            return this.tag == Tag.NO_PERMISSION;
        }

        private static final ShareFolderError OTHER_INSTANCE = new ShareFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code ShareFolderError} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code ShareFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static ShareFolderError other() {
            return ShareFolderError.OTHER_INSTANCE;
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

        private ShareFolderError(Tag t) {
            tag = t;
            badPathValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case EMAIL_UNVERIFIED:
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                case DISALLOWED_SHARED_LINK_POLICY:
                case NO_PERMISSION:
                case OTHER:
                    break;
                case BAD_PATH:
                    if (this.badPathValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case EMAIL_UNVERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case BAD_PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("bad_path");
                        g.writeFieldName("bad_path");
                        SharePathError._writer.write(x.badPathValue, g);
                        g.writeEndObject();
                        break;
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_policy_disallows_member_policy");
                        g.writeEndObject();
                        break;
                    case DISALLOWED_SHARED_LINK_POLICY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("disallowed_shared_link_policy");
                        g.writeEndObject();
                        break;
                    case NO_PERMISSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
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
        public static final JsonReader<ShareFolderError> _reader = new JsonReader<ShareFolderError>()
        {
            public final ShareFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return ShareFolderError.other(); }
                    switch (tag) {
                        case EMAIL_UNVERIFIED: return ShareFolderError.emailUnverified();
                        case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: return ShareFolderError.teamPolicyDisallowsMemberPolicy();
                        case DISALLOWED_SHARED_LINK_POLICY: return ShareFolderError.disallowedSharedLinkPolicy();
                        case NO_PERMISSION: return ShareFolderError.noPermission();
                        case OTHER: return ShareFolderError.other();
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
                        case EMAIL_UNVERIFIED: {
                            value = ShareFolderError.emailUnverified();
                            break;
                        }
                        case BAD_PATH: {
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
                        case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                            value = ShareFolderError.teamPolicyDisallowsMemberPolicy();
                            break;
                        }
                        case DISALLOWED_SHARED_LINK_POLICY: {
                            value = ShareFolderError.disallowedSharedLinkPolicy();
                            break;
                        }
                        case NO_PERMISSION: {
                            value = ShareFolderError.noPermission();
                            break;
                        }
                        case OTHER: {
                            value = ShareFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return ShareFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("email_unverified", Tag.EMAIL_UNVERIFIED);
            _values.put("bad_path", Tag.BAD_PATH);
            _values.put("team_policy_disallows_member_policy", Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
            _values.put("disallowed_shared_link_policy", Tag.DISALLOWED_SHARED_LINK_POLICY);
            _values.put("no_permission", Tag.NO_PERMISSION);
            _values.put("other", Tag.OTHER);
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


    public static final class SharePathError {
        // union SharePathError

        /**
         * The discriminating tag type for {@link SharePathError}.
         */
        public enum Tag {
            /**
             * A file is at the specified path.
             */
            IS_FILE,
            /**
             * We do not support sharing a folder inside a shared folder.
             */
            INSIDE_SHARED_FOLDER,
            /**
             * We do not support shared folders that contain shared folders.
             */
            CONTAINS_SHARED_FOLDER,
            /**
             * We do not support sharing an app folder.
             */
            IS_APP_FOLDER,
            /**
             * We do not support sharing a folder inside an app folder.
             */
            INSIDE_APP_FOLDER,
            /**
             * Folder is already shared.
             */
            ALREADY_SHARED,
            /**
             * Path is not valid.
             */
            INVALID_PATH,
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
         * handle this {@code SharePathError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * A file is at the specified path.
         */
        private static final SharePathError IS_FILE_INSTANCE = new SharePathError(Tag.IS_FILE);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#IS_FILE}.
         *
         * <p> A file is at the specified path. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#IS_FILE}.
         */
        public static SharePathError isFile() {
            return SharePathError.IS_FILE_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#IS_FILE}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#IS_FILE}, {@code false} otherwise.
         */
        public boolean isIsFile() {
            return this.tag == Tag.IS_FILE;
        }

        /**
         * We do not support sharing a folder inside a shared folder.
         */
        private static final SharePathError INSIDE_SHARED_FOLDER_INSTANCE = new SharePathError(Tag.INSIDE_SHARED_FOLDER);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#INSIDE_SHARED_FOLDER}.
         *
         * <p> We do not support sharing a folder inside a shared folder. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#INSIDE_SHARED_FOLDER}.
         */
        public static SharePathError insideSharedFolder() {
            return SharePathError.INSIDE_SHARED_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
         */
        public boolean isInsideSharedFolder() {
            return this.tag == Tag.INSIDE_SHARED_FOLDER;
        }

        /**
         * We do not support shared folders that contain shared folders.
         */
        private static final SharePathError CONTAINS_SHARED_FOLDER_INSTANCE = new SharePathError(Tag.CONTAINS_SHARED_FOLDER);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#CONTAINS_SHARED_FOLDER}.
         *
         * <p> We do not support shared folders that contain shared folders.
         * </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#CONTAINS_SHARED_FOLDER}.
         */
        public static SharePathError containsSharedFolder() {
            return SharePathError.CONTAINS_SHARED_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CONTAINS_SHARED_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CONTAINS_SHARED_FOLDER}, {@code false} otherwise.
         */
        public boolean isContainsSharedFolder() {
            return this.tag == Tag.CONTAINS_SHARED_FOLDER;
        }

        /**
         * We do not support sharing an app folder.
         */
        private static final SharePathError IS_APP_FOLDER_INSTANCE = new SharePathError(Tag.IS_APP_FOLDER);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#IS_APP_FOLDER}.
         *
         * <p> We do not support sharing an app folder. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#IS_APP_FOLDER}.
         */
        public static SharePathError isAppFolder() {
            return SharePathError.IS_APP_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#IS_APP_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#IS_APP_FOLDER}, {@code false} otherwise.
         */
        public boolean isIsAppFolder() {
            return this.tag == Tag.IS_APP_FOLDER;
        }

        /**
         * We do not support sharing a folder inside an app folder.
         */
        private static final SharePathError INSIDE_APP_FOLDER_INSTANCE = new SharePathError(Tag.INSIDE_APP_FOLDER);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#INSIDE_APP_FOLDER}.
         *
         * <p> We do not support sharing a folder inside an app folder. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#INSIDE_APP_FOLDER}.
         */
        public static SharePathError insideAppFolder() {
            return SharePathError.INSIDE_APP_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSIDE_APP_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSIDE_APP_FOLDER}, {@code false} otherwise.
         */
        public boolean isInsideAppFolder() {
            return this.tag == Tag.INSIDE_APP_FOLDER;
        }

        /**
         * Folder is already shared.
         */
        private static final SharePathError ALREADY_SHARED_INSTANCE = new SharePathError(Tag.ALREADY_SHARED);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#ALREADY_SHARED}.
         *
         * <p> Folder is already shared. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#ALREADY_SHARED}.
         */
        public static SharePathError alreadyShared() {
            return SharePathError.ALREADY_SHARED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ALREADY_SHARED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ALREADY_SHARED}, {@code false} otherwise.
         */
        public boolean isAlreadyShared() {
            return this.tag == Tag.ALREADY_SHARED;
        }

        /**
         * Path is not valid.
         */
        private static final SharePathError INVALID_PATH_INSTANCE = new SharePathError(Tag.INVALID_PATH);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#INVALID_PATH}.
         *
         * <p> Path is not valid. </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#INVALID_PATH}.
         */
        public static SharePathError invalidPath() {
            return SharePathError.INVALID_PATH_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_PATH}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_PATH}, {@code false} otherwise.
         */
        public boolean isInvalidPath() {
            return this.tag == Tag.INVALID_PATH;
        }

        private static final SharePathError OTHER_INSTANCE = new SharePathError(Tag.OTHER);

        /**
         * Returns an instance of {@code SharePathError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code SharePathError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static SharePathError other() {
            return SharePathError.OTHER_INSTANCE;
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

        private SharePathError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IS_FILE:
                case INSIDE_SHARED_FOLDER:
                case CONTAINS_SHARED_FOLDER:
                case IS_APP_FOLDER:
                case INSIDE_APP_FOLDER:
                case ALREADY_SHARED:
                case INVALID_PATH:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharePathError> _writer = new JsonWriter<SharePathError>()
        {
            public final void write(SharePathError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case IS_FILE:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("is_file");
                        g.writeEndObject();
                        break;
                    case INSIDE_SHARED_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_shared_folder");
                        g.writeEndObject();
                        break;
                    case CONTAINS_SHARED_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("contains_shared_folder");
                        g.writeEndObject();
                        break;
                    case IS_APP_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("is_app_folder");
                        g.writeEndObject();
                        break;
                    case INSIDE_APP_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_app_folder");
                        g.writeEndObject();
                        break;
                    case ALREADY_SHARED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("already_shared");
                        g.writeEndObject();
                        break;
                    case INVALID_PATH:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_path");
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
        public static final JsonReader<SharePathError> _reader = new JsonReader<SharePathError>()
        {
            public final SharePathError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharePathError.other(); }
                    switch (tag) {
                        case IS_FILE: return SharePathError.isFile();
                        case INSIDE_SHARED_FOLDER: return SharePathError.insideSharedFolder();
                        case CONTAINS_SHARED_FOLDER: return SharePathError.containsSharedFolder();
                        case IS_APP_FOLDER: return SharePathError.isAppFolder();
                        case INSIDE_APP_FOLDER: return SharePathError.insideAppFolder();
                        case ALREADY_SHARED: return SharePathError.alreadyShared();
                        case INVALID_PATH: return SharePathError.invalidPath();
                        case OTHER: return SharePathError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharePathError value = null;
                if (tag != null) {
                    switch (tag) {
                        case IS_FILE: {
                            value = SharePathError.isFile();
                            break;
                        }
                        case INSIDE_SHARED_FOLDER: {
                            value = SharePathError.insideSharedFolder();
                            break;
                        }
                        case CONTAINS_SHARED_FOLDER: {
                            value = SharePathError.containsSharedFolder();
                            break;
                        }
                        case IS_APP_FOLDER: {
                            value = SharePathError.isAppFolder();
                            break;
                        }
                        case INSIDE_APP_FOLDER: {
                            value = SharePathError.insideAppFolder();
                            break;
                        }
                        case ALREADY_SHARED: {
                            value = SharePathError.alreadyShared();
                            break;
                        }
                        case INVALID_PATH: {
                            value = SharePathError.invalidPath();
                            break;
                        }
                        case OTHER: {
                            value = SharePathError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharePathError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("is_file", Tag.IS_FILE);
            _values.put("inside_shared_folder", Tag.INSIDE_SHARED_FOLDER);
            _values.put("contains_shared_folder", Tag.CONTAINS_SHARED_FOLDER);
            _values.put("is_app_folder", Tag.IS_APP_FOLDER);
            _values.put("inside_app_folder", Tag.INSIDE_APP_FOLDER);
            _values.put("already_shared", Tag.ALREADY_SHARED);
            _values.put("invalid_path", Tag.INVALID_PATH);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharePathError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharePathError." +  _writer.writeToString(this, true);
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


    public static final class ShareFolderJobStatus {
        // union ShareFolderJobStatus

        /**
         * The discriminating tag type for {@link ShareFolderJobStatus}.
         */
        public enum Tag {
            /**
             * The asynchronous job is still in progress.
             */
            IN_PROGRESS,
            /**
             * The share job has finished. The value is the metadata for the
             * folder.
             */
            COMPLETE,  // SharedFolderMetadata
            FAILED  // ShareFolderError
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
         * handle this {@code ShareFolderJobStatus}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The asynchronous job is still in progress.
         */
        private static final ShareFolderJobStatus IN_PROGRESS_INSTANCE = new ShareFolderJobStatus(Tag.IN_PROGRESS);

        /**
         * Returns an instance of {@code ShareFolderJobStatus} that has its tag
         * set to {@link Tag#IN_PROGRESS}.
         *
         * <p> The asynchronous job is still in progress. </p>
         *
         * @return Instance of {@code ShareFolderJobStatus} with its tag set to
         *     {@link Tag#IN_PROGRESS}.
         */
        public static ShareFolderJobStatus inProgress() {
            return ShareFolderJobStatus.IN_PROGRESS_INSTANCE;
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

        private final SharedFolderMetadata completeValue;

        private ShareFolderJobStatus(Tag tag, SharedFolderMetadata value) {
            this.tag = tag;
            this.completeValue = value;
            this.failedValue = null;
            validate();
        }

        /**
         * The share job has finished. The value is the metadata for the folder.
         *
         * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
         *
         * @return The {@link SharedFolderMetadata} value associated with this
         *     instance if {@link #isComplete} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isComplete} is {@code
         *     false}.
         */
        public SharedFolderMetadata getCompleteValue() {
            if (this.tag != Tag.COMPLETE) {
                throw new IllegalStateException("getCompleteValue() requires tag==COMPLETE, actual tag==" + tag);
            }
            return completeValue;
        }

        /**
         * Returns an instance of {@code ShareFolderJobStatus} that has its tag
         * set to {@link Tag#COMPLETE}.
         *
         * <p> The share job has finished. The value is the metadata for the
         * folder. </p>
         *
         * @param value  {@link SharedFolderMetadata} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ShareFolderJobStatus} with its tag set to
         *     {@link Tag#COMPLETE}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ShareFolderJobStatus complete(SharedFolderMetadata value) {
            return new ShareFolderJobStatus(Tag.COMPLETE, value);
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

        private final ShareFolderError failedValue;

        private ShareFolderJobStatus(Tag tag, ShareFolderError value) {
            this.tag = tag;
            this.completeValue = null;
            this.failedValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#FAILED}. </p>
         *
         * @return The {@link ShareFolderError} value associated with this
         *     instance if {@link #isFailed} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
         */
        public ShareFolderError getFailedValue() {
            if (this.tag != Tag.FAILED) {
                throw new IllegalStateException("getFailedValue() requires tag==FAILED, actual tag==" + tag);
            }
            return failedValue;
        }

        /**
         * Returns an instance of {@code ShareFolderJobStatus} that has its tag
         * set to {@link Tag#FAILED}.
         *
         * <p> None </p>
         *
         * @param value  {@link ShareFolderError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ShareFolderJobStatus} with its tag set to
         *     {@link Tag#FAILED}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ShareFolderJobStatus failed(ShareFolderError value) {
            return new ShareFolderJobStatus(Tag.FAILED, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FAILED}, {@code false} otherwise.
         */
        public boolean isFailed() {
            return this.tag == Tag.FAILED;
        }

        private ShareFolderJobStatus(Tag t) {
            tag = t;
            completeValue = null;
            failedValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IN_PROGRESS:
                    break;
                case COMPLETE:
                    if (this.completeValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case FAILED:
                    if (this.failedValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                        SharedFolderMetadata._writer.writeFields(x.completeValue, g);
                        g.writeEndObject();
                        break;
                    case FAILED:
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
                        case IN_PROGRESS: return ShareFolderJobStatus.inProgress();
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
                        case IN_PROGRESS: {
                            value = ShareFolderJobStatus.inProgress();
                            break;
                        }
                        case COMPLETE: {
                            SharedFolderMetadata v = null;
                            v = SharedFolderMetadata._reader.readFields(parser);
                            value = ShareFolderJobStatus.complete(v);
                            break;
                        }
                        case FAILED: {
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
            _values.put("complete", Tag.COMPLETE);
            _values.put("failed", Tag.FAILED);
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
            /**
             * This response indicates that the processing is asynchronous. The
             * string is an id that can be used to obtain the status of the
             * asynchronous job.
             */
            ASYNC_JOB_ID,  // String
            COMPLETE  // SharedFolderMetadata
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
         * handle this {@code ShareFolderLaunch}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String asyncJobIdValue;

        private ShareFolderLaunch(Tag tag, String value) {
            this.tag = tag;
            this.asyncJobIdValue = value;
            this.completeValue = null;
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
         * Returns an instance of {@code ShareFolderLaunch} that has its tag set
         * to {@link Tag#ASYNC_JOB_ID}.
         *
         * <p> This response indicates that the processing is asynchronous. The
         * string is an id that can be used to obtain the status of the
         * asynchronous job. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code ShareFolderLaunch} with its tag set to
         *     {@link Tag#ASYNC_JOB_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static ShareFolderLaunch asyncJobId(String value) {
            return new ShareFolderLaunch(Tag.ASYNC_JOB_ID, value);
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

        private final SharedFolderMetadata completeValue;

        private ShareFolderLaunch(Tag tag, SharedFolderMetadata value) {
            this.tag = tag;
            this.asyncJobIdValue = null;
            this.completeValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#COMPLETE}. </p>
         *
         * @return The {@link SharedFolderMetadata} value associated with this
         *     instance if {@link #isComplete} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isComplete} is {@code
         *     false}.
         */
        public SharedFolderMetadata getCompleteValue() {
            if (this.tag != Tag.COMPLETE) {
                throw new IllegalStateException("getCompleteValue() requires tag==COMPLETE, actual tag==" + tag);
            }
            return completeValue;
        }

        /**
         * Returns an instance of {@code ShareFolderLaunch} that has its tag set
         * to {@link Tag#COMPLETE}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderMetadata} value to assign to this
         *     instance.
         *
         * @return Instance of {@code ShareFolderLaunch} with its tag set to
         *     {@link Tag#COMPLETE}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static ShareFolderLaunch complete(SharedFolderMetadata value) {
            return new ShareFolderLaunch(Tag.COMPLETE, value);
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
                case COMPLETE:
                    if (this.completeValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                        SharedFolderMetadata._writer.writeFields(x.completeValue, g);
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
                        case ASYNC_JOB_ID: {
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
                        case COMPLETE: {
                            SharedFolderMetadata v = null;
                            v = SharedFolderMetadata._reader.readFields(parser);
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
            _values.put("complete", Tag.COMPLETE);
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
            /**
             * The asynchronous job is still in progress.
             */
            IN_PROGRESS,
            /**
             * The asynchronous job has finished.
             */
            COMPLETE,
            /**
             * The asynchronous job returned an error.
             */
            FAILED  // JobError
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
         * handle this {@code JobStatus}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The asynchronous job is still in progress.
         */
        private static final JobStatus IN_PROGRESS_INSTANCE = new JobStatus(Tag.IN_PROGRESS);

        /**
         * Returns an instance of {@code JobStatus} that has its tag set to
         * {@link Tag#IN_PROGRESS}.
         *
         * <p> The asynchronous job is still in progress. </p>
         *
         * @return Instance of {@code JobStatus} with its tag set to {@link
         *     Tag#IN_PROGRESS}.
         */
        public static JobStatus inProgress() {
            return JobStatus.IN_PROGRESS_INSTANCE;
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
         * The asynchronous job has finished.
         */
        private static final JobStatus COMPLETE_INSTANCE = new JobStatus(Tag.COMPLETE);

        /**
         * Returns an instance of {@code JobStatus} that has its tag set to
         * {@link Tag#COMPLETE}.
         *
         * <p> The asynchronous job has finished. </p>
         *
         * @return Instance of {@code JobStatus} with its tag set to {@link
         *     Tag#COMPLETE}.
         */
        public static JobStatus complete() {
            return JobStatus.COMPLETE_INSTANCE;
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

        private final JobError failedValue;

        private JobStatus(Tag tag, JobError value) {
            this.tag = tag;
            this.failedValue = value;
            validate();
        }

        /**
         * The asynchronous job returned an error.
         *
         * <p> This instance must be tagged as {@link Tag#FAILED}. </p>
         *
         * @return The {@link JobError} value associated with this instance if
         *     {@link #isFailed} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isFailed} is {@code false}.
         */
        public JobError getFailedValue() {
            if (this.tag != Tag.FAILED) {
                throw new IllegalStateException("getFailedValue() requires tag==FAILED, actual tag==" + tag);
            }
            return failedValue;
        }

        /**
         * Returns an instance of {@code JobStatus} that has its tag set to
         * {@link Tag#FAILED}.
         *
         * <p> The asynchronous job returned an error. </p>
         *
         * @param value  {@link JobError} value to assign to this instance.
         *
         * @return Instance of {@code JobStatus} with its tag set to {@link
         *     Tag#FAILED}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static JobStatus failed(JobError value) {
            return new JobStatus(Tag.FAILED, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#FAILED},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FAILED}, {@code false} otherwise.
         */
        public boolean isFailed() {
            return this.tag == Tag.FAILED;
        }

        private JobStatus(Tag t) {
            tag = t;
            failedValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case IN_PROGRESS:
                case COMPLETE:
                    break;
                case FAILED:
                    if (this.failedValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case FAILED:
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
                        case IN_PROGRESS: return JobStatus.inProgress();
                        case COMPLETE: return JobStatus.complete();
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
                        case IN_PROGRESS: {
                            value = JobStatus.inProgress();
                            break;
                        }
                        case COMPLETE: {
                            value = JobStatus.complete();
                            break;
                        }
                        case FAILED: {
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
            _values.put("complete", Tag.COMPLETE);
            _values.put("failed", Tag.FAILED);
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


    public static final class SharedFolderMemberError {
        // union SharedFolderMemberError

        /**
         * The discriminating tag type for {@link SharedFolderMemberError}.
         */
        public enum Tag {
            /**
             * The target dropbox_id is invalid.
             */
            INVALID_DROPBOX_ID,
            /**
             * The target dropbox_id is not a member of the shared folder.
             */
            NOT_A_MEMBER,
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
         * handle this {@code SharedFolderMemberError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        /**
         * The target dropbox_id is invalid.
         */
        private static final SharedFolderMemberError INVALID_DROPBOX_ID_INSTANCE = new SharedFolderMemberError(Tag.INVALID_DROPBOX_ID);

        /**
         * Returns an instance of {@code SharedFolderMemberError} that has its
         * tag set to {@link Tag#INVALID_DROPBOX_ID}.
         *
         * <p> The target dropbox_id is invalid. </p>
         *
         * @return Instance of {@code SharedFolderMemberError} with its tag set
         *     to {@link Tag#INVALID_DROPBOX_ID}.
         */
        public static SharedFolderMemberError invalidDropboxId() {
            return SharedFolderMemberError.INVALID_DROPBOX_ID_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         */
        public boolean isInvalidDropboxId() {
            return this.tag == Tag.INVALID_DROPBOX_ID;
        }

        /**
         * The target dropbox_id is not a member of the shared folder.
         */
        private static final SharedFolderMemberError NOT_A_MEMBER_INSTANCE = new SharedFolderMemberError(Tag.NOT_A_MEMBER);

        /**
         * Returns an instance of {@code SharedFolderMemberError} that has its
         * tag set to {@link Tag#NOT_A_MEMBER}.
         *
         * <p> The target dropbox_id is not a member of the shared folder. </p>
         *
         * @return Instance of {@code SharedFolderMemberError} with its tag set
         *     to {@link Tag#NOT_A_MEMBER}.
         */
        public static SharedFolderMemberError notAMember() {
            return SharedFolderMemberError.NOT_A_MEMBER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_A_MEMBER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_A_MEMBER}, {@code false} otherwise.
         */
        public boolean isNotAMember() {
            return this.tag == Tag.NOT_A_MEMBER;
        }

        private static final SharedFolderMemberError OTHER_INSTANCE = new SharedFolderMemberError(Tag.OTHER);

        /**
         * Returns an instance of {@code SharedFolderMemberError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code SharedFolderMemberError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static SharedFolderMemberError other() {
            return SharedFolderMemberError.OTHER_INSTANCE;
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

        private SharedFolderMemberError(Tag t) {
            tag = t;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INVALID_DROPBOX_ID:
                case NOT_A_MEMBER:
                case OTHER:
                    break;
            }
        }

        static final JsonWriter<SharedFolderMemberError> _writer = new JsonWriter<SharedFolderMemberError>()
        {
            public final void write(SharedFolderMemberError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case INVALID_DROPBOX_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case NOT_A_MEMBER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_a_member");
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
        public static final JsonReader<SharedFolderMemberError> _reader = new JsonReader<SharedFolderMemberError>()
        {
            public final SharedFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return SharedFolderMemberError.other(); }
                    switch (tag) {
                        case INVALID_DROPBOX_ID: return SharedFolderMemberError.invalidDropboxId();
                        case NOT_A_MEMBER: return SharedFolderMemberError.notAMember();
                        case OTHER: return SharedFolderMemberError.other();
                    }
                    throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
                }
                JsonReader.expectObjectStart(parser);
                String[] tags = readTags(parser);
                assert tags != null && tags.length == 1;
                String text = tags[0];
                Tag tag = _values.get(text);
                SharedFolderMemberError value = null;
                if (tag != null) {
                    switch (tag) {
                        case INVALID_DROPBOX_ID: {
                            value = SharedFolderMemberError.invalidDropboxId();
                            break;
                        }
                        case NOT_A_MEMBER: {
                            value = SharedFolderMemberError.notAMember();
                            break;
                        }
                        case OTHER: {
                            value = SharedFolderMemberError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return SharedFolderMemberError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_dropbox_id", Tag.INVALID_DROPBOX_ID);
            _values.put("not_a_member", Tag.NOT_A_MEMBER);
            _values.put("other", Tag.OTHER);
        }

        public String toString() {
            return "SharedFolderMemberError." + _writer.writeToString(this, false);
        }
        public String toStringMultiline() {
            return "SharedFolderMemberError." +  _writer.writeToString(this, true);
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
            ACCESS_ERROR,  // SharedFolderAccessError
            MEMBER_ERROR,  // SharedFolderMemberError
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
         * handle this {@code JobError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private JobError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            this.memberErrorValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code JobError} that has its tag set to
         * {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code JobError} with its tag set to {@link
         *     Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static JobError accessError(SharedFolderAccessError value) {
            return new JobError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        private final SharedFolderMemberError memberErrorValue;

        private JobError(Tag tag, SharedFolderMemberError value) {
            this.tag = tag;
            this.accessErrorValue = null;
            this.memberErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#MEMBER_ERROR}. </p>
         *
         * @return The {@link SharedFolderMemberError} value associated with
         *     this instance if {@link #isMemberError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMemberError} is {@code
         *     false}.
         */
        public SharedFolderMemberError getMemberErrorValue() {
            if (this.tag != Tag.MEMBER_ERROR) {
                throw new IllegalStateException("getMemberErrorValue() requires tag==MEMBER_ERROR, actual tag==" + tag);
            }
            return memberErrorValue;
        }

        /**
         * Returns an instance of {@code JobError} that has its tag set to
         * {@link Tag#MEMBER_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderMemberError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code JobError} with its tag set to {@link
         *     Tag#MEMBER_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static JobError memberError(SharedFolderMemberError value) {
            return new JobError(Tag.MEMBER_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MEMBER_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MEMBER_ERROR}, {@code false} otherwise.
         */
        public boolean isMemberError() {
            return this.tag == Tag.MEMBER_ERROR;
        }

        private static final JobError OTHER_INSTANCE = new JobError(Tag.OTHER);

        /**
         * Returns an instance of {@code JobError} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code JobError} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static JobError other() {
            return JobError.OTHER_INSTANCE;
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

        private JobError(Tag t) {
            tag = t;
            accessErrorValue = null;
            memberErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case MEMBER_ERROR:
                    if (this.memberErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case MEMBER_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("member_error");
                        g.writeFieldName("member_error");
                        SharedFolderMemberError._writer.write(x.memberErrorValue, g);
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
        public static final JsonReader<JobError> _reader = new JsonReader<JobError>()
        {
            public final JobError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return JobError.other(); }
                    switch (tag) {
                        case OTHER: return JobError.other();
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
                        case ACCESS_ERROR: {
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
                        case MEMBER_ERROR: {
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
                        case OTHER: {
                            value = JobError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return JobError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("member_error", Tag.MEMBER_ERROR);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param leaveACopy  If true, members of this shared folder will get a
         *     copy of this folder after it's unshared. Otherwise, it will be
         *     removed from their Dropbox. The current user, who is an owner,
         *     will always retain their copy.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UnshareFolderArg(String sharedFolderId, boolean leaveACopy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
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
            ACCESS_ERROR,  // SharedFolderAccessError
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
         * handle this {@code UnshareFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private UnshareFolderError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code UnshareFolderError} that has its tag
         * set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UnshareFolderError} with its tag set to
         *     {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UnshareFolderError accessError(SharedFolderAccessError value) {
            return new UnshareFolderError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        private static final UnshareFolderError OTHER_INSTANCE = new UnshareFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code UnshareFolderError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code UnshareFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static UnshareFolderError other() {
            return UnshareFolderError.OTHER_INSTANCE;
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

        private UnshareFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
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
        public static final JsonReader<UnshareFolderError> _reader = new JsonReader<UnshareFolderError>()
        {
            public final UnshareFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UnshareFolderError.other(); }
                    switch (tag) {
                        case OTHER: return UnshareFolderError.other();
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
                        case ACCESS_ERROR: {
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
                        case OTHER: {
                            value = UnshareFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UnshareFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("other", Tag.OTHER);
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

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param toDropboxId  A account or team member ID to transfer ownership
         *     to. {@code toDropboxId} must have length of at least 1 and not be
         *     {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public TransferFolderArg(String sharedFolderId, String toDropboxId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.toDropboxId = toDropboxId;
            if (toDropboxId == null) {
                throw new IllegalArgumentException("Required value for 'toDropboxId' is null");
            }
            if (toDropboxId.length() < 1) {
                throw new IllegalArgumentException("String 'toDropboxId' is shorter than 1");
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
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * The current account does not have permission to perform this
             * action.
             */
            NO_PERMISSION,
            /**
             * {@link TransferFolderArg#toDropboxId} is invalid.
             */
            INVALID_DROPBOX_ID,
            /**
             * The new designated owner is not currently a member of the shared
             * folder.
             */
            NEW_OWNER_NOT_A_MEMBER,
            /**
             * The new desginated owner does not have the shared folder mounted.
             */
            NEW_OWNER_UNMOUNTED,
            /**
             * The new designated owner's e-mail address is unverified.
             */
            NEW_OWNER_EMAIL_UNVERIFIED,
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
         * handle this {@code TransferFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private TransferFolderError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static TransferFolderError accessError(SharedFolderAccessError value) {
            return new TransferFolderError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * The current account does not have permission to perform this action.
         */
        private static final TransferFolderError NO_PERMISSION_INSTANCE = new TransferFolderError(Tag.NO_PERMISSION);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#NO_PERMISSION}.
         *
         * <p> The current account does not have permission to perform this
         * action. </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#NO_PERMISSION}.
         */
        public static TransferFolderError noPermission() {
            return TransferFolderError.NO_PERMISSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_PERMISSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_PERMISSION}, {@code false} otherwise.
         */
        public boolean isNoPermission() {
            return this.tag == Tag.NO_PERMISSION;
        }

        /**
         * {@link TransferFolderArg#toDropboxId} is invalid.
         */
        private static final TransferFolderError INVALID_DROPBOX_ID_INSTANCE = new TransferFolderError(Tag.INVALID_DROPBOX_ID);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#INVALID_DROPBOX_ID}.
         *
         * <p> {@link TransferFolderArg#toDropboxId} is invalid. </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#INVALID_DROPBOX_ID}.
         */
        public static TransferFolderError invalidDropboxId() {
            return TransferFolderError.INVALID_DROPBOX_ID_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         */
        public boolean isInvalidDropboxId() {
            return this.tag == Tag.INVALID_DROPBOX_ID;
        }

        /**
         * The new designated owner is not currently a member of the shared
         * folder.
         */
        private static final TransferFolderError NEW_OWNER_NOT_A_MEMBER_INSTANCE = new TransferFolderError(Tag.NEW_OWNER_NOT_A_MEMBER);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#NEW_OWNER_NOT_A_MEMBER}.
         *
         * <p> The new designated owner is not currently a member of the shared
         * folder. </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#NEW_OWNER_NOT_A_MEMBER}.
         */
        public static TransferFolderError newOwnerNotAMember() {
            return TransferFolderError.NEW_OWNER_NOT_A_MEMBER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
         */
        public boolean isNewOwnerNotAMember() {
            return this.tag == Tag.NEW_OWNER_NOT_A_MEMBER;
        }

        /**
         * The new desginated owner does not have the shared folder mounted.
         */
        private static final TransferFolderError NEW_OWNER_UNMOUNTED_INSTANCE = new TransferFolderError(Tag.NEW_OWNER_UNMOUNTED);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#NEW_OWNER_UNMOUNTED}.
         *
         * <p> The new desginated owner does not have the shared folder mounted.
         * </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#NEW_OWNER_UNMOUNTED}.
         */
        public static TransferFolderError newOwnerUnmounted() {
            return TransferFolderError.NEW_OWNER_UNMOUNTED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
         */
        public boolean isNewOwnerUnmounted() {
            return this.tag == Tag.NEW_OWNER_UNMOUNTED;
        }

        /**
         * The new designated owner's e-mail address is unverified.
         */
        private static final TransferFolderError NEW_OWNER_EMAIL_UNVERIFIED_INSTANCE = new TransferFolderError(Tag.NEW_OWNER_EMAIL_UNVERIFIED);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#NEW_OWNER_EMAIL_UNVERIFIED}.
         *
         * <p> The new designated owner's e-mail address is unverified. </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#NEW_OWNER_EMAIL_UNVERIFIED}.
         */
        public static TransferFolderError newOwnerEmailUnverified() {
            return TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
         */
        public boolean isNewOwnerEmailUnverified() {
            return this.tag == Tag.NEW_OWNER_EMAIL_UNVERIFIED;
        }

        private static final TransferFolderError OTHER_INSTANCE = new TransferFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code TransferFolderError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code TransferFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static TransferFolderError other() {
            return TransferFolderError.OTHER_INSTANCE;
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

        private TransferFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NO_PERMISSION:
                case INVALID_DROPBOX_ID:
                case NEW_OWNER_NOT_A_MEMBER:
                case NEW_OWNER_UNMOUNTED:
                case NEW_OWNER_EMAIL_UNVERIFIED:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case NO_PERMISSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case INVALID_DROPBOX_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeEndObject();
                        break;
                    case NEW_OWNER_NOT_A_MEMBER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_not_a_member");
                        g.writeEndObject();
                        break;
                    case NEW_OWNER_UNMOUNTED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_unmounted");
                        g.writeEndObject();
                        break;
                    case NEW_OWNER_EMAIL_UNVERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("new_owner_email_unverified");
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
        public static final JsonReader<TransferFolderError> _reader = new JsonReader<TransferFolderError>()
        {
            public final TransferFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return TransferFolderError.other(); }
                    switch (tag) {
                        case NO_PERMISSION: return TransferFolderError.noPermission();
                        case INVALID_DROPBOX_ID: return TransferFolderError.invalidDropboxId();
                        case NEW_OWNER_NOT_A_MEMBER: return TransferFolderError.newOwnerNotAMember();
                        case NEW_OWNER_UNMOUNTED: return TransferFolderError.newOwnerUnmounted();
                        case NEW_OWNER_EMAIL_UNVERIFIED: return TransferFolderError.newOwnerEmailUnverified();
                        case OTHER: return TransferFolderError.other();
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
                        case ACCESS_ERROR: {
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
                        case NO_PERMISSION: {
                            value = TransferFolderError.noPermission();
                            break;
                        }
                        case INVALID_DROPBOX_ID: {
                            value = TransferFolderError.invalidDropboxId();
                            break;
                        }
                        case NEW_OWNER_NOT_A_MEMBER: {
                            value = TransferFolderError.newOwnerNotAMember();
                            break;
                        }
                        case NEW_OWNER_UNMOUNTED: {
                            value = TransferFolderError.newOwnerUnmounted();
                            break;
                        }
                        case NEW_OWNER_EMAIL_UNVERIFIED: {
                            value = TransferFolderError.newOwnerEmailUnverified();
                            break;
                        }
                        case OTHER: {
                            value = TransferFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return TransferFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("no_permission", Tag.NO_PERMISSION);
            _values.put("invalid_dropbox_id", Tag.INVALID_DROPBOX_ID);
            _values.put("new_owner_not_a_member", Tag.NEW_OWNER_NOT_A_MEMBER);
            _values.put("new_owner_unmounted", Tag.NEW_OWNER_UNMOUNTED);
            _values.put("new_owner_email_unverified", Tag.NEW_OWNER_EMAIL_UNVERIFIED);
            _values.put("other", Tag.OTHER);
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

        /**
         * If any of the policy's are unset, then they retain their current
         * setting.
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder.
         * @param memberPolicy  Who can be a member of this shared folder. Only
         *     set this if the current user is on a team.
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UpdateFolderPolicyArg(String sharedFolderId, MemberPolicy memberPolicy, AclUpdatePolicy aclUpdatePolicy, SharedLinkPolicy sharedLinkPolicy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.memberPolicy = memberPolicy;
            this.aclUpdatePolicy = aclUpdatePolicy;
            this.sharedLinkPolicy = sharedLinkPolicy;
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
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * {@link UpdateFolderPolicyArg#memberPolicy} was set even though
             * user is not on a team.
             */
            NOT_ON_TEAM,
            /**
             * Team policy is more restrictive than {@link
             * ShareFolderArg#memberPolicy}.
             */
            TEAM_POLICY_DISALLOWS_MEMBER_POLICY,
            /**
             * The current account is not allowed to select the specified {@link
             * ShareFolderArg#sharedLinkPolicy}.
             */
            DISALLOWED_SHARED_LINK_POLICY,
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
         * handle this {@code UpdateFolderPolicyError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private UpdateFolderPolicyError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code UpdateFolderPolicyError} that has its
         * tag set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UpdateFolderPolicyError} with its tag set
         *     to {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UpdateFolderPolicyError accessError(SharedFolderAccessError value) {
            return new UpdateFolderPolicyError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * {@link UpdateFolderPolicyArg#memberPolicy} was set even though user
         * is not on a team.
         */
        private static final UpdateFolderPolicyError NOT_ON_TEAM_INSTANCE = new UpdateFolderPolicyError(Tag.NOT_ON_TEAM);

        /**
         * Returns an instance of {@code UpdateFolderPolicyError} that has its
         * tag set to {@link Tag#NOT_ON_TEAM}.
         *
         * <p> {@link UpdateFolderPolicyArg#memberPolicy} was set even though
         * user is not on a team. </p>
         *
         * @return Instance of {@code UpdateFolderPolicyError} with its tag set
         *     to {@link Tag#NOT_ON_TEAM}.
         */
        public static UpdateFolderPolicyError notOnTeam() {
            return UpdateFolderPolicyError.NOT_ON_TEAM_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NOT_ON_TEAM}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NOT_ON_TEAM}, {@code false} otherwise.
         */
        public boolean isNotOnTeam() {
            return this.tag == Tag.NOT_ON_TEAM;
        }

        /**
         * Team policy is more restrictive than {@link
         * ShareFolderArg#memberPolicy}.
         */
        private static final UpdateFolderPolicyError TEAM_POLICY_DISALLOWS_MEMBER_POLICY_INSTANCE = new UpdateFolderPolicyError(Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);

        /**
         * Returns an instance of {@code UpdateFolderPolicyError} that has its
         * tag set to {@link Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}.
         *
         * <p> Team policy is more restrictive than {@link
         * ShareFolderArg#memberPolicy}. </p>
         *
         * @return Instance of {@code UpdateFolderPolicyError} with its tag set
         *     to {@link Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}.
         */
        public static UpdateFolderPolicyError teamPolicyDisallowsMemberPolicy() {
            return UpdateFolderPolicyError.TEAM_POLICY_DISALLOWS_MEMBER_POLICY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TEAM_POLICY_DISALLOWS_MEMBER_POLICY}, {@code false}
         *     otherwise.
         */
        public boolean isTeamPolicyDisallowsMemberPolicy() {
            return this.tag == Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY;
        }

        /**
         * The current account is not allowed to select the specified {@link
         * ShareFolderArg#sharedLinkPolicy}.
         */
        private static final UpdateFolderPolicyError DISALLOWED_SHARED_LINK_POLICY_INSTANCE = new UpdateFolderPolicyError(Tag.DISALLOWED_SHARED_LINK_POLICY);

        /**
         * Returns an instance of {@code UpdateFolderPolicyError} that has its
         * tag set to {@link Tag#DISALLOWED_SHARED_LINK_POLICY}.
         *
         * <p> The current account is not allowed to select the specified {@link
         * ShareFolderArg#sharedLinkPolicy}. </p>
         *
         * @return Instance of {@code UpdateFolderPolicyError} with its tag set
         *     to {@link Tag#DISALLOWED_SHARED_LINK_POLICY}.
         */
        public static UpdateFolderPolicyError disallowedSharedLinkPolicy() {
            return UpdateFolderPolicyError.DISALLOWED_SHARED_LINK_POLICY_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#DISALLOWED_SHARED_LINK_POLICY}, {@code false} otherwise.
         */
        public boolean isDisallowedSharedLinkPolicy() {
            return this.tag == Tag.DISALLOWED_SHARED_LINK_POLICY;
        }

        private static final UpdateFolderPolicyError OTHER_INSTANCE = new UpdateFolderPolicyError(Tag.OTHER);

        /**
         * Returns an instance of {@code UpdateFolderPolicyError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code UpdateFolderPolicyError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static UpdateFolderPolicyError other() {
            return UpdateFolderPolicyError.OTHER_INSTANCE;
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

        private UpdateFolderPolicyError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case NOT_ON_TEAM:
                case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                case DISALLOWED_SHARED_LINK_POLICY:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case NOT_ON_TEAM:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("not_on_team");
                        g.writeEndObject();
                        break;
                    case TEAM_POLICY_DISALLOWS_MEMBER_POLICY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("team_policy_disallows_member_policy");
                        g.writeEndObject();
                        break;
                    case DISALLOWED_SHARED_LINK_POLICY:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("disallowed_shared_link_policy");
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
        public static final JsonReader<UpdateFolderPolicyError> _reader = new JsonReader<UpdateFolderPolicyError>()
        {
            public final UpdateFolderPolicyError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UpdateFolderPolicyError.other(); }
                    switch (tag) {
                        case NOT_ON_TEAM: return UpdateFolderPolicyError.notOnTeam();
                        case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: return UpdateFolderPolicyError.teamPolicyDisallowsMemberPolicy();
                        case DISALLOWED_SHARED_LINK_POLICY: return UpdateFolderPolicyError.disallowedSharedLinkPolicy();
                        case OTHER: return UpdateFolderPolicyError.other();
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
                        case ACCESS_ERROR: {
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
                        case NOT_ON_TEAM: {
                            value = UpdateFolderPolicyError.notOnTeam();
                            break;
                        }
                        case TEAM_POLICY_DISALLOWS_MEMBER_POLICY: {
                            value = UpdateFolderPolicyError.teamPolicyDisallowsMemberPolicy();
                            break;
                        }
                        case DISALLOWED_SHARED_LINK_POLICY: {
                            value = UpdateFolderPolicyError.disallowedSharedLinkPolicy();
                            break;
                        }
                        case OTHER: {
                            value = UpdateFolderPolicyError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UpdateFolderPolicyError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("not_on_team", Tag.NOT_ON_TEAM);
            _values.put("team_policy_disallows_member_policy", Tag.TEAM_POLICY_DISALLOWS_MEMBER_POLICY);
            _values.put("disallowed_shared_link_policy", Tag.DISALLOWED_SHARED_LINK_POLICY);
            _values.put("other", Tag.OTHER);
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
        public final java.util.List<AddMember> members;
        /**
         * Whether added members should be notified via email and device
         * notifications of their invite.
         */
        public final boolean quiet;
        /**
         * Optional message to display to added members in their invitation.
         */
        public final String customMessage;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param quiet  Whether added members should be notified via email and
         *     device notifications of their invite.
         * @param members  The intended list of members to add.  Added members
         *     will receive invites to join the shared folder. {@code members}
         *     must not contain a {@code null} item and not be {@code null}.
         * @param customMessage  Optional message to display to added members in
         *     their invitation. {@code customMessage} must have length of at
         *     least 1.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public AddFolderMemberArg(String sharedFolderId, java.util.List<AddMember> members, Boolean quiet, String customMessage) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.members = members;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            for (AddMember x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
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
                    throw new IllegalArgumentException("String 'customMessage' is shorter than 1");
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
                java.util.List<AddMember> members = null;
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
         * The access level to grant {@link AddMember#member} to the shared
         * folder.  {@link AccessLevel#owner} is disallowed.
         */
        public final AccessLevel accessLevel;

        /**
         * The member and type of access the member should have when added to a
         * shared folder.
         *
         * @param member  The member to add to the shared folder. {@code member}
         *     must not be {@code null}.
         * @param accessLevel  The access level to grant {@code member} to the
         *     shared folder.  {@link AccessLevel#owner} is disallowed.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public AddMember(MemberSelector member, AccessLevel accessLevel) {
            this.member = member;
            if (member == null) {
                throw new IllegalArgumentException("Required value for 'member' is null");
            }
            if (accessLevel != null) {
                this.accessLevel = accessLevel;
            }
            else {
                this.accessLevel = AccessLevel.viewer();
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
     * Includes different ways to identify a member of a shared folder.
     */
    public static final class MemberSelector {
        // union MemberSelector

        /**
         * The discriminating tag type for {@link MemberSelector}.
         */
        public enum Tag {
            /**
             * Dropbox account, team member, or group ID of member.
             */
            DROPBOX_ID,  // String
            /**
             * E-mail address of member.
             */
            EMAIL,  // String
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
         * handle this {@code MemberSelector}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String dropboxIdValue;

        private MemberSelector(Tag tag, String value) {
            this.tag = tag;
            this.dropboxIdValue = value;
            validate();
        }

        /**
         * Dropbox account, team member, or group ID of member.
         *
         * <p> This instance must be tagged as {@link Tag#DROPBOX_ID}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isDropboxId} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isDropboxId} is {@code
         *     false}.
         */
        public String getDropboxIdValue() {
            if (this.tag != Tag.DROPBOX_ID) {
                throw new IllegalStateException("getDropboxIdValue() requires tag==DROPBOX_ID, actual tag==" + tag);
            }
            return dropboxIdValue;
        }

        /**
         * Returns an instance of {@code MemberSelector} that has its tag set to
         * {@link Tag#DROPBOX_ID}.
         *
         * <p> Dropbox account, team member, or group ID of member. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code MemberSelector} with its tag set to {@link
         *     Tag#DROPBOX_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static MemberSelector dropboxId(String value) {
            return new MemberSelector(Tag.DROPBOX_ID, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#DROPBOX_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#DROPBOX_ID}, {@code false} otherwise.
         */
        public boolean isDropboxId() {
            return this.tag == Tag.DROPBOX_ID;
        }

        // Reusing dropboxIdValue for email

        /**
         * E-mail address of member.
         *
         * <p> This instance must be tagged as {@link Tag#EMAIL}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isEmail} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isEmail} is {@code false}.
         */
        public String getEmailValue() {
            if (this.tag != Tag.EMAIL) {
                throw new IllegalStateException("getEmailValue() requires tag==EMAIL, actual tag==" + tag);
            }
            return dropboxIdValue;
        }

        /**
         * Returns an instance of {@code MemberSelector} that has its tag set to
         * {@link Tag#EMAIL}.
         *
         * <p> E-mail address of member. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code MemberSelector} with its tag set to {@link
         *     Tag#EMAIL}.
         *
         * @throws IllegalArgumentException  if {@code value} does not match
         *     pattern "{@code
         *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}"
         *     or is {@code null}.
         */
        public static MemberSelector email(String value) {
            return new MemberSelector(Tag.EMAIL, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link Tag#EMAIL},
         * {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link Tag#EMAIL},
         *     {@code false} otherwise.
         */
        public boolean isEmail() {
            return this.tag == Tag.EMAIL;
        }

        private static final MemberSelector OTHER_INSTANCE = new MemberSelector(Tag.OTHER);

        /**
         * Returns an instance of {@code MemberSelector} that has its tag set to
         * {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code MemberSelector} with its tag set to {@link
         *     Tag#OTHER}.
         */
        public static MemberSelector other() {
            return MemberSelector.OTHER_INSTANCE;
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

        private MemberSelector(Tag t) {
            tag = t;
            dropboxIdValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case DROPBOX_ID:
                    if (this.dropboxIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.dropboxIdValue.length() < 1) {
                        throw new IllegalArgumentException("String is shorter than 1");
                    }
                    break;
                case EMAIL:
                    if (this.dropboxIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", this.dropboxIdValue)) {
                        throw new IllegalArgumentException("String does not match pattern");
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
                    case DROPBOX_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("dropbox_id");
                        g.writeStringField("dropbox_id", x.dropboxIdValue);
                        g.writeEndObject();
                        break;
                    case EMAIL:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email");
                        g.writeStringField("email", x.dropboxIdValue);
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
        public static final JsonReader<MemberSelector> _reader = new JsonReader<MemberSelector>()
        {
            public final MemberSelector read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return MemberSelector.other(); }
                    switch (tag) {
                        case OTHER: return MemberSelector.other();
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
                        case DROPBOX_ID: {
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
                        case EMAIL: {
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
                        case OTHER: {
                            value = MemberSelector.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return MemberSelector.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("dropbox_id", Tag.DROPBOX_ID);
            _values.put("email", Tag.EMAIL);
            _values.put("other", Tag.OTHER);
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
            /**
             * Unable to access shared folder.
             */
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * The current account's e-mail address is unverified.
             */
            EMAIL_UNVERIFIED,
            /**
             * {@link AddFolderMemberArg#members} contains a bad invitation
             * recipient.
             */
            BAD_MEMBER,  // AddMemberSelectorError
            /**
             * The current account does not have permission to perform this
             * action.
             */
            NO_PERMISSION,
            /**
             * Your team policy does not allow sharing outside of the team.
             */
            CANT_SHARE_OUTSIDE_TEAM,
            /**
             * The value is the member limit that was reached.
             */
            TOO_MANY_MEMBERS,  // UInt64
            /**
             * The value is the pending invite limit that was reached.
             */
            TOO_MANY_PENDING_INVITES,  // UInt64
            /**
             * The user has reached the rate limit for invitations.
             */
            RATE_LIMIT,
            /**
             * The current user's account doesn't support this action. An
             * example of this is when adding a read-only member. This action
             * can only be performed by users that have upgraded to a Pro or
             * Business plan.
             */
            INSUFFICIENT_PLAN,
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
         * handle this {@code AddFolderMemberError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private AddFolderMemberError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            this.badMemberValue = null;
            this.tooManyMembersValue = null;
            validate();
        }

        /**
         * Unable to access shared folder.
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> Unable to access shared folder. </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static AddFolderMemberError accessError(SharedFolderAccessError value) {
            return new AddFolderMemberError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * The current account's e-mail address is unverified.
         */
        private static final AddFolderMemberError EMAIL_UNVERIFIED_INSTANCE = new AddFolderMemberError(Tag.EMAIL_UNVERIFIED);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#EMAIL_UNVERIFIED}.
         *
         * <p> The current account's e-mail address is unverified. </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#EMAIL_UNVERIFIED}.
         */
        public static AddFolderMemberError emailUnverified() {
            return AddFolderMemberError.EMAIL_UNVERIFIED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#EMAIL_UNVERIFIED}, {@code false} otherwise.
         */
        public boolean isEmailUnverified() {
            return this.tag == Tag.EMAIL_UNVERIFIED;
        }

        private final AddMemberSelectorError badMemberValue;

        private AddFolderMemberError(Tag tag, AddMemberSelectorError value) {
            this.tag = tag;
            this.accessErrorValue = null;
            this.badMemberValue = value;
            this.tooManyMembersValue = null;
            validate();
        }

        /**
         * {@link AddFolderMemberArg#members} contains a bad invitation
         * recipient.
         *
         * <p> This instance must be tagged as {@link Tag#BAD_MEMBER}. </p>
         *
         * @return The {@link AddMemberSelectorError} value associated with this
         *     instance if {@link #isBadMember} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isBadMember} is {@code
         *     false}.
         */
        public AddMemberSelectorError getBadMemberValue() {
            if (this.tag != Tag.BAD_MEMBER) {
                throw new IllegalStateException("getBadMemberValue() requires tag==BAD_MEMBER, actual tag==" + tag);
            }
            return badMemberValue;
        }

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#BAD_MEMBER}.
         *
         * <p> {@link AddFolderMemberArg#members} contains a bad invitation
         * recipient. </p>
         *
         * @param value  {@link AddMemberSelectorError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#BAD_MEMBER}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static AddFolderMemberError badMember(AddMemberSelectorError value) {
            return new AddFolderMemberError(Tag.BAD_MEMBER, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#BAD_MEMBER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#BAD_MEMBER}, {@code false} otherwise.
         */
        public boolean isBadMember() {
            return this.tag == Tag.BAD_MEMBER;
        }

        /**
         * The current account does not have permission to perform this action.
         */
        private static final AddFolderMemberError NO_PERMISSION_INSTANCE = new AddFolderMemberError(Tag.NO_PERMISSION);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#NO_PERMISSION}.
         *
         * <p> The current account does not have permission to perform this
         * action. </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#NO_PERMISSION}.
         */
        public static AddFolderMemberError noPermission() {
            return AddFolderMemberError.NO_PERMISSION_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#NO_PERMISSION}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#NO_PERMISSION}, {@code false} otherwise.
         */
        public boolean isNoPermission() {
            return this.tag == Tag.NO_PERMISSION;
        }

        /**
         * Your team policy does not allow sharing outside of the team.
         */
        private static final AddFolderMemberError CANT_SHARE_OUTSIDE_TEAM_INSTANCE = new AddFolderMemberError(Tag.CANT_SHARE_OUTSIDE_TEAM);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#CANT_SHARE_OUTSIDE_TEAM}.
         *
         * <p> Your team policy does not allow sharing outside of the team. </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#CANT_SHARE_OUTSIDE_TEAM}.
         */
        public static AddFolderMemberError cantShareOutsideTeam() {
            return AddFolderMemberError.CANT_SHARE_OUTSIDE_TEAM_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#CANT_SHARE_OUTSIDE_TEAM}, {@code false} otherwise.
         */
        public boolean isCantShareOutsideTeam() {
            return this.tag == Tag.CANT_SHARE_OUTSIDE_TEAM;
        }

        private final Long tooManyMembersValue;

        private AddFolderMemberError(Tag tag, Long value) {
            this.tag = tag;
            this.accessErrorValue = null;
            this.badMemberValue = null;
            this.tooManyMembersValue = value;
            validate();
        }

        /**
         * The value is the member limit that was reached.
         *
         * <p> This instance must be tagged as {@link Tag#TOO_MANY_MEMBERS}.
         * </p>
         *
         * @return The {@link Long} value associated with this instance if
         *     {@link #isTooManyMembers} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isTooManyMembers} is {@code
         *     false}.
         */
        public Long getTooManyMembersValue() {
            if (this.tag != Tag.TOO_MANY_MEMBERS) {
                throw new IllegalStateException("getTooManyMembersValue() requires tag==TOO_MANY_MEMBERS, actual tag==" + tag);
            }
            return tooManyMembersValue;
        }

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#TOO_MANY_MEMBERS}.
         *
         * <p> The value is the member limit that was reached. </p>
         *
         * @param value  {@link Long} value to assign to this instance.
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#TOO_MANY_MEMBERS}.
         */
        public static AddFolderMemberError tooManyMembers(Long value) {
            return new AddFolderMemberError(Tag.TOO_MANY_MEMBERS, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TOO_MANY_MEMBERS}, {@code false} otherwise.
         */
        public boolean isTooManyMembers() {
            return this.tag == Tag.TOO_MANY_MEMBERS;
        }

        // Reusing tooManyMembersValue for tooManyPendingInvites

        /**
         * The value is the pending invite limit that was reached.
         *
         * <p> This instance must be tagged as {@link
         * Tag#TOO_MANY_PENDING_INVITES}. </p>
         *
         * @return The {@link Long} value associated with this instance if
         *     {@link #isTooManyPendingInvites} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isTooManyPendingInvites} is
         *     {@code false}.
         */
        public Long getTooManyPendingInvitesValue() {
            if (this.tag != Tag.TOO_MANY_PENDING_INVITES) {
                throw new IllegalStateException("getTooManyPendingInvitesValue() requires tag==TOO_MANY_PENDING_INVITES, actual tag==" + tag);
            }
            return tooManyMembersValue;
        }

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#TOO_MANY_PENDING_INVITES}.
         *
         * <p> The value is the pending invite limit that was reached. </p>
         *
         * @param value  {@link Long} value to assign to this instance.
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#TOO_MANY_PENDING_INVITES}.
         */
        public static AddFolderMemberError tooManyPendingInvites(Long value) {
            return new AddFolderMemberError(Tag.TOO_MANY_PENDING_INVITES, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#TOO_MANY_PENDING_INVITES}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#TOO_MANY_PENDING_INVITES}, {@code false} otherwise.
         */
        public boolean isTooManyPendingInvites() {
            return this.tag == Tag.TOO_MANY_PENDING_INVITES;
        }

        /**
         * The user has reached the rate limit for invitations.
         */
        private static final AddFolderMemberError RATE_LIMIT_INSTANCE = new AddFolderMemberError(Tag.RATE_LIMIT);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#RATE_LIMIT}.
         *
         * <p> The user has reached the rate limit for invitations. </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#RATE_LIMIT}.
         */
        public static AddFolderMemberError rateLimit() {
            return AddFolderMemberError.RATE_LIMIT_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#RATE_LIMIT}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#RATE_LIMIT}, {@code false} otherwise.
         */
        public boolean isRateLimit() {
            return this.tag == Tag.RATE_LIMIT;
        }

        /**
         * The current user's account doesn't support this action. An example of
         * this is when adding a read-only member. This action can only be
         * performed by users that have upgraded to a Pro or Business plan.
         */
        private static final AddFolderMemberError INSUFFICIENT_PLAN_INSTANCE = new AddFolderMemberError(Tag.INSUFFICIENT_PLAN);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#INSUFFICIENT_PLAN}.
         *
         * <p> The current user's account doesn't support this action. An
         * example of this is when adding a read-only member. This action can
         * only be performed by users that have upgraded to a Pro or Business
         * plan. </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#INSUFFICIENT_PLAN}.
         */
        public static AddFolderMemberError insufficientPlan() {
            return AddFolderMemberError.INSUFFICIENT_PLAN_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
         */
        public boolean isInsufficientPlan() {
            return this.tag == Tag.INSUFFICIENT_PLAN;
        }

        private static final AddFolderMemberError OTHER_INSTANCE = new AddFolderMemberError(Tag.OTHER);

        /**
         * Returns an instance of {@code AddFolderMemberError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code AddFolderMemberError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static AddFolderMemberError other() {
            return AddFolderMemberError.OTHER_INSTANCE;
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

        private AddFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            badMemberValue = null;
            tooManyMembersValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case EMAIL_UNVERIFIED:
                case NO_PERMISSION:
                case CANT_SHARE_OUTSIDE_TEAM:
                case RATE_LIMIT:
                case INSUFFICIENT_PLAN:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case BAD_MEMBER:
                    if (this.badMemberValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case TOO_MANY_MEMBERS:
                    break;
                case TOO_MANY_PENDING_INVITES:
                    break;
            }
        }

        static final JsonWriter<AddFolderMemberError> _writer = new JsonWriter<AddFolderMemberError>()
        {
            public final void write(AddFolderMemberError x, JsonGenerator g)
              throws IOException
            {
                switch (x.tag) {
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case EMAIL_UNVERIFIED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("email_unverified");
                        g.writeEndObject();
                        break;
                    case BAD_MEMBER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("bad_member");
                        g.writeFieldName("bad_member");
                        AddMemberSelectorError._writer.write(x.badMemberValue, g);
                        g.writeEndObject();
                        break;
                    case NO_PERMISSION:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("no_permission");
                        g.writeEndObject();
                        break;
                    case CANT_SHARE_OUTSIDE_TEAM:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("cant_share_outside_team");
                        g.writeEndObject();
                        break;
                    case TOO_MANY_MEMBERS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_members");
                        g.writeNumberField("too_many_members", x.tooManyMembersValue);
                        g.writeEndObject();
                        break;
                    case TOO_MANY_PENDING_INVITES:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("too_many_pending_invites");
                        g.writeNumberField("too_many_pending_invites", x.tooManyMembersValue);
                        g.writeEndObject();
                        break;
                    case RATE_LIMIT:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("rate_limit");
                        g.writeEndObject();
                        break;
                    case INSUFFICIENT_PLAN:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_plan");
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
        public static final JsonReader<AddFolderMemberError> _reader = new JsonReader<AddFolderMemberError>()
        {
            public final AddFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AddFolderMemberError.other(); }
                    switch (tag) {
                        case EMAIL_UNVERIFIED: return AddFolderMemberError.emailUnverified();
                        case NO_PERMISSION: return AddFolderMemberError.noPermission();
                        case CANT_SHARE_OUTSIDE_TEAM: return AddFolderMemberError.cantShareOutsideTeam();
                        case RATE_LIMIT: return AddFolderMemberError.rateLimit();
                        case INSUFFICIENT_PLAN: return AddFolderMemberError.insufficientPlan();
                        case OTHER: return AddFolderMemberError.other();
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
                        case ACCESS_ERROR: {
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
                        case EMAIL_UNVERIFIED: {
                            value = AddFolderMemberError.emailUnverified();
                            break;
                        }
                        case BAD_MEMBER: {
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
                        case NO_PERMISSION: {
                            value = AddFolderMemberError.noPermission();
                            break;
                        }
                        case CANT_SHARE_OUTSIDE_TEAM: {
                            value = AddFolderMemberError.cantShareOutsideTeam();
                            break;
                        }
                        case TOO_MANY_MEMBERS: {
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
                        case TOO_MANY_PENDING_INVITES: {
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
                        case RATE_LIMIT: {
                            value = AddFolderMemberError.rateLimit();
                            break;
                        }
                        case INSUFFICIENT_PLAN: {
                            value = AddFolderMemberError.insufficientPlan();
                            break;
                        }
                        case OTHER: {
                            value = AddFolderMemberError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AddFolderMemberError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("email_unverified", Tag.EMAIL_UNVERIFIED);
            _values.put("bad_member", Tag.BAD_MEMBER);
            _values.put("no_permission", Tag.NO_PERMISSION);
            _values.put("cant_share_outside_team", Tag.CANT_SHARE_OUTSIDE_TEAM);
            _values.put("too_many_members", Tag.TOO_MANY_MEMBERS);
            _values.put("too_many_pending_invites", Tag.TOO_MANY_PENDING_INVITES);
            _values.put("rate_limit", Tag.RATE_LIMIT);
            _values.put("insufficient_plan", Tag.INSUFFICIENT_PLAN);
            _values.put("other", Tag.OTHER);
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
            /**
             * The value is the ID that could not be identified.
             */
            INVALID_DROPBOX_ID,  // String
            /**
             * The value is the e-email address that is malformed.
             */
            INVALID_EMAIL,  // String
            /**
             * The value is the ID of the Dropbox user with an unverified e-mail
             * address.  Invite unverified users by e-mail address instead of by
             * their Dropbox ID.
             */
            UNVERIFIED_DROPBOX_ID,  // String
            /**
             * At least one of the specified groups in {@link
             * AddFolderMemberArg#members} is deleted.
             */
            GROUP_DELETED,
            /**
             * Sharing to a group that is not on the current account's team.
             */
            GROUP_NOT_ON_TEAM,
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
         * handle this {@code AddMemberSelectorError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final String invalidDropboxIdValue;

        private AddMemberSelectorError(Tag tag, String value) {
            this.tag = tag;
            this.invalidDropboxIdValue = value;
            validate();
        }

        /**
         * The value is the ID that could not be identified.
         *
         * <p> This instance must be tagged as {@link Tag#INVALID_DROPBOX_ID}.
         * </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isInvalidDropboxId} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isInvalidDropboxId} is
         *     {@code false}.
         */
        public String getInvalidDropboxIdValue() {
            if (this.tag != Tag.INVALID_DROPBOX_ID) {
                throw new IllegalStateException("getInvalidDropboxIdValue() requires tag==INVALID_DROPBOX_ID, actual tag==" + tag);
            }
            return invalidDropboxIdValue;
        }

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#INVALID_DROPBOX_ID}.
         *
         * <p> The value is the ID that could not be identified. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#INVALID_DROPBOX_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static AddMemberSelectorError invalidDropboxId(String value) {
            return new AddMemberSelectorError(Tag.INVALID_DROPBOX_ID, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
         */
        public boolean isInvalidDropboxId() {
            return this.tag == Tag.INVALID_DROPBOX_ID;
        }

        // Reusing invalidDropboxIdValue for invalidEmail

        /**
         * The value is the e-email address that is malformed.
         *
         * <p> This instance must be tagged as {@link Tag#INVALID_EMAIL}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isInvalidEmail} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isInvalidEmail} is {@code
         *     false}.
         */
        public String getInvalidEmailValue() {
            if (this.tag != Tag.INVALID_EMAIL) {
                throw new IllegalStateException("getInvalidEmailValue() requires tag==INVALID_EMAIL, actual tag==" + tag);
            }
            return invalidDropboxIdValue;
        }

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#INVALID_EMAIL}.
         *
         * <p> The value is the e-email address that is malformed. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#INVALID_EMAIL}.
         *
         * @throws IllegalArgumentException  if {@code value} does not match
         *     pattern "{@code
         *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}"
         *     or is {@code null}.
         */
        public static AddMemberSelectorError invalidEmail(String value) {
            return new AddMemberSelectorError(Tag.INVALID_EMAIL, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INVALID_EMAIL}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INVALID_EMAIL}, {@code false} otherwise.
         */
        public boolean isInvalidEmail() {
            return this.tag == Tag.INVALID_EMAIL;
        }

        // Reusing invalidDropboxIdValue for unverifiedDropboxId

        /**
         * The value is the ID of the Dropbox user with an unverified e-mail
         * address.  Invite unverified users by e-mail address instead of by
         * their Dropbox ID.
         *
         * <p> This instance must be tagged as {@link
         * Tag#UNVERIFIED_DROPBOX_ID}. </p>
         *
         * @return The {@link String} value associated with this instance if
         *     {@link #isUnverifiedDropboxId} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isUnverifiedDropboxId} is
         *     {@code false}.
         */
        public String getUnverifiedDropboxIdValue() {
            if (this.tag != Tag.UNVERIFIED_DROPBOX_ID) {
                throw new IllegalStateException("getUnverifiedDropboxIdValue() requires tag==UNVERIFIED_DROPBOX_ID, actual tag==" + tag);
            }
            return invalidDropboxIdValue;
        }

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#UNVERIFIED_DROPBOX_ID}.
         *
         * <p> The value is the ID of the Dropbox user with an unverified e-mail
         * address.  Invite unverified users by e-mail address instead of by
         * their Dropbox ID. </p>
         *
         * @param value  {@link String} value to assign to this instance.
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#UNVERIFIED_DROPBOX_ID}.
         *
         * @throws IllegalArgumentException  if {@code value} is shorter than 1
         *     or is {@code null}.
         */
        public static AddMemberSelectorError unverifiedDropboxId(String value) {
            return new AddMemberSelectorError(Tag.UNVERIFIED_DROPBOX_ID, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#UNVERIFIED_DROPBOX_ID}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#UNVERIFIED_DROPBOX_ID}, {@code false} otherwise.
         */
        public boolean isUnverifiedDropboxId() {
            return this.tag == Tag.UNVERIFIED_DROPBOX_ID;
        }

        /**
         * At least one of the specified groups in {@link
         * AddFolderMemberArg#members} is deleted.
         */
        private static final AddMemberSelectorError GROUP_DELETED_INSTANCE = new AddMemberSelectorError(Tag.GROUP_DELETED);

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#GROUP_DELETED}.
         *
         * <p> At least one of the specified groups in {@link
         * AddFolderMemberArg#members} is deleted. </p>
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#GROUP_DELETED}.
         */
        public static AddMemberSelectorError groupDeleted() {
            return AddMemberSelectorError.GROUP_DELETED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#GROUP_DELETED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#GROUP_DELETED}, {@code false} otherwise.
         */
        public boolean isGroupDeleted() {
            return this.tag == Tag.GROUP_DELETED;
        }

        /**
         * Sharing to a group that is not on the current account's team.
         */
        private static final AddMemberSelectorError GROUP_NOT_ON_TEAM_INSTANCE = new AddMemberSelectorError(Tag.GROUP_NOT_ON_TEAM);

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#GROUP_NOT_ON_TEAM}.
         *
         * <p> Sharing to a group that is not on the current account's team.
         * </p>
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#GROUP_NOT_ON_TEAM}.
         */
        public static AddMemberSelectorError groupNotOnTeam() {
            return AddMemberSelectorError.GROUP_NOT_ON_TEAM_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#GROUP_NOT_ON_TEAM}, {@code false} otherwise.
         */
        public boolean isGroupNotOnTeam() {
            return this.tag == Tag.GROUP_NOT_ON_TEAM;
        }

        private static final AddMemberSelectorError OTHER_INSTANCE = new AddMemberSelectorError(Tag.OTHER);

        /**
         * Returns an instance of {@code AddMemberSelectorError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code AddMemberSelectorError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static AddMemberSelectorError other() {
            return AddMemberSelectorError.OTHER_INSTANCE;
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

        private AddMemberSelectorError(Tag t) {
            tag = t;
            invalidDropboxIdValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case GROUP_DELETED:
                case GROUP_NOT_ON_TEAM:
                case OTHER:
                    break;
                case INVALID_DROPBOX_ID:
                    if (this.invalidDropboxIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.invalidDropboxIdValue.length() < 1) {
                        throw new IllegalArgumentException("String is shorter than 1");
                    }
                    break;
                case INVALID_EMAIL:
                    if (this.invalidDropboxIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", this.invalidDropboxIdValue)) {
                        throw new IllegalArgumentException("String does not match pattern");
                    }
                    break;
                case UNVERIFIED_DROPBOX_ID:
                    if (this.invalidDropboxIdValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    if (this.invalidDropboxIdValue.length() < 1) {
                        throw new IllegalArgumentException("String is shorter than 1");
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
                    case INVALID_DROPBOX_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_dropbox_id");
                        g.writeStringField("invalid_dropbox_id", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case INVALID_EMAIL:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("invalid_email");
                        g.writeStringField("invalid_email", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case UNVERIFIED_DROPBOX_ID:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("unverified_dropbox_id");
                        g.writeStringField("unverified_dropbox_id", x.invalidDropboxIdValue);
                        g.writeEndObject();
                        break;
                    case GROUP_DELETED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_deleted");
                        g.writeEndObject();
                        break;
                    case GROUP_NOT_ON_TEAM:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_not_on_team");
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
        public static final JsonReader<AddMemberSelectorError> _reader = new JsonReader<AddMemberSelectorError>()
        {
            public final AddMemberSelectorError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return AddMemberSelectorError.other(); }
                    switch (tag) {
                        case GROUP_DELETED: return AddMemberSelectorError.groupDeleted();
                        case GROUP_NOT_ON_TEAM: return AddMemberSelectorError.groupNotOnTeam();
                        case OTHER: return AddMemberSelectorError.other();
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
                        case INVALID_DROPBOX_ID: {
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
                        case INVALID_EMAIL: {
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
                        case UNVERIFIED_DROPBOX_ID: {
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
                        case GROUP_DELETED: {
                            value = AddMemberSelectorError.groupDeleted();
                            break;
                        }
                        case GROUP_NOT_ON_TEAM: {
                            value = AddMemberSelectorError.groupNotOnTeam();
                            break;
                        }
                        case OTHER: {
                            value = AddMemberSelectorError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return AddMemberSelectorError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("invalid_dropbox_id", Tag.INVALID_DROPBOX_ID);
            _values.put("invalid_email", Tag.INVALID_EMAIL);
            _values.put("unverified_dropbox_id", Tag.UNVERIFIED_DROPBOX_ID);
            _values.put("group_deleted", Tag.GROUP_DELETED);
            _values.put("group_not_on_team", Tag.GROUP_NOT_ON_TEAM);
            _values.put("other", Tag.OTHER);
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


    public static class RemoveFolderMemberArg {
        // struct RemoveFolderMemberArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;
        /**
         * The member to remove from the folder.
         */
        public final MemberSelector member;
        /**
         * If true, the removed user will keep their copy of the folder after
         * it's unshared, assuming it was mounted. Otherwise, it will be removed
         * from their Dropbox. Also, this must be set to false when kicking a
         * group.
         */
        public final boolean leaveACopy;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param member  The member to remove from the folder. {@code member}
         *     must not be {@code null}.
         * @param leaveACopy  If true, the removed user will keep their copy of
         *     the folder after it's unshared, assuming it was mounted.
         *     Otherwise, it will be removed from their Dropbox. Also, this must
         *     be set to false when kicking a group.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public RemoveFolderMemberArg(String sharedFolderId, MemberSelector member, boolean leaveACopy) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.member = member;
            if (member == null) {
                throw new IllegalArgumentException("Required value for 'member' is null");
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
            ACCESS_ERROR,  // SharedFolderAccessError
            MEMBER_ERROR,  // SharedFolderMemberError
            /**
             * The target user is the owner of the shared folder. You can't
             * remove this user until ownership has been transferred to another
             * member.
             */
            FOLDER_OWNER,
            /**
             * The target user has access to the shared folder via a group.
             */
            GROUP_ACCESS,
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
         * handle this {@code RemoveFolderMemberError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private RemoveFolderMemberError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            this.memberErrorValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code RemoveFolderMemberError} that has its
         * tag set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code RemoveFolderMemberError} with its tag set
         *     to {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RemoveFolderMemberError accessError(SharedFolderAccessError value) {
            return new RemoveFolderMemberError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        private final SharedFolderMemberError memberErrorValue;

        private RemoveFolderMemberError(Tag tag, SharedFolderMemberError value) {
            this.tag = tag;
            this.accessErrorValue = null;
            this.memberErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#MEMBER_ERROR}. </p>
         *
         * @return The {@link SharedFolderMemberError} value associated with
         *     this instance if {@link #isMemberError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMemberError} is {@code
         *     false}.
         */
        public SharedFolderMemberError getMemberErrorValue() {
            if (this.tag != Tag.MEMBER_ERROR) {
                throw new IllegalStateException("getMemberErrorValue() requires tag==MEMBER_ERROR, actual tag==" + tag);
            }
            return memberErrorValue;
        }

        /**
         * Returns an instance of {@code RemoveFolderMemberError} that has its
         * tag set to {@link Tag#MEMBER_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderMemberError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code RemoveFolderMemberError} with its tag set
         *     to {@link Tag#MEMBER_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RemoveFolderMemberError memberError(SharedFolderMemberError value) {
            return new RemoveFolderMemberError(Tag.MEMBER_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MEMBER_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MEMBER_ERROR}, {@code false} otherwise.
         */
        public boolean isMemberError() {
            return this.tag == Tag.MEMBER_ERROR;
        }

        /**
         * The target user is the owner of the shared folder. You can't remove
         * this user until ownership has been transferred to another member.
         */
        private static final RemoveFolderMemberError FOLDER_OWNER_INSTANCE = new RemoveFolderMemberError(Tag.FOLDER_OWNER);

        /**
         * Returns an instance of {@code RemoveFolderMemberError} that has its
         * tag set to {@link Tag#FOLDER_OWNER}.
         *
         * <p> The target user is the owner of the shared folder. You can't
         * remove this user until ownership has been transferred to another
         * member. </p>
         *
         * @return Instance of {@code RemoveFolderMemberError} with its tag set
         *     to {@link Tag#FOLDER_OWNER}.
         */
        public static RemoveFolderMemberError folderOwner() {
            return RemoveFolderMemberError.FOLDER_OWNER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FOLDER_OWNER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FOLDER_OWNER}, {@code false} otherwise.
         */
        public boolean isFolderOwner() {
            return this.tag == Tag.FOLDER_OWNER;
        }

        /**
         * The target user has access to the shared folder via a group.
         */
        private static final RemoveFolderMemberError GROUP_ACCESS_INSTANCE = new RemoveFolderMemberError(Tag.GROUP_ACCESS);

        /**
         * Returns an instance of {@code RemoveFolderMemberError} that has its
         * tag set to {@link Tag#GROUP_ACCESS}.
         *
         * <p> The target user has access to the shared folder via a group. </p>
         *
         * @return Instance of {@code RemoveFolderMemberError} with its tag set
         *     to {@link Tag#GROUP_ACCESS}.
         */
        public static RemoveFolderMemberError groupAccess() {
            return RemoveFolderMemberError.GROUP_ACCESS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#GROUP_ACCESS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#GROUP_ACCESS}, {@code false} otherwise.
         */
        public boolean isGroupAccess() {
            return this.tag == Tag.GROUP_ACCESS;
        }

        private static final RemoveFolderMemberError OTHER_INSTANCE = new RemoveFolderMemberError(Tag.OTHER);

        /**
         * Returns an instance of {@code RemoveFolderMemberError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code RemoveFolderMemberError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static RemoveFolderMemberError other() {
            return RemoveFolderMemberError.OTHER_INSTANCE;
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

        private RemoveFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            memberErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FOLDER_OWNER:
                case GROUP_ACCESS:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case MEMBER_ERROR:
                    if (this.memberErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case MEMBER_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("member_error");
                        g.writeFieldName("member_error");
                        SharedFolderMemberError._writer.write(x.memberErrorValue, g);
                        g.writeEndObject();
                        break;
                    case FOLDER_OWNER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("folder_owner");
                        g.writeEndObject();
                        break;
                    case GROUP_ACCESS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_access");
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
        public static final JsonReader<RemoveFolderMemberError> _reader = new JsonReader<RemoveFolderMemberError>()
        {
            public final RemoveFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RemoveFolderMemberError.other(); }
                    switch (tag) {
                        case FOLDER_OWNER: return RemoveFolderMemberError.folderOwner();
                        case GROUP_ACCESS: return RemoveFolderMemberError.groupAccess();
                        case OTHER: return RemoveFolderMemberError.other();
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
                        case ACCESS_ERROR: {
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
                        case MEMBER_ERROR: {
                            SharedFolderMemberError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderMemberError._reader
                                .readField(parser, "member_error", v);
                            value = RemoveFolderMemberError.memberError(v);
                            break;
                        }
                        case FOLDER_OWNER: {
                            value = RemoveFolderMemberError.folderOwner();
                            break;
                        }
                        case GROUP_ACCESS: {
                            value = RemoveFolderMemberError.groupAccess();
                            break;
                        }
                        case OTHER: {
                            value = RemoveFolderMemberError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RemoveFolderMemberError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("member_error", Tag.MEMBER_ERROR);
            _values.put("folder_owner", Tag.FOLDER_OWNER);
            _values.put("group_access", Tag.GROUP_ACCESS);
            _values.put("other", Tag.OTHER);
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
         * The member of the shared folder to update.  Only the {@link
         * MemberSelector#dropboxId} may be set at this time.
         */
        public final MemberSelector member;
        /**
         * The new access level for {@link UpdateFolderMemberArg#member}. {@link
         * AccessLevel#owner} is disallowed.
         */
        public final AccessLevel accessLevel;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         * @param member  The member of the shared folder to update.  Only the
         *     {@link MemberSelector#dropboxId} may be set at this time. {@code
         *     member} must not be {@code null}.
         * @param accessLevel  The new access level for {@code member}. {@link
         *     AccessLevel#owner} is disallowed. {@code accessLevel} must not be
         *     {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UpdateFolderMemberArg(String sharedFolderId, MemberSelector member, AccessLevel accessLevel) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.member = member;
            if (member == null) {
                throw new IllegalArgumentException("Required value for 'member' is null");
            }
            this.accessLevel = accessLevel;
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'accessLevel' is null");
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
            ACCESS_ERROR,  // SharedFolderAccessError
            MEMBER_ERROR,  // SharedFolderMemberError
            /**
             * The current user's account doesn't support this action. An
             * example of this is when downgrading a member from editor to
             * viewer. This action can only be performed by users that have
             * upgraded to a Pro or Business plan.
             */
            INSUFFICIENT_PLAN,
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
         * handle this {@code UpdateFolderMemberError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private UpdateFolderMemberError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            this.memberErrorValue = null;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code UpdateFolderMemberError} that has its
         * tag set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UpdateFolderMemberError} with its tag set
         *     to {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UpdateFolderMemberError accessError(SharedFolderAccessError value) {
            return new UpdateFolderMemberError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        private final SharedFolderMemberError memberErrorValue;

        private UpdateFolderMemberError(Tag tag, SharedFolderMemberError value) {
            this.tag = tag;
            this.accessErrorValue = null;
            this.memberErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#MEMBER_ERROR}. </p>
         *
         * @return The {@link SharedFolderMemberError} value associated with
         *     this instance if {@link #isMemberError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isMemberError} is {@code
         *     false}.
         */
        public SharedFolderMemberError getMemberErrorValue() {
            if (this.tag != Tag.MEMBER_ERROR) {
                throw new IllegalStateException("getMemberErrorValue() requires tag==MEMBER_ERROR, actual tag==" + tag);
            }
            return memberErrorValue;
        }

        /**
         * Returns an instance of {@code UpdateFolderMemberError} that has its
         * tag set to {@link Tag#MEMBER_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderMemberError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UpdateFolderMemberError} with its tag set
         *     to {@link Tag#MEMBER_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UpdateFolderMemberError memberError(SharedFolderMemberError value) {
            return new UpdateFolderMemberError(Tag.MEMBER_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MEMBER_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MEMBER_ERROR}, {@code false} otherwise.
         */
        public boolean isMemberError() {
            return this.tag == Tag.MEMBER_ERROR;
        }

        /**
         * The current user's account doesn't support this action. An example of
         * this is when downgrading a member from editor to viewer. This action
         * can only be performed by users that have upgraded to a Pro or
         * Business plan.
         */
        private static final UpdateFolderMemberError INSUFFICIENT_PLAN_INSTANCE = new UpdateFolderMemberError(Tag.INSUFFICIENT_PLAN);

        /**
         * Returns an instance of {@code UpdateFolderMemberError} that has its
         * tag set to {@link Tag#INSUFFICIENT_PLAN}.
         *
         * <p> The current user's account doesn't support this action. An
         * example of this is when downgrading a member from editor to viewer.
         * This action can only be performed by users that have upgraded to a
         * Pro or Business plan. </p>
         *
         * @return Instance of {@code UpdateFolderMemberError} with its tag set
         *     to {@link Tag#INSUFFICIENT_PLAN}.
         */
        public static UpdateFolderMemberError insufficientPlan() {
            return UpdateFolderMemberError.INSUFFICIENT_PLAN_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSUFFICIENT_PLAN}, {@code false} otherwise.
         */
        public boolean isInsufficientPlan() {
            return this.tag == Tag.INSUFFICIENT_PLAN;
        }

        private static final UpdateFolderMemberError OTHER_INSTANCE = new UpdateFolderMemberError(Tag.OTHER);

        /**
         * Returns an instance of {@code UpdateFolderMemberError} that has its
         * tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code UpdateFolderMemberError} with its tag set
         *     to {@link Tag#OTHER}.
         */
        public static UpdateFolderMemberError other() {
            return UpdateFolderMemberError.OTHER_INSTANCE;
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

        private UpdateFolderMemberError(Tag t) {
            tag = t;
            accessErrorValue = null;
            memberErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INSUFFICIENT_PLAN:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
                    }
                    break;
                case MEMBER_ERROR:
                    if (this.memberErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case MEMBER_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("member_error");
                        g.writeFieldName("member_error");
                        SharedFolderMemberError._writer.write(x.memberErrorValue, g);
                        g.writeEndObject();
                        break;
                    case INSUFFICIENT_PLAN:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_plan");
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
        public static final JsonReader<UpdateFolderMemberError> _reader = new JsonReader<UpdateFolderMemberError>()
        {
            public final UpdateFolderMemberError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UpdateFolderMemberError.other(); }
                    switch (tag) {
                        case INSUFFICIENT_PLAN: return UpdateFolderMemberError.insufficientPlan();
                        case OTHER: return UpdateFolderMemberError.other();
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
                        case ACCESS_ERROR: {
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
                        case MEMBER_ERROR: {
                            SharedFolderMemberError v = null;
                            assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                            text = parser.getText();
                            assert tags[0].equals(text);
                            parser.nextToken();
                            v = SharedFolderMemberError._reader
                                .readField(parser, "member_error", v);
                            value = UpdateFolderMemberError.memberError(v);
                            break;
                        }
                        case INSUFFICIENT_PLAN: {
                            value = UpdateFolderMemberError.insufficientPlan();
                            break;
                        }
                        case OTHER: {
                            value = UpdateFolderMemberError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UpdateFolderMemberError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("member_error", Tag.MEMBER_ERROR);
            _values.put("insufficient_plan", Tag.INSUFFICIENT_PLAN);
            _values.put("other", Tag.OTHER);
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


    public static class MountFolderArg {
        // struct MountFolderArg
        /**
         * The ID of the shared folder to mount.
         */
        public final String sharedFolderId;

        /**
         *
         * @param sharedFolderId  The ID of the shared folder to mount. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public MountFolderArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
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
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * Mounting would cause a shared folder to be inside another, which
             * is disallowed.
             */
            INSIDE_SHARED_FOLDER,
            /**
             * The current user does not have enough space to mount the shared
             * folder.
             */
            INSUFFICIENT_QUOTA,
            /**
             * The shared folder is already mounted.
             */
            ALREADY_MOUNTED,
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
         * handle this {@code MountFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private MountFolderError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code MountFolderError} that has its tag set
         * to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code MountFolderError} with its tag set to
         *     {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static MountFolderError accessError(SharedFolderAccessError value) {
            return new MountFolderError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * Mounting would cause a shared folder to be inside another, which is
         * disallowed.
         */
        private static final MountFolderError INSIDE_SHARED_FOLDER_INSTANCE = new MountFolderError(Tag.INSIDE_SHARED_FOLDER);

        /**
         * Returns an instance of {@code MountFolderError} that has its tag set
         * to {@link Tag#INSIDE_SHARED_FOLDER}.
         *
         * <p> Mounting would cause a shared folder to be inside another, which
         * is disallowed. </p>
         *
         * @return Instance of {@code MountFolderError} with its tag set to
         *     {@link Tag#INSIDE_SHARED_FOLDER}.
         */
        public static MountFolderError insideSharedFolder() {
            return MountFolderError.INSIDE_SHARED_FOLDER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
         */
        public boolean isInsideSharedFolder() {
            return this.tag == Tag.INSIDE_SHARED_FOLDER;
        }

        /**
         * The current user does not have enough space to mount the shared
         * folder.
         */
        private static final MountFolderError INSUFFICIENT_QUOTA_INSTANCE = new MountFolderError(Tag.INSUFFICIENT_QUOTA);

        /**
         * Returns an instance of {@code MountFolderError} that has its tag set
         * to {@link Tag#INSUFFICIENT_QUOTA}.
         *
         * <p> The current user does not have enough space to mount the shared
         * folder. </p>
         *
         * @return Instance of {@code MountFolderError} with its tag set to
         *     {@link Tag#INSUFFICIENT_QUOTA}.
         */
        public static MountFolderError insufficientQuota() {
            return MountFolderError.INSUFFICIENT_QUOTA_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
         */
        public boolean isInsufficientQuota() {
            return this.tag == Tag.INSUFFICIENT_QUOTA;
        }

        /**
         * The shared folder is already mounted.
         */
        private static final MountFolderError ALREADY_MOUNTED_INSTANCE = new MountFolderError(Tag.ALREADY_MOUNTED);

        /**
         * Returns an instance of {@code MountFolderError} that has its tag set
         * to {@link Tag#ALREADY_MOUNTED}.
         *
         * <p> The shared folder is already mounted. </p>
         *
         * @return Instance of {@code MountFolderError} with its tag set to
         *     {@link Tag#ALREADY_MOUNTED}.
         */
        public static MountFolderError alreadyMounted() {
            return MountFolderError.ALREADY_MOUNTED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ALREADY_MOUNTED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ALREADY_MOUNTED}, {@code false} otherwise.
         */
        public boolean isAlreadyMounted() {
            return this.tag == Tag.ALREADY_MOUNTED;
        }

        private static final MountFolderError OTHER_INSTANCE = new MountFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code MountFolderError} that has its tag set
         * to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code MountFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static MountFolderError other() {
            return MountFolderError.OTHER_INSTANCE;
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

        private MountFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case INSIDE_SHARED_FOLDER:
                case INSUFFICIENT_QUOTA:
                case ALREADY_MOUNTED:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case INSIDE_SHARED_FOLDER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("inside_shared_folder");
                        g.writeEndObject();
                        break;
                    case INSUFFICIENT_QUOTA:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("insufficient_quota");
                        g.writeEndObject();
                        break;
                    case ALREADY_MOUNTED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("already_mounted");
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
        public static final JsonReader<MountFolderError> _reader = new JsonReader<MountFolderError>()
        {
            public final MountFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return MountFolderError.other(); }
                    switch (tag) {
                        case INSIDE_SHARED_FOLDER: return MountFolderError.insideSharedFolder();
                        case INSUFFICIENT_QUOTA: return MountFolderError.insufficientQuota();
                        case ALREADY_MOUNTED: return MountFolderError.alreadyMounted();
                        case OTHER: return MountFolderError.other();
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
                        case ACCESS_ERROR: {
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
                        case INSIDE_SHARED_FOLDER: {
                            value = MountFolderError.insideSharedFolder();
                            break;
                        }
                        case INSUFFICIENT_QUOTA: {
                            value = MountFolderError.insufficientQuota();
                            break;
                        }
                        case ALREADY_MOUNTED: {
                            value = MountFolderError.alreadyMounted();
                            break;
                        }
                        case OTHER: {
                            value = MountFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return MountFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("inside_shared_folder", Tag.INSIDE_SHARED_FOLDER);
            _values.put("insufficient_quota", Tag.INSUFFICIENT_QUOTA);
            _values.put("already_mounted", Tag.ALREADY_MOUNTED);
            _values.put("other", Tag.OTHER);
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


    public static class UnmountFolderArg {
        // struct UnmountFolderArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public UnmountFolderArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
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
            ACCESS_ERROR,  // SharedFolderAccessError
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
         * handle this {@code UnmountFolderError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private UnmountFolderError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code UnmountFolderError} that has its tag
         * set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code UnmountFolderError} with its tag set to
         *     {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static UnmountFolderError accessError(SharedFolderAccessError value) {
            return new UnmountFolderError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        private static final UnmountFolderError OTHER_INSTANCE = new UnmountFolderError(Tag.OTHER);

        /**
         * Returns an instance of {@code UnmountFolderError} that has its tag
         * set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code UnmountFolderError} with its tag set to
         *     {@link Tag#OTHER}.
         */
        public static UnmountFolderError other() {
            return UnmountFolderError.OTHER_INSTANCE;
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

        private UnmountFolderError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
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
        public static final JsonReader<UnmountFolderError> _reader = new JsonReader<UnmountFolderError>()
        {
            public final UnmountFolderError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return UnmountFolderError.other(); }
                    switch (tag) {
                        case OTHER: return UnmountFolderError.other();
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
                        case ACCESS_ERROR: {
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
                        case OTHER: {
                            value = UnmountFolderError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return UnmountFolderError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("other", Tag.OTHER);
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


    public static class RelinquishFolderMembershipArg {
        // struct RelinquishFolderMembershipArg
        /**
         * The ID for the shared folder.
         */
        public final String sharedFolderId;

        /**
         *
         * @param sharedFolderId  The ID for the shared folder. {@code
         *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and
         *     not be {@code null}.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public RelinquishFolderMembershipArg(String sharedFolderId) {
            this.sharedFolderId = sharedFolderId;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
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
            ACCESS_ERROR,  // SharedFolderAccessError
            /**
             * The current user is the owner of the shared folder. Owners cannot
             * relinquish membership to their own folders. Try unsharing or
             * transfering ownership first.
             */
            FOLDER_OWNER,
            /**
             * The shared folder is currently mounted.  Unmount the shared
             * folder before relinquishing membership.
             */
            MOUNTED,
            /**
             * The current user has access to the shared folder via a group.
             * You can't relinquish membership to folders shared via groups.
             */
            GROUP_ACCESS,
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
         * handle this {@code RelinquishFolderMembershipError}. </p>
         *
         * @return the tag for this instance.
         */
        public Tag getTag() {
            return this.tag;
        }

        private final SharedFolderAccessError accessErrorValue;

        private RelinquishFolderMembershipError(Tag tag, SharedFolderAccessError value) {
            this.tag = tag;
            this.accessErrorValue = value;
            validate();
        }

        /**
         * None
         *
         * <p> This instance must be tagged as {@link Tag#ACCESS_ERROR}. </p>
         *
         * @return The {@link SharedFolderAccessError} value associated with
         *     this instance if {@link #isAccessError} is {@code true}.
         *
         * @throws IllegalStateException  If {@link #isAccessError} is {@code
         *     false}.
         */
        public SharedFolderAccessError getAccessErrorValue() {
            if (this.tag != Tag.ACCESS_ERROR) {
                throw new IllegalStateException("getAccessErrorValue() requires tag==ACCESS_ERROR, actual tag==" + tag);
            }
            return accessErrorValue;
        }

        /**
         * Returns an instance of {@code RelinquishFolderMembershipError} that
         * has its tag set to {@link Tag#ACCESS_ERROR}.
         *
         * <p> None </p>
         *
         * @param value  {@link SharedFolderAccessError} value to assign to this
         *     instance.
         *
         * @return Instance of {@code RelinquishFolderMembershipError} with its
         *     tag set to {@link Tag#ACCESS_ERROR}.
         *
         * @throws IllegalArgumentException  if {@code value} is {@code null}.
         */
        public static RelinquishFolderMembershipError accessError(SharedFolderAccessError value) {
            return new RelinquishFolderMembershipError(Tag.ACCESS_ERROR, value);
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#ACCESS_ERROR}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#ACCESS_ERROR}, {@code false} otherwise.
         */
        public boolean isAccessError() {
            return this.tag == Tag.ACCESS_ERROR;
        }

        /**
         * The current user is the owner of the shared folder. Owners cannot
         * relinquish membership to their own folders. Try unsharing or
         * transfering ownership first.
         */
        private static final RelinquishFolderMembershipError FOLDER_OWNER_INSTANCE = new RelinquishFolderMembershipError(Tag.FOLDER_OWNER);

        /**
         * Returns an instance of {@code RelinquishFolderMembershipError} that
         * has its tag set to {@link Tag#FOLDER_OWNER}.
         *
         * <p> The current user is the owner of the shared folder. Owners cannot
         * relinquish membership to their own folders. Try unsharing or
         * transfering ownership first. </p>
         *
         * @return Instance of {@code RelinquishFolderMembershipError} with its
         *     tag set to {@link Tag#FOLDER_OWNER}.
         */
        public static RelinquishFolderMembershipError folderOwner() {
            return RelinquishFolderMembershipError.FOLDER_OWNER_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#FOLDER_OWNER}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#FOLDER_OWNER}, {@code false} otherwise.
         */
        public boolean isFolderOwner() {
            return this.tag == Tag.FOLDER_OWNER;
        }

        /**
         * The shared folder is currently mounted.  Unmount the shared folder
         * before relinquishing membership.
         */
        private static final RelinquishFolderMembershipError MOUNTED_INSTANCE = new RelinquishFolderMembershipError(Tag.MOUNTED);

        /**
         * Returns an instance of {@code RelinquishFolderMembershipError} that
         * has its tag set to {@link Tag#MOUNTED}.
         *
         * <p> The shared folder is currently mounted.  Unmount the shared
         * folder before relinquishing membership. </p>
         *
         * @return Instance of {@code RelinquishFolderMembershipError} with its
         *     tag set to {@link Tag#MOUNTED}.
         */
        public static RelinquishFolderMembershipError mounted() {
            return RelinquishFolderMembershipError.MOUNTED_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#MOUNTED}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#MOUNTED}, {@code false} otherwise.
         */
        public boolean isMounted() {
            return this.tag == Tag.MOUNTED;
        }

        /**
         * The current user has access to the shared folder via a group.  You
         * can't relinquish membership to folders shared via groups.
         */
        private static final RelinquishFolderMembershipError GROUP_ACCESS_INSTANCE = new RelinquishFolderMembershipError(Tag.GROUP_ACCESS);

        /**
         * Returns an instance of {@code RelinquishFolderMembershipError} that
         * has its tag set to {@link Tag#GROUP_ACCESS}.
         *
         * <p> The current user has access to the shared folder via a group.
         * You can't relinquish membership to folders shared via groups. </p>
         *
         * @return Instance of {@code RelinquishFolderMembershipError} with its
         *     tag set to {@link Tag#GROUP_ACCESS}.
         */
        public static RelinquishFolderMembershipError groupAccess() {
            return RelinquishFolderMembershipError.GROUP_ACCESS_INSTANCE;
        }

        /**
         * Returns {@code true} if this instance has the tag {@link
         * Tag#GROUP_ACCESS}, {@code false} otherwise.
         *
         * @return {@code true} if this instance is tagged as {@link
         *     Tag#GROUP_ACCESS}, {@code false} otherwise.
         */
        public boolean isGroupAccess() {
            return this.tag == Tag.GROUP_ACCESS;
        }

        private static final RelinquishFolderMembershipError OTHER_INSTANCE = new RelinquishFolderMembershipError(Tag.OTHER);

        /**
         * Returns an instance of {@code RelinquishFolderMembershipError} that
         * has its tag set to {@link Tag#OTHER}.
         *
         * <p> None </p>
         *
         * @return Instance of {@code RelinquishFolderMembershipError} with its
         *     tag set to {@link Tag#OTHER}.
         */
        public static RelinquishFolderMembershipError other() {
            return RelinquishFolderMembershipError.OTHER_INSTANCE;
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

        private RelinquishFolderMembershipError(Tag t) {
            tag = t;
            accessErrorValue = null;
            validate();
        }

        private final void validate() {
            switch (this.tag) {
                case FOLDER_OWNER:
                case MOUNTED:
                case GROUP_ACCESS:
                case OTHER:
                    break;
                case ACCESS_ERROR:
                    if (this.accessErrorValue == null) {
                        throw new IllegalArgumentException("Value is null");
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
                    case ACCESS_ERROR:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("access_error");
                        g.writeFieldName("access_error");
                        SharedFolderAccessError._writer.write(x.accessErrorValue, g);
                        g.writeEndObject();
                        break;
                    case FOLDER_OWNER:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("folder_owner");
                        g.writeEndObject();
                        break;
                    case MOUNTED:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("mounted");
                        g.writeEndObject();
                        break;
                    case GROUP_ACCESS:
                        g.writeStartObject();
                        g.writeFieldName(".tag");
                        g.writeString("group_access");
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
        public static final JsonReader<RelinquishFolderMembershipError> _reader = new JsonReader<RelinquishFolderMembershipError>()
        {
            public final RelinquishFolderMembershipError read(JsonParser parser)
              throws IOException, JsonReadException
            {
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String text = parser.getText();
                    parser.nextToken();
                    Tag tag = _values.get(text);
                    if (tag == null) { return RelinquishFolderMembershipError.other(); }
                    switch (tag) {
                        case FOLDER_OWNER: return RelinquishFolderMembershipError.folderOwner();
                        case MOUNTED: return RelinquishFolderMembershipError.mounted();
                        case GROUP_ACCESS: return RelinquishFolderMembershipError.groupAccess();
                        case OTHER: return RelinquishFolderMembershipError.other();
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
                        case ACCESS_ERROR: {
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
                        case FOLDER_OWNER: {
                            value = RelinquishFolderMembershipError.folderOwner();
                            break;
                        }
                        case MOUNTED: {
                            value = RelinquishFolderMembershipError.mounted();
                            break;
                        }
                        case GROUP_ACCESS: {
                            value = RelinquishFolderMembershipError.groupAccess();
                            break;
                        }
                        case OTHER: {
                            value = RelinquishFolderMembershipError.other();
                            break;
                        }
                    }
                }
                JsonReader.expectObjectEnd(parser);
                if (value == null) { return RelinquishFolderMembershipError.other(); }
                return value;
            }

        };
        private static final java.util.HashMap<String,Tag> _values;
        static {
            _values = new java.util.HashMap<String,Tag>();
            _values.put("access_error", Tag.ACCESS_ERROR);
            _values.put("folder_owner", Tag.FOLDER_OWNER);
            _values.put("mounted", Tag.MOUNTED);
            _values.put("group_access", Tag.GROUP_ACCESS);
            _values.put("other", Tag.OTHER);
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
     * Exception thrown by {@link DbxSharing#getSharedLinkMetadataBuilder}.
     */
    public static class GetSharedLinkMetadataException extends DbxApiException {
        /**
         * The error reported by getSharedLinkMetadata.
         */
        public final SharedLinkError errorValue;

        public GetSharedLinkMetadataException(String requestId, LocalizedText userMessage, SharedLinkError errorValue) {
            super(requestId, userMessage, buildMessage("get_shared_link_metadata", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Get the shared link's metadata.
     */
    private SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg arg)
            throws GetSharedLinkMetadataException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/get_shared_link_metadata",
                                   arg,
                                   false,
                                   GetSharedLinkMetadataArg._writer,
                                   SharedLinkMetadata._reader,
                                   SharedLinkError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinkMetadataException(ew.requestId, ew.userMessage, (SharedLinkError) (ew.errValue));
        }
    }
    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. {@code url} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata getSharedLinkMetadata(String url)
          throws GetSharedLinkMetadataException, DbxException
    {
        GetSharedLinkMetadataArg arg = new GetSharedLinkMetadataArg(url, null, null);
        return getSharedLinkMetadata(arg);
    }
    /**
     * The builder object returned by {@link #getSharedLinkMetadataBuilder}
     */
    public final class GetSharedLinkMetadataBuilder
    {
        private String url;
        private String path;
        private String linkPassword;

        private GetSharedLinkMetadataBuilder(String url)
        {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
        }

        /**
         * Set value for optional request field {@code path}.
         *
         * @param path  If the shared link is to a folder, this parameter can be
         *     used to retrieve the metadata for a specific file or sub-folder
         *     in this folder. A relative path should be used. {@code path} must
         *     match pattern "{@code /.*}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetSharedLinkMetadataBuilder path(String path)
        {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("/.*", path)) {
                    throw new IllegalArgumentException("String does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional request field {@code linkPassword}.
         *
         * @param linkPassword  If the shared link has a password, this
         *     parameter can be used.
         */
        public GetSharedLinkMetadataBuilder linkPassword(String linkPassword)
        {
            this.linkPassword = linkPassword;
            return this;
        }

        /**
         * Issues the request.
         */
        public SharedLinkMetadata start() throws GetSharedLinkMetadataException, DbxException
        {
            GetSharedLinkMetadataArg arg = new GetSharedLinkMetadataArg(url, path, linkPassword);
            return DbxSharing.this.getSharedLinkMetadata(arg);
        }
    }

    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. {@code url} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkMetadataBuilder getSharedLinkMetadataBuilder(String url)
    {
        return new GetSharedLinkMetadataBuilder(url);
    }

    /**
     * Exception thrown by {@link DbxSharing#listSharedLinksBuilder}.
     */
    public static class ListSharedLinksException extends DbxApiException {
        /**
         * The error reported by listSharedLinks.
         */
        public final ListSharedLinksError errorValue;

        public ListSharedLinksException(String requestId, LocalizedText userMessage, ListSharedLinksError errorValue) {
            super(requestId, userMessage, buildMessage("list_shared_links", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path.
     */
    private ListSharedLinksResult listSharedLinks(ListSharedLinksArg arg)
            throws ListSharedLinksException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/list_shared_links",
                                   arg,
                                   false,
                                   ListSharedLinksArg._writer,
                                   ListSharedLinksResult._reader,
                                   ListSharedLinksError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListSharedLinksException(ew.requestId, ew.userMessage, (ListSharedLinksError) (ew.errValue));
        }
    }
    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path.
     */
    public ListSharedLinksResult listSharedLinks()
          throws ListSharedLinksException, DbxException
    {
        ListSharedLinksArg arg = new ListSharedLinksArg(null, null);
        return listSharedLinks(arg);
    }
    /**
     * The builder object returned by {@link #listSharedLinksBuilder}
     */
    public final class ListSharedLinksBuilder
    {
        private String path;
        private String cursor;

        private ListSharedLinksBuilder()
        {
        }

        /**
         * Set value for optional request field {@code path}.
         *
         * @param path  See {@link DbxSharing#listSharedLinksBuilder}
         *     description. {@code path} must match pattern "{@code
         *     ((/|id:).*)|(rev:[0-9a-f]{9,})}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public ListSharedLinksBuilder path(String path)
        {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("((/|id:).*)|(rev:[0-9a-f]{9,})", path)) {
                    throw new IllegalArgumentException("String does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional request field {@code cursor}.
         *
         * @param cursor  The cursor returned by your last call to {@link
         *     DbxSharing#listSharedLinksBuilder}.
         */
        public ListSharedLinksBuilder cursor(String cursor)
        {
            this.cursor = cursor;
            return this;
        }

        /**
         * Issues the request.
         */
        public ListSharedLinksResult start() throws ListSharedLinksException, DbxException
        {
            ListSharedLinksArg arg = new ListSharedLinksArg(path, cursor);
            return DbxSharing.this.listSharedLinks(arg);
        }
    }

    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path.
     */
    public ListSharedLinksBuilder listSharedLinksBuilder()
    {
        return new ListSharedLinksBuilder();
    }

    /**
     * Exception thrown by {@link
     * DbxSharing#modifySharedLinkSettings(String,DbxSharing.SharedLinkSettings)}.
     */
    public static class ModifySharedLinkSettingsException extends DbxApiException {
        /**
         * The error reported by modifySharedLinkSettings.
         */
        public final ModifySharedLinkSettingsError errorValue;

        public ModifySharedLinkSettingsException(String requestId, LocalizedText userMessage, ModifySharedLinkSettingsError errorValue) {
            super(requestId, userMessage, buildMessage("modify_shared_link_settings", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Modify the shared link's settings. If the requested visibility conflict
     * with the shared links policy of the team or the shared folder (in case
     * the linked file is part of a shared folder) then the {@link
     * LinkPermissions#resolvedVisibility} of the returned {@link
     * SharedLinkMetadata} will reflect the actual visibility of the shared link
     * and the {@link LinkPermissions#requestedVisibility} will reflect the
     * requested visibility.
     */
    private SharedLinkMetadata modifySharedLinkSettings(ModifySharedLinkSettingsArgs arg)
            throws ModifySharedLinkSettingsException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/modify_shared_link_settings",
                                   arg,
                                   false,
                                   ModifySharedLinkSettingsArgs._writer,
                                   SharedLinkMetadata._reader,
                                   ModifySharedLinkSettingsError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ModifySharedLinkSettingsException(ew.requestId, ew.userMessage, (ModifySharedLinkSettingsError) (ew.errValue));
        }
    }
    /**
     * Modify the shared link's settings. If the requested visibility conflict
     * with the shared links policy of the team or the shared folder (in case
     * the linked file is part of a shared folder) then the {@link
     * LinkPermissions#resolvedVisibility} of the returned {@link
     * SharedLinkMetadata} will reflect the actual visibility of the shared link
     * and the {@link LinkPermissions#requestedVisibility} will reflect the
     * requested visibility.
     *
     * @param settings  Set of settings for the shared link. {@code settings}
     *     must not be {@code null}.
     * @param url  URL of the shared link to change its settings. {@code url}
     *     must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata modifySharedLinkSettings(String url, SharedLinkSettings settings)
          throws ModifySharedLinkSettingsException, DbxException
    {
        ModifySharedLinkSettingsArgs arg = new ModifySharedLinkSettingsArgs(url, settings);
        return modifySharedLinkSettings(arg);
    }

    /**
     * Exception thrown by {@link
     * DbxSharing#createSharedLinkWithSettings(String,DbxSharing.SharedLinkSettings)}.
     */
    public static class CreateSharedLinkWithSettingsException extends DbxApiException {
        /**
         * The error reported by createSharedLinkWithSettings.
         */
        public final CreateSharedLinkWithSettingsError errorValue;

        public CreateSharedLinkWithSettingsException(String requestId, LocalizedText userMessage, CreateSharedLinkWithSettingsError errorValue) {
            super(requestId, userMessage, buildMessage("create_shared_link_with_settings", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#public_} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     */
    private SharedLinkMetadata createSharedLinkWithSettings(CreateSharedLinkWithSettingsArg arg)
            throws CreateSharedLinkWithSettingsException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/create_shared_link_with_settings",
                                   arg,
                                   false,
                                   CreateSharedLinkWithSettingsArg._writer,
                                   SharedLinkMetadata._reader,
                                   CreateSharedLinkWithSettingsError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateSharedLinkWithSettingsException(ew.requestId, ew.userMessage, (CreateSharedLinkWithSettingsError) (ew.errValue));
        }
    }
    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#public_} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * @param path  The path to be shared by the shared link. {@code path} must
     *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path)
          throws CreateSharedLinkWithSettingsException, DbxException
    {
        CreateSharedLinkWithSettingsArg arg = new CreateSharedLinkWithSettingsArg(path, null);
        return createSharedLinkWithSettings(arg);
    }
    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#public_} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * @param path  The path to be shared by the shared link. {@code path} must
     *     match pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be
     *     {@code null}.
     * @param settings  The requested settings for the newly created shared
     *     link.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path, SharedLinkSettings settings)
          throws CreateSharedLinkWithSettingsException, DbxException
    {
        CreateSharedLinkWithSettingsArg arg = new CreateSharedLinkWithSettingsArg(path, settings);
        return createSharedLinkWithSettings(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#revokeSharedLink(String)}.
     */
    public static class RevokeSharedLinkException extends DbxApiException {
        /**
         * The error reported by revokeSharedLink.
         */
        public final RevokeSharedLinkError errorValue;

        public RevokeSharedLinkException(String requestId, LocalizedText userMessage, RevokeSharedLinkError errorValue) {
            super(requestId, userMessage, buildMessage("revoke_shared_link", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Revoke a shared link. Note that even after revoking a shared link to a
     * file, the file may be accessible if there are shared links leading to any
     * of the file parent folders. To list all shared links that enable access
     * to a specific file, you can use the {@link
     * DbxSharing#listSharedLinksBuilder} with the file as the {@link
     * ListSharedLinksArg#path} argument.
     */
    private void revokeSharedLink(RevokeSharedLinkArg arg)
            throws RevokeSharedLinkException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/revoke_shared_link",
                            arg,
                            false,
                            RevokeSharedLinkArg._writer,
                            JsonReader.VoidReader,
                            RevokeSharedLinkError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeSharedLinkException(ew.requestId, ew.userMessage, (RevokeSharedLinkError) (ew.errValue));
        }
    }
    /**
     * Revoke a shared link. Note that even after revoking a shared link to a
     * file, the file may be accessible if there are shared links leading to any
     * of the file parent folders. To list all shared links that enable access
     * to a specific file, you can use the {@link
     * DbxSharing#listSharedLinksBuilder} with the file as the {@link
     * ListSharedLinksArg#path} argument.
     *
     * @param url  URL of the shared link. {@code url} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void revokeSharedLink(String url)
          throws RevokeSharedLinkException, DbxException
    {
        RevokeSharedLinkArg arg = new RevokeSharedLinkArg(url);
        revokeSharedLink(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#getSharedLinkFileBuilder}.
     */
    public static class GetSharedLinkFileException extends DbxApiException {
        /**
         * The error reported by getSharedLinkFile.
         */
        public final GetSharedLinkFileError errorValue;

        public GetSharedLinkFileException(String requestId, LocalizedText userMessage, GetSharedLinkFileError errorValue) {
            super(requestId, userMessage, buildMessage("get_shared_link_file", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Download the shared link's file from a user's Dropbox.
     */
    private com.dropbox.core.DbxDownloader<SharedLinkMetadata> getSharedLinkFile(GetSharedLinkMetadataArg arg)
            throws GetSharedLinkFileException, DbxException
    {
        try {
            return client.downloadStyle(client.getHost().content,
                                        "2/sharing/get_shared_link_file",
                                        arg,
                                        false,
                                        GetSharedLinkMetadataArg._writer,
                                        SharedLinkMetadata._reader,
                                        GetSharedLinkFileError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinkFileException(ew.requestId, ew.userMessage, (GetSharedLinkFileError) (ew.errValue));
        }
    }
    /**
     * The {@link com.dropbox.core.v2.DbxDownloadStyleBuilder} returned by
     * {@link #getSharedLinkFileBuilder}.
     */
    public final class GetSharedLinkFileBuilder extends DbxDownloadStyleBuilder<SharedLinkMetadata>
    {
        private String url;
        private String path;
        private String linkPassword;

        private GetSharedLinkFileBuilder(String url)
        {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
        }

        /**
         * Set value for optional request field {@code path}.
         *
         * @param path  If the shared link is to a folder, this parameter can be
         *     used to retrieve the metadata for a specific file or sub-folder
         *     in this folder. A relative path should be used. {@code path} must
         *     match pattern "{@code /.*}".
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public GetSharedLinkFileBuilder path(String path)
        {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("/.*", path)) {
                    throw new IllegalArgumentException("String does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional request field {@code linkPassword}.
         *
         * @param linkPassword  If the shared link has a password, this
         *     parameter can be used.
         */
        public GetSharedLinkFileBuilder linkPassword(String linkPassword)
        {
            this.linkPassword = linkPassword;
            return this;
        }

        /**
         * Issues the request.
         */
        public com.dropbox.core.DbxDownloader<SharedLinkMetadata> start() throws GetSharedLinkFileException, DbxException
        {
            GetSharedLinkMetadataArg arg = new GetSharedLinkMetadataArg(url, path, linkPassword);
            return DbxSharing.this.getSharedLinkFile(arg);
        }
    }

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     * @param url  URL of the shared link. {@code url} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkFileBuilder getSharedLinkFileBuilder(String url)
    {
        return new GetSharedLinkFileBuilder(url);
    }

    /**
     * Exception thrown by {@link DbxSharing#getSharedLinks(String)}.
     */
    public static class GetSharedLinksException extends DbxApiException {
        /**
         * The error reported by getSharedLinks.
         */
        public final GetSharedLinksError errorValue;

        public GetSharedLinksException(String requestId, LocalizedText userMessage, GetSharedLinksError errorValue) {
            super(requestId, userMessage, buildMessage("get_shared_links", userMessage, errorValue));
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
     * shortened URL.
     */
    private GetSharedLinksResult getSharedLinks(GetSharedLinksArg arg)
            throws GetSharedLinksException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/get_shared_links",
                                   arg,
                                   false,
                                   GetSharedLinksArg._writer,
                                   GetSharedLinksResult._reader,
                                   GetSharedLinksError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinksException(ew.requestId, ew.userMessage, (GetSharedLinksError) (ew.errValue));
        }
    }
    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL.
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
     * shortened URL.
     *
     * @param path  See {@link DbxSharing#getSharedLinks(String)} description.
     */
    public GetSharedLinksResult getSharedLinks(String path)
          throws GetSharedLinksException, DbxException
    {
        GetSharedLinksArg arg = new GetSharedLinksArg(path);
        return getSharedLinks(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#createSharedLinkBuilder}.
     */
    public static class CreateSharedLinkException extends DbxApiException {
        /**
         * The error reported by createSharedLink.
         */
        public final CreateSharedLinkError errorValue;

        public CreateSharedLinkException(String requestId, LocalizedText userMessage, CreateSharedLinkError errorValue) {
            super(requestId, userMessage, buildMessage("create_shared_link", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link PathLinkMetadata#url} field is the
     * shortened URL if {@link CreateSharedLinkArg#shortUrl} argument is set to
     * {@code true}. Previously, it was technically possible to break a shared
     * link by moving or renaming the corresponding file or folder. In the
     * future, this will no longer be the case, so your app shouldn't rely on
     * this behavior. Instead, if your app needs to revoke a shared link, use
     * {@link DbxSharing#revokeSharedLink(String)}.
     */
    private PathLinkMetadata createSharedLink(CreateSharedLinkArg arg)
            throws CreateSharedLinkException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/create_shared_link",
                                   arg,
                                   false,
                                   CreateSharedLinkArg._writer,
                                   PathLinkMetadata._reader,
                                   CreateSharedLinkError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateSharedLinkException(ew.requestId, ew.userMessage, (CreateSharedLinkError) (ew.errValue));
        }
    }
    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link PathLinkMetadata#url} field is the
     * shortened URL if {@link CreateSharedLinkArg#shortUrl} argument is set to
     * {@code true}. Previously, it was technically possible to break a shared
     * link by moving or renaming the corresponding file or folder. In the
     * future, this will no longer be the case, so your app shouldn't rely on
     * this behavior. Instead, if your app needs to revoke a shared link, use
     * {@link DbxSharing#revokeSharedLink(String)}.
     *
     * @param path  The path to share. {@code path} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code shortUrl}.
         *
         * @param shortUrl  Whether to return a shortened URL.
         */
        public CreateSharedLinkBuilder shortUrl(boolean shortUrl)
        {
            this.shortUrl = shortUrl;
            return this;
        }

        /**
         * Set value for optional request field {@code pendingUpload}.
         *
         * @param pendingUpload  If it's okay to share a path that does not yet
         *     exist, set this to either {@link PendingUploadMode#file} or
         *     {@link PendingUploadMode#folder} to indicate whether to assume
         *     it's a file or folder.
         */
        public CreateSharedLinkBuilder pendingUpload(PendingUploadMode pendingUpload)
        {
            this.pendingUpload = pendingUpload;
            return this;
        }

        /**
         * Issues the request.
         */
        public PathLinkMetadata start() throws CreateSharedLinkException, DbxException
        {
            CreateSharedLinkArg arg = new CreateSharedLinkArg(path, shortUrl, pendingUpload);
            return DbxSharing.this.createSharedLink(arg);
        }
    }

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link PathLinkMetadata#url} field is the
     * shortened URL if {@link CreateSharedLinkArg#shortUrl} argument is set to
     * {@code true}. Previously, it was technically possible to break a shared
     * link by moving or renaming the corresponding file or folder. In the
     * future, this will no longer be the case, so your app shouldn't rely on
     * this behavior. Instead, if your app needs to revoke a shared link, use
     * {@link DbxSharing#revokeSharedLink(String)}.
     *
     * @param path  The path to share. {@code path} must not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkBuilder createSharedLinkBuilder(String path)
    {
        return new CreateSharedLinkBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxSharing#listFolders}.
     */
    public static class ListFoldersException extends DbxApiException {
        public ListFoldersException(String requestId, LocalizedText userMessage) {
            super(requestId, userMessage, buildMessage("list_folders", userMessage));
        }
    }
    /**
     * Return the list of all shared folders the current user has access to.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    public ListFoldersResult listFolders()
            throws ListFoldersException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/list_folders",
                                   null,
                                   false,
                                   null,
                                   ListFoldersResult._reader,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFoldersException(ew.requestId, ew.userMessage);
        }
    }

    /**
     * Exception thrown by {@link DbxSharing#listFoldersContinue(String)}.
     */
    public static class ListFoldersContinueException extends DbxApiException {
        /**
         * The error reported by listFoldersContinue.
         */
        public final ListFoldersContinueError errorValue;

        public ListFoldersContinueException(String requestId, LocalizedText userMessage, ListFoldersContinueError errorValue) {
            super(requestId, userMessage, buildMessage("list_folders/continue", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Once a cursor has been retrieved from {@link DbxSharing#listFolders}, use
     * this to paginate through all shared folders. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     */
    private ListFoldersResult listFoldersContinue(ListFoldersContinueArg arg)
            throws ListFoldersContinueException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/list_folders/continue",
                                   arg,
                                   false,
                                   ListFoldersContinueArg._writer,
                                   ListFoldersResult._reader,
                                   ListFoldersContinueError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFoldersContinueException(ew.requestId, ew.userMessage, (ListFoldersContinueError) (ew.errValue));
        }
    }
    /**
     * Once a cursor has been retrieved from {@link DbxSharing#listFolders}, use
     * this to paginate through all shared folders. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolders} or {@link
     *     DbxSharing#listFoldersContinue(String)}. {@code cursor} must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult listFoldersContinue(String cursor)
          throws ListFoldersContinueException, DbxException
    {
        ListFoldersContinueArg arg = new ListFoldersContinueArg(cursor);
        return listFoldersContinue(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#getFolderMetadata(String)}.
     */
    public static class GetFolderMetadataException extends DbxApiException {
        /**
         * The error reported by getFolderMetadata.
         */
        public final SharedFolderAccessError errorValue;

        public GetFolderMetadataException(String requestId, LocalizedText userMessage, SharedFolderAccessError errorValue) {
            super(requestId, userMessage, buildMessage("get_folder_metadata", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns shared folder metadata by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private SharedFolderMetadata getFolderMetadata(GetMetadataArgs arg)
            throws GetFolderMetadataException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/get_folder_metadata",
                                   arg,
                                   false,
                                   GetMetadataArgs._writer,
                                   SharedFolderMetadata._reader,
                                   SharedFolderAccessError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetFolderMetadataException(ew.requestId, ew.userMessage, (SharedFolderAccessError) (ew.errValue));
        }
    }
    /**
     * Returns shared folder metadata by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId)
          throws GetFolderMetadataException, DbxException
    {
        GetMetadataArgs arg = new GetMetadataArgs(sharedFolderId);
        return getFolderMetadata(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#listFolderMembers(String)}.
     */
    public static class ListFolderMembersException extends DbxApiException {
        /**
         * The error reported by listFolderMembers.
         */
        public final SharedFolderAccessError errorValue;

        public ListFolderMembersException(String requestId, LocalizedText userMessage, SharedFolderAccessError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder_members", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns shared folder membership by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private SharedFolderMembers listFolderMembers(ListFolderMembersArgs arg)
            throws ListFolderMembersException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/list_folder_members",
                                   arg,
                                   false,
                                   ListFolderMembersArgs._writer,
                                   SharedFolderMembers._reader,
                                   SharedFolderAccessError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderMembersException(ew.requestId, ew.userMessage, (SharedFolderAccessError) (ew.errValue));
        }
    }
    /**
     * Returns shared folder membership by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers listFolderMembers(String sharedFolderId)
          throws ListFolderMembersException, DbxException
    {
        ListFolderMembersArgs arg = new ListFolderMembersArgs(sharedFolderId);
        return listFolderMembers(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#listFolderMembersContinue(String)}.
     */
    public static class ListFolderMembersContinueException extends DbxApiException {
        /**
         * The error reported by listFolderMembersContinue.
         */
        public final ListFolderMembersContinueError errorValue;

        public ListFolderMembersContinueException(String requestId, LocalizedText userMessage, ListFolderMembersContinueError errorValue) {
            super(requestId, userMessage, buildMessage("list_folder_members/continue", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listFolderMembers(String)}, use this to paginate through all
     * shared folder members. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     */
    private SharedFolderMembers listFolderMembersContinue(ListFolderMembersContinueArg arg)
            throws ListFolderMembersContinueException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/list_folder_members/continue",
                                   arg,
                                   false,
                                   ListFolderMembersContinueArg._writer,
                                   SharedFolderMembers._reader,
                                   ListFolderMembersContinueError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderMembersContinueException(ew.requestId, ew.userMessage, (ListFolderMembersContinueError) (ew.errValue));
        }
    }
    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listFolderMembers(String)}, use this to paginate through all
     * shared folder members. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolderMembers(String)} or {@link
     *     DbxSharing#listFolderMembersContinue(String)}. {@code cursor} must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers listFolderMembersContinue(String cursor)
          throws ListFolderMembersContinueException, DbxException
    {
        ListFolderMembersContinueArg arg = new ListFolderMembersContinueArg(cursor);
        return listFolderMembersContinue(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#shareFolderBuilder}.
     */
    public static class ShareFolderException extends DbxApiException {
        /**
         * The error reported by shareFolder.
         */
        public final ShareFolderError errorValue;

        public ShareFolderException(String requestId, LocalizedText userMessage, ShareFolderError errorValue) {
            super(requestId, userMessage, buildMessage("share_folder", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    private ShareFolderLaunch shareFolder(ShareFolderArg arg)
            throws ShareFolderException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/share_folder",
                                   arg,
                                   false,
                                   ShareFolderArg._writer,
                                   ShareFolderLaunch._reader,
                                   ShareFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ShareFolderException(ew.requestId, ew.userMessage, (ShareFolderError) (ew.errValue));
        }
    }
    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. {@code path} must match pattern "{@code /.*}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
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
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
        }

        /**
         * Set value for optional request field {@code memberPolicy}.
         *
         * @param memberPolicy  Who can be a member of this shared folder.
         */
        public ShareFolderBuilder memberPolicy(MemberPolicy memberPolicy)
        {
            this.memberPolicy = memberPolicy;
            return this;
        }

        /**
         * Set value for optional request field {@code aclUpdatePolicy}.
         *
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder.
         */
        public ShareFolderBuilder aclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy)
        {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }

        /**
         * Set value for optional request field {@code sharedLinkPolicy}.
         *
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.
         */
        public ShareFolderBuilder sharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy)
        {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        /**
         * Set value for optional request field {@code forceAsync}.
         *
         * @param forceAsync  Whether to force the share to happen
         *     asynchronously.
         */
        public ShareFolderBuilder forceAsync(boolean forceAsync)
        {
            this.forceAsync = forceAsync;
            return this;
        }

        /**
         * Issues the request.
         */
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
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. {@code path} must match pattern "{@code /.*}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ShareFolderBuilder shareFolderBuilder(String path)
    {
        return new ShareFolderBuilder(path);
    }

    /**
     * Exception thrown by {@link DbxSharing#checkShareJobStatus(String)}.
     */
    public static class CheckShareJobStatusException extends DbxApiException {
        /**
         * The error reported by checkShareJobStatus.
         */
        public final DbxAsync.PollError errorValue;

        public CheckShareJobStatusException(String requestId, LocalizedText userMessage, DbxAsync.PollError errorValue) {
            super(requestId, userMessage, buildMessage("check_share_job_status", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the status of an asynchronous job for sharing a folder. Apps must
     * have full Dropbox access to use this endpoint. Warning: This endpoint is
     * in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     */
    private ShareFolderJobStatus checkShareJobStatus(DbxAsync.PollArg arg)
            throws CheckShareJobStatusException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/check_share_job_status",
                                   arg,
                                   false,
                                   DbxAsync.PollArg._writer,
                                   ShareFolderJobStatus._reader,
                                   DbxAsync.PollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CheckShareJobStatusException(ew.requestId, ew.userMessage, (DbxAsync.PollError) (ew.errValue));
        }
    }
    /**
     * Returns the status of an asynchronous job for sharing a folder. Apps must
     * have full Dropbox access to use this endpoint. Warning: This endpoint is
     * in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. {@code
     *     asyncJobId} must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public ShareFolderJobStatus checkShareJobStatus(String asyncJobId)
          throws CheckShareJobStatusException, DbxException
    {
        DbxAsync.PollArg arg = new DbxAsync.PollArg(asyncJobId);
        return checkShareJobStatus(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#checkJobStatus(String)}.
     */
    public static class CheckJobStatusException extends DbxApiException {
        /**
         * The error reported by checkJobStatus.
         */
        public final DbxAsync.PollError errorValue;

        public CheckJobStatusException(String requestId, LocalizedText userMessage, DbxAsync.PollError errorValue) {
            super(requestId, userMessage, buildMessage("check_job_status", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Returns the status of an asynchronous job. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     */
    private JobStatus checkJobStatus(DbxAsync.PollArg arg)
            throws CheckJobStatusException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/check_job_status",
                                   arg,
                                   false,
                                   DbxAsync.PollArg._writer,
                                   JobStatus._reader,
                                   DbxAsync.PollError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CheckJobStatusException(ew.requestId, ew.userMessage, (DbxAsync.PollError) (ew.errValue));
        }
    }
    /**
     * Returns the status of an asynchronous job. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. {@code
     *     asyncJobId} must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public JobStatus checkJobStatus(String asyncJobId)
          throws CheckJobStatusException, DbxException
    {
        DbxAsync.PollArg arg = new DbxAsync.PollArg(asyncJobId);
        return checkJobStatus(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#unshareFolder(String,boolean)}.
     */
    public static class UnshareFolderException extends DbxApiException {
        /**
         * The error reported by unshareFolder.
         */
        public final UnshareFolderError errorValue;

        public UnshareFolderException(String requestId, LocalizedText userMessage, UnshareFolderError errorValue) {
            super(requestId, userMessage, buildMessage("unshare_folder", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link DbxSharing#checkJobStatus(String)} to determine if the action has
     * completed successfully. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     */
    private DbxAsync.LaunchEmptyResult unshareFolder(UnshareFolderArg arg)
            throws UnshareFolderException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/unshare_folder",
                                   arg,
                                   false,
                                   UnshareFolderArg._writer,
                                   DbxAsync.LaunchEmptyResult._reader,
                                   UnshareFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnshareFolderException(ew.requestId, ew.userMessage, (UnshareFolderError) (ew.errValue));
        }
    }
    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link DbxSharing#checkJobStatus(String)} to determine if the action has
     * completed successfully. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param leaveACopy  If true, members of this shared folder will get a copy
     *     of this folder after it's unshared. Otherwise, it will be removed
     *     from their Dropbox. The current user, who is an owner, will always
     *     retain their copy.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public DbxAsync.LaunchEmptyResult unshareFolder(String sharedFolderId, boolean leaveACopy)
          throws UnshareFolderException, DbxException
    {
        UnshareFolderArg arg = new UnshareFolderArg(sharedFolderId, leaveACopy);
        return unshareFolder(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#transferFolder(String,String)}.
     */
    public static class TransferFolderException extends DbxApiException {
        /**
         * The error reported by transferFolder.
         */
        public final TransferFolderError errorValue;

        public TransferFolderException(String requestId, LocalizedText userMessage, TransferFolderError errorValue) {
            super(requestId, userMessage, buildMessage("transfer_folder", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private void transferFolder(TransferFolderArg arg)
            throws TransferFolderException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/transfer_folder",
                            arg,
                            false,
                            TransferFolderArg._writer,
                            JsonReader.VoidReader,
                            TransferFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new TransferFolderException(ew.requestId, ew.userMessage, (TransferFolderError) (ew.errValue));
        }
    }
    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param toDropboxId  A account or team member ID to transfer ownership to.
     *     {@code toDropboxId} must have length of at least 1 and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void transferFolder(String sharedFolderId, String toDropboxId)
          throws TransferFolderException, DbxException
    {
        TransferFolderArg arg = new TransferFolderArg(sharedFolderId, toDropboxId);
        transferFolder(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#updateFolderPolicyBuilder}.
     */
    public static class UpdateFolderPolicyException extends DbxApiException {
        /**
         * The error reported by updateFolderPolicy.
         */
        public final UpdateFolderPolicyError errorValue;

        public UpdateFolderPolicyException(String requestId, LocalizedText userMessage, UpdateFolderPolicyError errorValue) {
            super(requestId, userMessage, buildMessage("update_folder_policy", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private SharedFolderMetadata updateFolderPolicy(UpdateFolderPolicyArg arg)
            throws UpdateFolderPolicyException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/update_folder_policy",
                                   arg,
                                   false,
                                   UpdateFolderPolicyArg._writer,
                                   SharedFolderMetadata._reader,
                                   UpdateFolderPolicyError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderPolicyException(ew.requestId, ew.userMessage, (UpdateFolderPolicyError) (ew.errValue));
        }
    }
    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata updateFolderPolicy(String sharedFolderId)
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
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
        }

        /**
         * Set value for optional request field {@code memberPolicy}.
         *
         * @param memberPolicy  Who can be a member of this shared folder. Only
         *     set this if the current user is on a team.
         */
        public UpdateFolderPolicyBuilder memberPolicy(MemberPolicy memberPolicy)
        {
            this.memberPolicy = memberPolicy;
            return this;
        }

        /**
         * Set value for optional request field {@code aclUpdatePolicy}.
         *
         * @param aclUpdatePolicy  Who can add and remove members of this shared
         *     folder.
         */
        public UpdateFolderPolicyBuilder aclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy)
        {
            this.aclUpdatePolicy = aclUpdatePolicy;
            return this;
        }

        /**
         * Set value for optional request field {@code sharedLinkPolicy}.
         *
         * @param sharedLinkPolicy  The policy to apply to shared links created
         *     for content inside this shared folder.
         */
        public UpdateFolderPolicyBuilder sharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy)
        {
            this.sharedLinkPolicy = sharedLinkPolicy;
            return this;
        }

        /**
         * Issues the request.
         */
        public SharedFolderMetadata start() throws UpdateFolderPolicyException, DbxException
        {
            UpdateFolderPolicyArg arg = new UpdateFolderPolicyArg(sharedFolderId, memberPolicy, aclUpdatePolicy, sharedLinkPolicy);
            return DbxSharing.this.updateFolderPolicy(arg);
        }
    }

    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderPolicyBuilder updateFolderPolicyBuilder(String sharedFolderId)
    {
        return new UpdateFolderPolicyBuilder(sharedFolderId);
    }

    /**
     * Exception thrown by {@link DbxSharing#addFolderMemberBuilder}.
     */
    public static class AddFolderMemberException extends DbxApiException {
        /**
         * The error reported by addFolderMember.
         */
        public final AddFolderMemberError errorValue;

        public AddFolderMemberException(String requestId, LocalizedText userMessage, AddFolderMemberError errorValue) {
            super(requestId, userMessage, buildMessage("add_folder_member", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private void addFolderMember(AddFolderMemberArg arg)
            throws AddFolderMemberException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/add_folder_member",
                            arg,
                            false,
                            AddFolderMemberArg._writer,
                            JsonReader.VoidReader,
                            AddFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new AddFolderMemberException(ew.requestId, ew.userMessage, (AddFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. {@code members} must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void addFolderMember(String sharedFolderId, java.util.List<AddMember> members)
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
        private java.util.List<AddMember> members;
        private Boolean quiet;
        private String customMessage;

        private AddFolderMemberBuilder(String sharedFolderId, java.util.List<AddMember> members)
        {
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            if (members == null) {
                throw new IllegalArgumentException("Required value for 'members' is null");
            }
            for (AddMember x : members) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'members' is null");
                }
            }
            this.members = members;
        }

        /**
         * Set value for optional request field {@code quiet}.
         *
         * @param quiet  Whether added members should be notified via email and
         *     device notifications of their invite.
         */
        public AddFolderMemberBuilder quiet(boolean quiet)
        {
            this.quiet = quiet;
            return this;
        }

        /**
         * Set value for optional request field {@code customMessage}.
         *
         * @param customMessage  Optional message to display to added members in
         *     their invitation. {@code customMessage} must have length of at
         *     least 1.
         *
         * @throws IllegalArgumentException  if any argument does not meet its
         *     preconditions.
         */
        public AddFolderMemberBuilder customMessage(String customMessage)
        {
            if (customMessage != null) {
                if (customMessage.length() < 1) {
                    throw new IllegalArgumentException("String is shorter than 1");
                }
            }
            this.customMessage = customMessage;
            return this;
        }

        /**
         * Issues the request.
         */
        public void start() throws AddFolderMemberException, DbxException
        {
            AddFolderMemberArg arg = new AddFolderMemberArg(sharedFolderId, members, quiet, customMessage);
            DbxSharing.this.addFolderMember(arg);
        }
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. {@code members} must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public AddFolderMemberBuilder addFolderMemberBuilder(String sharedFolderId, java.util.List<AddMember> members)
    {
        return new AddFolderMemberBuilder(sharedFolderId, members);
    }

    /**
     * Exception thrown by {@link
     * DbxSharing#removeFolderMember(String,DbxSharing.MemberSelector,boolean)}.
     */
    public static class RemoveFolderMemberException extends DbxApiException {
        /**
         * The error reported by removeFolderMember.
         */
        public final RemoveFolderMemberError errorValue;

        public RemoveFolderMemberException(String requestId, LocalizedText userMessage, RemoveFolderMemberError errorValue) {
            super(requestId, userMessage, buildMessage("remove_folder_member", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    private DbxAsync.LaunchEmptyResult removeFolderMember(RemoveFolderMemberArg arg)
            throws RemoveFolderMemberException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/remove_folder_member",
                                   arg,
                                   false,
                                   RemoveFolderMemberArg._writer,
                                   DbxAsync.LaunchEmptyResult._reader,
                                   RemoveFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RemoveFolderMemberException(ew.requestId, ew.userMessage, (RemoveFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param member  The member to remove from the folder. {@code member} must
     *     not be {@code null}.
     * @param leaveACopy  If true, the removed user will keep their copy of the
     *     folder after it's unshared, assuming it was mounted. Otherwise, it
     *     will be removed from their Dropbox. Also, this must be set to false
     *     when kicking a group.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public DbxAsync.LaunchEmptyResult removeFolderMember(String sharedFolderId, MemberSelector member, boolean leaveACopy)
          throws RemoveFolderMemberException, DbxException
    {
        RemoveFolderMemberArg arg = new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        return removeFolderMember(arg);
    }

    /**
     * Exception thrown by {@link
     * DbxSharing#updateFolderMember(String,DbxSharing.MemberSelector,DbxSharing.AccessLevel)}.
     */
    public static class UpdateFolderMemberException extends DbxApiException {
        /**
         * The error reported by updateFolderMember.
         */
        public final UpdateFolderMemberError errorValue;

        public UpdateFolderMemberException(String requestId, LocalizedText userMessage, UpdateFolderMemberError errorValue) {
            super(requestId, userMessage, buildMessage("update_folder_member", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Apps must have full Dropbox access to use this endpoint.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private void updateFolderMember(UpdateFolderMemberArg arg)
            throws UpdateFolderMemberException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/update_folder_member",
                            arg,
                            false,
                            UpdateFolderMemberArg._writer,
                            JsonReader.VoidReader,
                            UpdateFolderMemberError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderMemberException(ew.requestId, ew.userMessage, (UpdateFolderMemberError) (ew.errValue));
        }
    }
    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Apps must have full Dropbox access to use this endpoint.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#dropboxId} may be set at this time. {@code
     *     member} must not be {@code null}.
     * @param accessLevel  The new access level for {@code member}. {@link
     *     AccessLevel#owner} is disallowed. {@code accessLevel} must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void updateFolderMember(String sharedFolderId, MemberSelector member, AccessLevel accessLevel)
          throws UpdateFolderMemberException, DbxException
    {
        UpdateFolderMemberArg arg = new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        updateFolderMember(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#mountFolder(String)}.
     */
    public static class MountFolderException extends DbxApiException {
        /**
         * The error reported by mountFolder.
         */
        public final MountFolderError errorValue;

        public MountFolderException(String requestId, LocalizedText userMessage, MountFolderError errorValue) {
            super(requestId, userMessage, buildMessage("mount_folder", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Apps must have full Dropbox access
     * to use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     */
    private SharedFolderMetadata mountFolder(MountFolderArg arg)
            throws MountFolderException, DbxException
    {
        try {
            return client.rpcStyle(client.getHost().api,
                                   "2/sharing/mount_folder",
                                   arg,
                                   false,
                                   MountFolderArg._writer,
                                   SharedFolderMetadata._reader,
                                   MountFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MountFolderException(ew.requestId, ew.userMessage, (MountFolderError) (ew.errValue));
        }
    }
    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Apps must have full Dropbox access
     * to use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID of the shared folder to mount. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata mountFolder(String sharedFolderId)
          throws MountFolderException, DbxException
    {
        MountFolderArg arg = new MountFolderArg(sharedFolderId);
        return mountFolder(arg);
    }

    /**
     * Exception thrown by {@link DbxSharing#unmountFolder(String)}.
     */
    public static class UnmountFolderException extends DbxApiException {
        /**
         * The error reported by unmountFolder.
         */
        public final UnmountFolderError errorValue;

        public UnmountFolderException(String requestId, LocalizedText userMessage, UnmountFolderError errorValue) {
            super(requestId, userMessage, buildMessage("unmount_folder", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link DbxSharing#mountFolder(String)}. Apps
     * must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     */
    private void unmountFolder(UnmountFolderArg arg)
            throws UnmountFolderException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/unmount_folder",
                            arg,
                            false,
                            UnmountFolderArg._writer,
                            JsonReader.VoidReader,
                            UnmountFolderError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnmountFolderException(ew.requestId, ew.userMessage, (UnmountFolderError) (ew.errValue));
        }
    }
    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link DbxSharing#mountFolder(String)}. Apps
     * must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void unmountFolder(String sharedFolderId)
          throws UnmountFolderException, DbxException
    {
        UnmountFolderArg arg = new UnmountFolderArg(sharedFolderId);
        unmountFolder(arg);
    }

    /**
     * Exception thrown by {@link
     * DbxSharing#relinquishFolderMembership(String)}.
     */
    public static class RelinquishFolderMembershipException extends DbxApiException {
        /**
         * The error reported by relinquishFolderMembership.
         */
        public final RelinquishFolderMembershipError errorValue;

        public RelinquishFolderMembershipException(String requestId, LocalizedText userMessage, RelinquishFolderMembershipError errorValue) {
            super(requestId, userMessage, buildMessage("relinquish_folder_membership", userMessage, errorValue));
            this.errorValue = errorValue;
        }
    }
    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     */
    private void relinquishFolderMembership(RelinquishFolderMembershipArg arg)
            throws RelinquishFolderMembershipException, DbxException
    {
        try {
            client.rpcStyle(client.getHost().api,
                            "2/sharing/relinquish_folder_membership",
                            arg,
                            false,
                            RelinquishFolderMembershipArg._writer,
                            JsonReader.VoidReader,
                            RelinquishFolderMembershipError._reader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RelinquishFolderMembershipException(ew.requestId, ew.userMessage, (RelinquishFolderMembershipError) (ew.errValue));
        }
    }
    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. {@code
     *     sharedFolderId} must match pattern "{@code [-_0-9a-zA-Z:]+}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  if any argument does not meet its
     *     preconditions.
     */
    public void relinquishFolderMembership(String sharedFolderId)
          throws RelinquishFolderMembershipException, DbxException
    {
        RelinquishFolderMembershipArg arg = new RelinquishFolderMembershipArg(sharedFolderId);
        relinquishFolderMembership(arg);
    }
}
