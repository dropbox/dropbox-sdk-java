/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class ListMemberAppsResult {
    // struct ListMemberAppsResult

    private final List<ApiApp> linkedApiApps;

    /**
     *
     * @param linkedApiApps  List of third party applications linked by this
     *     team member. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberAppsResult(List<ApiApp> linkedApiApps) {
        if (linkedApiApps == null) {
            throw new IllegalArgumentException("Required value for 'linkedApiApps' is null");
        }
        for (ApiApp x : linkedApiApps) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'linkedApiApps' is null");
            }
        }
        this.linkedApiApps = linkedApiApps;
    }

    /**
     * List of third party applications linked by this team member
     *
     * @return value for this field, never {@code null}.
     */
    public List<ApiApp> getLinkedApiApps() {
        return linkedApiApps;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ListMemberAppsResult other = (ListMemberAppsResult) obj;
            return (this.linkedApiApps == other.linkedApiApps) || (this.linkedApiApps.equals(other.linkedApiApps));
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

    public static ListMemberAppsResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListMemberAppsResult> _JSON_WRITER = new JsonWriter<ListMemberAppsResult>() {
        public final void write(ListMemberAppsResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListMemberAppsResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListMemberAppsResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("linked_api_apps");
            g.writeStartArray();
            for (ApiApp item: x.linkedApiApps) {
                if (item != null) {
                    ApiApp._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
        }
    };

    public static final JsonReader<ListMemberAppsResult> _JSON_READER = new JsonReader<ListMemberAppsResult>() {
        public final ListMemberAppsResult read(JsonParser parser) throws IOException, JsonReadException {
            ListMemberAppsResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListMemberAppsResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<ApiApp> linkedApiApps = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("linked_api_apps".equals(fieldName)) {
                    linkedApiApps = JsonArrayReader.mk(ApiApp._JSON_READER)
                        .readField(parser, "linked_api_apps", linkedApiApps);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (linkedApiApps == null) {
                throw new JsonReadException("Required field \"linked_api_apps\" is missing.", parser.getTokenLocation());
            }
            return new ListMemberAppsResult(linkedApiApps);
        }
    };
}
