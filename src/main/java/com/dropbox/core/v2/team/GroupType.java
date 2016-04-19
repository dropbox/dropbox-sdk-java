/* DO NOT EDIT */
/* This file was generated from team_common.babel */

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
 * The group type determines how a group is created and managed.
 */
@JsonSerialize(using=GroupType.Serializer.class)
@JsonDeserialize(using=GroupType.Deserializer.class)
public enum GroupType {
    // union GroupType
    /**
     * A group to which team members are automatically added. Applicable to <a
     * href="https://www.dropbox.com/help/986">team folders</a> only.
     */
    TEAM,
    /**
     * A group is created and managed by a user.
     */
    USER_MANAGED,
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

    static final class Serializer extends UnionJsonSerializer<GroupType> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupType.class);
        }

        @Override
        public void serialize(GroupType value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case TEAM:
                    g.writeString("team");
                    break;
                case USER_MANAGED:
                    g.writeString("user_managed");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<GroupType, GroupType> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupType.class, getTagMapping(), GroupType.OTHER);
        }

        @Override
        public GroupType deserialize(GroupType _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, GroupType> getTagMapping() {
            Map<String, GroupType> values = new HashMap<String, GroupType>();
            values.put("team", GroupType.TEAM);
            values.put("user_managed", GroupType.USER_MANAGED);
            values.put("other", GroupType.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
