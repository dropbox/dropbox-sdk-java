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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class UploadSessionAppendArg {
    // struct files.UploadSessionAppendArg (files.stone)

    @Nonnull
    protected final UploadSessionCursor cursor;
    protected final boolean close;
    @Nullable
    protected final String contentHash;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param close  If true, the current session will be closed, at which point
     *     you won't be able to call {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     anymore with the current session.
     * @param contentHash  A hash of the file content uploaded in this call. If
     *     provided and the uploaded content does not match this hash, an error
     *     will be returned. For more information see our <a
     *     href="https://www.dropbox.com/developers/reference/content-hash">Content
     *     hash</a> page. Must have length of at least 64 and have length of at
     *     most 64.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendArg(@Nonnull UploadSessionCursor cursor, boolean close, @Nullable String contentHash) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.close = close;
        if (contentHash != null) {
            if (contentHash.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (contentHash.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = contentHash;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendArg(@Nonnull UploadSessionCursor cursor) {
        this(cursor, false, null);
    }

    /**
     * Contains the upload session ID and the offset.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UploadSessionCursor getCursor() {
        return cursor;
    }

    /**
     * If true, the current session will be closed, at which point you won't be
     * able to call {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} anymore
     * with the current session.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getClose() {
        return close;
    }

    /**
     * A hash of the file content uploaded in this call. If provided and the
     * uploaded content does not match this hash, an error will be returned. For
     * more information see our <a
     * href="https://www.dropbox.com/developers/reference/content-hash">Content
     * hash</a> page.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getContentHash() {
        return contentHash;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(UploadSessionCursor cursor) {
        return new Builder(cursor);
    }

    /**
     * Builder for {@link UploadSessionAppendArg}.
     */
    public static class Builder {
        protected final UploadSessionCursor cursor;

        protected boolean close;
        protected String contentHash;

        protected Builder(UploadSessionCursor cursor) {
            if (cursor == null) {
                throw new IllegalArgumentException("Required value for 'cursor' is null");
            }
            this.cursor = cursor;
            this.close = false;
            this.contentHash = null;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param close  If true, the current session will be closed, at which
         *     point you won't be able to call {@link
         *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
         *     anymore with the current session. Defaults to {@code false} when
         *     set to {@code null}.
         *
         * @return this builder
         */
        public Builder withClose(Boolean close) {
            if (close != null) {
                this.close = close;
            }
            else {
                this.close = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param contentHash  A hash of the file content uploaded in this call.
         *     If provided and the uploaded content does not match this hash, an
         *     error will be returned. For more information see our <a
         *     href="https://www.dropbox.com/developers/reference/content-hash">Content
         *     hash</a> page. Must have length of at least 64 and have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withContentHash(String contentHash) {
            if (contentHash != null) {
                if (contentHash.length() < 64) {
                    throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
                }
                if (contentHash.length() > 64) {
                    throw new IllegalArgumentException("String 'contentHash' is longer than 64");
                }
            }
            this.contentHash = contentHash;
            return this;
        }

        /**
         * Builds an instance of {@link UploadSessionAppendArg} configured with
         * this builder's values
         *
         * @return new instance of {@link UploadSessionAppendArg}
         */
        public UploadSessionAppendArg build() {
            return new UploadSessionAppendArg(cursor, close, contentHash);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            cursor,
            close,
            contentHash
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
            UploadSessionAppendArg other = (UploadSessionAppendArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.close == other.close)
                && ((this.contentHash == other.contentHash) || (this.contentHash != null && this.contentHash.equals(other.contentHash)))
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
    static class Serializer extends StructSerializer<UploadSessionAppendArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionAppendArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("cursor");
            UploadSessionCursor.Serializer.INSTANCE.serialize(value.cursor, g);
            g.writeFieldName("close");
            StoneSerializers.boolean_().serialize(value.close, g);
            if (value.contentHash != null) {
                g.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.contentHash, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionAppendArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionAppendArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UploadSessionCursor f_cursor = null;
                Boolean f_close = false;
                String f_contentHash = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = UploadSessionCursor.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("close".equals(field)) {
                        f_close = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("content_hash".equals(field)) {
                        f_contentHash = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_cursor == null) {
                    throw new JsonParseException(p, "Required field \"cursor\" missing.");
                }
                value = new UploadSessionAppendArg(f_cursor, f_close, f_contentHash);
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
