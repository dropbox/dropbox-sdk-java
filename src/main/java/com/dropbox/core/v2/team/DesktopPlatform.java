/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

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

@JsonSerialize(using=DesktopPlatform.Serializer.class)
@JsonDeserialize(using=DesktopPlatform.Deserializer.class)
public enum DesktopPlatform {
    // union DesktopPlatform
    /**
     * Official Windows Dropbox desktop client
     */
    WINDOWS,
    /**
     * Official Mac Dropbox desktop client
     */
    MAC,
    /**
     * Official Linux Dropbox desktop client
     */
    LINUX,
    /**
     * Official Dropbox desktop client for another platform
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<DesktopPlatform> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DesktopPlatform.class);
        }

        @Override
        public void serialize(DesktopPlatform value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case WINDOWS:
                    g.writeString("windows");
                    break;
                case MAC:
                    g.writeString("mac");
                    break;
                case LINUX:
                    g.writeString("linux");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<DesktopPlatform, DesktopPlatform> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DesktopPlatform.class, getTagMapping(), DesktopPlatform.OTHER);
        }

        @Override
        public DesktopPlatform deserialize(DesktopPlatform _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, DesktopPlatform> getTagMapping() {
            Map<String, DesktopPlatform> values = new HashMap<String, DesktopPlatform>();
            values.put("windows", DesktopPlatform.WINDOWS);
            values.put("mac", DesktopPlatform.MAC);
            values.put("linux", DesktopPlatform.LINUX);
            values.put("other", DesktopPlatform.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
