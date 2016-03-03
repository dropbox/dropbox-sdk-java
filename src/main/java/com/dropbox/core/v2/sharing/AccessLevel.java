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
 * Defines the access levels for collaborators.
 */
@JsonSerialize(using=AccessLevel.Serializer.class)
@JsonDeserialize(using=AccessLevel.Deserializer.class)
public enum AccessLevel {
    // union AccessLevel
    /**
     * The collaborator is the owner of the shared folder. Owners can view and
     * edit the shared folder as well as set the folder's policies using {@link
     * DbxUserSharingRequests#updateFolderPolicy(String)}.
     */
    OWNER,
    /**
     * The collaborator can both view and edit the shared folder.
     */
    EDITOR,
    /**
     * The collaborator can only view the shared folder.
     */
    VIEWER,
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

    static final class Serializer extends UnionJsonSerializer<AccessLevel> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AccessLevel.class);
        }

        @Override
        public void serialize(AccessLevel value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case OWNER:
                    g.writeString("owner");
                    break;
                case EDITOR:
                    g.writeString("editor");
                    break;
                case VIEWER:
                    g.writeString("viewer");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<AccessLevel, AccessLevel> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AccessLevel.class, getTagMapping(), AccessLevel.OTHER);
        }

        @Override
        public AccessLevel deserialize(AccessLevel _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, AccessLevel> getTagMapping() {
            Map<String, AccessLevel> values = new HashMap<String, AccessLevel>();
            values.put("owner", AccessLevel.OWNER);
            values.put("editor", AccessLevel.EDITOR);
            values.put("viewer", AccessLevel.VIEWER);
            values.put("other", AccessLevel.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
