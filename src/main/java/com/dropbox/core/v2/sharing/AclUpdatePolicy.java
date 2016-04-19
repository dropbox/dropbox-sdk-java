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
 * Policy governing who can change a shared folder's access control list (ACL).
 * In other words, who can add, remove, or change the privileges of members.
 */
@JsonSerialize(using=AclUpdatePolicy.Serializer.class)
@JsonDeserialize(using=AclUpdatePolicy.Deserializer.class)
public enum AclUpdatePolicy {
    // union AclUpdatePolicy
    /**
     * Only the owner can update the ACL.
     */
    OWNER,
    /**
     * Any editor can update the ACL. This may be further restricted to editors
     * on the same team.
     */
    EDITORS,
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

    static final class Serializer extends UnionJsonSerializer<AclUpdatePolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AclUpdatePolicy.class);
        }

        @Override
        public void serialize(AclUpdatePolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case OWNER:
                    g.writeString("owner");
                    break;
                case EDITORS:
                    g.writeString("editors");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AclUpdatePolicy, AclUpdatePolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AclUpdatePolicy.class, getTagMapping(), AclUpdatePolicy.OTHER);
        }

        @Override
        public AclUpdatePolicy deserialize(AclUpdatePolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, AclUpdatePolicy> getTagMapping() {
            Map<String, AclUpdatePolicy> values = new HashMap<String, AclUpdatePolicy>();
            values.put("owner", AclUpdatePolicy.OWNER);
            values.put("editors", AclUpdatePolicy.EDITORS);
            values.put("other", AclUpdatePolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
