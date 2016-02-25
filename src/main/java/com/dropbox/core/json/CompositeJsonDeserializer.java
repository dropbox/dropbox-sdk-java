package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class CompositeJsonDeserializer<T> extends StdDeserializer<T>
    implements ResolvableDeserializer {
    private static final long serialVersionUID = 0L;

    private final Map<Class<?>, JsonDeserializer<Object>> _deserializers;


    protected CompositeJsonDeserializer(Class<T> clazz, Class<?> ... unwrappableClasses) {
        super(clazz);

        this._deserializers = new HashMap<Class<?>, JsonDeserializer<Object>>();

        for (Class<?> unwrappableClass : unwrappableClasses) {
            this._deserializers.put(unwrappableClass, null);
        }
    }

    @Override
    public void resolve(DeserializationContext ctx) {
        for (Class<?> clazz : new ArrayList<Class<?>>(_deserializers.keySet())) {
            _deserializers.put(clazz, getUnwrappingDeserializer(clazz, ctx));
        }
    }

    private JsonDeserializer<Object> getUnwrappingDeserializer(Class<?> clazz) {
        JsonDeserializer<Object> deserializer = _deserializers.get(clazz);
        if (deserializer == null) {
            throw new IllegalArgumentException("Unwrappable " + clazz + " not resolved.");
        }
        return deserializer;
    }

    protected <X> X readCollapsedStructValue(Class<X> structClass, JsonParser p, DeserializationContext ctx) throws IOException, JsonParseException {
        Object obj = getUnwrappingDeserializer(structClass).deserialize(p, ctx);
        if (obj == null) {
            return null;
        }

        if (structClass.isInstance(obj)) {
            return structClass.cast(obj);
        }

        throw new JsonParseException(
            p,
            "unexpected type deserialized, expected " + structClass + ", but was " + obj.getClass()
        );
    }

    protected static boolean hasTag(JsonParser parser) throws IOException, JsonParseException {
        return parser.getCurrentToken() == JsonToken.FIELD_NAME && ".tag".equals(parser.getCurrentName());
    }

    protected static String readTag(JsonParser parser) throws IOException, JsonParseException {
        if (!hasTag(parser)) {
            throw new JsonParseException(parser, "required tag field \".tag\" missing");
        }

        if (parser.nextToken() != JsonToken.VALUE_STRING) {
            throw new JsonParseException(parser, "expected a string value for .tag field");
        }

        String tag = parser.getText();
        parser.nextToken();

        return tag;
    }

    protected static String readEnumeratedSubtypeTag(JsonParser parser, String ... ancestors) throws IOException, JsonParseException {
        // nothing to do here, fall back to parsing whatever we can
        if (!hasTag(parser)) {
            return null;
        }

        String tag = readTag(parser);
        String [] parts = tag.split("\\.");

        if (parts.length < ancestors.length) {
            throw new JsonParseException(parser, "unexpected tag \"" + tag + "\"");
        }

        for (int i = 0; i < ancestors.length; ++i) {
            if (!parts[i].equals(ancestors[i])) {
                throw new JsonParseException(parser, "unexpected tag \"" + tag + "\"");
            }
        }

        if (parts.length == ancestors.length) {
            // this is the end of the ancestor, hiearchy. The caller must be the specific subtype
            // that must perform the deserialization.
            return null;
        } else {
            return parts[ancestors.length];
        }
    }

    protected static String getStringValue(JsonParser parser) throws IOException, JsonParseException {
        if (parser.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonParseException(parser, "expected string value.");
        }
        return parser.getText();
    }

    protected static void assertUnsigned(JsonParser parser, Number num) throws JsonParseException {
        if (num.longValue() < 0) {
            throw new JsonParseException(parser, "expected an unsigned number, got: " + num);
        }
    }

    protected static void expectField(JsonParser parser, String name) throws IOException, JsonParseException {
        if (parser.getCurrentToken() != JsonToken.FIELD_NAME) {
            throw new JsonParseException(parser, "expected field with name \"" + name + "\"");
        }
        parser.nextToken();
    }

    protected static void expectObjectStart(JsonParser parser) throws IOException, JsonParseException {
        if (!isObjectStart(parser)) {
            throw new JsonParseException(parser, "expecting the start of an object (\"{\")");
        }
        parser.nextToken();
    }

    protected static void expectObjectEnd(JsonParser parser) throws IOException, JsonParseException {
        if (!isObjectEnd(parser)) {
            throw new JsonParseException(parser, "expecting the end of an object (\"}\")");
        }
        // do not iterate to next token. convention is to leave cursor at end of parsed object.
    }

    protected static void expectArrayStart(JsonParser parser) throws IOException, JsonParseException {
        if (!isArrayStart(parser)) {
            throw new JsonParseException(parser, "expecting the start of an array (\"[\")");
        }
        parser.nextToken();
    }

    protected static void expectArrayEnd(JsonParser parser) throws IOException, JsonParseException {
        if (!isArrayEnd(parser)) {
            throw new JsonParseException(parser, "expecting the end of an array (\"[\")");
        }
        // do not iterate to next token. convention is to leave cursor at end of parsed object.
    }

    protected static boolean isArrayEnd(JsonParser parser) {
        return (parser.getCurrentToken() == JsonToken.END_ARRAY);
    }

    protected static boolean isArrayStart(JsonParser parser) {
        return (parser.getCurrentToken() == JsonToken.START_ARRAY);
    }

    protected static boolean isObjectEnd(JsonParser parser) {
        return (parser.getCurrentToken() == JsonToken.END_OBJECT);
    }

    protected static boolean isObjectStart(JsonParser parser) {
        return (parser.getCurrentToken() == JsonToken.START_OBJECT);
    }

    protected static void skipValue(JsonParser parser) throws IOException, JsonParseException {
        parser.skipChildren();
        parser.nextToken();
    }

    private static JsonDeserializer<Object> getUnwrappingDeserializer(Class<?> clazz, DeserializationContext ctx) {
        JsonDeserializer<Object> deserializer = null;
        try {
            deserializer = ctx.findRootValueDeserializer(ctx.constructType(clazz))
                .unwrappingDeserializer(NameTransformer.NOP);
        } catch (JsonMappingException ex) {
            throw new IllegalArgumentException("Unable to find deserializer for: " + clazz, ex);
        }

        return deserializer;
    }
}
