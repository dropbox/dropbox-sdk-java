package com.dropbox.core;

import java.io.IOException;

import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.stone.StoneSerializers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Human-readable text localized to a specific locale.
 */
public final class LocalizedText {
    private final String text;
    private final String locale;

    /**
     * Create a {@link LocalizedText} object that contains the given {@code text} already localized
     * to {@code locale}.
     *
     * @param text    Localized, human-readable text. Must not be {@code null}
     * @param locale  IETF BCP 47 language tag of text locale. Must not be {@code null}
     */
    public LocalizedText(String text, String locale) {
        if (text == null) {
            throw new NullPointerException("text");
        }
        if (locale == null) {
            throw new NullPointerException("locale");
        }

        this.text = text;
        this.locale = locale;
    }

    /**
     * Returns the localized, human-readable text.
     *
     * @return localized, human-readable text, never {@code null}
     */
    public String getText() {
        return text;
    }

    /**
     * Returns locale of the text in IETF BCP 47 language tag format.
     *
     * @return locale of text in IETF BCP 47 language tag format, never {@code null}
     */
    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return text;
    }

    /**
     * For internal use only.
     */
    static final StoneSerializer<LocalizedText> STONE_SERIALIZER = new StoneSerializer<LocalizedText>() {
        @Override
        public void serialize(LocalizedText value, JsonGenerator g) throws IOException, JsonGenerationException {
            throw new UnsupportedOperationException("Error wrapper serialization not supported.");
        }

        @Override
        public LocalizedText deserialize(JsonParser p) throws IOException, JsonParseException {
            String text = null;
            String locale = null;

            expectStartObject(p);
            while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String field = p.getCurrentName();
                p.nextToken();
                if ("text".equals(field)) {
                    text = StoneSerializers.string().deserialize(p);
                } else if ("locale".equals(field)) {
                    locale = StoneSerializers.string().deserialize(p);
                } else {
                    skipValue(p);
                }
            }

            if (text == null) {
                throw new JsonParseException(p, "Required field \"text\" missing.");
            }

            if (locale == null) {
                throw new JsonParseException(p, "Required field \"locale\" missing.");
            }

            LocalizedText value = new LocalizedText(text, locale);
            expectEndObject(p);

            return value;
        }
    };
}
