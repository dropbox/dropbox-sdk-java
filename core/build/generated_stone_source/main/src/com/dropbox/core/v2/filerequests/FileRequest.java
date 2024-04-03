/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A <a href="https://www.dropbox.com/help/9090">file request</a> for receiving
 * files into the user's Dropbox account.
 */
public class FileRequest {
    // struct file_requests.FileRequest (file_requests.stone)

    @Nonnull
    protected final String id;
    @Nonnull
    protected final String url;
    @Nonnull
    protected final String title;
    @Nullable
    protected final String destination;
    @Nonnull
    protected final Date created;
    @Nullable
    protected final FileRequestDeadline deadline;
    protected final boolean isOpen;
    protected final long fileCount;
    @Nullable
    protected final String description;

    /**
     * A <a href="https://www.dropbox.com/help/9090">file request</a> for
     * receiving files into the user's Dropbox account.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param id  The ID of the file request. Must have length of at least 1,
     *     match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code null}.
     * @param url  The URL of the file request. Must have length of at least 1
     *     and not be {@code null}.
     * @param title  The title of the file request. Must have length of at least
     *     1 and not be {@code null}.
     * @param created  When this file request was created. Must not be {@code
     *     null}.
     * @param isOpen  Whether or not the file request is open. If the file
     *     request is closed, it will not accept any more file submissions.
     * @param fileCount  The number of files this file request has received.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. This can be {@code null} if the destination was
     *     removed. For apps with the app folder permission, this will be
     *     relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}".
     * @param deadline  The deadline for this file request. Only set if the
     *     request has a deadline.
     * @param description  A description of the file request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequest(@Nonnull String id, @Nonnull String url, @Nonnull String title, @Nonnull Date created, boolean isOpen, long fileCount, @Nullable String destination, @Nullable FileRequestDeadline deadline, @Nullable String description) {
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z]+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        if (url.length() < 1) {
            throw new IllegalArgumentException("String 'url' is shorter than 1");
        }
        this.url = url;
        if (title == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        if (title.length() < 1) {
            throw new IllegalArgumentException("String 'title' is shorter than 1");
        }
        this.title = title;
        if (destination != null) {
            if (!Pattern.matches("/(.|[\\r\\n])*", destination)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
        }
        this.destination = destination;
        if (created == null) {
            throw new IllegalArgumentException("Required value for 'created' is null");
        }
        this.created = LangUtil.truncateMillis(created);
        this.deadline = deadline;
        this.isOpen = isOpen;
        this.fileCount = fileCount;
        this.description = description;
    }

    /**
     * A <a href="https://www.dropbox.com/help/9090">file request</a> for
     * receiving files into the user's Dropbox account.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param id  The ID of the file request. Must have length of at least 1,
     *     match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code null}.
     * @param url  The URL of the file request. Must have length of at least 1
     *     and not be {@code null}.
     * @param title  The title of the file request. Must have length of at least
     *     1 and not be {@code null}.
     * @param created  When this file request was created. Must not be {@code
     *     null}.
     * @param isOpen  Whether or not the file request is open. If the file
     *     request is closed, it will not accept any more file submissions.
     * @param fileCount  The number of files this file request has received.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequest(@Nonnull String id, @Nonnull String url, @Nonnull String title, @Nonnull Date created, boolean isOpen, long fileCount) {
        this(id, url, title, created, isOpen, fileCount, null, null, null);
    }

    /**
     * The ID of the file request.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getId() {
        return id;
    }

    /**
     * The URL of the file request.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * The title of the file request.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTitle() {
        return title;
    }

    /**
     * When this file request was created.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getCreated() {
        return created;
    }

    /**
     * Whether or not the file request is open. If the file request is closed,
     * it will not accept any more file submissions.
     *
     * @return value for this field.
     */
    public boolean getIsOpen() {
        return isOpen;
    }

    /**
     * The number of files this file request has received.
     *
     * @return value for this field.
     */
    public long getFileCount() {
        return fileCount;
    }

    /**
     * The path of the folder in the Dropbox where uploaded files will be sent.
     * This can be {@code null} if the destination was removed. For apps with
     * the app folder permission, this will be relative to the app folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDestination() {
        return destination;
    }

    /**
     * The deadline for this file request. Only set if the request has a
     * deadline.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileRequestDeadline getDeadline() {
        return deadline;
    }

    /**
     * A description of the file request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getDescription() {
        return description;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param id  The ID of the file request. Must have length of at least 1,
     *     match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code null}.
     * @param url  The URL of the file request. Must have length of at least 1
     *     and not be {@code null}.
     * @param title  The title of the file request. Must have length of at least
     *     1 and not be {@code null}.
     * @param created  When this file request was created. Must not be {@code
     *     null}.
     * @param isOpen  Whether or not the file request is open. If the file
     *     request is closed, it will not accept any more file submissions.
     * @param fileCount  The number of files this file request has received.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String id, String url, String title, Date created, boolean isOpen, long fileCount) {
        return new Builder(id, url, title, created, isOpen, fileCount);
    }

    /**
     * Builder for {@link FileRequest}.
     */
    public static class Builder {
        protected final String id;
        protected final String url;
        protected final String title;
        protected final Date created;
        protected final boolean isOpen;
        protected final long fileCount;

        protected String destination;
        protected FileRequestDeadline deadline;
        protected String description;

        protected Builder(String id, String url, String title, Date created, boolean isOpen, long fileCount) {
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z]+", id)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.id = id;
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            if (url.length() < 1) {
                throw new IllegalArgumentException("String 'url' is shorter than 1");
            }
            this.url = url;
            if (title == null) {
                throw new IllegalArgumentException("Required value for 'title' is null");
            }
            if (title.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
            this.title = title;
            if (created == null) {
                throw new IllegalArgumentException("Required value for 'created' is null");
            }
            this.created = LangUtil.truncateMillis(created);
            this.isOpen = isOpen;
            this.fileCount = fileCount;
            this.destination = null;
            this.deadline = null;
            this.description = null;
        }

        /**
         * Set value for optional field.
         *
         * @param destination  The path of the folder in the Dropbox where
         *     uploaded files will be sent. This can be {@code null} if the
         *     destination was removed. For apps with the app folder permission,
         *     this will be relative to the app folder. Must match pattern
         *     "{@code /(.|[\\r\\n])*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDestination(String destination) {
            if (destination != null) {
                if (!Pattern.matches("/(.|[\\r\\n])*", destination)) {
                    throw new IllegalArgumentException("String 'destination' does not match pattern");
                }
            }
            this.destination = destination;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param deadline  The deadline for this file request. Only set if the
         *     request has a deadline.
         *
         * @return this builder
         */
        public Builder withDeadline(FileRequestDeadline deadline) {
            this.deadline = deadline;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param description  A description of the file request.
         *
         * @return this builder
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds an instance of {@link FileRequest} configured with this
         * builder's values
         *
         * @return new instance of {@link FileRequest}
         */
        public FileRequest build() {
            return new FileRequest(id, url, title, created, isOpen, fileCount, destination, deadline, description);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.id,
            this.url,
            this.title,
            this.destination,
            this.created,
            this.deadline,
            this.isOpen,
            this.fileCount,
            this.description
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
            FileRequest other = (FileRequest) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.title == other.title) || (this.title.equals(other.title)))
                && ((this.created == other.created) || (this.created.equals(other.created)))
                && (this.isOpen == other.isOpen)
                && (this.fileCount == other.fileCount)
                && ((this.destination == other.destination) || (this.destination != null && this.destination.equals(other.destination)))
                && ((this.deadline == other.deadline) || (this.deadline != null && this.deadline.equals(other.deadline)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
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
    static class Serializer extends StructSerializer<FileRequest> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileRequest value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("title");
            StoneSerializers.string().serialize(value.title, g);
            g.writeFieldName("created");
            StoneSerializers.timestamp().serialize(value.created, g);
            g.writeFieldName("is_open");
            StoneSerializers.boolean_().serialize(value.isOpen, g);
            g.writeFieldName("file_count");
            StoneSerializers.int64().serialize(value.fileCount, g);
            if (value.destination != null) {
                g.writeFieldName("destination");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.destination, g);
            }
            if (value.deadline != null) {
                g.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(value.deadline, g);
            }
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileRequest deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileRequest value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_url = null;
                String f_title = null;
                Date f_created = null;
                Boolean f_isOpen = null;
                Long f_fileCount = null;
                String f_destination = null;
                FileRequestDeadline f_deadline = null;
                String f_description = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("title".equals(field)) {
                        f_title = StoneSerializers.string().deserialize(p);
                    }
                    else if ("created".equals(field)) {
                        f_created = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("is_open".equals(field)) {
                        f_isOpen = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("file_count".equals(field)) {
                        f_fileCount = StoneSerializers.int64().deserialize(p);
                    }
                    else if ("destination".equals(field)) {
                        f_destination = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("deadline".equals(field)) {
                        f_deadline = StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_title == null) {
                    throw new JsonParseException(p, "Required field \"title\" missing.");
                }
                if (f_created == null) {
                    throw new JsonParseException(p, "Required field \"created\" missing.");
                }
                if (f_isOpen == null) {
                    throw new JsonParseException(p, "Required field \"is_open\" missing.");
                }
                if (f_fileCount == null) {
                    throw new JsonParseException(p, "Required field \"file_count\" missing.");
                }
                value = new FileRequest(f_id, f_url, f_title, f_created, f_isOpen, f_fileCount, f_destination, f_deadline, f_description);
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
