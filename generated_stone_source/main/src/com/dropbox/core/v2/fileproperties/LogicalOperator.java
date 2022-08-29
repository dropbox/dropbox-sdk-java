/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Logical operator to join search queries together.
 */
public enum LogicalOperator {
    // union file_properties.LogicalOperator (file_properties.stone)
    /**
     * Append a query with an "or" operator.
     */
    OR_OPERATOR,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<LogicalOperator> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LogicalOperator value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case OR_OPERATOR: {
                    g.writeString("or_operator");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LogicalOperator deserialize(JsonParser p) throws IOException, JsonParseException {
            LogicalOperator value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("or_operator".equals(tag)) {
                value = LogicalOperator.OR_OPERATOR;
            }
            else {
                value = LogicalOperator.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
