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
 * Policy governing who can be a member of a shared folder. Only applicable to
 * folders owned by a user on a team.
 */
@JsonSerialize(using=MemberPolicy.Serializer.class)
@JsonDeserialize(using=MemberPolicy.Deserializer.class)
public enum MemberPolicy {
    // union MemberPolicy
    /**
     * Only a teammate can become a member.
     */
    TEAM,
    /**
     * Anyone can become a member.
     */
    ANYONE,
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

    static final class Serializer extends UnionJsonSerializer<MemberPolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberPolicy.class);
        }

        @Override
        public void serialize(MemberPolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case TEAM:
                    g.writeString("team");
                    break;
                case ANYONE:
                    g.writeString("anyone");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MemberPolicy, MemberPolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberPolicy.class, getTagMapping(), MemberPolicy.OTHER);
        }

        @Override
        public MemberPolicy deserialize(MemberPolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MemberPolicy> getTagMapping() {
            Map<String, MemberPolicy> values = new HashMap<String, MemberPolicy>();
            values.put("team", MemberPolicy.TEAM);
            values.put("anyone", MemberPolicy.ANYONE);
            values.put("other", MemberPolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
