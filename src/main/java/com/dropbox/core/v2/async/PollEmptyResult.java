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
 * Upon completion of the job, no additional information is returned.
 */
public enum PollEmptyResult {
    // union PollEmptyResult
    /**
     * The asynchronous job is still in progress.
     */
    IN_PROGRESS,
    /**
     * The asynchronous job has completed successfully.
     */
    COMPLETE;

    /**
     * For internal use only.
     */
    public static final class Serializer extends UnionSerializer<PollEmptyResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PollEmptyResult value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case COMPLETE: {
                    g.writeString("complete");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public PollEmptyResult deserialize(JsonParser p) throws IOException, JsonParseException {
            PollEmptyResult value;
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
                value = PollEmptyResult.IN_PROGRESS;
            }
            else if ("complete".equals(tag)) {
                value = PollEmptyResult.COMPLETE;
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
