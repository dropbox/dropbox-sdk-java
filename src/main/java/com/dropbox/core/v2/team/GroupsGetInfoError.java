/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=GroupsGetInfoError.Serializer.class)
@JsonDeserialize(using=GroupsGetInfoError.Deserializer.class)
public enum GroupsGetInfoError {
    // union GroupsGetInfoError
    /**
     * The group is not on your team.
     */
    GROUP_NOT_ON_TEAM,
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

    static final class Serializer extends UnionJsonSerializer<GroupsGetInfoError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsGetInfoError.class);
        }

        @Override
        public void serialize(GroupsGetInfoError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NOT_ON_TEAM:
                    g.writeString("group_not_on_team");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupsGetInfoError, GroupsGetInfoError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsGetInfoError.class, getTagMapping(), GroupsGetInfoError.OTHER);
        }

        @Override
        public GroupsGetInfoError deserialize(GroupsGetInfoError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupsGetInfoError> getTagMapping() {
            Map<String, GroupsGetInfoError> values = new HashMap<String, GroupsGetInfoError>();
            values.put("group_not_on_team", GroupsGetInfoError.GROUP_NOT_ON_TEAM);
            values.put("other", GroupsGetInfoError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
