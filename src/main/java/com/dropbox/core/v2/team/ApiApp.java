/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

/**
 * Information on linked third party applications
 */
@JsonSerialize(using=ApiApp.Serializer.class)
@JsonDeserialize(using=ApiApp.Deserializer.class)
public class ApiApp {
    // struct ApiApp

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String appId;
    protected final String appName;
    protected final String publisher;
    protected final String publisherUrl;
    protected final Date linked;
    protected final boolean isAppFolder;

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
        this.linked = com.dropbox.core.util.LangUtil.truncateMillis(linked);
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
            this.linked = com.dropbox.core.util.LangUtil.truncateMillis(linked);
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
                && (this.isAppFolder == other.isAppFolder)
                && ((this.publisher == other.publisher) || (this.publisher != null && this.publisher.equals(other.publisher)))
                && ((this.publisherUrl == other.publisherUrl) || (this.publisherUrl != null && this.publisherUrl.equals(other.publisherUrl)))
                && ((this.linked == other.linked) || (this.linked != null && this.linked.equals(other.linked)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ApiApp> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ApiApp.class);
        }

        public Serializer(boolean unwrapping) {
            super(ApiApp.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ApiApp> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ApiApp value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("app_id", value.appId);
            g.writeObjectField("app_name", value.appName);
            g.writeObjectField("is_app_folder", value.isAppFolder);
            if (value.publisher != null) {
                g.writeObjectField("publisher", value.publisher);
            }
            if (value.publisherUrl != null) {
                g.writeObjectField("publisher_url", value.publisherUrl);
            }
            if (value.linked != null) {
                g.writeObjectField("linked", value.linked);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ApiApp> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ApiApp.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ApiApp.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ApiApp> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ApiApp deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String appId = null;
            String appName = null;
            Boolean isAppFolder = null;
            String publisher = null;
            String publisherUrl = null;
            Date linked = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("app_id".equals(_field)) {
                    appId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("app_name".equals(_field)) {
                    appName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("is_app_folder".equals(_field)) {
                    isAppFolder = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("publisher".equals(_field)) {
                    publisher = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("publisher_url".equals(_field)) {
                    publisherUrl = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("linked".equals(_field)) {
                    linked = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (appId == null) {
                throw new JsonParseException(_p, "Required field \"app_id\" is missing.");
            }
            if (appName == null) {
                throw new JsonParseException(_p, "Required field \"app_name\" is missing.");
            }
            if (isAppFolder == null) {
                throw new JsonParseException(_p, "Required field \"is_app_folder\" is missing.");
            }

            return new ApiApp(appId, appName, isAppFolder, publisher, publisherUrl, linked);
        }
    }
}
