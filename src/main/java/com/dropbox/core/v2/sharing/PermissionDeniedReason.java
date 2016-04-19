/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
 * Possible reasons the user is denied a permission.
 */
@JsonSerialize(using=PermissionDeniedReason.Serializer.class)
@JsonDeserialize(using=PermissionDeniedReason.Deserializer.class)
public enum PermissionDeniedReason {
    // union PermissionDeniedReason
    /**
     * User is not on the same team as the folder owner.
     */
    USER_NOT_SAME_TEAM_AS_OWNER,
    /**
     * User is prohibited by the owner from taking the action.
     */
    USER_NOT_ALLOWED_BY_OWNER,
    /**
     * Target is indirectly a member of the folder, for example by being part of
     * a group.
     */
    TARGET_IS_INDIRECT_MEMBER,
    /**
     * Target is the owner of the folder.
     */
    TARGET_IS_OWNER,
    /**
     * Target is the user itself.
     */
    TARGET_IS_SELF,
    /**
     * Target is not an active member of the team.
     */
    TARGET_NOT_ACTIVE,
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

    static final class Serializer extends UnionJsonSerializer<PermissionDeniedReason> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PermissionDeniedReason.class);
        }

        @Override
        public void serialize(PermissionDeniedReason value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case USER_NOT_SAME_TEAM_AS_OWNER:
                    g.writeString("user_not_same_team_as_owner");
                    break;
                case USER_NOT_ALLOWED_BY_OWNER:
                    g.writeString("user_not_allowed_by_owner");
                    break;
                case TARGET_IS_INDIRECT_MEMBER:
                    g.writeString("target_is_indirect_member");
                    break;
                case TARGET_IS_OWNER:
                    g.writeString("target_is_owner");
                    break;
                case TARGET_IS_SELF:
                    g.writeString("target_is_self");
                    break;
                case TARGET_NOT_ACTIVE:
                    g.writeString("target_not_active");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PermissionDeniedReason, PermissionDeniedReason> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PermissionDeniedReason.class, getTagMapping(), PermissionDeniedReason.OTHER);
        }

        @Override
        public PermissionDeniedReason deserialize(PermissionDeniedReason _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, PermissionDeniedReason> getTagMapping() {
            Map<String, PermissionDeniedReason> values = new HashMap<String, PermissionDeniedReason>();
            values.put("user_not_same_team_as_owner", PermissionDeniedReason.USER_NOT_SAME_TEAM_AS_OWNER);
            values.put("user_not_allowed_by_owner", PermissionDeniedReason.USER_NOT_ALLOWED_BY_OWNER);
            values.put("target_is_indirect_member", PermissionDeniedReason.TARGET_IS_INDIRECT_MEMBER);
            values.put("target_is_owner", PermissionDeniedReason.TARGET_IS_OWNER);
            values.put("target_is_self", PermissionDeniedReason.TARGET_IS_SELF);
            values.put("target_not_active", PermissionDeniedReason.TARGET_NOT_ACTIVE);
            values.put("other", PermissionDeniedReason.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
