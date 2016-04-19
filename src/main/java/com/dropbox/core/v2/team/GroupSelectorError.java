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

/**
 * Error that can be raised when {@link GroupSelector}is used.
 */
@JsonSerialize(using=GroupSelectorError.Serializer.class)
@JsonDeserialize(using=GroupSelectorError.Deserializer.class)
public enum GroupSelectorError {
    // union GroupSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
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

    static final class Serializer extends UnionJsonSerializer<GroupSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupSelectorError.class);
        }

        @Override
        public void serialize(GroupSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case GROUP_NOT_FOUND:
                    g.writeString("group_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupSelectorError, GroupSelectorError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupSelectorError.class, getTagMapping(), GroupSelectorError.OTHER);
        }

        @Override
        public GroupSelectorError deserialize(GroupSelectorError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupSelectorError> getTagMapping() {
            Map<String, GroupSelectorError> values = new HashMap<String, GroupSelectorError>();
            values.put("group_not_found", GroupSelectorError.GROUP_NOT_FOUND);
            values.put("other", GroupSelectorError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
