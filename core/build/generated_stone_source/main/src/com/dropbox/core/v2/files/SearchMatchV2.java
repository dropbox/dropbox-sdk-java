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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SearchMatchV2 {
    // struct files.SearchMatchV2 (files.stone)

    protected final MetadataV2 metadata;
    protected final SearchMatchTypeV2 matchType;
    protected final List<HighlightSpan> highlightSpans;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param metadata  The metadata for the matched file or folder. Must not be
     *     {@code null}.
     * @param matchType  The type of the match.
     * @param highlightSpans  The list of HighlightSpan determines which parts
     *     of the file title should be highlighted. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchMatchV2(@Nonnull MetadataV2 metadata, @Nullable SearchMatchTypeV2 matchType, @Nullable List<HighlightSpan> highlightSpans) {
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
        this.matchType = matchType;
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
    public SearchMatchV2(@Nonnull MetadataV2 metadata) {
        this(metadata, null, null);
    }

    /**
     * The metadata for the matched file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public MetadataV2 getMetadata() {
        return metadata;
    }

    /**
     * The type of the match.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SearchMatchTypeV2 getMatchType() {
        return matchType;
    }

    /**
     * The list of HighlightSpan determines which parts of the file title should
     * be highlighted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<HighlightSpan> getHighlightSpans() {
        return highlightSpans;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param metadata  The metadata for the matched file or folder. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(MetadataV2 metadata) {
        return new Builder(metadata);
    }

    /**
     * Builder for {@link SearchMatchV2}.
     */
    public static class Builder {
        protected final MetadataV2 metadata;

        protected SearchMatchTypeV2 matchType;
        protected List<HighlightSpan> highlightSpans;

        protected Builder(MetadataV2 metadata) {
            if (metadata == null) {
                throw new IllegalArgumentException("Required value for 'metadata' is null");
            }
            this.metadata = metadata;
            this.matchType = null;
            this.highlightSpans = null;
        }

        /**
         * Set value for optional field.
         *
         * @param matchType  The type of the match.
         *
         * @return this builder
         */
        public Builder withMatchType(SearchMatchTypeV2 matchType) {
            this.matchType = matchType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param highlightSpans  The list of HighlightSpan determines which
         *     parts of the file title should be highlighted. Must not contain a
         *     {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withHighlightSpans(List<HighlightSpan> highlightSpans) {
            if (highlightSpans != null) {
                for (HighlightSpan x : highlightSpans) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'highlightSpans' is null");
                    }
                }
            }
            this.highlightSpans = highlightSpans;
            return this;
        }

        /**
         * Builds an instance of {@link SearchMatchV2} configured with this
         * builder's values
         *
         * @return new instance of {@link SearchMatchV2}
         */
        public SearchMatchV2 build() {
            return new SearchMatchV2(metadata, matchType, highlightSpans);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            metadata,
            matchType,
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
                && ((this.matchType == other.matchType) || (this.matchType != null && this.matchType.equals(other.matchType)))
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
            if (value.matchType != null) {
                g.writeFieldName("match_type");
                StoneSerializers.nullable(SearchMatchTypeV2.Serializer.INSTANCE).serialize(value.matchType, g);
            }
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
                SearchMatchTypeV2 f_matchType = null;
                List<HighlightSpan> f_highlightSpans = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("metadata".equals(field)) {
                        f_metadata = MetadataV2.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("match_type".equals(field)) {
                        f_matchType = StoneSerializers.nullable(SearchMatchTypeV2.Serializer.INSTANCE).deserialize(p);
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
                value = new SearchMatchV2(f_metadata, f_matchType, f_highlightSpans);
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
