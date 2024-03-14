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

class DeleteBatchArg {
    // struct files.DeleteBatchArg (files.stone)

    protected final List<DeleteArg> entries;

    /**
     *
     * @param entries  Must contain at most 1000 items, not contain a {@code
     *     null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteBatchArg(List<DeleteArg> entries) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        if (entries.size() > 1000) {
            throw new IllegalArgumentException("List 'entries' has more than 1000 items");
        }
        for (DeleteArg x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<DeleteArg> getEntries() {
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
            DeleteBatchArg other = (DeleteBatchArg) obj;
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
    static class Serializer extends StructSerializer<DeleteBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DeleteBatchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(DeleteArg.Serializer.INSTANCE).serialize(value.entries, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DeleteBatchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DeleteBatchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<DeleteArg> f_entries = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(DeleteArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new DeleteBatchArg(f_entries);
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
