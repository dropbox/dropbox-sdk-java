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
 * The user's status as a member of a specific team.
 */
@JsonSerialize(using=TeamMemberStatus.Serializer.class)
@JsonDeserialize(using=TeamMemberStatus.Deserializer.class)
public enum TeamMemberStatus {
    // union TeamMemberStatus
    /**
     * User has successfully joined the team.
     */
    ACTIVE,
    /**
     * User has been invited to a team, but has not joined the team yet.
     */
    INVITED,
    /**
     * User is no longer a member of the team, but the account can be
     * un-suspended, re-establishing the user as a team member.
     */
    SUSPENDED;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<TeamMemberStatus> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TeamMemberStatus.class);
        }

        @Override
        public void serialize(TeamMemberStatus value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case ACTIVE:
                    g.writeString("active");
                    break;
                case INVITED:
                    g.writeString("invited");
                    break;
                case SUSPENDED:
                    g.writeString("suspended");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<TeamMemberStatus, TeamMemberStatus> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TeamMemberStatus.class, getTagMapping(), null);
        }

        @Override
        public TeamMemberStatus deserialize(TeamMemberStatus _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, TeamMemberStatus> getTagMapping() {
            Map<String, TeamMemberStatus> values = new HashMap<String, TeamMemberStatus>();
            values.put("active", TeamMemberStatus.ACTIVE);
            values.put("invited", TeamMemberStatus.INVITED);
            values.put("suspended", TeamMemberStatus.SUSPENDED);
            return Collections.unmodifiableMap(values);
        }
    }
}
