/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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

@JsonSerialize(using=MemberSelectorError.Serializer.class)
@JsonDeserialize(using=MemberSelectorError.Deserializer.class)
public enum MemberSelectorError {
    // union MemberSelectorError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MemberSelectorError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberSelectorError.class);
        }

        @Override
        public void serialize(MemberSelectorError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_FOUND:
                    g.writeString("user_not_found");
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeString("user_not_in_team");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MemberSelectorError, MemberSelectorError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberSelectorError.class, getTagMapping(), null);
        }

        @Override
        public MemberSelectorError deserialize(MemberSelectorError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MemberSelectorError> getTagMapping() {
            Map<String, MemberSelectorError> values = new HashMap<String, MemberSelectorError>();
            values.put("user_not_in_team", MemberSelectorError.USER_NOT_IN_TEAM);
            return Collections.unmodifiableMap(values);
        }
    }
}
