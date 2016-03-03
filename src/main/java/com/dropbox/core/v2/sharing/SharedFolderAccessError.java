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
 * There is an error accessing the shared folder.
 */
@JsonSerialize(using=SharedFolderAccessError.Serializer.class)
@JsonDeserialize(using=SharedFolderAccessError.Deserializer.class)
public enum SharedFolderAccessError {
    // union SharedFolderAccessError
    /**
     * This shared folder ID is invalid.
     */
    INVALID_ID,
    /**
     * The user is not a member of the shared folder thus cannot access it.
     */
    NOT_A_MEMBER,
    /**
     * The current user's e-mail address is unverified.
     */
    EMAIL_UNVERIFIED,
    /**
     * The shared folder is unmounted.
     */
    UNMOUNTED,
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

    static final class Serializer extends UnionJsonSerializer<SharedFolderAccessError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderAccessError.class);
        }

        @Override
        public void serialize(SharedFolderAccessError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_ID:
                    g.writeString("invalid_id");
                    break;
                case NOT_A_MEMBER:
                    g.writeString("not_a_member");
                    break;
                case EMAIL_UNVERIFIED:
                    g.writeString("email_unverified");
                    break;
                case UNMOUNTED:
                    g.writeString("unmounted");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedFolderAccessError, SharedFolderAccessError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderAccessError.class, getTagMapping(), SharedFolderAccessError.OTHER);
        }

        @Override
        public SharedFolderAccessError deserialize(SharedFolderAccessError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedFolderAccessError> getTagMapping() {
            Map<String, SharedFolderAccessError> values = new HashMap<String, SharedFolderAccessError>();
            values.put("invalid_id", SharedFolderAccessError.INVALID_ID);
            values.put("not_a_member", SharedFolderAccessError.NOT_A_MEMBER);
            values.put("email_unverified", SharedFolderAccessError.EMAIL_UNVERIFIED);
            values.put("unmounted", SharedFolderAccessError.UNMOUNTED);
            values.put("other", SharedFolderAccessError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
