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

/**
 * Arguments for {@link DbxUserFileRequestsRequests#update(String)}.
 */
class UpdateFileRequestArgs {
    // struct file_requests.UpdateFileRequestArgs (file_requests.stone)

    protected final String id;
    protected final String title;
    protected final String destination;
    protected final UpdateFileRequestDeadline deadline;
    protected final Boolean open;
    protected final String description;

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#update(String)}.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param id  The ID of the file request to update. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     * @param title  The new title of the file request. Must not be empty. Must
     *     have length of at least 1.
     * @param destination  The new path of the folder in the Dropbox where
     *     uploaded files will be sent. For apps with the app folder permission,
     *     this will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}".
     * @param deadline  The new deadline for the file request. Deadlines can
     *     only be set by Professional and Business accounts. Must not be {@code
     *     null}.
     * @param open  Whether to set this file request as open or closed.
     * @param description  The description of the file request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFileRequestArgs(String id, String title, String destination, UpdateFileRequestDeadline deadline, Boolean open, String description) {
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
        if (title != null) {
            if (title.length() < 1) {
                throw new IllegalArgumentException("String 'title' is shorter than 1");
            }
        }
        this.title = title;
        if (destination != null) {
            if (!Pattern.matches("/(.|[\\r\\n])*", destination)) {
                throw new IllegalArgumentException("String 'destination' does not match pattern");
            }
        }
        this.destination = destination;
        if (deadline == null) {
            throw new IllegalArgumentException("Required value for 'deadline' is null");
        }
        this.deadline = deadline;
        this.open = open;
        this.description = description;
    }

    /**
     * Arguments for {@link DbxUserFileRequestsRequests#update(String)}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param id  The ID of the file request to update. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFileRequestArgs(String id) {
        this(id, null, null, UpdateFileRequestDeadline.NO_UPDATE, null, null);
    }

    /**
     * The ID of the file request to update.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * The new title of the file request. Must not be empty.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getTitle() {
        return title;
    }

    /**
     * The new path of the folder in the Dropbox where uploaded files will be
     * sent. For apps with the app folder permission, this will be relative to
     * the app folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * The new deadline for the file request. Deadlines can only be set by
     * Professional and Business accounts.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     UpdateFileRequestDeadline.NO_UPDATE.
     */
    public UpdateFileRequestDeadline getDeadline() {
        return deadline;
    }

    /**
     * Whether to set this file request as open or closed.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getOpen() {
        return open;
    }

    /**
     * The description of the file request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param id  The ID of the file request to update. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String id) {
        return new Builder(id);
    }

    /**
     * Builder for {@link UpdateFileRequestArgs}.
     */
    public static class Builder {
        protected final String id;

        protected String title;
        protected String destination;
        protected UpdateFileRequestDeadline deadline;
        protected Boolean open;
        protected String description;

        protected Builder(String id) {
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
            this.title = null;
            this.destination = null;
            this.deadline = UpdateFileRequestDeadline.NO_UPDATE;
            this.open = null;
            this.description = null;
        }

        /**
         * Set value for optional field.
         *
         * @param title  The new title of the file request. Must not be empty.
         *     Must have length of at least 1.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withTitle(String title) {
            if (title != null) {
                if (title.length() < 1) {
                    throw new IllegalArgumentException("String 'title' is shorter than 1");
                }
            }
            this.title = title;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param destination  The new path of the folder in the Dropbox where
         *     uploaded files will be sent. For apps with the app folder
         *     permission, this will be relative to the app folder. Must match
         *     pattern "{@code /(.|[\\r\\n])*}".
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
         * <p> If left unset or set to {@code null}, defaults to {@code
         * UpdateFileRequestDeadline.NO_UPDATE}. </p>
         *
         * @param deadline  The new deadline for the file request. Deadlines can
         *     only be set by Professional and Business accounts. Must not be
         *     {@code null}. Defaults to {@code
         *     UpdateFileRequestDeadline.NO_UPDATE} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withDeadline(UpdateFileRequestDeadline deadline) {
            if (deadline != null) {
                this.deadline = deadline;
            }
            else {
                this.deadline = UpdateFileRequestDeadline.NO_UPDATE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param open  Whether to set this file request as open or closed.
         *
         * @return this builder
         */
        public Builder withOpen(Boolean open) {
            this.open = open;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param description  The description of the file request.
         *
         * @return this builder
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds an instance of {@link UpdateFileRequestArgs} configured with
         * this builder's values
         *
         * @return new instance of {@link UpdateFileRequestArgs}
         */
        public UpdateFileRequestArgs build() {
            return new UpdateFileRequestArgs(id, title, destination, deadline, open, description);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            id,
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
            UpdateFileRequestArgs other = (UpdateFileRequestArgs) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.title == other.title) || (this.title != null && this.title.equals(other.title)))
                && ((this.destination == other.destination) || (this.destination != null && this.destination.equals(other.destination)))
                && ((this.deadline == other.deadline) || (this.deadline.equals(other.deadline)))
                && ((this.open == other.open) || (this.open != null && this.open.equals(other.open)))
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
    static class Serializer extends StructSerializer<UpdateFileRequestArgs> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdateFileRequestArgs value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.title != null) {
                g.writeFieldName("title");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.title, g);
            }
            if (value.destination != null) {
                g.writeFieldName("destination");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.destination, g);
            }
            g.writeFieldName("deadline");
            UpdateFileRequestDeadline.Serializer.INSTANCE.serialize(value.deadline, g);
            if (value.open != null) {
                g.writeFieldName("open");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.open, g);
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
        public UpdateFileRequestArgs deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UpdateFileRequestArgs value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_id = null;
                String f_title = null;
                String f_destination = null;
                UpdateFileRequestDeadline f_deadline = UpdateFileRequestDeadline.NO_UPDATE;
                Boolean f_open = null;
                String f_description = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("title".equals(field)) {
                        f_title = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("destination".equals(field)) {
                        f_destination = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("deadline".equals(field)) {
                        f_deadline = UpdateFileRequestDeadline.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("open".equals(field)) {
                        f_open = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
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
                value = new UpdateFileRequestArgs(f_id, f_title, f_destination, f_deadline, f_open, f_description);
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
