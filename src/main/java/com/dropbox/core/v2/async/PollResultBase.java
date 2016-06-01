/* DO NOT EDIT */
/* This file was generated from async.stone */

package com.dropbox.core.v2.async;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Result returned by methods that poll for the status of an asynchronous job.
 * Unions that extend this union should add a 'complete' field with a type of
 * the information returned upon job completion. See {@link PollEmptyResult} for
 * an example.
 */
public enum PollResultBase {
    // union PollResultBase
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<PollResultBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PollResultBase value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PollResultBase deserialize(JsonParser p) throws IOException, JsonParseException {
            PollResultBase value;
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
            else if ("in_progress".equals(tag)) {
                value = PollResultBase.IN_PROGRESS;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
