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

class CreateFolderBatchArg {
    // struct files.CreateFolderBatchArg (files.stone)

    protected final List<String> paths;
    protected final boolean autorename;
    protected final boolean forceAsync;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param paths  List of paths to be created in the user's Dropbox.
     *     Duplicate path arguments in the batch are considered only once. Must
     *     contain at most 10000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the folder to avoid the conflict.
     * @param forceAsync  Whether to force the create to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderBatchArg(List<String> paths, boolean autorename, boolean forceAsync) {
        if (paths == null) {
            throw new IllegalArgumentException("Required value for 'paths' is null");
        }
        if (paths.size() > 10000) {
            throw new IllegalArgumentException("List 'paths' has more than 10000 items");
        }
        for (String x : paths) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'paths' is null");
            }
            if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", x)) {
                throw new IllegalArgumentException("Stringan item in list 'paths' does not match pattern");
            }
        }
        this.paths = paths;
        this.autorename = autorename;
        this.forceAsync = forceAsync;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param paths  List of paths to be created in the user's Dropbox.
     *     Duplicate path arguments in the batch are considered only once. Must
     *     contain at most 10000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderBatchArg(List<String> paths) {
        this(paths, false, false);
    }

    /**
     * List of paths to be created in the user's Dropbox. Duplicate path
     * arguments in the batch are considered only once.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<String> getPaths() {
        return paths;
    }

    /**
     * If there's a conflict, have the Dropbox server try to autorename the
     * folder to avoid the conflict.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAutorename() {
        return autorename;
    }

    /**
     * Whether to force the create to happen asynchronously.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getForceAsync() {
        return forceAsync;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param paths  List of paths to be created in the user's Dropbox.
     *     Duplicate path arguments in the batch are considered only once. Must
     *     contain at most 10000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(List<String> paths) {
        return new Builder(paths);
    }

    /**
     * Builder for {@link CreateFolderBatchArg}.
     */
    public static class Builder {
        protected final List<String> paths;

        protected boolean autorename;
        protected boolean forceAsync;

        protected Builder(List<String> paths) {
            if (paths == null) {
                throw new IllegalArgumentException("Required value for 'paths' is null");
            }
            if (paths.size() > 10000) {
                throw new IllegalArgumentException("List 'paths' has more than 10000 items");
            }
            for (String x : paths) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'paths' is null");
                }
                if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)", x)) {
                    throw new IllegalArgumentException("Stringan item in list 'paths' does not match pattern");
                }
            }
            this.paths = paths;
            this.autorename = false;
            this.forceAsync = false;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param autorename  If there's a conflict, have the Dropbox server try
         *     to autorename the folder to avoid the conflict. Defaults to
         *     {@code false} when set to {@code null}.
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
         * @param forceAsync  Whether to force the create to happen
         *     asynchronously. Defaults to {@code false} when set to {@code
         *     null}.
         *
         * @return this builder
         */
        public Builder withForceAsync(Boolean forceAsync) {
            if (forceAsync != null) {
                this.forceAsync = forceAsync;
            }
            else {
                this.forceAsync = false;
            }
            return this;
        }

        /**
         * Builds an instance of {@link CreateFolderBatchArg} configured with
         * this builder's values
         *
         * @return new instance of {@link CreateFolderBatchArg}
         */
        public CreateFolderBatchArg build() {
            return new CreateFolderBatchArg(paths, autorename, forceAsync);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            paths,
            autorename,
            forceAsync
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
            CreateFolderBatchArg other = (CreateFolderBatchArg) obj;
            return ((this.paths == other.paths) || (this.paths.equals(other.paths)))
                && (this.autorename == other.autorename)
                && (this.forceAsync == other.forceAsync)
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
    static class Serializer extends StructSerializer<CreateFolderBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CreateFolderBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("paths");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.paths, g);
            g.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(value.autorename, g);
            g.writeFieldName("force_async");
            StoneSerializers.boolean_().serialize(value.forceAsync, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public CreateFolderBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            CreateFolderBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_paths = null;
                Boolean f_autorename = false;
                Boolean f_forceAsync = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("paths".equals(field)) {
                        f_paths = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("autorename".equals(field)) {
                        f_autorename = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("force_async".equals(field)) {
                        f_forceAsync = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_paths == null) {
                    throw new JsonParseException(p, "Required field \"paths\" missing.");
                }
                value = new CreateFolderBatchArg(f_paths, f_autorename, f_forceAsync);
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
