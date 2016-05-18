package com.dropbox.core.babel;

import static org.testng.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BabelSerializersTest {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String LONG_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd";

    @Test
    public void testV2Timestamps() throws Exception {
        // v2 allows 2 different formats for Babel Timestamp fields:
        //
        //    DateTime format: Timestamp("%Y-%m-%dT%H:%M:%SZ")
        //        Date format: Timestamp("%Y-%m-%d")
        //
        // The SDKs should be able to handle both formats.

        // LONG FORMAT DESERIALIZATION
        String expectedTimestamp = "2016-03-08T21:38:04Z";
        Date expected = fromTimestampString(expectedTimestamp);
        Date actual = BabelSerializers.timestamp().deserialize(quoted(expectedTimestamp));

        assertEquals(actual, expected);

        // LONG FORMAT SERIALIZATION
        String actualTimestamp = BabelSerializers.timestamp().serialize(expected);

        assertEquals(actualTimestamp, quoted(expectedTimestamp));

        // SHORT FORMAT DESERIALIZATION
        String shortTimestamp = "2011-02-03";
        expected = fromTimestampString(shortTimestamp);
        actual = BabelSerializers.timestamp().deserialize(quoted(shortTimestamp));

        assertEquals(actual, expected);

        // SHORT FORMAT SERIALIZATION
        actualTimestamp = BabelSerializers.timestamp().serialize(expected);

        // we always format to long-form
        expectedTimestamp = toTimestampString(expected);
        assertEquals(actualTimestamp, quoted(expectedTimestamp));
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadLongTimestamp() throws Exception {
        // we don't support milliseconds
        BabelSerializers.timestamp().deserialize(quoted("2016-03-08T21:38:04.352+0500"));
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadShortTimestamp() throws Exception {
        BabelSerializers.timestamp().deserialize(quoted("2016/03/08"));
    }

    private static String quoted(String value) {
        return "\"" + value + "\"";
    }

    private static String toTimestampString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(LONG_DATE_TIME_FORMAT);
        df.setTimeZone(UTC);
        return df.format(date);
    }

    private static Date fromTimestampString(String timestamp) {
        SimpleDateFormat df;
        if (timestamp.length() > SHORT_DATE_TIME_FORMAT.length()) {
            df = new SimpleDateFormat(LONG_DATE_TIME_FORMAT);
        } else {
            df = new SimpleDateFormat(SHORT_DATE_TIME_FORMAT);
        }

        df.setTimeZone(UTC);
        try {
            return df.parse(timestamp);
        } catch (Exception ex) {
            fail("invalid timestamp", ex);
            return null;
        }
    }
}
