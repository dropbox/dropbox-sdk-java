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

class RelocationBatchArgBase {
    // struct files.RelocationBatchArgBase (files.stone)

    protected final List<RelocationPath> entries;
    protected final boolean autorename;

    /**
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, not contain a
     *     {@code null} item, and not be {@code null}.
     * @param autorename  If there's a conflict with any file, have the Dropbox
     *     server try to autorename that file to avoid the conflict.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchArgBase(List<RelocationPath> entries, boolean autorename) {
        if (entries == null) {
            throw new IllegalArgumentException("Required value for 'entries' is null");
        }
        if (entries.size() < 1) {
            throw new IllegalArgumentException("List 'entries' has fewer than 1 items");
        }
        for (RelocationPath x : entries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'entries' is null");
            }
        }
        this.entries = entries;
        this.autorename = autorename;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, not contain a
     *     {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchArgBase(List<RelocationPath> entries) {
        this(entries, false);
    }

    /**
     * List of entries to be moved or copied. Each entry is {@link
     * RelocationPath}.
     *
     * @return value for this field, never {@code null}.
     */
    public List<RelocationPath> getEntries() {
        return entries;
    }

    /**
     * If there's a conflict with any file, have the Dropbox server try to
     * autorename that file to avoid the conflict.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getAutorename() {
        return autorename;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            entries,
            autorename
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
            RelocationBatchArgBase other = (RelocationBatchArgBase) obj;
            return ((this.entries == other.entries) || (this.entries.equals(other.entries)))
                && (this.autorename == other.autorename)
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
    static class Serializer extends StructSerializer<RelocationBatchArgBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchArgBase value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("entries");
            StoneSerializers.list(RelocationPath.Serializer.INSTANCE).serialize(value.entries, g);
            g.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(value.autorename, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocationBatchArgBase deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocationBatchArgBase value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<RelocationPath> f_entries = null;
                Boolean f_autorename = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("entries".equals(field)) {
                        f_entries = StoneSerializers.list(RelocationPath.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("autorename".equals(field)) {
                        f_autorename = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_entries == null) {
                    throw new JsonParseException(p, "Required field \"entries\" missing.");
                }
                value = new RelocationBatchArgBase(f_entries, f_autorename);
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
