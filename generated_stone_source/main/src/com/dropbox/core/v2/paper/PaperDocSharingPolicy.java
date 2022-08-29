/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

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

class PaperDocSharingPolicy extends RefPaperDoc {
    // struct paper.PaperDocSharingPolicy (paper.stone)

    protected final SharingPolicy sharingPolicy;

    /**
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param sharingPolicy  The default sharing policy to be set for the Paper
     *     doc. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperDocSharingPolicy(String docId, SharingPolicy sharingPolicy) {
        super(docId);
        if (sharingPolicy == null) {
            throw new IllegalArgumentException("Required value for 'sharingPolicy' is null");
        }
        this.sharingPolicy = sharingPolicy;
    }

    /**
     * The Paper doc ID.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDocId() {
        return docId;
    }

    /**
     * The default sharing policy to be set for the Paper doc.
     *
     * @return value for this field, never {@code null}.
     */
    public SharingPolicy getSharingPolicy() {
        return sharingPolicy;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            sharingPolicy
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
            PaperDocSharingPolicy other = (PaperDocSharingPolicy) obj;
            return ((this.docId == other.docId) || (this.docId.equals(other.docId)))
                && ((this.sharingPolicy == other.sharingPolicy) || (this.sharingPolicy.equals(other.sharingPolicy)))
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
    static class Serializer extends StructSerializer<PaperDocSharingPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PaperDocSharingPolicy value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("doc_id");
            StoneSerializers.string().serialize(value.docId, g);
            g.writeFieldName("sharing_policy");
            SharingPolicy.Serializer.INSTANCE.serialize(value.sharingPolicy, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PaperDocSharingPolicy deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PaperDocSharingPolicy value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_docId = null;
                SharingPolicy f_sharingPolicy = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("doc_id".equals(field)) {
                        f_docId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sharing_policy".equals(field)) {
                        f_sharingPolicy = SharingPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_docId == null) {
                    throw new JsonParseException(p, "Required field \"doc_id\" missing.");
                }
                if (f_sharingPolicy == null) {
                    throw new JsonParseException(p, "Required field \"sharing_policy\" missing.");
                }
                value = new PaperDocSharingPolicy(f_docId, f_sharingPolicy);
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
