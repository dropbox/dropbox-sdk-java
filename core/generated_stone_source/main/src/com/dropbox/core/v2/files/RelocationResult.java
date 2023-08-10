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

public class RelocationResult extends FileOpsResult {
    // struct files.RelocationResult (files.stone)

    protected final Metadata metadata;

    /**
     *
     * @param metadata  Metadata of the relocated object. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationResult(Metadata metadata) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
    }

    /**
     * Metadata of the relocated object.
     *
     * @return value for this field, never {@code null}.
     */
    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            metadata
        });
        hash = (31 * super.hashCode()) + hash;
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
            RelocationResult other = (RelocationResult) obj;
            return (this.metadata == other.metadata) || (this.metadata.equals(other.metadata));
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
    static class Serializer extends StructSerializer<RelocationResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("metadata");
            Metadata.Serializer.INSTANCE.serialize(value.metadata, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public RelocationResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            RelocationResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Metadata f_metadata = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("metadata".equals(field)) {
                        f_metadata = Metadata.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_metadata == null) {
                    throw new JsonParseException(p, "Required field \"metadata\" missing.");
                }
                value = new RelocationResult(f_metadata);
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
