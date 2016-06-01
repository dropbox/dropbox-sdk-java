/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum ThumbnailSize {
    // union ThumbnailSize
    /**
     * 32 by 32 px.
     */
    W32H32,
    /**
     * 64 by 64 px.
     */
    W64H64,
    /**
     * 128 by 128 px.
     */
    W128H128,
    /**
     * 640 by 480 px.
     */
    W640H480,
    /**
     * 1024 by 768
     */
    W1024H768;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<ThumbnailSize> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailSize value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case W32H32: {
                    g.writeString("w32h32");
                    break;
                }
                case W64H64: {
                    g.writeString("w64h64");
                    break;
                }
                case W128H128: {
                    g.writeString("w128h128");
                    break;
                }
                case W640H480: {
                    g.writeString("w640h480");
                    break;
                }
                case W1024H768: {
                    g.writeString("w1024h768");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public ThumbnailSize deserialize(JsonParser p) throws IOException, JsonParseException {
            ThumbnailSize value;
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
            else if ("w32h32".equals(tag)) {
                value = ThumbnailSize.W32H32;
            }
            else if ("w64h64".equals(tag)) {
                value = ThumbnailSize.W64H64;
            }
            else if ("w128h128".equals(tag)) {
                value = ThumbnailSize.W128H128;
            }
            else if ("w640h480".equals(tag)) {
                value = ThumbnailSize.W640H480;
            }
            else if ("w1024h768".equals(tag)) {
                value = ThumbnailSize.W1024H768;
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
