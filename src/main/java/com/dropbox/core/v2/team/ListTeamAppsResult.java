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

/**
 * Information returned by {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
 */
public class ListTeamAppsResult {
    // struct ListTeamAppsResult

    private final List<MemberLinkedApps> apps;
    private final boolean hasMore;
    private final String cursor;

    /**
     * Information returned by {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
     *
     * @param apps  The linked applications of each member of the team. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more apps available. Pass the
     *     cursor to {@link DbxTeam#linkedAppsListTeamLinkedApps()} to retrieve
     *     the rest.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeam#linkedAppsListTeamLinkedApps()} to receive the next sub list
     *     of team's applications.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListTeamAppsResult(List<MemberLinkedApps> apps, boolean hasMore, String cursor) {
        if (apps == null) {
            throw new IllegalArgumentException("Required value for 'apps' is null");
        }
        for (MemberLinkedApps x : apps) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'apps' is null");
            }
        }
        this.apps = apps;
        this.hasMore = hasMore;
        this.cursor = cursor;
    }

    /**
     * Information returned by {@link DbxTeam#linkedAppsListTeamLinkedApps()}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param apps  The linked applications of each member of the team. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more apps available. Pass the
     *     cursor to {@link DbxTeam#linkedAppsListTeamLinkedApps()} to retrieve
     *     the rest.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListTeamAppsResult(List<MemberLinkedApps> apps, boolean hasMore) {
        this(apps, hasMore, null);
    }

    /**
     * The linked applications of each member of the team
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberLinkedApps> getApps() {
        return apps;
    }

    /**
     * If true, then there are more apps available. Pass the cursor to {@link
     * DbxTeam#linkedAppsListTeamLinkedApps()} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link DbxTeam#linkedAppsListTeamLinkedApps()} to
     * receive the next sub list of team's applications.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
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
            ListTeamAppsResult other = (ListTeamAppsResult) obj;
            return ((this.apps == other.apps) || (this.apps.equals(other.apps)))
                && (this.hasMore == other.hasMore)
                && ((this.cursor == other.cursor) || (this.cursor != null && this.cursor.equals(other.cursor)))
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

    public static ListTeamAppsResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListTeamAppsResult> _JSON_WRITER = new JsonWriter<ListTeamAppsResult>() {
        public final void write(ListTeamAppsResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            ListTeamAppsResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(ListTeamAppsResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("apps");
            g.writeStartArray();
            for (MemberLinkedApps item: x.apps) {
                if (item != null) {
                    MemberLinkedApps._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("has_more");
            g.writeBoolean(x.hasMore);
            if (x.cursor != null) {
                g.writeFieldName("cursor");
                g.writeString(x.cursor);
            }
        }
    };

    public static final JsonReader<ListTeamAppsResult> _JSON_READER = new JsonReader<ListTeamAppsResult>() {
        public final ListTeamAppsResult read(JsonParser parser) throws IOException, JsonReadException {
            ListTeamAppsResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final ListTeamAppsResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<MemberLinkedApps> apps = null;
            Boolean hasMore = null;
            String cursor = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("apps".equals(fieldName)) {
                    apps = JsonArrayReader.mk(MemberLinkedApps._JSON_READER)
                        .readField(parser, "apps", apps);
                }
                else if ("has_more".equals(fieldName)) {
                    hasMore = JsonReader.BooleanReader
                        .readField(parser, "has_more", hasMore);
                }
                else if ("cursor".equals(fieldName)) {
                    cursor = JsonReader.StringReader
                        .readField(parser, "cursor", cursor);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (apps == null) {
                throw new JsonReadException("Required field \"apps\" is missing.", parser.getTokenLocation());
            }
            if (hasMore == null) {
                throw new JsonReadException("Required field \"has_more\" is missing.", parser.getTokenLocation());
            }
            return new ListTeamAppsResult(apps, hasMore, cursor);
        }
    };
}
