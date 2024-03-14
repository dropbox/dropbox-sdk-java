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

public class UploadSessionFinishBatchResult {
    // struct files.UploadSessionFinishBatchResult (files.stone)

    protected final List<UploadSessionFinishBatchResultEntry> entries;

    /**
     *
     * @param entries  Each entry in {@link
     *     UploadSessionFinishBatchArg#getEntries} will appear at the same
     *     position inside {@link UploadSessionFinishBatchResult#getEntries}.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishBatchResult(@javax.annotation.Nonnull List<UploadSessionFinishBatchResultEntry> entries) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (UploadSessionFinishBatchResultEntry x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
    }

    /**
     * Each entry in {@link UploadSessionFinishBatchArg#getEntries} will appear
     * at the same position inside {@link
     * UploadSessionFinishBatchResult#getEntries}.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<UploadSessionFinishBatchResultEntry> getEntries() {
        return entries;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            entries
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
            UploadSessionFinishBatchResult other = (UploadSessionFinishBatchResult) obj;
            return (this.entries == other.entries) || (this.entries.equals(other.entries));
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
    static class Serializer extends StructSerializer<UploadSessionFinishBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadSessionFinishBatchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(UploadSessionFinishBatchResultEntry.Serializer.INSTANCE).serialize(value.entries, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UploadSessionFinishBatchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UploadSessionFinishBatchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<UploadSessionFinishBatchResultEntry> f_entries = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(UploadSessionFinishBatchResultEntry.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new UploadSessionFinishBatchResult(f_entries);
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
