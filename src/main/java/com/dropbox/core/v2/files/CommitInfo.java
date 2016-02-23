/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;

public class CommitInfo {
    // struct CommitInfo

    private final String path;
    private final WriteMode mode;
    private final boolean autorename;
    private final Date clientModified;
    private final boolean mute;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /.*}" and not be {@code null}.
     * @param mode  Selects what to do if the file already exists.
     * @param autorename  If there's a conflict, as determined by {@link
     *     CommitInfo#getMode}, have the Dropbox server try to autorename the
     *     file to avoid conflict.
     * @param clientModified  The value to store as the {@link
     *     CommitInfo#getClientModified} timestamp. Dropbox automatically
     *     records the time at which the file was written to the Dropbox
     *     servers. It can also record an additional timestamp, provided by
     *     Dropbox desktop clients, mobile clients, and API apps of when the
     *     file was actually created or modified.
     * @param mute  Normally, users are made aware of any file modifications in
     *     their Dropbox account via notifications in the client software. If
     *     {@code true}, this tells the clients that this modification shouldn't
     *     result in a user notification.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfo(String path, WriteMode mode, boolean autorename, Date clientModified, boolean mute) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
        this.autorename = autorename;
        this.clientModified = clientModified;
        this.mute = mute;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfo(String path) {
        this(path, WriteMode.ADD, false, null, false);
    }

    /**
     * Path in the user's Dropbox to save the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Selects what to do if the file already exists.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     WriteMode.ADD.
     */
    public WriteMode getMode() {
        return mode;
    }

    /**
     * If there's a conflict, as determined by {@link CommitInfo#getMode}, have
     * the Dropbox server try to autorename the file to avoid conflict.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAutorename() {
        return autorename;
    }

    /**
     * The value to store as the {@link CommitInfo#getClientModified} timestamp.
     * Dropbox automatically records the time at which the file was written to
     * the Dropbox servers. It can also record an additional timestamp, provided
     * by Dropbox desktop clients, mobile clients, and API apps of when the file
     * was actually created or modified.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Date getClientModified() {
        return clientModified;
    }

    /**
     * Normally, users are made aware of any file modifications in their Dropbox
     * account via notifications in the client software. If {@code true}, this
     * tells the clients that this modification shouldn't result in a user
     * notification.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getMute() {
        return mute;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /.*}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path) {
        return new Builder(path);
    }

    /**
     * Builder for {@link CommitInfo}.
     */
    public static class Builder {
        protected final String path;

        protected WriteMode mode;
        protected boolean autorename;
        protected Date clientModified;
        protected boolean mute;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!java.util.regex.Pattern.matches("/.*", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.mode = WriteMode.ADD;
            this.autorename = false;
            this.clientModified = null;
            this.mute = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * WriteMode.ADD}. </p>
         *
         * @param mode  Selects what to do if the file already exists. Defaults
         *     to {@code WriteMode.ADD} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withMode(WriteMode mode) {
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = WriteMode.ADD;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param autorename  If there's a conflict, as determined by {@link
         *     CommitInfo#getMode}, have the Dropbox server try to autorename
         *     the file to avoid conflict. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withAutorename(Boolean autorename) {
            if (autorename != null) {
                this.autorename = autorename;
            }
            else {
                this.autorename = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param clientModified  The value to store as the {@link
         *     CommitInfo#getClientModified} timestamp. Dropbox automatically
         *     records the time at which the file was written to the Dropbox
         *     servers. It can also record an additional timestamp, provided by
         *     Dropbox desktop clients, mobile clients, and API apps of when the
         *     file was actually created or modified.
         *
         * @return this builder
         */
        public Builder withClientModified(Date clientModified) {
            this.clientModified = clientModified;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param mute  Normally, users are made aware of any file modifications
         *     in their Dropbox account via notifications in the client
         *     software. If {@code true}, this tells the clients that this
         *     modification shouldn't result in a user notification. Defaults to
         *     {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withMute(Boolean mute) {
            if (mute != null) {
                this.mute = mute;
            }
            else {
                this.mute = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link CommitInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link CommitInfo}
         */
        public CommitInfo build() {
            return new CommitInfo(path, mode, autorename, clientModified, mute);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            mode,
            autorename,
            clientModified,
            mute
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
            CommitInfo other = (CommitInfo) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
                && (this.autorename == other.autorename)
                && ((this.clientModified == other.clientModified) || (this.clientModified != null && this.clientModified.equals(other.clientModified)))
                && (this.mute == other.mute)
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

    public static CommitInfo fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<CommitInfo> _JSON_WRITER = new JsonWriter<CommitInfo>() {
        public final void write(CommitInfo x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            CommitInfo._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(CommitInfo x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("mode");
            WriteMode._JSON_WRITER.write(x.mode, g);
            g.writeFieldName("autorename");
            g.writeBoolean(x.autorename);
            if (x.clientModified != null) {
                g.writeFieldName("client_modified");
                writeDateIso(x.clientModified, g);
            }
            g.writeFieldName("mute");
            g.writeBoolean(x.mute);
        }
    };

    public static final JsonReader<CommitInfo> _JSON_READER = new JsonReader<CommitInfo>() {
        public final CommitInfo read(JsonParser parser) throws IOException, JsonReadException {
            CommitInfo result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final CommitInfo readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            WriteMode mode = null;
            Boolean autorename = null;
            Date clientModified = null;
            Boolean mute = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("mode".equals(fieldName)) {
                    mode = WriteMode._JSON_READER
                        .readField(parser, "mode", mode);
                }
                else if ("autorename".equals(fieldName)) {
                    autorename = JsonReader.BooleanReader
                        .readField(parser, "autorename", autorename);
                }
                else if ("client_modified".equals(fieldName)) {
                    clientModified = JsonDateReader.DropboxV2
                        .readField(parser, "client_modified", clientModified);
                }
                else if ("mute".equals(fieldName)) {
                    mute = JsonReader.BooleanReader
                        .readField(parser, "mute", mute);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            return new CommitInfo(path, mode, autorename, clientModified, mute);
        }
    };
}
