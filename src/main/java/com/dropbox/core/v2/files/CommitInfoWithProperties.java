/* DO NOT EDIT */
/* This file was generated from files_properties.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.properties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CommitInfoWithProperties extends CommitInfo {
    // struct CommitInfoWithProperties

    protected final List<PropertyGroup> propertyGroups;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param mode  Selects what to do if the file already exists.
     * @param autorename  If there's a conflict, as determined by the {@code
     *     mode} argument to {@link DbxUserFilesRequests#upload(String)}, have
     *     the Dropbox server try to autorename the file to avoid conflict.
     * @param clientModified  The value to store as the the {@code
     *     clientModified} argument to {@link
     *     DbxUserFilesRequests#upload(String)} timestamp. Dropbox automatically
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfoWithProperties(String path, WriteMode mode, boolean autorename, Date clientModified, boolean mute, List<PropertyGroup> propertyGroups) {
        super(path, mode, autorename, clientModified, mute);
        if (propertyGroups != null) {
            for (PropertyGroup x : propertyGroups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = propertyGroups;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CommitInfoWithProperties(String path) {
        this(path, WriteMode.ADD, false, null, false, null);
    }

    /**
     * List of custom properties to add to file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
     * Builder for {@link CommitInfoWithProperties}.
     */
    public static class Builder extends CommitInfo.Builder {

        protected List<PropertyGroup> propertyGroups;

        protected Builder(String path) {
            super(path);
            this.propertyGroups = null;
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
         * <p> If left unset or set to {@code null}, defaults to {@code
         * WriteMode.ADD}. </p>
         *
         * @param mode  Selects what to do if the file already exists. Defaults
         *     to {@code WriteMode.ADD} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withMode(WriteMode mode) {
            super.withMode(mode);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param autorename  If there's a conflict, as determined by the {@code
         *     mode} argument to {@link DbxUserFilesRequests#upload(String)},
         *     have the Dropbox server try to autorename the file to avoid
         *     conflict. Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withAutorename(Boolean autorename) {
            super.withAutorename(autorename);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param clientModified  The value to store as the the {@code
         *     clientModified} argument to {@link
         *     DbxUserFilesRequests#upload(String)} timestamp. Dropbox
         *     automatically records the time at which the file was written to
         *     the Dropbox servers. It can also record an additional timestamp,
         *     provided by Dropbox desktop clients, mobile clients, and API apps
         *     of when the file was actually created or modified.
         *
         * @return this builder
         */
        public Builder withClientModified(Date clientModified) {
            super.withClientModified(clientModified);
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
            super.withMute(mute);
            return this;
        }

        /**
         * Builds an instance of {@link CommitInfoWithProperties} configured
         * with this builder's values
         *
         * @return new instance of {@link CommitInfoWithProperties}
         */
        public CommitInfoWithProperties build() {
            return new CommitInfoWithProperties(path, mode, autorename, clientModified, mute, propertyGroups);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            propertyGroups
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            CommitInfoWithProperties other = (CommitInfoWithProperties) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
                && (this.autorename == other.autorename)
                && ((this.clientModified == other.clientModified) || (this.clientModified != null && this.clientModified.equals(other.clientModified)))
                && (this.mute == other.mute)
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups != null && this.propertyGroups.equals(other.propertyGroups)))
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
    static final class Serializer extends StructSerializer<CommitInfoWithProperties> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CommitInfoWithProperties value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CommitInfoWithProperties deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CommitInfoWithProperties value;
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
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new CommitInfoWithProperties(f_path, f_mode, f_autorename, f_clientModified, f_mute, f_propertyGroups);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
