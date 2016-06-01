/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Arguments for {@link DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()}.
 */
class ListMembersAppsArg {
    // struct ListMembersAppsArg

    protected final String cursor;

    /**
     * Arguments for {@link
     * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()}.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()} the cursor
     *     shouldn't be passed. Then, if the result of the call includes a
     *     cursor, the following requests should include the received cursors in
     *     order to receive the next sub list of the team applications.
     */
    public ListMembersAppsArg(String cursor) {
        this.cursor = cursor;
    }

    /**
     * Arguments for {@link
     * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()}.
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public ListMembersAppsArg() {
        this(null);
    }

    /**
     * At the first call to the {@link
     * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()} the cursor
     * shouldn't be passed. Then, if the result of the call includes a cursor,
     * the following requests should include the received cursors in order to
     * receive the next sub list of the team applications
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            cursor
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
            ListMembersAppsArg other = (ListMembersAppsArg) obj;
            return (this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static final class Serializer extends StructSerializer<ListMembersAppsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListMembersAppsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListMembersAppsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListMembersAppsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new ListMembersAppsArg(f_cursor);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
