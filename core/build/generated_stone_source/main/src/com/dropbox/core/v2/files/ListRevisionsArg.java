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

class ListRevisionsArg {
    // struct files.ListRevisionsArg (files.stone)

    @Nonnull
    protected final String path;
    @Nonnull
    protected final ListRevisionsMode mode;
    protected final long limit;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and
     *     not be {@code null}.
     * @param mode  Determines the behavior of the API in listing the revisions
     *     for a given file path or id. Must not be {@code null}.
     * @param limit  The maximum number of revision entries returned. Must be
     *     greater than or equal to 1 and be less than or equal to 100.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(@Nonnull String path, @Nonnull ListRevisionsMode mode, long limit) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 100L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        this.limit = limit;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsArg(@Nonnull String path) {
        this(path, ListRevisionsMode.PATH, 10L);
    }

    /**
     * The path to the file you want to see the revisions of.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * Determines the behavior of the API in listing the revisions for a given
     * file path or id.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     ListRevisionsMode.PATH.
     */
    @Nonnull
    public ListRevisionsMode getMode() {
        return mode;
    }

    /**
     * The maximum number of revision entries returned.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     10L.
     */
    public long getLimit() {
        return limit;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and
     *     not be {@code null}.
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
     * Builder for {@link ListRevisionsArg}.
     */
    public static class Builder {
        protected final String path;

        protected ListRevisionsMode mode;
        protected long limit;

        protected Builder(String path) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("/(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            this.mode = ListRevisionsMode.PATH;
            this.limit = 10L;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * ListRevisionsMode.PATH}. </p>
         *
         * @param mode  Determines the behavior of the API in listing the
         *     revisions for a given file path or id. Must not be {@code null}.
         *     Defaults to {@code ListRevisionsMode.PATH} when set to {@code
         *     null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMode(ListRevisionsMode mode) {
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = ListRevisionsMode.PATH;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 10L}.
         * </p>
         *
         * @param limit  The maximum number of revision entries returned. Must
         *     be greater than or equal to 1 and be less than or equal to 100.
         *     Defaults to {@code 10L} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withLimit(Long limit) {
            if (limit < 1L) {
                throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
            }
            if (limit > 100L) {
                throw new IllegalArgumentException("Number 'limit' is larger than 100L");
            }
            if (limit != null) {
                this.limit = limit;
            }
            else {
                this.limit = 10L;
            }
            return this;
        }

        /**
         * Builds an instance of {@link ListRevisionsArg} configured with this
         * builder's values
         *
         * @return new instance of {@link ListRevisionsArg}
         */
        public ListRevisionsArg build() {
            return new ListRevisionsArg(path, mode, limit);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            mode,
            limit
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
            ListRevisionsArg other = (ListRevisionsArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
                && (this.limit == other.limit)
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
    static class Serializer extends StructSerializer<ListRevisionsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListRevisionsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("mode");
            ListRevisionsMode.Serializer.INSTANCE.serialize(value.mode, g);
            g.writeFieldName("limit");
            StoneSerializers.uInt64().serialize(value.limit, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListRevisionsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListRevisionsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                ListRevisionsMode f_mode = ListRevisionsMode.PATH;
                Long f_limit = 10L;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("mode".equals(field)) {
                        f_mode = ListRevisionsMode.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("limit".equals(field)) {
                        f_limit = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new ListRevisionsArg(f_path, f_mode, f_limit);
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
