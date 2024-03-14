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

public class PropertiesSearchQuery {
    // struct file_properties.PropertiesSearchQuery (file_properties.stone)

    protected final String query;
    protected final PropertiesSearchMode mode;
    protected final LogicalOperator logicalOperator;

    /**
     *
     * @param query  The property field value for which to search across
     *     templates. Must not be {@code null}.
     * @param mode  The mode with which to perform the search. Must not be
     *     {@code null}.
     * @param logicalOperator  The logical operator with which to append the
     *     query. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchQuery(String query, PropertiesSearchMode mode, LogicalOperator logicalOperator) {
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        this.query = query;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
        if (logicalOperator == null) {
            throw new IllegalArgumentException("Required value for 'logicalOperator' is null");
        }
        this.logicalOperator = logicalOperator;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param query  The property field value for which to search across
     *     templates. Must not be {@code null}.
     * @param mode  The mode with which to perform the search. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertiesSearchQuery(String query, PropertiesSearchMode mode) {
        this(query, mode, LogicalOperator.OR_OPERATOR);
    }

    /**
     * The property field value for which to search across templates.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getQuery() {
        return query;
    }

    /**
     * The mode with which to perform the search.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public PropertiesSearchMode getMode() {
        return mode;
    }

    /**
     * The logical operator with which to append the query.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     LogicalOperator.OR_OPERATOR.
     */
    @javax.annotation.Nonnull
    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            query,
            mode,
            logicalOperator
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
            PropertiesSearchQuery other = (PropertiesSearchQuery) obj;
            return ((this.query == other.query) || (this.query.equals(other.query)))
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
                && ((this.logicalOperator == other.logicalOperator) || (this.logicalOperator.equals(other.logicalOperator)))
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
    static class Serializer extends StructSerializer<PropertiesSearchQuery> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertiesSearchQuery value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("query");
            StoneSerializers.string().serialize(value.query, g);
            g.writeFieldName("mode");
            PropertiesSearchMode.Serializer.INSTANCE.serialize(value.mode, g);
            g.writeFieldName("logical_operator");
            LogicalOperator.Serializer.INSTANCE.serialize(value.logicalOperator, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertiesSearchQuery deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertiesSearchQuery value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_query = null;
                PropertiesSearchMode f_mode = null;
                LogicalOperator f_logicalOperator = LogicalOperator.OR_OPERATOR;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("query".equals(field)) {
                        f_query = StoneSerializers.string().deserialize(p);
                    }
                    else if ("mode".equals(field)) {
                        f_mode = PropertiesSearchMode.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("logical_operator".equals(field)) {
                        f_logicalOperator = LogicalOperator.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_query == null) {
                    throw new JsonParseException(p, "Required field \"query\" missing.");
                }
                if (f_mode == null) {
                    throw new JsonParseException(p, "Required field \"mode\" missing.");
                }
                value = new PropertiesSearchQuery(f_query, f_mode, f_logicalOperator);
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
