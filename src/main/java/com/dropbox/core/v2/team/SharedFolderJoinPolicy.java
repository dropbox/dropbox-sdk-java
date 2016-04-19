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
 * Policy governing which shared folders a team member can join.
 */
@JsonSerialize(using=SharedFolderJoinPolicy.Serializer.class)
@JsonDeserialize(using=SharedFolderJoinPolicy.Deserializer.class)
public enum SharedFolderJoinPolicy {
    // union SharedFolderJoinPolicy
    /**
     * Team members can only join folders shared by teammates.
     */
    FROM_TEAM_ONLY,
    /**
     * Team members can join any shared folder, including those shared by users
     * outside the team.
     */
    FROM_ANYONE,
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

    static final class Serializer extends UnionJsonSerializer<SharedFolderJoinPolicy> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderJoinPolicy.class);
        }

        @Override
        public void serialize(SharedFolderJoinPolicy value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case FROM_TEAM_ONLY:
                    g.writeString("from_team_only");
                    break;
                case FROM_ANYONE:
                    g.writeString("from_anyone");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedFolderJoinPolicy, SharedFolderJoinPolicy> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderJoinPolicy.class, getTagMapping(), SharedFolderJoinPolicy.OTHER);
        }

        @Override
        public SharedFolderJoinPolicy deserialize(SharedFolderJoinPolicy _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedFolderJoinPolicy> getTagMapping() {
            Map<String, SharedFolderJoinPolicy> values = new HashMap<String, SharedFolderJoinPolicy>();
            values.put("from_team_only", SharedFolderJoinPolicy.FROM_TEAM_ONLY);
            values.put("from_anyone", SharedFolderJoinPolicy.FROM_ANYONE);
            values.put("other", SharedFolderJoinPolicy.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
