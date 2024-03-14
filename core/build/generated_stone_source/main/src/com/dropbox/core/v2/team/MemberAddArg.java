/* DO NOT EDIT */
/* This file was generated from team_members.stone */

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
import java.util.regex.Pattern;

public class MemberAddArg extends MemberAddArgBase {
    // struct team.MemberAddArg (team_members.stone)

    protected final AdminTier role;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at most
     *     100 and match pattern "{@code [^/:?*<>\"|]*}".
     * @param memberSurname  Member's last name. Must have length of at most 100
     *     and match pattern "{@code [^/:?*<>\"|]*}".
     * @param memberExternalId  External ID for member. Must have length of at
     *     most 64.
     * @param memberPersistentId  Persistent ID for member. This field is only
     *     available to teams using persistent ID SAML configuration.
     * @param sendWelcomeEmail  Whether to send a welcome email to the member.
     *     If send_welcome_email is false, no email invitation will be sent to
     *     the user. This may be useful for apps using single sign-on (SSO)
     *     flows for onboarding that want to handle announcements themselves.
     * @param isDirectoryRestricted  Whether a user is directory restricted.
     * @param role  Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname, String memberExternalId, String memberPersistentId, boolean sendWelcomeEmail, Boolean isDirectoryRestricted, AdminTier role) {
        super(memberEmail, memberGivenName, memberSurname, memberExternalId, memberPersistentId, sendWelcomeEmail, isDirectoryRestricted);
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail) {
        this(memberEmail, null, null, null, null, true, null, AdminTier.MEMBER_ONLY);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Member's first name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getMemberGivenName() {
        return memberGivenName;
    }

    /**
     * Member's last name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getMemberSurname() {
        return memberSurname;
    }

    /**
     * External ID for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getMemberExternalId() {
        return memberExternalId;
    }

    /**
     * Persistent ID for member. This field is only available to teams using
     * persistent ID SAML configuration.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getMemberPersistentId() {
        return memberPersistentId;
    }

    /**
     * Whether to send a welcome email to the member. If send_welcome_email is
     * false, no email invitation will be sent to the user. This may be useful
     * for apps using single sign-on (SSO) flows for onboarding that want to
     * handle announcements themselves.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     true.
     */
    public boolean getSendWelcomeEmail() {
        return sendWelcomeEmail;
    }

    /**
     * Whether a user is directory restricted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Boolean getIsDirectoryRestricted() {
        return isDirectoryRestricted;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AdminTier.MEMBER_ONLY.
     */
    @javax.annotation.Nonnull
    public AdminTier getRole() {
        return role;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String memberEmail) {
        return new Builder(memberEmail);
    }

    /**
     * Builder for {@link MemberAddArg}.
     */
    public static class Builder extends MemberAddArgBase.Builder {

        protected AdminTier role;

        protected Builder(String memberEmail) {
            super(memberEmail);
            this.role = AdminTier.MEMBER_ONLY;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AdminTier.MEMBER_ONLY}. </p>
         *
         * @param role  Must not be {@code null}. Defaults to {@code
         *     AdminTier.MEMBER_ONLY} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withRole(AdminTier role) {
            if (role != null) {
                this.role = role;
            }
            else {
                this.role = AdminTier.MEMBER_ONLY;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberGivenName  Member's first name. Must have length of at
         *     most 100 and match pattern "{@code [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMemberGivenName(String memberGivenName) {
            super.withMemberGivenName(memberGivenName);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberSurname  Member's last name. Must have length of at most
         *     100 and match pattern "{@code [^/:?*<>\"|]*}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMemberSurname(String memberSurname) {
            super.withMemberSurname(memberSurname);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberExternalId  External ID for member. Must have length of
         *     at most 64.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMemberExternalId(String memberExternalId) {
            super.withMemberExternalId(memberExternalId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param memberPersistentId  Persistent ID for member. This field is
         *     only available to teams using persistent ID SAML configuration.
         *
         * @return this builder
         */
        public Builder withMemberPersistentId(String memberPersistentId) {
            super.withMemberPersistentId(memberPersistentId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code true}.
         * </p>
         *
         * @param sendWelcomeEmail  Whether to send a welcome email to the
         *     member. If send_welcome_email is false, no email invitation will
         *     be sent to the user. This may be useful for apps using single
         *     sign-on (SSO) flows for onboarding that want to handle
         *     announcements themselves. Defaults to {@code true} when set to
         *     {@code null}.
         *
         * @return this builder
         */
        public Builder withSendWelcomeEmail(Boolean sendWelcomeEmail) {
            super.withSendWelcomeEmail(sendWelcomeEmail);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param isDirectoryRestricted  Whether a user is directory restricted.
         *
         * @return this builder
         */
        public Builder withIsDirectoryRestricted(Boolean isDirectoryRestricted) {
            super.withIsDirectoryRestricted(isDirectoryRestricted);
            return this;
        }

        /**
         * Builds an instance of {@link MemberAddArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberAddArg}
         */
        public MemberAddArg build() {
            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, memberPersistentId, sendWelcomeEmail, isDirectoryRestricted, role);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            role
        });
        hash = (31 * super.hashCode()) + hash;
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
            MemberAddArg other = (MemberAddArg) obj;
            return ((this.memberEmail == other.memberEmail) || (this.memberEmail.equals(other.memberEmail)))
                && ((this.memberGivenName == other.memberGivenName) || (this.memberGivenName != null && this.memberGivenName.equals(other.memberGivenName)))
                && ((this.memberSurname == other.memberSurname) || (this.memberSurname != null && this.memberSurname.equals(other.memberSurname)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && ((this.memberPersistentId == other.memberPersistentId) || (this.memberPersistentId != null && this.memberPersistentId.equals(other.memberPersistentId)))
                && (this.sendWelcomeEmail == other.sendWelcomeEmail)
                && ((this.isDirectoryRestricted == other.isDirectoryRestricted) || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(other.isDirectoryRestricted)))
                && ((this.role == other.role) || (this.role.equals(other.role)))
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
    static class Serializer extends StructSerializer<MemberAddArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberAddArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("member_email");
            StoneSerializers.string().serialize(value.memberEmail, g);
            if (value.memberGivenName != null) {
                g.writeFieldName("member_given_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberGivenName, g);
            }
            if (value.memberSurname != null) {
                g.writeFieldName("member_surname");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberSurname, g);
            }
            if (value.memberExternalId != null) {
                g.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberExternalId, g);
            }
            if (value.memberPersistentId != null) {
                g.writeFieldName("member_persistent_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.memberPersistentId, g);
            }
            g.writeFieldName("send_welcome_email");
            StoneSerializers.boolean_().serialize(value.sendWelcomeEmail, g);
            if (value.isDirectoryRestricted != null) {
                g.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isDirectoryRestricted, g);
            }
            g.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(value.role, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberAddArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberAddArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_memberEmail = null;
                String f_memberGivenName = null;
                String f_memberSurname = null;
                String f_memberExternalId = null;
                String f_memberPersistentId = null;
                Boolean f_sendWelcomeEmail = true;
                Boolean f_isDirectoryRestricted = null;
                AdminTier f_role = AdminTier.MEMBER_ONLY;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("member_email".equals(field)) {
                        f_memberEmail = StoneSerializers.string().deserialize(p);
                    }
                    else if ("member_given_name".equals(field)) {
                        f_memberGivenName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_surname".equals(field)) {
                        f_memberSurname = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_external_id".equals(field)) {
                        f_memberExternalId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("member_persistent_id".equals(field)) {
                        f_memberPersistentId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("send_welcome_email".equals(field)) {
                        f_sendWelcomeEmail = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("is_directory_restricted".equals(field)) {
                        f_isDirectoryRestricted = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else if ("role".equals(field)) {
                        f_role = AdminTier.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_memberEmail == null) {
                    throw new JsonParseException(p, "Required field \"member_email\" missing.");
                }
                value = new MemberAddArg(f_memberEmail, f_memberGivenName, f_memberSurname, f_memberExternalId, f_memberPersistentId, f_sendWelcomeEmail, f_isDirectoryRestricted, f_role);
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
