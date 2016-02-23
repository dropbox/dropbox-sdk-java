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

public class SearchMatch {
    // struct SearchMatch

    private final SearchMatchType matchType;
    private final Metadata metadata;

    /**
     *
     * @param matchType  The type of the match. Must not be {@code null}.
     * @param metadata  The metadata for the matched file or folder. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchMatch(SearchMatchType matchType, Metadata metadata) {
        if (matchType == null) {
            throw new IllegalArgumentException("Required value for 'matchType' is null");
        }
        this.matchType = matchType;
        if (metadata == null) {
            throw new IllegalArgumentException("Required value for 'metadata' is null");
        }
        this.metadata = metadata;
    }

    /**
     * The type of the match.
     *
     * @return value for this field, never {@code null}.
     */
    public SearchMatchType getMatchType() {
        return matchType;
    }

    /**
     * The metadata for the matched file or folder.
     *
     * @return value for this field, never {@code null}.
     */
    public Metadata getMetadata() {
        return metadata;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            matchType,
            metadata
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
            SearchMatch other = (SearchMatch) obj;
            return ((this.matchType == other.matchType) || (this.matchType.equals(other.matchType)))
                && ((this.metadata == other.metadata) || (this.metadata.equals(other.metadata)))
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

    public static SearchMatch fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SearchMatch> _JSON_WRITER = new JsonWriter<SearchMatch>() {
        public final void write(SearchMatch x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SearchMatch._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SearchMatch x, JsonGenerator g) throws IOException {
            g.writeFieldName("match_type");
            SearchMatchType._JSON_WRITER.write(x.matchType, g);
            g.writeFieldName("metadata");
            Metadata._JSON_WRITER.write(x.metadata, g);
        }
    };

    public static final JsonReader<SearchMatch> _JSON_READER = new JsonReader<SearchMatch>() {
        public final SearchMatch read(JsonParser parser) throws IOException, JsonReadException {
            SearchMatch result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SearchMatch readFields(JsonParser parser) throws IOException, JsonReadException {
            SearchMatchType matchType = null;
            Metadata metadata = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("match_type".equals(fieldName)) {
                    matchType = SearchMatchType._JSON_READER
                        .readField(parser, "match_type", matchType);
                }
                else if ("metadata".equals(fieldName)) {
                    metadata = Metadata._JSON_READER
                        .readField(parser, "metadata", metadata);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (matchType == null) {
                throw new JsonReadException("Required field \"match_type\" is missing.", parser.getTokenLocation());
            }
            if (metadata == null) {
                throw new JsonReadException("Required field \"metadata\" is missing.", parser.getTokenLocation());
            }
            return new SearchMatch(matchType, metadata);
        }
    };
}
