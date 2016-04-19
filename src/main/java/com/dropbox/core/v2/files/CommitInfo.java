/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

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

@JsonSerialize(using=CommitInfo.Serializer.class)
@JsonDeserialize(using=CommitInfo.Deserializer.class)
public class CommitInfo {
    // struct CommitInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final WriteMode mode;
    protected final boolean autorename;
    protected final Date clientModified;
    protected final boolean mute;

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
        this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
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
            this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
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

    static final class Serializer extends StructJsonSerializer<CommitInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(CommitInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(CommitInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<CommitInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(CommitInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("mode", value.mode);
            g.writeObjectField("autorename", value.autorename);
            if (value.clientModified != null) {
                g.writeObjectField("client_modified", value.clientModified);
            }
            g.writeObjectField("mute", value.mute);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<CommitInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(CommitInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(CommitInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<CommitInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public CommitInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            WriteMode mode = WriteMode.ADD;
            boolean autorename = false;
            Date clientModified = null;
            boolean mute = false;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("mode".equals(_field)) {
                    mode = _p.readValueAs(WriteMode.class);
                    _p.nextToken();
                }
                else if ("autorename".equals(_field)) {
                    autorename = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("client_modified".equals(_field)) {
                    clientModified = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("mute".equals(_field)) {
                    mute = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }

            return new CommitInfo(path, mode, autorename, clientModified, mute);
        }
    }
}
