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

@JsonSerialize(using=MemberAddArg.Serializer.class)
@JsonDeserialize(using=MemberAddArg.Deserializer.class)
public class MemberAddArg {
    // struct MemberAddArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String memberEmail;
    protected final String memberGivenName;
    protected final String memberSurname;
    protected final String memberExternalId;
    protected final boolean sendWelcomeEmail;
    protected final AdminTier role;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     * @param memberExternalId  External ID for member. Must have length of at
     *     most 64.
     * @param sendWelcomeEmail  Whether to send a welcome email to the member.
     *     If send_welcome_email is false, no email invitation will be sent to
     *     the user. This may be useful for apps using single sign-on (SSO)
     *     flows for onboarding that want to handle announcements themselves.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname, String memberExternalId, boolean sendWelcomeEmail, AdminTier role) {
        if (memberEmail == null) {
            throw new IllegalArgumentException("Required value for 'memberEmail' is null");
        }
        if (memberEmail.length() > 255) {
            throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
        }
        if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", memberEmail)) {
            throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
        }
        this.memberEmail = memberEmail;
        if (memberGivenName == null) {
            throw new IllegalArgumentException("Required value for 'memberGivenName' is null");
        }
        if (memberGivenName.length() < 1) {
            throw new IllegalArgumentException("String 'memberGivenName' is shorter than 1");
        }
        if (memberGivenName.length() > 100) {
            throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
        }
        if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
            throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
        }
        this.memberGivenName = memberGivenName;
        if (memberSurname == null) {
            throw new IllegalArgumentException("Required value for 'memberSurname' is null");
        }
        if (memberSurname.length() < 1) {
            throw new IllegalArgumentException("String 'memberSurname' is shorter than 1");
        }
        if (memberSurname.length() > 100) {
            throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
        }
        if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
            throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
        }
        this.memberSurname = memberSurname;
        if (memberExternalId != null) {
            if (memberExternalId.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
        }
        this.memberExternalId = memberExternalId;
        this.sendWelcomeEmail = sendWelcomeEmail;
        if (role == null) {
            throw new IllegalArgumentException("Required value for 'role' is null");
        }
        this.role = role;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAddArg(String memberEmail, String memberGivenName, String memberSurname) {
        this(memberEmail, memberGivenName, memberSurname, null, true, AdminTier.MEMBER_ONLY);
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
     * @return value for this field, never {@code null}.
     */
    public String getMemberGivenName() {
        return memberGivenName;
    }

    /**
     * Member's last name.
     *
     * @return value for this field, never {@code null}.
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
     * Returns a new builder for creating an instance of this class.
     *
     * @param memberEmail  Must have length of at most 255, match pattern
     *     "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param memberGivenName  Member's first name. Must have length of at least
     *     1, have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     * @param memberSurname  Member's last name. Must have length of at least 1,
     *     have length of at most 100, match pattern "{@code [^/:?*<>\"|]*}",
     *     and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String memberEmail, String memberGivenName, String memberSurname) {
        return new Builder(memberEmail, memberGivenName, memberSurname);
    }

    /**
     * Builder for {@link MemberAddArg}.
     */
    public static class Builder {
        protected final String memberEmail;
        protected final String memberGivenName;
        protected final String memberSurname;

        protected String memberExternalId;
        protected boolean sendWelcomeEmail;
        protected AdminTier role;

        protected Builder(String memberEmail, String memberGivenName, String memberSurname) {
            if (memberEmail == null) {
                throw new IllegalArgumentException("Required value for 'memberEmail' is null");
            }
            if (memberEmail.length() > 255) {
                throw new IllegalArgumentException("String 'memberEmail' is longer than 255");
            }
            if (!java.util.regex.Pattern.matches("^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$", memberEmail)) {
                throw new IllegalArgumentException("String 'memberEmail' does not match pattern");
            }
            this.memberEmail = memberEmail;
            if (memberGivenName == null) {
                throw new IllegalArgumentException("Required value for 'memberGivenName' is null");
            }
            if (memberGivenName.length() < 1) {
                throw new IllegalArgumentException("String 'memberGivenName' is shorter than 1");
            }
            if (memberGivenName.length() > 100) {
                throw new IllegalArgumentException("String 'memberGivenName' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberGivenName)) {
                throw new IllegalArgumentException("String 'memberGivenName' does not match pattern");
            }
            this.memberGivenName = memberGivenName;
            if (memberSurname == null) {
                throw new IllegalArgumentException("Required value for 'memberSurname' is null");
            }
            if (memberSurname.length() < 1) {
                throw new IllegalArgumentException("String 'memberSurname' is shorter than 1");
            }
            if (memberSurname.length() > 100) {
                throw new IllegalArgumentException("String 'memberSurname' is longer than 100");
            }
            if (!java.util.regex.Pattern.matches("[^/:?*<>\"|]*", memberSurname)) {
                throw new IllegalArgumentException("String 'memberSurname' does not match pattern");
            }
            this.memberSurname = memberSurname;
            this.memberExternalId = null;
            this.sendWelcomeEmail = true;
            this.role = AdminTier.MEMBER_ONLY;
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
         * @param role  Defaults to {@code AdminTier.MEMBER_ONLY} when set to
         *     {@code null}.
         *
         * @return this builder
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
         * Builds an instance of {@link MemberAddArg} configured with this
         * builder's values
         *
         * @return new instance of {@link MemberAddArg}
         */
        public MemberAddArg build() {
            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, sendWelcomeEmail, role);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            memberEmail,
            memberGivenName,
            memberSurname,
            memberExternalId,
            sendWelcomeEmail,
            role
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
            MemberAddArg other = (MemberAddArg) obj;
            return ((this.memberEmail == other.memberEmail) || (this.memberEmail.equals(other.memberEmail)))
                && ((this.memberGivenName == other.memberGivenName) || (this.memberGivenName.equals(other.memberGivenName)))
                && ((this.memberSurname == other.memberSurname) || (this.memberSurname.equals(other.memberSurname)))
                && ((this.memberExternalId == other.memberExternalId) || (this.memberExternalId != null && this.memberExternalId.equals(other.memberExternalId)))
                && (this.sendWelcomeEmail == other.sendWelcomeEmail)
                && ((this.role == other.role) || (this.role.equals(other.role)))
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

    static final class Serializer extends StructJsonSerializer<MemberAddArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(MemberAddArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(MemberAddArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<MemberAddArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(MemberAddArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("member_email", value.memberEmail);
            g.writeObjectField("member_given_name", value.memberGivenName);
            g.writeObjectField("member_surname", value.memberSurname);
            if (value.memberExternalId != null) {
                g.writeObjectField("member_external_id", value.memberExternalId);
            }
            g.writeObjectField("send_welcome_email", value.sendWelcomeEmail);
            g.writeObjectField("role", value.role);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<MemberAddArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(MemberAddArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(MemberAddArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<MemberAddArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public MemberAddArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String memberEmail = null;
            String memberGivenName = null;
            String memberSurname = null;
            String memberExternalId = null;
            Boolean sendWelcomeEmail = null;
            AdminTier role = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("member_email".equals(_field)) {
                    memberEmail = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_given_name".equals(_field)) {
                    memberGivenName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_surname".equals(_field)) {
                    memberSurname = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("member_external_id".equals(_field)) {
                    memberExternalId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("send_welcome_email".equals(_field)) {
                    sendWelcomeEmail = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("role".equals(_field)) {
                    role = _p.readValueAs(AdminTier.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (memberEmail == null) {
                throw new JsonParseException(_p, "Required field \"member_email\" is missing.");
            }
            if (memberGivenName == null) {
                throw new JsonParseException(_p, "Required field \"member_given_name\" is missing.");
            }
            if (memberSurname == null) {
                throw new JsonParseException(_p, "Required field \"member_surname\" is missing.");
            }

            return new MemberAddArg(memberEmail, memberGivenName, memberSurname, memberExternalId, sendWelcomeEmail, role);
        }
    }
}
