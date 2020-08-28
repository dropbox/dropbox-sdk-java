package com.dropbox.core.stone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonFactory;

final class Util {
    public static final JsonFactory JSON = new JsonFactory();

    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final int LONG_FORMAT_LENGTH = DATE_TIME_FORMAT.replace("'", "").length();
    private static final int SHORT_FORMAT_LENGTH = DATE_FORMAT.replace("'", "").length();

    public static String formatTimestamp(Date timestamp) {
        DateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.ENGLISH);
        format.setCalendar(new GregorianCalendar(UTC));
        return format.format(timestamp);
    }

    public static Date parseTimestamp(String timestamp) throws ParseException {
        int length = timestamp.length();

        DateFormat format = null;
        if (length == LONG_FORMAT_LENGTH) {
            format = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.ENGLISH);
        } else if (length == SHORT_FORMAT_LENGTH) {
            format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        } else {
            throw new ParseException("timestamp has unexpected format: '" + timestamp + "'", 0);
        }

        format.setCalendar(new GregorianCalendar(UTC));
        return format.parse(timestamp);
    }
}
