package com.dropbox.core.stone;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class StoneSerializers {

    public static @Nonnull StoneSerializer<Long> uInt64() {
        return LongSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Long> int64() {
        return LongSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Long> uInt32() {
        return LongSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Integer> int32() {
        return IntSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Double> float64() {
        return DoubleSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Float> float32() {
        return FloatSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Boolean> boolean_() {
        return BooleanSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<byte []> bytes() {
        return ByteArraySerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<String> string() {
        return StringSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Date> timestamp() {
        return DateSerializer.INSTANCE;
    }

    public static @Nonnull StoneSerializer<Void> void_() {
        return VoidSerializer.INSTANCE;
    }

    public static <T> @Nonnull StoneSerializer<T> nullable(@Nonnull StoneSerializer<T> underlying) {
        return new NullableSerializer<T>(underlying);
    }

    public static <T> @Nonnull StructSerializer<T> nullableStruct(@Nonnull StructSerializer<T> underlying) {
        return new NullableStructSerializer<T>(underlying);
    }

    public static <T> @Nonnull StoneSerializer<List<T>> list(@Nonnull StoneSerializer<T> underlying) {
        return new ListSerializer<T>(underlying);
    }

    public static <T> @Nonnull StoneSerializer<Map<String, T>> map(@Nonnull StoneSerializer<T> underlying) {
        return new MapSerializer<T>(underlying);
    }

    private static final class LongSerializer extends StoneSerializer<Long> {
        public static final @Nonnull LongSerializer INSTANCE = new LongSerializer();

        @Override
        public void serialize(@Nullable Long value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeNumber(value);
        }

        @Override
        public @Nonnull Long deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Long value = p.getLongValue();
            p.nextToken();
            return value;
        }
    }

    private static final class IntSerializer extends StoneSerializer<Integer> {
        public static final @Nonnull IntSerializer INSTANCE = new IntSerializer();

        @Override
        public void serialize(@Nullable Integer value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeNumber(value);
        }

        @Override
        public @Nonnull Integer deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Integer value = p.getIntValue();
            p.nextToken();
            return value;
        }
    }

    private static final class DoubleSerializer extends StoneSerializer<Double> {
        public static final @Nonnull DoubleSerializer INSTANCE = new DoubleSerializer();

        @Override
        public void serialize(@Nullable Double value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeNumber(value);
        }

        @Override
        public @Nonnull Double deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Double value = p.getDoubleValue();
            p.nextToken();
            return value;
        }
    }

    private static final class FloatSerializer extends StoneSerializer<Float> {
        public static final @Nonnull FloatSerializer INSTANCE = new FloatSerializer();

        @Override
        public void serialize(@Nullable Float value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeNumber(value);
        }

        @Override
        public @Nonnull Float deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Float value = p.getFloatValue();
            p.nextToken();
            return value;
        }
    }

    private static final class BooleanSerializer extends StoneSerializer<Boolean> {
        public static final @Nonnull BooleanSerializer INSTANCE = new BooleanSerializer();

        @Override
        public void serialize(@Nullable Boolean value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeBoolean(value);
        }

        @Override
        public @Nonnull Boolean deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Boolean value = p.getBooleanValue();
            p.nextToken();
            return value;
        }
    }

    private static final class ByteArraySerializer extends StoneSerializer<byte []> {
        public static final @Nonnull ByteArraySerializer INSTANCE = new ByteArraySerializer();

        @Override
        public void serialize(@Nullable byte [] value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeBinary(value);
        }

        @Override
        public @Nonnull byte [] deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            byte [] value = p.getBinaryValue();
            p.nextToken();
            return value;
        }
    }

    private static final class StringSerializer extends StoneSerializer<String> {
        public static final @Nonnull StringSerializer INSTANCE = new StringSerializer();

        @Override
        public void serialize(@Nullable String value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeString(value);
        }

        @Override
        public @Nonnull String deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            String value = getStringValue(p);
            p.nextToken();
            return value;
        }
    }

    private static final class DateSerializer extends StoneSerializer<Date> {
        public static final @Nonnull DateSerializer INSTANCE = new DateSerializer();

        @Override
        public void serialize(@Nullable Date value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeString(Util.formatTimestamp(value));
        }

        @Override
        public @Nonnull Date deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            String text = getStringValue(p);
            p.nextToken();
            try {
                return Util.parseTimestamp(text);
            } catch (ParseException ex) {
                throw new JsonParseException(p, "Malformed timestamp: '" + text + "'", ex);
            }
        }
    }

    private static final class VoidSerializer extends StoneSerializer<Void> {
        public static final @Nonnull VoidSerializer INSTANCE = new VoidSerializer();

        @Override
        public void serialize(@Nullable Void value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeNull();
        }

        @Override
        public @Nullable Void deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            skipValue(p);
            return null;
        }
    }

    private static final class NullableSerializer<T> extends StoneSerializer<T> {
        private final @Nonnull StoneSerializer<T> underlying;

        public NullableSerializer(@Nonnull StoneSerializer<T> underlying) {
            this.underlying = underlying;
        }

        @Override
        public void serialize(@Nullable T value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            if (value == null) {
                g.writeNull();
            } else {
                underlying.serialize(value, g);
            }
        }

        @Override
        public @Nullable T deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
                p.nextToken();
                return null;
            } else {
                return underlying.deserialize(p);
            }
        }
    }

    private static final class NullableStructSerializer<T> extends StructSerializer<T> {
        private final @Nonnull StructSerializer<T> underlying;

        public NullableStructSerializer(@Nonnull StructSerializer<T> underlying) {
            this.underlying = underlying;
        }

        @Override
        public void serialize(@Nullable T value, @Nonnull JsonGenerator g) throws IOException {
            if (value == null) {
                g.writeNull();
            } else {
                underlying.serialize(value, g);
            }
        }

        @Override
        public void serialize(@Nullable T value, @Nonnull JsonGenerator g, boolean collapsed) throws IOException {
            if (value == null) {
                g.writeNull();
            } else {
                underlying.serialize(value, g, collapsed);
            }
        }

        @Override
        public @Nullable T deserialize(@Nonnull JsonParser p) throws IOException {
            if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
                p.nextToken();
                return null;
            } else {
                return underlying.deserialize(p);
            }
        }

        @Override
        public @Nullable T deserialize(@Nonnull JsonParser p, boolean collapsed) throws IOException {
            if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
                p.nextToken();
                return null;
            } else {
                return underlying.deserialize(p, collapsed);
            }
        }
    }

    private static final class ListSerializer<T> extends StoneSerializer<List<T>> {
        private final @Nonnull StoneSerializer<T> underlying;

        public ListSerializer(@Nonnull StoneSerializer<T> underlying) {
            this.underlying = underlying;
        }

        @Override
        public void serialize(@Nullable List<T> value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeStartArray(value.size());
            for (T elem : value) {
                underlying.serialize(elem, g);
            }
            g.writeEndArray();
        }

        @Override
        public @Nonnull List<T> deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            expectStartArray(p);
            List<T> list = new ArrayList<T>();
            while (p.getCurrentToken() != JsonToken.END_ARRAY) {
                T elem = underlying.deserialize(p);
                list.add(elem);
            }
            expectEndArray(p);
            return list;
        }
    }

    private static final class MapSerializer<T> extends StoneSerializer<Map<String, T>> {
        private final @Nonnull StoneSerializer<T> underlying;

        public MapSerializer(@Nonnull StoneSerializer<T> underlying) {
            this.underlying = underlying;
        }

        @Override
        public void serialize(@Nullable Map<String, T> value, @Nonnull JsonGenerator g) throws IOException, JsonGenerationException {
            g.writeStartObject();
            for (Map.Entry<String, T> e : value.entrySet()) {
                g.writeFieldName(e.getKey());
                g.writeRawValue(underlying.serialize(e.getValue()));
            }
            g.writeEndObject();
        }

        @Override
        public @Nonnull Map<String, T> deserialize(@Nonnull JsonParser p) throws IOException, JsonParseException {
            Map<String, T> map = new HashMap<String, T>();

            expectStartObject(p);
            while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String key = p.getCurrentName();
                p.nextToken();
                T val = underlying.deserialize(p);
                map.put(key, val);
            }
            expectEndObject(p);

            return map;
        }
    }
}
