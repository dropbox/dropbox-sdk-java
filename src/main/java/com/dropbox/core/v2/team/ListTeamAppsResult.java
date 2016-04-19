/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

/**
 * Information returned by {@link
 * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
 */
@JsonSerialize(using=ListTeamAppsResult.Serializer.class)
@JsonDeserialize(using=ListTeamAppsResult.Deserializer.class)
public class ListTeamAppsResult {
    // struct ListTeamAppsResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<MemberLinkedApps> apps;
    protected final boolean hasMore;
    protected final String cursor;

    /**
     * Information returned by {@link
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     *
     * @param apps  The linked applications of each member of the team. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more apps available. Pass the
     *     cursor to {@link DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}
     *     to retrieve the rest.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()} to receive the
     *     next sub list of team's applications.
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
     * Information returned by {@link
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param apps  The linked applications of each member of the team. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param hasMore  If true, then there are more apps available. Pass the
     *     cursor to {@link DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}
     *     to retrieve the rest.
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
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()} to retrieve the rest.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()} to receive the next
     * sub list of team's applications.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            apps,
            hasMore,
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<ListTeamAppsResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListTeamAppsResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListTeamAppsResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListTeamAppsResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListTeamAppsResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("apps", value.apps);
            g.writeObjectField("has_more", value.hasMore);
            if (value.cursor != null) {
                g.writeObjectField("cursor", value.cursor);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListTeamAppsResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListTeamAppsResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListTeamAppsResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListTeamAppsResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListTeamAppsResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<MemberLinkedApps> apps = null;
            Boolean hasMore = null;
            String cursor = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("apps".equals(_field)) {
                    expectArrayStart(_p);
                    apps = new java.util.ArrayList<MemberLinkedApps>();
                    while (!isArrayEnd(_p)) {
                        MemberLinkedApps _x = null;
                        _x = _p.readValueAs(MemberLinkedApps.class);
                        _p.nextToken();
                        apps.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("has_more".equals(_field)) {
                    hasMore = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (apps == null) {
                throw new JsonParseException(_p, "Required field \"apps\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new ListTeamAppsResult(apps, hasMore, cursor);
        }
    }
}
