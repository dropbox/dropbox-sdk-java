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

@JsonSerialize(using=MobileClientPlatform.Serializer.class)
@JsonDeserialize(using=MobileClientPlatform.Deserializer.class)
public enum MobileClientPlatform {
    // union MobileClientPlatform
    /**
     * Official Dropbox iPhone client
     */
    IPHONE,
    /**
     * Official Dropbox iPad client
     */
    IPAD,
    /**
     * Official Dropbox Android client
     */
    ANDROID,
    /**
     * Official Dropbox Windows phone client
     */
    WINDOWS_PHONE,
    /**
     * Official Dropbox Blackberry client
     */
    BLACKBERRY,
    /**
     * Official Dropbox client for another platform
     */
    OTHER; // *catch_all

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    static final class Serializer extends UnionJsonSerializer<MobileClientPlatform> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MobileClientPlatform.class);
        }

        @Override
        public void serialize(MobileClientPlatform value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case IPHONE:
                    g.writeString("iphone");
                    break;
                case IPAD:
                    g.writeString("ipad");
                    break;
                case ANDROID:
                    g.writeString("android");
                    break;
                case WINDOWS_PHONE:
                    g.writeString("windows_phone");
                    break;
                case BLACKBERRY:
                    g.writeString("blackberry");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MobileClientPlatform, MobileClientPlatform> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MobileClientPlatform.class, getTagMapping(), MobileClientPlatform.OTHER);
        }

        @Override
        public MobileClientPlatform deserialize(MobileClientPlatform _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MobileClientPlatform> getTagMapping() {
            Map<String, MobileClientPlatform> values = new HashMap<String, MobileClientPlatform>();
            values.put("iphone", MobileClientPlatform.IPHONE);
            values.put("ipad", MobileClientPlatform.IPAD);
            values.put("android", MobileClientPlatform.ANDROID);
            values.put("windows_phone", MobileClientPlatform.WINDOWS_PHONE);
            values.put("blackberry", MobileClientPlatform.BLACKBERRY);
            values.put("other", MobileClientPlatform.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
