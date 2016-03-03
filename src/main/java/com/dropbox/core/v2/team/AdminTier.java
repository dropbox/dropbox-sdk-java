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

/**
 * Describes which team-related admin permissions a user has.
 */
@JsonSerialize(using=AdminTier.Serializer.class)
@JsonDeserialize(using=AdminTier.Deserializer.class)
public enum AdminTier {
    // union AdminTier
    /**
     * User is an administrator of the team - has all permissions.
     */
    TEAM_ADMIN,
    /**
     * User can do most user provisioning, de-provisioning and management.
     */
    USER_MANAGEMENT_ADMIN,
    /**
     * User can do a limited set of common support tasks for existing users.
     */
    SUPPORT_ADMIN,
    /**
     * User is not an admin of the team.
     */
    MEMBER_ONLY;

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<AdminTier> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AdminTier.class);
        }

        @Override
        public void serialize(AdminTier value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case TEAM_ADMIN:
                    g.writeString("team_admin");
                    break;
                case USER_MANAGEMENT_ADMIN:
                    g.writeString("user_management_admin");
                    break;
                case SUPPORT_ADMIN:
                    g.writeString("support_admin");
                    break;
                case MEMBER_ONLY:
                    g.writeString("member_only");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AdminTier, AdminTier> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AdminTier.class, getTagMapping(), null);
        }

        @Override
        public AdminTier deserialize(AdminTier _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, AdminTier> getTagMapping() {
            Map<String, AdminTier> values = new HashMap<String, AdminTier>();
            values.put("team_admin", AdminTier.TEAM_ADMIN);
            values.put("user_management_admin", AdminTier.USER_MANAGEMENT_ADMIN);
            values.put("support_admin", AdminTier.SUPPORT_ADMIN);
            values.put("member_only", AdminTier.MEMBER_ONLY);
            return Collections.unmodifiableMap(values);
        }
    }
}
