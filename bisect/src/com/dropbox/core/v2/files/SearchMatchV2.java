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

public class SearchMatchV2 {
    // struct files.SearchMatchV2 (files.stone)

    protected final MetadataV2 metadata;
    protected final List<HighlightSpan> highlightSpans;

    /**
     *
     * @param metadata  The metadata for the matched file or folder. Must not be
     *     {@code null}.
     * @param highlightSpans  The list of HighlightSpan determines which parts
     *     of the result should be highlighted. Must not contain a {@code null}
     *     item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchMatchV2(MetadataV2 metadata, List<HighlightSpan> highlightSpans) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        if (highlightSpans != null) {
            for (HighlightSpan x : highlightSpans) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'highlightSpans' is null");
                }
            }
        }
        this.highlightSpans = highlightSpans;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param metadata  The metadata for the matched file or folder. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchMatchV2(MetadataV2 metadata) {
        this(metadata, null);
    }

    /**
     * The metadata for the matched file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public MetadataV2 getMetadata() {
        return metadata;
    }

    /**
     * The list of HighlightSpan determines which parts of the result should be
     * highlighted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<HighlightSpan> getHighlightSpans() {
        return highlightSpans;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            metadata,
            highlightSpans
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
            SearchMatchV2 other = (SearchMatchV2) obj;
            return ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
                && ((this.highlightSpans == other.highlightSpans) || (this.highlightSpans != null && this.highlightSpans.equals(other.highlightSpans)))
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
    static class Serializer extends StructSerializer<SearchMatchV2> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchMatchV2 value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("metadata");
            MetadataV2.Serializer.INSTANCE.serialize(value.metadata, g);
            if (value.highlightSpans != null) {
                g.writeFieldName("highlight_spans");
                StoneSerializers.nullable(StoneSerializers.list(HighlightSpan.Serializer.INSTANCE)).serialize(value.highlightSpans, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchMatchV2 deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchMatchV2 value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                MetadataV2 f_metadata = null;
                List<HighlightSpan> f_highlightSpans = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("metadata".equals(field)) {
                        f_metadata = MetadataV2.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("highlight_spans".equals(field)) {
                        f_highlightSpans = StoneSerializers.nullable(StoneSerializers.list(HighlightSpan.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_metadata == null) {
                    throw new JsonParseException(p, "Required field \"metadata\" missing.");
                }
                value = new SearchMatchV2(f_metadata, f_highlightSpans);
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
