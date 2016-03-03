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

/**
 * Who can access a shared link. The most open visibility is {@link
 * Visibility#PUBLIC}. The default depends on many aspects, such as team and
 * user preferences and shared folder settings.
 */
@JsonSerialize(using=Visibility.Serializer.class)
@JsonDeserialize(using=Visibility.Deserializer.class)
public enum Visibility {
    // union Visibility
    /**
     * Anyone who has received the link can access it. No login required.
     */
    PUBLIC,
    /**
     * Only members of the same team can access the link. Login is required.
     */
    TEAM_ONLY,
    /**
     * A link-specific password is required to access the link. Login is not
     * required.
     */
    PASSWORD,
    /**
     * Only members of the same team who have the link-specific password can
     * access the link.
     */
    TEAM_AND_PASSWORD,
    /**
     * Only members of the shared folder containing the linked file can access
     * the link. Login is required.
     */
    SHARED_FOLDER_ONLY,
    /**
     * An unknown restriction is in place.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<Visibility> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Visibility.class);
        }

        @Override
        public void serialize(Visibility value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case PUBLIC:
                    g.writeString("public");
                    break;
                case TEAM_ONLY:
                    g.writeString("team_only");
                    break;
                case PASSWORD:
                    g.writeString("password");
                    break;
                case TEAM_AND_PASSWORD:
                    g.writeString("team_and_password");
                    break;
                case SHARED_FOLDER_ONLY:
                    g.writeString("shared_folder_only");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<Visibility, Visibility> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Visibility.class, getTagMapping(), Visibility.OTHER);
        }

        @Override
        public Visibility deserialize(Visibility _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, Visibility> getTagMapping() {
            Map<String, Visibility> values = new HashMap<String, Visibility>();
            values.put("public", Visibility.PUBLIC);
            values.put("team_only", Visibility.TEAM_ONLY);
            values.put("password", Visibility.PASSWORD);
            values.put("team_and_password", Visibility.TEAM_AND_PASSWORD);
            values.put("shared_folder_only", Visibility.SHARED_FOLDER_ONLY);
            values.put("other", Visibility.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
