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

@JsonSerialize(using=GroupCreateError.Serializer.class)
@JsonDeserialize(using=GroupCreateError.Deserializer.class)
public enum GroupCreateError {
    // union GroupCreateError
    /**
     * There is already an existing group with the requested name.
     */
    GROUP_NAME_ALREADY_USED,
    /**
     * Group name is empty or has invalid characters.
     */
    GROUP_NAME_INVALID,
    /**
     * The new external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE,
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

    static final class Serializer extends UnionJsonSerializer<GroupCreateError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupCreateError.class);
        }

        @Override
        public void serialize(GroupCreateError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NAME_ALREADY_USED:
                    g.writeString("group_name_already_used");
                    break;
                case GROUP_NAME_INVALID:
                    g.writeString("group_name_invalid");
                    break;
                case EXTERNAL_ID_ALREADY_IN_USE:
                    g.writeString("external_id_already_in_use");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupCreateError, GroupCreateError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupCreateError.class, getTagMapping(), GroupCreateError.OTHER);
        }

        @Override
        public GroupCreateError deserialize(GroupCreateError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupCreateError> getTagMapping() {
            Map<String, GroupCreateError> values = new HashMap<String, GroupCreateError>();
            values.put("group_name_already_used", GroupCreateError.GROUP_NAME_ALREADY_USED);
            values.put("group_name_invalid", GroupCreateError.GROUP_NAME_INVALID);
            values.put("external_id_already_in_use", GroupCreateError.EXTERNAL_ID_ALREADY_IN_USE);
            values.put("other", GroupCreateError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
