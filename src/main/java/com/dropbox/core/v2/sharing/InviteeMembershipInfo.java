/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Information about an invited member of a shared folder.
 */
public class InviteeMembershipInfo extends MembershipInfo {
    // struct InviteeMembershipInfo

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
    static final class Serializer extends StructSerializer<InviteeMembershipInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InviteeMembershipInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("invitee");
            InviteeInfo.Serializer.INSTANCE.serialize(value.invitee, g);
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
            if (value.initials != null) {
                g.writeFieldName("initials");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.initials, g);
            }
            g.writeFieldName("is_inherited");
            StoneSerializers.boolean_().serialize(value.isInherited, g);
            if (value.user != null) {
                g.writeFieldName("user");
                StoneSerializers.nullable(UserInfo.Serializer.INSTANCE).serialize(value.user, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public InviteeMembershipInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            InviteeMembershipInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessType = null;
                InviteeInfo f_invitee = null;
                List<MemberPermission> f_permissions = null;
                String f_initials = null;
                Boolean f_isInherited = false;
                UserInfo f_user = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_type".equals(field)) {
                        f_accessType = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("invitee".equals(field)) {
                        f_invitee = InviteeInfo.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(MemberPermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("initials".equals(field)) {
                        f_initials = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("is_inherited".equals(field)) {
                        f_isInherited = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("user".equals(field)) {
                        f_user = StoneSerializers.nullable(UserInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                if (f_invitee == null) {
                    throw new JsonParseException(p, "Required field \"invitee\" missing.");
                }
                value = new InviteeMembershipInfo(f_accessType, f_invitee, f_permissions, f_initials, f_isInherited, f_user);
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
