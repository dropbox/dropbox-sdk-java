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
 * Information about an invited member of a shared folder.
 */
@JsonSerialize(using=InviteeMembershipInfo.Serializer.class)
@JsonDeserialize(using=InviteeMembershipInfo.Deserializer.class)
public class InviteeMembershipInfo extends MembershipInfo {
    // struct InviteeMembershipInfo

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final InviteeInfo invitee;
    protected final UserInfo user;

    /**
     * Information about an invited member of a shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param invitee  Recipient of the invitation. Must not be {@code null}.
     * @param permissions  The permissions that requesting user has on this
     *     member. The set of permissions corresponds to the MemberActions in
     *     the request. Must not contain a {@code null} item.
     * @param initials  Suggested name initials for a member.
     * @param isInherited  True if the member's access to the file is inherited
     *     from a parent folder.
     * @param user  The user this invitation is tied to, if available.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee, List<MemberPermission> permissions, String initials, boolean isInherited, UserInfo user) {
        super(accessType, permissions, initials, isInherited);
        if (invitee == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        this.invitee = invitee;
        this.user = user;
    }

    /**
     * Information about an invited member of a shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param invitee  Recipient of the invitation. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public InviteeMembershipInfo(AccessLevel accessType, InviteeInfo invitee) {
        this(accessType, invitee, null, null, false, null);
    }

    /**
     * Recipient of the invitation.
     *
     * @return value for this field, never {@code null}.
     */
    public InviteeInfo getInvitee() {
        return invitee;
    }

    /**
     * The user this invitation is tied to, if available.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public UserInfo getUser() {
        return user;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The access type for this member. Must not be {@code
     *     null}.
     * @param invitee  Recipient of the invitation. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, InviteeInfo invitee) {
        return new Builder(accessType, invitee);
    }

    /**
     * Builder for {@link InviteeMembershipInfo}.
     */
    public static class Builder extends MembershipInfo.Builder {
        protected final InviteeInfo invitee;

        protected UserInfo user;

        protected Builder(AccessLevel accessType, InviteeInfo invitee) {
            super(accessType);
            if (invitee == null) {
                throw new IllegalArgumentException("Required value for 'invitee' is null");
            }
            this.invitee = invitee;
            this.user = null;
        }

        /**
         * Set value for optional field.
         *
         * @param user  The user this invitation is tied to, if available.
         *
         * @return this builder
         */
        public Builder withUser(UserInfo user) {
            this.user = user;
            return this;
        }

        /**
         * Builds an instance of {@link InviteeMembershipInfo} configured with
         * this builder's values
         *
         * @return new instance of {@link InviteeMembershipInfo}
         */
        public InviteeMembershipInfo build() {
            return new InviteeMembershipInfo(accessType, invitee, permissions, initials, isInherited, user);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            invitee,
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
            InviteeMembershipInfo other = (InviteeMembershipInfo) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && ((this.invitee == other.invitee) || (this.invitee.equals(other.invitee)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.initials == other.initials) || (this.initials != null && this.initials.equals(other.initials)))
                && (this.isInherited == other.isInherited)
                && ((this.user == other.user) || (this.user != null && this.user.equals(other.user)))
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

    static final class Serializer extends StructJsonSerializer<InviteeMembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(InviteeMembershipInfo.class);
        }

        public Serializer(boolean unwrapping) {
            super(InviteeMembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonSerializer<InviteeMembershipInfo> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(InviteeMembershipInfo value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("access_type", value.accessType);
            g.writeObjectField("invitee", value.invitee);
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
            }
            if (value.initials != null) {
                g.writeObjectField("initials", value.initials);
            }
            g.writeObjectField("is_inherited", value.isInherited);
            if (value.user != null) {
                g.writeObjectField("user", value.user);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<InviteeMembershipInfo> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(InviteeMembershipInfo.class);
        }

        public Deserializer(boolean unwrapping) {
            super(InviteeMembershipInfo.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<InviteeMembershipInfo> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public InviteeMembershipInfo deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AccessLevel accessType = null;
            InviteeInfo invitee = null;
            List<MemberPermission> permissions = null;
            String initials = null;
            boolean isInherited = false;
            UserInfo user = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(AccessLevel.class);
                    _p.nextToken();
                }
                else if ("invitee".equals(_field)) {
                    invitee = _p.readValueAs(InviteeInfo.class);
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
                else if ("user".equals(_field)) {
                    user = _p.readValueAs(UserInfo.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }
            if (invitee == null) {
                throw new JsonParseException(_p, "Required field \"invitee\" is missing.");
            }

            return new InviteeMembershipInfo(accessType, invitee, permissions, initials, isInherited, user);
        }
    }
}
