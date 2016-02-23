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

public class TeamSpaceAllocation {
    // struct TeamSpaceAllocation

    private final long used;
    private final long allocated;

    /**
     *
     * @param used  The total space currently used by the user's team (bytes).
     * @param allocated  The total space allocated to the user's team (bytes).
     */
    public TeamSpaceAllocation(long used, long allocated) {
        this.used = used;
        this.allocated = allocated;
    }

    /**
     * The total space currently used by the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getUsed() {
        return used;
    }

    /**
     * The total space allocated to the user's team (bytes).
     *
     * @return value for this field.
     */
    public long getAllocated() {
        return allocated;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            used,
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
            TeamSpaceAllocation other = (TeamSpaceAllocation) obj;
            return (this.used == other.used)
                && (this.allocated == other.allocated)
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

    public static TeamSpaceAllocation fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamSpaceAllocation> _JSON_WRITER = new JsonWriter<TeamSpaceAllocation>() {
        public final void write(TeamSpaceAllocation x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            TeamSpaceAllocation._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(TeamSpaceAllocation x, JsonGenerator g) throws IOException {
            g.writeFieldName("used");
            g.writeNumber(x.used);
            g.writeFieldName("allocated");
            g.writeNumber(x.allocated);
        }
    };

    public static final JsonReader<TeamSpaceAllocation> _JSON_READER = new JsonReader<TeamSpaceAllocation>() {
        public final TeamSpaceAllocation read(JsonParser parser) throws IOException, JsonReadException {
            TeamSpaceAllocation result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final TeamSpaceAllocation readFields(JsonParser parser) throws IOException, JsonReadException {
            Long used = null;
            Long allocated = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("used".equals(fieldName)) {
                    used = JsonReader.UInt64Reader
                        .readField(parser, "used", used);
                }
                else if ("allocated".equals(fieldName)) {
                    allocated = JsonReader.UInt64Reader
                        .readField(parser, "allocated", allocated);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (used == null) {
                throw new JsonReadException("Required field \"used\" is missing.", parser.getTokenLocation());
            }
            if (allocated == null) {
                throw new JsonReadException("Required field \"allocated\" is missing.", parser.getTokenLocation());
            }
            return new TeamSpaceAllocation(used, allocated);
        }
    };
}
