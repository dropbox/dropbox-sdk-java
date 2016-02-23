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

public class IndividualSpaceAllocation {
    // struct IndividualSpaceAllocation

    private final long allocated;

    /**
     *
     * @param allocated  The total space allocated to the user's account
     *     (bytes).
     */
    public IndividualSpaceAllocation(long allocated) {
        this.allocated = allocated;
    }

    /**
     * The total space allocated to the user's account (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            allocated
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
            IndividualSpaceAllocation other = (IndividualSpaceAllocation) obj;
            return this.allocated == other.allocated;
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

    public static IndividualSpaceAllocation fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<IndividualSpaceAllocation> _JSON_WRITER = new JsonWriter<IndividualSpaceAllocation>() {
        public final void write(IndividualSpaceAllocation x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            IndividualSpaceAllocation._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(IndividualSpaceAllocation x, JsonGenerator g) throws IOException {
            g.writeFieldName("allocated");
            g.writeNumber(x.allocated);
        }
    };

    public static final JsonReader<IndividualSpaceAllocation> _JSON_READER = new JsonReader<IndividualSpaceAllocation>() {
        public final IndividualSpaceAllocation read(JsonParser parser) throws IOException, JsonReadException {
            IndividualSpaceAllocation result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final IndividualSpaceAllocation readFields(JsonParser parser) throws IOException, JsonReadException {
            Long allocated = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("allocated".equals(fieldName)) {
                    allocated = JsonReader.UInt64Reader
                        .readField(parser, "allocated", allocated);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (allocated == null) {
                throw new JsonReadException("Required field \"allocated\" is missing.", parser.getTokenLocation());
            }
            return new IndividualSpaceAllocation(allocated);
        }
    };
}
