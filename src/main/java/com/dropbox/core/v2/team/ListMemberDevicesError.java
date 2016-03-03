/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

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

@JsonSerialize(using=ListMemberDevicesError.Serializer.class)
@JsonDeserialize(using=ListMemberDevicesError.Deserializer.class)
public enum ListMemberDevicesError {
    // union ListMemberDevicesError
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<ListMemberDevicesError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListMemberDevicesError.class);
        }

        @Override
        public void serialize(ListMemberDevicesError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case MEMBER_NOT_FOUND:
                    g.writeString("member_not_found");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ListMemberDevicesError, ListMemberDevicesError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListMemberDevicesError.class, getTagMapping(), ListMemberDevicesError.OTHER);
        }

        @Override
        public ListMemberDevicesError deserialize(ListMemberDevicesError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ListMemberDevicesError> getTagMapping() {
            Map<String, ListMemberDevicesError> values = new HashMap<String, ListMemberDevicesError>();
            values.put("member_not_found", ListMemberDevicesError.MEMBER_NOT_FOUND);
            values.put("other", ListMemberDevicesError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
