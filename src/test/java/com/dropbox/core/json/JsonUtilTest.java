package com.dropbox.core.json;

import static org.testng.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JsonUtilTest {
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
        ObjectMapper mapper = JsonUtil.getMapper();

        // LONG FORMAT DESERIALIZATION
        String expectedTimestamp = "2016-03-08T21:38:04Z";
        Date expected = fromTimestampString(expectedTimestamp);
        Date actual = mapper.readValue(quoted(expectedTimestamp).getBytes("UTF-8"), Date.class);

        assertEquals(actual, expected);

        // LONG FORMAT SERIALIZATION
        String actualTimestamp = mapper.writeValueAsString(expected);

        assertEquals(actualTimestamp, quoted(expectedTimestamp));

        // SHORT FORMAT DESERIALIZATION
        String shortTimestamp = "2011-02-03";
        expected = fromTimestampString(shortTimestamp);
        actual = mapper.readValue(quoted(shortTimestamp).getBytes("UTF-8"), Date.class);

        assertEquals(actual, expected);

        // SHORT FORMAT SERIALIZATION
        actualTimestamp = mapper.writeValueAsString(expected);

        // we always format to long-form
        expectedTimestamp = toTimestampString(expected);
        assertEquals(actualTimestamp, quoted(expectedTimestamp));
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadLongTimestamp() throws Exception {
        ObjectMapper mapper = JsonUtil.getMapper();
        // we don't support milliseconds
        mapper.readValue(quoted("2016-03-08T21:38:04.352+0500"), Date.class);
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadShortTimestamp() throws Exception {
        ObjectMapper mapper = JsonUtil.getMapper();
        mapper.readValue(quoted("2016/03/08"), Date.class);
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
