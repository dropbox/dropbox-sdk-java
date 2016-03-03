package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public abstract class StructJsonDeserializer<T> extends CompositeJsonDeserializer<T> {
    private static final long serialVersionUID = 0L;

    private final boolean unwrapping;

    protected StructJsonDeserializer(Class<T> clazz, Class<?> ... subtypeClasses) {
        this(clazz, false, subtypeClasses);
    }

    protected StructJsonDeserializer(Class<T> clazz, boolean unwrapping, Class<?> ... subtypeClasses) {
        super(clazz, subtypeClasses);

        this.unwrapping = unwrapping;
    }

    @Override
    public JsonDeserializer<T> unwrappingDeserializer(NameTransformer unwrapper) {
        return asUnwrapping();
    }

    /**
     * Override this method to support generating unwrapped JSON
     * (e.g. JSON not wrapped in object brackets, {}).
     */
    protected JsonDeserializer<T> asUnwrapping() {
        throw new IllegalStateException(getClass().toString() + " does not support unwrapping.");
    }

    @Override
    public final T deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonParseException {
        if (!unwrapping) {
            expectObjectStart(p);
        }

        T instance = deserializeFields(p, ctx);

        if (!unwrapping) {
            expectObjectEnd(p);
        }

        return instance;
    }

    protected abstract T deserializeFields(JsonParser p, DeserializationContext ctx) throws IOException, JsonParseException;
}
