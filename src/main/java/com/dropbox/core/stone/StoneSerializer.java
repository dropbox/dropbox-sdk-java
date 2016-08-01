package com.dropbox.core.stone;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public abstract class StoneSerializer<T> {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public String serialize(T value) {
        return serialize(value, false);
    }

    public String serialize(T value, boolean pretty) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            serialize(value, out, pretty);
        } catch (JsonGenerationException ex) {
            throw new IllegalStateException("Impossible JSON exception", ex);
        } catch (IOException ex) {
            throw new IllegalStateException("Impossible I/O exception", ex);
        }
        return new String(out.toByteArray(), UTF8);
    }

    public void serialize(T value, OutputStream out) throws IOException {
        serialize(value, out, false);
    }

    public void serialize(T value, OutputStream out, boolean pretty) throws IOException {
        JsonGenerator g = Util.JSON.createGenerator(out);
        if (pretty) {
            g.useDefaultPrettyPrinter();
        }
        try {
            serialize(value, g);
        } catch (JsonGenerationException ex) {
            throw new IllegalStateException("Impossible JSON generation exception", ex);
        }
        g.flush();
    }

    public T deserialize(String json) throws JsonParseException {
        try {
            JsonParser p = Util.JSON.createParser(json);
            p.nextToken();
            return deserialize(p);
        } catch (JsonParseException ex) {
            throw ex;
        } catch (IOException ex) {
            throw new IllegalStateException("Impossible I/O exception", ex);
        }
    }

    public T deserialize(InputStream json) throws IOException, JsonParseException {
        JsonParser p = Util.JSON.createParser(json);
        p.nextToken();
        return deserialize(p);
    }

    public abstract void serialize(T value, JsonGenerator g) throws IOException, JsonGenerationException;
    public abstract T deserialize(JsonParser p) throws IOException, JsonParseException;

    protected static String getStringValue(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.VALUE_STRING) {
            throw new JsonParseException(p, "expected string value, but was " + p.getCurrentToken());
        }
        return p.getText();
    }

    protected static void expectField(String name, JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.FIELD_NAME) {
            throw new JsonParseException(p, "expected field name, but was: " + p.getCurrentToken());
        }
        if (!name.equals(p.getCurrentName())) {
            throw new JsonParseException(p, "expected field '" + name + "', but was: '" + p.getCurrentName() + "'");
        }
        p.nextToken();
    }

    protected static void expectStartObject(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.START_OBJECT) {
            throw new JsonParseException(p, "expected object value.");
        }
        p.nextToken();
    }

    protected static void expectEndObject(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.END_OBJECT) {
            throw new JsonParseException(p, "expected end of object value.");
        }
        p.nextToken();
    }

    protected static void expectStartArray(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.START_ARRAY) {
            throw new JsonParseException(p, "expected array value.");
        }
        p.nextToken();
    }

    protected static void expectEndArray(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken() != JsonToken.END_ARRAY) {
            throw new JsonParseException(p, "expected end of array value.");
        }
        p.nextToken();
    }

    protected static void skipValue(JsonParser p) throws IOException, JsonParseException {
        if (p.getCurrentToken().isStructStart()) {
            p.skipChildren(); // will leave parser at end token (e.g. '}' or ']')
            p.nextToken();
        } else if (p.getCurrentToken().isScalarValue()) {
            p.nextToken();
        } else {
            throw new JsonParseException(p, "Can't skip JSON value token: " + p.getCurrentToken());
        }
    }

    protected static void skipFields(JsonParser p) throws IOException, JsonParseException {
        while (p.getCurrentToken() != null && !p.getCurrentToken().isStructEnd()) {
            if (p.getCurrentToken().isStructStart()) {
                p.skipChildren();
            } else if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                p.nextToken();
            } else if (p.getCurrentToken().isScalarValue()) {
                p.nextToken();
            } else {
                throw new JsonParseException(p, "Can't skip token: " + p.getCurrentToken());
            }
        }
    }
}
