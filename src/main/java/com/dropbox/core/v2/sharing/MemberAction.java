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
 * Actions that may be taken on members of a shared folder.
 */
@JsonSerialize(using=MemberAction.Serializer.class)
@JsonDeserialize(using=MemberAction.Deserializer.class)
public enum MemberAction {
    // union MemberAction
    /**
     * Make the member an editor of the folder.
     */
    MAKE_EDITOR,
    /**
     * Make the member an owner of the folder.
     */
    MAKE_OWNER,
    /**
     * Make the member a viewer of the folder.
     */
    MAKE_VIEWER,
    /**
     * Remove the member from the folder.
     */
    REMOVE,
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

    static final class Serializer extends UnionJsonSerializer<MemberAction> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberAction.class);
        }

        @Override
        public void serialize(MemberAction value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value) {
                case MAKE_EDITOR:
                    g.writeString("make_editor");
                    break;
                case MAKE_OWNER:
                    g.writeString("make_owner");
                    break;
                case MAKE_VIEWER:
                    g.writeString("make_viewer");
                    break;
                case REMOVE:
                    g.writeString("remove");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<MemberAction, MemberAction> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberAction.class, getTagMapping(), MemberAction.OTHER);
        }

        @Override
        public MemberAction deserialize(MemberAction _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            return _tag;
        }

        private static Map<String, MemberAction> getTagMapping() {
            Map<String, MemberAction> values = new HashMap<String, MemberAction>();
            values.put("make_editor", MemberAction.MAKE_EDITOR);
            values.put("make_owner", MemberAction.MAKE_OWNER);
            values.put("make_viewer", MemberAction.MAKE_VIEWER);
            values.put("remove", MemberAction.REMOVE);
            values.put("other", MemberAction.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
