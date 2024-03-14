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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

class RelocationArg extends RelocationPath {
    // struct files.RelocationArg (files.stone)

    protected final boolean allowSharedFolder;
    protected final boolean autorename;
    protected final boolean allowOwnershipTransfer;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param allowSharedFolder  This flag has no effect.
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the file to avoid the conflict.
     * @param allowOwnershipTransfer  Allow moves by owner even if it would
     *     result in an ownership transfer for the content being moved. This
     *     does not apply to copies.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationArg(@Nonnull String fromPath, @Nonnull String toPath, boolean allowSharedFolder, boolean autorename, boolean allowOwnershipTransfer) {
        super(fromPath, toPath);
        this.allowSharedFolder = allowSharedFolder;
        this.autorename = autorename;
        this.allowOwnershipTransfer = allowOwnershipTransfer;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationArg(String fromPath, String toPath) {
        this(fromPath, toPath, false, false, false);
    }

    /**
     * Path in the user's Dropbox to be copied or moved.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFromPath() {
        return fromPath;
    }

    /**
     * Path in the user's Dropbox that is the destination.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getToPath() {
        return toPath;
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
     * If there's a conflict, have the Dropbox server try to autorename the file
     * to avoid the conflict.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAutorename() {
        return autorename;
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
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String fromPath, String toPath) {
        return new Builder(fromPath, toPath);
    }

    /**
     * Builder for {@link RelocationArg}.
     */
    public static class Builder {
        protected final String fromPath;
        protected final String toPath;

        protected boolean allowSharedFolder;
        protected boolean autorename;
        protected boolean allowOwnershipTransfer;

        protected Builder(String fromPath, String toPath) {
            if (fromPath == null) {
                throw new IllegalArgumentException("Required value for 'fromPath' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", fromPath)) {
                throw new IllegalArgumentException("String 'fromPath' does not match pattern");
            }
            this.fromPath = fromPath;
            if (toPath == null) {
                throw new IllegalArgumentException("Required value for 'toPath' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", toPath)) {
                throw new IllegalArgumentException("String 'toPath' does not match pattern");
            }
            this.toPath = toPath;
            this.allowSharedFolder = false;
            this.autorename = false;
            this.allowOwnershipTransfer = false;
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
         * @param autorename  If there's a conflict, have the Dropbox server try
         *     to autorename the file to avoid the conflict. Defaults to {@code
         *     false} when set to {@code null}.
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
         * Builds an instance of {@link RelocationArg} configured with this
         * builder's values
         *
         * @return new instance of {@link RelocationArg}
         */
        public RelocationArg build() {
            return new RelocationArg(fromPath, toPath, allowSharedFolder, autorename, allowOwnershipTransfer);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            allowSharedFolder,
            autorename,
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
            RelocationArg other = (RelocationArg) obj;
            return ((this.fromPath == other.fromPath) || (this.fromPath.equals(other.fromPath)))
                && ((this.toPath == other.toPath) || (this.toPath.equals(other.toPath)))
                && (this.allowSharedFolder == other.allowSharedFolder)
                && (this.autorename == other.autorename)
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
    static class Serializer extends StructSerializer<RelocationArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("from_path");
            StoneSerializers.string().serialize(value.fromPath, g);
            g.writeFieldName("to_path");
            StoneSerializers.string().serialize(value.toPath, g);
            g.writeFieldName("allow_shared_folder");
            StoneSerializers.boolean_().serialize(value.allowSharedFolder, g);
            g.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(value.autorename, g);
            g.writeFieldName("allow_ownership_transfer");
            StoneSerializers.boolean_().serialize(value.allowOwnershipTransfer, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocationArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocationArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_fromPath = null;
                String f_toPath = null;
                Boolean f_allowSharedFolder = false;
                Boolean f_autorename = false;
                Boolean f_allowOwnershipTransfer = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("from_path".equals(field)) {
                        f_fromPath = StoneSerializers.string().deserialize(p);
                    }
                    else if ("to_path".equals(field)) {
                        f_toPath = StoneSerializers.string().deserialize(p);
                    }
                    else if ("allow_shared_folder".equals(field)) {
                        f_allowSharedFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("autorename".equals(field)) {
                        f_autorename = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("allow_ownership_transfer".equals(field)) {
                        f_allowOwnershipTransfer = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_fromPath == null) {
                    throw new JsonParseException(p, "Required field \"from_path\" missing.");
                }
                if (f_toPath == null) {
                    throw new JsonParseException(p, "Required field \"to_path\" missing.");
                }
                value = new RelocationArg(f_fromPath, f_toPath, f_allowSharedFolder, f_autorename, f_allowOwnershipTransfer);
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
