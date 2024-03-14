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

public class UploadSessionFinishArg {
    // struct files.UploadSessionFinishArg (files.stone)

    protected final UploadSessionCursor cursor;
    protected final CommitInfo commit;
    protected final String contentHash;

    /**
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. Must not be {@code null}.
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
    public UploadSessionFinishArg(UploadSessionCursor cursor, CommitInfo commit, String contentHash) {
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        if (commit == null) {
            throw new IllegalArgumentException("Required value for 'commit' is null");
        }
        this.commit = commit;
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
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishArg(UploadSessionCursor cursor, CommitInfo commit) {
        this(cursor, commit, null);
    }

    /**
     * Contains the upload session ID and the offset.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public UploadSessionCursor getCursor() {
        return cursor;
    }

    /**
     * Contains the path and other optional modifiers for the commit.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public CommitInfo getCommit() {
        return commit;
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
    @javax.annotation.Nullable
    public String getContentHash() {
        return contentHash;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            cursor,
            commit,
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
            UploadSessionFinishArg other = (UploadSessionFinishArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && ((this.commit == other.commit) || (this.commit.equals(other.commit)))
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
    static class Serializer extends StructSerializer<UploadSessionFinishArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionFinishArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("cursor");
            UploadSessionCursor.Serializer.INSTANCE.serialize(value.cursor, g);
            g.writeFieldName("commit");
            CommitInfo.Serializer.INSTANCE.serialize(value.commit, g);
            if (value.contentHash != null) {
                g.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.contentHash, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionFinishArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionFinishArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UploadSessionCursor f_cursor = null;
                CommitInfo f_commit = null;
                String f_contentHash = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = UploadSessionCursor.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("commit".equals(field)) {
                        f_commit = CommitInfo.Serializer.INSTANCE.deserialize(p);
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
                if (f_commit == null) {
                    throw new JsonParseException(p, "Required field \"commit\" missing.");
                }
                value = new UploadSessionFinishArg(f_cursor, f_commit, f_contentHash);
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
