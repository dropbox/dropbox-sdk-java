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

public class MemberAddArg {
    // struct team.MemberAddArg (team_members.stone)

    protected final String memberEmail;
    protected final String memberGivenName;
    protected final String memberSurname;
    protected final String memberExternalId;
    protected final String memberPersistentId;
    protected final boolean sendWelcomeEmail;
    protected final AdminTier role;
    protected final Boolean isDirectoryRestricted;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
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
     * @param role  Must not be {@code null}.
     * @param isDirectoryRestricted  Whether a user is directory restricted.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname, String memberExternalId, String memberPersistentId, boolean sendWelcomeEmail, AdminTier role, Boolean isDirectoryRestricted) {
        if (memberEmail == null) {
            throw new IllegalArgumentException("Required value for 'memberEmail' is null");
        }
        if (memberEmail.length() > 255) {
            throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
        }
        if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", memberEmail)) {
            throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
        }
        this.memberEmail = memberEmail;
        if (memberGivenName != null) {
            if (memberGivenName.length() > 100) {
                throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
                throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
            }
        }
        this.memberGivenName = memberGivenName;
        if (memberSurname != null) {
            if (memberSurname.length() > 100) {
                throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
            }
            if (!Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
                throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
            }
        }
        this.memberSurname = memberSurname;
        if (memberExternalId != null) {
            if (memberExternalId.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
        }
        this.memberExternalId = memberExternalId;
        this.memberPersistentId = memberPersistentId;
        this.sendWelcomeEmail = sendWelcomeEmail;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
        this.isDirectoryRestricted = isDirectoryRestricted;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail) {
        this(memberEmail, null, null, null, null, true, AdminTier.MEMBER_ONLY, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Member's first name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberGivenName() {
        return memberGivenName;
    }

    /**
     * Member's last name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberSurname() {
        return memberSurname;
    }

    /**
     * External ID for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getMemberExternalId() {
        return memberExternalId;
    }

    /**
     * Persistent ID for member. This field is only available to teams using
     * persistent ID SAML configuration.
     *
     * @return value for this field, or {@code null} if not present.
     */
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
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AdminTier.MEMBER_ONLY.
     */
    public AdminTier getRole() {
        return role;
    }

    /**
     * Whether a user is directory restricted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getIsDirectoryRestricted() {
        return isDirectoryRestricted;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
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
    public static class Builder {
        protected final String memberEmail;

        protected String memberGivenName;
        protected String memberSurname;
        protected String memberExternalId;
        protected String memberPersistentId;
        protected boolean sendWelcomeEmail;
        protected AdminTier role;
        protected Boolean isDirectoryRestricted;

        protected Builder(String memberEmail) {
            if (memberEmail == null) {
                throw new IllegalArgumentException("Required value for 'memberEmail' is null");
            }
            if (memberEmail.length() > 255) {
                throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
            }
            if (!Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", memberEmail)) {
                throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
            }
            this.memberEmail = memberEmail;
            this.memberGivenName = null;
            this.memberSurname = null;
            this.memberExternalId = null;
            this.memberPersistentId = null;
            this.sendWelcomeEmail = true;
            this.role = AdminTier.MEMBER_ONLY;
            this.isDirectoryRestricted = null;
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
            if (memberGivenName != null) {
                if (memberGivenName.length() > 100) {
                    throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
                    throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
                }
            }
            this.memberGivenName = memberGivenName;
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
            if (memberSurname != null) {
                if (memberSurname.length() > 100) {
                    throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
                }
                if (!Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
                    throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
                }
            }
            this.memberSurname = memberSurname;
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
            if (memberExternalId != null) {
                if (memberExternalId.length() > 64) {
                    throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
                }
            }
            this.memberExternalId = memberExternalId;
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
            this.memberPersistentId = memberPersistentId;
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
            if (sendWelcomeEmail != null) {
                this.sendWelcomeEmail = sendWelcomeEmail;
            }
            else {
                this.sendWelcomeEmail = true;
            }
            return this;
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
         * @param isDirectoryRestricted  Whether a user is directory restricted.
         *
         * @return this builder
         */
        public Builder withIsDirectoryRestricted(Boolean isDirectoryRestricted) {
            this.isDirectoryRestricted = isDirectoryRestricted;
            return this;
        }

        /**
         * Builds an instance of {@link MemberAddArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberAddArg}
         */
        public MemberAddArg build() {
            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, memberPersistentId, sendWelcomeEmail, role, isDirectoryRestricted);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            memberEmail,
            memberGivenName,
            memberSurname,
            memberExternalId,
            memberPersistentId,
            sendWelcomeEmail,
            role,
            isDirectoryRestricted
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
            MemberAddArg other = (MemberAddArg) obj;
            return ((this.memberEmail == other.memberEmail) || (this.memberEmail.equals(other.memberEmail)))
                && ((this.memberGivenName == other.memberGivenName) || (this.memberGivenName != null && this.memberGivenName.equals(other.memberGivenName)))
                && ((this.memberSurname == other.memberSurname) || (this.memberSurname != null && this.memberSurname.equals(other.memberSurname)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && ((this.memberPersistentId == other.memberPersistentId) || (this.memberPersistentId != null && this.memberPersistentId.equals(other.memberPersistentId)))
                && (this.sendWelcomeEmail == other.sendWelcomeEmail)
                && ((this.role == other.role) || (this.role.equals(other.role)))
                && ((this.isDirectoryRestricted == other.isDirectoryRestricted) || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(other.isDirectoryRestricted)))
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
            g.writeFieldName("role");
            AdminTier.Serializer.INSTANCE.serialize(value.role, g);
            if (value.isDirectoryRestricted != null) {
                g.writeFieldName("is_directory_restricted");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.isDirectoryRestricted, g);
            }
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
                AdminTier f_role = AdminTier.MEMBER_ONLY;
                Boolean f_isDirectoryRestricted = null;
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
                    else if ("role".equals(field)) {
                        f_role = AdminTier.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_directory_restricted".equals(field)) {
                        f_isDirectoryRestricted = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_memberEmail == null) {
                    throw new JsonParseException(p, "Required field \"member_email\" missing.");
                }
                value = new MemberAddArg(f_memberEmail, f_memberGivenName, f_memberSurname, f_memberExternalId, f_memberPersistentId, f_sendWelcomeEmail, f_role, f_isDirectoryRestricted);
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
