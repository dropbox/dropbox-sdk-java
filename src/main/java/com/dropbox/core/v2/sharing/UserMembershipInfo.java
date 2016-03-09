/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
 * The information about a user member of the shared folder.
 */
@JsonSerialize(using=UserMembershipInfo.Serializer.class)
@JsonDeserialize(using=UserMembershipInfo.Deserializer.class)
public class UserMembershipInfo extends MembershipInfo {
    // struct UserMembershipInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final UserInfo user;

    /**
     * The information about a user member of the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     * @param permissions  The permissions that requesting user has on this
     *     member. The set of permissions corresponds to the MemberActions in
     *     the request. Must not contain a {@code null} item.
     * @param initials  Suggested name initials for a member.
     * @param isInherited  True if the member's access to the file is inherited
     *     from a parent folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserMembershipInfo(AccessLevel accessType, UserInfo user, List<MemberPermission> permissions, String initials, boolean isInherited) {
        super(accessType, permissions, initials, isInherited);
        if (user == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = user;
    }

    /**
     * The information about a user member of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserMembershipInfo(AccessLevel accessType, UserInfo user) {
        this(accessType, user, null, null, false);
    }

    /**
     * The account information for the membership user.
     *
     * @return value for this field, never {@code null}.
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param user  The account information for the membership user. Must not be
     *     {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, UserInfo user) {
        return new Builder(accessType, user);
    }

    /**
     * Builder for {@link UserMembershipInfo}.
     */
    public static class Builder extends MembershipInfo.Builder {
        protected final UserInfo user;

        protected Builder(AccessLevel accessType, UserInfo user) {
            super(accessType);
            if (user == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = user;
        }

        /**
         * Builds an instance of {@link UserMembershipInfo} configured with this
         * builder's values
         *
         * @return new instance of {@link UserMembershipInfo}
         */
        public UserMembershipInfo build() {
            return new UserMembershipInfo(accessType, user, permissions, initials, isInherited);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            user
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            UserMembershipInfo other = (UserMembershipInfo) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && ((this.user == other.user) || (this.user.equals(other.user)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.initials == other.initials) || (this.initials != null && this.initials.equals(other.initials)))
                && (this.isInherited == other.isInherited)
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

    static final class Serializer extends StructJsonSerializer<UserMembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UserMembershipInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(UserMembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UserMembershipInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UserMembershipInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("access_type", value.accessType);
            g.writeObjectField("user", value.user);
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
            }
            if (value.initials != null) {
                g.writeObjectField("initials", value.initials);
            }
            g.writeObjectField("is_inherited", value.isInherited);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UserMembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UserMembershipInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UserMembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UserMembershipInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UserMembershipInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AccessLevel accessType = null;
            UserInfo user = null;
            List<MemberPermission> permissions = null;
            String initials = null;
            boolean isInherited = false;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(AccessLevel.class);
                    _p.nextToken();
                }
                else if ("user".equals(_field)) {
                    user = _p.readValueAs(UserInfo.class);
                    _p.nextToken();
                }
                else if ("permissions".equals(_field)) {
                    expectArrayStart(_p);
                    permissions = new java.util.ArrayList<MemberPermission>();
                    while (!isArrayEnd(_p)) {
                        MemberPermission _x = null;
                        _x = _p.readValueAs(MemberPermission.class);
                        _p.nextToken();
                        permissions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("initials".equals(_field)) {
                    initials = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("is_inherited".equals(_field)) {
                    isInherited = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }
            if (user == null) {
                throw new JsonParseException(_p, "Required field \"user\" is missing.");
            }

            return new UserMembershipInfo(accessType, user, permissions, initials, isInherited);
        }
    }
}
