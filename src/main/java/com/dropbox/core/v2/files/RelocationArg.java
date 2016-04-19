/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=RelocationArg.Serializer.class)
@JsonDeserialize(using=RelocationArg.Deserializer.class)
class RelocationArg {
    // struct RelocationArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String fromPath;
    protected final String toPath;

    /**
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationArg(String fromPath, String toPath) {
        if (fromPath == null) {
            throw new IllegalArgumentException("Required value for 'fromPath' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", fromPath)) {
            throw new IllegalArgumentException("String 'fromPath' does not match pattern");
        }
        this.fromPath = fromPath;
        if (toPath == null) {
            throw new IllegalArgumentException("Required value for 'toPath' is null");
        }
        if (!java.util.regex.Pattern.matches("/.*", toPath)) {
            throw new IllegalArgumentException("String 'toPath' does not match pattern");
        }
        this.toPath = toPath;
    }

    /**
     * Path in the user's Dropbox to be copied or moved.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFromPath() {
        return fromPath;
    }

    /**
     * Path in the user's Dropbox that is the destination.
     *
     * @return value for this field, never {@code null}.
     */
    public String getToPath() {
        return toPath;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            fromPath,
            toPath
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            RelocationArg other = (RelocationArg) obj;
            return ((this.fromPath == other.fromPath) || (this.fromPath.equals(other.fromPath)))
                && ((this.toPath == other.toPath) || (this.toPath.equals(other.toPath)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<RelocationArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RelocationArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(RelocationArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<RelocationArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(RelocationArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("from_path", value.fromPath);
            g.writeObjectField("to_path", value.toPath);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<RelocationArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RelocationArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(RelocationArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<RelocationArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public RelocationArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String fromPath = null;
            String toPath = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("from_path".equals(_field)) {
                    fromPath = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("to_path".equals(_field)) {
                    toPath = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (fromPath == null) {
                throw new JsonParseException(_p, "Required field \"from_path\" is missing.");
            }
            if (toPath == null) {
                throw new JsonParseException(_p, "Required field \"to_path\" is missing.");
            }

            return new RelocationArg(fromPath, toPath);
        }
    }
}
