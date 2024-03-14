/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Information on linked third party applications.
 */
public class ApiApp {
    // struct team.ApiApp (team_linked_apps.stone)

    protected final String appId;
    protected final String appName;
    protected final String publisher;
    protected final String publisherUrl;
    protected final Date linked;
    protected final boolean isAppFolder;

    /**
     * Information on linked third party applications.
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
    public ApiApp(@Nonnull String appId, @Nonnull String appName, boolean isAppFolder, @Nullable String publisher, @Nullable String publisherUrl, @Nullable Date linked) {
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
        this.linked = LangUtil.truncateMillis(linked);
        this.isAppFolder = isAppFolder;
    }

    /**
     * Information on linked third party applications.
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
    public ApiApp(@Nonnull String appId, @Nonnull String appName, boolean isAppFolder) {
        this(appId, appName, isAppFolder, null, null, null);
    }

    /**
     * The application unique id.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAppId() {
        return appId;
    }

    /**
     * The application name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getAppName() {
        return appName;
    }

    /**
     * Whether the linked application uses a dedicated folder.
     *
     * @return value for this field.
     */
    public boolean getIsAppFolder() {
        return isAppFolder;
    }

    /**
     * The application publisher name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPublisher() {
        return publisher;
    }

    /**
     * The publisher's URL.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPublisherUrl() {
        return publisherUrl;
    }

    /**
     * The time this application was linked.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Date getLinked() {
        return linked;
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
            this.linked = LangUtil.truncateMillis(linked);
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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<ApiApp> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ApiApp value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("app_id");
            StoneSerializers.string().serialize(value.appId, g);
            g.writeFieldName("app_name");
            StoneSerializers.string().serialize(value.appName, g);
            g.writeFieldName("is_app_folder");
            StoneSerializers.boolean_().serialize(value.isAppFolder, g);
            if (value.publisher != null) {
                g.writeFieldName("publisher");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.publisher, g);
            }
            if (value.publisherUrl != null) {
                g.writeFieldName("publisher_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.publisherUrl, g);
            }
            if (value.linked != null) {
                g.writeFieldName("linked");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.linked, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ApiApp deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ApiApp value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_appId = null;
                String f_appName = null;
                Boolean f_isAppFolder = null;
                String f_publisher = null;
                String f_publisherUrl = null;
                Date f_linked = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("app_id".equals(field)) {
                        f_appId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("app_name".equals(field)) {
                        f_appName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_app_folder".equals(field)) {
                        f_isAppFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("publisher".equals(field)) {
                        f_publisher = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("publisher_url".equals(field)) {
                        f_publisherUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("linked".equals(field)) {
                        f_linked = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_appId == null) {
                    throw new JsonParseException(p, "Required field \"app_id\" missing.");
                }
                if (f_appName == null) {
                    throw new JsonParseException(p, "Required field \"app_name\" missing.");
                }
                if (f_isAppFolder == null) {
                    throw new JsonParseException(p, "Required field \"is_app_folder\" missing.");
                }
                value = new ApiApp(f_appId, f_appName, f_isAppFolder, f_publisher, f_publisherUrl, f_linked);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
