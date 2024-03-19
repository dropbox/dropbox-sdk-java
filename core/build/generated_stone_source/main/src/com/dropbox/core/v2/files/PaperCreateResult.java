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

public class PaperCreateResult {
    // struct files.PaperCreateResult (files.stone)

    @Nonnull
    protected final String url;
    @Nonnull
    protected final String resultPath;
    @Nonnull
    protected final String fileId;
    protected final long paperRevision;

    /**
     *
     * @param url  URL to open the Paper Doc. Must not be {@code null}.
     * @param resultPath  The fully qualified path the Paper Doc was actually
     *     created at. Must not be {@code null}.
     * @param fileId  The id to use in Dropbox APIs when referencing the Paper
     *     Doc. Must have length of at least 4, match pattern "{@code id:.+}",
     *     and not be {@code null}.
     * @param paperRevision  The current doc revision.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperCreateResult(@Nonnull String url, @Nonnull String resultPath, @Nonnull String fileId, long paperRevision) {
        if (url == null) {
            throw new IllegalArgumentException("Required value for 'url' is null");
        }
        this.url = url;
        if (resultPath == null) {
            throw new IllegalArgumentException("Required value for 'resultPath' is null");
        }
        this.resultPath = resultPath;
        if (fileId == null) {
            throw new IllegalArgumentException("Required value for 'fileId' is null");
        }
        if (fileId.length() < 4) {
            throw new IllegalArgumentException("String 'fileId' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", fileId)) {
            throw new IllegalArgumentException("String 'fileId' does not match pattern");
        }
        this.fileId = fileId;
        this.paperRevision = paperRevision;
    }

    /**
     * URL to open the Paper Doc.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getUrl() {
        return url;
    }

    /**
     * The fully qualified path the Paper Doc was actually created at.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getResultPath() {
        return resultPath;
    }

    /**
     * The id to use in Dropbox APIs when referencing the Paper Doc.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getFileId() {
        return fileId;
    }

    /**
     * The current doc revision.
     *
     * @return value for this field.
     */
    public long getPaperRevision() {
        return paperRevision;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            url,
            resultPath,
            fileId,
            paperRevision
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
            PaperCreateResult other = (PaperCreateResult) obj;
            return ((this.url == other.url) || (this.url.equals(other.url)))
                && ((this.resultPath == other.resultPath) || (this.resultPath.equals(other.resultPath)))
                && ((this.fileId == other.fileId) || (this.fileId.equals(other.fileId)))
                && (this.paperRevision == other.paperRevision)
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
    static class Serializer extends StructSerializer<PaperCreateResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperCreateResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("url");
            StoneSerializers.string().serialize(value.url, g);
            g.writeFieldName("result_path");
            StoneSerializers.string().serialize(value.resultPath, g);
            g.writeFieldName("file_id");
            StoneSerializers.string().serialize(value.fileId, g);
            g.writeFieldName("paper_revision");
            StoneSerializers.int64().serialize(value.paperRevision, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperCreateResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperCreateResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_url = null;
                String f_resultPath = null;
                String f_fileId = null;
                Long f_paperRevision = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("url".equals(field)) {
                        f_url = StoneSerializers.string().deserialize(p);
                    }
                    else if ("result_path".equals(field)) {
                        f_resultPath = StoneSerializers.string().deserialize(p);
                    }
                    else if ("file_id".equals(field)) {
                        f_fileId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("paper_revision".equals(field)) {
                        f_paperRevision = StoneSerializers.int64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_url == null) {
                    throw new JsonParseException(p, "Required field \"url\" missing.");
                }
                if (f_resultPath == null) {
                    throw new JsonParseException(p, "Required field \"result_path\" missing.");
                }
                if (f_fileId == null) {
                    throw new JsonParseException(p, "Required field \"file_id\" missing.");
                }
                if (f_paperRevision == null) {
                    throw new JsonParseException(p, "Required field \"paper_revision\" missing.");
                }
                value = new PaperCreateResult(f_url, f_resultPath, f_fileId, f_paperRevision);
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
