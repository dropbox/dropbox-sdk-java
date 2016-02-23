/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class UploadSessionFinishArg {
    // struct UploadSessionFinishArg

    private final UploadSessionCursor cursor;
    private final CommitInfo commit;

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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UploadSessionFinishArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UploadSessionFinishArg> _JSON_WRITER = new JsonWriter<UploadSessionFinishArg>() {
        public final void write(UploadSessionFinishArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            UploadSessionFinishArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(UploadSessionFinishArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("cursor");
            UploadSessionCursor._JSON_WRITER.write(x.cursor, g);
            g.writeFieldName("commit");
            CommitInfo._JSON_WRITER.write(x.commit, g);
        }
    };

    public static final JsonReader<UploadSessionFinishArg> _JSON_READER = new JsonReader<UploadSessionFinishArg>() {
        public final UploadSessionFinishArg read(JsonParser parser) throws IOException, JsonReadException {
            UploadSessionFinishArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final UploadSessionFinishArg readFields(JsonParser parser) throws IOException, JsonReadException {
            UploadSessionCursor cursor = null;
            CommitInfo commit = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("cursor".equals(fieldName)) {
                    cursor = UploadSessionCursor._JSON_READER
                        .readField(parser, "cursor", cursor);
                }
                else if ("commit".equals(fieldName)) {
                    commit = CommitInfo._JSON_READER
                        .readField(parser, "commit", commit);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (cursor == null) {
                throw new JsonReadException("Required field \"cursor\" is missing.", parser.getTokenLocation());
            }
            if (commit == null) {
                throw new JsonReadException("Required field \"commit\" is missing.", parser.getTokenLocation());
            }
            return new UploadSessionFinishArg(cursor, commit);
        }
    };
}
