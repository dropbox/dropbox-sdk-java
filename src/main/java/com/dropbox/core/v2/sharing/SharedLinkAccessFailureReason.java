/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

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

@JsonSerialize(using=SharedLinkAccessFailureReason.Serializer.class)
@JsonDeserialize(using=SharedLinkAccessFailureReason.Deserializer.class)
public enum SharedLinkAccessFailureReason {
    // union SharedLinkAccessFailureReason
    /**
     * User is not logged in.
     */
    LOGIN_REQUIRED,
    /**
     * User's email is not verified.
     */
    EMAIL_VERIFY_REQUIRED,
    /**
     * The link is password protected.
     */
    PASSWORD_REQUIRED,
    /**
     * Access is allowed for team members only.
     */
    TEAM_ONLY,
    /**
     * Access is allowed for the shared link's owner only.
     */
    OWNER_ONLY,
    /**
     * An unknown accessibility failure.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<SharedLinkAccessFailureReason> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedLinkAccessFailureReason.class);
        }

        @Override
        public void serialize(SharedLinkAccessFailureReason value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case LOGIN_REQUIRED:
                    g.writeString("login_required");
                    break;
                case EMAIL_VERIFY_REQUIRED:
                    g.writeString("email_verify_required");
                    break;
                case PASSWORD_REQUIRED:
                    g.writeString("password_required");
                    break;
                case TEAM_ONLY:
                    g.writeString("team_only");
                    break;
                case OWNER_ONLY:
                    g.writeString("owner_only");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedLinkAccessFailureReason, SharedLinkAccessFailureReason> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedLinkAccessFailureReason.class, getTagMapping(), SharedLinkAccessFailureReason.OTHER);
        }

        @Override
        public SharedLinkAccessFailureReason deserialize(SharedLinkAccessFailureReason _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedLinkAccessFailureReason> getTagMapping() {
            Map<String, SharedLinkAccessFailureReason> values = new HashMap<String, SharedLinkAccessFailureReason>();
            values.put("login_required", SharedLinkAccessFailureReason.LOGIN_REQUIRED);
            values.put("email_verify_required", SharedLinkAccessFailureReason.EMAIL_VERIFY_REQUIRED);
            values.put("password_required", SharedLinkAccessFailureReason.PASSWORD_REQUIRED);
            values.put("team_only", SharedLinkAccessFailureReason.TEAM_ONLY);
            values.put("owner_only", SharedLinkAccessFailureReason.OWNER_ONLY);
            values.put("other", SharedLinkAccessFailureReason.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
