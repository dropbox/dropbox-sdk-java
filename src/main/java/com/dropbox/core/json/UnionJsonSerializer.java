package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class UnionJsonSerializer<T> extends StdSerializer<T> implements ResolvableSerializer {
    private static final long serialVersionUID = 0L;

    private final Map<Class<?>, JsonSerializer<Object>> _serializers;

    protected UnionJsonSerializer(Class<T> clazz, Class<?> ... unwrappableFieldClasses) {
        super(clazz);
        this._serializers = new HashMap<Class<?>, JsonSerializer<Object>>();

        for (Class<?> fieldClass : unwrappableFieldClasses) {
            _serializers.put(fieldClass, null);
        }
    }

    @Override
    public void resolve(SerializerProvider provider) {
        for (Class<?> clazz : new ArrayList<Class<?>>(_serializers.keySet())) {
            _serializers.put(clazz, getUnwrappingSerializer(clazz, provider));
        }
    }

    protected JsonSerializer<Object> getUnwrappingSerializer(Class<?> fieldClass) {
        JsonSerializer<Object> serializer = _serializers.get(fieldClass);
        if (serializer == null) {
            throw new IllegalArgumentException("Field class " + fieldClass + " not resolved.");
        }
        return serializer;
    }

    @Override
    public abstract void serialize(T value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException;

    private static JsonSerializer<Object> getUnwrappingSerializer(Class<?> clazz, SerializerProvider provider) {
        JsonSerializer<Object> serializer = null;
        try {
            serializer = provider.findValueSerializer(clazz)
                .unwrappingSerializer(NameTransformer.NOP);
        } catch (JsonMappingException ex) {
            throw new IllegalArgumentException("Unable to find serializer for: " + clazz, ex);
        }

        if (!serializer.isUnwrappingSerializer()) {
            throw new IllegalArgumentException("Serializer for " + clazz + " does not support unwrapping.");
        }

        return serializer;
    }
}
