package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.stone.StoneSerializers;
import com.fasterxml.jackson.core.JsonParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.expectThrows;

public class StreamOwnershipTest {
    private static class TrackedStream extends ByteArrayInputStream {
        int closes;

        TrackedStream(String json) {
            super(json.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public void close() {
            ++closes;
        }
    }

    @DataProvider
    public Object[][] readers() {
        return new Object[][]{{false}, {true}};
    }

    @Test(dataProvider = "readers")
    public void standaloneDecodersRetainLegacyOwnership(boolean stone) throws Exception {
        for (String json : Arrays.asList("not-json", "\"unterminated", "\"ok\"")) {
            boolean valid = json.equals("\"ok\"");
            TrackedStream stream = new TrackedStream(json);
            try {
                if (valid) {
                    String result = stone ? StoneSerializers.string().deserialize(stream)
                        : JsonReader.StringReader.readFully(stream);
                    assertThat(result).isEqualTo("ok");
                } else if (stone) {
                    expectThrows(JsonParseException.class, () -> StoneSerializers.string().deserialize(stream));
                } else {
                    expectThrows(JsonReadException.class, () -> JsonReader.StringReader.readFully(stream));
                }
                // EOF closes the source even for truncated JSON; an earlier token error does not.
                assertThat(stream.closes).isEqualTo(json.startsWith("\"") ? 1 : 0);
            } finally {
                stream.close();
            }
        }
    }


    @Test(dataProvider = "readers")
    public void standaloneDecodersPreserveEofCloseFailure(boolean stone) {
        IOException failure = new IOException("close failed");
        ByteArrayInputStream stream = new ByteArrayInputStream("\"ok\"".getBytes(StandardCharsets.UTF_8)) {
            @Override
            public void close() throws IOException {
                throw failure;
            }
        };
        IOException actual = expectThrows(IOException.class, () -> {
            if (stone) StoneSerializers.string().deserialize(stream);
            else JsonReader.StringReader.readFully(stream);
        });
        assertThat(actual).isSameInstanceAs(failure);
    }
}
