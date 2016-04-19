/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

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
 * Policy governing who can be a member of a folder shared by a team member.
 */
@JsonSerialize(using=SharedFolderMemberPolicy.Serializer.class)
@JsonDeserialize(using=SharedFolderMemberPolicy.Deserializer.class)
public enum SharedFolderMemberPolicy {
    // union SharedFolderMemberPolicy
    /**
     * Only a teammate can be a member of a folder shared by a team member.
     */
    TEAM,
    /**
     * Anyone can be a member of a folder shared by a team member.
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

    static final class Serializer extends UnionJsonSerializer<SharedFolderMemberPolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderMemberPolicy.class);
        }

        @Override
        public void serialize(SharedFolderMemberPolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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

    static final class Deserializer extends UnionJsonDeserializer<SharedFolderMemberPolicy, SharedFolderMemberPolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderMemberPolicy.class, getTagMapping(), SharedFolderMemberPolicy.OTHER);
        }

        @Override
        public SharedFolderMemberPolicy deserialize(SharedFolderMemberPolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedFolderMemberPolicy> getTagMapping() {
            Map<String, SharedFolderMemberPolicy> values = new HashMap<String, SharedFolderMemberPolicy>();
            values.put("team", SharedFolderMemberPolicy.TEAM);
            values.put("anyone", SharedFolderMemberPolicy.ANYONE);
            values.put("other", SharedFolderMemberPolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
