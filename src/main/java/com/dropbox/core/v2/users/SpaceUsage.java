/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Information about a user's space usage and quota.
 */
public class SpaceUsage {
    // struct SpaceUsage

    private final long used;
    private final SpaceAllocation allocation;

    /**
     * Information about a user's space usage and quota.
     *
     * @param used  The user's total space usage (bytes).
     * @param allocation  The user's space allocation. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SpaceUsage(long used, SpaceAllocation allocation) {
        this.used = used;
        if (allocation == null) {
            throw new IllegalArgumentException("Required value for 'allocation' is null");
        }
        this.allocation = allocation;
    }

    /**
     * The user's total space usage (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The user's space allocation.
     *
     * @return value for this field, never {@code null}.
     */
    public SpaceAllocation getAllocation() {
        return allocation;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            used,
            allocation
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            SpaceUsage other = (SpaceUsage) obj;
            return (this.used == other.used)
                && ((this.allocation == other.allocation) || (this.allocation.equals(other.allocation)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SpaceUsage fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SpaceUsage> _JSON_WRITER = new JsonWriter<SpaceUsage>() {
        public final void write(SpaceUsage x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SpaceUsage._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SpaceUsage x, JsonGenerator g) throws IOException {
            g.writeFieldName("used");
            g.writeNumber(x.used);
            g.writeFieldName("allocation");
            SpaceAllocation._JSON_WRITER.write(x.allocation, g);
        }
    };

    public static final JsonReader<SpaceUsage> _JSON_READER = new JsonReader<SpaceUsage>() {
        public final SpaceUsage read(JsonParser parser) throws IOException, JsonReadException {
            SpaceUsage result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SpaceUsage readFields(JsonParser parser) throws IOException, JsonReadException {
            Long used = null;
            SpaceAllocation allocation = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("used".equals(fieldName)) {
                    used = JsonReader.UInt64Reader
                        .readField(parser, "used", used);
                }
                else if ("allocation".equals(fieldName)) {
                    allocation = SpaceAllocation._JSON_READER
                        .readField(parser, "allocation", allocation);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (used == null) {
                throw new JsonReadException("Required field \"used\" is missing.", parser.getTokenLocation());
            }
            if (allocation == null) {
                throw new JsonReadException("Required field \"allocation\" is missing.", parser.getTokenLocation());
            }
            return new SpaceUsage(used, allocation);
        }
    };
}
