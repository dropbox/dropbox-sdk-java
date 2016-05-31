package com.dropbox.core.stone;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public abstract class StructSerializer<T> extends CompositeSerializer<T> {

    @Override
    public void serialize(T value, JsonGenerator g) throws IOException, JsonGenerationException {
        serialize(value, g, false);
    }

    public abstract void serialize(T value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException;

    @Override
    public T deserialize(JsonParser p) throws IOException, JsonParseException {
        return deserialize(p, false);
    }

    public abstract T deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException;
}
