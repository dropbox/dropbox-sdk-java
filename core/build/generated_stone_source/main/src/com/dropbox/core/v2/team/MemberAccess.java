/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

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

import javax.annotation.Nonnull;

/**
 * Specify access type a member should have when joined to a group.
 */
public class MemberAccess {
    // struct team.MemberAccess (team_groups.stone)

    @Nonnull
    protected final UserSelectorArg user;
    @Nonnull
    protected final GroupAccessType accessType;

    /**
     * Specify access type a member should have when joined to a group.
     *
     * @param user  Identity of a user. Must not be {@code null}.
     * @param accessType  Access type. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAccess(@Nonnull UserSelectorArg user, @Nonnull GroupAccessType accessType) {
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
    }

    /**
     * Identity of a user.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * Access type.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            user,
            accessType
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
            MemberAccess other = (MemberAccess) obj;
            return ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
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
    static class Serializer extends StructSerializer<MemberAccess> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberAccess value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(value.user, g);
            g.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(value.accessType, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberAccess deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberAccess value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                UserSelectorArg f_user = null;
                GroupAccessType f_accessType = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("user".equals(field)) {
                        f_user = UserSelectorArg.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("access_type".equals(field)) {
                        f_accessType = GroupAccessType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_user == null) {
                    throw new JsonParseException(p, "Required field \"user\" missing.");
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                value = new MemberAccess(f_user, f_accessType);
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
