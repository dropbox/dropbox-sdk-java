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

@JsonSerialize(using=SharePathError.Serializer.class)
@JsonDeserialize(using=SharePathError.Deserializer.class)
public enum SharePathError {
    // union SharePathError
    /**
     * A file is at the specified path.
     */
    IS_FILE,
    /**
     * We do not support sharing a folder inside a shared folder.
     */
    INSIDE_SHARED_FOLDER,
    /**
     * We do not support shared folders that contain shared folders.
     */
    CONTAINS_SHARED_FOLDER,
    /**
     * We do not support sharing an app folder.
     */
    IS_APP_FOLDER,
    /**
     * We do not support sharing a folder inside an app folder.
     */
    INSIDE_APP_FOLDER,
    /**
     * Folder is already shared.
     */
    ALREADY_SHARED,
    /**
     * Path is not valid.
     */
    INVALID_PATH,
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

    static final class Serializer extends UnionJsonSerializer<SharePathError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharePathError.class);
        }

        @Override
        public void serialize(SharePathError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case IS_FILE:
                    g.writeString("is_file");
                    break;
                case INSIDE_SHARED_FOLDER:
                    g.writeString("inside_shared_folder");
                    break;
                case CONTAINS_SHARED_FOLDER:
                    g.writeString("contains_shared_folder");
                    break;
                case IS_APP_FOLDER:
                    g.writeString("is_app_folder");
                    break;
                case INSIDE_APP_FOLDER:
                    g.writeString("inside_app_folder");
                    break;
                case ALREADY_SHARED:
                    g.writeString("already_shared");
                    break;
                case INVALID_PATH:
                    g.writeString("invalid_path");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SharePathError, SharePathError> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharePathError.class, getTagMapping(), SharePathError.OTHER);
        }

        @Override
        public SharePathError deserialize(SharePathError _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, SharePathError> getTagMapping() {
            Map<String, SharePathError> values = new HashMap<String, SharePathError>();
            values.put("is_file", SharePathError.IS_FILE);
            values.put("inside_shared_folder", SharePathError.INSIDE_SHARED_FOLDER);
            values.put("contains_shared_folder", SharePathError.CONTAINS_SHARED_FOLDER);
            values.put("is_app_folder", SharePathError.IS_APP_FOLDER);
            values.put("inside_app_folder", SharePathError.INSIDE_APP_FOLDER);
            values.put("already_shared", SharePathError.ALREADY_SHARED);
            values.put("invalid_path", SharePathError.INVALID_PATH);
            values.put("other", SharePathError.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
