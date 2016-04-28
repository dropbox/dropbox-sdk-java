/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

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
 * Error returned by {@link
 * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()}
 */
@JsonSerialize(using=ListMembersAppsError.Serializer.class)
@JsonDeserialize(using=ListMembersAppsError.Deserializer.class)
public enum ListMembersAppsError {
    // union ListMembersAppsError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()} again with an
     * empty cursor to obtain a new cursor.
     */
    RESET,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<ListMembersAppsError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListMembersAppsError.class);
        }

        @Override
        public void serialize(ListMembersAppsError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case RESET:
                    g.writeString("reset");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ListMembersAppsError, ListMembersAppsError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListMembersAppsError.class, getTagMapping(), ListMembersAppsError.OTHER);
        }

        @Override
        public ListMembersAppsError deserialize(ListMembersAppsError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, ListMembersAppsError> getTagMapping() {
            Map<String, ListMembersAppsError> values = new HashMap<String, ListMembersAppsError>();
            values.put("reset", ListMembersAppsError.RESET);
            values.put("other", ListMembersAppsError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
