package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public abstract class StructJsonSerializer<T> extends StdSerializer<T> {
    private static final long serialVersionUID = 0L;

    private final boolean unwrapping;

    protected StructJsonSerializer(Class<T> clazz) {
        this(clazz, false);
    }

    protected StructJsonSerializer(Class<T> clazz, boolean unwrapping) {
        super(clazz);

        this.unwrapping = unwrapping;
    }

    @Override
    public boolean isUnwrappingSerializer() {
        return unwrapping;
    }

    @Override
    public JsonSerializer<T> unwrappingSerializer(NameTransformer unwrapper) {
        return asUnwrapping();
    }

    /**
     * Override this method to support generating unwrapped JSON
     * (e.g. JSON not wrapped in object brackets, {}).
     */
    protected JsonSerializer<T> asUnwrapping() {
        throw new IllegalStateException(getClass().toString() + " does not support unwrapping.");
    }

    @Override
    public final void serialize(T value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
        if (!unwrapping) {
            g.writeStartObject();
        }

        serializeFields(value, g, provider);

        if (!unwrapping) {
            g.writeEndObject();
        }
    }

    protected abstract void serializeFields(T value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException;
}
