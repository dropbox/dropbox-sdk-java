package com.dropbox.core.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class UnionJsonDeserializer<V,T extends Enum<T>> extends CompositeJsonDeserializer<V> {
    private static final long serialVersionUID = 0L;

    private final Map<String, T> _tagMapping;
    private final T _catchAll;

    protected UnionJsonDeserializer(Class<V> clazz,
                                    Map<String, T> tagMapping,
                                    T catchAll,
                                    Class<?> ... unwrappableFieldClasses
    ) {
        super(clazz, unwrappableFieldClasses);

        if (tagMapping == null) {
            throw new NullPointerException("tagMapping");
        }

        this._tagMapping = Collections.unmodifiableMap(new HashMap<String, T>(tagMapping));
        this._catchAll = catchAll;
    }

    protected abstract V deserialize(T tag, JsonParser p, DeserializationContext ctx) throws IOException, JsonParseException;

    @Override
    public V deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonParseException {
        V value;
        if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
            T tag = parseTag(p, p.getText());
            value = deserialize(tag, p, ctx);
        } else {
            expectObjectStart(p);
            T tag = parseTag(p, readTag(p));
            value = deserialize(tag, p, ctx);
            expectObjectEnd(p);
        }
        return value;
    }

    private T parseTag(JsonParser p, String value) throws IOException, JsonParseException {
        T tag = _tagMapping.get(value);

        if (tag == null) {
            if (_catchAll == null) {
                throw new JsonParseException(p, "Unanticipated tag " + value + " without catch-all");
            } else {
                tag = _catchAll;
            }
        }

        return tag;
    }
}
