/* DO NOT EDIT */
/* This file was generated from team_policies.babel */

package com.dropbox.core.v2.teampolicies;

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
 * Policy governing the visibility of newly created shared links.
 */
@JsonSerialize(using=SharedLinkCreatePolicy.Serializer.class)
@JsonDeserialize(using=SharedLinkCreatePolicy.Deserializer.class)
public enum SharedLinkCreatePolicy {
    // union SharedLinkCreatePolicy
    /**
     * By default, anyone can access newly created shared links. No login will
     * be required to access the shared links unless overridden.
     */
    DEFAULT_PUBLIC,
    /**
     * By default, only members of the same team can access newly created shared
     * links. Login will be required to access the shared links unless
     * overridden.
     */
    DEFAULT_TEAM_ONLY,
    /**
     * Only members of the same team can access newly created shared links.
     * Login will be required to access the shared links.
     */
    TEAM_ONLY,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SharedLinkCreatePolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkCreatePolicy.class);
        }

        @Override
        public void serialize(SharedLinkCreatePolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case DEFAULT_PUBLIC:
                    g.writeString("default_public");
                    break;
                case DEFAULT_TEAM_ONLY:
                    g.writeString("default_team_only");
                    break;
                case TEAM_ONLY:
                    g.writeString("team_only");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedLinkCreatePolicy, SharedLinkCreatePolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkCreatePolicy.class, getTagMapping(), SharedLinkCreatePolicy.OTHER);
        }

        @Override
        public SharedLinkCreatePolicy deserialize(SharedLinkCreatePolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedLinkCreatePolicy> getTagMapping() {
            Map<String, SharedLinkCreatePolicy> values = new HashMap<String, SharedLinkCreatePolicy>();
            values.put("default_public", SharedLinkCreatePolicy.DEFAULT_PUBLIC);
            values.put("default_team_only", SharedLinkCreatePolicy.DEFAULT_TEAM_ONLY);
            values.put("team_only", SharedLinkCreatePolicy.TEAM_ONLY);
            values.put("other", SharedLinkCreatePolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
