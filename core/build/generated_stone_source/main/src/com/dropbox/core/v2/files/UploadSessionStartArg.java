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

class UploadSessionStartArg {
    // struct files.UploadSessionStartArg (files.stone)

    protected final boolean close;
    @Nullable
    protected final UploadSessionType sessionType;
    @Nullable
    protected final String contentHash;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param close  If true, the current session will be closed, at which point
     *     you won't be able to call {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     anymore with the current session.
     * @param sessionType  Type of upload session you want to start. If not
     *     specified, default is {@link UploadSessionType#SEQUENTIAL}.
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
    public UploadSessionStartArg(boolean close, @Nullable UploadSessionType sessionType, @Nullable String contentHash) {
        this.close = close;
        this.sessionType = sessionType;
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
     */
    public UploadSessionStartArg() {
        this(false, null, null);
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
     * Type of upload session you want to start. If not specified, default is
     * {@link UploadSessionType#SEQUENTIAL}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public UploadSessionType getSessionType() {
        return sessionType;
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
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link UploadSessionStartArg}.
     */
    public static class Builder {

        protected boolean close;
        protected UploadSessionType sessionType;
        protected String contentHash;

        protected Builder() {
            this.close = false;
            this.sessionType = null;
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
         * @param sessionType  Type of upload session you want to start. If not
         *     specified, default is {@link UploadSessionType#SEQUENTIAL}.
         *
         * @return this builder
         */
        public Builder withSessionType(UploadSessionType sessionType) {
            this.sessionType = sessionType;
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
         * Builds an instance of {@link UploadSessionStartArg} configured with
         * this builder's values
         *
         * @return new instance of {@link UploadSessionStartArg}
         */
        public UploadSessionStartArg build() {
            return new UploadSessionStartArg(close, sessionType, contentHash);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            close,
            sessionType,
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
            UploadSessionStartArg other = (UploadSessionStartArg) obj;
            return (this.close == other.close)
                && ((this.sessionType == other.sessionType) || (this.sessionType != null && this.sessionType.equals(other.sessionType)))
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
    static class Serializer extends StructSerializer<UploadSessionStartArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionStartArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("close");
            StoneSerializers.boolean_().serialize(value.close, g);
            if (value.sessionType != null) {
                g.writeFieldName("session_type");
                StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).serialize(value.sessionType, g);
            }
            if (value.contentHash != null) {
                g.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.contentHash, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionStartArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionStartArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_close = false;
                UploadSessionType f_sessionType = null;
                String f_contentHash = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("close".equals(field)) {
                        f_close = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("session_type".equals(field)) {
                        f_sessionType = StoneSerializers.nullable(UploadSessionType.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("content_hash".equals(field)) {
                        f_contentHash = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new UploadSessionStartArg(f_close, f_sessionType, f_contentHash);
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
