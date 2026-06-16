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

public class SearchMatchFieldOptions {
    // struct files.SearchMatchFieldOptions (files.stone)

    protected final boolean includeHighlights;

    /**
     *
     * @param includeHighlights  Whether to include highlight span from file
     *     title.
     */
    public SearchMatchFieldOptions(boolean includeHighlights) {
        this.includeHighlights = includeHighlights;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SearchMatchFieldOptions() {
        this(false);
    }

    /**
     * Whether to include highlight span from file title.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getIncludeHighlights() {
        return includeHighlights;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.includeHighlights
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
            SearchMatchFieldOptions other = (SearchMatchFieldOptions) obj;
            return this.includeHighlights == other.includeHighlights;
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
    static class Serializer extends StructSerializer<SearchMatchFieldOptions> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchMatchFieldOptions value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("include_highlights");
            StoneSerializers.boolean_().serialize(value.includeHighlights, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchMatchFieldOptions deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchMatchFieldOptions value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Boolean f_includeHighlights = false;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("include_highlights".equals(field)) {
                        f_includeHighlights = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SearchMatchFieldOptions(f_includeHighlights);
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
