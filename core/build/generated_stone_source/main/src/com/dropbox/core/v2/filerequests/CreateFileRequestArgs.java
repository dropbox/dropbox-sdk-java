/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Arguments for {@link DbxUserFileRequestsRequests#create(String,String)}.
 */
class CreateFileRequestArgs {
    // struct file_requests.CreateFileRequestArgs (file_requests.stone)

    protected final String title;
    protected final String destination;
    protected final FileRequestDeadline deadline;
    protected final boolean open;
    protected final String description;

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#create(String,String)}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param title  The title of the file request. Must not be empty. Must have
     *     length of at least 1 and not be {@code null}.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. For apps with the app folder permission, this
     *     will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param deadline  The deadline for the file request. Deadlines can only be
     *     set by Professional and Business accounts.
     * @param open  Whether or not the file request should be open. If the file
     *     request is closed, it will not accept any file submissions, but it
     *     can be opened later.
     * @param description  A description of the file request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFileRequestArgs(@Nonnull String title, @Nonnull String destination, @Nullable FileRequestDeadline deadline, boolean open, @Nullable String description) {
        if (title == null) {
            throw new IllegalArgumentException("Required value for 'title' is null");
        }
        if (title.length() < 1) {
            throw new IllegalArgumentException("String 'title' is shorter than 1");
        }
        this.title = title;
        if (destination == null) {
            throw new IllegalArgumentException("Required value for 'destination' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*", destination)) {
            throw new IllegalArgumentException("String 'destination' does not match pattern");
        }
        this.destination = destination;
        this.deadline = deadline;
        this.open = open;
        this.description = description;
    }

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#create(String,String)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param title  The title of the file request. Must not be empty. Must have
     *     length of at least 1 and not be {@code null}.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. For apps with the app folder permission, this
     *     will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFileRequestArgs(String title, String destination) {
        this(title, destination, null, true, null);
    }

    /**
     * The title of the file request. Must not be empty.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTitle() {
        return title;
    }

    /**
     * The path of the folder in the Dropbox where uploaded files will be sent.
     * For apps with the app folder permission, this will be relative to the app
     * folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getDestination() {
        return destination;
    }

    /**
     * The deadline for the file request. Deadlines can only be set by
     * Professional and Business accounts.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FileRequestDeadline getDeadline() {
        return deadline;
    }

    /**
     * Whether or not the file request should be open. If the file request is
     * closed, it will not accept any file submissions, but it can be opened
     * later.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getOpen() {
        return open;
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
     * @param title  The title of the file request. Must not be empty. Must have
     *     length of at least 1 and not be {@code null}.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. For apps with the app folder permission, this
     *     will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String title, String destination) {
        return new Builder(title, destination);
    }

    /**
     * Builder for {@link CreateFileRequestArgs}.
     */
    public static class Builder {
        protected final String title;
        protected final String destination;

        protected FileRequestDeadline deadline;
        protected boolean open;
        protected String description;

        protected Builder(String title, String destination) {
            if (title == null) {
                throw new IllegalArgumentException("Required value for 'title' is null");
            }
            if (title.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
            this.title = title;
            if (destination == null) {
                throw new IllegalArgumentException("Required value for 'destination' is null");
            }
            if (!Pattern.matches("/(.|[\\r\\n])*", destination)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
            this.destination = destination;
            this.deadline = null;
            this.open = true;
            this.description = null;
        }

        /**
         * Set value for optional field.
         *
         * @param deadline  The deadline for the file request. Deadlines can
         *     only be set by Professional and Business accounts.
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
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param open  Whether or not the file request should be open. If the
         *     file request is closed, it will not accept any file submissions,
         *     but it can be opened later. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withOpen(Boolean open) {
            if (open != null) {
                this.open = open;
            }
            else {
                this.open = true;
            }
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
         * Builds an instance of {@link CreateFileRequestArgs} configured with
         * this builder's values
         *
         * @return new instance of {@link CreateFileRequestArgs}
         */
        public CreateFileRequestArgs build() {
            return new CreateFileRequestArgs(title, destination, deadline, open, description);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            title,
            destination,
            deadline,
            open,
            description
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
            CreateFileRequestArgs other = (CreateFileRequestArgs) obj;
            return ((this.title == other.title) || (this.title.equals(other.title)))
                && ((this.destination == other.destination) || (this.destination.equals(other.destination)))
                && ((this.deadline == other.deadline) || (this.deadline != null && this.deadline.equals(other.deadline)))
                && (this.open == other.open)
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
    static class Serializer extends StructSerializer<CreateFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateFileRequestArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("title");
            StoneSerializers.string().serialize(value.title, g);
            g.writeFieldName("destination");
            StoneSerializers.string().serialize(value.destination, g);
            if (value.deadline != null) {
                g.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(value.deadline, g);
            }
            g.writeFieldName("open");
            StoneSerializers.boolean_().serialize(value.open, g);
            if (value.description != null) {
                g.writeFieldName("description");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.description, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CreateFileRequestArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CreateFileRequestArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_title = null;
                String f_destination = null;
                FileRequestDeadline f_deadline = null;
                Boolean f_open = true;
                String f_description = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("title".equals(field)) {
                        f_title = StoneSerializers.string().deserialize(p);
                    }
                    else if ("destination".equals(field)) {
                        f_destination = StoneSerializers.string().deserialize(p);
                    }
                    else if ("deadline".equals(field)) {
                        f_deadline = StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("open".equals(field)) {
                        f_open = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_title == null) {
                    throw new JsonParseException(p, "Required field \"title\" missing.");
                }
                if (f_destination == null) {
                    throw new JsonParseException(p, "Required field \"destination\" missing.");
                }
                value = new CreateFileRequestArgs(f_title, f_destination, f_deadline, f_open, f_description);
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
