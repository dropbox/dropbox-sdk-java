/* DO NOT EDIT */
/* This file was generated from team_members.babel */

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

@JsonSerialize(using=MembersListResult.Serializer.class)
@JsonDeserialize(using=MembersListResult.Deserializer.class)
public class MembersListResult {
    // struct MembersListResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<TeamMemberInfo> members;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#membersListContinue(String)} to obtain the
     *     additional members. Must not be {@code null}.
     * @param hasMore  Is true if there are additional team members that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#membersListContinue(String)} can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListResult(List<TeamMemberInfo> members, String cursor, boolean hasMore) {
        if (members == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        for (TeamMemberInfo x : members) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'members' is null");
            }
        }
        this.members = members;
        if (cursor == null) {
            throw new IllegalArgumentException("Required value for 'cursor' is null");
        }
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * List of team members.
     *
     * @return value for this field, never {@code null}.
     */
    public List<TeamMemberInfo> getMembers() {
        return members;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#membersListContinue(String)} to obtain the additional
     * members.
     *
     * @return value for this field, never {@code null}.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * Is true if there are additional team members that have not been returned
     * yet. An additional call to {@link
     * DbxTeamTeamRequests#membersListContinue(String)} can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            members,
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
            MembersListResult other = (MembersListResult) obj;
            return ((this.members == other.members) || (this.members.equals(other.members)))
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

    static final class Serializer extends StructJsonSerializer<MembersListResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MembersListResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(MembersListResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MembersListResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MembersListResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("members", value.members);
            g.writeObjectField("cursor", value.cursor);
            g.writeObjectField("has_more", value.hasMore);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MembersListResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MembersListResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MembersListResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MembersListResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MembersListResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<TeamMemberInfo> members = null;
            String cursor = null;
            Boolean hasMore = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("members".equals(_field)) {
                    expectArrayStart(_p);
                    members = new java.util.ArrayList<TeamMemberInfo>();
                    while (!isArrayEnd(_p)) {
                        TeamMemberInfo _x = null;
                        _x = _p.readValueAs(TeamMemberInfo.class);
                        _p.nextToken();
                        members.add(_x);
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

            if (members == null) {
                throw new JsonParseException(_p, "Required field \"members\" is missing.");
            }
            if (cursor == null) {
                throw new JsonParseException(_p, "Required field \"cursor\" is missing.");
            }
            if (hasMore == null) {
                throw new JsonParseException(_p, "Required field \"has_more\" is missing.");
            }

            return new MembersListResult(members, cursor, hasMore);
        }
    }
}
