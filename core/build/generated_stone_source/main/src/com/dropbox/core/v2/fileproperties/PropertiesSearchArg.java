/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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

class PropertiesSearchArg {
    // struct file_properties.PropertiesSearchArg (file_properties.stone)

    @Nonnull
    protected final List<PropertiesSearchQuery> queries;
    @Nonnull
    protected final TemplateFilter templateFilter;

    /**
     *
     * @param queries  Queries to search. Must contain at least 1 items, not
     *     contain a {@code null} item, and not be {@code null}.
     * @param templateFilter  Filter results to contain only properties
     *     associated with these template IDs. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchArg(@Nonnull List<PropertiesSearchQuery> queries, @Nonnull TemplateFilter templateFilter) {
        if (queries == null) {
            throw new IllegalArgumentException("Required value for 'queries' is null");
        }
        if (queries.size() < 1) {
            throw new IllegalArgumentException("List 'queries' has fewer than 1 items");
        }
        for (PropertiesSearchQuery x : queries) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'queries' is null");
            }
        }
        this.queries = queries;
        if (templateFilter == null) {
            throw new IllegalArgumentException("Required value for 'templateFilter' is null");
        }
        this.templateFilter = templateFilter;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param queries  Queries to search. Must contain at least 1 items, not
     *     contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchArg(@Nonnull List<PropertiesSearchQuery> queries) {
        this(queries, TemplateFilter.FILTER_NONE);
    }

    /**
     * Queries to search.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public List<PropertiesSearchQuery> getQueries() {
        return queries;
    }

    /**
     * Filter results to contain only properties associated with these template
     * IDs.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     TemplateFilter.FILTER_NONE.
     */
    @Nonnull
    public TemplateFilter getTemplateFilter() {
        return templateFilter;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            queries,
            templateFilter
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
            PropertiesSearchArg other = (PropertiesSearchArg) obj;
            return ((this.queries == other.queries) || (this.queries.equals(other.queries)))
                && ((this.templateFilter == other.templateFilter) || (this.templateFilter.equals(other.templateFilter)))
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
    static class Serializer extends StructSerializer<PropertiesSearchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("queries");
            StoneSerializers.list(PropertiesSearchQuery.Serializer.INSTANCE).serialize(value.queries, g);
            g.writeFieldName("template_filter");
            TemplateFilter.Serializer.INSTANCE.serialize(value.templateFilter, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertiesSearchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertiesSearchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<PropertiesSearchQuery> f_queries = null;
                TemplateFilter f_templateFilter = TemplateFilter.FILTER_NONE;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("queries".equals(field)) {
                        f_queries = StoneSerializers.list(PropertiesSearchQuery.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("template_filter".equals(field)) {
                        f_templateFilter = TemplateFilter.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_queries == null) {
                    throw new JsonParseException(p, "Required field \"queries\" missing.");
                }
                value = new PropertiesSearchArg(f_queries, f_templateFilter);
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
