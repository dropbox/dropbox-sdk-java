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
import javax.annotation.Nullable;

public class MinimalFileLinkMetadata {
    // struct files.MinimalFileLinkMetadata (files.stone)

    @Nonnull
    protected final String url;
    @Nullable
    protected final String id;
    @Nullable
    protected final String path;
    @Nonnull
    protected final String rev;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param id  Unique identifier for the linked file. Must have length of at
     *     least 1.
     * @param path  Full path in the user's Dropbox. This always starts with a
     *     slash. This field will only be present only if the linked file is in
     *     the authenticated user's Dropbox.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MinimalFileLinkMetadata(@Nonnull String url, @Nonnull String rev, @Nullable String id, @Nullable String path) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (id != null) {
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
        }
        this.id = id;
        this.path = path;
        if (rev == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (rev.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", rev)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = rev;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MinimalFileLinkMetadata(@Nonnull String url, @Nonnull String rev) {
        this(url, rev, null, null);
    }

    /**
     * URL of the shared link.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * A unique identifier for the current revision of a file. This field is the
     * same rev as elsewhere in the API and can be used to detect changes and
     * avoid conflicts.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getRev() {
        return rev;
    }

    /**
     * Unique identifier for the linked file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getId() {
        return id;
    }

    /**
     * Full path in the user's Dropbox. This always starts with a slash. This
     * field will only be present only if the linked file is in the
     * authenticated user's Dropbox.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPath() {
        return path;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String url, String rev) {
        return new Builder(url, rev);
    }

    /**
     * Builder for {@link MinimalFileLinkMetadata}.
     */
    public static class Builder {
        protected final String url;
        protected final String rev;

        protected String id;
        protected String path;

        protected Builder(String url, String rev) {
            if (url == null) {
                throw new IllegalArgumentException("Required value for 'url' is null");
            }
            this.url = url;
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = rev;
            this.id = null;
            this.path = null;
        }

        /**
         * Set value for optional field.
         *
         * @param id  Unique identifier for the linked file. Must have length of
         *     at least 1.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withId(String id) {
            if (id != null) {
                if (id.length() < 1) {
                    throw new IllegalArgumentException("String 'id' is shorter than 1");
                }
            }
            this.id = id;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param path  Full path in the user's Dropbox. This always starts with
         *     a slash. This field will only be present only if the linked file
         *     is in the authenticated user's Dropbox.
         *
         * @return this builder
         */
        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        /**
         * Builds an instance of {@link MinimalFileLinkMetadata} configured with
         * this builder's values
         *
         * @return new instance of {@link MinimalFileLinkMetadata}
         */
        public MinimalFileLinkMetadata build() {
            return new MinimalFileLinkMetadata(url, rev, id, path);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            url,
            id,
            path,
            rev
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
            MinimalFileLinkMetadata other = (MinimalFileLinkMetadata) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && ((this.id == other.id) || (this.id != null && this.id.equals(other.id)))
                && ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
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
    static class Serializer extends StructSerializer<MinimalFileLinkMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MinimalFileLinkMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("rev");
            StoneSerializers.string().serialize(value.rev, g);
            if (value.id != null) {
                g.writeFieldName("id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.id, g);
            }
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MinimalFileLinkMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MinimalFileLinkMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                String f_rev = null;
                String f_id = null;
                String f_path = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("rev".equals(field)) {
                        f_rev = StoneSerializers.string().deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_rev == null) {
                    throw new JsonParseException(p, "Required field \"rev\" missing.");
                }
                value = new MinimalFileLinkMetadata(f_url, f_rev, f_id, f_path);
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
