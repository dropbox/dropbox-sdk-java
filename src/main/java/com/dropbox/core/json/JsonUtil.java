package com.dropbox.core.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class JsonUtil {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final ObjectMapper MAPPER = createMapper(false);
    private static final ObjectMapper MAPPER_PRETTY = createMapper(true);

    private static ObjectMapper createMapper(boolean prettyPrint) {
        DateFormat df = new BabelDateFormat();
        df.setTimeZone(UTC);
        df.setLenient(false);

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

    private static final class BabelDateFormat extends SimpleDateFormat {
        private static final long serialVersionUID = 0L;
        private static final int LONG_FORMAT_LENGTH = DATE_TIME_FORMAT.replace("'", "").length();
        private static final int SHORT_FORMAT_LENGTH = DATE_FORMAT.replace("'", "").length();

        private DateFormat shortFormat;

        public BabelDateFormat() {
            super(DATE_TIME_FORMAT);
            this.shortFormat = new SimpleDateFormat(DATE_FORMAT);
        }

        @Override
        public Object clone() {
            BabelDateFormat other = (BabelDateFormat) super.clone();
            other.shortFormat = (DateFormat) shortFormat.clone();
            return other;
        }

        @Override
        public Date parse(String source, ParsePosition pos) {
            int dateLength = source.length() - pos.getIndex();
            if (dateLength == LONG_FORMAT_LENGTH) {
                return super.parse(source, pos);
            } else if (dateLength == SHORT_FORMAT_LENGTH) {
                return shortFormat.parse(source, pos);
            } else {
                pos.setErrorIndex(Math.min(source.length(), pos.getIndex() + LONG_FORMAT_LENGTH + 1));
                return null;
            }
        }

        @Override
        public void setCalendar(Calendar newCalendar) {
            super.setCalendar(newCalendar);
            shortFormat.setCalendar(newCalendar);
        }

        @Override
        public void setLenient(boolean lenient) {
            super.setLenient(lenient);
            shortFormat.setLenient(lenient);
        }

        @Override
        public void setTimeZone(TimeZone zone) {
            super.setTimeZone(zone);
            shortFormat.setTimeZone(zone);
        }
    }
}
