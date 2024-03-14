/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Excluded users list result.
 */
public class ExcludedUsersListResult {
    // struct team.ExcludedUsersListResult (team_member_space_limits.stone)

    protected final List<MemberProfile> users;
    protected final String cursor;
    protected final boolean hasMore;

    /**
     * Excluded users list result.
     *
     * @param users  Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param hasMore  Is true if there are additional excluded users that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#memberSpaceLimitsExcludedUsersListContinue(String)}
     *     can retrieve them.
     * @param cursor  Pass the cursor into {@link
     *     DbxTeamTeamRequests#memberSpaceLimitsExcludedUsersListContinue(String)}
     *     to obtain additional excluded users.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersListResult(List<MemberProfile> users, boolean hasMore, String cursor) {
        if (users == null) {
            throw new IllegalArgumentException("Required value for 'users' is null");
        }
        for (MemberProfile x : users) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'users' is null");
            }
        }
        this.users = users;
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    /**
     * Excluded users list result.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param users  Must not contain a {@code null} item and not be {@code
     *     null}.
     * @param hasMore  Is true if there are additional excluded users that have
     *     not been returned yet. An additional call to {@link
     *     DbxTeamTeamRequests#memberSpaceLimitsExcludedUsersListContinue(String)}
     *     can retrieve them.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersListResult(List<MemberProfile> users, boolean hasMore) {
        this(users, hasMore, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<MemberProfile> getUsers() {
        return users;
    }

    /**
     * Is true if there are additional excluded users that have not been
     * returned yet. An additional call to {@link
     * DbxTeamTeamRequests#memberSpaceLimitsExcludedUsersListContinue(String)}
     * can retrieve them.
     *
     * @return value for this field.
     */
    public boolean getHasMore() {
        return hasMore;
    }

    /**
     * Pass the cursor into {@link
     * DbxTeamTeamRequests#memberSpaceLimitsExcludedUsersListContinue(String)}
     * to obtain additional excluded users.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            users,
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
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            ExcludedUsersListResult other = (ExcludedUsersListResult) obj;
            return ((this.users == other.users) || (this.users.equals(other.users)))
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
    static class Serializer extends StructSerializer<ExcludedUsersListResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExcludedUsersListResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("users");
            StoneSerializers.list(MemberProfile.Serializer.INSTANCE).serialize(value.users, g);
            g.writeFieldName("has_more");
            StoneSerializers.boolean_().serialize(value.hasMore, g);
            if (value.cursor != null) {
                g.writeFieldName("cursor");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.cursor, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ExcludedUsersListResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ExcludedUsersListResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<MemberProfile> f_users = null;
                Boolean f_hasMore = null;
                String f_cursor = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("users".equals(field)) {
                        f_users = StoneSerializers.list(MemberProfile.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("has_more".equals(field)) {
                        f_hasMore = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("cursor".equals(field)) {
                        f_cursor = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_users == null) {
                    throw new JsonParseException(p, "Required field \"users\" missing.");
                }
                if (f_hasMore == null) {
                    throw new JsonParseException(p, "Required field \"has_more\" missing.");
                }
                value = new ExcludedUsersListResult(f_users, f_hasMore, f_cursor);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
