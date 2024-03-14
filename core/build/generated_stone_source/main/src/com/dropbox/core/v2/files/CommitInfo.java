/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.fileproperties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class CommitInfo {
    // struct files.CommitInfo (files.stone)

    protected final String path;
    protected final WriteMode mode;
    protected final boolean autorename;
    protected final Date clientModified;
    protected final boolean mute;
    protected final List<PropertyGroup> propertyGroups;
    protected final boolean strictConflict;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     * @param mode  Selects what to do if the file already exists. Must not be
     *     {@code null}.
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
     * @param propertyGroups  List of custom properties to add to file. Must not
     *     contain a {@code null} item.
     * @param strictConflict  Be more strict about how each {@link WriteMode}
     *     detects conflict. For example, always return a conflict error when
     *     {@link CommitInfo#getMode} = {@link WriteMode#getUpdateValue} and the
     *     given "rev" doesn't match the existing file's "rev", even if the
     *     existing file has been deleted. This also forces a conflict even when
     *     the target path refers to a file with identical contents.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfo(@javax.annotation.Nonnull String path, @javax.annotation.Nonnull WriteMode mode, boolean autorename, @javax.annotation.Nullable Date clientModified, boolean mute, @javax.annotation.Nullable List<PropertyGroup> propertyGroups, boolean strictConflict) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
        this.autorename = autorename;
        this.clientModified = LangUtil.truncateMillis(clientModified);
        this.mute = mute;
        if (propertyGroups != null) {
            for (PropertyGroup x : propertyGroups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = propertyGroups;
        this.strictConflict = strictConflict;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfo(String path) {
        this(path, WriteMode.ADD, false, null, false, null, false);
    }

    /**
     * Path in the user's Dropbox to save the file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Selects what to do if the file already exists.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     WriteMode.ADD.
     */
    @javax.annotation.Nonnull
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
    @javax.annotation.Nullable
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
     * List of custom properties to add to file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    /**
     * Be more strict about how each {@link WriteMode} detects conflict. For
     * example, always return a conflict error when {@link CommitInfo#getMode} =
     * {@link WriteMode#getUpdateValue} and the given "rev" doesn't match the
     * existing file's "rev", even if the existing file has been deleted. This
     * also forces a conflict even when the target path refers to a file with
     * identical contents.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getStrictConflict() {
        return strictConflict;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
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
        protected List<PropertyGroup> propertyGroups;
        protected boolean strictConflict;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.mode = WriteMode.ADD;
            this.autorename = false;
            this.clientModified = null;
            this.mute = false;
            this.propertyGroups = null;
            this.strictConflict = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * WriteMode.ADD}. </p>
         *
         * @param mode  Selects what to do if the file already exists. Must not
         *     be {@code null}. Defaults to {@code WriteMode.ADD} when set to
         *     {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
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
            this.clientModified = LangUtil.truncateMillis(clientModified);
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
         * Set value for optional field.
         *
         * @param propertyGroups  List of custom properties to add to file. Must
         *     not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPropertyGroups(List<PropertyGroup> propertyGroups) {
            if (propertyGroups != null) {
                for (PropertyGroup x : propertyGroups) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                    }
                }
            }
            this.propertyGroups = propertyGroups;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param strictConflict  Be more strict about how each {@link
         *     WriteMode} detects conflict. For example, always return a
         *     conflict error when {@link CommitInfo#getMode} = {@link
         *     WriteMode#getUpdateValue} and the given "rev" doesn't match the
         *     existing file's "rev", even if the existing file has been
         *     deleted. This also forces a conflict even when the target path
         *     refers to a file with identical contents. Defaults to {@code
         *     false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withStrictConflict(Boolean strictConflict) {
            if (strictConflict != null) {
                this.strictConflict = strictConflict;
            }
            else {
                this.strictConflict = false;
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
            return new CommitInfo(path, mode, autorename, clientModified, mute, propertyGroups, strictConflict);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            mode,
            autorename,
            clientModified,
            mute,
            propertyGroups,
            strictConflict
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
            CommitInfo other = (CommitInfo) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
                && (this.autorename == other.autorename)
                && ((this.clientModified == other.clientModified) || (this.clientModified != null && this.clientModified.equals(other.clientModified)))
                && (this.mute == other.mute)
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups != null && this.propertyGroups.equals(other.propertyGroups)))
                && (this.strictConflict == other.strictConflict)
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
    static class Serializer extends StructSerializer<CommitInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CommitInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("mode");
            WriteMode.Serializer.INSTANCE.serialize(value.mode, g);
            g.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(value.autorename, g);
            if (value.clientModified != null) {
                g.writeFieldName("client_modified");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.clientModified, g);
            }
            g.writeFieldName("mute");
            StoneSerializers.boolean_().serialize(value.mute, g);
            if (value.propertyGroups != null) {
                g.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(value.propertyGroups, g);
            }
            g.writeFieldName("strict_conflict");
            StoneSerializers.boolean_().serialize(value.strictConflict, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CommitInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CommitInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                WriteMode f_mode = WriteMode.ADD;
                Boolean f_autorename = false;
                Date f_clientModified = null;
                Boolean f_mute = false;
                List<PropertyGroup> f_propertyGroups = null;
                Boolean f_strictConflict = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("mode".equals(field)) {
                        f_mode = WriteMode.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("autorename".equals(field)) {
                        f_autorename = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("client_modified".equals(field)) {
                        f_clientModified = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else if ("mute".equals(field)) {
                        f_mute = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("strict_conflict".equals(field)) {
                        f_strictConflict = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new CommitInfo(f_path, f_mode, f_autorename, f_clientModified, f_mute, f_propertyGroups, f_strictConflict);
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
