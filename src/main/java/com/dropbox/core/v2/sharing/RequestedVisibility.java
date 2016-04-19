/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

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
 * The access permission that can be requested by the caller for the shared
 * link. Note that the final resolved visibility of the shared link takes into
 * account other aspects, such as team and shared folder settings. Check the
 * {@link ResolvedVisibility} for more info on the possible resolved visibility
 * values of shared links.
 */
@JsonSerialize(using=RequestedVisibility.Serializer.class)
@JsonDeserialize(using=RequestedVisibility.Deserializer.class)
public enum RequestedVisibility {
    // union RequestedVisibility
    /**
     * Anyone who has received the link can access it. No login required.
     */
    PUBLIC,
    /**
     * Only members of the same team can access the link. Login is required.
     */
    TEAM_ONLY,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<RequestedVisibility> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RequestedVisibility.class);
        }

        @Override
        public void serialize(RequestedVisibility value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case PUBLIC:
                    g.writeString("public");
                    break;
                case TEAM_ONLY:
                    g.writeString("team_only");
                    break;
                case PASSWORD:
                    g.writeString("password");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RequestedVisibility, RequestedVisibility> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RequestedVisibility.class, getTagMapping(), null);
        }

        @Override
        public RequestedVisibility deserialize(RequestedVisibility _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, RequestedVisibility> getTagMapping() {
            Map<String, RequestedVisibility> values = new HashMap<String, RequestedVisibility>();
            values.put("public", RequestedVisibility.PUBLIC);
            values.put("team_only", RequestedVisibility.TEAM_ONLY);
            values.put("password", RequestedVisibility.PASSWORD);
            return Collections.unmodifiableMap(values);
        }
    }
}
