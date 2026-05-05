package com.dropbox.core.stone;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class StructSerializer<T> extends CompositeSerializer<T> {

    @Override
    public void serialize(@Nullable T value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
        serialize(value, g, false);
    }

    public abstract void serialize(@Nullable T value, @Nonnull JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException;

    @Override
    public @Nullable T deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
        return deserialize(p, false);
    }

    public abstract @Nullable T deserialize(@Nonnull JsonParser p, boolean collapsed) throws IOException, JsonParseException;
}
