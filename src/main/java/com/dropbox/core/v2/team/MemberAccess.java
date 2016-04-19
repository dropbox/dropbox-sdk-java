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

/**
 * Specify access type a member should have when joined to a group.
 */
@JsonSerialize(using=MemberAccess.Serializer.class)
@JsonDeserialize(using=MemberAccess.Deserializer.class)
public class MemberAccess {
    // struct MemberAccess

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserSelectorArg user;
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
    public MemberAccess(UserSelectorArg user, GroupAccessType accessType) {
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
    public UserSelectorArg getUser() {
        return user;
    }

    /**
     * Access type.
     *
     * @return value for this field, never {@code null}.
     */
    public GroupAccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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

    static final class Serializer extends StructJsonSerializer<MemberAccess> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberAccess.class);
        }

        public Serializer(boolean unwrapping) {
            super(MemberAccess.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MemberAccess> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MemberAccess value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("user", value.user);
            g.writeObjectField("access_type", value.accessType);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MemberAccess> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberAccess.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MemberAccess.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MemberAccess> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MemberAccess deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            UserSelectorArg user = null;
            GroupAccessType accessType = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("user".equals(_field)) {
                    user = _p.readValueAs(UserSelectorArg.class);
                    _p.nextToken();
                }
                else if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(GroupAccessType.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }
            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }

            return new MemberAccess(user, accessType);
        }
    }
}
