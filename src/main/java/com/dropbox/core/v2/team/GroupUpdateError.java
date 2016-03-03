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

@JsonSerialize(using=GroupUpdateError.Serializer.class)
@JsonDeserialize(using=GroupUpdateError.Deserializer.class)
public enum GroupUpdateError {
    // union GroupUpdateError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The new external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<GroupUpdateError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupUpdateError.class);
        }

        @Override
        public void serialize(GroupUpdateError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NOT_FOUND:
                    g.writeString("group_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
                case EXTERNAL_ID_ALREADY_IN_USE:
                    g.writeString("external_id_already_in_use");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupUpdateError, GroupUpdateError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupUpdateError.class, getTagMapping(), null);
        }

        @Override
        public GroupUpdateError deserialize(GroupUpdateError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupUpdateError> getTagMapping() {
            Map<String, GroupUpdateError> values = new HashMap<String, GroupUpdateError>();
            values.put("external_id_already_in_use", GroupUpdateError.EXTERNAL_ID_ALREADY_IN_USE);
            return Collections.unmodifiableMap(values);
        }
    }
}
