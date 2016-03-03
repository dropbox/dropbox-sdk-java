package com.dropbox.core.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class JsonUtil {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static final ObjectMapper MAPPER = createMapper(false);
    private static final ObjectMapper MAPPER_PRETTY = createMapper(true);

    private static ObjectMapper createMapper(boolean prettyPrint) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(UTC);

        ObjectMapper mapper = new ObjectMapper()
            .setTimeZone(UTC)
            .setDateFormat(df)
            .setBase64Variant(Base64Variants.MIME_NO_LINEFEEDS);

        if (prettyPrint) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
        }

        return mapper;
    }

    public static ObjectMapper getMapper() {
        return getMapper(false);
    }

    public static ObjectMapper getMapper(boolean prettyPrint) {
        if (prettyPrint) {
            return MAPPER_PRETTY;
        } else{
            return MAPPER;
        }
    }

    public static JavaType createType(TypeReference<?> typeReference) {
        return MAPPER.getTypeFactory().constructType(typeReference);
    }

    public static JavaType createType(Class<?> clazz) {
        return MAPPER.getTypeFactory().constructType(clazz);
    }
}
