/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Policy governing who can view shared links.
 */
@JsonSerialize(using=SharedLinkPolicy.Serializer.class)
@JsonDeserialize(using=SharedLinkPolicy.Deserializer.class)
public enum SharedLinkPolicy {
    // union SharedLinkPolicy
    /**
     * Links can be shared with anyone.
     */
    ANYONE,
    /**
     * Links can only be shared among members of the shared folder.
     */
    MEMBERS,
    /**
     * An unknown shared link policy.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SharedLinkPolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkPolicy.class);
        }

        @Override
        public void serialize(SharedLinkPolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case ANYONE:
                    g.writeString("anyone");
                    break;
                case MEMBERS:
                    g.writeString("members");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedLinkPolicy, SharedLinkPolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkPolicy.class, getTagMapping(), SharedLinkPolicy.OTHER);
        }

        @Override
        public SharedLinkPolicy deserialize(SharedLinkPolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedLinkPolicy> getTagMapping() {
            Map<String, SharedLinkPolicy> values = new HashMap<String, SharedLinkPolicy>();
            values.put("anyone", SharedLinkPolicy.ANYONE);
            values.put("members", SharedLinkPolicy.MEMBERS);
            values.put("other", SharedLinkPolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
