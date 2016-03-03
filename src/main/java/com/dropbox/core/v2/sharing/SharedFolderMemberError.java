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

@JsonSerialize(using=SharedFolderMemberError.Serializer.class)
@JsonDeserialize(using=SharedFolderMemberError.Deserializer.class)
public enum SharedFolderMemberError {
    // union SharedFolderMemberError
    /**
     * The target dropbox_id is invalid.
     */
    INVALID_DROPBOX_ID,
    /**
     * The target dropbox_id is not a member of the shared folder.
     */
    NOT_A_MEMBER,
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

    static final class Serializer extends UnionJsonSerializer<SharedFolderMemberError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderMemberError.class);
        }

        @Override
        public void serialize(SharedFolderMemberError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case INVALID_DROPBOX_ID:
                    g.writeString("invalid_dropbox_id");
                    break;
                case NOT_A_MEMBER:
                    g.writeString("not_a_member");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharedFolderMemberError, SharedFolderMemberError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderMemberError.class, getTagMapping(), SharedFolderMemberError.OTHER);
        }

        @Override
        public SharedFolderMemberError deserialize(SharedFolderMemberError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharedFolderMemberError> getTagMapping() {
            Map<String, SharedFolderMemberError> values = new HashMap<String, SharedFolderMemberError>();
            values.put("invalid_dropbox_id", SharedFolderMemberError.INVALID_DROPBOX_ID);
            values.put("not_a_member", SharedFolderMemberError.NOT_A_MEMBER);
            values.put("other", SharedFolderMemberError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
