package com.dropbox.core.stone;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.fail;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class StoneSerializersTest {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private static final String LONG_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd";

    @Test
    public void testV2Timestamps() throws Exception {
        // v2 allows 2 different formats for Stone Timestamp fields:
        //
        //    DateTime format: Timestamp("%Y-%m-%dT%H:%M:%SZ")
        //        Date format: Timestamp("%Y-%m-%d")
        //
        // The SDKs should be able to handle both formats.

        // LONG FORMAT DESERIALIZATION
        String expectedTimestamp = "2016-03-08T21:38:04Z";
        Date expected = fromTimestampString(expectedTimestamp);
        Date actual = StoneSerializers.timestamp().deserialize(quoted(expectedTimestamp));

        assertThat(actual).isEqualTo(expected);

        // LONG FORMAT SERIALIZATION
        String actualTimestamp = StoneSerializers.timestamp().serialize(expected);

        assertThat(actualTimestamp).isEqualTo(quoted(expectedTimestamp));

        // SHORT FORMAT DESERIALIZATION
        String shortTimestamp = "2011-02-03";
        expected = fromTimestampString(shortTimestamp);
        actual = StoneSerializers.timestamp().deserialize(quoted(shortTimestamp));

        assertThat(actual).isEqualTo(expected);

        // SHORT FORMAT SERIALIZATION
        actualTimestamp = StoneSerializers.timestamp().serialize(expected);

        // we always format to long-form
        expectedTimestamp = toTimestampString(expected);
        assertThat(actualTimestamp).isEqualTo(quoted(expectedTimestamp));
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadLongTimestamp() throws Exception {
        // we don't support milliseconds
        StoneSerializers.timestamp().deserialize(quoted("2016-03-08T21:38:04.352+0500"));
    }

    @Test(expectedExceptions = JsonProcessingException.class)
    public void testV2BadShortTimestamp() throws Exception {
        StoneSerializers.timestamp().deserialize(quoted("2016/03/08"));
    }

    @Test
    public void testDeserializeNonEmptyVoidType() throws Exception {
        StoneSerializers.void_().deserialize("{\".tag\":\"foo\"}");
        StoneSerializers.void_().deserialize(quoted("bar"));
    }
    @Test
    public void testEmptyMap() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String serialized = "{}";

        StoneSerializer<Map<String, Integer>> serializer = StoneSerializers.map(StoneSerializers.int32());
        assertThat(serializer.serialize(map)).isEqualTo(serialized);
        assertThat(serializer.deserialize(serialized)).isEqualTo(map);
    }

    @Test
    public void testFlatMap() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
        }};
        String serialized = "{\"a\":1,\"b\":2}";

        StoneSerializer<Map<String, Integer>> serializer = StoneSerializers.map(StoneSerializers.int32());
        assertThat(serializer.serialize(map)).isEqualTo(serialized);
        assertThat(serializer.deserialize(serialized)).isEqualTo(map);
    }

    @Test
    public void testNestedMap() throws Exception {
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>() {{
            put("a", new HashMap<String, Integer>() {{
                put("aa", 1);
            }});
            put("b", new HashMap<String, Integer>() {{
                put("bb", 2);
            }});
        }};
        String serialized = "{\"a\":{\"aa\":1},\"b\":{\"bb\":2}}";

        StoneSerializer<Map<String, Map<String, Integer>>> serializer =
                StoneSerializers.map(StoneSerializers.map(StoneSerializers.int32()));
        assertThat(serializer.serialize(map)).isEqualTo(serialized);
        assertThat(serializer.deserialize(serialized)).isEqualTo(map);
    }

    @Test
    public void testMapWithNullableValue() throws Exception {
        Map<String, String> map = new HashMap<String, String>() {{
            put("a", null);
        }};
        String serialized = "{\"a\":null}";

        StoneSerializer<Map<String, String>> serializer =
                StoneSerializers.map(StoneSerializers.nullable(StoneSerializers.string()));
        assertThat(serializer.serialize(map)).isEqualTo(serialized);
        assertThat(serializer.deserialize(serialized)).isEqualTo(map);
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
