/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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
import java.util.List;

import javax.annotation.Nonnull;

class RelocationBatchArg extends RelocationBatchArgBase {
    // struct files.RelocationBatchArg (files.stone)

    protected final boolean allowSharedFolder;
    protected final boolean allowOwnershipTransfer;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     * @param autorename  If there's a conflict with any file, have the Dropbox
     *     server try to autorename that file to avoid the conflict.
     * @param allowSharedFolder  This flag has no effect.
     * @param allowOwnershipTransfer  Allow moves by owner even if it would
     *     result in an ownership transfer for the content being moved. This
     *     does not apply to copies.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchArg(@Nonnull List<RelocationPath> entries, boolean autorename, boolean allowSharedFolder, boolean allowOwnershipTransfer) {
        super(entries, autorename);
        this.allowSharedFolder = allowSharedFolder;
        this.allowOwnershipTransfer = allowOwnershipTransfer;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchArg(@Nonnull List<RelocationPath> entries) {
        this(entries, false, false, false);
    }

    /**
     * List of entries to be moved or copied. Each entry is {@link
     * RelocationPath}.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<RelocationPath> getEntries() {
        return entries;
    }

    /**
     * If there's a conflict with any file, have the Dropbox server try to
     * autorename that file to avoid the conflict.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAutorename() {
        return autorename;
    }

    /**
     * This flag has no effect.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAllowSharedFolder() {
        return allowSharedFolder;
    }

    /**
     * Allow moves by owner even if it would result in an ownership transfer for
     * the content being moved. This does not apply to copies.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAllowOwnershipTransfer() {
        return allowOwnershipTransfer;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<RelocationPath> entries) {
        return new Builder(entries);
    }

    /**
     * Builder for {@link RelocationBatchArg}.
     */
    public static class Builder {
        protected final List<RelocationPath> entries;

        protected boolean autorename;
        protected boolean allowSharedFolder;
        protected boolean allowOwnershipTransfer;

        protected Builder(List<RelocationPath> entries) {
            if (entries == null) {
                throw new IllegalArgumentException("Required value for 'entries' is null");
            }
            if (entries.size() < 1) {
                throw new IllegalArgumentException("List 'entries' has fewer than 1 items");
            }
            if (entries.size() > 1000) {
                throw new IllegalArgumentException("List 'entries' has more than 1000 items");
            }
            for (RelocationPath x : entries) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'entries' is null");
                }
            }
            this.entries = entries;
            this.autorename = false;
            this.allowSharedFolder = false;
            this.allowOwnershipTransfer = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param autorename  If there's a conflict with any file, have the
         *     Dropbox server try to autorename that file to avoid the conflict.
         *     Defaults to {@code false} when set to {@code null}.
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
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param allowSharedFolder  This flag has no effect. Defaults to {@code
         *     false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withAllowSharedFolder(Boolean allowSharedFolder) {
            if (allowSharedFolder != null) {
                this.allowSharedFolder = allowSharedFolder;
            }
            else {
                this.allowSharedFolder = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param allowOwnershipTransfer  Allow moves by owner even if it would
         *     result in an ownership transfer for the content being moved. This
         *     does not apply to copies. Defaults to {@code false} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withAllowOwnershipTransfer(Boolean allowOwnershipTransfer) {
            if (allowOwnershipTransfer != null) {
                this.allowOwnershipTransfer = allowOwnershipTransfer;
            }
            else {
                this.allowOwnershipTransfer = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link RelocationBatchArg} configured with this
         * builder's values
         *
         * @return new instance of {@link RelocationBatchArg}
         */
        public RelocationBatchArg build() {
            return new RelocationBatchArg(entries, autorename, allowSharedFolder, allowOwnershipTransfer);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            allowSharedFolder,
            allowOwnershipTransfer
        });
        hash = (31 * super.hashCode()) + hash;
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
            RelocationBatchArg other = (RelocationBatchArg) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
                && (this.autorename == other.autorename)
                && (this.allowSharedFolder == other.allowSharedFolder)
                && (this.allowOwnershipTransfer == other.allowOwnershipTransfer)
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
    static class Serializer extends StructSerializer<RelocationBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(RelocationPath.Serializer.INSTANCE).serialize(value.entries, g);
            g.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(value.autorename, g);
            g.writeFieldName("allow_shared_folder");
            StoneSerializers.boolean_().serialize(value.allowSharedFolder, g);
            g.writeFieldName("allow_ownership_transfer");
            StoneSerializers.boolean_().serialize(value.allowOwnershipTransfer, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocationBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocationBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RelocationPath> f_entries = null;
                Boolean f_autorename = false;
                Boolean f_allowSharedFolder = false;
                Boolean f_allowOwnershipTransfer = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(RelocationPath.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("autorename".equals(field)) {
                        f_autorename = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("allow_shared_folder".equals(field)) {
                        f_allowSharedFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("allow_ownership_transfer".equals(field)) {
                        f_allowOwnershipTransfer = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new RelocationBatchArg(f_entries, f_autorename, f_allowSharedFolder, f_allowOwnershipTransfer);
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
