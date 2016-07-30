/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class UploadSessionFinishArg {
    // struct UploadSessionFinishArg

    protected final UploadSessionCursor cursor;
    protected final CommitInfo commit;

    /**
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
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        if (commit == null) {
            throw new IllegalArgumentException("Required value for 'commit' is null");
        }
        this.commit = commit;
    }

    /**
     * Contains the upload session ID and the offset.
     *
     * @return value for this field, never {@code null}.
     */
    public UploadSessionCursor getCursor() {
        return cursor;
    }

    /**
     * Contains the path and other optional modifiers for the commit.
     *
     * @return value for this field, never {@code null}.
     */
    public CommitInfo getCommit() {
        return commit;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor,
            commit
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            UploadSessionFinishArg other = (UploadSessionFinishArg) obj;
            return ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && ((this.commit == other.commit) || (this.commit.equals(other.commit)))
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
    static final class Serializer extends StructSerializer<UploadSessionFinishArg> {
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
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = UploadSessionCursor.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("commit".equals(field)) {
                        f_commit = CommitInfo.Serializer.INSTANCE.deserialize(p);
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
                value = new UploadSessionFinishArg(f_cursor, f_commit);
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
