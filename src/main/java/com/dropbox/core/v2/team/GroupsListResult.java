/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

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

@JsonSerialize(using=GroupsListResult.Serializer.class)
@JsonDeserialize(using=GroupsListResult.Deserializer.class)
public class GroupsListResult {
    // struct GroupsListResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<GroupSummary> groups;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param groups  Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#groupsListContinue(String)} to obtain the
     *     additional groups. Must not be {@code null}.
     * @param hasMore  Is true if there are additional groups that have not been
     *     returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#groupsListContinue(String)} can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult(List<GroupSummary> groups, String cursor, boolean hasMore) {
        if (groups == null) {
            throw new IllegalArgumentException("Required value for 'groups' is null");
        }
        for (GroupSummary x : groups) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'groups' is null");
            }
        }
        this.groups = groups;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public List<GroupSummary> getGroups() {
        return groups;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#groupsListContinue(String)} to obtain the additional
     * groups.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional groups that have not been returned yet.
     * An additional call to {@link
     * DbxTeamTeamRequests#groupsListContinue(String)} can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            groups,
            cursor,
            hasMore
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
            GroupsListResult other = (GroupsListResult) obj;
            return ((this.groups == other.groups) || (this.groups.equals(other.groups)))
                && ((this.cursor == other.cursor) || (this.cursor.equals(other.cursor)))
                && (this.hasMore == other.hasMore)
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

    static final class Serializer extends StructJsonSerializer<GroupsListResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GroupsListResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(GroupsListResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GroupsListResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GroupsListResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("groups", value.groups);
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("has_more", value.hasMore);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GroupsListResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GroupsListResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GroupsListResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GroupsListResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GroupsListResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<GroupSummary> groups = null;
            String cursor = null;
            Boolean hasMore = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("groups".equals(_field)) {
                    expectArrayStart(_p);
                    groups = new java.util.ArrayList<GroupSummary>();
                    while (!isArrayEnd(_p)) {
                        GroupSummary _x = null;
                        _x = _p.readValueAs(GroupSummary.class);
                        _p.nextToken();
                        groups.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("cursor".equals(_field)) {
                    cursor = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("has_more".equals(_field)) {
                    hasMore = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (groups == null) {
                throw new JsonParseException(_p, "Required field \"groups\" is missing.");
            }
            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new GroupsListResult(groups, cursor, hasMore);
        }
    }
}
