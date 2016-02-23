/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

/**
 * Information on linked third party applications
 */
public class ApiApp {
    // struct ApiApp

    private final String appId;
    private final String appName;
    private final String publisher;
    private final String publisherUrl;
    private final Date linked;
    private final boolean isAppFolder;

    /**
     * Information on linked third party applications
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param appId  The application unique id. Must not be {@code null}.
     * @param appName  The application name. Must not be {@code null}.
     * @param isAppFolder  Whether the linked application uses a dedicated
     *     folder.
     * @param publisher  The application publisher name.
     * @param publisherUrl  The publisher's URL.
     * @param linked  The time this application was linked.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ApiApp(String appId, String appName, boolean isAppFolder, String publisher, String publisherUrl, Date linked) {
        if (appId == null) {
            throw new IllegalArgumentException("Required value for 'appId' is null");
        }
        this.appId = appId;
        if (appName == null) {
            throw new IllegalArgumentException("Required value for 'appName' is null");
        }
        this.appName = appName;
        this.publisher = publisher;
        this.publisherUrl = publisherUrl;
        this.linked = linked;
        this.isAppFolder = isAppFolder;
    }

    /**
     * Information on linked third party applications
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param appId  The application unique id. Must not be {@code null}.
     * @param appName  The application name. Must not be {@code null}.
     * @param isAppFolder  Whether the linked application uses a dedicated
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ApiApp(String appId, String appName, boolean isAppFolder) {
        this(appId, appName, isAppFolder, null, null, null);
    }

    /**
     * The application unique id
     *
     * @return value for this field, never {@code null}.
     */
    public String getAppId() {
        return appId;
    }

    /**
     * The application name
     *
     * @return value for this field, never {@code null}.
     */
    public String getAppName() {
        return appName;
    }

    /**
     * The application publisher name
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * The publisher's URL
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPublisherUrl() {
        return publisherUrl;
    }

    /**
     * The time this application was linked
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getLinked() {
        return linked;
    }

    /**
     * Whether the linked application uses a dedicated folder
     *
     * @return value for this field.
     */
    public boolean getIsAppFolder() {
        return isAppFolder;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param appId  The application unique id. Must not be {@code null}.
     * @param appName  The application name. Must not be {@code null}.
     * @param isAppFolder  Whether the linked application uses a dedicated
     *     folder.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String appId, String appName, boolean isAppFolder) {
        return new Builder(appId, appName, isAppFolder);
    }

    /**
     * Builder for {@link ApiApp}.
     */
    public static class Builder {
        protected final String appId;
        protected final String appName;
        protected final boolean isAppFolder;

        protected String publisher;
        protected String publisherUrl;
        protected Date linked;

        protected Builder(String appId, String appName, boolean isAppFolder) {
            if (appId == null) {
                throw new IllegalArgumentException("Required value for 'appId' is null");
            }
            this.appId = appId;
            if (appName == null) {
                throw new IllegalArgumentException("Required value for 'appName' is null");
            }
            this.appName = appName;
            this.isAppFolder = isAppFolder;
            this.publisher = null;
            this.publisherUrl = null;
            this.linked = null;
        }

        /**
         * Set value for optional field.
         *
         * @param publisher  The application publisher name.
         *
         * @return this builder
         */
        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param publisherUrl  The publisher's URL.
         *
         * @return this builder
         */
        public Builder withPublisherUrl(String publisherUrl) {
            this.publisherUrl = publisherUrl;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linked  The time this application was linked.
         *
         * @return this builder
         */
        public Builder withLinked(Date linked) {
            this.linked = linked;
            return this;
        }

        /**
         * Builds an instance of {@link ApiApp} configured with this builder's
         * values
         *
         * @return new instance of {@link ApiApp}
         */
        public ApiApp build() {
            return new ApiApp(appId, appName, isAppFolder, publisher, publisherUrl, linked);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            appId,
            appName,
            publisher,
            publisherUrl,
            linked,
            isAppFolder
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ApiApp other = (ApiApp) obj;
            return ((this.appId == other.appId) || (this.appId.equals(other.appId)))
                && ((this.appName == other.appName) || (this.appName.equals(other.appName)))
                && ((this.publisher == other.publisher) || (this.publisher != null && this.publisher.equals(other.publisher)))
                && ((this.publisherUrl == other.publisherUrl) || (this.publisherUrl != null && this.publisherUrl.equals(other.publisherUrl)))
                && ((this.linked == other.linked) || (this.linked != null && this.linked.equals(other.linked)))
                && (this.isAppFolder == other.isAppFolder)
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ApiApp fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ApiApp> _JSON_WRITER = new JsonWriter<ApiApp>() {
        public final void write(ApiApp x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ApiApp._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ApiApp x, JsonGenerator g) throws IOException {
            g.writeFieldName("app_id");
            g.writeString(x.appId);
            g.writeFieldName("app_name");
            g.writeString(x.appName);
            if (x.publisher != null) {
                g.writeFieldName("publisher");
                g.writeString(x.publisher);
            }
            if (x.publisherUrl != null) {
                g.writeFieldName("publisher_url");
                g.writeString(x.publisherUrl);
            }
            if (x.linked != null) {
                g.writeFieldName("linked");
                writeDateIso(x.linked, g);
            }
            g.writeFieldName("is_app_folder");
            g.writeBoolean(x.isAppFolder);
        }
    };

    public static final JsonReader<ApiApp> _JSON_READER = new JsonReader<ApiApp>() {
        public final ApiApp read(JsonParser parser) throws IOException, JsonReadException {
            ApiApp result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ApiApp readFields(JsonParser parser) throws IOException, JsonReadException {
            String appId = null;
            String appName = null;
            Boolean isAppFolder = null;
            String publisher = null;
            String publisherUrl = null;
            Date linked = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("app_id".equals(fieldName)) {
                    appId = JsonReader.StringReader
                        .readField(parser, "app_id", appId);
                }
                else if ("app_name".equals(fieldName)) {
                    appName = JsonReader.StringReader
                        .readField(parser, "app_name", appName);
                }
                else if ("is_app_folder".equals(fieldName)) {
                    isAppFolder = JsonReader.BooleanReader
                        .readField(parser, "is_app_folder", isAppFolder);
                }
                else if ("publisher".equals(fieldName)) {
                    publisher = JsonReader.StringReader
                        .readField(parser, "publisher", publisher);
                }
                else if ("publisher_url".equals(fieldName)) {
                    publisherUrl = JsonReader.StringReader
                        .readField(parser, "publisher_url", publisherUrl);
                }
                else if ("linked".equals(fieldName)) {
                    linked = JsonDateReader.DropboxV2
                        .readField(parser, "linked", linked);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (appId == null) {
                throw new JsonReadException("Required field \"app_id\" is missing.", parser.getTokenLocation());
            }
            if (appName == null) {
                throw new JsonReadException("Required field \"app_name\" is missing.", parser.getTokenLocation());
            }
            if (isAppFolder == null) {
                throw new JsonReadException("Required field \"is_app_folder\" is missing.", parser.getTokenLocation());
            }
            return new ApiApp(appId, appName, isAppFolder, publisher, publisherUrl, linked);
        }
    };
}
