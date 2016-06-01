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
import java.util.List;

public class ListRevisionsResult {
    // struct ListRevisionsResult

    protected final boolean isDeleted;
    protected final List<FileMetadata> entries;

    /**
     *
     * @param isDeleted  If the file is deleted.
     * @param entries  The revisions for the file. Only non-delete revisions
     *     will show up here. Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult(boolean isDeleted, List<FileMetadata> entries) {
        this.isDeleted = isDeleted;
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        for (FileMetadata x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
    }

    /**
     * If the file is deleted.
     *
     * @return value for this field.
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * The revisions for the file. Only non-delete revisions will show up here.
     *
     * @return value for this field, never {@code null}.
     */
    public List<FileMetadata> getEntries() {
        return entries;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            isDeleted,
            entries
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
            ListRevisionsResult other = (ListRevisionsResult) obj;
            return (this.isDeleted == other.isDeleted)
                && ((this.entries == other.entries) || (this.entries.equals(other.entries)))
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
    static final class Serializer extends StructSerializer<ListRevisionsResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListRevisionsResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("is_deleted");
            StoneSerializers.boolean_().serialize(value.isDeleted, g);
            g.writeFieldName("entries");
            StoneSerializers.list(FileMetadata.Serializer.INSTANCE).serialize(value.entries, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListRevisionsResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListRevisionsResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_isDeleted = null;
                List<FileMetadata> f_entries = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("is_deleted".equals(field)) {
                        f_isDeleted = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(FileMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_isDeleted == null) {
                    throw new JsonParseException(p, "Required field \"is_deleted\" missing.");
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new ListRevisionsResult(f_isDeleted, f_entries);
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
