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
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MemberAddV2Arg extends MemberAddArgBase {
    // struct team.MemberAddV2Arg (team_members.stone)

    protected final List<String> roleIds;

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
     * @param roleIds  Must contain at most 1 items and not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddV2Arg(@Nonnull String memberEmail, @Nullable String memberGivenName, @Nullable String memberSurname, @Nullable String memberExternalId, @Nullable String memberPersistentId, boolean sendWelcomeEmail, @Nullable Boolean isDirectoryRestricted, @Nullable List<String> roleIds) {
        super(memberEmail, memberGivenName, memberSurname, memberExternalId, memberPersistentId, sendWelcomeEmail, isDirectoryRestricted);
        if (roleIds != null) {
            if (roleIds.size() > 1) {
                throw new IllegalArgumentException("List 'roleIds' has more than 1 items");
            }
            for (String x : roleIds) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'roleIds' is null");
                }
                if (x.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'roleIds' is longer than 128");
                }
                if (!Pattern.matches("pid_dbtmr:.*", x)) {
                    throw new IllegalArgumentException("Stringan item in list 'roleIds' does not match pattern");
                }
            }
        }
        this.roleIds = roleIds;
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
    public MemberAddV2Arg(String memberEmail) {
        this(memberEmail, null, null, null, null, true, null, null);
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Member's first name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getMemberGivenName() {
        return memberGivenName;
    }

    /**
     * Member's last name.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getMemberSurname() {
        return memberSurname;
    }

    /**
     * External ID for member.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getMemberExternalId() {
        return memberExternalId;
    }

    /**
     * Persistent ID for member. This field is only available to teams using
     * persistent ID SAML configuration.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
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
    @Nullable
    public Boolean getIsDirectoryRestricted() {
        return isDirectoryRestricted;
    }

    /**
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getRoleIds() {
        return roleIds;
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
     * Builder for {@link MemberAddV2Arg}.
     */
    public static class Builder extends MemberAddArgBase.Builder {

        protected List<String> roleIds;

        protected Builder(String memberEmail) {
            super(memberEmail);
            this.roleIds = null;
        }

        /**
         * Set value for optional field.
         *
         * @param roleIds  Must contain at most 1 items and not contain a {@code
         *     null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withRoleIds(List<String> roleIds) {
            if (roleIds != null) {
                if (roleIds.size() > 1) {
                    throw new IllegalArgumentException("List 'roleIds' has more than 1 items");
                }
                for (String x : roleIds) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'roleIds' is null");
                    }
                    if (x.length() > 128) {
                        throw new IllegalArgumentException("Stringan item in list 'roleIds' is longer than 128");
                    }
                    if (!Pattern.matches("pid_dbtmr:.*", x)) {
                        throw new IllegalArgumentException("Stringan item in list 'roleIds' does not match pattern");
                    }
                }
            }
            this.roleIds = roleIds;
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
         * Builds an instance of {@link MemberAddV2Arg} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberAddV2Arg}
         */
        public MemberAddV2Arg build() {
            return new MemberAddV2Arg(memberEmail, memberGivenName, memberSurname, memberExternalId, memberPersistentId, sendWelcomeEmail, isDirectoryRestricted, roleIds);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            roleIds
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
            MemberAddV2Arg other = (MemberAddV2Arg) obj;
            return ((this.memberEmail == other.memberEmail) || (this.memberEmail.equals(other.memberEmail)))
                && ((this.memberGivenName == other.memberGivenName) || (this.memberGivenName != null && this.memberGivenName.equals(other.memberGivenName)))
                && ((this.memberSurname == other.memberSurname) || (this.memberSurname != null && this.memberSurname.equals(other.memberSurname)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && ((this.memberPersistentId == other.memberPersistentId) || (this.memberPersistentId != null && this.memberPersistentId.equals(other.memberPersistentId)))
                && (this.sendWelcomeEmail == other.sendWelcomeEmail)
                && ((this.isDirectoryRestricted == other.isDirectoryRestricted) || (this.isDirectoryRestricted != null && this.isDirectoryRestricted.equals(other.isDirectoryRestricted)))
                && ((this.roleIds == other.roleIds) || (this.roleIds != null && this.roleIds.equals(other.roleIds)))
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
    static class Serializer extends StructSerializer<MemberAddV2Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberAddV2Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
            if (value.roleIds != null) {
                g.writeFieldName("role_ids");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.roleIds, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public MemberAddV2Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            MemberAddV2Arg value;
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
                List<String> f_roleIds = null;
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
                    else if ("role_ids".equals(field)) {
                        f_roleIds = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_memberEmail == null) {
                    throw new JsonParseException(p, "Required field \"member_email\" missing.");
                }
                value = new MemberAddV2Arg(f_memberEmail, f_memberGivenName, f_memberSurname, f_memberExternalId, f_memberPersistentId, f_sendWelcomeEmail, f_isDirectoryRestricted, f_roleIds);
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
